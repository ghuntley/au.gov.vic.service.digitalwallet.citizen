package com.google.android.gms.internal.vision;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzev<E> extends zzej<E> {
    static final zzev<Object> zza = new zzev<>(new Object[0], 0, null, 0, 0);
    private final transient Object[] zzb;
    private final transient Object[] zzc;
    private final transient int zzd;
    private final transient int zze;
    private final transient int zzf;

    zzev(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzb = objArr;
        this.zzc = objArr2;
        this.zzd = i2;
        this.zze = i;
        this.zzf = i3;
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

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzej
    public final boolean zzg() {
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.zzc;
        if (obj == null || objArr == null) {
            return false;
        }
        int zza2 = zzec.zza(obj);
        while (true) {
            int i = zza2 & this.zzd;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            zza2 = i + 1;
        }
    }

    public final int size() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final zzfa<E> zza() {
        return (zzfa) zze().iterator();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzeb
    public final Object[] zzb() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzeb
    public final int zzd() {
        return this.zzf;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzeb
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, i, this.zzf);
        return i + this.zzf;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzej
    public final zzee<E> zzh() {
        return zzee.zzb(this.zzb, this.zzf);
    }

    @Override // com.google.android.gms.internal.vision.zzej
    public final int hashCode() {
        return this.zze;
    }

    @Override // java.util.AbstractCollection, com.google.android.gms.internal.vision.zzeb, java.util.Collection, java.util.Set, java.lang.Iterable, com.google.android.gms.internal.vision.zzej
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
