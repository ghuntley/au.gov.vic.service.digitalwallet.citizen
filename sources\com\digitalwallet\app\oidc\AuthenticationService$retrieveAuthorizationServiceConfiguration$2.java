package com.digitalwallet.app.oidc;

import io.reactivex.functions.BiPredicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationException;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "attempt", "", "error", "", "test", "(Ljava/lang/Integer;Ljava/lang/Throwable;)Z"}, k = 3, mv = {1, 4, 0})
/* compiled from: AuthenticationService.kt */
public final class AuthenticationService$retrieveAuthorizationServiceConfiguration$2<T1, T2> implements BiPredicate<Integer, Throwable> {
    public static final AuthenticationService$retrieveAuthorizationServiceConfiguration$2 INSTANCE = new AuthenticationService$retrieveAuthorizationServiceConfiguration$2();

    AuthenticationService$retrieveAuthorizationServiceConfiguration$2() {
    }

    public final boolean test(Integer num, Throwable th) {
        Intrinsics.checkNotNullParameter(num, "attempt");
        Intrinsics.checkNotNullParameter(th, "error");
        return Intrinsics.areEqual(th, AuthorizationException.GeneralErrors.NETWORK_ERROR) && Intrinsics.compare(num.intValue(), 3) < 0;
    }
}
