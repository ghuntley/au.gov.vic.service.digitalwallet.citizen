package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Field;
import java.util.Arrays;

public final class zzed {
    private final int flags;
    private final Object[] zzmj;
    private final int zzmk;
    private final int zzml;
    private final int zzmm;
    private final int[] zzms;
    private final zzee zznh;
    private Class<?> zzni;
    private final int zznj;
    private final int zznk;
    private final int zznl;
    private final int zznm;
    private final int zznn;
    private final int zzno;
    private int zznp;
    private int zznq;
    private int zznr = Integer.MAX_VALUE;
    private int zzns = Integer.MIN_VALUE;
    private int zznt = 0;
    private int zznu = 0;
    private int zznv = 0;
    private int zznw = 0;
    private int zznx = 0;
    private int zzny;
    private int zznz;
    private int zzoa;
    private int zzob;
    private int zzoc;
    private Field zzod;
    private Object zzoe;
    private Object zzof;
    private Object zzog;

    zzed(Class<?> cls, String str, Object[] objArr) {
        this.zzni = cls;
        zzee zzee = new zzee(str);
        this.zznh = zzee;
        this.zzmj = objArr;
        this.flags = zzee.next();
        int next = zzee.next();
        this.zznj = next;
        int[] iArr = null;
        if (next == 0) {
            this.zznk = 0;
            this.zznl = 0;
            this.zzmk = 0;
            this.zzml = 0;
            this.zznm = 0;
            this.zznn = 0;
            this.zzmm = 0;
            this.zzno = 0;
            this.zzms = null;
            return;
        }
        int next2 = zzee.next();
        this.zznk = next2;
        int next3 = zzee.next();
        this.zznl = next3;
        this.zzmk = zzee.next();
        this.zzml = zzee.next();
        this.zznn = zzee.next();
        this.zzmm = zzee.next();
        this.zznm = zzee.next();
        this.zzno = zzee.next();
        int next4 = zzee.next();
        this.zzms = next4 != 0 ? new int[next4] : iArr;
        this.zznp = (next2 << 1) + next3;
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private final Object zzcw() {
        Object[] objArr = this.zzmj;
        int i = this.zznp;
        this.zznp = i + 1;
        return objArr[i];
    }

    private final boolean zzcz() {
        return (this.flags & 1) == 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c6, code lost:
        if (zzcz() != false) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (r1 != false) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x015b, code lost:
        if (zzcz() != false) goto L_0x00c8;
     */
    public final boolean next() {
        int i;
        Object type;
        boolean z = false;
        if (!this.zznh.hasNext()) {
            return false;
        }
        this.zzny = this.zznh.next();
        int next = this.zznh.next();
        this.zznz = next;
        int i2 = next & 255;
        this.zzoa = i2;
        int i3 = this.zzny;
        if (i3 < this.zznr) {
            this.zznr = i3;
        }
        if (i3 > this.zzns) {
            this.zzns = i3;
        }
        if (i2 == zzcb.MAP.id()) {
            this.zznt++;
        } else if (this.zzoa >= zzcb.DOUBLE_LIST.id() && this.zzoa <= zzcb.GROUP_LIST.id()) {
            this.zznu++;
        }
        int i4 = this.zznx + 1;
        this.zznx = i4;
        if (zzeh.zzc(this.zznr, this.zzny, i4)) {
            int i5 = this.zzny + 1;
            this.zznw = i5;
            i = i5 - this.zznr;
        } else {
            i = this.zznv + 1;
        }
        this.zznv = i;
        if ((this.zznz & 1024) != 0) {
            int[] iArr = this.zzms;
            int i6 = this.zznq;
            this.zznq = i6 + 1;
            iArr[i6] = this.zzny;
        }
        this.zzoe = null;
        this.zzof = null;
        this.zzog = null;
        if (zzda()) {
            this.zzob = this.zznh.next();
            if (!(this.zzoa == zzcb.MESSAGE.id() + 51 || this.zzoa == zzcb.GROUP.id() + 51)) {
                if (this.zzoa == zzcb.ENUM.id() + 51) {
                }
                return true;
            }
            type = zzcw();
            this.zzoe = type;
            return true;
        }
        this.zzod = zza(this.zzni, (String) zzcw());
        if (zzde()) {
            this.zzoc = this.zznh.next();
        }
        if (this.zzoa == zzcb.MESSAGE.id() || this.zzoa == zzcb.GROUP.id()) {
            type = this.zzod.getType();
            this.zzoe = type;
            return true;
        }
        if (!(this.zzoa == zzcb.MESSAGE_LIST.id() || this.zzoa == zzcb.GROUP_LIST.id())) {
            if (this.zzoa != zzcb.ENUM.id() && this.zzoa != zzcb.ENUM_LIST.id() && this.zzoa != zzcb.ENUM_LIST_PACKED.id()) {
                if (this.zzoa == zzcb.MAP.id()) {
                    this.zzog = zzcw();
                    if ((this.zznz & 2048) != 0) {
                        z = true;
                    }
                }
                return true;
            }
        }
        type = zzcw();
        this.zzoe = type;
        return true;
        this.zzof = zzcw();
        return true;
    }

    public final int zzcx() {
        return this.zzny;
    }

    public final int zzcy() {
        return this.zzoa;
    }

    public final boolean zzda() {
        return this.zzoa > zzcb.MAP.id();
    }

    public final Field zzdb() {
        int i = this.zzob << 1;
        Object obj = this.zzmj[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field zza = zza(this.zzni, (String) obj);
        this.zzmj[i] = zza;
        return zza;
    }

    public final Field zzdc() {
        int i = (this.zzob << 1) + 1;
        Object obj = this.zzmj[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field zza = zza(this.zzni, (String) obj);
        this.zzmj[i] = zza;
        return zza;
    }

    public final Field zzdd() {
        return this.zzod;
    }

    public final boolean zzde() {
        return zzcz() && this.zzoa <= zzcb.GROUP.id();
    }

    public final Field zzdf() {
        int i = (this.zznk << 1) + (this.zzoc / 32);
        Object obj = this.zzmj[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field zza = zza(this.zzni, (String) obj);
        this.zzmj[i] = zza;
        return zza;
    }

    public final int zzdg() {
        return this.zzoc % 32;
    }

    public final boolean zzdh() {
        return (this.zznz & 256) != 0;
    }

    public final boolean zzdi() {
        return (this.zznz & 512) != 0;
    }

    public final Object zzdj() {
        return this.zzoe;
    }

    public final Object zzdk() {
        return this.zzof;
    }

    public final Object zzdl() {
        return this.zzog;
    }
}
