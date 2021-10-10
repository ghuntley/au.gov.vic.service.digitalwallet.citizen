package com.digitalwallet.model;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/digitalwallet/model/CheckInAuth;", "", "type", "", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Lcom/digitalwallet/model/CheckInAuthToken;", "(Ljava/lang/String;Lcom/digitalwallet/model/CheckInAuthToken;)V", "getData", "()Lcom/digitalwallet/model/CheckInAuthToken;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckIn.kt */
public final class CheckInAuth {
    private final CheckInAuthToken data;
    private final String type;

    public static /* synthetic */ CheckInAuth copy$default(CheckInAuth checkInAuth, String str, CheckInAuthToken checkInAuthToken, int i, Object obj) {
        if ((i & 1) != 0) {
            str = checkInAuth.type;
        }
        if ((i & 2) != 0) {
            checkInAuthToken = checkInAuth.data;
        }
        return checkInAuth.copy(str, checkInAuthToken);
    }

    public final String component1() {
        return this.type;
    }

    public final CheckInAuthToken component2() {
        return this.data;
    }

    public final CheckInAuth copy(String str, CheckInAuthToken checkInAuthToken) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(checkInAuthToken, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        return new CheckInAuth(str, checkInAuthToken);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckInAuth)) {
            return false;
        }
        CheckInAuth checkInAuth = (CheckInAuth) obj;
        return Intrinsics.areEqual(this.type, checkInAuth.type) && Intrinsics.areEqual(this.data, checkInAuth.data);
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        CheckInAuthToken checkInAuthToken = this.data;
        if (checkInAuthToken != null) {
            i = checkInAuthToken.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CheckInAuth(type=" + this.type + ", data=" + this.data + ")";
    }

    public CheckInAuth(String str, CheckInAuthToken checkInAuthToken) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(checkInAuthToken, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        this.type = str;
        this.data = checkInAuthToken;
    }

    public final String getType() {
        return this.type;
    }

    public final CheckInAuthToken getData() {
        return this.data;
    }
}
