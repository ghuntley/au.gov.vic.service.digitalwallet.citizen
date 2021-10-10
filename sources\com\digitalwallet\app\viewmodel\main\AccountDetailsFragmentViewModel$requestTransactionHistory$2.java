package com.digitalwallet.app.viewmodel.main;

import com.digitalwallet.app.model.transaction.TransactionHistoryItem;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/digitalwallet/app/model/transaction/TransactionHistoryItem;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: AccountDetailsFragmentViewModel.kt */
public final class AccountDetailsFragmentViewModel$requestTransactionHistory$2<T> implements Consumer<List<? extends TransactionHistoryItem>> {
    final /* synthetic */ AccountDetailsFragmentViewModel this$0;

    AccountDetailsFragmentViewModel$requestTransactionHistory$2(AccountDetailsFragmentViewModel accountDetailsFragmentViewModel) {
        this.this$0 = accountDetailsFragmentViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(List<? extends TransactionHistoryItem> list) {
        accept((List<TransactionHistoryItem>) list);
    }

    public final void accept(List<TransactionHistoryItem> list) {
        this.this$0.getTransHistoryItems().set(list);
        this.this$0.getErrorTransHistory().set(false);
        this.this$0.getLoadingTransHistory().set(false);
    }
}
