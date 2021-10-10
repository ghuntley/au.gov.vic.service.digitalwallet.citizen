package net.openid.appauth;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Objects;

public final class Preconditions {
    public static <T> T checkNotNull(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static String checkNotEmpty(String str, Object obj) {
        checkNotNull(str, obj);
        checkArgument(!TextUtils.isEmpty(str), obj);
        return str;
    }

    public static <T extends Collection<?>> T checkCollectionNotEmpty(T t, Object obj) {
        checkNotNull(t, obj);
        checkArgument(!t.isEmpty(), obj);
        return t;
    }

    public static String checkNullOrNotEmpty(String str, Object obj) {
        if (str != null) {
            checkNotEmpty(str, obj);
        }
        return str;
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    private Preconditions() {
        throw new IllegalStateException("This type is not intended to be instantiated");
    }
}
