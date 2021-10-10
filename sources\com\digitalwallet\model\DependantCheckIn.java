package com.digitalwallet.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/digitalwallet/model/DependantCheckIn;", "Landroid/os/Parcelable;", "guestPayload", "Lcom/digitalwallet/model/CheckInGuest;", "internalId", "", "shouldSave", "", "(Lcom/digitalwallet/model/CheckInGuest;Ljava/lang/String;Z)V", "getGuestPayload", "()Lcom/digitalwallet/model/CheckInGuest;", "getInternalId", "()Ljava/lang/String;", "getShouldSave", "()Z", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckIn.kt */
public final class DependantCheckIn implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final CheckInGuest guestPayload;
    private final String internalId;
    private final boolean shouldSave;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DependantCheckIn((CheckInGuest) CheckInGuest.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new DependantCheckIn[i];
        }
    }

    public static /* synthetic */ DependantCheckIn copy$default(DependantCheckIn dependantCheckIn, CheckInGuest checkInGuest, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            checkInGuest = dependantCheckIn.guestPayload;
        }
        if ((i & 2) != 0) {
            str = dependantCheckIn.internalId;
        }
        if ((i & 4) != 0) {
            z = dependantCheckIn.shouldSave;
        }
        return dependantCheckIn.copy(checkInGuest, str, z);
    }

    public final CheckInGuest component1() {
        return this.guestPayload;
    }

    public final String component2() {
        return this.internalId;
    }

    public final boolean component3() {
        return this.shouldSave;
    }

    public final DependantCheckIn copy(CheckInGuest checkInGuest, String str, boolean z) {
        Intrinsics.checkNotNullParameter(checkInGuest, "guestPayload");
        Intrinsics.checkNotNullParameter(str, "internalId");
        return new DependantCheckIn(checkInGuest, str, z);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DependantCheckIn)) {
            return false;
        }
        DependantCheckIn dependantCheckIn = (DependantCheckIn) obj;
        return Intrinsics.areEqual(this.guestPayload, dependantCheckIn.guestPayload) && Intrinsics.areEqual(this.internalId, dependantCheckIn.internalId) && this.shouldSave == dependantCheckIn.shouldSave;
    }

    public int hashCode() {
        CheckInGuest checkInGuest = this.guestPayload;
        int i = 0;
        int hashCode = (checkInGuest != null ? checkInGuest.hashCode() : 0) * 31;
        String str = this.internalId;
        if (str != null) {
            i = str.hashCode();
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
        return "DependantCheckIn(guestPayload=" + this.guestPayload + ", internalId=" + this.internalId + ", shouldSave=" + this.shouldSave + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.guestPayload.writeToParcel(parcel, 0);
        parcel.writeString(this.internalId);
        parcel.writeInt(this.shouldSave ? 1 : 0);
    }

    public DependantCheckIn(CheckInGuest checkInGuest, String str, boolean z) {
        Intrinsics.checkNotNullParameter(checkInGuest, "guestPayload");
        Intrinsics.checkNotNullParameter(str, "internalId");
        this.guestPayload = checkInGuest;
        this.internalId = str;
        this.shouldSave = z;
    }

    public final CheckInGuest getGuestPayload() {
        return this.guestPayload;
    }

    public final String getInternalId() {
        return this.internalId;
    }

    public final boolean getShouldSave() {
        return this.shouldSave;
    }
}
