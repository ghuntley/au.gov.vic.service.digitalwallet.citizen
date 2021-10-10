package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.InstanceIdResult;

/* access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final /* synthetic */ class FirebaseMessaging$$Lambda$2 implements Continuation {
    static final Continuation $instance = new FirebaseMessaging$$Lambda$2();

    private FirebaseMessaging$$Lambda$2() {
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        return ((InstanceIdResult) task.getResult()).getToken();
    }
}
