package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzer<K, V> extends zzej<Map.Entry<K, V>> {
    private final transient zzef<K, V> zza;
    private final transient Object[] zzb;
    private final transient int zzc = 0;
    private final transient int zzd;

    zzer(zzef<K, V> zzef, Object[] objArr, int i, int i2) {
        this.zza = zzef;
        this.zzb = objArr;
        this.zzd = i2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final zzfa<Map.Entry<K, V>> zza() {
        return (zzfa) zze().iterator();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzeb
    public final int zza(Object[] objArr, int i) {
        return zze().zza(objArr, i);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzej
    public final zzee<Map.Entry<K, V>> zzh() {
        return new zzeu(this);
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.zza.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int size() {
        return this.zzd;
    }

    @Override // java.util.AbstractCollection, com.google.android.gms.internal.vision.zzeb, java.util.Collection, java.util.Set, java.lang.Iterable, com.google.android.gms.internal.vision.zzej
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
