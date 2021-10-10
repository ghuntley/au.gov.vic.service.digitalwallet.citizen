package com.digitalwallet.app.model;

import com.digitalwallet.app.model.MPContent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001e*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u001eB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000e\u0010\u0015\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\tJ(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/digitalwallet/app/model/Body;", "T", "Lcom/digitalwallet/app/model/MPContent;", "Lcom/digitalwallet/app/model/MPType;", "type", "", Body.contentsKey, "(Ljava/lang/String;Lcom/digitalwallet/app/model/MPContent;)V", "getContents", "()Lcom/digitalwallet/app/model/MPContent;", "Lcom/digitalwallet/app/model/MPContent;", "getType", "()Ljava/lang/String;", "typeToken", "Lcom/digitalwallet/app/model/MPTypeToken;", "getTypeToken", "()Lcom/digitalwallet/app/model/MPTypeToken;", "asMap", "", "", "component1", "component2", "copy", "(Ljava/lang/String;Lcom/digitalwallet/app/model/MPContent;)Lcom/digitalwallet/app/model/Body;", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: MPType.kt */
public final class Body<T extends MPContent> extends MPType {
    public static final Companion Companion = new Companion(null);
    public static final String contentsKey = "contents";
    public static final String typeKey = "type";
    private final T contents;
    private final String type;
    private final MPTypeToken typeToken = MPTypeToken.BODY;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.digitalwallet.app.model.Body */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Body copy$default(Body body, String str, MPContent mPContent, int i, Object obj) {
        if ((i & 1) != 0) {
            str = body.type;
        }
        if ((i & 2) != 0) {
            mPContent = body.contents;
        }
        return body.copy(str, mPContent);
    }

    public final String component1() {
        return this.type;
    }

    public final T component2() {
        return this.contents;
    }

    public final Body<T> copy(String str, T t) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(t, contentsKey);
        return new Body<>(str, t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Body)) {
            return false;
        }
        Body body = (Body) obj;
        return Intrinsics.areEqual(this.type, body.type) && Intrinsics.areEqual(this.contents, body.contents);
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        T t = this.contents;
        if (t != null) {
            i = t.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Body(type=" + this.type + ", contents=" + this.contents + ")";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/digitalwallet/app/model/Body$Companion;", "", "()V", "contentsKey", "", "typeKey", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: MPType.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Body(String str, T t) {
        super(null);
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(t, contentsKey);
        this.type = str;
        this.contents = t;
    }

    public final T getContents() {
        return this.contents;
    }

    public final String getType() {
        return this.type;
    }

    @Override // com.digitalwallet.app.model.MPType
    public MPTypeToken getTypeToken() {
        return this.typeToken;
    }

    @Override // com.digitalwallet.app.model.MPType
    public Map<String, Object> asMap() {
        return MapsKt.mapOf(TuplesKt.to("type", this.type), TuplesKt.to(contentsKey, this.contents.asMap()));
    }
}
