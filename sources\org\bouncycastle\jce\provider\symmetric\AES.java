package org.bouncycastle.jce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.engines.AESFastEngine;
import org.bouncycastle.crypto.engines.AESWrapEngine;
import org.bouncycastle.crypto.engines.RFC3211WrapEngine;
import org.bouncycastle.crypto.macs.CMac;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.provider.JCEBlockCipher;
import org.bouncycastle.jce.provider.JCEKeyGenerator;
import org.bouncycastle.jce.provider.JCEMac;
import org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator;
import org.bouncycastle.jce.provider.JDKAlgorithmParameters;
import org.bouncycastle.jce.provider.WrapCipherSpi;
import org.objectweb.asm.Opcodes;

public final class AES {

    public static class AESCMAC extends JCEMac {
        public AESCMAC() {
            super(new CMac(new AESFastEngine()));
        }
    }

    public static class AlgParamGen extends JDKAlgorithmParameterGenerator {
        /* access modifiers changed from: protected */
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.random == null) {
                this.random = new SecureRandom();
            }
            this.random.nextBytes(bArr);
            try {
                AlgorithmParameters instance = AlgorithmParameters.getInstance("AES", BouncyCastleProvider.PROVIDER_NAME);
                instance.init(new IvParameterSpec(bArr));
                return instance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        /* access modifiers changed from: protected */
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
        }
    }

    public static class AlgParams extends JDKAlgorithmParameters.IVAlgorithmParameters {
        /* access modifiers changed from: protected */
        @Override // org.bouncycastle.jce.provider.JDKAlgorithmParameters.IVAlgorithmParameters
        public String engineToString() {
            return "AES IV";
        }
    }

    public static class CBC extends JCEBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new AESFastEngine()), 128);
        }
    }

    public static class CFB extends JCEBlockCipher {
        public CFB() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new AESFastEngine(), 128)), 128);
        }
    }

    public static class ECB extends JCEBlockCipher {
        public ECB() {
            super(new AESFastEngine());
        }
    }

    public static class KeyGen extends JCEKeyGenerator {
        public KeyGen() {
            this(Opcodes.CHECKCAST);
        }

        public KeyGen(int i) {
            super("AES", i, new CipherKeyGenerator());
        }
    }

    public static class KeyGen128 extends KeyGen {
        public KeyGen128() {
            super(128);
        }
    }

    public static class KeyGen192 extends KeyGen {
        public KeyGen192() {
            super(Opcodes.CHECKCAST);
        }
    }

    public static class KeyGen256 extends KeyGen {
        public KeyGen256() {
            super(256);
        }
    }

    public static class Mappings extends HashMap {
        private static final String wrongAES128 = "2.16.840.1.101.3.4.2";
        private static final String wrongAES192 = "2.16.840.1.101.3.4.22";
        private static final String wrongAES256 = "2.16.840.1.101.3.4.42";

        public Mappings() {
            put("AlgorithmParameters.AES", "org.bouncycastle.jce.provider.symmetric.AES$AlgParams");
            put("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.2", "AES");
            put("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.22", "AES");
            put("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.42", "AES");
            put("Alg.Alias.AlgorithmParameters." + NISTObjectIdentifiers.id_aes128_CBC, "AES");
            put("Alg.Alias.AlgorithmParameters." + NISTObjectIdentifiers.id_aes192_CBC, "AES");
            put("Alg.Alias.AlgorithmParameters." + NISTObjectIdentifiers.id_aes256_CBC, "AES");
            put("AlgorithmParameterGenerator.AES", "org.bouncycastle.jce.provider.symmetric.AES$AlgParamGen");
            put("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.2", "AES");
            put("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.22", "AES");
            put("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.42", "AES");
            put("Alg.Alias.AlgorithmParameterGenerator." + NISTObjectIdentifiers.id_aes128_CBC, "AES");
            put("Alg.Alias.AlgorithmParameterGenerator." + NISTObjectIdentifiers.id_aes192_CBC, "AES");
            put("Alg.Alias.AlgorithmParameterGenerator." + NISTObjectIdentifiers.id_aes256_CBC, "AES");
            put("Cipher.AES", "org.bouncycastle.jce.provider.symmetric.AES$ECB");
            put("Alg.Alias.Cipher.2.16.840.1.101.3.4.2", "AES");
            put("Alg.Alias.Cipher.2.16.840.1.101.3.4.22", "AES");
            put("Alg.Alias.Cipher.2.16.840.1.101.3.4.42", "AES");
            put("Cipher." + NISTObjectIdentifiers.id_aes128_ECB, "org.bouncycastle.jce.provider.symmetric.AES$ECB");
            put("Cipher." + NISTObjectIdentifiers.id_aes192_ECB, "org.bouncycastle.jce.provider.symmetric.AES$ECB");
            put("Cipher." + NISTObjectIdentifiers.id_aes256_ECB, "org.bouncycastle.jce.provider.symmetric.AES$ECB");
            put("Cipher." + NISTObjectIdentifiers.id_aes128_CBC, "org.bouncycastle.jce.provider.symmetric.AES$CBC");
            put("Cipher." + NISTObjectIdentifiers.id_aes192_CBC, "org.bouncycastle.jce.provider.symmetric.AES$CBC");
            put("Cipher." + NISTObjectIdentifiers.id_aes256_CBC, "org.bouncycastle.jce.provider.symmetric.AES$CBC");
            put("Cipher." + NISTObjectIdentifiers.id_aes128_OFB, "org.bouncycastle.jce.provider.symmetric.AES$OFB");
            put("Cipher." + NISTObjectIdentifiers.id_aes192_OFB, "org.bouncycastle.jce.provider.symmetric.AES$OFB");
            put("Cipher." + NISTObjectIdentifiers.id_aes256_OFB, "org.bouncycastle.jce.provider.symmetric.AES$OFB");
            put("Cipher." + NISTObjectIdentifiers.id_aes128_CFB, "org.bouncycastle.jce.provider.symmetric.AES$CFB");
            put("Cipher." + NISTObjectIdentifiers.id_aes192_CFB, "org.bouncycastle.jce.provider.symmetric.AES$CFB");
            put("Cipher." + NISTObjectIdentifiers.id_aes256_CFB, "org.bouncycastle.jce.provider.symmetric.AES$CFB");
            put("Cipher.AESWRAP", "org.bouncycastle.jce.provider.symmetric.AES$Wrap");
            put("Alg.Alias.Cipher." + NISTObjectIdentifiers.id_aes128_wrap, "AESWRAP");
            put("Alg.Alias.Cipher." + NISTObjectIdentifiers.id_aes192_wrap, "AESWRAP");
            put("Alg.Alias.Cipher." + NISTObjectIdentifiers.id_aes256_wrap, "AESWRAP");
            put("Cipher.AESRFC3211WRAP", "org.bouncycastle.jce.provider.symmetric.AES$RFC3211Wrap");
            put("KeyGenerator.AES", "org.bouncycastle.jce.provider.symmetric.AES$KeyGen");
            put("KeyGenerator.2.16.840.1.101.3.4.2", "org.bouncycastle.jce.provider.symmetric.AES$KeyGen128");
            put("KeyGenerator.2.16.840.1.101.3.4.22", "org.bouncycastle.jce.provider.symmetric.AES$KeyGen192");
            put("KeyGenerator.2.16.840.1.101.3.4.42", "org.bouncycastle.jce.provider.symmetric.AES$KeyGen256");
            put("KeyGenerator." + NISTObjectIdentifiers.id_aes128_ECB, "org.bouncycastle.jce.provider.symmetric.AES$KeyGen128");
            put("KeyGenerator." + NISTObjectIdentifiers.id_aes128_CBC, "org.bouncycastle.jce.provider.symmetric.AES$KeyGen128");
            put("KeyGenerator." + NISTObjectIdentifiers.id_aes128_OFB, "org.bouncycastle.jce.provider.symmetric.AES$KeyGen128");
            put("KeyGenerator." + NISTObjectIdentifiers.id_aes128_CFB, "org.bouncycastle.jce.provider.symmetric.AES$KeyGen128");
            put("KeyGenerator." + NISTObjectIdentifiers.id_aes192_ECB, "org.bouncycastle.jce.provider.symmetric.AES$KeyGen192");
            put("KeyGenerator." + NISTObjectIdentifiers.id_aes192_CBC, "org.bouncycastle.jce.provider.symmetric.AES$KeyGen192");
            put("KeyGenerator." + NISTObjectIdentifiers.id_aes192_OFB, "org.bouncycastle.jce.provider.symmetric.AES$KeyGen192");
            put("KeyGenerator." + NISTObjectIdentifiers.id_aes192_CFB, "org.bouncycastle.jce.provider.symmetric.AES$KeyGen192");
            put("KeyGenerator." + NISTObjectIdentifiers.id_aes256_ECB, "org.bouncycastle.jce.provider.symmetric.AES$KeyGen256");
            put("KeyGenerator." + NISTObjectIdentifiers.id_aes256_CBC, "org.bouncycastle.jce.provider.symmetric.AES$KeyGen256");
            put("KeyGenerator." + NISTObjectIdentifiers.id_aes256_OFB, "org.bouncycastle.jce.provider.symmetric.AES$KeyGen256");
            put("KeyGenerator." + NISTObjectIdentifiers.id_aes256_CFB, "org.bouncycastle.jce.provider.symmetric.AES$KeyGen256");
            put("KeyGenerator.AESWRAP", "org.bouncycastle.jce.provider.symmetric.AES$KeyGen");
            put("KeyGenerator." + NISTObjectIdentifiers.id_aes128_wrap, "org.bouncycastle.jce.provider.symmetric.AES$KeyGen128");
            put("KeyGenerator." + NISTObjectIdentifiers.id_aes192_wrap, "org.bouncycastle.jce.provider.symmetric.AES$KeyGen192");
            put("KeyGenerator." + NISTObjectIdentifiers.id_aes256_wrap, "org.bouncycastle.jce.provider.symmetric.AES$KeyGen256");
            put("Mac.AESCMAC", "org.bouncycastle.jce.provider.symmetric.AES$AESCMAC");
        }
    }

    public static class OFB extends JCEBlockCipher {
        public OFB() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new AESFastEngine(), 128)), 128);
        }
    }

    public static class RFC3211Wrap extends WrapCipherSpi {
        public RFC3211Wrap() {
            super(new RFC3211WrapEngine(new AESFastEngine()), 16);
        }
    }

    public static class Wrap extends WrapCipherSpi {
        public Wrap() {
            super(new AESWrapEngine());
        }
    }

    private AES() {
    }
}
