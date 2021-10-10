package com.google.android.play.core.assetpacks;

import org.objectweb.asm.Opcodes;

/* access modifiers changed from: package-private */
public final class dq {
    private final int a;
    private final String b;
    private final long c;
    private final long d;
    private final int e;

    dq() {
    }

    dq(int i, String str, long j, long j2, int i2) {
        this();
        this.a = i;
        this.b = str;
        this.c = j;
        this.d = j2;
        this.e = i2;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public long c() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public long d() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof dq) {
            dq dqVar = (dq) obj;
            return this.a == dqVar.a() && ((str = this.b) != null ? str.equals(dqVar.b()) : dqVar.b() == null) && this.c == dqVar.c() && this.d == dqVar.d() && this.e == dqVar.e();
        }
    }

    public int hashCode() {
        int i = (this.a ^ 1000003) * 1000003;
        String str = this.b;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.c;
        long j2 = this.d;
        return ((((((i ^ hashCode) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.e;
    }

    public String toString() {
        int i = this.a;
        String str = this.b;
        long j = this.c;
        long j2 = this.d;
        int i2 = this.e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + Opcodes.IFGT);
        sb.append("SliceCheckpoint{fileExtractionStatus=");
        sb.append(i);
        sb.append(", filePath=");
        sb.append(str);
        sb.append(", fileOffset=");
        sb.append(j);
        sb.append(", remainingBytes=");
        sb.append(j2);
        sb.append(", previousChunk=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }
}
