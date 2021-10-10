package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* compiled from: storage.kt */
public final class StorageKt {
    public static final <T> T getValue(NotNullLazyValue<? extends T> notNullLazyValue, Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(notNullLazyValue, "$this$getValue");
        Intrinsics.checkNotNullParameter(kProperty, "p");
        return (T) notNullLazyValue.invoke();
    }

    public static final <T> T getValue(NullableLazyValue<? extends T> nullableLazyValue, Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(nullableLazyValue, "$this$getValue");
        Intrinsics.checkNotNullParameter(kProperty, "p");
        return (T) nullableLazyValue.invoke();
    }
}
