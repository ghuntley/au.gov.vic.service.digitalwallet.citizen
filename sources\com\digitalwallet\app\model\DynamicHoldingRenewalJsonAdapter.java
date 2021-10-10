package com.digitalwallet.app.model;

import com.google.android.gms.common.internal.ImagesContract;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/model/DynamicHoldingRenewalJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/DynamicHoldingRenewal;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: DynamicHoldingRenewalJsonAdapter.kt */
public final class DynamicHoldingRenewalJsonAdapter extends JsonAdapter<DynamicHoldingRenewal> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public DynamicHoldingRenewalJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("period", ImagesContract.URL);
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"period\", \"url\")");
        this.options = of;
        JsonAdapter<Integer> adapter = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), "period");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Int::class…va, emptySet(), \"period\")");
        this.intAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), ImagesContract.URL);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl… emptySet(),\n      \"url\")");
        this.stringAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(43);
        sb.append("GeneratedJsonAdapter(");
        sb.append("DynamicHoldingRenewal");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public DynamicHoldingRenewal fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        Integer num = null;
        String str = null;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                Integer fromJson = this.intAdapter.fromJson(jsonReader);
                if (fromJson != null) {
                    num = Integer.valueOf(fromJson.intValue());
                } else {
                    JsonDataException unexpectedNull = Util.unexpectedNull("period", "period", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"per…iod\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (str = this.stringAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull(ImagesContract.URL, ImagesContract.URL, jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"url\", \"url\", reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (num != null) {
            int intValue = num.intValue();
            if (str != null) {
                return new DynamicHoldingRenewal(intValue, str);
            }
            JsonDataException missingProperty = Util.missingProperty(ImagesContract.URL, ImagesContract.URL, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"url\", \"url\", reader)");
            throw missingProperty;
        }
        JsonDataException missingProperty2 = Util.missingProperty("period", "period", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"period\", \"period\", reader)");
        throw missingProperty2;
    }

    public void toJson(JsonWriter jsonWriter, DynamicHoldingRenewal dynamicHoldingRenewal) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (dynamicHoldingRenewal != null) {
            jsonWriter.beginObject();
            jsonWriter.name("period");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(dynamicHoldingRenewal.getPeriod()));
            jsonWriter.name(ImagesContract.URL);
            this.stringAdapter.toJson(jsonWriter, dynamicHoldingRenewal.getUrl());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
