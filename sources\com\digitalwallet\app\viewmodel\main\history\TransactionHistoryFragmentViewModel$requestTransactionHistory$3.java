package com.digitalwallet.app.viewmodel.main.history;

import com.digitalwallet.app.model.transaction.TransactionHistoryItem;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "p1", "", "Lcom/digitalwallet/app/model/transaction/TransactionHistoryItem;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: TransactionHistoryFragmentViewModel.kt */
public final /* synthetic */ class TransactionHistoryFragmentViewModel$requestTransactionHistory$3 extends FunctionReferenceImpl implements Function1<List<? extends TransactionHistoryItem>, Unit> {
    TransactionHistoryFragmentViewModel$requestTransactionHistory$3(BehaviorSubject behaviorSubject) {
        super(1, behaviorSubject, BehaviorSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends TransactionHistoryItem> list) {
        invoke((List<TransactionHistoryItem>) list);
        return Unit.INSTANCE;
    }

    public final void invoke(List<TransactionHistoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "p1");
        ((BehaviorSubject) this.receiver).onNext(list);
    }
}
