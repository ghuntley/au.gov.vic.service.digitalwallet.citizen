package org.bouncycastle.openpgp;

import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.bcpg.PublicSubkeyPacket;
import org.bouncycastle.bcpg.TrustPacket;

public class PGPKeyRingGenerator {
    private int certificationLevel;
    private int encAlgorithm;
    private PGPSignatureSubpacketVector hashedPcks;
    private String id;
    List keys;
    private PGPKeyPair masterKey;
    private char[] passPhrase;
    private Provider provider;
    private SecureRandom rand;
    private PGPSignatureSubpacketVector unhashedPcks;
    private boolean useSHA1;

    public PGPKeyRingGenerator(int i, PGPKeyPair pGPKeyPair, String str, int i2, char[] cArr, PGPSignatureSubpacketVector pGPSignatureSubpacketVector, PGPSignatureSubpacketVector pGPSignatureSubpacketVector2, SecureRandom secureRandom, String str2) throws PGPException, NoSuchProviderException {
        this(i, pGPKeyPair, str, i2, cArr, false, pGPSignatureSubpacketVector, pGPSignatureSubpacketVector2, secureRandom, str2);
    }

    public PGPKeyRingGenerator(int i, PGPKeyPair pGPKeyPair, String str, int i2, char[] cArr, boolean z, PGPSignatureSubpacketVector pGPSignatureSubpacketVector, PGPSignatureSubpacketVector pGPSignatureSubpacketVector2, SecureRandom secureRandom, String str2) throws PGPException, NoSuchProviderException {
        this(i, pGPKeyPair, str, i2, cArr, z, pGPSignatureSubpacketVector, pGPSignatureSubpacketVector2, secureRandom, PGPUtil.getProvider(str2));
    }

    public PGPKeyRingGenerator(int i, PGPKeyPair pGPKeyPair, String str, int i2, char[] cArr, boolean z, PGPSignatureSubpacketVector pGPSignatureSubpacketVector, PGPSignatureSubpacketVector pGPSignatureSubpacketVector2, SecureRandom secureRandom, Provider provider2) throws PGPException, NoSuchProviderException {
        ArrayList arrayList = new ArrayList();
        this.keys = arrayList;
        this.certificationLevel = i;
        this.masterKey = pGPKeyPair;
        this.id = str;
        this.encAlgorithm = i2;
        this.passPhrase = cArr;
        this.useSHA1 = z;
        this.hashedPcks = pGPSignatureSubpacketVector;
        this.unhashedPcks = pGPSignatureSubpacketVector2;
        this.rand = secureRandom;
        this.provider = provider2;
        arrayList.add(new PGPSecretKey(i, pGPKeyPair, str, i2, cArr, z, pGPSignatureSubpacketVector, pGPSignatureSubpacketVector2, secureRandom, provider2));
    }

    public void addSubKey(PGPKeyPair pGPKeyPair) throws PGPException {
        addSubKey(pGPKeyPair, this.hashedPcks, this.unhashedPcks);
    }

    public void addSubKey(PGPKeyPair pGPKeyPair, PGPSignatureSubpacketVector pGPSignatureSubpacketVector, PGPSignatureSubpacketVector pGPSignatureSubpacketVector2) throws PGPException {
        try {
            PGPSignatureGenerator pGPSignatureGenerator = new PGPSignatureGenerator(this.masterKey.getPublicKey().getAlgorithm(), 2, this.provider);
            pGPSignatureGenerator.initSign(24, this.masterKey.getPrivateKey());
            pGPSignatureGenerator.setHashedSubpackets(pGPSignatureSubpacketVector);
            pGPSignatureGenerator.setUnhashedSubpackets(pGPSignatureSubpacketVector2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(pGPSignatureGenerator.generateCertification(this.masterKey.getPublicKey(), pGPKeyPair.getPublicKey()));
            this.keys.add(new PGPSecretKey(pGPKeyPair.getPrivateKey(), new PGPPublicKey(pGPKeyPair.getPublicKey(), (TrustPacket) null, arrayList), this.encAlgorithm, this.passPhrase, this.useSHA1, this.rand, this.provider));
        } catch (PGPException e) {
            throw e;
        } catch (Exception e2) {
            throw new PGPException("exception adding subkey: ", e2);
        }
    }

    public PGPPublicKeyRing generatePublicKeyRing() {
        Iterator it = this.keys.iterator();
        ArrayList arrayList = new ArrayList();
        PGPPublicKey publicKey = ((PGPSecretKey) it.next()).getPublicKey();
        while (true) {
            arrayList.add(publicKey);
            if (!it.hasNext()) {
                return new PGPPublicKeyRing(arrayList);
            }
            publicKey = new PGPPublicKey(((PGPSecretKey) it.next()).getPublicKey());
            publicKey.publicPk = new PublicSubkeyPacket(publicKey.getAlgorithm(), publicKey.getCreationTime(), publicKey.publicPk.getKey());
        }
    }

    public PGPSecretKeyRing generateSecretKeyRing() {
        return new PGPSecretKeyRing(this.keys);
    }
}
