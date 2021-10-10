package com.google.android.play.core.internal;

public final class cl<T> implements co<T> {
    private co<T> a;

    public static <T> void b(co<T> coVar, co<T> coVar2) {
        br.i(coVar2);
        cl clVar = (cl) coVar;
        if (clVar.a == null) {
            clVar.a = coVar2;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.play.core.internal.co
    public final T a() {
        co<T> coVar = this.a;
        if (coVar != null) {
            return coVar.a();
        }
        throw new IllegalStateException();
    }
}
