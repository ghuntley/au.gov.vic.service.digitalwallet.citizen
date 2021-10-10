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

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
public final class zzan extends zzt<zzad> {
    private final zzam zza;

    public zzan(Context context, zzam zzam) {
        super(context, "TextNativeHandle", "ocr");
        this.zza = zzam;
        zzd();
    }

    public final zzah[] zza(Bitmap bitmap, zzs zzs, zzaj zzaj) {
        if (!zzb()) {
            return new zzah[0];
        }
        try {
            return ((zzad) Preconditions.checkNotNull((zzad) zzd())).zza(ObjectWrapper.wrap(bitmap), zzs, zzaj);
        } catch (RemoteException e) {
            Log.e("TextNativeHandle", "Error calling native text recognizer", e);
            return new zzah[0];
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.vision.zzt
    public final void zza() throws RemoteException {
        ((zzad) Preconditions.checkNotNull((zzad) zzd())).zzb();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.vision.zzt
    public final /* synthetic */ zzad zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException {
        zzaf zzaf;
        IBinder instantiate = dynamiteModule.instantiate("com.google.android.gms.vision.text.ChimeraNativeTextRecognizerCreator");
        if (instantiate == null) {
            zzaf = null;
        } else {
            IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator");
            if (queryLocalInterface instanceof zzaf) {
                zzaf = (zzaf) queryLocalInterface;
            } else {
                zzaf = new zzae(instantiate);
            }
        }
        if (zzaf == null) {
            return null;
        }
        return zzaf.zza(ObjectWrapper.wrap(context), (zzam) Preconditions.checkNotNull(this.zza));
    }
}
