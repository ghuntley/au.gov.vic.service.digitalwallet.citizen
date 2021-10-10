package com.digitalwallet.app.oidc.model;

import com.digitalwallet.app.model.db.harvester.HarvestBatch$$ExternalSynthetic0;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/digitalwallet/app/oidc/model/Tokens;", "", "id", "", "access", "refresh", "expiresIn", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;D)V", "getAccess", "()Ljava/lang/String;", "expiresBy", "", "getExpiresBy", "()J", "getExpiresIn", "()D", "getId", "getRefresh", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "haveExpired", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Tokens.kt */
public class Tokens {
    private final String access;
    private final long expiresBy = (System.currentTimeMillis() + (((long) getExpiresIn()) * 1000));
    private final double expiresIn;
    private final String id;
    private final String refresh;

    public static /* synthetic */ Tokens copy$default(Tokens tokens, String str, String str2, String str3, double d, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = tokens.getId();
            }
            if ((i & 2) != 0) {
                str2 = tokens.getAccess();
            }
            if ((i & 4) != 0) {
                str3 = tokens.getRefresh();
            }
            if ((i & 8) != 0) {
                d = tokens.getExpiresIn();
            }
            return tokens.copy(str, str2, str3, d);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
    }

    public final String component1() {
        return getId();
    }

    public final String component2() {
        return getAccess();
    }

    public final String component3() {
        return getRefresh();
    }

    public final double component4() {
        return getExpiresIn();
    }

    public final Tokens copy(@Json(name = "id_token") String str, @Json(name = "access_token") String str2, @Json(name = "refresh_token") String str3, @Json(name = "expires_in") double d) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "access");
        Intrinsics.checkNotNullParameter(str3, "refresh");
        return new Tokens(str, str2, str3, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tokens)) {
            return false;
        }
        Tokens tokens = (Tokens) obj;
        return Intrinsics.areEqual(getId(), tokens.getId()) && Intrinsics.areEqual(getAccess(), tokens.getAccess()) && Intrinsics.areEqual(getRefresh(), tokens.getRefresh()) && Double.compare(getExpiresIn(), tokens.getExpiresIn()) == 0;
    }

    public int hashCode() {
        String id2 = getId();
        int i = 0;
        int hashCode = (id2 != null ? id2.hashCode() : 0) * 31;
        String access2 = getAccess();
        int hashCode2 = (hashCode + (access2 != null ? access2.hashCode() : 0)) * 31;
        String refresh2 = getRefresh();
        if (refresh2 != null) {
            i = refresh2.hashCode();
        }
        return ((hashCode2 + i) * 31) + HarvestBatch$$ExternalSynthetic0.m0(getExpiresIn());
    }

    public String toString() {
        return "Tokens(id=" + getId() + ", access=" + getAccess() + ", refresh=" + getRefresh() + ", expiresIn=" + getExpiresIn() + ")";
    }

    public Tokens(@Json(name = "id_token") String str, @Json(name = "access_token") String str2, @Json(name = "refresh_token") String str3, @Json(name = "expires_in") double d) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "access");
        Intrinsics.checkNotNullParameter(str3, "refresh");
        this.id = str;
        this.access = str2;
        this.refresh = str3;
        this.expiresIn = d;
    }

    public String getId() {
        return this.id;
    }

    public String getAccess() {
        return this.access;
    }

    public String getRefresh() {
        return this.refresh;
    }

    public double getExpiresIn() {
        return this.expiresIn;
    }

    public long getExpiresBy() {
        return this.expiresBy;
    }

    public boolean haveExpired() {
        return getExpiresBy() - System.currentTimeMillis() <= 0;
    }
}
