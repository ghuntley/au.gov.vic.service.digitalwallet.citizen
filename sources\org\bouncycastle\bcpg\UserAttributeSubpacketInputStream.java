package org.bouncycastle.bcpg;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.bcpg.attr.ImageAttribute;
import org.objectweb.asm.Opcodes;

public class UserAttributeSubpacketInputStream extends InputStream implements UserAttributeSubpacketTags {
    InputStream in;

    public UserAttributeSubpacketInputStream(InputStream inputStream) {
        this.in = inputStream;
    }

    private void readFully(byte[] bArr, int i, int i2) throws IOException {
        if (i2 > 0) {
            int read = read();
            if (read >= 0) {
                bArr[i] = (byte) read;
                i++;
                i2--;
            } else {
                throw new EOFException();
            }
        }
        while (i2 > 0) {
            int read2 = this.in.read(bArr, i, i2);
            if (read2 >= 0) {
                i += read2;
                i2 -= read2;
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.in.available();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.in.read();
    }

    public UserAttributeSubpacket readPacket() throws IOException {
        int read = read();
        if (read < 0) {
            return null;
        }
        if (read >= 192) {
            read = read <= 223 ? ((read - 192) << 8) + this.in.read() + Opcodes.CHECKCAST : read == 255 ? (this.in.read() << 24) | (this.in.read() << 16) | (this.in.read() << 8) | this.in.read() : 0;
        }
        int read2 = this.in.read();
        if (read2 >= 0) {
            int i = read - 1;
            byte[] bArr = new byte[i];
            readFully(bArr, 0, i);
            return read2 != 1 ? new UserAttributeSubpacket(read2, bArr) : new ImageAttribute(bArr);
        }
        throw new EOFException("unexpected EOF reading user attribute sub packet");
    }
}
