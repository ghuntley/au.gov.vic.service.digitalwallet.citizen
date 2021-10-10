package com.digitalwallet.app.model.login;

import com.google.android.gms.common.internal.ImagesContract;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/digitalwallet/app/model/login/SVItemJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/login/SVItem;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "intAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SVItemJsonAdapter.kt */
public final class SVItemJsonAdapter extends JsonAdapter<SVItem> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public SVItemJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", "image", "imageUrl", ImagesContract.URL, "openExternally", "order");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"i…openExternally\", \"order\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "image");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…     emptySet(), \"image\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<Boolean> adapter3 = moshi.adapter(Boolean.TYPE, SetsKt.emptySet(), "openExternally");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Boolean::c…,\n      \"openExternally\")");
        this.booleanAdapter = adapter3;
        JsonAdapter<Integer> adapter4 = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), "order");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Int::class…ava, emptySet(), \"order\")");
        this.intAdapter = adapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(28);
        sb.append("GeneratedJsonAdapter(");
        sb.append("SVItem");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public SVItem fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        Integer num = null;
        jsonReader.beginObject();
        String str = null;
        String str2 = str;
        String str3 = str2;
        Boolean bool = null;
        String str4 = str3;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    str4 = this.stringAdapter.fromJson(jsonReader);
                    if (str4 != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"id\", \"id\", reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    str = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 2:
                    str2 = this.nullableStringAdapter.fromJson(jsonReader);
                    break;
                case 3:
                    str3 = this.stringAdapter.fromJson(jsonReader);
                    if (str3 != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull(ImagesContract.URL, ImagesContract.URL, jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"url\", \"url\", reader)");
                        throw unexpectedNull2;
                    }
                case 4:
                    Boolean fromJson = this.booleanAdapter.fromJson(jsonReader);
                    if (fromJson != null) {
                        bool = Boolean.valueOf(fromJson.booleanValue());
                        break;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("openExternally", "openExternally", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"ope…\"openExternally\", reader)");
                        throw unexpectedNull3;
                    }
                case 5:
                    Integer fromJson2 = this.intAdapter.fromJson(jsonReader);
                    if (fromJson2 != null) {
                        num = Integer.valueOf(fromJson2.intValue());
                        break;
                    } else {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("order", "order", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "Util.unexpectedNull(\"ord…der\",\n            reader)");
                        throw unexpectedNull4;
                    }
            }
        }
        jsonReader.endObject();
        if (str4 == null) {
            JsonDataException missingProperty = Util.missingProperty("id", "id", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"id\", \"id\", reader)");
            throw missingProperty;
        } else if (str3 == null) {
            JsonDataException missingProperty2 = Util.missingProperty(ImagesContract.URL, ImagesContract.URL, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"url\", \"url\", reader)");
            throw missingProperty2;
        } else if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (num != null) {
                return new SVItem(str4, str, str2, str3, booleanValue, num.intValue());
            }
            JsonDataException missingProperty3 = Util.missingProperty("order", "order", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"order\", \"order\", reader)");
            throw missingProperty3;
        } else {
            JsonDataException missingProperty4 = Util.missingProperty("openExternally", "openExternally", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "Util.missingProperty(\"op…\"openExternally\", reader)");
            throw missingProperty4;
        }
    }

    public void toJson(JsonWriter jsonWriter, SVItem sVItem) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (sVItem != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, sVItem.getId());
            jsonWriter.name("image");
            this.nullableStringAdapter.toJson(jsonWriter, sVItem.getImage());
            jsonWriter.name("imageUrl");
            this.nullableStringAdapter.toJson(jsonWriter, sVItem.getImageUrl());
            jsonWriter.name(ImagesContract.URL);
            this.stringAdapter.toJson(jsonWriter, sVItem.getUrl());
            jsonWriter.name("openExternally");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(sVItem.getOpenExternally()));
            jsonWriter.name("order");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(sVItem.getOrder()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
