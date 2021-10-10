package com.digitalwallet.app.view.harvester;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.HarvesterJobsBinding;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.viewmodel.harvester.HarvestJobWizardViewModel;
import com.digitalwallet.app.viewmodel.harvester.HavestJobAdapter;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/digitalwallet/app/view/harvester/HarvestJobListFragment;", "Lcom/digitalwallet/app/view/base/BaseAppFragment;", "Lcom/digitalwallet/app/databinding/HarvesterJobsBinding;", "Lcom/digitalwallet/app/view/harvester/HarvestJobFragment;", "()V", "harvestView", "Lcom/digitalwallet/app/view/harvester/HarvestView;", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/app/viewmodel/harvester/HarvestJobWizardViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/harvester/HarvestJobWizardViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/harvester/HarvestJobWizardViewModel;)V", "onResume", "", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "retrieveJobs", "setUserVisibleHint", "isVisibleToUser", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestJobListFragment.kt */
public final class HarvestJobListFragment extends BaseAppFragment<HarvesterJobsBinding> implements HarvestJobFragment {
    private HashMap _$_findViewCache;
    private HarvestView harvestView;
    private final int layoutId = R.layout.harvester_jobs;
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

    @Override // com.digitalwallet.view.base.BaseFragment
    public int getLayoutId() {
        return this.layoutId;
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

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.digitalwallet.app.view.harvester.HarvestView");
        this.harvestView = (HarvestView) activity;
        RecyclerView recyclerView = ((HarvesterJobsBinding) getBinding()).jobTable;
        HarvestView harvestView2 = this.harvestView;
        if (harvestView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("harvestView");
        }
        recyclerView.setAdapter(new HavestJobAdapter(harvestView2, getViewModel().getJobs()));
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        getParentFragmentManager().addOnBackStackChangedListener(HarvestJobListFragment$onViewCreated$2.INSTANCE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        retrieveJobs();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            retrieveJobs();
        }
    }

    private final void retrieveJobs() {
        getViewModel().m6getJobs();
    }
}
