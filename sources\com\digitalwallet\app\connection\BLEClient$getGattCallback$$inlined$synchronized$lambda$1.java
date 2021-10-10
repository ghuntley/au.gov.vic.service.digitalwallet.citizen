package com.digitalwallet.app.connection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0007"}, d2 = {"<anonymous>", "", "connection", "Lcom/digitalwallet/app/connection/GattConnection;", "invoke", "com/digitalwallet/app/connection/BLEClient$getGattCallback$1$2$1$1", "com/digitalwallet/app/connection/BLEClient$$special$$inlined$also$lambda$1", "com/digitalwallet/app/connection/BLEClient$$special$$inlined$run$lambda$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEClient.kt */
final class BLEClient$getGattCallback$$inlined$synchronized$lambda$1 extends Lambda implements Function1<GattConnection, Unit> {
    final /* synthetic */ String $address$inlined;
    final /* synthetic */ GattClientCallback $it;
    final /* synthetic */ BLEClient $this_run$inlined;
    final /* synthetic */ BLEClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BLEClient$getGattCallback$$inlined$synchronized$lambda$1(GattClientCallback gattClientCallback, BLEClient bLEClient, BLEClient bLEClient2, String str) {
        super(1);
        this.$it = gattClientCallback;
        this.$this_run$inlined = bLEClient;
        this.this$0 = bLEClient2;
        this.$address$inlined = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GattConnection gattConnection) {
        invoke(gattConnection);
        return Unit.INSTANCE;
    }

    public final void invoke(GattConnection gattConnection) {
        Intrinsics.checkNotNullParameter(gattConnection, "connection");
        synchronized (BLEClient.access$getGattCallbacks$p(this.$this_run$inlined)) {
            if (Intrinsics.areEqual((GattClientCallback) BLEClient.access$getGattCallbacks$p(this.$this_run$inlined).get(gattConnection.getAddress()), this.$it)) {
                BLEClient.access$disconnected(this.$this_run$inlined, gattConnection.getAddress());
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
