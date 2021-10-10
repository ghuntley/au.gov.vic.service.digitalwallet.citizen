package com.digitalwallet.app.model.transaction;

import com.digitalwallet.utilities.DateFormattingHelper;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0010\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006!"}, d2 = {"Lcom/digitalwallet/app/model/transaction/TransactionHistoryItem;", "", "transactionReferenceNumber", "", "createdDate", "name", "domain", "status", "showReferenceNumber", "", "createdDateFormatted", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getCreatedDateFormatted", "()Ljava/lang/String;", "getDomain", "getName", "getShowReferenceNumber", "()Z", "getStatus", "getTransactionReferenceNumber", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: TransactionHistoryItem.kt */
public final class TransactionHistoryItem {
    @Json(name = "createdDate")
    private final String createdDate;
    private final String createdDateFormatted;
    @Json(name = "domain")
    private final String domain;
    @Json(name = "name")
    private final String name;
    private final boolean showReferenceNumber;
    @Json(name = "status")
    private final String status;
    @Json(name = "transactionReferenceNumber")
    private final String transactionReferenceNumber;

    public TransactionHistoryItem() {
        this(null, null, null, null, null, false, null, 127, null);
    }

    private final String component2() {
        return this.createdDate;
    }

    public static /* synthetic */ TransactionHistoryItem copy$default(TransactionHistoryItem transactionHistoryItem, String str, String str2, String str3, String str4, String str5, boolean z, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = transactionHistoryItem.transactionReferenceNumber;
        }
        if ((i & 2) != 0) {
            str2 = transactionHistoryItem.createdDate;
        }
        if ((i & 4) != 0) {
            str3 = transactionHistoryItem.name;
        }
        if ((i & 8) != 0) {
            str4 = transactionHistoryItem.domain;
        }
        if ((i & 16) != 0) {
            str5 = transactionHistoryItem.status;
        }
        if ((i & 32) != 0) {
            z = transactionHistoryItem.showReferenceNumber;
        }
        if ((i & 64) != 0) {
            str6 = transactionHistoryItem.createdDateFormatted;
        }
        return transactionHistoryItem.copy(str, str2, str3, str4, str5, z, str6);
    }

    public final String component1() {
        return this.transactionReferenceNumber;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.domain;
    }

    public final String component5() {
        return this.status;
    }

    public final boolean component6() {
        return this.showReferenceNumber;
    }

    public final String component7() {
        return this.createdDateFormatted;
    }

    public final TransactionHistoryItem copy(String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        Intrinsics.checkNotNullParameter(str, "transactionReferenceNumber");
        Intrinsics.checkNotNullParameter(str2, "createdDate");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, "domain");
        Intrinsics.checkNotNullParameter(str5, "status");
        Intrinsics.checkNotNullParameter(str6, "createdDateFormatted");
        return new TransactionHistoryItem(str, str2, str3, str4, str5, z, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransactionHistoryItem)) {
            return false;
        }
        TransactionHistoryItem transactionHistoryItem = (TransactionHistoryItem) obj;
        return Intrinsics.areEqual(this.transactionReferenceNumber, transactionHistoryItem.transactionReferenceNumber) && Intrinsics.areEqual(this.createdDate, transactionHistoryItem.createdDate) && Intrinsics.areEqual(this.name, transactionHistoryItem.name) && Intrinsics.areEqual(this.domain, transactionHistoryItem.domain) && Intrinsics.areEqual(this.status, transactionHistoryItem.status) && this.showReferenceNumber == transactionHistoryItem.showReferenceNumber && Intrinsics.areEqual(this.createdDateFormatted, transactionHistoryItem.createdDateFormatted);
    }

    public int hashCode() {
        String str = this.transactionReferenceNumber;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.createdDate;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.domain;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.status;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        boolean z = this.showReferenceNumber;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode5 + i2) * 31;
        String str6 = this.createdDateFormatted;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return i5 + i;
    }

    public String toString() {
        return "TransactionHistoryItem(transactionReferenceNumber=" + this.transactionReferenceNumber + ", createdDate=" + this.createdDate + ", name=" + this.name + ", domain=" + this.domain + ", status=" + this.status + ", showReferenceNumber=" + this.showReferenceNumber + ", createdDateFormatted=" + this.createdDateFormatted + ")";
    }

    public TransactionHistoryItem(String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        Intrinsics.checkNotNullParameter(str, "transactionReferenceNumber");
        Intrinsics.checkNotNullParameter(str2, "createdDate");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, "domain");
        Intrinsics.checkNotNullParameter(str5, "status");
        Intrinsics.checkNotNullParameter(str6, "createdDateFormatted");
        this.transactionReferenceNumber = str;
        this.createdDate = str2;
        this.name = str3;
        this.domain = str4;
        this.status = str5;
        this.showReferenceNumber = z;
        this.createdDateFormatted = str6;
    }

    public final String getTransactionReferenceNumber() {
        return this.transactionReferenceNumber;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getStatus() {
        return this.status;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public /* synthetic */ TransactionHistoryItem(String str, String str2, String str3, String str4, String str5, boolean z, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r14, r1, (i & 4) != 0 ? r0 : str3, (i & 8) != 0 ? r0 : str4, (i & 16) == 0 ? str5 : r0, (i & 32) != 0 ? StringsKt.startsWith$default(r14, "SV", false, 2, (Object) null) : z, (i & 64) != 0 ? DateFormattingHelper.INSTANCE.toDateWithMonthAsWordFromUTC(r1) : str6);
        String str7 = "";
        String str8 = (i & 1) != 0 ? str7 : str;
        String str9 = (i & 2) != 0 ? str7 : str2;
    }

    public final boolean getShowReferenceNumber() {
        return this.showReferenceNumber;
    }

    public final String getCreatedDateFormatted() {
        return this.createdDateFormatted;
    }
}
