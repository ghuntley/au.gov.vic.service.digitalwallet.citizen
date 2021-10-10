package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.location.zzae;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.internal.location.zzbh;
import com.google.android.gms.internal.location.zzn;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public class LocationServices {
    public static final Api<Api.ApiOptions.NoOptions> API;
    @Deprecated
    public static final FusedLocationProviderApi FusedLocationApi = new zzn();
    @Deprecated
    public static final GeofencingApi GeofencingApi = new zzae();
    @Deprecated
    public static final SettingsApi SettingsApi = new zzbh();
    private static final Api.ClientKey<zzay> zza;
    private static final Api.AbstractClientBuilder<zzay, Api.ApiOptions.NoOptions> zzb;

    private LocationServices() {
    }

    /* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
    public static abstract class zza<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzay> {
        public zza(GoogleApiClient googleApiClient) {
            super(LocationServices.API, googleApiClient);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.gms.location.LocationServices$zza<R extends com.google.android.gms.common.api.Result> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl, com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
        public /* bridge */ /* synthetic */ void setResult(Object obj) {
            super.setResult((Result) obj);
        }
    }

    public static zzay zza(GoogleApiClient googleApiClient) {
        boolean z = true;
        Preconditions.checkArgument(googleApiClient != null, "GoogleApiClient parameter is required.");
        zzay zzay = (zzay) googleApiClient.getClient(zza);
        if (zzay == null) {
            z = false;
        }
        Preconditions.checkState(z, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return zzay;
    }

    public static GeofencingClient getGeofencingClient(Activity activity) {
        return new GeofencingClient(activity);
    }

    public static GeofencingClient getGeofencingClient(Context context) {
        return new GeofencingClient(context);
    }

    public static SettingsClient getSettingsClient(Activity activity) {
        return new SettingsClient(activity);
    }

    public static SettingsClient getSettingsClient(Context context) {
        return new SettingsClient(context);
    }

    public static FusedLocationProviderClient getFusedLocationProviderClient(Activity activity) {
        return new FusedLocationProviderClient(activity);
    }

    public static FusedLocationProviderClient getFusedLocationProviderClient(Context context) {
        return new FusedLocationProviderClient(context);
    }

    static {
        Api.ClientKey<zzay> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        zzax zzax = new zzax();
        zzb = zzax;
        API = new Api<>("LocationServices.API", zzax, clientKey);
    }
}
