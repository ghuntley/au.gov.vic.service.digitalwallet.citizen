package com.digitalwallet.app.model.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.ResponseTypeValues;
import net.openid.appauth.TokenRequest;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003JY\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020%HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020%HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010¨\u00061"}, d2 = {"Lcom/digitalwallet/app/model/login/VerifyOTPRequestPayload;", "Landroid/os/Parcelable;", "email", "", "sessionID", ResponseTypeValues.CODE, "id", TokenRequest.GRANT_TYPE_PASSWORD, "firstName", "lastName", "devicePrint", "Lcom/digitalwallet/app/model/login/DevicePrint;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/digitalwallet/app/model/login/DevicePrint;)V", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getDevicePrint", "()Lcom/digitalwallet/app/model/login/DevicePrint;", "getEmail", "getFirstName", "getId", "setId", "getLastName", "getPassword", "getSessionID", "setSessionID", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CreateAccountPayloads.kt */
public final class VerifyOTPRequestPayload implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private String code;
    private final DevicePrint devicePrint;
    private final String email;
    private final String firstName;
    private String id;
    private final String lastName;
    private final String password;
    private String sessionID;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new VerifyOTPRequestPayload(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (DevicePrint) DevicePrint.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new VerifyOTPRequestPayload[i];
        }
    }

    public static /* synthetic */ VerifyOTPRequestPayload copy$default(VerifyOTPRequestPayload verifyOTPRequestPayload, String str, String str2, String str3, String str4, String str5, String str6, String str7, DevicePrint devicePrint2, int i, Object obj) {
        return verifyOTPRequestPayload.copy((i & 1) != 0 ? verifyOTPRequestPayload.email : str, (i & 2) != 0 ? verifyOTPRequestPayload.sessionID : str2, (i & 4) != 0 ? verifyOTPRequestPayload.code : str3, (i & 8) != 0 ? verifyOTPRequestPayload.id : str4, (i & 16) != 0 ? verifyOTPRequestPayload.password : str5, (i & 32) != 0 ? verifyOTPRequestPayload.firstName : str6, (i & 64) != 0 ? verifyOTPRequestPayload.lastName : str7, (i & 128) != 0 ? verifyOTPRequestPayload.devicePrint : devicePrint2);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.sessionID;
    }

    public final String component3() {
        return this.code;
    }

    public final String component4() {
        return this.id;
    }

    public final String component5() {
        return this.password;
    }

    public final String component6() {
        return this.firstName;
    }

    public final String component7() {
        return this.lastName;
    }

    public final DevicePrint component8() {
        return this.devicePrint;
    }

    public final VerifyOTPRequestPayload copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, DevicePrint devicePrint2) {
        Intrinsics.checkNotNullParameter(str, "email");
        Intrinsics.checkNotNullParameter(str2, "sessionID");
        Intrinsics.checkNotNullParameter(str3, ResponseTypeValues.CODE);
        Intrinsics.checkNotNullParameter(str4, "id");
        Intrinsics.checkNotNullParameter(str5, TokenRequest.GRANT_TYPE_PASSWORD);
        Intrinsics.checkNotNullParameter(str6, "firstName");
        Intrinsics.checkNotNullParameter(str7, "lastName");
        Intrinsics.checkNotNullParameter(devicePrint2, "devicePrint");
        return new VerifyOTPRequestPayload(str, str2, str3, str4, str5, str6, str7, devicePrint2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VerifyOTPRequestPayload)) {
            return false;
        }
        VerifyOTPRequestPayload verifyOTPRequestPayload = (VerifyOTPRequestPayload) obj;
        return Intrinsics.areEqual(this.email, verifyOTPRequestPayload.email) && Intrinsics.areEqual(this.sessionID, verifyOTPRequestPayload.sessionID) && Intrinsics.areEqual(this.code, verifyOTPRequestPayload.code) && Intrinsics.areEqual(this.id, verifyOTPRequestPayload.id) && Intrinsics.areEqual(this.password, verifyOTPRequestPayload.password) && Intrinsics.areEqual(this.firstName, verifyOTPRequestPayload.firstName) && Intrinsics.areEqual(this.lastName, verifyOTPRequestPayload.lastName) && Intrinsics.areEqual(this.devicePrint, verifyOTPRequestPayload.devicePrint);
    }

    public int hashCode() {
        String str = this.email;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.sessionID;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.code;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.id;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.password;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.firstName;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.lastName;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        DevicePrint devicePrint2 = this.devicePrint;
        if (devicePrint2 != null) {
            i = devicePrint2.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "VerifyOTPRequestPayload(email=" + this.email + ", sessionID=" + this.sessionID + ", code=" + this.code + ", id=" + this.id + ", password=" + this.password + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", devicePrint=" + this.devicePrint + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.email);
        parcel.writeString(this.sessionID);
        parcel.writeString(this.code);
        parcel.writeString(this.id);
        parcel.writeString(this.password);
        parcel.writeString(this.firstName);
        parcel.writeString(this.lastName);
        this.devicePrint.writeToParcel(parcel, 0);
    }

    public VerifyOTPRequestPayload(String str, String str2, String str3, String str4, String str5, String str6, String str7, DevicePrint devicePrint2) {
        Intrinsics.checkNotNullParameter(str, "email");
        Intrinsics.checkNotNullParameter(str2, "sessionID");
        Intrinsics.checkNotNullParameter(str3, ResponseTypeValues.CODE);
        Intrinsics.checkNotNullParameter(str4, "id");
        Intrinsics.checkNotNullParameter(str5, TokenRequest.GRANT_TYPE_PASSWORD);
        Intrinsics.checkNotNullParameter(str6, "firstName");
        Intrinsics.checkNotNullParameter(str7, "lastName");
        Intrinsics.checkNotNullParameter(devicePrint2, "devicePrint");
        this.email = str;
        this.sessionID = str2;
        this.code = str3;
        this.id = str4;
        this.password = str5;
        this.firstName = str6;
        this.lastName = str7;
        this.devicePrint = devicePrint2;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getSessionID() {
        return this.sessionID;
    }

    public final void setSessionID(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionID = str;
    }

    public final String getCode() {
        return this.code;
    }

    public final void setCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.code = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final DevicePrint getDevicePrint() {
        return this.devicePrint;
    }
}
