package com.digitalwallet.app.view.main;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.FragmentAccountSettingsBinding;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.view.main.adapter.AccountSettingsAdapter;
import com.digitalwallet.app.view.util.CustomDividerItemDecoration;
import com.digitalwallet.app.viewmodel.main.AccountSettingsFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.SettingOption;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.utilities.AppType;
import com.google.android.gms.analytics.ecommerce.Promotion;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/digitalwallet/app/view/main/AccountSettingsFragment;", "Lcom/digitalwallet/app/view/base/BaseAppFragment;", "Lcom/digitalwallet/app/databinding/FragmentAccountSettingsBinding;", "()V", "authenticationUtility", "Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "getAuthenticationUtility", "()Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "setAuthenticationUtility", "(Lcom/digitalwallet/app/oidc/AuthenticationUtility;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/app/viewmodel/main/AccountSettingsFragmentViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/main/AccountSettingsFragmentViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/main/AccountSettingsFragmentViewModel;)V", "onDestroyView", "", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setScreen", "setUserVisibleHint", "isVisibleToUser", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AccountSettingsFragment.kt */
public final class AccountSettingsFragment extends BaseAppFragment<FragmentAccountSettingsBinding> {
    private HashMap _$_findViewCache;
    @Inject
    public AuthenticationUtility authenticationUtility;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final int layoutId = R.layout.fragment_account_settings;
    @Inject
    public AccountSettingsFragmentViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[SettingOption.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[SettingOption.Privacy.ordinal()] = 1;
            iArr[SettingOption.Terms.ordinal()] = 2;
            int[] iArr2 = new int[AppType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[AppType.AUTHORITY.ordinal()] = 1;
            iArr2[AppType.CITIZEN.ordinal()] = 2;
            int[] iArr3 = new int[SettingOption.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[SettingOption.AutoSync.ordinal()] = 1;
            iArr3[SettingOption.Contact.ordinal()] = 2;
        }
    }

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

    @Override // com.digitalwallet.view.base.BaseFragment
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public AccountSettingsFragmentViewModel getViewModel() {
        AccountSettingsFragmentViewModel accountSettingsFragmentViewModel = this.viewModel;
        if (accountSettingsFragmentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return accountSettingsFragmentViewModel;
    }

    public void setViewModel(AccountSettingsFragmentViewModel accountSettingsFragmentViewModel) {
        Intrinsics.checkNotNullParameter(accountSettingsFragmentViewModel, "<set-?>");
        this.viewModel = accountSettingsFragmentViewModel;
    }

    public final AuthenticationUtility getAuthenticationUtility() {
        AuthenticationUtility authenticationUtility2 = this.authenticationUtility;
        if (authenticationUtility2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authenticationUtility");
        }
        return authenticationUtility2;
    }

    public final void setAuthenticationUtility(AuthenticationUtility authenticationUtility2) {
        Intrinsics.checkNotNullParameter(authenticationUtility2, "<set-?>");
        this.authenticationUtility = authenticationUtility2;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        setScreen();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(com.digitalwallet.app.R.id.settingItemsRecyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "settingItemsRecyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        AccountSettingsAdapter accountSettingsAdapter = new AccountSettingsAdapter();
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(com.digitalwallet.app.R.id.settingItemsRecyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "settingItemsRecyclerView");
        recyclerView2.setAdapter(accountSettingsAdapter);
        List<SettingOption> settingsToDisplay = getViewModel().getSettingsToDisplay();
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        accountSettingsAdapter.updateList(settingsToDisplay, context);
        AuthenticationUtility authenticationUtility2 = this.authenticationUtility;
        if (authenticationUtility2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authenticationUtility");
        }
        accountSettingsAdapter.updateAutoSyncStatus(authenticationUtility2.shouldAutoUpdate());
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ((RecyclerView) _$_findCachedViewById(com.digitalwallet.app.R.id.settingItemsRecyclerView)).addItemDecoration(new CustomDividerItemDecoration(requireContext, R.drawable.setting_recyclerview_divider));
        this.disposables.add(accountSettingsAdapter.getSelectedOptionItemViewModel().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new AccountSettingsFragment$onViewCreated$1(this, accountSettingsAdapter)));
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.app.view.base.BaseAppFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.disposables.clear();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(com.digitalwallet.app.R.id.settingItemsRecyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "settingItemsRecyclerView");
        recyclerView.setAdapter(null);
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            setScreen();
        }
    }

    private final void setScreen() {
        if (isVisible() && getUserVisibleHint()) {
            ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), ActivityAnalyticsHelper.Screen.SettingsMenuTable, null, null, 6, null);
        }
    }
}
