package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbv;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final /* synthetic */ class zzq {
    static final /* synthetic */ int[] zza;
    static final /* synthetic */ int[] zzb;

    /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|(3:27|28|30)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|30) */
    /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|30) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
    static {
        int[] iArr = new int[zzbv.zzd.zza.values().length];
        zzb = iArr;
        try {
            iArr[zzbv.zzd.zza.LESS_THAN.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zzb[zzbv.zzd.zza.GREATER_THAN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zzb[zzbv.zzd.zza.EQUAL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            zzb[zzbv.zzd.zza.BETWEEN.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[zzbv.zzf.zzb.values().length];
        zza = iArr2;
        iArr2[zzbv.zzf.zzb.REGEXP.ordinal()] = 1;
        zza[zzbv.zzf.zzb.BEGINS_WITH.ordinal()] = 2;
        zza[zzbv.zzf.zzb.ENDS_WITH.ordinal()] = 3;
        zza[zzbv.zzf.zzb.PARTIAL.ordinal()] = 4;
        zza[zzbv.zzf.zzb.EXACT.ordinal()] = 5;
        try {
            zza[zzbv.zzf.zzb.IN_LIST.ordinal()] = 6;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
