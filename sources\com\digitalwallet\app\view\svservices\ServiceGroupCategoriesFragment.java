package com.digitalwallet.app.view.svservices;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.FragmentServiceGroupCategoriesBinding;
import com.digitalwallet.app.model.login.SVService;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.view.svservices.adapter.GroupCategoriesAdapter;
import com.digitalwallet.app.viewmodel.svservices.ServiceGroupCategoriesViewModel;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.utilities.EventObserver;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/digitalwallet/app/view/svservices/ServiceGroupCategoriesFragment;", "Lcom/digitalwallet/app/view/base/BaseAppFragment;", "Lcom/digitalwallet/app/databinding/FragmentServiceGroupCategoriesBinding;", "()V", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/app/viewmodel/svservices/ServiceGroupCategoriesViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/svservices/ServiceGroupCategoriesViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/svservices/ServiceGroupCategoriesViewModel;)V", "observeCategoryListAction", "", SVService.TYPE_GROUP, "Lcom/digitalwallet/app/model/login/SVService;", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ServiceGroupCategoriesFragment.kt */
public final class ServiceGroupCategoriesFragment extends BaseAppFragment<FragmentServiceGroupCategoriesBinding> {
    public static final Companion Companion = new Companion(null);
    public static final String SV_SERVICE_GROUP_KEY = "SV_SERVICE_GROUP_KEY";
    private HashMap _$_findViewCache;
    private final int layoutId = R.layout.fragment_service_group_categories;
    @Inject
    public ServiceGroupCategoriesViewModel viewModel;

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
    public ServiceGroupCategoriesViewModel getViewModel() {
        ServiceGroupCategoriesViewModel serviceGroupCategoriesViewModel = this.viewModel;
        if (serviceGroupCategoriesViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return serviceGroupCategoriesViewModel;
    }

    public void setViewModel(ServiceGroupCategoriesViewModel serviceGroupCategoriesViewModel) {
        Intrinsics.checkNotNullParameter(serviceGroupCategoriesViewModel, "<set-?>");
        this.viewModel = serviceGroupCategoriesViewModel;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ActivityAnalyticsHelper.setScreenName$default(new ActivityAnalyticsHelper(requireActivity), ActivityAnalyticsHelper.Screen.LoginServiceGroupCategories, null, null, 6, null);
        ((FragmentServiceGroupCategoriesBinding) getBinding()).setLifecycleOwner(this);
        Bundle arguments = getArguments();
        SVService sVService = null;
        SVService sVService2 = arguments != null ? (SVService) arguments.getParcelable(SV_SERVICE_GROUP_KEY) : null;
        if (sVService2 instanceof SVService) {
            sVService = sVService2;
        }
        if (sVService != null) {
            if (Intrinsics.areEqual(sVService.getType(), SVService.TYPE_GROUP)) {
                getViewModel().updateServiceGroup(sVService);
                RecyclerView recyclerView = ((FragmentServiceGroupCategoriesBinding) getBinding()).groupCategoryList;
                Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.groupCategoryList");
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                RecyclerView recyclerView2 = ((FragmentServiceGroupCategoriesBinding) getBinding()).groupCategoryList;
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.groupCategoryList");
                recyclerView2.setAdapter(new GroupCategoriesAdapter(getViewModel().getSVCategoryVMs(sVService)));
                observeCategoryListAction(sVService);
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        getViewModel().getGoBackEvent().observe(getViewLifecycleOwner(), new EventObserver(new ServiceGroupCategoriesFragment$onViewCreated$2(this)));
    }

    private final void observeCategoryListAction(SVService sVService) {
        getViewModel().getNavigateToCategoryTransactionsEvent().observe(getViewLifecycleOwner(), new EventObserver(new ServiceGroupCategoriesFragment$observeCategoryListAction$1(this, sVService)));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/digitalwallet/app/view/svservices/ServiceGroupCategoriesFragment$Companion;", "", "()V", ServiceGroupCategoriesFragment.SV_SERVICE_GROUP_KEY, "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ServiceGroupCategoriesFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
