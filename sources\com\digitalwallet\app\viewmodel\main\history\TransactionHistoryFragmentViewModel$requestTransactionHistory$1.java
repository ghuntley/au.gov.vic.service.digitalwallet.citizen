package com.digitalwallet.app.viewmodel.main.history;

import com.digitalwallet.app.model.transaction.TransactionHistory;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/app/model/transaction/TransactionHistory;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: TransactionHistoryFragmentViewModel.kt */
public final class TransactionHistoryFragmentViewModel$requestTransactionHistory$1<T> implements Consumer<TransactionHistory> {
    final /* synthetic */ TransactionHistoryFragmentViewModel this$0;

    TransactionHistoryFragmentViewModel$requestTransactionHistory$1(TransactionHistoryFragmentViewModel transactionHistoryFragmentViewModel) {
        this.this$0 = transactionHistoryFragmentViewModel;
    }

    public final void accept(TransactionHistory transactionHistory) {
        if (transactionHistory.getTotalRecords() <= 0) {
            this.this$0.getShowNoTransactionView().set(true);
        }
        this.this$0.getShowHistoryList().set(true);
        this.this$0.getShowLoadingHUD().set(false);
    }
}
