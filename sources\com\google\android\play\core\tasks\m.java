package com.google.android.play.core.tasks;

import com.google.android.play.core.internal.aw;
import java.util.concurrent.Executor;

/* access modifiers changed from: package-private */
public final class m<ResultT> extends Task<ResultT> {
    private final Object a = new Object();
    private final h<ResultT> b = new h<>();
    private boolean c;
    private ResultT d;
    private Exception e;

    m() {
    }

    private final void e() {
        aw.c(this.c, "Task is not yet complete");
    }

    private final void f() {
        aw.c(!this.c, "Task is already complete");
    }

    private final void g() {
        synchronized (this.a) {
            if (this.c) {
                this.b.b(this);
            }
        }
    }

    public final void a(ResultT resultt) {
        synchronized (this.a) {
            f();
            this.c = true;
            this.d = resultt;
        }
        this.b.b(this);
    }

    @Override // com.google.android.play.core.tasks.Task
    public final Task<ResultT> addOnCompleteListener(OnCompleteListener<ResultT> onCompleteListener) {
        this.b.a(new b(TaskExecutors.MAIN_THREAD, onCompleteListener));
        g();
        return this;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final Task<ResultT> addOnCompleteListener(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        this.b.a(new b(executor, onCompleteListener));
        g();
        return this;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final Task<ResultT> addOnFailureListener(OnFailureListener onFailureListener) {
        addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
        return this;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final Task<ResultT> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.b.a(new d(executor, onFailureListener));
        g();
        return this;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final Task<ResultT> addOnSuccessListener(OnSuccessListener<? super ResultT> onSuccessListener) {
        addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
        return this;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final Task<ResultT> addOnSuccessListener(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        this.b.a(new f(executor, onSuccessListener));
        g();
        return this;
    }

    public final boolean b(ResultT resultt) {
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.d = resultt;
            this.b.b(this);
            return true;
        }
    }

    public final void c(Exception exc) {
        synchronized (this.a) {
            f();
            this.c = true;
            this.e = exc;
        }
        this.b.b(this);
    }

    public final boolean d(Exception exc) {
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.e = exc;
            this.b.b(this);
            return true;
        }
    }

    @Override // com.google.android.play.core.tasks.Task
    public final Exception getException() {
        Exception exc;
        synchronized (this.a) {
            exc = this.e;
        }
        return exc;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final ResultT getResult() {
        ResultT resultt;
        synchronized (this.a) {
            e();
            Exception exc = this.e;
            if (exc == null) {
                resultt = this.d;
            } else {
                throw new RuntimeExecutionException(exc);
            }
        }
        return resultt;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final <X extends Throwable> ResultT getResult(Class<X> cls) throws Throwable {
        ResultT resultt;
        synchronized (this.a) {
            e();
            if (!cls.isInstance(this.e)) {
                Exception exc = this.e;
                if (exc == null) {
                    resultt = this.d;
                } else {
                    throw new RuntimeExecutionException(exc);
                }
            } else {
                throw cls.cast(this.e);
            }
        }
        return resultt;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final boolean isComplete() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    @Override // com.google.android.play.core.tasks.Task
    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.a) {
            z = false;
            if (this.c && this.e == null) {
                z = true;
            }
        }
        return z;
    }
}
