package com.digitalwallet.app.viewmodel.login;

import androidx.lifecycle.MutableLiveData;
import com.digitalwallet.app.model.login.CreateAccountError;
import com.digitalwallet.app.model.login.RegisterUserRequestPayload;
import com.digitalwallet.app.model.login.RegisterUserResponsePayload;
import com.digitalwallet.app.model.login.VerifyOTPRequestPayload;
import com.digitalwallet.utilities.ActionEvent;
import com.digitalwallet.utilities.ActionEventKt;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CreateAccountViewModel.kt */
public final class CreateAccountViewModel$createAccount$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CreateAccountViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateAccountViewModel$createAccount$1(CreateAccountViewModel createAccountViewModel) {
        super(0);
        this.this$0 = createAccountViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        if (Intrinsics.areEqual((Object) this.this$0.getAreAllInputsValid().get(), (Object) true)) {
            this.this$0.getShowLoading().set(true);
            String str = this.this$0.getGivenNames().get();
            final String str2 = "";
            if (str == null) {
                str = str2;
            }
            Intrinsics.checkNotNullExpressionValue(str, "(givenNames.get() ?: \"\")");
            Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
            final String obj = StringsKt.trim((CharSequence) str).toString();
            String str3 = this.this$0.getFamilyName().get();
            if (str3 == null) {
                str3 = str2;
            }
            Intrinsics.checkNotNullExpressionValue(str3, "(familyName.get() ?: \"\")");
            Objects.requireNonNull(str3, "null cannot be cast to non-null type kotlin.CharSequence");
            final String obj2 = StringsKt.trim((CharSequence) str3).toString();
            String str4 = this.this$0.getEmail().get();
            if (str4 == null) {
                str4 = str2;
            }
            Intrinsics.checkNotNullExpressionValue(str4, "(email.get() ?: \"\")");
            Objects.requireNonNull(str4, "null cannot be cast to non-null type kotlin.CharSequence");
            String obj3 = StringsKt.trim((CharSequence) str4).toString();
            String str5 = this.this$0.getPassword().get();
            if (str5 != null) {
                str2 = str5;
            }
            Intrinsics.checkNotNullExpressionValue(str2, "password.get() ?: \"\"");
            this.this$0.disposables.add(this.this$0.userApi.registerUser(this.this$0.getUserApiXTransId(), new RegisterUserRequestPayload(obj3, obj)).zipWith(this.this$0.remoteSubscriptionService.getDeviceToken(), AnonymousClass1.INSTANCE).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Pair<? extends RegisterUserResponsePayload, ? extends String>>(this) {
                /* class com.digitalwallet.app.viewmodel.login.CreateAccountViewModel$createAccount$1.AnonymousClass2 */
                final /* synthetic */ CreateAccountViewModel$createAccount$1 this$0;

                {
                    this.this$0 = r1;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // io.reactivex.functions.Consumer
                public /* bridge */ /* synthetic */ void accept(Pair<? extends RegisterUserResponsePayload, ? extends String> pair) {
                    accept((Pair<RegisterUserResponsePayload, String>) pair);
                }

                public final void accept(Pair<RegisterUserResponsePayload, String> pair) {
                    RegisterUserResponsePayload component1 = pair.component1();
                    String component2 = pair.component2();
                    MutableLiveData<ActionEvent<VerifyOTPRequestPayload>> successEvent = this.this$0.this$0.getSuccessEvent();
                    CreateAccountViewModel createAccountViewModel = this.this$0.this$0;
                    Intrinsics.checkNotNullExpressionValue(component1, "registerUserResponsePayload");
                    Intrinsics.checkNotNullExpressionValue(component2, "deviceToken");
                    ActionEventKt.postEvent(successEvent, createAccountViewModel.getVerifyOTPRequestPayload(component1, component2, obj, obj2, str2));
                    this.this$0.this$0.getShowLoading().set(false);
                }
            }, new Consumer<Throwable>(this) {
                /* class com.digitalwallet.app.viewmodel.login.CreateAccountViewModel$createAccount$1.AnonymousClass3 */
                final /* synthetic */ CreateAccountViewModel$createAccount$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(Throwable th) {
                    MutableLiveData<ActionEvent<CreateAccountError>> errorEvent = this.this$0.this$0.getErrorEvent();
                    CreateAccountError.Companion companion = CreateAccountError.Companion;
                    Intrinsics.checkNotNullExpressionValue(th, "it");
                    ActionEventKt.postEvent(errorEvent, companion.fromThrowable(th, this.this$0.this$0.moshi));
                    this.this$0.this$0.getShowLoading().set(false);
                }
            }));
        }
    }
}
