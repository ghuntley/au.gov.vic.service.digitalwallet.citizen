package com.google.android.play.core.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class ce extends WeakReference<Throwable> {
    private final int a;

    public ce(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            ce ceVar = (ce) obj;
            return this.a == ceVar.a && get() == ceVar.get();
        }
    }

    public final int hashCode() {
        return this.a;
    }
}
