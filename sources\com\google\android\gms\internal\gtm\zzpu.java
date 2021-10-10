package com.google.android.gms.internal.gtm;

import java.util.Comparator;

final class zzpu implements Comparator<zzps> {
    zzpu() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzps zzps, zzps zzps2) {
        zzps zzps3 = zzps;
        zzps zzps4 = zzps2;
        zzpz zzpz = (zzpz) zzps3.iterator();
        zzpz zzpz2 = (zzpz) zzps4.iterator();
        while (zzpz.hasNext() && zzpz2.hasNext()) {
            int compare = Integer.compare(zzps.zza(zzpz.nextByte()), zzps.zza(zzpz2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzps3.size(), zzps4.size());
    }
}
