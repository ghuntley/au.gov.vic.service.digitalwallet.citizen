package com.digitalwallet.app.connection;

import com.digitalwallet.app.connection.BLEClient;
import com.digitalwallet.app.utilities.WrapNull;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lio/reactivex/SingleSource;", "Lcom/digitalwallet/app/connection/GattClientCallback;", "kotlin.jvm.PlatformType", "it", "Lcom/digitalwallet/app/utilities/WrapNull;", "Lcom/digitalwallet/app/connection/NamedDevice;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEClient.kt */
final class BLEClient$handshake$1<T, R> implements Function<WrapNull<NamedDevice>, SingleSource<? extends GattClientCallback>> {
    final /* synthetic */ String $address;
    final /* synthetic */ BluetoothConnection $connection;
    final /* synthetic */ GattClientCallback $gattCallback;
    final /* synthetic */ BLEClient this$0;

    BLEClient$handshake$1(BLEClient bLEClient, String str, GattClientCallback gattClientCallback, BluetoothConnection bluetoothConnection) {
        this.this$0 = bLEClient;
        this.$address = str;
        this.$gattCallback = gattClientCallback;
        this.$connection = bluetoothConnection;
    }

    public final SingleSource<? extends GattClientCallback> apply(WrapNull<NamedDevice> wrapNull) {
        Single single;
        Intrinsics.checkNotNullParameter(wrapNull, "it");
        UUID uuid = (UUID) BLEClient.access$getSessions$p(this.this$0).get(this.$address);
        if (uuid == null) {
            uuid = UUID.randomUUID();
        }
        Map access$getSessions$p = BLEClient.access$getSessions$p(this.this$0);
        String str = this.$address;
        Intrinsics.checkNotNullExpressionValue(uuid, "sessionUuid");
        access$getSessions$p.put(str, uuid);
        if (wrapNull.getValue() == null) {
            single = Single.error(new BLEClient.HandshakeServiceError());
        } else {
            this.$gattCallback.startHandshake(uuid, this.$connection.getGatt());
            single = Single.just(this.$gattCallback);
        }
        return single;
    }
}
