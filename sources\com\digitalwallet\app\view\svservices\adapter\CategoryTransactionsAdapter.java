package com.digitalwallet.app.view.svservices.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.digitalwallet.app.databinding.ItemSvServiceTitleActionBinding;
import com.digitalwallet.app.viewmodel.svservices.TitleActionVM;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0010B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\bH\u0016J\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/digitalwallet/app/view/svservices/adapter/CategoryTransactionsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/digitalwallet/app/view/svservices/adapter/CategoryTransactionsAdapter$CategoryTransactionViewHolder;", "transactionVMs", "", "Lcom/digitalwallet/app/viewmodel/svservices/TitleActionVM;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "CategoryTransactionViewHolder", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CategoryTransactionsAdapter.kt */
public final class CategoryTransactionsAdapter extends RecyclerView.Adapter<CategoryTransactionViewHolder> {
    private final List<TitleActionVM> transactionVMs;

    public CategoryTransactionsAdapter(List<TitleActionVM> list) {
        Intrinsics.checkNotNullParameter(list, "transactionVMs");
        this.transactionVMs = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CategoryTransactionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemSvServiceTitleActionBinding inflate = ItemSvServiceTitleActionBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "ItemSvServiceTitleAction…tInflater, parent, false)");
        return new CategoryTransactionViewHolder(this, inflate);
    }

    public void onBindViewHolder(CategoryTransactionViewHolder categoryTransactionViewHolder, int i) {
        Intrinsics.checkNotNullParameter(categoryTransactionViewHolder, "viewHolder");
        categoryTransactionViewHolder.bind(this.transactionVMs.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.transactionVMs.size();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/view/svservices/adapter/CategoryTransactionsAdapter$CategoryTransactionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/digitalwallet/app/databinding/ItemSvServiceTitleActionBinding;", "(Lcom/digitalwallet/app/view/svservices/adapter/CategoryTransactionsAdapter;Lcom/digitalwallet/app/databinding/ItemSvServiceTitleActionBinding;)V", "bind", "", "transactionVM", "Lcom/digitalwallet/app/viewmodel/svservices/TitleActionVM;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CategoryTransactionsAdapter.kt */
    public final class CategoryTransactionViewHolder extends RecyclerView.ViewHolder {
        private final ItemSvServiceTitleActionBinding binding;
        final /* synthetic */ CategoryTransactionsAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CategoryTransactionViewHolder(CategoryTransactionsAdapter categoryTransactionsAdapter, ItemSvServiceTitleActionBinding itemSvServiceTitleActionBinding) {
            super(itemSvServiceTitleActionBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemSvServiceTitleActionBinding, "binding");
            this.this$0 = categoryTransactionsAdapter;
            this.binding = itemSvServiceTitleActionBinding;
        }

        public final void bind(TitleActionVM titleActionVM) {
            Intrinsics.checkNotNullParameter(titleActionVM, "transactionVM");
            this.binding.setVm(titleActionVM);
            this.binding.executePendingBindings();
        }
    }
}
