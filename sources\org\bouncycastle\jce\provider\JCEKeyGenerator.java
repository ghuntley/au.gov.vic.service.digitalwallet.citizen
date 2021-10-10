package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.generators.DESKeyGenerator;
import org.objectweb.asm.Opcodes;

public class JCEKeyGenerator extends KeyGeneratorSpi {
    protected String algName;
    protected int defaultKeySize;
    protected CipherKeyGenerator engine;
    protected int keySize;
    protected boolean uninitialised = true;

    public static class DES extends JCEKeyGenerator {
        public DES() {
            super("DES", 64, new DESKeyGenerator());
        }
    }

    public static class GOST28147 extends JCEKeyGenerator {
        public GOST28147() {
            super("GOST28147", 256, new CipherKeyGenerator());
        }
    }

    public static class HMACSHA1 extends JCEKeyGenerator {
        public HMACSHA1() {
            super("HMACSHA1", Opcodes.IF_ICMPNE, new CipherKeyGenerator());
        }
    }

    public static class HMACSHA224 extends JCEKeyGenerator {
        public HMACSHA224() {
            super("HMACSHA224", 224, new CipherKeyGenerator());
        }
    }

    public static class HMACSHA256 extends JCEKeyGenerator {
        public HMACSHA256() {
            super("HMACSHA256", 256, new CipherKeyGenerator());
        }
    }

    public static class HMACSHA384 extends JCEKeyGenerator {
        public HMACSHA384() {
            super("HMACSHA384", 384, new CipherKeyGenerator());
        }
    }

    public static class HMACSHA512 extends JCEKeyGenerator {
        public HMACSHA512() {
            super("HMACSHA512", 512, new CipherKeyGenerator());
        }
    }

    public static class HMACTIGER extends JCEKeyGenerator {
        public HMACTIGER() {
            super("HMACTIGER", Opcodes.CHECKCAST, new CipherKeyGenerator());
        }
    }

    public static class MD2HMAC extends JCEKeyGenerator {
        public MD2HMAC() {
            super("HMACMD2", 128, new CipherKeyGenerator());
        }
    }

    public static class MD4HMAC extends JCEKeyGenerator {
        public MD4HMAC() {
            super("HMACMD4", 128, new CipherKeyGenerator());
        }
    }

    public static class MD5HMAC extends JCEKeyGenerator {
        public MD5HMAC() {
            super("HMACMD5", 128, new CipherKeyGenerator());
        }
    }

    public static class RC2 extends JCEKeyGenerator {
        public RC2() {
            super("RC2", 128, new CipherKeyGenerator());
        }
    }

    public static class RIPEMD128HMAC extends JCEKeyGenerator {
        public RIPEMD128HMAC() {
            super("HMACRIPEMD128", 128, new CipherKeyGenerator());
        }
    }

    public static class RIPEMD160HMAC extends JCEKeyGenerator {
        public RIPEMD160HMAC() {
            super("HMACRIPEMD160", Opcodes.IF_ICMPNE, new CipherKeyGenerator());
        }
    }

    protected JCEKeyGenerator(String str, int i, CipherKeyGenerator cipherKeyGenerator) {
        this.algName = str;
        this.defaultKeySize = i;
        this.keySize = i;
        this.engine = cipherKeyGenerator;
    }

    /* access modifiers changed from: protected */
    public SecretKey engineGenerateKey() {
        if (this.uninitialised) {
            this.engine.init(new KeyGenerationParameters(new SecureRandom(), this.defaultKeySize));
            this.uninitialised = false;
        }
        return new SecretKeySpec(this.engine.generateKey(), this.algName);
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(int i, SecureRandom secureRandom) {
        try {
            this.engine.init(new KeyGenerationParameters(secureRandom, i));
            this.uninitialised = false;
        } catch (IllegalArgumentException e) {
            throw new InvalidParameterException(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(SecureRandom secureRandom) {
        if (secureRandom != null) {
            this.engine.init(new KeyGenerationParameters(secureRandom, this.defaultKeySize));
            this.uninitialised = false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("Not Implemented");
    }
}
