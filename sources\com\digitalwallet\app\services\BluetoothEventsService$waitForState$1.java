package com.digitalwallet.app.services;

import io.reactivex.functions.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "test", "(Ljava/lang/Integer;)Z"}, k = 3, mv = {1, 4, 0})
/* compiled from: BluetoothEventsService.kt */
public final class BluetoothEventsService$waitForState$1<T> implements Predicate<Integer> {
    final /* synthetic */ int $state;

    BluetoothEventsService$waitForState$1(int i) {
        this.$state = i;
    }

    public final boolean test(Integer num) {
        Intrinsics.checkNotNullParameter(num, "it");
        return num.intValue() == this.$state;
    }
}
