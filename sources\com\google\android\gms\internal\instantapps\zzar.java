package com.google.android.gms.internal.instantapps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.Nullable;

public final class zzar extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzar> CREATOR = new zzau();
    private boolean zzce;
    @Nullable
    private String zzcf;
    private boolean zzcg;
    private boolean zzch;
    private boolean zzci;
    private boolean zzcj;
    private boolean zzck;

    zzar(boolean z, @Nullable String str, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.zzce = z;
        this.zzcf = str;
        this.zzcg = z2;
        this.zzch = z3;
        this.zzci = z4;
        this.zzcj = z5;
        this.zzck = z6;
    }

    public zzar() {
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zzce);
        SafeParcelWriter.writeString(parcel, 2, this.zzcf, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzcg);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzch);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzci);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzcj);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzck);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
