package org.bouncycastle.openpgp;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.DigestOutputStream;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import kotlin.UByte;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.bcpg.ContainedPacket;
import org.bouncycastle.bcpg.PublicKeyEncSessionPacket;
import org.bouncycastle.bcpg.S2K;
import org.bouncycastle.bcpg.SymmetricKeyAlgorithmTags;
import org.bouncycastle.bcpg.SymmetricKeyEncSessionPacket;

public class PGPEncryptedDataGenerator implements SymmetricKeyAlgorithmTags, StreamGenerator {
    public static final int S2K_SHA1 = 2;
    public static final int S2K_SHA224 = 11;
    public static final int S2K_SHA256 = 8;
    public static final int S2K_SHA384 = 9;
    public static final int S2K_SHA512 = 10;
    private Cipher c;
    private CipherOutputStream cOut;
    private int defAlgorithm;
    private Provider defProvider;
    private DigestOutputStream digestOut;
    private List methods;
    private boolean oldFormat;
    private BCPGOutputStream pOut;
    private SecureRandom rand;
    private boolean withIntegrityPacket;

    /* access modifiers changed from: private */
    public abstract class EncMethod extends ContainedPacket {
        protected int encAlgorithm;
        protected Key key;
        protected byte[] sessionInfo;

        private EncMethod() {
        }

        public abstract void addSessionInfo(byte[] bArr) throws Exception;
    }

    /* access modifiers changed from: private */
    public class PBEMethod extends EncMethod {
        S2K s2k;

        PBEMethod(int i, S2K s2k2, Key key) {
            super();
            this.encAlgorithm = i;
            this.s2k = s2k2;
            this.key = key;
        }

        @Override // org.bouncycastle.openpgp.PGPEncryptedDataGenerator.EncMethod
        public void addSessionInfo(byte[] bArr) throws Exception {
            String symmetricCipherName = PGPUtil.getSymmetricCipherName(this.encAlgorithm);
            Cipher instance = Cipher.getInstance(symmetricCipherName + "/CFB/NoPadding", PGPEncryptedDataGenerator.this.defProvider);
            instance.init(1, this.key, new IvParameterSpec(new byte[instance.getBlockSize()]), PGPEncryptedDataGenerator.this.rand);
            this.sessionInfo = instance.doFinal(bArr, 0, bArr.length + -2);
        }

        @Override // org.bouncycastle.bcpg.ContainedPacket
        public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
            bCPGOutputStream.writePacket(new SymmetricKeyEncSessionPacket(this.encAlgorithm, this.s2k, this.sessionInfo));
        }

