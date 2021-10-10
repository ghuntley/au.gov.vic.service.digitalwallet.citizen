package org.bouncycastle.openpgp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.LiteralDataPacket;

public class PGPLiteralData {
    public static final char BINARY = 'b';
    public static final String CONSOLE = "_CONSOLE";
    public static final Date NOW = new Date(0);
    public static final char TEXT = 't';
    public static final char UTF8 = 'u';
    LiteralDataPacket data;

    public PGPLiteralData(BCPGInputStream bCPGInputStream) throws IOException {
        this.data = (LiteralDataPacket) bCPGInputStream.readPacket();
    }

    public InputStream getDataStream() {
        return getInputStream();
    }

    public String getFileName() {
        return this.data.getFileName();
    }

    public int getFormat() {
        return this.data.getFormat();
    }

    public InputStream getInputStream() {
        return this.data.getInputStream();
    }

    public Date getModificationTime() {
        return new Date(this.data.getModificationTime());
    }

    public byte[] getRawFileName() {
        return this.data.getRawFileName();
    }
}
