package com.digitalwallet.app.connection;

import com.digitalwallet.app.connection.HoldingRequestState;
import com.digitalwallet.app.model.P2PMessage;
import io.reactivex.functions.Consumer;
import java.util.Objects;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "message", "Lcom/digitalwallet/app/model/P2PMessage;", "kotlin.jvm.PlatformType", "accept", "com/digitalwallet/app/connection/GattClientCallback$readHoldingCharacteristic$1$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: GattClientCallback.kt */
public final class GattClientCallback$readHoldingCharacteristic$$inlined$also$lambda$1<T> implements Consumer<P2PMessage<?>> {
    final /* synthetic */ GattClientCallback this$0;

    GattClientCallback$readHoldingCharacteristic$$inlined$also$lambda$1(GattClientCallback gattClientCallback) {
        this.this$0 = gattClientCallback;
    }

    public final void accept(P2PMessage<?> p2PMessage) {
        Objects.requireNonNull(p2PMessage, "null cannot be cast to non-null type com.digitalwallet.app.model.P2PMessage<com.digitalwallet.app.model.ShareHolding>");
        this.this$0.getHoldingRequestEvents().accept(new HoldingRequestState.Received(p2PMessage));
        this.this$0.handshakeService.reset();
    }
}
