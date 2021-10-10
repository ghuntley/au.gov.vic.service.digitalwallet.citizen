package org.bouncycastle.bcpg;

import java.io.IOException;
import java.util.Date;

public class PublicSubkeyPacket extends PublicKeyPacket {
    public PublicSubkeyPacket(int i, Date date, BCPGKey bCPGKey) {
        super(i, date, bCPGKey);
    }

    PublicSubkeyPacket(BCPGInputStream bCPGInputStream) throws IOException {
        super(bCPGInputStream);
    }

    @Override // org.bouncycastle.bcpg.ContainedPacket, org.bouncycastle.bcpg.PublicKeyPacket
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writePacket(14, getEncodedContents(), true);
    }
}
