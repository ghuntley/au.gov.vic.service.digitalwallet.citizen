package net.minidev.asm;

import java.lang.reflect.Method;

/* access modifiers changed from: package-private */
public class DynamicClassLoader extends ClassLoader {
    private static final String BEAN_AC = BeansAccess.class.getName();
    private static final Class<?>[] DEF_CLASS_SIG = {String.class, byte[].class, Integer.TYPE, Integer.TYPE};

    DynamicClassLoader(ClassLoader classLoader) {
        super(classLoader);
    }

    public static <T> Class<T> directLoad(Class<? extends T> cls, String str, byte[] bArr) {
        return (Class<T>) new DynamicClassLoader(cls.getClassLoader()).defineClass(str, bArr);
    }

    public static <T> T directInstance(Class<? extends T> cls, String str, byte[] bArr) throws InstantiationException, IllegalAccessException {
        return (T) directLoad(cls, str, bArr).newInstance();
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.ClassLoader
    public synchronized Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        if (str.equals(BEAN_AC)) {
            return BeansAccess.class;
        }
        return super.loadClass(str, z);
    }

    /* access modifiers changed from: package-private */
    public Class<?> defineClass(String str, byte[] bArr) throws ClassFormatError {
        try {
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("defineClass", DEF_CLASS_SIG);
            declaredMethod.setAccessible(true);
            return (Class) declaredMethod.invoke(getParent(), str, bArr, 0, Integer.valueOf(bArr.length));
        } catch (Exception unused) {
            return defineClass(str, bArr, 0, bArr.length);
        }
    }
}
