package kotlinx.coroutines.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.internal.ThreadSafeHeap;

public final class TestCoroutineContext implements CoroutineContext {
    private long counter;
    private final Dispatcher ctxDispatcher;
    private final CoroutineExceptionHandler ctxHandler;
    private final String name;
    private final ThreadSafeHeap<TimedRunnableObsolete> queue;
    private long time;
    private final List<Throwable> uncaughtExceptions;

    public TestCoroutineContext() {
        this(null, 1, null);
    }

    public TestCoroutineContext(String str) {
        this.name = str;
        this.uncaughtExceptions = new ArrayList();
        this.ctxDispatcher = new Dispatcher();
        this.ctxHandler = new TestCoroutineContext$$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this);
        this.queue = new ThreadSafeHeap<>();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TestCoroutineContext(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.plus(this, coroutineContext);
    }

    public final List<Throwable> getExceptions() {
        return this.uncaughtExceptions;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) function2.invoke((Object) function2.invoke(r, this.ctxDispatcher), this.ctxHandler);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        if (key == ContinuationInterceptor.Key) {
            Dispatcher dispatcher = this.ctxDispatcher;
            if (dispatcher != null) {
                return dispatcher;
            }
            throw new TypeCastException("null cannot be cast to non-null type E");
        } else if (key != CoroutineExceptionHandler.Key) {
            return null;
        } else {
            CoroutineExceptionHandler coroutineExceptionHandler = this.ctxHandler;
            if (coroutineExceptionHandler != null) {
                return coroutineExceptionHandler;
            }
            throw new TypeCastException("null cannot be cast to non-null type E");
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        if (key == ContinuationInterceptor.Key) {
            return this.ctxHandler;
        }
        if (key == CoroutineExceptionHandler.Key) {
            return this.ctxDispatcher;
        }
        return this;
    }

