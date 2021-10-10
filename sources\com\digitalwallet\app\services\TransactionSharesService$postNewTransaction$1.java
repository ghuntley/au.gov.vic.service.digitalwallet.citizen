package com.digitalwallet.app.services;

import com.digitalwallet.app.model.transaction.TransactionHistory;
import com.digitalwallet.app.model.transaction.TransactionHistoryItem;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/digitalwallet/app/model/transaction/TransactionHistory;", "kotlin.jvm.PlatformType", "it", "Lcom/digitalwallet/app/model/transaction/TransactionHistoryItem;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: TransactionSharesService.kt */
public final class TransactionSharesService$postNewTransaction$1<T, R> implements Function<TransactionHistoryItem, TransactionHistory> {
    public static final TransactionSharesService$postNewTransaction$1 INSTANCE = new TransactionSharesService$postNewTransaction$1();

    TransactionSharesService$postNewTransaction$1() {
    }

    public final TransactionHistory apply(TransactionHistoryItem transactionHistoryItem) {
        Intrinsics.checkNotNullParameter(transactionHistoryItem, "it");
        return new TransactionHistory(1, CollectionsKt.listOf(transactionHistoryItem));
    }
}
