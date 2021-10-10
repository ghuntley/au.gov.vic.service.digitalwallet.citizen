package com.digitalwallet.model;

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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/digitalwallet/model/CheckInCookieJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/model/CheckInCookie;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "constructorRef", "Ljava/lang/reflect/Constructor;", "listOfCheckInAdapter", "", "Lcom/digitalwallet/model/CheckIn;", "listOfDependantCheckInAdapter", "Lcom/digitalwallet/model/DependantCheckIn;", "nullableAttestationJwtAdapter", "Lcom/digitalwallet/model/AttestationJwt;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInCookieJsonAdapter.kt */
public final class CheckInCookieJsonAdapter extends JsonAdapter<CheckInCookie> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private volatile Constructor<CheckInCookie> constructorRef;
    private final JsonAdapter<List<CheckIn>> listOfCheckInAdapter;
    private final JsonAdapter<List<DependantCheckIn>> listOfDependantCheckInAdapter;
    private final JsonAdapter<AttestationJwt> nullableAttestationJwtAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;

    public CheckInCookieJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("pendingCheckIns", "attestation", "checkInAtLeastOnce_v2", "checkInFirstName", "checkInLastName", "checkInPhoneNumber", "checkInDependants");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"p…     \"checkInDependants\")");
        this.options = of;
        JsonAdapter<List<CheckIn>> adapter = moshi.adapter(Types.newParameterizedType(List.class, CheckIn.class), SetsKt.emptySet(), "pendingCheckIns");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…\n      \"pendingCheckIns\")");
        this.listOfCheckInAdapter = adapter;
        JsonAdapter<AttestationJwt> adapter2 = moshi.adapter(AttestationJwt.class, SetsKt.emptySet(), "attestation");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Attestatio…mptySet(), \"attestation\")");
        this.nullableAttestationJwtAdapter = adapter2;
        JsonAdapter<Boolean> adapter3 = moshi.adapter(Boolean.TYPE, SetsKt.emptySet(), "checkInAtLeastOnce");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Boolean::c…    \"checkInAtLeastOnce\")");
        this.booleanAdapter = adapter3;
        JsonAdapter<String> adapter4 = moshi.adapter(String.class, SetsKt.emptySet(), "checkInFirstName");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(String::cl…et(), \"checkInFirstName\")");
        this.nullableStringAdapter = adapter4;
        JsonAdapter<List<DependantCheckIn>> adapter5 = moshi.adapter(Types.newParameterizedType(List.class, DependantCheckIn.class), SetsKt.emptySet(), "checkInDependants");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Types.newP…t(), \"checkInDependants\")");
        this.listOfDependantCheckInAdapter = adapter5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(35);
        sb.append("GeneratedJsonAdapter(");
        sb.append("CheckInCookie");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public CheckInCookie fromJson(JsonReader jsonReader) {
        long j;
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        List<CheckIn> list = null;
        jsonReader.beginObject();
        String str = null;
        String str2 = str;
        int i = -1;
        Boolean bool = false;
        String str3 = str2;
        AttestationJwt attestationJwt = null;
        List<DependantCheckIn> list2 = list;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    continue;
                case 0:
                    list = this.listOfCheckInAdapter.fromJson(jsonReader);
                    if (list != null) {
                        j = 4294967294L;
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("pendingCheckIns", "pendingCheckIns", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"pen…pendingCheckIns\", reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    attestationJwt = this.nullableAttestationJwtAdapter.fromJson(jsonReader);
                    j = 4294967293L;
                    break;
                case 2:
                    Boolean fromJson = this.booleanAdapter.fromJson(jsonReader);
                    if (fromJson != null) {
                        bool = Boolean.valueOf(fromJson.booleanValue());
                        j = 4294967291L;
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("checkInAtLeastOnce", "checkInAtLeastOnce_v2", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"che…nAtLeastOnce_v2\", reader)");
                        throw unexpectedNull2;
                    }
                case 3:
                    str3 = this.nullableStringAdapter.fromJson(jsonReader);
                    j = 4294967287L;
                    break;
                case 4:
                    str = this.nullableStringAdapter.fromJson(jsonReader);
                    j = 4294967279L;
                    break;
                case 5:
                    str2 = this.nullableStringAdapter.fromJson(jsonReader);
                    j = 4294967263L;
                    break;
                case 6:
                    list2 = this.listOfDependantCheckInAdapter.fromJson(jsonReader);
                    if (list2 != null) {
                        j = 4294967231L;
                        break;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("checkInDependants", "checkInDependants", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"che…eckInDependants\", reader)");
                        throw unexpectedNull3;
                    }
            }
            i &= (int) j;
        }
        jsonReader.endObject();
        Constructor<CheckInCookie> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = CheckInCookie.class.getDeclaredConstructor(List.class, AttestationJwt.class, Boolean.TYPE, String.class, String.class, String.class, List.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "CheckInCookie::class.jav…his.constructorRef = it }");
        }
        CheckInCookie newInstance = constructor.newInstance(list, attestationJwt, bool, str3, str, str2, list2, Integer.valueOf(i), null);
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…mask0,\n        null\n    )");
        return newInstance;
    }

    public void toJson(JsonWriter jsonWriter, CheckInCookie checkInCookie) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (checkInCookie != null) {
            jsonWriter.beginObject();
            jsonWriter.name("pendingCheckIns");
            this.listOfCheckInAdapter.toJson(jsonWriter, checkInCookie.getPendingCheckIns());
            jsonWriter.name("attestation");
            this.nullableAttestationJwtAdapter.toJson(jsonWriter, checkInCookie.getAttestation());
            jsonWriter.name("checkInAtLeastOnce_v2");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(checkInCookie.getCheckInAtLeastOnce()));
            jsonWriter.name("checkInFirstName");
            this.nullableStringAdapter.toJson(jsonWriter, checkInCookie.getCheckInFirstName());
            jsonWriter.name("checkInLastName");
            this.nullableStringAdapter.toJson(jsonWriter, checkInCookie.getCheckInLastName());
            jsonWriter.name("checkInPhoneNumber");
            this.nullableStringAdapter.toJson(jsonWriter, checkInCookie.getCheckInPhoneNumber());
            jsonWriter.name("checkInDependants");
            this.listOfDependantCheckInAdapter.toJson(jsonWriter, checkInCookie.getCheckInDependants());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
