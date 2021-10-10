package com.digitalwallet.model;

import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/digitalwallet/model/RemoteConfigUpdate;", "", AbstractSpiCall.ANDROID_CLIENT_TYPE, "Lcom/digitalwallet/model/RemoteConfigUpdateData;", "(Lcom/digitalwallet/model/RemoteConfigUpdateData;)V", "getAndroid", "()Lcom/digitalwallet/model/RemoteConfigUpdateData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RemoteConfig.kt */
public final class RemoteConfigUpdate {

    /* renamed from: android  reason: collision with root package name */
    private final RemoteConfigUpdateData f4android;

    public static /* synthetic */ RemoteConfigUpdate copy$default(RemoteConfigUpdate remoteConfigUpdate, RemoteConfigUpdateData remoteConfigUpdateData, int i, Object obj) {
        if ((i & 1) != 0) {
            remoteConfigUpdateData = remoteConfigUpdate.f4android;
        }
        return remoteConfigUpdate.copy(remoteConfigUpdateData);
    }

    public final RemoteConfigUpdateData component1() {
        return this.f4android;
    }

    public final RemoteConfigUpdate copy(RemoteConfigUpdateData remoteConfigUpdateData) {
        return new RemoteConfigUpdate(remoteConfigUpdateData);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RemoteConfigUpdate) && Intrinsics.areEqual(this.f4android, ((RemoteConfigUpdate) obj).f4android);
        }
        return true;
    }

    public int hashCode() {
        RemoteConfigUpdateData remoteConfigUpdateData = this.f4android;
        if (remoteConfigUpdateData != null) {
            return remoteConfigUpdateData.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "RemoteConfigUpdate(android=" + this.f4android + ")";
    }

    public RemoteConfigUpdate(RemoteConfigUpdateData remoteConfigUpdateData) {
        this.f4android = remoteConfigUpdateData;
    }

    public final RemoteConfigUpdateData getAndroid() {
        return this.f4android;
    }
}
