package org.bouncycastle.bcpg;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;
import org.objectweb.asm.Opcodes;

public class BCPGInputStream extends InputStream implements PacketTags {
    InputStream in;
    boolean next = false;
    int nextB;

    private static class PartialInputStream extends InputStream {
        private int dataLength;
        private BCPGInputStream in;
        private boolean partial;

        PartialInputStream(BCPGInputStream bCPGInputStream, boolean z, int i) {
            this.in = bCPGInputStream;
            this.partial = z;
            this.dataLength = i;
        }

        private int loadDataLength() throws IOException {
            int read = this.in.read();
            if (read < 0) {
                return -1;
            }
            this.partial = false;
            if (read >= 192) {
                if (read <= 223) {
                    read = ((read - Opcodes.CHECKCAST) << 8) + this.in.read() + Opcodes.CHECKCAST;
                } else if (read == 255) {
                    read = (this.in.read() << 24) | (this.in.read() << 16) | (this.in.read() << 8) | this.in.read();
                } else {
                    this.partial = true;
                    read = 1 << (read & 31);
                }
            }
            this.dataLength = read;
            return this.dataLength;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            int available = this.in.available();
            int i = this.dataLength;
            if (available <= i || i < 0) {
                return available;
            }
            if (!this.partial || i != 0) {
                return i;
            }
            return 1;
        }

        /* JADX WARNING: Removed duplicated region for block: B:8:0x001b  */
        @Override // java.io.InputStream
        public int read() throws IOException {
            while (this.dataLength == 0) {
                if (!this.partial || loadDataLength() < 0) {
                    return -1;
                }
                while (this.dataLength == 0) {
                }
            }
            int read = this.in.read();
            if (read >= 0) {
                this.dataLength--;
                return read;
            }
            throw new EOFException("premature end of stream in PartialInputStream");
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            do {
                int i3 = this.dataLength;
                if (i3 != 0) {
                    if (i3 <= i2 && i3 >= 0) {
                        i2 = i3;
                    }
                    int read = this.in.read(bArr, i, i2);
                    if (read >= 0) {
                        this.dataLength -= read;
                        return read;
                    }
                    throw new EOFException("premature end of stream in PartialInputStream");
                } else if (!this.partial) {
                    return -1;
                }
            } while (loadDataLength() >= 0);
            return -1;
        }
    }

    public BCPGInputStream(InputStream inputStream) {
        this.in = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.in.available();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() throws IOException {
        this.in.close();
    }

    public int nextPacketTag() throws IOException {
        if (!this.next) {
            try {
                this.nextB = this.in.read();
            } catch (EOFException unused) {
                this.nextB = -1;
            }
        }
        this.next = true;
        int i = this.nextB;
        if (i < 0) {
            return i;
        }
        int i2 = i & 64;
        int i3 = i & 63;
        return i2 != 0 ? i3 : i3 >> 2;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (!this.next) {
            return this.in.read();
        }
        this.next = false;
        return this.nextB;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (!this.next) {
            return this.in.read(bArr, i, i2);
        }
        int i3 = this.nextB;
        if (i3 < 0) {
            return -1;
        }
        bArr[i] = (byte) i3;
        this.next = false;
        return 1;
    }

    public void readFully(byte[] bArr) throws IOException {
        readFully(bArr, 0, bArr.length);
    }

    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        if (Streams.readFully(this, bArr, i, i2) < i2) {
            throw new EOFException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x009f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0139  */
    public Packet readPacket() throws IOException {
        int i;
        int i2;
        int i3;
        int i4;
        int read = read();
        if (read < 0) {
            return null;
        }
        if ((read & 128) != 0) {
            int i5 = 0;
            boolean z = true;
            if ((read & 64) != 0) {
                i = read & 63;
                i2 = read();
                if (i2 >= 192) {
                    if (i2 <= 223) {
                        i2 = ((i2 - 192) << 8) + this.in.read() + Opcodes.CHECKCAST;
                    } else if (i2 == 255) {
                        i4 = (this.in.read() << 24) | (this.in.read() << 16) | (this.in.read() << 8);
                        i3 = this.in.read();
                    } else {
                        i2 = 1 << (i2 & 31);
                        i5 = i2;
                        BCPGInputStream bCPGInputStream = (i5 == 0 || !z) ? new BCPGInputStream(new PartialInputStream(this, z, i5)) : this;
                        switch (i) {
                            case 0:
                                return new InputStreamPacket(bCPGInputStream);
                            case 1:
                                return new PublicKeyEncSessionPacket(bCPGInputStream);
                            case 2:
                                return new SignaturePacket(bCPGInputStream);
                            case 3:
                                return new SymmetricKeyEncSessionPacket(bCPGInputStream);
                            case 4:
                                return new OnePassSignaturePacket(bCPGInputStream);
                            case 5:
                                return new SecretKeyPacket(bCPGInputStream);
                            case 6:
                                return new PublicKeyPacket(bCPGInputStream);
                            case 7:
                                return new SecretSubkeyPacket(bCPGInputStream);
                            case 8:
                                return new CompressedDataPacket(bCPGInputStream);
                            case 9:
                                return new SymmetricEncDataPacket(bCPGInputStream);
                            case 10:
                                return new MarkerPacket(bCPGInputStream);
                            case 11:
                                return new LiteralDataPacket(bCPGInputStream);
                            case 12:
                                return new TrustPacket(bCPGInputStream);
                            case 13:
                                return new UserIDPacket(bCPGInputStream);
                            case 14:
                                return new PublicSubkeyPacket(bCPGInputStream);
                            default:
                                switch (i) {
                                    case 17:
                                        return new UserAttributePacket(bCPGInputStream);
                                    case 18:
                                        return new SymmetricEncIntegrityPacket(bCPGInputStream);
                                    case 19:
                                        return new ModDetectionCodePacket(bCPGInputStream);
                                    default:
                                        switch (i) {
                                            case 60:
                                            case 61:
                                            case 62:
                                            case 63:
                                                return new ExperimentalPacket(i, bCPGInputStream);
                                            default:
                                                throw new IOException("unknown packet type encountered: " + i);
                                        }
                                }
                        }
                    }
                }
                z = false;
                i5 = i2;
                if (i5 == 0) {
                }
                switch (i) {
                }
            } else {
                int i6 = read & 3;
                i = (read & 63) >> 2;
                if (i6 != 0) {
                    if (i6 == 1) {
                        i4 = read() << 8;
                    } else if (i6 != 2) {
                        if (i6 != 3) {
                            throw new IOException("unknown length type encountered");
                        }
                        if (i5 == 0) {
                        }
                        switch (i) {
                        }
                    } else {
                        i4 = (read() << 24) | (read() << 16) | (read() << 8);
                    }
                    i3 = read();
                } else {
                    i2 = read();
                    z = false;
                    i5 = i2;
                    if (i5 == 0) {
                    }
                    switch (i) {
                    }
                }
            }
            i2 = i4 | i3;
            z = false;
            i5 = i2;
            if (i5 == 0) {
            }
            switch (i) {
            }
        } else {
            throw new IOException("invalid header encountered");
        }
    }
}
