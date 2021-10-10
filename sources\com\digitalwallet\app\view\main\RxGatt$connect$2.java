package com.digitalwallet.app.view.main;

import android.bluetooth.BluetoothGatt;
import io.reactivex.functions.Action;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
final class RxGatt$connect$2 implements Action {
    final /* synthetic */ RxGatt this$0;

    RxGatt$connect$2(RxGatt rxGatt) {
        this.this$0 = rxGatt;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        BluetoothGatt access$getGatt$p = RxGatt.access$getGatt$p(this.this$0);
        if (access$getGatt$p != null) {
            access$getGatt$p.close();
        }
    }
}
