package com.google.android.gms.internal.vision;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzdr extends zzdw<Map.Entry<K, V>> {
    private final /* synthetic */ zzdp zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdr(zzdp zzdp) {
        super(zzdp, null);
        this.zza = zzdp;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzdw
    public final /* synthetic */ Object zza(int i) {
        return new zzdy(this.zza, i);
    }
}
