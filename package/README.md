# background-location

BackgroundLocation is a custom Capacitor 5 plugin that enables accurate background geolocation tracking on both Android and iOS using native APIs. It allows the app to receive continuous location updates even when the app is in the background or terminated, and securely posts the data to a remote server.

## Install

```bash
npm install background-location
npx cap sync
```

## API

<docgen-index>

* [`startTracking()`](#starttracking)
* [`stopTracking()`](#stoptracking)
* [`addListener('locationUpdate', ...)`](#addlistenerlocationupdate-)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### startTracking()

```typescript
startTracking() => Promise<void>
```

--------------------


### stopTracking()

```typescript
stopTracking() => Promise<void>
```

--------------------


### addListener('locationUpdate', ...)

```typescript
addListener(eventName: 'locationUpdate', listenerFunc: (data: LocationUpdate) => void) => Promise<PluginListenerHandle>
```

| Param              | Type                                                                         |
| ------------------ | ---------------------------------------------------------------------------- |
| **`eventName`**    | <code>'locationUpdate'</code>                                                |
| **`listenerFunc`** | <code>(data: <a href="#locationupdate">LocationUpdate</a>) =&gt; void</code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt;</code>

--------------------


### Interfaces


#### PluginListenerHandle

| Prop         | Type                                      |
| ------------ | ----------------------------------------- |
| **`remove`** | <code>() =&gt; Promise&lt;void&gt;</code> |


#### LocationUpdate

| Prop            | Type                |
| --------------- | ------------------- |
| **`latitude`**  | <code>number</code> |
| **`longitude`** | <code>number</code> |
| **`accuracy`**  | <code>number</code> |
| **`timestamp`** | <code>number</code> |

</docgen-api>
