package com.google.android.play.core.internal;

public final class bp extends RuntimeException {
    public bp(String str) {
        super(str);
    }

    public bp(Throwable th) {
        super("Failed to initialize FileStorage", th);
    }
}
