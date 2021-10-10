package org.bouncycastle.crypto.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.Digest;

public class DigestOutputStream extends FilterOutputStream {
    protected Digest digest;

    public DigestOutputStream(OutputStream outputStream, Digest digest2) {
        super(outputStream);
        this.digest = digest2;
    }

    public Digest getDigest() {
        return this.digest;
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream
    public void write(int i) throws IOException {
        this.digest.update((byte) i);
        this.out.write(i);
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.digest.update(bArr, i, i2);
        this.out.write(bArr, i, i2);
    }
}
