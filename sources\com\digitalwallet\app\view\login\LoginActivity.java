package com.digitalwallet.app.view.login;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.LoginHelloBinding;
import com.digitalwallet.app.oidc.AuthSession;
import com.digitalwallet.app.services.remotenotification.RemoteSubscriptionService;
import com.digitalwallet.app.view.base.BaseAppActivity;
import com.digitalwallet.app.view.util.CustomTabProvider;
import com.digitalwallet.app.viewmodel.login.LoginActivityViewModel;
import com.digitalwallet.services.RemoteConfigService;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.ServerTypeKt;
import com.digitalwallet.view.main.BackHandler;
import com.google.firebase.messaging.Constants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import net.openid.appauth.AuthorizationException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0002J\u0006\u0010%\u001a\u00020!J\"\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\b\u0010+\u001a\u00020!H\u0016J\u0012\u0010,\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020!H\u0014J\b\u00100\u001a\u00020!H\u0014J\b\u00101\u001a\u00020!H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u001b8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u00063"}, d2 = {"Lcom/digitalwallet/app/view/login/LoginActivity;", "Lcom/digitalwallet/app/view/base/BaseAppActivity;", "Lcom/digitalwallet/app/databinding/LoginHelloBinding;", "()V", "customTabsPackageName", "", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "layoutId", "", "getLayoutId", "()I", "loginProgress", "Landroid/app/Dialog;", "remoteConfigService", "Lcom/digitalwallet/services/RemoteConfigService;", "getRemoteConfigService", "()Lcom/digitalwallet/services/RemoteConfigService;", "setRemoteConfigService", "(Lcom/digitalwallet/services/RemoteConfigService;)V", "remoteSubscriptionService", "Lcom/digitalwallet/app/services/remotenotification/RemoteSubscriptionService;", "getRemoteSubscriptionService", "()Lcom/digitalwallet/app/services/remotenotification/RemoteSubscriptionService;", "setRemoteSubscriptionService", "(Lcom/digitalwallet/app/services/remotenotification/RemoteSubscriptionService;)V", "viewModel", "Lcom/digitalwallet/app/viewmodel/login/LoginActivityViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/login/LoginActivityViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/login/LoginActivityViewModel;)V", "dismissLoginProgressIndicator", "", "handleAuthenticationError", "error", "", "login", "onActivityResult", "requestCode", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "showLoginProgressIndicator", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: LoginActivity.kt */
public final class LoginActivity extends BaseAppActivity<LoginHelloBinding> {
    public static final Companion Companion = new Companion(null);
    private static final String LOGIN_EXPIRED_KEY = "LOGIN_EXPIRED";
    public static final String PRESENT_LOGIN_SCREEN_KEY = "PRESENT_LOGIN_SCREEN";
    private HashMap _$_findViewCache;
    private String customTabsPackageName;
    private CompositeDisposable disposables = new CompositeDisposable();
    private final int layoutId = R.layout.login_hello;
    private Dialog loginProgress;
    @Inject
    public RemoteConfigService remoteConfigService;
    @Inject
    public RemoteSubscriptionService remoteSubscriptionService;
    @Inject
    public LoginActivityViewModel viewModel;

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
    public LoginActivityViewModel getViewModel() {
        LoginActivityViewModel loginActivityViewModel = this.viewModel;
        if (loginActivityViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return loginActivityViewModel;
    }

    public void setViewModel(LoginActivityViewModel loginActivityViewModel) {
        Intrinsics.checkNotNullParameter(loginActivityViewModel, "<set-?>");
        this.viewModel = loginActivityViewModel;
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

    public final RemoteSubscriptionService getRemoteSubscriptionService() {
        RemoteSubscriptionService remoteSubscriptionService2 = this.remoteSubscriptionService;
        if (remoteSubscriptionService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("remoteSubscriptionService");
        }
        return remoteSubscriptionService2;
    }

    public final void setRemoteSubscriptionService(RemoteSubscriptionService remoteSubscriptionService2) {
        Intrinsics.checkNotNullParameter(remoteSubscriptionService2, "<set-?>");
        this.remoteSubscriptionService = remoteSubscriptionService2;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.digitalwallet.app.view.base.BaseAppActivity, com.digitalwallet.view.base.BaseActivity
    public void onCreate(Bundle bundle) {
        Bundle extras;
        Bundle extras2;
        createComponent().inject(this);
        super.onCreate(bundle);
        ((LoginHelloBinding) getBinding()).setLifecycleOwner(this);
        LoginActivity loginActivity = this;
        String customTabsPackageName2 = CustomTabProvider.INSTANCE.getCustomTabsPackageName(loginActivity);
        this.customTabsPackageName = customTabsPackageName2;
        if (customTabsPackageName2 != null) {
            CustomTabsClient.bindCustomTabsService(loginActivity, customTabsPackageName2, CustomTabProvider.INSTANCE.getTabsServiceConnection());
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.replace(R.id.fragment_container_RES_2114322527, HomeServicesFragment.Companion.newInstance(true), Reflection.getOrCreateKotlinClass(HomeServicesFragment.class).getSimpleName()).commit();
        Intent intent = getIntent();
        if (!(intent == null || (extras2 = intent.getExtras()) == null || !extras2.getBoolean(LOGIN_EXPIRED_KEY))) {
            Toast.makeText(loginActivity, getResources().getString(R.string.login_expired_copy), 1).show();
        }
        Intent intent2 = getIntent();
        if (!(intent2 == null || (extras = intent2.getExtras()) == null || !extras.getBoolean(PRESENT_LOGIN_SCREEN_KEY))) {
            login();
        }
        RemoteSubscriptionService remoteSubscriptionService2 = this.remoteSubscriptionService;
        if (remoteSubscriptionService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("remoteSubscriptionService");
        }
        remoteSubscriptionService2.registerRemoteNotification();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.customTabsPackageName != null) {
            unbindService(CustomTabProvider.INSTANCE.getTabsServiceConnection());
        }
        Dialog dialog = this.loginProgress;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.loginProgress = null;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), ActivityAnalyticsHelper.Screen.LoginHello, null, null, 6, null);
        if (ServerTypeKt.getAppType() == AppType.CITIZEN) {
            RemoteConfigService remoteConfigService2 = this.remoteConfigService;
            if (remoteConfigService2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("remoteConfigService");
            }
            this.disposables.add(remoteConfigService2.getRemoteConfig().observeOn(AndroidSchedulers.mainThread()).subscribe(new LoginActivity$onResume$1(this)));
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null) {
            AuthSession authSession = getViewModel().getAuthSession();
            if (authSession == null || getViewModel().handleLoginActivityResult(i, intent, authSession).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new LoginActivity$onActivityResult$$inlined$let$lambda$1(this, i, intent), new LoginActivity$sam$i$io_reactivex_functions_Consumer$0(new LoginActivity$onActivityResult$1$2(this))) == null) {
                handleAuthenticationError(new NullPointerException("Auth Session not set"));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void login() {
        getAnalytics().selectContent("Authenticate", "Log in");
        showLoginProgressIndicator();
        this.disposables.add(getViewModel().getAuthRequest().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new LoginActivity$login$1(this), new LoginActivity$sam$io_reactivex_functions_Consumer$0(new LoginActivity$login$2(this))));
    }

    /* access modifiers changed from: private */
    public final void handleAuthenticationError(Throwable th) {
        dismissLoginProgressIndicator();
        Toast.makeText(this, Intrinsics.areEqual(th, AuthorizationException.GeneralErrors.NETWORK_ERROR) ? "Connection error was encountered.\nPlease try again later." : "There was an error during log in.", 1).show();
    }

    private final void showLoginProgressIndicator() {
        Dialog dialog = new Dialog(this, 16973840);
        dialog.setContentView(R.layout.login_progress);
        dialog.show();
        Unit unit = Unit.INSTANCE;
        this.loginProgress = dialog;
    }

    /* access modifiers changed from: private */
    public final void dismissLoginProgressIndicator() {
        Dialog dialog = this.loginProgress;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.loginProgress = null;
    }

    @Override // androidx.activity.ComponentActivity, com.digitalwallet.view.base.BaseActivity
    public void onBackPressed() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        boolean z = false;
        if (supportFragmentManager.getBackStackEntryCount() == 0) {
            finish();
            return;
        }
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
        if (!z) {
            super.onBackPressed();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/digitalwallet/app/view/login/LoginActivity$Companion;", "", "()V", "LOGIN_EXPIRED_KEY", "", "PRESENT_LOGIN_SCREEN_KEY", "navigate", "", "context", "Landroid/content/Context;", "loginExpired", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: LoginActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void navigate(Context context, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, LoginActivity.class);
            intent.setFlags(268468224);
            intent.putExtra(LoginActivity.LOGIN_EXPIRED_KEY, z);
            context.startActivity(intent);
        }
    }
}
