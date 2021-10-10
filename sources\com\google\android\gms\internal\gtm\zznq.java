package com.google.android.gms.internal.gtm;

import java.util.HashMap;
import java.util.Map;

public final class zznq {
    private final Map<String, zznx> zzats = new HashMap();
    private zznx zzatt;

    public final zznq zza(String str, zznx zznx) {
        this.zzats.put(str, zznx);
        return this;
    }

    public final zznq zzb(zznx zznx) {
        this.zzatt = zznx;
        return this;
    }

    public final zzno zzlv() {
        return new zzno(this.zzats, this.zzatt);
    }
}
