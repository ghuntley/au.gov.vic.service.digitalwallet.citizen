package com.digitalwallet.app.model.login;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.ResponseTypeValues;
import net.openid.appauth.TokenRequest;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/model/login/VerifyOTPRequestPayloadJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/login/VerifyOTPRequestPayload;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "devicePrintAdapter", "Lcom/digitalwallet/app/model/login/DevicePrint;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: VerifyOTPRequestPayloadJsonAdapter.kt */
public final class VerifyOTPRequestPayloadJsonAdapter extends JsonAdapter<VerifyOTPRequestPayload> {
    private final JsonAdapter<DevicePrint> devicePrintAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public VerifyOTPRequestPayloadJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("email", "sessionID", ResponseTypeValues.CODE, "id", TokenRequest.GRANT_TYPE_PASSWORD, "firstName", "lastName", "devicePrint");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"e…lastName\", \"devicePrint\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "email");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…mptySet(),\n      \"email\")");
        this.stringAdapter = adapter;
        JsonAdapter<DevicePrint> adapter2 = moshi.adapter(DevicePrint.class, SetsKt.emptySet(), "devicePrint");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(DevicePrin…mptySet(), \"devicePrint\")");
        this.devicePrintAdapter = adapter2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(45);
        sb.append("GeneratedJsonAdapter(");
        sb.append("VerifyOTPRequestPayload");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.squareup.moshi.JsonAdapter
    public VerifyOTPRequestPayload fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        DevicePrint devicePrint = null;
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        String str7 = str6;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    devicePrint = devicePrint;
                    str7 = str7;
                    break;
                case 0:
                    String fromJson = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson != null) {
                        str = fromJson;
                        devicePrint = devicePrint;
                        str7 = str7;
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("email", "email", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"ema…ail\",\n            reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    String fromJson2 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson2 != null) {
                        str2 = fromJson2;
                        devicePrint = devicePrint;
                        str7 = str7;
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("sessionID", "sessionID", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"ses…     \"sessionID\", reader)");
                        throw unexpectedNull2;
                    }
                case 2:
                    String fromJson3 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson3 != null) {
                        str3 = fromJson3;
                        devicePrint = devicePrint;
                        str7 = str7;
                        break;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull(ResponseTypeValues.CODE, ResponseTypeValues.CODE, jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"cod…ode\",\n            reader)");
                        throw unexpectedNull3;
                    }
                case 3:
                    String fromJson4 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson4 != null) {
                        str4 = fromJson4;
                        devicePrint = devicePrint;
                        str7 = str7;
                        break;
                    } else {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("id", "id", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "Util.unexpectedNull(\"id\", \"id\", reader)");
                        throw unexpectedNull4;
                    }
                case 4:
                    String fromJson5 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson5 != null) {
                        str5 = fromJson5;
                        devicePrint = devicePrint;
                        str7 = str7;
                        break;
                    } else {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull(TokenRequest.GRANT_TYPE_PASSWORD, TokenRequest.GRANT_TYPE_PASSWORD, jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "Util.unexpectedNull(\"pas…      \"password\", reader)");
                        throw unexpectedNull5;
                    }
                case 5:
                    String fromJson6 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson6 != null) {
                        str6 = fromJson6;
                        devicePrint = devicePrint;
                        str7 = str7;
                        continue;
                    } else {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull("firstName", "firstName", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "Util.unexpectedNull(\"fir…     \"firstName\", reader)");
                        throw unexpectedNull6;
                    }
                case 6:
                    String fromJson7 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson7 != null) {
                        str7 = fromJson7;
                        devicePrint = devicePrint;
                        break;
                    } else {
                        JsonDataException unexpectedNull7 = Util.unexpectedNull("lastName", "lastName", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull7, "Util.unexpectedNull(\"las…      \"lastName\", reader)");
                        throw unexpectedNull7;
                    }
                case 7:
                    DevicePrint fromJson8 = this.devicePrintAdapter.fromJson(jsonReader);
                    if (fromJson8 != null) {
                        devicePrint = fromJson8;
                        str7 = str7;
                        break;
                    } else {
                        JsonDataException unexpectedNull8 = Util.unexpectedNull("devicePrint", "devicePrint", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull8, "Util.unexpectedNull(\"dev…\", \"devicePrint\", reader)");
                        throw unexpectedNull8;
                    }
                default:
                    devicePrint = devicePrint;
                    str7 = str7;
                    break;
            }
            str6 = str6;
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("email", "email", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"email\", \"email\", reader)");
            throw missingProperty;
        } else if (str2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("sessionID", "sessionID", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"se…ID\", \"sessionID\", reader)");
            throw missingProperty2;
        } else if (str3 == null) {
            JsonDataException missingProperty3 = Util.missingProperty(ResponseTypeValues.CODE, ResponseTypeValues.CODE, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"code\", \"code\", reader)");
            throw missingProperty3;
        } else if (str4 == null) {
            JsonDataException missingProperty4 = Util.missingProperty("id", "id", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "Util.missingProperty(\"id\", \"id\", reader)");
            throw missingProperty4;
        } else if (str5 == null) {
            JsonDataException missingProperty5 = Util.missingProperty(TokenRequest.GRANT_TYPE_PASSWORD, TokenRequest.GRANT_TYPE_PASSWORD, jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty5, "Util.missingProperty(\"pa…ord\", \"password\", reader)");
            throw missingProperty5;
        } else if (str6 == null) {
            JsonDataException missingProperty6 = Util.missingProperty("firstName", "firstName", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty6, "Util.missingProperty(\"fi…me\", \"firstName\", reader)");
            throw missingProperty6;
        } else if (str7 == null) {
            JsonDataException missingProperty7 = Util.missingProperty("lastName", "lastName", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty7, "Util.missingProperty(\"la…ame\", \"lastName\", reader)");
            throw missingProperty7;
        } else if (devicePrint != null) {
            return new VerifyOTPRequestPayload(str, str2, str3, str4, str5, str6, str7, devicePrint);
        } else {
            JsonDataException missingProperty8 = Util.missingProperty("devicePrint", "devicePrint", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty8, "Util.missingProperty(\"de…int\",\n            reader)");
            throw missingProperty8;
        }
    }

    public void toJson(JsonWriter jsonWriter, VerifyOTPRequestPayload verifyOTPRequestPayload) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (verifyOTPRequestPayload != null) {
            jsonWriter.beginObject();
            jsonWriter.name("email");
            this.stringAdapter.toJson(jsonWriter, verifyOTPRequestPayload.getEmail());
            jsonWriter.name("sessionID");
            this.stringAdapter.toJson(jsonWriter, verifyOTPRequestPayload.getSessionID());
            jsonWriter.name(ResponseTypeValues.CODE);
            this.stringAdapter.toJson(jsonWriter, verifyOTPRequestPayload.getCode());
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, verifyOTPRequestPayload.getId());
            jsonWriter.name(TokenRequest.GRANT_TYPE_PASSWORD);
            this.stringAdapter.toJson(jsonWriter, verifyOTPRequestPayload.getPassword());
            jsonWriter.name("firstName");
            this.stringAdapter.toJson(jsonWriter, verifyOTPRequestPayload.getFirstName());
            jsonWriter.name("lastName");
            this.stringAdapter.toJson(jsonWriter, verifyOTPRequestPayload.getLastName());
            jsonWriter.name("devicePrint");
            this.devicePrintAdapter.toJson(jsonWriter, verifyOTPRequestPayload.getDevicePrint());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
