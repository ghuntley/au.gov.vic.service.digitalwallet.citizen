package org.bouncycastle.bcpg;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.bcpg.sig.Exportable;
import org.bouncycastle.bcpg.sig.IssuerKeyID;
import org.bouncycastle.bcpg.sig.KeyExpirationTime;
import org.bouncycastle.bcpg.sig.KeyFlags;
import org.bouncycastle.bcpg.sig.NotationData;
import org.bouncycastle.bcpg.sig.PreferredAlgorithms;
import org.bouncycastle.bcpg.sig.PrimaryUserID;
import org.bouncycastle.bcpg.sig.Revocable;
import org.bouncycastle.bcpg.sig.SignatureCreationTime;
import org.bouncycastle.bcpg.sig.SignatureExpirationTime;
import org.bouncycastle.bcpg.sig.SignerUserID;
import org.bouncycastle.bcpg.sig.TrustSignature;
import org.bouncycastle.util.io.Streams;
import org.objectweb.asm.Opcodes;

public class SignatureSubpacketInputStream extends InputStream implements SignatureSubpacketTags {
    InputStream in;

    public SignatureSubpacketInputStream(InputStream inputStream) {
        this.in = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.in.available();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.in.read();
    }

    public SignatureSubpacket readPacket() throws IOException {
        int read = read();
        if (read < 0) {
            return null;
        }
        boolean z = false;
        if (read >= 192) {
            read = read <= 223 ? ((read - 192) << 8) + this.in.read() + Opcodes.CHECKCAST : read == 255 ? (this.in.read() << 24) | (this.in.read() << 16) | (this.in.read() << 8) | this.in.read() : 0;
        }
        int read2 = this.in.read();
        if (read2 >= 0) {
            int i = read - 1;
            byte[] bArr = new byte[i];
            if (Streams.readFully(this.in, bArr) >= i) {
                if ((read2 & 128) != 0) {
                    z = true;
                }
                int i2 = read2 & 127;
                if (i2 == 2) {
                    return new SignatureCreationTime(z, bArr);
                }
                if (i2 == 3) {
                    return new SignatureExpirationTime(z, bArr);
                }
                if (i2 == 4) {
                    return new Exportable(z, bArr);
                }
                if (i2 == 5) {
                    return new TrustSignature(z, bArr);
                }
                if (i2 == 7) {
                    return new Revocable(z, bArr);
                }
                if (i2 == 9) {
                    return new KeyExpirationTime(z, bArr);
                }
                if (i2 != 11) {
                    if (i2 == 16) {
                        return new IssuerKeyID(z, bArr);
                    }
                    if (i2 == 25) {
                        return new PrimaryUserID(z, bArr);
                    }
                    if (i2 == 27) {
                        return new KeyFlags(z, bArr);
                    }
                    if (i2 == 28) {
                        return new SignerUserID(z, bArr);
                    }
                    switch (i2) {
                        case 20:
                            return new NotationData(z, bArr);
                        case 21:
                        case 22:
                            break;
                        default:
                            return new SignatureSubpacket(i2, z, bArr);
                    }
                }
                return new PreferredAlgorithms(i2, z, bArr);
            }
            throw new EOFException();
        }
        throw new EOFException("unexpected EOF reading signature sub packet");
    }
}
