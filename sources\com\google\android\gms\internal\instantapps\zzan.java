package com.google.android.gms.internal.instantapps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzan> CREATOR = new zzaq();
    private final String[] zzbs;
    private final String[] zzbt;
    private final String[] zzbu;
    private final String[] zzbv;

    public zzan(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        this.zzbs = strArr;
        this.zzbt = strArr2;
        this.zzbv = strArr3;
        this.zzbu = strArr4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.zzbs, false);
        SafeParcelWriter.writeStringArray(parcel, 2, this.zzbt, false);
        SafeParcelWriter.writeStringArray(parcel, 3, this.zzbu, false);
        SafeParcelWriter.writeStringArray(parcel, 4, this.zzbv, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
