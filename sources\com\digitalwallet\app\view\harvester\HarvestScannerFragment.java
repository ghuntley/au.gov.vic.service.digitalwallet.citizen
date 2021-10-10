package com.digitalwallet.app.view.harvester;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.databinding.HarvesterScannerBinding;
import com.digitalwallet.app.viewmodel.harvester.HarvestTagViewModel;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.view.main.BackHandler;
import com.digitalwallet.view.main.ScannerFragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010%\u001a\u00020&H\u0016J&\u0010'\u001a\u0004\u0018\u00010\r2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u00072\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020&H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001c\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010$¨\u00061"}, d2 = {"Lcom/digitalwallet/app/view/harvester/HarvestScannerFragment;", "Lcom/digitalwallet/view/main/ScannerFragment;", "Lcom/digitalwallet/app/databinding/HarvesterScannerBinding;", "Lcom/digitalwallet/app/view/harvester/HarvestTagFragment;", "Lcom/digitalwallet/view/main/BackHandler;", "()V", "cameraFrame", "Landroid/view/ViewGroup;", "getCameraFrame", "()Landroid/view/ViewGroup;", "setCameraFrame", "(Landroid/view/ViewGroup;)V", "cameraGuide", "Landroid/view/View;", "getCameraGuide", "()Landroid/view/View;", "setCameraGuide", "(Landroid/view/View;)V", "layoutId", "", "getLayoutId", "()I", "outerFrame", "getOuterFrame", "setOuterFrame", "scannerViewModel", "Lcom/digitalwallet/app/viewmodel/harvester/HarvestTagViewModel;", "getScannerViewModel", "()Lcom/digitalwallet/app/viewmodel/harvester/HarvestTagViewModel;", "viewModel", "getViewModel", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/harvester/HarvestTagViewModel;)V", "vmBindingName", "getVmBindingName", "setVmBindingName", "(I)V", "handleBack", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "setUserVisibleHint", "isVisibleToUser", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestScannerFragment.kt */
public final class HarvestScannerFragment extends ScannerFragment<HarvesterScannerBinding> implements HarvestTagFragment, BackHandler {
    private HashMap _$_findViewCache;
    public ViewGroup cameraFrame;
    public View cameraGuide;
    private final int layoutId = R.layout.harvester_scanner;
    public ViewGroup outerFrame;
    public HarvestTagViewModel viewModel;
    private int vmBindingName = BR.vm;

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, com.digitalwallet.view.main.ScannerFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, com.digitalwallet.view.main.ScannerFragment
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

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment, com.digitalwallet.view.main.ScannerFragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public int getVmBindingName() {
        return this.vmBindingName;
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public void setVmBindingName(int i) {
        this.vmBindingName = i;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.app.view.harvester.HarvestTagFragment
    public HarvestTagViewModel getViewModel() {
        HarvestTagViewModel harvestTagViewModel = this.viewModel;
        if (harvestTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return harvestTagViewModel;
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestTagFragment
    public void setViewModel(HarvestTagViewModel harvestTagViewModel) {
        Intrinsics.checkNotNullParameter(harvestTagViewModel, "<set-?>");
        this.viewModel = harvestTagViewModel;
    }

    @Override // com.digitalwallet.view.main.ScannerFragment
    public HarvestTagViewModel getScannerViewModel() {
        return getViewModel();
    }

    @Override // com.digitalwallet.view.main.ScannerFragment
    public ViewGroup getOuterFrame() {
        ViewGroup viewGroup = this.outerFrame;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outerFrame");
        }
        return viewGroup;
    }

    public void setOuterFrame(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.outerFrame = viewGroup;
    }

    @Override // com.digitalwallet.view.main.ScannerFragment
    public View getCameraGuide() {
        View view = this.cameraGuide;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraGuide");
        }
        return view;
    }

    public void setCameraGuide(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.cameraGuide = view;
    }

    @Override // com.digitalwallet.view.main.ScannerFragment
    public ViewGroup getCameraFrame() {
        ViewGroup viewGroup = this.cameraFrame;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraFrame");
        }
        return viewGroup;
    }

    public void setCameraFrame(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.cameraFrame = viewGroup;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        ConstraintLayout constraintLayout = ((HarvesterScannerBinding) getBinding()).outerFrame;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.outerFrame");
        setOuterFrame(constraintLayout);
        FrameLayout frameLayout = ((HarvesterScannerBinding) getBinding()).cameraFrame;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.cameraFrame");
        setCameraFrame(frameLayout);
        FrameLayout frameLayout2 = ((HarvesterScannerBinding) getBinding()).cameraGuide;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.cameraGuide");
        setCameraGuide(frameLayout2);
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        Intrinsics.checkNotNullExpressionValue(activity, "activity!!");
        ActivityAnalyticsHelper.setScreenName$default(new ActivityAnalyticsHelper(activity), ActivityAnalyticsHelper.Screen.KangarooHarvesterScannerView, null, null, 6, null);
        getViewModel().resumeScan();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            getViewModel().resumeScan();
        } else {
            getViewModel().pauseScan();
        }
    }

    @Override // com.digitalwallet.view.main.BackHandler
    public boolean handleBack() {
        return ((Boolean) new HarvestScannerFragment$handleBack$1(this).invoke()).booleanValue();
    }
}
