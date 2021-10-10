package com.digitalwallet.app.view.main;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.digitalwallet.app.databinding.FragmentCardSyncBinding;
import com.digitalwallet.app.view.main.adapter.CardSyncListAdapter;
import com.digitalwallet.app.viewmodel.main.addsync.CardDetailItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/digitalwallet/app/viewmodel/main/addsync/CardDetailItem;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 0})
/* compiled from: CardSyncFragment.kt */
final class CardSyncFragment$onViewCreated$2<T> implements Observer<List<? extends CardDetailItem>> {
    final /* synthetic */ CardSyncFragment this$0;

    CardSyncFragment$onViewCreated$2(CardSyncFragment cardSyncFragment) {
        this.this$0 = cardSyncFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public /* bridge */ /* synthetic */ void onChanged(List<? extends CardDetailItem> list) {
        onChanged((List<CardDetailItem>) list);
    }

    public final void onChanged(List<CardDetailItem> list) {
        List<CardDetailItem> list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            RecyclerView recyclerView = ((FragmentCardSyncBinding) this.this$0.getBinding()).cardRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.cardRecyclerView");
            recyclerView.setLayoutManager(new LinearLayoutManager(this.this$0.getContext(), 1, false));
            RecyclerView recyclerView2 = ((FragmentCardSyncBinding) this.this$0.getBinding()).cardRecyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.cardRecyclerView");
            recyclerView2.setAdapter(new CardSyncListAdapter(list));
        }
    }
}
