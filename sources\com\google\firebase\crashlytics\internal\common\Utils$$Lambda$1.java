package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;

/* access modifiers changed from: package-private */
/* compiled from: Utils */
public final /* synthetic */ class Utils$$Lambda$1 implements Continuation {
    private final CountDownLatch arg$1;

    private Utils$$Lambda$1(CountDownLatch countDownLatch) {
        this.arg$1 = countDownLatch;
    }

    public static Continuation lambdaFactory$(CountDownLatch countDownLatch) {
        return new Utils$$Lambda$1(countDownLatch);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return this.arg$1.countDown();
    }
}
