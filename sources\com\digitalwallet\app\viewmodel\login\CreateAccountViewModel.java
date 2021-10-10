package com.digitalwallet.app.viewmodel.login;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.api.UserApi;
import com.digitalwallet.app.model.login.CreateAccountError;
import com.digitalwallet.app.model.login.DevicePrint;
import com.digitalwallet.app.model.login.DevicePrintFonts;
import com.digitalwallet.app.model.login.DevicePrintPlugins;
import com.digitalwallet.app.model.login.DevicePrintScreen;
import com.digitalwallet.app.model.login.DevicePrintTimezone;
import com.digitalwallet.app.model.login.RegisterUserResponsePayload;
import com.digitalwallet.app.model.login.VerifyOTPRequestPayload;
import com.digitalwallet.app.services.remotenotification.RemoteSubscriptionService;
import com.digitalwallet.utilities.ActionEvent;
import com.digitalwallet.utilities.ActionEventKt;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.utilities.DeviceInfoKt;
import com.digitalwallet.utilities.VersionNameCodeKt;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.squareup.moshi.Moshi;
import io.reactivex.disposables.CompositeDisposable;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.TokenRequest;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010C\u001a\u00020/J\u0016\u0010D\u001a\u00020/2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020/0FH\u0002J0\u0010G\u001a\u00020>2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u00162\u0006\u0010K\u001a\u00020\u00162\u0006\u0010L\u001a\u00020\u00162\u0006\u0010M\u001a\u00020\u0016H\u0002J\b\u0010N\u001a\u00020/H\u0002J\u000e\u0010O\u001a\u00020/2\u0006\u0010P\u001a\u00020QJ\u000e\u0010R\u001a\u00020/2\u0006\u0010P\u001a\u00020QJ\u000e\u0010S\u001a\u00020/2\u0006\u0010P\u001a\u00020QJ\u000e\u0010T\u001a\u00020/2\u0006\u0010P\u001a\u00020QJ\u0010\u0010U\u001a\u00020&2\u0006\u0010V\u001a\u00020\u000fH\u0003R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\r\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00160\u00160\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R'\u0010\u001a\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001d`\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001f\u0010!\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00160\u00160\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R\u0019\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0012R\u000e\u0010%\u001a\u00020&XD¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&XD¢\u0006\u0002\n\u0000R\u001f\u0010(\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00160\u00160\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0012R\u0019\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0012R\u000e\u0010,\u001a\u00020&XD¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020&XD¢\u0006\u0002\n\u0000R'\u0010.\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u001c0\u001bj\b\u0012\u0004\u0012\u00020/`\u001e¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001f\u00101\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00160\u00160\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0012R\u000e\u00103\u001a\u00020&XD¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u001f\u00105\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010&0&0\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0012R\u001f\u00107\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010&0&0\u000e¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0012R\u001f\u00109\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010&0&0\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010;\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0012R'\u0010=\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0\u001c0\u001bj\b\u0012\u0004\u0012\u00020>`\u001e¢\u0006\b\n\u0000\u001a\u0004\b?\u0010 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010@\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\bA\u0010B¨\u0006W"}, d2 = {"Lcom/digitalwallet/app/viewmodel/login/CreateAccountViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "context", "Landroid/content/Context;", "userApi", "Lcom/digitalwallet/app/api/UserApi;", "remoteSubscriptionService", "Lcom/digitalwallet/app/services/remotenotification/RemoteSubscriptionService;", "moshi", "Lcom/squareup/moshi/Moshi;", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "(Landroid/content/Context;Lcom/digitalwallet/app/api/UserApi;Lcom/digitalwallet/app/services/remotenotification/RemoteSubscriptionService;Lcom/squareup/moshi/Moshi;Lcom/digitalwallet/utilities/AnalyticsHelper;)V", "areAllInputsValid", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getAreAllInputsValid", "()Landroidx/databinding/ObservableField;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "email", "", "getEmail", "emailError", "getEmailError", "errorEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/digitalwallet/utilities/ActionEvent;", "Lcom/digitalwallet/app/model/login/CreateAccountError;", "Lcom/digitalwallet/utilities/MutableLiveEvent;", "getErrorEvent", "()Landroidx/lifecycle/MutableLiveData;", "familyName", "getFamilyName", "familyNameError", "getFamilyNameError", "familyNameMaxLength", "", "familyNameMinLength", "givenNames", "getGivenNames", "givenNamesError", "getGivenNamesError", "givenNamesMaxLength", "givenNamesMinLength", "hideKeyboardEvent", "", "getHideKeyboardEvent", TokenRequest.GRANT_TYPE_PASSWORD, "getPassword", "passwordMinLength", "pwHintInitialColor", "pwLengthHintColor", "getPwLengthHintColor", "pwLowerLetterHintColor", "getPwLowerLetterHintColor", "pwUpperLetterHintColor", "getPwUpperLetterHintColor", "showLoading", "getShowLoading", "successEvent", "Lcom/digitalwallet/app/model/login/VerifyOTPRequestPayload;", "getSuccessEvent", "userApiXTransId", "getUserApiXTransId", "()Ljava/lang/String;", "createAccount", "doInDelay", "action", "Lkotlin/Function0;", "getVerifyOTPRequestPayload", "registerUserResponsePayload", "Lcom/digitalwallet/app/model/login/RegisterUserResponsePayload;", "deviceToken", "givenNamesStr", "familyNameStr", "passwordStr", "onAnInputChanged", "onEmailChanged", "e", "Landroid/text/Editable;", "onFamilyNameChanged", "onGivenNamesChanged", "onPasswordChanged", "passwordHintColor", "satisfied", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CreateAccountViewModel.kt */
public final class CreateAccountViewModel extends BaseViewModel {
    private final AnalyticsHelper analytics;
    private final ObservableField<Boolean> areAllInputsValid;
    private final Context context;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final ObservableField<String> email;
    private final ObservableField<String> emailError;
    private final MutableLiveData<ActionEvent<CreateAccountError>> errorEvent;
    private final ObservableField<String> familyName;
    private final ObservableField<String> familyNameError;
    private final int familyNameMaxLength;
    private final int familyNameMinLength;
    private final ObservableField<String> givenNames;
    private final ObservableField<String> givenNamesError;
    private final int givenNamesMaxLength;
    private final int givenNamesMinLength;
    private final MutableLiveData<ActionEvent<Unit>> hideKeyboardEvent;
    private final Moshi moshi;
    private final ObservableField<String> password;
    private final int passwordMinLength;
    private final int pwHintInitialColor;
    private final ObservableField<Integer> pwLengthHintColor;
    private final ObservableField<Integer> pwLowerLetterHintColor;
    private final ObservableField<Integer> pwUpperLetterHintColor;
    private final RemoteSubscriptionService remoteSubscriptionService;
    private final ObservableField<Boolean> showLoading;
    private final MutableLiveData<ActionEvent<VerifyOTPRequestPayload>> successEvent;
    private final UserApi userApi;
    private final String userApiXTransId;

