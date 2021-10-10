package com.google.android.gms.internal.gtm;

public enum zzrm {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzps.class, zzps.class, zzps.zzavx),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    private final Class<?> zzbbv;
    private final Class<?> zzbbw;
    private final Object zzbbx;

    private zzrm(Class cls, Class cls2, Object obj) {
        this.zzbbv = cls;
        this.zzbbw = cls2;
        this.zzbbx = obj;
    }

    public final Class<?> zzpx() {
        return this.zzbbw;
    }
}
