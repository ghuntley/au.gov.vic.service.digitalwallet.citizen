package org.bouncycastle.openpgp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.PublicSubkeyPacket;
import org.bouncycastle.bcpg.SecretKeyPacket;
import org.bouncycastle.bcpg.SecretSubkeyPacket;
import org.bouncycastle.bcpg.TrustPacket;

public class PGPSecretKeyRing extends PGPKeyRing {
    List extraPubKeys;
    List keys;

    public PGPSecretKeyRing(InputStream inputStream) throws IOException, PGPException {
        Object obj;
        List list;
        this.keys = new ArrayList();
        this.extraPubKeys = new ArrayList();
        BCPGInputStream wrap = wrap(inputStream);
        int nextPacketTag = wrap.nextPacketTag();
        if (nextPacketTag == 5 || nextPacketTag == 7) {
            SecretKeyPacket secretKeyPacket = (SecretKeyPacket) wrap.readPacket();
            while (wrap.nextPacketTag() == 61) {
                wrap.readPacket();
            }
            TrustPacket readOptionalTrustPacket = readOptionalTrustPacket(wrap);
            List readSignaturesAndTrust = readSignaturesAndTrust(wrap);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            readUserIDs(wrap, arrayList, arrayList2, arrayList3);
            this.keys.add(new PGPSecretKey(secretKeyPacket, new PGPPublicKey(secretKeyPacket.getPublicKeyPacket(), readOptionalTrustPacket, readSignaturesAndTrust, arrayList, arrayList2, arrayList3)));
            while (true) {
                if (wrap.nextPacketTag() == 7 || wrap.nextPacketTag() == 14) {
                    if (wrap.nextPacketTag() == 7) {
                        SecretSubkeyPacket secretSubkeyPacket = (SecretSubkeyPacket) wrap.readPacket();
                        while (wrap.nextPacketTag() == 61) {
                            wrap.readPacket();
                        }
                        TrustPacket readOptionalTrustPacket2 = readOptionalTrustPacket(wrap);
                        List readSignaturesAndTrust2 = readSignaturesAndTrust(wrap);
                        list = this.keys;
                        obj = new PGPSecretKey(secretSubkeyPacket, new PGPPublicKey(secretSubkeyPacket.getPublicKeyPacket(), readOptionalTrustPacket2, readSignaturesAndTrust2));
                    } else {
                        TrustPacket readOptionalTrustPacket3 = readOptionalTrustPacket(wrap);
                        List readSignaturesAndTrust3 = readSignaturesAndTrust(wrap);
                        list = this.extraPubKeys;
                        obj = new PGPPublicKey((PublicSubkeyPacket) wrap.readPacket(), readOptionalTrustPacket3, readSignaturesAndTrust3);
                    }
                    list.add(obj);
                } else {
                    return;
                }
            }
        } else {
            throw new IOException("secret key ring doesn't start with secret key tag: tag 0x" + Integer.toHexString(nextPacketTag));
        }
    }

    PGPSecretKeyRing(List list) {
        this(list, new ArrayList());
    }

    private PGPSecretKeyRing(List list, List list2) {
        this.keys = list;
        this.extraPubKeys = list2;
    }

    public PGPSecretKeyRing(byte[] bArr) throws IOException, PGPException {
        this(new ByteArrayInputStream(bArr));
    }

    public static PGPSecretKeyRing copyWithNewPassword(PGPSecretKeyRing pGPSecretKeyRing, char[] cArr, char[] cArr2, int i, SecureRandom secureRandom, String str) throws PGPException, NoSuchProviderException {
        return copyWithNewPassword(pGPSecretKeyRing, cArr, cArr2, i, secureRandom, PGPUtil.getProvider(str));
    }

