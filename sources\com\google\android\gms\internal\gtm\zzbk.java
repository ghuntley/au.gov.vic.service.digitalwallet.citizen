package com.google.android.gms.internal.gtm;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzbk implements Parcelable {
    @Deprecated
    public static final Parcelable.Creator<zzbk> CREATOR = new zzbl();
    private String value;
    private String zzno;
    private String zzyj;

    @Deprecated
    public final int describeContents() {
        return 0;
    }

    public final String getId() {
        return this.zzno;
    }

    public final String getValue() {
        return this.value;
    }

    @Deprecated
    public zzbk() {
    }

    @Deprecated
    zzbk(Parcel parcel) {
        this.zzno = parcel.readString();
        this.zzyj = parcel.readString();
        this.value = parcel.readString();
    }

    @Deprecated
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzno);
        parcel.writeString(this.zzyj);
        parcel.writeString(this.value);
    }
}
