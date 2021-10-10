package com.digitalwallet.app.connection;

import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/SingleSource;", "Lcom/digitalwallet/app/connection/GattClientCallback;", "kotlin.jvm.PlatformType", "it", "Lcom/digitalwallet/app/connection/CallbackConnection;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEClient.kt */
final class BLEClient$requestHolding$request$1<T, R> implements Function<CallbackConnection, SingleSource<? extends GattClientCallback>> {
    final /* synthetic */ String $address;
    final /* synthetic */ BLEClient this$0;

    BLEClient$requestHolding$request$1(BLEClient bLEClient, String str) {
        this.this$0 = bLEClient;
        this.$address = str;
    }

    public final SingleSource<? extends GattClientCallback> apply(CallbackConnection callbackConnection) {
        Intrinsics.checkNotNullParameter(callbackConnection, "it");
        BLEClient bLEClient = this.this$0;
        String str = this.$address;
        Intrinsics.checkNotNullExpressionValue(str, AuthorizationRequest.Scope.ADDRESS);
        return bLEClient.handshake(str, callbackConnection);
    }
}
