package com.digitalwallet.app.viewmodel.login;

import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
/* compiled from: VerifyEmailViewModel.kt */
public final class VerifyEmailViewModel$sam$io_reactivex_functions_Function$0 implements Function {
    private final /* synthetic */ Function1 function;

    VerifyEmailViewModel$sam$io_reactivex_functions_Function$0(Function1 function1) {
        this.function = function1;
    }

    @Override // io.reactivex.functions.Function
    public final /* synthetic */ Object apply(Object obj) {
        return this.function.invoke(obj);
    }
}
