package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class Tasks {

    /* access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
    public interface zza<T> extends OnCanceledListener, OnFailureListener, OnSuccessListener<T> {
    }

    public static <TResult> Task<TResult> forResult(TResult tresult) {
        zzu zzu = new zzu();
        zzu.zza((Object) tresult);
        return zzu;
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
    public static final class zzb implements zza {
        private final CountDownLatch zza;

        private zzb() {
            this.zza = new CountDownLatch(1);
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public final void onSuccess(Object obj) {
            this.zza.countDown();
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(Exception exc) {
            this.zza.countDown();
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public final void onCanceled() {
            this.zza.countDown();
        }

        public final void zza() throws InterruptedException {
            this.zza.await();
        }

        public final boolean zza(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.zza.await(j, timeUnit);
        }

        /* synthetic */ zzb(zzy zzy) {
            this();
        }
    }

    public static <TResult> Task<TResult> forException(Exception exc) {
        zzu zzu = new zzu();
        zzu.zza(exc);
        return zzu;
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
    public static final class zzc implements zza {
        private final Object zza = new Object();
        private final int zzb;
        private final zzu<Void> zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private Exception zzg;
        private boolean zzh;

        public zzc(int i, zzu<Void> zzu) {
            this.zzb = i;
            this.zzc = zzu;
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(Exception exc) {
            synchronized (this.zza) {
                this.zze++;
                this.zzg = exc;
                zza();
            }
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public final void onSuccess(Object obj) {
            synchronized (this.zza) {
                this.zzd++;
                zza();
            }
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public final void onCanceled() {
            synchronized (this.zza) {
                this.zzf++;
                this.zzh = true;
                zza();
            }
        }

        private final void zza() {
            if (this.zzd + this.zze + this.zzf != this.zzb) {
                return;
            }
            if (this.zzg != null) {
                zzu<Void> zzu = this.zzc;
                int i = this.zze;
                int i2 = this.zzb;
                StringBuilder sb = new StringBuilder(54);
                sb.append(i);
                sb.append(" out of ");
                sb.append(i2);
                sb.append(" underlying tasks failed");
                zzu.zza(new ExecutionException(sb.toString(), this.zzg));
            } else if (this.zzh) {
                this.zzc.zza();
            } else {
                this.zzc.zza((Void) null);
            }
        }
    }

    public static <TResult> Task<TResult> forCanceled() {
        zzu zzu = new zzu();
        zzu.zza();
        return zzu;
    }

    @Deprecated
    public static <TResult> Task<TResult> call(Callable<TResult> callable) {
        return call(TaskExecutors.MAIN_THREAD, callable);
    }

    @Deprecated
    public static <TResult> Task<TResult> call(Executor executor, Callable<TResult> callable) {
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(callable, "Callback must not be null");
        zzu zzu = new zzu();
        executor.execute(new zzy(zzu, callable));
        return zzu;
    }

    public static <TResult> TResult await(Task<TResult> task) throws ExecutionException, InterruptedException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        if (task.isComplete()) {
            return (TResult) zza(task);
        }
        zzb zzb2 = new zzb(null);
        zza(task, zzb2);
        zzb2.zza();
        return (TResult) zza(task);
    }

    public static <TResult> TResult await(Task<TResult> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return (TResult) zza(task);
        }
        zzb zzb2 = new zzb(null);
        zza(task, zzb2);
        if (zzb2.zza(j, timeUnit)) {
            return (TResult) zza(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static Task<Void> whenAll(Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult(null);
        }
        Iterator<? extends Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull((Task) it.next(), "null tasks are not accepted");
        }
        zzu zzu = new zzu();
        zzc zzc2 = new zzc(collection.size(), zzu);
        Iterator<? extends Task<?>> it2 = collection.iterator();
        while (it2.hasNext()) {
            zza((Task) it2.next(), zzc2);
        }
        return zzu;
    }

    public static Task<Void> whenAll(Task<?>... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult(null);
        }
        return whenAll(Arrays.asList(taskArr));
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult(Collections.emptyList());
        }
        return whenAll(collection).continueWith(new zzaa(collection));
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Task<?>... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult(Collections.emptyList());
        }
        return whenAllSuccess(Arrays.asList(taskArr));
    }

    public static Task<List<Task<?>>> whenAllComplete(Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult(Collections.emptyList());
        }
        return whenAll(collection).continueWithTask(new zzz(collection));
    }

    public static Task<List<Task<?>>> whenAllComplete(Task<?>... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult(Collections.emptyList());
        }
        return whenAllComplete(Arrays.asList(taskArr));
    }

    private static <TResult> TResult zza(Task<TResult> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.getException());
    }

    private static <T> void zza(Task<T> task, zza<? super T> zza2) {
        task.addOnSuccessListener(TaskExecutors.zza, zza2);
        task.addOnFailureListener(TaskExecutors.zza, zza2);
        task.addOnCanceledListener(TaskExecutors.zza, zza2);
    }

    private Tasks() {
    }
}
