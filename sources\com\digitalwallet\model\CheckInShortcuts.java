package com.digitalwallet.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B]\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0003J\u0015\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003Ja\u0010!\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u0003J\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0003J\t\u0010)\u001a\u00020\u0004HÖ\u0001J\u0014\u0010*\u001a\u00020\u001b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0\u0003J\u0014\u0010,\u001a\u00020\u001b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020(0\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\u0019\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u00063"}, d2 = {"Lcom/digitalwallet/model/CheckInShortcuts;", "Landroid/os/Parcelable;", "favouriteLocationLookup", "", "", "historyCheckIns", "Lcom/digitalwallet/model/CheckIn;", "historyLocationLookup", "historyIsHiddenFlags", "", "locations", "", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "getFavouriteLocationLookup", "()Ljava/util/List;", "setFavouriteLocationLookup", "(Ljava/util/List;)V", "getHistoryCheckIns", "setHistoryCheckIns", "getHistoryIsHiddenFlags", "setHistoryIsHiddenFlags", "getHistoryLocationLookup", "setHistoryLocationLookup", "getLocations", "()Ljava/util/Map;", "cleanupUnusedLocations", "", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "getFavourites", "getHistoryItems", "Lcom/digitalwallet/model/CheckInHistoryCombo;", "hashCode", "setFavourites", "value", "setHistoryItems", "toString", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckIn.kt */
public final class CheckInShortcuts implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private List<Integer> favouriteLocationLookup;
    private List<CheckIn> historyCheckIns;
    private List<Boolean> historyIsHiddenFlags;
    private List<Integer> historyLocationLookup;
    private final Map<Integer, CheckInUtils.CheckInCode> locations;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(Integer.valueOf(parcel.readInt()));
                readInt--;
            }
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList2.add((CheckIn) CheckIn.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            int readInt3 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(readInt3);
            while (readInt3 != 0) {
                arrayList3.add(parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
                readInt3--;
            }
            int readInt4 = parcel.readInt();
            ArrayList arrayList4 = new ArrayList(readInt4);
            while (readInt4 != 0) {
                arrayList4.add(Boolean.valueOf(parcel.readInt() != 0));
                readInt4--;
            }
            int readInt5 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt5);
            while (readInt5 != 0) {
                linkedHashMap.put(Integer.valueOf(parcel.readInt()), (CheckInUtils.CheckInCode) CheckInUtils.CheckInCode.CREATOR.createFromParcel(parcel));
                readInt5--;
            }
            return new CheckInShortcuts(arrayList, arrayList2, arrayList3, arrayList4, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new CheckInShortcuts[i];
        }
    }

    public CheckInShortcuts() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.digitalwallet.model.CheckInShortcuts */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CheckInShortcuts copy$default(CheckInShortcuts checkInShortcuts, List list, List list2, List list3, List list4, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            list = checkInShortcuts.favouriteLocationLookup;
        }
        if ((i & 2) != 0) {
            list2 = checkInShortcuts.historyCheckIns;
        }
        if ((i & 4) != 0) {
            list3 = checkInShortcuts.historyLocationLookup;
        }
        if ((i & 8) != 0) {
            list4 = checkInShortcuts.historyIsHiddenFlags;
        }
        if ((i & 16) != 0) {
            map = checkInShortcuts.locations;
        }
        return checkInShortcuts.copy(list, list2, list3, list4, map);
    }

    public final List<Integer> component1() {
        return this.favouriteLocationLookup;
    }

    public final List<CheckIn> component2() {
        return this.historyCheckIns;
    }

    public final List<Integer> component3() {
        return this.historyLocationLookup;
    }

    public final List<Boolean> component4() {
        return this.historyIsHiddenFlags;
    }

    public final Map<Integer, CheckInUtils.CheckInCode> component5() {
        return this.locations;
    }

    public final CheckInShortcuts copy(List<Integer> list, @Json(name = "history") List<CheckIn> list2, List<Integer> list3, List<Boolean> list4, Map<Integer, CheckInUtils.CheckInCode> map) {
        Intrinsics.checkNotNullParameter(list, "favouriteLocationLookup");
        Intrinsics.checkNotNullParameter(list2, "historyCheckIns");
        Intrinsics.checkNotNullParameter(list3, "historyLocationLookup");
        Intrinsics.checkNotNullParameter(list4, "historyIsHiddenFlags");
        Intrinsics.checkNotNullParameter(map, "locations");
        return new CheckInShortcuts(list, list2, list3, list4, map);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckInShortcuts)) {
            return false;
        }
        CheckInShortcuts checkInShortcuts = (CheckInShortcuts) obj;
        return Intrinsics.areEqual(this.favouriteLocationLookup, checkInShortcuts.favouriteLocationLookup) && Intrinsics.areEqual(this.historyCheckIns, checkInShortcuts.historyCheckIns) && Intrinsics.areEqual(this.historyLocationLookup, checkInShortcuts.historyLocationLookup) && Intrinsics.areEqual(this.historyIsHiddenFlags, checkInShortcuts.historyIsHiddenFlags) && Intrinsics.areEqual(this.locations, checkInShortcuts.locations);
    }

    public int hashCode() {
        List<Integer> list = this.favouriteLocationLookup;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<CheckIn> list2 = this.historyCheckIns;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Integer> list3 = this.historyLocationLookup;
        int hashCode3 = (hashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<Boolean> list4 = this.historyIsHiddenFlags;
        int hashCode4 = (hashCode3 + (list4 != null ? list4.hashCode() : 0)) * 31;
        Map<Integer, CheckInUtils.CheckInCode> map = this.locations;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "CheckInShortcuts(favouriteLocationLookup=" + this.favouriteLocationLookup + ", historyCheckIns=" + this.historyCheckIns + ", historyLocationLookup=" + this.historyLocationLookup + ", historyIsHiddenFlags=" + this.historyIsHiddenFlags + ", locations=" + this.locations + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        List<Integer> list = this.favouriteLocationLookup;
        parcel.writeInt(list.size());
        for (Integer num : list) {
            parcel.writeInt(num.intValue());
        }
        List<CheckIn> list2 = this.historyCheckIns;
        parcel.writeInt(list2.size());
        for (CheckIn checkIn : list2) {
            checkIn.writeToParcel(parcel, 0);
        }
        List<Integer> list3 = this.historyLocationLookup;
        parcel.writeInt(list3.size());
        for (Integer num2 : list3) {
            if (num2 != null) {
                parcel.writeInt(1);
                parcel.writeInt(num2.intValue());
            } else {
                parcel.writeInt(0);
            }
        }
        List<Boolean> list4 = this.historyIsHiddenFlags;
        parcel.writeInt(list4.size());
        for (Boolean bool : list4) {
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Map<Integer, CheckInUtils.CheckInCode> map = this.locations;
        parcel.writeInt(map.size());
        for (Map.Entry<Integer, CheckInUtils.CheckInCode> entry : map.entrySet()) {
            parcel.writeInt(entry.getKey().intValue());
            entry.getValue().writeToParcel(parcel, 0);
        }
    }

    public CheckInShortcuts(List<Integer> list, @Json(name = "history") List<CheckIn> list2, List<Integer> list3, List<Boolean> list4, Map<Integer, CheckInUtils.CheckInCode> map) {
        Intrinsics.checkNotNullParameter(list, "favouriteLocationLookup");
        Intrinsics.checkNotNullParameter(list2, "historyCheckIns");
        Intrinsics.checkNotNullParameter(list3, "historyLocationLookup");
        Intrinsics.checkNotNullParameter(list4, "historyIsHiddenFlags");
        Intrinsics.checkNotNullParameter(map, "locations");
        this.favouriteLocationLookup = list;
        this.historyCheckIns = list2;
        this.historyLocationLookup = list3;
        this.historyIsHiddenFlags = list4;
        this.locations = map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CheckInShortcuts(List list, List list2, List list3, List list4, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt.emptyList() : list3, (i & 8) != 0 ? CollectionsKt.emptyList() : list4, (i & 16) != 0 ? new LinkedHashMap() : map);
    }

    public final List<Integer> getFavouriteLocationLookup() {
        return this.favouriteLocationLookup;
    }

    public final void setFavouriteLocationLookup(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.favouriteLocationLookup = list;
    }

    public final List<CheckIn> getHistoryCheckIns() {
        return this.historyCheckIns;
    }

    public final void setHistoryCheckIns(List<CheckIn> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.historyCheckIns = list;
    }

    public final List<Integer> getHistoryLocationLookup() {
        return this.historyLocationLookup;
    }

    public final void setHistoryLocationLookup(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.historyLocationLookup = list;
    }

    public final List<Boolean> getHistoryIsHiddenFlags() {
        return this.historyIsHiddenFlags;
    }

    public final void setHistoryIsHiddenFlags(List<Boolean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.historyIsHiddenFlags = list;
    }

    public final Map<Integer, CheckInUtils.CheckInCode> getLocations() {
        return this.locations;
    }

    public final List<CheckInUtils.CheckInCode> getFavourites() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.favouriteLocationLookup.iterator();
        while (it.hasNext()) {
            CheckInUtils.CheckInCode checkInCode = this.locations.get(Integer.valueOf(it.next().intValue()));
            if (checkInCode != null) {
                arrayList.add(checkInCode);
            }
        }
        return arrayList;
    }

    public final void setFavourites(List<CheckInUtils.CheckInCode> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        List<CheckInUtils.CheckInCode> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (T t : list2) {
            int hashCode = t.hashCode();
            this.locations.put(Integer.valueOf(hashCode), t);
            arrayList.add(Integer.valueOf(hashCode));
        }
        this.favouriteLocationLookup = arrayList;
    }

    public final List<CheckInHistoryCombo> getHistoryItems() {
        Integer num;
        ArrayList arrayList = new ArrayList();
        int size = this.historyCheckIns.size();
        for (int i = 0; i < size; i++) {
            CheckInUtils.CheckInCode checkInCode = null;
            if (CollectionsKt.getIndices(this.historyLocationLookup).contains(i) && (num = this.historyLocationLookup.get(i)) != null) {
                checkInCode = this.locations.get(Integer.valueOf(num.intValue()));
            }
            arrayList.add(new CheckInHistoryCombo(this.historyCheckIns.get(i), checkInCode, CollectionsKt.getIndices(this.historyIsHiddenFlags).contains(i) ? this.historyIsHiddenFlags.get(i).booleanValue() : false));
        }
        return arrayList;
    }

    public final void setHistoryItems(List<CheckInHistoryCombo> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        List<CheckInHistoryCombo> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getCheckInItem());
        }
        this.historyCheckIns = arrayList;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            CheckInUtils.CheckInCode component2 = it2.next().component2();
            Integer valueOf = component2 != null ? Integer.valueOf(component2.hashCode()) : null;
            if (valueOf != null) {
                this.locations.put(Integer.valueOf(valueOf.intValue()), component2);
            }
            arrayList2.add(valueOf);
        }
        this.historyLocationLookup = arrayList2;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it3 = list2.iterator();
        while (it3.hasNext()) {
            arrayList3.add(Boolean.valueOf(it3.next().isHidden()));
        }
        this.historyIsHiddenFlags = arrayList3;
    }

    public final void cleanupUnusedLocations() {
        ArrayList<Number> arrayList = new ArrayList();
        for (T t : this.locations.keySet()) {
            int intValue = t.intValue();
            if (!(this.favouriteLocationLookup.contains(Integer.valueOf(intValue)) || this.historyLocationLookup.contains(Integer.valueOf(intValue)))) {
                arrayList.add(t);
            }
        }
        Map<Integer, CheckInUtils.CheckInCode> map = this.locations;
        for (Number number : arrayList) {
            map.remove(Integer.valueOf(number.intValue()));
        }
    }
}
