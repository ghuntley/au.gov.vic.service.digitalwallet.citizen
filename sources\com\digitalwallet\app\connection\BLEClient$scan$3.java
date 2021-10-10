package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothDevice;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "Lio/reactivex/SingleSource;", "", "Lcom/digitalwallet/app/connection/NamedDevice;", "kotlin.jvm.PlatformType", "it", "", "", "Landroid/bluetooth/BluetoothDevice;", "Lcom/digitalwallet/app/connection/ScannedDevices;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEClient.kt */
final class BLEClient$scan$3<T, R> implements Function<Map<String, ? extends BluetoothDevice>, SingleSource<? extends List<? extends NamedDevice>>> {
    final /* synthetic */ long $connectTimeout;
    final /* synthetic */ BLEClient this$0;

    BLEClient$scan$3(BLEClient bLEClient, long j) {
        this.this$0 = bLEClient;
        this.$connectTimeout = j;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ SingleSource<? extends List<? extends NamedDevice>> apply(Map<String, ? extends BluetoothDevice> map) {
        return apply((Map<String, BluetoothDevice>) map);
    }

    public final SingleSource<? extends List<NamedDevice>> apply(Map<String, BluetoothDevice> map) {
        Intrinsics.checkNotNullParameter(map, "it");
        return this.this$0.connectToAllPeers(map, this.$connectTimeout);
    }
}
