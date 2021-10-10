package com.digitalwallet.app.viewmodel.main.history;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: TransactionHistoryFragmentViewModel.kt */
public final /* synthetic */ class TransactionHistoryFragmentViewModel$requestTransactionHistory$4 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    TransactionHistoryFragmentViewModel$requestTransactionHistory$4(TransactionHistoryFragmentViewModel transactionHistoryFragmentViewModel) {
        super(1, transactionHistoryFragmentViewModel, TransactionHistoryFragmentViewModel.class, "showErrorState", "showErrorState(Ljava/lang/Throwable;)V", 0);
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
        ((TransactionHistoryFragmentViewModel) this.receiver).showErrorState(th);
    }
}
