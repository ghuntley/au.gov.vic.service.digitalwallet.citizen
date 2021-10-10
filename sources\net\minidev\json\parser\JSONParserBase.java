package net.minidev.json.parser;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.text.Typography;
import net.minidev.json.writer.JsonReader;
import net.minidev.json.writer.JsonReaderI;
import org.objectweb.asm.Opcodes;

/* access modifiers changed from: package-private */
public abstract class JSONParserBase {
    public static final byte EOI = 26;
    protected static final char MAX_STOP = '~';
    protected static boolean[] stopAll;
    protected static boolean[] stopArray;
    protected static boolean[] stopKey;
    protected static boolean[] stopValue;
    protected static boolean[] stopX;
    protected final boolean acceptLeadinZero;
    protected final boolean acceptNaN;
    protected final boolean acceptNonQuote;
    protected final boolean acceptSimpleQuote;
    protected final boolean acceptUselessComma;
    JsonReader base;
    protected char c;
    protected final boolean checkTaillingData;
    protected final boolean checkTaillingSpace;
    protected final boolean ignoreControlChar;
    private String lastKey;
    protected int pos;
    protected final boolean reject127;
    protected final MSB sb = new MSB(15);
    protected final boolean useHiPrecisionFloat;
    protected final boolean useIntegerStorage;
    protected Object xo;
    protected String xs;

    /* access modifiers changed from: protected */
    public abstract void read() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void readNQString(boolean[] zArr) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void readNoEnd() throws ParseException, IOException;

    /* access modifiers changed from: protected */
    public abstract Object readNumber(boolean[] zArr) throws ParseException, IOException;

    /* access modifiers changed from: package-private */
    public abstract void readS() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void readString() throws ParseException, IOException;

    static {
        boolean[] zArr = new boolean[Opcodes.IAND];
        stopAll = zArr;
        boolean[] zArr2 = new boolean[Opcodes.IAND];
        stopArray = zArr2;
        boolean[] zArr3 = new boolean[Opcodes.IAND];
        stopKey = zArr3;
        boolean[] zArr4 = new boolean[Opcodes.IAND];
        stopValue = zArr4;
        boolean[] zArr5 = new boolean[Opcodes.IAND];
        stopX = zArr5;
        zArr3[26] = true;
        zArr3[58] = true;
        zArr4[26] = true;
        zArr4[125] = true;
        zArr4[44] = true;
        zArr2[26] = true;
        zArr2[93] = true;
        zArr2[44] = true;
        zArr5[26] = true;
        zArr[58] = true;
        zArr[44] = true;
        zArr[26] = true;
        zArr[125] = true;
        zArr[93] = true;
    }

    public JSONParserBase(int i) {
        boolean z = false;
        this.acceptNaN = (i & 4) > 0;
        this.acceptNonQuote = (i & 2) > 0;
        this.acceptSimpleQuote = (i & 1) > 0;
        this.ignoreControlChar = (i & 8) > 0;
        this.useIntegerStorage = (i & 16) > 0;
        this.acceptLeadinZero = (i & 32) > 0;
        this.acceptUselessComma = (i & 64) > 0;
        this.useHiPrecisionFloat = (i & 128) > 0;
        this.checkTaillingData = (i & 768) != 768;
        this.checkTaillingSpace = (i & 512) == 0;
        this.reject127 = (i & 1024) > 0 ? true : z;
    }

    public void checkControleChar() throws ParseException {
        if (!this.ignoreControlChar) {
            int length = this.xs.length();
            for (int i = 0; i < length; i++) {
                char charAt = this.xs.charAt(i);
                if (charAt >= 0) {
                    if (charAt <= 31) {
                        throw new ParseException(this.pos + i, 0, Character.valueOf(charAt));
                    } else if (charAt == 127 && this.reject127) {
                        throw new ParseException(this.pos + i, 0, Character.valueOf(charAt));
                    }
                }
            }
        }
    }

