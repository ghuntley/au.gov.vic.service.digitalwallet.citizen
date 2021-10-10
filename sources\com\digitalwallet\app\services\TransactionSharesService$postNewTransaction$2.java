package com.digitalwallet.app.services;

import com.digitalwallet.app.api.HoldingsApi;
import com.digitalwallet.app.model.transaction.TransactionHistory;
import io.reactivex.Completable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/reactivex/Completable;", "p1", "Lcom/digitalwallet/app/model/transaction/TransactionHistory;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: TransactionSharesService.kt */
public final /* synthetic */ class TransactionSharesService$postNewTransaction$2 extends FunctionReferenceImpl implements Function1<TransactionHistory, Completable> {
    TransactionSharesService$postNewTransaction$2(HoldingsApi holdingsApi) {
        super(1, holdingsApi, HoldingsApi.class, "postNewTransactions", "postNewTransactions(Lcom/digitalwallet/app/model/transaction/TransactionHistory;)Lio/reactivex/Completable;", 0);
    }

    public final Completable invoke(TransactionHistory transactionHistory) {
        Intrinsics.checkNotNullParameter(transactionHistory, "p1");
        return ((HoldingsApi) this.receiver).postNewTransactions(transactionHistory);
    }
}
