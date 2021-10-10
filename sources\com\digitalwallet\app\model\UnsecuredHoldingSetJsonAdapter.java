package com.digitalwallet.app.model;

import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/digitalwallet/app/model/UnsecuredHoldingSetJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/UnsecuredHoldingSet;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "intAdapter", "", "listOfUnsecuredHoldingAdapter", "", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: UnsecuredHoldingSetJsonAdapter.kt */
public final class UnsecuredHoldingSetJsonAdapter extends JsonAdapter<UnsecuredHoldingSet> {
    private volatile Constructor<UnsecuredHoldingSet> constructorRef;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<List<UnsecuredHolding>> listOfUnsecuredHoldingAdapter;
    private final JsonReader.Options options;

    public UnsecuredHoldingSetJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("totalRecords", "records");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"totalRecords\", \"records\")");
        this.options = of;
        JsonAdapter<Integer> adapter = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), "totalRecords");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Int::class…(),\n      \"totalRecords\")");
        this.intAdapter = adapter;
        JsonAdapter<List<UnsecuredHolding>> adapter2 = moshi.adapter(Types.newParameterizedType(List.class, UnsecuredHolding.class), SetsKt.emptySet(), "records");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…   emptySet(), \"records\")");
        this.listOfUnsecuredHoldingAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(41);
        sb.append("GeneratedJsonAdapter(");
        sb.append("UnsecuredHoldingSet");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public UnsecuredHoldingSet fromJson(JsonReader jsonReader) {
        long j;
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        int i = 0;
        List<UnsecuredHolding> list = null;
        jsonReader.beginObject();
        int i2 = -1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName != -1) {
                if (selectName == 0) {
                    Integer fromJson = this.intAdapter.fromJson(jsonReader);
                    if (fromJson != null) {
                        i = Integer.valueOf(fromJson.intValue());
                        j = 4294967294L;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("totalRecords", "totalRecords", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"tot…  \"totalRecords\", reader)");
                        throw unexpectedNull;
                    }
                } else if (selectName == 1) {
                    list = this.listOfUnsecuredHoldingAdapter.fromJson(jsonReader);
                    if (list != null) {
                        j = 4294967293L;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("records", "records", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"records\", \"records\", reader)");
                        throw unexpectedNull2;
                    }
                } else {
                    continue;
                }
                i2 &= (int) j;
            } else {
                jsonReader.skipName();
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        Constructor<UnsecuredHoldingSet> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = UnsecuredHoldingSet.class.getDeclaredConstructor(Integer.TYPE, List.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "UnsecuredHoldingSet::cla…his.constructorRef = it }");
        }
        UnsecuredHoldingSet newInstance = constructor.newInstance(i, list, Integer.valueOf(i2), null);
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…mask0,\n        null\n    )");
        return newInstance;
    }

    public void toJson(JsonWriter jsonWriter, UnsecuredHoldingSet unsecuredHoldingSet) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (unsecuredHoldingSet != null) {
            jsonWriter.beginObject();
            jsonWriter.name("totalRecords");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(unsecuredHoldingSet.getTotalRecords()));
            jsonWriter.name("records");
            this.listOfUnsecuredHoldingAdapter.toJson(jsonWriter, unsecuredHoldingSet.getRecords());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
