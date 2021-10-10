package com.digitalwallet.app.connection;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: GattClientCallback.kt */
public final class GattClientCallback$readPerifHalfCharacteristic$2<T> implements Consumer<Throwable> {
    final /* synthetic */ GattClientCallback this$0;

    GattClientCallback$readPerifHalfCharacteristic$2(GattClientCallback gattClientCallback) {
        this.this$0 = gattClientCallback;
    }

    public final void accept(Throwable th) {
        GattClientCallback gattClientCallback = this.this$0;
        Intrinsics.checkNotNullExpressionValue(th, "error");
        gattClientCallback.holdingError(th);
    }
}
