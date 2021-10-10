package com.digitalwallet.app.view.main;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.FragmentAccountDetailsBinding;
import com.digitalwallet.app.model.AttributeDetailItem;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.view.util.ViewUtilsKt;
import com.digitalwallet.app.viewmodel.main.AccountDetailsFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.AccountDetailsView;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.ServerTypeKt;
import com.google.android.gms.analytics.ecommerce.Promotion;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0016J\u001a\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010%\u001a\u00020\u0016H\u0002J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u0016H\u0002J\u0016\u0010*\u001a\u00020\u00162\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006."}, d2 = {"Lcom/digitalwallet/app/view/main/AccountDetailsFragment;", "Lcom/digitalwallet/app/view/base/BaseAppFragment;", "Lcom/digitalwallet/app/databinding/FragmentAccountDetailsBinding;", "Lcom/digitalwallet/app/viewmodel/main/AccountDetailsView;", "()V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "layoutId", "", "getLayoutId", "()I", "mainActivity", "Lcom/digitalwallet/app/view/main/MainActivity;", "getMainActivity", "()Lcom/digitalwallet/app/view/main/MainActivity;", "viewModel", "Lcom/digitalwallet/app/viewmodel/main/AccountDetailsFragmentViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/main/AccountDetailsFragmentViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/main/AccountDetailsFragmentViewModel;)V", "edit", "", "editNickname", "editStoredDetails", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onViewCreated", Promotion.ACTION_VIEW, "setScreen", "setUserVisibleHint", "isVisibleToUser", "", "setupTransactionHistory", "updateList", "detailList", "", "Lcom/digitalwallet/app/model/AttributeDetailItem;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AccountDetailsFragment.kt */
public final class AccountDetailsFragment extends BaseAppFragment<FragmentAccountDetailsBinding> implements AccountDetailsView {
    private HashMap _$_findViewCache;
    private CompositeDisposable disposables = new CompositeDisposable();
    private final int layoutId = R.layout.fragment_account_details;
    @Inject
    public AccountDetailsFragmentViewModel viewModel;

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
    public AccountDetailsFragmentViewModel getViewModel() {
        AccountDetailsFragmentViewModel accountDetailsFragmentViewModel = this.viewModel;
        if (accountDetailsFragmentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return accountDetailsFragmentViewModel;
    }

    public void setViewModel(AccountDetailsFragmentViewModel accountDetailsFragmentViewModel) {
        Intrinsics.checkNotNullParameter(accountDetailsFragmentViewModel, "<set-?>");
        this.viewModel = accountDetailsFragmentViewModel;
    }

    private final MainActivity getMainActivity() {
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.digitalwallet.app.view.main.MainActivity");
        return (MainActivity) activity;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        getViewModel().setView(this);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        setScreen();
        ViewCompat.setNestedScrollingEnabled((RecyclerView) _$_findCachedViewById(com.digitalwallet.app.R.id.account_details_recycler_view), false);
        setupTransactionHistory();
        this.disposables.add(getMainActivity().getAtFront().subscribe(new AccountDetailsFragment$onViewCreated$1(this)));
    }

    private final void setupTransactionHistory() {
        TextView textView = ((FragmentAccountDetailsBinding) getBinding()).historyErrorText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.historyErrorText");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        getViewModel().getTransHistoryItems().addOnPropertyChangedCallback(new AccountDetailsFragment$setupTransactionHistory$1(this));
    }

    @Override // com.digitalwallet.app.viewmodel.main.AccountDetailsView
    public void edit() {
        if (ServerTypeKt.getAppType() == AppType.CITIZEN) {
            Context context = getContext();
            Intrinsics.checkNotNull(context);
            AlertDialog create = new AlertDialog.Builder(context).setPositiveButton(R.string.user_menu_nickname, new AccountDetailsFragment$edit$dialog$1(this)).setNegativeButton(R.string.user_menu_stored_details, new AccountDetailsFragment$edit$dialog$2(this)).setNeutralButton(R.string.cancel_RES_2114650146, (DialogInterface.OnClickListener) null).create();
            Intrinsics.checkNotNullExpressionValue(create, "AlertDialog\n            …ll)\n            .create()");
            create.show();
            int color = getResources().getColor(R.color.dark_RES_2131034188, null);
            create.getButton(-2).setTextColor(color);
            create.getButton(-3).setTextColor(color);
            create.getButton(-1).setTextColor(color);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* access modifiers changed from: private */
    public final void editNickname() {
        FragmentManager supportFragmentManager = getMainActivity().getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "mainActivity.supportFragmentManager");
        NicknameEditFragment nicknameEditFragment = new NicknameEditFragment();
        List<Fragment> fragments = supportFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
        for (T t : fragments) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            t.setUserVisibleHint(false);
        }
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        String simpleName = Reflection.getOrCreateKotlinClass(NicknameEditFragment.class).getSimpleName();
        beginTransaction.add(R.id.fragment_container_RES_2114322527, nicknameEditFragment, simpleName).addToBackStack(simpleName).commit();
    }

    /* access modifiers changed from: private */
    public final void editStoredDetails() {
        String string = getResources().getString(R.string.user_edit_url);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.user_edit_url)");
        getMainActivity().startChromeCustomTabs(string, true);
    }

    @Override // com.digitalwallet.app.viewmodel.main.AccountDetailsView
    public void updateList(List<AttributeDetailItem> list) {
        Intrinsics.checkNotNullParameter(list, "detailList");
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(com.digitalwallet.app.R.id.account_details_recycler_view);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "account_details_recycler_view");
        ViewUtilsKt.initDetails(recyclerView, list);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getViewModel().reload();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.disposables.clear();
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
            ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), ActivityAnalyticsHelper.Screen.AccountDetails, null, null, 6, null);
        }
    }
}
