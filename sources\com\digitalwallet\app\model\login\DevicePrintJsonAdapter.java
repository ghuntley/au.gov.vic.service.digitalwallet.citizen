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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/digitalwallet/app/model/login/DevicePrintJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/digitalwallet/app/model/login/DevicePrint;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "devicePrintFontsAdapter", "Lcom/digitalwallet/app/model/login/DevicePrintFonts;", "devicePrintPluginsAdapter", "Lcom/digitalwallet/app/model/login/DevicePrintPlugins;", "devicePrintScreenAdapter", "Lcom/digitalwallet/app/model/login/DevicePrintScreen;", "devicePrintTimezoneAdapter", "Lcom/digitalwallet/app/model/login/DevicePrintTimezone;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: DevicePrintJsonAdapter.kt */
public final class DevicePrintJsonAdapter extends JsonAdapter<DevicePrint> {
    private final JsonAdapter<DevicePrintFonts> devicePrintFontsAdapter;
    private final JsonAdapter<DevicePrintPlugins> devicePrintPluginsAdapter;
    private final JsonAdapter<DevicePrintScreen> devicePrintScreenAdapter;
    private final JsonAdapter<DevicePrintTimezone> devicePrintTimezoneAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public DevicePrintJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("deviceId", "screen", "timezone", "plugins", "fonts", "userAgent", "appName", "appCodeName", "appVersion", "platform", "product", "productSub", "vendor", "language");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"d…b\", \"vendor\", \"language\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "deviceId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…ySet(),\n      \"deviceId\")");
        this.stringAdapter = adapter;
        JsonAdapter<DevicePrintScreen> adapter2 = moshi.adapter(DevicePrintScreen.class, SetsKt.emptySet(), "screen");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(DevicePrin…va, emptySet(), \"screen\")");
        this.devicePrintScreenAdapter = adapter2;
        JsonAdapter<DevicePrintTimezone> adapter3 = moshi.adapter(DevicePrintTimezone.class, SetsKt.emptySet(), "timezone");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(DevicePrin…, emptySet(), \"timezone\")");
        this.devicePrintTimezoneAdapter = adapter3;
        JsonAdapter<DevicePrintPlugins> adapter4 = moshi.adapter(DevicePrintPlugins.class, SetsKt.emptySet(), "plugins");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(DevicePrin…a, emptySet(), \"plugins\")");
        this.devicePrintPluginsAdapter = adapter4;
        JsonAdapter<DevicePrintFonts> adapter5 = moshi.adapter(DevicePrintFonts.class, SetsKt.emptySet(), "fonts");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(DevicePrin…ava, emptySet(), \"fonts\")");
        this.devicePrintFontsAdapter = adapter5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(33);
        sb.append("GeneratedJsonAdapter(");
        sb.append("DevicePrint");
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.squareup.moshi.JsonAdapter
    public DevicePrint fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        DevicePrintFonts devicePrintFonts = null;
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
        DevicePrintScreen devicePrintScreen = null;
        DevicePrintTimezone devicePrintTimezone = null;
        DevicePrintPlugins devicePrintPlugins = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    str4 = str4;
                    str3 = str3;
                    str2 = str2;
                    devicePrintFonts = devicePrintFonts;
                    devicePrintPlugins = devicePrintPlugins;
                    devicePrintTimezone = devicePrintTimezone;
                    devicePrintScreen = devicePrintScreen;
                    break;
                case 0:
                    String fromJson = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson != null) {
                        str = fromJson;
                        str4 = str4;
                        str3 = str3;
                        str2 = str2;
                        devicePrintFonts = devicePrintFonts;
                        devicePrintPlugins = devicePrintPlugins;
                        devicePrintTimezone = devicePrintTimezone;
                        devicePrintScreen = devicePrintScreen;
                        continue;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("deviceId", "deviceId", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "Util.unexpectedNull(\"dev…      \"deviceId\", reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    DevicePrintScreen fromJson2 = this.devicePrintScreenAdapter.fromJson(jsonReader);
                    if (fromJson2 != null) {
                        devicePrintScreen = fromJson2;
                        str4 = str4;
                        str3 = str3;
                        str2 = str2;
                        devicePrintFonts = devicePrintFonts;
                        devicePrintPlugins = devicePrintPlugins;
                        devicePrintTimezone = devicePrintTimezone;
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("screen", "screen", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "Util.unexpectedNull(\"screen\", \"screen\", reader)");
                        throw unexpectedNull2;
                    }
                case 2:
                    DevicePrintTimezone fromJson3 = this.devicePrintTimezoneAdapter.fromJson(jsonReader);
                    if (fromJson3 != null) {
                        devicePrintTimezone = fromJson3;
                        str4 = str4;
                        str3 = str3;
                        str2 = str2;
                        devicePrintFonts = devicePrintFonts;
                        devicePrintPlugins = devicePrintPlugins;
                        devicePrintScreen = devicePrintScreen;
                        break;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("timezone", "timezone", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "Util.unexpectedNull(\"tim…one\", \"timezone\", reader)");
                        throw unexpectedNull3;
                    }
                case 3:
                    DevicePrintPlugins fromJson4 = this.devicePrintPluginsAdapter.fromJson(jsonReader);
                    if (fromJson4 != null) {
                        devicePrintPlugins = fromJson4;
                        str4 = str4;
                        str3 = str3;
                        str2 = str2;
                        devicePrintFonts = devicePrintFonts;
                        devicePrintTimezone = devicePrintTimezone;
                        devicePrintScreen = devicePrintScreen;
                        break;
                    } else {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("plugins", "plugins", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "Util.unexpectedNull(\"plugins\", \"plugins\", reader)");
                        throw unexpectedNull4;
                    }
                case 4:
                    DevicePrintFonts fromJson5 = this.devicePrintFontsAdapter.fromJson(jsonReader);
                    if (fromJson5 != null) {
                        devicePrintFonts = fromJson5;
                        str4 = str4;
                        str3 = str3;
                        str2 = str2;
                        devicePrintPlugins = devicePrintPlugins;
                        devicePrintTimezone = devicePrintTimezone;
                        devicePrintScreen = devicePrintScreen;
                        break;
                    } else {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("fonts", "fonts", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "Util.unexpectedNull(\"fon…         \"fonts\", reader)");
                        throw unexpectedNull5;
                    }
                case 5:
                    String fromJson6 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson6 != null) {
                        str2 = fromJson6;
                        str4 = str4;
                        str3 = str3;
                        devicePrintFonts = devicePrintFonts;
                        devicePrintPlugins = devicePrintPlugins;
                        devicePrintTimezone = devicePrintTimezone;
                        devicePrintScreen = devicePrintScreen;
                        break;
                    } else {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull("userAgent", "userAgent", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "Util.unexpectedNull(\"use…     \"userAgent\", reader)");
                        throw unexpectedNull6;
                    }
                case 6:
                    String fromJson7 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson7 != null) {
                        str3 = fromJson7;
                        str4 = str4;
                        str2 = str2;
                        devicePrintFonts = devicePrintFonts;
                        devicePrintPlugins = devicePrintPlugins;
                        devicePrintTimezone = devicePrintTimezone;
                        devicePrintScreen = devicePrintScreen;
                        break;
                    } else {
                        JsonDataException unexpectedNull7 = Util.unexpectedNull("appName", "appName", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull7, "Util.unexpectedNull(\"app…       \"appName\", reader)");
                        throw unexpectedNull7;
                    }
                case 7:
                    String fromJson8 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson8 != null) {
                        str4 = fromJson8;
                        str3 = str3;
                        str2 = str2;
                        devicePrintFonts = devicePrintFonts;
                        devicePrintPlugins = devicePrintPlugins;
                        devicePrintTimezone = devicePrintTimezone;
                        devicePrintScreen = devicePrintScreen;
                        break;
                    } else {
                        JsonDataException unexpectedNull8 = Util.unexpectedNull("appCodeName", "appCodeName", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull8, "Util.unexpectedNull(\"app…\", \"appCodeName\", reader)");
                        throw unexpectedNull8;
                    }
                case 8:
                    String fromJson9 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson9 != null) {
                        str5 = fromJson9;
                        str4 = str4;
                        str3 = str3;
                        str2 = str2;
                        devicePrintFonts = devicePrintFonts;
                        devicePrintPlugins = devicePrintPlugins;
                        devicePrintTimezone = devicePrintTimezone;
                        devicePrintScreen = devicePrintScreen;
                        break;
                    } else {
                        JsonDataException unexpectedNull9 = Util.unexpectedNull("appVersion", "appVersion", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull9, "Util.unexpectedNull(\"app…    \"appVersion\", reader)");
                        throw unexpectedNull9;
                    }
                case 9:
                    String fromJson10 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson10 != null) {
                        str6 = fromJson10;
                        str4 = str4;
                        str3 = str3;
                        str2 = str2;
                        devicePrintFonts = devicePrintFonts;
                        devicePrintPlugins = devicePrintPlugins;
                        devicePrintTimezone = devicePrintTimezone;
                        devicePrintScreen = devicePrintScreen;
                        break;
                    } else {
                        JsonDataException unexpectedNull10 = Util.unexpectedNull("platform", "platform", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull10, "Util.unexpectedNull(\"pla…      \"platform\", reader)");
                        throw unexpectedNull10;
                    }
                case 10:
                    String fromJson11 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson11 != null) {
                        str7 = fromJson11;
                        str4 = str4;
                        str3 = str3;
                        str2 = str2;
                        devicePrintFonts = devicePrintFonts;
                        devicePrintPlugins = devicePrintPlugins;
                        devicePrintTimezone = devicePrintTimezone;
                        devicePrintScreen = devicePrintScreen;
                        break;
                    } else {
                        JsonDataException unexpectedNull11 = Util.unexpectedNull("product", "product", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull11, "Util.unexpectedNull(\"pro…       \"product\", reader)");
                        throw unexpectedNull11;
                    }
                case 11:
                    String fromJson12 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson12 != null) {
                        str8 = fromJson12;
                        str4 = str4;
                        str3 = str3;
                        str2 = str2;
                        devicePrintFonts = devicePrintFonts;
                        devicePrintPlugins = devicePrintPlugins;
                        devicePrintTimezone = devicePrintTimezone;
                        devicePrintScreen = devicePrintScreen;
                        break;
                    } else {
                        JsonDataException unexpectedNull12 = Util.unexpectedNull("productSub", "productSub", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull12, "Util.unexpectedNull(\"pro…    \"productSub\", reader)");
                        throw unexpectedNull12;
                    }
                case 12:
                    String fromJson13 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson13 != null) {
                        str9 = fromJson13;
                        str4 = str4;
                        str3 = str3;
                        str2 = str2;
                        devicePrintFonts = devicePrintFonts;
                        devicePrintPlugins = devicePrintPlugins;
                        devicePrintTimezone = devicePrintTimezone;
                        devicePrintScreen = devicePrintScreen;
                        break;
                    } else {
                        JsonDataException unexpectedNull13 = Util.unexpectedNull("vendor", "vendor", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull13, "Util.unexpectedNull(\"ven…        \"vendor\", reader)");
                        throw unexpectedNull13;
                    }
                case 13:
                    String fromJson14 = this.stringAdapter.fromJson(jsonReader);
                    if (fromJson14 != null) {
                        str10 = fromJson14;
                        str4 = str4;
                        str3 = str3;
                        str2 = str2;
                        devicePrintFonts = devicePrintFonts;
                        devicePrintPlugins = devicePrintPlugins;
                        devicePrintTimezone = devicePrintTimezone;
                        devicePrintScreen = devicePrintScreen;
                        break;
                    } else {
                        JsonDataException unexpectedNull14 = Util.unexpectedNull("language", "language", jsonReader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull14, "Util.unexpectedNull(\"lan…      \"language\", reader)");
                        throw unexpectedNull14;
                    }
                default:
                    str4 = str4;
                    str3 = str3;
                    str2 = str2;
                    devicePrintFonts = devicePrintFonts;
                    devicePrintPlugins = devicePrintPlugins;
                    devicePrintTimezone = devicePrintTimezone;
                    devicePrintScreen = devicePrintScreen;
                    break;
            }
            str = str;
        }
        jsonReader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("deviceId", "deviceId", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "Util.missingProperty(\"de…eId\", \"deviceId\", reader)");
            throw missingProperty;
        } else if (devicePrintScreen == null) {
            JsonDataException missingProperty2 = Util.missingProperty("screen", "screen", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "Util.missingProperty(\"screen\", \"screen\", reader)");
            throw missingProperty2;
        } else if (devicePrintTimezone == null) {
            JsonDataException missingProperty3 = Util.missingProperty("timezone", "timezone", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "Util.missingProperty(\"ti…one\", \"timezone\", reader)");
            throw missingProperty3;
        } else if (devicePrintPlugins == null) {
            JsonDataException missingProperty4 = Util.missingProperty("plugins", "plugins", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "Util.missingProperty(\"plugins\", \"plugins\", reader)");
            throw missingProperty4;
        } else if (devicePrintFonts == null) {
            JsonDataException missingProperty5 = Util.missingProperty("fonts", "fonts", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty5, "Util.missingProperty(\"fonts\", \"fonts\", reader)");
            throw missingProperty5;
        } else if (str2 == null) {
            JsonDataException missingProperty6 = Util.missingProperty("userAgent", "userAgent", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty6, "Util.missingProperty(\"us…nt\", \"userAgent\", reader)");
            throw missingProperty6;
        } else if (str3 == null) {
            JsonDataException missingProperty7 = Util.missingProperty("appName", "appName", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty7, "Util.missingProperty(\"appName\", \"appName\", reader)");
            throw missingProperty7;
        } else if (str4 == null) {
            JsonDataException missingProperty8 = Util.missingProperty("appCodeName", "appCodeName", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty8, "Util.missingProperty(\"ap…ame\",\n            reader)");
            throw missingProperty8;
        } else if (str5 == null) {
            JsonDataException missingProperty9 = Util.missingProperty("appVersion", "appVersion", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty9, "Util.missingProperty(\"ap…n\", \"appVersion\", reader)");
            throw missingProperty9;
        } else if (str6 == null) {
            JsonDataException missingProperty10 = Util.missingProperty("platform", "platform", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty10, "Util.missingProperty(\"pl…orm\", \"platform\", reader)");
            throw missingProperty10;
        } else if (str7 == null) {
            JsonDataException missingProperty11 = Util.missingProperty("product", "product", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty11, "Util.missingProperty(\"product\", \"product\", reader)");
            throw missingProperty11;
        } else if (str8 == null) {
            JsonDataException missingProperty12 = Util.missingProperty("productSub", "productSub", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty12, "Util.missingProperty(\"pr…b\", \"productSub\", reader)");
            throw missingProperty12;
        } else if (str9 == null) {
            JsonDataException missingProperty13 = Util.missingProperty("vendor", "vendor", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty13, "Util.missingProperty(\"vendor\", \"vendor\", reader)");
            throw missingProperty13;
        } else if (str10 != null) {
            return new DevicePrint(str, devicePrintScreen, devicePrintTimezone, devicePrintPlugins, devicePrintFonts, str2, str3, str4, str5, str6, str7, str8, str9, str10);
        } else {
            JsonDataException missingProperty14 = Util.missingProperty("language", "language", jsonReader);
            Intrinsics.checkNotNullExpressionValue(missingProperty14, "Util.missingProperty(\"la…age\", \"language\", reader)");
            throw missingProperty14;
        }
    }

    public void toJson(JsonWriter jsonWriter, DevicePrint devicePrint) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (devicePrint != null) {
            jsonWriter.beginObject();
            jsonWriter.name("deviceId");
            this.stringAdapter.toJson(jsonWriter, devicePrint.getDeviceId());
            jsonWriter.name("screen");
            this.devicePrintScreenAdapter.toJson(jsonWriter, devicePrint.getScreen());
            jsonWriter.name("timezone");
            this.devicePrintTimezoneAdapter.toJson(jsonWriter, devicePrint.getTimezone());
            jsonWriter.name("plugins");
            this.devicePrintPluginsAdapter.toJson(jsonWriter, devicePrint.getPlugins());
            jsonWriter.name("fonts");
            this.devicePrintFontsAdapter.toJson(jsonWriter, devicePrint.getFonts());
            jsonWriter.name("userAgent");
            this.stringAdapter.toJson(jsonWriter, devicePrint.getUserAgent());
            jsonWriter.name("appName");
            this.stringAdapter.toJson(jsonWriter, devicePrint.getAppName());
            jsonWriter.name("appCodeName");
            this.stringAdapter.toJson(jsonWriter, devicePrint.getAppCodeName());
            jsonWriter.name("appVersion");
            this.stringAdapter.toJson(jsonWriter, devicePrint.getAppVersion());
            jsonWriter.name("platform");
            this.stringAdapter.toJson(jsonWriter, devicePrint.getPlatform());
            jsonWriter.name("product");
            this.stringAdapter.toJson(jsonWriter, devicePrint.getProduct());
            jsonWriter.name("productSub");
            this.stringAdapter.toJson(jsonWriter, devicePrint.getProductSub());
            jsonWriter.name("vendor");
            this.stringAdapter.toJson(jsonWriter, devicePrint.getVendor());
            jsonWriter.name("language");
            this.stringAdapter.toJson(jsonWriter, devicePrint.getLanguage());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
