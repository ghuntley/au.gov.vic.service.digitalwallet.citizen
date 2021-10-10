package com.digitalwallet.app.model.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.JsonClass;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JA\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\nHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006("}, d2 = {"Lcom/digitalwallet/app/model/login/SVCategory;", "Landroid/os/Parcelable;", "id", "", MessageBundle.TITLE_ENTRY, "description", "transactions", "", "Lcom/digitalwallet/app/model/login/SVTransaction;", "order", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;I)V", "getDescription", "()Ljava/lang/String;", "getId", "getOrder", "()I", "sortedTransactions", "getSortedTransactions", "()Ljava/util/List;", "getTitle", "getTransactions", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SVServices.kt */
public final class SVCategory implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String description;
    private final String id;
    private final int order;
    private final List<SVTransaction> sortedTransactions;
    private final String title;
    private final List<SVTransaction> transactions;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((SVTransaction) SVTransaction.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new SVCategory(readString, readString2, readString3, arrayList, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new SVCategory[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.digitalwallet.app.model.login.SVCategory */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SVCategory copy$default(SVCategory sVCategory, String str, String str2, String str3, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sVCategory.id;
        }
        if ((i2 & 2) != 0) {
            str2 = sVCategory.title;
        }
        if ((i2 & 4) != 0) {
            str3 = sVCategory.description;
        }
        if ((i2 & 8) != 0) {
            list = sVCategory.transactions;
        }
        if ((i2 & 16) != 0) {
            i = sVCategory.order;
        }
        return sVCategory.copy(str, str2, str3, list, i);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.description;
    }

    public final List<SVTransaction> component4() {
        return this.transactions;
    }

    public final int component5() {
        return this.order;
    }

    public final SVCategory copy(String str, String str2, String str3, List<SVTransaction> list, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(list, "transactions");
        return new SVCategory(str, str2, str3, list, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SVCategory)) {
            return false;
        }
        SVCategory sVCategory = (SVCategory) obj;
        return Intrinsics.areEqual(this.id, sVCategory.id) && Intrinsics.areEqual(this.title, sVCategory.title) && Intrinsics.areEqual(this.description, sVCategory.description) && Intrinsics.areEqual(this.transactions, sVCategory.transactions) && this.order == sVCategory.order;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.description;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<SVTransaction> list = this.transactions;
        if (list != null) {
            i = list.hashCode();
        }
        return ((hashCode3 + i) * 31) + this.order;
    }

    public String toString() {
        return "SVCategory(id=" + this.id + ", title=" + this.title + ", description=" + this.description + ", transactions=" + this.transactions + ", order=" + this.order + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        List<SVTransaction> list = this.transactions;
        parcel.writeInt(list.size());
        for (SVTransaction sVTransaction : list) {
            sVTransaction.writeToParcel(parcel, 0);
        }
        parcel.writeInt(this.order);
    }

    public SVCategory(String str, String str2, String str3, List<SVTransaction> list, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(list, "transactions");
        this.id = str;
        this.title = str2;
        this.description = str3;
        this.transactions = list;
        this.order = i;
        this.sortedTransactions = CollectionsKt.sortedWith(list, new SVCategory$$special$$inlined$sortedBy$1());
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.id;
    }

    public final int getOrder() {
        return this.order;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<SVTransaction> getTransactions() {
        return this.transactions;
    }

    public final List<SVTransaction> getSortedTransactions() {
        return this.sortedTransactions;
    }
}
