package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
abstract class zzkt<T, B> {
    zzkt() {
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
    public abstract void zza(B b, int i, zzgp zzgp);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, T t);

    /* access modifiers changed from: package-private */
    public abstract void zza(T t, zzlm zzlm) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(Object obj, T t);

    /* access modifiers changed from: package-private */
    public abstract boolean zza(zzjy zzjy);

    /* access modifiers changed from: package-private */
    public abstract T zzb(Object obj);

    /* access modifiers changed from: package-private */
    public abstract void zzb(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzb(T t, zzlm zzlm) throws IOException;

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
    public final boolean zza(B b, zzjy zzjy) throws IOException {
        int zzb = zzjy.zzb();
        int i = zzb >>> 3;
        int i2 = zzb & 7;
        if (i2 == 0) {
            zza(b, i, zzjy.zzg());
            return true;
        } else if (i2 == 1) {
            zzb(b, i, zzjy.zzi());
            return true;
        } else if (i2 == 2) {
            zza((Object) b, i, zzjy.zzn());
            return true;
        } else if (i2 == 3) {
            B zza = zza();
            int i3 = 4 | (i << 3);
            while (zzjy.zza() != Integer.MAX_VALUE && zza((Object) zza, zzjy)) {
                while (zzjy.zza() != Integer.MAX_VALUE) {
                    while (zzjy.zza() != Integer.MAX_VALUE) {
                    }
                }
            }
            if (i3 == zzjy.zzb()) {
                zza((Object) b, i, (Object) zza((Object) zza));
                return true;
            }
            throw zzij.zze();
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zza((Object) b, i, zzjy.zzj());
                return true;
            }
            throw zzij.zzf();
        }
    }
}
