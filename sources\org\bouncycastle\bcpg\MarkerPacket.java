package org.bouncycastle.bcpg;

import java.io.IOException;

public class MarkerPacket extends ContainedPacket {
    byte[] marker;

    public MarkerPacket(BCPGInputStream bCPGInputStream) throws IOException {
        byte[] bArr = {80, 71, 80};
        this.marker = bArr;
        bCPGInputStream.readFully(bArr);
    }

    @Override // org.bouncycastle.bcpg.ContainedPacket
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writePacket(10, this.marker, true);
    }
}
