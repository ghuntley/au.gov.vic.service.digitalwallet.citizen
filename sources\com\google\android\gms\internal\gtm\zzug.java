package com.google.android.gms.internal.gtm;

public enum zzug {
    DOUBLE(zzul.DOUBLE, 1),
    FLOAT(zzul.FLOAT, 5),
    INT64(zzul.LONG, 0),
    UINT64(zzul.LONG, 0),
    INT32(zzul.INT, 0),
    FIXED64(zzul.LONG, 1),
    FIXED32(zzul.INT, 5),
    BOOL(zzul.BOOLEAN, 0),
    STRING(zzul.STRING, 2) {
    },
    GROUP(zzul.MESSAGE, 3) {
    },
    MESSAGE(zzul.MESSAGE, 2) {
    },
    BYTES(zzul.BYTE_STRING, 2) {
    },
    UINT32(zzul.INT, 0),
    ENUM(zzul.ENUM, 0),
    SFIXED32(zzul.INT, 5),
    SFIXED64(zzul.LONG, 1),
    SINT32(zzul.INT, 0),
    SINT64(zzul.LONG, 0);
    
    private final zzul zzbgh;
    private final int zzbgi;

    private zzug(zzul zzul, int i) {
        this.zzbgh = zzul;
        this.zzbgi = i;
    }

    public final zzul zzrs() {
        return this.zzbgh;
    }

    public final int zzrt() {
        return this.zzbgi;
    }

    /* synthetic */ zzug(zzul zzul, int i, zzuf zzuf) {
        this(zzul, i);
    }
}
