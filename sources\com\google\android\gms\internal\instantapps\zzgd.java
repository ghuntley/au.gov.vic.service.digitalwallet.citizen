package com.google.android.gms.internal.instantapps;

public enum zzgd {
    DOUBLE(zzgg.DOUBLE, 1),
    FLOAT(zzgg.FLOAT, 5),
    INT64(zzgg.LONG, 0),
    UINT64(zzgg.LONG, 0),
    INT32(zzgg.INT, 0),
    FIXED64(zzgg.LONG, 1),
    FIXED32(zzgg.INT, 5),
    BOOL(zzgg.BOOLEAN, 0),
    STRING(zzgg.STRING, 2) {
    },
    GROUP(zzgg.MESSAGE, 3) {
    },
    MESSAGE(zzgg.MESSAGE, 2) {
    },
    BYTES(zzgg.BYTE_STRING, 2) {
    },
    UINT32(zzgg.INT, 0),
    ENUM(zzgg.ENUM, 0),
    SFIXED32(zzgg.INT, 5),
    SFIXED64(zzgg.LONG, 1),
    SINT32(zzgg.INT, 0),
    SINT64(zzgg.LONG, 0);
    
    private final zzgg zzaux;
    private final int zzauy;

    private zzgd(zzgg zzgg, int i) {
        this.zzaux = zzgg;
        this.zzauy = i;
    }

    public final zzgg zzej() {
        return this.zzaux;
    }

    public final int zzek() {
        return this.zzauy;
    }

    /* synthetic */ zzgd(zzgg zzgg, int i, zzga zzga) {
        this(zzgg, i);
    }
}
