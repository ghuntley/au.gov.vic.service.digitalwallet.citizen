package com.digitalwallet.app.oidc.config;

import io.reactivex.Flowable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/reactivex/Flowable;", "", "p1", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: ConfigService.kt */
public final /* synthetic */ class ConfigService$getBootstrapConfigFromRemote$3 extends FunctionReferenceImpl implements Function1<Flowable<Throwable>, Flowable<Throwable>> {
    ConfigService$getBootstrapConfigFromRemote$3(ConfigService configService) {
        super(1, configService, ConfigService.class, "onConnectionFailAndThrottle", "onConnectionFailAndThrottle(Lio/reactivex/Flowable;)Lio/reactivex/Flowable;", 0);
    }

    public final Flowable<Throwable> invoke(Flowable<Throwable> flowable) {
        Intrinsics.checkNotNullParameter(flowable, "p1");
        return ((ConfigService) this.receiver).onConnectionFailAndThrottle(flowable);
    }
}
