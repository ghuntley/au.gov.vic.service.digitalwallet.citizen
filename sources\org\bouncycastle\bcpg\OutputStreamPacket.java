package org.bouncycastle.bcpg;

import java.io.IOException;

public abstract class OutputStreamPacket {
    protected BCPGOutputStream out;

    public OutputStreamPacket(BCPGOutputStream bCPGOutputStream) {
        this.out = bCPGOutputStream;
    }

    public abstract void close() throws IOException;

    public abstract BCPGOutputStream open() throws IOException;
}
