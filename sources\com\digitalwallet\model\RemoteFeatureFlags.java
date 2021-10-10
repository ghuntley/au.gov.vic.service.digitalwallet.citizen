package com.digitalwallet.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/digitalwallet/model/RemoteFeatureFlags;", "", "createAccountEnabled", "", "(Ljava/lang/Boolean;)V", "getCreateAccountEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/digitalwallet/model/RemoteFeatureFlags;", "equals", "other", "hashCode", "", "toString", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RemoteConfig.kt */
public final class RemoteFeatureFlags {
    private final Boolean createAccountEnabled;

    public static /* synthetic */ RemoteFeatureFlags copy$default(RemoteFeatureFlags remoteFeatureFlags, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = remoteFeatureFlags.createAccountEnabled;
        }
        return remoteFeatureFlags.copy(bool);
    }

    public final Boolean component1() {
        return this.createAccountEnabled;
    }

    public final RemoteFeatureFlags copy(@Json(name = "create-account-enabled") Boolean bool) {
        return new RemoteFeatureFlags(bool);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RemoteFeatureFlags) && Intrinsics.areEqual(this.createAccountEnabled, ((RemoteFeatureFlags) obj).createAccountEnabled);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.createAccountEnabled;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "RemoteFeatureFlags(createAccountEnabled=" + this.createAccountEnabled + ")";
    }

    public RemoteFeatureFlags(@Json(name = "create-account-enabled") Boolean bool) {
        this.createAccountEnabled = bool;
    }

    public final Boolean getCreateAccountEnabled() {
        return this.createAccountEnabled;
    }
}
