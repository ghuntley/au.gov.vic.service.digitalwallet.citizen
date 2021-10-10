package org.bouncycastle.bcpg.sig;

import org.bouncycastle.bcpg.SignatureSubpacket;

public class EmbeddedSignature extends SignatureSubpacket {
    public EmbeddedSignature(boolean z, byte[] bArr) {
        super(32, z, bArr);
    }
}
