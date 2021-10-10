package com.digitalwallet.app.oidc.model;

import com.squareup.moshi.Json;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0002\u0010\tJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÂ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\u000e\b\u0003\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/digitalwallet/app/oidc/model/BootstrapConfig;", "", "authenticationConfigs", "", "Lcom/digitalwallet/app/oidc/model/AuthenticationConfig;", "apiConfig", "Lcom/digitalwallet/app/oidc/model/ApiConfig;", "precache", "Lcom/digitalwallet/app/oidc/model/PrecacheConfig;", "(Ljava/util/List;Lcom/digitalwallet/app/oidc/model/ApiConfig;Ljava/util/List;)V", "getApiConfig", "()Lcom/digitalwallet/app/oidc/model/ApiConfig;", "authentication", "getAuthentication", "()Lcom/digitalwallet/app/oidc/model/AuthenticationConfig;", "created", "Ljava/util/Date;", "getCreated", "()Ljava/util/Date;", "getPrecache", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: BootstrapConfig.kt */
public final class BootstrapConfig {
    private final ApiConfig apiConfig;
    private final AuthenticationConfig authentication;
    private final List<AuthenticationConfig> authenticationConfigs;
    private final Date created;
    private final List<PrecacheConfig> precache;

    private final List<AuthenticationConfig> component1() {
        return this.authenticationConfigs;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.digitalwallet.app.oidc.model.BootstrapConfig */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BootstrapConfig copy$default(BootstrapConfig bootstrapConfig, List list, ApiConfig apiConfig2, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = bootstrapConfig.authenticationConfigs;
        }
        if ((i & 2) != 0) {
            apiConfig2 = bootstrapConfig.apiConfig;
        }
        if ((i & 4) != 0) {
            list2 = bootstrapConfig.precache;
        }
        return bootstrapConfig.copy(list, apiConfig2, list2);
    }

    public final ApiConfig component2() {
        return this.apiConfig;
    }

    public final List<PrecacheConfig> component3() {
        return this.precache;
    }

    public final BootstrapConfig copy(@Json(name = "authentication") List<AuthenticationConfig> list, @Json(name = "api") ApiConfig apiConfig2, @Json(name = "preCache") List<PrecacheConfig> list2) {
        Intrinsics.checkNotNullParameter(list, "authenticationConfigs");
        Intrinsics.checkNotNullParameter(apiConfig2, "apiConfig");
        Intrinsics.checkNotNullParameter(list2, "precache");
        return new BootstrapConfig(list, apiConfig2, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BootstrapConfig)) {
            return false;
        }
        BootstrapConfig bootstrapConfig = (BootstrapConfig) obj;
        return Intrinsics.areEqual(this.authenticationConfigs, bootstrapConfig.authenticationConfigs) && Intrinsics.areEqual(this.apiConfig, bootstrapConfig.apiConfig) && Intrinsics.areEqual(this.precache, bootstrapConfig.precache);
    }

    public int hashCode() {
        List<AuthenticationConfig> list = this.authenticationConfigs;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        ApiConfig apiConfig2 = this.apiConfig;
        int hashCode2 = (hashCode + (apiConfig2 != null ? apiConfig2.hashCode() : 0)) * 31;
        List<PrecacheConfig> list2 = this.precache;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "BootstrapConfig(authenticationConfigs=" + this.authenticationConfigs + ", apiConfig=" + this.apiConfig + ", precache=" + this.precache + ")";
    }

    public BootstrapConfig(@Json(name = "authentication") List<AuthenticationConfig> list, @Json(name = "api") ApiConfig apiConfig2, @Json(name = "preCache") List<PrecacheConfig> list2) {
        Intrinsics.checkNotNullParameter(list, "authenticationConfigs");
        Intrinsics.checkNotNullParameter(apiConfig2, "apiConfig");
        Intrinsics.checkNotNullParameter(list2, "precache");
        this.authenticationConfigs = list;
        this.apiConfig = apiConfig2;
        this.precache = list2;
        for (T t : list) {
            if (Intrinsics.areEqual(t.getName(), "au.gov.vic.service.digitalwallet.citizen")) {
                this.authentication = t;
                this.created = new Date();
                return;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final ApiConfig getApiConfig() {
        return this.apiConfig;
    }

    public final List<PrecacheConfig> getPrecache() {
        return this.precache;
    }

    public final AuthenticationConfig getAuthentication() {
        return this.authentication;
    }

    public final Date getCreated() {
        return this.created;
    }
}
