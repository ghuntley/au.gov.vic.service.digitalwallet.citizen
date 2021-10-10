package com.digitalwallet.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class CheckIn implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private Date date;
    private final String eventID;
    private final String firstName;
    private List<CheckInGuest> guests;
    private final String lastName;
    private String locationName;
    private final String phoneNumber;
    private final String type;

    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            Date date = (Date) parcel.readSerializable();
            String readString5 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((CheckInGuest) CheckInGuest.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new CheckIn(readString, readString2, readString3, readString4, date, readString5, arrayList, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new CheckIn[i];
        }
    }

    public static /* synthetic */ CheckIn copy$default(CheckIn checkIn, String str, String str2, String str3, String str4, Date date2, String str5, List list, String str6, int i, Object obj) {
        return checkIn.copy((i & 1) != 0 ? checkIn.locationName : str, (i & 2) != 0 ? checkIn.firstName : str2, (i & 4) != 0 ? checkIn.lastName : str3, (i & 8) != 0 ? checkIn.phoneNumber : str4, (i & 16) != 0 ? checkIn.date : date2, (i & 32) != 0 ? checkIn.eventID : str5, (i & 64) != 0 ? checkIn.guests : list, (i & 128) != 0 ? checkIn.type : str6);
    }

    public final String component1() {
        return this.locationName;
    }

    public final String component2() {
        return this.firstName;
    }

    public final String component3() {
        return this.lastName;
    }

    public final String component4() {
        return this.phoneNumber;
    }

    public final Date component5() {
        return this.date;
    }

    public final String component6() {
        return this.eventID;
    }

    public final List<CheckInGuest> component7() {
        return this.guests;
    }

    public final String component8() {
        return this.type;
    }

    public final CheckIn copy(String str, String str2, String str3, String str4, Date date2, String str5, List<CheckInGuest> list, String str6) {
        return new CheckIn(str, str2, str3, str4, date2, str5, list, str6);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckIn)) {
            return false;
        }
        CheckIn checkIn = (CheckIn) obj;
        return Intrinsics.areEqual(this.locationName, checkIn.locationName) && Intrinsics.areEqual(this.firstName, checkIn.firstName) && Intrinsics.areEqual(this.lastName, checkIn.lastName) && Intrinsics.areEqual(this.phoneNumber, checkIn.phoneNumber) && Intrinsics.areEqual(this.date, checkIn.date) && Intrinsics.areEqual(this.eventID, checkIn.eventID) && Intrinsics.areEqual(this.guests, checkIn.guests) && Intrinsics.areEqual(this.type, checkIn.type);
    }

    public int hashCode() {
        String str = this.locationName;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.firstName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.lastName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.phoneNumber;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Date date2 = this.date;
        int hashCode5 = (hashCode4 + (date2 != null ? date2.hashCode() : 0)) * 31;
        String str5 = this.eventID;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        List<CheckInGuest> list = this.guests;
        int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 0)) * 31;
        String str6 = this.type;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "CheckIn(locationName=" + this.locationName + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", phoneNumber=" + this.phoneNumber + ", date=" + this.date + ", eventID=" + this.eventID + ", guests=" + this.guests + ", type=" + this.type + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.locationName);
        parcel.writeString(this.firstName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.phoneNumber);
        parcel.writeSerializable(this.date);
        parcel.writeString(this.eventID);
        List<CheckInGuest> list = this.guests;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (CheckInGuest checkInGuest : list) {
                checkInGuest.writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.type);
    }

    public CheckIn(String str, String str2, String str3, String str4, Date date2, String str5, List<CheckInGuest> list, String str6) {
        this.locationName = str;
        this.firstName = str2;
        this.lastName = str3;
        this.phoneNumber = str4;
        this.date = date2;
        this.eventID = str5;
        this.guests = list;
        this.type = str6;
    }

    public final String getLocationName() {
        return this.locationName;
    }

    public final void setLocationName(String str) {
        this.locationName = str;
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

    public final Date getDate() {
        return this.date;
    }

    public final void setDate(Date date2) {
        this.date = date2;
    }

    public final String getEventID() {
        return this.eventID;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CheckIn(String str, String str2, String str3, String str4, Date date2, String str5, List list, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, date2, str5, (i & 64) != 0 ? CollectionsKt.emptyList() : list, (i & 128) != 0 ? "APP" : str6);
    }

    public final List<CheckInGuest> getGuests() {
        return this.guests;
    }

    public final void setGuests(List<CheckInGuest> list) {
        this.guests = list;
    }

    public final String getType() {
        return this.type;
    }
}
