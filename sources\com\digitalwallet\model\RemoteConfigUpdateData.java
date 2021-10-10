package com.digitalwallet.model;

import com.digitalwallet.app.model.P2PHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/digitalwallet/model/RemoteConfigUpdateData;", "", P2PHeader.versionKey, "", MessageBundle.TITLE_ENTRY, "", "message", "force", "", "(ILjava/lang/String;Ljava/lang/String;Z)V", "getForce", "()Z", "getMessage", "()Ljava/lang/String;", "getTitle", "getVersion", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RemoteConfig.kt */
public final class RemoteConfigUpdateData {
    private final boolean force;
    private final String message;
    private final String title;
    private final int version;

    public static /* synthetic */ RemoteConfigUpdateData copy$default(RemoteConfigUpdateData remoteConfigUpdateData, int i, String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = remoteConfigUpdateData.version;
        }
        if ((i2 & 2) != 0) {
            str = remoteConfigUpdateData.title;
        }
        if ((i2 & 4) != 0) {
            str2 = remoteConfigUpdateData.message;
        }
        if ((i2 & 8) != 0) {
            z = remoteConfigUpdateData.force;
        }
        return remoteConfigUpdateData.copy(i, str, str2, z);
    }

    public final int component1() {
        return this.version;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.message;
    }

    public final boolean component4() {
        return this.force;
    }

    public final RemoteConfigUpdateData copy(int i, String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(str2, "message");
        return new RemoteConfigUpdateData(i, str, str2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemoteConfigUpdateData)) {
            return false;
        }
        RemoteConfigUpdateData remoteConfigUpdateData = (RemoteConfigUpdateData) obj;
        return this.version == remoteConfigUpdateData.version && Intrinsics.areEqual(this.title, remoteConfigUpdateData.title) && Intrinsics.areEqual(this.message, remoteConfigUpdateData.message) && this.force == remoteConfigUpdateData.force;
    }

    public int hashCode() {
        int i = this.version * 31;
        String str = this.title;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.message;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode + i2) * 31;
        boolean z = this.force;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        return i3 + i4;
    }

    public String toString() {
        return "RemoteConfigUpdateData(version=" + this.version + ", title=" + this.title + ", message=" + this.message + ", force=" + this.force + ")";
    }

    public RemoteConfigUpdateData(int i, String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(str2, "message");
        this.version = i;
        this.title = str;
        this.message = str2;
        this.force = z;
    }

    public final boolean getForce() {
        return this.force;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getVersion() {
        return this.version;
    }
}
