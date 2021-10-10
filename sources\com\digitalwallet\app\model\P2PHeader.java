package com.digitalwallet.app.model;

import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u0016\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0016H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J?\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Lcom/digitalwallet/app/model/P2PHeader;", "Lcom/digitalwallet/app/model/MPType;", P2PHeader.versionKey, "", P2PHeader.messageIdKey, "Ljava/util/UUID;", P2PHeader.responseIdKey, P2PHeader.sourceIdKey, P2PHeader.destinationIdKey, "(ILjava/util/UUID;Ljava/util/UUID;Ljava/util/UUID;Ljava/util/UUID;)V", "getDestinationID", "()Ljava/util/UUID;", "getMessageID", "getResponseID", "getSourceID", "typeToken", "Lcom/digitalwallet/app/model/MPTypeToken;", "getTypeToken", "()Lcom/digitalwallet/app/model/MPTypeToken;", "getVersion", "()I", "asMap", "", "", "", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: MPType.kt */
public final class P2PHeader extends MPType {
    public static final Companion Companion = new Companion(null);
    public static final String destinationIdKey = "destinationID";
    public static final String messageIdKey = "messageID";
    public static final String responseIdKey = "responseID";
    public static final String sourceIdKey = "sourceID";
    public static final String versionKey = "version";
    private final UUID destinationID;
    private final UUID messageID;
    private final UUID responseID;
    private final UUID sourceID;
    private final MPTypeToken typeToken;
    private final int version;

    public static /* synthetic */ P2PHeader copy$default(P2PHeader p2PHeader, int i, UUID uuid, UUID uuid2, UUID uuid3, UUID uuid4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = p2PHeader.version;
        }
        if ((i2 & 2) != 0) {
            uuid = p2PHeader.messageID;
        }
        if ((i2 & 4) != 0) {
            uuid2 = p2PHeader.responseID;
        }
        if ((i2 & 8) != 0) {
            uuid3 = p2PHeader.sourceID;
        }
        if ((i2 & 16) != 0) {
            uuid4 = p2PHeader.destinationID;
        }
        return p2PHeader.copy(i, uuid, uuid2, uuid3, uuid4);
    }

    public final int component1() {
        return this.version;
    }

    public final UUID component2() {
        return this.messageID;
    }

    public final UUID component3() {
        return this.responseID;
    }

    public final UUID component4() {
        return this.sourceID;
    }

    public final UUID component5() {
        return this.destinationID;
    }

    public final P2PHeader copy(int i, UUID uuid, UUID uuid2, UUID uuid3, UUID uuid4) {
        Intrinsics.checkNotNullParameter(uuid, messageIdKey);
        Intrinsics.checkNotNullParameter(uuid3, sourceIdKey);
        return new P2PHeader(i, uuid, uuid2, uuid3, uuid4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof P2PHeader)) {
            return false;
        }
        P2PHeader p2PHeader = (P2PHeader) obj;
        return this.version == p2PHeader.version && Intrinsics.areEqual(this.messageID, p2PHeader.messageID) && Intrinsics.areEqual(this.responseID, p2PHeader.responseID) && Intrinsics.areEqual(this.sourceID, p2PHeader.sourceID) && Intrinsics.areEqual(this.destinationID, p2PHeader.destinationID);
    }

    public int hashCode() {
        int i = this.version * 31;
        UUID uuid = this.messageID;
        int i2 = 0;
        int hashCode = (i + (uuid != null ? uuid.hashCode() : 0)) * 31;
        UUID uuid2 = this.responseID;
        int hashCode2 = (hashCode + (uuid2 != null ? uuid2.hashCode() : 0)) * 31;
        UUID uuid3 = this.sourceID;
        int hashCode3 = (hashCode2 + (uuid3 != null ? uuid3.hashCode() : 0)) * 31;
        UUID uuid4 = this.destinationID;
        if (uuid4 != null) {
            i2 = uuid4.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        return "P2PHeader(version=" + this.version + ", messageID=" + this.messageID + ", responseID=" + this.responseID + ", sourceID=" + this.sourceID + ", destinationID=" + this.destinationID + ")";
    }

    public final int getVersion() {
        return this.version;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public /* synthetic */ P2PHeader(int i, UUID uuid, UUID uuid2, UUID uuid3, UUID uuid4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, uuid, (i2 & 4) != 0 ? null : uuid2, uuid3, (i2 & 16) != 0 ? null : uuid4);
        i = (i2 & 1) != 0 ? 0 : i;
        if ((i2 & 2) != 0) {
            uuid = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuid, "UUID.randomUUID()");
        }
    }

    public final UUID getMessageID() {
        return this.messageID;
    }

    public final UUID getResponseID() {
        return this.responseID;
    }

    public final UUID getSourceID() {
        return this.sourceID;
    }

    public final UUID getDestinationID() {
        return this.destinationID;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/model/P2PHeader$Companion;", "", "()V", "destinationIdKey", "", "messageIdKey", "responseIdKey", "sourceIdKey", "versionKey", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: MPType.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public P2PHeader(int i, UUID uuid, UUID uuid2, UUID uuid3, UUID uuid4) {
        super(null);
        Intrinsics.checkNotNullParameter(uuid, messageIdKey);
        Intrinsics.checkNotNullParameter(uuid3, sourceIdKey);
        this.version = i;
        this.messageID = uuid;
        this.responseID = uuid2;
        this.sourceID = uuid3;
        this.destinationID = uuid4;
        this.typeToken = MPTypeToken.HEADER;
    }

    @Override // com.digitalwallet.app.model.MPType
    public MPTypeToken getTypeToken() {
        return this.typeToken;
    }

    @Override // com.digitalwallet.app.model.MPType
    public Map<String, Object> asMap() {
        return MapsKt.mapOf(TuplesKt.to(versionKey, Integer.valueOf(this.version)), TuplesKt.to(messageIdKey, this.messageID), TuplesKt.to(sourceIdKey, this.sourceID), TuplesKt.to(responseIdKey, this.responseID), TuplesKt.to(destinationIdKey, this.destinationID));
    }
}
