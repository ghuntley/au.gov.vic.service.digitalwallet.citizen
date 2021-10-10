package com.digitalwallet.app.viewmodel.harvester;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.digitalwallet.app.databinding.HarvesterItemJobBinding;
import com.digitalwallet.app.model.db.harvester.SavedHarvestJob;
import com.digitalwallet.app.view.harvester.HarvestView;
import com.digitalwallet.app.view.util.ClickMute;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/digitalwallet/app/viewmodel/harvester/HavestJobAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/digitalwallet/app/viewmodel/harvester/HarvestJobViewHolder;", Promotion.ACTION_VIEW, "Lcom/digitalwallet/app/view/harvester/HarvestView;", "jobs", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "", "Lcom/digitalwallet/app/model/db/harvester/SavedHarvestJob;", "(Lcom/digitalwallet/app/view/harvester/HarvestView;Lcom/jakewharton/rxrelay2/BehaviorRelay;)V", "clickMute", "Lcom/digitalwallet/app/view/util/ClickMute;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getItemCount", "", "getItemId", "", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestJobAdapter.kt */
public final class HavestJobAdapter extends RecyclerView.Adapter<HarvestJobViewHolder> {
    private ClickMute clickMute = new ClickMute(500);
    private CompositeDisposable disposables = new CompositeDisposable();
    private final BehaviorRelay<List<SavedHarvestJob>> jobs;
    private final HarvestView view;

    public HavestJobAdapter(HarvestView harvestView, BehaviorRelay<List<SavedHarvestJob>> behaviorRelay) {
        Intrinsics.checkNotNullParameter(harvestView, Promotion.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(behaviorRelay, "jobs");
        this.view = harvestView;
        this.jobs = behaviorRelay;
        this.disposables.add(behaviorRelay.subscribe(new Consumer<List<? extends SavedHarvestJob>>(this) {
            /* class com.digitalwallet.app.viewmodel.harvester.HavestJobAdapter.AnonymousClass1 */
            final /* synthetic */ HavestJobAdapter this$0;

            {
                this.this$0 = r1;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public /* bridge */ /* synthetic */ void accept(List<? extends SavedHarvestJob> list) {
                accept((List<SavedHarvestJob>) list);
            }

            public final void accept(List<SavedHarvestJob> list) {
                this.this$0.notifyDataSetChanged();
            }
        }));
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public HarvestJobViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        HarvesterItemJobBinding inflate = HarvesterItemJobBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "HarvesterItemJobBinding.…(inflater, parent, false)");
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        HarvestJobViewHolder harvestJobViewHolder = new HarvestJobViewHolder(root, this.view, this.clickMute);
        inflate.setVm(harvestJobViewHolder);
        return harvestJobViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<SavedHarvestJob> value = this.jobs.getValue();
        if (value != null) {
            return value.size();
        }
        return 0;
    }

    public void onBindViewHolder(HarvestJobViewHolder harvestJobViewHolder, int i) {
        Intrinsics.checkNotNullParameter(harvestJobViewHolder, "holder");
        List<SavedHarvestJob> value = this.jobs.getValue();
        if (value != null) {
            harvestJobViewHolder.bind(value.get(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        List<SavedHarvestJob> value = this.jobs.getValue();
        if (value != null) {
            Intrinsics.checkNotNullExpressionValue(value, "it");
            SavedHarvestJob savedHarvestJob = (SavedHarvestJob) CollectionsKt.getOrNull(value, i);
            Long id = savedHarvestJob != null ? savedHarvestJob.getId() : null;
            if (id != null) {
                return id.longValue();
            }
        }
        return -1;
    }
}
