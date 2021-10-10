package com.digitalwallet.app.model.db.secure;

import android.security.keystore.KeyGenParameterSpec;
import com.digitalwallet.app.model.InitHandshakeData;
import com.google.android.gms.stats.CodePackage;
import java.security.KeyStore;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\b\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006\u001a\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0007\u001a\u00020\u0006\u001a\n\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"alias", "", "androidkeystore", "createKey", "Ljavax/crypto/SecretKey;", "decrypt", "", "bytes", InitHandshakeData.ivKey, "encrypt", "Lkotlin/Pair;", "getKey", "app_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: SecuredStore.kt */
public final class SecuredStoreKt {
    private static final String alias = "dwksalias";
    private static final String androidkeystore = "AndroidKeyStore";

    private static final SecretKey createKey() {
        KeyGenParameterSpec.Builder builder = new KeyGenParameterSpec.Builder(alias, 3);
        builder.setBlockModes(CodePackage.GCM);
        builder.setEncryptionPaddings("NoPadding");
        KeyGenParameterSpec build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "KeyGenParameterSpec.Buil…   }\n            .build()");
        KeyGenerator instance = KeyGenerator.getInstance("AES", androidkeystore);
        instance.init(build);
        SecretKey generateKey = instance.generateKey();
        Intrinsics.checkNotNullExpressionValue(generateKey, "gen.generateKey()");
        return generateKey;
    }

    private static final SecretKey getKey() {
        KeyStore instance = KeyStore.getInstance(androidkeystore);
        instance.load(null);
        if (!instance.containsAlias(alias)) {
            return null;
        }
        KeyStore.Entry entry = instance.getEntry(alias, null);
        if (!(entry instanceof KeyStore.SecretKeyEntry)) {
            entry = null;
        }
        KeyStore.SecretKeyEntry secretKeyEntry = (KeyStore.SecretKeyEntry) entry;
        if (secretKeyEntry != null) {
            return secretKeyEntry.getSecretKey();
        }
        return null;
    }

    public static final Pair<byte[], byte[]> encrypt(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        SecretKey key = getKey();
        if (key == null) {
            key = createKey();
        }
        Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
        instance.init(1, key);
        byte[] doFinal = instance.doFinal(bArr);
        Intrinsics.checkNotNullExpressionValue(instance, "cipher");
        return new Pair<>(doFinal, instance.getIV());
    }

    public static final byte[] decrypt(byte[] bArr, byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(bArr2, InitHandshakeData.ivKey);
        SecretKey key = getKey();
        if (key != null) {
            Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            instance.init(2, key, new GCMParameterSpec(128, bArr2));
            byte[] doFinal = instance.doFinal(bArr);
            Intrinsics.checkNotNullExpressionValue(doFinal, "cipher.doFinal(bytes)");
            return doFinal;
        }
        throw new IllegalStateException("No key to decrypt database");
    }
}
