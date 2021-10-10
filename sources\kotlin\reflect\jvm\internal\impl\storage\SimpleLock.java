package kotlin.reflect.jvm.internal.impl.storage;

/* compiled from: locks.kt */
public interface SimpleLock {
    public static final Companion Companion = Companion.$$INSTANCE;

    void lock();

    void unlock();

    /* compiled from: locks.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final DefaultSimpleLock simpleLock(Runnable runnable) {
            return runnable != null ? new CancellableSimpleLock(runnable) : new DefaultSimpleLock(null, 1, null);
        }
    }
}
