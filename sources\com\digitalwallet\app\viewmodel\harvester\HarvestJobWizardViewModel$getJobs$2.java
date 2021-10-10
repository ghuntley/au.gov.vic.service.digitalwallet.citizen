package com.digitalwallet.app.viewmodel.harvester;

import com.digitalwallet.app.model.db.harvester.SavedHarvestJob;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "j", "", "Lcom/digitalwallet/app/model/db/harvester/SavedHarvestJob;", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: HarvestJobWizardViewModel.kt */
public final class HarvestJobWizardViewModel$getJobs$2<T> implements Consumer<List<? extends SavedHarvestJob>> {
    final /* synthetic */ HarvestJobWizardViewModel this$0;

    HarvestJobWizardViewModel$getJobs$2(HarvestJobWizardViewModel harvestJobWizardViewModel) {
        this.this$0 = harvestJobWizardViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(List<? extends SavedHarvestJob> list) {
        accept((List<SavedHarvestJob>) list);
    }

    public final void accept(List<SavedHarvestJob> list) {
        Intrinsics.checkNotNullParameter(list, "j");
        this.this$0.getJobs().accept(list);
    }
}
