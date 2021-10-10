package com.digitalwallet.view.checkIn;

import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.style.ReplacementSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.databinding.FragmentCheckInScannerBinding;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.utilities.EventObserver;
import com.digitalwallet.view.base.BaseFragment;
import com.digitalwallet.view.main.BackHandler;
import com.digitalwallet.view.main.ScannerFragment;
import com.digitalwallet.view.util.ViewUtilsKt;
import com.digitalwallet.viewmodel.checkIn.CheckInScannerViewModel;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.bouncycastle.i18n.TextBundle;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001=B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020'H\u0002J&\u0010.\u001a\u0004\u0018\u00010\f2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u00062\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020'H\u0016J\u001a\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0010\u00107\u001a\u00020'2\u0006\u00108\u001a\u00020)H\u0016J\u0014\u00109\u001a\u00020:*\u00020:2\u0006\u0010;\u001a\u00020<H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0018XD¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\nR\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020\u001f8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010!\"\u0004\b$\u0010%¨\u0006>"}, d2 = {"Lcom/digitalwallet/view/checkIn/CheckInScannerFragment;", "Lcom/digitalwallet/view/main/ScannerFragment;", "Lcom/digitalwallet/databinding/FragmentCheckInScannerBinding;", "Lcom/digitalwallet/view/main/BackHandler;", "()V", "cameraFrame", "Landroid/view/ViewGroup;", "getCameraFrame", "()Landroid/view/ViewGroup;", "setCameraFrame", "(Landroid/view/ViewGroup;)V", "cameraGuide", "Landroid/view/View;", "getCameraGuide", "()Landroid/view/View;", "setCameraGuide", "(Landroid/view/View;)V", "checkInRepository", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "getCheckInRepository", "()Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "setCheckInRepository", "(Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;)V", "layoutId", "", "getLayoutId", "()I", "outerFrame", "getOuterFrame", "setOuterFrame", "scannerViewModel", "Lcom/digitalwallet/viewmodel/checkIn/CheckInScannerViewModel;", "getScannerViewModel", "()Lcom/digitalwallet/viewmodel/checkIn/CheckInScannerViewModel;", "viewModel", "getViewModel", "setViewModel", "(Lcom/digitalwallet/viewmodel/checkIn/CheckInScannerViewModel;)V", "checkPopBackNavigation", "", "handleBack", "", "navigateToCheckIn", "checkInCode", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "observeEvents", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", Promotion.ACTION_VIEW, "setUserVisibleHint", "isVisibleToUser", "setEditText", "Landroid/app/AlertDialog$Builder;", "editText", "Landroid/widget/EditText;", "DrawableSpan", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInScannerFragment.kt */
public final class CheckInScannerFragment extends ScannerFragment<FragmentCheckInScannerBinding> implements BackHandler {
    private HashMap _$_findViewCache;
    public ViewGroup cameraFrame;
    public View cameraGuide;
    @Inject
    public CheckInRepository checkInRepository;
    private final int layoutId = R.layout.fragment_check_in_scanner;
    public ViewGroup outerFrame;
    @Inject
    public CheckInScannerViewModel viewModel;

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, com.digitalwallet.view.main.ScannerFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, com.digitalwallet.view.main.ScannerFragment
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

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment, com.digitalwallet.view.main.ScannerFragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public CheckInScannerViewModel getViewModel() {
        CheckInScannerViewModel checkInScannerViewModel = this.viewModel;
        if (checkInScannerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return checkInScannerViewModel;
    }

    public void setViewModel(CheckInScannerViewModel checkInScannerViewModel) {
        Intrinsics.checkNotNullParameter(checkInScannerViewModel, "<set-?>");
        this.viewModel = checkInScannerViewModel;
    }

    @Override // com.digitalwallet.view.main.ScannerFragment
    public CheckInScannerViewModel getScannerViewModel() {
        return getViewModel();
    }

    @Override // com.digitalwallet.view.main.ScannerFragment
    public ViewGroup getOuterFrame() {
        ViewGroup viewGroup = this.outerFrame;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outerFrame");
        }
        return viewGroup;
    }

    public void setOuterFrame(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.outerFrame = viewGroup;
    }

