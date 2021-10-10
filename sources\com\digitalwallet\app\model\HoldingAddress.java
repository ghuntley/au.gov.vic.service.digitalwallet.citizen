package com.digitalwallet.app.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010*\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020,HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001J\u0019\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020,HÖ\u0001J\u001e\u00108\u001a\u00020\u0003*\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003092\b\b\u0002\u0010:\u001a\u00020\u0003H\u0002R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00038F¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0015\u001a\u00020\u0003¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u0017\u0010\u0019\u001a\u00020\u0003¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\fR\u0017\u0010\u001d\u001a\u00020\u0003¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\fR\u0017\u0010 \u001a\u00020\u0003¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\f¨\u0006;"}, d2 = {"Lcom/digitalwallet/app/model/HoldingAddress;", "Landroid/os/Parcelable;", "country", "", "streetName", "houseNumber", "postCode", "state", "suburb", "addressLine", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddressLine", "()Ljava/lang/String;", "getCountry", "getHouseNumber", "getPostCode", "standardFormatAddress", "getStandardFormatAddress$annotations", "()V", "getStandardFormatAddress", "getState", "stateAndPostcode", "getStateAndPostcode$annotations", "getStateAndPostcode", "getStreetName", "streetNumberAndName", "getStreetNumberAndName$annotations", "getStreetNumberAndName", "getSuburb", "suburbStateAndPostcode", "getSuburbStateAndPostcode$annotations", "getSuburbStateAndPostcode", "wholeAddressAsString", "getWholeAddressAsString$annotations", "getWholeAddressAsString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "elementsToString", "", "separator", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public final class HoldingAddress implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String addressLine;
    private final String country;
    private final String houseNumber;
    private final String postCode;
    private final String state;
    private final String stateAndPostcode;
    private final String streetName;
    private final String streetNumberAndName;
    private final String suburb;
    private final String suburbStateAndPostcode;
    private final String wholeAddressAsString;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new HoldingAddress(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new HoldingAddress[i];
        }
    }

    public HoldingAddress() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ HoldingAddress copy$default(HoldingAddress holdingAddress, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = holdingAddress.country;
        }
        if ((i & 2) != 0) {
            str2 = holdingAddress.streetName;
        }
        if ((i & 4) != 0) {
            str3 = holdingAddress.houseNumber;
        }
        if ((i & 8) != 0) {
            str4 = holdingAddress.postCode;
        }
        if ((i & 16) != 0) {
            str5 = holdingAddress.state;
        }
        if ((i & 32) != 0) {
            str6 = holdingAddress.suburb;
        }
        if ((i & 64) != 0) {
            str7 = holdingAddress.addressLine;
        }
        return holdingAddress.copy(str, str2, str3, str4, str5, str6, str7);
    }

    public static /* synthetic */ void getStandardFormatAddress$annotations() {
    }

    public static /* synthetic */ void getStateAndPostcode$annotations() {
    }

    public static /* synthetic */ void getStreetNumberAndName$annotations() {
    }

    public static /* synthetic */ void getSuburbStateAndPostcode$annotations() {
    }

    public static /* synthetic */ void getWholeAddressAsString$annotations() {
    }

    public final String component1() {
        return this.country;
    }

    public final String component2() {
        return this.streetName;
    }

    public final String component3() {
        return this.houseNumber;
    }

    public final String component4() {
        return this.postCode;
    }

    public final String component5() {
        return this.state;
    }

    public final String component6() {
        return this.suburb;
    }

    public final String component7() {
        return this.addressLine;
    }

    public final HoldingAddress copy(@Json(name = "country") String str, @Json(name = "streetName") String str2, @Json(name = "houseNumber") String str3, @Json(name = "postCode") String str4, @Json(name = "stateOrTerritory") String str5, @Json(name = "suburbOrPlaceOrLocality") String str6, @Json(name = "unstructuredAddressLine") String str7) {
        return new HoldingAddress(str, str2, str3, str4, str5, str6, str7);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HoldingAddress)) {
            return false;
        }
        HoldingAddress holdingAddress = (HoldingAddress) obj;
        return Intrinsics.areEqual(this.country, holdingAddress.country) && Intrinsics.areEqual(this.streetName, holdingAddress.streetName) && Intrinsics.areEqual(this.houseNumber, holdingAddress.houseNumber) && Intrinsics.areEqual(this.postCode, holdingAddress.postCode) && Intrinsics.areEqual(this.state, holdingAddress.state) && Intrinsics.areEqual(this.suburb, holdingAddress.suburb) && Intrinsics.areEqual(this.addressLine, holdingAddress.addressLine);
    }

    public int hashCode() {
        String str = this.country;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.streetName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.houseNumber;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.postCode;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.state;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.suburb;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.addressLine;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "HoldingAddress(country=" + this.country + ", streetName=" + this.streetName + ", houseNumber=" + this.houseNumber + ", postCode=" + this.postCode + ", state=" + this.state + ", suburb=" + this.suburb + ", addressLine=" + this.addressLine + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.country);
        parcel.writeString(this.streetName);
        parcel.writeString(this.houseNumber);
        parcel.writeString(this.postCode);
        parcel.writeString(this.state);
        parcel.writeString(this.suburb);
        parcel.writeString(this.addressLine);
    }

    public HoldingAddress(@Json(name = "country") String str, @Json(name = "streetName") String str2, @Json(name = "houseNumber") String str3, @Json(name = "postCode") String str4, @Json(name = "stateOrTerritory") String str5, @Json(name = "suburbOrPlaceOrLocality") String str6, @Json(name = "unstructuredAddressLine") String str7) {
        this.country = str;
        this.streetName = str2;
        this.houseNumber = str3;
        this.postCode = str4;
        this.state = str5;
        this.suburb = str6;
        this.addressLine = str7;
        String elementsToString$default = elementsToString$default(this, CollectionsKt.listOf((Object[]) new String[]{str3, str2}), null, 1, null);
        this.streetNumberAndName = elementsToString$default;
        String elementsToString$default2 = elementsToString$default(this, CollectionsKt.listOf((Object[]) new String[]{str5, str4}), null, 1, null);
        this.stateAndPostcode = elementsToString$default2;
        this.suburbStateAndPostcode = elementsToString$default(this, CollectionsKt.listOf((Object[]) new String[]{str6, str5, str4}), null, 1, null);
        this.wholeAddressAsString = elementsToString(CollectionsKt.listOf((Object[]) new String[]{elementsToString$default, str6, elementsToString$default2}), "\n");
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getStreetName() {
        return this.streetName;
    }

    public final String getHouseNumber() {
        return this.houseNumber;
    }

    public final String getPostCode() {
        return this.postCode;
    }

    public final String getState() {
        return this.state;
    }

    public final String getSuburb() {
        return this.suburb;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HoldingAddress(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7);
    }

    public final String getAddressLine() {
        return this.addressLine;
    }

    public final String getStreetNumberAndName() {
        return this.streetNumberAndName;
    }

    public final String getStateAndPostcode() {
        return this.stateAndPostcode;
    }

    public final String getSuburbStateAndPostcode() {
        return this.suburbStateAndPostcode;
    }

    public final String getWholeAddressAsString() {
        return this.wholeAddressAsString;
    }

    public final String getStandardFormatAddress() {
        return elementsToString(CollectionsKt.listOf((Object[]) new String[]{this.streetNumberAndName, this.suburbStateAndPostcode}), "\n");
    }

    static /* synthetic */ String elementsToString$default(HoldingAddress holdingAddress, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = " ";
        }
        return holdingAddress.elementsToString(list, str);
    }

    private final String elementsToString(List<String> list, String str) {
        return SequencesKt.joinToString$default(SequencesKt.filter(CollectionsKt.asSequence(list), HoldingAddress$elementsToString$1.INSTANCE), str, null, null, 0, null, null, 62, null);
    }
}
