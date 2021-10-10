package com.digitalwallet.app.viewmodel.pin;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.text.Editable;
import androidx.databinding.ObservableField;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.services.HandshakeService;
import com.digitalwallet.app.viewmodel.pin.AuthViewInterface;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 92\u00020\u0001:\u00029:B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010.\u001a\u00020/2\u0006\u0010,\u001a\u00020-J\u000e\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u00020/J\b\u00104\u001a\u00020/H\u0002J\u0010\u00105\u001a\u00020/2\b\u00106\u001a\u0004\u0018\u000107J\u0006\u00108\u001a\u00020/R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\r\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00160\u00160\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00190\u00190\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u001f\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00160\u00160\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u001d\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00140\u00140\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u001f\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00190\u00190\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012R\u0011\u0010!\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001f\u0010(\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00190\u00190\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0012R\u001f\u0010*\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00190\u00190\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0012R\u000e\u0010,\u001a\u00020-X.¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/digitalwallet/app/viewmodel/pin/PinActivityViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "authenticationUtility", "Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "holdingsService", "Lcom/digitalwallet/app/holdings/HoldingsService;", "digitalWalletDb", "Lcom/digitalwallet/app/model/db/DigitalWalletDatabase;", "handshakeService", "Lcom/digitalwallet/app/services/HandshakeService;", "(Lcom/digitalwallet/app/oidc/AuthenticationUtility;Lcom/digitalwallet/utilities/AnalyticsHelper;Lcom/digitalwallet/app/holdings/HoldingsService;Lcom/digitalwallet/app/model/db/DigitalWalletDatabase;Lcom/digitalwallet/app/services/HandshakeService;)V", "buttonAlpha", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getButtonAlpha", "()Landroidx/databinding/ObservableField;", "confirmPin", "", "enableButton", "", "getEnableButton", "headerText", "", "getHeaderText", "hideButton", "getHideButton", "pin", "getPin", "pinError", "getPinError", "pinSet", "getPinSet", "()Z", "screen", "Lcom/digitalwallet/app/viewmodel/pin/PinActivityViewModel$PinScreen;", "getScreen", "()Lcom/digitalwallet/app/viewmodel/pin/PinActivityViewModel$PinScreen;", "screenTitle", "getScreenTitle", "subHeaderText", "getSubHeaderText", "viewInterface", "Lcom/digitalwallet/app/viewmodel/pin/AuthViewInterface;", "inject", "", "isFingerprintAuthAvailable", "context", "Landroid/content/Context;", "loginWithEmail", "logout", "pinChanged", "editable", "Landroid/text/Editable;", "pinNext", "Companion", "PinScreen", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: PinActivityViewModel.kt */
public final class PinActivityViewModel extends BaseViewModel {
    public static final Companion Companion = new Companion(null);
    public static final int PIN_LENGTH = 6;
    private final AnalyticsHelper analytics;
    private final AuthenticationUtility authenticationUtility;
    private final ObservableField<Float> buttonAlpha = new ObservableField<>(Float.valueOf(0.4f));
    private String confirmPin;
    private final DigitalWalletDatabase digitalWalletDb;
    private final ObservableField<Boolean> enableButton = new ObservableField<>((Boolean) false);
    private final HandshakeService handshakeService;
    private final ObservableField<Integer> headerText = new ObservableField<>(Integer.valueOf((int) R.string.pin_creation_header));
    private final ObservableField<Boolean> hideButton = new ObservableField<>((Boolean) false);
    private final HoldingsService holdingsService;
    private final ObservableField<String> pin = new ObservableField<>("");
    private final ObservableField<Integer> pinError = new ObservableField<>(Integer.valueOf((int) R.string.empty_string_RES_2114650224));
    private final ObservableField<Integer> screenTitle = new ObservableField<>(Integer.valueOf((int) R.string.create_a_passcode));
    private final ObservableField<Integer> subHeaderText = new ObservableField<>(Integer.valueOf((int) R.string.pin_creation_subheader));
    private AuthViewInterface viewInterface;

    @Inject
    public PinActivityViewModel(AuthenticationUtility authenticationUtility2, AnalyticsHelper analyticsHelper, HoldingsService holdingsService2, DigitalWalletDatabase digitalWalletDatabase, HandshakeService handshakeService2) {
        Intrinsics.checkNotNullParameter(authenticationUtility2, "authenticationUtility");
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        Intrinsics.checkNotNullParameter(holdingsService2, "holdingsService");
        Intrinsics.checkNotNullParameter(digitalWalletDatabase, "digitalWalletDb");
        Intrinsics.checkNotNullParameter(handshakeService2, "handshakeService");
        this.authenticationUtility = authenticationUtility2;
        this.analytics = analyticsHelper;
        this.holdingsService = holdingsService2;
        this.digitalWalletDb = digitalWalletDatabase;
        this.handshakeService = handshakeService2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/digitalwallet/app/viewmodel/pin/PinActivityViewModel$Companion;", "", "()V", "PIN_LENGTH", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: PinActivityViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/viewmodel/pin/PinActivityViewModel$PinScreen;", "", "rawValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "Create", "Validate", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: PinActivityViewModel.kt */
    public enum PinScreen {
        Create("Create"),
        Validate("Validate");
        
        private final String rawValue;

        private PinScreen(String str) {
            this.rawValue = str;
        }

        public final String getRawValue() {
            return this.rawValue;
        }
    }

    public final ObservableField<String> getPin() {
        return this.pin;
    }

    public final ObservableField<Integer> getPinError() {
        return this.pinError;
    }

    public final ObservableField<Integer> getSubHeaderText() {
        return this.subHeaderText;
    }

    public final ObservableField<Integer> getHeaderText() {
        return this.headerText;
    }

    public final ObservableField<Integer> getScreenTitle() {
        return this.screenTitle;
    }

    public final ObservableField<Boolean> getEnableButton() {
        return this.enableButton;
    }

    public final ObservableField<Boolean> getHideButton() {
        return this.hideButton;
    }

    public final ObservableField<Float> getButtonAlpha() {
        return this.buttonAlpha;
    }

    public final void inject(AuthViewInterface authViewInterface) {
        Intrinsics.checkNotNullParameter(authViewInterface, "viewInterface");
        this.viewInterface = authViewInterface;
        if (getScreen() == PinScreen.Validate) {
            this.confirmPin = this.authenticationUtility.getUserPin();
            this.subHeaderText.set(Integer.valueOf((int) R.string.empty_string_RES_2114650224));
            this.headerText.set(Integer.valueOf((int) R.string.pin_enter_pin));
            this.screenTitle.set(Integer.valueOf((int) R.string.unlock_app));
            this.hideButton.set(true);
        }
    }

    public final boolean getPinSet() {
        String userPin = this.authenticationUtility.getUserPin();
        return !(userPin == null || StringsKt.isBlank(userPin));
    }

    public final PinScreen getScreen() {
        if (getPinSet()) {
            return PinScreen.Validate;
        }
        return PinScreen.Create;
    }

    public final void pinNext() {
        if (!(!Intrinsics.areEqual((Object) this.enableButton.get(), (Object) true))) {
            if (getScreen() == PinScreen.Create) {
                this.confirmPin = this.pin.get();
            }
            String str = this.pin.get();
            if (str == null) {
                return;
            }
            if (Intrinsics.areEqual(str, this.confirmPin)) {
                AuthenticationUtility authenticationUtility2 = this.authenticationUtility;
                Intrinsics.checkNotNullExpressionValue(str, "enteredPin");
                authenticationUtility2.setUserPin(str);
                this.pinError.set(Integer.valueOf((int) R.string.empty_string_RES_2114650224));
                AuthViewInterface authViewInterface = this.viewInterface;
                if (authViewInterface == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewInterface");
                }
                authViewInterface.startMainActivity();
            } else if (str.length() >= 6) {
                this.pinError.set(Integer.valueOf((int) R.string.pin_incorrect));
                this.pin.set("");
            }
        }
    }

    public final void pinChanged(Editable editable) {
        Boolean bool;
        ObservableField<Float> observableField;
        float f;
        if (editable != null) {
            this.enableButton.set(Boolean.valueOf(editable.toString().length() >= 6));
            Boolean bool2 = this.enableButton.get();
            if (bool2 != null) {
                Intrinsics.checkNotNullExpressionValue(bool2, "enableButton");
                if (bool2.booleanValue()) {
                    observableField = this.buttonAlpha;
                    f = 1.0f;
                } else {
                    observableField = this.buttonAlpha;
                    f = 0.4f;
                }
                observableField.set(Float.valueOf(f));
            }
        }
        Boolean bool3 = this.hideButton.get();
        if (bool3 != null && (bool = this.enableButton.get()) != null) {
            Intrinsics.checkNotNullExpressionValue(bool3, "hideButton");
            if (bool3.booleanValue()) {
                Intrinsics.checkNotNullExpressionValue(bool, "enableButton");
                if (bool.booleanValue()) {
                    pinNext();
                }
            }
        }
    }

    public final boolean isFingerprintAuthAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("fingerprint");
        if (!(systemService instanceof FingerprintManager)) {
            systemService = null;
        }
        FingerprintManager fingerprintManager = (FingerprintManager) systemService;
        if (fingerprintManager == null || !fingerprintManager.isHardwareDetected() || !fingerprintManager.hasEnrolledFingerprints()) {
            return false;
        }
        return true;
    }

    public final void loginWithEmail() {
        AnalyticsHelper.selectContent$default(this.analytics, "Pin Screen - email-password button tapped", null, 2, null);
        logout();
        AuthViewInterface authViewInterface = this.viewInterface;
        if (authViewInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewInterface");
        }
        AuthViewInterface.DefaultImpls.startLoginActivity$default(authViewInterface, false, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.digitalwallet.app.viewmodel.pin.PinActivityViewModel$sam$io_reactivex_functions_Consumer$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final void logout() {
        CompositeDisposable compositeDisposable = getCompositeDisposable();
        Completable subscribeOn = Completable.fromCallable(new PinActivityViewModel$logout$1(this)).subscribeOn(Schedulers.io());
        PinActivityViewModel$logout$2 pinActivityViewModel$logout$2 = PinActivityViewModel$logout$2.INSTANCE;
        if (pinActivityViewModel$logout$2 != null) {
            pinActivityViewModel$logout$2 = new PinActivityViewModel$sam$io_reactivex_functions_Consumer$0(pinActivityViewModel$logout$2);
        }
        compositeDisposable.add(subscribeOn.doOnError((Consumer) pinActivityViewModel$logout$2).andThen(this.holdingsService.deleteHoldingExpiryNotifications()).andThen(Completable.fromCallable(new PinActivityViewModel$sam$java_util_concurrent_Callable$0(new PinActivityViewModel$logout$3(this.digitalWalletDb)))).andThen(Completable.fromCallable(new PinActivityViewModel$logout$4(this))).subscribe());
    }
}
