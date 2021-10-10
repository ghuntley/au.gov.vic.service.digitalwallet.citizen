package com.google.android.gms.internal.instantapps;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.instantapps.InstantAppIntentData;
import com.google.android.gms.instantapps.InstantApps;
import com.google.android.gms.instantapps.LaunchData;
import com.google.android.gms.instantapps.Launcher;
import com.google.android.gms.tasks.Task;

public final class zzaj implements Launcher {
    private static zzaj zzbo;
    private final Context zzbl;
    private final zzy zzbp = new zzy();

    public static synchronized zzaj zzf(Context context) {
        zzaj zzaj;
        synchronized (zzaj.class) {
            Preconditions.checkNotNull(context);
            Context applicationContext = context.getApplicationContext();
            zzaj zzaj2 = zzbo;
            if (zzaj2 == null || zzaj2.zzbl != applicationContext) {
                zzbo = new zzaj(applicationContext);
            }
            zzaj = zzbo;
        }
        return zzaj;
    }

    private zzaj(Context context) {
        this.zzbl = context;
    }

    @Override // com.google.android.gms.instantapps.Launcher
    public final boolean initializeIntentClient() {
        return zzai.zzd(this.zzbl);
    }

    @Override // com.google.android.gms.instantapps.Launcher
    public final InstantAppIntentData getInstantAppIntentData(String str, Intent intent) {
        return zzai.zza(this.zzbl, str, intent, new zzar(), Bundle.EMPTY);
    }

    @Override // com.google.android.gms.instantapps.Launcher
    public final Task<LaunchData> getInstantAppLaunchData(String str) {
        return InstantApps.getInstantAppsClient(this.zzbl).getInstantAppLaunchData(str);
    }
}
