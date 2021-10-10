package com.digitalwallet.app.view.login;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.FragmentCreateAccountBinding;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.viewmodel.login.CreateAccountViewModel;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.utilities.EventObserver;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u001a\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/digitalwallet/app/view/login/CreateAccountFragment;", "Lcom/digitalwallet/app/view/base/BaseAppFragment;", "Lcom/digitalwallet/app/databinding/FragmentCreateAccountBinding;", "()V", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/app/viewmodel/login/CreateAccountViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/login/CreateAccountViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/login/CreateAccountViewModel;)V", "login", "", "observeEvents", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupButtons", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CreateAccountFragment.kt */
public final class CreateAccountFragment extends BaseAppFragment<FragmentCreateAccountBinding> {
    private HashMap _$_findViewCache;
    private final int layoutId = R.layout.fragment_create_account;
    @Inject
    public CreateAccountViewModel viewModel;

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
    public CreateAccountViewModel getViewModel() {
        CreateAccountViewModel createAccountViewModel = this.viewModel;
        if (createAccountViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return createAccountViewModel;
    }

    public void setViewModel(CreateAccountViewModel createAccountViewModel) {
        Intrinsics.checkNotNullParameter(createAccountViewModel, "<set-?>");
        this.viewModel = createAccountViewModel;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), ActivityAnalyticsHelper.Screen.CreateAccount, null, null, 6, null);
        setupButtons();
        observeEvents();
    }

    private final void setupButtons() {
        ((FragmentCreateAccountBinding) getBinding()).backButton.setOnClickListener(new CreateAccountFragment$setupButtons$1(this));
        ((FragmentCreateAccountBinding) getBinding()).loginButton.setOnClickListener(new CreateAccountFragment$setupButtons$2(this));
    }

    private final void observeEvents() {
        getViewModel().getHideKeyboardEvent().observe(getViewLifecycleOwner(), new EventObserver(new CreateAccountFragment$observeEvents$1(this)));
        getViewModel().getSuccessEvent().observe(getViewLifecycleOwner(), new EventObserver(new CreateAccountFragment$observeEvents$2(this)));
        getViewModel().getErrorEvent().observe(getViewLifecycleOwner(), new EventObserver(new CreateAccountFragment$observeEvents$3(this)));
    }

    /* access modifiers changed from: private */
    public final void login() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof LoginActivity)) {
            activity = null;
        }
        LoginActivity loginActivity = (LoginActivity) activity;
        if (loginActivity != null) {
            loginActivity.login();
        }
    }
}
