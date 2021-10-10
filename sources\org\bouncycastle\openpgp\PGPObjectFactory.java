package org.bouncycastle.openpgp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.bouncycastle.bcpg.BCPGInputStream;

public class PGPObjectFactory {
    BCPGInputStream in;

    public PGPObjectFactory(InputStream inputStream) {
        this.in = new BCPGInputStream(inputStream);
    }

    public PGPObjectFactory(byte[] bArr) {
        this(new ByteArrayInputStream(bArr));
    }

    public Object nextObject() throws IOException {
        int nextPacketTag = this.in.nextPacketTag();
        if (nextPacketTag == -1) {
            return null;
        }
        if (nextPacketTag == 8) {
            return new PGPCompressedData(this.in);
        }
        if (nextPacketTag == 14) {
            return PGPPublicKeyRing.readSubkey(this.in);
        }
        if (nextPacketTag == 10) {
            return new PGPMarker(this.in);
        }
        if (nextPacketTag == 11) {
            return new PGPLiteralData(this.in);
        }
        switch (nextPacketTag) {
            case 1:
            case 3:
                return new PGPEncryptedDataList(this.in);
            case 2:
                ArrayList arrayList = new ArrayList();
                while (this.in.nextPacketTag() == 2) {
                    try {
                        arrayList.add(new PGPSignature(this.in));
                    } catch (PGPException e) {
                        throw new IOException("can't create signature object: " + e);
                    }
                }
                return new PGPSignatureList((PGPSignature[]) arrayList.toArray(new PGPSignature[arrayList.size()]));
            case 4:
                ArrayList arrayList2 = new ArrayList();
                while (this.in.nextPacketTag() == 4) {
                    try {
                        arrayList2.add(new PGPOnePassSignature(this.in));
                    } catch (PGPException e2) {
                        throw new IOException("can't create one pass signature object: " + e2);
                    }
                }
                return new PGPOnePassSignatureList((PGPOnePassSignature[]) arrayList2.toArray(new PGPOnePassSignature[arrayList2.size()]));
            case 5:
                try {
                    return new PGPSecretKeyRing(this.in);
                } catch (PGPException e3) {
                    throw new IOException("can't create secret key object: " + e3);
                }
            case 6:
                return new PGPPublicKeyRing(this.in);
            default:
                switch (nextPacketTag) {
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                        return this.in.readPacket();
                    default:
                        throw new IOException("unknown object in stream: " + this.in.nextPacketTag());
                }
        }
    }
}
