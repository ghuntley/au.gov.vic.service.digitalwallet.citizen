package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzas {
    private final Map<String, String> zztc;
    private final String zzut;
    private final long zzww = 0;
    private final String zzwx;
    private final boolean zzwy;
    private long zzwz;

    public zzas(long j, String str, String str2, boolean z, long j2, Map<String, String> map) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        this.zzut = str;
        this.zzwx = str2;
        this.zzwy = z;
        this.zzwz = j2;
        if (map != null) {
            this.zztc = new HashMap(map);
        } else {
            this.zztc = Collections.emptyMap();
        }
    }

    public final long zzdi() {
        return this.zzww;
    }

    public final String zzbt() {
        return this.zzut;
    }

    public final String zzdj() {
        return this.zzwx;
    }

    public final boolean zzdk() {
        return this.zzwy;
    }

    public final long zzdl() {
        return this.zzwz;
    }

    public final void zzb(long j) {
        this.zzwz = j;
    }

    public final Map<String, String> zzdm() {
        return this.zztc;
    }
}
