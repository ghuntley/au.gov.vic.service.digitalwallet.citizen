package com.digitalwallet.app.viewmodel.login;

import android.content.Context;
import android.text.SpannableStringBuilder;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.api.UserApi;
import com.digitalwallet.app.model.login.CreateAccountError;
import com.digitalwallet.app.model.login.RegisterUserRequestPayload;
import com.digitalwallet.app.model.login.RegistrationLoginRequestPayload;
import com.digitalwallet.app.model.login.VerifyOTPRequestPayload;
import com.digitalwallet.app.oidc.AuthenticationService;
import com.digitalwallet.app.oidc.model.Tokens;
import com.digitalwallet.utilities.ActionEvent;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.view.util.SpannableTextKt;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.squareup.moshi.Moshi;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u00104\u001a\u00020!J\u0006\u00105\u001a\u00020!J\u0006\u00106\u001a\u00020!J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J\u0006\u0010;\u001a\u00020!J\u0016\u0010<\u001a\u00020!2\u0006\u00102\u001a\u0002032\u0006\u0010-\u001a\u00020\u0015J\u0006\u0010=\u001a\u00020!R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R'\u0010\u0019\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001c`\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR'\u0010 \u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u001b0\u001aj\b\u0012\u0004\u0012\u00020!`\u001d¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001f\u0010)\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018R\u001f\u0010+\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010$0$0\u0014¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R'\u0010.\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001c`\u001d¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR'\u00100\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u001b0\u001aj\b\u0012\u0004\u0012\u00020!`\u001d¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001fR\u000e\u00102\u001a\u000203X.¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/digitalwallet/app/viewmodel/login/VerifyEmailViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "context", "Landroid/content/Context;", "userApi", "Lcom/digitalwallet/app/api/UserApi;", "authenticationService", "Lcom/digitalwallet/app/oidc/AuthenticationService;", "moshi", "Lcom/squareup/moshi/Moshi;", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "(Landroid/content/Context;Lcom/digitalwallet/app/api/UserApi;Lcom/digitalwallet/app/oidc/AuthenticationService;Lcom/squareup/moshi/Moshi;Lcom/digitalwallet/utilities/AnalyticsHelper;)V", "detailedDescription", "Landroid/text/SpannableStringBuilder;", "getDetailedDescription", "()Landroid/text/SpannableStringBuilder;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "email", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getEmail", "()Landroidx/databinding/ObservableField;", "emailResendFailedEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/digitalwallet/utilities/ActionEvent;", "Lcom/digitalwallet/app/model/login/CreateAccountError;", "Lcom/digitalwallet/utilities/MutableLiveEvent;", "getEmailResendFailedEvent", "()Landroidx/lifecycle/MutableLiveData;", "emailResentEvent", "", "getEmailResentEvent", "hasOTPConfirmed", "", "getHasOTPConfirmed", "()Z", "setHasOTPConfirmed", "(Z)V", "otpInput", "getOtpInput", "showLoading", "getShowLoading", "userApiXTransId", "verificationFailedEvent", "getVerificationFailedEvent", "verificationPassedEvent", "getVerificationPassedEvent", "verifyOTPRequestPayload", "Lcom/digitalwallet/app/model/login/VerifyOTPRequestPayload;", "autoLogin", "clearOtpInput", "initiateANewSession", "onRegistrationLoginSuccess", "Lio/reactivex/Completable;", "tokens", "Lcom/digitalwallet/app/oidc/model/Tokens;", "resendEmail", "setup", "verifyOTP", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: VerifyEmailViewModel.kt */
public final class VerifyEmailViewModel extends BaseViewModel {
    private final AnalyticsHelper analytics;
    private final AuthenticationService authenticationService;
    private final Context context;
    private final SpannableStringBuilder detailedDescription;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final ObservableField<String> email = new ObservableField<>("");
    private final MutableLiveData<ActionEvent<CreateAccountError>> emailResendFailedEvent;
    private final MutableLiveData<ActionEvent<Unit>> emailResentEvent;
    private boolean hasOTPConfirmed;
    private final Moshi moshi;
    private final ObservableField<String> otpInput;
    private final ObservableField<Boolean> showLoading;
    private final UserApi userApi;
    private String userApiXTransId;
    private final MutableLiveData<ActionEvent<CreateAccountError>> verificationFailedEvent;
    private final MutableLiveData<ActionEvent<Unit>> verificationPassedEvent;
    private VerifyOTPRequestPayload verifyOTPRequestPayload;

