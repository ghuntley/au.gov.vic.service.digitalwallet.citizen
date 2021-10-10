package com.digitalwallet.app.view.harvester;

import android.view.View;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.HarvesterConsentBinding;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.viewmodel.harvester.HarvestJobWizardViewModel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/digitalwallet/app/view/harvester/HarvestJobWizardConsentFragment;", "Lcom/digitalwallet/app/view/base/BaseAppFragment;", "Lcom/digitalwallet/app/databinding/HarvesterConsentBinding;", "Lcom/digitalwallet/app/view/harvester/HarvestJobFragment;", "()V", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/app/viewmodel/harvester/HarvestJobWizardViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/harvester/HarvestJobWizardViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/harvester/HarvestJobWizardViewModel;)V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestJobWizardConsentFragment.kt */
public final class HarvestJobWizardConsentFragment extends BaseAppFragment<HarvesterConsentBinding> implements HarvestJobFragment {
    private HashMap _$_findViewCache;
    private final int layoutId = R.layout.harvester_consent;
    public HarvestJobWizardViewModel viewModel;

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.app.view.base.BaseAppFragment, com.digitalwallet.view.base.BasicFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.app.view.base.BaseAppFragment, com.digitalwallet.view.base.BasicFragment
    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.app.view.base.BaseAppFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.app.view.harvester.HarvestJobFragment
    public HarvestJobWizardViewModel getViewModel() {
        HarvestJobWizardViewModel harvestJobWizardViewModel = this.viewModel;
        if (harvestJobWizardViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return harvestJobWizardViewModel;
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestJobFragment
    public void setViewModel(HarvestJobWizardViewModel harvestJobWizardViewModel) {
        Intrinsics.checkNotNullParameter(harvestJobWizardViewModel, "<set-?>");
        this.viewModel = harvestJobWizardViewModel;
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public int getLayoutId() {
        return this.layoutId;
    }
}
