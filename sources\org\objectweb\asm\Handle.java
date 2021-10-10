package org.objectweb.asm;

public final class Handle {
    final int a;
    final String b;
    final String c;
    final String d;

    public Handle(int i, String str, String str2, String str3) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Handle)) {
            return false;
        }
        Handle handle = (Handle) obj;
        return this.a == handle.a && this.b.equals(handle.b) && this.c.equals(handle.c) && this.d.equals(handle.d);
    }

    public String getDesc() {
        return this.d;
    }

    public String getName() {
        return this.c;
    }

    public String getOwner() {
        return this.b;
    }

    public int getTag() {
        return this.a;
    }

    public int hashCode() {
        return this.a + (this.b.hashCode() * this.c.hashCode() * this.d.hashCode());
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b);
        stringBuffer.append('.');
        stringBuffer.append(this.c);
        stringBuffer.append(this.d);
        stringBuffer.append(" (");
        stringBuffer.append(this.a);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}