    @Override // com.digitalwallet.view.main.ScannerFragment
    public View getCameraGuide() {
        View view = this.cameraGuide;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraGuide");
        }
        return view;
    }

    public void setCameraGuide(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.cameraGuide = view;
    }

    @Override // com.digitalwallet.view.main.ScannerFragment
    public ViewGroup getCameraFrame() {
        ViewGroup viewGroup = this.cameraFrame;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraFrame");
        }
        return viewGroup;
    }

    public void setCameraFrame(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.cameraFrame = viewGroup;
    }

    public final CheckInRepository getCheckInRepository() {
        CheckInRepository checkInRepository2 = this.checkInRepository;
        if (checkInRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkInRepository");
        }
        return checkInRepository2;
    }

    public final void setCheckInRepository(CheckInRepository checkInRepository2) {
        Intrinsics.checkNotNullParameter(checkInRepository2, "<set-?>");
        this.checkInRepository = checkInRepository2;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        ConstraintLayout constraintLayout = ((FragmentCheckInScannerBinding) getBinding()).outerFrame;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.outerFrame");
        setOuterFrame(constraintLayout);
        FrameLayout frameLayout = ((FragmentCheckInScannerBinding) getBinding()).cameraFrame;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.cameraFrame");
        setCameraFrame(frameLayout);
        FrameLayout frameLayout2 = ((FragmentCheckInScannerBinding) getBinding()).cameraGuide;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.cameraGuide");
        setCameraGuide(frameLayout2);
        return onCreateView;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment, com.digitalwallet.view.main.ScannerFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), ActivityAnalyticsHelper.Screen.CheckInScanner, null, null, 6, null);
        ((FragmentCheckInScannerBinding) getBinding()).setLifecycleOwner(this);
        observeEvents();
        CheckInUtils.Companion companion = CheckInUtils.Companion;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        companion.checkGoogleApiAvailability(requireActivity);
    }

    private final void observeEvents() {
        getViewModel().getBackToPreviousScreen().observe(getViewLifecycleOwner(), new EventObserver(new CheckInScannerFragment$observeEvents$1(this)));
        getViewModel().getNavigateToHelpUrl().observe(getViewLifecycleOwner(), new EventObserver(new CheckInScannerFragment$observeEvents$2(this)));
        getViewModel().getShowQRCodeInvalidMessage().observe(getViewLifecycleOwner(), new EventObserver(new CheckInScannerFragment$observeEvents$3(this)));
        getViewModel().getShowManualCodeEmptyMessage().observe(getViewLifecycleOwner(), new EventObserver(new CheckInScannerFragment$observeEvents$4(this)));
        getViewModel().getShowManualCodeInvalidMessage().observe(getViewLifecycleOwner(), new EventObserver(new CheckInScannerFragment$observeEvents$5(this)));
        getViewModel().getShowManualCodeErrorMessage().observe(getViewLifecycleOwner(), new EventObserver(new CheckInScannerFragment$observeEvents$6(this)));
        getViewModel().getShowManualEntry().observe(getViewLifecycleOwner(), new EventObserver(new CheckInScannerFragment$observeEvents$7(this)));
        getViewModel().getNavigateToCheckIn().observe(getViewLifecycleOwner(), new EventObserver(new CheckInScannerFragment$observeEvents$8(this)));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getViewModel().resumeScan();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            getViewModel().resumeScan();
        } else {
            getViewModel().pauseScan();
        }
    }

    @Override // com.digitalwallet.view.main.BackHandler
    public boolean handleBack() {
        return ((Boolean) new CheckInScannerFragment$handleBack$1(this).invoke()).booleanValue();
    }

    /* access modifiers changed from: private */
    public final void checkPopBackNavigation() {
        PackageManager packageManager;
        if (Build.VERSION.SDK_INT >= 26) {
            Context context = getContext();
            if (context == null || (packageManager = context.getPackageManager()) == null || !packageManager.isInstantApp()) {
                getParentFragmentManager().popBackStack();
                return;
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finishAndRemoveTask();
                return;
            }
            return;
        }
        getParentFragmentManager().popBackStack();
    }

    /* access modifiers changed from: private */
    public final void navigateToCheckIn(CheckInUtils.CheckInCode checkInCode) {
        CheckInRepository checkInRepository2 = this.checkInRepository;
        if (checkInRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkInRepository");
        }
        BaseFragment<? extends ViewDataBinding> checkInInputEntryFragment = CheckInUtilsKt.getCheckInInputEntryFragment(checkInRepository2, checkInCode, true);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        int containerId = ViewUtilsKt.getContainerId(this);
        FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        beginTransaction.replace(containerId, checkInInputEntryFragment, Reflection.getOrCreateKotlinClass(BaseFragment.class).getSimpleName()).addToBackStack(null).commit();
    }

    /* access modifiers changed from: private */
    public final AlertDialog.Builder setEditText(AlertDialog.Builder builder, EditText editText) {
        FrameLayout frameLayout = new FrameLayout(builder.getContext());
        frameLayout.addView(editText);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
        int i = (int) (system.getDisplayMetrics().density * 20.0f);
        layoutParams.setMargins(i, i, i, i);
        frameLayout.setLayoutParams(layoutParams);
        FrameLayout frameLayout2 = new FrameLayout(builder.getContext());
        frameLayout2.addView(frameLayout);
        builder.setView(frameLayout2);
        return builder;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JP\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J2\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J(\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/digitalwallet/view/checkIn/CheckInScannerFragment$DrawableSpan;", "Landroid/text/style/ReplacementSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "padding", "Landroid/graphics/Rect;", "draw", "", "canvas", "Landroid/graphics/Canvas;", TextBundle.TEXT_ENTRY, "", "start", "", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "measureText", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CheckInScannerFragment.kt */
    private static final class DrawableSpan extends ReplacementSpan {
        private final Drawable drawable;
        private final Rect padding;

        public DrawableSpan(Drawable drawable2) {
            Intrinsics.checkNotNullParameter(drawable2, "drawable");
            this.drawable = drawable2;
            Rect rect = new Rect();
            this.padding = rect;
            drawable2.getPadding(rect);
        }

        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(charSequence, TextBundle.TEXT_ENTRY);
            Intrinsics.checkNotNullParameter(paint, "paint");
            RectF rectF = new RectF(f, (float) i3, measureText(paint, charSequence, i, i2) + f, (float) i5);
            this.drawable.setBounds(((int) rectF.left) - this.padding.left, ((int) rectF.top) - this.padding.top, ((int) rectF.right) + this.padding.right, ((int) rectF.bottom) + this.padding.bottom);
            canvas.drawText(charSequence, i, i2, f, (float) i4, paint);
            this.drawable.draw(canvas);
        }

        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            Intrinsics.checkNotNullParameter(paint, "paint");
            Intrinsics.checkNotNullParameter(charSequence, TextBundle.TEXT_ENTRY);
            return Math.round(paint.measureText(charSequence, i, i2));
        }

        private final float measureText(Paint paint, CharSequence charSequence, int i, int i2) {
            return paint.measureText(charSequence, i, i2);
        }
    }
}
