package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: locks.kt */
public final class CancellableSimpleLock extends DefaultSimpleLock {
    private final Runnable checkCancelled;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CancellableSimpleLock(Lock lock, Runnable runnable) {
        super(lock);
        Intrinsics.checkNotNullParameter(lock, "lock");
        Intrinsics.checkNotNullParameter(runnable, "checkCancelled");
        this.checkCancelled = runnable;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CancellableSimpleLock(Runnable runnable) {
        this(new ReentrantLock(), runnable);
        Intrinsics.checkNotNullParameter(runnable, "checkCancelled");
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock, kotlin.reflect.jvm.internal.impl.storage.DefaultSimpleLock
    public void lock() {
        while (!getLock().tryLock(50, TimeUnit.MILLISECONDS)) {
            this.checkCancelled.run();
        }
    }
}
