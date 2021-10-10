package com.google.android.gms.internal.vision;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzet<K> extends zzej<K> {
    private final transient zzef<K, ?> zza;
    private final transient zzee<K> zzb;

    zzet(zzef<K, ?> zzef, zzee<K> zzee) {
        this.zza = zzef;
        this.zzb = zzee;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final zzfa<K> zza() {
        return (zzfa) zze().iterator();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzeb
    public final int zza(Object[] objArr, int i) {
        return zze().zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.vision.zzeb, com.google.android.gms.internal.vision.zzej
    public final zzee<K> zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean contains(@NullableDecl Object obj) {
        return this.zza.get(obj) != null;
    }

    public final int size() {
        return this.zza.size();
    }

    @Override // java.util.AbstractCollection, com.google.android.gms.internal.vision.zzeb, java.util.Collection, java.util.Set, java.lang.Iterable, com.google.android.gms.internal.vision.zzej
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
