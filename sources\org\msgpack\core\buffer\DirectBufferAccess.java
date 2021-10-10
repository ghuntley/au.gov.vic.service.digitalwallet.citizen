package org.msgpack.core.buffer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import net.openid.appauth.AuthorizationRequest;

/* access modifiers changed from: package-private */
public class DirectBufferAccess {
    static Constructor byteBufferConstructor;
    static DirectBufferConstructorType directBufferConstructorType;
    static Class<?> directByteBufferClass;
    static Method mClean;
    static Method mCleaner;
    static Method mGetAddress;
    static Method memoryBlockWrapFromJni;

    /* access modifiers changed from: package-private */
    public enum DirectBufferConstructorType {
        ARGS_LONG_INT_REF,
        ARGS_LONG_INT,
        ARGS_INT_INT,
        ARGS_MB_INT_INT
    }

    private DirectBufferAccess() {
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:3:0x0011 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:5:0x0026 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v11, types: [org.msgpack.core.buffer.DirectBufferAccess$DirectBufferConstructorType] */
    /* JADX WARN: Type inference failed for: r2v12, types: [org.msgpack.core.buffer.DirectBufferAccess$DirectBufferConstructorType] */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|11|(2:13|14)(2:15|16)) */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004c, code lost:
        r0 = java.lang.Class.forName("java.nio.MemoryBlock");
        r1 = r0.getDeclaredMethod("wrapFromJni", java.lang.Integer.TYPE, java.lang.Long.TYPE);
        r1.setAccessible(true);
        r6 = org.msgpack.core.buffer.DirectBufferAccess.directByteBufferClass;
        r2 = new java.lang.Class[r2];
        r2[0] = r0;
        r2[1] = java.lang.Integer.TYPE;
        r2[2] = java.lang.Integer.TYPE;
        r0 = r6.getDeclaredConstructor(r2);
        r2 = org.msgpack.core.buffer.DirectBufferAccess.DirectBufferConstructorType.ARGS_MB_INT_INT;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0026 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0039 */
    static {
        try {
            Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass("java.nio.DirectByteBuffer");
            directByteBufferClass = loadClass;
            Method method = null;
            int i = 3;
            Constructor<?> constructor = loadClass.getDeclaredConstructor(Long.TYPE, Integer.TYPE, Object.class);
            i = DirectBufferConstructorType.ARGS_LONG_INT_REF;
            DirectBufferConstructorType directBufferConstructorType2 = i;
            constructor = directByteBufferClass.getDeclaredConstructor(Long.TYPE, Integer.TYPE);
            i = DirectBufferConstructorType.ARGS_LONG_INT;
            directBufferConstructorType2 = i;
            constructor = directByteBufferClass.getDeclaredConstructor(Integer.TYPE, Integer.TYPE);
            directBufferConstructorType2 = DirectBufferConstructorType.ARGS_INT_INT;
            byteBufferConstructor = constructor;
            directBufferConstructorType = directBufferConstructorType2;
            memoryBlockWrapFromJni = method;
            if (constructor != null) {
                constructor.setAccessible(true);
                Method declaredMethod = directByteBufferClass.getDeclaredMethod(AuthorizationRequest.Scope.ADDRESS, new Class[0]);
                mGetAddress = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = directByteBufferClass.getDeclaredMethod("cleaner", new Class[0]);
                mCleaner = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = mCleaner.getReturnType().getDeclaredMethod("clean", new Class[0]);
                mClean = declaredMethod3;
                declaredMethod3.setAccessible(true);
                return;
            }
            throw new RuntimeException("Constructor of DirectByteBuffer is not found");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static long getAddress(Object obj) {
        try {
            return ((Long) mGetAddress.invoke(obj, new Object[0])).longValue();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    static void clean(Object obj) {
        try {
            mClean.invoke(mCleaner.invoke(obj, new Object[0]), new Object[0]);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    static boolean isDirectByteBufferInstance(Object obj) {
        return directByteBufferClass.isInstance(obj);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: org.msgpack.core.buffer.DirectBufferAccess$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[DirectBufferConstructorType.values().length];
            $SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType = iArr;
            iArr[DirectBufferConstructorType.ARGS_LONG_INT_REF.ordinal()] = 1;
            $SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType[DirectBufferConstructorType.ARGS_LONG_INT.ordinal()] = 2;
            $SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType[DirectBufferConstructorType.ARGS_INT_INT.ordinal()] = 3;
            try {
                $SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType[DirectBufferConstructorType.ARGS_MB_INT_INT.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    static ByteBuffer newByteBuffer(long j, int i, int i2, ByteBuffer byteBuffer) {
        try {
            int i3 = AnonymousClass1.$SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType[directBufferConstructorType.ordinal()];
            if (i3 == 1) {
                return (ByteBuffer) byteBufferConstructor.newInstance(Long.valueOf(j + ((long) i)), Integer.valueOf(i2), byteBuffer);
            } else if (i3 == 2) {
                return (ByteBuffer) byteBufferConstructor.newInstance(Long.valueOf(j + ((long) i)), Integer.valueOf(i2));
            } else if (i3 == 3) {
                return (ByteBuffer) byteBufferConstructor.newInstance(Integer.valueOf(((int) j) + i), Integer.valueOf(i2));
            } else if (i3 == 4) {
                return (ByteBuffer) byteBufferConstructor.newInstance(memoryBlockWrapFromJni.invoke(null, Long.valueOf(j + ((long) i)), Integer.valueOf(i2)), Integer.valueOf(i2), 0);
            } else {
                throw new IllegalStateException("Unexpected value");
            }
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }
}
