package org.bouncycastle.bcpg;

import java.io.IOException;

public class SymmetricEncIntegrityPacket extends InputStreamPacket {
    int version;

    SymmetricEncIntegrityPacket(BCPGInputStream bCPGInputStream) throws IOException {
        super(bCPGInputStream);
        this.version = bCPGInputStream.read();
    }
}
