package com.digitalwallet.app.viewmodel.login;

import com.digitalwallet.app.oidc.model.Tokens;
import io.reactivex.Completable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/reactivex/Completable;", "p1", "Lcom/digitalwallet/app/oidc/model/Tokens;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: VerifyEmailViewModel.kt */
public final /* synthetic */ class VerifyEmailViewModel$autoLogin$1 extends FunctionReferenceImpl implements Function1<Tokens, Completable> {
    VerifyEmailViewModel$autoLogin$1(VerifyEmailViewModel verifyEmailViewModel) {
        super(1, verifyEmailViewModel, VerifyEmailViewModel.class, "onRegistrationLoginSuccess", "onRegistrationLoginSuccess(Lcom/digitalwallet/app/oidc/model/Tokens;)Lio/reactivex/Completable;", 0);
    }

    public final Completable invoke(Tokens tokens) {
        Intrinsics.checkNotNullParameter(tokens, "p1");
        return ((VerifyEmailViewModel) this.receiver).onRegistrationLoginSuccess(tokens);
    }
}
