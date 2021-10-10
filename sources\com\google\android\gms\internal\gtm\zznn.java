package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zznn {
    private String version = "";
    private final List<zznr> zzatq = new ArrayList();
    private final Map<String, zzno> zzatr = new HashMap();
    private int zzpw = 0;

    public final zznn zza(zznr zznr) {
        this.zzatq.add(zznr);
        return this;
    }

    public final zznn zzb(zzno zzno) {
        this.zzatr.put(zzno.zzlu().get("instance_name").toString(), zzno);
        return this;
    }

    public final zznn zzcl(String str) {
        this.version = str;
        return this;
    }

    public final zznm zzlt() {
        return new zznm(this.zzatq, this.zzatr, this.version, 0);
    }
}
