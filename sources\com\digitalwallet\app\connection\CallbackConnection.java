package com.digitalwallet.app.connection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/digitalwallet/app/connection/CallbackConnection;", "", "connected", "", "callback", "Lcom/digitalwallet/app/connection/GattClientCallback;", "(ZLcom/digitalwallet/app/connection/GattClientCallback;)V", "getCallback", "()Lcom/digitalwallet/app/connection/GattClientCallback;", "getConnected", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: BLEClient.kt */
public final class CallbackConnection {
    private final GattClientCallback callback;
    private final boolean connected;

    public static /* synthetic */ CallbackConnection copy$default(CallbackConnection callbackConnection, boolean z, GattClientCallback gattClientCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            z = callbackConnection.connected;
        }
        if ((i & 2) != 0) {
            gattClientCallback = callbackConnection.callback;
        }
        return callbackConnection.copy(z, gattClientCallback);
    }

    public final boolean component1() {
        return this.connected;
    }

    public final GattClientCallback component2() {
        return this.callback;
    }

    public final CallbackConnection copy(boolean z, GattClientCallback gattClientCallback) {
        Intrinsics.checkNotNullParameter(gattClientCallback, "callback");
        return new CallbackConnection(z, gattClientCallback);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallbackConnection)) {
            return false;
        }
        CallbackConnection callbackConnection = (CallbackConnection) obj;
        return this.connected == callbackConnection.connected && Intrinsics.areEqual(this.callback, callbackConnection.callback);
    }

    public int hashCode() {
        boolean z = this.connected;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = i * 31;
        GattClientCallback gattClientCallback = this.callback;
        return i4 + (gattClientCallback != null ? gattClientCallback.hashCode() : 0);
    }

    public String toString() {
        return "CallbackConnection(connected=" + this.connected + ", callback=" + this.callback + ")";
    }

    public CallbackConnection(boolean z, GattClientCallback gattClientCallback) {
        Intrinsics.checkNotNullParameter(gattClientCallback, "callback");
        this.connected = z;
        this.callback = gattClientCallback;
    }

    public final GattClientCallback getCallback() {
        return this.callback;
    }

    public final boolean getConnected() {
        return this.connected;
    }
}
