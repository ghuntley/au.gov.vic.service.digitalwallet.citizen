package com.digitalwallet.app.model.db.harvester;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010!\u001a\u00020\u0015H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/digitalwallet/app/model/db/harvester/HarvestBatchJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/db/harvester/HarvestBatch;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "constructorRef", "Ljava/lang/reflect/Constructor;", "dateAdapter", "Ljava/util/Date;", "doubleAdapter", "", "intAdapter", "", "listOfHarvestTagAdapter", "", "Lcom/digitalwallet/app/model/db/harvester/HarvestTag;", "nullableIntAdapter", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestBatchJsonAdapter.kt */
public final class HarvestBatchJsonAdapter extends JsonAdapter<HarvestBatch> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private volatile Constructor<HarvestBatch> constructorRef;
    private final JsonAdapter<Date> dateAdapter;
    private final JsonAdapter<Double> doubleAdapter;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<List<HarvestTag>> listOfHarvestTagAdapter;
    private final JsonAdapter<Integer> nullableIntAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public HarvestBatchJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("quotaId", "harvesterID", AuthorizationRequest.Scope.ADDRESS, "landholderName", "landholderContactNumber", "consentCaptured", "consentDateTime", "dateOfHarvest", "scanLatitude", "scanLongitude", "numFemales", "numEasternGreyKangaroos", "numWesternGreyKangaroos", "numRedKangaroos", "numPouchYoungDestroyed", "numYoungAtFootDestroyed", "numTaggedCarcassesLeftOnProperty", "numTaggedCarcassesStoredForProcessor", "comments", "tags");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"q…sor\", \"comments\", \"tags\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "quotaId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…tySet(),\n      \"quotaId\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "landholderName");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…ySet(), \"landholderName\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<Boolean> adapter3 = moshi.adapter(Boolean.TYPE, SetsKt.emptySet(), "consentCaptured");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Boolean::c…\n      \"consentCaptured\")");
        this.booleanAdapter = adapter3;
        JsonAdapter<Date> adapter4 = moshi.adapter(Date.class, SetsKt.emptySet(), "consentDateTime");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Date::clas…\n      \"consentDateTime\")");
        this.dateAdapter = adapter4;
        JsonAdapter<Double> adapter5 = moshi.adapter(Double.TYPE, SetsKt.emptySet(), "scanLatitude");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Double::cl…(),\n      \"scanLatitude\")");
        this.doubleAdapter = adapter5;
        JsonAdapter<Integer> adapter6 = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), "numFemales");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Int::class…et(),\n      \"numFemales\")");
        this.intAdapter = adapter6;
        JsonAdapter<Integer> adapter7 = moshi.adapter(Integer.class, SetsKt.emptySet(), "numEasternGreyKangaroos");
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(Int::class…numEasternGreyKangaroos\")");
        this.nullableIntAdapter = adapter7;
        JsonAdapter<List<HarvestTag>> adapter8 = moshi.adapter(Types.newParameterizedType(List.class, HarvestTag.class), SetsKt.emptySet(), "tags");
        Intrinsics.checkNotNullExpressionValue(adapter8, "moshi.adapter(Types.newP…      emptySet(), \"tags\")");
        this.listOfHarvestTagAdapter = adapter8;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(34);
        sb.append("GeneratedJsonAdapter(");
        sb.append("HarvestBatch");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.squareup.moshi.JsonAdapter
    public HarvestBatch fromJson(JsonReader jsonReader) {
        String str;
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        String str2 = null;
        Double valueOf = Double.valueOf(0.0d);
        jsonReader.beginObject();
        Date date = null;
        Date date2 = date;
        Double d = valueOf;
        Double d2 = d;
        Integer num = null;
        Integer num2 = num;
        Integer num3 = num2;
        Integer num4 = num3;
        Integer num5 = num4;
        Integer num6 = num5;
        Integer num7 = num6;
        Integer num8 = num7;
        List<HarvestTag> list = null;
        int i = -1;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        Boolean bool = null;
        String str7 = str6;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    str2 = str2;
                    str6 = str6;
                    num2 = num2;
                    num = num;
                    d2 = d2;
                    d = d;
                    date2 = date2;
                    date = date;
                    bool = bool;
                    str5 = str5;
                    str4 = str4;
                    str3 = str3;
                    break;
                case 0:
                    String fromJson = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson != null) {
                        str2 = fromJson;
                        str6 = str6;
                        num2 = num2;
                        num = num;
                        d2 = d2;
                        d = d;
                        date2 = date2;
                        date = date;
                        bool = bool;
                        str5 = str5;
                        str4 = str4;
                        str3 = str3;
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("quotaId", "quotaId", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"quo…       \"quotaId\", reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    String fromJson2 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson2 != null) {
                        str7 = fromJson2;
                        str2 = str2;
                        str6 = str6;
                        num2 = num2;
                        num = num;
                        d2 = d2;
                        d = d;
                        date2 = date2;
                        date = date;
                        bool = bool;
                        str5 = str5;
                        str4 = str4;
                        str3 = str3;
                        continue;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("harvesterId", "harvesterID", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"har…\", \"harvesterID\", reader)");
                        throw unexpectedNull2;
                    }
                case 2:
                    String fromJson3 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson3 != null) {
                        str3 = fromJson3;
                        str2 = str2;
                        str6 = str6;
                        num2 = num2;
                        num = num;
                        d2 = d2;
                        d = d;
                        date2 = date2;
                        date = date;
                        bool = bool;
                        str5 = str5;
                        str4 = str4;
                        break;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull(AuthorizationRequest.Scope.ADDRESS, AuthorizationRequest.Scope.ADDRESS, jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"add…       \"address\", reader)");
                        throw unexpectedNull3;
                    }
                case 3:
                    str4 = this.nullableStringAdapter.fromJson(jsonReader);
                    str2 = str2;
                    str6 = str6;
                    num2 = num2;
                    num = num;
                    d2 = d2;
                    d = d;
                    date2 = date2;
                    date = date;
                    bool = bool;
                    str5 = str5;
                    str3 = str3;
                    break;
                case 4:
                    str5 = this.nullableStringAdapter.fromJson(jsonReader);
                    str2 = str2;
                    str6 = str6;
                    num2 = num2;
                    num = num;
                    d2 = d2;
                    d = d;
                    date2 = date2;
                    date = date;
                    bool = bool;
                    str4 = str4;
                    str3 = str3;
                    break;
                case 5:
                    Boolean fromJson4 = this.booleanAdapter.fromJson(jsonReader);
                    if (fromJson4 != null) {
                        bool = Boolean.valueOf(fromJson4.booleanValue());
                        str2 = str2;
                        str6 = str6;
                        num2 = num2;
                        num = num;
                        d2 = d2;
                        d = d;
                        date2 = date2;
                        date = date;
                        str5 = str5;
                        str4 = str4;
                        str3 = str3;
                        break;
                    } else {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("consentCaptured", "consentCaptured", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "Util.unexpectedNull(\"con…consentCaptured\", reader)");
                        throw unexpectedNull4;
                    }
                case 6:
                    Date fromJson5 = this.dateAdapter.fromJson(jsonReader);
                    if (fromJson5 != null) {
                        date = fromJson5;
                        str2 = str2;
                        str6 = str6;
                        num2 = num2;
                        num = num;
                        d2 = d2;
                        d = d;
                        date2 = date2;
                        bool = bool;
                        str5 = str5;
                        str4 = str4;
                        str3 = str3;
                        break;
                    } else {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("consentDateTime", "consentDateTime", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "Util.unexpectedNull(\"con…consentDateTime\", reader)");
                        throw unexpectedNull5;
                    }
                case 7:
                    Date fromJson6 = this.dateAdapter.fromJson(jsonReader);
                    if (fromJson6 != null) {
                        date2 = fromJson6;
                        str2 = str2;
                        str6 = str6;
                        num2 = num2;
                        num = num;
                        d2 = d2;
                        d = d;
                        date = date;
                        bool = bool;
                        str5 = str5;
                        str4 = str4;
                        str3 = str3;
                        break;
                    } else {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull("dateOfHarvest", "dateOfHarvest", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "Util.unexpectedNull(\"dat… \"dateOfHarvest\", reader)");
                        throw unexpectedNull6;
                    }
                case 8:
                    Double fromJson7 = this.doubleAdapter.fromJson(jsonReader);
                    if (fromJson7 != null) {
                        d = Double.valueOf(fromJson7.doubleValue());
                        i &= (int) 4294967039L;
                        str2 = str2;
                        str6 = str6;
                        num2 = num2;
                        num = num;
                        d2 = d2;
                        date2 = date2;
                        date = date;
                        bool = bool;
                        str5 = str5;
                        str4 = str4;
                        str3 = str3;
                        break;
                    } else {
                        JsonDataException unexpectedNull7 = Util.unexpectedNull("scanLatitude", "scanLatitude", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull7, "Util.unexpectedNull(\"sca…  \"scanLatitude\", reader)");
                        throw unexpectedNull7;
                    }
                case 9:
                    Double fromJson8 = this.doubleAdapter.fromJson(jsonReader);
                    if (fromJson8 != null) {
                        d2 = Double.valueOf(fromJson8.doubleValue());
                        i &= (int) 4294966783L;
                        str2 = str2;
                        str6 = str6;
                        num2 = num2;
                        num = num;
                        d = d;
                        date2 = date2;
                        date = date;
                        bool = bool;
                        str5 = str5;
                        str4 = str4;
                        str3 = str3;
                        break;
                    } else {
                        JsonDataException unexpectedNull8 = Util.unexpectedNull("scanLongitude", "scanLongitude", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull8, "Util.unexpectedNull(\"sca… \"scanLongitude\", reader)");
                        throw unexpectedNull8;
                    }
                case 10:
                    Integer fromJson9 = this.intAdapter.fromJson(jsonReader);
                    if (fromJson9 != null) {
                        num = Integer.valueOf(fromJson9.intValue());
                        str2 = str2;
                        str6 = str6;
                        num2 = num2;
                        d2 = d2;
                        d = d;
                        date2 = date2;
                        date = date;
                        bool = bool;
                        str5 = str5;
                        str4 = str4;
                        str3 = str3;
                        break;
                    } else {
                        JsonDataException unexpectedNull9 = Util.unexpectedNull("numFemales", "numFemales", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull9, "Util.unexpectedNull(\"num…    \"numFemales\", reader)");
                        throw unexpectedNull9;
                    }
                case 11:
                    num2 = this.nullableIntAdapter.fromJson(jsonReader);
                    str2 = str2;
                    str6 = str6;
                    num = num;
                    d2 = d2;
                    d = d;
                    date2 = date2;
                    date = date;
                    bool = bool;
                    str5 = str5;
                    str4 = str4;
                    str3 = str3;
                    break;
                case 12:
                    Integer fromJson10 = this.intAdapter.fromJson(jsonReader);
                    if (fromJson10 != null) {
                        num3 = Integer.valueOf(fromJson10.intValue());
                        str2 = str2;
                        str6 = str6;
                        num2 = num2;
                        num = num;
                        d2 = d2;
                        d = d;
                        date2 = date2;
                        date = date;
                        bool = bool;
                        str5 = str5;
                        str4 = str4;
                        str3 = str3;
                        break;
                    } else {
                        JsonDataException unexpectedNull10 = Util.unexpectedNull("numWesternGreyKangaroos", "numWesternGreyKangaroos", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull10, "Util.unexpectedNull(\"num…rnGreyKangaroos\", reader)");
                        throw unexpectedNull10;
                    }
                case 13:
                    num4 = this.nullableIntAdapter.fromJson(jsonReader);
                    str2 = str2;
                    str6 = str6;
                    num2 = num2;
                    num = num;
                    d2 = d2;
                    d = d;
                    date2 = date2;
                    date = date;
                    bool = bool;
                    str5 = str5;
                    str4 = str4;
                    str3 = str3;
                    break;
                case 14:
                    Integer fromJson11 = this.intAdapter.fromJson(jsonReader);
                    if (fromJson11 != null) {
                        num5 = Integer.valueOf(fromJson11.intValue());
                        str2 = str2;
                        str6 = str6;
                        num2 = num2;
                        num = num;
                        d2 = d2;
                        d = d;
                        date2 = date2;
                        date = date;
                        bool = bool;
                        str5 = str5;
                        str4 = str4;
                        str3 = str3;
                        break;
                    } else {
                        JsonDataException unexpectedNull11 = Util.unexpectedNull("numPouchYoungDestroyed", "numPouchYoungDestroyed", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull11, "Util.unexpectedNull(\"num…hYoungDestroyed\", reader)");
                        throw unexpectedNull11;
                    }
                case 15:
                    Integer fromJson12 = this.intAdapter.fromJson(jsonReader);
                    if (fromJson12 != null) {
                        num6 = Integer.valueOf(fromJson12.intValue());
                        str2 = str2;
                        str6 = str6;
                        num2 = num2;
                        num = num;
                        d2 = d2;
                        d = d;
                        date2 = date2;
                        date = date;
                        bool = bool;
                        str5 = str5;
                        str4 = str4;
                        str3 = str3;
                        break;
                    } else {
                        JsonDataException unexpectedNull12 = Util.unexpectedNull("numYoungAtFootDestroyed", "numYoungAtFootDestroyed", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull12, "Util.unexpectedNull(\"num…AtFootDestroyed\", reader)");
                        throw unexpectedNull12;
                    }
                case 16:
                    Integer fromJson13 = this.intAdapter.fromJson(jsonReader);
                    if (fromJson13 != null) {
                        num7 = Integer.valueOf(fromJson13.intValue());
                        str2 = str2;
                        str6 = str6;
                        num2 = num2;
                        num = num;
                        d2 = d2;
                        d = d;
                        date2 = date2;
                        date = date;
                        bool = bool;
                        str5 = str5;
                        str4 = str4;
                        str3 = str3;
                        break;
                    } else {
                        JsonDataException unexpectedNull13 = Util.unexpectedNull("numTaggedCarcassesLeftOnProperty", "numTaggedCarcassesLeftOnProperty", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull13, "Util.unexpectedNull(\"num…sLeftOnProperty\", reader)");
                        throw unexpectedNull13;
                    }
                case 17:
                    Integer fromJson14 = this.intAdapter.fromJson(jsonReader);
                    if (fromJson14 != null) {
                        num8 = Integer.valueOf(fromJson14.intValue());
                        str2 = str2;
                        str6 = str6;
                        num2 = num2;
                        num = num;
                        d2 = d2;
                        d = d;
                        date2 = date2;
                        date = date;
                        bool = bool;
                        str5 = str5;
                        str4 = str4;
                        str3 = str3;
                        break;
                    } else {
                        JsonDataException unexpectedNull14 = Util.unexpectedNull("numTaggedCarcassesStoredForProcessor", "numTaggedCarcassesStoredForProcessor", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull14, "Util.unexpectedNull(\"num…redForProcessor\", reader)");
                        throw unexpectedNull14;
                    }
                case 18:
                    String fromJson15 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson15 != null) {
                        str6 = fromJson15;
                        str2 = str2;
                        num2 = num2;
                        num = num;
                        d2 = d2;
                        d = d;
                        date2 = date2;
                        date = date;
                        bool = bool;
                        str5 = str5;
                        str4 = str4;
                        str3 = str3;
                        break;
                    } else {
                        JsonDataException unexpectedNull15 = Util.unexpectedNull("comments", "comments", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull15, "Util.unexpectedNull(\"com…      \"comments\", reader)");
                        throw unexpectedNull15;
                    }
                case 19:
                    List<HarvestTag> fromJson16 = this.listOfHarvestTagAdapter.fromJson(jsonReader);
                    if (fromJson16 != null) {
                        list = fromJson16;
                        str2 = str2;
                        str6 = str6;
                        num2 = num2;
                        num = num;
                        d2 = d2;
                        d = d;
                        date2 = date2;
                        date = date;
                        bool = bool;
                        str5 = str5;
                        str4 = str4;
                        str3 = str3;
                        break;
                    } else {
                        JsonDataException unexpectedNull16 = Util.unexpectedNull("tags", "tags", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull16, "Util.unexpectedNull(\"tag…          \"tags\", reader)");
                        throw unexpectedNull16;
                    }
                default:
                    str2 = str2;
                    str6 = str6;
                    num2 = num2;
                    num = num;
                    d2 = d2;
                    d = d;
                    date2 = date2;
                    date = date;
                    bool = bool;
                    str5 = str5;
                    str4 = str4;
                    str3 = str3;
                    break;
            }
            str7 = str7;
        }
        jsonReader.endObject();
        Constructor<HarvestBatch> constructor = this.constructorRef;
        if (constructor != null) {
            str = AuthorizationRequest.Scope.ADDRESS;
        } else {
            str = AuthorizationRequest.Scope.ADDRESS;
            constructor = HarvestBatch.class.getDeclaredConstructor(String.class, String.class, String.class, String.class, String.class, Boolean.TYPE, Date.class, Date.class, Double.TYPE, Double.TYPE, Integer.TYPE, Integer.class, Integer.TYPE, Integer.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class, List.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            Unit unit = Unit.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(constructor, "HarvestBatch::class.java…his.constructorRef = it }");
        }
        Object[] objArr = new Object[22];
        if (str2 != null) {
            objArr[0] = str2;
            if (str7 != null) {
                objArr[1] = str7;
                if (str3 != null) {
                    objArr[2] = str3;
                    objArr[3] = str4;
                    objArr[4] = str5;
                    if (bool != null) {
                        objArr[5] = Boolean.valueOf(bool.booleanValue());
                        if (date != null) {
                            objArr[6] = date;
                            if (date2 != null) {
                                objArr[7] = date2;
                                objArr[8] = d;
                                objArr[9] = d2;
                                if (num != null) {
                                    objArr[10] = Integer.valueOf(num.intValue());
                                    objArr[11] = num2;
                                    if (num3 != null) {
                                        objArr[12] = Integer.valueOf(num3.intValue());
                                        objArr[13] = num4;
                                        if (num5 != null) {
                                            objArr[14] = Integer.valueOf(num5.intValue());
                                            if (num6 != null) {
                                                objArr[15] = Integer.valueOf(num6.intValue());
                                                if (num7 != null) {
                                                    objArr[16] = Integer.valueOf(num7.intValue());
                                                    if (num8 != null) {
                                                        objArr[17] = Integer.valueOf(num8.intValue());
                                                        if (str6 != null) {
                                                            objArr[18] = str6;
                                                            if (list != null) {
                                                                objArr[19] = list;
                                                                objArr[20] = Integer.valueOf(i);
                                                                objArr[21] = null;
                                                                HarvestBatch newInstance = constructor.newInstance(objArr);
                                                                Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…mask0,\n        null\n    )");
                                                                return newInstance;
                                                            }
                                                            JsonDataException missingProperty = Util.missingProperty("tags", "tags", jsonReader);
                                                            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"tags\", \"tags\", reader)");
                                                            throw missingProperty;
                                                        }
                                                        JsonDataException missingProperty2 = Util.missingProperty("comments", "comments", jsonReader);
                                                        Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"co…nts\", \"comments\", reader)");
                                                        throw missingProperty2;
                                                    }
                                                    JsonDataException missingProperty3 = Util.missingProperty("numTaggedCarcassesStoredForProcessor", "numTaggedCarcassesStoredForProcessor", jsonReader);
                                                    Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"nu…redForProcessor\", reader)");
                                                    throw missingProperty3;
                                                }
                                                JsonDataException missingProperty4 = Util.missingProperty("numTaggedCarcassesLeftOnProperty", "numTaggedCarcassesLeftOnProperty", jsonReader);
                                                Intrinsics.checkNotNullExpressionValue(missingProperty4, "Util.missingProperty(\"nu…sLeftOnProperty\", reader)");
                                                throw missingProperty4;
                                            }
                                            JsonDataException missingProperty5 = Util.missingProperty("numYoungAtFootDestroyed", "numYoungAtFootDestroyed", jsonReader);
                                            Intrinsics.checkNotNullExpressionValue(missingProperty5, "Util.missingProperty(\"nu…AtFootDestroyed\", reader)");
                                            throw missingProperty5;
                                        }
                                        JsonDataException missingProperty6 = Util.missingProperty("numPouchYoungDestroyed", "numPouchYoungDestroyed", jsonReader);
                                        Intrinsics.checkNotNullExpressionValue(missingProperty6, "Util.missingProperty(\"nu…hYoungDestroyed\", reader)");
                                        throw missingProperty6;
                                    }
                                    JsonDataException missingProperty7 = Util.missingProperty("numWesternGreyKangaroos", "numWesternGreyKangaroos", jsonReader);
                                    Intrinsics.checkNotNullExpressionValue(missingProperty7, "Util.missingProperty(\"nu…rnGreyKangaroos\", reader)");
                                    throw missingProperty7;
                                }
                                JsonDataException missingProperty8 = Util.missingProperty("numFemales", "numFemales", jsonReader);
                                Intrinsics.checkNotNullExpressionValue(missingProperty8, "Util.missingProperty(\"nu…s\", \"numFemales\", reader)");
                                throw missingProperty8;
                            }
                            JsonDataException missingProperty9 = Util.missingProperty("dateOfHarvest", "dateOfHarvest", jsonReader);
                            Intrinsics.checkNotNullExpressionValue(missingProperty9, "Util.missingProperty(\"da… \"dateOfHarvest\", reader)");
                            throw missingProperty9;
                        }
                        JsonDataException missingProperty10 = Util.missingProperty("consentDateTime", "consentDateTime", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(missingProperty10, "Util.missingProperty(\"co…consentDateTime\", reader)");
                        throw missingProperty10;
                    }
                    JsonDataException missingProperty11 = Util.missingProperty("consentCaptured", "consentCaptured", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty11, "Util.missingProperty(\"co…consentCaptured\", reader)");
                    throw missingProperty11;
                }
                JsonDataException missingProperty12 = Util.missingProperty(str, str, jsonReader);
                Intrinsics.checkNotNullExpressionValue(missingProperty12, "Util.missingProperty(\"address\", \"address\", reader)");
                throw missingProperty12;
            }
            JsonDataException missingProperty13 = Util.missingProperty("harvesterId", "harvesterID", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty13, "Util.missingProperty(\"ha…\", \"harvesterID\", reader)");
            throw missingProperty13;
        }
        JsonDataException missingProperty14 = Util.missingProperty("quotaId", "quotaId", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty14, "Util.missingProperty(\"quotaId\", \"quotaId\", reader)");
        throw missingProperty14;
    }

    public void toJson(JsonWriter jsonWriter, HarvestBatch harvestBatch) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (harvestBatch != null) {
            jsonWriter.beginObject();
            jsonWriter.name("quotaId");
            this.stringAdapter.toJson(jsonWriter, harvestBatch.getQuotaId());
            jsonWriter.name("harvesterID");
            this.stringAdapter.toJson(jsonWriter, harvestBatch.getHarvesterId());
            jsonWriter.name(AuthorizationRequest.Scope.ADDRESS);
            this.stringAdapter.toJson(jsonWriter, harvestBatch.getAddress());
            jsonWriter.name("landholderName");
            this.nullableStringAdapter.toJson(jsonWriter, harvestBatch.getLandholderName());
            jsonWriter.name("landholderContactNumber");
            this.nullableStringAdapter.toJson(jsonWriter, harvestBatch.getLandholderContactNumber());
            jsonWriter.name("consentCaptured");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(harvestBatch.getConsentCaptured()));
            jsonWriter.name("consentDateTime");
            this.dateAdapter.toJson(jsonWriter, harvestBatch.getConsentDateTime());
            jsonWriter.name("dateOfHarvest");
            this.dateAdapter.toJson(jsonWriter, harvestBatch.getDateOfHarvest());
            jsonWriter.name("scanLatitude");
            this.doubleAdapter.toJson(jsonWriter, Double.valueOf(harvestBatch.getScanLatitude()));
            jsonWriter.name("scanLongitude");
            this.doubleAdapter.toJson(jsonWriter, Double.valueOf(harvestBatch.getScanLongitude()));
            jsonWriter.name("numFemales");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(harvestBatch.getNumFemales()));
            jsonWriter.name("numEasternGreyKangaroos");
            this.nullableIntAdapter.toJson(jsonWriter, harvestBatch.getNumEasternGreyKangaroos());
            jsonWriter.name("numWesternGreyKangaroos");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(harvestBatch.getNumWesternGreyKangaroos()));
            jsonWriter.name("numRedKangaroos");
            this.nullableIntAdapter.toJson(jsonWriter, harvestBatch.getNumRedKangaroos());
            jsonWriter.name("numPouchYoungDestroyed");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(harvestBatch.getNumPouchYoungDestroyed()));
            jsonWriter.name("numYoungAtFootDestroyed");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(harvestBatch.getNumYoungAtFootDestroyed()));
            jsonWriter.name("numTaggedCarcassesLeftOnProperty");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(harvestBatch.getNumTaggedCarcassesLeftOnProperty()));
            jsonWriter.name("numTaggedCarcassesStoredForProcessor");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(harvestBatch.getNumTaggedCarcassesStoredForProcessor()));
            jsonWriter.name("comments");
            this.stringAdapter.toJson(jsonWriter, harvestBatch.getComments());
            jsonWriter.name("tags");
            this.listOfHarvestTagAdapter.toJson(jsonWriter, harvestBatch.getTags());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
