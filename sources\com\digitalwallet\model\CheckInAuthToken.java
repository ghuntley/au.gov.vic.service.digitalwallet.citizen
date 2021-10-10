package com.digitalwallet.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.ResponseTypeValues;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/digitalwallet/model/CheckInAuthToken;", "", ResponseTypeValues.TOKEN, "", "(Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckIn.kt */
public final class CheckInAuthToken {
    private final String token;

    public static /* synthetic */ CheckInAuthToken copy$default(CheckInAuthToken checkInAuthToken, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = checkInAuthToken.token;
        }
        return checkInAuthToken.copy(str);
    }

    public final String component1() {
        return this.token;
    }

    public final CheckInAuthToken copy(String str) {
        Intrinsics.checkNotNullParameter(str, ResponseTypeValues.TOKEN);
        return new CheckInAuthToken(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CheckInAuthToken) && Intrinsics.areEqual(this.token, ((CheckInAuthToken) obj).token);
        }
        return true;
    }

    public int hashCode() {
        String str = this.token;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "CheckInAuthToken(token=" + this.token + ")";
    }

    public CheckInAuthToken(String str) {
        Intrinsics.checkNotNullParameter(str, ResponseTypeValues.TOKEN);
        this.token = str;
    }

    public final String getToken() {
        return this.token;
    }
}
