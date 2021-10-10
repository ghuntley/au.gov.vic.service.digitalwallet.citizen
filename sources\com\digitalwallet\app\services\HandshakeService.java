package com.digitalwallet.app.services;

import android.util.Log;
import com.digitalwallet.app.model.InitHandshakeData;
import com.digitalwallet.app.model.P2PMessage;
import com.digitalwallet.app.model.security.SecureUtilKt;
import com.digitalwallet.di.ActivityScope;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPublicKey;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@ActivityScope
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0016\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0005J\u0016\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0005J\u000e\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005J\u001e\u00102\u001a\u0004\u0018\u00010\u00062\f\u00103\u001a\b\u0012\u0004\u0012\u000200042\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u000208R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u000f*\u0004\u0018\u00010\u00050\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0004X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00128F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R&\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00180\u0004X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u00128F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00128F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0014R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u00128F¢\u0006\u0006\u001a\u0004\b \u0010\u0014R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001d\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u00128F¢\u0006\u0006\u001a\u0004\b)\u0010\u0014¨\u00069"}, d2 = {"Lcom/digitalwallet/app/services/HandshakeService;", "", "()V", "_aesKeys", "", "Ljava/util/UUID;", "Ljavax/crypto/SecretKey;", "_ephKeyPairs", "Ljava/security/KeyPair;", "_ivs", "", "_others", "Ljava/security/interfaces/ECPublicKey;", "_salts", "_sessionId", "kotlin.jvm.PlatformType", "_sharedSecrets", "aesKeys", "", "getAesKeys", "()Ljava/util/Map;", "ephKeyPairs", "getEphKeyPairs", "halves", "Lkotlin/Pair;", "ivs", "getIvs", "publicKeys", "getPublicKeys", "random", "Ljava/security/SecureRandom;", "salts", "getSalts", "securedSessions", "Lio/reactivex/Observable;", "getSecuredSessions", "()Lio/reactivex/Observable;", "sessionId", "getSessionId", "()Ljava/util/UUID;", "sharedSecrets", "getSharedSecrets", "decryptFor", P2PMessage.encryptedKey, "uuid", "encryptFor", "message", "generateDataForHandshake", "Lcom/digitalwallet/app/model/InitHandshakeData;", "other", "generateSharedEncryptionKey", "handshakeMessage", "Lcom/digitalwallet/app/model/P2PMessage;", "order", "Lcom/digitalwallet/app/services/Order;", "reset", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HandshakeService.kt */
public final class HandshakeService {
    private final Map<UUID, SecretKey> _aesKeys = new LinkedHashMap();
    private final Map<UUID, KeyPair> _ephKeyPairs = new LinkedHashMap();
    private final Map<UUID, byte[]> _ivs = new LinkedHashMap();
    private final Map<UUID, ECPublicKey> _others = new LinkedHashMap();
    private final Map<UUID, byte[]> _salts = new LinkedHashMap();
    private UUID _sessionId = UUID.randomUUID();
    private final Map<UUID, byte[]> _sharedSecrets = new LinkedHashMap();
    private final Map<UUID, Pair<byte[], byte[]>> halves = new LinkedHashMap();
    private final SecureRandom random = new SecureRandom();
    private final Observable<UUID> securedSessions;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Order.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Order.First.ordinal()] = 1;
            iArr[Order.Second.ordinal()] = 2;
        }
    }

    @Inject
    public HandshakeService() {
        PublishSubject create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create()");
        this.securedSessions = create;
    }

    public final SecretKey generateSharedEncryptionKey(P2PMessage<InitHandshakeData> p2PMessage, Order order) {
        byte[] first;
        byte[] plus;
        byte[] second;
        byte[] plus2;
        byte[] first2;
        byte[] plus3;
        byte[] second2;
        byte[] plus4;
        Intrinsics.checkNotNullParameter(p2PMessage, "handshakeMessage");
        Intrinsics.checkNotNullParameter(order, "order");
        UUID sourceID = p2PMessage.getHeader().getSourceID();
        SecretKey secretKey = getAesKeys().get(sourceID);
        if (secretKey != null) {
            return secretKey;
        }
        Timber.d("generating shared encryption key for " + p2PMessage, new Object[0]);
        this._others.put(p2PMessage.getHeader().getSourceID(), SecureUtilKt.decodeECPublicKey(p2PMessage.getBody().getContents().getPubKey()));
        Log.d("XYZ encdeets", "hs " + order + ':' + p2PMessage + ' ');
        int i = WhenMappings.$EnumSwitchMapping$0[order.ordinal()];
        if (i == 1) {
            KeyPair keyPair = getEphKeyPairs().get(sourceID);
            if (keyPair == null) {
                return null;
            }
            Map<UUID, byte[]> map = this._ivs;
            Pair<byte[], byte[]> pair = this.halves.get(sourceID);
            if (pair == null || (first = pair.getFirst()) == null || (plus = ArraysKt.plus(first, p2PMessage.getBody().getContents().getIv())) == null) {
                throw new IllegalStateException("failed to find salt half for " + sourceID);
            }
            map.put(sourceID, plus);
            Map<UUID, byte[]> map2 = this._salts;
            Pair<byte[], byte[]> pair2 = this.halves.get(sourceID);
            if (pair2 == null || (second = pair2.getSecond()) == null || (plus2 = ArraysKt.plus(second, p2PMessage.getBody().getContents().getSalt())) == null) {
                throw new IllegalStateException("failed to find iv half for " + sourceID);
            }
            map2.put(sourceID, plus2);
            Map<UUID, byte[]> map3 = this._sharedSecrets;
            ECPublicKey decodeECPublicKey = SecureUtilKt.decodeECPublicKey(p2PMessage.getBody().getContents().getPubKey());
            PrivateKey privateKey = keyPair.getPrivate();
            Intrinsics.checkNotNullExpressionValue(privateKey, "it.private");
            map3.put(sourceID, SecureUtilKt.generateSharedSecret(decodeECPublicKey, privateKey));
            Map<UUID, SecretKey> map4 = this._aesKeys;
            SecretKey secretKey2 = map4.get(sourceID);
            if (secretKey2 == null) {
                byte[] bArr = getSharedSecrets().get(sourceID);
                if (bArr != null) {
                    byte[] bArr2 = getSalts().get(sourceID);
                    if (bArr2 != null) {
                        secretKey2 = SecureUtilKt.generateAESKey(bArr, bArr2);
                    } else {
                        throw new IllegalStateException("failed to lookup shared secret for " + sourceID);
                    }
                } else {
                    throw new IllegalStateException("failed to lookup shared secret for " + sourceID);
                }
            }
            if (secretKey2 != null) {
                map4.put(sourceID, secretKey2);
                Observable<UUID> observable = this.securedSessions;
                Objects.requireNonNull(observable, "null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<java.util.UUID>");
                ((PublishSubject) observable).onNext(sourceID);
                SecretKey secretKey3 = getAesKeys().get(sourceID);
                if (secretKey3 != null) {
                    return secretKey3;
                }
                throw new IllegalStateException("failed to lookup aes key for " + sourceID);
            }
            throw new Throwable("Failed to expand AES key for " + sourceID);
        } else if (i == 2) {
            Map<UUID, KeyPair> map5 = this._ephKeyPairs;
            KeyPair keyPair2 = map5.get(sourceID);
            if (keyPair2 == null) {
                keyPair2 = SecureUtilKt.generateDHEphKeys();
            }
            map5.put(sourceID, keyPair2);
            this.halves.put(sourceID, new Pair<>(SecureUtilKt.generateRandomBytes(8, this.random), SecureUtilKt.generateRandomBytes(16, this.random)));
            Map<UUID, byte[]> map6 = this._ivs;
            Pair<byte[], byte[]> pair3 = this.halves.get(sourceID);
            if (pair3 == null || (first2 = pair3.getFirst()) == null || (plus3 = ArraysKt.plus(p2PMessage.getBody().getContents().getIv(), first2)) == null) {
                throw new IllegalStateException("failed to find salt half for " + sourceID);
            }
            map6.put(sourceID, plus3);
            Map<UUID, byte[]> map7 = this._salts;
            Pair<byte[], byte[]> pair4 = this.halves.get(sourceID);
            if (pair4 == null || (second2 = pair4.getSecond()) == null || (plus4 = ArraysKt.plus(p2PMessage.getBody().getContents().getSalt(), second2)) == null) {
                throw new IllegalStateException("failed to find iv half for " + sourceID);
            }
            map7.put(sourceID, plus4);
            KeyPair keyPair3 = getEphKeyPairs().get(sourceID);
            if (keyPair3 == null) {
                return null;
            }
            Map<UUID, byte[]> map8 = this._sharedSecrets;
            ECPublicKey decodeECPublicKey2 = SecureUtilKt.decodeECPublicKey(p2PMessage.getBody().getContents().getPubKey());
            PrivateKey privateKey2 = keyPair3.getPrivate();
            Intrinsics.checkNotNullExpressionValue(privateKey2, "it.private");
            map8.put(sourceID, SecureUtilKt.generateSharedSecret(decodeECPublicKey2, privateKey2));
            Map<UUID, SecretKey> map9 = this._aesKeys;
            byte[] bArr3 = getSharedSecrets().get(sourceID);
            if (bArr3 != null) {
                byte[] bArr4 = getSalts().get(sourceID);
                if (bArr4 != null) {
                    SecretKey generateAESKey = SecureUtilKt.generateAESKey(bArr3, bArr4);
                    if (generateAESKey != null) {
                        map9.put(sourceID, generateAESKey);
                        Observable<UUID> observable2 = this.securedSessions;
                        Objects.requireNonNull(observable2, "null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<java.util.UUID>");
                        ((PublishSubject) observable2).onNext(sourceID);
                        SecretKey secretKey4 = getAesKeys().get(sourceID);
                        if (secretKey4 != null) {
                            return secretKey4;
                        }
                        throw new IllegalStateException("failed to lookup aes key for " + sourceID);
                    }
                    throw new Throwable("Failed to expand AES key for " + sourceID);
                }
                throw new IllegalStateException("failed to lookup shared secret for " + sourceID);
            }
            throw new IllegalStateException("failed to lookup shared secret for " + sourceID);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final InitHandshakeData generateDataForHandshake(UUID uuid) {
        PublicKey publicKey;
        byte[] encoded;
        List<Byte> takeLast;
        byte[] byteArray;
        byte[] first;
        byte[] second;
        Intrinsics.checkNotNullParameter(uuid, "other");
        Map<UUID, Pair<byte[], byte[]>> map = this.halves;
        Pair<byte[], byte[]> pair = map.get(uuid);
        if (pair == null) {
            pair = new Pair<>(SecureUtilKt.generateRandomBytes(8, this.random), SecureUtilKt.generateRandomBytes(16, this.random));
        }
        map.put(uuid, pair);
        Map<UUID, KeyPair> map2 = this._ephKeyPairs;
        KeyPair keyPair = map2.get(uuid);
        if (keyPair == null) {
            keyPair = SecureUtilKt.generateDHEphKeys();
        }
        map2.put(uuid, keyPair);
        KeyPair keyPair2 = getEphKeyPairs().get(uuid);
        if (keyPair2 == null || (publicKey = keyPair2.getPublic()) == null || (encoded = publicKey.getEncoded()) == null || (takeLast = ArraysKt.takeLast(encoded, 65)) == null || (byteArray = CollectionsKt.toByteArray(takeLast)) == null) {
            throw new IllegalStateException("failed to get public key for " + uuid);
        }
        Pair<byte[], byte[]> pair2 = this.halves.get(uuid);
        if (pair2 == null || (first = pair2.getFirst()) == null) {
            throw new IllegalStateException("failed to get iv for " + uuid);
        }
        Pair<byte[], byte[]> pair3 = this.halves.get(uuid);
        if (pair3 != null && (second = pair3.getSecond()) != null) {
            return new InitHandshakeData(byteArray, first, second);
        }
        throw new IllegalStateException("failed to get salt for " + uuid);
    }

    public final byte[] decryptFor(byte[] bArr, UUID uuid) {
        Intrinsics.checkNotNullParameter(bArr, P2PMessage.encryptedKey);
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        SecretKey secretKey = getAesKeys().get(uuid);
        if (secretKey != null) {
            byte[] bArr2 = getIvs().get(uuid);
            if (bArr2 != null) {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                StringBuilder sb = new StringBuilder();
                sb.append("iv:");
                String arrays = Arrays.toString(bArr2);
                Intrinsics.checkNotNullExpressionValue(arrays, "java.util.Arrays.toString(this)");
                sb.append(arrays);
                sb.append(' ');
                Log.d("XYZ encdeets", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("symmkey:");
                String arrays2 = Arrays.toString(secretKey.getEncoded());
                Intrinsics.checkNotNullExpressionValue(arrays2, "java.util.Arrays.toString(this)");
                sb2.append(arrays2);
                sb2.append(' ');
                Log.d("XYZ encdeets", sb2.toString());
                instance.init(2, secretKey, ivParameterSpec);
                byte[] doFinal = instance.doFinal(bArr);
                Intrinsics.checkNotNullExpressionValue(doFinal, "cipher.doFinal(encrypted)");
                return doFinal;
            }
            throw new IllegalStateException("no iv found for " + uuid);
        }
        throw new IllegalStateException("no symmetric key found for " + uuid);
    }

    public final byte[] encryptFor(byte[] bArr, UUID uuid) {
        Intrinsics.checkNotNullParameter(bArr, "message");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        SecretKey secretKey = getAesKeys().get(uuid);
        if (secretKey != null) {
            byte[] bArr2 = getIvs().get(uuid);
            if (bArr2 != null) {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
                StringBuilder sb = new StringBuilder();
                sb.append("iv:");
                String arrays = Arrays.toString(bArr2);
                Intrinsics.checkNotNullExpressionValue(arrays, "java.util.Arrays.toString(this)");
                sb.append(arrays);
                sb.append(' ');
                Log.d("XYZ encdeets", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("symmkey:");
                String arrays2 = Arrays.toString(secretKey.getEncoded());
                Intrinsics.checkNotNullExpressionValue(arrays2, "java.util.Arrays.toString(this)");
                sb2.append(arrays2);
                sb2.append(' ');
                Log.d("XYZ encdeets", sb2.toString());
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                instance.init(1, secretKey, ivParameterSpec);
                byte[] doFinal = instance.doFinal(bArr);
                Intrinsics.checkNotNullExpressionValue(doFinal, "cipher.doFinal(message)");
                return doFinal;
            }
            throw new IllegalStateException("no iv found for " + uuid);
        }
        throw new IllegalStateException("no symmetric key found for " + uuid);
    }

    public final void reset() {
        this._sessionId = UUID.randomUUID();
        this._sharedSecrets.clear();
        this._aesKeys.clear();
        this._ephKeyPairs.clear();
        this._salts.clear();
        this._ivs.clear();
        this.halves.clear();
        this._others.clear();
    }

    public final UUID getSessionId() {
        UUID uuid = this._sessionId;
        Intrinsics.checkNotNullExpressionValue(uuid, "_sessionId");
        return uuid;
    }

    public final Observable<UUID> getSecuredSessions() {
        return this.securedSessions;
    }

    public final Map<UUID, byte[]> getSharedSecrets() {
        return this._sharedSecrets;
    }

    public final Map<UUID, SecretKey> getAesKeys() {
        return this._aesKeys;
    }

    public final Map<UUID, KeyPair> getEphKeyPairs() {
        return this._ephKeyPairs;
    }

    public final Map<UUID, byte[]> getSalts() {
        return this._salts;
    }

    public final Map<UUID, byte[]> getIvs() {
        return this._ivs;
    }

    public final Map<UUID, ECPublicKey> getPublicKeys() {
        return this._others;
    }
}
