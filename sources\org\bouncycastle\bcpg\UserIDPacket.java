package org.bouncycastle.bcpg;

import java.io.IOException;
import org.bouncycastle.util.Strings;

public class UserIDPacket extends ContainedPacket {
    private byte[] idData;

    public UserIDPacket(String str) {
        this.idData = Strings.toUTF8ByteArray(str);
    }

    public UserIDPacket(BCPGInputStream bCPGInputStream) throws IOException {
        byte[] bArr = new byte[bCPGInputStream.available()];
        this.idData = bArr;
        bCPGInputStream.readFully(bArr);
    }

    @Override // org.bouncycastle.bcpg.ContainedPacket
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writePacket(13, this.idData, true);
    }

    public String getID() {
        return Strings.fromUTF8ByteArray(this.idData);
    }
}
