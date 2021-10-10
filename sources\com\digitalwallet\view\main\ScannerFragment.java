package com.digitalwallet.view.main;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.utilities.StandardHelperKt;
import com.digitalwallet.view.base.BaseFragment;
import com.digitalwallet.viewmodel.main.ScannerFragmentViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 /*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001/B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J-\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\"H\u0016¢\u0006\u0002\u0010#J\u001a\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u001aH\u0004J\u0018\u0010)\u001a\n +*\u0004\u0018\u00010*0*2\u0006\u0010,\u001a\u00020-H\u0002J\u0018\u0010.\u001a\n +*\u0004\u0018\u00010*0*2\u0006\u0010,\u001a\u00020-H\u0002R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\bR\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u00060"}, d2 = {"Lcom/digitalwallet/view/main/ScannerFragment;", "T", "Landroidx/databinding/ViewDataBinding;", "Lcom/digitalwallet/view/base/BaseFragment;", "()V", "cameraFrame", "Landroid/view/ViewGroup;", "getCameraFrame", "()Landroid/view/ViewGroup;", "cameraGuide", "Landroid/view/View;", "getCameraGuide", "()Landroid/view/View;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "outerFrame", "getOuterFrame", "scannerViewModel", "Lcom/digitalwallet/viewmodel/main/ScannerFragmentViewModel;", "getScannerViewModel", "()Lcom/digitalwallet/viewmodel/main/ScannerFragmentViewModel;", "initializeCamera", "", "onDestroyView", "", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", Promotion.ACTION_VIEW, "savedInstanceState", "Landroid/os/Bundle;", "popFragment", "showRationaleDialog", "Landroid/app/AlertDialog;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "showUnsupportedDialog", "Companion", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ScannerFragment.kt */
public abstract class ScannerFragment<T extends ViewDataBinding> extends BaseFragment<T> {
    public static final Companion Companion = new Companion(null);
    private static final int PERMISSIONS_REQUEST_CODE = 123;
    private HashMap _$_findViewCache;
    private final CompositeDisposable disposables = new CompositeDisposable();

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment
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

    public abstract ViewGroup getCameraFrame();

    public abstract View getCameraGuide();

    public abstract ViewGroup getOuterFrame();

    public abstract ScannerFragmentViewModel getScannerViewModel();

    /* access modifiers changed from: protected */
    public final CompositeDisposable getDisposables() {
        return this.disposables;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, androidx.fragment.app.Fragment, com.digitalwallet.view.base.BasicFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        StandardHelperKt.postAfter(500, new ScannerFragment$onViewCreated$1(this));
    }

    @Override // com.digitalwallet.view.base.BaseFragment, androidx.fragment.app.Fragment, com.digitalwallet.view.base.BasicFragment
    public void onDestroyView() {
        super.onDestroyView();
        this.disposables.clear();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 123) {
            ScannerFragmentViewModel scannerViewModel = getScannerViewModel();
            Context context = getContext();
            Objects.requireNonNull(context, "null cannot be cast to non-null type android.content.Context");
            if (scannerViewModel.cameraPermissionGranted(context)) {
                initializeCamera();
                return;
            }
        }
        Context context2 = getContext();
        Objects.requireNonNull(context2, "null cannot be cast to non-null type android.content.Context");
        showRationaleDialog(context2);
    }

    /* access modifiers changed from: private */
    public final Object initializeCamera() {
        Object obj;
        Context context = getContext();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "(it)");
            if (!context.getPackageManager().hasSystemFeature("android.hardware.camera")) {
                obj = showUnsupportedDialog(context);
            } else if (!getScannerViewModel().cameraPermissionGranted(context)) {
                requestPermissions(new String[]{"android.permission.CAMERA"}, 123);
                obj = Unit.INSTANCE;
            } else {
                SurfaceView surfaceView = new SurfaceView(context);
                getCameraFrame().addView(surfaceView);
                getScannerViewModel().initializeScanner(surfaceView);
                getCameraGuide().getViewTreeObserver().addOnGlobalLayoutListener(new ScannerFragment$initializeCamera$$inlined$let$lambda$1(this));
                obj = Unit.INSTANCE;
            }
            if (obj != null) {
                return obj;
            }
        }
        AnalyticsHelper.selectContent$default(getAnalytics(), "Initialize camera failure", null, 2, null);
        return Unit.INSTANCE;
    }

    private final AlertDialog showUnsupportedDialog(Context context) {
        return new AlertDialog.Builder(context).setTitle(R.string.feature_unsupported).setMessage(R.string.feature_unsupported_camera).setPositiveButton(R.string.onboarding_back_RES_2131689720, new ScannerFragment$showUnsupportedDialog$1(this)).show();
    }

    private final AlertDialog showRationaleDialog(Context context) {
        return new AlertDialog.Builder(context).setMessage(R.string.scanner_camera_rationale).setPositiveButton(R.string.scanner_settings, new ScannerFragment$showRationaleDialog$1(this, context)).setNegativeButton(R.string.scanner_cancel, new ScannerFragment$showRationaleDialog$2(this)).show();
    }

    /* access modifiers changed from: protected */
    public final void popFragment() {
        getParentFragmentManager().popBackStack(Reflection.getOrCreateKotlinClass(getClass()).getSimpleName(), 1);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/digitalwallet/view/main/ScannerFragment$Companion;", "", "()V", "PERMISSIONS_REQUEST_CODE", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ScannerFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
