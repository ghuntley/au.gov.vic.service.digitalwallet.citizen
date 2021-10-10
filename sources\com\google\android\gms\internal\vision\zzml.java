package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public enum zzml {
    DOUBLE(zzmo.DOUBLE, 1),
    FLOAT(zzmo.FLOAT, 5),
    INT64(zzmo.LONG, 0),
    UINT64(zzmo.LONG, 0),
    INT32(zzmo.INT, 0),
    FIXED64(zzmo.LONG, 1),
    FIXED32(zzmo.INT, 5),
    BOOL(zzmo.BOOLEAN, 0),
    STRING(zzmo.STRING, 2) {
    },
    GROUP(zzmo.MESSAGE, 3) {
    },
    MESSAGE(zzmo.MESSAGE, 2) {
    },
    BYTES(zzmo.BYTE_STRING, 2) {
    },
    UINT32(zzmo.INT, 0),
    ENUM(zzmo.ENUM, 0),
    SFIXED32(zzmo.INT, 5),
    SFIXED64(zzmo.LONG, 1),
    SINT32(zzmo.INT, 0),
    SINT64(zzmo.LONG, 0);
    
    private final zzmo zzs;
    private final int zzt;

    private zzml(zzmo zzmo, int i) {
        this.zzs = zzmo;
        this.zzt = i;
    }

    public final zzmo zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }

    /* synthetic */ zzml(zzmo zzmo, int i, zzmi zzmi) {
        this(zzmo, i);
    }
}
