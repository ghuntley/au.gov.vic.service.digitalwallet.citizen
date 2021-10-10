package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.GoogleApiAvailabilityLight;

public final class zzao {
    public static final String VERSION;
    public static final String zzwe;

    static {
        String replaceAll = String.valueOf(GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
        VERSION = replaceAll;
        String valueOf = String.valueOf(replaceAll);
        zzwe = valueOf.length() != 0 ? "ma".concat(valueOf) : new String("ma");
    }
}
