package com.digitalwallet.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.util.Date;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/model/AttestationJwtJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/model/AttestationJwt;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "dateAdapter", "Ljava/util/Date;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AttestationJwtJsonAdapter.kt */
public final class AttestationJwtJsonAdapter extends JsonAdapter<AttestationJwt> {
    private final JsonAdapter<Date> dateAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public AttestationJwtJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("jwt", "creationDate");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"jwt\", \"creationDate\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "jwt");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl… emptySet(),\n      \"jwt\")");
        this.stringAdapter = adapter;
        JsonAdapter<Date> adapter2 = moshi.adapter(Date.class, SetsKt.emptySet(), "creationDate");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Date::clas…(),\n      \"creationDate\")");
        this.dateAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(36);
        sb.append("GeneratedJsonAdapter(");
        sb.append("AttestationJwt");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public AttestationJwt fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        String str = null;
        Date date = null;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("jwt", "jwt", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"jwt\", \"jwt\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (date = this.dateAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("creationDate", "creationDate", jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"cre…, \"creationDate\", reader)");
                throw unexpectedNull2;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("jwt", "jwt", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"jwt\", \"jwt\", reader)");
            throw missingProperty;
        } else if (date != null) {
            return new AttestationJwt(str, date);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("creationDate", "creationDate", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"cr…ate\",\n            reader)");
            throw missingProperty2;
        }
    }

    public void toJson(JsonWriter jsonWriter, AttestationJwt attestationJwt) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (attestationJwt != null) {
            jsonWriter.beginObject();
            jsonWriter.name("jwt");
            this.stringAdapter.toJson(jsonWriter, attestationJwt.getJwt());
            jsonWriter.name("creationDate");
            this.dateAdapter.toJson(jsonWriter, attestationJwt.getCreationDate());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
