package com.digitalwallet.app.oidc.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/digitalwallet/app/oidc/model/ApiConfig;", "", "apiUrl", "", "holdingSigningKeys", "(Ljava/lang/String;Ljava/lang/String;)V", "getApiUrl", "()Ljava/lang/String;", "getHoldingSigningKeys", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: BootstrapConfig.kt */
public final class ApiConfig {
    private final String apiUrl;
    private final String holdingSigningKeys;

    public static /* synthetic */ ApiConfig copy$default(ApiConfig apiConfig, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = apiConfig.apiUrl;
        }
        if ((i & 2) != 0) {
            str2 = apiConfig.holdingSigningKeys;
        }
        return apiConfig.copy(str, str2);
    }

    public final String component1() {
        return this.apiUrl;
    }

    public final String component2() {
        return this.holdingSigningKeys;
    }

    public final ApiConfig copy(@Json(name = "apiUrl") String str, @Json(name = "holdingSigningKeys") String str2) {
        Intrinsics.checkNotNullParameter(str, "apiUrl");
        Intrinsics.checkNotNullParameter(str2, "holdingSigningKeys");
        return new ApiConfig(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApiConfig)) {
            return false;
        }
        ApiConfig apiConfig = (ApiConfig) obj;
        return Intrinsics.areEqual(this.apiUrl, apiConfig.apiUrl) && Intrinsics.areEqual(this.holdingSigningKeys, apiConfig.holdingSigningKeys);
    }

    public int hashCode() {
        String str = this.apiUrl;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.holdingSigningKeys;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ApiConfig(apiUrl=" + this.apiUrl + ", holdingSigningKeys=" + this.holdingSigningKeys + ")";
    }

    public ApiConfig(@Json(name = "apiUrl") String str, @Json(name = "holdingSigningKeys") String str2) {
        Intrinsics.checkNotNullParameter(str, "apiUrl");
        Intrinsics.checkNotNullParameter(str2, "holdingSigningKeys");
        this.apiUrl = str;
        this.holdingSigningKeys = str2;
    }

    public final String getApiUrl() {
        return this.apiUrl;
    }

    public final String getHoldingSigningKeys() {
        return this.holdingSigningKeys;
    }
}
