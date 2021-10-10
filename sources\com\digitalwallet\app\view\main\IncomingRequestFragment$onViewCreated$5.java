package com.digitalwallet.app.view.main;

import com.digitalwallet.utilities.RetrofitHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: IncomingRequestFragment.kt */
final /* synthetic */ class IncomingRequestFragment$onViewCreated$5 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    IncomingRequestFragment$onViewCreated$5(RetrofitHelper.Companion companion) {
        super(1, companion, RetrofitHelper.Companion.class, "filterHttpException", "filterHttpException(Ljava/lang/Throwable;)V", 0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke(th);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "p1");
        ((RetrofitHelper.Companion) this.receiver).filterHttpException(th);
    }
}
