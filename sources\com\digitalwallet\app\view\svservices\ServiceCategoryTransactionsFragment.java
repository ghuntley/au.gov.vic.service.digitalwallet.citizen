package com.digitalwallet.app.view.svservices;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.FragmentServiceCategoryTransactionsBinding;
import com.digitalwallet.app.model.login.SVCategory;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.view.login.HomeServicesFragment;
import com.digitalwallet.app.view.svservices.adapter.CategoryTransactionsAdapter;
import com.digitalwallet.app.viewmodel.svservices.ServiceCategoryTransactionsViewModel;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.utilities.EventObserver;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/digitalwallet/app/view/svservices/ServiceCategoryTransactionsFragment;", "Lcom/digitalwallet/app/view/base/BaseAppFragment;", "Lcom/digitalwallet/app/databinding/FragmentServiceCategoryTransactionsBinding;", "()V", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/app/viewmodel/svservices/ServiceCategoryTransactionsViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/svservices/ServiceCategoryTransactionsViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/svservices/ServiceCategoryTransactionsViewModel;)V", "observeTransactionListAction", "", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ServiceCategoryTransactionsFragment.kt */
public final class ServiceCategoryTransactionsFragment extends BaseAppFragment<FragmentServiceCategoryTransactionsBinding> {
    public static final Companion Companion = new Companion(null);
    public static final String SV_SERVICE_CATEGORY_KEY = "SV_SERVICE_CATEGORY_KEY";
    public static final String SV_SERVICE_GROUP_NAME_KEY = "SV_SERVICE_GROUP_NAME_KEY";
    private HashMap _$_findViewCache;
    private final int layoutId = R.layout.fragment_service_category_transactions;
    @Inject
    public ServiceCategoryTransactionsViewModel viewModel;

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
    public ServiceCategoryTransactionsViewModel getViewModel() {
        ServiceCategoryTransactionsViewModel serviceCategoryTransactionsViewModel = this.viewModel;
        if (serviceCategoryTransactionsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return serviceCategoryTransactionsViewModel;
    }

    public void setViewModel(ServiceCategoryTransactionsViewModel serviceCategoryTransactionsViewModel) {
        Intrinsics.checkNotNullParameter(serviceCategoryTransactionsViewModel, "<set-?>");
        this.viewModel = serviceCategoryTransactionsViewModel;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String str;
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ActivityAnalyticsHelper.setScreenName$default(new ActivityAnalyticsHelper(requireActivity), ActivityAnalyticsHelper.Screen.LoginServiceCategoryTransactions, null, null, 6, null);
        ((FragmentServiceCategoryTransactionsBinding) getBinding()).setLifecycleOwner(this);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString(SV_SERVICE_GROUP_NAME_KEY)) == null) {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "arguments?.getString(SV_…ICE_GROUP_NAME_KEY) ?: \"\"");
        Bundle arguments2 = getArguments();
        SVCategory sVCategory = null;
        SVCategory sVCategory2 = arguments2 != null ? (SVCategory) arguments2.getParcelable(SV_SERVICE_CATEGORY_KEY) : null;
        if (sVCategory2 instanceof SVCategory) {
            sVCategory = sVCategory2;
        }
        if (sVCategory != null) {
            getViewModel().updateServiceCategory(str, sVCategory);
            RecyclerView recyclerView = ((FragmentServiceCategoryTransactionsBinding) getBinding()).categoryTransactionList;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.categoryTransactionList");
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            RecyclerView recyclerView2 = ((FragmentServiceCategoryTransactionsBinding) getBinding()).categoryTransactionList;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.categoryTransactionList");
            recyclerView2.setAdapter(new CategoryTransactionsAdapter(getViewModel().getSVTransactionVMs(sVCategory)));
            observeTransactionListAction();
        }
        getViewModel().getGoBackEvent().observe(getViewLifecycleOwner(), new EventObserver(new ServiceCategoryTransactionsFragment$onViewCreated$2(this)));
    }

    private final void observeTransactionListAction() {
        T t;
        T t2;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        List<Fragment> fragments = parentFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "parentFragmentManager.fragments");
        Iterator<T> it = fragments.iterator();
        while (true) {
            t = null;
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (Intrinsics.areEqual(t2.getClass(), HomeServicesFragment.class)) {
                break;
            }
        }
        if (t2 instanceof HomeServicesFragment) {
            t = t2;
        }
        T t3 = t;
        getViewModel().getStartChromeEvent().observe(getViewLifecycleOwner(), new EventObserver(new ServiceCategoryTransactionsFragment$observeTransactionListAction$1(t3)));
        getViewModel().getOpenURLEvent().observe(getViewLifecycleOwner(), new EventObserver(new ServiceCategoryTransactionsFragment$observeTransactionListAction$2(t3)));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/digitalwallet/app/view/svservices/ServiceCategoryTransactionsFragment$Companion;", "", "()V", ServiceCategoryTransactionsFragment.SV_SERVICE_CATEGORY_KEY, "", ServiceCategoryTransactionsFragment.SV_SERVICE_GROUP_NAME_KEY, "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ServiceCategoryTransactionsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
