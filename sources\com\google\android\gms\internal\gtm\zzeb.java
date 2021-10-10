package com.google.android.gms.internal.gtm;

import android.util.Log;

public final class zzeb implements zzew {
    private boolean zzani = true;
    private int zzyr = 5;

    @Override // com.google.android.gms.internal.gtm.zzew
    public final void zzav(String str) {
        if (isLoggable(6)) {
            Log.e("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzew
    public final void zza(String str, Throwable th) {
        if (isLoggable(6)) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzew
    public final void zzac(String str) {
        if (isLoggable(5)) {
            Log.w("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzew
    public final void zzb(String str, Throwable th) {
        if (isLoggable(5)) {
            Log.w("GoogleTagManager", str, th);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzew
    public final void zzaw(String str) {
        if (isLoggable(4)) {
            Log.i("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzew
    public final void zzab(String str) {
        if (isLoggable(2)) {
            Log.v("GoogleTagManager", str);
        }
    }

    private final boolean isLoggable(int i) {
        if (!this.zzani || !Log.isLoggable("GoogleTagManager", i)) {
            return !this.zzani && this.zzyr <= i;
        }
        return true;
    }
}
