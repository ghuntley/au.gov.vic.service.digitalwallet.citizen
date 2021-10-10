package com.digitalwallet.view.base;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.google.android.gms.analytics.ecommerce.Promotion;
import dagger.android.support.DaggerFragment;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX.¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/digitalwallet/view/base/BasicFragment;", "Ldagger/android/support/DaggerFragment;", "()V", "<set-?>", "Lcom/digitalwallet/utilities/ActivityAnalyticsHelper;", "analytics", "getAnalytics", "()Lcom/digitalwallet/utilities/ActivityAnalyticsHelper;", "onViewCreated", "", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: BasicFragment.kt */
public class BasicFragment extends DaggerFragment {
    private HashMap _$_findViewCache;
    private ActivityAnalyticsHelper analytics;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

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

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final ActivityAnalyticsHelper getAnalytics() {
        ActivityAnalyticsHelper activityAnalyticsHelper = this.analytics;
        if (activityAnalyticsHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return activityAnalyticsHelper;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type android.app.Activity");
        this.analytics = new ActivityAnalyticsHelper(activity);
    }
}
