package com.digitalwallet.app.viewmodel.harvester;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"com/digitalwallet/app/viewmodel/harvester/HarvestTagViewModel$summaryFilled$1", "Landroidx/databinding/ObservableField;", "", "get", "()Ljava/lang/Boolean;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestTagViewModel.kt */
public final class HarvestTagViewModel$summaryFilled$1 extends ObservableField<Boolean> {
    final /* synthetic */ HarvestTagViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HarvestTagViewModel$summaryFilled$1(HarvestTagViewModel harvestTagViewModel, Observable[] observableArr) {
        super(observableArr);
        this.this$0 = harvestTagViewModel;
    }

    @Override // androidx.databinding.ObservableField
    public Boolean get() {
        String str = this.this$0.getNumOfWesternGreys().get();
        boolean z = false;
        if (!(str == null || str.length() == 0)) {
            String str2 = this.this$0.getNumOfFemales().get();
            if (!(str2 == null || str2.length() == 0)) {
                String str3 = this.this$0.getNumPouchYoungDestroyed().get();
                if (!(str3 == null || str3.length() == 0)) {
                    String str4 = this.this$0.getNumYoungAtFootDestroyed().get();
                    if (!(str4 == null || str4.length() == 0)) {
                        String str5 = this.this$0.getNumTaggedCarcassesLeftOnProperty().get();
                        if (!(str5 == null || str5.length() == 0)) {
                            String str6 = this.this$0.getNumTaggedCarcassesStoredForProcessor().get();
                            if (!(str6 == null || str6.length() == 0)) {
                                z = true;
                            }
                        }
                    }
                }
            }
        }
        return Boolean.valueOf(z);
    }
}
