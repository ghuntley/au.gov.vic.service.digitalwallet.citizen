package com.digitalwallet.app.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/digitalwallet/app/model/AuthorityJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/Authority;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "authorityTypeAdapter", "Lcom/digitalwallet/app/model/AuthorityType;", "constructorRef", "Ljava/lang/reflect/Constructor;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AuthorityJsonAdapter.kt */
public final class AuthorityJsonAdapter extends JsonAdapter<Authority> {
    private final JsonAdapter<AuthorityType> authorityTypeAdapter;
    private volatile Constructor<Authority> constructorRef;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public AuthorityJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("name", "logo", "authorityType");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"n… \"logo\", \"authorityType\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "name");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…emptySet(),\n      \"name\")");
        this.stringAdapter = adapter;
        JsonAdapter<AuthorityType> adapter2 = moshi.adapter(AuthorityType.class, SetsKt.emptySet(), "authorityType");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(AuthorityT…tySet(), \"authorityType\")");
        this.authorityTypeAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(31);
        sb.append("GeneratedJsonAdapter(");
        sb.append("Authority");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public Authority fromJson(JsonReader jsonReader) {
        long j;
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        String str = null;
        jsonReader.beginObject();
        AuthorityType authorityType = null;
        int i = -1;
        String str2 = str;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName != -1) {
                if (selectName == 0) {
                    str = this.stringAdapter.fromJson(jsonReader);
                    if (str != null) {
                        j = 4294967294L;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("name", "name", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"name\", \"name\", reader)");
                        throw unexpectedNull;
                    }
                } else if (selectName == 1) {
                    str2 = this.stringAdapter.fromJson(jsonReader);
                    if (str2 != null) {
                        j = 4294967293L;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("logo", "logo", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"logo\", \"logo\", reader)");
                        throw unexpectedNull2;
                    }
                } else if (selectName == 2) {
                    authorityType = this.authorityTypeAdapter.fromJson(jsonReader);
                    if (authorityType != null) {
                        j = 4294967291L;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("authorityType", "authorityType", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"aut… \"authorityType\", reader)");
                        throw unexpectedNull3;
                    }
                } else {
                    continue;
                }
                i &= (int) j;
            } else {
                jsonReader.skipName();
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        Constructor<Authority> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = Authority.class.getDeclaredConstructor(String.class, String.class, AuthorityType.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "Authority::class.java.ge…his.constructorRef = it }");
        }
        Authority newInstance = constructor.newInstance(str, str2, authorityType, Integer.valueOf(i), null);
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…mask0,\n        null\n    )");
        return newInstance;
    }

    public void toJson(JsonWriter jsonWriter, Authority authority) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (authority != null) {
            jsonWriter.beginObject();
            jsonWriter.name("name");
            this.stringAdapter.toJson(jsonWriter, authority.getName());
            jsonWriter.name("logo");
            this.stringAdapter.toJson(jsonWriter, authority.getLogo());
            jsonWriter.name("authorityType");
            this.authorityTypeAdapter.toJson(jsonWriter, authority.getAuthorityType());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
