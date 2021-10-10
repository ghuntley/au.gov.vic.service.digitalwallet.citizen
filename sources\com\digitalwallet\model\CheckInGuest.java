package com.digitalwallet.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0007\u001a\u00020\u0003¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006 "}, d2 = {"Lcom/digitalwallet/model/CheckInGuest;", "Landroid/os/Parcelable;", "firstName", "", "lastName", "phoneNumber", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "abbreviatedFullName", "getAbbreviatedFullName$annotations", "()V", "getAbbreviatedFullName", "()Ljava/lang/String;", "getFirstName", "getLastName", "getPhoneNumber", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckIn.kt */
public final class CheckInGuest implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String abbreviatedFullName = ((String) new CheckInGuest$abbreviatedFullName$1(this).invoke());
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new CheckInGuest(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new CheckInGuest[i];
        }
    }

    public static /* synthetic */ CheckInGuest copy$default(CheckInGuest checkInGuest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = checkInGuest.firstName;
        }
        if ((i & 2) != 0) {
            str2 = checkInGuest.lastName;
        }
        if ((i & 4) != 0) {
            str3 = checkInGuest.phoneNumber;
        }
        return checkInGuest.copy(str, str2, str3);
    }

    public static /* synthetic */ void getAbbreviatedFullName$annotations() {
    }

    public final String component1() {
        return this.firstName;
    }

    public final String component2() {
        return this.lastName;
    }

    public final String component3() {
        return this.phoneNumber;
    }

    public final CheckInGuest copy(@Json(name = "firstName") String str, @Json(name = "lastName") String str2, @Json(name = "contactNumber") String str3) {
        return new CheckInGuest(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckInGuest)) {
            return false;
        }
        CheckInGuest checkInGuest = (CheckInGuest) obj;
        return Intrinsics.areEqual(this.firstName, checkInGuest.firstName) && Intrinsics.areEqual(this.lastName, checkInGuest.lastName) && Intrinsics.areEqual(this.phoneNumber, checkInGuest.phoneNumber);
    }

    public int hashCode() {
        String str = this.firstName;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.lastName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.phoneNumber;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "CheckInGuest(firstName=" + this.firstName + ", lastName=" + this.lastName + ", phoneNumber=" + this.phoneNumber + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.firstName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.phoneNumber);
    }

    public CheckInGuest(@Json(name = "firstName") String str, @Json(name = "lastName") String str2, @Json(name = "contactNumber") String str3) {
        this.firstName = str;
        this.lastName = str2;
        this.phoneNumber = str3;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getAbbreviatedFullName() {
        return this.abbreviatedFullName;
    }
}
