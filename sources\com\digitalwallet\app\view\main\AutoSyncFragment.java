package com.digitalwallet.app.view.main;

import android.os.Bundle;
import android.view.View;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.FragmentAutoSyncBinding;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.viewmodel.main.addsync.AutoSyncViewModel;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/view/main/AutoSyncFragment;", "Lcom/digitalwallet/app/view/base/BaseAppFragment;", "Lcom/digitalwallet/app/databinding/FragmentAutoSyncBinding;", "()V", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/app/viewmodel/main/addsync/AutoSyncViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/main/addsync/AutoSyncViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/main/addsync/AutoSyncViewModel;)V", "onViewCreated", "", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AutoSyncFragment.kt */
public final class AutoSyncFragment extends BaseAppFragment<FragmentAutoSyncBinding> {
    public static final Companion Companion = new Companion(null);
    private static final String SETUP_KEY = "SETUP";
    private HashMap _$_findViewCache;
    private final int layoutId = R.layout.fragment_auto_sync;
    @Inject
    public AutoSyncViewModel viewModel;

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

    @Override // com.digitalwallet.view.base.BaseFragment
    public AutoSyncViewModel getViewModel() {
        AutoSyncViewModel autoSyncViewModel = this.viewModel;
        if (autoSyncViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return autoSyncViewModel;
    }

    public void setViewModel(AutoSyncViewModel autoSyncViewModel) {
        Intrinsics.checkNotNullParameter(autoSyncViewModel, "<set-?>");
        this.viewModel = autoSyncViewModel;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), ActivityAnalyticsHelper.Screen.SyncOption, null, null, 6, null);
        Bundle arguments = getArguments();
        boolean z = true;
        if (arguments == null || !arguments.getBoolean(SETUP_KEY)) {
            z = false;
        }
        getViewModel().getAutoSyncEnabled().observe(this, new AutoSyncFragment$onViewCreated$1(this, z));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/view/main/AutoSyncFragment$Companion;", "", "()V", "SETUP_KEY", "", "newInstance", "Lcom/digitalwallet/app/view/main/AutoSyncFragment;", "setup", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: AutoSyncFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ AutoSyncFragment newInstance$default(Companion companion, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.newInstance(z);
        }

        public final AutoSyncFragment newInstance(boolean z) {
            AutoSyncFragment autoSyncFragment = new AutoSyncFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(AutoSyncFragment.SETUP_KEY, z);
            Unit unit = Unit.INSTANCE;
            autoSyncFragment.setArguments(bundle);
            return autoSyncFragment;
        }
    }
}
