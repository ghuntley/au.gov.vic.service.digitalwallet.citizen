package com.digitalwallet.app.viewmodel.splash;

import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
/* compiled from: SplashViewModel.kt */
public final class SplashViewModel$sam$java_util_concurrent_Callable$0 implements Callable {
    private final /* synthetic */ Function0 function;

    SplashViewModel$sam$java_util_concurrent_Callable$0(Function0 function0) {
        this.function = function0;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        return this.function.invoke();
    }
}
