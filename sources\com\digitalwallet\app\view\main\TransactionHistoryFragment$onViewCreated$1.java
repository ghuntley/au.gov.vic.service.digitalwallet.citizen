package com.digitalwallet.app.view.main;

import com.digitalwallet.app.model.transaction.TransactionHistoryItem;
import com.digitalwallet.app.view.main.adapter.TransactionInfoAdapter;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/digitalwallet/app/model/transaction/TransactionHistoryItem;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: TransactionHistoryFragment.kt */
final class TransactionHistoryFragment$onViewCreated$1<T> implements Consumer<List<? extends TransactionHistoryItem>> {
    final /* synthetic */ TransactionHistoryFragment this$0;

    TransactionHistoryFragment$onViewCreated$1(TransactionHistoryFragment transactionHistoryFragment) {
        this.this$0 = transactionHistoryFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(List<? extends TransactionHistoryItem> list) {
        accept((List<TransactionHistoryItem>) list);
    }

    public final void accept(List<TransactionHistoryItem> list) {
        TransactionInfoAdapter transactionInfoAdapter = this.this$0.transactionInfoAdapter;
        Intrinsics.checkNotNullExpressionValue(list, "it");
        transactionInfoAdapter.updateList(list);
    }
}
