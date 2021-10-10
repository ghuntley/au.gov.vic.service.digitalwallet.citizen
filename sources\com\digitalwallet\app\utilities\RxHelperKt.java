package com.digitalwallet.app.utilities;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¨\u0006\u0006"}, d2 = {"andThenWrapError", "Lio/reactivex/Completable;", "execute", "Lkotlin/Function1;", "Lio/reactivex/CompletableObserver;", "", "app_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: RxHelper.kt */
public final class RxHelperKt {
    public static final Completable andThenWrapError(Completable completable, Function1<? super CompletableObserver, Unit> function1) {
        Intrinsics.checkNotNullParameter(completable, "$this$andThenWrapError");
        Intrinsics.checkNotNullParameter(function1, "execute");
        Completable andThen = completable.andThen(new RxHelperKt$andThenWrapError$1(function1));
        Intrinsics.checkNotNullExpressionValue(andThen, "andThen { co ->\n        …nError(t)\n        }\n    }");
        return andThen;
    }
}
