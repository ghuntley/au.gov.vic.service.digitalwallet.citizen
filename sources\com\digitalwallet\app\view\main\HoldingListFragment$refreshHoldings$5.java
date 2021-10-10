package com.digitalwallet.app.view.main;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.digitalwallet.app.R;
import com.digitalwallet.app.model.HoldingAssets;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.view.main.adapter.CardListItem;
import com.digitalwallet.app.view.main.adapter.HoldingListAdapter;
import com.digitalwallet.utilities.AnalyticsHelper;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "holdings", "", "Lcom/digitalwallet/app/model/SecureHolding;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingListFragment.kt */
public final class HoldingListFragment$refreshHoldings$5<T> implements Consumer<List<? extends SecureHolding>> {
    final /* synthetic */ HoldingListFragment this$0;

    HoldingListFragment$refreshHoldings$5(HoldingListFragment holdingListFragment) {
        this.this$0 = holdingListFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(List<? extends SecureHolding> list) {
        accept((List<SecureHolding>) list);
    }

    public final void accept(List<SecureHolding> list) {
        int itemCount;
        Intrinsics.checkNotNullExpressionValue(list, "holdings");
        List<SecureHolding> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (T t : list2) {
            Context context = this.this$0.getContext();
            Intrinsics.checkNotNull(context);
            Intrinsics.checkNotNullExpressionValue(context, "context!!");
            arrayList.add(new CardListItem(t, new HoldingAssets(context, this.this$0.getAssetService(), t.getAssets(), null, null, 24, null)));
        }
        HoldingListAdapter holdingListAdapter = new HoldingListAdapter(arrayList);
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(R.id.cardListRecyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "cardListRecyclerView");
        HoldingListAdapter holdingListAdapter2 = (HoldingListAdapter) recyclerView.getAdapter();
        if (!(holdingListAdapter2 == null || (itemCount = holdingListAdapter.getItemCount() - holdingListAdapter2.getItemCount()) == 0)) {
            AnalyticsHelper.addCount$default(this.this$0.getAnalytics(), "card_count_change", itemCount, null, 4, null);
        }
        RecyclerView recyclerView2 = (RecyclerView) this.this$0._$_findCachedViewById(R.id.cardListRecyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "cardListRecyclerView");
        recyclerView2.setAdapter(holdingListAdapter);
        ((RecyclerView) this.this$0._$_findCachedViewById(R.id.cardListRecyclerView)).removeItemDecoration(this.this$0.pageIndicator);
        if (list.size() > 1) {
            HoldingListFragment holdingListFragment = this.this$0;
            RecyclerView recyclerView3 = (RecyclerView) holdingListFragment._$_findCachedViewById(R.id.cardListRecyclerView);
            Intrinsics.checkNotNullExpressionValue(recyclerView3, "cardListRecyclerView");
            holdingListFragment.updateViewForMultipleHoldings(recyclerView3);
        }
        CompositeDisposable compositeDisposable = this.this$0.disposables;
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(this.this$0.observeSelectedHolding(holdingListAdapter.getSelectedHolding()));
        spreadBuilder.addSpread(this.this$0.observeRenewals(list));
        compositeDisposable.addAll((Disposable[]) spreadBuilder.toArray(new Disposable[spreadBuilder.size()]));
    }
}
