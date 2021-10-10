package com.digitalwallet.app.view.main.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.digitalwallet.app.databinding.ItemTransactionHistoryBinding;
import com.digitalwallet.app.model.transaction.TransactionHistoryItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/digitalwallet/app/view/main/adapter/TransactionInfoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/digitalwallet/app/databinding/ItemTransactionHistoryBinding;", "(Lcom/digitalwallet/app/databinding/ItemTransactionHistoryBinding;)V", "getBinding", "()Lcom/digitalwallet/app/databinding/ItemTransactionHistoryBinding;", "bind", "", "item", "Lcom/digitalwallet/app/model/transaction/TransactionHistoryItem;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: TransactionInfoAdapter.kt */
public final class TransactionInfoViewHolder extends RecyclerView.ViewHolder {
    private final ItemTransactionHistoryBinding binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransactionInfoViewHolder(ItemTransactionHistoryBinding itemTransactionHistoryBinding) {
        super(itemTransactionHistoryBinding.getRoot());
        Intrinsics.checkNotNullParameter(itemTransactionHistoryBinding, "binding");
        this.binding = itemTransactionHistoryBinding;
    }

    public final ItemTransactionHistoryBinding getBinding() {
        return this.binding;
    }

    public final void bind(TransactionHistoryItem transactionHistoryItem) {
        Intrinsics.checkNotNullParameter(transactionHistoryItem, "item");
        this.binding.setVm(transactionHistoryItem);
        this.binding.executePendingBindings();
    }
}
