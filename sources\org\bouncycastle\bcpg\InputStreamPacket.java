package org.bouncycastle.bcpg;

public class InputStreamPacket extends Packet {
    private BCPGInputStream in;

    public InputStreamPacket(BCPGInputStream bCPGInputStream) {
        this.in = bCPGInputStream;
    }

    public BCPGInputStream getInputStream() {
        return this.in;
    }
}
