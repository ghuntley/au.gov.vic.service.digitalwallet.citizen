package org.bouncycastle.bcpg;

import java.io.IOException;

public class CompressedDataPacket extends InputStreamPacket {
    int algorithm;

    CompressedDataPacket(BCPGInputStream bCPGInputStream) throws IOException {
        super(bCPGInputStream);
        this.algorithm = bCPGInputStream.read();
    }

    public int getAlgorithm() {
        return this.algorithm;
    }
}
