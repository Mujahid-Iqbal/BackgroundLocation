package com.mujahidiqbal.backgroundlocation;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.IBinder;
import android.util.Log;

public class LocationService extends Service implements LocationListener {

    private static final String TAG = "BackgroundLocation";
    private LocationManager locationManager;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "LocationService started");

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        try {
            locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                5000,
                5,
                this
            );
        } catch (SecurityException e) {
            Log.e(TAG, "Permission error: " + e.getMessage());
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d(TAG, "Location: " + location.getLatitude() + ", " + location.getLongitude());

        // Send a broadcast to your plugin to notify JS
        Intent intent = new Intent("com.mujahidiqbal.backgroundlocation.LOCATION_UPDATE");
        intent.putExtra("latitude", location.getLatitude());
        intent.putExtra("longitude", location.getLongitude());
        sendBroadcast(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (locationManager != null) {
            locationManager.removeUpdates(this);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
