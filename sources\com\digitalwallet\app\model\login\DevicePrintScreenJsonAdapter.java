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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/digitalwallet/app/model/login/DevicePrintScreenJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/login/DevicePrintScreen;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: DevicePrintScreenJsonAdapter.kt */
public final class DevicePrintScreenJsonAdapter extends JsonAdapter<DevicePrintScreen> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;

    public DevicePrintScreenJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("screenWidth", "screenHeight", "screenColourDepth");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"s…     \"screenColourDepth\")");
        this.options = of;
        JsonAdapter<Integer> adapter = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), "screenWidth");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Int::class…t(),\n      \"screenWidth\")");
        this.intAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(39);
        sb.append("GeneratedJsonAdapter(");
        sb.append("DevicePrintScreen");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public DevicePrintScreen fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        Integer num = null;
        jsonReader.beginObject();
        Integer num2 = num;
        Integer num3 = num2;
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
                    JsonDataException unexpectedNull = Util.unexpectedNull("screenWidth", "screenWidth", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"scr…   \"screenWidth\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                Integer fromJson2 = this.intAdapter.fromJson(jsonReader);
                if (fromJson2 != null) {
                    num2 = Integer.valueOf(fromJson2.intValue());
                } else {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("screenHeight", "screenHeight", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"scr…  \"screenHeight\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                Integer fromJson3 = this.intAdapter.fromJson(jsonReader);
                if (fromJson3 != null) {
                    num3 = Integer.valueOf(fromJson3.intValue());
                } else {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("screenColourDepth", "screenColourDepth", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"scr…reenColourDepth\", reader)");
                    throw unexpectedNull3;
                }
            } else {
                continue;
            }
        }
        jsonReader.endObject();
        if (num != null) {
            int intValue = num.intValue();
            if (num2 != null) {
                int intValue2 = num2.intValue();
                if (num3 != null) {
                    return new DevicePrintScreen(intValue, intValue2, num3.intValue());
                }
                JsonDataException missingProperty = Util.missingProperty("screenColourDepth", "screenColourDepth", jsonReader);
                Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"sc…reenColourDepth\", reader)");
                throw missingProperty;
            }
            JsonDataException missingProperty2 = Util.missingProperty("screenHeight", "screenHeight", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"sc…ght\",\n            reader)");
            throw missingProperty2;
        }
        JsonDataException missingProperty3 = Util.missingProperty("screenWidth", "screenWidth", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"sc…dth\",\n            reader)");
        throw missingProperty3;
    }

    public void toJson(JsonWriter jsonWriter, DevicePrintScreen devicePrintScreen) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (devicePrintScreen != null) {
            jsonWriter.beginObject();
            jsonWriter.name("screenWidth");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(devicePrintScreen.getScreenWidth()));
            jsonWriter.name("screenHeight");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(devicePrintScreen.getScreenHeight()));
            jsonWriter.name("screenColourDepth");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(devicePrintScreen.getScreenColourDepth()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
