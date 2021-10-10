package com.google.android.gms.location;

import com.google.android.gms.common.Feature;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public final class zzp {
    public static final Feature zza;
    public static final Feature zzb;
    public static final Feature[] zzc;
    private static final Feature zzd;
    private static final Feature zze;

    static {
        Feature feature = new Feature("name_ulr_private", 1);
        zzd = feature;
        Feature feature2 = new Feature("name_sleep_segment_request", 1);
        zze = feature2;
        Feature feature3 = new Feature("support_context_feature_id", 1);
        zza = feature3;
        Feature feature4 = new Feature("get_current_location", 1);
        zzb = feature4;
        zzc = new Feature[]{feature, feature2, feature3, feature4};
    }
}
