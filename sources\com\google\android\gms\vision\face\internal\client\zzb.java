package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.graphics.PointF;
import android.media.Image;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.internal.vision.zzt;
import com.google.android.gms.internal.vision.zzu;
import com.google.android.gms.vision.face.Contour;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
public final class zzb extends zzt<zzh> {
    private final zzf zza;

    public zzb(Context context, zzf zzf) {
        super(context, "FaceNativeHandle", "face");
        this.zza = zzf;
        zzd();
    }

    public final Face[] zza(ByteBuffer byteBuffer, zzs zzs) {
        if (!zzb()) {
            return new Face[0];
        }
        try {
            FaceParcel[] zza2 = ((zzh) Preconditions.checkNotNull((zzh) zzd())).zza(ObjectWrapper.wrap(byteBuffer), zzs);
            Face[] faceArr = new Face[zza2.length];
            for (int i = 0; i < zza2.length; i++) {
                faceArr[i] = zza(zza2[i]);
            }
            return faceArr;
        } catch (RemoteException e) {
            Log.e("FaceNativeHandle", "Could not call native face detector", e);
            return new Face[0];
        }
    }

    public final Face[] zza(Image.Plane[] planeArr, zzs zzs) {
        if (!zzb()) {
            Log.e("FaceNativeHandle", "Native handle is not ready to be used.");
            return new Face[0];
        } else if (planeArr == null || planeArr.length == 3) {
            try {
                FaceParcel[] zza2 = ((zzh) Preconditions.checkNotNull((zzh) zzd())).zza(ObjectWrapper.wrap(planeArr[0].getBuffer()), ObjectWrapper.wrap(planeArr[1].getBuffer()), ObjectWrapper.wrap(planeArr[2].getBuffer()), planeArr[0].getPixelStride(), planeArr[1].getPixelStride(), planeArr[2].getPixelStride(), planeArr[0].getRowStride(), planeArr[1].getRowStride(), planeArr[2].getRowStride(), zzs);
                Face[] faceArr = new Face[zza2.length];
                for (int i = 0; i < zza2.length; i++) {
                    faceArr[i] = zza(zza2[i]);
                }
                return faceArr;
            } catch (RemoteException e) {
                Log.e("FaceNativeHandle", "Could not call native face detector", e);
                return new Face[0];
            }
        } else {
            throw new IllegalArgumentException("Only android.graphics.ImageFormat#YUV_420_888 is supported which should have 3 planes.");
        }
    }

    public final boolean zza(int i) {
        if (!zzb()) {
            return false;
        }
        try {
            return ((zzh) Preconditions.checkNotNull((zzh) zzd())).zza(i);
        } catch (RemoteException e) {
            Log.e("FaceNativeHandle", "Could not call native face detector", e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.vision.zzt
    public final void zza() throws RemoteException {
        ((zzh) Preconditions.checkNotNull((zzh) zzd())).zza();
    }

    private static Face zza(FaceParcel faceParcel) {
        Landmark[] landmarkArr;
        Contour[] contourArr;
        int i = faceParcel.zza;
        PointF pointF = new PointF(faceParcel.zzb, faceParcel.zzc);
        float f = faceParcel.zzd;
        float f2 = faceParcel.zze;
        float f3 = faceParcel.zzf;
        float f4 = faceParcel.zzg;
        float f5 = faceParcel.zzh;
        LandmarkParcel[] landmarkParcelArr = faceParcel.zzi;
        if (landmarkParcelArr == null) {
            landmarkArr = new Landmark[0];
        } else {
            Landmark[] landmarkArr2 = new Landmark[landmarkParcelArr.length];
            int i2 = 0;
            while (i2 < landmarkParcelArr.length) {
                LandmarkParcel landmarkParcel = landmarkParcelArr[i2];
                landmarkArr2[i2] = new Landmark(new PointF(landmarkParcel.zza, landmarkParcel.zzb), landmarkParcel.zzc);
                i2++;
                landmarkParcelArr = landmarkParcelArr;
            }
            landmarkArr = landmarkArr2;
        }
        zza[] zzaArr = faceParcel.zzm;
        if (zzaArr == null) {
            contourArr = new Contour[0];
        } else {
            Contour[] contourArr2 = new Contour[zzaArr.length];
            for (int i3 = 0; i3 < zzaArr.length; i3++) {
                zza zza2 = zzaArr[i3];
                contourArr2[i3] = new Contour(zza2.zza, zza2.zzb);
            }
            contourArr = contourArr2;
        }
        return new Face(i, pointF, f, f2, f3, f4, f5, landmarkArr, contourArr, faceParcel.zzj, faceParcel.zzk, faceParcel.zzl, faceParcel.zzn);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.vision.zzt
    public final /* synthetic */ zzh zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException {
        zzi zzi;
        if (zzu.zza(context, "com.google.android.gms.vision.dynamite.face")) {
            zzi = zzl.asInterface(dynamiteModule.instantiate("com.google.android.gms.vision.face.NativeFaceDetectorV2Creator"));
        } else {
            zzi = zzl.asInterface(dynamiteModule.instantiate("com.google.android.gms.vision.face.ChimeraNativeFaceDetectorCreator"));
        }
        if (zzi == null) {
            return null;
        }
        return zzi.newFaceDetector(ObjectWrapper.wrap(context), (zzf) Preconditions.checkNotNull(this.zza));
    }
}
