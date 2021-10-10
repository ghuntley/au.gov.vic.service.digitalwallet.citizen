package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzog extends zzoa<zzoa<?>> {
    public static final zzog zzauj = new zzog("BREAK");
    public static final zzog zzauk = new zzog("CONTINUE");
    public static final zzog zzaul = new zzog("NULL");
    public static final zzog zzaum = new zzog("UNDEFINED");
    private final String name;
    private final boolean zzaun;
    private final zzoa<?> zzauo;

    private zzog(String str) {
        this.name = str;
        this.zzaun = false;
        this.zzauo = null;
    }

    public zzog(zzoa<?> zzoa) {
        Preconditions.checkNotNull(zzoa);
        this.name = "RETURN";
        this.zzaun = true;
        this.zzauo = zzoa;
    }

    public final boolean zzmh() {
        return this.zzaun;
    }

    @Override // com.google.android.gms.internal.gtm.zzoa
    public final String toString() {
        return this.name;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.gtm.zzoa
    public final /* synthetic */ zzoa<?> value() {
        return this.zzauo;
    }
}
