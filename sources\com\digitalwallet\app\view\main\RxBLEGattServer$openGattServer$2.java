package com.digitalwallet.app.view.main;

import android.bluetooth.BluetoothGattServer;
import io.reactivex.functions.Action;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
final class RxBLEGattServer$openGattServer$2 implements Action {
    final /* synthetic */ RxBLEGattServer this$0;

    RxBLEGattServer$openGattServer$2(RxBLEGattServer rxBLEGattServer) {
        this.this$0 = rxBLEGattServer;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        BluetoothGattServer server = this.this$0.getServer();
        if (server != null) {
            server.close();
        }
    }
}
