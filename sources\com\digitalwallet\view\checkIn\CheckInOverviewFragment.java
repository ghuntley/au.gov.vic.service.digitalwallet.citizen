package com.digitalwallet.view.checkIn;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.databinding.FragmentCheckInOverviewBinding;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.utilities.EventObserver;
import com.digitalwallet.view.base.BaseFragment;
import com.digitalwallet.view.util.ViewUtilsKt;
import com.digitalwallet.viewmodel.checkIn.CheckInOverviewViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/digitalwallet/view/checkIn/CheckInOverviewFragment;", "Lcom/digitalwallet/view/base/BaseFragment;", "Lcom/digitalwallet/databinding/FragmentCheckInOverviewBinding;", "()V", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/viewmodel/checkIn/CheckInOverviewViewModel;", "getViewModel", "()Lcom/digitalwallet/viewmodel/checkIn/CheckInOverviewViewModel;", "setViewModel", "(Lcom/digitalwallet/viewmodel/checkIn/CheckInOverviewViewModel;)V", "onResume", "", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "startCheckInScannerFragment", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInOverviewFragment.kt */
public final class CheckInOverviewFragment extends BaseFragment<FragmentCheckInOverviewBinding> {
    private HashMap _$_findViewCache;
    private final int layoutId = R.layout.fragment_check_in_overview;
    @Inject
    public CheckInOverviewViewModel viewModel;

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment
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

    @Override // com.digitalwallet.view.base.BaseFragment, androidx.fragment.app.Fragment, com.digitalwallet.view.base.BasicFragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public CheckInOverviewViewModel getViewModel() {
        CheckInOverviewViewModel checkInOverviewViewModel = this.viewModel;
        if (checkInOverviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return checkInOverviewViewModel;
    }

    public void setViewModel(CheckInOverviewViewModel checkInOverviewViewModel) {
        Intrinsics.checkNotNullParameter(checkInOverviewViewModel, "<set-?>");
        this.viewModel = checkInOverviewViewModel;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, androidx.fragment.app.Fragment, com.digitalwallet.view.base.BasicFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), ActivityAnalyticsHelper.Screen.CheckInOverview, null, null, 6, null);
        ((FragmentCheckInOverviewBinding) getBinding()).setLifecycleOwner(this);
        getViewModel().getNavigateToCheckInScanner().observe(getViewLifecycleOwner(), new EventObserver(new CheckInOverviewFragment$onViewCreated$1(this)));
        getViewModel().getNavigateToHelpUrl().observe(getViewLifecycleOwner(), new EventObserver(new CheckInOverviewFragment$onViewCreated$2(this)));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getViewModel().refreshCheckInHistory();
    }

    /* access modifiers changed from: private */
    public final void startCheckInScannerFragment() {
        CheckInScannerFragment checkInScannerFragment = new CheckInScannerFragment();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        int containerId = ViewUtilsKt.getContainerId(this);
        List<Fragment> fragments = parentFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
        for (T t : fragments) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            t.setUserVisibleHint(false);
        }
        FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
        String simpleName = Reflection.getOrCreateKotlinClass(CheckInScannerFragment.class).getSimpleName();
        beginTransaction.add(containerId, checkInScannerFragment, simpleName).addToBackStack(simpleName).commit();
    }
}
