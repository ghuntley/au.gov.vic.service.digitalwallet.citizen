package com.digitalwallet.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.JsonClass;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/digitalwallet/model/AttestationJwt;", "Landroid/os/Parcelable;", "jwt", "", "creationDate", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;)V", "getCreationDate", "()Ljava/util/Date;", "getJwt", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckIn.kt */
public final class AttestationJwt implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final Date creationDate;
    private final String jwt;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AttestationJwt(parcel.readString(), (Date) parcel.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new AttestationJwt[i];
        }
    }

    public static /* synthetic */ AttestationJwt copy$default(AttestationJwt attestationJwt, String str, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = attestationJwt.jwt;
        }
        if ((i & 2) != 0) {
            date = attestationJwt.creationDate;
        }
        return attestationJwt.copy(str, date);
    }

    public final String component1() {
        return this.jwt;
    }

    public final Date component2() {
        return this.creationDate;
    }

    public final AttestationJwt copy(String str, Date date) {
        Intrinsics.checkNotNullParameter(str, "jwt");
        Intrinsics.checkNotNullParameter(date, "creationDate");
        return new AttestationJwt(str, date);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AttestationJwt)) {
            return false;
        }
        AttestationJwt attestationJwt = (AttestationJwt) obj;
        return Intrinsics.areEqual(this.jwt, attestationJwt.jwt) && Intrinsics.areEqual(this.creationDate, attestationJwt.creationDate);
    }

    public int hashCode() {
        String str = this.jwt;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Date date = this.creationDate;
        if (date != null) {
            i = date.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "AttestationJwt(jwt=" + this.jwt + ", creationDate=" + this.creationDate + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.jwt);
        parcel.writeSerializable(this.creationDate);
    }

    public AttestationJwt(String str, Date date) {
        Intrinsics.checkNotNullParameter(str, "jwt");
        Intrinsics.checkNotNullParameter(date, "creationDate");
        this.jwt = str;
        this.creationDate = date;
    }

    public final String getJwt() {
        return this.jwt;
    }

    public final Date getCreationDate() {
        return this.creationDate;
    }
}
