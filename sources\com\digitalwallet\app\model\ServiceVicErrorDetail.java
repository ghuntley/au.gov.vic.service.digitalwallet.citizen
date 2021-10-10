package com.digitalwallet.app.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.ResponseTypeValues;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\r\u0010\u000f\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u0010J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/digitalwallet/app/model/ServiceVicErrorDetail;", "", ResponseTypeValues.CODE, "", "description", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getDescription", "component1", "component2", "copy", "equals", "", "other", "getDisplayMessage", "getDisplayMessage$app_citizenProdRelease", "hashCode", "", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ServiceVicError.kt */
public final class ServiceVicErrorDetail {
    private final String code;
    private final String description;

    public ServiceVicErrorDetail() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ ServiceVicErrorDetail copy$default(ServiceVicErrorDetail serviceVicErrorDetail, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = serviceVicErrorDetail.code;
        }
        if ((i & 2) != 0) {
            str2 = serviceVicErrorDetail.description;
        }
        return serviceVicErrorDetail.copy(str, str2);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.description;
    }

    public final ServiceVicErrorDetail copy(@Json(name = "code") String str, @Json(name = "description") String str2) {
        Intrinsics.checkNotNullParameter(str, ResponseTypeValues.CODE);
        Intrinsics.checkNotNullParameter(str2, "description");
        return new ServiceVicErrorDetail(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ServiceVicErrorDetail)) {
            return false;
        }
        ServiceVicErrorDetail serviceVicErrorDetail = (ServiceVicErrorDetail) obj;
        return Intrinsics.areEqual(this.code, serviceVicErrorDetail.code) && Intrinsics.areEqual(this.description, serviceVicErrorDetail.description);
    }

    public int hashCode() {
        String str = this.code;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.description;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ServiceVicErrorDetail(code=" + this.code + ", description=" + this.description + ")";
    }

    public ServiceVicErrorDetail(@Json(name = "code") String str, @Json(name = "description") String str2) {
        Intrinsics.checkNotNullParameter(str, ResponseTypeValues.CODE);
        Intrinsics.checkNotNullParameter(str2, "description");
        this.code = str;
        this.description = str2;
    }

    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ServiceVicErrorDetail(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDisplayMessage$app_citizenProdRelease() {
        return this.description + "\n(Code: " + this.code + ')';
    }
}
