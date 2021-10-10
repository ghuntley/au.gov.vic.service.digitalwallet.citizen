package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothGatt;
import com.digitalwallet.app.model.P2PHeader;
import com.digitalwallet.app.model.P2PMessage;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import timber.log.Timber;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "message", "Lcom/digitalwallet/app/model/P2PMessage;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: GattClientCallback.kt */
public final class GattClientCallback$readPerifHalfCharacteristic$1<T> implements Consumer<P2PMessage<?>> {
    final /* synthetic */ BluetoothGatt $gatt;
    final /* synthetic */ GattClientCallback this$0;

    GattClientCallback$readPerifHalfCharacteristic$1(GattClientCallback gattClientCallback, BluetoothGatt bluetoothGatt) {
        this.this$0 = gattClientCallback;
        this.$gatt = bluetoothGatt;
    }

    public final void accept(P2PMessage<?> p2PMessage) {
        P2PMessage p2PMessage2 = new P2PMessage(new P2PHeader(0, null, null, this.this$0.gattClientInterface.getSession(this.$gatt), p2PMessage.getHeader().getDestinationID(), 7, null), p2PMessage.getBody(), p2PMessage.getEncrypted(), p2PMessage.getSignature());
        Timber.Tree tree = this.this$0.getLog();
        tree.d("encdeets client deser: " + p2PMessage + ' ', new Object[0]);
        this.this$0.requestHolding(p2PMessage2, this.$gatt);
    }
}
