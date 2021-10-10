package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.internal.location.zze;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public class ActivityRecognition {
    public static final Api<Api.ApiOptions.NoOptions> API;
    @Deprecated
    public static final ActivityRecognitionApi ActivityRecognitionApi = new zze();
    public static final String CLIENT_NAME = "activity_recognition";
    private static final Api.ClientKey<zzay> zza;
    private static final Api.AbstractClientBuilder<zzay, Api.ApiOptions.NoOptions> zzb;

    private ActivityRecognition() {
    }

    /* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
    public static abstract class zza<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzay> {
        public zza(GoogleApiClient googleApiClient) {
            super(ActivityRecognition.API, googleApiClient);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.gms.location.ActivityRecognition$zza<R extends com.google.android.gms.common.api.Result> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl, com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
        public /* bridge */ /* synthetic */ void setResult(Object obj) {
            super.setResult((Result) obj);
        }
    }

    public static ActivityRecognitionClient getClient(Activity activity) {
        return new ActivityRecognitionClient(activity);
    }

    public static ActivityRecognitionClient getClient(Context context) {
        return new ActivityRecognitionClient(context);
    }

    static {
        Api.ClientKey<zzay> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        zza zza2 = new zza();
        zzb = zza2;
        API = new Api<>("ActivityRecognition.API", zza2, clientKey);
    }
}
