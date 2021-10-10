package org.objectweb.asm;

/* access modifiers changed from: package-private */
public final class Frame {
    static final int[] a;
    Label b;
    int[] c;
    int[] d;
    private int[] e;
    private int[] f;
    private int g;
    private int h;
    private int[] i;

    static {
        _clinit_();
        int[] iArr = new int[202];
        for (int i2 = 0; i2 < 202; i2++) {
            iArr[i2] = "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDDCDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCDCDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEFEDDDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE".charAt(i2) - 'E';
        }
        a = iArr;
    }

    Frame() {
    }

    static /* synthetic */ void _clinit_() {
    }

    private int a() {
        int i2 = this.g;
        if (i2 > 0) {
            int[] iArr = this.f;
            int i3 = i2 - 1;
            this.g = i3;
            return iArr[i3];
        }
        Label label = this.b;
        int i4 = label.f - 1;
        label.f = i4;
        return 50331648 | (-i4);
    }

    private int a(int i2) {
        int[] iArr = this.e;
        if (iArr == null || i2 >= iArr.length) {
            return i2 | 33554432;
        }
        int i3 = iArr[i2];
        if (i3 != 0) {
            return i3;
        }
        int i4 = i2 | 33554432;
        iArr[i2] = i4;
        return i4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d A[LOOP:0: B:8:0x0022->B:19:0x004d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c A[SYNTHETIC] */
    private int a(ClassWriter classWriter, int i2) {
        String str;
        int i3;
        if (i2 == 16777222) {
            str = classWriter.I;
        } else {
            if ((-1048576 & i2) == 25165824) {
                str = classWriter.H[1048575 & i2].g;
            }
            return i2;
        }
        int c2 = classWriter.c(str) | 24117248;
        for (int i4 = 0; i4 < this.h; i4++) {
            int i5 = this.i[i4];
            int i6 = -268435456 & i5;
            int i7 = 251658240 & i5;
            if (i7 == 33554432) {
                i3 = this.c[i5 & 8388607];
            } else {
                if (i7 == 50331648) {
                    int[] iArr = this.d;
                    i3 = iArr[iArr.length - (i5 & 8388607)];
                }
                if (i2 != i5) {
                    return c2;
                }
            }
            i5 = i3 + i6;
            if (i2 != i5) {
            }
        }
        return i2;
    }

    private void a(int i2, int i3) {
        if (this.e == null) {
            this.e = new int[10];
        }
        int length = this.e.length;
        if (i2 >= length) {
            int[] iArr = new int[Math.max(i2 + 1, length * 2)];
            System.arraycopy(this.e, 0, iArr, 0, length);
            this.e = iArr;
        }
        this.e[i2] = i3;
    }

    private void a(String str) {
        char charAt = str.charAt(0);
        if (charAt == '(') {
            c((Type.getArgumentsAndReturnSizes(str) >> 2) - 1);
        } else if (charAt == 'J' || charAt == 'D') {
            c(2);
        } else {
            c(1);
        }
    }

    private void a(ClassWriter classWriter, String str) {
        int b2 = b(classWriter, str);
        if (b2 != 0) {
            b(b2);
            if (b2 == 16777220 || b2 == 16777219) {
                b(16777216);
            }
        }
    }

    private static boolean a(ClassWriter classWriter, int i2, int[] iArr, int i3) {
        int min;
        int i4 = iArr[i3];
        if (i4 == i2) {
            return false;
        }
        if ((268435455 & i2) == 16777221) {
            if (i4 == 16777221) {
                return false;
            }
            i2 = 16777221;
        }
        if (i4 == 0) {
            iArr[i3] = i2;
            return true;
        }
        int i5 = i4 & 267386880;
        int i6 = 16777216;
        int i7 = -268435456;
        if (i5 == 24117248 || (i4 & -268435456) != 0) {
            if (i2 == 16777221) {
                return false;
            }
            if ((i2 & -1048576) != (-1048576 & i4)) {
                int i8 = i2 & 267386880;
                if (i8 == 24117248 || (i2 & -268435456) != 0) {
                    int i9 = i2 & -268435456;
                    int i10 = ((i9 == 0 || i8 == 24117248) ? 0 : -268435456) + i9;
                    int i11 = i4 & -268435456;
                    if (i11 == 0 || i5 == 24117248) {
                        i7 = 0;
                    }
                    min = Math.min(i10, i7 + i11);
                }
            } else if (i5 == 24117248) {
                i6 = (i2 & -268435456) | 24117248 | classWriter.a(i2 & 1048575, 1048575 & i4);
            } else {
                min = (i4 & -268435456) - 268435456;
            }
            i6 = min | 24117248 | classWriter.c("java/lang/Object");
        } else if (i4 == 16777221) {
            if ((i2 & 267386880) != 24117248 && (i2 & -268435456) == 0) {
                i2 = 16777216;
            }
            i6 = i2;
        }
        if (i4 == i6) {
            return false;
        }
        iArr[i3] = i6;
        return true;
    }

    private static int b(ClassWriter classWriter, String str) {
        int indexOf = str.charAt(0) == '(' ? str.indexOf(41) + 1 : 0;
        char charAt = str.charAt(indexOf);
        int i2 = 16777218;
        if (charAt == 'F') {
            return 16777218;
        }
        if (charAt == 'L') {
            return classWriter.c(str.substring(indexOf + 1, str.length() - 1)) | 24117248;
        }
        if (charAt != 'S') {
            if (charAt == 'V') {
                return 0;
            }
            if (!(charAt == 'Z' || charAt == 'I')) {
                if (charAt == 'J') {
                    return 16777220;
                }
                switch (charAt) {
                    case 'B':
                    case 'C':
                        break;
                    case 'D':
                        return 16777219;
                    default:
                        int i3 = indexOf + 1;
                        while (str.charAt(i3) == '[') {
                            i3++;
                        }
                        char charAt2 = str.charAt(i3);
                        if (charAt2 != 'F') {
                            if (charAt2 == 'S') {
                                i2 = 16777228;
                            } else if (charAt2 == 'Z') {
                                i2 = 16777225;
                            } else if (charAt2 == 'I') {
                                i2 = 16777217;
                            } else if (charAt2 != 'J') {
                                switch (charAt2) {
                                    case 'B':
                                        i2 = 16777226;
                                        break;
                                    case 'C':
                                        i2 = 16777227;
                                        break;
                                    case 'D':
                                        i2 = 16777219;
                                        break;
                                    default:
                                        i2 = classWriter.c(str.substring(i3 + 1, str.length() - 1)) | 24117248;
                                        break;
                                }
                            } else {
                                i2 = 16777220;
                            }
                        }
                        return ((i3 - indexOf) << 28) | i2;
                }
            }
        }
        return 16777217;
    }

    private void b(int i2) {
        if (this.f == null) {
            this.f = new int[10];
        }
        int length = this.f.length;
        int i3 = this.g;
        if (i3 >= length) {
            int[] iArr = new int[Math.max(i3 + 1, length * 2)];
            System.arraycopy(this.f, 0, iArr, 0, length);
            this.f = iArr;
        }
        int[] iArr2 = this.f;
        int i4 = this.g;
        this.g = i4 + 1;
        iArr2[i4] = i2;
        int i5 = this.b.f + this.g;
        if (i5 > this.b.g) {
            this.b.g = i5;
        }
    }

    private void c(int i2) {
        int i3 = this.g;
        if (i3 >= i2) {
            this.g = i3 - i2;
            return;
        }
        this.b.f -= i2 - this.g;
        this.g = 0;
    }

    private void d(int i2) {
        if (this.i == null) {
            this.i = new int[2];
        }
        int length = this.i.length;
        int i3 = this.h;
        if (i3 >= length) {
            int[] iArr = new int[Math.max(i3 + 1, length * 2)];
            System.arraycopy(this.i, 0, iArr, 0, length);
            this.i = iArr;
        }
        int[] iArr2 = this.i;
        int i4 = this.h;
        this.h = i4 + 1;
        iArr2[i4] = i2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004b, code lost:
        if (r1.charAt(0) == '[') goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0227  */
    public void a(int i2, int i3, ClassWriter classWriter, Item item) {
        int i4;
        String str;
        int i5;
        int i6;
        int i7;
        int i8;
        if (!(i2 == 198 || i2 == 199)) {
            switch (i2) {
                case 0:
                    return;
                case 1:
                    i4 = 16777221;
                    b(i4);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 16:
                case 17:
                    b(16777217);
                    return;
                case 9:
                case 10:
                    b(16777220);
                    b(16777216);
                    return;
                case 11:
                case 12:
                case 13:
                    b(16777218);
                    return;
                case 14:
                case 15:
                    b(16777219);
                    b(16777216);
                    return;
                case 18:
                    int i9 = item.b;
                    if (i9 != 16) {
                        switch (i9) {
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                str = "java/lang/Class";
                                break;
                            case 8:
                                str = "java/lang/String";
                                break;
                            default:
                                str = "java/lang/invoke/MethodHandle";
                                break;
                        }
                    } else {
                        str = "java/lang/invoke/MethodType";
                    }
                    i4 = classWriter.c(str) | 24117248;
                    b(i4);
                    return;
                default:
                    switch (i2) {
                        case 21:
                            break;
                        case 22:
                            break;
                        case 23:
                            break;
                        case 24:
                            break;
                        case 25:
                            i4 = a(i3);
                            b(i4);
                            return;
                        default:
                            switch (i2) {
                                case 46:
                                case 51:
                                case 52:
                                case 53:
                                    c(2);
                                    b(16777217);
                                    return;
                                case 47:
                                    c(2);
                                    b(16777220);
                                    b(16777216);
                                    return;
                                case 48:
                                    c(2);
                                    b(16777218);
                                    return;
                                case 49:
                                    c(2);
                                    b(16777219);
                                    b(16777216);
                                    return;
                                case 50:
                                    c(1);
                                    i4 = a() - 268435456;
                                    b(i4);
                                    return;
                                case 54:
                                case 56:
                                case 58:
                                    a(i3, a());
                                    if (i3 > 0) {
                                        i5 = i3 - 1;
                                        i6 = a(i5);
                                        if (!(i6 == 16777220 || i6 == 16777219)) {
                                            if ((i6 & 251658240) == 16777216) {
                                                return;
                                            }
                                            a(i5, i6 | 8388608);
                                            return;
                                        }
                                        a(i5, 16777216);
                                        return;
                                    }
                                    return;
                                case 55:
                                case 57:
                                    c(1);
                                    a(i3, a());
                                    a(i3 + 1, 16777216);
                                    if (i3 > 0) {
                                        i5 = i3 - 1;
                                        i6 = a(i5);
                                        if (!(i6 == 16777220 || i6 == 16777219)) {
                                            if ((i6 & 251658240) == 16777216) {
                                                return;
                                            }
                                            a(i5, i6 | 8388608);
                                            return;
                                        }
                                        a(i5, 16777216);
                                        return;
                                    }
                                    return;
                                default:
                                    switch (i2) {
                                        case 79:
                                        case 81:
                                        case 83:
                                        case 84:
                                        case 85:
                                        case 86:
                                            c(3);
                                            return;
                                        case 80:
                                        case 82:
                                            c(4);
                                            return;
                                        case 87:
                                        case Opcodes.IFEQ /*{ENCODED_INT: 153}*/:
                                        case Opcodes.IFNE /*{ENCODED_INT: 154}*/:
                                        case Opcodes.IFLT /*{ENCODED_INT: 155}*/:
                                        case Opcodes.IFGE /*{ENCODED_INT: 156}*/:
                                        case Opcodes.IFGT /*{ENCODED_INT: 157}*/:
                                        case Opcodes.IFLE /*{ENCODED_INT: 158}*/:
                                        case Opcodes.TABLESWITCH /*{ENCODED_INT: 170}*/:
                                        case Opcodes.LOOKUPSWITCH /*{ENCODED_INT: 171}*/:
                                        case Opcodes.IRETURN /*{ENCODED_INT: 172}*/:
                                        case Opcodes.FRETURN /*{ENCODED_INT: 174}*/:
                                        case Opcodes.ARETURN /*{ENCODED_INT: 176}*/:
                                        case Opcodes.ATHROW /*{ENCODED_INT: 191}*/:
                                        case Opcodes.MONITORENTER /*{ENCODED_INT: 194}*/:
                                        case Opcodes.MONITOREXIT /*{ENCODED_INT: 195}*/:
                                            break;
                                        case 88:
                                        case Opcodes.IF_ICMPEQ /*{ENCODED_INT: 159}*/:
                                        case Opcodes.IF_ICMPNE /*{ENCODED_INT: 160}*/:
                                        case Opcodes.IF_ICMPLT /*{ENCODED_INT: 161}*/:
                                        case Opcodes.IF_ICMPGE /*{ENCODED_INT: 162}*/:
                                        case Opcodes.IF_ICMPGT /*{ENCODED_INT: 163}*/:
                                        case Opcodes.IF_ICMPLE /*{ENCODED_INT: 164}*/:
                                        case Opcodes.IF_ACMPEQ /*{ENCODED_INT: 165}*/:
                                        case Opcodes.IF_ACMPNE /*{ENCODED_INT: 166}*/:
                                        case Opcodes.LRETURN /*{ENCODED_INT: 173}*/:
                                        case Opcodes.DRETURN /*{ENCODED_INT: 175}*/:
                                            c(2);
                                            return;
                                        case 89:
                                            i4 = a();
                                            b(i4);
                                            b(i4);
                                            return;
                                        case 90:
                                            i4 = a();
                                            i7 = a();
                                            b(i4);
                                            b(i7);
                                            b(i4);
                                            return;
                                        case 91:
                                            i4 = a();
                                            i7 = a();
                                            i8 = a();
                                            b(i4);
                                            b(i8);
                                            b(i7);
                                            b(i4);
                                            return;
                                        case 92:
                                            i4 = a();
                                            i7 = a();
                                            b(i7);
                                            b(i4);
                                            b(i7);
                                            b(i4);
                                            return;
                                        case 93:
                                            i4 = a();
                                            i7 = a();
                                            i8 = a();
                                            b(i7);
                                            b(i4);
                                            b(i8);
                                            b(i7);
                                            b(i4);
                                            return;
                                        case 94:
                                            i4 = a();
                                            i7 = a();
                                            i8 = a();
                                            int a2 = a();
                                            b(i7);
                                            b(i4);
                                            b(a2);
                                            b(i8);
                                            b(i7);
                                            b(i4);
                                            return;
                                        case 95:
                                            int a3 = a();
                                            int a4 = a();
                                            b(a3);
                                            b(a4);
                                            return;
                                        case 96:
                                        case 100:
                                        case 104:
                                        case 108:
                                        case 112:
                                        case 120:
                                        case 122:
                                        case 124:
                                        case Opcodes.IAND /*{ENCODED_INT: 126}*/:
                                        case 128:
                                        case Opcodes.IXOR /*{ENCODED_INT: 130}*/:
                                        case Opcodes.L2I /*{ENCODED_INT: 136}*/:
                                        case 142:
                                        case 149:
                                        case Opcodes.FCMPG /*{ENCODED_INT: 150}*/:
                                            break;
                                        case 97:
                                        case 101:
                                        case 105:
                                        case 109:
                                        case 113:
                                        case 127:
                                        case Opcodes.LOR /*{ENCODED_INT: 129}*/:
                                        case Opcodes.LXOR /*{ENCODED_INT: 131}*/:
                                            c(4);
                                            b(16777220);
                                            b(16777216);
                                            return;
                                        case 98:
                                        case 102:
                                        case 106:
                                        case 110:
                                        case 114:
                                        case Opcodes.L2F /*{ENCODED_INT: 137}*/:
                                        case 144:
                                            break;
                                        case 99:
                                        case 103:
                                        case 107:
                                        case 111:
                                        case 115:
                                            c(4);
                                            b(16777219);
                                            b(16777216);
                                            return;
                                        case 116:
                                        case 117:
                                        case 118:
                                        case 119:
                                        case 145:
                                        case 146:
                                        case 147:
                                        case Opcodes.GOTO /*{ENCODED_INT: 167}*/:
                                        case Opcodes.RETURN /*{ENCODED_INT: 177}*/:
                                            return;
                                        case 121:
                                        case 123:
                                        case Opcodes.LUSHR /*{ENCODED_INT: 125}*/:
                                            c(3);
                                            b(16777220);
                                            b(16777216);
                                            return;
                                        case Opcodes.IINC /*{ENCODED_INT: 132}*/:
                                            a(i3, 16777217);
                                            return;
                                        case Opcodes.I2L /*{ENCODED_INT: 133}*/:
                                        case 140:
                                            c(1);
                                            b(16777220);
                                            b(16777216);
                                            return;
                                        case Opcodes.I2F /*{ENCODED_INT: 134}*/:
                                            c(1);
                                            b(16777218);
                                            return;
                                        case Opcodes.I2D /*{ENCODED_INT: 135}*/:
                                        case 141:
                                            c(1);
                                            b(16777219);
                                            b(16777216);
                                            return;
                                        case 138:
                                            break;
                                        case 139:
                                        case Opcodes.ARRAYLENGTH /*{ENCODED_INT: 190}*/:
                                        case Opcodes.INSTANCEOF /*{ENCODED_INT: 193}*/:
                                            c(1);
                                            b(16777217);
                                            return;
                                        case 143:
                                            break;
                                        case 148:
                                        case Opcodes.DCMPL /*{ENCODED_INT: 151}*/:
                                        case Opcodes.DCMPG /*{ENCODED_INT: 152}*/:
                                            c(4);
                                            b(16777217);
                                            return;
                                        case Opcodes.JSR /*{ENCODED_INT: 168}*/:
                                        case Opcodes.RET /*{ENCODED_INT: 169}*/:
                                            throw new RuntimeException("JSR/RET are not supported with computeFrames option");
                                        case Opcodes.GETSTATIC /*{ENCODED_INT: 178}*/:
                                            str = item.i;
                                            a(classWriter, str);
                                            return;
                                        case Opcodes.PUTSTATIC /*{ENCODED_INT: 179}*/:
                                            a(item.i);
                                            return;
                                        case 180:
                                            c(1);
                                            str = item.i;
                                            a(classWriter, str);
                                            return;
                                        case Opcodes.PUTFIELD /*{ENCODED_INT: 181}*/:
                                            a(item.i);
                                            a();
                                            return;
                                        case Opcodes.INVOKEVIRTUAL /*{ENCODED_INT: 182}*/:
                                        case Opcodes.INVOKESPECIAL /*{ENCODED_INT: 183}*/:
                                        case Opcodes.INVOKESTATIC /*{ENCODED_INT: 184}*/:
                                        case Opcodes.INVOKEINTERFACE /*{ENCODED_INT: 185}*/:
                                            a(item.i);
                                            if (i2 != 184) {
                                                int a5 = a();
                                                if (i2 == 183 && item.h.charAt(0) == '<') {
                                                    d(a5);
                                                }
                                            }
                                            str = item.i;
                                            a(classWriter, str);
                                            return;
                                        case Opcodes.INVOKEDYNAMIC /*{ENCODED_INT: 186}*/:
                                            a(item.h);
                                            str = item.h;
                                            a(classWriter, str);
                                            return;
                                        case Opcodes.NEW /*{ENCODED_INT: 187}*/:
                                            i4 = 25165824 | classWriter.a(item.g, i3);
                                            b(i4);
                                            return;
                                        case 188:
                                            a();
                                            switch (i3) {
                                                case 4:
                                                    i4 = 285212681;
                                                    break;
                                                case 5:
                                                    i4 = 285212683;
                                                    break;
                                                case 6:
                                                    i4 = 285212674;
                                                    break;
                                                case 7:
                                                    i4 = 285212675;
                                                    break;
                                                case 8:
                                                    i4 = 285212682;
                                                    break;
                                                case 9:
                                                    i4 = 285212684;
                                                    break;
                                                case 10:
                                                    i4 = 285212673;
                                                    break;
                                                default:
                                                    i4 = 285212676;
                                                    break;
                                            }
                                            b(i4);
                                            return;
                                        case Opcodes.ANEWARRAY /*{ENCODED_INT: 189}*/:
                                            String str2 = item.g;
                                            a();
                                            if (str2.charAt(0) == '[') {
                                                StringBuffer stringBuffer = new StringBuffer();
                                                stringBuffer.append('[');
                                                stringBuffer.append(str2);
                                                str = stringBuffer.toString();
                                                a(classWriter, str);
                                                return;
                                            }
                                            i4 = classWriter.c(str2) | 292552704;
                                            b(i4);
                                            return;
                                        case Opcodes.CHECKCAST /*{ENCODED_INT: 192}*/:
                                            str = item.g;
                                            a();
                                            break;
                                        default:
                                            c(i3);
                                            str = item.g;
                                            a(classWriter, str);
                                            return;
                                    }
                            }
                    }
            }
        }
        c(1);
    }

    /* access modifiers changed from: package-private */
    public void a(ClassWriter classWriter, int i2, Type[] typeArr, int i3) {
        int[] iArr = new int[i3];
        this.c = iArr;
        this.d = new int[0];
        int i4 = 1;
        if ((i2 & 8) != 0) {
            i4 = 0;
        } else if ((i2 & 524288) == 0) {
            iArr[0] = 24117248 | classWriter.c(classWriter.I);
        } else {
            iArr[0] = 16777222;
        }
        for (Type type : typeArr) {
            int b2 = b(classWriter, type.getDescriptor());
            int[] iArr2 = this.c;
            int i5 = i4 + 1;
            iArr2[i4] = b2;
            if (b2 == 16777220 || b2 == 16777219) {
                iArr2[i5] = 16777216;
                i4 = i5 + 1;
            } else {
                i4 = i5;
            }
        }
        while (i4 < i3) {
            this.c[i4] = 16777216;
            i4++;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0109 A[SYNTHETIC] */
    public boolean a(ClassWriter classWriter, Frame frame, int i2) {
        boolean z;
        boolean z2;
        int i3;
        boolean z3;
        int length = this.c.length;
        int length2 = this.d.length;
        if (frame.c == null) {
            frame.c = new int[length];
            z = true;
        } else {
            z = false;
        }
        int i4 = 0;
        while (true) {
            int i5 = 16777216;
            if (i4 >= length) {
                break;
            }
            int[] iArr = this.e;
            if (iArr == null || i4 >= iArr.length) {
                i5 = this.c[i4];
            } else {
                int i6 = iArr[i4];
                if (i6 == 0) {
                    i5 = this.c[i4];
                } else {
                    int i7 = i6 & -268435456;
                    int i8 = 251658240 & i6;
                    if (i8 == 16777216) {
                        i5 = i6;
                    } else {
                        int i9 = i7 + (i8 == 33554432 ? this.c[i6 & 8388607] : this.d[length2 - (i6 & 8388607)]);
                        if ((i6 & 8388608) == 0 || !(i9 == 16777220 || i9 == 16777219)) {
                            i5 = i9;
                        }
                    }
                }
            }
            if (this.i != null) {
                i5 = a(classWriter, i5);
            }
            z |= a(classWriter, i5, frame.c, i4);
            i4++;
        }
        if (i2 > 0) {
            for (int i10 = 0; i10 < length; i10++) {
                z |= a(classWriter, this.c[i10], frame.c, i10);
            }
            if (frame.d == null) {
                frame.d = new int[1];
                z3 = true;
            } else {
                z3 = z;
            }
            return a(classWriter, i2, frame.d, 0) | z3;
        }
        int length3 = this.d.length + this.b.f;
        if (frame.d == null) {
            frame.d = new int[(this.g + length3)];
            z2 = true;
        } else {
            z2 = z;
        }
        for (int i11 = 0; i11 < length3; i11++) {
            int i12 = this.d[i11];
            if (this.i != null) {
                i12 = a(classWriter, i12);
            }
            z2 |= a(classWriter, i12, frame.d, i11);
        }
        for (int i13 = 0; i13 < this.g; i13++) {
            int i14 = this.f[i13];
            int i15 = i14 & -268435456;
            int i16 = i14 & 251658240;
            if (i16 == 16777216) {
                i3 = i14;
            } else {
                i3 = i15 + (i16 == 33554432 ? this.c[i14 & 8388607] : this.d[length2 - (i14 & 8388607)]);
                if ((i14 & 8388608) != 0) {
                    if (i3 == 16777220 || i3 == 16777219) {
                        i3 = 16777216;
                    }
                    if (this.i == null) {
                        i3 = a(classWriter, i3);
                    }
                    z2 |= a(classWriter, i3, frame.d, length3 + i13);
                }
            }
            if (this.i == null) {
            }
            z2 |= a(classWriter, i3, frame.d, length3 + i13);
        }
        return z2;
    }
}
