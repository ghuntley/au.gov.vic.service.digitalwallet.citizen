package com.digitalwallet.app.connection;

import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/digitalwallet/app/connection/CallbackConnection;", "kotlin.jvm.PlatformType", "it", "Lcom/digitalwallet/app/connection/GattConnection;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEClient.kt */
final class BLEClient$connect$1$nextEvent$1<T, R> implements Function<GattConnection, CallbackConnection> {
    final /* synthetic */ GattClientCallback $callback;

    BLEClient$connect$1$nextEvent$1(GattClientCallback gattClientCallback) {
        this.$callback = gattClientCallback;
    }

    public final CallbackConnection apply(GattConnection gattConnection) {
        Intrinsics.checkNotNullParameter(gattConnection, "it");
        return new CallbackConnection(gattConnection.getConnected(), this.$callback);
    }
}
