package com.digitalwallet.app.viewmodel.main;

import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
/* compiled from: EligibilityScannerFragmentViewModel.kt */
final class EligibilityScannerFragmentViewModel$sam$io_reactivex_functions_Function$0 implements Function {
    private final /* synthetic */ Function1 function;

    EligibilityScannerFragmentViewModel$sam$io_reactivex_functions_Function$0(Function1 function1) {
        this.function = function1;
    }

    @Override // io.reactivex.functions.Function
    public final /* synthetic */ Object apply(Object obj) {
        return this.function.invoke(obj);
    }
}
