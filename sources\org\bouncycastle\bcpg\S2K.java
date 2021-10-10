package org.bouncycastle.bcpg;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class S2K extends BCPGObject {
    private static final int EXPBIAS = 6;
    public static final int GNU_DUMMY_S2K = 101;
    public static final int SALTED = 1;
    public static final int SALTED_AND_ITERATED = 3;
    public static final int SIMPLE = 0;
    int algorithm;
    int itCount;
    byte[] iv;
    int protectionMode;
    int type;

    public S2K(int i) {
        this.itCount = -1;
        this.protectionMode = -1;
        this.type = 0;
        this.algorithm = i;
    }

    public S2K(int i, byte[] bArr) {
        this.itCount = -1;
        this.protectionMode = -1;
        this.type = 1;
        this.algorithm = i;
        this.iv = bArr;
    }

    public S2K(int i, byte[] bArr, int i2) {
        this.itCount = -1;
        this.protectionMode = -1;
        this.type = 3;
        this.algorithm = i;
        this.iv = bArr;
        this.itCount = i2;
    }

    S2K(InputStream inputStream) throws IOException {
        this.itCount = -1;
        this.protectionMode = -1;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.type = dataInputStream.read();
        this.algorithm = dataInputStream.read();
        int i = this.type;
        if (i == 101) {
            dataInputStream.read();
            dataInputStream.read();
            dataInputStream.read();
            this.protectionMode = dataInputStream.read();
        } else if (i != 0) {
            byte[] bArr = new byte[8];
            this.iv = bArr;
            dataInputStream.readFully(bArr, 0, bArr.length);
            if (this.type == 3) {
                this.itCount = dataInputStream.read();
            }
        }
    }

    @Override // org.bouncycastle.bcpg.BCPGObject
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        int i;
        bCPGOutputStream.write(this.type);
        bCPGOutputStream.write(this.algorithm);
        int i2 = this.type;
        if (i2 != 101) {
            if (i2 != 0) {
                bCPGOutputStream.write(this.iv);
            }
            if (this.type == 3) {
                i = this.itCount;
            } else {
                return;
            }
        } else {
            bCPGOutputStream.write(71);
            bCPGOutputStream.write(78);
            bCPGOutputStream.write(85);
            i = this.protectionMode;
        }
        bCPGOutputStream.write(i);
    }

    public int getHashAlgorithm() {
        return this.algorithm;
    }

    public byte[] getIV() {
        return this.iv;
    }

    public long getIterationCount() {
        int i = this.itCount;
        return (long) (((i & 15) + 16) << ((i >> 4) + 6));
    }

    public int getProtectionMode() {
        return this.protectionMode;
    }

    public int getType() {
        return this.type;
    }
}
