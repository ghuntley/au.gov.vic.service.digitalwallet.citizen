package net.minidev.json;

import java.io.IOException;

/* access modifiers changed from: package-private */
public class JStylerObj {
    public static final Escape4Web ESCAPE4Web = new Escape4Web(null);
    public static final EscapeLT ESCAPE_LT = new EscapeLT(null);
    public static final MPAgressive MP_AGGRESIVE = new MPAgressive(null);
    public static final MPSimple MP_SIMPLE = new MPSimple(null);
    public static final MPTrue MP_TRUE = new MPTrue(null);

    public interface MustProtect {
        boolean mustBeProtect(String str);
    }

    public interface StringProtector {
        void escape(String str, Appendable appendable);
    }

    public static boolean isSpace(char c) {
        return c == '\r' || c == '\n' || c == '\t' || c == ' ';
    }

    public static boolean isSpecial(char c) {
        return c == '{' || c == '[' || c == ',' || c == '}' || c == ']' || c == ':' || c == '\'' || c == '\"';
    }

    public static boolean isSpecialChar(char c) {
        return c == '\b' || c == '\f' || c == '\n';
    }

    public static boolean isSpecialClose(char c) {
        return c == '}' || c == ']' || c == ',' || c == ':';
    }

    public static boolean isSpecialOpen(char c) {
        return c == '{' || c == '[' || c == ',' || c == ':';
    }

    public static boolean isUnicode(char c) {
        if (c >= 0 && c <= 31) {
            return true;
        }
        if (c < 127 || c > 159) {
            return c >= 8192 && c <= 8447;
        }
        return true;
    }

    JStylerObj() {
    }

    /* access modifiers changed from: private */
    public static class MPTrue implements MustProtect {
        @Override // net.minidev.json.JStylerObj.MustProtect
        public boolean mustBeProtect(String str) {
            return true;
        }

        private MPTrue() {
        }

        /* synthetic */ MPTrue(MPTrue mPTrue) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public static class MPSimple implements MustProtect {
        private MPSimple() {
        }

        /* synthetic */ MPSimple(MPSimple mPSimple) {
            this();
        }

        @Override // net.minidev.json.JStylerObj.MustProtect
        public boolean mustBeProtect(String str) {
            if (str == null) {
                return false;
            }
            int length = str.length();
            if (length == 0 || str.trim() != str) {
                return true;
            }
            char charAt = str.charAt(0);
            if ((charAt >= '0' && charAt <= '9') || charAt == '-') {
                return true;
            }
            for (int i = 0; i < length; i++) {
                char charAt2 = str.charAt(i);
                if (JStylerObj.isSpace(charAt2) || JStylerObj.isSpecial(charAt2) || JStylerObj.isSpecialChar(charAt2) || JStylerObj.isUnicode(charAt2)) {
                    return true;
                }
            }
            return JStylerObj.isKeyword(str);
        }
    }

    /* access modifiers changed from: private */
    public static class MPAgressive implements MustProtect {
        private MPAgressive() {
        }