    public void checkLeadinZero() throws ParseException {
        int length = this.xs.length();
        if (length != 1) {
            if (length != 2) {
                char charAt = this.xs.charAt(0);
                char charAt2 = this.xs.charAt(1);
                if (charAt == '-') {
                    char charAt3 = this.xs.charAt(2);
                    if (charAt2 == '0' && charAt3 >= '0' && charAt3 <= '9') {
                        throw new ParseException(this.pos, 6, this.xs);
                    }
                } else if (charAt == '0' && charAt2 >= '0' && charAt2 <= '9') {
                    throw new ParseException(this.pos, 6, this.xs);
                }
            } else if (this.xs.equals("00")) {
                throw new ParseException(this.pos, 6, this.xs);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Number extractFloat() throws ParseException {
        if (!this.acceptLeadinZero) {
            checkLeadinZero();
        }
        if (!this.useHiPrecisionFloat) {
            return Float.valueOf(Float.parseFloat(this.xs));
        }
        if (this.xs.length() > 18) {
            return new BigDecimal(this.xs);
        }
        return Double.valueOf(Double.parseDouble(this.xs));
    }

    /* access modifiers changed from: protected */
    public <T> T parse(JsonReaderI<T> jsonReaderI) throws ParseException {
        this.pos = -1;
        try {
            read();
            T t = (T) readFirst(jsonReaderI);
            if (this.checkTaillingData) {
                if (!this.checkTaillingSpace) {
                    skipSpace();
                }
                if (this.c != 26) {
                    throw new ParseException(this.pos - 1, 1, Character.valueOf(this.c));
                }
            }
            this.xs = null;
            this.xo = null;
            return t;
        } catch (IOException e) {
            throw new ParseException(this.pos, e);
        }
    }

    /* access modifiers changed from: protected */
    public Number parseNumber(String str) throws ParseException {
        int i;
        int i2;
        boolean z;
        int length = str.length();
        boolean z2 = false;
        if (str.charAt(0) == '-') {
            i2 = 20;
            if (this.acceptLeadinZero || length < 3 || str.charAt(1) != '0') {
                i = 1;
            } else {
                throw new ParseException(this.pos, 6, str);
            }
        } else if (this.acceptLeadinZero || length < 2 || str.charAt(0) != '0') {
            i2 = 19;
            i = 0;
        } else {
            throw new ParseException(this.pos, 6, str);
        }
        if (length < i2) {
            z = false;
        } else if (length > i2) {
            return new BigInteger(str, 10);
        } else {
            length--;
            z = true;
        }
        long j = 0;
        while (i < length) {
            j = (j * 10) + ((long) ('0' - str.charAt(i)));
            i++;
        }
        if (z) {
            int i3 = (j > -922337203685477580L ? 1 : (j == -922337203685477580L ? 0 : -1));
            if (i3 <= 0) {
                if (i3 >= 0) {
                    if (i != 0) {
                    }
                }
                z2 = true;
            }
            if (z2) {
                return new BigInteger(str, 10);
            }
            j = (j * 10) + ((long) ('0' - str.charAt(i)));
        }
        if (i == 0) {
            long j2 = -j;
            if (!this.useIntegerStorage || j2 > 2147483647L) {
                return Long.valueOf(j2);
            }
            return Integer.valueOf((int) j2);
        } else if (!this.useIntegerStorage || j < -2147483648L) {
            return Long.valueOf(j);
        } else {
            return Integer.valueOf((int) j);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
        if (r5 == ':') goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0047, code lost:
        if (r5 == ']') goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        if (r5 == '}') goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (r4 == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005b, code lost:
        if (r7.acceptUselessComma == false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006b, code lost:
        throw new net.minidev.json.parser.ParseException(r7.pos, 0, java.lang.Character.valueOf(r7.c));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006c, code lost:
        read();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0073, code lost:
        return r8.convert(r0);
     */
    public <T> T readArray(JsonReaderI<T> jsonReaderI) throws ParseException, IOException {
        Object createArray = jsonReaderI.createArray();
        if (this.c == '[') {
            read();
            if (this.c != ',' || this.acceptUselessComma) {
                while (true) {
                    boolean z = false;
                    while (true) {
                        char c2 = this.c;
                        if (!(c2 == '\t' || c2 == '\n' || c2 == '\r')) {
                            if (c2 == 26) {
                                throw new ParseException(this.pos - 1, 3, "EOF");
                            } else if (c2 != ' ') {
                                if (c2 != ',') {
                                    break;
                                } else if (!z || this.acceptUselessComma) {
                                    read();
                                    z = true;
                                } else {
                                    throw new ParseException(this.pos, 0, Character.valueOf(this.c));
                                }
                            }
                        }
                        read();
                    }
                    jsonReaderI.addValue(createArray, readMain(jsonReaderI, stopArray));
                }
                throw new ParseException(this.pos, 0, Character.valueOf(this.c));
            }
            throw new ParseException(this.pos, 0, Character.valueOf(this.c));
        }
        throw new RuntimeException("Internal Error");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ba, code lost:
        throw new net.minidev.json.parser.ParseException(r3.pos, 0, java.lang.Character.valueOf(r3.c));
     */
    public <T> T readFirst(JsonReaderI<T> jsonReaderI) throws ParseException, IOException {
        while (true) {
            char c2 = this.c;
            if (!(c2 == '\t' || c2 == '\n')) {
                switch (c2) {
                    case '\r':
                    case ' ':
                        break;
                    case '\"':
                    case '\'':
                        readString();
                        return jsonReaderI.convert(this.xs);
                    case '-':
                        break;
                    case 'N':
                        readNQString(stopX);
                        if (!this.acceptNaN) {
                            throw new ParseException(this.pos, 1, this.xs);
                        } else if ("NaN".equals(this.xs)) {
                            return jsonReaderI.convert(Float.valueOf(Float.NaN));
                        } else {
                            if (this.acceptNonQuote) {
                                return jsonReaderI.convert(this.xs);
                            }
                            throw new ParseException(this.pos, 1, this.xs);
                        }
                    case '[':
                        return (T) readArray(jsonReaderI);
                    case ']':
                    case Opcodes.LUSHR /*{ENCODED_INT: 125}*/:
                        break;
                    case 'f':
                        readNQString(stopX);
                        if ("false".equals(this.xs)) {
                            return jsonReaderI.convert(Boolean.FALSE);
                        }
                        if (this.acceptNonQuote) {
                            return jsonReaderI.convert(this.xs);
                        }
                        throw new ParseException(this.pos, 1, this.xs);
                    case 'n':
                        readNQString(stopX);
                        if ("null".equals(this.xs)) {
                            return null;
                        }
                        if (this.acceptNonQuote) {
                            return jsonReaderI.convert(this.xs);
                        }
                        throw new ParseException(this.pos, 1, this.xs);
                    case 't':
                        readNQString(stopX);
                        if ("true".equals(this.xs)) {
                            return jsonReaderI.convert(Boolean.TRUE);
                        }
                        if (this.acceptNonQuote) {
                            return jsonReaderI.convert(this.xs);
                        }
                        throw new ParseException(this.pos, 1, this.xs);
                    case '{':
                        return (T) readObject(jsonReaderI);
                    default:
                        switch (c2) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                break;
                            case ':':
                                break;
                            default:
                                readNQString(stopX);
                                if (this.acceptNonQuote) {
                                    return jsonReaderI.convert(this.xs);
                                }
                                throw new ParseException(this.pos, 1, this.xs);
                        }
                }
            }
            read();
        }
        Object readNumber = readNumber(stopX);
        this.xo = readNumber;
        return jsonReaderI.convert(readNumber);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a0, code lost:
        throw new net.minidev.json.parser.ParseException(r2.pos, 0, java.lang.Character.valueOf(r2.c));
     */
    public Object readMain(JsonReaderI<?> jsonReaderI, boolean[] zArr) throws ParseException, IOException {
        while (true) {
            char c2 = this.c;
            if (!(c2 == '\t' || c2 == '\n')) {
                switch (c2) {
                    case '\r':
                    case ' ':
                        break;
                    case '\"':
                    case '\'':
                        readString();
                        return this.xs;
                    case '-':
                        break;
                    case 'N':
                        readNQString(zArr);
                        if (!this.acceptNaN) {
                            throw new ParseException(this.pos, 1, this.xs);
                        } else if ("NaN".equals(this.xs)) {
                            return Float.valueOf(Float.NaN);
                        } else {
                            if (this.acceptNonQuote) {
                                return this.xs;
                            }
                            throw new ParseException(this.pos, 1, this.xs);
                        }
                    case '[':
                        return readArray(jsonReaderI.startArray(this.lastKey));
                    case ']':
                    case Opcodes.LUSHR /*{ENCODED_INT: 125}*/:
                        break;
                    case 'f':
                        readNQString(zArr);
                        if ("false".equals(this.xs)) {
                            return Boolean.FALSE;
                        }
                        if (this.acceptNonQuote) {
                            return this.xs;
                        }
                        throw new ParseException(this.pos, 1, this.xs);
                    case 'n':
                        readNQString(zArr);
                        if ("null".equals(this.xs)) {
                            return null;
                        }
                        if (this.acceptNonQuote) {
                            return this.xs;
                        }
                        throw new ParseException(this.pos, 1, this.xs);
                    case 't':
                        readNQString(zArr);
                        if ("true".equals(this.xs)) {
                            return Boolean.TRUE;
                        }
                        if (this.acceptNonQuote) {
                            return this.xs;
                        }
                        throw new ParseException(this.pos, 1, this.xs);
                    case '{':
                        return readObject(jsonReaderI.startObject(this.lastKey));
                    default:
                        switch (c2) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                break;
                            case ':':
                                break;
                            default:
                                readNQString(zArr);
                                if (this.acceptNonQuote) {
                                    return this.xs;
                                }
                                throw new ParseException(this.pos, 1, this.xs);
                        }
                }
            }
            read();
        }
        return readNumber(zArr);
    }

    /* access modifiers changed from: protected */
    public <T> T readObject(JsonReaderI<T> jsonReaderI) throws ParseException, IOException {
        if (this.c == '{') {
            Object createObject = jsonReaderI.createObject();
            boolean z = false;
            while (true) {
                read();
                char c2 = this.c;
                if (!(c2 == '\t' || c2 == '\n' || c2 == '\r' || c2 == ' ')) {
                    if (c2 != ',') {
                        if (c2 != ':' && c2 != '[' && c2 != ']' && c2 != '{') {
                            if (c2 != '}') {
                                if (c2 == '\"' || c2 == '\'') {
                                    readString();
                                } else {
                                    readNQString(stopKey);
                                    if (!this.acceptNonQuote) {
                                        throw new ParseException(this.pos, 1, this.xs);
                                    }
                                }
                                String str = this.xs;
                                skipSpace();
                                char c3 = this.c;
                                if (c3 == ':') {
                                    readNoEnd();
                                    this.lastKey = str;
                                    jsonReaderI.setValue(createObject, str, readMain(jsonReaderI, stopValue));
                                    this.lastKey = null;
                                    skipSpace();
                                    char c4 = this.c;
                                    if (c4 == '}') {
                                        read();
                                        return jsonReaderI.convert(createObject);
                                    } else if (c4 == 26) {
                                        throw new ParseException(this.pos - 1, 3, null);
                                    } else if (c4 != ',') {
                                        throw new ParseException(this.pos - 1, 1, Character.valueOf(this.c));
                                    }
                                } else if (c3 == 26) {
                                    throw new ParseException(this.pos - 1, 3, null);
                                } else {
                                    throw new ParseException(this.pos - 1, 0, Character.valueOf(this.c));
                                }
                            } else if (!z || this.acceptUselessComma) {
                                read();
                                return jsonReaderI.convert(createObject);
                            } else {
                                throw new ParseException(this.pos, 0, Character.valueOf(this.c));
                            }
                        }
                    } else if (z && !this.acceptUselessComma) {
                        throw new ParseException(this.pos, 0, Character.valueOf(this.c));
                    }
                    z = true;
                }
            }
            throw new ParseException(this.pos, 0, Character.valueOf(this.c));
        }
        throw new RuntimeException("Internal Error");
    }

    /* access modifiers changed from: protected */
    public void readString2() throws ParseException, IOException {
        char c2 = this.c;
        while (true) {
            read();
            char c3 = this.c;
            if (c3 == '\"' || c3 == '\'') {
                if (c2 == c3) {
                    read();
                    this.xs = this.sb.toString();
                    return;
                }
                this.sb.append(c3);
            } else if (c3 != '\\') {
                if (c3 != 127) {
                    switch (c3) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case '\b':
                        case '\t':
                        case '\n':
                        case 11:
                        case '\f':
                        case '\r':
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                            if (this.ignoreControlChar) {
                                break;
                            } else {
                                throw new ParseException(this.pos, 0, Character.valueOf(this.c));
                            }
                        case 26:
                            throw new ParseException(this.pos - 1, 3, null);
                    }
                } else if (this.ignoreControlChar) {
                    continue;
                } else if (this.reject127) {
                    throw new ParseException(this.pos, 0, Character.valueOf(this.c));
                }
                this.sb.append(c3);
            } else {
                read();
                char c4 = this.c;
                if (c4 == '\"') {
                    this.sb.append(Typography.quote);
                } else if (c4 == '\'') {
                    this.sb.append('\'');
                } else if (c4 == '/') {
                    this.sb.append('/');
                } else if (c4 == '\\') {
                    this.sb.append('\\');
                } else if (c4 == 'b') {
                    this.sb.append('\b');
                } else if (c4 == 'f') {
                    this.sb.append('\f');
                } else if (c4 == 'n') {
                    this.sb.append('\n');
                } else if (c4 == 'r') {
                    this.sb.append('\r');
                } else if (c4 == 'x') {
                    this.sb.append(readUnicode(2));
                } else if (c4 == 't') {
                    this.sb.append('\t');
                } else if (c4 == 'u') {
                    this.sb.append(readUnicode(4));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public char readUnicode(int i) throws ParseException, IOException {
        int i2;
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = i4 * 16;
            read();
            char c2 = this.c;
            if (c2 > '9' || c2 < '0') {
                if (c2 <= 'F' && c2 >= 'A') {
                    i2 = c2 - 'A';
                } else if (c2 >= 'a' && c2 <= 'f') {
                    i2 = c2 - 'a';
                } else if (c2 == 26) {
                    throw new ParseException(this.pos, 3, "EOF");
                } else {
                    throw new ParseException(this.pos, 4, Character.valueOf(this.c));
                }
                i3 = i2 + 10;
            } else {
                i3 = c2 - '0';
            }
            i4 = i6 + i3;
        }
        return (char) i4;
    }

    /* access modifiers changed from: protected */
    public void skipDigits() throws IOException {
        while (true) {
            char c2 = this.c;
            if (c2 >= '0' && c2 <= '9') {
                readS();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void skipNQString(boolean[] zArr) throws IOException {
        while (true) {
            char c2 = this.c;
            if (c2 == 26) {
                return;
            }
            if (c2 < 0 || c2 >= '~' || !zArr[c2]) {
                readS();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void skipSpace() throws IOException {
        while (true) {
            char c2 = this.c;
            if (c2 <= ' ' && c2 != 26) {
                readS();
            } else {
                return;
            }
        }
    }

    public static class MSB {
        char[] b;
        int p = -1;

        public MSB(int i) {
            this.b = new char[i];
        }

        public void append(char c) {
            int i = this.p + 1;
            this.p = i;
            char[] cArr = this.b;
            if (cArr.length <= i) {
                char[] cArr2 = new char[((cArr.length * 2) + 1)];
                System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                this.b = cArr2;
            }
            this.b[this.p] = c;
        }

        public void append(int i) {
            int i2 = this.p + 1;
            this.p = i2;
            char[] cArr = this.b;
            if (cArr.length <= i2) {
                char[] cArr2 = new char[((cArr.length * 2) + 1)];
                System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                this.b = cArr2;
            }
            this.b[this.p] = (char) i;
        }

        public String toString() {
            return new String(this.b, 0, this.p + 1);
        }

        public void clear() {
            this.p = -1;
        }
    }
}
