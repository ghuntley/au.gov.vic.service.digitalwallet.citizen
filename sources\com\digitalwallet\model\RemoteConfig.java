package com.digitalwallet.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/digitalwallet/model/RemoteConfig;", "", "notice", "Lcom/digitalwallet/model/RemoteConfigNotice;", "update", "Lcom/digitalwallet/model/RemoteConfigUpdate;", "features", "Lcom/digitalwallet/model/RemoteFeatureFlags;", "(Lcom/digitalwallet/model/RemoteConfigNotice;Lcom/digitalwallet/model/RemoteConfigUpdate;Lcom/digitalwallet/model/RemoteFeatureFlags;)V", "getFeatures", "()Lcom/digitalwallet/model/RemoteFeatureFlags;", "getNotice", "()Lcom/digitalwallet/model/RemoteConfigNotice;", "getUpdate", "()Lcom/digitalwallet/model/RemoteConfigUpdate;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RemoteConfig.kt */
public final class RemoteConfig {
    private final RemoteFeatureFlags features;
    private final RemoteConfigNotice notice;
    private final RemoteConfigUpdate update;

    public static /* synthetic */ RemoteConfig copy$default(RemoteConfig remoteConfig, RemoteConfigNotice remoteConfigNotice, RemoteConfigUpdate remoteConfigUpdate, RemoteFeatureFlags remoteFeatureFlags, int i, Object obj) {
        if ((i & 1) != 0) {
            remoteConfigNotice = remoteConfig.notice;
        }
        if ((i & 2) != 0) {
            remoteConfigUpdate = remoteConfig.update;
        }
        if ((i & 4) != 0) {
            remoteFeatureFlags = remoteConfig.features;
        }
        return remoteConfig.copy(remoteConfigNotice, remoteConfigUpdate, remoteFeatureFlags);
    }

    public final RemoteConfigNotice component1() {
        return this.notice;
    }

    public final RemoteConfigUpdate component2() {
        return this.update;
    }

    public final RemoteFeatureFlags component3() {
        return this.features;
    }

    public final RemoteConfig copy(RemoteConfigNotice remoteConfigNotice, RemoteConfigUpdate remoteConfigUpdate, RemoteFeatureFlags remoteFeatureFlags) {
        return new RemoteConfig(remoteConfigNotice, remoteConfigUpdate, remoteFeatureFlags);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemoteConfig)) {
            return false;
        }
        RemoteConfig remoteConfig = (RemoteConfig) obj;
        return Intrinsics.areEqual(this.notice, remoteConfig.notice) && Intrinsics.areEqual(this.update, remoteConfig.update) && Intrinsics.areEqual(this.features, remoteConfig.features);
    }

    public int hashCode() {
        RemoteConfigNotice remoteConfigNotice = this.notice;
        int i = 0;
        int hashCode = (remoteConfigNotice != null ? remoteConfigNotice.hashCode() : 0) * 31;
        RemoteConfigUpdate remoteConfigUpdate = this.update;
        int hashCode2 = (hashCode + (remoteConfigUpdate != null ? remoteConfigUpdate.hashCode() : 0)) * 31;
        RemoteFeatureFlags remoteFeatureFlags = this.features;
        if (remoteFeatureFlags != null) {
            i = remoteFeatureFlags.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "RemoteConfig(notice=" + this.notice + ", update=" + this.update + ", features=" + this.features + ")";
    }

    public RemoteConfig(RemoteConfigNotice remoteConfigNotice, RemoteConfigUpdate remoteConfigUpdate, RemoteFeatureFlags remoteFeatureFlags) {
        this.notice = remoteConfigNotice;
        this.update = remoteConfigUpdate;
        this.features = remoteFeatureFlags;
    }

    public final RemoteFeatureFlags getFeatures() {
        return this.features;
    }

    public final RemoteConfigNotice getNotice() {
        return this.notice;
    }

    public final RemoteConfigUpdate getUpdate() {
        return this.update;
    }
}
