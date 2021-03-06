package org.bouncycastle.jce.provider.symmetric;

import java.util.HashMap;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.engines.Grain128Engine;
import org.bouncycastle.jce.provider.JCEKeyGenerator;
import org.bouncycastle.jce.provider.JCEStreamCipher;

public final class Grain128 {

    public static class Base extends JCEStreamCipher {
        public Base() {
            super(new Grain128Engine(), 12);
        }
    }

    public static class KeyGen extends JCEKeyGenerator {
        public KeyGen() {
            super("Grain128", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends HashMap {
        public Mappings() {
            put("Cipher.Grain128", "org.bouncycastle.jce.provider.symmetric.Grain128$Base");
            put("KeyGenerator.Grain128", "org.bouncycastle.jce.provider.symmetric.Grain128$KeyGen");
        }
    }

    private Grain128() {
    }
}
