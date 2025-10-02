# background-location

BackgroundLocation is a custom Capacitor 5 plugin that enables accurate background geolocation tracking on both Android and iOS using native APIs. It allows the app to receive continuous location updates even when the app is in the background or terminated, and securely posts the data to a remote server.

## Install

```bash
npm install background-location
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------

</docgen-api>
