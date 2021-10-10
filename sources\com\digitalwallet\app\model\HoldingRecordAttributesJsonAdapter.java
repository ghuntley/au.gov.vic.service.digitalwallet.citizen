package com.digitalwallet.app.model;

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
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010!\u001a\u00020\u0012H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/digitalwallet/app/model/HoldingRecordAttributesJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/HoldingRecordAttributes;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "listOfHoldingAddressAdapter", "", "Lcom/digitalwallet/app/model/HoldingAddress;", "listOfHoldingEmailAdapter", "Lcom/digitalwallet/app/model/HoldingEmail;", "listOfHoldingPhoneAdapter", "Lcom/digitalwallet/app/model/HoldingPhone;", "listOfKangarooHarvesterQuotaAdapter", "Lcom/digitalwallet/app/model/KangarooHarvesterQuota;", "listOfStringAdapter", "", "nullableAuthorityAdapter", "Lcom/digitalwallet/app/model/Authority;", "nullableStringAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HoldingRecordAttributesJsonAdapter.kt */
public final class HoldingRecordAttributesJsonAdapter extends JsonAdapter<HoldingRecordAttributes> {
    private volatile Constructor<HoldingRecordAttributes> constructorRef;
    private final JsonAdapter<List<HoldingAddress>> listOfHoldingAddressAdapter;
    private final JsonAdapter<List<HoldingEmail>> listOfHoldingEmailAdapter;
    private final JsonAdapter<List<HoldingPhone>> listOfHoldingPhoneAdapter;
    private final JsonAdapter<List<KangarooHarvesterQuota>> listOfKangarooHarvesterQuotaAdapter;
    private final JsonAdapter<List<String>> listOfStringAdapter;
    private final JsonAdapter<Authority> nullableAuthorityAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public HoldingRecordAttributesJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("permissions", "authority", "type", "subType", "subtype", "domain", "expiry", "firstName", "lastName", "name", "dateOfBirth", "state", "emailContacts", "phoneContacts", "addresses", "agencyIdentifier", "kind", "startDateTime", "length", "solarHotWater", "gridConnect", "battery", "standAlone", "licenceConditions", "licenceClass", "quotas", RequestHolding.sharingCodeKey);
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"p… \"quotas\", \"sharingCode\")");
        this.options = of;
        JsonAdapter<List<String>> adapter = moshi.adapter(Types.newParameterizedType(List.class, String.class), SetsKt.emptySet(), "permissions");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…t(),\n      \"permissions\")");
        this.listOfStringAdapter = adapter;
        JsonAdapter<Authority> adapter2 = moshi.adapter(Authority.class, SetsKt.emptySet(), "authority");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Authority:… emptySet(), \"authority\")");
        this.nullableAuthorityAdapter = adapter2;
        JsonAdapter<String> adapter3 = moshi.adapter(String.class, SetsKt.emptySet(), "type");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(String::cl…emptySet(),\n      \"type\")");
        this.stringAdapter = adapter3;
        JsonAdapter<List<HoldingEmail>> adapter4 = moshi.adapter(Types.newParameterizedType(List.class, HoldingEmail.class), SetsKt.emptySet(), "emailContact");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Types.newP…ptySet(), \"emailContact\")");
        this.listOfHoldingEmailAdapter = adapter4;
        JsonAdapter<List<HoldingPhone>> adapter5 = moshi.adapter(Types.newParameterizedType(List.class, HoldingPhone.class), SetsKt.emptySet(), "phoneContact");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Types.newP…ptySet(), \"phoneContact\")");
        this.listOfHoldingPhoneAdapter = adapter5;
        JsonAdapter<List<HoldingAddress>> adapter6 = moshi.adapter(Types.newParameterizedType(List.class, HoldingAddress.class), SetsKt.emptySet(), "addresses");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Types.newP… emptySet(), \"addresses\")");
        this.listOfHoldingAddressAdapter = adapter6;
        JsonAdapter<List<KangarooHarvesterQuota>> adapter7 = moshi.adapter(Types.newParameterizedType(List.class, KangarooHarvesterQuota.class), SetsKt.emptySet(), "quotas");
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(Types.newP…a), emptySet(), \"quotas\")");
        this.listOfKangarooHarvesterQuotaAdapter = adapter7;
        JsonAdapter<String> adapter8 = moshi.adapter(String.class, SetsKt.emptySet(), RequestHolding.sharingCodeKey);
        Intrinsics.checkNotNullExpressionValue(adapter8, "moshi.adapter(String::cl…mptySet(), \"sharingCode\")");
        this.nullableStringAdapter = adapter8;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(45);
        sb.append("GeneratedJsonAdapter(");
        sb.append("HoldingRecordAttributes");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public HoldingRecordAttributes fromJson(JsonReader jsonReader) {
        List<String> list;
        List<String> list2;
        int i;
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        List<String> list3 = null;
        jsonReader.beginObject();
        List<KangarooHarvesterQuota> list4 = list3;
        Authority authority = null;
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        String str7 = str6;
        String str8 = str7;
        String str9 = str8;
        String str10 = str9;
        String str11 = str10;
        String str12 = str11;
        String str13 = str12;
        String str14 = str13;
        String str15 = str14;
        String str16 = str15;
        String str17 = str16;
        String str18 = str17;
        String str19 = str18;
        String str20 = str19;
        String str21 = str20;
        int i2 = -1;
        List<HoldingEmail> list5 = list4;
        List<HoldingPhone> list6 = list5;
        List<HoldingAddress> list7 = list6;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(this.options)) {
                case -1:
                    list2 = list7;
                    list = list4;
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    List<String> fromJson = this.listOfStringAdapter.fromJson(jsonReader);
                    if (fromJson != null) {
                        i2 &= (int) 4294967294L;
                        list7 = list7;
                        list4 = list4;
                        list3 = fromJson;
                        continue;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("permissions", "permissions", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"per…\", \"permissions\", reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    list2 = list7;
                    list = list4;
                    i = i2 & ((int) 4294967293L);
                    authority = this.nullableAuthorityAdapter.fromJson(jsonReader);
                    i2 = i;
                    break;
                case 2:
                    list2 = list7;
                    list = list4;
                    String fromJson2 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson2 != null) {
                        i = i2 & ((int) 4294967291L);
                        str = fromJson2;
                        i2 = i;
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("type", "type", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"type\", \"type\", reader)");
                        throw unexpectedNull2;
                    }
                case 3:
                    list2 = list7;
                    list = list4;
                    String fromJson3 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson3 != null) {
                        i = i2 & ((int) 4294967287L);
                        str2 = fromJson3;
                        i2 = i;
                        break;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("deprecatedSubType", "subType", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"dep…Type\", \"subType\", reader)");
                        throw unexpectedNull3;
                    }
                case 4:
                    list2 = list7;
                    list = list4;
                    String fromJson4 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson4 != null) {
                        i = i2 & ((int) 4294967279L);
                        str3 = fromJson4;
                        i2 = i;
                        break;
                    } else {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("subtype", "subtype", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "Util.unexpectedNull(\"sub…       \"subtype\", reader)");
                        throw unexpectedNull4;
                    }
                case 5:
                    list2 = list7;
                    list = list4;
                    String fromJson5 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson5 != null) {
                        i = i2 & ((int) 4294967263L);
                        str4 = fromJson5;
                        i2 = i;
                        break;
                    } else {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("domain", "domain", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "Util.unexpectedNull(\"dom…n\",\n              reader)");
                        throw unexpectedNull5;
                    }
                case 6:
                    list2 = list7;
                    list = list4;
                    String fromJson6 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson6 != null) {
                        i = i2 & ((int) 4294967231L);
                        str5 = fromJson6;
                        i2 = i;
                        break;
                    } else {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull("expiry", "expiry", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "Util.unexpectedNull(\"exp…y\",\n              reader)");
                        throw unexpectedNull6;
                    }
                case 7:
                    list2 = list7;
                    list = list4;
                    String fromJson7 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson7 != null) {
                        i = i2 & ((int) 4294967167L);
                        str6 = fromJson7;
                        i2 = i;
                        break;
                    } else {
                        JsonDataException unexpectedNull7 = Util.unexpectedNull("_firstName", "firstName", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull7, "Util.unexpectedNull(\"_fi…     \"firstName\", reader)");
                        throw unexpectedNull7;
                    }
                case 8:
                    list2 = list7;
                    list = list4;
                    String fromJson8 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson8 != null) {
                        i = i2 & ((int) 4294967039L);
                        str7 = fromJson8;
                        i2 = i;
                        break;
                    } else {
                        JsonDataException unexpectedNull8 = Util.unexpectedNull("_lastName", "lastName", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull8, "Util.unexpectedNull(\"_la…      \"lastName\", reader)");
                        throw unexpectedNull8;
                    }
                case 9:
                    list2 = list7;
                    list = list4;
                    String fromJson9 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson9 != null) {
                        i = i2 & ((int) 4294966783L);
                        str8 = fromJson9;
                        i2 = i;
                        break;
                    } else {
                        JsonDataException unexpectedNull9 = Util.unexpectedNull("name", "name", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull9, "Util.unexpectedNull(\"name\", \"name\", reader)");
                        throw unexpectedNull9;
                    }
                case 10:
                    list2 = list7;
                    list = list4;
                    String fromJson10 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson10 != null) {
                        i = i2 & ((int) 4294966271L);
                        str9 = fromJson10;
                        i2 = i;
                        break;
                    } else {
                        JsonDataException unexpectedNull10 = Util.unexpectedNull("dateOfBirth", "dateOfBirth", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull10, "Util.unexpectedNull(\"dat…   \"dateOfBirth\", reader)");
                        throw unexpectedNull10;
                    }
                case 11:
                    list2 = list7;
                    list = list4;
                    String fromJson11 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson11 != null) {
                        i = i2 & ((int) 4294965247L);
                        str10 = fromJson11;
                        i2 = i;
                        break;
                    } else {
                        JsonDataException unexpectedNull11 = Util.unexpectedNull("holdingState", "state", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull11, "Util.unexpectedNull(\"hol…         \"state\", reader)");
                        throw unexpectedNull11;
                    }
                case 12:
                    List<HoldingEmail> fromJson12 = this.listOfHoldingEmailAdapter.fromJson(jsonReader);
                    if (fromJson12 != null) {
                        i2 &= (int) 4294963199L;
                        list7 = list7;
                        list4 = list4;
                        list5 = fromJson12;
                        continue;
                    } else {
                        JsonDataException unexpectedNull12 = Util.unexpectedNull("emailContact", "emailContacts", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull12, "Util.unexpectedNull(\"ema… \"emailContacts\", reader)");
                        throw unexpectedNull12;
                    }
                case 13:
                    List<HoldingPhone> fromJson13 = this.listOfHoldingPhoneAdapter.fromJson(jsonReader);
                    if (fromJson13 != null) {
                        i2 &= (int) 4294959103L;
                        list7 = list7;
                        list4 = list4;
                        list6 = fromJson13;
                        continue;
                    } else {
                        JsonDataException unexpectedNull13 = Util.unexpectedNull("phoneContact", "phoneContacts", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull13, "Util.unexpectedNull(\"pho… \"phoneContacts\", reader)");
                        throw unexpectedNull13;
                    }
                case 14:
                    List<HoldingAddress> fromJson14 = this.listOfHoldingAddressAdapter.fromJson(jsonReader);
                    if (fromJson14 != null) {
                        i2 &= (int) 4294950911L;
                        list4 = list4;
                        list7 = fromJson14;
                        continue;
                    } else {
                        JsonDataException unexpectedNull14 = Util.unexpectedNull("addresses", "addresses", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull14, "Util.unexpectedNull(\"add…es\", \"addresses\", reader)");
                        throw unexpectedNull14;
                    }
                case 15:
                    list2 = list7;
                    list = list4;
                    String fromJson15 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson15 != null) {
                        i = i2 & ((int) 4294934527L);
                        str11 = fromJson15;
                        i2 = i;
                        break;
                    } else {
                        JsonDataException unexpectedNull15 = Util.unexpectedNull("identifier", "agencyIdentifier", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull15, "Util.unexpectedNull(\"ide…gencyIdentifier\", reader)");
                        throw unexpectedNull15;
                    }
                case 16:
                    list2 = list7;
                    list = list4;
                    String fromJson16 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson16 != null) {
                        i = i2 & ((int) 4294901759L);
                        str12 = fromJson16;
                        i2 = i;
                        break;
                    } else {
                        JsonDataException unexpectedNull16 = Util.unexpectedNull("licenceKind", "kind", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull16, "Util.unexpectedNull(\"lic…          \"kind\", reader)");
                        throw unexpectedNull16;
                    }
                case 17:
                    list2 = list7;
                    list = list4;
                    String fromJson17 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson17 != null) {
                        i = i2 & ((int) 4294836223L);
                        str13 = fromJson17;
                        i2 = i;
                        break;
                    } else {
                        JsonDataException unexpectedNull17 = Util.unexpectedNull("startDateTime", "startDateTime", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull17, "Util.unexpectedNull(\"sta… \"startDateTime\", reader)");
                        throw unexpectedNull17;
                    }
                case 18:
                    list2 = list7;
                    list = list4;
                    String fromJson18 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson18 != null) {
                        i = i2 & ((int) 4294705151L);
                        str14 = fromJson18;
                        i2 = i;
                        break;
                    } else {
                        JsonDataException unexpectedNull18 = Util.unexpectedNull("length", "length", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull18, "Util.unexpectedNull(\"len…h\",\n              reader)");
                        throw unexpectedNull18;
                    }
                case 19:
                    list2 = list7;
                    list = list4;
                    String fromJson19 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson19 != null) {
                        i = i2 & ((int) 4294443007L);
                        str15 = fromJson19;
                        i2 = i;
                        break;
                    } else {
                        JsonDataException unexpectedNull19 = Util.unexpectedNull("strSolarHotWater", "solarHotWater", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull19, "Util.unexpectedNull(\"str… \"solarHotWater\", reader)");
                        throw unexpectedNull19;
                    }
                case 20:
                    list2 = list7;
                    list = list4;
                    String fromJson20 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson20 != null) {
                        i = i2 & ((int) 4293918719L);
                        str16 = fromJson20;
                        i2 = i;
                        break;
                    } else {
                        JsonDataException unexpectedNull20 = Util.unexpectedNull("strGridConnect", "gridConnect", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull20, "Util.unexpectedNull(\"str…\", \"gridConnect\", reader)");
                        throw unexpectedNull20;
                    }
                case 21:
                    list2 = list7;
                    list = list4;
                    String fromJson21 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson21 != null) {
                        i = i2 & ((int) 4292870143L);
                        str17 = fromJson21;
                        i2 = i;
                        break;
                    } else {
                        JsonDataException unexpectedNull21 = Util.unexpectedNull("strBattery", "battery", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull21, "Util.unexpectedNull(\"str…       \"battery\", reader)");
                        throw unexpectedNull21;
                    }
                case 22:
                    list2 = list7;
                    list = list4;
                    String fromJson22 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson22 != null) {
                        i = i2 & ((int) 4290772991L);
                        str18 = fromJson22;
                        i2 = i;
                        break;
                    } else {
                        JsonDataException unexpectedNull22 = Util.unexpectedNull("strStandAlone", "standAlone", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull22, "Util.unexpectedNull(\"str…e\", \"standAlone\", reader)");
                        throw unexpectedNull22;
                    }
                case 23:
                    list2 = list7;
                    list = list4;
                    String fromJson23 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson23 != null) {
                        i = i2 & ((int) 4286578687L);
                        str19 = fromJson23;
                        i2 = i;
                        break;
                    } else {
                        JsonDataException unexpectedNull23 = Util.unexpectedNull("licenceConditions", "licenceConditions", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull23, "Util.unexpectedNull(\"lic…cenceConditions\", reader)");
                        throw unexpectedNull23;
                    }
                case 24:
                    list2 = list7;
                    list = list4;
                    String fromJson24 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson24 != null) {
                        i = i2 & ((int) 4278190079L);
                        str20 = fromJson24;
                        i2 = i;
                        break;
                    } else {
                        JsonDataException unexpectedNull24 = Util.unexpectedNull("licenceClass", "licenceClass", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull24, "Util.unexpectedNull(\"lic…  \"licenceClass\", reader)");
                        throw unexpectedNull24;
                    }
                case 25:
                    List<KangarooHarvesterQuota> fromJson25 = this.listOfKangarooHarvesterQuotaAdapter.fromJson(jsonReader);
                    if (fromJson25 != null) {
                        list4 = fromJson25;
                        i2 &= (int) 4261412863L;
                        list7 = list7;
                        continue;
                    } else {
                        JsonDataException unexpectedNull25 = Util.unexpectedNull("quotas", "quotas", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull25, "Util.unexpectedNull(\"quotas\", \"quotas\", reader)");
                        throw unexpectedNull25;
                    }
                case 26:
                    list2 = list7;
                    list = list4;
                    i = i2 & ((int) 4227858431L);
                    str21 = this.nullableStringAdapter.fromJson(jsonReader);
                    i2 = i;
                    break;
                default:
                    list2 = list7;
                    list = list4;
                    break;
            }
            list7 = list2;
            list4 = list;
        }
        jsonReader.endObject();
        Constructor<HoldingRecordAttributes> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = HoldingRecordAttributes.class.getDeclaredConstructor(List.class, Authority.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, List.class, List.class, List.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, List.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            Unit unit = Unit.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(constructor, "HoldingRecordAttributes:…his.constructorRef = it }");
        }
        HoldingRecordAttributes newInstance = constructor.newInstance(list3, authority, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, list5, list6, list7, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, list4, str21, Integer.valueOf(i2), null);
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…mask0,\n        null\n    )");
        return newInstance;
    }

    public void toJson(JsonWriter jsonWriter, HoldingRecordAttributes holdingRecordAttributes) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (holdingRecordAttributes != null) {
            jsonWriter.beginObject();
            jsonWriter.name("permissions");
            this.listOfStringAdapter.toJson(jsonWriter, holdingRecordAttributes.getPermissions());
            jsonWriter.name("authority");
            this.nullableAuthorityAdapter.toJson(jsonWriter, holdingRecordAttributes.getAuthority());
            jsonWriter.name("type");
            this.stringAdapter.toJson(jsonWriter, holdingRecordAttributes.getType());
            jsonWriter.name("subType");
            this.stringAdapter.toJson(jsonWriter, holdingRecordAttributes.getDeprecatedSubType());
            jsonWriter.name("subtype");
            this.stringAdapter.toJson(jsonWriter, holdingRecordAttributes.getSubtype());
            jsonWriter.name("domain");
            this.stringAdapter.toJson(jsonWriter, holdingRecordAttributes.getDomain());
            jsonWriter.name("expiry");
            this.stringAdapter.toJson(jsonWriter, holdingRecordAttributes.getExpiry());
            jsonWriter.name("firstName");
            this.stringAdapter.toJson(jsonWriter, holdingRecordAttributes.get_firstName());
            jsonWriter.name("lastName");
            this.stringAdapter.toJson(jsonWriter, holdingRecordAttributes.get_lastName());
            jsonWriter.name("name");
            this.stringAdapter.toJson(jsonWriter, holdingRecordAttributes.getName());
            jsonWriter.name("dateOfBirth");
            this.stringAdapter.toJson(jsonWriter, holdingRecordAttributes.getDateOfBirth());
            jsonWriter.name("state");
            this.stringAdapter.toJson(jsonWriter, holdingRecordAttributes.getHoldingState());
            jsonWriter.name("emailContacts");
            this.listOfHoldingEmailAdapter.toJson(jsonWriter, holdingRecordAttributes.getEmailContact());
            jsonWriter.name("phoneContacts");
            this.listOfHoldingPhoneAdapter.toJson(jsonWriter, holdingRecordAttributes.getPhoneContact());
            jsonWriter.name("addresses");
            this.listOfHoldingAddressAdapter.toJson(jsonWriter, holdingRecordAttributes.getAddresses());
            jsonWriter.name("agencyIdentifier");
            this.stringAdapter.toJson(jsonWriter, holdingRecordAttributes.getIdentifier());
            jsonWriter.name("kind");
            this.stringAdapter.toJson(jsonWriter, holdingRecordAttributes.getLicenceKind());
            jsonWriter.name("startDateTime");
            this.stringAdapter.toJson(jsonWriter, holdingRecordAttributes.getStartDateTime());
            jsonWriter.name("length");
            this.stringAdapter.toJson(jsonWriter, holdingRecordAttributes.getLength());
            jsonWriter.name("solarHotWater");
            this.stringAdapter.toJson(jsonWriter, holdingRecordAttributes.getStrSolarHotWater());
            jsonWriter.name("gridConnect");
            this.stringAdapter.toJson(jsonWriter, holdingRecordAttributes.getStrGridConnect());
            jsonWriter.name("battery");
            this.stringAdapter.toJson(jsonWriter, holdingRecordAttributes.getStrBattery());
            jsonWriter.name("standAlone");
            this.stringAdapter.toJson(jsonWriter, holdingRecordAttributes.getStrStandAlone());
            jsonWriter.name("licenceConditions");
            this.stringAdapter.toJson(jsonWriter, holdingRecordAttributes.getLicenceConditions());
            jsonWriter.name("licenceClass");
            this.stringAdapter.toJson(jsonWriter, holdingRecordAttributes.getLicenceClass());
            jsonWriter.name("quotas");
            this.listOfKangarooHarvesterQuotaAdapter.toJson(jsonWriter, holdingRecordAttributes.getQuotas());
            jsonWriter.name(RequestHolding.sharingCodeKey);
            this.nullableStringAdapter.toJson(jsonWriter, holdingRecordAttributes.getSharingCode());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
