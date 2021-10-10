package com.google.android.gms.internal.gtm;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tagmanager.zzcm;
import java.util.Map;

public final class zzmh extends zzhb {
    private final zzfj zzapc;
    private final zzcm zzasa;

    public zzmh(zzcm zzcm, zzfj zzfj) {
        this.zzasa = zzcm;
        this.zzapc = zzfj;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 1 || zzoaArr.length == 2);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        zzog zzog = zzoaArr.length > 1 ? zzoaArr[1] : zzog.zzaum;
        if (zzog != zzog.zzaum && !(zzog instanceof zzok)) {
            z = false;
        }
        Preconditions.checkArgument(z);
        zzee zzkt = this.zzapc.zzkt();
        String str = (String) ((zzom) zzoaArr[0]).value();
        Bundle bundle = null;
        if (zzog != zzog.zzaum) {
            bundle = zzoo.zzk((Map) ((zzok) zzog).value());
        }
        try {
            this.zzasa.logEventInternalNoInterceptor(zzkt.zzkh(), str, bundle, zzkt.currentTimeMillis());
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzev.zzav(valueOf.length() != 0 ? "Error calling measurement proxy:".concat(valueOf) : new String("Error calling measurement proxy:"));
        }
        return zzog.zzaum;
    }
}
