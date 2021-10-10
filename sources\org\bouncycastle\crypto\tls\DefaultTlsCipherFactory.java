package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.engines.AESFastEngine;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;

public class DefaultTlsCipherFactory implements TlsCipherFactory {
    /* access modifiers changed from: protected */
    public BlockCipher createAESBlockCipher() {
        return new CBCBlockCipher(new AESFastEngine());
    }

    /* access modifiers changed from: protected */
    public TlsCipher createAESCipher(TlsClientContext tlsClientContext, int i, int i2) throws IOException {
        return new TlsBlockCipher(tlsClientContext, createAESBlockCipher(), createAESBlockCipher(), createDigest(i2), createDigest(i2), i);
    }

    @Override // org.bouncycastle.crypto.tls.TlsCipherFactory
    public TlsCipher createCipher(TlsClientContext tlsClientContext, int i, int i2) throws IOException {
        if (i == 7) {
            return createDESedeCipher(tlsClientContext, 24, i2);
        }
        if (i == 8) {
            return createAESCipher(tlsClientContext, 16, i2);
        }
        if (i == 9) {
            return createAESCipher(tlsClientContext, 32, i2);
        }
        throw new TlsFatalAlert(80);
    }

    /* access modifiers changed from: protected */
    public BlockCipher createDESedeBlockCipher() {
        return new CBCBlockCipher(new DESedeEngine());
    }

    /* access modifiers changed from: protected */
    public TlsCipher createDESedeCipher(TlsClientContext tlsClientContext, int i, int i2) throws IOException {
        return new TlsBlockCipher(tlsClientContext, createDESedeBlockCipher(), createDESedeBlockCipher(), createDigest(i2), createDigest(i2), i);
    }

    /* access modifiers changed from: protected */
    public Digest createDigest(int i) throws IOException {
        if (i == 1) {
            return new MD5Digest();
        }
        if (i == 2) {
            return new SHA1Digest();
        }
        if (i == 3) {
            return new SHA256Digest();
        }
        if (i == 4) {
            return new SHA384Digest();
        }
        throw new TlsFatalAlert(80);
    }
}
