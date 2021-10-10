package com.google.android.gms.phenotype;

import java.util.Comparator;

final class zzj implements Comparator<zzi> {
    zzj() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzi zzi, zzi zzi2) {
        zzi zzi3 = zzi;
        zzi zzi4 = zzi2;
        return zzi3.zzah == zzi4.zzah ? zzi3.name.compareTo(zzi4.name) : zzi3.zzah - zzi4.zzah;
    }
}
