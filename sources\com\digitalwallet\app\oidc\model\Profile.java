package com.digitalwallet.app.oidc.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\b\u0012\b\b\u0003\u0010\t\u001a\u00020\u0003\u0012\b\b\u0003\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/digitalwallet/app/oidc/model/Profile;", "", "sub", "", "username", "name", "email", "emailVerified", "", "phoneNumber", "phoneNumberVerified", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Z)V", "getEmail", "()Ljava/lang/String;", "getEmailVerified", "()Z", "getName", "getPhoneNumber", "getPhoneNumberVerified", "getSub", "getUsername", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Profile.kt */
public final class Profile {
    private final String email;
    private final boolean emailVerified;
    private final String name;
    private final String phoneNumber;
    private final boolean phoneNumberVerified;
    private final String sub;
    private final String username;

    public Profile() {
        this(null, null, null, null, false, null, false, 127, null);
    }

    public static /* synthetic */ Profile copy$default(Profile profile, String str, String str2, String str3, String str4, boolean z, String str5, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = profile.sub;
        }
        if ((i & 2) != 0) {
            str2 = profile.username;
        }
        if ((i & 4) != 0) {
            str3 = profile.name;
        }
        if ((i & 8) != 0) {
            str4 = profile.email;
        }
        if ((i & 16) != 0) {
            z = profile.emailVerified;
        }
        if ((i & 32) != 0) {
            str5 = profile.phoneNumber;
        }
        if ((i & 64) != 0) {
            z2 = profile.phoneNumberVerified;
        }
        return profile.copy(str, str2, str3, str4, z, str5, z2);
    }

    public final String component1() {
        return this.sub;
    }

    public final String component2() {
        return this.username;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.email;
    }

    public final boolean component5() {
        return this.emailVerified;
    }

    public final String component6() {
        return this.phoneNumber;
    }

    public final boolean component7() {
        return this.phoneNumberVerified;
    }

    public final Profile copy(@Json(name = "sub") String str, @Json(name = "preferred_username") String str2, @Json(name = "name") String str3, @Json(name = "email") String str4, @Json(name = "email_verified") boolean z, @Json(name = "phone_number") String str5, @Json(name = "phone_number_verified") boolean z2) {
        Intrinsics.checkNotNullParameter(str, "sub");
        Intrinsics.checkNotNullParameter(str2, "username");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, "email");
        Intrinsics.checkNotNullParameter(str5, "phoneNumber");
        return new Profile(str, str2, str3, str4, z, str5, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) obj;
        return Intrinsics.areEqual(this.sub, profile.sub) && Intrinsics.areEqual(this.username, profile.username) && Intrinsics.areEqual(this.name, profile.name) && Intrinsics.areEqual(this.email, profile.email) && this.emailVerified == profile.emailVerified && Intrinsics.areEqual(this.phoneNumber, profile.phoneNumber) && this.phoneNumberVerified == profile.phoneNumberVerified;
    }

    public int hashCode() {
        String str = this.sub;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.username;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.email;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        boolean z = this.emailVerified;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode4 + i3) * 31;
        String str5 = this.phoneNumber;
        if (str5 != null) {
            i = str5.hashCode();
        }
        int i7 = (i6 + i) * 31;
        boolean z2 = this.phoneNumberVerified;
        if (!z2) {
            i2 = z2 ? 1 : 0;
        }
        return i7 + i2;
    }

    public String toString() {
        return "Profile(sub=" + this.sub + ", username=" + this.username + ", name=" + this.name + ", email=" + this.email + ", emailVerified=" + this.emailVerified + ", phoneNumber=" + this.phoneNumber + ", phoneNumberVerified=" + this.phoneNumberVerified + ")";
    }

    public Profile(@Json(name = "sub") String str, @Json(name = "preferred_username") String str2, @Json(name = "name") String str3, @Json(name = "email") String str4, @Json(name = "email_verified") boolean z, @Json(name = "phone_number") String str5, @Json(name = "phone_number_verified") boolean z2) {
        Intrinsics.checkNotNullParameter(str, "sub");
        Intrinsics.checkNotNullParameter(str2, "username");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, "email");
        Intrinsics.checkNotNullParameter(str5, "phoneNumber");
        this.sub = str;
        this.username = str2;
        this.name = str3;
        this.email = str4;
        this.emailVerified = z;
        this.phoneNumber = str5;
        this.phoneNumberVerified = z2;
    }

    public final String getSub() {
        return this.sub;
    }

    public final String getUsername() {
        return this.username;
    }

    public final String getName() {
        return this.name;
    }

    public final String getEmail() {
        return this.email;
    }

    public final boolean getEmailVerified() {
        return this.emailVerified;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public /* synthetic */ Profile(String str, String str2, String str3, String str4, boolean z, String str5, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? r0 : str, (i & 2) != 0 ? r0 : str2, (i & 4) != 0 ? r0 : str3, (i & 8) != 0 ? r0 : str4, (i & 16) != 0 ? false : z, (i & 32) == 0 ? str5 : r0, (i & 64) != 0 ? false : z2);
        String str6 = "";
    }

    public final boolean getPhoneNumberVerified() {
        return this.phoneNumberVerified;
    }
}
