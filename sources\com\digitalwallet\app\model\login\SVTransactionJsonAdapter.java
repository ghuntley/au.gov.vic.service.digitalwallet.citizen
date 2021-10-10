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
import org.bouncycastle.i18n.MessageBundle;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/digitalwallet/app/model/login/SVTransactionJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/login/SVTransaction;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "intAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SVTransactionJsonAdapter.kt */
public final class SVTransactionJsonAdapter extends JsonAdapter<SVTransaction> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public SVTransactionJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", MessageBundle.TITLE_ENTRY, ImagesContract.URL, "openExternally", "order");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"i…openExternally\", \"order\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<Boolean> adapter2 = moshi.adapter(Boolean.TYPE, SetsKt.emptySet(), "openExternally");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Boolean::c…,\n      \"openExternally\")");
        this.booleanAdapter = adapter2;
        JsonAdapter<Integer> adapter3 = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), "order");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Int::class…ava, emptySet(), \"order\")");
        this.intAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(35);
        sb.append("GeneratedJsonAdapter(");
        sb.append("SVTransaction");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public SVTransaction fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        Integer num = null;
        jsonReader.beginObject();
        String str = null;
        String str2 = str;
        Boolean bool = null;
        String str3 = str2;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str3 = this.stringAdapter.fromJson(jsonReader);
                if (str3 == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"id\", \"id\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(MessageBundle.TITLE_ENTRY, MessageBundle.TITLE_ENTRY, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"tit…tle\",\n            reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str2 = this.stringAdapter.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull(ImagesContract.URL, ImagesContract.URL, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"url\", \"url\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                Boolean fromJson = this.booleanAdapter.fromJson(jsonReader);
                if (fromJson != null) {
                    bool = Boolean.valueOf(fromJson.booleanValue());
                } else {
                    JsonDataException unexpectedNull4 = Util.unexpectedNull("openExternally", "openExternally", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "Util.unexpectedNull(\"ope…\"openExternally\", reader)");
                    throw unexpectedNull4;
                }
            } else if (selectName == 4) {
                Integer fromJson2 = this.intAdapter.fromJson(jsonReader);
                if (fromJson2 != null) {
                    num = Integer.valueOf(fromJson2.intValue());
                } else {
                    JsonDataException unexpectedNull5 = Util.unexpectedNull("order", "order", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "Util.unexpectedNull(\"ord…der\",\n            reader)");
                    throw unexpectedNull5;
                }
            } else {
                continue;
            }
        }
        jsonReader.endObject();
        if (str3 == null) {
            JsonDataException missingProperty = Util.missingProperty("id", "id", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"id\", \"id\", reader)");
            throw missingProperty;
        } else if (str == null) {
            JsonDataException missingProperty2 = Util.missingProperty(MessageBundle.TITLE_ENTRY, MessageBundle.TITLE_ENTRY, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"title\", \"title\", reader)");
            throw missingProperty2;
        } else if (str2 == null) {
            JsonDataException missingProperty3 = Util.missingProperty(ImagesContract.URL, ImagesContract.URL, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"url\", \"url\", reader)");
            throw missingProperty3;
        } else if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (num != null) {
                return new SVTransaction(str3, str, str2, booleanValue, num.intValue());
            }
            JsonDataException missingProperty4 = Util.missingProperty("order", "order", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "Util.missingProperty(\"order\", \"order\", reader)");
            throw missingProperty4;
        } else {
            JsonDataException missingProperty5 = Util.missingProperty("openExternally", "openExternally", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty5, "Util.missingProperty(\"op…\"openExternally\", reader)");
            throw missingProperty5;
        }
    }

    public void toJson(JsonWriter jsonWriter, SVTransaction sVTransaction) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (sVTransaction != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, sVTransaction.getId());
            jsonWriter.name(MessageBundle.TITLE_ENTRY);
            this.stringAdapter.toJson(jsonWriter, sVTransaction.getTitle());
            jsonWriter.name(ImagesContract.URL);
            this.stringAdapter.toJson(jsonWriter, sVTransaction.getUrl());
            jsonWriter.name("openExternally");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(sVTransaction.getOpenExternally()));
            jsonWriter.name("order");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(sVTransaction.getOrder()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
