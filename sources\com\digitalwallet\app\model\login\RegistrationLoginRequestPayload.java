package com.digitalwallet.app.model.login;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.TokenRequest;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/digitalwallet/app/model/login/RegistrationLoginRequestPayload;", "", "email", "", TokenRequest.GRANT_TYPE_PASSWORD, "devicePrint", "Lcom/digitalwallet/app/model/login/DevicePrint;", "(Ljava/lang/String;Ljava/lang/String;Lcom/digitalwallet/app/model/login/DevicePrint;)V", "getDevicePrint", "()Lcom/digitalwallet/app/model/login/DevicePrint;", "getEmail", "()Ljava/lang/String;", "getPassword", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CreateAccountPayloads.kt */
public final class RegistrationLoginRequestPayload {
    private final DevicePrint devicePrint;
    private final String email;
    private final String password;

    public static /* synthetic */ RegistrationLoginRequestPayload copy$default(RegistrationLoginRequestPayload registrationLoginRequestPayload, String str, String str2, DevicePrint devicePrint2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = registrationLoginRequestPayload.email;
        }
        if ((i & 2) != 0) {
            str2 = registrationLoginRequestPayload.password;
        }
        if ((i & 4) != 0) {
            devicePrint2 = registrationLoginRequestPayload.devicePrint;
        }
        return registrationLoginRequestPayload.copy(str, str2, devicePrint2);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.password;
    }

    public final DevicePrint component3() {
        return this.devicePrint;
    }

    public final RegistrationLoginRequestPayload copy(String str, String str2, DevicePrint devicePrint2) {
        Intrinsics.checkNotNullParameter(str, "email");
        Intrinsics.checkNotNullParameter(str2, TokenRequest.GRANT_TYPE_PASSWORD);
        Intrinsics.checkNotNullParameter(devicePrint2, "devicePrint");
        return new RegistrationLoginRequestPayload(str, str2, devicePrint2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegistrationLoginRequestPayload)) {
            return false;
        }
        RegistrationLoginRequestPayload registrationLoginRequestPayload = (RegistrationLoginRequestPayload) obj;
        return Intrinsics.areEqual(this.email, registrationLoginRequestPayload.email) && Intrinsics.areEqual(this.password, registrationLoginRequestPayload.password) && Intrinsics.areEqual(this.devicePrint, registrationLoginRequestPayload.devicePrint);
    }

    public int hashCode() {
        String str = this.email;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.password;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        DevicePrint devicePrint2 = this.devicePrint;
        if (devicePrint2 != null) {
            i = devicePrint2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "RegistrationLoginRequestPayload(email=" + this.email + ", password=" + this.password + ", devicePrint=" + this.devicePrint + ")";
    }

    public RegistrationLoginRequestPayload(String str, String str2, DevicePrint devicePrint2) {
        Intrinsics.checkNotNullParameter(str, "email");
        Intrinsics.checkNotNullParameter(str2, TokenRequest.GRANT_TYPE_PASSWORD);
        Intrinsics.checkNotNullParameter(devicePrint2, "devicePrint");
        this.email = str;
        this.password = str2;
        this.devicePrint = devicePrint2;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPassword() {
        return this.password;
    }

    public final DevicePrint getDevicePrint() {
        return this.devicePrint;
    }
}