    @Inject
    public CreateAccountViewModel(Context context2, UserApi userApi2, RemoteSubscriptionService remoteSubscriptionService2, Moshi moshi2, AnalyticsHelper analyticsHelper) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(userApi2, "userApi");
        Intrinsics.checkNotNullParameter(remoteSubscriptionService2, "remoteSubscriptionService");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        this.context = context2;
        this.userApi = userApi2;
        this.remoteSubscriptionService = remoteSubscriptionService2;
        this.moshi = moshi2;
        this.analytics = analyticsHelper;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "UUID.randomUUID().toString()");
        this.userApiXTransId = uuid;
        this.givenNames = new ObservableField<>("");
        this.familyName = new ObservableField<>("");
        this.email = new ObservableField<>("");
        this.password = new ObservableField<>("");
        this.givenNamesError = new ObservableField<>();
        this.familyNameError = new ObservableField<>();
        this.emailError = new ObservableField<>();
        this.givenNamesMinLength = 1;
        this.givenNamesMaxLength = 40;
        this.familyNameMinLength = 1;
        this.familyNameMaxLength = 80;
        this.passwordMinLength = 8;
        int color = context2.getColor(R.color.dw_battleship_grey_RES_2114060291);
        this.pwHintInitialColor = color;
        this.pwLengthHintColor = new ObservableField<>(Integer.valueOf(color));
        this.pwUpperLetterHintColor = new ObservableField<>(Integer.valueOf(color));
        this.pwLowerLetterHintColor = new ObservableField<>(Integer.valueOf(color));
        this.areAllInputsValid = new ObservableField<>((Boolean) false);
        this.showLoading = new ObservableField<>((Boolean) false);
        this.hideKeyboardEvent = new MutableLiveData<>();
        this.successEvent = new MutableLiveData<>();
        this.errorEvent = new MutableLiveData<>();
    }

    public final String getUserApiXTransId() {
        return this.userApiXTransId;
    }

    public final ObservableField<String> getGivenNames() {
        return this.givenNames;
    }

    public final ObservableField<String> getFamilyName() {
        return this.familyName;
    }

    public final ObservableField<String> getEmail() {
        return this.email;
    }

    public final ObservableField<String> getPassword() {
        return this.password;
    }

    public final ObservableField<String> getGivenNamesError() {
        return this.givenNamesError;
    }

    public final ObservableField<String> getFamilyNameError() {
        return this.familyNameError;
    }

    public final ObservableField<String> getEmailError() {
        return this.emailError;
    }

    public final ObservableField<Integer> getPwLengthHintColor() {
        return this.pwLengthHintColor;
    }

    public final ObservableField<Integer> getPwUpperLetterHintColor() {
        return this.pwUpperLetterHintColor;
    }

    public final ObservableField<Integer> getPwLowerLetterHintColor() {
        return this.pwLowerLetterHintColor;
    }

    public final ObservableField<Boolean> getAreAllInputsValid() {
        return this.areAllInputsValid;
    }

    public final ObservableField<Boolean> getShowLoading() {
        return this.showLoading;
    }

    public final MutableLiveData<ActionEvent<Unit>> getHideKeyboardEvent() {
        return this.hideKeyboardEvent;
    }

    public final MutableLiveData<ActionEvent<VerifyOTPRequestPayload>> getSuccessEvent() {
        return this.successEvent;
    }

    public final MutableLiveData<ActionEvent<CreateAccountError>> getErrorEvent() {
        return this.errorEvent;
    }

    public final void onGivenNamesChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "e");
        doInDelay(new CreateAccountViewModel$onGivenNamesChanged$1(this));
    }

    public final void onFamilyNameChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "e");
        doInDelay(new CreateAccountViewModel$onFamilyNameChanged$1(this));
    }

    public final void onEmailChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "e");
        doInDelay(new CreateAccountViewModel$onEmailChanged$1(this));
    }

    public final void onPasswordChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "e");
        doInDelay(new CreateAccountViewModel$onPasswordChanged$1(this));
    }

    /* access modifiers changed from: private */
    public final void onAnInputChanged() {
        Integer num;
        Integer num2;
        boolean z = false;
        boolean z2 = this.givenNamesError.get() == null;
        boolean z3 = this.familyNameError.get() == null;
        boolean z4 = this.emailError.get() == null;
        int passwordHintColor = passwordHintColor(true);
        Integer num3 = this.pwLengthHintColor.get();
        boolean z5 = num3 != null && num3.intValue() == passwordHintColor && (num = this.pwUpperLetterHintColor.get()) != null && num.intValue() == passwordHintColor && (num2 = this.pwLowerLetterHintColor.get()) != null && num2.intValue() == passwordHintColor;
        ObservableField<Boolean> observableField = this.areAllInputsValid;
        if (z2 && z3 && z4 && z5) {
            z = true;
        }
        observableField.set(Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public final int passwordHintColor(boolean z) {
        int i;
        if (z) {
            i = R.color.hint_green;
        } else if (!z) {
            i = R.color.dw_battleship_grey_RES_2114060291;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return this.context.getColor(i);
    }

    private final void doInDelay(Function0<Unit> function0) {
        new Handler(Looper.getMainLooper()).postDelayed(new CreateAccountViewModel$doInDelay$1(function0), 200);
    }

    public final void createAccount() {
        AnalyticsHelper.selectContent$default(this.analytics, "Button click - Create account screen - Create account", null, 2, null);
        ActionEventKt.post(this.hideKeyboardEvent);
        doInDelay(new CreateAccountViewModel$createAccount$1(this));
    }

    /* access modifiers changed from: private */
    public final VerifyOTPRequestPayload getVerifyOTPRequestPayload(RegisterUserResponsePayload registerUserResponsePayload, String str, String str2, String str3, String str4) {
        DevicePrintScreen devicePrintScreen = new DevicePrintScreen(DeviceInfoKt.getScreenWidth(this.context), DeviceInfoKt.getScreenHeight(this.context), 24);
        DevicePrintTimezone devicePrintTimezone = new DevicePrintTimezone(DeviceInfoKt.getDeviceTimezoneOffsetInMin());
        DevicePrintPlugins devicePrintPlugins = new DevicePrintPlugins("");
        DevicePrintFonts devicePrintFonts = new DevicePrintFonts("");
        String string = this.context.getString(R.string.app_name_RES_2114650130);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.app_name)");
        return new VerifyOTPRequestPayload(registerUserResponsePayload.getEmail(), registerUserResponsePayload.getSessionID(), "", registerUserResponsePayload.getId(), str4, str2, str3, new DevicePrint(str, devicePrintScreen, devicePrintTimezone, devicePrintPlugins, devicePrintFonts, "Android", string, "", VersionNameCodeKt.versionName(this.context), "Android", DeviceInfoKt.getDeviceModel(), "", DeviceInfoKt.getDeviceManufacturer(), DeviceInfoKt.getDeviceLocaleTag()));
    }
}
