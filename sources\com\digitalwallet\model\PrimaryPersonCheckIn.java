package com.digitalwallet.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/digitalwallet/model/PrimaryPersonCheckIn;", "Landroid/os/Parcelable;", "checkInPayload", "Lcom/digitalwallet/model/CheckIn;", "checkInCode", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "shouldSave", "", "(Lcom/digitalwallet/model/CheckIn;Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;Z)V", "getCheckInCode", "()Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "getCheckInPayload", "()Lcom/digitalwallet/model/CheckIn;", "getShouldSave", "()Z", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckIn.kt */
public final class PrimaryPersonCheckIn implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final CheckInUtils.CheckInCode checkInCode;
    private final CheckIn checkInPayload;
    private final boolean shouldSave;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new PrimaryPersonCheckIn((CheckIn) CheckIn.CREATOR.createFromParcel(parcel), (CheckInUtils.CheckInCode) CheckInUtils.CheckInCode.CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new PrimaryPersonCheckIn[i];
        }
    }

    public static /* synthetic */ PrimaryPersonCheckIn copy$default(PrimaryPersonCheckIn primaryPersonCheckIn, CheckIn checkIn, CheckInUtils.CheckInCode checkInCode2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            checkIn = primaryPersonCheckIn.checkInPayload;
        }
        if ((i & 2) != 0) {
            checkInCode2 = primaryPersonCheckIn.checkInCode;
        }
        if ((i & 4) != 0) {
            z = primaryPersonCheckIn.shouldSave;
        }
        return primaryPersonCheckIn.copy(checkIn, checkInCode2, z);
    }

    public final CheckIn component1() {
        return this.checkInPayload;
    }

    public final CheckInUtils.CheckInCode component2() {
        return this.checkInCode;
    }

    public final boolean component3() {
        return this.shouldSave;
    }

    public final PrimaryPersonCheckIn copy(CheckIn checkIn, CheckInUtils.CheckInCode checkInCode2, boolean z) {
        Intrinsics.checkNotNullParameter(checkIn, "checkInPayload");
        Intrinsics.checkNotNullParameter(checkInCode2, "checkInCode");
        return new PrimaryPersonCheckIn(checkIn, checkInCode2, z);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrimaryPersonCheckIn)) {
            return false;
        }
        PrimaryPersonCheckIn primaryPersonCheckIn = (PrimaryPersonCheckIn) obj;
        return Intrinsics.areEqual(this.checkInPayload, primaryPersonCheckIn.checkInPayload) && Intrinsics.areEqual(this.checkInCode, primaryPersonCheckIn.checkInCode) && this.shouldSave == primaryPersonCheckIn.shouldSave;
    }

    public int hashCode() {
        CheckIn checkIn = this.checkInPayload;
        int i = 0;
        int hashCode = (checkIn != null ? checkIn.hashCode() : 0) * 31;
        CheckInUtils.CheckInCode checkInCode2 = this.checkInCode;
        if (checkInCode2 != null) {
            i = checkInCode2.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.shouldSave;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    public String toString() {
        return "PrimaryPersonCheckIn(checkInPayload=" + this.checkInPayload + ", checkInCode=" + this.checkInCode + ", shouldSave=" + this.shouldSave + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.checkInPayload.writeToParcel(parcel, 0);
        this.checkInCode.writeToParcel(parcel, 0);
        parcel.writeInt(this.shouldSave ? 1 : 0);
    }

    public PrimaryPersonCheckIn(CheckIn checkIn, CheckInUtils.CheckInCode checkInCode2, boolean z) {
        Intrinsics.checkNotNullParameter(checkIn, "checkInPayload");
        Intrinsics.checkNotNullParameter(checkInCode2, "checkInCode");
        this.checkInPayload = checkIn;
        this.checkInCode = checkInCode2;
        this.shouldSave = z;
    }

    public final CheckIn getCheckInPayload() {
        return this.checkInPayload;
    }

    public final CheckInUtils.CheckInCode getCheckInCode() {
        return this.checkInCode;
    }

    public final boolean getShouldSave() {
        return this.shouldSave;
    }
}
