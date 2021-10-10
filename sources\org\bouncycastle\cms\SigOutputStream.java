package org.bouncycastle.cms;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Signature;
import java.security.SignatureException;

/* access modifiers changed from: package-private */
public class SigOutputStream extends OutputStream {
    private final Signature sig;

    SigOutputStream(Signature signature) {
        this.sig = signature;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        try {
            this.sig.update((byte) i);
        } catch (SignatureException e) {
            throw new CMSStreamException("signature problem: " + e, e);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.sig.update(bArr, i, i2);
        } catch (SignatureException e) {
            throw new CMSStreamException("signature problem: " + e, e);
        }
    }
}
