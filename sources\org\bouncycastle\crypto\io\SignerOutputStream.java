package org.bouncycastle.crypto.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.Signer;

public class SignerOutputStream extends FilterOutputStream {
    protected Signer signer;

    public SignerOutputStream(OutputStream outputStream, Signer signer2) {
        super(outputStream);
        this.signer = signer2;
    }

    public Signer getSigner() {
        return this.signer;
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream
    public void write(int i) throws IOException {
        this.signer.update((byte) i);
        this.out.write(i);
    }

    @Override // java.io.OutputStream, java.io.FilterOutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.signer.update(bArr, i, i2);
        this.out.write(bArr, i, i2);
    }
}
