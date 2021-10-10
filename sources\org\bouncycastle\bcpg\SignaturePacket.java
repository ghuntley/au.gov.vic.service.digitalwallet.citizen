package org.bouncycastle.bcpg;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Vector;
import org.bouncycastle.bcpg.sig.IssuerKeyID;
import org.bouncycastle.bcpg.sig.SignatureCreationTime;
import org.bouncycastle.util.Arrays;

public class SignaturePacket extends ContainedPacket implements PublicKeyAlgorithmTags {
    private long creationTime;
    private byte[] fingerPrint;
    private int hashAlgorithm;
    private SignatureSubpacket[] hashedData;
    private int keyAlgorithm;
    private long keyID;
    private MPInteger[] signature;
    private byte[] signatureEncoding;
    private int signatureType;
    private SignatureSubpacket[] unhashedData;
    private int version;

    public SignaturePacket(int i, int i2, long j, int i3, int i4, long j2, byte[] bArr, MPInteger[] mPIntegerArr) {
        this(i, i2, j, i3, i4, null, null, bArr, mPIntegerArr);
        this.creationTime = j2;
    }

    public SignaturePacket(int i, int i2, long j, int i3, int i4, SignatureSubpacket[] signatureSubpacketArr, SignatureSubpacket[] signatureSubpacketArr2, byte[] bArr, MPInteger[] mPIntegerArr) {
        this.version = i;
        this.signatureType = i2;
        this.keyID = j;
        this.keyAlgorithm = i3;
        this.hashAlgorithm = i4;
        this.hashedData = signatureSubpacketArr;
        this.unhashedData = signatureSubpacketArr2;
        this.fingerPrint = bArr;
        this.signature = mPIntegerArr;
        if (signatureSubpacketArr != null) {
            setCreationTime();
        }
    }

    public SignaturePacket(int i, long j, int i2, int i3, SignatureSubpacket[] signatureSubpacketArr, SignatureSubpacket[] signatureSubpacketArr2, byte[] bArr, MPInteger[] mPIntegerArr) {
        this(4, i, j, i2, i3, signatureSubpacketArr, signatureSubpacketArr2, bArr, mPIntegerArr);
    }

