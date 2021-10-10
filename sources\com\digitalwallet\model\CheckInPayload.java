package com.digitalwallet.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/digitalwallet/model/CheckInPayload;", "Landroid/os/Parcelable;", "jws", "", "checkInList", "Lcom/digitalwallet/model/CheckIn;", "(Ljava/lang/String;Lcom/digitalwallet/model/CheckIn;)V", "getCheckInList", "()Lcom/digitalwallet/model/CheckIn;", "getJws", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckIn.kt */
public final class CheckInPayload implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final CheckIn checkInList;
    private final String jws;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new CheckInPayload(parcel.readString(), (CheckIn) CheckIn.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new CheckInPayload[i];
        }
    }

    public static /* synthetic */ CheckInPayload copy$default(CheckInPayload checkInPayload, String str, CheckIn checkIn, int i, Object obj) {
        if ((i & 1) != 0) {
            str = checkInPayload.jws;
        }
        if ((i & 2) != 0) {
            checkIn = checkInPayload.checkInList;
        }
        return checkInPayload.copy(str, checkIn);
    }

    public final String component1() {
        return this.jws;
    }

    public final CheckIn component2() {
        return this.checkInList;
    }

    public final CheckInPayload copy(@Json(name = "jws") String str, @Json(name = "checkInList") CheckIn checkIn) {
        Intrinsics.checkNotNullParameter(str, "jws");
        Intrinsics.checkNotNullParameter(checkIn, "checkInList");
        return new CheckInPayload(str, checkIn);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckInPayload)) {
            return false;
        }
        CheckInPayload checkInPayload = (CheckInPayload) obj;
        return Intrinsics.areEqual(this.jws, checkInPayload.jws) && Intrinsics.areEqual(this.checkInList, checkInPayload.checkInList);
    }

    public int hashCode() {
        String str = this.jws;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        CheckIn checkIn = this.checkInList;
        if (checkIn != null) {
            i = checkIn.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CheckInPayload(jws=" + this.jws + ", checkInList=" + this.checkInList + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.jws);
        this.checkInList.writeToParcel(parcel, 0);
    }

    public CheckInPayload(@Json(name = "jws") String str, @Json(name = "checkInList") CheckIn checkIn) {
        Intrinsics.checkNotNullParameter(str, "jws");
        Intrinsics.checkNotNullParameter(checkIn, "checkInList");
        this.jws = str;
        this.checkInList = checkIn;
    }

    public final String getJws() {
        return this.jws;
    }

    public final CheckIn getCheckInList() {
        return this.checkInList;
    }
}
