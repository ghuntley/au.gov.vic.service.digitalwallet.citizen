package com.digitalwallet.app.viewmodel.pin;

import androidx.databinding.ObservableField;
import com.digitalwallet.app.viewmodel.pin.FingerprintDialogFragmentViewModel;
import com.digitalwallet.app.viewmodel.pin.FingerprintState;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.github.ajalt.reprint.core.AuthenticationResult;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "result", "Lcom/github/ajalt/reprint/core/AuthenticationResult;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: FingerprintDialogFragmentViewModel.kt */
public final class FingerprintDialogFragmentViewModel$listenForFingerprint$1<T> implements Consumer<AuthenticationResult> {
    final /* synthetic */ FingerprintDialogFragmentViewModel this$0;

    FingerprintDialogFragmentViewModel$listenForFingerprint$1(FingerprintDialogFragmentViewModel fingerprintDialogFragmentViewModel) {
        this.this$0 = fingerprintDialogFragmentViewModel;
    }

    public final void accept(AuthenticationResult authenticationResult) {
        AuthenticationResult.Status status;
        if (authenticationResult != null) {
            status = authenticationResult.status;
        } else {
            status = null;
        }
        if (status != null) {
            int i = FingerprintDialogFragmentViewModel.WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
            if (i == 1) {
                AnalyticsHelper.selectContent$default(this.this$0.analytics, "Pin Screen - Biometric Authorisation Success", null, 2, null);
                FingerprintDialogFragmentViewModel.access$getViewInterface$p(this.this$0).startMainActivity();
            } else if (i == 2) {
                AnalyticsHelper.selectContent$default(this.this$0.analytics, "Pin Screen - Biometric Authorisation Failed - NONFATAL", null, 2, null);
                if (authenticationResult.errorCode == 1001) {
                    FingerprintDialogFragmentViewModel fingerprintDialogFragmentViewModel = this.this$0;
                    fingerprintDialogFragmentViewModel.attemptCounter = fingerprintDialogFragmentViewModel.attemptCounter + 1;
                }
                if (this.this$0.attemptCounter != 5) {
                    ObservableField<FingerprintState> viewState = this.this$0.getViewState();
                    CharSequence charSequence = authenticationResult.errorMessage;
                    Intrinsics.checkNotNullExpressionValue(charSequence, "result.errorMessage");
                    viewState.set(new FingerprintState.Error(charSequence));
                    boolean unused = this.this$0.triggerMessageReset();
                }
            } else if (i == 3) {
                AnalyticsHelper.selectContent$default(this.this$0.analytics, "Pin Screen - Biometric Authorisation Failed - FATAL", null, 2, null);
                if (authenticationResult.errorCode == 7) {
                    ObservableField<FingerprintState> viewState2 = this.this$0.getViewState();
                    CharSequence charSequence2 = authenticationResult.errorMessage;
                    Intrinsics.checkNotNullExpressionValue(charSequence2, "result.errorMessage");
                    viewState2.set(new FingerprintState.Error(charSequence2));
                    this.this$0.attemptCounter = 0;
                    return;
                }
                ObservableField<FingerprintState> viewState3 = this.this$0.getViewState();
                CharSequence charSequence3 = authenticationResult.errorMessage;
                Intrinsics.checkNotNullExpressionValue(charSequence3, "result.errorMessage");
                viewState3.set(new FingerprintState.Error(charSequence3));
                boolean unused2 = this.this$0.triggerMessageReset();
            }
        }
    }
}
