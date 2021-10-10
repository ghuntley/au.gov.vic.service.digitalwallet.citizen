package com.google.android.gms.internal.instantapps;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzam> CREATOR = new zzal();
    private final int zzao;
    private final String zzas;
    @Deprecated
    private final Account[] zzbr;

    zzam(int i, String str, Account[] accountArr) {
        this.zzao = i;
        this.zzas = str;
        this.zzbr = accountArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzao);
        SafeParcelWriter.writeString(parcel, 3, this.zzas, false);
        SafeParcelWriter.writeTypedArray(parcel, 4, this.zzbr, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
