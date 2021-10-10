package com.digitalwallet.app.connection;

import com.digitalwallet.app.connection.BLEClient;
import io.reactivex.Completable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/connection/BLEScanDisabled;", "Lcom/digitalwallet/app/connection/BLEScanResult;", "()V", "immediateScanCheck", "Lio/reactivex/Completable;", "getImmediateScanCheck", "()Lio/reactivex/Completable;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: BLEScanCallback.kt */
public final class BLEScanDisabled implements BLEScanResult {
    private final Completable immediateScanCheck;

    public BLEScanDisabled() {
        Completable error = Completable.error(new BLEClient.ImmediateScanFail(-1));
        Intrinsics.checkNotNullExpressionValue(error, "Completable.error(BLEClient.ImmediateScanFail(-1))");
        this.immediateScanCheck = error;
    }

    @Override // com.digitalwallet.app.connection.BLEScanResult
    public Completable getImmediateScanCheck() {
        return this.immediateScanCheck;
    }
}
