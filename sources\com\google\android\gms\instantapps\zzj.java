package com.google.android.gms.instantapps;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.instantapps.zze;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzj extends zze {
    private final /* synthetic */ TaskCompletionSource zzt;

    zzj(InstantAppsClient instantAppsClient, TaskCompletionSource taskCompletionSource) {
        this.zzt = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.instantapps.zze, com.google.android.gms.internal.instantapps.zzs
    public final void zza(Status status, boolean z) {
        TaskUtil.setResultOrApiException(status, Boolean.valueOf(z), this.zzt);
    }
}
