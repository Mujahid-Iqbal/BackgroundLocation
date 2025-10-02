import { WebPlugin } from '@capacitor/core';

import type { BackgroundLocationPlugin } from './definitions';

export class BackgroundLocationWeb
  extends WebPlugin
  implements BackgroundLocationPlugin {

  async startTracking(): Promise<void> {
    console.warn('BackgroundLocation: startTracking() is not supported on web.');
    return;
  }

  async stopTracking(): Promise<void> {
    console.warn('BackgroundLocation: stopTracking() is not supported on web.');
    return;
  }
}