    public static PGPSecretKeyRing copyWithNewPassword(PGPSecretKeyRing pGPSecretKeyRing, char[] cArr, char[] cArr2, int i, SecureRandom secureRandom, Provider provider) throws PGPException {
        ArrayList arrayList = new ArrayList(pGPSecretKeyRing.keys.size());
        Iterator secretKeys = pGPSecretKeyRing.getSecretKeys();
        while (secretKeys.hasNext()) {
            arrayList.add(PGPSecretKey.copyWithNewPassword((PGPSecretKey) secretKeys.next(), cArr, cArr2, i, secureRandom, provider));
        }
        return new PGPSecretKeyRing(arrayList, pGPSecretKeyRing.extraPubKeys);
    }

    public static PGPSecretKeyRing insertSecretKey(PGPSecretKeyRing pGPSecretKeyRing, PGPSecretKey pGPSecretKey) {
        ArrayList arrayList = new ArrayList(pGPSecretKeyRing.keys);
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i != arrayList.size(); i++) {
            PGPSecretKey pGPSecretKey2 = (PGPSecretKey) arrayList.get(i);
            if (pGPSecretKey2.getKeyID() == pGPSecretKey.getKeyID()) {
                arrayList.set(i, pGPSecretKey);
                z = true;
            }
            if (pGPSecretKey2.isMasterKey()) {
                z2 = true;
            }
        }
        if (!z) {
            if (!pGPSecretKey.isMasterKey()) {
                arrayList.add(pGPSecretKey);
            } else if (!z2) {
                arrayList.add(0, pGPSecretKey);
            } else {
                throw new IllegalArgumentException("cannot add a master key to a ring that already has one");
            }
        }
        return new PGPSecretKeyRing(arrayList, pGPSecretKeyRing.extraPubKeys);
    }

    public static PGPSecretKeyRing removeSecretKey(PGPSecretKeyRing pGPSecretKeyRing, PGPSecretKey pGPSecretKey) {
        ArrayList arrayList = new ArrayList(pGPSecretKeyRing.keys);
        boolean z = false;
        for (int i = 0; i < arrayList.size(); i++) {
            if (((PGPSecretKey) arrayList.get(i)).getKeyID() == pGPSecretKey.getKeyID()) {
                arrayList.remove(i);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return new PGPSecretKeyRing(arrayList, pGPSecretKeyRing.extraPubKeys);
    }

    public static PGPSecretKeyRing replacePublicKeys(PGPSecretKeyRing pGPSecretKeyRing, PGPPublicKeyRing pGPPublicKeyRing) {
        ArrayList arrayList = new ArrayList(pGPSecretKeyRing.keys.size());
        for (PGPSecretKey pGPSecretKey : pGPSecretKeyRing.keys) {
            arrayList.add(PGPSecretKey.replacePublicKey(pGPSecretKey, pGPPublicKeyRing.getPublicKey(pGPSecretKey.getKeyID())));
        }
        return new PGPSecretKeyRing(arrayList);
    }

    public void encode(OutputStream outputStream) throws IOException {
        for (int i = 0; i != this.keys.size(); i++) {
            ((PGPSecretKey) this.keys.get(i)).encode(outputStream);
        }
        for (int i2 = 0; i2 != this.extraPubKeys.size(); i2++) {
            ((PGPPublicKey) this.extraPubKeys.get(i2)).encode(outputStream);
        }
    }

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public Iterator getExtraPublicKeys() {
        return this.extraPubKeys.iterator();
    }

    public PGPPublicKey getPublicKey() {
        return ((PGPSecretKey) this.keys.get(0)).getPublicKey();
    }

    public PGPSecretKey getSecretKey() {
        return (PGPSecretKey) this.keys.get(0);
    }

    public PGPSecretKey getSecretKey(long j) {
        for (int i = 0; i != this.keys.size(); i++) {
            PGPSecretKey pGPSecretKey = (PGPSecretKey) this.keys.get(i);
            if (j == pGPSecretKey.getKeyID()) {
                return pGPSecretKey;
            }
        }
        return null;
    }

    public Iterator getSecretKeys() {
        return Collections.unmodifiableList(this.keys).iterator();
    }
}