        /* synthetic */ MPAgressive(MPAgressive mPAgressive) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0054, code lost:
            if (r3 == '.') goto L_0x0056;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0056, code lost:
            r7 = r7 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0058, code lost:
            if (r7 < r1) goto L_0x005b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x005b, code lost:
            r3 = r10.charAt(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x005f, code lost:
            if (r3 < '0') goto L_0x0063;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0061, code lost:
            if (r3 <= '9') goto L_0x0056;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0063, code lost:
            if (r7 != r1) goto L_0x0066;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0065, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0068, code lost:
            if (r3 == 'E') goto L_0x006e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x006c, code lost:
            if (r3 != 'e') goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x006e, code lost:
            r7 = r7 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0070, code lost:
            if (r7 != r1) goto L_0x0073;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0072, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0073, code lost:
            r3 = r10.charAt(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0079, code lost:
            if (r3 == '+') goto L_0x007d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x007b, code lost:
            if (r3 != '-') goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x007d, code lost:
            r7 = r7 + 1;
            r10.charAt(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0082, code lost:
            if (r7 != r1) goto L_0x0085;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0084, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0085, code lost:
            if (r7 < r1) goto L_0x0088;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0088, code lost:
            r3 = r10.charAt(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x008c, code lost:
            if (r3 < '0') goto L_0x0094;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x008e, code lost:
            if (r3 <= '9') goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0091, code lost:
            r7 = r7 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0094, code lost:
            if (r7 != r1) goto L_0x0097;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0096, code lost:
            return true;
         */
        @Override // net.minidev.json.JStylerObj.MustProtect
        public boolean mustBeProtect(String str) {
            if (str == null) {
                return false;
            }
            int length = str.length();
            if (length == 0 || str.trim() != str) {
                return true;
            }
            char charAt = str.charAt(0);
            if (!JStylerObj.isSpecial(charAt) && !JStylerObj.isUnicode(charAt)) {
                for (int i = 1; i < length; i++) {
                    char charAt2 = str.charAt(i);
                    if (!JStylerObj.isSpecialClose(charAt2) && !JStylerObj.isUnicode(charAt2)) {
                    }
                }
                if (JStylerObj.isKeyword(str)) {
                    return true;
                }
                char charAt3 = str.charAt(0);
                if ((charAt3 >= '0' && charAt3 <= '9') || charAt3 == '-') {
                    int i2 = 1;
                    while (i2 < length) {
                        charAt3 = str.charAt(i2);
                        if (charAt3 < '0' || charAt3 > '9') {
                            break;
                        }
                        i2++;
                    }
                    if (i2 == length) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
    }

    public static boolean isKeyword(String str) {
        if (str.length() < 3) {
            return false;
        }
        char charAt = str.charAt(0);
        if (charAt == 'n') {
            return str.equals("null");
        }
        if (charAt == 't') {
            return str.equals("true");
        }
        if (charAt == 'f') {
            return str.equals("false");
        }
        if (charAt == 'N') {
            return str.equals("NaN");
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static class EscapeLT implements StringProtector {
        private EscapeLT() {
        }

        /* synthetic */ EscapeLT(EscapeLT escapeLT) {
            this();
        }

        @Override // net.minidev.json.JStylerObj.StringProtector
        public void escape(String str, Appendable appendable) {
            try {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt == '\f') {
                        appendable.append("\\f");
                    } else if (charAt == '\r') {
                        appendable.append("\\r");
                    } else if (charAt == '\"') {
                        appendable.append("\\\"");
                    } else if (charAt != '\\') {
                        switch (charAt) {
                            case '\b':
                                appendable.append("\\b");
                                continue;
                            case '\t':
                                appendable.append("\\t");
                                continue;
                            case '\n':
                                appendable.append("\\n");
                                continue;
                            default:
                                if ((charAt < 0 || charAt > 31) && ((charAt < 127 || charAt > 159) && (charAt < 8192 || charAt > 8447))) {
                                    appendable.append(charAt);
                                    break;
                                } else {
                                    appendable.append("\\u");
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> '\f') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> '\b') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> 4) & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> 0) & 15));
                                    continue;
                                }
                        }
                    } else {
                        appendable.append("\\\\");
                    }
                }
            } catch (IOException unused) {
                throw new RuntimeException("Impossible Exeption");
            }
        }
    }

    /* access modifiers changed from: private */
    public static class Escape4Web implements StringProtector {
        private Escape4Web() {
        }

        /* synthetic */ Escape4Web(Escape4Web escape4Web) {
            this();
        }

        @Override // net.minidev.json.JStylerObj.StringProtector
        public void escape(String str, Appendable appendable) {
            try {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt == '\f') {
                        appendable.append("\\f");
                    } else if (charAt == '\r') {
                        appendable.append("\\r");
                    } else if (charAt == '\"') {
                        appendable.append("\\\"");
                    } else if (charAt == '/') {
                        appendable.append("\\/");
                    } else if (charAt != '\\') {
                        switch (charAt) {
                            case '\b':
                                appendable.append("\\b");
                                continue;
                            case '\t':
                                appendable.append("\\t");
                                continue;
                            case '\n':
                                appendable.append("\\n");
                                continue;
                            default:
                                if ((charAt < 0 || charAt > 31) && ((charAt < 127 || charAt > 159) && (charAt < 8192 || charAt > 8447))) {
                                    appendable.append(charAt);
                                    break;
                                } else {
                                    appendable.append("\\u");
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> '\f') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> '\b') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> 4) & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> 0) & 15));
                                    continue;
                                }
                        }
                    } else {
                        appendable.append("\\\\");
                    }
                }
            } catch (IOException unused) {
                throw new RuntimeException("Impossible Error");
            }
        }
    }
}
