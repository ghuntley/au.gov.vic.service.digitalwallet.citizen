package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnSuccessListener;

/* access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final /* synthetic */ class FirebaseMessaging$$Lambda$1 implements OnSuccessListener {
    private final FirebaseMessaging arg$1;

    FirebaseMessaging$$Lambda$1(FirebaseMessaging firebaseMessaging) {
        this.arg$1 = firebaseMessaging;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        this.arg$1.lambda$new$1$FirebaseMessaging((TopicsSubscriber) obj);
    }
}
