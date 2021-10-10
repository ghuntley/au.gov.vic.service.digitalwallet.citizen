package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
public final class zzd implements Parcelable.Creator<FaceParcel> {
    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FaceParcel[] newArray(int i) {
        return new FaceParcel[i];
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FaceParcel createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        LandmarkParcel[] landmarkParcelArr = null;
        zza[] zzaArr = null;
        int i = 0;
        int i2 = 0;
        float f = Float.MAX_VALUE;
        float f2 = Float.MAX_VALUE;
        float f3 = Float.MAX_VALUE;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = -1.0f;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    f4 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 4:
                    f5 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 5:
                    f6 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 6:
                    f7 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 7:
                    f = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 8:
                    f2 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 9:
                    landmarkParcelArr = (LandmarkParcel[]) SafeParcelReader.createTypedArray(parcel, readHeader, LandmarkParcel.CREATOR);
                    break;
                case 10:
                    f8 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 11:
                    f9 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 12:
                    f10 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 13:
                    zzaArr = (zza[]) SafeParcelReader.createTypedArray(parcel, readHeader, zza.CREATOR);
                    break;
                case 14:
                    f3 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 15:
                    f11 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new FaceParcel(i, i2, f4, f5, f6, f7, f, f2, f3, landmarkParcelArr, f8, f9, f10, zzaArr, f11);
    }
}
