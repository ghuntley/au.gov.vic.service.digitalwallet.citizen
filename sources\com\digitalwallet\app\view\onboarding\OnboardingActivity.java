package com.digitalwallet.app.view.onboarding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.OnboardingBinding;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.view.base.AppDaggerAppCompatActivity;
import com.digitalwallet.app.view.login.LoginActivity;
import com.digitalwallet.app.view.onboarding.OnboardingViewModel;
import com.digitalwallet.services.RemoteConfigService;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.ServerTypeKt;
import com.digitalwallet.view.main.BackHandler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0002%&B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u001dH\u0016J\u0012\u0010!\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\u001dH\u0014R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006'"}, d2 = {"Lcom/digitalwallet/app/view/onboarding/OnboardingActivity;", "Lcom/digitalwallet/app/view/base/AppDaggerAppCompatActivity;", "Lcom/digitalwallet/app/view/onboarding/OnboardingViewModel;", "()V", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "getAnalytics", "()Lcom/digitalwallet/utilities/AnalyticsHelper;", "setAnalytics", "(Lcom/digitalwallet/utilities/AnalyticsHelper;)V", "authenticationUtility", "Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "getAuthenticationUtility", "()Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "setAuthenticationUtility", "(Lcom/digitalwallet/app/oidc/AuthenticationUtility;)V", "bindings", "Lcom/digitalwallet/app/databinding/OnboardingBinding;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "navigateToLogin", "", "remoteConfigService", "Lcom/digitalwallet/services/RemoteConfigService;", "getRemoteConfigService", "()Lcom/digitalwallet/services/RemoteConfigService;", "setRemoteConfigService", "(Lcom/digitalwallet/services/RemoteConfigService;)V", "done", "", "isSkip", "next", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "PageChangeListener", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: OnboardingActivity.kt */
public final class OnboardingActivity extends AppDaggerAppCompatActivity implements OnboardingViewModel {
    public static final Companion Companion = new Companion(null);
    private static final String EXTRA_NAVIGATE_TO_LOGIN = "navigatetologin";
    private HashMap _$_findViewCache;
    @Inject
    public AnalyticsHelper analytics;
    @Inject
    public AuthenticationUtility authenticationUtility;
    private OnboardingBinding bindings;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private boolean navigateToLogin;
    @Inject
    public RemoteConfigService remoteConfigService;