        public Key getKey() {
            return this.key;
        }
    }

    /* access modifiers changed from: private */
    public class PubMethod extends EncMethod {
        BigInteger[] data;
        PGPPublicKey pubKey;

        PubMethod(PGPPublicKey pGPPublicKey) {
            super();
            this.pubKey = pGPPublicKey;
        }

        @Override // org.bouncycastle.openpgp.PGPEncryptedDataGenerator.EncMethod
        public void addSessionInfo(byte[] bArr) throws Exception {
            String str;
            Provider provider;
            int algorithm = this.pubKey.getAlgorithm();
            if (algorithm == 1 || algorithm == 2) {
                provider = PGPEncryptedDataGenerator.this.defProvider;
                str = "RSA/ECB/PKCS1Padding";
            } else {
                if (algorithm != 16) {
                    if (algorithm == 17) {
                        throw new PGPException("Can't use DSA for encryption.");
                    } else if (algorithm == 19) {
                        throw new PGPException("Can't use ECDSA for encryption.");
                    } else if (algorithm != 20) {
                        throw new PGPException("unknown asymmetric algorithm: " + this.pubKey.getAlgorithm());
                    }
                }
                provider = PGPEncryptedDataGenerator.this.defProvider;
                str = "ElGamal/ECB/PKCS1Padding";
            }
            Cipher instance = Cipher.getInstance(str, provider);
            instance.init(1, this.pubKey.getKey(PGPEncryptedDataGenerator.this.defProvider), PGPEncryptedDataGenerator.this.rand);
            byte[] doFinal = instance.doFinal(bArr);
            int algorithm2 = this.pubKey.getAlgorithm();
            if (algorithm2 == 1 || algorithm2 == 2) {
                BigInteger[] bigIntegerArr = new BigInteger[1];
                this.data = bigIntegerArr;
                bigIntegerArr[0] = new BigInteger(1, doFinal);
            } else if (algorithm2 == 16 || algorithm2 == 20) {
                int length = doFinal.length / 2;
                byte[] bArr2 = new byte[length];
                int length2 = doFinal.length / 2;
                byte[] bArr3 = new byte[length2];
                System.arraycopy(doFinal, 0, bArr2, 0, length);
                System.arraycopy(doFinal, length, bArr3, 0, length2);
                BigInteger[] bigIntegerArr2 = new BigInteger[2];
                this.data = bigIntegerArr2;
                bigIntegerArr2[0] = new BigInteger(1, bArr2);
                this.data[1] = new BigInteger(1, bArr3);
            } else {
                throw new PGPException("unknown asymmetric algorithm: " + this.encAlgorithm);
            }
        }

        @Override // org.bouncycastle.bcpg.ContainedPacket
        public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
            bCPGOutputStream.writePacket(new PublicKeyEncSessionPacket(this.pubKey.getKeyID(), this.pubKey.getAlgorithm(), this.data));
        }
    }

    public PGPEncryptedDataGenerator(int i, SecureRandom secureRandom, String str) {
        this(i, secureRandom, Security.getProvider(str));
    }

    public PGPEncryptedDataGenerator(int i, SecureRandom secureRandom, Provider provider) {
        this.withIntegrityPacket = false;
        this.oldFormat = false;
        this.methods = new ArrayList();
        this.defAlgorithm = i;
        this.rand = secureRandom;
        this.defProvider = provider;
    }

    public PGPEncryptedDataGenerator(int i, SecureRandom secureRandom, boolean z, String str) {
        this.withIntegrityPacket = false;
        this.oldFormat = false;
        this.methods = new ArrayList();
        this.defAlgorithm = i;
        this.rand = secureRandom;
        this.defProvider = Security.getProvider(str);
        this.oldFormat = z;
    }

    public PGPEncryptedDataGenerator(int i, SecureRandom secureRandom, boolean z, Provider provider) {
        this.withIntegrityPacket = false;
        this.oldFormat = false;
        this.methods = new ArrayList();
        this.defAlgorithm = i;
        this.rand = secureRandom;
        this.defProvider = provider;
        this.oldFormat = z;
    }

    public PGPEncryptedDataGenerator(int i, boolean z, SecureRandom secureRandom, String str) {
        this(i, z, secureRandom, Security.getProvider(str));
    }

    public PGPEncryptedDataGenerator(int i, boolean z, SecureRandom secureRandom, Provider provider) {
        this.withIntegrityPacket = false;
        this.oldFormat = false;
        this.methods = new ArrayList();
        this.defAlgorithm = i;
        this.rand = secureRandom;
        this.defProvider = provider;
        this.withIntegrityPacket = z;
    }

    private void addCheckSum(byte[] bArr) {
        int i = 0;
        for (int i2 = 1; i2 != bArr.length - 2; i2++) {
            i += bArr[i2] & UByte.MAX_VALUE;
        }
        bArr[bArr.length - 2] = (byte) (i >> 8);
        bArr[bArr.length - 1] = (byte) i;
    }

    private byte[] createSessionInfo(int i, Key key) {
        byte[] encoded = key.getEncoded();
        byte[] bArr = new byte[(encoded.length + 3)];
        bArr[0] = (byte) i;
        System.arraycopy(encoded, 0, bArr, 1, encoded.length);
        addCheckSum(bArr);
        return bArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v15, resolved type: java.security.DigestOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    private OutputStream open(OutputStream outputStream, long j, byte[] bArr) throws IOException, PGPException, IllegalStateException {
        Key key;
        if (this.cOut != null) {
            throw new IllegalStateException("generator already in open state");
        } else if (this.methods.size() == 0) {
            throw new IllegalStateException("no encryption methods specified");
        } else if (this.defProvider != null) {
            this.pOut = new BCPGOutputStream(outputStream);
            if (this.methods.size() == 1) {
                if (this.methods.get(0) instanceof PBEMethod) {
                    key = ((PBEMethod) this.methods.get(0)).getKey();
                } else {
                    key = PGPUtil.makeRandomKey(this.defAlgorithm, this.rand);
                    try {
                        ((PubMethod) this.methods.get(0)).addSessionInfo(createSessionInfo(this.defAlgorithm, key));
                    } catch (Exception e) {
                        throw new PGPException("exception encrypting session key", e);
                    }
                }
                this.pOut.writePacket((ContainedPacket) this.methods.get(0));
            } else {
                key = PGPUtil.makeRandomKey(this.defAlgorithm, this.rand);
                byte[] createSessionInfo = createSessionInfo(this.defAlgorithm, key);
                for (int i = 0; i != this.methods.size(); i++) {
                    EncMethod encMethod = (EncMethod) this.methods.get(i);
                    try {
                        encMethod.addSessionInfo(createSessionInfo);
                        this.pOut.writePacket(encMethod);
                    } catch (Exception e2) {
                        throw new PGPException("exception encrypting session key", e2);
                    }
                }
            }
            String symmetricCipherName = PGPUtil.getSymmetricCipherName(this.defAlgorithm);
            if (symmetricCipherName != null) {
                try {
                    this.c = this.withIntegrityPacket ? Cipher.getInstance(symmetricCipherName + "/CFB/NoPadding", this.defProvider) : Cipher.getInstance(symmetricCipherName + "/OpenPGPCFB/NoPadding", this.defProvider);
                    this.c.init(1, key, new IvParameterSpec(new byte[this.c.getBlockSize()]), this.rand);
                    if (bArr == null) {
                        if (this.withIntegrityPacket) {
                            BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(outputStream, 18, j + ((long) this.c.getBlockSize()) + 2 + 1 + 22);
                            this.pOut = bCPGOutputStream;
                            bCPGOutputStream.write(1);
                        } else {
                            this.pOut = new BCPGOutputStream(outputStream, 9, j + ((long) this.c.getBlockSize()) + 2, this.oldFormat);
                        }
                    } else if (this.withIntegrityPacket) {
                        BCPGOutputStream bCPGOutputStream2 = new BCPGOutputStream(outputStream, 18, bArr);
                        this.pOut = bCPGOutputStream2;
                        bCPGOutputStream2.write(1);
                    } else {
                        this.pOut = new BCPGOutputStream(outputStream, 9, bArr);
                    }
                    CipherOutputStream cipherOutputStream = new CipherOutputStream(this.pOut, this.c);
                    this.cOut = cipherOutputStream;
                    if (this.withIntegrityPacket) {
                        DigestOutputStream digestOutputStream = new DigestOutputStream(this.cOut, MessageDigest.getInstance(PGPUtil.getDigestName(2), this.defProvider));
                        this.digestOut = digestOutputStream;
                        cipherOutputStream = digestOutputStream;
                    }
                    int blockSize = this.c.getBlockSize() + 2;
                    byte[] bArr2 = new byte[blockSize];
                    this.rand.nextBytes(bArr2);
                    bArr2[blockSize - 1] = bArr2[blockSize - 3];
                    bArr2[blockSize - 2] = bArr2[blockSize - 4];
                    cipherOutputStream.write(bArr2);
                    return new WrappedGeneratorStream(cipherOutputStream, this);
                } catch (Exception e3) {
                    throw new PGPException("Exception creating cipher", e3);
                }
            } else {
                throw new PGPException("null cipher specified");
            }
        } else {
            throw new IllegalStateException("provider resolves to null");
        }
    }

    public void addMethod(PGPPublicKey pGPPublicKey) throws NoSuchProviderException, PGPException {
        if (!pGPPublicKey.isEncryptionKey()) {
            throw new IllegalArgumentException("passed in key not an encryption key!");
        } else if (this.defProvider != null) {
            this.methods.add(new PubMethod(pGPPublicKey));
        } else {
            throw new NoSuchProviderException("unable to find provider.");
        }
    }

    public void addMethod(char[] cArr) throws NoSuchProviderException, PGPException {
        addMethod(cArr, 2);
    }

    public void addMethod(char[] cArr, int i) throws NoSuchProviderException, PGPException {
        if (this.defProvider != null) {
            byte[] bArr = new byte[8];
            this.rand.nextBytes(bArr);
            S2K s2k = new S2K(i, bArr, 96);
            List list = this.methods;
            int i2 = this.defAlgorithm;
            list.add(new PBEMethod(i2, s2k, PGPUtil.makeKeyFromPassPhrase(i2, s2k, cArr, this.defProvider)));
            return;
        }
        throw new NoSuchProviderException("unable to find provider.");
    }

    @Override // org.bouncycastle.openpgp.StreamGenerator
    public void close() throws IOException {
        if (this.cOut != null) {
            if (this.digestOut != null) {
                new BCPGOutputStream(this.digestOut, 19, 20).flush();
                this.digestOut.flush();
                this.cOut.write(this.digestOut.getMessageDigest().digest());
            }
            this.cOut.flush();
            try {
                this.pOut.write(this.c.doFinal());
                this.pOut.finish();
                this.cOut = null;
                this.pOut = null;
            } catch (Exception e) {
                throw new IOException(e.toString());
            }
        }
    }

    public OutputStream open(OutputStream outputStream, long j) throws IOException, PGPException {
        return open(outputStream, j, null);
    }

    public OutputStream open(OutputStream outputStream, byte[] bArr) throws IOException, PGPException {
        return open(outputStream, 0, bArr);
    }
}
