package com.digitalwallet.app.model.login;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/digitalwallet/app/model/login/DevicePrintTimezoneJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/login/DevicePrintTimezone;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: DevicePrintTimezoneJsonAdapter.kt */
public final class DevicePrintTimezoneJsonAdapter extends JsonAdapter<DevicePrintTimezone> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;

    public DevicePrintTimezoneJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("timezone");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"timezone\")");
        this.options = of;
        JsonAdapter<Integer> adapter = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), "timezone");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Int::class…, emptySet(), \"timezone\")");
        this.intAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(41);
        sb.append("GeneratedJsonAdapter(");
        sb.append("DevicePrintTimezone");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public DevicePrintTimezone fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        Integer num = null;
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
                    JsonDataException unexpectedNull = Util.unexpectedNull("timezone", "timezone", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"tim…      \"timezone\", reader)");
                    throw unexpectedNull;
                }
            } else {
                continue;
            }
        }
        jsonReader.endObject();
        if (num != null) {
            return new DevicePrintTimezone(num.intValue());
        }
        JsonDataException missingProperty = Util.missingProperty("timezone", "timezone", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"ti…one\", \"timezone\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, DevicePrintTimezone devicePrintTimezone) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (devicePrintTimezone != null) {
            jsonWriter.beginObject();
            jsonWriter.name("timezone");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(devicePrintTimezone.getTimezone()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
