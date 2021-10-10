package org.bouncycastle.bcpg;

import java.io.IOException;
import org.bouncycastle.util.Strings;

public class LiteralDataPacket extends InputStreamPacket {
    byte[] fileName;
    int format;
    long modDate;

    LiteralDataPacket(BCPGInputStream bCPGInputStream) throws IOException {
        super(bCPGInputStream);
        this.format = bCPGInputStream.read();
        this.fileName = new byte[bCPGInputStream.read()];
        int i = 0;
        while (true) {
            byte[] bArr = this.fileName;
            if (i != bArr.length) {
                bArr[i] = (byte) bCPGInputStream.read();
                i++;
            } else {
                this.modDate = (((long) bCPGInputStream.read()) << 24) | ((long) (bCPGInputStream.read() << 16)) | ((long) (bCPGInputStream.read() << 8)) | ((long) bCPGInputStream.read());
                return;
            }
        }
    }

    public String getFileName() {
        return Strings.fromUTF8ByteArray(this.fileName);
    }

    public int getFormat() {
        return this.format;
    }

    public long getModificationTime() {
        return this.modDate * 1000;
    }

    public byte[] getRawFileName() {
        int length = this.fileName.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = this.fileName[i];
        }
        return bArr;
    }
}
