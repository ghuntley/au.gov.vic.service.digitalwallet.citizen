package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothDevice;
import androidx.core.app.NotificationCompat;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a,\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003 \u0005*\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001j\u0004\u0018\u0001`\u00040\u0001j\u0002`\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "", "Landroid/bluetooth/BluetoothDevice;", "Lcom/digitalwallet/app/connection/ScannedDevices;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEClient.kt */
final class BLEClient$scan$2<V> implements Callable<Map<String, ? extends BluetoothDevice>> {
    final /* synthetic */ BLEClient this$0;

    BLEClient$scan$2(BLEClient bLEClient) {
        this.this$0 = bLEClient;
    }

    /* Return type fixed from 'java.util.Map<java.lang.String, android.bluetooth.BluetoothDevice>' to match base method */
    @Override // java.util.concurrent.Callable
    public final Map<String, ? extends BluetoothDevice> call() {
        return this.this$0.takeResults();
    }
}
