package com.digitalwallet.app.view.main;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"GattNotConnected", "", "getGattNotConnected", "()Ljava/lang/Throwable;", "app_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
public final class RxBLEScannerKt {
    private static final Throwable GattNotConnected = new Throwable("Gatt Not Connected");

    public static final Throwable getGattNotConnected() {
        return GattNotConnected;
    }
}
