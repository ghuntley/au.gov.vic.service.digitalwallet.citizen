package com.digitalwallet.app.model.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.JsonClass;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 .2\u00020\u0001:\u0001.BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\u0002\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007HÆ\u0003JY\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007HÆ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0005HÖ\u0001R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011¨\u0006/"}, d2 = {"Lcom/digitalwallet/app/model/login/SVService;", "Landroid/os/Parcelable;", "type", "", "order", "", FirebaseAnalytics.Param.ITEMS, "", "Lcom/digitalwallet/app/model/login/SVItem;", "id", MessageBundle.TITLE_ENTRY, "categories", "Lcom/digitalwallet/app/model/login/SVCategory;", "(Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCategories", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getItems", "getOrder", "()I", "sortedCategories", "getSortedCategories", "sortedItems", "getSortedItems", "getTitle", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SVServices.kt */
public final class SVService implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    public static final String TYPE_CAROUSEL = "carousel";
    public static final String TYPE_GROUP = "group";
    private final List<SVCategory> categories;
    private final String id;
    private final List<SVItem> items;
    private final int order;
    private final List<SVCategory> sortedCategories;
    private final List<SVItem> sortedItems;
    private final String title;
    private final String type;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList2 = null;
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                arrayList = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList.add((SVItem) SVItem.CREATOR.createFromParcel(parcel));
                    readInt2--;
                }
            } else {
                arrayList = null;
            }
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt3 = parcel.readInt();
                arrayList2 = new ArrayList(readInt3);
                while (readInt3 != 0) {
                    arrayList2.add((SVCategory) SVCategory.CREATOR.createFromParcel(parcel));
                    readInt3--;
                }
            }
            return new SVService(readString, readInt, arrayList, readString2, readString3, arrayList2);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new SVService[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.digitalwallet.app.model.login.SVService */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SVService copy$default(SVService sVService, String str, int i, List list, String str2, String str3, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sVService.type;
        }
        if ((i2 & 2) != 0) {
            i = sVService.order;
        }
        if ((i2 & 4) != 0) {
            list = sVService.items;
        }
        if ((i2 & 8) != 0) {
            str2 = sVService.id;
        }
        if ((i2 & 16) != 0) {
            str3 = sVService.title;
        }
        if ((i2 & 32) != 0) {
            list2 = sVService.categories;
        }
        return sVService.copy(str, i, list, str2, str3, list2);
    }

    public final String component1() {
        return this.type;
    }

    public final int component2() {
        return this.order;
    }

    public final List<SVItem> component3() {
        return this.items;
    }

    public final String component4() {
        return this.id;
    }

    public final String component5() {
        return this.title;
    }

    public final List<SVCategory> component6() {
        return this.categories;
    }

    public final SVService copy(String str, int i, List<SVItem> list, String str2, String str3, List<SVCategory> list2) {
        Intrinsics.checkNotNullParameter(str, "type");
        return new SVService(str, i, list, str2, str3, list2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SVService)) {
            return false;
        }
        SVService sVService = (SVService) obj;
        return Intrinsics.areEqual(this.type, sVService.type) && this.order == sVService.order && Intrinsics.areEqual(this.items, sVService.items) && Intrinsics.areEqual(this.id, sVService.id) && Intrinsics.areEqual(this.title, sVService.title) && Intrinsics.areEqual(this.categories, sVService.categories);
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.order) * 31;
        List<SVItem> list = this.items;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.id;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.title;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<SVCategory> list2 = this.categories;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "SVService(type=" + this.type + ", order=" + this.order + ", items=" + this.items + ", id=" + this.id + ", title=" + this.title + ", categories=" + this.categories + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.type);
        parcel.writeInt(this.order);
        List<SVItem> list = this.items;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (SVItem sVItem : list) {
                sVItem.writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        List<SVCategory> list2 = this.categories;
        if (list2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(list2.size());
            for (SVCategory sVCategory : list2) {
                sVCategory.writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public SVService(String str, int i, List<SVItem> list, String str2, String str3, List<SVCategory> list2) {
        Intrinsics.checkNotNullParameter(str, "type");
        this.type = str;
        this.order = i;
        this.items = list;
        this.id = str2;
        this.title = str3;
        this.categories = list2;
        List<SVCategory> list3 = null;
        this.sortedItems = list != null ? CollectionsKt.sortedWith(list, new SVService$$special$$inlined$sortedBy$1()) : null;
        this.sortedCategories = list2 != null ? CollectionsKt.sortedWith(list2, new SVService$$special$$inlined$sortedBy$2()) : list3;
    }

    public final int getOrder() {
        return this.order;
    }

    public final String getType() {
        return this.type;
    }

    public final List<SVItem> getItems() {
        return this.items;
    }

    public final List<SVCategory> getCategories() {
        return this.categories;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/digitalwallet/app/model/login/SVService$Companion;", "", "()V", "TYPE_CAROUSEL", "", "TYPE_GROUP", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: SVServices.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final List<SVItem> getSortedItems() {
        return this.sortedItems;
    }

    public final List<SVCategory> getSortedCategories() {
        return this.sortedCategories;
    }
}
