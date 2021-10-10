package com.google.android.gms.internal.vision;

import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzeg extends zzee<E> {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzee zzc;

    zzeg(zzee zzee, int i, int i2) {
        this.zzc = zzee;
        this.zza = i;
        this.zzb = i2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean zzf() {
        return true;
    }

    public final int size() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzeb
    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzeb
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzeb
    public final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzde.zza(i, this.zzb);
        return (E) this.zzc.get(i + this.zza);
    }

    @Override // com.google.android.gms.internal.vision.zzee
    public final zzee<E> zza(int i, int i2) {
        zzde.zza(i, i2, this.zzb);
        zzee zzee = this.zzc;
        int i3 = this.zza;
        return (zzee) zzee.subList(i + i3, i2 + i3);
    }

    @Override // com.google.android.gms.internal.vision.zzee, java.util.List
    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
