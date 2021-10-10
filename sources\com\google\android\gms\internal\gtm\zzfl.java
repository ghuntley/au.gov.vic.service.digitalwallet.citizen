package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.Map;

public final class zzfl {
    private zzfl zzape;
    private Map<String, zzoa> zzapf;

    public zzfl() {
        this(null);
    }

    private zzfl(zzfl zzfl) {
        this.zzapf = null;
        this.zzape = zzfl;
    }

    public final zzfl zzku() {
        return new zzfl(this);
    }

    public final boolean has(String str) {
        zzfl zzfl = this;
        do {
            Map<String, zzoa> map = zzfl.zzapf;
            if (map != null && map.containsKey(str)) {
                return true;
            }
            zzfl = zzfl.zzape;
        } while (zzfl != null);
        return false;
    }

    public final zzoa<?> zzca(String str) {
        zzfl zzfl = this;
        do {
            Map<String, zzoa> map = zzfl.zzapf;
            if (map != null && map.containsKey(str)) {
                return zzfl.zzapf.get(str);
            }
            zzfl = zzfl.zzape;
        } while (zzfl != null);
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Trying to get a non existent symbol: ".concat(valueOf) : new String("Trying to get a non existent symbol: "));
    }

    public final void zza(String str, zzoa<?> zzoa) {
        if (this.zzapf == null) {
            this.zzapf = new HashMap();
        }
        this.zzapf.put(str, zzoa);
    }

    public final void zzb(String str, zzoa<?> zzoa) {
        zzfl zzfl = this;
        do {
            Map<String, zzoa> map = zzfl.zzapf;
            if (map == null || !map.containsKey(str)) {
                zzfl = zzfl.zzape;
            } else {
                zzfl.zzapf.put(str, zzoa);
                return;
            }
        } while (zzfl != null);
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Trying to modify a non existent symbol: ".concat(valueOf) : new String("Trying to modify a non existent symbol: "));
    }

    public final void remove(String str) {
        zzfl zzfl = this;
        while (true) {
            Preconditions.checkState(zzfl.has(str));
            Map<String, zzoa> map = zzfl.zzapf;
            if (map == null || !map.containsKey(str)) {
                zzfl = zzfl.zzape;
            } else {
                zzfl.zzapf.remove(str);
                return;
            }
        }
    }
}
