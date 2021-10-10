package com.digitalwallet.app.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0006\u0007\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/digitalwallet/app/model/MPContent;", "Lcom/digitalwallet/app/model/MPType;", "()V", "typeString", "", "getTypeString", "()Ljava/lang/String;", "Lcom/digitalwallet/app/model/InitHandshakeData;", "Lcom/digitalwallet/app/model/Register;", "Lcom/digitalwallet/app/model/LobbyInvite;", "Lcom/digitalwallet/app/model/JoinLobby;", "Lcom/digitalwallet/app/model/RequestHolding;", "Lcom/digitalwallet/app/model/ShareHolding;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: MPType.kt */
public abstract class MPContent extends MPType {
    public abstract String getTypeString();

    private MPContent() {
        super(null);
    }

    public /* synthetic */ MPContent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
