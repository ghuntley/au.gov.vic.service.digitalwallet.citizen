package org.objectweb.asm.signature;

public class SignatureReader {
    private final String a;

    public SignatureReader(String str) {
        this.a = str;
    }

    private static int a(String str, int i, SignatureVisitor signatureVisitor) {
        int i2 = i + 1;
        char charAt = str.charAt(i);
        if (!(charAt == 'F' || charAt == 'V' || charAt == 'I' || charAt == 'J' || charAt == 'S')) {
            if (charAt == 'T') {
                int indexOf = str.indexOf(59, i2);
                signatureVisitor.visitTypeVariable(str.substring(i2, indexOf));
                return indexOf + 1;
            } else if (charAt != 'Z') {
                if (charAt != '[') {
                    switch (charAt) {
                        case 'B':
                        case 'C':
                        case 'D':
                            break;
                        default:
                            int i3 = i2;
                            boolean z = false;
                            boolean z2 = false;
                            while (true) {
                                int i4 = i2 + 1;
                                char charAt2 = str.charAt(i2);
                                if (charAt2 == '.' || charAt2 == ';') {
                                    if (!z) {
                                        String substring = str.substring(i3, i4 - 1);
                                        if (z2) {
                                            signatureVisitor.visitInnerClassType(substring);
                                        } else {
                                            signatureVisitor.visitClassType(substring);
                                        }
                                    }
                                    if (charAt2 == ';') {
                                        signatureVisitor.visitEnd();
                                        return i4;
                                    }
                                    z = false;
                                    z2 = true;
                                    i3 = i4;
                                    i2 = i3;
                                } else {
                                    if (charAt2 == '<') {
                                        String substring2 = str.substring(i3, i4 - 1);
                                        if (z2) {
                                            signatureVisitor.visitInnerClassType(substring2);
                                        } else {
                                            signatureVisitor.visitClassType(substring2);
                                        }
                                        while (true) {
                                            char charAt3 = str.charAt(i4);
                                            if (charAt3 != '*') {
                                                if (charAt3 == '+' || charAt3 == '-') {
                                                    i4++;
                                                } else if (charAt3 != '>') {
                                                    charAt3 = SignatureVisitor.INSTANCEOF;
                                                } else {
                                                    z = true;
                                                }
                                                i4 = a(str, i4, signatureVisitor.visitTypeArgument(charAt3));
                                            } else {
                                                i4++;
                                                signatureVisitor.visitTypeArgument();
                                            }
                                        }
                                    }
                                    i2 = i4;
                                }
                            }
                            break;
                    }
                } else {
                    return a(str, i2, signatureVisitor.visitArrayType());
                }
            }
        }
        signatureVisitor.visitBaseType(charAt);
        return i2;
    }

    public void accept(SignatureVisitor signatureVisitor) {
        char charAt;
        String str = this.a;
        int length = str.length();
        int i = 0;
        if (str.charAt(0) == '<') {
            i = 2;
            do {
                int indexOf = str.indexOf(58, i);
                signatureVisitor.visitFormalTypeParameter(str.substring(i - 1, indexOf));
                int i2 = indexOf + 1;
                char charAt2 = str.charAt(i2);
                if (charAt2 == 'L' || charAt2 == '[' || charAt2 == 'T') {
                    i2 = a(str, i2, signatureVisitor.visitClassBound());
                }
                while (true) {
                    i = i2 + 1;
                    charAt = str.charAt(i2);
                    if (charAt != ':') {
                        break;
                    }
                    i2 = a(str, i, signatureVisitor.visitInterfaceBound());
                }
            } while (charAt != '>');
        }
        if (str.charAt(i) == '(') {
            int i3 = i + 1;
            while (str.charAt(i3) != ')') {
                i3 = a(str, i3, signatureVisitor.visitParameterType());
            }
            int i4 = i3 + 1;
            SignatureVisitor visitReturnType = signatureVisitor.visitReturnType();
            while (true) {
                int a2 = a(str, i4, visitReturnType);
                if (a2 < length) {
                    i4 = a2 + 1;
                    visitReturnType = signatureVisitor.visitExceptionType();
                } else {
                    return;
                }
            }
        } else {
            SignatureVisitor visitSuperclass = signatureVisitor.visitSuperclass();
            while (true) {
                i = a(str, i, visitSuperclass);
                if (i < length) {
                    visitSuperclass = signatureVisitor.visitInterface();
                } else {
                    return;
                }
            }
        }
    }

    public void acceptType(SignatureVisitor signatureVisitor) {
        a(this.a, 0, signatureVisitor);
    }
}
