package com.digitalwallet.view.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.google.android.play.core.splitcompat.SplitCompat;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0(H\u0016J\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020*H\u0016J\u0012\u0010.\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\b\u00101\u001a\u00020*H\u0002R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX.¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0000@BX.¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010'¨\u00062"}, d2 = {"Lcom/digitalwallet/view/base/BaseActivity;", "T", "Landroidx/databinding/ViewDataBinding;", "Landroidx/appcompat/app/AppCompatActivity;", "Ldagger/android/HasAndroidInjector;", "()V", "<set-?>", "Lcom/digitalwallet/utilities/ActivityAnalyticsHelper;", "analytics", "getAnalytics", "()Lcom/digitalwallet/utilities/ActivityAnalyticsHelper;", "androidInjector", "Ldagger/android/DispatchingAndroidInjector;", "", "getAndroidInjector", "()Ldagger/android/DispatchingAndroidInjector;", "setAndroidInjector", "(Ldagger/android/DispatchingAndroidInjector;)V", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "Landroidx/databinding/ViewDataBinding;", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "getViewModel", "()Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "viewModelFactory", "Lcom/digitalwallet/di/ViewModelFactory;", "getViewModelFactory", "()Lcom/digitalwallet/di/ViewModelFactory;", "setViewModelFactory", "(Lcom/digitalwallet/di/ViewModelFactory;)V", "vmBinding", "getVmBinding", "setVmBinding", "(I)V", "Ldagger/android/AndroidInjector;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "performDataBinding", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: BaseActivity.kt */
public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity implements HasAndroidInjector {
    private HashMap _$_findViewCache;
    private ActivityAnalyticsHelper analytics;
    @Inject
    public DispatchingAndroidInjector<Object> androidInjector;
    private T binding;
    @Inject
    public ViewModelFactory viewModelFactory;
    private int vmBinding = 8;

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
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public abstract int getLayoutId();

    public abstract BaseViewModel getViewModel();

    /* access modifiers changed from: protected */
    public int getVmBinding() {
        return this.vmBinding;
    }

    /* access modifiers changed from: protected */
    public void setVmBinding(int i) {
        this.vmBinding = i;
    }

    public final T getBinding() {
        T t = this.binding;
        if (t == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return t;
    }

    public final ActivityAnalyticsHelper getAnalytics() {
        ActivityAnalyticsHelper activityAnalyticsHelper = this.analytics;
        if (activityAnalyticsHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return activityAnalyticsHelper;
    }

    public final DispatchingAndroidInjector<Object> getAndroidInjector() {
        DispatchingAndroidInjector<Object> dispatchingAndroidInjector = this.androidInjector;
        if (dispatchingAndroidInjector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("androidInjector");
        }
        return dispatchingAndroidInjector;
    }

    public final void setAndroidInjector(DispatchingAndroidInjector<Object> dispatchingAndroidInjector) {
        Intrinsics.checkNotNullParameter(dispatchingAndroidInjector, "<set-?>");
        this.androidInjector = dispatchingAndroidInjector;
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

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        SplitCompat.install(this);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        performDataBinding();
        this.analytics = new ActivityAnalyticsHelper(this);
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.getBackStackEntryCount() != 0) {
            super.onBackPressed();
        } else {
            moveTaskToBack(true);
        }
    }

    private final void performDataBinding() {
        T t = (T) DataBindingUtil.setContentView(this, getLayoutId());
        Intrinsics.checkNotNullExpressionValue(t, "DataBindingUtil.setContentView(this, layoutId)");
        this.binding = t;
        if (t == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        t.setVariable(getVmBinding(), getViewModel());
        T t2 = this.binding;
        if (t2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        t2.executePendingBindings();
    }

    @Override // dagger.android.HasAndroidInjector
    public AndroidInjector<Object> androidInjector() {
        DispatchingAndroidInjector<Object> dispatchingAndroidInjector = this.androidInjector;
        if (dispatchingAndroidInjector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("androidInjector");
        }
        return dispatchingAndroidInjector;
    }
}
