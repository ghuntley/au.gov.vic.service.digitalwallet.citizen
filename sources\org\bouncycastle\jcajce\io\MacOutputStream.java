package org.bouncycastle.jcajce.io;

import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Mac;

public class MacOutputStream extends OutputStream {
    protected Mac mac;

    public MacOutputStream(Mac mac2) {
        this.mac = mac2;
    }

    public byte[] getMac() {
        return this.mac.doFinal();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.mac.update((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.mac.update(bArr, i, i2);
    }
}
