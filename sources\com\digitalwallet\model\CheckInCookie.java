package com.digitalwallet.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B_\u0012\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0003\u0010\u0007\u001a\u00020\b\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\n\u0012\u000e\b\u0003\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003¢\u0006\u0002\u0010\u000fJ\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003HÆ\u0003Jc\u0010-\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\n2\u000e\b\u0003\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003HÆ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001J\u0013\u00100\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020/HÖ\u0001J\t\u00104\u001a\u00020\nHÖ\u0001J\u0019\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020/HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001c\u0010\f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001b¨\u0006:"}, d2 = {"Lcom/digitalwallet/model/CheckInCookie;", "Landroid/os/Parcelable;", "pendingCheckIns", "", "Lcom/digitalwallet/model/CheckIn;", "attestation", "Lcom/digitalwallet/model/AttestationJwt;", "checkInAtLeastOnce", "", "checkInFirstName", "", "checkInLastName", "checkInPhoneNumber", "checkInDependants", "Lcom/digitalwallet/model/DependantCheckIn;", "(Ljava/util/List;Lcom/digitalwallet/model/AttestationJwt;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAttestation", "()Lcom/digitalwallet/model/AttestationJwt;", "setAttestation", "(Lcom/digitalwallet/model/AttestationJwt;)V", "getCheckInAtLeastOnce", "()Z", "setCheckInAtLeastOnce", "(Z)V", "getCheckInDependants", "()Ljava/util/List;", "setCheckInDependants", "(Ljava/util/List;)V", "getCheckInFirstName", "()Ljava/lang/String;", "setCheckInFirstName", "(Ljava/lang/String;)V", "getCheckInLastName", "setCheckInLastName", "getCheckInPhoneNumber", "setCheckInPhoneNumber", "getPendingCheckIns", "setPendingCheckIns", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckIn.kt */
public final class CheckInCookie implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private AttestationJwt attestation;
    private boolean checkInAtLeastOnce;
    private List<DependantCheckIn> checkInDependants;
    private String checkInFirstName;
    private String checkInLastName;
    private String checkInPhoneNumber;
    private List<CheckIn> pendingCheckIns;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((CheckIn) CheckIn.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            AttestationJwt attestationJwt = parcel.readInt() != 0 ? (AttestationJwt) AttestationJwt.CREATOR.createFromParcel(parcel) : null;
            boolean z = parcel.readInt() != 0;
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList2.add((DependantCheckIn) DependantCheckIn.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            return new CheckInCookie(arrayList, attestationJwt, z, readString, readString2, readString3, arrayList2);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new CheckInCookie[i];
        }
    }

    public CheckInCookie() {
        this(null, null, false, null, null, null, null, 127, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.digitalwallet.model.CheckInCookie */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CheckInCookie copy$default(CheckInCookie checkInCookie, List list, AttestationJwt attestationJwt, boolean z, String str, String str2, String str3, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = checkInCookie.pendingCheckIns;
        }
        if ((i & 2) != 0) {
            attestationJwt = checkInCookie.attestation;
        }
        if ((i & 4) != 0) {
            z = checkInCookie.checkInAtLeastOnce;
        }
        if ((i & 8) != 0) {
            str = checkInCookie.checkInFirstName;
        }
        if ((i & 16) != 0) {
            str2 = checkInCookie.checkInLastName;
        }
        if ((i & 32) != 0) {
            str3 = checkInCookie.checkInPhoneNumber;
        }
        if ((i & 64) != 0) {
            list2 = checkInCookie.checkInDependants;
        }
        return checkInCookie.copy(list, attestationJwt, z, str, str2, str3, list2);
    }

    public final List<CheckIn> component1() {
        return this.pendingCheckIns;
    }

    public final AttestationJwt component2() {
        return this.attestation;
    }

    public final boolean component3() {
        return this.checkInAtLeastOnce;
    }

    public final String component4() {
        return this.checkInFirstName;
    }

    public final String component5() {
        return this.checkInLastName;
    }

    public final String component6() {
        return this.checkInPhoneNumber;
    }

    public final List<DependantCheckIn> component7() {
        return this.checkInDependants;
    }

    public final CheckInCookie copy(@Json(name = "pendingCheckIns") List<CheckIn> list, @Json(name = "attestation") AttestationJwt attestationJwt, @Json(name = "checkInAtLeastOnce_v2") boolean z, @Json(name = "checkInFirstName") String str, @Json(name = "checkInLastName") String str2, @Json(name = "checkInPhoneNumber") String str3, @Json(name = "checkInDependants") List<DependantCheckIn> list2) {
        Intrinsics.checkNotNullParameter(list, "pendingCheckIns");
        Intrinsics.checkNotNullParameter(list2, "checkInDependants");
        return new CheckInCookie(list, attestationJwt, z, str, str2, str3, list2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckInCookie)) {
            return false;
        }
        CheckInCookie checkInCookie = (CheckInCookie) obj;
        return Intrinsics.areEqual(this.pendingCheckIns, checkInCookie.pendingCheckIns) && Intrinsics.areEqual(this.attestation, checkInCookie.attestation) && this.checkInAtLeastOnce == checkInCookie.checkInAtLeastOnce && Intrinsics.areEqual(this.checkInFirstName, checkInCookie.checkInFirstName) && Intrinsics.areEqual(this.checkInLastName, checkInCookie.checkInLastName) && Intrinsics.areEqual(this.checkInPhoneNumber, checkInCookie.checkInPhoneNumber) && Intrinsics.areEqual(this.checkInDependants, checkInCookie.checkInDependants);
    }

    public int hashCode() {
        List<CheckIn> list = this.pendingCheckIns;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        AttestationJwt attestationJwt = this.attestation;
        int hashCode2 = (hashCode + (attestationJwt != null ? attestationJwt.hashCode() : 0)) * 31;
        boolean z = this.checkInAtLeastOnce;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode2 + i2) * 31;
        String str = this.checkInFirstName;
        int hashCode3 = (i5 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.checkInLastName;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.checkInPhoneNumber;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<DependantCheckIn> list2 = this.checkInDependants;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "CheckInCookie(pendingCheckIns=" + this.pendingCheckIns + ", attestation=" + this.attestation + ", checkInAtLeastOnce=" + this.checkInAtLeastOnce + ", checkInFirstName=" + this.checkInFirstName + ", checkInLastName=" + this.checkInLastName + ", checkInPhoneNumber=" + this.checkInPhoneNumber + ", checkInDependants=" + this.checkInDependants + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        List<CheckIn> list = this.pendingCheckIns;
        parcel.writeInt(list.size());
        for (CheckIn checkIn : list) {
            checkIn.writeToParcel(parcel, 0);
        }
        AttestationJwt attestationJwt = this.attestation;
        if (attestationJwt != null) {
            parcel.writeInt(1);
            attestationJwt.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.checkInAtLeastOnce ? 1 : 0);
        parcel.writeString(this.checkInFirstName);
        parcel.writeString(this.checkInLastName);
        parcel.writeString(this.checkInPhoneNumber);
        List<DependantCheckIn> list2 = this.checkInDependants;
        parcel.writeInt(list2.size());
        for (DependantCheckIn dependantCheckIn : list2) {
            dependantCheckIn.writeToParcel(parcel, 0);
        }
    }

    public CheckInCookie(@Json(name = "pendingCheckIns") List<CheckIn> list, @Json(name = "attestation") AttestationJwt attestationJwt, @Json(name = "checkInAtLeastOnce_v2") boolean z, @Json(name = "checkInFirstName") String str, @Json(name = "checkInLastName") String str2, @Json(name = "checkInPhoneNumber") String str3, @Json(name = "checkInDependants") List<DependantCheckIn> list2) {
        Intrinsics.checkNotNullParameter(list, "pendingCheckIns");
        Intrinsics.checkNotNullParameter(list2, "checkInDependants");
        this.pendingCheckIns = list;
        this.attestation = attestationJwt;
        this.checkInAtLeastOnce = z;
        this.checkInFirstName = str;
        this.checkInLastName = str2;
        this.checkInPhoneNumber = str3;
        this.checkInDependants = list2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CheckInCookie(List list, AttestationJwt attestationJwt, boolean z, String str, String str2, String str3, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : attestationJwt, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? CollectionsKt.emptyList() : list2);
    }

    public final List<CheckIn> getPendingCheckIns() {
        return this.pendingCheckIns;
    }

    public final void setPendingCheckIns(List<CheckIn> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.pendingCheckIns = list;
    }

    public final AttestationJwt getAttestation() {
        return this.attestation;
    }

    public final void setAttestation(AttestationJwt attestationJwt) {
        this.attestation = attestationJwt;
    }

    public final boolean getCheckInAtLeastOnce() {
        return this.checkInAtLeastOnce;
    }

    public final void setCheckInAtLeastOnce(boolean z) {
        this.checkInAtLeastOnce = z;
    }

    public final String getCheckInFirstName() {
        return this.checkInFirstName;
    }

    public final void setCheckInFirstName(String str) {
        this.checkInFirstName = str;
    }

    public final String getCheckInLastName() {
        return this.checkInLastName;
    }

    public final void setCheckInLastName(String str) {
        this.checkInLastName = str;
    }

    public final String getCheckInPhoneNumber() {
        return this.checkInPhoneNumber;
    }

    public final void setCheckInPhoneNumber(String str) {
        this.checkInPhoneNumber = str;
    }

    public final List<DependantCheckIn> getCheckInDependants() {
        return this.checkInDependants;
    }

    public final void setCheckInDependants(List<DependantCheckIn> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.checkInDependants = list;
    }
}
