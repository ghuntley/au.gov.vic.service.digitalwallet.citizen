package com.jakewharton.rxbinding2.internal;

import io.reactivex.functions.Predicate;
import java.util.concurrent.Callable;

public final class Functions {
    private static final Always ALWAYS_TRUE;
    public static final Callable<Boolean> CALLABLE_ALWAYS_TRUE;
    public static final Predicate<Object> PREDICATE_ALWAYS_TRUE;

    static {
        Always always = new Always(true);
        ALWAYS_TRUE = always;
        CALLABLE_ALWAYS_TRUE = always;
        PREDICATE_ALWAYS_TRUE = always;
    }

    private static final class Always implements Callable<Boolean>, Predicate<Object> {
        private final Boolean value;

        Always(Boolean bool) {
            this.value = bool;
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() {
            return this.value;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return this.value.booleanValue();
        }
    }

    private Functions() {
        throw new AssertionError("No instances.");
    }
}
