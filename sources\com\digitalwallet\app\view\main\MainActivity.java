package com.digitalwallet.app.view.main;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.digitalwallet.DigitalWalletApplication;
import com.digitalwallet.app.databinding.ActivityMainBinding;
import com.digitalwallet.app.holdings.HoldingExpiryPublisher;
import com.digitalwallet.app.holdings.HoldingParser;
import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.oidc.model.Tokens;
import com.digitalwallet.app.services.BluetoothEventsService;
import com.digitalwallet.app.services.remotenotification.RemoteSubscriptionService;
import com.digitalwallet.app.view.SetupActivity;
import com.digitalwallet.app.view.base.BaseAppActivity;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.view.login.HomeServicesFragment;
import com.digitalwallet.app.view.pin.PinActivity;
import com.digitalwallet.app.view.util.AlertFragment;
import com.digitalwallet.app.view.util.CustomTabProvider;
import com.digitalwallet.app.viewmodel.main.MainActivityViewModel;
import com.digitalwallet.utilities.ActivityHelperKt;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.ServerTypeKt;
import com.digitalwallet.view.util.ViewUtilsKt;
import com.jakewharton.rxrelay2.BehaviorRelay;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import net.openid.appauth.ResponseTypeValues;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 W2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001WB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020%H\u0002J\b\u0010?\u001a\u00020<H\u0016J\u0012\u0010@\u001a\u00020<2\b\u0010A\u001a\u0004\u0018\u00010BH\u0014J\b\u0010C\u001a\u00020<H\u0014J\u0012\u0010D\u001a\u00020<2\b\u0010E\u001a\u0004\u0018\u00010FH\u0014J\b\u0010G\u001a\u00020<H\u0014J\b\u0010H\u001a\u00020<H\u0015J\b\u0010I\u001a\u00020<H\u0014J\b\u0010J\u001a\u00020.H\u0016J\u0010\u0010K\u001a\u00020<2\u0006\u0010L\u001a\u00020MH\u0002J\b\u0010N\u001a\u00020<H\u0002J\u000e\u0010O\u001a\u00020<2\u0006\u0010L\u001a\u00020\u0017J\u0016\u0010P\u001a\u00020<2\u0006\u0010Q\u001a\u00020\u00172\u0006\u0010R\u001a\u00020.J\b\u0010S\u001a\u00020<H\u0007J\u0016\u0010T\u001a\u00020U*\u00020U2\b\u0010V\u001a\u0004\u0018\u00010\u0017H\u0002R\u001f\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%XD¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020%XD¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010/\u001a\u0002008\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\u0002068\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006X"}, d2 = {"Lcom/digitalwallet/app/view/main/MainActivity;", "Lcom/digitalwallet/app/view/base/BaseAppActivity;", "Lcom/digitalwallet/app/databinding/ActivityMainBinding;", "()V", "atFront", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "", "kotlin.jvm.PlatformType", "getAtFront", "()Lcom/jakewharton/rxrelay2/BehaviorRelay;", "authenticationUtility", "Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "getAuthenticationUtility", "()Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "setAuthenticationUtility", "(Lcom/digitalwallet/app/oidc/AuthenticationUtility;)V", "bluetoothEvents", "Lcom/digitalwallet/app/services/BluetoothEventsService;", "getBluetoothEvents", "()Lcom/digitalwallet/app/services/BluetoothEventsService;", "setBluetoothEvents", "(Lcom/digitalwallet/app/services/BluetoothEventsService;)V", "customTabsPackageName", "", "holdingParser", "Lcom/digitalwallet/app/holdings/HoldingParser;", "getHoldingParser", "()Lcom/digitalwallet/app/holdings/HoldingParser;", "setHoldingParser", "(Lcom/digitalwallet/app/holdings/HoldingParser;)V", "holdingsService", "Lcom/digitalwallet/app/holdings/HoldingsService;", "getHoldingsService", "()Lcom/digitalwallet/app/holdings/HoldingsService;", "setHoldingsService", "(Lcom/digitalwallet/app/holdings/HoldingsService;)V", "layoutId", "", "getLayoutId", "()I", "menuResource", "menuTabs", "", "Landroidx/fragment/app/Fragment;", "permissionsRequest", "pinEnteredForSession", "", "remoteSubscriptionService", "Lcom/digitalwallet/app/services/remotenotification/RemoteSubscriptionService;", "getRemoteSubscriptionService", "()Lcom/digitalwallet/app/services/remotenotification/RemoteSubscriptionService;", "setRemoteSubscriptionService", "(Lcom/digitalwallet/app/services/remotenotification/RemoteSubscriptionService;)V", "viewModel", "Lcom/digitalwallet/app/viewmodel/main/MainActivityViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/main/MainActivityViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/main/MainActivityViewModel;)V", "initBottomMenuOptions", "", "maybeStartCardSharingSetup", "currentBottomTabIndex", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "onStart", "onStop", "onSupportNavigateUp", "openURL", "fullUrl", "Landroid/net/Uri;", "setupBottomNavigationBar", "startChrome", "startChromeCustomTabs", "uriString", "isSecure", "vibrateForShare", "addSecureParams", "Landroid/net/Uri$Builder;", "redirectUrl", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: MainActivity.kt */
public class MainActivity extends BaseAppActivity<ActivityMainBinding> {
    public static final Companion Companion = new Companion(null);
    private static final Class<? extends MainActivity> intentClass;
    private HashMap _$_findViewCache;
    private final BehaviorRelay<Object> atFront;
    @Inject
    public AuthenticationUtility authenticationUtility;
    @Inject
    public BluetoothEventsService bluetoothEvents;
    private String customTabsPackageName;
    @Inject
    public HoldingParser holdingParser;
    @Inject
    public HoldingsService holdingsService;
    private final int layoutId = R.layout.activity_main;
    private final int menuResource;
    private List<? extends Fragment> menuTabs;
    private final int permissionsRequest = 1;
    private boolean pinEnteredForSession;
    @Inject
    public RemoteSubscriptionService remoteSubscriptionService;
    @Inject
    public MainActivityViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[AppType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AppType.AUTHORITY.ordinal()] = 1;
            iArr[AppType.CITIZEN.ordinal()] = 2;
            int[] iArr2 = new int[AppType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[AppType.AUTHORITY.ordinal()] = 1;
            iArr2[AppType.CITIZEN.ordinal()] = 2;
        }
    }

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

    public MainActivity() {
        int i;
        BehaviorRelay<Object> create = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create<Any>()");
        this.atFront = create;
        int i2 = WhenMappings.$EnumSwitchMapping$0[ServerTypeKt.getAppType().ordinal()];
        if (i2 == 1) {
            i = R.menu.bottom_navigation_menu_authority;
        } else if (i2 == 2) {
            i = R.menu.bottom_navigation_menu_citizen;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.menuResource = i;
    }

    public static final /* synthetic */ List access$getMenuTabs$p(MainActivity mainActivity) {
        List<? extends Fragment> list = mainActivity.menuTabs;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuTabs");
        }
        return list;
    }

    @Override // com.digitalwallet.view.base.BaseActivity
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.digitalwallet.view.base.BaseActivity
    public MainActivityViewModel getViewModel() {
        MainActivityViewModel mainActivityViewModel = this.viewModel;
        if (mainActivityViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return mainActivityViewModel;
    }

    public void setViewModel(MainActivityViewModel mainActivityViewModel) {
        Intrinsics.checkNotNullParameter(mainActivityViewModel, "<set-?>");
        this.viewModel = mainActivityViewModel;
    }

    public final HoldingParser getHoldingParser() {
        HoldingParser holdingParser2 = this.holdingParser;
        if (holdingParser2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("holdingParser");
        }
        return holdingParser2;
    }

    public final void setHoldingParser(HoldingParser holdingParser2) {
        Intrinsics.checkNotNullParameter(holdingParser2, "<set-?>");
        this.holdingParser = holdingParser2;
    }

    public final HoldingsService getHoldingsService() {
        HoldingsService holdingsService2 = this.holdingsService;
        if (holdingsService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("holdingsService");
        }
        return holdingsService2;
    }

    public final void setHoldingsService(HoldingsService holdingsService2) {
        Intrinsics.checkNotNullParameter(holdingsService2, "<set-?>");
        this.holdingsService = holdingsService2;
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

    public final BluetoothEventsService getBluetoothEvents() {
        BluetoothEventsService bluetoothEventsService = this.bluetoothEvents;
        if (bluetoothEventsService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bluetoothEvents");
        }
        return bluetoothEventsService;
    }

    public final void setBluetoothEvents(BluetoothEventsService bluetoothEventsService) {
        Intrinsics.checkNotNullParameter(bluetoothEventsService, "<set-?>");
        this.bluetoothEvents = bluetoothEventsService;
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

    public final BehaviorRelay<Object> getAtFront() {
        return this.atFront;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/digitalwallet/app/view/main/MainActivity$Companion;", "", "()V", "intentClass", "Ljava/lang/Class;", "Lcom/digitalwallet/app/view/main/MainActivity;", "getIntentClass", "()Ljava/lang/Class;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: MainActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Class<? extends MainActivity> getIntentClass() {
            return MainActivity.intentClass;
        }
    }

    static {
        Class<? extends MainActivity> cls;
        if (ServerTypeKt.getAppType() == AppType.AUTHORITY) {
            cls = MainActivity.class;
        } else {
            cls = MainActivityServer.class;
        }
        intentClass = cls;
    }

    private final void initBottomMenuOptions() {
        List<? extends Fragment> list;
        int i = WhenMappings.$EnumSwitchMapping$1[ServerTypeKt.getAppType().ordinal()];
        if (i == 1) {
            list = CollectionsKt.listOf((Object[]) new BaseAppFragment[]{new HoldingListFragment(), MainPagerFragment.Companion.newInstance(MainFragmentType.Account)});
        } else if (i == 2) {
            list = CollectionsKt.listOf((Object[]) new BaseAppFragment[]{HomeServicesFragment.Companion.newInstance$default(HomeServicesFragment.Companion, false, 1, null), new HoldingListFragment(), MainPagerFragment.Companion.newInstance(MainFragmentType.Account)});
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.menuTabs = list;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.digitalwallet.app.view.base.BaseAppActivity, com.digitalwallet.view.base.BaseActivity
    public void onCreate(Bundle bundle) {
        if (!getComponentCreated()) {
            createComponent().inject(this);
        }
        super.onCreate(bundle);
        BluetoothEventsService bluetoothEventsService = this.bluetoothEvents;
        if (bluetoothEventsService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bluetoothEvents");
        }
        MainActivity mainActivity = this;
        bluetoothEventsService.register(mainActivity);
        initBottomMenuOptions();
        setupBottomNavigationBar();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        List<? extends Fragment> list = this.menuTabs;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuTabs");
        }
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.replace(R.id.fragment_container_RES_2114322527, (Fragment) list.get(0), Reflection.getOrCreateKotlinClass(Fragment.class).getSimpleName()).commit();
        getViewModel().getRemoteConfig().addOnPropertyChangedCallback(new MainActivity$onCreate$1(this));
        this.pinEnteredForSession = getIntent().getBooleanExtra(PinActivity.PIN_ENTERED_KEY, false);
        getSupportFragmentManager().addOnBackStackChangedListener(new MainActivity$onCreate$2(this));
        String customTabsPackageName2 = CustomTabProvider.INSTANCE.getCustomTabsPackageName(mainActivity);
        this.customTabsPackageName = customTabsPackageName2;
        if (customTabsPackageName2 != null) {
            CustomTabsClient.bindCustomTabsService(mainActivity, customTabsPackageName2, CustomTabProvider.INSTANCE.getTabsServiceConnection());
        }
        CustomTabProvider.INSTANCE.getBackgroundState().observeForever(new MainActivity$onCreate$4(this));
        RemoteSubscriptionService remoteSubscriptionService2 = this.remoteSubscriptionService;
        if (remoteSubscriptionService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("remoteSubscriptionService");
        }
        remoteSubscriptionService2.registerRemoteNotification();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            AlertFragment createMultiAction$default = AlertFragment.Companion.createMultiAction$default(AlertFragment.Companion, getString(R.string.location_permission_title), null, false, getString(R.string.location_permission_message), null, null, CollectionsKt.listOf(getString(R.string.ok_RES_2114650415)), CollectionsKt.listOf(new MainActivity$onStart$fragment$1(this, "android.permission.ACCESS_COARSE_LOCATION")), Integer.valueOf((int) R.drawable.ic_location_permissions), null, false, 1590, null);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            List<Fragment> fragments = supportFragmentManager.getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
            for (T t : fragments) {
                Intrinsics.checkNotNullExpressionValue(t, "it");
                t.setUserVisibleHint(false);
            }
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
            String simpleName = Reflection.getOrCreateKotlinClass(AlertFragment.class).getSimpleName();
            beginTransaction.add(R.id.fragment_container_RES_2114322527, createMultiAction$default, simpleName).addToBackStack(simpleName).commit();
        }
        Application application = getApplication();
        Objects.requireNonNull(application, "null cannot be cast to non-null type com.digitalwallet.DigitalWalletApplication");
        if (((DigitalWalletApplication) application).getSpawnedAnotherActivity()) {
            this.pinEnteredForSession = true;
            Application application2 = getApplication();
            Objects.requireNonNull(application2, "null cannot be cast to non-null type com.digitalwallet.DigitalWalletApplication");
            ((DigitalWalletApplication) application2).setSpawnedAnotherActivity(false);
        }
        if (!this.pinEnteredForSession) {
            PinActivity.Companion.launch$default(PinActivity.Companion, this, false, 2, null);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        Bundle extras;
        super.onResume();
        this.atFront.accept(new Object());
        MainActivityViewModel viewModel2 = getViewModel();
        Intent intent = getIntent();
        viewModel2.refreshData((intent == null || (extras = intent.getExtras()) == null) ? null : extras.getString(HoldingExpiryPublisher.HOLDING_KEY));
        AHBottomNavigation aHBottomNavigation = ((ActivityMainBinding) getBinding()).bottomNavigation;
        Intrinsics.checkNotNullExpressionValue(aHBottomNavigation, "binding.bottomNavigation");
        maybeStartCardSharingSetup(aHBottomNavigation.getCurrentItem());
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStop() {
        super.onStop();
        this.pinEnteredForSession = false;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.customTabsPackageName != null) {
            unbindService(CustomTabProvider.INSTANCE.getTabsServiceConnection());
        }
        BluetoothEventsService bluetoothEventsService = this.bluetoothEvents;
        if (bluetoothEventsService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bluetoothEvents");
        }
        bluetoothEventsService.unregister(this);
    }

    @Override // androidx.activity.ComponentActivity, com.digitalwallet.view.base.BaseActivity
    public void onBackPressed() {
        ViewUtilsKt.supportBackHandlerPress(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            int i = 0;
            this.pinEnteredForSession = intent.getBooleanExtra(PinActivity.PIN_ENTERED_KEY, false);
            Bundle extras = intent.getExtras();
            String str = null;
            if (extras != null) {
                str = extras.getString(HoldingExpiryPublisher.HOLDING_KEY, null);
            }
            if (str != null) {
                AHBottomNavigation aHBottomNavigation = ((ActivityMainBinding) getBinding()).bottomNavigation;
                Intrinsics.checkNotNullExpressionValue(aHBottomNavigation, "binding.bottomNavigation");
                List<? extends Fragment> list = this.menuTabs;
                if (list == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("menuTabs");
                }
                Iterator<? extends Fragment> it = list.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    } else if (((Fragment) it.next()) instanceof HoldingListFragment) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    i = i2;
                }
                aHBottomNavigation.setCurrentItem(i);
            }
            setIntent(intent);
        }
    }

    public final void vibrateForShare() {
        ((Vibrator) getSystemService(Vibrator.class)).vibrate(VibrationEffect.createOneShot(1000, -1));
    }

    /* access modifiers changed from: private */
    public final void maybeStartCardSharingSetup(int i) {
        List<? extends Fragment> list = this.menuTabs;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuTabs");
        }
        boolean areEqual = Intrinsics.areEqual(((Fragment) list.get(i)).getClass(), HoldingListFragment.class);
        boolean z = false;
        if (areEqual && ServerTypeKt.getAppType() == AppType.CITIZEN) {
            AuthenticationUtility authenticationUtility2 = this.authenticationUtility;
            if (authenticationUtility2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authenticationUtility");
            }
            if (authenticationUtility2.cardSyncPreferencesSet()) {
                AuthenticationUtility authenticationUtility3 = this.authenticationUtility;
                if (authenticationUtility3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("authenticationUtility");
                }
                if (authenticationUtility3.getNickname().length() == 0) {
                    z = true;
                }
                if (!z) {
                    return;
                }
            }
            Intent intent = new Intent(this, SetupActivity.class);
            intent.setFlags(67108864);
            intent.putExtra(PinActivity.PIN_ENTERED_KEY, true);
            startActivity(intent);
        }
    }

    private final void setupBottomNavigationBar() {
        new AHBottomNavigationAdapter(this, this.menuResource).setupWithBottomNavigation(((ActivityMainBinding) getBinding()).bottomNavigation);
        AHBottomNavigation aHBottomNavigation = ((ActivityMainBinding) getBinding()).bottomNavigation;
        aHBottomNavigation.setOnTabSelectedListener(new MainActivity$setupBottomNavigationBar$$inlined$apply$lambda$1(aHBottomNavigation, this));
        aHBottomNavigation.setTitleTextSizeInSp(13.0f, 13.0f);
        aHBottomNavigation.setTitleTypeface(ResourcesCompat.getFont(getBaseContext(), R.font.vic_semi_bold));
        aHBottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
    }

    public final void startChromeCustomTabs(String str, boolean z) {
        Uri uri;
        Intrinsics.checkNotNullParameter(str, "uriString");
        getAnalytics().viewItem("Web view", str);
        Application application = getApplication();
        Objects.requireNonNull(application, "null cannot be cast to non-null type com.digitalwallet.DigitalWalletApplication");
        ((DigitalWalletApplication) application).setSpawnedAnotherActivity(true);
        if (z) {
            Uri.Builder buildUpon = Uri.parse("https://service.vic.gov.au/login").buildUpon();
            Intrinsics.checkNotNullExpressionValue(buildUpon, "Uri.parse(\"${BuildConfig…             .buildUpon()");
            uri = addSecureParams(buildUpon, str).build();
            Intrinsics.checkNotNullExpressionValue(uri, "Uri.parse(\"${BuildConfig…                 .build()");
        } else {
            Uri.Builder buildUpon2 = Uri.parse("https://service.vic.gov.au/").buildUpon();
            buildUpon2.appendPath(str);
            uri = buildUpon2.build();
            Intrinsics.checkNotNullExpressionValue(uri, "Uri.parse(BuildConfig.AP…Path(uriString) }.build()");
        }
        if (this.customTabsPackageName != null) {
            CustomTabsIntent customTabsIntent = CustomTabProvider.INSTANCE.getCustomTabsIntent();
            if (customTabsIntent != null) {
                customTabsIntent.launchUrl(this, uri);
                return;
            }
            return;
        }
        openURL(uri);
    }

    public final void startChrome(String str) {
        Intrinsics.checkNotNullParameter(str, "fullUrl");
        getAnalytics().viewItem("Web view", str);
        Application application = getApplication();
        Objects.requireNonNull(application, "null cannot be cast to non-null type com.digitalwallet.DigitalWalletApplication");
        ((DigitalWalletApplication) application).setSpawnedAnotherActivity(true);
        Uri build = Uri.parse(str).buildUpon().build();
        Intrinsics.checkNotNullExpressionValue(build, "Uri.parse(fullUrl).buildUpon().build()");
        if (this.customTabsPackageName != null) {
            CustomTabsIntent customTabsIntent = CustomTabProvider.INSTANCE.getCustomTabsIntent();
            if (customTabsIntent != null) {
                customTabsIntent.launchUrl(this, build);
                return;
            }
            return;
        }
        openURL(build);
    }

    private final void openURL(Uri uri) {
        ActivityHelperKt.viewURI(this, uri);
    }

    private final Uri.Builder addSecureParams(Uri.Builder builder, String str) {
        AuthenticationUtility authenticationUtility2 = this.authenticationUtility;
        if (authenticationUtility2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authenticationUtility");
        }
        builder.appendQueryParameter("ga_uid", authenticationUtility2.getLoginSession());
        builder.appendQueryParameter("channel", "mobileApplication");
        AuthenticationUtility authenticationUtility3 = this.authenticationUtility;
        if (authenticationUtility3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authenticationUtility");
        }
        Tokens tokens = authenticationUtility3.getTokens();
        if (tokens != null) {
            builder.appendQueryParameter(ResponseTypeValues.ID_TOKEN, tokens.getId());
        }
        if (str != null) {
            builder.appendQueryParameter("redirect_url", str);
        }
        return builder;
    }
}
