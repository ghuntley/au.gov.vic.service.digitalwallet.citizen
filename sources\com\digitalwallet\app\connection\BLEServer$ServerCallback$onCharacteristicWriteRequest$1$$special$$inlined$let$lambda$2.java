package com.digitalwallet.app.connection;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "com/digitalwallet/app/connection/BLEServer$ServerCallback$onCharacteristicWriteRequest$1$3$2"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEServer.kt */
final class BLEServer$ServerCallback$onCharacteristicWriteRequest$1$$special$$inlined$let$lambda$2<T> implements Consumer<Throwable> {
    final /* synthetic */ BLEServer$ServerCallback$onCharacteristicWriteRequest$1 this$0;

    BLEServer$ServerCallback$onCharacteristicWriteRequest$1$$special$$inlined$let$lambda$2(BLEServer$ServerCallback$onCharacteristicWriteRequest$1 bLEServer$ServerCallback$onCharacteristicWriteRequest$1) {
        this.this$0 = bLEServer$ServerCallback$onCharacteristicWriteRequest$1;
    }

    public final void accept(Throwable th) {
        Timber.d("holding request failed to parse", new Object[0]);
        BLEServer.this.handshakeService.reset();
    }
}
