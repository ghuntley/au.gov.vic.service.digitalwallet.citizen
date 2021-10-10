package com.google.android.gms.internal.instantapps;

import java.io.IOException;

abstract class zzfm<T, B> {
    zzfm() {
    }

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, zzbp zzbp);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, T t);

    /* access modifiers changed from: package-private */
    public abstract void zza(T t, zzgi zzgi) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract boolean zza(zzev zzev);

    /* access modifiers changed from: package-private */
    public abstract void zzb(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzc(Object obj);

    /* access modifiers changed from: package-private */
    public abstract void zzc(B b, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void zzc(T t, zzgi zzgi) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract B zzdz();

    /* access modifiers changed from: package-private */
    public abstract void zze(Object obj, T t);

    /* access modifiers changed from: package-private */
    public abstract void zzf(Object obj, B b);

    /* access modifiers changed from: package-private */
    public abstract T zzg(T t, T t2);

    /* access modifiers changed from: package-private */
    public abstract T zzi(B b);

    /* access modifiers changed from: package-private */
    public abstract int zzm(T t);

    /* access modifiers changed from: package-private */
    public abstract T zzq(Object obj);

    /* access modifiers changed from: package-private */
    public abstract B zzr(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int zzs(T t);

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    public final boolean zza(B b, zzev zzev) throws IOException {
        int tag = zzev.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            zza(b, i, zzev.zzac());
            return true;
        } else if (i2 == 1) {
            zzb(b, i, zzev.zzae());
            return true;
        } else if (i2 == 2) {
            zza((Object) b, i, zzev.zzai());
            return true;
        } else if (i2 == 3) {
            B zzdz = zzdz();
            int i3 = 4 | (i << 3);
            while (zzev.zzas() != Integer.MAX_VALUE && zza(zzdz, zzev)) {
                while (zzev.zzas() != Integer.MAX_VALUE) {
                    while (zzev.zzas() != Integer.MAX_VALUE) {
                    }
                }
            }
            if (i3 == zzev.getTag()) {
                zza((Object) b, i, (Object) zzi(zzdz));
                return true;
            }
            throw zzdf.zzcj();
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzc(b, i, zzev.zzaf());
                return true;
            }
            throw zzdf.zzck();
        }
    }
}
