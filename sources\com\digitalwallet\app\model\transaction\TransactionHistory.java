package com.digitalwallet.app.model.transaction;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/model/transaction/TransactionHistory;", "", "totalRecords", "", "records", "", "Lcom/digitalwallet/app/model/transaction/TransactionHistoryItem;", "(ILjava/util/List;)V", "getRecords", "()Ljava/util/List;", "getTotalRecords", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: TransactionHistory.kt */
public final class TransactionHistory {
    private final List<TransactionHistoryItem> records;
    private final int totalRecords;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.digitalwallet.app.model.transaction.TransactionHistory */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TransactionHistory copy$default(TransactionHistory transactionHistory, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = transactionHistory.totalRecords;
        }
        if ((i2 & 2) != 0) {
            list = transactionHistory.records;
        }
        return transactionHistory.copy(i, list);
    }

    public final int component1() {
        return this.totalRecords;
    }

    public final List<TransactionHistoryItem> component2() {
        return this.records;
    }

    public final TransactionHistory copy(int i, List<TransactionHistoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "records");
        return new TransactionHistory(i, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransactionHistory)) {
            return false;
        }
        TransactionHistory transactionHistory = (TransactionHistory) obj;
        return this.totalRecords == transactionHistory.totalRecords && Intrinsics.areEqual(this.records, transactionHistory.records);
    }

    public int hashCode() {
        int i = this.totalRecords * 31;
        List<TransactionHistoryItem> list = this.records;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "TransactionHistory(totalRecords=" + this.totalRecords + ", records=" + this.records + ")";
    }

    public TransactionHistory(int i, List<TransactionHistoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "records");
        this.totalRecords = i;
        this.records = list;
    }

    public final int getTotalRecords() {
        return this.totalRecords;
    }

    public final List<TransactionHistoryItem> getRecords() {
        return this.records;
    }
}
