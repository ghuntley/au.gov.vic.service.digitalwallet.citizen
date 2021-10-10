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
import org.bouncycastle.i18n.MessageBundle;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/digitalwallet/app/model/login/SVCategoryJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/login/SVCategory;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "listOfSVTransactionAdapter", "", "Lcom/digitalwallet/app/model/login/SVTransaction;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SVCategoryJsonAdapter.kt */
public final class SVCategoryJsonAdapter extends JsonAdapter<SVCategory> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<List<SVTransaction>> listOfSVTransactionAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public SVCategoryJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", MessageBundle.TITLE_ENTRY, "description", "transactions", "order");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"i… \"transactions\", \"order\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<List<SVTransaction>> adapter2 = moshi.adapter(Types.newParameterizedType(List.class, SVTransaction.class), SetsKt.emptySet(), "transactions");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…ptySet(), \"transactions\")");
        this.listOfSVTransactionAdapter = adapter2;
        JsonAdapter<Integer> adapter3 = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), "order");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Int::class…ava, emptySet(), \"order\")");
        this.intAdapter = adapter3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("GeneratedJsonAdapter(");
        sb.append("SVCategory");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public SVCategory fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        Integer num = null;
        jsonReader.beginObject();
        String str = null;
        String str2 = str;
        List<SVTransaction> list = null;
        String str3 = str2;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                String fromJson = this.stringAdapter.fromJson(jsonReader);
                if (fromJson != null) {
                    str3 = fromJson;
                } else {
                    JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"id\", \"id\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                String fromJson2 = this.stringAdapter.fromJson(jsonReader);
                if (fromJson2 != null) {
                    str = fromJson2;
                } else {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull(MessageBundle.TITLE_ENTRY, MessageBundle.TITLE_ENTRY, jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"tit…tle\",\n            reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                String fromJson3 = this.stringAdapter.fromJson(jsonReader);
                if (fromJson3 != null) {
                    str2 = fromJson3;
                } else {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("description", "description", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"des…\", \"description\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                List<SVTransaction> fromJson4 = this.listOfSVTransactionAdapter.fromJson(jsonReader);
                if (fromJson4 != null) {
                    list = fromJson4;
                } else {
                    JsonDataException unexpectedNull4 = Util.unexpectedNull("transactions", "transactions", jsonReader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "Util.unexpectedNull(\"tra…, \"transactions\", reader)");
                    throw unexpectedNull4;
                }
            } else if (selectName == 4) {
                Integer fromJson5 = this.intAdapter.fromJson(jsonReader);
                if (fromJson5 != null) {
                    num = Integer.valueOf(fromJson5.intValue());
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
            JsonDataException missingProperty3 = Util.missingProperty("description", "description", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"de…ion\",\n            reader)");
            throw missingProperty3;
        } else if (list == null) {
            JsonDataException missingProperty4 = Util.missingProperty("transactions", "transactions", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "Util.missingProperty(\"tr…ons\",\n            reader)");
            throw missingProperty4;
        } else if (num != null) {
            return new SVCategory(str3, str, str2, list, num.intValue());
        } else {
            JsonDataException missingProperty5 = Util.missingProperty("order", "order", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty5, "Util.missingProperty(\"order\", \"order\", reader)");
            throw missingProperty5;
        }
    }

    public void toJson(JsonWriter jsonWriter, SVCategory sVCategory) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (sVCategory != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, sVCategory.getId());
            jsonWriter.name(MessageBundle.TITLE_ENTRY);
            this.stringAdapter.toJson(jsonWriter, sVCategory.getTitle());
            jsonWriter.name("description");
            this.stringAdapter.toJson(jsonWriter, sVCategory.getDescription());
            jsonWriter.name("transactions");
            this.listOfSVTransactionAdapter.toJson(jsonWriter, sVCategory.getTransactions());
            jsonWriter.name("order");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(sVCategory.getOrder()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
