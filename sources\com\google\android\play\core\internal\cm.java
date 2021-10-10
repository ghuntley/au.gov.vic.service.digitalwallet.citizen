package com.google.android.play.core.internal;

public final class cm<T> implements co, ck {
    private static final Object a = new Object();
    private volatile co<T> b;
    private volatile Object c = a;

    private cm(co<T> coVar) {
        this.b = coVar;
    }

    public static <P extends co<T>, T> co<T> b(P p) {
        br.i(p);
        return p instanceof cm ? p : new cm(p);
    }

    public static <P extends co<T>, T> ck<T> c(P p) {
        if (p instanceof ck) {
            return (ck) p;
        }
        br.i(p);
        return new cm(p);
    }

    @Override // com.google.android.play.core.internal.ck, com.google.android.play.core.internal.co
    public final T a() {
        T t = (T) this.c;
        Object obj = a;
        if (t == obj) {
            synchronized (this) {
                t = this.c;
                if (t == obj) {
                    t = this.b.a();
                    Object obj2 = this.c;
                    if (obj2 != obj && !(obj2 instanceof cn)) {
                        if (obj2 != t) {
                            String valueOf = String.valueOf(obj2);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.c = t;
                    this.b = null;
                }
            }
        }
        return t;
    }
}
