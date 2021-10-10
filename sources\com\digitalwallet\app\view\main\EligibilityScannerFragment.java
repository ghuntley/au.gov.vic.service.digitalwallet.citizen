package com.digitalwallet.app.view.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.databinding.FragmentEligibilityScannerBinding;
import com.digitalwallet.app.viewmodel.main.EligibilityScannerFragmentViewModel;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.view.main.ScannerFragment;
import com.google.android.gms.analytics.ecommerce.Promotion;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J&\u0010#\u001a\u0004\u0018\u00010\u000b2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u00052\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\u001a\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u0014\u0010\u0017\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u00188\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001a\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\"¨\u0006-"}, d2 = {"Lcom/digitalwallet/app/view/main/EligibilityScannerFragment;", "Lcom/digitalwallet/view/main/ScannerFragment;", "Lcom/digitalwallet/app/databinding/FragmentEligibilityScannerBinding;", "()V", "cameraFrame", "Landroid/view/ViewGroup;", "getCameraFrame", "()Landroid/view/ViewGroup;", "setCameraFrame", "(Landroid/view/ViewGroup;)V", "cameraGuide", "Landroid/view/View;", "getCameraGuide", "()Landroid/view/View;", "setCameraGuide", "(Landroid/view/View;)V", "layoutId", "", "getLayoutId", "()I", "outerFrame", "getOuterFrame", "setOuterFrame", "scannerViewModel", "Lcom/digitalwallet/app/viewmodel/main/EligibilityScannerFragmentViewModel;", "getScannerViewModel", "()Lcom/digitalwallet/app/viewmodel/main/EligibilityScannerFragmentViewModel;", "viewModel", "getViewModel", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/main/EligibilityScannerFragmentViewModel;)V", "vmBindingName", "getVmBindingName", "setVmBindingName", "(I)V", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onViewCreated", Promotion.ACTION_VIEW, "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: EligibilityScannerFragment.kt */
public final class EligibilityScannerFragment extends ScannerFragment<FragmentEligibilityScannerBinding> {
    private HashMap _$_findViewCache;
    public ViewGroup cameraFrame;
    public View cameraGuide;
    private final int layoutId = R.layout.fragment_eligibility_scanner;
    public ViewGroup outerFrame;
    @Inject
    public EligibilityScannerFragmentViewModel viewModel;
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

    @Override // com.digitalwallet.view.base.BaseFragment
    public EligibilityScannerFragmentViewModel getViewModel() {
        EligibilityScannerFragmentViewModel eligibilityScannerFragmentViewModel = this.viewModel;
        if (eligibilityScannerFragmentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return eligibilityScannerFragmentViewModel;
    }

    public void setViewModel(EligibilityScannerFragmentViewModel eligibilityScannerFragmentViewModel) {
        Intrinsics.checkNotNullParameter(eligibilityScannerFragmentViewModel, "<set-?>");
        this.viewModel = eligibilityScannerFragmentViewModel;
    }

    @Override // com.digitalwallet.view.main.ScannerFragment
    public EligibilityScannerFragmentViewModel getScannerViewModel() {
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

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment, com.digitalwallet.view.main.ScannerFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        getDisposables().add(getScannerViewModel().getClickEmitter().observeOn(AndroidSchedulers.mainThread()).subscribe(new EligibilityScannerFragment$onViewCreated$1(this)));
    }

    @Override // com.digitalwallet.view.base.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        ConstraintLayout constraintLayout = ((FragmentEligibilityScannerBinding) getBinding()).pending;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.pending");
        setOuterFrame(constraintLayout);
        FrameLayout frameLayout = ((FragmentEligibilityScannerBinding) getBinding()).cameraFrame;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.cameraFrame");
        setCameraFrame(frameLayout);
        ConstraintLayout constraintLayout2 = ((FragmentEligibilityScannerBinding) getBinding()).cameraGuide;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "binding.cameraGuide");
        setCameraGuide(constraintLayout2);
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        Intrinsics.checkNotNullExpressionValue(activity, "activity!!");
        ActivityAnalyticsHelper.setScreenName$default(new ActivityAnalyticsHelper(activity), ActivityAnalyticsHelper.Screen.SolarHomesScannerView, null, null, 6, null);
    }
}
