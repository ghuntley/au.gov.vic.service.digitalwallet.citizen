package com.digitalwallet.app.view.harvester;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.HarvesterActivityBinding;
import com.digitalwallet.app.model.HoldingRecordAttributes;
import com.digitalwallet.app.utilities.ActivityHelperKt;
import com.digitalwallet.app.view.base.BaseAppActivity;
import com.digitalwallet.app.view.harvester.HarvestTagView;
import com.digitalwallet.app.view.harvester.HarvestView;
import com.digitalwallet.app.view.util.AlertFragment;
import com.digitalwallet.app.viewmodel.harvester.HarvestJobWizardViewModel;
import com.digitalwallet.app.viewmodel.harvester.HarvestTagViewModel;
import com.digitalwallet.view.main.BackHandler;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.snackbar.Snackbar;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import net.openid.appauth.AuthorizationRequest;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0017\u0018\u0000 U2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001UB\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u0002002\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u00104\u001a\u000200H\u0016J\b\u00105\u001a\u000200H\u0016J\b\u00106\u001a\u000200H\u0002J\b\u00107\u001a\u000200H\u0016J\u0010\u00108\u001a\u0002002\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000200H\u0016J\u0012\u0010<\u001a\u0002002\b\u0010=\u001a\u0004\u0018\u00010>H\u0014J\b\u0010?\u001a\u000200H\u0014J-\u0010@\u001a\u0002002\u0006\u0010A\u001a\u00020\u00132\u000e\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020D0C2\u0006\u0010E\u001a\u00020FH\u0016¢\u0006\u0002\u0010GJ\u0010\u0010H\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\b\u0010I\u001a\u000200H\u0016J\b\u0010J\u001a\u000200H\u0016J\b\u0010K\u001a\u00020LH\u0017J\u0010\u0010M\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\b\u0010N\u001a\u000200H\u0016J\b\u0010O\u001a\u000200H\u0016J\b\u0010P\u001a\u000200H\u0016J\u0010\u0010Q\u001a\u0002002\u0006\u0010R\u001a\u00020\u0013H\u0016J\u0012\u0010S\u001a\u0002002\b\b\u0001\u0010T\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u0013XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020*8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006V"}, d2 = {"Lcom/digitalwallet/app/view/harvester/HarvestActivity;", "Lcom/digitalwallet/app/view/base/BaseAppActivity;", "Lcom/digitalwallet/app/databinding/HarvesterActivityBinding;", "Lcom/digitalwallet/app/view/harvester/HarvestView;", "Lcom/digitalwallet/app/view/harvester/HarvestTagView;", "()V", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "gpsLatitude", "", "getGpsLatitude", "()Ljava/lang/Double;", "setGpsLatitude", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "gpsLongitude", "getGpsLongitude", "setGpsLongitude", "layoutId", "", "getLayoutId", "()I", "locationCallback", "com/digitalwallet/app/view/harvester/HarvestActivity$locationCallback$1", "Lcom/digitalwallet/app/view/harvester/HarvestActivity$locationCallback$1;", "locationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "locationRequest", "Lcom/google/android/gms/location/LocationRequest;", "screen", "Lcom/digitalwallet/app/view/harvester/HarvestView$Screen;", "getScreen", "()Lcom/digitalwallet/app/view/harvester/HarvestView$Screen;", "setScreen", "(Lcom/digitalwallet/app/view/harvester/HarvestView$Screen;)V", "tagViewModel", "Lcom/digitalwallet/app/viewmodel/harvester/HarvestTagViewModel;", "getTagViewModel", "()Lcom/digitalwallet/app/viewmodel/harvester/HarvestTagViewModel;", "setTagViewModel", "(Lcom/digitalwallet/app/viewmodel/harvester/HarvestTagViewModel;)V", "viewModel", "Lcom/digitalwallet/app/viewmodel/harvester/HarvestJobWizardViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/harvester/HarvestJobWizardViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/harvester/HarvestJobWizardViewModel;)V", "closeJob", "", "jobId", "", "go", "goBack", "goBackDirect", "listenForLocation", "manualTagEntry", "onAttachFragment", AuthorizationRequest.ResponseMode.FRAGMENT, "Landroidx/fragment/app/Fragment;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "scanTags", "showAddJobSuccess", "showCloseScanner", "showProgressIndicator", "Landroid/app/ProgressDialog;", "showScanner", "showSummary", "showSummaryBackgroundRetry", "showSummarySuccess", "showTagSuccess", "numTags", "toast", "message", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestActivity.kt */
public final class HarvestActivity extends BaseAppActivity<HarvesterActivityBinding> implements HarvestView, HarvestTagView {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_ATTRIBUTES = "Attributes";
    private static final int LOCATION_REQUEST_CODE = 101;
    private HashMap _$_findViewCache;
    private CameraManager cameraManager;
    private Double gpsLatitude;
    private Double gpsLongitude;
    private final int layoutId = R.layout.harvester_activity;
    private final HarvestActivity$locationCallback$1 locationCallback = new HarvestActivity$locationCallback$1(this);
    private FusedLocationProviderClient locationClient;
    private final LocationRequest locationRequest;
    private HarvestView.Screen screen;
    @Inject
    public HarvestTagViewModel tagViewModel;
    @Inject
    public HarvestJobWizardViewModel viewModel;

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

