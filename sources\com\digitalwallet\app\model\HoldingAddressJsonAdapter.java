package com.digitalwallet.app.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/model/HoldingAddressJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/HoldingAddress;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HoldingAddressJsonAdapter.kt */
public final class HoldingAddressJsonAdapter extends JsonAdapter<HoldingAddress> {
    private volatile Constructor<HoldingAddress> constructorRef;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;

    public HoldingAddressJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("country", "streetName", "houseNumber", "postCode", "stateOrTerritory", "suburbOrPlaceOrLocality", "unstructuredAddressLine");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"c…unstructuredAddressLine\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "country");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…   emptySet(), \"country\")");
        this.nullableStringAdapter = adapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(36);
        sb.append("GeneratedJsonAdapter(");
        sb.append("HoldingAddress");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public HoldingAddress fromJson(JsonReader jsonReader) {
        long j;
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        String str = null;
        jsonReader.beginObject();
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        int i = -1;
        String str7 = str6;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    continue;
                case 0:
                    str = this.nullableStringAdapter.fromJson(jsonReader);
                    j = 4294967294L;
                    break;
                case 1:
                    str7 = this.nullableStringAdapter.fromJson(jsonReader);
                    j = 4294967293L;
                    break;
                case 2:
                    str2 = this.nullableStringAdapter.fromJson(jsonReader);
                    j = 4294967291L;
                    break;
                case 3:
                    str3 = this.nullableStringAdapter.fromJson(jsonReader);
                    j = 4294967287L;
                    break;
                case 4:
                    str4 = this.nullableStringAdapter.fromJson(jsonReader);
                    j = 4294967279L;
                    break;
                case 5:
                    str5 = this.nullableStringAdapter.fromJson(jsonReader);
                    j = 4294967263L;
                    break;
                case 6:
                    str6 = this.nullableStringAdapter.fromJson(jsonReader);
                    j = 4294967231L;
                    break;
            }
            i &= (int) j;
        }
        jsonReader.endObject();
        Constructor<HoldingAddress> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = HoldingAddress.class.getDeclaredConstructor(String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "HoldingAddress::class.ja…his.constructorRef = it }");
        }
        HoldingAddress newInstance = constructor.newInstance(str, str7, str2, str3, str4, str5, str6, Integer.valueOf(i), null);
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…mask0,\n        null\n    )");
        return newInstance;
    }

    public void toJson(JsonWriter jsonWriter, HoldingAddress holdingAddress) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (holdingAddress != null) {
            jsonWriter.beginObject();
            jsonWriter.name("country");
            this.nullableStringAdapter.toJson(jsonWriter, holdingAddress.getCountry());
            jsonWriter.name("streetName");
            this.nullableStringAdapter.toJson(jsonWriter, holdingAddress.getStreetName());
            jsonWriter.name("houseNumber");
            this.nullableStringAdapter.toJson(jsonWriter, holdingAddress.getHouseNumber());
            jsonWriter.name("postCode");
            this.nullableStringAdapter.toJson(jsonWriter, holdingAddress.getPostCode());
            jsonWriter.name("stateOrTerritory");
            this.nullableStringAdapter.toJson(jsonWriter, holdingAddress.getState());
            jsonWriter.name("suburbOrPlaceOrLocality");
            this.nullableStringAdapter.toJson(jsonWriter, holdingAddress.getSuburb());
            jsonWriter.name("unstructuredAddressLine");
            this.nullableStringAdapter.toJson(jsonWriter, holdingAddress.getAddressLine());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
