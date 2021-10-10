package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjk extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 2);
        zzom zzom = zzoaArr[0];
        zzom zzom2 = zzoaArr[1];
        if ((!(zzom instanceof zzog) || zzom == zzog.zzaum || zzom == zzog.zzaul) && (!(zzom2 instanceof zzog) || zzom2 == zzog.zzaum || zzom2 == zzog.zzaul)) {
            if ((zzom instanceof zzok) || (zzom instanceof zzoh) || (zzom instanceof zzof)) {
                zzom = new zzom(zzha.zzd(zzom));
            }
            if ((zzom2 instanceof zzok) || (zzom2 instanceof zzoh) || (zzom2 instanceof zzof)) {
                zzom2 = new zzom(zzha.zzd(zzom2));
            }
            if (!(zzom instanceof zzom) && !(zzom2 instanceof zzom)) {
                return new zzoe(Double.valueOf(zzha.zza(zzom, zzom2)));
            }
            String valueOf = String.valueOf(zzha.zzd(zzom));
            String valueOf2 = String.valueOf(zzha.zzd(zzom2));
            return new zzom(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        }
        throw new IllegalArgumentException("Illegal InternalType passed to Add.");
    }
}