    public HarvestActivity() {
        LocationRequest locationRequest2 = new LocationRequest();
        locationRequest2.setPriority(102);
        locationRequest2.setInterval(10000);
        locationRequest2.setFastestInterval(5000);
        locationRequest2.setSmallestDisplacement(100.0f);
        Unit unit = Unit.INSTANCE;
        this.locationRequest = locationRequest2;
        this.screen = HarvestView.Screen.List;
    }

    @Override // com.digitalwallet.view.base.BaseActivity
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.digitalwallet.view.base.BaseActivity
    public HarvestJobWizardViewModel getViewModel() {
        HarvestJobWizardViewModel harvestJobWizardViewModel = this.viewModel;
        if (harvestJobWizardViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return harvestJobWizardViewModel;
    }

    public void setViewModel(HarvestJobWizardViewModel harvestJobWizardViewModel) {
        Intrinsics.checkNotNullParameter(harvestJobWizardViewModel, "<set-?>");
        this.viewModel = harvestJobWizardViewModel;
    }

    public final HarvestTagViewModel getTagViewModel() {
        HarvestTagViewModel harvestTagViewModel = this.tagViewModel;
        if (harvestTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagViewModel");
        }
        return harvestTagViewModel;
    }

    public final void setTagViewModel(HarvestTagViewModel harvestTagViewModel) {
        Intrinsics.checkNotNullParameter(harvestTagViewModel, "<set-?>");
        this.tagViewModel = harvestTagViewModel;
    }

    public final HarvestView.Screen getScreen() {
        return this.screen;
    }

    public final void setScreen(HarvestView.Screen screen2) {
        Intrinsics.checkNotNullParameter(screen2, "<set-?>");
        this.screen = screen2;
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestTagView
    public Double getGpsLatitude() {
        return this.gpsLatitude;
    }

    public void setGpsLatitude(Double d) {
        this.gpsLatitude = d;
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestTagView
    public Double getGpsLongitude() {
        return this.gpsLongitude;
    }

    public void setGpsLongitude(Double d) {
        this.gpsLongitude = d;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/digitalwallet/app/view/harvester/HarvestActivity$Companion;", "", "()V", "KEY_ATTRIBUTES", "", "LOCATION_REQUEST_CODE", "", "create", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "attributes", "Lcom/digitalwallet/app/model/HoldingRecordAttributes;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: HarvestActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent create(Context context, HoldingRecordAttributes holdingRecordAttributes) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(holdingRecordAttributes, "attributes");
            Intent intent = new Intent(context, HarvestActivity.class);
            intent.putExtra(HarvestActivity.KEY_ATTRIBUTES, holdingRecordAttributes);
            intent.setFlags(268435456);
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.digitalwallet.app.view.base.BaseAppActivity, com.digitalwallet.view.base.BaseActivity
    public void onCreate(Bundle bundle) {
        createComponent().inject(this);
        super.onCreate(bundle);
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient((Activity) this);
        Intrinsics.checkNotNullExpressionValue(fusedLocationProviderClient, "LocationServices.getFuse…ationProviderClient(this)");
        this.locationClient = fusedLocationProviderClient;
        listenForLocation();
        Object systemService = getSystemService("camera");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        this.cameraManager = (CameraManager) systemService;
        Parcelable parcelableExtra = getIntent().getParcelableExtra(KEY_ATTRIBUTES);
        Intrinsics.checkNotNull(parcelableExtra);
        getViewModel().setup((HoldingRecordAttributes) parcelableExtra, this);
        HarvestJobListFragment harvestJobListFragment = new HarvestJobListFragment();
        harvestJobListFragment.setViewModel(getViewModel());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "it");
        HarvestJobListFragment harvestJobListFragment2 = harvestJobListFragment;
        String fragmentName = HarvestActivityKt.getFragmentName(HarvestView.Screen.List);
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        if (fragmentName == null) {
            fragmentName = Reflection.getOrCreateKotlinClass(HarvestJobListFragment.class).getSimpleName();
        }
        beginTransaction.replace(R.id.fragment_container_RES_2114322527, harvestJobListFragment2, fragmentName).commit();
        supportFragmentManager.addOnBackStackChangedListener(new HarvestActivity$onCreate$$inlined$also$lambda$1(this, harvestJobListFragment));
    }

    @Override // androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback, androidx.fragment.app.FragmentActivity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 101) {
            if (iArr.length == 0) {
                Timber.d("User interaction cancelled", new Object[0]);
                return;
            }
            Integer firstOrNull = ArraysKt.firstOrNull(iArr);
            if (firstOrNull != null && firstOrNull.intValue() == 0) {
                listenForLocation();
            } else {
                Intrinsics.checkNotNullExpressionValue(Snackbar.make(((HarvesterActivityBinding) getBinding()).getRoot(), (int) R.string.error_permission_denied, 0), "Snackbar.make(binding.ro…ed, Snackbar.LENGTH_LONG)");
            }
        }
    }

    private final void listenForLocation() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            FusedLocationProviderClient fusedLocationProviderClient = this.locationClient;
            if (fusedLocationProviderClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationClient");
            }
            fusedLocationProviderClient.requestLocationUpdates(this.locationRequest, this.locationCallback, null);
            return;
        }
        AlertFragment createMultiAction$default = AlertFragment.Companion.createMultiAction$default(AlertFragment.Companion, getString(R.string.location_permission_title), null, false, getString(R.string.location_permission_message), null, null, CollectionsKt.listOf(getString(R.string.action_continue_RES_2114650112)), CollectionsKt.listOf(new HarvestActivity$listenForLocation$fragment$1(this)), Integer.valueOf((int) R.drawable.ic_location_permissions), null, false, 1590, null);
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

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        FusedLocationProviderClient fusedLocationProviderClient = this.locationClient;
        if (fusedLocationProviderClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationClient");
        }
        fusedLocationProviderClient.removeLocationUpdates(this.locationCallback);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, AuthorizationRequest.ResponseMode.FRAGMENT);
        if (!(fragment instanceof HarvestJobFragment)) {
            fragment = null;
        }
        HarvestJobFragment harvestJobFragment = (HarvestJobFragment) fragment;
        if (harvestJobFragment != null) {
            harvestJobFragment.setViewModel(getViewModel());
        }
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestView
    public void go(HarvestView.Screen screen2) {
        Intrinsics.checkNotNullParameter(screen2, "screen");
        this.screen = screen2;
        HarvestActivityKt.go(screen2, this);
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestView
    public void showAddJobSuccess() {
        AlertFragment create$default = AlertFragment.Companion.create$default(AlertFragment.Companion, getString(R.string.success_RES_2114650501), HarvestActivityKt.getFragmentName(HarvestView.Screen.Consent), true, getString(R.string.harvest_job_added_alert_message), null, null, getString(R.string.ok_RES_2114650415), null, null, null, false, 1968, null);
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
        beginTransaction.add(R.id.fragment_container_RES_2114322527, create$default, simpleName).addToBackStack(simpleName).commit();
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestView
    public void closeJob(long j) {
        AlertFragment create$default = AlertFragment.Companion.create$default(AlertFragment.Companion, getString(R.string.harvest_job_delete_this_job_title), null, false, getString(R.string.harvest_job_delete_this_job_message), getString(R.string.cancel_RES_2114650146), null, getString(R.string.harvest_close_job), new HarvestActivity$closeJob$deleteSuccess$1(this, j), null, null, false, 1574, null);
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
        beginTransaction.add(R.id.fragment_container_RES_2114322527, create$default, simpleName).addToBackStack(simpleName).commit();
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestView
    public void scanTags(long j) {
        AlertFragment create$default = AlertFragment.Companion.create$default(AlertFragment.Companion, getString(R.string.harvest_scanner_instruction_title), null, false, getString(R.string.harvest_scanner_instruction_message), getString(R.string.cancel_RES_2114650146), null, getString(R.string.harvest_scan_tags), new HarvestActivity$scanTags$fragment$1(this, j), null, null, false, 1574, null);
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
        beginTransaction.add(R.id.fragment_container_RES_2114322527, create$default, simpleName).addToBackStack(simpleName).commit();
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestTagView
    public void manualTagEntry() {
        HarvestActivityKt.go(HarvestTagView.Screen.ManualEntry, this);
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestTagView
    public void showSummary() {
        HarvestTagViewModel harvestTagViewModel = this.tagViewModel;
        if (harvestTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagViewModel");
        }
        harvestTagViewModel.getSummaryStarted().set(true);
        HarvestActivityKt.go(HarvestTagView.Screen.HarvestSummary, this);
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestTagView
    public void showScanner(long j) {
        HarvestTagViewModel harvestTagViewModel = this.tagViewModel;
        if (harvestTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagViewModel");
        }
        harvestTagViewModel.setup(this, j);
        HarvestActivityKt.go(HarvestTagView.Screen.Scanner, this);
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestTagView
    public void showCloseScanner() {
        AlertFragment createMultiAction$default = AlertFragment.Companion.createMultiAction$default(AlertFragment.Companion, getString(R.string.harvest_tag_exit_scanner_title), null, false, getString(R.string.harvest_tag_exit_scanner_message), getString(R.string.cancel_RES_2114650146), null, CollectionsKt.listOf((Object[]) new String[]{getString(R.string.harvest_tag_exit_scanner_action_summary), getString(R.string.harvest_tag_exit_scanner_action_exit)}), CollectionsKt.listOf((Object[]) new Function0[]{new HarvestActivity$showCloseScanner$fragment$1(this), new HarvestActivity$showCloseScanner$fragment$2(this)}), null, null, false, 1570, null);
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

    @Override // com.digitalwallet.app.view.harvester.HarvestTagView
    public void showTagSuccess(int i) {
        ActivityHelperKt.hideKeyboard(this);
        HarvestActivity$showTagSuccess$showNextOptions$1 harvestActivity$showTagSuccess$showNextOptions$1 = new HarvestActivity$showTagSuccess$showNextOptions$1(this, i);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        Fragment fragment = new Fragment();
        List<Fragment> fragments = supportFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
        for (T t : fragments) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            t.setUserVisibleHint(false);
        }
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
        String simpleName = Reflection.getOrCreateKotlinClass(Fragment.class).getSimpleName();
        beginTransaction.add(R.id.fragment_container_RES_2114322527, fragment, simpleName).addToBackStack(simpleName).commit();
        AlertFragment create$default = AlertFragment.Companion.create$default(AlertFragment.Companion, getString(R.string.success_RES_2114650501), null, false, getString(R.string.harvest_tag_added_message), null, null, getString(R.string.next_RES_2114650403), new HarvestActivity$showTagSuccess$fragment$1(harvestActivity$showTagSuccess$showNextOptions$1), null, null, false, 1842, null);
        FragmentManager supportFragmentManager2 = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "supportFragmentManager");
        List<Fragment> fragments2 = supportFragmentManager2.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments2, "fragments");
        for (T t2 : fragments2) {
            Intrinsics.checkNotNullExpressionValue(t2, "it");
            t2.setUserVisibleHint(false);
        }
        FragmentTransaction beginTransaction2 = supportFragmentManager2.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction2, "this.beginTransaction()");
        beginTransaction2.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
        String simpleName2 = Reflection.getOrCreateKotlinClass(AlertFragment.class).getSimpleName();
        beginTransaction2.add(R.id.fragment_container_RES_2114322527, create$default, simpleName2).addToBackStack(simpleName2).commit();
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestTagView
    public void showSummarySuccess() {
        ActivityHelperKt.hideKeyboard(this);
        AlertFragment create$default = AlertFragment.Companion.create$default(AlertFragment.Companion, getString(R.string.success_RES_2114650501), HarvestActivityKt.getFragmentName(HarvestTagView.Screen.Scanner), true, getString(R.string.harvest_tag_summary_submitted_message), null, null, getString(R.string.ok_RES_2114650415), null, null, null, false, 1968, null);
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
        beginTransaction.add(R.id.fragment_container_RES_2114322527, create$default, simpleName).addToBackStack(simpleName).commit();
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestTagView
    public void showSummaryBackgroundRetry() {
        ActivityHelperKt.hideKeyboard(this);
        AlertFragment create$default = AlertFragment.Companion.create$default(AlertFragment.Companion, getString(R.string.saved_RES_2114650460), HarvestActivityKt.getFragmentName(HarvestTagView.Screen.Scanner), true, getString(R.string.harvest_tag_summary_submit_background_message), null, null, getString(R.string.ok_RES_2114650415), null, Integer.valueOf((int) R.drawable.ic_icon_info_slate), null, false, 1712, null);
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
        beginTransaction.add(R.id.fragment_container_RES_2114322527, create$default, simpleName).addToBackStack(simpleName).commit();
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestTagView
    public ProgressDialog showProgressIndicator() {
        ProgressDialog show = ProgressDialog.show(this, getString(R.string.submitting_RES_2114650500), null, true, false);
        Intrinsics.checkNotNullExpressionValue(show, "ProgressDialog.show(this…ting), null, true, false)");
        return show;
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestTagView, com.digitalwallet.app.view.harvester.HarvestView
    public void goBack() {
        onBackPressed();
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestTagView
    public void goBackDirect() {
        super.onBackPressed();
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

    @Override // com.digitalwallet.app.view.harvester.HarvestTagView
    public void toast(int i) {
        new Handler(Looper.getMainLooper()).post(new HarvestActivity$toast$$inlined$main$1(this, i));
    }
}
