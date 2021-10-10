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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/digitalwallet/app/model/DynamicHoldingCardTemplateJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/DynamicHoldingCardTemplate;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "dynamicHoldingTemplateTypeAdapter", "Lcom/digitalwallet/app/model/DynamicHoldingTemplateType;", "dynamicHoldingTextStyleAdapter", "Lcom/digitalwallet/app/model/DynamicHoldingTextStyle;", "listOfDynamicHoldingFieldAdapter", "", "Lcom/digitalwallet/app/model/DynamicHoldingField;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: DynamicHoldingCardTemplateJsonAdapter.kt */
public final class DynamicHoldingCardTemplateJsonAdapter extends JsonAdapter<DynamicHoldingCardTemplate> {
    private final JsonAdapter<DynamicHoldingTemplateType> dynamicHoldingTemplateTypeAdapter;
    private final JsonAdapter<DynamicHoldingTextStyle> dynamicHoldingTextStyleAdapter;
    private final JsonAdapter<List<DynamicHoldingField>> listOfDynamicHoldingFieldAdapter;
    private final JsonReader.Options options;

    public DynamicHoldingCardTemplateJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("template", "textStyle", "fields");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"t…\", \"textStyle\", \"fields\")");
        this.options = of;
        JsonAdapter<DynamicHoldingTemplateType> adapter = moshi.adapter(DynamicHoldingTemplateType.class, SetsKt.emptySet(), "templateType");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(DynamicHol…ptySet(), \"templateType\")");
        this.dynamicHoldingTemplateTypeAdapter = adapter;
        JsonAdapter<DynamicHoldingTextStyle> adapter2 = moshi.adapter(DynamicHoldingTextStyle.class, SetsKt.emptySet(), "textStyle");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(DynamicHol… emptySet(), \"textStyle\")");
        this.dynamicHoldingTextStyleAdapter = adapter2;
        JsonAdapter<List<DynamicHoldingField>> adapter3 = moshi.adapter(Types.newParameterizedType(List.class, DynamicHoldingField.class), SetsKt.emptySet(), "fields");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Types.newP…    emptySet(), \"fields\")");
        this.listOfDynamicHoldingFieldAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(48);
        sb.append("GeneratedJsonAdapter(");
        sb.append("DynamicHoldingCardTemplate");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public DynamicHoldingCardTemplate fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        DynamicHoldingTemplateType dynamicHoldingTemplateType = null;
        DynamicHoldingTextStyle dynamicHoldingTextStyle = null;
        List<DynamicHoldingField> list = null;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                dynamicHoldingTemplateType = this.dynamicHoldingTemplateTypeAdapter.fromJson(jsonReader);
                if (dynamicHoldingTemplateType == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("templateType", "template", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"tem…ype\", \"template\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                dynamicHoldingTextStyle = this.dynamicHoldingTextStyleAdapter.fromJson(jsonReader);
                if (dynamicHoldingTextStyle == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("textStyle", "textStyle", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"tex…le\", \"textStyle\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (list = this.listOfDynamicHoldingFieldAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("fields", "fields", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"fields\", \"fields\", reader)");
                throw unexpectedNull3;
            }
        }
        jsonReader.endObject();
        if (dynamicHoldingTemplateType == null) {
            JsonDataException missingProperty = Util.missingProperty("templateType", "template", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"te…ate\",\n            reader)");
            throw missingProperty;
        } else if (dynamicHoldingTextStyle == null) {
            JsonDataException missingProperty2 = Util.missingProperty("textStyle", "textStyle", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"te…le\", \"textStyle\", reader)");
            throw missingProperty2;
        } else if (list != null) {
            return new DynamicHoldingCardTemplate(dynamicHoldingTemplateType, dynamicHoldingTextStyle, list);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("fields", "fields", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"fields\", \"fields\", reader)");
            throw missingProperty3;
        }
    }

    public void toJson(JsonWriter jsonWriter, DynamicHoldingCardTemplate dynamicHoldingCardTemplate) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (dynamicHoldingCardTemplate != null) {
            jsonWriter.beginObject();
            jsonWriter.name("template");
            this.dynamicHoldingTemplateTypeAdapter.toJson(jsonWriter, dynamicHoldingCardTemplate.getTemplateType());
            jsonWriter.name("textStyle");
            this.dynamicHoldingTextStyleAdapter.toJson(jsonWriter, dynamicHoldingCardTemplate.getTextStyle());
            jsonWriter.name("fields");
            this.listOfDynamicHoldingFieldAdapter.toJson(jsonWriter, dynamicHoldingCardTemplate.getFields());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
