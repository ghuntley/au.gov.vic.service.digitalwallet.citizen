package com.google.android.gms.instantapps;

import android.app.Activity;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.internal.instantapps.zzy;
import com.google.android.gms.tasks.Task;

public class InstantAppsClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    private final zzy zzo = new zzy();

    public InstantAppsClient(Context context) {
        super(context, InstantApps.API, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public InstantAppsClient(Activity activity) {
        super(activity, (Api) InstantApps.API, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public final Task<LaunchData> getInstantAppLaunchData(String str) {
        return PendingResultUtil.toTask(this.zzo.zza(asGoogleApiClient(), str), zzg.zzn);
    }

    public Task<ParcelFileDescriptor> getInstantAppData() {
        return PendingResultUtil.toTask(this.zzo.zza(asGoogleApiClient()), zzi.zzn);
    }

    public Task<Boolean> areInstantAppsEnabledForDevice() {
        return doRead(TaskApiCall.builder().execute(new zzh(this)).setFeatures(zza.zze).build());
    }
}
