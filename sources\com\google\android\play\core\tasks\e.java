package com.google.android.play.core.tasks;

final class e implements Runnable {
    final /* synthetic */ Task a;
    final /* synthetic */ f b;

    e(f fVar, Task task) {
        this.b = fVar;
        this.a = task;
    }

    public final void run() {
        synchronized (this.b.b) {
            if (this.b.c != null) {
                this.b.c.onSuccess(this.a.getResult());
            }
        }
    }
}
