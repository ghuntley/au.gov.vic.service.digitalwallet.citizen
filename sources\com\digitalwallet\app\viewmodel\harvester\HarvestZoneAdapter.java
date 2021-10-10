package com.digitalwallet.app.viewmodel.harvester;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.digitalwallet.app.databinding.HarvesterItemZoneBinding;
import com.digitalwallet.app.model.KangarooHarvesterQuota;
import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/digitalwallet/app/viewmodel/harvester/HarvestZoneAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/digitalwallet/app/viewmodel/harvester/HarvestZoneViewHolder;", "viewModel", "Lcom/digitalwallet/app/viewmodel/harvester/HarvestJobWizardViewModel;", "(Lcom/digitalwallet/app/viewmodel/harvester/HarvestJobWizardViewModel;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "quotas", "", "Lcom/digitalwallet/app/model/KangarooHarvesterQuota;", "selection", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "", "kotlin.jvm.PlatformType", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestZoneAdapter.kt */
public final class HarvestZoneAdapter extends RecyclerView.Adapter<HarvestZoneViewHolder> {
    private final CompositeDisposable disposables;
    private List<KangarooHarvesterQuota> quotas;
    private final BehaviorRelay<String> selection;
    private HarvestJobWizardViewModel viewModel;

    public HarvestZoneAdapter(HarvestJobWizardViewModel harvestJobWizardViewModel) {
        Intrinsics.checkNotNullParameter(harvestJobWizardViewModel, "viewModel");
        this.viewModel = harvestJobWizardViewModel;
        this.quotas = harvestJobWizardViewModel.getZones();
        String str = this.viewModel.getQuotaId().get();
        BehaviorRelay<String> createDefault = BehaviorRelay.createDefault(str == null ? "" : str);
        Intrinsics.checkNotNullExpressionValue(createDefault, "BehaviorRelay.createDefa…odel.quotaId.get() ?: \"\")");
        this.selection = createDefault;
        this.disposables = new CompositeDisposable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public HarvestZoneViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        HarvesterItemZoneBinding inflate = HarvesterItemZoneBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "HarvesterItemZoneBinding…(inflater, parent, false)");
        BehaviorRelay<String> behaviorRelay = this.selection;
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        HarvestZoneViewHolder harvestZoneViewHolder = new HarvestZoneViewHolder(behaviorRelay, root);
        inflate.setVm(harvestZoneViewHolder);
        this.disposables.add(this.selection.subscribe(new HarvestZoneAdapter$onCreateViewHolder$1(this)));
        return harvestZoneViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.quotas.size();
    }

    public void onBindViewHolder(HarvestZoneViewHolder harvestZoneViewHolder, int i) {
        Intrinsics.checkNotNullParameter(harvestZoneViewHolder, "holder");
        harvestZoneViewHolder.bind(this.quotas.get(i));
    }
}
