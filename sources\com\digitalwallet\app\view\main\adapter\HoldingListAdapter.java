package com.digitalwallet.app.view.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.databinding.CardWithAffordancesBinding;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.view.main.HoldingElements;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0017B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/digitalwallet/app/view/main/adapter/HoldingListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/digitalwallet/app/view/main/adapter/HoldingListAdapter$CardItemViewHolder;", "cardsList", "", "Lcom/digitalwallet/app/view/main/adapter/CardListItem;", "(Ljava/util/List;)V", "selectedHolding", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/digitalwallet/app/model/SecureHolding;", "getSelectedHolding", "()Lio/reactivex/subjects/BehaviorSubject;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "CardItemViewHolder", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HoldingListAdapter.kt */
public final class HoldingListAdapter extends RecyclerView.Adapter<CardItemViewHolder> {
    private final List<CardListItem> cardsList;
    private final BehaviorSubject<SecureHolding> selectedHolding;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i;
    }

    public HoldingListAdapter(List<CardListItem> list) {
        Intrinsics.checkNotNullParameter(list, "cardsList");
        this.cardsList = list;
        BehaviorSubject<SecureHolding> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorSubject.create()");
        this.selectedHolding = create;
    }

    public final BehaviorSubject<SecureHolding> getSelectedHolding() {
        return this.selectedHolding;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cardsList.size();
    }

    public void onBindViewHolder(CardItemViewHolder cardItemViewHolder, int i) {
        Intrinsics.checkNotNullParameter(cardItemViewHolder, "holder");
        cardItemViewHolder.bind(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CardItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        HoldingElements holdingElements = this.cardsList.get(i).getHolding().getHoldingElements();
        ViewDataBinding inflate = DataBindingUtil.inflate(from, R.layout.card_with_affordances, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…fordances, parent, false)");
        CardWithAffordancesBinding cardWithAffordancesBinding = (CardWithAffordancesBinding) inflate;
        ViewDataBinding inflate2 = DataBindingUtil.inflate(from, holdingElements.getFront(), cardWithAffordancesBinding.card.cardContainer, true);
        Intrinsics.checkNotNullExpressionValue(inflate2, "DataBindingUtil.inflate(…card.cardContainer, true)");
        ViewDataBinding inflate3 = DataBindingUtil.inflate(from, holdingElements.getAffordances(), cardWithAffordancesBinding.cardAffordances, true);
        Intrinsics.checkNotNullExpressionValue(inflate3, "DataBindingUtil.inflate(…ng.cardAffordances, true)");
        View root = cardWithAffordancesBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        FrameLayout frameLayout = cardWithAffordancesBinding.card.cardContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.card.cardContainer");
        return new CardItemViewHolder(this, root, frameLayout, inflate2, inflate3);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/digitalwallet/app/view/main/adapter/HoldingListAdapter$CardItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "root", "Landroid/view/View;", "cardContainer", "Landroid/view/ViewGroup;", "cardBinding", "Landroidx/databinding/ViewDataBinding;", "affordancesBinding", "(Lcom/digitalwallet/app/view/main/adapter/HoldingListAdapter;Landroid/view/View;Landroid/view/ViewGroup;Landroidx/databinding/ViewDataBinding;Landroidx/databinding/ViewDataBinding;)V", "bind", "", FirebaseAnalytics.Param.INDEX, "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: HoldingListAdapter.kt */
    public final class CardItemViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding affordancesBinding;
        private final ViewDataBinding cardBinding;
        private final ViewGroup cardContainer;
        final /* synthetic */ HoldingListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CardItemViewHolder(HoldingListAdapter holdingListAdapter, View view, ViewGroup viewGroup, ViewDataBinding viewDataBinding, ViewDataBinding viewDataBinding2) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "root");
            Intrinsics.checkNotNullParameter(viewGroup, "cardContainer");
            Intrinsics.checkNotNullParameter(viewDataBinding, "cardBinding");
            Intrinsics.checkNotNullParameter(viewDataBinding2, "affordancesBinding");
            this.this$0 = holdingListAdapter;
            this.cardContainer = viewGroup;
            this.cardBinding = viewDataBinding;
            this.affordancesBinding = viewDataBinding2;
        }

        public final void bind(int i) {
            ViewDataBinding viewDataBinding = this.affordancesBinding;
            viewDataBinding.setVariable(BR.holding, ((CardListItem) this.this$0.cardsList.get(i)).getHolding());
            viewDataBinding.setVariable(BR.assets, ((CardListItem) this.this$0.cardsList.get(i)).getAssets());
            viewDataBinding.executePendingBindings();
            ViewDataBinding viewDataBinding2 = this.cardBinding;
            viewDataBinding2.setVariable(BR.holding, ((CardListItem) this.this$0.cardsList.get(i)).getHolding());
            viewDataBinding2.setVariable(BR.vm, ((CardListItem) this.this$0.cardsList.get(i)).getHolding().getAttributes());
            viewDataBinding2.setVariable(BR.assets, ((CardListItem) this.this$0.cardsList.get(i)).getAssets());
            viewDataBinding2.executePendingBindings();
            this.cardContainer.setOnClickListener(new HoldingListAdapter$CardItemViewHolder$bind$3(this, i));
        }
    }
}
