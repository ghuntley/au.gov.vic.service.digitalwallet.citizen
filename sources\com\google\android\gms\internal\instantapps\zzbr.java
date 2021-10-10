package com.google.android.gms.internal.instantapps;

import java.util.Comparator;

final class zzbr implements Comparator<zzbp> {
    zzbr() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzbp zzbp, zzbp zzbp2) {
        zzbp zzbp3 = zzbp;
        zzbp zzbp4 = zzbp2;
        zzbu zzbu = (zzbu) zzbp3.iterator();
        zzbu zzbu2 = (zzbu) zzbp4.iterator();
        while (zzbu.hasNext() && zzbu2.hasNext()) {
            int compare = Integer.compare(zzbp.zza(zzbu.nextByte()), zzbp.zza(zzbu2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzbp3.size(), zzbp4.size());
    }
}
