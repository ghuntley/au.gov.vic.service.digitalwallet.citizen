package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* access modifiers changed from: package-private */
public final class f<ResultT> implements g<ResultT> {
    private final Executor a;
    private final Object b = new Object();
    private final OnSuccessListener<? super ResultT> c;

    public f(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        this.a = executor;
        this.c = onSuccessListener;
    }

    @Override // com.google.android.play.core.tasks.g
    public final void a(Task<ResultT> task) {
        if (task.isSuccessful()) {
            synchronized (this.b) {
                if (this.c != null) {
                    this.a.execute(new e(this, task));
                }
            }
        }
    }
}
