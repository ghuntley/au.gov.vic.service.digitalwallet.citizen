package com.digitalwallet.app.model.security;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"toSecretKey", "Ljavax/crypto/SecretKey;", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: SecureUtil.kt */
final class SecureUtilKt$generateAESKey$1 extends Lambda implements Function1<byte[], SecretKey> {
    public static final SecureUtilKt$generateAESKey$1 INSTANCE = new SecureUtilKt$generateAESKey$1();

    SecureUtilKt$generateAESKey$1() {
        super(1);
    }

    public final SecretKey invoke(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$toSecretKey");
        return new SecretKeySpec(bArr, 0, bArr.length, "AES/CBC/PKCS7Padding");
    }
}
