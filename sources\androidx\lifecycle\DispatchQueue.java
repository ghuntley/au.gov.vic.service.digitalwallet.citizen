package androidx.lifecycle;

import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

public final class DispatchQueue {
    private boolean finished;
    private boolean isDraining;
    private boolean paused = true;
    private final Queue<Runnable> queue = new ArrayDeque();

    public final void pause() {
        this.paused = true;
    }

    public final void resume() {
        if (this.paused) {
            if (!this.finished) {
                this.paused = false;
                drainQueue();
                return;
            }
            throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
        }
    }

    public final void finish() {
        this.finished = true;
        drainQueue();
    }

    public final void drainQueue() {
        if (!this.isDraining) {
            boolean z = false;
            z = true;
            try {
                while (true) {
                    if (!(this.queue.isEmpty() ^ z)) {
                        break;
                    } else if (!canRun()) {
                        break;
                    } else {
                        Runnable poll = this.queue.poll();
                        if (poll != null) {
                            poll.run();
                        }
                    }
                }
                this.isDraining = z;
            } finally {
                this.isDraining = z;
            }
        }
    }

    private final boolean canRun() {
        return this.finished || !this.paused;
    }

    public final void runOrEnqueue(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        if (immediate.isDispatchNeeded(EmptyCoroutineContext.INSTANCE)) {
            immediate.dispatch(EmptyCoroutineContext.INSTANCE, new DispatchQueue$runOrEnqueue$$inlined$with$lambda$1(this, runnable));
        } else {
            enqueue(runnable);
        }
    }

    /* access modifiers changed from: public */
    private final void enqueue(Runnable runnable) {
        if (this.queue.offer(runnable)) {
            drainQueue();
            return;
        }
        throw new IllegalStateException("cannot enqueue any more runnables".toString());
    }
}
