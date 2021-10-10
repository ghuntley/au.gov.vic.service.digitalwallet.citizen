package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public LifecycleController(Lifecycle lifecycle2, Lifecycle.State state, DispatchQueue dispatchQueue2, Job job) {
        Intrinsics.checkParameterIsNotNull(lifecycle2, "lifecycle");
        Intrinsics.checkParameterIsNotNull(state, "minState");
        Intrinsics.checkParameterIsNotNull(dispatchQueue2, "dispatchQueue");
        Intrinsics.checkParameterIsNotNull(job, "parentJob");
        this.lifecycle = lifecycle2;
        this.minState = state;
        this.dispatchQueue = dispatchQueue2;
        LifecycleController$observer$1 lifecycleController$observer$1 = new LifecycleController$observer$1(this, job);
        this.observer = lifecycleController$observer$1;
        if (lifecycle2.getCurrentState() == Lifecycle.State.DESTROYED) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            finish();
            return;
        }
        lifecycle2.addObserver(lifecycleController$observer$1);
    }

    /* access modifiers changed from: public */
    private final void handleDestroy(Job job) {
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        finish();
    }

    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
