package com.digitalwallet.app.viewmodel.login;

import androidx.lifecycle.MutableLiveData;
import com.digitalwallet.app.model.login.CreateAccountError;
import com.digitalwallet.utilities.ActionEvent;
import com.digitalwallet.utilities.ActionEventKt;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: VerifyEmailViewModel.kt */
public final class VerifyEmailViewModel$autoLogin$3<T> implements Consumer<Throwable> {
    final /* synthetic */ VerifyEmailViewModel this$0;

    VerifyEmailViewModel$autoLogin$3(VerifyEmailViewModel verifyEmailViewModel) {
        this.this$0 = verifyEmailViewModel;
    }

    public final void accept(Throwable th) {
        MutableLiveData<ActionEvent<CreateAccountError>> verificationFailedEvent = this.this$0.getVerificationFailedEvent();
        CreateAccountError.Companion companion = CreateAccountError.Companion;
        Intrinsics.checkNotNullExpressionValue(th, "it");
        ActionEventKt.postEvent(verificationFailedEvent, companion.fromThrowable(th, this.this$0.moshi));
        this.this$0.getShowLoading().set(false);
    }
}
