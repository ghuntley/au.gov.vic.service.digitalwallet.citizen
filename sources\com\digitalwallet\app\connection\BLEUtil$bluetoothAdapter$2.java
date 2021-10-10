package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/bluetooth/BluetoothAdapter;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEUtil.kt */
public final class BLEUtil$bluetoothAdapter$2 extends Lambda implements Function0<BluetoothAdapter> {
    final /* synthetic */ BLEUtil this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BLEUtil$bluetoothAdapter$2(BLEUtil bLEUtil) {
        super(0);
        this.this$0 = bLEUtil;
    }

    @Override // kotlin.jvm.functions.Function0
    public final BluetoothAdapter invoke() {
        return this.this$0.getBluetoothManager().getAdapter();
    }
}
