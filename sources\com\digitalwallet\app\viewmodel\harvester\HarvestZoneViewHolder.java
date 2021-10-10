package com.digitalwallet.app.viewmodel.harvester;

import android.view.View;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.RecyclerView;
import com.digitalwallet.app.model.KangarooHarvesterQuota;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0015\u001a\u00020\u0014R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/digitalwallet/app/viewmodel/harvester/HarvestZoneViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "selection", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "", Promotion.ACTION_VIEW, "Landroid/view/View;", "(Lcom/jakewharton/rxrelay2/BehaviorRelay;Landroid/view/View;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "name", "Landroidx/databinding/ObservableField;", "getName", "()Landroidx/databinding/ObservableField;", "quota", "Lcom/digitalwallet/app/model/KangarooHarvesterQuota;", "selected", "", "getSelected", "bind", "", "select", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestZoneAdapter.kt */
public final class HarvestZoneViewHolder extends RecyclerView.ViewHolder {
    private final CompositeDisposable disposables;
    private final ObservableField<String> name = new ObservableField<>("-");
    private KangarooHarvesterQuota quota;
    private final ObservableField<Boolean> selected = new ObservableField<>((Boolean) false);
    private BehaviorRelay<String> selection;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HarvestZoneViewHolder(BehaviorRelay<String> behaviorRelay, View view) {
        super(view);
        Intrinsics.checkNotNullParameter(behaviorRelay, "selection");
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        this.selection = behaviorRelay;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.disposables = compositeDisposable;
        compositeDisposable.add(this.selection.subscribe(new Consumer<String>(this) {
            /* class com.digitalwallet.app.viewmodel.harvester.HarvestZoneViewHolder.AnonymousClass1 */
            final /* synthetic */ HarvestZoneViewHolder this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(String str) {
                ObservableField<Boolean> selected = this.this$0.getSelected();
                KangarooHarvesterQuota kangarooHarvesterQuota = this.this$0.quota;
                selected.set(Boolean.valueOf(Intrinsics.areEqual(str, kangarooHarvesterQuota != null ? kangarooHarvesterQuota.getQuotaId() : null)));
            }
        }));
    }

    public final ObservableField<Boolean> getSelected() {
        return this.selected;
    }

    public final ObservableField<String> getName() {
        return this.name;
    }

    public final void select() {
        BehaviorRelay<String> behaviorRelay = this.selection;
        KangarooHarvesterQuota kangarooHarvesterQuota = this.quota;
        Intrinsics.checkNotNull(kangarooHarvesterQuota);
        behaviorRelay.accept(kangarooHarvesterQuota.getQuotaId());
    }

    public final void bind(KangarooHarvesterQuota kangarooHarvesterQuota) {
        Intrinsics.checkNotNullParameter(kangarooHarvesterQuota, "quota");
        this.quota = kangarooHarvesterQuota;
        this.name.set(kangarooHarvesterQuota.getZoneName());
        this.selected.set(Boolean.valueOf(Intrinsics.areEqual(kangarooHarvesterQuota.getQuotaId(), this.selection.getValue())));
    }
}
