package com.google.android.gms.internal.vision;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzdv extends AbstractSet<K> {
    private final /* synthetic */ zzdp zza;

    zzdv(zzdp zzdp) {
        this.zza = zzdp;
    }

    public final int size() {
        return this.zza.size();
    }

    public final boolean contains(Object obj) {
        return this.zza.containsKey(obj);
    }

    public final boolean remove(@NullableDecl Object obj) {
        Map zzb = this.zza.zzb();
        if (zzb != null) {
            return zzb.keySet().remove(obj);
        }
        return zzdp.zza(this.zza, obj) != zzdp.zzh();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<K> iterator() {
        return this.zza.zze();
    }

    public final void clear() {
        this.zza.clear();
    }
}
