package com.digitalwallet.app.utilities;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "co", "Lio/reactivex/CompletableObserver;", "subscribe"}, k = 3, mv = {1, 4, 0})
/* compiled from: RxHelper.kt */
final class RxHelperKt$andThenWrapError$1 implements CompletableSource {
    final /* synthetic */ Function1 $execute;

    RxHelperKt$andThenWrapError$1(Function1 function1) {
        this.$execute = function1;
    }

    @Override // io.reactivex.CompletableSource
    public final void subscribe(CompletableObserver completableObserver) {
        Intrinsics.checkNotNullParameter(completableObserver, "co");
        try {
            this.$execute.invoke(completableObserver);
        } catch (Throwable th) {
            completableObserver.onError(th);
        }
    }
}
