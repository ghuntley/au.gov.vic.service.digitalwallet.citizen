package com.digitalwallet.app.view.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.digitalwallet.DigitalWalletApplication;
import com.digitalwallet.app.AppStartUp;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.di.AppComponent;
import com.digitalwallet.app.di.DaggerAppComponentClient;
import com.digitalwallet.app.di.DaggerAppComponentServer;
import com.digitalwallet.di.BaseComponent;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.ServerTypeKt;
import com.digitalwallet.view.base.BaseActivity;
import java.util.HashMap;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0017\u001a\u00020\u0018J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/digitalwallet/app/view/base/BaseAppActivity;", "T", "Landroidx/databinding/ViewDataBinding;", "Lcom/digitalwallet/view/base/BaseActivity;", "()V", "appStartUp", "Lcom/digitalwallet/app/AppStartUp;", "getAppStartUp", "()Lcom/digitalwallet/app/AppStartUp;", "setAppStartUp", "(Lcom/digitalwallet/app/AppStartUp;)V", "componentCreated", "", "getComponentCreated", "()Z", "setComponentCreated", "(Z)V", "vmBinding", "", "getVmBinding", "()I", "setVmBinding", "(I)V", "createComponent", "Lcom/digitalwallet/app/di/AppComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: BaseAppActivity.kt */
public abstract class BaseAppActivity<T extends ViewDataBinding> extends BaseActivity<T> {
    private HashMap _$_findViewCache;
    @Inject
    public AppStartUp appStartUp;
    private boolean componentCreated;
    private int vmBinding = BR.vm;

    @Override // com.digitalwallet.view.base.BaseActivity
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.digitalwallet.view.base.BaseActivity
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

    public final AppStartUp getAppStartUp() {
        AppStartUp appStartUp2 = this.appStartUp;
        if (appStartUp2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appStartUp");
        }
        return appStartUp2;
    }

    public final void setAppStartUp(AppStartUp appStartUp2) {
        Intrinsics.checkNotNullParameter(appStartUp2, "<set-?>");
        this.appStartUp = appStartUp2;
    }

    /* access modifiers changed from: protected */
    public final boolean getComponentCreated() {
        return this.componentCreated;
    }

    /* access modifiers changed from: protected */
    public final void setComponentCreated(boolean z) {
        this.componentCreated = z;
    }

    /* access modifiers changed from: protected */
    @Override // com.digitalwallet.view.base.BaseActivity
    public int getVmBinding() {
        return this.vmBinding;
    }

    /* access modifiers changed from: protected */
    @Override // com.digitalwallet.view.base.BaseActivity
    public void setVmBinding(int i) {
        this.vmBinding = i;
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
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.digitalwallet.view.base.BaseActivity
    public void onCreate(Bundle bundle) {
        if (this.componentCreated) {
            super.onCreate(bundle);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
