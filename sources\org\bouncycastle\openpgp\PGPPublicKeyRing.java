package org.bouncycastle.openpgp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.PublicKeyPacket;
import org.bouncycastle.bcpg.TrustPacket;

public class PGPPublicKeyRing extends PGPKeyRing {
    List keys;

    public PGPPublicKeyRing(InputStream inputStream) throws IOException {
        this.keys = new ArrayList();
        BCPGInputStream wrap = wrap(inputStream);
        int nextPacketTag = wrap.nextPacketTag();
        if (nextPacketTag == 6 || nextPacketTag == 14) {
            PublicKeyPacket publicKeyPacket = (PublicKeyPacket) wrap.readPacket();
            TrustPacket readOptionalTrustPacket = readOptionalTrustPacket(wrap);
            List readSignaturesAndTrust = readSignaturesAndTrust(wrap);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            readUserIDs(wrap, arrayList, arrayList2, arrayList3);
            this.keys.add(new PGPPublicKey(publicKeyPacket, readOptionalTrustPacket, readSignaturesAndTrust, arrayList, arrayList2, arrayList3));
            while (wrap.nextPacketTag() == 14) {
                this.keys.add(readSubkey(wrap));
            }
            return;
        }
        throw new IOException("public key ring doesn't start with public key tag: tag 0x" + Integer.toHexString(nextPacketTag));
    }

    PGPPublicKeyRing(List list) {
        this.keys = list;
    }

    public PGPPublicKeyRing(byte[] bArr) throws IOException {
        this(new ByteArrayInputStream(bArr));
    }

    public static PGPPublicKeyRing insertPublicKey(PGPPublicKeyRing pGPPublicKeyRing, PGPPublicKey pGPPublicKey) {
        ArrayList arrayList = new ArrayList(pGPPublicKeyRing.keys);
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i != arrayList.size(); i++) {
            PGPPublicKey pGPPublicKey2 = (PGPPublicKey) arrayList.get(i);
            if (pGPPublicKey2.getKeyID() == pGPPublicKey.getKeyID()) {
                arrayList.set(i, pGPPublicKey);
                z = true;
            }
            if (pGPPublicKey2.isMasterKey()) {
                z2 = true;
            }
        }
        if (!z) {
            if (!pGPPublicKey.isMasterKey()) {
                arrayList.add(pGPPublicKey);
            } else if (!z2) {
                arrayList.add(0, pGPPublicKey);
            } else {
                throw new IllegalArgumentException("cannot add a master key to a ring that already has one");
            }
        }
        return new PGPPublicKeyRing(arrayList);
    }

    static PGPPublicKey readSubkey(BCPGInputStream bCPGInputStream) throws IOException {
        return new PGPPublicKey((PublicKeyPacket) bCPGInputStream.readPacket(), readOptionalTrustPacket(bCPGInputStream), readSignaturesAndTrust(bCPGInputStream));
    }

    public static PGPPublicKeyRing removePublicKey(PGPPublicKeyRing pGPPublicKeyRing, PGPPublicKey pGPPublicKey) {
        ArrayList arrayList = new ArrayList(pGPPublicKeyRing.keys);
        boolean z = false;
        for (int i = 0; i < arrayList.size(); i++) {
            if (((PGPPublicKey) arrayList.get(i)).getKeyID() == pGPPublicKey.getKeyID()) {
                arrayList.remove(i);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return new PGPPublicKeyRing(arrayList);
    }

    public void encode(OutputStream outputStream) throws IOException {
        for (int i = 0; i != this.keys.size(); i++) {
            ((PGPPublicKey) this.keys.get(i)).encode(outputStream);
        }
    }

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public PGPPublicKey getPublicKey() {
        return (PGPPublicKey) this.keys.get(0);
    }

    public PGPPublicKey getPublicKey(long j) {
        for (int i = 0; i != this.keys.size(); i++) {
            PGPPublicKey pGPPublicKey = (PGPPublicKey) this.keys.get(i);
            if (j == pGPPublicKey.getKeyID()) {
                return pGPPublicKey;
            }
        }
        return null;
    }

    public Iterator getPublicKeys() {
        return Collections.unmodifiableList(this.keys).iterator();
    }
}
