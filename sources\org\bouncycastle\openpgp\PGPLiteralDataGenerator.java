package org.bouncycastle.openpgp;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.util.Strings;

public class PGPLiteralDataGenerator implements StreamGenerator {
    public static final char BINARY = 'b';
    public static final String CONSOLE = "_CONSOLE";
    public static final Date NOW = PGPLiteralData.NOW;
    public static final char TEXT = 't';
    public static final char UTF8 = 'u';
    private boolean oldFormat = false;
    private BCPGOutputStream pkOut;

    public PGPLiteralDataGenerator() {
    }

    public PGPLiteralDataGenerator(boolean z) {
        this.oldFormat = z;
    }

    private void writeHeader(OutputStream outputStream, char c, String str, long j) throws IOException {
        outputStream.write(c);
        byte[] uTF8ByteArray = Strings.toUTF8ByteArray(str);
        outputStream.write((byte) uTF8ByteArray.length);
        for (int i = 0; i != uTF8ByteArray.length; i++) {
            outputStream.write(uTF8ByteArray[i]);
        }
        long j2 = j / 1000;
        outputStream.write((byte) ((int) (j2 >> 24)));
        outputStream.write((byte) ((int) (j2 >> 16)));
        outputStream.write((byte) ((int) (j2 >> 8)));
        outputStream.write((byte) ((int) j2));
    }

    @Override // org.bouncycastle.openpgp.StreamGenerator
    public void close() throws IOException {
        BCPGOutputStream bCPGOutputStream = this.pkOut;
        if (bCPGOutputStream != null) {
            bCPGOutputStream.finish();
            this.pkOut.flush();
            this.pkOut = null;
        }
    }

    public OutputStream open(OutputStream outputStream, char c, File file) throws IOException {
        if (this.pkOut == null) {
            BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(outputStream, 11, 4 + file.length() + 2 + ((long) file.getName().length()), this.oldFormat);
            this.pkOut = bCPGOutputStream;
            writeHeader(bCPGOutputStream, c, file.getName(), file.lastModified());
            return new WrappedGeneratorStream(this.pkOut, this);
        }
        throw new IllegalStateException("generator already in open state");
    }

    public OutputStream open(OutputStream outputStream, char c, String str, long j, Date date) throws IOException {
        if (this.pkOut == null) {
            BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(outputStream, 11, j + 2 + ((long) str.length()) + 4, this.oldFormat);
            this.pkOut = bCPGOutputStream;
            writeHeader(bCPGOutputStream, c, str, date.getTime());
            return new WrappedGeneratorStream(this.pkOut, this);
        }
        throw new IllegalStateException("generator already in open state");
    }

    public OutputStream open(OutputStream outputStream, char c, String str, Date date, byte[] bArr) throws IOException {
        if (this.pkOut == null) {
            BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(outputStream, 11, bArr);
            this.pkOut = bCPGOutputStream;
            writeHeader(bCPGOutputStream, c, str, date.getTime());
            return new WrappedGeneratorStream(this.pkOut, this);
        }
        throw new IllegalStateException("generator already in open state");
    }
}
