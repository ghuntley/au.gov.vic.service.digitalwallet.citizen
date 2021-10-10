package com.google.android.gms.internal.vision;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzed<E> extends zzdm<E> {
    private final zzee<E> zza;

    zzed(zzee<E> zzee, int i) {
        super(zzee.size(), i);
        this.zza = zzee;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.vision.zzdm
    public final E zza(int i) {
        return this.zza.get(i);
    }
}
