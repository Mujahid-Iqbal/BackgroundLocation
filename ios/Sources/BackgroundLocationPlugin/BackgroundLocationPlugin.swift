import Foundation
import Capacitor
import CoreLocation

@objc(BackgroundLocationPlugin)
public class BackgroundLocationPlugin: CAPPlugin, CLLocationManagerDelegate {
    var locationManager: CLLocationManager?

    @objc public override func load() {
        locationManager = CLLocationManager()
        locationManager?.delegate = self
        locationManager?.desiredAccuracy = kCLLocationAccuracyBest
        locationManager?.distanceFilter = 10
        locationManager?.allowsBackgroundLocationUpdates = true
        locationManager?.pausesLocationUpdatesAutomatically = false
    }

    @objc func startTracking(_ call: CAPPluginCall) {
        guard let manager = locationManager else {
            call.reject("LocationManager not initialized")
            return
        }

        manager.requestAlwaysAuthorization()
        manager.startUpdatingLocation()

        print("📡 iOS startTracking called")
        call.resolve()
    }

    @objc func stopTracking(_ call: CAPPluginCall) {
        locationManager?.stopUpdatingLocation()
        print("🛑 iOS stopTracking called")
        call.resolve()
    }

    public func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        guard let loc = locations.last else {
            print("⚠️ No location available")
            return
        }

        let data: [String: Any] = [
            "latitude": loc.coordinate.latitude,
            "longitude": loc.coordinate.longitude,
            "accuracy": loc.horizontalAccuracy,
            "timestamp": loc.timestamp.timeIntervalSince1970
        ]

        notifyListeners("locationUpdate", data: data)
        print("📍 iOS Location update sent:", data)
    }

    public func locationManager(_ manager: CLLocationManager, didFailWithError error: Error) {
        print("⚠️ iOS Location error:", error.localizedDescription)
    }
}
