package com.digitalwallet.app.model.login;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/digitalwallet/app/model/login/RegisterUserRequestPayload;", "", "email", "", "firstName", "(Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getFirstName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CreateAccountPayloads.kt */
public final class RegisterUserRequestPayload {
    private final String email;
    private final String firstName;

    public static /* synthetic */ RegisterUserRequestPayload copy$default(RegisterUserRequestPayload registerUserRequestPayload, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = registerUserRequestPayload.email;
        }
        if ((i & 2) != 0) {
            str2 = registerUserRequestPayload.firstName;
        }
        return registerUserRequestPayload.copy(str, str2);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.firstName;
    }

    public final RegisterUserRequestPayload copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "email");
        Intrinsics.checkNotNullParameter(str2, "firstName");
        return new RegisterUserRequestPayload(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterUserRequestPayload)) {
            return false;
        }
        RegisterUserRequestPayload registerUserRequestPayload = (RegisterUserRequestPayload) obj;
        return Intrinsics.areEqual(this.email, registerUserRequestPayload.email) && Intrinsics.areEqual(this.firstName, registerUserRequestPayload.firstName);
    }

    public int hashCode() {
        String str = this.email;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.firstName;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "RegisterUserRequestPayload(email=" + this.email + ", firstName=" + this.firstName + ")";
    }

    public RegisterUserRequestPayload(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "email");
        Intrinsics.checkNotNullParameter(str2, "firstName");
        this.email = str;
        this.firstName = str2;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getFirstName() {
        return this.firstName;
    }
}
