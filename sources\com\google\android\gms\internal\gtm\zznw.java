package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.List;

public final class zznw {
    private String version;
    private List<zzgy> zzaty = new ArrayList();

    public final zznw zza(zzgy zzgy) {
        this.zzaty.add(zzgy);
        return this;
    }

    public final zznw zzcm(String str) {
        this.version = str;
        return this;
    }

    public final zznu zzmc() {
        return new zznu(this.version, this.zzaty);
    }
}
