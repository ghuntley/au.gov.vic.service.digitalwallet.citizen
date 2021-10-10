package com.digitalwallet.app.viewmodel.harvester;

import android.view.View;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.RecyclerView;
import com.digitalwallet.app.model.db.harvester.SavedHarvestJob;
import com.digitalwallet.app.view.harvester.HarvestView;
import com.digitalwallet.app.view.util.ClickMute;
import com.google.android.gms.analytics.ecommerce.Promotion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/digitalwallet/app/viewmodel/harvester/HarvestJobViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "root", "Landroid/view/View;", Promotion.ACTION_VIEW, "Lcom/digitalwallet/app/view/harvester/HarvestView;", "clickMute", "Lcom/digitalwallet/app/view/util/ClickMute;", "(Landroid/view/View;Lcom/digitalwallet/app/view/harvester/HarvestView;Lcom/digitalwallet/app/view/util/ClickMute;)V", AuthorizationRequest.Scope.ADDRESS, "Landroidx/databinding/ObservableField;", "", "getAddress", "()Landroidx/databinding/ObservableField;", "jobId", "", "Ljava/lang/Long;", "bind", "", "job", "Lcom/digitalwallet/app/model/db/harvester/SavedHarvestJob;", "closeJob", "scanTags", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestJobAdapter.kt */
public final class HarvestJobViewHolder extends RecyclerView.ViewHolder {
    private final ObservableField<String> address = new ObservableField<>("");
    private ClickMute clickMute;
    private Long jobId;
    private HarvestView view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HarvestJobViewHolder(View view2, HarvestView harvestView, ClickMute clickMute2) {
        super(view2);
        Intrinsics.checkNotNullParameter(view2, "root");
        Intrinsics.checkNotNullParameter(harvestView, Promotion.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(clickMute2, "clickMute");
        this.view = harvestView;
        this.clickMute = clickMute2;
    }

    public final ObservableField<String> getAddress() {
        return this.address;
    }

    public final void bind(SavedHarvestJob savedHarvestJob) {
        Intrinsics.checkNotNullParameter(savedHarvestJob, "job");
        this.jobId = savedHarvestJob.getId();
        this.address.set(savedHarvestJob.getHarvestAddress());
    }

    public final void scanTags() {
        this.clickMute.tryDo(new HarvestJobViewHolder$scanTags$1(this));
    }

    public final void closeJob() {
        this.clickMute.tryDo(new HarvestJobViewHolder$closeJob$1(this));
    }
}
