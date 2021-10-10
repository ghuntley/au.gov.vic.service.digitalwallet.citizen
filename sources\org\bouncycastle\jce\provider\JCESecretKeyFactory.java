package org.bouncycastle.jce.provider;

import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactorySpi;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.DESParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.jce.provider.PBE;
import org.objectweb.asm.Opcodes;

public class JCESecretKeyFactory extends SecretKeyFactorySpi implements PBE {
    protected String algName;
    protected DERObjectIdentifier algOid;

    public static class DES extends JCESecretKeyFactory {
        public DES() {
            super("DES", null);
        }

        /* access modifiers changed from: protected */
        @Override // org.bouncycastle.jce.provider.JCESecretKeyFactory, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            return keySpec instanceof DESKeySpec ? new SecretKeySpec(((DESKeySpec) keySpec).getKey(), "DES") : JCESecretKeyFactory.super.engineGenerateSecret(keySpec);
        }
    }

    public static class DESPBEKeyFactory extends JCESecretKeyFactory {
        private int digest;
        private boolean forCipher;
        private int ivSize;
        private int keySize;
        private int scheme;

        public DESPBEKeyFactory(String str, DERObjectIdentifier dERObjectIdentifier, boolean z, int i, int i2, int i3, int i4) {
            super(str, dERObjectIdentifier);
            this.forCipher = z;
            this.scheme = i;
            this.digest = i2;
            this.keySize = i3;
            this.ivSize = i4;
        }

        /* access modifiers changed from: protected */
        @Override // org.bouncycastle.jce.provider.JCESecretKeyFactory, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof PBEKeySpec) {
                PBEKeySpec pBEKeySpec = (PBEKeySpec) keySpec;
                if (pBEKeySpec.getSalt() == null) {
                    return new JCEPBEKey(this.algName, this.algOid, this.scheme, this.digest, this.keySize, this.ivSize, pBEKeySpec, null);
                }
                CipherParameters makePBEParameters = this.forCipher ? PBE.Util.makePBEParameters(pBEKeySpec, this.scheme, this.digest, this.keySize, this.ivSize) : PBE.Util.makePBEMacParameters(pBEKeySpec, this.scheme, this.digest, this.keySize);
                DESParameters.setOddParity((makePBEParameters instanceof ParametersWithIV ? (KeyParameter) ((ParametersWithIV) makePBEParameters).getParameters() : (KeyParameter) makePBEParameters).getKey());
                return new JCEPBEKey(this.algName, this.algOid, this.scheme, this.digest, this.keySize, this.ivSize, pBEKeySpec, makePBEParameters);
            }
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    public static class PBEKeyFactory extends JCESecretKeyFactory {
        private int digest;
        private boolean forCipher;
        private int ivSize;
        private int keySize;
        private int scheme;

        public PBEKeyFactory(String str, DERObjectIdentifier dERObjectIdentifier, boolean z, int i, int i2, int i3, int i4) {
            super(str, dERObjectIdentifier);
            this.forCipher = z;
            this.scheme = i;
            this.digest = i2;
            this.keySize = i3;
            this.ivSize = i4;
        }

        /* access modifiers changed from: protected */
        @Override // org.bouncycastle.jce.provider.JCESecretKeyFactory, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof PBEKeySpec) {
                PBEKeySpec pBEKeySpec = (PBEKeySpec) keySpec;
                if (pBEKeySpec.getSalt() == null) {
                    return new JCEPBEKey(this.algName, this.algOid, this.scheme, this.digest, this.keySize, this.ivSize, pBEKeySpec, null);
                }
                return new JCEPBEKey(this.algName, this.algOid, this.scheme, this.digest, this.keySize, this.ivSize, pBEKeySpec, this.forCipher ? PBE.Util.makePBEParameters(pBEKeySpec, this.scheme, this.digest, this.keySize, this.ivSize) : PBE.Util.makePBEMacParameters(pBEKeySpec, this.scheme, this.digest, this.keySize));
            }
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    public static class PBEWithMD2AndDES extends DESPBEKeyFactory {
        public PBEWithMD2AndDES() {
            super("PBEwithMD2andDES", PKCSObjectIdentifiers.pbeWithMD2AndDES_CBC, true, 0, 5, 64, 64);
        }
    }

    public static class PBEWithMD2AndRC2 extends PBEKeyFactory {
        public PBEWithMD2AndRC2() {
            super("PBEwithMD2andRC2", PKCSObjectIdentifiers.pbeWithMD2AndRC2_CBC, true, 0, 5, 64, 64);
        }
    }

    public static class PBEWithMD5And128BitAESCBCOpenSSL extends PBEKeyFactory {
        public PBEWithMD5And128BitAESCBCOpenSSL() {
            super("PBEWithMD5And128BitAES-CBC-OpenSSL", null, true, 3, 0, 128, 128);
        }
    }

    public static class PBEWithMD5And192BitAESCBCOpenSSL extends PBEKeyFactory {
        public PBEWithMD5And192BitAESCBCOpenSSL() {
            super("PBEWithMD5And192BitAES-CBC-OpenSSL", null, true, 3, 0, Opcodes.CHECKCAST, 128);
        }
    }

    public static class PBEWithMD5And256BitAESCBCOpenSSL extends PBEKeyFactory {
        public PBEWithMD5And256BitAESCBCOpenSSL() {
            super("PBEWithMD5And256BitAES-CBC-OpenSSL", null, true, 3, 0, 256, 128);
        }
    }

    public static class PBEWithMD5AndDES extends DESPBEKeyFactory {
        public PBEWithMD5AndDES() {
            super("PBEwithMD5andDES", PKCSObjectIdentifiers.pbeWithMD5AndDES_CBC, true, 0, 0, 64, 64);
        }
    }

    public static class PBEWithMD5AndRC2 extends PBEKeyFactory {
        public PBEWithMD5AndRC2() {
            super("PBEwithMD5andRC2", PKCSObjectIdentifiers.pbeWithMD5AndRC2_CBC, true, 0, 0, 64, 64);
        }
    }

    public static class PBEWithRIPEMD160 extends PBEKeyFactory {
        public PBEWithRIPEMD160() {
            super("PBEwithHmacRIPEMD160", null, false, 2, 2, Opcodes.IF_ICMPNE, 0);
        }
    }

    public static class PBEWithSHA extends PBEKeyFactory {
        public PBEWithSHA() {
            super("PBEwithHmacSHA", null, false, 2, 1, Opcodes.IF_ICMPNE, 0);
        }
    }

    public static class PBEWithSHA1AndDES extends DESPBEKeyFactory {
        public PBEWithSHA1AndDES() {
            super("PBEwithSHA1andDES", PKCSObjectIdentifiers.pbeWithSHA1AndDES_CBC, true, 0, 1, 64, 64);
        }
    }

    public static class PBEWithSHA1AndRC2 extends PBEKeyFactory {
        public PBEWithSHA1AndRC2() {
            super("PBEwithSHA1andRC2", PKCSObjectIdentifiers.pbeWithSHA1AndRC2_CBC, true, 0, 1, 64, 64);
        }
    }

    public static class PBEWithSHA256And128BitAESBC extends PBEKeyFactory {
        public PBEWithSHA256And128BitAESBC() {
            super("PBEWithSHA256And128BitAES-CBC-BC", null, true, 2, 4, 128, 128);
        }
    }

    public static class PBEWithSHA256And192BitAESBC extends PBEKeyFactory {
        public PBEWithSHA256And192BitAESBC() {
            super("PBEWithSHA256And192BitAES-CBC-BC", null, true, 2, 4, Opcodes.CHECKCAST, 128);
        }
    }

    public static class PBEWithSHA256And256BitAESBC extends PBEKeyFactory {
        public PBEWithSHA256And256BitAESBC() {
            super("PBEWithSHA256And256BitAES-CBC-BC", null, true, 2, 4, 256, 128);
        }
    }

    public static class PBEWithSHAAnd128BitAESBC extends PBEKeyFactory {
        public PBEWithSHAAnd128BitAESBC() {
            super("PBEWithSHA1And128BitAES-CBC-BC", null, true, 2, 1, 128, 128);
        }
    }

    public static class PBEWithSHAAnd128BitRC2 extends PBEKeyFactory {
        public PBEWithSHAAnd128BitRC2() {
            super("PBEwithSHAand128BitRC2-CBC", PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC2_CBC, true, 2, 1, 128, 64);
        }
    }

    public static class PBEWithSHAAnd128BitRC4 extends PBEKeyFactory {
        public PBEWithSHAAnd128BitRC4() {
            super("PBEWithSHAAnd128BitRC4", PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4, true, 2, 1, 128, 0);
        }
    }

    public static class PBEWithSHAAnd192BitAESBC extends PBEKeyFactory {
        public PBEWithSHAAnd192BitAESBC() {
            super("PBEWithSHA1And192BitAES-CBC-BC", null, true, 2, 1, Opcodes.CHECKCAST, 128);
        }
    }

    public static class PBEWithSHAAnd256BitAESBC extends PBEKeyFactory {
        public PBEWithSHAAnd256BitAESBC() {
            super("PBEWithSHA1And256BitAES-CBC-BC", null, true, 2, 1, 256, 128);
        }
    }

    public static class PBEWithSHAAnd40BitRC2 extends PBEKeyFactory {
        public PBEWithSHAAnd40BitRC2() {
            super("PBEwithSHAand40BitRC2-CBC", PKCSObjectIdentifiers.pbewithSHAAnd40BitRC2_CBC, true, 2, 1, 40, 64);
        }
    }

    public static class PBEWithSHAAnd40BitRC4 extends PBEKeyFactory {
        public PBEWithSHAAnd40BitRC4() {
            super("PBEWithSHAAnd128BitRC4", PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4, true, 2, 1, 40, 0);
        }
    }

    public static class PBEWithSHAAndDES2Key extends DESPBEKeyFactory {
        public PBEWithSHAAndDES2Key() {
            super("PBEwithSHAandDES2Key-CBC", PKCSObjectIdentifiers.pbeWithSHAAnd2_KeyTripleDES_CBC, true, 2, 1, 128, 64);
        }
    }

    public static class PBEWithSHAAndDES3Key extends DESPBEKeyFactory {
        public PBEWithSHAAndDES3Key() {
            super("PBEwithSHAandDES3Key-CBC", PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC, true, 2, 1, Opcodes.CHECKCAST, 64);
        }
    }

    public static class PBEWithSHAAndTwofish extends PBEKeyFactory {
        public PBEWithSHAAndTwofish() {
            super("PBEwithSHAandTwofish-CBC", null, true, 2, 1, 256, 128);
        }
    }

    public static class PBEWithTiger extends PBEKeyFactory {
        public PBEWithTiger() {
            super("PBEwithHmacTiger", null, false, 2, 3, Opcodes.CHECKCAST, 0);
        }
    }

    protected JCESecretKeyFactory(String str, DERObjectIdentifier dERObjectIdentifier) {
        this.algName = str;
        this.algOid = dERObjectIdentifier;
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.SecretKeyFactorySpi
    public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof SecretKeySpec) {
            return (SecretKey) keySpec;
        }
        throw new InvalidKeySpecException("Invalid KeySpec");
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.SecretKeyFactorySpi
    public KeySpec engineGetKeySpec(SecretKey secretKey, Class cls) throws InvalidKeySpecException {
        if (cls == null) {
            throw new InvalidKeySpecException("keySpec parameter is null");
        } else if (secretKey == null) {
            throw new InvalidKeySpecException("key parameter is null");
        } else if (SecretKeySpec.class.isAssignableFrom(cls)) {
            return new SecretKeySpec(secretKey.getEncoded(), this.algName);
        } else {
            try {
                return (KeySpec) cls.getConstructor(byte[].class).newInstance(secretKey.getEncoded());
            } catch (Exception e) {
                throw new InvalidKeySpecException(e.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.SecretKeyFactorySpi
    public SecretKey engineTranslateKey(SecretKey secretKey) throws InvalidKeyException {
        if (secretKey == null) {
            throw new InvalidKeyException("key parameter is null");
        } else if (secretKey.getAlgorithm().equalsIgnoreCase(this.algName)) {
            return new SecretKeySpec(secretKey.getEncoded(), this.algName);
        } else {
            throw new InvalidKeyException("Key not of type " + this.algName + ".");
        }
    }
}
