package org.bouncycastle.bcpg;

import java.io.IOException;
import java.io.OutputStream;
import org.objectweb.asm.Opcodes;

public class SignatureSubpacket {
    boolean critical;
    protected byte[] data;
    int type;

    protected SignatureSubpacket(int i, boolean z, byte[] bArr) {
        this.type = i;
        this.critical = z;
        this.data = bArr;
    }

    public void encode(OutputStream outputStream) throws IOException {
        byte b;
        int length = this.data.length + 1;
        if (length >= 192) {
            if (length <= 8383) {
                length -= 192;
                b = (byte) (((length >> 8) & 255) + Opcodes.CHECKCAST);
            } else {
                outputStream.write(255);
                outputStream.write((byte) (length >> 24));
                outputStream.write((byte) (length >> 16));
                b = (byte) (length >> 8);
            }
            outputStream.write(b);
        }
        outputStream.write((byte) length);
        outputStream.write(this.critical ? this.type | 128 : this.type);
        outputStream.write(this.data);
    }

    public byte[] getData() {
        return this.data;
    }

    public int getType() {
        return this.type;
    }

    public boolean isCritical() {
        return this.critical;
    }
}
