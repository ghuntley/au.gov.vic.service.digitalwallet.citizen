package com.digitalwallet.app.model;

import com.digitalwallet.app.model.MPContent;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \"*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\"B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0016J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003J?\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\t\u0010!\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/digitalwallet/app/model/P2PMessage;", "T", "Lcom/digitalwallet/app/model/MPContent;", "", P2PMessage.headerKey, "Lcom/digitalwallet/app/model/P2PHeader;", P2PMessage.contentsKey, "Lcom/digitalwallet/app/model/Body;", P2PMessage.encryptedKey, "", P2PMessage.signKey, "", "(Lcom/digitalwallet/app/model/P2PHeader;Lcom/digitalwallet/app/model/Body;Z[B)V", "getBody", "()Lcom/digitalwallet/app/model/Body;", "getEncrypted", "()Z", "getHeader", "()Lcom/digitalwallet/app/model/P2PHeader;", "getSignature", "()[B", "asMap", "", "", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: MPType.kt */
public final class P2PMessage<T extends MPContent> {
    public static final Companion Companion = new Companion(null);
    public static final String contentsKey = "body";
    public static final String encryptedKey = "encrypted";
    public static final String headerKey = "header";
    public static final String signKey = "signature";
    private final Body<T> body;
    private final boolean encrypted;
    private final P2PHeader header;
    private final byte[] signature;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.digitalwallet.app.model.P2PMessage */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ P2PMessage copy$default(P2PMessage p2PMessage, P2PHeader p2PHeader, Body body2, boolean z, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            p2PHeader = p2PMessage.header;
        }
        if ((i & 2) != 0) {
            body2 = p2PMessage.body;
        }
        if ((i & 4) != 0) {
            z = p2PMessage.encrypted;
        }
        if ((i & 8) != 0) {
            bArr = p2PMessage.signature;
        }
        return p2PMessage.copy(p2PHeader, body2, z, bArr);
    }

    public final P2PHeader component1() {
        return this.header;
    }

    public final Body<T> component2() {
        return this.body;
    }

    public final boolean component3() {
        return this.encrypted;
    }

    public final byte[] component4() {
        return this.signature;
    }

    public final P2PMessage<T> copy(P2PHeader p2PHeader, Body<T> body2, boolean z, byte[] bArr) {
        Intrinsics.checkNotNullParameter(p2PHeader, headerKey);
        Intrinsics.checkNotNullParameter(body2, contentsKey);
        return new P2PMessage<>(p2PHeader, body2, z, bArr);
    }

    public String toString() {
        return "P2PMessage(header=" + this.header + ", body=" + this.body + ", encrypted=" + this.encrypted + ", signature=" + Arrays.toString(this.signature) + ")";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/digitalwallet/app/model/P2PMessage$Companion;", "", "()V", "contentsKey", "", "encryptedKey", "headerKey", "signKey", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: MPType.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public P2PMessage(P2PHeader p2PHeader, Body<T> body2, boolean z, byte[] bArr) {
        Intrinsics.checkNotNullParameter(p2PHeader, headerKey);
        Intrinsics.checkNotNullParameter(body2, contentsKey);
        this.header = p2PHeader;
        this.body = body2;
        this.encrypted = z;
        this.signature = bArr;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ P2PMessage(P2PHeader p2PHeader, Body body2, boolean z, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(p2PHeader, body2, z, (i & 8) != 0 ? null : bArr);
    }

    public final Body<T> getBody() {
        return this.body;
    }

    public final boolean getEncrypted() {
        return this.encrypted;
    }

    public final P2PHeader getHeader() {
        return this.header;
    }

    public final byte[] getSignature() {
        return this.signature;
    }

    public final Map<String, Object> asMap() {
        return MapsKt.mapOf(TuplesKt.to(headerKey, this.header.asMap()), TuplesKt.to(contentsKey, this.body.asMap()), TuplesKt.to(encryptedKey, Boolean.valueOf(this.encrypted)), TuplesKt.to(signKey, this.signature));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.digitalwallet.app.model.P2PMessage<*>");
        P2PMessage p2PMessage = (P2PMessage) obj;
        if (!(!Intrinsics.areEqual(this.header, p2PMessage.header)) && !(!Intrinsics.areEqual(this.body, p2PMessage.body)) && this.encrypted == p2PMessage.encrypted && Arrays.equals(this.signature, p2PMessage.signature)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.header.hashCode() * 31) + this.body.hashCode()) * 31) + P2PMessage$$ExternalSynthetic0.m0(this.encrypted)) * 31;
        byte[] bArr = this.signature;
        return hashCode + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }
}
