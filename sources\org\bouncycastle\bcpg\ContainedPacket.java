package org.bouncycastle.bcpg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class ContainedPacket extends Packet {
    public abstract void encode(BCPGOutputStream bCPGOutputStream) throws IOException;

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new BCPGOutputStream(byteArrayOutputStream).writePacket(this);
        return byteArrayOutputStream.toByteArray();
    }
}
