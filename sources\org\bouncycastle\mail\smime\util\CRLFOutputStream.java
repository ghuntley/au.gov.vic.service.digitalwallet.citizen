package org.bouncycastle.mail.smime.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CRLFOutputStream extends FilterOutputStream {
    protected static byte[] newline;
    protected int lastb = -1;

    static {
        byte[] bArr = new byte[2];
        newline = bArr;
        bArr[0] = 13;
        bArr[1] = 10;
    }

    public CRLFOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream
    public void write(int i) throws IOException {
        if (i == 13) {
            this.out.write(newline);
        } else if (i != 10) {
            this.out.write(i);
        } else if (this.lastb != 13) {
            this.out.write(newline);
        }
        this.lastb = i;
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        for (int i3 = i; i3 != i + i2; i3++) {
            write(bArr[i3]);
        }
    }

    public void writeln() throws IOException {
        ((FilterOutputStream) this).out.write(newline);
    }
}
