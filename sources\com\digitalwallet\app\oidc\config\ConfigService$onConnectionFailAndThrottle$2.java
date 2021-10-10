package com.digitalwallet.app.oidc.config;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lorg/reactivestreams/Publisher;", "", "kotlin.jvm.PlatformType", "it", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: ConfigService.kt */
public final class ConfigService$onConnectionFailAndThrottle$2<T, R> implements Function<Throwable, Publisher<? extends Throwable>> {
    final /* synthetic */ ConfigService this$0;

    ConfigService$onConnectionFailAndThrottle$2(ConfigService configService) {
        this.this$0 = configService;
    }

    public final Publisher<? extends Throwable> apply(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        int incrementAndGet = new AtomicInteger(0).incrementAndGet();
        long[] jArr = this.this$0.throttle;
        int i = incrementAndGet - 1;
        return Flowable.just(th).delay((i < 0 || i > ArraysKt.getLastIndex(jArr)) ? ArraysKt.last(this.this$0.throttle) : jArr[i], TimeUnit.SECONDS);
    }
}
