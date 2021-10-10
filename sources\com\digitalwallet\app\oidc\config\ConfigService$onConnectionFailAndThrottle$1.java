package com.digitalwallet.app.oidc.config;

import io.reactivex.functions.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import retrofit2.HttpException;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "test"}, k = 3, mv = {1, 4, 0})
/* compiled from: ConfigService.kt */
public final class ConfigService$onConnectionFailAndThrottle$1<T> implements Predicate<Throwable> {
    public static final ConfigService$onConnectionFailAndThrottle$1 INSTANCE = new ConfigService$onConnectionFailAndThrottle$1();

    ConfigService$onConnectionFailAndThrottle$1() {
    }

    public final boolean test(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        IntRange intRange = new IntRange(500, 599);
        Integer num = null;
        if (!(th instanceof HttpException)) {
            th = null;
        }
        HttpException httpException = (HttpException) th;
        if (httpException != null) {
            num = Integer.valueOf(httpException.code());
        }
        return num != null && intRange.contains(num.intValue());
    }
}
