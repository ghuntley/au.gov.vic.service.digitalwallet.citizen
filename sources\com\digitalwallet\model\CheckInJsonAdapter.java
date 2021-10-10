package com.digitalwallet.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/digitalwallet/model/CheckInJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/model/CheckIn;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableDateAdapter", "Ljava/util/Date;", "nullableListOfCheckInGuestAdapter", "", "Lcom/digitalwallet/model/CheckInGuest;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInJsonAdapter.kt */
public final class CheckInJsonAdapter extends JsonAdapter<CheckIn> {
    private volatile Constructor<CheckIn> constructorRef;
    private final JsonAdapter<Date> nullableDateAdapter;
    private final JsonAdapter<List<CheckInGuest>> nullableListOfCheckInGuestAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;

    public CheckInJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(FirebaseAnalytics.Param.LOCATION, "firstName", "lastName", "contactNumber", "timestamp", "eventID", "guests", "type");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"l…entID\", \"guests\", \"type\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "locationName");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…ptySet(), \"locationName\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<Date> adapter2 = moshi.adapter(Date.class, SetsKt.emptySet(), "date");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Date::clas…emptySet(),\n      \"date\")");
        this.nullableDateAdapter = adapter2;
        JsonAdapter<List<CheckInGuest>> adapter3 = moshi.adapter(Types.newParameterizedType(List.class, CheckInGuest.class), SetsKt.emptySet(), "guests");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Types.newP…    emptySet(), \"guests\")");
        this.nullableListOfCheckInGuestAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(29);
        sb.append("GeneratedJsonAdapter(");
        sb.append("CheckIn");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public CheckIn fromJson(JsonReader jsonReader) {
        long j;
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        String str = null;
        jsonReader.beginObject();
        String str2 = str;
        String str3 = str2;
        Date date = null;
        List<CheckInGuest> list = null;
        int i = -1;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    continue;
                case 0:
                    str = this.nullableStringAdapter.fromJson(jsonReader);
                    continue;
                case 1:
                    str4 = this.nullableStringAdapter.fromJson(jsonReader);
                    continue;
                case 2:
                    str5 = this.nullableStringAdapter.fromJson(jsonReader);
                    continue;
                case 3:
                    str6 = this.nullableStringAdapter.fromJson(jsonReader);
                    continue;
                case 4:
                    date = this.nullableDateAdapter.fromJson(jsonReader);
                    continue;
                case 5:
                    str2 = this.nullableStringAdapter.fromJson(jsonReader);
                    continue;
                case 6:
                    list = this.nullableListOfCheckInGuestAdapter.fromJson(jsonReader);
                    j = 4294967231L;
                    break;
                case 7:
                    str3 = this.nullableStringAdapter.fromJson(jsonReader);
                    j = 4294967167L;
                    break;
            }
            i &= (int) j;
        }
        jsonReader.endObject();
        Constructor<CheckIn> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = CheckIn.class.getDeclaredConstructor(String.class, String.class, String.class, String.class, Date.class, String.class, List.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "CheckIn::class.java.getD…his.constructorRef = it }");
        }
        CheckIn newInstance = constructor.newInstance(str, str4, str5, str6, date, str2, list, str3, Integer.valueOf(i), null);
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…mask0,\n        null\n    )");
        return newInstance;
    }

    public void toJson(JsonWriter jsonWriter, CheckIn checkIn) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (checkIn != null) {
            jsonWriter.beginObject();
            jsonWriter.name(FirebaseAnalytics.Param.LOCATION);
            this.nullableStringAdapter.toJson(jsonWriter, checkIn.getLocationName());
            jsonWriter.name("firstName");
            this.nullableStringAdapter.toJson(jsonWriter, checkIn.getFirstName());
            jsonWriter.name("lastName");
            this.nullableStringAdapter.toJson(jsonWriter, checkIn.getLastName());
            jsonWriter.name("contactNumber");
            this.nullableStringAdapter.toJson(jsonWriter, checkIn.getPhoneNumber());
            jsonWriter.name("timestamp");
            this.nullableDateAdapter.toJson(jsonWriter, checkIn.getDate());
            jsonWriter.name("eventID");
            this.nullableStringAdapter.toJson(jsonWriter, checkIn.getEventID());
            jsonWriter.name("guests");
            this.nullableListOfCheckInGuestAdapter.toJson(jsonWriter, checkIn.getGuests());
            jsonWriter.name("type");
            this.nullableStringAdapter.toJson(jsonWriter, checkIn.getType());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
