package com.google.android.gms.internal.vision;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzmb implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zzlz zzb;

    zzmb(zzlz zzlz) {
        this.zzb = zzlz;
        this.zza = zzlz.zza.iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zza.next();
    }
}
