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
import org.bouncycastle.i18n.ErrorBundle;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/digitalwallet/app/model/DynamicHoldingDisplayJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/DynamicHoldingDisplay;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "listOfDynamicHoldingDisplayDetailAdapter", "", "Lcom/digitalwallet/app/model/DynamicHoldingDisplayDetail;", "nullableDynamicHoldingCardTemplateAdapter", "Lcom/digitalwallet/app/model/DynamicHoldingCardTemplate;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: DynamicHoldingDisplayJsonAdapter.kt */
public final class DynamicHoldingDisplayJsonAdapter extends JsonAdapter<DynamicHoldingDisplay> {
    private final JsonAdapter<List<DynamicHoldingDisplayDetail>> listOfDynamicHoldingDisplayDetailAdapter;
    private final JsonAdapter<DynamicHoldingCardTemplate> nullableDynamicHoldingCardTemplateAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;

    public DynamicHoldingDisplayJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("name", "card", ErrorBundle.DETAIL_ENTRY);
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"name\", \"card\", \"details\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "name");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…      emptySet(), \"name\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<DynamicHoldingCardTemplate> adapter2 = moshi.adapter(DynamicHoldingCardTemplate.class, SetsKt.emptySet(), "cardTemplate");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(DynamicHol…ptySet(), \"cardTemplate\")");
        this.nullableDynamicHoldingCardTemplateAdapter = adapter2;
        JsonAdapter<List<DynamicHoldingDisplayDetail>> adapter3 = moshi.adapter(Types.newParameterizedType(List.class, DynamicHoldingDisplayDetail.class), SetsKt.emptySet(), "displayDetails");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Types.newP…ySet(), \"displayDetails\")");
        this.listOfDynamicHoldingDisplayDetailAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(43);
        sb.append("GeneratedJsonAdapter(");
        sb.append("DynamicHoldingDisplay");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public DynamicHoldingDisplay fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        String str = null;
        DynamicHoldingCardTemplate dynamicHoldingCardTemplate = null;
        List<DynamicHoldingDisplayDetail> list = null;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.nullableStringAdapter.fromJson(jsonReader);
            } else if (selectName == 1) {
                dynamicHoldingCardTemplate = this.nullableDynamicHoldingCardTemplateAdapter.fromJson(jsonReader);
            } else if (selectName == 2 && (list = this.listOfDynamicHoldingDisplayDetailAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("displayDetails", ErrorBundle.DETAIL_ENTRY, jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"dis…ails\", \"details\", reader)");
                throw unexpectedNull;
            }
        }
        jsonReader.endObject();
        if (list != null) {
            return new DynamicHoldingDisplay(str, dynamicHoldingCardTemplate, list);
        }
        JsonDataException missingProperty = Util.missingProperty("displayDetails", ErrorBundle.DETAIL_ENTRY, jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"di…ils\",\n            reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, DynamicHoldingDisplay dynamicHoldingDisplay) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (dynamicHoldingDisplay != null) {
            jsonWriter.beginObject();
            jsonWriter.name("name");
            this.nullableStringAdapter.toJson(jsonWriter, dynamicHoldingDisplay.getName());
            jsonWriter.name("card");
            this.nullableDynamicHoldingCardTemplateAdapter.toJson(jsonWriter, dynamicHoldingDisplay.getCardTemplate());
            jsonWriter.name(ErrorBundle.DETAIL_ENTRY);
            this.listOfDynamicHoldingDisplayDetailAdapter.toJson(jsonWriter, dynamicHoldingDisplay.getDisplayDetails());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
