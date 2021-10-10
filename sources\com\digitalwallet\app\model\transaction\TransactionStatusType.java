package com.digitalwallet.app.model.transaction;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/model/transaction/TransactionStatusType;", "", "displayName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "SHARED_WITH_AUTHORITY", "DENIED_TO_AUTHORITY", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: TransactionStatusType.kt */
public enum TransactionStatusType {
    SHARED_WITH_AUTHORITY("Shared With Authority"),
    DENIED_TO_AUTHORITY("Denied To Authority");
    
    private final String displayName;

    private TransactionStatusType(String str) {
        this.displayName = str;
    }

    public final String getDisplayName() {
        return this.displayName;
    }
}
