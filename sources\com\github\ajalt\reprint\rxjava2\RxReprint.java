package com.github.ajalt.reprint.rxjava2;

import com.github.ajalt.reprint.core.AuthenticationFailureReason;
import com.github.ajalt.reprint.core.AuthenticationListener;
import com.github.ajalt.reprint.core.AuthenticationResult;
import com.github.ajalt.reprint.core.Reprint;
import com.github.ajalt.reprint.core.RestartPredicates;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.Action;

public class RxReprint {
    public static Flowable<AuthenticationResult> authenticate() {
        return authenticate(RestartPredicates.defaultPredicate());
    }

    public static Flowable<AuthenticationResult> authenticate(final Reprint.RestartPredicate restartPredicate) {
        return Flowable.create(new FlowableOnSubscribe<AuthenticationResult>() {
            /* class com.github.ajalt.reprint.rxjava2.RxReprint.AnonymousClass2 */

            @Override // io.reactivex.FlowableOnSubscribe
            public void subscribe(final FlowableEmitter<AuthenticationResult> flowableEmitter) {
                Reprint.authenticate(new AuthenticationListener() {
                    /* class com.github.ajalt.reprint.rxjava2.RxReprint.AnonymousClass2.AnonymousClass1 */
                    private boolean listening = true;

                    @Override // com.github.ajalt.reprint.core.AuthenticationListener
                    public void onSuccess(int i) {
                        if (this.listening) {
                            this.listening = false;
                            flowableEmitter.onNext(new AuthenticationResult(AuthenticationResult.Status.SUCCESS, null, "", i, 0));
                            flowableEmitter.onComplete();
                        }
                    }

                    @Override // com.github.ajalt.reprint.core.AuthenticationListener
                    public void onFailure(AuthenticationFailureReason authenticationFailureReason, boolean z, CharSequence charSequence, int i, int i2) {
                        if (this.listening) {
                            flowableEmitter.onNext(new AuthenticationResult(z ? AuthenticationResult.Status.FATAL_FAILURE : AuthenticationResult.Status.NONFATAL_FAILURE, authenticationFailureReason, charSequence, i, i2));
                            if (z) {
                                flowableEmitter.onComplete();
                            }
                        }
                    }
                }, restartPredicate);
            }
        }, BackpressureStrategy.LATEST).doOnCancel(new Action() {
            /* class com.github.ajalt.reprint.rxjava2.RxReprint.AnonymousClass1 */

            @Override // io.reactivex.functions.Action
            public void run() throws Exception {
                Reprint.cancelAuthentication();
            }
        });
    }
}
