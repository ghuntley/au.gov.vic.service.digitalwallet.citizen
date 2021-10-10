package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

final class d<ResultT> implements g<ResultT> {
    private final Executor a;
    private final Object b = new Object();
    private final OnFailureListener c;

    public d(Executor executor, OnFailureListener onFailureListener) {
        this.a = executor;
        this.c = onFailureListener;
    }

    @Override // com.google.android.play.core.tasks.g
    public final void a(Task<ResultT> task) {
        if (!task.isSuccessful()) {
            synchronized (this.b) {
                if (this.c != null) {
                    this.a.execute(new c(this, task));
                }
            }
        }
    }
}
