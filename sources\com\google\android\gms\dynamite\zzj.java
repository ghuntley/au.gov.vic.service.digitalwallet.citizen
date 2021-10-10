package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final class zzj extends zzb implements zzk {
    zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, iObjectWrapper);
        a_.writeString(str);
        a_.writeInt(i);
        Parcel zza = zza(2, a_);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final int zza(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, iObjectWrapper);
        a_.writeString(str);
        zzd.zza(a_, z);
        Parcel zza = zza(3, a_);
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, iObjectWrapper);
        a_.writeString(str);
        a_.writeInt(i);
        Parcel zza = zza(4, a_);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final int zzb(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, iObjectWrapper);
        a_.writeString(str);
        zzd.zza(a_, z);
        Parcel zza = zza(5, a_);
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final int zzb() throws RemoteException {
        Parcel zza = zza(6, a_());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final IObjectWrapper zzc(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, iObjectWrapper);
        a_.writeString(str);
        zzd.zza(a_, z);
        Parcel zza = zza(7, a_);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, iObjectWrapper);
        a_.writeString(str);
        a_.writeInt(i);
        zzd.zza(a_, iObjectWrapper2);
        Parcel zza = zza(8, a_);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }
}
