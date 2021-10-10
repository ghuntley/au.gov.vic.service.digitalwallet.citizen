package com.digitalwallet.app.connection;

import io.reactivex.functions.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/app/connection/GattConnection;", "test"}, k = 3, mv = {1, 4, 0})
/* compiled from: GattClientCallback.kt */
public final class GattClientCallback$setOnDisconnectSubscriber$1<T> implements Predicate<GattConnection> {
    public static final GattClientCallback$setOnDisconnectSubscriber$1 INSTANCE = new GattClientCallback$setOnDisconnectSubscriber$1();

    GattClientCallback$setOnDisconnectSubscriber$1() {
    }

    public final boolean test(GattConnection gattConnection) {
        Intrinsics.checkNotNullParameter(gattConnection, "it");
        return !gattConnection.getConnected();
    }
}
