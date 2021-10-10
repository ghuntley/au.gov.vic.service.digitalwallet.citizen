package com.digitalwallet.app.view.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.ActivitySplashBinding;
import com.digitalwallet.app.view.base.BaseAppActivity;
import com.digitalwallet.app.view.login.LoginActivity;
import com.digitalwallet.app.view.onboarding.OnboardingActivity;
import com.digitalwallet.app.view.pin.PinActivity;
import com.digitalwallet.app.viewmodel.splash.SplashViewModel;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0014H\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/digitalwallet/app/view/splash/SplashActivity;", "Lcom/digitalwallet/app/view/base/BaseAppActivity;", "Lcom/digitalwallet/app/databinding/ActivitySplashBinding;", "Lcom/digitalwallet/app/view/splash/SplashView;", "()V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/app/viewmodel/splash/SplashViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/splash/SplashViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/splash/SplashViewModel;)V", "navigateToLogin", "", "loginExpired", "", "navigateToOnboarding", "navigateToPin", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SplashActivity.kt */
public final class SplashActivity extends BaseAppActivity<ActivitySplashBinding> implements SplashView {
    private HashMap _$_findViewCache;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final int layoutId = R.layout.activity_splash;
    @Inject
    public SplashViewModel viewModel;

    @Override // com.digitalwallet.app.view.base.BaseAppActivity, com.digitalwallet.view.base.BaseActivity
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.digitalwallet.app.view.base.BaseAppActivity, com.digitalwallet.view.base.BaseActivity
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

    @Override // com.digitalwallet.view.base.BaseActivity
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.digitalwallet.view.base.BaseActivity
    public SplashViewModel getViewModel() {
        SplashViewModel splashViewModel = this.viewModel;
        if (splashViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return splashViewModel;
    }

    public void setViewModel(SplashViewModel splashViewModel) {
        Intrinsics.checkNotNullParameter(splashViewModel, "<set-?>");
        this.viewModel = splashViewModel;
    }

    public final CompositeDisposable getDisposables() {
        return this.disposables;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.digitalwallet.app.view.base.BaseAppActivity, com.digitalwallet.view.base.BaseActivity
    public void onCreate(Bundle bundle) {
        createComponent().inject(this);
        super.onCreate(bundle);
        getViewModel().inject(this);
        SplashActivity splashActivity = this;
        ((ActivitySplashBinding) getBinding()).setLifecycleOwner(splashActivity);
        getViewModel().getTokensExpired().observe(splashActivity, new SplashActivity$onCreate$1(this));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        new ActivityAnalyticsHelper(this).setScreenName(ActivityAnalyticsHelper.Screen.Splash, null, "SplashActivity");
    }

    @Override // com.digitalwallet.app.view.splash.SplashView
    public void navigateToLogin(boolean z) {
        LoginActivity.Companion.navigate(this, z);
    }

    @Override // com.digitalwallet.app.view.splash.SplashView
    public void navigateToOnboarding() {
        OnboardingActivity.Companion.startActivity(this, true);
    }

    @Override // com.digitalwallet.app.view.splash.SplashView
    public void navigateToPin() {
        Intent intent = new Intent(this, PinActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
    }
}
