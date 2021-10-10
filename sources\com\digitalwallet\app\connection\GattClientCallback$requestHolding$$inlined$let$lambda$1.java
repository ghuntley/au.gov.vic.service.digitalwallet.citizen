package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import com.digitalwallet.app.model.SecureHolding;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "localHolding", "", "Lcom/digitalwallet/app/model/SecureHolding;", "kotlin.jvm.PlatformType", "accept", "com/digitalwallet/app/connection/GattClientCallback$requestHolding$1$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: GattClientCallback.kt */
public final class GattClientCallback$requestHolding$$inlined$let$lambda$1<T> implements Consumer<List<? extends SecureHolding>> {
    final /* synthetic */ BluetoothGatt $gatt$inlined;
    final /* synthetic */ BluetoothGattCharacteristic $requestCharacteristic;
    final /* synthetic */ GattClientCallback this$0;

    GattClientCallback$requestHolding$$inlined$let$lambda$1(BluetoothGattCharacteristic bluetoothGattCharacteristic, GattClientCallback gattClientCallback, BluetoothGatt bluetoothGatt) {
        this.$requestCharacteristic = bluetoothGattCharacteristic;
        this.this$0 = gattClientCallback;
        this.$gatt$inlined = bluetoothGatt;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(List<? extends SecureHolding> list) {
        accept((List<SecureHolding>) list);
    }

    public final void accept(List<SecureHolding> list) {
        try {
            GattClientCallback gattClientCallback = this.this$0;
            Intrinsics.checkNotNullExpressionValue(list, "localHolding");
            gattClientCallback.sendHoldingRequest(list, this.$gatt$inlined, this.$requestCharacteristic);
        } catch (Throwable th) {
            this.this$0.holdingError(th);
        }
    }
}
