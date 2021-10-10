package org.bouncycastle.openssl;

import java.io.IOException;
import java.security.Provider;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.objectweb.asm.Opcodes;

final class PEMUtilities {
    private static final Map KEYSIZES;
    private static final Set PKCS5_SCHEME_1;
    private static final Set PKCS5_SCHEME_2;

    static {
        HashMap hashMap = new HashMap();
        KEYSIZES = hashMap;
        HashSet hashSet = new HashSet();
        PKCS5_SCHEME_1 = hashSet;
        HashSet hashSet2 = new HashSet();
        PKCS5_SCHEME_2 = hashSet2;
        hashSet.add(PKCSObjectIdentifiers.pbeWithMD2AndDES_CBC);
        hashSet.add(PKCSObjectIdentifiers.pbeWithMD2AndRC2_CBC);
        hashSet.add(PKCSObjectIdentifiers.pbeWithMD5AndDES_CBC);
        hashSet.add(PKCSObjectIdentifiers.pbeWithMD5AndRC2_CBC);
        hashSet.add(PKCSObjectIdentifiers.pbeWithSHA1AndDES_CBC);
        hashSet.add(PKCSObjectIdentifiers.pbeWithSHA1AndRC2_CBC);
        hashSet2.add(PKCSObjectIdentifiers.id_PBES2);
        hashSet2.add(PKCSObjectIdentifiers.des_EDE3_CBC);
        hashSet2.add(NISTObjectIdentifiers.id_aes128_CBC);
        hashSet2.add(NISTObjectIdentifiers.id_aes192_CBC);
        hashSet2.add(NISTObjectIdentifiers.id_aes256_CBC);
        hashMap.put(PKCSObjectIdentifiers.des_EDE3_CBC.getId(), new Integer((int) Opcodes.CHECKCAST));
        hashMap.put(NISTObjectIdentifiers.id_aes128_CBC.getId(), new Integer(128));
        hashMap.put(NISTObjectIdentifiers.id_aes192_CBC.getId(), new Integer((int) Opcodes.CHECKCAST));
        hashMap.put(NISTObjectIdentifiers.id_aes256_CBC.getId(), new Integer(256));
    }

    PEMUtilities() {
    }

    static byte[] crypt(boolean z, String str, byte[] bArr, char[] cArr, String str2, byte[] bArr2) throws IOException {
        Provider provider;
        if (str != null) {
            provider = Security.getProvider(str);
            if (provider == null) {
                throw new EncryptionException("cannot find provider: " + str);
            }
        } else {
            provider = null;
        }
        return crypt(z, provider, bArr, cArr, str2, bArr2);
    }

