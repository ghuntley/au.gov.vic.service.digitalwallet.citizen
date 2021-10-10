package com.digitalwallet.app.view.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.digitalwallet.DigitalWalletApplication;
import com.digitalwallet.app.di.AppComponent;
import com.digitalwallet.app.di.DaggerAppComponentClient;
import com.digitalwallet.app.di.DaggerAppComponentServer;
import com.digitalwallet.di.BaseComponent;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.ServerTypeKt;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import java.util.HashMap;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0017H\u0016J\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/digitalwallet/app/view/base/AppDaggerAppCompatActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Ldagger/android/HasAndroidInjector;", "()V", "androidInjector", "Ldagger/android/DispatchingAndroidInjector;", "", "getAndroidInjector", "()Ldagger/android/DispatchingAndroidInjector;", "setAndroidInjector", "(Ldagger/android/DispatchingAndroidInjector;)V", "componentCreated", "", "getComponentCreated", "()Z", "setComponentCreated", "(Z)V", "viewModelFactory", "Lcom/digitalwallet/di/ViewModelFactory;", "getViewModelFactory", "()Lcom/digitalwallet/di/ViewModelFactory;", "setViewModelFactory", "(Lcom/digitalwallet/di/ViewModelFactory;)V", "Ldagger/android/AndroidInjector;", "createComponent", "Lcom/digitalwallet/app/di/AppComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AppDaggerAppCompatActivity.kt */
public abstract class AppDaggerAppCompatActivity extends AppCompatActivity implements HasAndroidInjector {
    private HashMap _$_findViewCache;
    @Inject
    public DispatchingAndroidInjector<Object> androidInjector;
    private boolean componentCreated;
    @Inject
    public ViewModelFactory viewModelFactory;

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
    public final boolean getComponentCreated() {
        return this.componentCreated;
    }

    /* access modifiers changed from: protected */
    public final void setComponentCreated(boolean z) {
        this.componentCreated = z;
    }

    public final AppComponent createComponent() {
        Context applicationContext = getApplicationContext();
        Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.digitalwallet.DigitalWalletApplication");
        BaseComponent baseComponent = ((DigitalWalletApplication) applicationContext).getBaseComponent();
        this.componentCreated = true;
        if (ServerTypeKt.getAppType() == AppType.AUTHORITY) {
            return DaggerAppComponentClient.factory().create(baseComponent);
        }
        return DaggerAppComponentServer.factory().create(baseComponent);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        if (this.componentCreated) {
            super.onCreate(bundle);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
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
