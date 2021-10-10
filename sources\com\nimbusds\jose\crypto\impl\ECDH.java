package com.nimbusds.jose.crypto.impl;

import com.google.crypto.tink.subtle.X25519;
import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.OctetKeyPair;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.interfaces.ECPublicKey;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.objectweb.asm.Opcodes;

public class ECDH {

    public enum AlgorithmMode {
        DIRECT,
        KW
    }

    public static AlgorithmMode resolveAlgorithmMode(JWEAlgorithm jWEAlgorithm) throws JOSEException {
        if (jWEAlgorithm.equals(JWEAlgorithm.ECDH_ES)) {
            return AlgorithmMode.DIRECT;
        }
        if (jWEAlgorithm.equals(JWEAlgorithm.ECDH_ES_A128KW) || jWEAlgorithm.equals(JWEAlgorithm.ECDH_ES_A192KW) || jWEAlgorithm.equals(JWEAlgorithm.ECDH_ES_A256KW)) {
            return AlgorithmMode.KW;
        }
        throw new JOSEException(AlgorithmSupportMessage.unsupportedJWEAlgorithm(jWEAlgorithm, ECDHCryptoProvider.SUPPORTED_ALGORITHMS));
    }

    public static int sharedKeyLength(JWEAlgorithm jWEAlgorithm, EncryptionMethod encryptionMethod) throws JOSEException {
        if (jWEAlgorithm.equals(JWEAlgorithm.ECDH_ES)) {
            int cekBitLength = encryptionMethod.cekBitLength();
            if (cekBitLength != 0) {
                return cekBitLength;
            }
            throw new JOSEException("Unsupported JWE encryption method " + encryptionMethod);
        } else if (jWEAlgorithm.equals(JWEAlgorithm.ECDH_ES_A128KW)) {
            return 128;
        } else {
            if (jWEAlgorithm.equals(JWEAlgorithm.ECDH_ES_A192KW)) {
                return Opcodes.CHECKCAST;
            }
            if (jWEAlgorithm.equals(JWEAlgorithm.ECDH_ES_A256KW)) {
                return 256;
            }
            throw new JOSEException(AlgorithmSupportMessage.unsupportedJWEAlgorithm(jWEAlgorithm, ECDHCryptoProvider.SUPPORTED_ALGORITHMS));
        }
    }

    public static SecretKey deriveSharedSecret(ECPublicKey eCPublicKey, PrivateKey privateKey, Provider provider) throws JOSEException {
        KeyAgreement keyAgreement;
        if (provider != null) {
            try {
                keyAgreement = KeyAgreement.getInstance("ECDH", provider);
            } catch (NoSuchAlgorithmException e) {
                throw new JOSEException("Couldn't get an ECDH key agreement instance: " + e.getMessage(), e);
            }
        } else {
            keyAgreement = KeyAgreement.getInstance("ECDH");
        }
        try {
            keyAgreement.init(privateKey);
            keyAgreement.doPhase(eCPublicKey, true);
            return new SecretKeySpec(keyAgreement.generateSecret(), "AES");
        } catch (InvalidKeyException e2) {
            throw new JOSEException("Invalid key for ECDH key agreement: " + e2.getMessage(), e2);
        }
    }

    public static SecretKey deriveSharedSecret(OctetKeyPair octetKeyPair, OctetKeyPair octetKeyPair2) throws JOSEException {
        if (octetKeyPair.isPrivate()) {
            throw new JOSEException("Expected public key but received OKP with 'd' value");
        } else if (!Curve.X25519.equals(octetKeyPair.getCurve())) {
            throw new JOSEException("Expected public key OKP with crv=X25519");
        } else if (!octetKeyPair2.isPrivate()) {
            throw new JOSEException("Expected private key but received OKP without 'd' value");
        } else if (Curve.X25519.equals(octetKeyPair2.getCurve())) {
            try {
                return new SecretKeySpec(X25519.computeSharedSecret(octetKeyPair2.getDecodedD(), octetKeyPair.getDecodedX()), "AES");
            } catch (InvalidKeyException e) {
                throw new JOSEException(e.getMessage(), e);
            }
        } else {
            throw new JOSEException("Expected private key OKP with crv=X25519");
        }
    }

    public static SecretKey deriveSharedKey(JWEHeader jWEHeader, SecretKey secretKey, ConcatKDF concatKDF) throws JOSEException {
        String str;
        int sharedKeyLength = sharedKeyLength(jWEHeader.getAlgorithm(), jWEHeader.getEncryptionMethod());
        AlgorithmMode resolveAlgorithmMode = resolveAlgorithmMode(jWEHeader.getAlgorithm());
        if (resolveAlgorithmMode == AlgorithmMode.DIRECT) {
            str = jWEHeader.getEncryptionMethod().getName();
        } else if (resolveAlgorithmMode == AlgorithmMode.KW) {
            str = jWEHeader.getAlgorithm().getName();
        } else {
            throw new JOSEException("Unsupported JWE ECDH algorithm mode: " + resolveAlgorithmMode);
        }
        return concatKDF.deriveKey(secretKey, sharedKeyLength, ConcatKDF.encodeDataWithLength(str.getBytes(Charset.forName("ASCII"))), ConcatKDF.encodeDataWithLength(jWEHeader.getAgreementPartyUInfo()), ConcatKDF.encodeDataWithLength(jWEHeader.getAgreementPartyVInfo()), ConcatKDF.encodeIntData(sharedKeyLength), ConcatKDF.encodeNoData());
    }

    private ECDH() {
    }
}
