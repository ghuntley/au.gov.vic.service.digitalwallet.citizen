package com.digitalwallet.app.view.main;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.databinding.FragmentHoldingDetailBinding;
import com.digitalwallet.app.databinding.NotificationBannerBinding;
import com.digitalwallet.app.model.Asset;
import com.digitalwallet.app.model.AssetList;
import com.digitalwallet.app.model.DynamicHoldingRenewal;
import com.digitalwallet.app.model.HoldingAssets;
import com.digitalwallet.app.model.HoldingRecordAttributes;
import com.digitalwallet.app.model.HoldingState;
import com.digitalwallet.app.model.HoldingType;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.model.db.shares.ShareRecord;
import com.digitalwallet.app.services.AssetService;
import com.digitalwallet.app.utilities.DeviceModelHelperKt;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.view.hologram.HologramView;
import com.digitalwallet.app.view.util.ViewUtilsKt;
import com.digitalwallet.app.viewmodel.NotificationBannerViewModel;
import com.digitalwallet.app.viewmodel.NotificationType;
import com.digitalwallet.app.viewmodel.main.HoldingDetailFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.HoldingDetailView;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.ServerTypeKt;
import com.digitalwallet.view.main.BackHandler;
import com.google.android.gms.analytics.ecommerce.Promotion;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 x2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005:\u0001xB\u0005¢\u0006\u0002\u0010\u0006J\b\u0010A\u001a\u00020BH\u0003J\b\u0010C\u001a\u00020BH\u0002J\u0010\u0010D\u001a\u00020B2\u0006\u0010E\u001a\u00020\u0014H\u0002J\b\u0010F\u001a\u00020BH\u0002J\u001a\u0010G\u001a\u00020B2\u0006\u0010H\u001a\u00020,2\b\u0010I\u001a\u0004\u0018\u00010JH\u0002J\b\u0010K\u001a\u00020BH\u0002J\u001a\u0010L\u001a\u00020B2\u0006\u0010M\u001a\u00020N2\b\b\u0002\u0010O\u001a\u00020\u0014H\u0002J\b\u0010P\u001a\u00020BH\u0016J\b\u0010Q\u001a\u00020BH\u0016J\b\u0010R\u001a\u00020BH\u0002J\u0018\u0010S\u001a\u00020B2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010U\u001a\u00020\u0014H\u0002J\u0010\u0010V\u001a\u00020B2\u0006\u0010U\u001a\u00020\u0014H\u0016J\n\u0010W\u001a\u0004\u0018\u00010NH\u0002J\b\u0010X\u001a\u00020\u0014H\u0016J\u0018\u0010Y\u001a\u00020B2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020,H\u0016J\u0010\u0010]\u001a\u00020B2\u0006\u0010^\u001a\u00020_H\u0016J\u0012\u0010`\u001a\u00020B2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\b\u0010c\u001a\u00020BH\u0016J\b\u0010d\u001a\u00020BH\u0016J\b\u0010e\u001a\u00020BH\u0016J\b\u0010f\u001a\u00020BH\u0016J\u0010\u0010g\u001a\u00020B2\u0006\u0010h\u001a\u00020iH\u0016J\u001a\u0010j\u001a\u00020B2\u0006\u0010k\u001a\u00020l2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\b\u0010m\u001a\u00020BH\u0002J\u0010\u0010n\u001a\u00020B2\u0006\u0010k\u001a\u00020%H\u0002J\b\u0010o\u001a\u00020BH\u0002J\b\u0010p\u001a\u00020BH\u0002J\b\u0010q\u001a\u00020BH\u0002J\b\u0010r\u001a\u00020BH\u0002J\b\u0010s\u001a\u00020BH\u0002J\u0010\u0010t\u001a\u00020B2\u0006\u0010u\u001a\u00020\u0014H\u0002J\b\u0010v\u001a\u00020BH\u0016J\u0010\u0010w\u001a\u00020B2\u0006\u00103\u001a\u000204H\u0002R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0012R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010'\"\u0004\b)\u0010\u0017R\u000e\u0010*\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020,XD¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X.¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u000204X.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0014\u00109\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b:\u0010'R\u001e\u0010;\u001a\u00020<8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006y"}, d2 = {"Lcom/digitalwallet/app/view/main/HoldingDetailFragment;", "Landroid/hardware/SensorEventListener;", "Lcom/digitalwallet/app/view/base/BaseAppFragment;", "Lcom/digitalwallet/app/databinding/FragmentHoldingDetailBinding;", "Lcom/digitalwallet/app/viewmodel/main/HoldingDetailView;", "Lcom/digitalwallet/view/main/BackHandler;", "()V", "assetService", "Lcom/digitalwallet/app/services/AssetService;", "getAssetService", "()Lcom/digitalwallet/app/services/AssetService;", "setAssetService", "(Lcom/digitalwallet/app/services/AssetService;)V", "bannerBinding", "Lcom/digitalwallet/app/databinding/NotificationBannerBinding;", "cameraDistance", "", "getCameraDistance", "()F", "value", "", "canFlip", "setCanFlip", "(Z)V", "cardView", "Landroidx/cardview/widget/CardView;", "cardWidth", "getCardWidth", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "holdingAssets", "Lcom/digitalwallet/app/model/HoldingAssets;", "getHoldingAssets", "()Lcom/digitalwallet/app/model/HoldingAssets;", "setHoldingAssets", "(Lcom/digitalwallet/app/model/HoldingAssets;)V", "hologram", "Lcom/digitalwallet/app/view/hologram/HologramView;", "isLandscape", "()Z", "isUserFocus", "setUserFocus", "lastAngle", "layoutId", "", "getLayoutId", "()I", "orientationObserver", "Landroid/database/ContentObserver;", "rotateMessageFade", "Landroid/animation/AnimatorSet;", "secureHolding", "Lcom/digitalwallet/app/model/SecureHolding;", "getSecureHolding", "()Lcom/digitalwallet/app/model/SecureHolding;", "setSecureHolding", "(Lcom/digitalwallet/app/model/SecureHolding;)V", "systemAutoRotate", "getSystemAutoRotate", "viewModel", "Lcom/digitalwallet/app/viewmodel/main/HoldingDetailFragmentViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/main/HoldingDetailFragmentViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/main/HoldingDetailFragmentViewModel;)V", "addSwipeListener", "", "animateBanner", "applyLayoutConstraintForBanner", "bannerIsShown", "bindCard", "bindHoldingView", "holdingView", "container", "Landroid/widget/FrameLayout;", "bindHoldingViews", "bindNotificationBanner", "notificationType", "Lcom/digitalwallet/app/viewmodel/NotificationType;", "isHoldingExpired", "changeToLandscapeOrientation", "changeToPortraitOrientation", "decideRotation", "flipAnimation", "showFrontHoldingView", "flipFromLeftToRight", "flipCard", "getNotificationTypeForHolding", "handleBack", "onAccuracyChanged", "sensor", "Landroid/hardware/Sensor;", "accuracy", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onPause", "onResume", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "removeRotationSettingListener", "scaleHologram", "setupNotificationBanner", "setupRecyclerView", "setupRotateSensor", "setupRotationSettingListener", "showRotationMessage", "showSide", "front", "startHoldingDisclaimerFragment", "visitUrl", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HoldingDetailFragment.kt */
public final class HoldingDetailFragment extends BaseAppFragment<FragmentHoldingDetailBinding> implements SensorEventListener, HoldingDetailView, BackHandler {
    private static final long ANIMATION_DURATION = 300;
    public static final Companion Companion = new Companion(null);
    private static final float MIN_PITCH_FOR_TRANSFORM = 0.75f;
    private static final float PITCH_SCALAR = 10.0f;
    private static final float ROTATION_MAX = 7.5f;
    private static final String assetsKey = "assets";
    private static final String secureHoldingKey = "secureHoldingKey";
    private HashMap _$_findViewCache;
    @Inject
    public AssetService assetService;
    private NotificationBannerBinding bannerBinding;
    private boolean canFlip = true;
    private CardView cardView;
    private final CompositeDisposable disposables = new CompositeDisposable();
    public HoldingAssets holdingAssets;
    private HologramView hologram;
    private boolean isUserFocus;
    private float lastAngle;
    private final int layoutId = R.layout.fragment_holding_detail;
    private ContentObserver orientationObserver;
    private AnimatorSet rotateMessageFade;
    public SecureHolding secureHolding;
    @Inject
    public HoldingDetailFragmentViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HoldingType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[HoldingType.SOLAR_INSTALLER.ordinal()] = 1;
            iArr[HoldingType.KANGAROO_HARVESTER.ordinal()] = 2;
        }
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.app.view.base.BaseAppFragment, com.digitalwallet.view.base.BasicFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.app.view.base.BaseAppFragment, com.digitalwallet.view.base.BasicFragment
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

    public void onAccuracyChanged(Sensor sensor, int i) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
    }

    public static final /* synthetic */ CardView access$getCardView$p(HoldingDetailFragment holdingDetailFragment) {
        CardView cardView2 = holdingDetailFragment.cardView;
        if (cardView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardView");
        }
        return cardView2;
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public HoldingDetailFragmentViewModel getViewModel() {
        HoldingDetailFragmentViewModel holdingDetailFragmentViewModel = this.viewModel;
        if (holdingDetailFragmentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return holdingDetailFragmentViewModel;
    }

    public void setViewModel(HoldingDetailFragmentViewModel holdingDetailFragmentViewModel) {
        Intrinsics.checkNotNullParameter(holdingDetailFragmentViewModel, "<set-?>");
        this.viewModel = holdingDetailFragmentViewModel;
    }

    public final AssetService getAssetService() {
        AssetService assetService2 = this.assetService;
        if (assetService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assetService");
        }
        return assetService2;
    }

    public final void setAssetService(AssetService assetService2) {
        Intrinsics.checkNotNullParameter(assetService2, "<set-?>");
        this.assetService = assetService2;
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public int getLayoutId() {
        return this.layoutId;
    }

    public final SecureHolding getSecureHolding() {
        SecureHolding secureHolding2 = this.secureHolding;
        if (secureHolding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secureHolding");
        }
        return secureHolding2;
    }

    public final void setSecureHolding(SecureHolding secureHolding2) {
        Intrinsics.checkNotNullParameter(secureHolding2, "<set-?>");
        this.secureHolding = secureHolding2;
    }

    public final HoldingAssets getHoldingAssets() {
        HoldingAssets holdingAssets2 = this.holdingAssets;
        if (holdingAssets2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("holdingAssets");
        }
        return holdingAssets2;
    }

    public final void setHoldingAssets(HoldingAssets holdingAssets2) {
        Intrinsics.checkNotNullParameter(holdingAssets2, "<set-?>");
        this.holdingAssets = holdingAssets2;
    }

    public final boolean isUserFocus() {
        return this.isUserFocus;
    }

    public final void setUserFocus(boolean z) {
        this.isUserFocus = z;
    }

    /* access modifiers changed from: private */
    public final void setCanFlip(boolean z) {
        ImageButton imageButton = ((FragmentHoldingDetailBinding) getBinding()).flipCardButton;
        if (imageButton != null) {
            imageButton.setAlpha(z ? 1.0f : 0.5f);
        }
        this.canFlip = z;
    }

    /* access modifiers changed from: private */
    public final boolean isLandscape() {
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return resources.getConfiguration().orientation == 2;
    }

    /* access modifiers changed from: private */
    public final boolean getSystemAutoRotate() {
        FragmentActivity activity = getActivity();
        return Settings.System.getInt(activity != null ? activity.getContentResolver() : null, "accelerometer_rotation", 0) == 1;
    }

    private final float getCardWidth() {
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        Resources resources = context.getResources();
        Intrinsics.checkNotNull(resources);
        return resources.getDimension(R.dimen.card_width);
    }

    private final float getCameraDistance() {
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        Resources resources = context.getResources();
        Intrinsics.checkNotNull(resources);
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Intrinsics.checkNotNull(displayMetrics);
        return displayMetrics.density * getCardWidth() * ((float) 2);
    }

    @Override // com.digitalwallet.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getViewModel().setView(this);
        this.isUserFocus = true;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        SecureHolding secureHolding2;
        AssetList assetList;
        SecureHolding secureHolding3;
        HoldingRecordAttributes attributes;
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        HoldingDetailFragment$onViewCreated$earlyExit$1 holdingDetailFragment$onViewCreated$earlyExit$1 = new HoldingDetailFragment$onViewCreated$earlyExit$1(this);
        Bundle arguments = getArguments();
        if (arguments == null || (secureHolding2 = (SecureHolding) arguments.getParcelable(secureHoldingKey)) == null) {
            holdingDetailFragment$onViewCreated$earlyExit$1.invoke();
            return;
        }
        Intrinsics.checkNotNullExpressionValue(secureHolding2, "it");
        this.secureHolding = secureHolding2;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (assetList = (AssetList) arguments2.getParcelable("assets")) == null) {
            holdingDetailFragment$onViewCreated$earlyExit$1.invoke();
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        AssetService assetService2 = this.assetService;
        if (assetService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assetService");
        }
        this.holdingAssets = new HoldingAssets(context, assetService2, assetList.getList(), null, null, 24, null);
        HoldingDetailFragmentViewModel viewModel2 = getViewModel();
        SecureHolding secureHolding4 = this.secureHolding;
        if (secureHolding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secureHolding");
        }
        viewModel2.setSecureHolding(secureHolding4);
        HoldingDetailFragmentViewModel viewModel3 = getViewModel();
        HoldingAssets holdingAssets2 = this.holdingAssets;
        if (holdingAssets2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("holdingAssets");
        }
        viewModel3.setHoldingAssets(holdingAssets2);
        ObservableField<Boolean> showExpiryView = getViewModel().getShowExpiryView();
        SecureHolding secureHolding5 = this.secureHolding;
        if (secureHolding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secureHolding");
        }
        int i = WhenMappings.$EnumSwitchMapping$0[secureHolding5.getHoldingType().ordinal()];
        boolean z = false;
        if (!(i == 1 || i == 2 || (secureHolding3 = getViewModel().getSecureHolding()) == null || (attributes = secureHolding3.getAttributes()) == null)) {
            z = attributes.isHoldingExpired();
        }
        showExpiryView.set(Boolean.valueOf(z));
        bindCard();
        bindHoldingViews();
        setupRotationSettingListener();
        addSwipeListener();
        setupNotificationBanner();
        setupRecyclerView();
        setupRotateSensor();
        decideRotation();
    }

    private final void bindCard() {
        CardView cardView2 = ((FragmentHoldingDetailBinding) getBinding()).cardLayout.cardView;
        Intrinsics.checkNotNullExpressionValue(cardView2, "binding.cardLayout.cardView");
        this.cardView = cardView2;
        if (cardView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardView");
        }
        cardView2.setCameraDistance(getCameraDistance());
        CardView cardView3 = this.cardView;
        if (cardView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardView");
        }
        cardView3.setLayerType(2, null);
        HologramView hologramView = ((FragmentHoldingDetailBinding) getBinding()).cardLayout.serviceVicHoloView;
        if (isLandscape()) {
            hologramView.setup();
            Intrinsics.checkNotNullExpressionValue(hologramView, "it");
            scaleHologram(hologramView);
            hologramView.setVisibility(0);
            Unit unit = Unit.INSTANCE;
            this.hologram = hologramView;
            CardView cardView4 = this.cardView;
            if (cardView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardView");
            }
            cardView4.setOutlineProvider(null);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(hologramView, "hologramView");
        hologramView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void showSide(boolean z) {
        FrameLayout frameLayout = ((FragmentHoldingDetailBinding) getBinding()).cardLayout.cardContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.cardLayout.cardContainer");
        int i = 0;
        frameLayout.setVisibility(z ? 0 : 4);
        if (isLandscape()) {
            FrameLayout frameLayout2 = ((FragmentHoldingDetailBinding) getBinding()).cardLayout.backCardContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.cardLayout.backCardContainer");
            if (z) {
                i = 4;
            }
            frameLayout2.setVisibility(i);
        }
    }

    private final void bindHoldingViews() {
        SecureHolding secureHolding2 = this.secureHolding;
        if (secureHolding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secureHolding");
        }
        HoldingElements holdingElements = secureHolding2.getHoldingElements();
        bindHoldingView(holdingElements.getFront(), ((FragmentHoldingDetailBinding) getBinding()).cardLayout.cardContainer);
        if (isLandscape()) {
            Integer back = holdingElements.getBack();
            Intrinsics.checkNotNull(back);
            bindHoldingView(back.intValue(), ((FragmentHoldingDetailBinding) getBinding()).cardLayout.backCardContainer);
        }
        getViewModel().setShowHoldingFrontView(true);
        showSide(getViewModel().getShowHoldingFrontView());
    }

    private final void bindHoldingView(int i, FrameLayout frameLayout) {
        getViewModel().getShowHoldingDetailAttributeView().set(true);
        ViewDataBinding inflate = DataBindingUtil.inflate(getLayoutInflater(), i, frameLayout, true);
        SecureHolding secureHolding2 = this.secureHolding;
        if (secureHolding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secureHolding");
        }
        HoldingRecordAttributes attributes = secureHolding2.getAttributes();
        SecureHolding secureHolding3 = this.secureHolding;
        if (secureHolding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secureHolding");
        }
        inflate.setVariable(BR.holding, new SecureHolding(null, attributes, null, secureHolding3.getDynamicDisplay(), null, null, 53, null));
        SecureHolding secureHolding4 = this.secureHolding;
        if (secureHolding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secureHolding");
        }
        inflate.setVariable(BR.vm, secureHolding4.getAttributes());
        HoldingAssets holdingAssets2 = this.holdingAssets;
        if (holdingAssets2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("holdingAssets");
        }
        inflate.setVariable(BR.assets, holdingAssets2);
        inflate.executePendingBindings();
        CardView cardView2 = this.cardView;
        if (cardView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardView");
        }
        cardView2.requestLayout();
        HologramView hologramView = this.hologram;
        if (hologramView != null) {
            hologramView.fade(0.0f);
        }
    }

    private final void addSwipeListener() {
        ((FragmentHoldingDetailBinding) getBinding()).cardLayout.cardFrame.setFlipCard(new HoldingDetailFragment$addSwipeListener$1(this));
    }

    private final void decideRotation() {
        FragmentActivity activity;
        Boolean bool = getViewModel().getShowHoldingDetailAttributeView().get();
        boolean z = false;
        Boolean bool2 = false;
        if (bool == null) {
            bool = bool2;
        }
        Intrinsics.checkNotNullExpressionValue(bool, "viewModel.showHoldingDet…ributeView.get() ?: false");
        boolean booleanValue = bool.booleanValue();
        Boolean bool3 = getViewModel().getKeepLandscapeOrientation().get();
        if (bool3 != null) {
            bool2 = bool3;
        }
        Intrinsics.checkNotNullExpressionValue(bool2, "viewModel.keepLandscapeOrientation.get() ?: false");
        boolean booleanValue2 = bool2.booleanValue();
        if (booleanValue && getSystemAutoRotate() && !booleanValue2 && this.isUserFocus) {
            z = true;
        }
        if (z && (activity = getActivity()) != null) {
            activity.setRequestedOrientation(10);
        }
        if (isLandscape() && this.isUserFocus && !booleanValue2) {
            AnalyticsHelper.selectContent$default(getAnalytics(), "Present card - rotate", null, 2, null);
        }
    }

    private final void setupRotationSettingListener() {
        Uri uriFor = Settings.System.getUriFor("accelerometer_rotation");
        Handler handler = new Handler(Looper.getMainLooper());
        this.orientationObserver = new HoldingDetailFragment$setupRotationSettingListener$1(this, handler, handler);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        Intrinsics.checkNotNullExpressionValue(activity, "activity!!");
        ContentResolver contentResolver = activity.getContentResolver();
        Intrinsics.checkNotNull(contentResolver);
        ContentObserver contentObserver = this.orientationObserver;
        if (contentObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientationObserver");
        }
        contentResolver.registerContentObserver(uriFor, true, contentObserver);
    }

    private final void removeRotationSettingListener() {
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        Intrinsics.checkNotNullExpressionValue(activity, "activity!!");
        ContentResolver contentResolver = activity.getContentResolver();
        Intrinsics.checkNotNull(contentResolver);
        ContentObserver contentObserver = this.orientationObserver;
        if (contentObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientationObserver");
        }
        contentResolver.unregisterContentObserver(contentObserver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        ActivityAnalyticsHelper.Screen screen;
        super.onResume();
        setCanFlip(true);
        HologramView hologramView = this.hologram;
        if (hologramView != null) {
            hologramView.onResume();
        }
        Boolean bool = getViewModel().getKeepLandscapeOrientation().get();
        if (bool != null) {
            Intrinsics.checkNotNullExpressionValue(bool, "it");
            if (bool.booleanValue()) {
                screen = ActivityAnalyticsHelper.Screen.ShowCard;
            } else {
                screen = ActivityAnalyticsHelper.Screen.CardDetails;
            }
            ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), screen, null, null, 6, null);
        }
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.app.view.base.BaseAppFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        SensorManager sensorManager;
        super.onDestroyView();
        removeRotationSettingListener();
        HologramView hologramView = this.hologram;
        if (hologramView != null) {
            hologramView.destroy();
        }
        this.disposables.clear();
        Context context = getContext();
        if (!(context == null || (sensorManager = (SensorManager) context.getSystemService(SensorManager.class)) == null)) {
            sensorManager.unregisterListener(this);
        }
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setRequestedOrientation(1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        TextView textView = ((FragmentHoldingDetailBinding) getBinding()).rotateMessage;
        if (textView != null) {
            textView.setAlpha(0.0f);
        }
        HologramView hologramView = this.hologram;
        if (hologramView != null) {
            hologramView.onPause();
        }
    }

    @Override // com.digitalwallet.view.main.BackHandler
    public boolean handleBack() {
        boolean isLandscape = isLandscape();
        if (isLandscape) {
            changeToPortraitOrientation();
        }
        return isLandscape;
    }

    @Override // androidx.fragment.app.Fragment
    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if (this.isUserFocus) {
            int i = configuration.orientation;
            if (i == 1 || i == 2) {
                HoldingDetailFragment holdingDetailFragment = this;
                getParentFragmentManager().beginTransaction().detach(holdingDetailFragment).attach(holdingDetailFragment).commit();
            }
        }
    }

    private final void setupRotateSensor() {
        Context context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.content.Context");
        Object systemService = context.getSystemService(SensorManager.class);
        Intrinsics.checkNotNull(systemService);
        SensorManager sensorManager = (SensorManager) systemService;
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(1), 3);
    }

    /* access modifiers changed from: private */
    public final void visitUrl(SecureHolding secureHolding2) {
        String url;
        Unit unit = null;
        AnalyticsHelper.selectContent$default(getAnalytics(), "Renew card - card details", null, 2, null);
        DynamicHoldingRenewal renewal = secureHolding2.getRenewal();
        if (renewal == null || (url = renewal.getUrl()) == null) {
            Integer applyUrl = secureHolding2.getHoldingElements().getApplyUrl();
            if (applyUrl != null) {
                String string = getResources().getString(applyUrl.intValue());
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(urlId)");
                FragmentActivity activity = getActivity();
                Objects.requireNonNull(activity, "null cannot be cast to non-null type com.digitalwallet.app.view.main.MainActivity");
                ((MainActivity) activity).startChromeCustomTabs(string, true);
                unit = Unit.INSTANCE;
            }
        } else {
            FragmentActivity activity2 = getActivity();
            Objects.requireNonNull(activity2, "null cannot be cast to non-null type com.digitalwallet.app.view.main.MainActivity");
            ((MainActivity) activity2).startChrome(url);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            throw new Exception("Unsupported Holding Type " + secureHolding2.getHoldingType());
        }
    }

    private final void scaleHologram(HologramView hologramView) {
        float dimension = getResources().getDimension(R.dimen.card_width);
        float dimension2 = getResources().getDimension(R.dimen.card_height);
        float dimension3 = getResources().getDimension(R.dimen.card_width_overdraw);
        float dimension4 = getResources().getDimension(R.dimen.card_height_overdraw);
        hologramView.scale((1.0f - ((dimension3 - dimension) / (dimension + dimension3))) * 0.95f, (1.0f - ((dimension4 - dimension2) / (dimension2 + dimension4))) * 0.95f);
    }

    private final void setupNotificationBanner() {
        if (ServerTypeKt.getAppType() != AppType.AUTHORITY && !isLandscape()) {
            HoldingType[] holdingTypeArr = {HoldingType.SOLAR_INSTALLER, HoldingType.KANGAROO_HARVESTER};
            SecureHolding secureHolding2 = this.secureHolding;
            if (secureHolding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secureHolding");
            }
            if (!ArraysKt.contains(holdingTypeArr, secureHolding2.getHoldingType())) {
                NotificationType notificationTypeForHolding = getNotificationTypeForHolding();
                if (notificationTypeForHolding != null) {
                    SecureHolding secureHolding3 = this.secureHolding;
                    if (secureHolding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("secureHolding");
                    }
                    bindNotificationBanner(notificationTypeForHolding, secureHolding3.getAttributes().isHoldingExpired());
                    animateBanner();
                    return;
                }
                getViewModel().getShowNotificationBanner().set(false);
            }
        }
    }

    private final NotificationType getNotificationTypeForHolding() {
        SecureHolding secureHolding2 = this.secureHolding;
        if (secureHolding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secureHolding");
        }
        if (secureHolding2.getAttributes().getHoldingStateType() == HoldingState.COMING_SOON) {
            return NotificationType.ComingSoon;
        }
        SecureHolding secureHolding3 = this.secureHolding;
        if (secureHolding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secureHolding");
        }
        if (secureHolding3.getAttributes().getHoldingStateType() == HoldingState.EXPIRED) {
            return NotificationType.Expired;
        }
        SecureHolding secureHolding4 = this.secureHolding;
        if (secureHolding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secureHolding");
        }
        if (secureHolding4.getShowExpiryWarning()) {
            return NotificationType.ExpiringSoon;
        }
        return null;
    }

    private final void animateBanner() {
        applyLayoutConstraintForBanner(false);
        this.disposables.add(Completable.timer(500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new HoldingDetailFragment$animateBanner$1(this)));
    }

    static /* synthetic */ void bindNotificationBanner$default(HoldingDetailFragment holdingDetailFragment, NotificationType notificationType, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        holdingDetailFragment.bindNotificationBanner(notificationType, z);
    }

    private final void bindNotificationBanner(NotificationType notificationType, boolean z) {
        ViewDataBinding inflate = DataBindingUtil.inflate(getLayoutInflater(), R.layout.notification_banner, ((FragmentHoldingDetailBinding) getBinding()).notificationBannerView, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…ater, layout, root, true)");
        NotificationBannerBinding notificationBannerBinding = (NotificationBannerBinding) inflate;
        this.bannerBinding = notificationBannerBinding;
        if (notificationBannerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerBinding");
        }
        NotificationBannerViewModel from = NotificationBannerViewModel.Companion.from(notificationType, z);
        if (from != null) {
            from.setVisitUrl(new HoldingDetailFragment$bindNotificationBanner$$inlined$apply$lambda$1(this, notificationType, z));
            Unit unit = Unit.INSTANCE;
        } else {
            from = null;
        }
        notificationBannerBinding.setVm(from);
        notificationBannerBinding.executePendingBindings();
        getViewModel().getShowNotificationBanner().set(true);
    }

    private final void setupRecyclerView() {
        RecyclerView recyclerView = ((FragmentHoldingDetailBinding) getBinding()).holdingDetailRecyclerView;
        if (recyclerView != null) {
            ViewUtilsKt.initDetails(recyclerView, getViewModel().getHoldingDetailItems());
            recyclerView.setNestedScrollingEnabled(false);
        }
    }

    /* access modifiers changed from: private */
    public final void applyLayoutConstraintForBanner(boolean z) {
        FrameLayout frameLayout;
        ConstraintSet constraintSet = new ConstraintSet();
        ConstraintLayout constraintLayout = ((FragmentHoldingDetailBinding) getBinding()).holdingDetailConstraintLayout;
        try {
            ScrollView scrollView = ((FragmentHoldingDetailBinding) getBinding()).contentScrollView;
            if (scrollView != null) {
                int intValue = Integer.valueOf(scrollView.getId()).intValue();
                constraintSet.clone(constraintLayout);
                constraintSet.clear(intValue, 4);
                if (z && (frameLayout = ((FragmentHoldingDetailBinding) getBinding()).notificationBannerView) != null) {
                    constraintSet.connect(intValue, 4, Integer.valueOf(frameLayout.getId()).intValue(), 3, 0);
                }
                constraintSet.applyTo(constraintLayout);
            }
        } catch (Exception e) {
            Timber.e(e);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void flipAnimation(boolean z, boolean z2) {
        setCanFlip(false);
        if (DeviceModelHelperKt.isDeviceSupportBetterAnimation()) {
            float f = z2 ? -90.0f : 90.0f;
            CardView cardView2 = this.cardView;
            if (cardView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardView");
            }
            cardView2.animate().withLayer().rotationY(f).setDuration(ANIMATION_DURATION).withEndAction(new HoldingDetailFragment$flipAnimation$1(this, z, f)).start();
            return;
        }
        CardView cardView3 = this.cardView;
        if (cardView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardView");
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cardView3, "scaleX", 1.0f, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "oa1");
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addListener(new HoldingDetailFragment$flipAnimation$2(this, z));
        ofFloat.start();
    }

    @Override // com.digitalwallet.app.viewmodel.main.HoldingDetailView
    public void startHoldingDisclaimerFragment() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        HoldingDisclaimerFragment holdingDisclaimerFragment = new HoldingDisclaimerFragment();
        List<Fragment> fragments = parentFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
        for (T t : fragments) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            t.setUserVisibleHint(false);
        }
        FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
        String simpleName = Reflection.getOrCreateKotlinClass(HoldingDisclaimerFragment.class).getSimpleName();
        beginTransaction.add(R.id.fragment_container_RES_2114322527, holdingDisclaimerFragment, simpleName).addToBackStack(simpleName).commit();
        this.isUserFocus = false;
    }

    @Override // com.digitalwallet.app.viewmodel.main.HoldingDetailView
    public void changeToLandscapeOrientation() {
        getViewModel().getKeepLandscapeOrientation().set(true);
        getViewModel().getShowNotificationBanner().set(false);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setRequestedOrientation(0);
        }
    }

    @Override // com.digitalwallet.app.viewmodel.main.HoldingDetailView
    public void changeToPortraitOrientation() {
        getViewModel().getKeepLandscapeOrientation().set(false);
        if (getSystemAutoRotate()) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(10);
            }
            showRotationMessage();
            return;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.setRequestedOrientation(1);
        }
    }

    private final void showRotationMessage() {
        new Handler(Looper.getMainLooper()).post(new HoldingDetailFragment$showRotationMessage$1(this));
    }

    @Override // com.digitalwallet.app.viewmodel.main.HoldingDetailView
    public void flipCard(boolean z) {
        if (Intrinsics.areEqual((Object) getViewModel().getShowHoldingDetailAttributeView().get(), (Object) true) && isLandscape() && this.canFlip) {
            HologramView hologramView = this.hologram;
            if (hologramView != null) {
                hologramView.fade(0.0f);
            }
            getViewModel().setShowHoldingFrontView(true ^ getViewModel().getShowHoldingFrontView());
            AnalyticsHelper.selectContent$default(getAnalytics(), "Flip card", null, 2, null);
            flipAnimation(getViewModel().getShowHoldingFrontView(), z);
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        Intrinsics.checkNotNullParameter(sensorEvent, "event");
        float f = sensorEvent.values[1];
        float f2 = 0.0f;
        if (f < -0.5f || f > 0.5f) {
            float f3 = (float) 0;
            if (f > f3) {
                f2 = Math.min(f * PITCH_SCALAR, (float) ROTATION_MAX);
            } else if (f < f3) {
                f2 = Math.max(-7.5f, f * PITCH_SCALAR);
            }
        }
        float f4 = this.lastAngle;
        float f5 = ((f2 - f4) * 0.02f) + f4;
        if (isLandscape() && f5 != this.lastAngle && this.canFlip) {
            new Handler(Looper.getMainLooper()).post(new HoldingDetailFragment$onSensorChanged$1(this, f5));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/digitalwallet/app/view/main/HoldingDetailFragment$Companion;", "", "()V", "ANIMATION_DURATION", "", "MIN_PITCH_FOR_TRANSFORM", "", "PITCH_SCALAR", "ROTATION_MAX", "assetsKey", "", HoldingDetailFragment.secureHoldingKey, "newInstance", "Lcom/digitalwallet/app/view/main/HoldingDetailFragment;", "secureHolding", "Lcom/digitalwallet/app/model/SecureHolding;", "shareRecord", "Lcom/digitalwallet/app/model/db/shares/ShareRecord;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: HoldingDetailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HoldingDetailFragment newInstance(SecureHolding secureHolding) {
            Intrinsics.checkNotNullParameter(secureHolding, "secureHolding");
            HoldingDetailFragment holdingDetailFragment = new HoldingDetailFragment();
            List<Asset> assets = secureHolding.getAssets();
            if (assets == null) {
                assets = CollectionsKt.emptyList();
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(HoldingDetailFragment.secureHoldingKey, secureHolding);
            Unit unit = Unit.INSTANCE;
            bundle.putParcelable("assets", new AssetList(assets));
            Unit unit2 = Unit.INSTANCE;
            holdingDetailFragment.setArguments(bundle);
            return holdingDetailFragment;
        }

        public final HoldingDetailFragment newInstance(ShareRecord shareRecord) {
            Intrinsics.checkNotNullParameter(shareRecord, "shareRecord");
            HoldingDetailFragment holdingDetailFragment = new HoldingDetailFragment();
            List<Asset> assets = shareRecord.getAssets();
            if (assets == null) {
                assets = CollectionsKt.emptyList();
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(HoldingDetailFragment.secureHoldingKey, new SecureHolding(null, shareRecord.getAttributes(), null, shareRecord.getDynamicDisplay(), shareRecord.getAssets(), null, 37, null));
            bundle.putParcelable("assets", new AssetList(assets));
            Unit unit = Unit.INSTANCE;
            holdingDetailFragment.setArguments(bundle);
            return holdingDetailFragment;
        }
    }
}
