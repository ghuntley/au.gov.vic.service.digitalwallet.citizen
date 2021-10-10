package com.nimbusds.jose.jca;

import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWSAlgorithm;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public final class JCASupport {
    public static boolean isUnlimitedStrength() {
        try {
            return Cipher.getMaxAllowedKeyLength("AES") >= 256;
        } catch (NoSuchAlgorithmException unused) {
            return false;
        }
    }

    public static boolean isSupported(Algorithm algorithm) {
        if (algorithm instanceof JWSAlgorithm) {
            return isSupported((JWSAlgorithm) algorithm);
        }
        if (algorithm instanceof JWEAlgorithm) {
            return isSupported((JWEAlgorithm) algorithm);
        }
        if (algorithm instanceof EncryptionMethod) {
            return isSupported((EncryptionMethod) algorithm);
        }
        throw new IllegalArgumentException("Unexpected algorithm class: " + algorithm.getClass().getCanonicalName());
    }

    public static boolean isSupported(Algorithm algorithm, Provider provider) {
        if (algorithm instanceof JWSAlgorithm) {
            return isSupported((JWSAlgorithm) algorithm, provider);
        }
        if (algorithm instanceof JWEAlgorithm) {
            return isSupported((JWEAlgorithm) algorithm, provider);
        }
        if (algorithm instanceof EncryptionMethod) {
            return isSupported((EncryptionMethod) algorithm, provider);
        }
        throw new IllegalArgumentException("Unexpected algorithm class: " + algorithm.getClass().getCanonicalName());
    }

    public static boolean isSupported(JWSAlgorithm jWSAlgorithm) {
        if (jWSAlgorithm.getName().equals(Algorithm.NONE.getName())) {
            return true;
        }
        for (Provider provider : Security.getProviders()) {
            if (isSupported(jWSAlgorithm, provider)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSupported(JWSAlgorithm jWSAlgorithm, Provider provider) {
        String str;
        String str2;
        String str3;
        if (JWSAlgorithm.Family.HMAC_SHA.contains(jWSAlgorithm)) {
            if (jWSAlgorithm.equals(JWSAlgorithm.HS256)) {
                str3 = "HMACSHA256";
            } else if (jWSAlgorithm.equals(JWSAlgorithm.HS384)) {
                str3 = "HMACSHA384";
            } else if (!jWSAlgorithm.equals(JWSAlgorithm.HS512)) {
                return false;
            } else {
                str3 = "HMACSHA512";
            }
            return provider.getService("KeyGenerator", str3) != null;
        } else if (JWSAlgorithm.Family.RSA.contains(jWSAlgorithm)) {
            if (jWSAlgorithm.equals(JWSAlgorithm.RS256)) {
                str2 = "SHA256withRSA";
            } else if (jWSAlgorithm.equals(JWSAlgorithm.RS384)) {
                str2 = "SHA384withRSA";
            } else if (jWSAlgorithm.equals(JWSAlgorithm.RS512)) {
                str2 = "SHA512withRSA";
            } else if (jWSAlgorithm.equals(JWSAlgorithm.PS256)) {
                str2 = "SHA256withRSAandMGF1";
            } else if (jWSAlgorithm.equals(JWSAlgorithm.PS384)) {
                str2 = "SHA384withRSAandMGF1";
            } else if (!jWSAlgorithm.equals(JWSAlgorithm.PS512)) {
                return false;
            } else {
                str2 = "SHA512withRSAandMGF1";
            }
            return provider.getService("Signature", str2) != null;
        } else {
            if (JWSAlgorithm.Family.EC.contains(jWSAlgorithm)) {
                if (jWSAlgorithm.equals(JWSAlgorithm.ES256)) {
                    str = "SHA256withECDSA";
                } else if (jWSAlgorithm.equals(JWSAlgorithm.ES384)) {
                    str = "SHA384withECDSA";
                } else if (jWSAlgorithm.equals(JWSAlgorithm.ES512)) {
                    str = "SHA512withECDSA";
                }
                return provider.getService("Signature", str) != null;
            }
            return false;
        }
    }

    public static boolean isSupported(JWEAlgorithm jWEAlgorithm) {
        for (Provider provider : Security.getProviders()) {
            if (isSupported(jWEAlgorithm, provider)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSupported(JWEAlgorithm jWEAlgorithm, Provider provider) {
        String str;
        String str2;
        if (JWEAlgorithm.Family.RSA.contains(jWEAlgorithm)) {
            if (jWEAlgorithm.equals(JWEAlgorithm.RSA1_5)) {
                str2 = "RSA/ECB/PKCS1Padding";
            } else if (jWEAlgorithm.equals(JWEAlgorithm.RSA_OAEP)) {
                str2 = "RSA/ECB/OAEPWithSHA-1AndMGF1Padding";
            } else {
                if (jWEAlgorithm.equals(JWEAlgorithm.RSA_OAEP_256)) {
                    str2 = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
                }
                return false;
            }
            try {
                Cipher.getInstance(str2, provider);
                return true;
            } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            }
        } else if (JWEAlgorithm.Family.AES_KW.contains(jWEAlgorithm)) {
            return provider.getService("Cipher", "AESWrap") != null;
        } else {
            if (JWEAlgorithm.Family.ECDH_ES.contains(jWEAlgorithm)) {
                return provider.getService("KeyAgreement", "ECDH") != null;
            }
            if (JWEAlgorithm.Family.AES_GCM_KW.contains(jWEAlgorithm)) {
                try {
                    Cipher.getInstance("AES/GCM/NoPadding", provider);
                    return true;
                } catch (NoSuchAlgorithmException | NoSuchPaddingException unused2) {
                    return false;
                }
            } else if (!JWEAlgorithm.Family.PBES2.contains(jWEAlgorithm)) {
                return JWEAlgorithm.DIR.equals(jWEAlgorithm);
            } else {
                if (jWEAlgorithm.equals(JWEAlgorithm.PBES2_HS256_A128KW)) {
                    str = "HmacSHA256";
                } else {
                    str = jWEAlgorithm.equals(JWEAlgorithm.PBES2_HS384_A192KW) ? "HmacSHA384" : "HmacSHA512";
                }
                return provider.getService("KeyGenerator", str) != null;
            }
        }
    }

    public static boolean isSupported(EncryptionMethod encryptionMethod) {
        for (Provider provider : Security.getProviders()) {
            if (isSupported(encryptionMethod, provider)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSupported(EncryptionMethod encryptionMethod, Provider provider) {
        String str;
        if (EncryptionMethod.Family.AES_CBC_HMAC_SHA.contains(encryptionMethod)) {
            try {
                Cipher.getInstance("AES/CBC/PKCS5Padding", provider);
                if (encryptionMethod.equals(EncryptionMethod.A128CBC_HS256)) {
                    str = "HmacSHA256";
                } else {
                    str = encryptionMethod.equals(EncryptionMethod.A192CBC_HS384) ? "HmacSHA384" : "HmacSHA512";
                }
                return provider.getService("KeyGenerator", str) != null;
            } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
                return false;
            }
        } else {
            if (EncryptionMethod.Family.AES_GCM.contains(encryptionMethod)) {
                try {
                    Cipher.getInstance("AES/GCM/NoPadding", provider);
                    return true;
                } catch (NoSuchAlgorithmException | NoSuchPaddingException unused2) {
                }
            }
            return false;
        }
    }

    private JCASupport() {
    }
}
