import type { PluginListenerHandle } from "@capacitor/core";

export interface LocationUpdate {
  latitude: number;
  longitude: number;
  accuracy: number;
  timestamp: number;
}

export interface BackgroundLocationPlugin {
  startTracking(): Promise<void>;
  stopTracking(): Promise<void>;
  addListener(
    eventName: 'locationUpdate',
    listenerFunc: (data: LocationUpdate) => void
  ): Promise<PluginListenerHandle>;
}
