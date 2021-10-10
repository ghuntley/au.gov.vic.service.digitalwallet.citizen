package com.google.android.gms.internal.vision;

import java.util.AbstractCollection;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzdx extends AbstractCollection<V> {
    private final /* synthetic */ zzdp zza;

    zzdx(zzdp zzdp) {
        this.zza = zzdp;
    }

    public final int size() {
        return this.zza.size();
    }

    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<V> iterator() {
        return this.zza.zzg();
    }
}
