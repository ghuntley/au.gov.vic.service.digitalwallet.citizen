package org.bouncycastle.asn1.x500.style;

/* access modifiers changed from: package-private */
public class X500NameTokenizer {
    private StringBuffer buf;
    private int index;
    private char seperator;
    private String value;

    public X500NameTokenizer(String str) {
        this(str, ',');
    }

    public X500NameTokenizer(String str, char c) {
        this.buf = new StringBuffer();
        this.value = str;
        this.index = -1;
        this.seperator = c;
    }

    public boolean hasMoreTokens() {
        return this.index != this.value.length();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0057, code lost:
        if (r2.charAt(r2.length() - 1) == '=') goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
        r8.buf.append('\\');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0065, code lost:
        if (r8.seperator != '+') goto L_0x0059;
     */
    public String nextToken() {
        if (this.index == this.value.length()) {
            return null;
        }
        int i = this.index + 1;
        this.buf.setLength(0);
        boolean z = false;
        boolean z2 = false;
        while (i != this.value.length()) {
            char charAt = this.value.charAt(i);
            if (charAt == '\"') {
                if (!z) {
                    z2 = !z2;
                }
                this.buf.append(charAt);
            } else if (z || z2) {
                if (charAt == '#') {
                    StringBuffer stringBuffer = this.buf;
                }
                if (charAt == '+') {
                }
                this.buf.append(charAt);
            } else {
                if (charAt == '\\') {
                    z = true;
                } else if (charAt == this.seperator) {
                    break;
                } else {
                    this.buf.append(charAt);
                }
                i++;
            }
            z = false;
            i++;
        }
        this.index = i;
        return this.buf.toString().trim();
    }
}
