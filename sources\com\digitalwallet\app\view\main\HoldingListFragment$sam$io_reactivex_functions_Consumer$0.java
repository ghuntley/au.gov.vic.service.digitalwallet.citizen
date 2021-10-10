package com.digitalwallet.app.view.main;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingListFragment.kt */
public final class HoldingListFragment$sam$io_reactivex_functions_Consumer$0 implements Consumer {
    private final /* synthetic */ Function1 function;

    HoldingListFragment$sam$io_reactivex_functions_Consumer$0(Function1 function1) {
        this.function = function1;
    }

    @Override // io.reactivex.functions.Consumer
    public final /* synthetic */ void accept(Object obj) {
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(obj), "invoke(...)");
    }
}
