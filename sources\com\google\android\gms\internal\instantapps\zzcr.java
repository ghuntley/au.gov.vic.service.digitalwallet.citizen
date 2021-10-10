package com.google.android.gms.internal.instantapps;

import java.lang.reflect.Type;

public enum zzcr {
    DOUBLE(0, zzct.SCALAR, zzdh.DOUBLE),
    FLOAT(1, zzct.SCALAR, zzdh.FLOAT),
    INT64(2, zzct.SCALAR, zzdh.LONG),
    UINT64(3, zzct.SCALAR, zzdh.LONG),
    INT32(4, zzct.SCALAR, zzdh.INT),
    FIXED64(5, zzct.SCALAR, zzdh.LONG),
    FIXED32(6, zzct.SCALAR, zzdh.INT),
    BOOL(7, zzct.SCALAR, zzdh.BOOLEAN),
    STRING(8, zzct.SCALAR, zzdh.STRING),
    MESSAGE(9, zzct.SCALAR, zzdh.MESSAGE),
    BYTES(10, zzct.SCALAR, zzdh.BYTE_STRING),
    UINT32(11, zzct.SCALAR, zzdh.INT),
    ENUM(12, zzct.SCALAR, zzdh.ENUM),
    SFIXED32(13, zzct.SCALAR, zzdh.INT),
    SFIXED64(14, zzct.SCALAR, zzdh.LONG),
    SINT32(15, zzct.SCALAR, zzdh.INT),
    SINT64(16, zzct.SCALAR, zzdh.LONG),
    GROUP(17, zzct.SCALAR, zzdh.MESSAGE),
    DOUBLE_LIST(18, zzct.VECTOR, zzdh.DOUBLE),
    FLOAT_LIST(19, zzct.VECTOR, zzdh.FLOAT),
    INT64_LIST(20, zzct.VECTOR, zzdh.LONG),
    UINT64_LIST(21, zzct.VECTOR, zzdh.LONG),
    INT32_LIST(22, zzct.VECTOR, zzdh.INT),
    FIXED64_LIST(23, zzct.VECTOR, zzdh.LONG),
    FIXED32_LIST(24, zzct.VECTOR, zzdh.INT),
    BOOL_LIST(25, zzct.VECTOR, zzdh.BOOLEAN),
    STRING_LIST(26, zzct.VECTOR, zzdh.STRING),
    MESSAGE_LIST(27, zzct.VECTOR, zzdh.MESSAGE),
    BYTES_LIST(28, zzct.VECTOR, zzdh.BYTE_STRING),
    UINT32_LIST(29, zzct.VECTOR, zzdh.INT),
    ENUM_LIST(30, zzct.VECTOR, zzdh.ENUM),
    SFIXED32_LIST(31, zzct.VECTOR, zzdh.INT),
    SFIXED64_LIST(32, zzct.VECTOR, zzdh.LONG),
    SINT32_LIST(33, zzct.VECTOR, zzdh.INT),
    SINT64_LIST(34, zzct.VECTOR, zzdh.LONG),
    DOUBLE_LIST_PACKED(35, zzct.PACKED_VECTOR, zzdh.DOUBLE),
    FLOAT_LIST_PACKED(36, zzct.PACKED_VECTOR, zzdh.FLOAT),
    INT64_LIST_PACKED(37, zzct.PACKED_VECTOR, zzdh.LONG),
    UINT64_LIST_PACKED(38, zzct.PACKED_VECTOR, zzdh.LONG),
    INT32_LIST_PACKED(39, zzct.PACKED_VECTOR, zzdh.INT),
    FIXED64_LIST_PACKED(40, zzct.PACKED_VECTOR, zzdh.LONG),
    FIXED32_LIST_PACKED(41, zzct.PACKED_VECTOR, zzdh.INT),
    BOOL_LIST_PACKED(42, zzct.PACKED_VECTOR, zzdh.BOOLEAN),
    UINT32_LIST_PACKED(43, zzct.PACKED_VECTOR, zzdh.INT),
    ENUM_LIST_PACKED(44, zzct.PACKED_VECTOR, zzdh.ENUM),
    SFIXED32_LIST_PACKED(45, zzct.PACKED_VECTOR, zzdh.INT),
    SFIXED64_LIST_PACKED(46, zzct.PACKED_VECTOR, zzdh.LONG),
    SINT32_LIST_PACKED(47, zzct.PACKED_VECTOR, zzdh.INT),
    SINT64_LIST_PACKED(48, zzct.PACKED_VECTOR, zzdh.LONG),
    GROUP_LIST(49, zzct.VECTOR, zzdh.MESSAGE),
    MAP(50, zzct.MAP, zzdh.VOID);
    
    private static final zzcr[] zzaol;
    private static final Type[] zzaom = new Type[0];
    private final int id;
    private final zzdh zzaoh;
    private final zzct zzaoi;
    private final Class<?> zzaoj;
    private final boolean zzaok;

    private zzcr(int i, zzct zzct, zzdh zzdh) {
        int i2;
        this.id = i;
        this.zzaoi = zzct;
        this.zzaoh = zzdh;
        int i3 = zzcu.zzaou[zzct.ordinal()];
        boolean z = true;
        if (i3 == 1) {
            this.zzaoj = zzdh.zzco();
        } else if (i3 != 2) {
            this.zzaoj = null;
        } else {
            this.zzaoj = zzdh.zzco();
        }
        this.zzaok = (zzct != zzct.SCALAR || (i2 = zzcu.zzaov[zzdh.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : z;
    }

    public final int id() {
        return this.id;
    }

    static {
        zzcr[] values = values();
        zzaol = new zzcr[values.length];
        for (zzcr zzcr : values) {
            zzaol[zzcr.id] = zzcr;
        }
    }
}
