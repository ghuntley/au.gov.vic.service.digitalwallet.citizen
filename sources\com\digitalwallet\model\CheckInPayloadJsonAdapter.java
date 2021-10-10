package com.digitalwallet.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/model/CheckInPayloadJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/model/CheckInPayload;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "checkInAdapter", "Lcom/digitalwallet/model/CheckIn;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInPayloadJsonAdapter.kt */
public final class CheckInPayloadJsonAdapter extends JsonAdapter<CheckInPayload> {
    private final JsonAdapter<CheckIn> checkInAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public CheckInPayloadJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("jws", "checkInList");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"jws\", \"checkInList\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "jws");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl… emptySet(),\n      \"jws\")");
        this.stringAdapter = adapter;
        JsonAdapter<CheckIn> adapter2 = moshi.adapter(CheckIn.class, SetsKt.emptySet(), "checkInList");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(CheckIn::c…t(),\n      \"checkInList\")");
        this.checkInAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(36);
        sb.append("GeneratedJsonAdapter(");
        sb.append("CheckInPayload");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public CheckInPayload fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        String str = null;
        CheckIn checkIn = null;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("jws", "jws", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"jws\", \"jws\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (checkIn = this.checkInAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("checkInList", "checkInList", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"che…\", \"checkInList\", reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("jws", "jws", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"jws\", \"jws\", reader)");
            throw missingProperty;
        } else if (checkIn != null) {
            return new CheckInPayload(str, checkIn);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("checkInList", "checkInList", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"ch…ist\",\n            reader)");
            throw missingProperty2;
        }
    }

    public void toJson(JsonWriter jsonWriter, CheckInPayload checkInPayload) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (checkInPayload != null) {
            jsonWriter.beginObject();
            jsonWriter.name("jws");
            this.stringAdapter.toJson(jsonWriter, checkInPayload.getJws());
            jsonWriter.name("checkInList");
            this.checkInAdapter.toJson(jsonWriter, checkInPayload.getCheckInList());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
