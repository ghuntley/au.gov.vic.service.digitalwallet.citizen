package com.digitalwallet.app.model.db.unsecure;

import com.digitalwallet.app.model.Asset;
import com.digitalwallet.app.model.DynamicHoldingDisplay;
import com.digitalwallet.app.model.DynamicHoldingRenewal;
import com.digitalwallet.app.model.HoldingRecordAttributes;
import com.digitalwallet.app.model.ShareHolding;
import com.google.firebase.messaging.Constants;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010 \u001a\u00020\u0017H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00120\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHoldingJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "holdingRecordAttributesAdapter", "Lcom/digitalwallet/app/model/HoldingRecordAttributes;", "intAdapter", "", "nullableDynamicHoldingDisplayAdapter", "Lcom/digitalwallet/app/model/DynamicHoldingDisplay;", "nullableDynamicHoldingRenewalAdapter", "Lcom/digitalwallet/app/model/DynamicHoldingRenewal;", "nullableIntAdapter", "nullableListOfAssetAdapter", "", "Lcom/digitalwallet/app/model/Asset;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: UnsecuredHoldingJsonAdapter.kt */
public final class UnsecuredHoldingJsonAdapter extends JsonAdapter<UnsecuredHolding> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<HoldingRecordAttributes> holdingRecordAttributesAdapter;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<DynamicHoldingDisplay> nullableDynamicHoldingDisplayAdapter;
    private final JsonAdapter<DynamicHoldingRenewal> nullableDynamicHoldingRenewalAdapter;
    private final JsonAdapter<Integer> nullableIntAdapter;
    private final JsonAdapter<List<Asset>> nullableListOfAssetAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public UnsecuredHoldingJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(ShareHolding.assetDataKey, "attributes", Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, "holdingTypeInt", "id", "link", "renewal", "shouldUpdate");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"a…renewal\", \"shouldUpdate\")");
        this.options = of;
        JsonAdapter<List<Asset>> adapter = moshi.adapter(Types.newParameterizedType(List.class, Asset.class), SetsKt.emptySet(), ShareHolding.assetDataKey);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…ptySet(),\n      \"assets\")");
        this.nullableListOfAssetAdapter = adapter;
        JsonAdapter<HoldingRecordAttributes> adapter2 = moshi.adapter(HoldingRecordAttributes.class, SetsKt.emptySet(), "attributes");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(HoldingRec…emptySet(), \"attributes\")");
        this.holdingRecordAttributesAdapter = adapter2;
        JsonAdapter<DynamicHoldingDisplay> adapter3 = moshi.adapter(DynamicHoldingDisplay.class, SetsKt.emptySet(), Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(DynamicHol…a, emptySet(), \"display\")");
        this.nullableDynamicHoldingDisplayAdapter = adapter3;
        JsonAdapter<Integer> adapter4 = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), "holdingTypeInt");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Int::class…,\n      \"holdingTypeInt\")");
        this.intAdapter = adapter4;
        JsonAdapter<Integer> adapter5 = moshi.adapter(Integer.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Int::class…,\n      emptySet(), \"id\")");
        this.nullableIntAdapter = adapter5;
        JsonAdapter<String> adapter6 = moshi.adapter(String.class, SetsKt.emptySet(), "link");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(String::cl…emptySet(),\n      \"link\")");
        this.stringAdapter = adapter6;
        JsonAdapter<DynamicHoldingRenewal> adapter7 = moshi.adapter(DynamicHoldingRenewal.class, SetsKt.emptySet(), "renewal");
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(DynamicHol…a, emptySet(), \"renewal\")");
        this.nullableDynamicHoldingRenewalAdapter = adapter7;
        JsonAdapter<Boolean> adapter8 = moshi.adapter(Boolean.TYPE, SetsKt.emptySet(), "shouldUpdate");
        Intrinsics.checkNotNullExpressionValue(adapter8, "moshi.adapter(Boolean::c…(),\n      \"shouldUpdate\")");
        this.booleanAdapter = adapter8;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(38);
        sb.append("GeneratedJsonAdapter(");
        sb.append("UnsecuredHolding");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public UnsecuredHolding fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        List<Asset> list = null;
        HoldingRecordAttributes holdingRecordAttributes = null;
        DynamicHoldingDisplay dynamicHoldingDisplay = null;
        Integer num = null;
        Boolean bool = null;
        jsonReader.beginObject();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        DynamicHoldingRenewal dynamicHoldingRenewal = null;
        String str = null;
        Integer num2 = num;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    list = this.nullableListOfAssetAdapter.fromJson(jsonReader);
                    z = true;
                    break;
                case 1:
                    holdingRecordAttributes = this.holdingRecordAttributesAdapter.fromJson(jsonReader);
                    if (holdingRecordAttributes != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("attributes", "attributes", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"att…s\", \"attributes\", reader)");
                        throw unexpectedNull;
                    }
                case 2:
                    dynamicHoldingDisplay = this.nullableDynamicHoldingDisplayAdapter.fromJson(jsonReader);
                    z2 = true;
                    break;
                case 3:
                    Integer fromJson = this.intAdapter.fromJson(jsonReader);
                    if (fromJson != null) {
                        num = Integer.valueOf(fromJson.intValue());
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("holdingTypeInt", "holdingTypeInt", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"hol…\"holdingTypeInt\", reader)");
                        throw unexpectedNull2;
                    }
                case 4:
                    num2 = this.nullableIntAdapter.fromJson(jsonReader);
                    z3 = true;
                    break;
                case 5:
                    str = this.stringAdapter.fromJson(jsonReader);
                    if (str != null) {
                        break;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("link", "link", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"lin…ink\",\n            reader)");
                        throw unexpectedNull3;
                    }
                case 6:
                    dynamicHoldingRenewal = this.nullableDynamicHoldingRenewalAdapter.fromJson(jsonReader);
                    z4 = true;
                    break;
                case 7:
                    Boolean fromJson2 = this.booleanAdapter.fromJson(jsonReader);
                    if (fromJson2 != null) {
                        bool = Boolean.valueOf(fromJson2.booleanValue());
                        break;
                    } else {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("shouldUpdate", "shouldUpdate", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "Util.unexpectedNull(\"sho…, \"shouldUpdate\", reader)");
                        throw unexpectedNull4;
                    }
            }
        }
        jsonReader.endObject();
        UnsecuredHolding unsecuredHolding = new UnsecuredHolding();
        if (!z) {
            list = unsecuredHolding.getAssets();
        }
        unsecuredHolding.setAssets(list);
        if (holdingRecordAttributes == null) {
            holdingRecordAttributes = unsecuredHolding.getAttributes();
        }
        unsecuredHolding.setAttributes(holdingRecordAttributes);
        if (!z2) {
            dynamicHoldingDisplay = unsecuredHolding.getDisplay();
        }
        unsecuredHolding.setDisplay(dynamicHoldingDisplay);
        unsecuredHolding.setHoldingTypeInt(num != null ? num.intValue() : unsecuredHolding.getHoldingTypeInt());
        if (!z3) {
            num2 = unsecuredHolding.getId();
        }
        unsecuredHolding.setId(num2);
        if (str == null) {
            str = unsecuredHolding.getLink();
        }
        unsecuredHolding.setLink(str);
        if (!z4) {
            dynamicHoldingRenewal = unsecuredHolding.getRenewal();
        }
        unsecuredHolding.setRenewal(dynamicHoldingRenewal);
        unsecuredHolding.setShouldUpdate(bool != null ? bool.booleanValue() : unsecuredHolding.getShouldUpdate());
        return unsecuredHolding;
    }

    public void toJson(JsonWriter jsonWriter, UnsecuredHolding unsecuredHolding) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (unsecuredHolding != null) {
            jsonWriter.beginObject();
            jsonWriter.name(ShareHolding.assetDataKey);
            this.nullableListOfAssetAdapter.toJson(jsonWriter, unsecuredHolding.getAssets());
            jsonWriter.name("attributes");
            this.holdingRecordAttributesAdapter.toJson(jsonWriter, unsecuredHolding.getAttributes());
            jsonWriter.name(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
            this.nullableDynamicHoldingDisplayAdapter.toJson(jsonWriter, unsecuredHolding.getDisplay());
            jsonWriter.name("holdingTypeInt");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(unsecuredHolding.getHoldingTypeInt()));
            jsonWriter.name("id");
            this.nullableIntAdapter.toJson(jsonWriter, unsecuredHolding.getId());
            jsonWriter.name("link");
            this.stringAdapter.toJson(jsonWriter, unsecuredHolding.getLink());
            jsonWriter.name("renewal");
            this.nullableDynamicHoldingRenewalAdapter.toJson(jsonWriter, unsecuredHolding.getRenewal());
            jsonWriter.name("shouldUpdate");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(unsecuredHolding.getShouldUpdate()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
