package org.bouncycastle.openpgp;

import java.io.IOException;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.MarkerPacket;

public class PGPMarker {
    private MarkerPacket p;

    public PGPMarker(BCPGInputStream bCPGInputStream) throws IOException {
        this.p = (MarkerPacket) bCPGInputStream.readPacket();
    }
}
