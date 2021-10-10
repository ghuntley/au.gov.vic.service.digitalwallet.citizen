package org.objectweb.asm;

/* access modifiers changed from: package-private */
public final class Item {
    int a;
    int b;
    int c;
    long d;
    String g;
    String h;
    String i;
    int j;
    Item k;

    Item() {
    }

    Item(int i2) {
        this.a = i2;
    }

    Item(int i2, Item item) {
        this.a = i2;
        this.b = item.b;
        this.c = item.c;
        this.d = item.d;
        this.g = item.g;
        this.h = item.h;
        this.i = item.i;
        this.j = item.j;
    }

    /* access modifiers changed from: package-private */
    public void a(double d2) {
        this.b = 6;
        this.d = Double.doubleToRawLongBits(d2);
        this.j = Integer.MAX_VALUE & (this.b + ((int) d2));
    }

    /* access modifiers changed from: package-private */
    public void a(float f) {
        this.b = 4;
        this.c = Float.floatToRawIntBits(f);
        this.j = Integer.MAX_VALUE & (this.b + ((int) f));
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        this.b = 3;
        this.c = i2;
        this.j = Integer.MAX_VALUE & (3 + i2);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3) {
        this.b = 33;
        this.c = i2;
        this.j = i3;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, String str, String str2, String str3) {
        int hashCode;
        int hashCode2;
        int hashCode3;
        this.b = i2;
        this.g = str;
        this.h = str2;
        this.i = str3;
        if (i2 != 1) {
            if (i2 == 12) {
                hashCode2 = str.hashCode();
                hashCode3 = str2.hashCode();
            } else if (!(i2 == 16 || i2 == 30)) {
                if (i2 == 7) {
                    this.c = 0;
                } else if (i2 != 8) {
                    hashCode2 = str.hashCode() * str2.hashCode();
                    hashCode3 = str3.hashCode();
                }
            }
            hashCode = hashCode2 * hashCode3;
            this.j = (i2 + hashCode) & Integer.MAX_VALUE;
        }
        hashCode = str.hashCode();
        this.j = (i2 + hashCode) & Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public void a(long j2) {
        this.b = 5;
        this.d = j2;
        this.j = Integer.MAX_VALUE & (5 + ((int) j2));
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2, int i2) {
        this.b = 18;
        this.d = (long) i2;
        this.g = str;
        this.h = str2;
        this.j = Integer.MAX_VALUE & ((i2 * str.hashCode() * this.h.hashCode()) + 18);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c  */
    public boolean a(Item item) {
        int i2 = this.b;
        if (i2 != 1) {
            if (i2 == 12) {
                return item.g.equals(this.g) && item.h.equals(this.h);
            }
            if (i2 != 16) {
                if (i2 == 18) {
                    return item.d == this.d && item.g.equals(this.g) && item.h.equals(this.h);
                }
                switch (i2) {
                    case 3:
                    case 4:
                        return item.c == this.c;
                    case 5:
                    case 6:
                        return item.d == this.d;
                    case 7:
                    case 8:
                        break;
                    default:
                        switch (i2) {
                            case 30:
                                break;
                            case 31:
                                return item.c == this.c && item.g.equals(this.g);
                            case 32:
                                break;
                            default:
                                return item.g.equals(this.g) && item.h.equals(this.h) && item.i.equals(this.i);
                        }
                }
            }
        }
        return item.g.equals(this.g);
    }
}
