package com.digitalwallet.app.oidc.model;

import com.google.android.gms.common.internal.ImagesContract;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/digitalwallet/app/oidc/model/PrecacheConfig;", "", "type", "", ImagesContract.URL, "(Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: BootstrapConfig.kt */
public final class PrecacheConfig {
    private final String type;
    private final String url;

    public static /* synthetic */ PrecacheConfig copy$default(PrecacheConfig precacheConfig, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = precacheConfig.type;
        }
        if ((i & 2) != 0) {
            str2 = precacheConfig.url;
        }
        return precacheConfig.copy(str, str2);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.url;
    }

    public final PrecacheConfig copy(@Json(name = "type") String str, @Json(name = "url") String str2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, ImagesContract.URL);
        return new PrecacheConfig(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrecacheConfig)) {
            return false;
        }
        PrecacheConfig precacheConfig = (PrecacheConfig) obj;
        return Intrinsics.areEqual(this.type, precacheConfig.type) && Intrinsics.areEqual(this.url, precacheConfig.url);
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "PrecacheConfig(type=" + this.type + ", url=" + this.url + ")";
    }

    public PrecacheConfig(@Json(name = "type") String str, @Json(name = "url") String str2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, ImagesContract.URL);
        this.type = str;
        this.url = str2;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }
}
