package com.digitalwallet.app.model;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000  2\u00020\u0001:\u0001 B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J'\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\t\u0010\u001f\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/digitalwallet/app/model/InitHandshakeData;", "Lcom/digitalwallet/app/model/MPContent;", "pubKey", "", InitHandshakeData.ivKey, InitHandshakeData.saltKey, "([B[B[B)V", "getIv", "()[B", "getPubKey", "getSalt", "typeString", "", "getTypeString", "()Ljava/lang/String;", "typeToken", "Lcom/digitalwallet/app/model/MPTypeToken;", "getTypeToken", "()Lcom/digitalwallet/app/model/MPTypeToken;", "asMap", "", "", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: MPType.kt */
public final class InitHandshakeData extends MPContent {
    public static final Companion Companion = new Companion(null);
    public static final String ivKey = "iv";
    public static final String pubKeyKey = "pubKeyEph";
    public static final String saltKey = "salt";
    private final byte[] iv;
    private final byte[] pubKey;
    private final byte[] salt;
    private final String typeString = "handshake";
    private final MPTypeToken typeToken = MPTypeToken.HANDSHAKE;

    public static /* synthetic */ InitHandshakeData copy$default(InitHandshakeData initHandshakeData, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = initHandshakeData.pubKey;
        }
        if ((i & 2) != 0) {
            bArr2 = initHandshakeData.iv;
        }
        if ((i & 4) != 0) {
            bArr3 = initHandshakeData.salt;
        }
        return initHandshakeData.copy(bArr, bArr2, bArr3);
    }

    public final byte[] component1() {
        return this.pubKey;
    }

    public final byte[] component2() {
        return this.iv;
    }

    public final byte[] component3() {
        return this.salt;
    }

    public final InitHandshakeData copy(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        Intrinsics.checkNotNullParameter(bArr, "pubKey");
        Intrinsics.checkNotNullParameter(bArr2, ivKey);
        Intrinsics.checkNotNullParameter(bArr3, saltKey);
        return new InitHandshakeData(bArr, bArr2, bArr3);
    }

    public String toString() {
        return "InitHandshakeData(pubKey=" + Arrays.toString(this.pubKey) + ", iv=" + Arrays.toString(this.iv) + ", salt=" + Arrays.toString(this.salt) + ")";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InitHandshakeData(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(null);
        Intrinsics.checkNotNullParameter(bArr, "pubKey");
        Intrinsics.checkNotNullParameter(bArr2, ivKey);
        Intrinsics.checkNotNullParameter(bArr3, saltKey);
        this.pubKey = bArr;
        this.iv = bArr2;
        this.salt = bArr3;
    }

    public final byte[] getIv() {
        return this.iv;
    }

    public final byte[] getPubKey() {
        return this.pubKey;
    }

    public final byte[] getSalt() {
        return this.salt;
    }

    @Override // com.digitalwallet.app.model.MPContent
    public String getTypeString() {
        return this.typeString;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/app/model/InitHandshakeData$Companion;", "", "()V", "ivKey", "", "pubKeyKey", "saltKey", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: MPType.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.digitalwallet.app.model.MPType
    public MPTypeToken getTypeToken() {
        return this.typeToken;
    }

    @Override // com.digitalwallet.app.model.MPType
    public Map<String, Object> asMap() {
        return MapsKt.mapOf(TuplesKt.to(pubKeyKey, this.pubKey), TuplesKt.to(ivKey, this.iv), TuplesKt.to(saltKey, this.salt));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.digitalwallet.app.model.InitHandshakeData");
        InitHandshakeData initHandshakeData = (InitHandshakeData) obj;
        if (Arrays.equals(this.pubKey, initHandshakeData.pubKey) && Arrays.equals(this.iv, initHandshakeData.iv) && Arrays.equals(this.salt, initHandshakeData.salt)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.pubKey) * 31) + Arrays.hashCode(this.iv)) * 31) + Arrays.hashCode(this.salt);
    }
}
