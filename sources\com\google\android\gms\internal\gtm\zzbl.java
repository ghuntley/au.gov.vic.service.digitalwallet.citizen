package com.google.android.gms.internal.gtm;

import android.os.Parcel;
import android.os.Parcelable;

final class zzbl implements Parcelable.Creator<zzbk> {
    zzbl() {
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    @Deprecated
    public final /* synthetic */ zzbk[] newArray(int i) {
        return new zzbk[i];
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    @Deprecated
    public final /* synthetic */ zzbk createFromParcel(Parcel parcel) {
        return new zzbk(parcel);
    }
}
