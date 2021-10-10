package com.digitalwallet.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/digitalwallet/model/CheckInSubmissionPayload;", "", "checkIns", "", "Lcom/digitalwallet/model/CheckIn;", "auth", "Lcom/digitalwallet/model/CheckInAuth;", "(Ljava/util/List;Lcom/digitalwallet/model/CheckInAuth;)V", "getAuth", "()Lcom/digitalwallet/model/CheckInAuth;", "getCheckIns", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckIn.kt */
public final class CheckInSubmissionPayload {
    private final CheckInAuth auth;
    private final List<CheckIn> checkIns;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.digitalwallet.model.CheckInSubmissionPayload */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CheckInSubmissionPayload copy$default(CheckInSubmissionPayload checkInSubmissionPayload, List list, CheckInAuth checkInAuth, int i, Object obj) {
        if ((i & 1) != 0) {
            list = checkInSubmissionPayload.checkIns;
        }
        if ((i & 2) != 0) {
            checkInAuth = checkInSubmissionPayload.auth;
        }
        return checkInSubmissionPayload.copy(list, checkInAuth);
    }

    public final List<CheckIn> component1() {
        return this.checkIns;
    }

    public final CheckInAuth component2() {
        return this.auth;
    }

    public final CheckInSubmissionPayload copy(List<CheckIn> list, CheckInAuth checkInAuth) {
        Intrinsics.checkNotNullParameter(list, "checkIns");
        Intrinsics.checkNotNullParameter(checkInAuth, "auth");
        return new CheckInSubmissionPayload(list, checkInAuth);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckInSubmissionPayload)) {
            return false;
        }
        CheckInSubmissionPayload checkInSubmissionPayload = (CheckInSubmissionPayload) obj;
        return Intrinsics.areEqual(this.checkIns, checkInSubmissionPayload.checkIns) && Intrinsics.areEqual(this.auth, checkInSubmissionPayload.auth);
    }

    public int hashCode() {
        List<CheckIn> list = this.checkIns;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        CheckInAuth checkInAuth = this.auth;
        if (checkInAuth != null) {
            i = checkInAuth.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CheckInSubmissionPayload(checkIns=" + this.checkIns + ", auth=" + this.auth + ")";
    }

    public CheckInSubmissionPayload(List<CheckIn> list, CheckInAuth checkInAuth) {
        Intrinsics.checkNotNullParameter(list, "checkIns");
        Intrinsics.checkNotNullParameter(checkInAuth, "auth");
        this.checkIns = list;
        this.auth = checkInAuth;
    }

    public final List<CheckIn> getCheckIns() {
        return this.checkIns;
    }

    public final CheckInAuth getAuth() {
        return this.auth;
    }
}
