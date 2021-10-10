package com.digitalwallet.app.model;

import com.google.firebase.messaging.Constants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00110\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/digitalwallet/app/model/SecureHoldingJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/SecureHolding;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "holdingRecordAttributesAdapter", "Lcom/digitalwallet/app/model/HoldingRecordAttributes;", "nullableDynamicHoldingDisplayAdapter", "Lcom/digitalwallet/app/model/DynamicHoldingDisplay;", "nullableDynamicHoldingRenewalAdapter", "Lcom/digitalwallet/app/model/DynamicHoldingRenewal;", "nullableIntAdapter", "", "nullableListOfAssetAdapter", "", "Lcom/digitalwallet/app/model/Asset;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SecureHoldingJsonAdapter.kt */
public final class SecureHoldingJsonAdapter extends JsonAdapter<SecureHolding> {
    private volatile Constructor<SecureHolding> constructorRef;
    private final JsonAdapter<HoldingRecordAttributes> holdingRecordAttributesAdapter;
    private final JsonAdapter<DynamicHoldingDisplay> nullableDynamicHoldingDisplayAdapter;
    private final JsonAdapter<DynamicHoldingRenewal> nullableDynamicHoldingRenewalAdapter;
    private final JsonAdapter<Integer> nullableIntAdapter;
    private final JsonAdapter<List<Asset>> nullableListOfAssetAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public SecureHoldingJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("link", "attributes", "jws", Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, ShareHolding.assetDataKey, "renewal", "unsecuredId");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"l…\"renewal\", \"unsecuredId\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "link");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…emptySet(),\n      \"link\")");
        this.stringAdapter = adapter;
        JsonAdapter<HoldingRecordAttributes> adapter2 = moshi.adapter(HoldingRecordAttributes.class, SetsKt.emptySet(), "attributes");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(HoldingRec…emptySet(), \"attributes\")");
        this.holdingRecordAttributesAdapter = adapter2;
        JsonAdapter<DynamicHoldingDisplay> adapter3 = moshi.adapter(DynamicHoldingDisplay.class, SetsKt.emptySet(), "dynamicDisplay");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(DynamicHol…ySet(), \"dynamicDisplay\")");
        this.nullableDynamicHoldingDisplayAdapter = adapter3;
        JsonAdapter<List<Asset>> adapter4 = moshi.adapter(Types.newParameterizedType(List.class, Asset.class), SetsKt.emptySet(), ShareHolding.assetDataKey);
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Types.newP…ptySet(),\n      \"assets\")");
        this.nullableListOfAssetAdapter = adapter4;
        JsonAdapter<DynamicHoldingRenewal> adapter5 = moshi.adapter(DynamicHoldingRenewal.class, SetsKt.emptySet(), "renewal");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(DynamicHol…a, emptySet(), \"renewal\")");
        this.nullableDynamicHoldingRenewalAdapter = adapter5;
        JsonAdapter<Integer> adapter6 = moshi.adapter(Integer.class, SetsKt.emptySet(), "unsecuredId");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Int::class…mptySet(), \"unsecuredId\")");
        this.nullableIntAdapter = adapter6;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(35);
        sb.append("GeneratedJsonAdapter(");
        sb.append("SecureHolding");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public SecureHolding fromJson(JsonReader jsonReader) {
        long j;
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        String str = null;
        jsonReader.beginObject();
        boolean z = false;
        int i = -1;
        Integer num = null;
        DynamicHoldingRenewal dynamicHoldingRenewal = null;
        List<Asset> list = null;
        DynamicHoldingDisplay dynamicHoldingDisplay = null;
        HoldingRecordAttributes holdingRecordAttributes = null;
        String str2 = str;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    continue;
                case 0:
                    str = this.stringAdapter.fromJson(jsonReader);
                    if (str != null) {
                        j = 4294967294L;
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("link", "link", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"link\", \"link\", reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    holdingRecordAttributes = this.holdingRecordAttributesAdapter.fromJson(jsonReader);
                    if (holdingRecordAttributes != null) {
                        continue;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("attributes", "attributes", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"att…s\", \"attributes\", reader)");
                        throw unexpectedNull2;
                    }
                case 2:
                    str2 = this.stringAdapter.fromJson(jsonReader);
                    if (str2 != null) {
                        j = 4294967291L;
                        break;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("jws", "jws", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"jws\", \"jws\", reader)");
                        throw unexpectedNull3;
                    }
                case 3:
                    dynamicHoldingDisplay = this.nullableDynamicHoldingDisplayAdapter.fromJson(jsonReader);
                    j = 4294967287L;
                    break;
                case 4:
                    list = this.nullableListOfAssetAdapter.fromJson(jsonReader);
                    j = 4294967279L;
                    break;
                case 5:
                    dynamicHoldingRenewal = this.nullableDynamicHoldingRenewalAdapter.fromJson(jsonReader);
                    j = 4294967263L;
                    break;
                case 6:
                    num = this.nullableIntAdapter.fromJson(jsonReader);
                    z = true;
                    continue;
            }
            i &= (int) j;
        }
        jsonReader.endObject();
        Constructor<SecureHolding> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = SecureHolding.class.getDeclaredConstructor(String.class, HoldingRecordAttributes.class, String.class, DynamicHoldingDisplay.class, List.class, DynamicHoldingRenewal.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "SecureHolding::class.jav…his.constructorRef = it }");
        }
        Object[] objArr = new Object[8];
        objArr[0] = str;
        if (holdingRecordAttributes != null) {
            objArr[1] = holdingRecordAttributes;
            objArr[2] = str2;
            objArr[3] = dynamicHoldingDisplay;
            objArr[4] = list;
            objArr[5] = dynamicHoldingRenewal;
            objArr[6] = Integer.valueOf(i);
            objArr[7] = null;
            SecureHolding newInstance = constructor.newInstance(objArr);
            Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…mask0,\n        null\n    )");
            SecureHolding secureHolding = newInstance;
            if (!z) {
                num = secureHolding.getUnsecuredId();
            }
            secureHolding.setUnsecuredId(num);
            return secureHolding;
        }
        JsonDataException missingProperty = Util.missingProperty("attributes", "attributes", jsonReader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"at…s\", \"attributes\", reader)");
        throw missingProperty;
    }

    public void toJson(JsonWriter jsonWriter, SecureHolding secureHolding) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (secureHolding != null) {
            jsonWriter.beginObject();
            jsonWriter.name("link");
            this.stringAdapter.toJson(jsonWriter, secureHolding.getLink());
            jsonWriter.name("attributes");
            this.holdingRecordAttributesAdapter.toJson(jsonWriter, secureHolding.getAttributes());
            jsonWriter.name("jws");
            this.stringAdapter.toJson(jsonWriter, secureHolding.getJws());
            jsonWriter.name(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
            this.nullableDynamicHoldingDisplayAdapter.toJson(jsonWriter, secureHolding.getDynamicDisplay());
            jsonWriter.name(ShareHolding.assetDataKey);
            this.nullableListOfAssetAdapter.toJson(jsonWriter, secureHolding.getAssets());
            jsonWriter.name("renewal");
            this.nullableDynamicHoldingRenewalAdapter.toJson(jsonWriter, secureHolding.getRenewal());
            jsonWriter.name("unsecuredId");
            this.nullableIntAdapter.toJson(jsonWriter, secureHolding.getUnsecuredId());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
