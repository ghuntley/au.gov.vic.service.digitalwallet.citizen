package com.google.android.play.core.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;

public final class bq<T> {
    private final Object a;
    private final Field b;
    private final Class<T> c;

    bq(Object obj, Field field, Class<T> cls) {
        this.a = obj;
        this.b = field;
        this.c = cls;
    }

    bq(Object obj, Field field, Class cls, byte[] bArr) {
        this(obj, field, Array.newInstance(cls, 0).getClass());
    }

    private Class f() {
        return c().getType().getComponentType();
    }

    public final T a() {
        try {
            return this.c.cast(this.b.get(this.a));
        } catch (Exception e) {
            throw new bs(String.format("Failed to get value of field %s of type %s on object of type %s", this.b.getName(), this.a.getClass().getName(), this.c.getName()), e);
        }
    }

    public final void b(T t) {
        try {
            this.b.set(this.a, t);
        } catch (Exception e) {
            throw new bs(String.format("Failed to set value of field %s of type %s on object of type %s", this.b.getName(), this.a.getClass().getName(), this.c.getName()), e);
        }
    }

    /* access modifiers changed from: protected */
    public final Field c() {
        return this.b;
    }

    public void d(Collection collection) {
        Object[] objArr = (Object[]) a();
        int length = objArr == null ? 0 : objArr.length;
        Object[] objArr2 = (Object[]) Array.newInstance(f(), collection.size() + length);
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        }
        for (Object obj : collection) {
            objArr2[length] = obj;
            length++;
        }
        b(objArr2);
    }

    public void e(Collection collection) {
        Object[] objArr = (Object[]) a();
        int i = 0;
        Object[] objArr2 = (Object[]) Array.newInstance(f(), (objArr == null ? 0 : objArr.length) + collection.size());
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, collection.size(), objArr.length);
        }
        for (Object obj : collection) {
            objArr2[i] = obj;
            i++;
        }
        b(objArr2);
    }
}
