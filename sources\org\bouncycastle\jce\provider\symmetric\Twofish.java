package org.bouncycastle.jce.provider.symmetric;

import java.util.HashMap;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.engines.TwofishEngine;
import org.bouncycastle.jce.provider.JCEBlockCipher;
import org.bouncycastle.jce.provider.JCEKeyGenerator;
import org.bouncycastle.jce.provider.JDKAlgorithmParameters;

public final class Twofish {

    public static class AlgParams extends JDKAlgorithmParameters.IVAlgorithmParameters {
        /* access modifiers changed from: protected */
        @Override // org.bouncycastle.jce.provider.JDKAlgorithmParameters.IVAlgorithmParameters
        public String engineToString() {
            return "Twofish IV";
        }
    }

    public static class ECB extends JCEBlockCipher {
        public ECB() {
            super(new TwofishEngine());
        }
    }

    public static class KeyGen extends JCEKeyGenerator {
        public KeyGen() {
            super("Twofish", 256, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends HashMap {
        public Mappings() {
            put("Cipher.Twofish", "org.bouncycastle.jce.provider.symmetric.Twofish$ECB");
            put("KeyGenerator.Twofish", "org.bouncycastle.jce.provider.symmetric.Twofish$KeyGen");
            put("AlgorithmParameters.Twofish", "org.bouncycastle.jce.provider.symmetric.Twofish$AlgParams");
        }
    }

    private Twofish() {
    }
}
