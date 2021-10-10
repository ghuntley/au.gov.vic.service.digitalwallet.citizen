package com.digitalwallet.app.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/digitalwallet/app/model/DynamicHoldingField;", "Landroid/os/Parcelable;", "id", "Lcom/digitalwallet/app/model/DynamicHoldingFieldID;", "value", "", "(Lcom/digitalwallet/app/model/DynamicHoldingFieldID;Ljava/lang/String;)V", "getId", "()Lcom/digitalwallet/app/model/DynamicHoldingFieldID;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Holding.kt */
public final class DynamicHoldingField implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final DynamicHoldingFieldID id;
    private final String value;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DynamicHoldingField((DynamicHoldingFieldID) Enum.valueOf(DynamicHoldingFieldID.class, parcel.readString()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new DynamicHoldingField[i];
        }
    }

    public static /* synthetic */ DynamicHoldingField copy$default(DynamicHoldingField dynamicHoldingField, DynamicHoldingFieldID dynamicHoldingFieldID, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            dynamicHoldingFieldID = dynamicHoldingField.id;
        }
        if ((i & 2) != 0) {
            str = dynamicHoldingField.value;
        }
        return dynamicHoldingField.copy(dynamicHoldingFieldID, str);
    }

    public final DynamicHoldingFieldID component1() {
        return this.id;
    }

    public final String component2() {
        return this.value;
    }

    public final DynamicHoldingField copy(DynamicHoldingFieldID dynamicHoldingFieldID, String str) {
        Intrinsics.checkNotNullParameter(dynamicHoldingFieldID, "id");
        Intrinsics.checkNotNullParameter(str, "value");
        return new DynamicHoldingField(dynamicHoldingFieldID, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DynamicHoldingField)) {
            return false;
        }
        DynamicHoldingField dynamicHoldingField = (DynamicHoldingField) obj;
        return Intrinsics.areEqual(this.id, dynamicHoldingField.id) && Intrinsics.areEqual(this.value, dynamicHoldingField.value);
    }

    public int hashCode() {
        DynamicHoldingFieldID dynamicHoldingFieldID = this.id;
        int i = 0;
        int hashCode = (dynamicHoldingFieldID != null ? dynamicHoldingFieldID.hashCode() : 0) * 31;
        String str = this.value;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "DynamicHoldingField(id=" + this.id + ", value=" + this.value + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id.name());
        parcel.writeString(this.value);
    }

    public DynamicHoldingField(DynamicHoldingFieldID dynamicHoldingFieldID, String str) {
        Intrinsics.checkNotNullParameter(dynamicHoldingFieldID, "id");
        Intrinsics.checkNotNullParameter(str, "value");
        this.id = dynamicHoldingFieldID;
        this.value = str;
    }

    public final DynamicHoldingFieldID getId() {
        return this.id;
    }

    public final String getValue() {
        return this.value;
    }
}
