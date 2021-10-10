package com.google.android.play.core.internal;

import com.google.android.play.core.listener.StateUpdatedListener;
import java.util.HashSet;
import java.util.Set;

public final class af<StateT> {
    protected final Set<StateUpdatedListener<StateT>> a = new HashSet();

    public final synchronized void a(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.a.add(stateUpdatedListener);
    }

    public final synchronized void b(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.a.remove(stateUpdatedListener);
    }

    public final synchronized void c(StateT statet) {
        for (StateUpdatedListener<StateT> stateUpdatedListener : this.a) {
            stateUpdatedListener.onStateUpdate(statet);
        }
    }
}
