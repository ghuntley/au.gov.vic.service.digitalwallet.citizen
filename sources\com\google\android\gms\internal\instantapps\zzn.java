package com.google.android.gms.internal.instantapps;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new zzq();
    private final int zzam;
    private final long zzan;
    private final int zzao;
    private final Account zzap;
    private final Account[] zzaq;

    public zzn(int i, long j, int i2, Account account, Account[] accountArr) {
        this.zzam = i;
        this.zzan = j;
        this.zzao = i2;
        this.zzap = account;
        this.zzaq = accountArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzam);
        SafeParcelWriter.writeLong(parcel, 3, this.zzan);
        SafeParcelWriter.writeInt(parcel, 4, this.zzao);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzap, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 6, this.zzaq, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
