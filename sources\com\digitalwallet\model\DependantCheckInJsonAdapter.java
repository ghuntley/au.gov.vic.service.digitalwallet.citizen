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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/digitalwallet/model/DependantCheckInJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/model/DependantCheckIn;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "checkInGuestAdapter", "Lcom/digitalwallet/model/CheckInGuest;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: DependantCheckInJsonAdapter.kt */
public final class DependantCheckInJsonAdapter extends JsonAdapter<DependantCheckIn> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<CheckInGuest> checkInGuestAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public DependantCheckInJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("guestPayload", "internalId", "shouldSave");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"g…lId\",\n      \"shouldSave\")");
        this.options = of;
        JsonAdapter<CheckInGuest> adapter = moshi.adapter(CheckInGuest.class, SetsKt.emptySet(), "guestPayload");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(CheckInGue…ptySet(), \"guestPayload\")");
        this.checkInGuestAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "internalId");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…et(),\n      \"internalId\")");
        this.stringAdapter = adapter2;
        JsonAdapter<Boolean> adapter3 = moshi.adapter(Boolean.TYPE, SetsKt.emptySet(), "shouldSave");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Boolean::c…et(),\n      \"shouldSave\")");
        this.booleanAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(38);
        sb.append("GeneratedJsonAdapter(");
        sb.append("DependantCheckIn");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public DependantCheckIn fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        CheckInGuest checkInGuest = null;
        String str = null;
        Boolean bool = null;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                checkInGuest = this.checkInGuestAdapter.fromJson(jsonReader);
                if (checkInGuest == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("guestPayload", "guestPayload", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"gue…, \"guestPayload\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("internalId", "internalId", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"int…    \"internalId\", reader)");
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
        if (checkInGuest == null) {
            JsonDataException missingProperty = Util.missingProperty("guestPayload", "guestPayload", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"gu…oad\",\n            reader)");
            throw missingProperty;
        } else if (str == null) {
            JsonDataException missingProperty2 = Util.missingProperty("internalId", "internalId", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"in…d\", \"internalId\", reader)");
            throw missingProperty2;
        } else if (bool != null) {
            return new DependantCheckIn(checkInGuest, str, bool.booleanValue());
        } else {
            JsonDataException missingProperty3 = Util.missingProperty("shouldSave", "shouldSave", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"sh…e\", \"shouldSave\", reader)");
            throw missingProperty3;
        }
    }

    public void toJson(JsonWriter jsonWriter, DependantCheckIn dependantCheckIn) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (dependantCheckIn != null) {
            jsonWriter.beginObject();
            jsonWriter.name("guestPayload");
            this.checkInGuestAdapter.toJson(jsonWriter, dependantCheckIn.getGuestPayload());
            jsonWriter.name("internalId");
            this.stringAdapter.toJson(jsonWriter, dependantCheckIn.getInternalId());
            jsonWriter.name("shouldSave");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(dependantCheckIn.getShouldSave()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
