package com.digitalwallet.app.view.main.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.digitalwallet.app.databinding.CardDetailBinding;
import com.digitalwallet.app.viewmodel.main.addsync.CardDetailItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/digitalwallet/app/view/main/adapter/CardSyncListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/digitalwallet/app/view/main/adapter/CardSyncListAdapter$CardDetailHolder;", "cards", "", "Lcom/digitalwallet/app/viewmodel/main/addsync/CardDetailItem;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "CardDetailHolder", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CardSyncListAdapter.kt */
public final class CardSyncListAdapter extends RecyclerView.Adapter<CardDetailHolder> {
    private final List<CardDetailItem> cards;

    public CardSyncListAdapter(List<CardDetailItem> list) {
        Intrinsics.checkNotNullParameter(list, "cards");
        this.cards = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CardDetailHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        CardDetailBinding inflate = CardDetailBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "CardDetailBinding.inflat…tInflater, parent, false)");
        return new CardDetailHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cards.size();
    }

    public void onBindViewHolder(CardDetailHolder cardDetailHolder, int i) {
        Intrinsics.checkNotNullParameter(cardDetailHolder, "holder");
        cardDetailHolder.bind(this.cards.get(i));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/digitalwallet/app/view/main/adapter/CardSyncListAdapter$CardDetailHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/digitalwallet/app/databinding/CardDetailBinding;", "(Lcom/digitalwallet/app/databinding/CardDetailBinding;)V", "getBinding", "()Lcom/digitalwallet/app/databinding/CardDetailBinding;", "bind", "", "item", "Lcom/digitalwallet/app/viewmodel/main/addsync/CardDetailItem;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CardSyncListAdapter.kt */
    public static final class CardDetailHolder extends RecyclerView.ViewHolder {
        private final CardDetailBinding binding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CardDetailHolder(CardDetailBinding cardDetailBinding) {
            super(cardDetailBinding.getRoot());
            Intrinsics.checkNotNullParameter(cardDetailBinding, "binding");
            this.binding = cardDetailBinding;
        }

        public final CardDetailBinding getBinding() {
            return this.binding;
        }

        public final void bind(CardDetailItem cardDetailItem) {
            Intrinsics.checkNotNullParameter(cardDetailItem, "item");
            this.binding.setVm(cardDetailItem);
        }
    }
}
