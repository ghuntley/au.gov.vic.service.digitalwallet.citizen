package org.bouncycastle.cms;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;

/* access modifiers changed from: package-private */
public class DigOutputStream extends OutputStream {
    private final MessageDigest dig;

    DigOutputStream(MessageDigest messageDigest) {
        this.dig = messageDigest;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.dig.update((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.dig.update(bArr, i, i2);
    }
}