    @Override // com.digitalwallet.app.view.base.AppDaggerAppCompatActivity
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.digitalwallet.app.view.base.AppDaggerAppCompatActivity
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/digitalwallet/app/view/onboarding/OnboardingActivity$Companion;", "", "()V", "EXTRA_NAVIGATE_TO_LOGIN", "", "startActivity", "", "context", "Landroid/content/Context;", "navigateToLogin", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: OnboardingActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(Context context, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, OnboardingActivity.class);
            intent.putExtra(OnboardingActivity.EXTRA_NAVIGATE_TO_LOGIN, z);
            context.startActivity(intent);
        }
    }

    public final AuthenticationUtility getAuthenticationUtility() {
        AuthenticationUtility authenticationUtility2 = this.authenticationUtility;
        if (authenticationUtility2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authenticationUtility");
        }
        return authenticationUtility2;
    }

    public final void setAuthenticationUtility(AuthenticationUtility authenticationUtility2) {
        Intrinsics.checkNotNullParameter(authenticationUtility2, "<set-?>");
        this.authenticationUtility = authenticationUtility2;
    }

    public final RemoteConfigService getRemoteConfigService() {
        RemoteConfigService remoteConfigService2 = this.remoteConfigService;
        if (remoteConfigService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("remoteConfigService");
        }
        return remoteConfigService2;
    }

    public final void setRemoteConfigService(RemoteConfigService remoteConfigService2) {
        Intrinsics.checkNotNullParameter(remoteConfigService2, "<set-?>");
        this.remoteConfigService = remoteConfigService2;
    }

    public final AnalyticsHelper getAnalytics() {
        AnalyticsHelper analyticsHelper = this.analytics;
        if (analyticsHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analyticsHelper;
    }

    public final void setAnalytics(AnalyticsHelper analyticsHelper) {
        Intrinsics.checkNotNullParameter(analyticsHelper, "<set-?>");
        this.analytics = analyticsHelper;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.digitalwallet.app.view.base.AppDaggerAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        createComponent().inject(this);
        super.onCreate(bundle);
        this.navigateToLogin = getIntent().getBooleanExtra(EXTRA_NAVIGATE_TO_LOGIN, false);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.onboarding);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…his, R.layout.onboarding)");
        OnboardingBinding onboardingBinding = (OnboardingBinding) contentView;
        this.bindings = onboardingBinding;
        if (onboardingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindings");
        }
        onboardingBinding.setViewModel(this);
        OnboardingBinding onboardingBinding2 = this.bindings;
        if (onboardingBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindings");
        }
        PageChangeListener pageChangeListener = new PageChangeListener(onboardingBinding2);
        pageChangeListener.onPageSelected(0);
        OnboardingBinding onboardingBinding3 = this.bindings;
        if (onboardingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindings");
        }
        onboardingBinding3.pager.addOnPageChangeListener(pageChangeListener);
        OnboardingBinding onboardingBinding4 = this.bindings;
        if (onboardingBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindings");
        }
        ViewPager viewPager = onboardingBinding4.pager;
        Intrinsics.checkNotNullExpressionValue(viewPager, "bindings.pager");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        viewPager.setAdapter(new OnboardingPagerAdapter(supportFragmentManager));
        if (ServerTypeKt.getAppType() == AppType.CITIZEN) {
            RemoteConfigService remoteConfigService2 = this.remoteConfigService;
            if (remoteConfigService2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("remoteConfigService");
            }
            this.compositeDisposable.add(remoteConfigService2.getRemoteConfig().observeOn(AndroidSchedulers.mainThread()).subscribe(new OnboardingActivity$onCreate$1(this)));
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        this.compositeDisposable.clear();
    }

    @Override // com.digitalwallet.app.view.onboarding.OnboardingViewModel
    public void done(boolean z) {
        if (z) {
            AnalyticsHelper analyticsHelper = this.analytics;
            if (analyticsHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            AnalyticsHelper.selectContent$default(analyticsHelper, "Onboarding - skip button tapped", null, 2, null);
        }
        AuthenticationUtility authenticationUtility2 = this.authenticationUtility;
        if (authenticationUtility2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authenticationUtility");
        }
        authenticationUtility2.setFirstRun();
        if (this.navigateToLogin) {
            LoginActivity.Companion.navigate(this, false);
        } else {
            finish();
        }
    }

    @Override // com.digitalwallet.app.view.onboarding.OnboardingViewModel
    public void next() {
        OnboardingBinding onboardingBinding = this.bindings;
        if (onboardingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindings");
        }
        ViewPager viewPager = onboardingBinding.pager;
        Intrinsics.checkNotNullExpressionValue(viewPager, "bindings.pager");
        PagerAdapter adapter = viewPager.getAdapter();
        int count = adapter != null ? adapter.getCount() : OnboardingPagerAdapter.Companion.getItemCount();
        OnboardingBinding onboardingBinding2 = this.bindings;
        if (onboardingBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindings");
        }
        ViewPager viewPager2 = onboardingBinding2.pager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "bindings.pager");
        if (viewPager2.getCurrentItem() == count - 1) {
            OnboardingViewModel.DefaultImpls.done$default(this, false, 1, null);
            return;
        }
        OnboardingBinding onboardingBinding3 = this.bindings;
        if (onboardingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindings");
        }
        ViewPager viewPager3 = onboardingBinding3.pager;
        Intrinsics.checkNotNullExpressionValue(viewPager3, "bindings.pager");
        viewPager3.setCurrentItem(viewPager3.getCurrentItem() + 1);
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        boolean z = false;
        if (!(supportFragmentManager.getBackStackEntryCount() == 0)) {
            FragmentManager supportFragmentManager2 = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "supportFragmentManager");
            List<Fragment> fragments = supportFragmentManager2.getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
            Fragment fragment = (Fragment) CollectionsKt.lastOrNull((List) fragments);
            if (!(fragment instanceof BackHandler)) {
                fragment = null;
            }
            BackHandler backHandler = (BackHandler) fragment;
            if (backHandler != null) {
                z = backHandler.handleBack();
            }
            if (z) {
                return;
            }
        }
        OnboardingBinding onboardingBinding = this.bindings;
        if (onboardingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindings");
        }
        ViewPager viewPager = onboardingBinding.pager;
        Intrinsics.checkNotNullExpressionValue(viewPager, "bindings.pager");
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
            return;
        }
        OnboardingBinding onboardingBinding2 = this.bindings;
        if (onboardingBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindings");
        }
        ViewPager viewPager2 = onboardingBinding2.pager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "bindings.pager");
        OnboardingBinding onboardingBinding3 = this.bindings;
        if (onboardingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindings");
        }
        ViewPager viewPager3 = onboardingBinding3.pager;
        Intrinsics.checkNotNullExpressionValue(viewPager3, "bindings.pager");
        viewPager2.setCurrentItem(viewPager3.getCurrentItem() - 1);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/digitalwallet/app/view/onboarding/OnboardingActivity$PageChangeListener;", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "bindings", "Lcom/digitalwallet/app/databinding/OnboardingBinding;", "(Lcom/digitalwallet/app/databinding/OnboardingBinding;)V", "getBindings", "()Lcom/digitalwallet/app/databinding/OnboardingBinding;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "dots", "", "Landroid/widget/ImageView;", "onPageSelected", "", "position", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: OnboardingActivity.kt */
    public static final class PageChangeListener extends ViewPager.SimpleOnPageChangeListener {
        private final OnboardingBinding bindings;
        private final Context context;
        private final List<ImageView> dots;

        public PageChangeListener(OnboardingBinding onboardingBinding) {
            Intrinsics.checkNotNullParameter(onboardingBinding, "bindings");
            this.bindings = onboardingBinding;
            this.dots = CollectionsKt.listOf((Object[]) new ImageView[]{onboardingBinding.dot1, onboardingBinding.dot2, onboardingBinding.dot3});
            View root = onboardingBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "bindings.root");
            this.context = root.getContext();
        }

        public final OnboardingBinding getBindings() {
            return this.bindings;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener, androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = i == OnboardingPagerAdapter.Companion.getItemCount() - 1;
            int i2 = 0;
            for (T t : this.dots) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                t.setImageResource(i2 == i ? R.drawable.pill_slate : R.drawable.pill_light);
                i2 = i3;
            }
            Button button = this.bindings.next;
            Intrinsics.checkNotNullExpressionValue(button, "bindings.next");
            button.setText(this.context.getString(z ? R.string.onboarding_lets_go : R.string.next_RES_2114650403));
        }
    }
}
