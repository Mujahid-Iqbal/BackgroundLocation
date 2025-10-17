#import <Capacitor/Capacitor.h>

CAP_PLUGIN(BackgroundLocationPlugin, "BackgroundLocation",
   CAP_PLUGIN_METHOD(startTracking, CAPPluginReturnPromise);
   CAP_PLUGIN_METHOD(stopTracking, CAPPluginReturnPromise);
)