    SignaturePacket(BCPGInputStream bCPGInputStream) throws IOException {
        int read = bCPGInputStream.read();
        this.version = read;
        if (read == 3 || read == 2) {
            bCPGInputStream.read();
            this.signatureType = bCPGInputStream.read();
            this.creationTime = ((((long) bCPGInputStream.read()) << 24) | ((long) (bCPGInputStream.read() << 16)) | ((long) (bCPGInputStream.read() << 8)) | ((long) bCPGInputStream.read())) * 1000;
            long read2 = this.keyID | (((long) bCPGInputStream.read()) << 56);
            this.keyID = read2;
            long read3 = read2 | (((long) bCPGInputStream.read()) << 48);
            this.keyID = read3;
            long read4 = read3 | (((long) bCPGInputStream.read()) << 40);
            this.keyID = read4;
            long read5 = read4 | (((long) bCPGInputStream.read()) << 32);
            this.keyID = read5;
            long read6 = read5 | (((long) bCPGInputStream.read()) << 24);
            this.keyID = read6;
            long read7 = read6 | (((long) bCPGInputStream.read()) << 16);
            this.keyID = read7;
            long read8 = read7 | (((long) bCPGInputStream.read()) << 8);
            this.keyID = read8;
            this.keyID = read8 | ((long) bCPGInputStream.read());
            this.keyAlgorithm = bCPGInputStream.read();
            this.hashAlgorithm = bCPGInputStream.read();
        } else if (read == 4) {
            this.signatureType = bCPGInputStream.read();
            this.keyAlgorithm = bCPGInputStream.read();
            this.hashAlgorithm = bCPGInputStream.read();
            byte[] bArr = new byte[((bCPGInputStream.read() << 8) | bCPGInputStream.read())];
            bCPGInputStream.readFully(bArr);
            SignatureSubpacketInputStream signatureSubpacketInputStream = new SignatureSubpacketInputStream(new ByteArrayInputStream(bArr));
            Vector vector = new Vector();
            while (true) {
                SignatureSubpacket readPacket = signatureSubpacketInputStream.readPacket();
                if (readPacket == null) {
                    break;
                }
                vector.addElement(readPacket);
            }
            this.hashedData = new SignatureSubpacket[vector.size()];
            for (int i = 0; i != this.hashedData.length; i++) {
                SignatureSubpacket signatureSubpacket = (SignatureSubpacket) vector.elementAt(i);
                if (signatureSubpacket instanceof IssuerKeyID) {
                    this.keyID = ((IssuerKeyID) signatureSubpacket).getKeyID();
                } else if (signatureSubpacket instanceof SignatureCreationTime) {
                    this.creationTime = ((SignatureCreationTime) signatureSubpacket).getTime().getTime();
                }
                this.hashedData[i] = signatureSubpacket;
            }
            byte[] bArr2 = new byte[((bCPGInputStream.read() << 8) | bCPGInputStream.read())];
            bCPGInputStream.readFully(bArr2);
            SignatureSubpacketInputStream signatureSubpacketInputStream2 = new SignatureSubpacketInputStream(new ByteArrayInputStream(bArr2));
            vector.removeAllElements();
            while (true) {
                SignatureSubpacket readPacket2 = signatureSubpacketInputStream2.readPacket();
                if (readPacket2 == null) {
                    break;
                }
                vector.addElement(readPacket2);
            }
            this.unhashedData = new SignatureSubpacket[vector.size()];
            for (int i2 = 0; i2 != this.unhashedData.length; i2++) {
                SignatureSubpacket signatureSubpacket2 = (SignatureSubpacket) vector.elementAt(i2);
                if (signatureSubpacket2 instanceof IssuerKeyID) {
                    this.keyID = ((IssuerKeyID) signatureSubpacket2).getKeyID();
                }
                this.unhashedData[i2] = signatureSubpacket2;
            }
        } else {
            throw new RuntimeException("unsupported version: " + this.version);
        }
        byte[] bArr3 = new byte[2];
        this.fingerPrint = bArr3;
        bCPGInputStream.readFully(bArr3);
        int i3 = this.keyAlgorithm;
        if (i3 == 1 || i3 == 3) {
            MPInteger mPInteger = new MPInteger(bCPGInputStream);
            MPInteger[] mPIntegerArr = new MPInteger[1];
            this.signature = mPIntegerArr;
            mPIntegerArr[0] = mPInteger;
        } else if (i3 == 20 || i3 == 16) {
            MPInteger mPInteger2 = new MPInteger(bCPGInputStream);
            MPInteger mPInteger3 = new MPInteger(bCPGInputStream);
            MPInteger mPInteger4 = new MPInteger(bCPGInputStream);
            MPInteger[] mPIntegerArr2 = new MPInteger[3];
            this.signature = mPIntegerArr2;
            mPIntegerArr2[0] = mPInteger2;
            mPIntegerArr2[1] = mPInteger3;
            mPIntegerArr2[2] = mPInteger4;
        } else if (i3 == 17) {
            MPInteger mPInteger5 = new MPInteger(bCPGInputStream);
            MPInteger mPInteger6 = new MPInteger(bCPGInputStream);
            MPInteger[] mPIntegerArr3 = new MPInteger[2];
            this.signature = mPIntegerArr3;
            mPIntegerArr3[0] = mPInteger5;
            mPIntegerArr3[1] = mPInteger6;
        } else if (i3 < 100 || i3 > 110) {
            throw new IOException("unknown signature key algorithm: " + this.keyAlgorithm);
        } else {
            this.signature = null;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read9 = bCPGInputStream.read();
                if (read9 >= 0) {
                    byteArrayOutputStream.write(read9);
                } else {
                    this.signatureEncoding = byteArrayOutputStream.toByteArray();
                    return;
                }
            }
        }
    }

    private void setCreationTime() {
        int i = 0;
        while (true) {
            SignatureSubpacket[] signatureSubpacketArr = this.hashedData;
            if (i == signatureSubpacketArr.length) {
                return;
            }
            if (signatureSubpacketArr[i] instanceof SignatureCreationTime) {
                this.creationTime = ((SignatureCreationTime) signatureSubpacketArr[i]).getTime().getTime();
                return;
            }
            i++;
        }
    }

    @Override // org.bouncycastle.bcpg.ContainedPacket
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BCPGOutputStream bCPGOutputStream2 = new BCPGOutputStream(byteArrayOutputStream);
        bCPGOutputStream2.write(this.version);
        int i = this.version;
        int i2 = 0;
        if (i == 3 || i == 2) {
            bCPGOutputStream2.write(5);
            long j = this.creationTime / 1000;
            bCPGOutputStream2.write(this.signatureType);
            bCPGOutputStream2.write((byte) ((int) (j >> 24)));
            bCPGOutputStream2.write((byte) ((int) (j >> 16)));
            bCPGOutputStream2.write((byte) ((int) (j >> 8)));
            bCPGOutputStream2.write((byte) ((int) j));
            bCPGOutputStream2.write((byte) ((int) (this.keyID >> 56)));
            bCPGOutputStream2.write((byte) ((int) (this.keyID >> 48)));
            bCPGOutputStream2.write((byte) ((int) (this.keyID >> 40)));
            bCPGOutputStream2.write((byte) ((int) (this.keyID >> 32)));
            bCPGOutputStream2.write((byte) ((int) (this.keyID >> 24)));
            bCPGOutputStream2.write((byte) ((int) (this.keyID >> 16)));
            bCPGOutputStream2.write((byte) ((int) (this.keyID >> 8)));
            bCPGOutputStream2.write((byte) ((int) this.keyID));
            bCPGOutputStream2.write(this.keyAlgorithm);
            bCPGOutputStream2.write(this.hashAlgorithm);
        } else if (i == 4) {
            bCPGOutputStream2.write(this.signatureType);
            bCPGOutputStream2.write(this.keyAlgorithm);
            bCPGOutputStream2.write(this.hashAlgorithm);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            int i3 = 0;
            while (true) {
                SignatureSubpacket[] signatureSubpacketArr = this.hashedData;
                if (i3 == signatureSubpacketArr.length) {
                    break;
                }
                signatureSubpacketArr[i3].encode(byteArrayOutputStream2);
                i3++;
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            bCPGOutputStream2.write(byteArray.length >> 8);
            bCPGOutputStream2.write(byteArray.length);
            bCPGOutputStream2.write(byteArray);
            byteArrayOutputStream2.reset();
            int i4 = 0;
            while (true) {
                SignatureSubpacket[] signatureSubpacketArr2 = this.unhashedData;
                if (i4 == signatureSubpacketArr2.length) {
                    break;
                }
                signatureSubpacketArr2[i4].encode(byteArrayOutputStream2);
                i4++;
            }
            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
            bCPGOutputStream2.write(byteArray2.length >> 8);
            bCPGOutputStream2.write(byteArray2.length);
            bCPGOutputStream2.write(byteArray2);
        } else {
            throw new IOException("unknown version: " + this.version);
        }
        bCPGOutputStream2.write(this.fingerPrint);
        if (this.signature != null) {
            while (true) {
                MPInteger[] mPIntegerArr = this.signature;
                if (i2 == mPIntegerArr.length) {
                    break;
                }
                bCPGOutputStream2.writeObject(mPIntegerArr[i2]);
                i2++;
            }
        } else {
            bCPGOutputStream2.write(this.signatureEncoding);
        }
        bCPGOutputStream.writePacket(2, byteArrayOutputStream.toByteArray(), true);
    }

    public long getCreationTime() {
        return this.creationTime;
    }

    public int getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public SignatureSubpacket[] getHashedSubPackets() {
        return this.hashedData;
    }

    public int getKeyAlgorithm() {
        return this.keyAlgorithm;
    }

    public long getKeyID() {
        return this.keyID;
    }

    public MPInteger[] getSignature() {
        return this.signature;
    }

    public byte[] getSignatureBytes() {
        byte[] bArr = this.signatureEncoding;
        if (bArr != null) {
            return Arrays.clone(bArr);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(byteArrayOutputStream);
        int i = 0;
        while (true) {
            MPInteger[] mPIntegerArr = this.signature;
            if (i == mPIntegerArr.length) {
                return byteArrayOutputStream.toByteArray();
            }
            try {
                bCPGOutputStream.writeObject(mPIntegerArr[i]);
                i++;
            } catch (IOException e) {
                throw new RuntimeException("internal error: " + e);
            }
        }
    }

    public byte[] getSignatureTrailer() {
        int i = this.version;
        if (i == 3 || i == 2) {
            long j = this.creationTime / 1000;
            return new byte[]{(byte) this.signatureType, (byte) ((int) (j >> 24)), (byte) ((int) (j >> 16)), (byte) ((int) (j >> 8)), (byte) ((int) j)};
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write((byte) getVersion());
            byteArrayOutputStream.write((byte) getSignatureType());
            byteArrayOutputStream.write((byte) getKeyAlgorithm());
            byteArrayOutputStream.write((byte) getHashAlgorithm());
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            SignatureSubpacket[] hashedSubPackets = getHashedSubPackets();
            for (int i2 = 0; i2 != hashedSubPackets.length; i2++) {
                hashedSubPackets[i2].encode(byteArrayOutputStream2);
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            byteArrayOutputStream.write((byte) (byteArray.length >> 8));
            byteArrayOutputStream.write((byte) byteArray.length);
            byteArrayOutputStream.write(byteArray);
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.write((byte) getVersion());
            byteArrayOutputStream.write(-1);
            byteArrayOutputStream.write((byte) (byteArray2.length >> 24));
            byteArrayOutputStream.write((byte) (byteArray2.length >> 16));
            byteArrayOutputStream.write((byte) (byteArray2.length >> 8));
            byteArrayOutputStream.write((byte) byteArray2.length);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("exception generating trailer: " + e);
        }
    }

    public int getSignatureType() {
        return this.signatureType;
    }

    public SignatureSubpacket[] getUnhashedSubPackets() {
        return this.unhashedData;
    }

    public int getVersion() {
        return this.version;
    }
}
