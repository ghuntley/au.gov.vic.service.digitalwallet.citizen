package com.digitalwallet.app.model.security;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/model/security/HkdfMacFactory;", "", "createInstance", "Ljavax/crypto/Mac;", "key", "", "Default", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HKDF.kt */
public interface HkdfMacFactory {
    Mac createInstance(byte[] bArr);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/digitalwallet/app/model/security/HkdfMacFactory$Default;", "Lcom/digitalwallet/app/model/security/HkdfMacFactory;", "macAlgorithmName", "", "provider", "Ljava/security/Provider;", "(Ljava/lang/String;Ljava/security/Provider;)V", "createInstance", "Ljavax/crypto/Mac;", "key", "", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: HKDF.kt */
    public static final class Default implements HkdfMacFactory {
        public static final Companion Companion = new Companion(null);
        private final String macAlgorithmName;
        private final Provider provider;

        public Default(String str) {
            this(str, null, 2, null);
        }

        public Default(String str, Provider provider2) {
            Intrinsics.checkNotNullParameter(str, "macAlgorithmName");
            this.macAlgorithmName = str;
            this.provider = provider2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Default(String str, Provider provider2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : provider2);
        }

        @Override // com.digitalwallet.app.model.security.HkdfMacFactory
        public Mac createInstance(byte[] bArr) {
            Mac mac;
            Intrinsics.checkNotNullParameter(bArr, "key");
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, this.macAlgorithmName);
                Provider provider2 = this.provider;
                if (provider2 == null) {
                    mac = Mac.getInstance(this.macAlgorithmName);
                    Intrinsics.checkNotNullExpressionValue(mac, "Mac.getInstance(macAlgorithmName)");
                } else {
                    mac = Mac.getInstance(this.macAlgorithmName, provider2);
                    Intrinsics.checkNotNullExpressionValue(mac, "Mac.getInstance(macAlgorithmName, provider)");
                }
                mac.init(secretKeySpec);
                return mac;
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalStateException("defined mac algorithm was not found", e);
            } catch (Exception e2) {
                throw new IllegalStateException("could not make hmac hasher in hkdf", e2);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/model/security/HkdfMacFactory$Default$Companion;", "", "()V", "hmacSha1", "Lcom/digitalwallet/app/model/security/HkdfMacFactory;", "hmacSha256", "hmacSha512", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
        /* compiled from: HKDF.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final HkdfMacFactory hmacSha256() {
                return new Default("HmacSHA256", null);
            }

            public final HkdfMacFactory hmacSha512() {
                return new Default("HmacSHA512", null);
            }

            @Deprecated(message = "sha1 with HMAC should be fine, but not recommended for new protocols; see https://crypto.stackexchange.com/questions/26510/why-is-hmac-sha1-still-considered-secure")
            public final HkdfMacFactory hmacSha1() {
                return new Default("HmacSHA1", null);
            }
        }
    }
}
