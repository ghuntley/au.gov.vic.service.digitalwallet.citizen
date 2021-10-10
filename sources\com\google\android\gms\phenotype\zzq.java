package com.google.android.gms.phenotype;

import com.google.android.gms.phenotype.PhenotypeFlag;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzq implements PhenotypeFlag.zza {
    private final String zzav;
    private final boolean zzaw = false;

    zzq(String str, boolean z) {
        this.zzav = str;
    }

    @Override // com.google.android.gms.phenotype.PhenotypeFlag.zza
    public final Object zzh() {
        return PhenotypeFlag.zzb(this.zzav, this.zzaw);
    }
}
