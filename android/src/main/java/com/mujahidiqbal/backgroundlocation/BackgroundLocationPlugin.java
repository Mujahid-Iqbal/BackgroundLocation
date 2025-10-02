package com.mujahidiqbal.backgroundlocation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "BackgroundLocation")
public class BackgroundLocationPlugin extends Plugin {

    private static final String TAG = "BackgroundLocationPlugin";

    // Define the receiver to listen for broadcasts from LocationService
    private final BroadcastReceiver locationReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            double latitude = intent.getDoubleExtra("latitude", 0.0);
            double longitude = intent.getDoubleExtra("longitude", 0.0);
            float accuracy = intent.getFloatExtra("accuracy", 0.0f);
            long timestamp = intent.getLongExtra("timestamp", System.currentTimeMillis());

            JSObject data = new JSObject();
            data.put("latitude", latitude);
            data.put("longitude", longitude);
            data.put("accuracy", accuracy);
            data.put("timestamp", timestamp);

            Log.d(TAG, "📡 Emitting location update to JS: " + data.toString());

            notifyListeners("locationUpdate", data, true);
        }
    };

    // Register the broadcast receiver when the plugin is loaded
    @Override
    public void load() {
        Log.d(TAG, "✅ BackgroundLocationPlugin loaded");
        IntentFilter filter = new IntentFilter("com.mujahidiqbal.backgroundlocation.LOCATION_UPDATE");
        getContext().registerReceiver(locationReceiver, filter);
    }

    // Start the background location service
    @PluginMethod
    public void startTracking(PluginCall call) {
        Log.d(TAG, "🚀 startTracking() called");
        Intent serviceIntent = new Intent(getContext(), LocationService.class);
        getContext().startService(serviceIntent);
        call.resolve();
    }

    // Stop the background location service
    @PluginMethod
    public void stopTracking(PluginCall call) {
        Log.d(TAG, "🛑 stopTracking() called");
        Intent serviceIntent = new Intent(getContext(), LocationService.class);
        getContext().stopService(serviceIntent);
        call.resolve();
    }

    // Unregister the broadcast receiver when the plugin is destroyed
    @Override
    protected void handleOnDestroy() {
        try {
            getContext().unregisterReceiver(locationReceiver);
            Log.d(TAG, "🧹 Receiver unregistered");
        } catch (IllegalArgumentException e) {
            Log.w(TAG, "⚠️ Receiver was not registered or already removed: " + e.getMessage());
        }
    }
}
