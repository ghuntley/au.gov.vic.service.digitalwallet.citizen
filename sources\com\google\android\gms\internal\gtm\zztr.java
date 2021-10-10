package com.google.android.gms.internal.gtm;

import java.io.IOException;

abstract class zztr<T, B> {
    zztr() {
    }

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, zzps zzps);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, T t);

    /* access modifiers changed from: package-private */
    public abstract void zza(T t, zzum zzum) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract boolean zza(zzsy zzsy);

    /* access modifiers changed from: package-private */
    public abstract T zzaa(B b);

    /* access modifiers changed from: package-private */
    public abstract int zzad(T t);

    /* access modifiers changed from: package-private */
    public abstract T zzag(Object obj);

    /* access modifiers changed from: package-private */
    public abstract B zzah(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int zzai(T t);

    /* access modifiers changed from: package-private */
    public abstract void zzb(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzc(B b, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void zzc(T t, zzum zzum) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzf(Object obj, T t);

    /* access modifiers changed from: package-private */
    public abstract void zzg(Object obj, B b);

    /* access modifiers changed from: package-private */
    public abstract T zzh(T t, T t2);

    /* access modifiers changed from: package-private */
    public abstract B zzri();

    /* access modifiers changed from: package-private */
    public abstract void zzt(Object obj);

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    public final boolean zza(B b, zzsy zzsy) throws IOException {
        int tag = zzsy.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            zza(b, i, zzsy.zznk());
            return true;
        } else if (i2 == 1) {
            zzb(b, i, zzsy.zznm());
            return true;
        } else if (i2 == 2) {
            zza((Object) b, i, zzsy.zznq());
            return true;
        } else if (i2 == 3) {
            B zzri = zzri();
            int i3 = 4 | (i << 3);
            while (zzsy.zzog() != Integer.MAX_VALUE && zza(zzri, zzsy)) {
                while (zzsy.zzog() != Integer.MAX_VALUE) {
                    while (zzsy.zzog() != Integer.MAX_VALUE) {
                    }
                }
            }
            if (i3 == zzsy.getTag()) {
                zza((Object) b, i, (Object) zzaa(zzri));
                return true;
            }
            throw zzrk.zzps();
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzc(b, i, zzsy.zznn());
                return true;
            }
            throw zzrk.zzpt();
        }
    }
}
