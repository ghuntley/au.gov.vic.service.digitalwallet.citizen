package com.google.android.gms.instantapps;

import com.google.android.gms.common.Feature;

public final class zza {
    public static final Feature zze;
    public static final Feature zzf;
    public static final Feature zzg;
    public static final Feature zzh;
    private static final Feature[] zzi;

    static {
        Feature feature = new Feature("device_enabled_api", 1);
        zze = feature;
        Feature feature2 = new Feature("instant_app_removed_api", 1);
        zzf = feature2;
        Feature feature3 = new Feature("instant_app_installed_api", 1);
        zzg = feature3;
        Feature feature4 = new Feature("instant_app_uninstalled_api", 1);
        zzh = feature4;
        zzi = new Feature[]{feature, feature2, feature3, feature4};
    }
}
