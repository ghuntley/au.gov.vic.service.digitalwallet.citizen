package com.google.android.gms.internal.vision;

import androidx.core.internal.view.SupportMenu;
import com.google.android.gms.internal.vision.zzjb;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public class zzio {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzio zzc;
    private static volatile zzio zzd;
    private static final zzio zze = new zzio(true);
    private final Map<zza, zzjb.zze<?, ?>> zzf;

    public static zzio zza() {
        return new zzio();
    }

    public static zzio zzb() {
        zzio zzio = zzc;
        if (zzio == null) {
            synchronized (zzio.class) {
                zzio = zzc;
                if (zzio == null) {
                    zzio = zze;
                    zzc = zzio;
                }
            }
        }
        return zzio;
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    private static final class zza {
        private final Object zza;
        private final int zzb;

        zza(Object obj, int i) {
            this.zza = obj;
            this.zzb = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.zza) * SupportMenu.USER_MASK) + this.zzb;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza2 = (zza) obj;
            if (this.zza == zza2.zza && this.zzb == zza2.zzb) {
                return true;
            }
            return false;
        }
    }

    public static zzio zzc() {
        zzio zzio = zzd;
        if (zzio != null) {
            return zzio;
        }
        synchronized (zzio.class) {
            zzio zzio2 = zzd;
            if (zzio2 != null) {
                return zzio2;
            }
            zzio zza2 = zziz.zza(zzio.class);
            zzd = zza2;
            return zza2;
        }
    }

    public final <ContainingType extends zzkk> zzjb.zze<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzjb.zze<ContainingType, ?>) this.zzf.get(new zza(containingtype, i));
    }

    public final void zza(zzjb.zze<?, ?> zze2) {
        this.zzf.put(new zza(zze2.zza, zze2.zzd.zzb), zze2);
    }

    zzio() {
        this.zzf = new HashMap();
    }

    private zzio(boolean z) {
        this.zzf = Collections.emptyMap();
    }
}
