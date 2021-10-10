package com.digitalwallet.app.model.login;

import com.google.firebase.analytics.FirebaseAnalytics;
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
import org.bouncycastle.i18n.MessageBundle;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/digitalwallet/app/model/login/SVServiceJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/login/SVService;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "nullableListOfSVCategoryAdapter", "", "Lcom/digitalwallet/app/model/login/SVCategory;", "nullableListOfSVItemAdapter", "Lcom/digitalwallet/app/model/login/SVItem;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SVServiceJsonAdapter.kt */
public final class SVServiceJsonAdapter extends JsonAdapter<SVService> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<List<SVCategory>> nullableListOfSVCategoryAdapter;
    private final JsonAdapter<List<SVItem>> nullableListOfSVItemAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public SVServiceJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("type", "order", FirebaseAnalytics.Param.ITEMS, "id", MessageBundle.TITLE_ENTRY, "categories");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"t…   \"title\", \"categories\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "type");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…emptySet(),\n      \"type\")");
        this.stringAdapter = adapter;
        JsonAdapter<Integer> adapter2 = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), "order");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Int::class…ava, emptySet(), \"order\")");
        this.intAdapter = adapter2;
        JsonAdapter<List<SVItem>> adapter3 = moshi.adapter(Types.newParameterizedType(List.class, SVItem.class), SetsKt.emptySet(), FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Types.newP…mptySet(),\n      \"items\")");
        this.nullableListOfSVItemAdapter = adapter3;
        JsonAdapter<String> adapter4 = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(String::cl…,\n      emptySet(), \"id\")");
        this.nullableStringAdapter = adapter4;
        JsonAdapter<List<SVCategory>> adapter5 = moshi.adapter(Types.newParameterizedType(List.class, SVCategory.class), SetsKt.emptySet(), "categories");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Types.newP…emptySet(), \"categories\")");
        this.nullableListOfSVCategoryAdapter = adapter5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(31);
        sb.append("GeneratedJsonAdapter(");
        sb.append("SVService");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public SVService fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        Integer num = null;
        jsonReader.beginObject();
        List<SVItem> list = null;
        List<SVCategory> list2 = list;
        String str = null;
        String str2 = str;
        String str3 = str2;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    String fromJson = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson != null) {
                        str = fromJson;
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("type", "type", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"typ…ype\",\n            reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    Integer fromJson2 = this.intAdapter.fromJson(jsonReader);
                    if (fromJson2 != null) {
                        num = Integer.valueOf(fromJson2.intValue());
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("order", "order", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"ord…der\",\n            reader)");
                        throw unexpectedNull2;
                    }
                case 2:
                    list = this.nullableListOfSVItemAdapter.fromJson(jsonReader);
                    break;
                case 3:
                    str2 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 4:
                    str3 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 5:
                    list2 = this.nullableListOfSVCategoryAdapter.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("type", "type", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"type\", \"type\", reader)");
            throw missingProperty;
        } else if (num != null) {
            return new SVService(str, num.intValue(), list, str2, str3, list2);
        } else {
            JsonDataException missingProperty2 = Util.missingProperty("order", "order", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"order\", \"order\", reader)");
            throw missingProperty2;
        }
    }

    public void toJson(JsonWriter jsonWriter, SVService sVService) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (sVService != null) {
            jsonWriter.beginObject();
            jsonWriter.name("type");
            this.stringAdapter.toJson(jsonWriter, sVService.getType());
            jsonWriter.name("order");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(sVService.getOrder()));
            jsonWriter.name(FirebaseAnalytics.Param.ITEMS);
            this.nullableListOfSVItemAdapter.toJson(jsonWriter, sVService.getItems());
            jsonWriter.name("id");
            this.nullableStringAdapter.toJson(jsonWriter, sVService.getId());
            jsonWriter.name(MessageBundle.TITLE_ENTRY);
            this.nullableStringAdapter.toJson(jsonWriter, sVService.getTitle());
            jsonWriter.name("categories");
            this.nullableListOfSVCategoryAdapter.toJson(jsonWriter, sVService.getCategories());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
