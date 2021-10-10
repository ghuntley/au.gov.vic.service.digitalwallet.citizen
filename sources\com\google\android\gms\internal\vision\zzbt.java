package com.google.android.gms.internal.vision;

import android.content.SharedPreferences;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final /* synthetic */ class zzbt implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final zzbq zza;

    zzbt(zzbq zzbq) {
        this.zza = zzbq;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zza.zza(sharedPreferences, str);
    }
}
