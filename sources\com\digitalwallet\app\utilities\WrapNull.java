package com.digitalwallet.app.utilities;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004J\u001a\u0010\b\u001a\u00020\t\"\u0004\b\u0001\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fJ&\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0004\b\u0001\u0010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\n0\u000eR\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/digitalwallet/app/utilities/WrapNull;", "T", "", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "orElse", "", "R", "block", "Lkotlin/Function0;", "use", "Lkotlin/Function1;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: WrapNull.kt */
public final class WrapNull<T> {
    private final T value;

    public WrapNull() {
        this(null, 1, null);
    }

    public WrapNull(T t) {
        this.value = t;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WrapNull(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj);
    }

    public final T getValue() {
        return this.value;
    }

    public final <R> WrapNull<T> use(Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        T t = this.value;
        if (t != null) {
            function1.invoke(t);
        }
        return this;
    }

    public final <R> void orElse(Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        if (this.value == null) {
            function0.invoke();
        }
    }
}
