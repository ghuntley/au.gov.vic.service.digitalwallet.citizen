package com.digitalwallet.app.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006%"}, d2 = {"Lcom/digitalwallet/app/model/DynamicHoldingDisplay;", "Landroid/os/Parcelable;", "name", "", "cardTemplate", "Lcom/digitalwallet/app/model/DynamicHoldingCardTemplate;", "displayDetails", "", "Lcom/digitalwallet/app/model/DynamicHoldingDisplayDetail;", "(Ljava/lang/String;Lcom/digitalwallet/app/model/DynamicHoldingCardTemplate;Ljava/util/List;)V", "getCardTemplate", "()Lcom/digitalwallet/app/model/DynamicHoldingCardTemplate;", "getDisplayDetails", "()Ljava/util/List;", "holdingName", "getHoldingName$annotations", "()V", "getHoldingName", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public final class DynamicHoldingDisplay implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final DynamicHoldingCardTemplate cardTemplate;
    private final List<DynamicHoldingDisplayDetail> displayDetails;
    private final String holdingName;
    private final String name;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            DynamicHoldingCardTemplate dynamicHoldingCardTemplate = parcel.readInt() != 0 ? (DynamicHoldingCardTemplate) DynamicHoldingCardTemplate.CREATOR.createFromParcel(parcel) : null;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((DynamicHoldingDisplayDetail) DynamicHoldingDisplayDetail.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new DynamicHoldingDisplay(readString, dynamicHoldingCardTemplate, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new DynamicHoldingDisplay[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.digitalwallet.app.model.DynamicHoldingDisplay */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DynamicHoldingDisplay copy$default(DynamicHoldingDisplay dynamicHoldingDisplay, String str, DynamicHoldingCardTemplate dynamicHoldingCardTemplate, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dynamicHoldingDisplay.name;
        }
        if ((i & 2) != 0) {
            dynamicHoldingCardTemplate = dynamicHoldingDisplay.cardTemplate;
        }
        if ((i & 4) != 0) {
            list = dynamicHoldingDisplay.displayDetails;
        }
        return dynamicHoldingDisplay.copy(str, dynamicHoldingCardTemplate, list);
    }

    public static /* synthetic */ void getHoldingName$annotations() {
    }

    public final String component1() {
        return this.name;
    }

    public final DynamicHoldingCardTemplate component2() {
        return this.cardTemplate;
    }

    public final List<DynamicHoldingDisplayDetail> component3() {
        return this.displayDetails;
    }

    public final DynamicHoldingDisplay copy(String str, @Json(name = "card") DynamicHoldingCardTemplate dynamicHoldingCardTemplate, @Json(name = "details") List<DynamicHoldingDisplayDetail> list) {
        Intrinsics.checkNotNullParameter(list, "displayDetails");
        return new DynamicHoldingDisplay(str, dynamicHoldingCardTemplate, list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DynamicHoldingDisplay)) {
            return false;
        }
        DynamicHoldingDisplay dynamicHoldingDisplay = (DynamicHoldingDisplay) obj;
        return Intrinsics.areEqual(this.name, dynamicHoldingDisplay.name) && Intrinsics.areEqual(this.cardTemplate, dynamicHoldingDisplay.cardTemplate) && Intrinsics.areEqual(this.displayDetails, dynamicHoldingDisplay.displayDetails);
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        DynamicHoldingCardTemplate dynamicHoldingCardTemplate = this.cardTemplate;
        int hashCode2 = (hashCode + (dynamicHoldingCardTemplate != null ? dynamicHoldingCardTemplate.hashCode() : 0)) * 31;
        List<DynamicHoldingDisplayDetail> list = this.displayDetails;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "DynamicHoldingDisplay(name=" + this.name + ", cardTemplate=" + this.cardTemplate + ", displayDetails=" + this.displayDetails + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        DynamicHoldingCardTemplate dynamicHoldingCardTemplate = this.cardTemplate;
        if (dynamicHoldingCardTemplate != null) {
            parcel.writeInt(1);
            dynamicHoldingCardTemplate.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        List<DynamicHoldingDisplayDetail> list = this.displayDetails;
        parcel.writeInt(list.size());
        for (DynamicHoldingDisplayDetail dynamicHoldingDisplayDetail : list) {
            dynamicHoldingDisplayDetail.writeToParcel(parcel, 0);
        }
    }

    public DynamicHoldingDisplay(String str, @Json(name = "card") DynamicHoldingCardTemplate dynamicHoldingCardTemplate, @Json(name = "details") List<DynamicHoldingDisplayDetail> list) {
        Intrinsics.checkNotNullParameter(list, "displayDetails");
        this.name = str;
        this.cardTemplate = dynamicHoldingCardTemplate;
        this.displayDetails = list;
        this.holdingName = str == null ? dynamicHoldingCardTemplate != null ? dynamicHoldingCardTemplate.getTitle() : null : str;
    }

    public final String getName() {
        return this.name;
    }

    public final DynamicHoldingCardTemplate getCardTemplate() {
        return this.cardTemplate;
    }

    public final List<DynamicHoldingDisplayDetail> getDisplayDetails() {
        return this.displayDetails;
    }

    public final String getHoldingName() {
        return this.holdingName;
    }
}
