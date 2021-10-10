package com.digitalwallet.app.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/digitalwallet/app/model/AttributeDetailItem;", "Landroid/os/Parcelable;", "fieldNameId", "", "fieldValue", "", "(ILjava/lang/String;)V", "overrideFieldName", "(Ljava/lang/String;Ljava/lang/String;)V", "(ILjava/lang/String;Ljava/lang/String;)V", "getFieldValue", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "fieldName", "context", "Landroid/content/Context;", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AttributeDetailItem.kt */
public final class AttributeDetailItem implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    public static final String NOT_AVAILABLE = "n/a";
    private final int fieldNameId;
    private final String fieldValue;
    private final String overrideFieldName;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AttributeDetailItem(parcel.readInt(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new AttributeDetailItem[i];
        }
    }

    private final int component1() {
        return this.fieldNameId;
    }

    private final String component2() {
        return this.overrideFieldName;
    }

    public static /* synthetic */ AttributeDetailItem copy$default(AttributeDetailItem attributeDetailItem, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = attributeDetailItem.fieldNameId;
        }
        if ((i2 & 2) != 0) {
            str = attributeDetailItem.overrideFieldName;
        }
        if ((i2 & 4) != 0) {
            str2 = attributeDetailItem.fieldValue;
        }
        return attributeDetailItem.copy(i, str, str2);
    }

    public final String component3() {
        return this.fieldValue;
    }

    public final AttributeDetailItem copy(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "fieldValue");
        return new AttributeDetailItem(i, str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AttributeDetailItem)) {
            return false;
        }
        AttributeDetailItem attributeDetailItem = (AttributeDetailItem) obj;
        return this.fieldNameId == attributeDetailItem.fieldNameId && Intrinsics.areEqual(this.overrideFieldName, attributeDetailItem.overrideFieldName) && Intrinsics.areEqual(this.fieldValue, attributeDetailItem.fieldValue);
    }

    public int hashCode() {
        int i = this.fieldNameId * 31;
        String str = this.overrideFieldName;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.fieldValue;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "AttributeDetailItem(fieldNameId=" + this.fieldNameId + ", overrideFieldName=" + this.overrideFieldName + ", fieldValue=" + this.fieldValue + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.fieldNameId);
        parcel.writeString(this.overrideFieldName);
        parcel.writeString(this.fieldValue);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/digitalwallet/app/model/AttributeDetailItem$Companion;", "", "()V", "NOT_AVAILABLE", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: AttributeDetailItem.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AttributeDetailItem(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "fieldValue");
        this.fieldNameId = i;
        this.overrideFieldName = str;
        this.fieldValue = str2;
    }

    public final String getFieldValue() {
        return this.fieldValue;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AttributeDetailItem(int i, String str) {
        this(i, null, str);
        Intrinsics.checkNotNullParameter(str, "fieldValue");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AttributeDetailItem(String str, String str2) {
        this(0, str, str2);
        Intrinsics.checkNotNullParameter(str, "overrideFieldName");
        Intrinsics.checkNotNullParameter(str2, "fieldValue");
    }

    public final String fieldName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = this.overrideFieldName;
        if (str != null) {
            return str;
        }
        String string = context.getString(this.fieldNameId);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(fieldNameId)");
        return string;
    }
}
