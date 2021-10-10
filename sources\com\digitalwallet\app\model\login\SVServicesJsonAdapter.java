package com.digitalwallet.app.model.login;

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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/model/login/SVServicesJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/login/SVServices;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "listOfSVServiceAdapter", "", "Lcom/digitalwallet/app/model/login/SVService;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SVServicesJsonAdapter.kt */
public final class SVServicesJsonAdapter extends JsonAdapter<SVServices> {
    private final JsonAdapter<List<SVService>> listOfSVServiceAdapter;
    private final JsonReader.Options options;

    public SVServicesJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("services");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"services\")");
        this.options = of;
        JsonAdapter<List<SVService>> adapter = moshi.adapter(Types.newParameterizedType(List.class, SVService.class), SetsKt.emptySet(), "services");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…ySet(),\n      \"services\")");
        this.listOfSVServiceAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("GeneratedJsonAdapter(");
        sb.append("SVServices");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public SVServices fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        List<SVService> list = null;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0 && (list = this.listOfSVServiceAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("services", "services", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"ser…ces\", \"services\", reader)");
                throw unexpectedNull;
            }
        }
        jsonReader.endObject();
        if (list != null) {
            return new SVServices(list);
        }
        JsonDataException missingProperty = Util.missingProperty("services", "services", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"se…ces\", \"services\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, SVServices sVServices) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (sVServices != null) {
            jsonWriter.beginObject();
            jsonWriter.name("services");
            this.listOfSVServiceAdapter.toJson(jsonWriter, sVServices.getServices());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
