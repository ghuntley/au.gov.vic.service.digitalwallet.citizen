package com.digitalwallet.app.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/digitalwallet/app/model/Authority;", "Landroid/os/Parcelable;", "name", "", "logo", "authorityType", "Lcom/digitalwallet/app/model/AuthorityType;", "(Ljava/lang/String;Ljava/lang/String;Lcom/digitalwallet/app/model/AuthorityType;)V", "getAuthorityType", "()Lcom/digitalwallet/app/model/AuthorityType;", "getLogo", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public final class Authority implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final AuthorityType authorityType;
    private final String logo;
    private final String name;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new Authority(parcel.readString(), parcel.readString(), (AuthorityType) Enum.valueOf(AuthorityType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new Authority[i];
        }
    }

    public Authority() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ Authority copy$default(Authority authority, String str, String str2, AuthorityType authorityType2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authority.name;
        }
        if ((i & 2) != 0) {
            str2 = authority.logo;
        }
        if ((i & 4) != 0) {
            authorityType2 = authority.authorityType;
        }
        return authority.copy(str, str2, authorityType2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.logo;
    }

    public final AuthorityType component3() {
        return this.authorityType;
    }

    public final Authority copy(@Json(name = "name") String str, @Json(name = "logo") String str2, AuthorityType authorityType2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "logo");
        Intrinsics.checkNotNullParameter(authorityType2, "authorityType");
        return new Authority(str, str2, authorityType2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Authority)) {
            return false;
        }
        Authority authority = (Authority) obj;
        return Intrinsics.areEqual(this.name, authority.name) && Intrinsics.areEqual(this.logo, authority.logo) && Intrinsics.areEqual(this.authorityType, authority.authorityType);
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.logo;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        AuthorityType authorityType2 = this.authorityType;
        if (authorityType2 != null) {
            i = authorityType2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "Authority(name=" + this.name + ", logo=" + this.logo + ", authorityType=" + this.authorityType + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeString(this.logo);
        parcel.writeString(this.authorityType.name());
    }

    public Authority(@Json(name = "name") String str, @Json(name = "logo") String str2, AuthorityType authorityType2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "logo");
        Intrinsics.checkNotNullParameter(authorityType2, "authorityType");
        this.name = str;
        this.logo = str2;
        this.authorityType = authorityType2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getLogo() {
        return this.logo;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public /* synthetic */ Authority(String str, String str2, AuthorityType authorityType2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, authorityType2);
        str = (i & 1) != 0 ? "" : str;
        str2 = (i & 2) != 0 ? "" : str2;
        if ((i & 4) != 0) {
            if (str.hashCode() == -1598353518 && str.equals("Fisheries")) {
                authorityType2 = AuthorityType.FISHERIES;
            } else {
                authorityType2 = AuthorityType.UNKNOWN;
            }
        }
    }

    public final AuthorityType getAuthorityType() {
        return this.authorityType;
    }
}
