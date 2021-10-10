package com.digitalwallet.app.view.main.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.ItemTransactionHistoryBinding;
import com.digitalwallet.app.model.transaction.TransactionHistoryItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0014\u0010\u0011\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/digitalwallet/app/view/main/adapter/TransactionInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/digitalwallet/app/view/main/adapter/TransactionInfoViewHolder;", "()V", "transactionHistories", "", "Lcom/digitalwallet/app/model/transaction/TransactionHistoryItem;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateList", "updates", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: TransactionInfoAdapter.kt */
public final class TransactionInfoAdapter extends RecyclerView.Adapter<TransactionInfoViewHolder> {
    private final List<TransactionHistoryItem> transactionHistories = new ArrayList();

    public final void updateList(List<TransactionHistoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "updates");
        this.transactionHistories.clear();
        this.transactionHistories.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TransactionInfoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemTransactionHistoryBinding itemTransactionHistoryBinding = (ItemTransactionHistoryBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_transaction_history, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(itemTransactionHistoryBinding, "binding");
        return new TransactionInfoViewHolder(itemTransactionHistoryBinding);
    }

    public void onBindViewHolder(TransactionInfoViewHolder transactionInfoViewHolder, int i) {
        Intrinsics.checkNotNullParameter(transactionInfoViewHolder, "holder");
        transactionInfoViewHolder.bind(this.transactionHistories.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.transactionHistories.size();
    }
}