    static byte[] crypt(boolean z, Provider provider, byte[] bArr, char[] cArr, String str, byte[] bArr2) throws IOException {
        String str2;
        String str3;
        SecretKey secretKey;
        AlgorithmParameterSpec rC2ParameterSpec;
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        String str4 = "NoPadding";
        if (str.endsWith("-CFB")) {
            str3 = "CFB";
            str2 = str4;
        } else {
            str3 = "CBC";
            str2 = "PKCS5Padding";
        }
        if (str.endsWith("-ECB") || "DES-EDE".equals(str) || "DES-EDE3".equals(str)) {
            ivParameterSpec = null;
            str3 = "ECB";
        }
        if (str.endsWith("-OFB")) {
            str3 = "OFB";
        } else {
            str4 = str2;
        }
        String str5 = "AES";
        int i = 1;
        if (str.startsWith("DES-EDE")) {
            str5 = "DESede";
            secretKey = getKey(cArr, str5, 24, bArr2, !str.startsWith("DES-EDE3"));
        } else if (str.startsWith("DES-")) {
            str5 = "DES";
            secretKey = getKey(cArr, str5, 8, bArr2);
        } else if (str.startsWith("BF-")) {
            str5 = "Blowfish";
            secretKey = getKey(cArr, str5, 16, bArr2);
        } else {
            int i2 = 128;
            if (str.startsWith("RC2-")) {
                str5 = "RC2";
                if (str.startsWith("RC2-40-")) {
                    i2 = 40;
                } else if (str.startsWith("RC2-64-")) {
                    i2 = 64;
                }
                secretKey = getKey(cArr, str5, i2 / 8, bArr2);
                if (ivParameterSpec != null) {
                    rC2ParameterSpec = new RC2ParameterSpec(i2, bArr2);
                }
                ivParameterSpec = rC2ParameterSpec;
            } else if (str.startsWith("AES-")) {
                if (bArr2.length > 8) {
                    byte[] bArr3 = new byte[8];
                    System.arraycopy(bArr2, 0, bArr3, 0, 8);
                    bArr2 = bArr3;
                }
                if (!str.startsWith("AES-128-")) {
                    if (str.startsWith("AES-192-")) {
                        i2 = Opcodes.CHECKCAST;
                    } else if (str.startsWith("AES-256-")) {
                        i2 = 256;
                    } else {
                        throw new EncryptionException("unknown AES encryption with private key");
                    }
                }
                secretKey = getKey(cArr, str5, i2 / 8, bArr2);
            } else {
                throw new EncryptionException("unknown encryption with private key");
            }
        }
        try {
            Cipher instance = Cipher.getInstance(str5 + "/" + str3 + "/" + str4, provider);
            if (!z) {
                i = 2;
            }
            if (ivParameterSpec == null) {
                instance.init(i, secretKey);
            } else {
                instance.init(i, secretKey, ivParameterSpec);
            }
            return instance.doFinal(bArr);
        } catch (Exception e) {
            throw new EncryptionException("exception using cipher - please check password and data.", e);
        }
    }

    static SecretKey generateSecretKeyForPKCS5Scheme2(String str, char[] cArr, byte[] bArr, int i) {
        PKCS5S2ParametersGenerator pKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator();
        pKCS5S2ParametersGenerator.init(PBEParametersGenerator.PKCS5PasswordToBytes(cArr), bArr, i);
        return new SecretKeySpec(((KeyParameter) pKCS5S2ParametersGenerator.generateDerivedParameters(getKeySize(str))).getKey(), str);
    }

    private static SecretKey getKey(char[] cArr, String str, int i, byte[] bArr) {
        return getKey(cArr, str, i, bArr, false);
    }

    private static SecretKey getKey(char[] cArr, String str, int i, byte[] bArr, boolean z) {
        OpenSSLPBEParametersGenerator openSSLPBEParametersGenerator = new OpenSSLPBEParametersGenerator();
        openSSLPBEParametersGenerator.init(PBEParametersGenerator.PKCS5PasswordToBytes(cArr), bArr);
        byte[] key = ((KeyParameter) openSSLPBEParametersGenerator.generateDerivedParameters(i * 8)).getKey();
        if (z && key.length >= 24) {
            System.arraycopy(key, 0, key, 16, 8);
        }
        return new SecretKeySpec(key, str);
    }

    static int getKeySize(String str) {
        Map map = KEYSIZES;
        if (map.containsKey(str)) {
            return ((Integer) map.get(str)).intValue();
        }
        throw new IllegalStateException("no key size for algorithm: " + str);
    }

    static boolean isPKCS12(DERObjectIdentifier dERObjectIdentifier) {
        return dERObjectIdentifier.getId().startsWith(PKCSObjectIdentifiers.pkcs_12PbeIds.getId());
    }

    static boolean isPKCS5Scheme1(DERObjectIdentifier dERObjectIdentifier) {
        return PKCS5_SCHEME_1.contains(dERObjectIdentifier);
    }

    static boolean isPKCS5Scheme2(DERObjectIdentifier dERObjectIdentifier) {
        return PKCS5_SCHEME_2.contains(dERObjectIdentifier);
    }
}
