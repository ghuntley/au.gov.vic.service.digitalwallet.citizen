package com.digitalwallet.app.services.remotenotification;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/SingleEmitter;", "", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 4, 0})
/* compiled from: RemoteSubscriptionService.kt */
public final class RemoteSubscriptionService$getDeviceToken$1<T> implements SingleOnSubscribe<String> {
    public static final RemoteSubscriptionService$getDeviceToken$1 INSTANCE = new RemoteSubscriptionService$getDeviceToken$1();

    RemoteSubscriptionService$getDeviceToken$1() {
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(final SingleEmitter<String> singleEmitter) {
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        FirebaseMessaging instance = FirebaseMessaging.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "FirebaseMessaging.getInstance()");
        instance.getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            /* class com.digitalwallet.app.services.remotenotification.RemoteSubscriptionService$getDeviceToken$1.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: io.reactivex.SingleEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task<String> task) {
                Intrinsics.checkNotNullParameter(task, "task");
                if (!task.isSuccessful()) {
                    Timber.w(task.getException(), "Fetching FCM registration token failed", new Object[0]);
                    SingleEmitter singleEmitter = singleEmitter;
                    Exception exception = task.getException();
                    if (exception == null) {
                        exception = new Exception("Fetching FCM registration token failed");
                    }
                    singleEmitter.onError(exception);
                    return;
                }
                singleEmitter.onSuccess(task.getResult());
            }
        });
    }
}
