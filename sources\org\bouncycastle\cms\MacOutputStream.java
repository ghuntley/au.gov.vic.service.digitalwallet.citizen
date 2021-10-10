package org.bouncycastle.cms;

import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Mac;

class MacOutputStream extends OutputStream {
    private final Mac mac;

    MacOutputStream(Mac mac2) {
        this.mac = mac2;
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
