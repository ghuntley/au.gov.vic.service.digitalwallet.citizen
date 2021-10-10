package com.google.android.gms.internal.instantapps;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzv implements Parcelable.Creator<zzw> {
    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzw[] newArray(int i) {
        return new zzw[i];
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzw createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        int i2 = 0;
        int i3 = 0;
        String str = null;
        Intent intent = null;
        Intent intent2 = null;
        zzf zzf = null;
        zzap zzap = null;
        byte[] bArr = null;
        String str2 = null;
        String str3 = null;
        byte[] bArr2 = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 5:
                    intent = (Intent) SafeParcelReader.createParcelable(parcel, readHeader, Intent.CREATOR);
                    break;
                case 6:
                    intent2 = (Intent) SafeParcelReader.createParcelable(parcel, readHeader, Intent.CREATOR);
                    break;
                case 7:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 8:
                    zzf = (zzf) SafeParcelReader.createParcelable(parcel, readHeader, zzf.CREATOR);
                    break;
                case 9:
                    zzap = (zzap) SafeParcelReader.createParcelable(parcel, readHeader, zzap.CREATOR);
                    break;
                case 10:
                    z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 11:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 12:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 13:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 14:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 15:
                    bundle = SafeParcelReader.createBundle(parcel, readHeader);
                    break;
                case 16:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 17:
                    bArr2 = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzw(i, str, z, intent, intent2, zzf, zzap, z2, bArr, str2, i2, i3, str3, bArr2, bundle);
    }
}
