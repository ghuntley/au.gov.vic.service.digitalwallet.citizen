package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbv;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public abstract class zzu {
    String zza;
    int zzb;
    Boolean zzc;
    Boolean zzd;
    Long zze;
    Long zzf;

    zzu(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    /* access modifiers changed from: package-private */
    public abstract int zza();

    /* access modifiers changed from: package-private */
    public abstract boolean zzb();

    /* access modifiers changed from: package-private */
    public abstract boolean zzc();

    static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    static Boolean zza(String str, zzbv.zzf zzf2, zzeq zzeq) {
        String str2;
        List<String> list;
        Preconditions.checkNotNull(zzf2);
        if (str == null || !zzf2.zza() || zzf2.zzb() == zzbv.zzf.zzb.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        if (zzf2.zzb() == zzbv.zzf.zzb.IN_LIST) {
            if (zzf2.zzh() == 0) {
                return null;
            }
        } else if (!zzf2.zzc()) {
            return null;
        }
        zzbv.zzf.zzb zzb2 = zzf2.zzb();
        boolean zzf3 = zzf2.zzf();
        if (zzf3 || zzb2 == zzbv.zzf.zzb.REGEXP || zzb2 == zzbv.zzf.zzb.IN_LIST) {
            str2 = zzf2.zzd();
        } else {
            str2 = zzf2.zzd().toUpperCase(Locale.ENGLISH);
        }
        if (zzf2.zzh() == 0) {
            list = null;
        } else {
            List<String> zzg = zzf2.zzg();
            if (!zzf3) {
                ArrayList arrayList = new ArrayList(zzg.size());
                for (String str3 : zzg) {
                    arrayList.add(str3.toUpperCase(Locale.ENGLISH));
                }
                zzg = Collections.unmodifiableList(arrayList);
            }
            list = zzg;
        }
        return zza(str, zzb2, zzf3, str2, list, zzb2 == zzbv.zzf.zzb.REGEXP ? str2 : null, zzeq);
    }

    private static Boolean zza(String str, zzbv.zzf.zzb zzb2, boolean z, String str2, List<String> list, String str3, zzeq zzeq) {
        if (str == null) {
            return null;
        }
        if (zzb2 == zzbv.zzf.zzb.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && zzb2 != zzbv.zzf.zzb.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (zzq.zza[zzb2.ordinal()]) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzeq != null) {
                        zzeq.zzh().zza("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    static Boolean zza(long j, zzbv.zzd zzd2) {
        try {
            return zza(new BigDecimal(j), zzd2, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zza(double d, zzbv.zzd zzd2) {
        try {
            return zza(new BigDecimal(d), zzd2, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zza(String str, zzbv.zzd zzd2) {
        if (!zzkr.zza(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzd2, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0084, code lost:
        if (r2 != null) goto L_0x0086;
     */
    private static Boolean zza(BigDecimal bigDecimal, zzbv.zzd zzd2, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzd2);
        if (zzd2.zza() && zzd2.zzb() != zzbv.zzd.zza.UNKNOWN_COMPARISON_TYPE) {
            if (zzd2.zzb() == zzbv.zzd.zza.BETWEEN) {
                if (!zzd2.zzg() || !zzd2.zzi()) {
                    return null;
                }
            } else if (!zzd2.zze()) {
                return null;
            }
            zzbv.zzd.zza zzb2 = zzd2.zzb();
            if (zzd2.zzb() == zzbv.zzd.zza.BETWEEN) {
                if (zzkr.zza(zzd2.zzh()) && zzkr.zza(zzd2.zzj())) {
                    try {
                        BigDecimal bigDecimal5 = new BigDecimal(zzd2.zzh());
                        bigDecimal3 = new BigDecimal(zzd2.zzj());
                        bigDecimal2 = bigDecimal5;
                        bigDecimal4 = null;
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            } else if (!zzkr.zza(zzd2.zzf())) {
                return null;
            } else {
                try {
                    bigDecimal4 = new BigDecimal(zzd2.zzf());
                    bigDecimal2 = null;
                    bigDecimal3 = null;
                } catch (NumberFormatException unused2) {
                }
            }
            if (zzb2 == zzbv.zzd.zza.BETWEEN) {
                if (bigDecimal2 == null) {
                    return null;
                }
            }
            int i = zzq.zzb[zzb2.ordinal()];
            boolean z = false;
            if (i == 1) {
                if (bigDecimal.compareTo(bigDecimal4) == -1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else if (i == 2) {
                if (bigDecimal.compareTo(bigDecimal4) == 1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else if (i != 3) {
                if (i == 4) {
                    if (!(bigDecimal.compareTo(bigDecimal2) == -1 || bigDecimal.compareTo(bigDecimal3) == 1)) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            } else if (d != 0.0d) {
                if (bigDecimal.compareTo(bigDecimal4.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) == 1 && bigDecimal.compareTo(bigDecimal4.add(new BigDecimal(d).multiply(new BigDecimal(2)))) == -1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else {
                if (bigDecimal.compareTo(bigDecimal4) == 0) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }
        return null;
    }
}
