package com.digitalwallet.app.viewmodel.harvester;

import androidx.databinding.ObservableField;
import com.digitalwallet.app.model.db.harvester.SavedHarvestJob;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "savedJob", "Lcom/digitalwallet/app/model/db/harvester/SavedHarvestJob;", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: HarvestTagViewModel.kt */
public final class HarvestTagViewModel$setup$2<T> implements Consumer<SavedHarvestJob> {
    final /* synthetic */ long $jobId;
    final /* synthetic */ HarvestTagViewModel this$0;

    HarvestTagViewModel$setup$2(HarvestTagViewModel harvestTagViewModel, long j) {
        this.this$0 = harvestTagViewModel;
        this.$jobId = j;
    }

    public final void accept(SavedHarvestJob savedHarvestJob) {
        if (savedHarvestJob != null) {
            Long id = savedHarvestJob.getId();
            if (id != null && id.longValue() == this.$jobId) {
                this.this$0.job = savedHarvestJob;
                this.this$0.getAddress().set(savedHarvestJob.getHarvestAddress());
                ObservableField<String> landholderName = this.this$0.getLandholderName();
                String landholderName2 = savedHarvestJob.getLandholderName();
                String str = "";
                if (landholderName2 == null) {
                    landholderName2 = str;
                }
                landholderName.set(landholderName2);
                ObservableField<String> landholderContactNumber = this.this$0.getLandholderContactNumber();
                String landholderContactNumber2 = savedHarvestJob.getLandholderContactNumber();
                if (landholderContactNumber2 != null) {
                    str = landholderContactNumber2;
                }
                landholderContactNumber.set(str);
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }
}
