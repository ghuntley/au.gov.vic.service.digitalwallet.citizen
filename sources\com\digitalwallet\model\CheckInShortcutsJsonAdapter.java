package com.digitalwallet.model;

import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\u00110\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/digitalwallet/model/CheckInShortcutsJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/model/CheckInShortcuts;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "listOfBooleanAdapter", "", "", "listOfCheckInAdapter", "Lcom/digitalwallet/model/CheckIn;", "listOfIntAdapter", "", "listOfNullableIntAdapter", "mutableMapOfIntCheckInCodeAdapter", "", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInShortcutsJsonAdapter.kt */
public final class CheckInShortcutsJsonAdapter extends JsonAdapter<CheckInShortcuts> {
    private volatile Constructor<CheckInShortcuts> constructorRef;
    private final JsonAdapter<List<Boolean>> listOfBooleanAdapter;
    private final JsonAdapter<List<CheckIn>> listOfCheckInAdapter;
    private final JsonAdapter<List<Integer>> listOfIntAdapter;
    private final JsonAdapter<List<Integer>> listOfNullableIntAdapter;
    private final JsonAdapter<Map<Integer, CheckInUtils.CheckInCode>> mutableMapOfIntCheckInCodeAdapter;
    private final JsonReader.Options options;

    public CheckInShortcutsJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("favouriteLocationLookup", "history", "historyLocationLookup", "historyIsHiddenFlags", "locations");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"f…iddenFlags\", \"locations\")");
        this.options = of;
        JsonAdapter<List<Integer>> adapter = moshi.adapter(Types.newParameterizedType(List.class, Integer.class), SetsKt.emptySet(), "favouriteLocationLookup");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…favouriteLocationLookup\")");
        this.listOfIntAdapter = adapter;
        JsonAdapter<List<CheckIn>> adapter2 = moshi.adapter(Types.newParameterizedType(List.class, CheckIn.class), SetsKt.emptySet(), "historyCheckIns");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…\n      \"historyCheckIns\")");
        this.listOfCheckInAdapter = adapter2;
        JsonAdapter<List<Integer>> adapter3 = moshi.adapter(Types.newParameterizedType(List.class, Integer.class), SetsKt.emptySet(), "historyLocationLookup");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Types.newP… \"historyLocationLookup\")");
        this.listOfNullableIntAdapter = adapter3;
        JsonAdapter<List<Boolean>> adapter4 = moshi.adapter(Types.newParameterizedType(List.class, Boolean.class), SetsKt.emptySet(), "historyIsHiddenFlags");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Types.newP…, \"historyIsHiddenFlags\")");
        this.listOfBooleanAdapter = adapter4;
        JsonAdapter<Map<Integer, CheckInUtils.CheckInCode>> adapter5 = moshi.adapter(Types.newParameterizedType(Map.class, Integer.class, CheckInUtils.CheckInCode.class), SetsKt.emptySet(), "locations");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Types.newP… emptySet(), \"locations\")");
        this.mutableMapOfIntCheckInCodeAdapter = adapter5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(38);
        sb.append("GeneratedJsonAdapter(");
        sb.append("CheckInShortcuts");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public CheckInShortcuts fromJson(JsonReader jsonReader) {
        long j;
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        List<Integer> list = null;
        jsonReader.beginObject();
        List<Integer> list2 = list;
        List<Boolean> list3 = list2;
        Map<Integer, CheckInUtils.CheckInCode> map = null;
        int i = -1;
        List<CheckIn> list4 = list3;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName != -1) {
                if (selectName == 0) {
                    list = this.listOfIntAdapter.fromJson(jsonReader);
                    if (list != null) {
                        j = 4294967294L;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("favouriteLocationLookup", "favouriteLocationLookup", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"fav…p\",\n              reader)");
                        throw unexpectedNull;
                    }
                } else if (selectName == 1) {
                    list4 = this.listOfCheckInAdapter.fromJson(jsonReader);
                    if (list4 != null) {
                        j = 4294967293L;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("historyCheckIns", "history", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"his…kIns\", \"history\", reader)");
                        throw unexpectedNull2;
                    }
                } else if (selectName == 2) {
                    list2 = this.listOfNullableIntAdapter.fromJson(jsonReader);
                    if (list2 != null) {
                        j = 4294967291L;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("historyLocationLookup", "historyLocationLookup", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"his…yLocationLookup\", reader)");
                        throw unexpectedNull3;
                    }
                } else if (selectName == 3) {
                    list3 = this.listOfBooleanAdapter.fromJson(jsonReader);
                    if (list3 != null) {
                        j = 4294967287L;
                    } else {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("historyIsHiddenFlags", "historyIsHiddenFlags", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "Util.unexpectedNull(\"his…ryIsHiddenFlags\", reader)");
                        throw unexpectedNull4;
                    }
                } else if (selectName == 4) {
                    map = this.mutableMapOfIntCheckInCodeAdapter.fromJson(jsonReader);
                    if (map != null) {
                        j = 4294967279L;
                    } else {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("locations", "locations", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "Util.unexpectedNull(\"loc…ns\", \"locations\", reader)");
                        throw unexpectedNull5;
                    }
                } else {
                    continue;
                }
                i &= (int) j;
            } else {
                jsonReader.skipName();
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        Constructor<CheckInShortcuts> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = CheckInShortcuts.class.getDeclaredConstructor(List.class, List.class, List.class, List.class, Map.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "CheckInShortcuts::class.…his.constructorRef = it }");
        }
        CheckInShortcuts newInstance = constructor.newInstance(list, list4, list2, list3, map, Integer.valueOf(i), null);
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…mask0,\n        null\n    )");
        return newInstance;
    }

    public void toJson(JsonWriter jsonWriter, CheckInShortcuts checkInShortcuts) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (checkInShortcuts != null) {
            jsonWriter.beginObject();
            jsonWriter.name("favouriteLocationLookup");
            this.listOfIntAdapter.toJson(jsonWriter, checkInShortcuts.getFavouriteLocationLookup());
            jsonWriter.name("history");
            this.listOfCheckInAdapter.toJson(jsonWriter, checkInShortcuts.getHistoryCheckIns());
            jsonWriter.name("historyLocationLookup");
            this.listOfNullableIntAdapter.toJson(jsonWriter, checkInShortcuts.getHistoryLocationLookup());
            jsonWriter.name("historyIsHiddenFlags");
            this.listOfBooleanAdapter.toJson(jsonWriter, checkInShortcuts.getHistoryIsHiddenFlags());
            jsonWriter.name("locations");
            this.mutableMapOfIntCheckInCodeAdapter.toJson(jsonWriter, checkInShortcuts.getLocations());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
