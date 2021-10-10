package com.google.android.gms.internal.location;

import android.os.DeadObjectException;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public final class zzk implements zzbi<zzal> {
    private final /* synthetic */ zzh zza;

    zzk(zzh zzh) {
        this.zza = zzh;
    }

    @Override // com.google.android.gms.internal.location.zzbi
    public final void zza() {
        this.zza.checkConnected();
    }

    /* Return type fixed from 'android.os.IInterface' to match base method */
    @Override // com.google.android.gms.internal.location.zzbi
    public final /* synthetic */ zzal zzb() throws DeadObjectException {
        return (zzal) this.zza.getService();
    }
}
