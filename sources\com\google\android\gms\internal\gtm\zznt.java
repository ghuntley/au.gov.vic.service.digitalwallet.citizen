package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.List;

public final class zznt {
    private final List<zzno> zzatu = new ArrayList();
    private final List<zzno> zzatv = new ArrayList();
    private final List<zzno> zzatw = new ArrayList();
    private final List<zzno> zzatx = new ArrayList();

    public final zznt zzc(zzno zzno) {
        this.zzatu.add(zzno);
        return this;
    }

    public final zznt zzd(zzno zzno) {
        this.zzatv.add(zzno);
        return this;
    }

    public final zznt zze(zzno zzno) {
        this.zzatw.add(zzno);
        return this;
    }

    public final zznt zzf(zzno zzno) {
        this.zzatx.add(zzno);
        return this;
    }

    public final zznr zzma() {
        return new zznr(this.zzatu, this.zzatv, this.zzatw, this.zzatx);
    }
}
