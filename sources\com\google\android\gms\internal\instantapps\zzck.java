package com.google.android.gms.internal.instantapps;

import androidx.core.internal.view.SupportMenu;
import com.google.android.gms.internal.instantapps.zzcx;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzck {
    private static volatile boolean zzalv = false;
    private static final Class<?> zzalw = zzbe();
    private static volatile zzck zzalx;
    static final zzck zzaly = new zzck(true);
    private final Map<zza, zzcx.zze<?, ?>> zzalz;

    private static Class<?> zzbe() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * SupportMenu.USER_MASK) + this.number;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.object == zza.object && this.number == zza.number) {
                return true;
            }
            return false;
        }
    }

    public static zzck zzbf() {
        zzck zzck = zzalx;
        if (zzck == null) {
            synchronized (zzck.class) {
                zzck = zzalx;
                if (zzck == null) {
                    zzck = zzcl.zzbh();
                    zzalx = zzck;
                }
            }
        }
        return zzck;
    }

    public final <ContainingType extends zzef> zzcx.zze<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzcx.zze<ContainingType, ?>) this.zzalz.get(new zza(containingtype, i));
    }

    zzck() {
        this.zzalz = new HashMap();
    }

    private zzck(boolean z) {
        this.zzalz = Collections.emptyMap();
    }
}
