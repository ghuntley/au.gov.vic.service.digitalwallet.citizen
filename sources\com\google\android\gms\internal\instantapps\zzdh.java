package com.google.android.gms.internal.instantapps;

public enum zzdh {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzbp.class, zzbp.class, zzbp.zzakv),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    private final Class<?> zzaqk;
    private final Class<?> zzaql;
    private final Object zzaqm;

    private zzdh(Class cls, Class cls2, Object obj) {
        this.zzaqk = cls;
        this.zzaql = cls2;
        this.zzaqm = obj;
    }

    public final Class<?> zzco() {
        return this.zzaql;
    }
}
