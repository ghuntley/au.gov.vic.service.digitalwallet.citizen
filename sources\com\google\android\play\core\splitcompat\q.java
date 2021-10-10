package com.google.android.play.core.splitcompat;

import java.io.File;
import java.util.Objects;

/* access modifiers changed from: package-private */
public final class q {
    private final File a;
    private final String b;

    q() {
    }

    q(File file, String str) {
        this();
        Objects.requireNonNull(file, "Null splitFile");
        this.a = file;
        Objects.requireNonNull(str, "Null splitId");
        this.b = str;
    }

    /* access modifiers changed from: package-private */
    public File a() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            return this.a.equals(qVar.a()) && this.b.equals(qVar.b());
        }
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.a);
        String str = this.b;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35 + str.length());
        sb.append("SplitFileInfo{splitFile=");
        sb.append(valueOf);
        sb.append(", splitId=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
