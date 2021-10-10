package com.digitalwallet.app.view.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.digitalwallet.app.R;
import com.digitalwallet.app.databinding.FragmentServiceTypeBinding;
import com.digitalwallet.app.view.main.adapter.ServiceTypeAdapter;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.view.base.BasicFragment;
import com.google.android.gms.analytics.ecommerce.Promotion;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/digitalwallet/app/view/main/ServiceTypeFragment;", "Lcom/digitalwallet/view/base/BasicFragment;", "()V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "serviceTypeAdapter", "Lcom/digitalwallet/app/view/main/adapter/ServiceTypeAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "", "onViewCreated", Promotion.ACTION_VIEW, "setScreen", "setUserVisibleHint", "isVisibleToUser", "", "setupRX", "startServiceDetailFragment", "serviceTypeItemViewModel", "Lcom/digitalwallet/app/view/main/ServiceType;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ServiceTypeFragment.kt */
public final class ServiceTypeFragment extends BasicFragment {
    private HashMap _$_findViewCache;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final ServiceTypeAdapter serviceTypeAdapter = new ServiceTypeAdapter();

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
        FragmentServiceTypeBinding inflate = FragmentServiceTypeBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "FragmentServiceTypeBindi…flater, container, false)");
        return inflate.getRoot();
    }

    @Override // androidx.fragment.app.Fragment, com.digitalwallet.view.base.BasicFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        setScreen();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.serviceTypeRecyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "serviceTypeRecyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.serviceTypeRecyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "serviceTypeRecyclerView");
        recyclerView2.setAdapter(this.serviceTypeAdapter);
        this.serviceTypeAdapter.updateList(ArraysKt.toList(ServiceType.values()));
        setupRX();
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
            ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), ActivityAnalyticsHelper.Screen.MyServicesCategory, null, null, 6, null);
        }
    }

    private final void setupRX() {
        this.disposables.add(this.serviceTypeAdapter.getSelectedTypeItemViewModel().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ServiceTypeFragment$setupRX$1(this)));
    }

    /* access modifiers changed from: private */
    public final void startServiceDetailFragment(ServiceType serviceType) {
        FragmentManager supportFragmentManager;
        ServiceDetailFragment newInstance = ServiceDetailFragment.Companion.newInstance(serviceType);
        Context context = getContext();
        if (!(context instanceof AppCompatActivity)) {
            context = null;
        }
        AppCompatActivity appCompatActivity = (AppCompatActivity) context;
        if (!(appCompatActivity == null || (supportFragmentManager = appCompatActivity.getSupportFragmentManager()) == null)) {
            List<Fragment> fragments = supportFragmentManager.getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
            for (T t : fragments) {
                Intrinsics.checkNotNullExpressionValue(t, "it");
                t.setUserVisibleHint(false);
            }
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
            beginTransaction.setCustomAnimations(au.gov.vic.service.digitalwallet.citizen.R.anim.slide_in_up, au.gov.vic.service.digitalwallet.citizen.R.anim.slide_out_down, au.gov.vic.service.digitalwallet.citizen.R.anim.slide_in_up, au.gov.vic.service.digitalwallet.citizen.R.anim.slide_out_down);
            String simpleName = Reflection.getOrCreateKotlinClass(ServiceDetailFragment.class).getSimpleName();
            beginTransaction.add(au.gov.vic.service.digitalwallet.citizen.R.id.fragment_container_RES_2114322527, newInstance, simpleName).addToBackStack(simpleName).commit();
        }
    }
}
