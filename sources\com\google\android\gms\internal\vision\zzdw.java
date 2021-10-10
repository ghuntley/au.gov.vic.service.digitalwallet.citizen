package com.google.android.gms.internal.vision;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public abstract class zzdw<T> implements Iterator<T> {
    private int zza;
    private int zzb;
    private int zzc;
    private final /* synthetic */ zzdp zzd;

    private zzdw(zzdp zzdp) {
        this.zzd = zzdp;
        this.zza = zzdp.zzf;
        this.zzb = zzdp.zzd();
        this.zzc = -1;
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(int i);

    public boolean hasNext() {
        return this.zzb >= 0;
    }

    @Override // java.util.Iterator
    public T next() {
        zza();
        if (hasNext()) {
            int i = this.zzb;
            this.zzc = i;
            T zza2 = zza(i);
            this.zzb = this.zzd.zza(this.zzb);
            return zza2;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        zza();
        zzde.zzb(this.zzc >= 0, "no calls to next() since the last call to remove()");
        this.zza += 32;
        zzdp zzdp = this.zzd;
        zzdp.remove(zzdp.zzb[this.zzc]);
        this.zzb = zzdp.zzb(this.zzb, this.zzc);
        this.zzc = -1;
    }

    private final void zza() {
        if (this.zzd.zzf != this.zza) {
            throw new ConcurrentModificationException();
        }
    }

    /* synthetic */ zzdw(zzdp zzdp, zzds zzds) {
        this(zzdp);
    }
}
