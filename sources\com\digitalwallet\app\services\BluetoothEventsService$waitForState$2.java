package com.digitalwallet.app.services;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import timber.log.Timber;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 0})
/* compiled from: BluetoothEventsService.kt */
public final class BluetoothEventsService$waitForState$2<T> implements Consumer<Integer> {
    public static final BluetoothEventsService$waitForState$2 INSTANCE = new BluetoothEventsService$waitForState$2();

    BluetoothEventsService$waitForState$2() {
    }

    public final void accept(Integer num) {
        Timber.d("State change hit: " + num, new Object[0]);
    }
}
