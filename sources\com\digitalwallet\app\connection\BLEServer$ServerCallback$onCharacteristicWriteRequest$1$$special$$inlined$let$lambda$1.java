package com.digitalwallet.app.connection;

import com.digitalwallet.app.model.P2PMessage;
import com.digitalwallet.app.model.RequestHolding;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.Objects;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "message", "Lcom/digitalwallet/app/model/P2PMessage;", "kotlin.jvm.PlatformType", "accept", "com/digitalwallet/app/connection/BLEServer$ServerCallback$onCharacteristicWriteRequest$1$3$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEServer.kt */
final class BLEServer$ServerCallback$onCharacteristicWriteRequest$1$$special$$inlined$let$lambda$1<T> implements Consumer<P2PMessage<?>> {
    final /* synthetic */ BLEServer$ServerCallback$onCharacteristicWriteRequest$1 this$0;

    BLEServer$ServerCallback$onCharacteristicWriteRequest$1$$special$$inlined$let$lambda$1(BLEServer$ServerCallback$onCharacteristicWriteRequest$1 bLEServer$ServerCallback$onCharacteristicWriteRequest$1) {
        this.this$0 = bLEServer$ServerCallback$onCharacteristicWriteRequest$1;
    }

    public final void accept(P2PMessage<?> p2PMessage) {
        Timber.d("request: " + p2PMessage + ' ', new Object[0]);
        BLEServer.this.requester = this.this$0.$device;
        PublishSubject<P2PMessage<RequestHolding>> bodySubject = BLEServer.this.getBodySubject();
        Objects.requireNonNull(p2PMessage, "null cannot be cast to non-null type com.digitalwallet.app.model.P2PMessage<com.digitalwallet.app.model.RequestHolding>");
        bodySubject.onNext(p2PMessage);
    }
}
