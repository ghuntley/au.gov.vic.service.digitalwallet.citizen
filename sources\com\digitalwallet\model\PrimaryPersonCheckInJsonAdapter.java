package com.digitalwallet.model;

import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/digitalwallet/model/PrimaryPersonCheckInJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/model/PrimaryPersonCheckIn;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "checkInAdapter", "Lcom/digitalwallet/model/CheckIn;", "checkInCodeAdapter", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: PrimaryPersonCheckInJsonAdapter.kt */
public final class PrimaryPersonCheckInJsonAdapter extends JsonAdapter<PrimaryPersonCheckIn> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<CheckIn> checkInAdapter;
    private final JsonAdapter<CheckInUtils.CheckInCode> checkInCodeAdapter;
    private final JsonReader.Options options;

    public PrimaryPersonCheckInJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("checkInPayload", "checkInCode", "shouldSave");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"c…ode\",\n      \"shouldSave\")");
        this.options = of;
        JsonAdapter<CheckIn> adapter = moshi.adapter(CheckIn.class, SetsKt.emptySet(), "checkInPayload");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(CheckIn::c…,\n      \"checkInPayload\")");
        this.checkInAdapter = adapter;
        JsonAdapter<CheckInUtils.CheckInCode> adapter2 = moshi.adapter(CheckInUtils.CheckInCode.class, SetsKt.emptySet(), "checkInCode");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(CheckInUti…mptySet(), \"checkInCode\")");
        this.checkInCodeAdapter = adapter2;
        JsonAdapter<Boolean> adapter3 = moshi.adapter(Boolean.TYPE, SetsKt.emptySet(), "shouldSave");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Boolean::c…et(),\n      \"shouldSave\")");
        this.booleanAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(42);
        sb.append("GeneratedJsonAdapter(");
        sb.append("PrimaryPersonCheckIn");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public PrimaryPersonCheckIn fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        CheckIn checkIn = null;
        CheckInUtils.CheckInCode checkInCode = null;
        Boolean bool = null;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                checkIn = this.checkInAdapter.fromJson(jsonReader);
                if (checkIn == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("checkInPayload", "checkInPayload", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"che…\"checkInPayload\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                checkInCode = this.checkInCodeAdapter.fromJson(jsonReader);
                if (checkInCode == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("checkInCode", "checkInCode", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"che…\", \"checkInCode\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                Boolean fromJson = this.booleanAdapter.fromJson(jsonReader);
                if (fromJson != null) {
                    bool = Boolean.valueOf(fromJson.booleanValue());
                } else {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("shouldSave", "shouldSave", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"sho…    \"shouldSave\", reader)");
                    throw unexpectedNull3;
                }
            } else {
                continue;
            }
        }
        jsonReader.endObject();
        if (checkIn == null) {
            JsonDataException missingProperty = Util.missingProperty("checkInPayload", "checkInPayload", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"ch…\"checkInPayload\", reader)");
            throw missingProperty;
        } else if (checkInCode == null) {
            JsonDataException missingProperty2 = Util.missingProperty("checkInCode", "checkInCode", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"ch…ode\",\n            reader)");
            throw missingProperty2;
        } else if (bool != null) {
            return new PrimaryPersonCheckIn(checkIn, checkInCode, bool.booleanValue());
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("shouldSave", "shouldSave", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"sh…e\", \"shouldSave\", reader)");
            throw missingProperty3;
        }
    }

    public void toJson(JsonWriter jsonWriter, PrimaryPersonCheckIn primaryPersonCheckIn) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (primaryPersonCheckIn != null) {
            jsonWriter.beginObject();
            jsonWriter.name("checkInPayload");
            this.checkInAdapter.toJson(jsonWriter, primaryPersonCheckIn.getCheckInPayload());
            jsonWriter.name("checkInCode");
            this.checkInCodeAdapter.toJson(jsonWriter, primaryPersonCheckIn.getCheckInCode());
            jsonWriter.name("shouldSave");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(primaryPersonCheckIn.getShouldSave()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
