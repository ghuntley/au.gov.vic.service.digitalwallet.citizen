package com.google.android.gms.internal.vision;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzep<E> extends zzee<E> {
    static final zzee<Object> zza = new zzep(new Object[0], 0);
    private final transient Object[] zzb;
    private final transient int zzc;

    zzep(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzeb
    public final int zzc() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean zzf() {
        return false;
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzeb
    public final Object[] zzb() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzeb
    public final int zzd() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzee, com.google.android.gms.internal.vision.zzeb
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, i, this.zzc);
        return i + this.zzc;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzde.zza(i, this.zzc);
        return (E) this.zzb[i];
    }
}
