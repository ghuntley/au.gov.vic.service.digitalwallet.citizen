package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothDevice;
import com.digitalwallet.app.utilities.WrapNull;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Lio/reactivex/ObservableSource;", "Lcom/digitalwallet/app/utilities/WrapNull;", "Lcom/digitalwallet/app/connection/NamedDevice;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "", "", "Landroid/bluetooth/BluetoothDevice;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEClient.kt */
public final class BLEClient$connectToAllPeers$2<T, R> implements Function<Map.Entry<? extends String, ? extends BluetoothDevice>, ObservableSource<? extends WrapNull<NamedDevice>>> {
    final /* synthetic */ BLEClient this$0;

    BLEClient$connectToAllPeers$2(BLEClient bLEClient) {
        this.this$0 = bLEClient;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ ObservableSource<? extends WrapNull<NamedDevice>> apply(Map.Entry<? extends String, ? extends BluetoothDevice> entry) {
        return apply((Map.Entry<String, BluetoothDevice>) entry);
    }

    public final ObservableSource<? extends WrapNull<NamedDevice>> apply(Map.Entry<String, BluetoothDevice> entry) {
        Intrinsics.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
        return ((Single) BLEClient.access$connect(this.this$0, entry.getValue()).getFirst()).flatMap(new Function<CallbackConnection, SingleSource<? extends WrapNull<NamedDevice>>>(this) {
            /* class com.digitalwallet.app.connection.BLEClient$connectToAllPeers$2.AnonymousClass2 */
            final /* synthetic */ BLEClient$connectToAllPeers$2 this$0;

            {
                this.this$0 = r1;
            }

            public final SingleSource<? extends WrapNull<NamedDevice>> apply(CallbackConnection callbackConnection) {
                Intrinsics.checkNotNullParameter(callbackConnection, "it");
                return BLEClient.access$discoverName(this.this$0.this$0, callbackConnection);
            }
        }).delay(100, TimeUnit.MILLISECONDS).toObservable();
    }
}
