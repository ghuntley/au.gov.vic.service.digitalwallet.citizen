package com.google.android.gms.internal.vision;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.vision.barcode.Barcode;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
public final class zzm extends zzt<zzl> {
    private final zzk zza;

    public zzm(Context context, zzk zzk) {
        super(context, "BarcodeNativeHandle", "barcode");
        this.zza = zzk;
        zzd();
    }

    public final Barcode[] zza(ByteBuffer byteBuffer, zzs zzs) {
        if (!zzb()) {
            return new Barcode[0];
        }
        try {
            return ((zzl) Preconditions.checkNotNull((zzl) zzd())).zza(ObjectWrapper.wrap(byteBuffer), zzs);
        } catch (RemoteException e) {
            Log.e("BarcodeNativeHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }

    public final Barcode[] zza(Bitmap bitmap, zzs zzs) {
        if (!zzb()) {
            return new Barcode[0];
        }
        try {
            return ((zzl) Preconditions.checkNotNull((zzl) zzd())).zzb(ObjectWrapper.wrap(bitmap), zzs);
        } catch (RemoteException e) {
            Log.e("BarcodeNativeHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.vision.zzt
    public final void zza() throws RemoteException {
        if (zzb()) {
            ((zzl) Preconditions.checkNotNull((zzl) zzd())).zza();
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.vision.zzt
    public final /* synthetic */ zzl zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException {
        zzn zzn;
        IBinder instantiate = dynamiteModule.instantiate("com.google.android.gms.vision.barcode.ChimeraNativeBarcodeDetectorCreator");
        if (instantiate == null) {
            zzn = null;
        } else {
            IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
            if (queryLocalInterface instanceof zzn) {
                zzn = (zzn) queryLocalInterface;
            } else {
                zzn = new zzp(instantiate);
            }
        }
        if (zzn == null) {
            return null;
        }
        return zzn.zza(ObjectWrapper.wrap(context), (zzk) Preconditions.checkNotNull(this.zza));
    }
}
