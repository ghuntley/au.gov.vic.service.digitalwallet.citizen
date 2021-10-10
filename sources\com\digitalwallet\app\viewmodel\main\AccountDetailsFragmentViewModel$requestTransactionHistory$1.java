package com.digitalwallet.app.viewmodel.main;

import com.digitalwallet.app.model.transaction.TransactionHistory;
import com.digitalwallet.app.model.transaction.TransactionHistoryItem;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lcom/digitalwallet/app/model/transaction/TransactionHistoryItem;", "kotlin.jvm.PlatformType", "it", "Lcom/digitalwallet/app/model/transaction/TransactionHistory;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: AccountDetailsFragmentViewModel.kt */
public final class AccountDetailsFragmentViewModel$requestTransactionHistory$1<T, R> implements Function<TransactionHistory, List<? extends TransactionHistoryItem>> {
    public static final AccountDetailsFragmentViewModel$requestTransactionHistory$1 INSTANCE = new AccountDetailsFragmentViewModel$requestTransactionHistory$1();

    AccountDetailsFragmentViewModel$requestTransactionHistory$1() {
    }

    public final List<TransactionHistoryItem> apply(TransactionHistory transactionHistory) {
        Intrinsics.checkNotNullParameter(transactionHistory, "it");
        return transactionHistory.getRecords();
    }
}
