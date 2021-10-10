package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/bluetooth/BluetoothManager;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEServer.kt */
public final class BLEServer$bluetoothManager$2 extends Lambda implements Function0<BluetoothManager> {
    final /* synthetic */ BLEServer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BLEServer$bluetoothManager$2(BLEServer bLEServer) {
        super(0);
        this.this$0 = bLEServer;
    }

    @Override // kotlin.jvm.functions.Function0
    public final BluetoothManager invoke() {
        Object systemService = this.this$0.application.getSystemService("bluetooth");
        if (!(systemService instanceof BluetoothManager)) {
            systemService = null;
        }
        return (BluetoothManager) systemService;
    }
}
