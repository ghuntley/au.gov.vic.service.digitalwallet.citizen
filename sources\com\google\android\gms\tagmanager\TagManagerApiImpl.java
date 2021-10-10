package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.gtm.zzev;
import com.google.android.gms.internal.gtm.zzfb;
import com.google.android.gms.internal.gtm.zzfy;

public class TagManagerApiImpl extends zzcq {
    private zzfy zzalj;

    @Override // com.google.android.gms.tagmanager.zzcp
    public void initialize(IObjectWrapper iObjectWrapper, zzcm zzcm, zzcd zzcd) throws RemoteException {
        zzfy zza = zzfy.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzcm, zzcd);
        this.zzalj = zza;
        zza.zzb((String[]) null);
    }

    @Override // com.google.android.gms.tagmanager.zzcp
    @Deprecated
    public void preview(Intent intent, IObjectWrapper iObjectWrapper) {
        zzev.zzac("Deprecated. Please use previewIntent instead.");
    }

    @Override // com.google.android.gms.tagmanager.zzcp
    public void previewIntent(Intent intent, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, zzcm zzcm, zzcd zzcd) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfy zza = zzfy.zza(context, zzcm, zzcd);
        this.zzalj = zza;
        new zzfb(intent, context, (Context) ObjectWrapper.unwrap(iObjectWrapper2), zza).zzkq();
    }
}
