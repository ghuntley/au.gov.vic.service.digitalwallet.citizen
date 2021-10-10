package org.bouncycastle.bcpg;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import kotlin.UByte;
import org.objectweb.asm.signature.SignatureVisitor;

public class ArmoredInputStream extends InputStream {
    private static final byte[] decodingTable = new byte[128];
    int bufPtr;
    boolean clearText;
    CRC24 crc;
    boolean crcFound;
    boolean hasHeaders;
    String header;
    Vector headerList;
    InputStream in;
    boolean isEndOfStream;
    int lastC;
    boolean newLineFound;
    int[] outBuf;
    boolean restart;
    boolean start;

    static {
        for (int i = 65; i <= 90; i++) {
            decodingTable[i] = (byte) (i - 65);
        }
        for (int i2 = 97; i2 <= 122; i2++) {
            decodingTable[i2] = (byte) ((i2 - 97) + 26);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            decodingTable[i3] = (byte) ((i3 - 48) + 52);
        }
        byte[] bArr = decodingTable;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public ArmoredInputStream(InputStream inputStream) throws IOException {
        this(inputStream, true);
    }

    public ArmoredInputStream(InputStream inputStream, boolean z) throws IOException {
        this.start = true;
        this.outBuf = new int[3];
        this.bufPtr = 3;
        this.crc = new CRC24();
        this.crcFound = false;
        this.hasHeaders = true;
        this.header = null;
        this.newLineFound = false;
        this.clearText = false;
        this.restart = false;
        this.headerList = new Vector();
        this.lastC = 0;
        this.in = inputStream;
        this.hasHeaders = z;
        if (z) {
            parseHeaders();
        }
        this.start = false;
    }

    private int decode(int i, int i2, int i3, int i4, int[] iArr) throws EOFException {
        if (i4 < 0) {
            throw new EOFException("unexpected end of file in armored stream.");
        } else if (i3 == 61) {
            byte[] bArr = decodingTable;
            iArr[2] = (((bArr[i] & UByte.MAX_VALUE) << 2) | ((bArr[i2] & UByte.MAX_VALUE) >> 4)) & 255;
            return 2;
        } else if (i4 == 61) {
            byte[] bArr2 = decodingTable;
            byte b = bArr2[i];
            byte b2 = bArr2[i2];
            byte b3 = bArr2[i3];
            iArr[1] = ((b << 2) | (b2 >> 4)) & 255;
            iArr[2] = ((b2 << 4) | (b3 >> 2)) & 255;
            return 1;
        } else {
            byte[] bArr3 = decodingTable;
            byte b4 = bArr3[i];
            byte b5 = bArr3[i2];
            byte b6 = bArr3[i3];
            byte b7 = bArr3[i4];
            iArr[0] = ((b4 << 2) | (b5 >> 4)) & 255;
            iArr[1] = ((b5 << 4) | (b6 >> 2)) & 255;
            iArr[2] = ((b6 << 6) | b7) & 255;
            return 0;
        }
    }

    private boolean parseHeaders() throws IOException {
        boolean z;
        int i;
        this.header = null;
        this.headerList = new Vector();
        if (this.restart) {
            z = true;
            i = 0;
        } else {
            i = 0;
            while (true) {
                int read = this.in.read();
                if (read < 0) {
                    z = false;
                    break;
                } else if (!(read == 45 && (i == 0 || i == 10 || i == 13))) {
                    i = read;
                }
            }
            z = true;
        }
        if (z) {
            StringBuffer stringBuffer = new StringBuffer("-");
            if (this.restart) {
                stringBuffer.append(SignatureVisitor.SUPER);
            }
            boolean z2 = false;
            boolean z3 = false;
            while (true) {
                int read2 = this.in.read();
                if (read2 >= 0) {
                    if (i == 13 && read2 == 10) {
                        z3 = true;
                    }
                    if ((z2 && i != 13 && read2 == 10) || (z2 && read2 == 13)) {
                        break;
                    }
                    if (read2 == 13 || (i != 13 && read2 == 10)) {
                        String stringBuffer2 = stringBuffer.toString();
                        if (stringBuffer2.trim().length() == 0) {
                            break;
                        }
                        this.headerList.addElement(stringBuffer2);
                        stringBuffer.setLength(0);
                    }
                    if (read2 != 10 && read2 != 13) {
                        stringBuffer.append((char) read2);
                        z2 = false;
                    } else if (read2 == 13 || (i != 13 && read2 == 10)) {
                        z2 = true;
                    }
                    i = read2;
                } else {
                    break;
                }
            }
            if (z3) {
                this.in.read();
            }
        }
        if (this.headerList.size() > 0) {
            this.header = (String) this.headerList.elementAt(0);
        }
        this.clearText = "-----BEGIN PGP SIGNED MESSAGE-----".equals(this.header);
        this.newLineFound = true;
        return z;
    }

    private int readIgnoreSpace() throws IOException {
        while (true) {
            int read = this.in.read();
            if (read != 32 && read != 9) {
                return read;
            }
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.in.available();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() throws IOException {
        this.in.close();
    }

    public String getArmorHeaderLine() {
        return this.header;
    }

    public String[] getArmorHeaders() {
        if (this.headerList.size() <= 1) {
            return null;
        }
        int size = this.headerList.size() - 1;
        String[] strArr = new String[size];
        int i = 0;
        while (i != size) {
            int i2 = i + 1;
            strArr[i] = (String) this.headerList.elementAt(i2);
            i = i2;
        }
        return strArr;
    }

    public boolean isClearText() {
        return this.clearText;
    }

    public boolean isEndOfStream() {
        return this.isEndOfStream;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
        if (r9.lastC != 13) goto L_0x0048;
     */
    @Override // java.io.InputStream
    public int read() throws IOException {
        int readIgnoreSpace;
        int decode;
        int read;
        if (this.start) {
            if (this.hasHeaders) {
                parseHeaders();
            }
            this.crc.reset();
            this.start = false;
        }
        if (this.clearText) {
            int read2 = this.in.read();
            if (read2 == 13 || (read2 == 10 && this.lastC != 13)) {
                this.newLineFound = true;
            } else {
                if (this.newLineFound && read2 == 45) {
                    read2 = this.in.read();
                    if (read2 == 45) {
                        this.clearText = false;
                        this.start = true;
                        this.restart = true;
                    } else {
                        read2 = this.in.read();
                    }
                } else if (read2 != 10) {
                }
                this.newLineFound = false;
            }
            this.lastC = read2;
            if (read2 < 0) {
                this.isEndOfStream = true;
            }
            return read2;
        }
        if (this.bufPtr > 2 || this.crcFound) {
            int readIgnoreSpace2 = readIgnoreSpace();
            if (readIgnoreSpace2 == 13 || readIgnoreSpace2 == 10) {
                while (true) {
                    readIgnoreSpace = readIgnoreSpace();
                    if (readIgnoreSpace != 10 && readIgnoreSpace != 13) {
                        break;
                    }
                }
                if (readIgnoreSpace < 0) {
                    this.isEndOfStream = true;
                    return -1;
                } else if (readIgnoreSpace == 61) {
                    int decode2 = decode(readIgnoreSpace(), readIgnoreSpace(), readIgnoreSpace(), readIgnoreSpace(), this.outBuf);
                    this.bufPtr = decode2;
                    if (decode2 == 0) {
                        int[] iArr = this.outBuf;
                        int i = (iArr[2] & 255) | ((iArr[0] & 255) << 16) | ((iArr[1] & 255) << 8);
                        this.crcFound = true;
                        if (i == this.crc.getValue()) {
                            return read();
                        }
                        throw new IOException("crc check failed in armored message.");
                    }
                    throw new IOException("no crc found in armored message.");
                } else if (readIgnoreSpace == 45) {
                    do {
                        read = this.in.read();
                        if (read < 0 || read == 10) {
                        }
                    } while (read != 13);
                    if (this.crcFound) {
                        this.crcFound = false;
                        this.start = true;
                        this.bufPtr = 3;
                        if (read < 0) {
                            this.isEndOfStream = true;
                        }
                        return -1;
                    }
                    throw new IOException("crc check not found.");
                } else {
                    decode = decode(readIgnoreSpace, readIgnoreSpace(), readIgnoreSpace(), readIgnoreSpace(), this.outBuf);
                }
            } else if (readIgnoreSpace2 >= 0) {
                decode = decode(readIgnoreSpace2, readIgnoreSpace(), readIgnoreSpace(), readIgnoreSpace(), this.outBuf);
            } else {
                this.isEndOfStream = true;
                return -1;
            }
            this.bufPtr = decode;
        }
        int[] iArr2 = this.outBuf;
        int i2 = this.bufPtr;
        this.bufPtr = i2 + 1;
        int i3 = iArr2[i2];
        this.crc.update(i3);
        return i3;
    }
}
