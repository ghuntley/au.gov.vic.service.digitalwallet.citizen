package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzmw {
    private zzmk zzasy;

    public final zzmw zza(zzmk zzmk) throws IllegalArgumentException {
        Preconditions.checkNotNull(zzmk);
        this.zzasy = zzmk;
        return this;
    }

    public final zzmk zzlk() {
        return this.zzasy;
    }

    public final String getId() {
        zzmk zzmk = this.zzasy;
        return zzmk == null ? "" : zzmk.getContainerId();
    }
}
