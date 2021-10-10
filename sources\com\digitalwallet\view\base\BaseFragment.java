package com.digitalwallet.view.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.play.core.splitcompat.SplitCompat;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R \u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000@BX.¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u001b¨\u0006+"}, d2 = {"Lcom/digitalwallet/view/base/BaseFragment;", "T", "Landroidx/databinding/ViewDataBinding;", "Lcom/digitalwallet/view/base/BasicFragment;", "()V", "<set-?>", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "Landroidx/databinding/ViewDataBinding;", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "getViewModel", "()Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "viewModelFactory", "Lcom/digitalwallet/di/ViewModelFactory;", "getViewModelFactory", "()Lcom/digitalwallet/di/ViewModelFactory;", "setViewModelFactory", "(Lcom/digitalwallet/di/ViewModelFactory;)V", "vmBindingName", "getVmBindingName", "setVmBindingName", "(I)V", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", Promotion.ACTION_VIEW, "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: BaseFragment.kt */
public abstract class BaseFragment<T extends ViewDataBinding> extends BasicFragment {
    private HashMap _$_findViewCache;
    private T binding;
    @Inject
    public ViewModelFactory viewModelFactory;
    private int vmBindingName = 8;

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

    public abstract int getLayoutId();

    public abstract BaseViewModel getViewModel();

    @Override // androidx.fragment.app.Fragment, com.digitalwallet.view.base.BasicFragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public int getVmBindingName() {
        return this.vmBindingName;
    }

    public void setVmBindingName(int i) {
        this.vmBindingName = i;
    }

    public final T getBinding() {
        T t = this.binding;
        if (t == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return t;
    }

    public final ViewModelFactory getViewModelFactory() {
        ViewModelFactory viewModelFactory2 = this.viewModelFactory;
        if (viewModelFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return viewModelFactory2;
    }

    public final void setViewModelFactory(ViewModelFactory viewModelFactory2) {
        Intrinsics.checkNotNullParameter(viewModelFactory2, "<set-?>");
        this.viewModelFactory = viewModelFactory2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(false);
    }

    @Override // dagger.android.support.DaggerFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        SplitCompat.install(getActivity());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        T t = (T) DataBindingUtil.inflate(layoutInflater, getLayoutId(), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(t, "DataBindingUtil.inflate(…youtId, container, false)");
        this.binding = t;
        if (t == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return t.getRoot();
    }

    @Override // androidx.fragment.app.Fragment, com.digitalwallet.view.base.BasicFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        T t = this.binding;
        if (t == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        t.setVariable(getVmBindingName(), getViewModel());
        T t2 = this.binding;
        if (t2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        t2.setLifecycleOwner(this);
        T t3 = this.binding;
        if (t3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        t3.executePendingBindings();
    }
}
