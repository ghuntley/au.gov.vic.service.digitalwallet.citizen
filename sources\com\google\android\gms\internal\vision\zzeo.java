package com.google.android.gms.internal.vision;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzeo extends zzfa<T> {
    private boolean zza;
    private final /* synthetic */ Object zzb;

    zzeo(Object obj) {
        this.zzb = obj;
    }

    public final boolean hasNext() {
        return !this.zza;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!this.zza) {
            this.zza = true;
            return (T) this.zzb;
        }
        throw new NoSuchElementException();
    }
}
