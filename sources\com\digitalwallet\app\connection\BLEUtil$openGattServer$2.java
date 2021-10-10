package com.digitalwallet.app.connection;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u00012\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u00050\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lorg/reactivestreams/Publisher;", "kotlin.jvm.PlatformType", "errors", "Lio/reactivex/Flowable;", "", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEUtil.kt */
public final class BLEUtil$openGattServer$2<T, R> implements Function<Flowable<Throwable>, Publisher<?>> {
    public static final BLEUtil$openGattServer$2 INSTANCE = new BLEUtil$openGattServer$2();

    BLEUtil$openGattServer$2() {
    }

    public final Publisher<?> apply(Flowable<Throwable> flowable) {
        Intrinsics.checkNotNullParameter(flowable, "errors");
        return flowable.flatMap(AnonymousClass1.INSTANCE);
    }
}
