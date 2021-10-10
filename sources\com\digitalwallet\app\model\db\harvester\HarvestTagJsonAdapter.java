package com.digitalwallet.app.model.db.harvester;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/digitalwallet/app/model/db/harvester/HarvestTagJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/db/harvester/HarvestTag;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "longAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestTagJsonAdapter.kt */
public final class HarvestTagJsonAdapter extends JsonAdapter<HarvestTag> {
    private final JsonAdapter<Long> longAdapter;
    private final JsonReader.Options options;

    public HarvestTagJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("tagNumber");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"tagNumber\")");
        this.options = of;
        JsonAdapter<Long> adapter = moshi.adapter(Long.TYPE, SetsKt.emptySet(), "tagNumber");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Long::clas…Set(),\n      \"tagNumber\")");
        this.longAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("GeneratedJsonAdapter(");
        sb.append("HarvestTag");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public HarvestTag fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        Long l = null;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                Long fromJson = this.longAdapter.fromJson(jsonReader);
                if (fromJson != null) {
                    l = Long.valueOf(fromJson.longValue());
                } else {
                    JsonDataException unexpectedNull = Util.unexpectedNull("tagNumber", "tagNumber", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"tag…     \"tagNumber\", reader)");
                    throw unexpectedNull;
                }
            } else {
                continue;
            }
        }
        jsonReader.endObject();
        if (l != null) {
            return new HarvestTag(l.longValue());
        }
        JsonDataException missingProperty = Util.missingProperty("tagNumber", "tagNumber", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"ta…er\", \"tagNumber\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, HarvestTag harvestTag) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (harvestTag != null) {
            jsonWriter.beginObject();
            jsonWriter.name("tagNumber");
            this.longAdapter.toJson(jsonWriter, Long.valueOf(harvestTag.getTagNumber()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
