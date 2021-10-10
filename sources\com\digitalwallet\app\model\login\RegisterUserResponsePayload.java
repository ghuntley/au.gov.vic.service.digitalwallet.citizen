package com.digitalwallet.app.model.login;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/model/login/RegisterUserResponsePayload;", "", "email", "", "sessionID", "id", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getId", "getSessionID", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CreateAccountPayloads.kt */
public final class RegisterUserResponsePayload {
    private final String email;
    private final String id;
    private final String sessionID;

    public static /* synthetic */ RegisterUserResponsePayload copy$default(RegisterUserResponsePayload registerUserResponsePayload, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = registerUserResponsePayload.email;
        }
        if ((i & 2) != 0) {
            str2 = registerUserResponsePayload.sessionID;
        }
        if ((i & 4) != 0) {
            str3 = registerUserResponsePayload.id;
        }
        return registerUserResponsePayload.copy(str, str2, str3);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.sessionID;
    }

    public final String component3() {
        return this.id;
    }

    public final RegisterUserResponsePayload copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "email");
        Intrinsics.checkNotNullParameter(str2, "sessionID");
        Intrinsics.checkNotNullParameter(str3, "id");
        return new RegisterUserResponsePayload(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterUserResponsePayload)) {
            return false;
        }
        RegisterUserResponsePayload registerUserResponsePayload = (RegisterUserResponsePayload) obj;
        return Intrinsics.areEqual(this.email, registerUserResponsePayload.email) && Intrinsics.areEqual(this.sessionID, registerUserResponsePayload.sessionID) && Intrinsics.areEqual(this.id, registerUserResponsePayload.id);
    }

    public int hashCode() {
        String str = this.email;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.sessionID;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.id;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "RegisterUserResponsePayload(email=" + this.email + ", sessionID=" + this.sessionID + ", id=" + this.id + ")";
    }

    public RegisterUserResponsePayload(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "email");
        Intrinsics.checkNotNullParameter(str2, "sessionID");
        Intrinsics.checkNotNullParameter(str3, "id");
        this.email = str;
        this.sessionID = str2;
        this.id = str3;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getId() {
        return this.id;
    }

    public final String getSessionID() {
        return this.sessionID;
    }
}