    public static /* synthetic */ long now$default(TestCoroutineContext testCoroutineContext, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 1) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return testCoroutineContext.now(timeUnit);
    }

    public final long now(TimeUnit timeUnit) {
        return timeUnit.convert(this.time, TimeUnit.NANOSECONDS);
    }

    public static /* synthetic */ long advanceTimeBy$default(TestCoroutineContext testCoroutineContext, long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return testCoroutineContext.advanceTimeBy(j, timeUnit);
    }

    public final long advanceTimeBy(long j, TimeUnit timeUnit) {
        long j2 = this.time;
        advanceTimeTo(timeUnit.toNanos(j) + j2, TimeUnit.NANOSECONDS);
        return timeUnit.convert(this.time - j2, TimeUnit.NANOSECONDS);
    }

    public static /* synthetic */ void advanceTimeTo$default(TestCoroutineContext testCoroutineContext, long j, TimeUnit timeUnit, int i, Object obj) {
        if ((i & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        testCoroutineContext.advanceTimeTo(j, timeUnit);
    }

    public final void advanceTimeTo(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        triggerActions(nanos);
        if (nanos > this.time) {
            this.time = nanos;
        }
    }

    public final void triggerActions() {
        triggerActions(this.time);
    }

    public final void cancelAllActions() {
        if (!this.queue.isEmpty()) {
            this.queue.clear();
        }
    }

    public static /* synthetic */ void assertUnhandledException$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertUnhandledException(str, function1);
    }

    public final void assertUnhandledException(String str, Function1<? super Throwable, Boolean> function1) {
        if (this.uncaughtExceptions.size() != 1 || !function1.invoke(this.uncaughtExceptions.get(0)).booleanValue()) {
            throw new AssertionError(str);
        }
        this.uncaughtExceptions.clear();
    }

    public static /* synthetic */ void assertAllUnhandledExceptions$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertAllUnhandledExceptions(str, function1);
    }

    public final void assertAllUnhandledExceptions(String str, Function1<? super Throwable, Boolean> function1) {
        List<Throwable> list = this.uncaughtExceptions;
        boolean z = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!function1.invoke(it.next()).booleanValue()) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z) {
            this.uncaughtExceptions.clear();
            return;
        }
        throw new AssertionError(str);
    }

    public static /* synthetic */ void assertAnyUnhandledException$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertAnyUnhandledException(str, function1);
    }

    public final void assertAnyUnhandledException(String str, Function1<? super Throwable, Boolean> function1) {
        List<Throwable> list = this.uncaughtExceptions;
        boolean z = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (function1.invoke(it.next()).booleanValue()) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z) {
            this.uncaughtExceptions.clear();
            return;
        }
        throw new AssertionError(str);
    }

    public static /* synthetic */ void assertExceptions$default(TestCoroutineContext testCoroutineContext, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        testCoroutineContext.assertExceptions(str, function1);
    }

    public final void assertExceptions(String str, Function1<? super List<? extends Throwable>, Boolean> function1) {
        if (function1.invoke(this.uncaughtExceptions).booleanValue()) {
            this.uncaughtExceptions.clear();
            return;
        }
        throw new AssertionError(str);
    }

    private final void enqueue(Runnable runnable) {
        ThreadSafeHeap<TimedRunnableObsolete> threadSafeHeap = this.queue;
        long j = this.counter;
        this.counter = 1 + j;
        threadSafeHeap.addLast(new TimedRunnableObsolete(runnable, j, 0, 4, null));
    }

    private final TimedRunnableObsolete postDelayed(Runnable runnable, long j) {
        long j2 = this.counter;
        this.counter = 1 + j2;
        TimedRunnableObsolete timedRunnableObsolete = new TimedRunnableObsolete(runnable, j2, this.time + TimeUnit.MILLISECONDS.toNanos(j));
        this.queue.addLast(timedRunnableObsolete);
        return timedRunnableObsolete;
    }

    private final long processNextEvent() {
        TimedRunnableObsolete peek = this.queue.peek();
        if (peek != null) {
            triggerActions(peek.time);
        }
        if (this.queue.isEmpty()) {
            return LongCompanionObject.MAX_VALUE;
        }
        return 0;
    }

    private final void triggerActions(long j) {
        TimedRunnableObsolete timedRunnableObsolete;
        while (true) {
            ThreadSafeHeap<TimedRunnableObsolete> threadSafeHeap = this.queue;
            synchronized (threadSafeHeap) {
                TimedRunnableObsolete firstImpl = threadSafeHeap.firstImpl();
                timedRunnableObsolete = null;
                if (firstImpl != null) {
                    if (firstImpl.time <= j) {
                        timedRunnableObsolete = threadSafeHeap.removeAtImpl(0);
                    }
                }
            }
            TimedRunnableObsolete timedRunnableObsolete2 = timedRunnableObsolete;
            if (timedRunnableObsolete2 != null) {
                if (timedRunnableObsolete2.time != 0) {
                    this.time = timedRunnableObsolete2.time;
                }
                timedRunnableObsolete2.run();
            } else {
                return;
            }
        }
    }

    public String toString() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        return "TestCoroutineContext@" + DebugStringsKt.getHexAddress(this);
    }

    public final class Dispatcher extends EventLoop implements Delay {
        @Override // kotlinx.coroutines.EventLoop
        public boolean shouldBeProcessedFromContext() {
            return true;
        }

        public Dispatcher() {
            TestCoroutineContext.this = r3;
            EventLoop.incrementUseCount$default(this, false, 1, null);
        }

        @Override // kotlinx.coroutines.Delay
        public Object delay(long j, Continuation<? super Unit> continuation) {
            return Delay.DefaultImpls.delay(this, j, continuation);
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
            TestCoroutineContext.this.enqueue(runnable);
        }

        @Override // kotlinx.coroutines.Delay
        public void scheduleResumeAfterDelay(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
            TestCoroutineContext.this.postDelayed(new TestCoroutineContext$Dispatcher$scheduleResumeAfterDelay$$inlined$Runnable$1(this, cancellableContinuation), j);
        }

        @Override // kotlinx.coroutines.Delay
        public DisposableHandle invokeOnTimeout(long j, Runnable runnable) {
            return new TestCoroutineContext$Dispatcher$invokeOnTimeout$1(this, TestCoroutineContext.this.postDelayed(runnable, j));
        }

        @Override // kotlinx.coroutines.EventLoop
        public long processNextEvent() {
            return TestCoroutineContext.this.processNextEvent();
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        public String toString() {
            return "Dispatcher(" + TestCoroutineContext.this + ')';
        }
    }
}
