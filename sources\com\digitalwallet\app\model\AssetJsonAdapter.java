package com.digitalwallet.app.model;

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

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/digitalwallet/app/model/AssetJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/Asset;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AssetJsonAdapter.kt */
public final class AssetJsonAdapter extends JsonAdapter<Asset> {
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public AssetJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("type", "hash", ImagesContract.URL);
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"type\", \"hash\", \"url\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "type");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…emptySet(),\n      \"type\")");
        this.stringAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(27);
        sb.append("GeneratedJsonAdapter(");
        sb.append("Asset");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public Asset fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        String str = null;
        jsonReader.beginObject();
        String str2 = str;
        String str3 = str2;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("type", "type", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"typ…ype\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("hash", "hash", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"has…ash\",\n            reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (str3 = this.stringAdapter.fromJson(jsonReader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull(ImagesContract.URL, ImagesContract.URL, jsonReader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"url\", \"url\", reader)");
                throw unexpectedNull3;
            }
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("type", "type", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"type\", \"type\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("hash", "hash", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"hash\", \"hash\", reader)");
            throw missingProperty2;
        } else if (str3 != null) {
            return new Asset(str, str2, str3);
        } else {
            JsonDataException missingProperty3 = Util.missingProperty(ImagesContract.URL, ImagesContract.URL, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"url\", \"url\", reader)");
            throw missingProperty3;
        }
    }

    public void toJson(JsonWriter jsonWriter, Asset asset) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (asset != null) {
            jsonWriter.beginObject();
            jsonWriter.name("type");
            this.stringAdapter.toJson(jsonWriter, asset.getType());
            jsonWriter.name("hash");
            this.stringAdapter.toJson(jsonWriter, asset.getHash());
            jsonWriter.name(ImagesContract.URL);
            this.stringAdapter.toJson(jsonWriter, asset.getUrl());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
