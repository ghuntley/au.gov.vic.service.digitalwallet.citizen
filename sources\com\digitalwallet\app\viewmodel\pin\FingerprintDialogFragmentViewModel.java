package com.digitalwallet.app.viewmodel.pin;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.databinding.ObservableField;
import com.digitalwallet.app.viewmodel.pin.FingerprintState;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.github.ajalt.reprint.core.AuthenticationResult;
import com.github.ajalt.reprint.core.Reprint;
import com.github.ajalt.reprint.rxjava2.RxReprint;
import com.google.android.gms.analytics.ecommerce.Promotion;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/digitalwallet/app/viewmodel/pin/FingerprintDialogFragmentViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "(Lcom/digitalwallet/utilities/AnalyticsHelper;)V", "attemptCounter", "", "viewInterface", "Lcom/digitalwallet/app/viewmodel/pin/AuthViewInterface;", "viewState", "Landroidx/databinding/ObservableField;", "Lcom/digitalwallet/app/viewmodel/pin/FingerprintState;", "getViewState", "()Landroidx/databinding/ObservableField;", "dismissFingerprintDialog", "", "inject", Promotion.ACTION_VIEW, "listenForFingerprint", "context", "Landroid/content/Context;", "triggerMessageReset", "", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: FingerprintDialogFragmentViewModel.kt */
public final class FingerprintDialogFragmentViewModel extends BaseViewModel {
    private static final int ATTEMPT_ALLOWED = 5;
    public static final Companion Companion = new Companion(null);
    private static final long ERROR_TIMEOUT_MILLIS = 1600;
    private static final int HARDWARE_LOCKED_OUT = 7;
    private static final int STATUS_NO_REGISTERED_FINGERPRINTS = 1001;
    private final AnalyticsHelper analytics;
    private int attemptCounter;
    private AuthViewInterface viewInterface;
    private final ObservableField<FingerprintState> viewState = new ObservableField<>(FingerprintState.Default.INSTANCE);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AuthenticationResult.Status.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AuthenticationResult.Status.SUCCESS.ordinal()] = 1;
            iArr[AuthenticationResult.Status.NONFATAL_FAILURE.ordinal()] = 2;
            iArr[AuthenticationResult.Status.FATAL_FAILURE.ordinal()] = 3;
        }
    }

    public static final /* synthetic */ AuthViewInterface access$getViewInterface$p(FingerprintDialogFragmentViewModel fingerprintDialogFragmentViewModel) {
        AuthViewInterface authViewInterface = fingerprintDialogFragmentViewModel.viewInterface;
        if (authViewInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewInterface");
        }
        return authViewInterface;
    }

    @Inject
    public FingerprintDialogFragmentViewModel(AnalyticsHelper analyticsHelper) {
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        this.analytics = analyticsHelper;
    }

    public final ObservableField<FingerprintState> getViewState() {
        return this.viewState;
    }

    public final void inject(AuthViewInterface authViewInterface) {
        Intrinsics.checkNotNullParameter(authViewInterface, Promotion.ACTION_VIEW);
        this.viewInterface = authViewInterface;
    }

    public final void dismissFingerprintDialog() {
        AuthViewInterface authViewInterface = this.viewInterface;
        if (authViewInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewInterface");
        }
        authViewInterface.toggleFingerprintDialog(false);
    }

    public final void listenForFingerprint(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Reprint.initialize(context);
        AnalyticsHelper.selectContent$default(this.analytics, "Pin Screen - Awaiting Biometric Authorisation", null, 2, null);
        getCompositeDisposable().add(RxReprint.authenticate().subscribe(new FingerprintDialogFragmentViewModel$listenForFingerprint$1(this)));
    }

    /* access modifiers changed from: private */
    public final boolean triggerMessageReset() {
        return new Handler(Looper.getMainLooper()).postDelayed(new FingerprintDialogFragmentViewModel$triggerMessageReset$1(this), ERROR_TIMEOUT_MILLIS);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/viewmodel/pin/FingerprintDialogFragmentViewModel$Companion;", "", "()V", "ATTEMPT_ALLOWED", "", "ERROR_TIMEOUT_MILLIS", "", "HARDWARE_LOCKED_OUT", "STATUS_NO_REGISTERED_FINGERPRINTS", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: FingerprintDialogFragmentViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
