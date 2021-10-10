package com.google.android.gms.internal.vision;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
abstract class zzlu<T, B> {
    zzlu() {
    }

    /* access modifiers changed from: package-private */
    public abstract B zza();

    /* access modifiers changed from: package-private */
    public abstract T zza(B b);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, zzht zzht);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, T t);

    /* access modifiers changed from: package-private */
    public abstract void zza(T t, zzmr zzmr) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(Object obj, T t);

    /* access modifiers changed from: package-private */
    public abstract boolean zza(zzld zzld);

    /* access modifiers changed from: package-private */
    public abstract T zzb(Object obj);

    /* access modifiers changed from: package-private */
    public abstract void zzb(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzb(T t, zzmr zzmr) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzb(Object obj, B b);

    /* access modifiers changed from: package-private */
    public abstract B zzc(Object obj);

    /* access modifiers changed from: package-private */
    public abstract T zzc(T t, T t2);

    /* access modifiers changed from: package-private */
    public abstract void zzd(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int zze(T t);

    /* access modifiers changed from: package-private */
    public abstract int zzf(T t);

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    public final boolean zza(B b, zzld zzld) throws IOException {
        int zzb = zzld.zzb();
        int i = zzb >>> 3;
        int i2 = zzb & 7;
        if (i2 == 0) {
            zza(b, i, zzld.zzg());
            return true;
        } else if (i2 == 1) {
            zzb(b, i, zzld.zzi());
            return true;
        } else if (i2 == 2) {
            zza((Object) b, i, zzld.zzn());
            return true;
        } else if (i2 == 3) {
            B zza = zza();
            int i3 = 4 | (i << 3);
            while (zzld.zza() != Integer.MAX_VALUE && zza((Object) zza, zzld)) {
                while (zzld.zza() != Integer.MAX_VALUE) {
                    while (zzld.zza() != Integer.MAX_VALUE) {
                    }
                }
            }
            if (i3 == zzld.zzb()) {
                zza((Object) b, i, (Object) zza((Object) zza));
                return true;
            }
            throw zzjk.zze();
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zza((Object) b, i, zzld.zzj());
                return true;
            }
            throw zzjk.zzf();
        }
    }
}
