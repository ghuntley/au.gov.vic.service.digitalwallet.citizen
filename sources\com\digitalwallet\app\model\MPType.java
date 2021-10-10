package com.digitalwallet.app.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/digitalwallet/app/model/MPType;", "", "()V", "typeToken", "Lcom/digitalwallet/app/model/MPTypeToken;", "getTypeToken", "()Lcom/digitalwallet/app/model/MPTypeToken;", "asMap", "", "", "Lcom/digitalwallet/app/model/P2PHeader;", "Lcom/digitalwallet/app/model/Body;", "Lcom/digitalwallet/app/model/MPContent;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: MPType.kt */
public abstract class MPType {
    public abstract Map<String, Object> asMap();

    public abstract MPTypeToken getTypeToken();

    private MPType() {
    }

    public /* synthetic */ MPType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
