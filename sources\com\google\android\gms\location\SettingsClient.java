package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public class SettingsClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    public SettingsClient(Context context) {
        super(context, LocationServices.API, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
    public static class zza implements BaseImplementation.ResultHolder<LocationSettingsResult> {
        private final TaskCompletionSource<LocationSettingsResponse> zza;

        public zza(TaskCompletionSource<LocationSettingsResponse> taskCompletionSource) {
            this.zza = taskCompletionSource;
        }

        @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
        public final void setFailedResult(Status status) {
            this.zza.setException(new ApiException(status));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
        public final /* synthetic */ void setResult(LocationSettingsResult locationSettingsResult) {
            LocationSettingsResult locationSettingsResult2 = locationSettingsResult;
            Status status = locationSettingsResult2.getStatus();
            if (status.isSuccess()) {
                this.zza.setResult(new LocationSettingsResponse(locationSettingsResult2));
            } else if (status.hasResolution()) {
                this.zza.setException(new ResolvableApiException(status));
            } else {
                this.zza.setException(new ApiException(status));
            }
        }
    }

    public SettingsClient(Activity activity) {
        super(activity, (Api) LocationServices.API, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public Task<LocationSettingsResponse> checkLocationSettings(LocationSettingsRequest locationSettingsRequest) {
        return doRead(TaskApiCall.builder().run(new zzbh(locationSettingsRequest)).build());
    }
}
