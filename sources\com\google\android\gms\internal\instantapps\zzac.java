package com.google.android.gms.internal.instantapps;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.instantapps.zzf;

final class zzac implements zzf {
    private final /* synthetic */ Status zzbg;

    zzac(zzz zzz, Status status) {
        this.zzbg = status;
    }

    @Override // com.google.android.gms.instantapps.zzf
    public final ParcelFileDescriptor zzc() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzbg;
    }
}