    public static final /* synthetic */ VerifyOTPRequestPayload access$getVerifyOTPRequestPayload$p(VerifyEmailViewModel verifyEmailViewModel) {
        VerifyOTPRequestPayload verifyOTPRequestPayload2 = verifyEmailViewModel.verifyOTPRequestPayload;
        if (verifyOTPRequestPayload2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyOTPRequestPayload");
        }
        return verifyOTPRequestPayload2;
    }

    @Inject
    public VerifyEmailViewModel(Context context2, UserApi userApi2, AuthenticationService authenticationService2, Moshi moshi2, AnalyticsHelper analyticsHelper) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(userApi2, "userApi");
        Intrinsics.checkNotNullParameter(authenticationService2, "authenticationService");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        this.context = context2;
        this.userApi = userApi2;
        this.authenticationService = authenticationService2;
        this.moshi = moshi2;
        this.analytics = analyticsHelper;
        this.detailedDescription = SpannableTextKt.getDWStyleSpannableStringBuilder(context2, R.string.check_email_detailed_description, R.string.check_email_description_resend_email, new VerifyEmailViewModel$detailedDescription$1(this));
        this.otpInput = new ObservableField<>("");
        this.showLoading = new ObservableField<>((Boolean) false);
        this.emailResentEvent = new MutableLiveData<>();
        this.emailResendFailedEvent = new MutableLiveData<>();
        this.verificationPassedEvent = new MutableLiveData<>();
        this.verificationFailedEvent = new MutableLiveData<>();
    }

    public final void setup(VerifyOTPRequestPayload verifyOTPRequestPayload2, String str) {
        Intrinsics.checkNotNullParameter(verifyOTPRequestPayload2, "verifyOTPRequestPayload");
        Intrinsics.checkNotNullParameter(str, "userApiXTransId");
        this.verifyOTPRequestPayload = verifyOTPRequestPayload2;
        this.email.set(verifyOTPRequestPayload2.getEmail());
        this.userApiXTransId = str;
    }

    public final ObservableField<String> getEmail() {
        return this.email;
    }

    public final SpannableStringBuilder getDetailedDescription() {
        return this.detailedDescription;
    }

    public final ObservableField<String> getOtpInput() {
        return this.otpInput;
    }

    public final boolean getHasOTPConfirmed() {
        return this.hasOTPConfirmed;
    }

    public final void setHasOTPConfirmed(boolean z) {
        this.hasOTPConfirmed = z;
    }

    public final ObservableField<Boolean> getShowLoading() {
        return this.showLoading;
    }

    public final MutableLiveData<ActionEvent<Unit>> getEmailResentEvent() {
        return this.emailResentEvent;
    }

    public final MutableLiveData<ActionEvent<CreateAccountError>> getEmailResendFailedEvent() {
        return this.emailResendFailedEvent;
    }

    public final MutableLiveData<ActionEvent<Unit>> getVerificationPassedEvent() {
        return this.verificationPassedEvent;
    }

    public final MutableLiveData<ActionEvent<CreateAccountError>> getVerificationFailedEvent() {
        return this.verificationFailedEvent;
    }

    public final void clearOtpInput() {
        this.otpInput.set("");
    }

    public final void resendEmail() {
        AnalyticsHelper.selectContent$default(this.analytics, "Button click - Check email screen - Resend email", null, 2, null);
        this.showLoading.set(true);
        UserApi userApi2 = this.userApi;
        VerifyOTPRequestPayload verifyOTPRequestPayload2 = this.verifyOTPRequestPayload;
        if (verifyOTPRequestPayload2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyOTPRequestPayload");
        }
        String sessionID = verifyOTPRequestPayload2.getSessionID();
        String str = this.userApiXTransId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userApiXTransId");
        }
        this.disposables.add(userApi2.resendOtp(sessionID, str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new VerifyEmailViewModel$resendEmail$1(this), new VerifyEmailViewModel$resendEmail$2(this)));
    }

    public final void verifyOTP() {
        if (this.hasOTPConfirmed) {
            autoLogin();
            return;
        }
        this.showLoading.set(true);
        String str = this.otpInput.get();
        if (str == null) {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "otpInput.get() ?: \"\"");
        VerifyOTPRequestPayload verifyOTPRequestPayload2 = this.verifyOTPRequestPayload;
        if (verifyOTPRequestPayload2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyOTPRequestPayload");
        }
        verifyOTPRequestPayload2.setCode(str);
        UserApi userApi2 = this.userApi;
        String str2 = this.userApiXTransId;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userApiXTransId");
        }
        VerifyOTPRequestPayload verifyOTPRequestPayload3 = this.verifyOTPRequestPayload;
        if (verifyOTPRequestPayload3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyOTPRequestPayload");
        }
        this.disposables.add(userApi2.confirmOtp(str2, verifyOTPRequestPayload3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new VerifyEmailViewModel$verifyOTP$1(this), new VerifyEmailViewModel$verifyOTP$2(this)));
    }

    public final void autoLogin() {
        this.showLoading.set(true);
        VerifyOTPRequestPayload verifyOTPRequestPayload2 = this.verifyOTPRequestPayload;
        if (verifyOTPRequestPayload2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyOTPRequestPayload");
        }
        String email2 = verifyOTPRequestPayload2.getEmail();
        VerifyOTPRequestPayload verifyOTPRequestPayload3 = this.verifyOTPRequestPayload;
        if (verifyOTPRequestPayload3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyOTPRequestPayload");
        }
        String password = verifyOTPRequestPayload3.getPassword();
        VerifyOTPRequestPayload verifyOTPRequestPayload4 = this.verifyOTPRequestPayload;
        if (verifyOTPRequestPayload4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyOTPRequestPayload");
        }
        RegistrationLoginRequestPayload registrationLoginRequestPayload = new RegistrationLoginRequestPayload(email2, password, verifyOTPRequestPayload4.getDevicePrint());
        UserApi userApi2 = this.userApi;
        String str = this.userApiXTransId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userApiXTransId");
        }
        this.disposables.add(userApi2.registrationLogin(str, registrationLoginRequestPayload).flatMapCompletable(new VerifyEmailViewModel$sam$io_reactivex_functions_Function$0(new VerifyEmailViewModel$autoLogin$1(this))).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new VerifyEmailViewModel$autoLogin$2(this), new VerifyEmailViewModel$autoLogin$3(this)));
    }

    public final void initiateANewSession() {
        this.showLoading.set(true);
        VerifyOTPRequestPayload verifyOTPRequestPayload2 = this.verifyOTPRequestPayload;
        if (verifyOTPRequestPayload2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyOTPRequestPayload");
        }
        String email2 = verifyOTPRequestPayload2.getEmail();
        VerifyOTPRequestPayload verifyOTPRequestPayload3 = this.verifyOTPRequestPayload;
        if (verifyOTPRequestPayload3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyOTPRequestPayload");
        }
        RegisterUserRequestPayload registerUserRequestPayload = new RegisterUserRequestPayload(email2, verifyOTPRequestPayload3.getFirstName());
        UserApi userApi2 = this.userApi;
        String str = this.userApiXTransId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userApiXTransId");
        }
        this.disposables.add(userApi2.registerUser(str, registerUserRequestPayload).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new VerifyEmailViewModel$initiateANewSession$1(this), new VerifyEmailViewModel$initiateANewSession$2(this)));
    }

    /* access modifiers changed from: private */
    public final Completable onRegistrationLoginSuccess(Tokens tokens) {
        return this.authenticationService.handleRegistrationLoginSuccess(tokens, this.context);
    }
}
