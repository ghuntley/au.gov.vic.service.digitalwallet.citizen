package com.digitalwallet.app.oidc.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/digitalwallet/app/oidc/model/AuthenticationConfig;", "", "discoveryUrl", "", "authorityUrl", "name", "authClientId", "apiClientId", "scopes", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApiClientId", "()Ljava/lang/String;", "getAuthClientId", "getAuthorityUrl", "getDiscoveryUrl", "getName", "getScopes", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: BootstrapConfig.kt */
public final class AuthenticationConfig {
    private final String apiClientId;
    private final String authClientId;
    private final String authorityUrl;
    private final String discoveryUrl;
    private final String name;
    private final String scopes;

    public static /* synthetic */ AuthenticationConfig copy$default(AuthenticationConfig authenticationConfig, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authenticationConfig.discoveryUrl;
        }
        if ((i & 2) != 0) {
            str2 = authenticationConfig.authorityUrl;
        }
        if ((i & 4) != 0) {
            str3 = authenticationConfig.name;
        }
        if ((i & 8) != 0) {
            str4 = authenticationConfig.authClientId;
        }
        if ((i & 16) != 0) {
            str5 = authenticationConfig.apiClientId;
        }
        if ((i & 32) != 0) {
            str6 = authenticationConfig.scopes;
        }
        return authenticationConfig.copy(str, str2, str3, str4, str5, str6);
    }

    public final String component1() {
        return this.discoveryUrl;
    }

    public final String component2() {
        return this.authorityUrl;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.authClientId;
    }

    public final String component5() {
        return this.apiClientId;
    }

    public final String component6() {
        return this.scopes;
    }

    public final AuthenticationConfig copy(@Json(name = "discoveryDocumentUrl") String str, @Json(name = "authorityUrl") String str2, @Json(name = "androidName") String str3, @Json(name = "authClientId") String str4, @Json(name = "apiClientId") String str5, @Json(name = "scopes") String str6) {
        Intrinsics.checkNotNullParameter(str, "discoveryUrl");
        Intrinsics.checkNotNullParameter(str2, "authorityUrl");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, "authClientId");
        Intrinsics.checkNotNullParameter(str5, "apiClientId");
        Intrinsics.checkNotNullParameter(str6, "scopes");
        return new AuthenticationConfig(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationConfig)) {
            return false;
        }
        AuthenticationConfig authenticationConfig = (AuthenticationConfig) obj;
        return Intrinsics.areEqual(this.discoveryUrl, authenticationConfig.discoveryUrl) && Intrinsics.areEqual(this.authorityUrl, authenticationConfig.authorityUrl) && Intrinsics.areEqual(this.name, authenticationConfig.name) && Intrinsics.areEqual(this.authClientId, authenticationConfig.authClientId) && Intrinsics.areEqual(this.apiClientId, authenticationConfig.apiClientId) && Intrinsics.areEqual(this.scopes, authenticationConfig.scopes);
    }

    public int hashCode() {
        String str = this.discoveryUrl;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.authorityUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.authClientId;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.apiClientId;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.scopes;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "AuthenticationConfig(discoveryUrl=" + this.discoveryUrl + ", authorityUrl=" + this.authorityUrl + ", name=" + this.name + ", authClientId=" + this.authClientId + ", apiClientId=" + this.apiClientId + ", scopes=" + this.scopes + ")";
    }

    public AuthenticationConfig(@Json(name = "discoveryDocumentUrl") String str, @Json(name = "authorityUrl") String str2, @Json(name = "androidName") String str3, @Json(name = "authClientId") String str4, @Json(name = "apiClientId") String str5, @Json(name = "scopes") String str6) {
        Intrinsics.checkNotNullParameter(str, "discoveryUrl");
        Intrinsics.checkNotNullParameter(str2, "authorityUrl");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, "authClientId");
        Intrinsics.checkNotNullParameter(str5, "apiClientId");
        Intrinsics.checkNotNullParameter(str6, "scopes");
        this.discoveryUrl = str;
        this.authorityUrl = str2;
        this.name = str3;
        this.authClientId = str4;
        this.apiClientId = str5;
        this.scopes = str6;
    }

    public final String getDiscoveryUrl() {
        return this.discoveryUrl;
    }

    public final String getAuthorityUrl() {
        return this.authorityUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final String getAuthClientId() {
        return this.authClientId;
    }

    public final String getApiClientId() {
        return this.apiClientId;
    }

    public final String getScopes() {
        return this.scopes;
    }
}
