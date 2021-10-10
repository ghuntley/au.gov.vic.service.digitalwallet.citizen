package org.msgpack.core.buffer;

import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.msgpack.core.Preconditions;
import sun.misc.Unsafe;

public class MessageBuffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ARRAY_BYTE_BASE_OFFSET;
    private static final String BIGENDIAN_MESSAGE_BUFFER = "org.msgpack.core.buffer.MessageBufferBE";
    private static final String DEFAULT_MESSAGE_BUFFER = "org.msgpack.core.buffer.MessageBuffer";
    private static final String UNIVERSAL_MESSAGE_BUFFER = "org.msgpack.core.buffer.MessageBufferU";
    static final boolean isUniversalBuffer;
    private static final Constructor<?> mbArrConstructor;
    private static final Constructor<?> mbBBConstructor;
    static final Unsafe unsafe;
    protected final long address;
    protected final Object base;
    protected final ByteBuffer reference;
    protected final int size;

    /* JADX WARNING: Code restructure failed: missing block: B:66:0x011c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x011d, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x011f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0120, code lost:
        r1 = false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0078 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x011c A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0013] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x016a  */
    static {
        boolean z;
        Throwable th;
        Exception e;
        boolean z2;
        boolean z3;
        String str = DEFAULT_MESSAGE_BUFFER;
        String str2 = UNIVERSAL_MESSAGE_BUFFER;
        int i = 16;
        Unsafe unsafe2 = null;
        try {
            String property = System.getProperty("java.specification.version", "");
            int indexOf = property.indexOf(46);
            if (indexOf != -1) {
                try {
                    int parseInt = Integer.parseInt(property.substring(0, indexOf));
                    int parseInt2 = Integer.parseInt(property.substring(indexOf + 1));
                    if (parseInt > 1 || (parseInt == 1 && parseInt2 >= 7)) {
                        z2 = true;
                        if (Class.forName("sun.misc.Unsafe") != null) {
                            z3 = true;
                            z = !Boolean.parseBoolean(System.getProperty("msgpack.universal-buffer", "false")) || System.getProperty("java.runtime.name", "").toLowerCase().contains(AbstractSpiCall.ANDROID_CLIENT_TYPE) || (System.getProperty("com.google.appengine.runtime.version") != null) || !z2 || !z3;
                            if (!z) {
                                try {
                                    Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
                                    declaredField.setAccessible(true);
                                    Unsafe unsafe3 = (Unsafe) declaredField.get(null);
                                    if (unsafe3 != null) {
                                        try {
                                            i = unsafe3.arrayBaseOffset(byte[].class);
                                            int arrayIndexScale = unsafe3.arrayIndexScale(byte[].class);
                                            if (arrayIndexScale == 1) {
                                                unsafe2 = unsafe3;
                                            } else {
                                                throw new IllegalStateException("Byte array index scale must be 1, but is " + arrayIndexScale);
                                            }
                                        } catch (Exception e2) {
                                            e = e2;
                                            unsafe2 = unsafe3;
                                            try {
                                                e.printStackTrace(System.err);
                                                unsafe = unsafe2;
                                                ARRAY_BYTE_BASE_OFFSET = 16;
                                                isUniversalBuffer = true;
                                                try {
                                                    Class<?> cls = Class.forName(str2);
                                                    Constructor<?> declaredConstructor = cls.getDeclaredConstructor(byte[].class, Integer.TYPE, Integer.TYPE);
                                                    declaredConstructor.setAccessible(true);
                                                    mbArrConstructor = declaredConstructor;
                                                    Constructor<?> declaredConstructor2 = cls.getDeclaredConstructor(ByteBuffer.class);
                                                    declaredConstructor2.setAccessible(true);
                                                    mbBBConstructor = declaredConstructor2;
                                                    return;
                                                } catch (Exception e3) {
                                                    e3.printStackTrace(System.err);
                                                    throw new RuntimeException(e3);
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                unsafe = unsafe2;
                                                ARRAY_BYTE_BASE_OFFSET = 16;
                                                isUniversalBuffer = z;
                                                if (!z) {
                                                    if (!(ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN)) {
                                                        str = BIGENDIAN_MESSAGE_BUFFER;
                                                    }
                                                    str2 = str;
                                                }
                                                try {
                                                    Class<?> cls2 = Class.forName(str2);
                                                    Constructor<?> declaredConstructor3 = cls2.getDeclaredConstructor(byte[].class, Integer.TYPE, Integer.TYPE);
                                                    declaredConstructor3.setAccessible(true);
                                                    mbArrConstructor = declaredConstructor3;
                                                    Constructor<?> declaredConstructor4 = cls2.getDeclaredConstructor(ByteBuffer.class);
                                                    declaredConstructor4.setAccessible(true);
                                                    mbBBConstructor = declaredConstructor4;
                                                    throw th;
                                                } catch (Exception e4) {
                                                    e4.printStackTrace(System.err);
                                                    throw new RuntimeException(e4);
                                                }
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            unsafe2 = unsafe3;
                                            unsafe = unsafe2;
                                            ARRAY_BYTE_BASE_OFFSET = 16;
                                            isUniversalBuffer = z;
                                            if (!z) {
                                            }
                                            Class<?> cls22 = Class.forName(str2);
                                            Constructor<?> declaredConstructor32 = cls22.getDeclaredConstructor(byte[].class, Integer.TYPE, Integer.TYPE);
                                            declaredConstructor32.setAccessible(true);
                                            mbArrConstructor = declaredConstructor32;
                                            Constructor<?> declaredConstructor42 = cls22.getDeclaredConstructor(ByteBuffer.class);
                                            declaredConstructor42.setAccessible(true);
                                            mbBBConstructor = declaredConstructor42;
                                            throw th;
                                        }
                                    } else {
                                        throw new RuntimeException("Unsafe is unavailable");
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    e.printStackTrace(System.err);
                                    unsafe = unsafe2;
                                    ARRAY_BYTE_BASE_OFFSET = 16;
                                    isUniversalBuffer = true;
                                    Class<?> cls3 = Class.forName(str2);
                                    Constructor<?> declaredConstructor5 = cls3.getDeclaredConstructor(byte[].class, Integer.TYPE, Integer.TYPE);
                                    declaredConstructor5.setAccessible(true);
                                    mbArrConstructor = declaredConstructor5;
                                    Constructor<?> declaredConstructor22 = cls3.getDeclaredConstructor(ByteBuffer.class);
                                    declaredConstructor22.setAccessible(true);
                                    mbBBConstructor = declaredConstructor22;
                                    return;
                                }
                            }
                            unsafe = unsafe2;
                            ARRAY_BYTE_BASE_OFFSET = i;
                            isUniversalBuffer = z;
                            if (!z) {
                                if (!(ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN)) {
                                    str = BIGENDIAN_MESSAGE_BUFFER;
                                }
                                str2 = str;
                            }
                            Class<?> cls4 = Class.forName(str2);
                            Constructor<?> declaredConstructor6 = cls4.getDeclaredConstructor(byte[].class, Integer.TYPE, Integer.TYPE);
                            declaredConstructor6.setAccessible(true);
                            mbArrConstructor = declaredConstructor6;
                            Constructor<?> declaredConstructor7 = cls4.getDeclaredConstructor(ByteBuffer.class);
                            declaredConstructor7.setAccessible(true);
                            mbBBConstructor = declaredConstructor7;
                        }
                        z3 = false;
                        if (!Boolean.parseBoolean(System.getProperty("msgpack.universal-buffer", "false"))) {
                        }
                        if (!z) {
                        }
                        unsafe = unsafe2;
                        ARRAY_BYTE_BASE_OFFSET = i;
                        isUniversalBuffer = z;
                        if (!z) {
                        }
                        Class<?> cls42 = Class.forName(str2);
                        Constructor<?> declaredConstructor62 = cls42.getDeclaredConstructor(byte[].class, Integer.TYPE, Integer.TYPE);
                        declaredConstructor62.setAccessible(true);
                        mbArrConstructor = declaredConstructor62;
                        Constructor<?> declaredConstructor72 = cls42.getDeclaredConstructor(ByteBuffer.class);
                        declaredConstructor72.setAccessible(true);
                        mbBBConstructor = declaredConstructor72;
                    }
                } catch (NumberFormatException e6) {
                    e6.printStackTrace(System.err);
                }
            }
            z2 = false;
            if (Class.forName("sun.misc.Unsafe") != null) {
            }
        } catch (Exception unused) {
        } catch (Throwable th4) {
        }
        z3 = false;
        if (!Boolean.parseBoolean(System.getProperty("msgpack.universal-buffer", "false"))) {
        }
        if (!z) {
        }
        unsafe = unsafe2;
        ARRAY_BYTE_BASE_OFFSET = i;
        isUniversalBuffer = z;
        if (!z) {
        }
        try {
            Class<?> cls422 = Class.forName(str2);
            Constructor<?> declaredConstructor622 = cls422.getDeclaredConstructor(byte[].class, Integer.TYPE, Integer.TYPE);
            declaredConstructor622.setAccessible(true);
            mbArrConstructor = declaredConstructor622;
            Constructor<?> declaredConstructor722 = cls422.getDeclaredConstructor(ByteBuffer.class);
            declaredConstructor722.setAccessible(true);
            mbBBConstructor = declaredConstructor722;
        } catch (Exception e7) {
            e7.printStackTrace(System.err);
            throw new RuntimeException(e7);
        }
    }

    public static MessageBuffer allocate(int i) {
        if (i >= 0) {
            return wrap(new byte[i]);
        }
        throw new IllegalArgumentException("size must not be negative");
    }

    public static MessageBuffer wrap(byte[] bArr) {
        return newMessageBuffer(bArr, 0, bArr.length);
    }

    public static MessageBuffer wrap(byte[] bArr, int i, int i2) {
        return newMessageBuffer(bArr, i, i2);
    }

    public static MessageBuffer wrap(ByteBuffer byteBuffer) {
        return newMessageBuffer(byteBuffer);
    }

    private static MessageBuffer newMessageBuffer(byte[] bArr, int i, int i2) {
        Preconditions.checkNotNull(bArr);
        return newInstance(mbArrConstructor, bArr, Integer.valueOf(i), Integer.valueOf(i2));
    }

    private static MessageBuffer newMessageBuffer(ByteBuffer byteBuffer) {
        Preconditions.checkNotNull(byteBuffer);
        return newInstance(mbBBConstructor, byteBuffer);
    }

    private static MessageBuffer newInstance(Constructor<?> constructor, Object... objArr) {
        try {
            return (MessageBuffer) constructor.newInstance(objArr);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException(e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            } else if (e3.getCause() instanceof Error) {
                throw ((Error) e3.getCause());
            } else {
                throw new IllegalStateException(e3.getCause());
            }
        }
    }

    public static void releaseBuffer(MessageBuffer messageBuffer) {
        if (!isUniversalBuffer && !messageBuffer.hasArray()) {
            if (DirectBufferAccess.isDirectByteBufferInstance(messageBuffer.reference)) {
                DirectBufferAccess.clean(messageBuffer.reference);
            } else {
                unsafe.freeMemory(messageBuffer.address);
            }
        }
    }

    MessageBuffer(byte[] bArr, int i, int i2) {
        this.base = bArr;
        this.address = (long) (ARRAY_BYTE_BASE_OFFSET + i);
        this.size = i2;
        this.reference = null;
    }

    MessageBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.isDirect()) {
            if (!isUniversalBuffer) {
                this.base = null;
                this.address = DirectBufferAccess.getAddress(byteBuffer) + ((long) byteBuffer.position());
                this.size = byteBuffer.remaining();
                this.reference = byteBuffer;
                return;
            }
            throw new UnsupportedOperationException("Cannot create MessageBuffer from a DirectBuffer on this platform");
        } else if (byteBuffer.hasArray()) {
            this.base = byteBuffer.array();
            this.address = (long) (ARRAY_BYTE_BASE_OFFSET + byteBuffer.arrayOffset() + byteBuffer.position());
            this.size = byteBuffer.remaining();
            this.reference = null;
        } else {
            throw new IllegalArgumentException("Only the array-backed ByteBuffer or DirectBuffer is supported");
        }
    }

    protected MessageBuffer(Object obj, long j, int i) {
        this.base = obj;
        this.address = j;
        this.size = i;
        this.reference = null;
    }

    public int size() {
        return this.size;
    }

    public MessageBuffer slice(int i, int i2) {
        if (i == 0 && i2 == size()) {
            return this;
        }
        Preconditions.checkArgument(i + i2 <= size());
        return new MessageBuffer(this.base, this.address + ((long) i), i2);
    }

    public byte getByte(int i) {
        return unsafe.getByte(this.base, this.address + ((long) i));
    }

    public boolean getBoolean(int i) {
        return unsafe.getBoolean(this.base, this.address + ((long) i));
    }

    public short getShort(int i) {
        return Short.reverseBytes(unsafe.getShort(this.base, this.address + ((long) i)));
    }

    public int getInt(int i) {
        return Integer.reverseBytes(unsafe.getInt(this.base, this.address + ((long) i)));
    }

    public float getFloat(int i) {
        return Float.intBitsToFloat(getInt(i));
    }

    public long getLong(int i) {
        return Long.reverseBytes(unsafe.getLong(this.base, this.address + ((long) i)));
    }

    public double getDouble(int i) {
        return Double.longBitsToDouble(getLong(i));
    }

    public void getBytes(int i, byte[] bArr, int i2, int i3) {
        unsafe.copyMemory(this.base, this.address + ((long) i), bArr, (long) (ARRAY_BYTE_BASE_OFFSET + i2), (long) i3);
    }

    public void getBytes(int i, int i2, ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() >= i2) {
            byteBuffer.put(sliceAsByteBuffer(i, i2));
            return;
        }
        throw new BufferOverflowException();
    }

    public void putByte(int i, byte b) {
        unsafe.putByte(this.base, this.address + ((long) i), b);
    }

    public void putBoolean(int i, boolean z) {
        unsafe.putBoolean(this.base, this.address + ((long) i), z);
    }

    public void putShort(int i, short s) {
        unsafe.putShort(this.base, this.address + ((long) i), Short.reverseBytes(s));
    }

    public void putInt(int i, int i2) {
        unsafe.putInt(this.base, this.address + ((long) i), Integer.reverseBytes(i2));
    }

    public void putFloat(int i, float f) {
        putInt(i, Float.floatToRawIntBits(f));
    }

    public void putLong(int i, long j) {
        unsafe.putLong(this.base, ((long) i) + this.address, Long.reverseBytes(j));
    }

    public void putDouble(int i, double d) {
        putLong(i, Double.doubleToRawLongBits(d));
    }

    public void putBytes(int i, byte[] bArr, int i2, int i3) {
        unsafe.copyMemory(bArr, (long) (ARRAY_BYTE_BASE_OFFSET + i2), this.base, this.address + ((long) i), (long) i3);
    }

    public void putByteBuffer(int i, ByteBuffer byteBuffer, int i2) {
        if (byteBuffer.isDirect()) {
            unsafe.copyMemory((Object) null, DirectBufferAccess.getAddress(byteBuffer) + ((long) byteBuffer.position()), this.base, this.address + ((long) i), (long) i2);
            byteBuffer.position(byteBuffer.position() + i2);
        } else if (byteBuffer.hasArray()) {
            unsafe.copyMemory(byteBuffer.array(), (long) (ARRAY_BYTE_BASE_OFFSET + byteBuffer.position()), this.base, this.address + ((long) i), (long) i2);
            byteBuffer.position(byteBuffer.position() + i2);
        } else if (hasArray()) {
            byteBuffer.get((byte[]) this.base, i, i2);
        } else {
            for (int i3 = 0; i3 < i2; i3++) {
                unsafe.putByte(this.base, this.address + ((long) i), byteBuffer.get());
            }
        }
    }

    public void putMessageBuffer(int i, MessageBuffer messageBuffer, int i2, int i3) {
        unsafe.copyMemory(messageBuffer.base, messageBuffer.address + ((long) i2), this.base, ((long) i) + this.address, (long) i3);
    }

    public ByteBuffer sliceAsByteBuffer(int i, int i2) {
        if (hasArray()) {
            return ByteBuffer.wrap((byte[]) this.base, (int) ((this.address - ((long) ARRAY_BYTE_BASE_OFFSET)) + ((long) i)), i2);
        }
        return DirectBufferAccess.newByteBuffer(this.address, i, i2, this.reference);
    }

    public ByteBuffer sliceAsByteBuffer() {
        return sliceAsByteBuffer(0, size());
    }

    public boolean hasArray() {
        return this.base != null;
    }

    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        unsafe.copyMemory(this.base, this.address, bArr, (long) ARRAY_BYTE_BASE_OFFSET, (long) size());
        return bArr;
    }

    public byte[] array() {
        return (byte[]) this.base;
    }

    public int arrayOffset() {
        return ((int) this.address) - ARRAY_BYTE_BASE_OFFSET;
    }

    public void copyTo(int i, MessageBuffer messageBuffer, int i2, int i3) {
        unsafe.copyMemory(this.base, this.address + ((long) i), messageBuffer.base, ((long) i2) + messageBuffer.address, (long) i3);
    }

    public String toHexString(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = i; i3 < i2; i3++) {
            if (i3 != i) {
                sb.append(" ");
            }
            sb.append(String.format("%02x", Byte.valueOf(getByte(i3))));
        }
        return sb.toString();
    }
}
