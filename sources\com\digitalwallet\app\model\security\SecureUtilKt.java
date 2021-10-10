package com.digitalwallet.app.model.security;

import android.util.Base64;
import com.digitalwallet.app.model.InitHandshakeData;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECPublicKeySpec;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a \u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003\u001a\u0006\u0010\u0007\u001a\u00020\b\u001a\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u001a\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u001e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003\u001a\n\u0010\u001d\u001a\u00020\u0010*\u00020\u0003¨\u0006\u001e"}, d2 = {"generateAESKey", "Ljavax/crypto/SecretKey;", "sharedSecretKey", "", InitHandshakeData.saltKey, "senderSalt", "receiverSalt", "generateDHEphKeys", "Ljava/security/KeyPair;", "generateRandomBytes", "size", "", "randomizer", "Ljava/util/Random;", "generateSharedSecret", "remotePub", "Ljava/security/interfaces/ECPublicKey;", "localPrivateKey", "Ljava/security/PrivateKey;", "signPayload", "privateKey", "Ljava/security/interfaces/ECPrivateKey;", "payload", "random", "Ljava/security/SecureRandom;", "verifyPayload", "", "publicKey", "signed", "decodeECPublicKey", "app_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: SecureUtil.kt */
public final class SecureUtilKt {
    public static final ECPublicKey decodeECPublicKey(byte[] bArr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        Intrinsics.checkNotNullParameter(bArr, "$this$decodeECPublicKey");
        ECNamedCurveParameterSpec parameterSpec = ECNamedCurveTable.getParameterSpec("secp256r1");
        Intrinsics.checkNotNullExpressionValue(parameterSpec, "paramSpec");
        PublicKey generatePublic = KeyFactory.getInstance("ECDSA", new BouncyCastleProvider()).generatePublic(new ECPublicKeySpec(new ECNamedCurveParameterSpec("secp256v1", parameterSpec.getCurve(), parameterSpec.getG(), parameterSpec.getN()).getCurve().decodePoint(bArr), parameterSpec));
        Objects.requireNonNull(generatePublic, "null cannot be cast to non-null type java.security.interfaces.ECPublicKey");
        return (ECPublicKey) generatePublic;
    }

    public static final KeyPair generateDHEphKeys() {
        KeyPairGenerator instance = KeyPairGenerator.getInstance("EC", new BouncyCastleProvider());
        instance.initialize(ECNamedCurveTable.getParameterSpec("secp256r1"));
        KeyPair generateKeyPair = instance.generateKeyPair();
        Intrinsics.checkNotNullExpressionValue(generateKeyPair, "keyPairGenerator.generateKeyPair()");
        return generateKeyPair;
    }

    public static final byte[] generateSharedSecret(ECPublicKey eCPublicKey, PrivateKey privateKey) {
        Intrinsics.checkNotNullParameter(eCPublicKey, "remotePub");
        Intrinsics.checkNotNullParameter(privateKey, "localPrivateKey");
        KeyAgreement instance = KeyAgreement.getInstance("ECDH", new BouncyCastleProvider());
        instance.init(privateKey);
        instance.doPhase(eCPublicKey, true);
        byte[] generateSecret = instance.generateSecret();
        Timber.e(Base64.encodeToString(generateSecret, 0), new Object[0]);
        Timber.e(Arrays.toString(generateSecret), new Object[0]);
        Intrinsics.checkNotNullExpressionValue(generateSecret, "secret");
        return generateSecret;
    }

    public static final SecretKey generateAESKey(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] extractAndExpand;
        Intrinsics.checkNotNullParameter(bArr, "sharedSecretKey");
        Intrinsics.checkNotNullParameter(bArr2, "senderSalt");
        Intrinsics.checkNotNullParameter(bArr3, "receiverSalt");
        SecureUtilKt$generateAESKey$1 secureUtilKt$generateAESKey$1 = SecureUtilKt$generateAESKey$1.INSTANCE;
        HKDF fromHmacSha256 = HKDF.Companion.fromHmacSha256();
        if (fromHmacSha256 == null || (extractAndExpand = fromHmacSha256.extractAndExpand(ArraysKt.plus(bArr2, bArr3), bArr, null, 32)) == null) {
            return null;
        }
        return secureUtilKt$generateAESKey$1.invoke(extractAndExpand);
    }

    public static final SecretKey generateAESKey(byte[] bArr, byte[] bArr2) {
        byte[] extractAndExpand;
        Intrinsics.checkNotNullParameter(bArr, "sharedSecretKey");
        Intrinsics.checkNotNullParameter(bArr2, InitHandshakeData.saltKey);
        SecureUtilKt$generateAESKey$2 secureUtilKt$generateAESKey$2 = SecureUtilKt$generateAESKey$2.INSTANCE;
        HKDF fromHmacSha256 = HKDF.Companion.fromHmacSha256();
        if (fromHmacSha256 == null || (extractAndExpand = fromHmacSha256.extractAndExpand(bArr2, bArr, null, 32)) == null) {
            return null;
        }
        return secureUtilKt$generateAESKey$2.invoke(extractAndExpand);
    }

    public static final byte[] generateRandomBytes(int i, Random random) {
        Intrinsics.checkNotNullParameter(random, "randomizer");
        byte[] bArr = new byte[i];
        random.nextBytes(bArr);
        return bArr;
    }

    public static final byte[] signPayload(ECPrivateKey eCPrivateKey, byte[] bArr, SecureRandom secureRandom) {
        Intrinsics.checkNotNullParameter(eCPrivateKey, "privateKey");
        Intrinsics.checkNotNullParameter(bArr, "payload");
        Intrinsics.checkNotNullParameter(secureRandom, "random");
        Signature instance = Signature.getInstance("SHA256withECDSA");
        instance.initSign(eCPrivateKey, secureRandom);
        instance.update(bArr);
        byte[] sign = instance.sign();
        Intrinsics.checkNotNullExpressionValue(sign, "signature.sign()");
        return sign;
    }

    public static final boolean verifyPayload(ECPublicKey eCPublicKey, byte[] bArr, byte[] bArr2) {
        Intrinsics.checkNotNullParameter(eCPublicKey, "publicKey");
        Intrinsics.checkNotNullParameter(bArr, "payload");
        Intrinsics.checkNotNullParameter(bArr2, "signed");
        Signature instance = Signature.getInstance("SHA256withECDSA");
        instance.initVerify(eCPublicKey);
        instance.update(bArr);
        return instance.verify(bArr2);
    }
}
