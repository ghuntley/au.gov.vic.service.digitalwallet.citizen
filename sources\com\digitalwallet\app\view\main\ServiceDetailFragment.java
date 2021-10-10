package com.digitalwallet.app.view.main;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.FragmentServiceDetailBinding;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.view.main.adapter.ServiceDetailAdapter;
import com.digitalwallet.app.view.util.CustomDividerItemDecoration;
import com.digitalwallet.app.viewmodel.main.ServiceDetailFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.ServiceTypeItem;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.google.android.gms.analytics.ecommerce.Promotion;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u001a\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/digitalwallet/app/view/main/ServiceDetailFragment;", "Lcom/digitalwallet/app/view/base/BaseAppFragment;", "Lcom/digitalwallet/app/databinding/FragmentServiceDetailBinding;", "()V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "layoutId", "", "getLayoutId", "()I", "serviceDetailAdapter", "Lcom/digitalwallet/app/view/main/adapter/ServiceDetailAdapter;", "type", "Lcom/digitalwallet/app/view/main/ServiceType;", "getType", "()Lcom/digitalwallet/app/view/main/ServiceType;", "setType", "(Lcom/digitalwallet/app/view/main/ServiceType;)V", "viewModel", "Lcom/digitalwallet/app/viewmodel/main/ServiceDetailFragmentViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/main/ServiceDetailFragmentViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/main/ServiceDetailFragmentViewModel;)V", "onDestroy", "", "onResume", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupRX", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ServiceDetailFragment.kt */
public final class ServiceDetailFragment extends BaseAppFragment<FragmentServiceDetailBinding> {
    public static final Companion Companion = new Companion(null);
    private static final String typeKey = "type";
    private HashMap _$_findViewCache;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final int layoutId = R.layout.fragment_service_detail;
    private ServiceDetailAdapter serviceDetailAdapter = new ServiceDetailAdapter();
    public ServiceType type;
    @Inject
    public ServiceDetailFragmentViewModel viewModel;

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
    public ServiceDetailFragmentViewModel getViewModel() {
        ServiceDetailFragmentViewModel serviceDetailFragmentViewModel = this.viewModel;
        if (serviceDetailFragmentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return serviceDetailFragmentViewModel;
    }

    public void setViewModel(ServiceDetailFragmentViewModel serviceDetailFragmentViewModel) {
        Intrinsics.checkNotNullParameter(serviceDetailFragmentViewModel, "<set-?>");
        this.viewModel = serviceDetailFragmentViewModel;
    }

    public final ServiceType getType() {
        ServiceType serviceType = this.type;
        if (serviceType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
        }
        return serviceType;
    }

    public final void setType(ServiceType serviceType) {
        Intrinsics.checkNotNullParameter(serviceType, "<set-?>");
        this.type = serviceType;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("type") : null;
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.digitalwallet.app.view.main.ServiceType");
        this.type = (ServiceType) serializable;
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(com.digitalwallet.app.R.id.serviceDetailRecyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "serviceDetailRecyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(com.digitalwallet.app.R.id.serviceDetailRecyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "serviceDetailRecyclerView");
        recyclerView2.setAdapter(this.serviceDetailAdapter);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ((RecyclerView) _$_findCachedViewById(com.digitalwallet.app.R.id.serviceDetailRecyclerView)).addItemDecoration(new CustomDividerItemDecoration(requireContext, R.drawable.service_detail_recyclerview_divider));
        ServiceTypeItem.Companion companion = ServiceTypeItem.Companion;
        ServiceType serviceType = this.type;
        if (serviceType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
        }
        ServiceTypeItem from = companion.from(serviceType);
        getViewModel().getTitle().set(getString(from.getName()));
        getViewModel().getImage().set(Integer.valueOf(from.getImage()));
        this.serviceDetailAdapter.updateList(from.getServiceDetails());
        setupRX();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ServiceTypeItem.Companion companion = ServiceTypeItem.Companion;
        ServiceType serviceType = this.type;
        if (serviceType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
        }
        String string = getString(companion.from(serviceType).getName());
        Intrinsics.checkNotNullExpressionValue(string, "getString(ServiceTypeItem.from(type).name)");
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        Intrinsics.checkNotNullExpressionValue(activity, "activity!!");
        ActivityAnalyticsHelper.setScreenName$default(new ActivityAnalyticsHelper(activity), ActivityAnalyticsHelper.Screen.MyServicesMenu, string, null, 4, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.disposables.clear();
    }

    private final void setupRX() {
        this.disposables.add(this.serviceDetailAdapter.getSelectedDetailItemViewModel().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ServiceDetailFragment$setupRX$1(this)));
        this.disposables.add(getViewModel().getBackToMainActivity().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ServiceDetailFragment$setupRX$2(this)));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/view/main/ServiceDetailFragment$Companion;", "", "()V", "typeKey", "", "newInstance", "Lcom/digitalwallet/app/view/main/ServiceDetailFragment;", "serviceType", "Lcom/digitalwallet/app/view/main/ServiceType;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ServiceDetailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ServiceDetailFragment newInstance(ServiceType serviceType) {
            Intrinsics.checkNotNullParameter(serviceType, "serviceType");
            ServiceDetailFragment serviceDetailFragment = new ServiceDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("type", serviceType);
            serviceDetailFragment.setArguments(bundle);
            return serviceDetailFragment;
        }
    }
}
