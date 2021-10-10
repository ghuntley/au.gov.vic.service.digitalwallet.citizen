package com.digitalwallet.app.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/model/HoldingRequestSetJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/HoldingRequestSet;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "listOfHoldingRequestRecordAdapter", "", "Lcom/digitalwallet/app/model/HoldingRequestRecord;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HoldingRequestSetJsonAdapter.kt */
public final class HoldingRequestSetJsonAdapter extends JsonAdapter<HoldingRequestSet> {
    private final JsonAdapter<List<HoldingRequestRecord>> listOfHoldingRequestRecordAdapter;
    private final JsonReader.Options options;

    public HoldingRequestSetJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("records");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"records\")");
        this.options = of;
        JsonAdapter<List<HoldingRequestRecord>> adapter = moshi.adapter(Types.newParameterizedType(List.class, HoldingRequestRecord.class), SetsKt.emptySet(), "records");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…   emptySet(), \"records\")");
        this.listOfHoldingRequestRecordAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(39);
        sb.append("GeneratedJsonAdapter(");
        sb.append("HoldingRequestSet");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public HoldingRequestSet fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        List<HoldingRequestRecord> list = null;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0 && (list = this.listOfHoldingRequestRecordAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("records", "records", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"records\", \"records\", reader)");
                throw unexpectedNull;
            }
        }
        jsonReader.endObject();
        if (list != null) {
            return new HoldingRequestSet(list);
        }
        JsonDataException missingProperty = Util.missingProperty("records", "records", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"records\", \"records\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, HoldingRequestSet holdingRequestSet) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (holdingRequestSet != null) {
            jsonWriter.beginObject();
            jsonWriter.name("records");
            this.listOfHoldingRequestRecordAdapter.toJson(jsonWriter, holdingRequestSet.getRecords());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
