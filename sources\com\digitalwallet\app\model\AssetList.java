package com.digitalwallet.app.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\rH\u0016R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/digitalwallet/app/model/AssetList;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "list", "", "Lcom/digitalwallet/app/model/Asset;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "setList", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: Asset.kt */
public final class AssetList implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    private List<Asset> list;

    public int describeContents() {
        return 0;
    }

    public final List<Asset> getList() {
        return this.list;
    }

    public final void setList(List<Asset> list2) {
        Intrinsics.checkNotNullParameter(list2, "<set-?>");
        this.list = list2;
    }

    public AssetList(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        ArrayList arrayList = new ArrayList();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            Parcelable readParcelable = parcel.readParcelable(Asset.class.getClassLoader());
            Intrinsics.checkNotNull(readParcelable);
            Intrinsics.checkNotNullExpressionValue(readParcelable, "parcel.readParcelable<As…class.java.classLoader)!!");
            arrayList.add((Asset) readParcelable);
        }
        this.list = arrayList;
    }

    public AssetList(List<Asset> list2) {
        Intrinsics.checkNotNullParameter(list2, "list");
        this.list = list2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.list.size());
        Iterator<T> it = this.list.iterator();
        while (it.hasNext()) {
            parcel.writeParcelable(it.next(), 0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/digitalwallet/app/model/AssetList$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/digitalwallet/app/model/AssetList;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/digitalwallet/app/model/AssetList;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Asset.kt */
    public static final class CREATOR implements Parcelable.Creator<AssetList> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public AssetList createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AssetList(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AssetList[] newArray(int i) {
            return new AssetList[i];
        }
    }
}
