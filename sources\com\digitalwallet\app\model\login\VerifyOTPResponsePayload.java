package com.digitalwallet.app.model.login;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/digitalwallet/app/model/login/VerifyOTPResponsePayload;", "", "status", "", "(Ljava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CreateAccountPayloads.kt */
public final class VerifyOTPResponsePayload {
    private final String status;

    public static /* synthetic */ VerifyOTPResponsePayload copy$default(VerifyOTPResponsePayload verifyOTPResponsePayload, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = verifyOTPResponsePayload.status;
        }
        return verifyOTPResponsePayload.copy(str);
    }

    public final String component1() {
        return this.status;
    }

    public final VerifyOTPResponsePayload copy(String str) {
        Intrinsics.checkNotNullParameter(str, "status");
        return new VerifyOTPResponsePayload(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof VerifyOTPResponsePayload) && Intrinsics.areEqual(this.status, ((VerifyOTPResponsePayload) obj).status);
        }
        return true;
    }

    public int hashCode() {
        String str = this.status;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "VerifyOTPResponsePayload(status=" + this.status + ")";
    }

    public VerifyOTPResponsePayload(String str) {
        Intrinsics.checkNotNullParameter(str, "status");
        this.status = str;
    }

    public final String getStatus() {
        return this.status;
    }
}
