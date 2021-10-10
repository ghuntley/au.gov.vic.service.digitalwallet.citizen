package com.google.android.gms.internal.gtm;

import android.os.Build;

public final class zzbx {
    public static int version() {
        try {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException unused) {
            zzch.zzf("Invalid version number", Build.VERSION.SDK);
            return 0;
        }
    }
}
