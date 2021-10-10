package com.google.android.play.core.assetpacks;

import java.util.Arrays;
import org.objectweb.asm.Opcodes;

/* access modifiers changed from: package-private */
public final class dx {
    private final String a;
    private final long b;
    private final int c;
    private final boolean d;
    private final boolean e;
    private final byte[] f;

    dx() {
    }

    dx(String str, long j, int i, boolean z, boolean z2, byte[] bArr) {
        this();
        this.a = str;
        this.b = j;
        this.c = i;
        this.d = z;
        this.e = z2;
        this.f = bArr;
    }

    static dx a(String str, long j, int i, boolean z, byte[] bArr, boolean z2) {
        return new dx(str, j, i, z, z2, bArr);
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        if (d() == null) {
            return false;
        }
        return d().endsWith("/");
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        return f() == 0;
    }

    /* access modifiers changed from: package-private */
    public String d() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public long e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof dx) {
            dx dxVar = (dx) obj;
            String str = this.a;
            if (str != null ? str.equals(dxVar.d()) : dxVar.d() == null) {
                if (this.b == dxVar.e() && this.c == dxVar.f() && this.d == dxVar.g() && this.e == dxVar.h()) {
                    if (Arrays.equals(this.f, dxVar instanceof dx ? dxVar.f : dxVar.i())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.e;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.b;
        int i = 1237;
        int i2 = (((((((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.c) * 1000003) ^ (true != this.d ? 1237 : 1231)) * 1000003;
        if (true == this.e) {
            i = 1231;
        }
        return ((i2 ^ i) * 1000003) ^ Arrays.hashCode(this.f);
    }

    /* access modifiers changed from: package-private */
    public byte[] i() {
        return this.f;
    }

    public String toString() {
        String str = this.a;
        long j = this.b;
        int i = this.c;
        boolean z = this.d;
        boolean z2 = this.e;
        String arrays = Arrays.toString(this.f);
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + Opcodes.IAND + String.valueOf(arrays).length());
        sb.append("ZipEntry{name=");
        sb.append(str);
        sb.append(", size=");
        sb.append(j);
        sb.append(", compressionMethod=");
        sb.append(i);
        sb.append(", isPartial=");
        sb.append(z);
        sb.append(", isEndOfArchive=");
        sb.append(z2);
        sb.append(", headerBytes=");
        sb.append(arrays);
        sb.append("}");
        return sb.toString();
    }
}
