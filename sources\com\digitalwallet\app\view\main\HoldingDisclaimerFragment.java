package com.digitalwallet.app.view.main;

import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.digitalwallet.app.databinding.FragmentHoldingDisclaimerBinding;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.view.base.BasicFragment;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/digitalwallet/app/view/main/HoldingDisclaimerFragment;", "Lcom/digitalwallet/view/base/BasicFragment;", "Lcom/digitalwallet/app/view/main/HoldingDisclaimerFragmentViewModel;", "()V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "backToHoldingDetailFragment", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HoldingDisclaimerFragment.kt */
public final class HoldingDisclaimerFragment extends BasicFragment implements HoldingDisclaimerFragmentViewModel {
    private HashMap _$_findViewCache;
    private final CompositeDisposable disposables = new CompositeDisposable();

    @Override // com.digitalwallet.view.base.BasicFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.digitalwallet.view.base.BasicFragment
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

    @Override // androidx.fragment.app.Fragment, com.digitalwallet.view.base.BasicFragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentHoldingDisclaimerBinding inflate = FragmentHoldingDisclaimerBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "it");
        inflate.setVm(this);
        return inflate.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        Intrinsics.checkNotNullExpressionValue(activity, "activity!!");
        ActivityAnalyticsHelper.setScreenName$default(new ActivityAnalyticsHelper(activity), ActivityAnalyticsHelper.Screen.ShowCardDisclaimer, null, null, 6, null);
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.setRequestedOrientation(11);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.disposables.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        HoldingDetailFragment holdingDetailFragment = (HoldingDetailFragment) getParentFragmentManager().findFragmentByTag(Reflection.getOrCreateKotlinClass(HoldingDetailFragment.class).getSimpleName());
        if (holdingDetailFragment != null) {
            boolean areEqual = Intrinsics.areEqual((Object) holdingDetailFragment.getViewModel().getKeepLandscapeOrientation().get(), (Object) true);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                boolean z = Settings.System.getInt(activity.getContentResolver(), "accelerometer_rotation", 0) == 1;
                if (areEqual) {
                    activity.setRequestedOrientation(0);
                } else if (z) {
                    activity.setRequestedOrientation(10);
                }
            }
            holdingDetailFragment.setUserFocus(true);
        }
    }

    @Override // com.digitalwallet.app.view.main.HoldingDisclaimerFragmentViewModel
    public void backToHoldingDetailFragment() {
        getParentFragmentManager().popBackStackImmediate(Reflection.getOrCreateKotlinClass(getClass()).getSimpleName(), 1);
    }
}
