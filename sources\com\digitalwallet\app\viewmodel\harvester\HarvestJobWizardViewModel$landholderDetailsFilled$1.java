package com.digitalwallet.app.viewmodel.harvester;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"com/digitalwallet/app/viewmodel/harvester/HarvestJobWizardViewModel$landholderDetailsFilled$1", "Landroidx/databinding/ObservableField;", "", "get", "()Ljava/lang/Boolean;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestJobWizardViewModel.kt */
public final class HarvestJobWizardViewModel$landholderDetailsFilled$1 extends ObservableField<Boolean> {
    final /* synthetic */ HarvestJobWizardViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HarvestJobWizardViewModel$landholderDetailsFilled$1(HarvestJobWizardViewModel harvestJobWizardViewModel, Observable[] observableArr) {
        super(observableArr);
        this.this$0 = harvestJobWizardViewModel;
    }

    @Override // androidx.databinding.ObservableField
    public Boolean get() {
        String str = this.this$0.getLandholderContactNumber().get();
        boolean z = false;
        if (!(str == null || StringsKt.isBlank(str))) {
            String str2 = this.this$0.getLandholderName().get();
            if (!(str2 == null || StringsKt.isBlank(str2))) {
                String str3 = this.this$0.getAddress().get();
                if (!(str3 == null || StringsKt.isBlank(str3))) {
                    z = true;
                }
            }
        }
        return Boolean.valueOf(z);
    }
}
