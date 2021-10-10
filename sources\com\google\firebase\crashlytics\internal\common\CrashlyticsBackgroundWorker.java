package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* access modifiers changed from: package-private */
public class CrashlyticsBackgroundWorker {
    private final Executor executor;
    private ThreadLocal<Boolean> isExecutorThread = new ThreadLocal<>();
    private Task<Void> tail = Tasks.forResult(null);
    private final Object tailLock = new Object();

    public CrashlyticsBackgroundWorker(Executor executor2) {
        this.executor = executor2;
        executor2.execute(new Runnable() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.AnonymousClass1 */

            public void run() {
                CrashlyticsBackgroundWorker.this.isExecutorThread.set(true);
            }
        });
    }

    public Executor getExecutor() {
        return this.executor;
    }

    private boolean isRunningOnThread() {
        return Boolean.TRUE.equals(this.isExecutorThread.get());
    }

    public void checkRunningOnThread() {
        if (!isRunningOnThread()) {
            throw new IllegalStateException("Not running on background worker thread as intended.");
        }
    }

    /* access modifiers changed from: package-private */
    public Task<Void> submit(final Runnable runnable) {
        return submit(new Callable<Void>() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.AnonymousClass2 */

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                runnable.run();
                return null;
            }
        });
    }

    private <T> Continuation<Void, T> newContinuation(final Callable<T> callable) {
        return new Continuation<Void, T>() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.AnonymousClass3 */

            @Override // com.google.android.gms.tasks.Continuation
            public T then(Task<Void> task) throws Exception {
                return (T) callable.call();
            }
        };
    }

    private <T> Task<Void> ignoreResult(Task<T> task) {
        return task.continueWith(this.executor, new Continuation<T, Void>() {
            /* class com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker.AnonymousClass4 */

            @Override // com.google.android.gms.tasks.Continuation
            public Void then(Task<T> task) throws Exception {
                return null;
            }
        });
    }

    public <T> Task<T> submit(Callable<T> callable) {
        Task<T> continueWith;
        synchronized (this.tailLock) {
            continueWith = this.tail.continueWith(this.executor, newContinuation(callable));
            this.tail = ignoreResult(continueWith);
        }
        return continueWith;
    }

    public <T> Task<T> submitTask(Callable<Task<T>> callable) {
        Task<T> continueWithTask;
        synchronized (this.tailLock) {
            continueWithTask = this.tail.continueWithTask(this.executor, newContinuation(callable));
            this.tail = ignoreResult(continueWithTask);
        }
        return continueWithTask;
    }
}
