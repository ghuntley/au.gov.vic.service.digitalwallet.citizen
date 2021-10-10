package com.digitalwallet.app.connection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/digitalwallet/app/connection/GattConnection;", "", AuthorizationRequest.Scope.ADDRESS, "", "connected", "", "(Ljava/lang/String;Z)V", "getAddress", "()Ljava/lang/String;", "getConnected", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: GattClientCallback.kt */
public final class GattConnection {
    private final String address;
    private final boolean connected;

    public static /* synthetic */ GattConnection copy$default(GattConnection gattConnection, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gattConnection.address;
        }
        if ((i & 2) != 0) {
            z = gattConnection.connected;
        }
        return gattConnection.copy(str, z);
    }

    public final String component1() {
        return this.address;
    }

    public final boolean component2() {
        return this.connected;
    }

    public final GattConnection copy(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, AuthorizationRequest.Scope.ADDRESS);
        return new GattConnection(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GattConnection)) {
            return false;
        }
        GattConnection gattConnection = (GattConnection) obj;
        return Intrinsics.areEqual(this.address, gattConnection.address) && this.connected == gattConnection.connected;
    }

    public int hashCode() {
        String str = this.address;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.connected;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return hashCode + i;
    }

    public String toString() {
        return "GattConnection(address=" + this.address + ", connected=" + this.connected + ")";
    }

    public GattConnection(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, AuthorizationRequest.Scope.ADDRESS);
        this.address = str;
        this.connected = z;
    }

    public final String getAddress() {
        return this.address;
    }

    public final boolean getConnected() {
        return this.connected;
    }
}
