package com.google.android.play.core.tasks;

final class a implements Runnable {
    final /* synthetic */ Task a;
    final /* synthetic */ b b;

    a(b bVar, Task task) {
        this.b = bVar;
        this.a = task;
    }

    public final void run() {
        synchronized (this.b.b) {
            if (this.b.c != null) {
                this.b.c.onComplete(this.a);
            }
        }
    }
}
