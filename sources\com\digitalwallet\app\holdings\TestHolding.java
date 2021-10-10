package com.digitalwallet.app.holdings;

import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.model.SubType;
import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import com.squareup.moshi.Moshi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001b*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001bB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0003J)\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J.\u0010\u0014\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/digitalwallet/app/holdings/TestHolding;", "T", "", "json", "", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)V", "getClazz", "()Ljava/lang/Class;", "getJson", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "mockIf", "Lkotlin/Function1;", "", "filter", "moshi", "Lcom/squareup/moshi/Moshi;", "toString", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: TestHoldings.kt */
public final class TestHolding<T> {
    public static final Companion Companion = new Companion(null);
    private static final String ambulanceVictoria = "{\n    \"link\": \"/api/v1/ambulance/holdings/907239470\",\n    \"attributes\": {\n        \"type\": \"AGENCY_HOLDING\",\n        \"subtype\": \"AMBULANCE_MEMBERSHIP\",\n        \"expiry\": \"2034-10-23\",\n        \"state\": \"ACTIVE\",\n        \"domain\": \"AMBULANCE\",\n        \"name\": \"Asdasd Asdasd\",\n        \"agencyIdentifier\": \"4440928\",\n        \"kind\": \"SINGLE\",\n        \"length\": \"5-YEAR\"\n    },\n    \"jws\": \"\"\n}";
    private static final TestHolding<SecureHolding> ambulanceVictoriaSecure = new TestHolding<>("{\n    \"link\": \"/api/v1/ambulance/holdings/907239470\",\n    \"attributes\": {\n        \"type\": \"AGENCY_HOLDING\",\n        \"subtype\": \"AMBULANCE_MEMBERSHIP\",\n        \"expiry\": \"2034-10-23\",\n        \"state\": \"ACTIVE\",\n        \"domain\": \"AMBULANCE\",\n        \"name\": \"Asdasd Asdasd\",\n        \"agencyIdentifier\": \"4440928\",\n        \"kind\": \"SINGLE\",\n        \"length\": \"5-YEAR\"\n    },\n    \"jws\": \"\"\n}", SecureHolding.class);
    private static final TestHolding<UnsecuredHolding> ambulanceVictoriaUnsecured = new TestHolding<>("{\n    \"link\": \"/api/v1/ambulance/holdings/907239470\",\n    \"attributes\": {\n        \"type\": \"AGENCY_HOLDING\",\n        \"subtype\": \"AMBULANCE_MEMBERSHIP\",\n        \"expiry\": \"2034-10-23\",\n        \"state\": \"ACTIVE\",\n        \"domain\": \"AMBULANCE\",\n        \"name\": \"Asdasd Asdasd\",\n        \"agencyIdentifier\": \"4440928\",\n        \"kind\": \"SINGLE\",\n        \"length\": \"5-YEAR\"\n    },\n    \"jws\": \"\"\n}", UnsecuredHolding.class);
    private static final String kangarooHarvester = "{\n    \"link\": \"/api/v1/kangaroos/holdings/H12345\",\n    \"attributes\": {\n        \"type\": \"AGENCY_HOLDING\",\n        \"subtype\": \"LICENCE\",\n        \"expiry\": \"2035-07-28T02:00:00+11:00\",\n        \"state\": \"Authorised\",\n        \"domain\": \"DJPR\",\n        \"agencyIdentifier\": \"H12345\",\n        \"name\": \"Wallace Ronald\",\n        \"startDateTime\": \"2018-03-28T02:00:00+11:00\",\n        \"quotas\": [\n            {\n                \"quotaId\": \"Q123456\",\n                \"zoneNumber\": \"1\",\n                \"zoneName\": \"East\",\n                \"startDateTime\": \"2018-03-28T02:00:00+11:00\",\n                \"endDateTime\": \"2060-03-28T02:00:00+11:00\",\n                \"status\": \"Open\"\n            },\n            {\n                \"quotaId\": \"Q123457\",\n                \"zoneNumber\": \"2\",\n                \"zoneName\": \"Another Zone\",\n                \"startDateTime\": \"2018-03-28T02:00:00+11:00\",\n                \"endDateTime\": \"2060-03-28T02:00:00+11:00\",\n                \"status\": \"oPeN\"\n            },\n            {\n                \"quotaId\": \"Q123458\",\n                \"zoneNumber\": \"3\",\n                \"zoneName\": \"Expired Zone\",\n                \"startDateTime\": \"2018-03-28T02:00:00+11:00\",\n                \"endDateTime\": \"2019-03-28T02:00:00+11:00\",\n                \"status\": \"Open\"\n            },\n            {\n                \"quotaId\": \"Q123459\",\n                \"zoneNumber\": \"4\",\n                \"zoneName\": \"Closed Zone\",\n                \"startDateTime\": \"2018-03-28T02:00:00+11:00\",\n                \"endDateTime\": \"2060-03-28T02:00:00+11:00\",\n                \"status\": \"Closed\"\n            },\n            {\n                \"quotaId\": \"Q123459\",\n                \"zoneNumber\": \"5\",\n                \"zoneName\": \"Future Zone\",\n                \"startDateTime\": \"2080-03-28T02:00:00+11:00\",\n                \"endDateTime\": \"2090-03-28T02:00:00+11:00\",\n                \"status\": \"Closed\"\n            }\n        ],\n        \"addresses\": [\n            {\n                \"country\": \"AUSTRALIA\",\n                \"postCode\": \"3011\",\n                \"stateOrTerritory\": \"VIC\",\n                \"streetName\": \"1 McNab Ave\",\n                \"suburbOrPlaceOrLocality\": \"FOOTSCRAY\",\n                \"unstructuredAddressLine\": \"1 McNab Ave, FOOTSCRAY, VIC 3011\"\n            }\n        ]\n    }\n}";
    private static final TestHolding<SecureHolding> kangarooHarvesterSecure = new TestHolding<>("{\n    \"link\": \"/api/v1/kangaroos/holdings/H12345\",\n    \"attributes\": {\n        \"type\": \"AGENCY_HOLDING\",\n        \"subtype\": \"LICENCE\",\n        \"expiry\": \"2035-07-28T02:00:00+11:00\",\n        \"state\": \"Authorised\",\n        \"domain\": \"DJPR\",\n        \"agencyIdentifier\": \"H12345\",\n        \"name\": \"Wallace Ronald\",\n        \"startDateTime\": \"2018-03-28T02:00:00+11:00\",\n        \"quotas\": [\n            {\n                \"quotaId\": \"Q123456\",\n                \"zoneNumber\": \"1\",\n                \"zoneName\": \"East\",\n                \"startDateTime\": \"2018-03-28T02:00:00+11:00\",\n                \"endDateTime\": \"2060-03-28T02:00:00+11:00\",\n                \"status\": \"Open\"\n            },\n            {\n                \"quotaId\": \"Q123457\",\n                \"zoneNumber\": \"2\",\n                \"zoneName\": \"Another Zone\",\n                \"startDateTime\": \"2018-03-28T02:00:00+11:00\",\n                \"endDateTime\": \"2060-03-28T02:00:00+11:00\",\n                \"status\": \"oPeN\"\n            },\n            {\n                \"quotaId\": \"Q123458\",\n                \"zoneNumber\": \"3\",\n                \"zoneName\": \"Expired Zone\",\n                \"startDateTime\": \"2018-03-28T02:00:00+11:00\",\n                \"endDateTime\": \"2019-03-28T02:00:00+11:00\",\n                \"status\": \"Open\"\n            },\n            {\n                \"quotaId\": \"Q123459\",\n                \"zoneNumber\": \"4\",\n                \"zoneName\": \"Closed Zone\",\n                \"startDateTime\": \"2018-03-28T02:00:00+11:00\",\n                \"endDateTime\": \"2060-03-28T02:00:00+11:00\",\n                \"status\": \"Closed\"\n            },\n            {\n                \"quotaId\": \"Q123459\",\n                \"zoneNumber\": \"5\",\n                \"zoneName\": \"Future Zone\",\n                \"startDateTime\": \"2080-03-28T02:00:00+11:00\",\n                \"endDateTime\": \"2090-03-28T02:00:00+11:00\",\n                \"status\": \"Closed\"\n            }\n        ],\n        \"addresses\": [\n            {\n                \"country\": \"AUSTRALIA\",\n                \"postCode\": \"3011\",\n                \"stateOrTerritory\": \"VIC\",\n                \"streetName\": \"1 McNab Ave\",\n                \"suburbOrPlaceOrLocality\": \"FOOTSCRAY\",\n                \"unstructuredAddressLine\": \"1 McNab Ave, FOOTSCRAY, VIC 3011\"\n            }\n        ]\n    }\n}", SecureHolding.class);
    private static final TestHolding<UnsecuredHolding> kangarooHarvesterUnsecured = new TestHolding<>("{\n    \"link\": \"/api/v1/kangaroos/holdings/H12345\",\n    \"attributes\": {\n        \"type\": \"AGENCY_HOLDING\",\n        \"subtype\": \"LICENCE\",\n        \"expiry\": \"2035-07-28T02:00:00+11:00\",\n        \"state\": \"Authorised\",\n        \"domain\": \"DJPR\",\n        \"agencyIdentifier\": \"H12345\",\n        \"name\": \"Wallace Ronald\",\n        \"startDateTime\": \"2018-03-28T02:00:00+11:00\",\n        \"quotas\": [\n            {\n                \"quotaId\": \"Q123456\",\n                \"zoneNumber\": \"1\",\n                \"zoneName\": \"East\",\n                \"startDateTime\": \"2018-03-28T02:00:00+11:00\",\n                \"endDateTime\": \"2060-03-28T02:00:00+11:00\",\n                \"status\": \"Open\"\n            },\n            {\n                \"quotaId\": \"Q123457\",\n                \"zoneNumber\": \"2\",\n                \"zoneName\": \"Another Zone\",\n                \"startDateTime\": \"2018-03-28T02:00:00+11:00\",\n                \"endDateTime\": \"2060-03-28T02:00:00+11:00\",\n                \"status\": \"oPeN\"\n            },\n            {\n                \"quotaId\": \"Q123458\",\n                \"zoneNumber\": \"3\",\n                \"zoneName\": \"Expired Zone\",\n                \"startDateTime\": \"2018-03-28T02:00:00+11:00\",\n                \"endDateTime\": \"2019-03-28T02:00:00+11:00\",\n                \"status\": \"Open\"\n            },\n            {\n                \"quotaId\": \"Q123459\",\n                \"zoneNumber\": \"4\",\n                \"zoneName\": \"Closed Zone\",\n                \"startDateTime\": \"2018-03-28T02:00:00+11:00\",\n                \"endDateTime\": \"2060-03-28T02:00:00+11:00\",\n                \"status\": \"Closed\"\n            },\n            {\n                \"quotaId\": \"Q123459\",\n                \"zoneNumber\": \"5\",\n                \"zoneName\": \"Future Zone\",\n                \"startDateTime\": \"2080-03-28T02:00:00+11:00\",\n                \"endDateTime\": \"2090-03-28T02:00:00+11:00\",\n                \"status\": \"Closed\"\n            }\n        ],\n        \"addresses\": [\n            {\n                \"country\": \"AUSTRALIA\",\n                \"postCode\": \"3011\",\n                \"stateOrTerritory\": \"VIC\",\n                \"streetName\": \"1 McNab Ave\",\n                \"suburbOrPlaceOrLocality\": \"FOOTSCRAY\",\n                \"unstructuredAddressLine\": \"1 McNab Ave, FOOTSCRAY, VIC 3011\"\n            }\n        ]\n    }\n}", UnsecuredHolding.class);
    private static final String solar = "{\n    \"link\": \"/adapter/v1/wallet/holdings/SOLAR_INSTALLATION-AGENCY_HOLDING-LICENCE-SOH-55511\",\n    \"attributes\": {\n        \"type\": \"AGENCY_HOLDING\",\n        \"domain\": \"SOLAR_INSTALLATION\",\n        \"subtype\": \"LICENCE\",\n        \"kind\": \"3 Year License\",\n        \"expiry\": \"2035-05-23T00:00:00+10:00\",\n        \"state\": \"Active\",\n        \"name\": \"Solar12 Technician12\",\n        \"agencyIdentifier\": \"SOH-55511\",\n        \"firstName\": \"Solar12\",\n        \"lastName\": \"Technician12\",\n        \"startDateTime\": \"2020-05-23T00:00:00+10:00\",\n        \"solarHotWater\": \"false\",\n        \"gridConnect\": \"true\",\n        \"battery\": \"false\",\n        \"standAlone\": \"true\"\n    },\n    \"jws\": \"\"\n}";
    private static final TestHolding<SecureHolding> solarSecure = new TestHolding<>("{\n    \"link\": \"/adapter/v1/wallet/holdings/SOLAR_INSTALLATION-AGENCY_HOLDING-LICENCE-SOH-55511\",\n    \"attributes\": {\n        \"type\": \"AGENCY_HOLDING\",\n        \"domain\": \"SOLAR_INSTALLATION\",\n        \"subtype\": \"LICENCE\",\n        \"kind\": \"3 Year License\",\n        \"expiry\": \"2035-05-23T00:00:00+10:00\",\n        \"state\": \"Active\",\n        \"name\": \"Solar12 Technician12\",\n        \"agencyIdentifier\": \"SOH-55511\",\n        \"firstName\": \"Solar12\",\n        \"lastName\": \"Technician12\",\n        \"startDateTime\": \"2020-05-23T00:00:00+10:00\",\n        \"solarHotWater\": \"false\",\n        \"gridConnect\": \"true\",\n        \"battery\": \"false\",\n        \"standAlone\": \"true\"\n    },\n    \"jws\": \"\"\n}", SecureHolding.class);
    private static final TestHolding<UnsecuredHolding> solarUnsecured = new TestHolding<>("{\n    \"link\": \"/adapter/v1/wallet/holdings/SOLAR_INSTALLATION-AGENCY_HOLDING-LICENCE-SOH-55511\",\n    \"attributes\": {\n        \"type\": \"AGENCY_HOLDING\",\n        \"domain\": \"SOLAR_INSTALLATION\",\n        \"subtype\": \"LICENCE\",\n        \"kind\": \"3 Year License\",\n        \"expiry\": \"2035-05-23T00:00:00+10:00\",\n        \"state\": \"Active\",\n        \"name\": \"Solar12 Technician12\",\n        \"agencyIdentifier\": \"SOH-55511\",\n        \"firstName\": \"Solar12\",\n        \"lastName\": \"Technician12\",\n        \"startDateTime\": \"2020-05-23T00:00:00+10:00\",\n        \"solarHotWater\": \"false\",\n        \"gridConnect\": \"true\",\n        \"battery\": \"false\",\n        \"standAlone\": \"true\"\n    },\n    \"jws\": \"\"\n}", UnsecuredHolding.class);
    private static final String worksafe = "{\n    \"attributes\": {\n        \"domain\": \"WORKSAFE\",\n        \"type\": \"AGENCY_HOLDING\",\n        \"subtype\": \"SUBTYPE\",\n        \"agencyIdentifier\": \"WL1234567\",\n        \"firstName\": \"JOHN\",\n        \"lastName\": \"CITIZEN\",\n        \"licenceClass\": \"SA, RA, LF\",\n        \"licenceConditions\": \"SCLR\",\n        \"startDateTime\": \"2018-06-02T00:00:00+10:00\",\n        \"expiry\": \"2035-06-02T00:00:00+10:00\",\n        \"dateOfBirth\": \"1980-01-01\",\n        \"state\": \"Valid\"\n    },\n    \"assets\": [\n        {\n            \"type\": \"photo\",\n            \"url\": \"https://farm8.staticflickr.com/6104/6299178350_ba7f9894b2_o.jpg\",\n            \"hash\": \"b1_XNh7nflM_mYJZUElspwTHumM\"\n        }\n    ],\n    \"link\": \"/adapter/v1/wallet/holdings/WORKSAFE-AGENCY_HOLDING-HIGH_RISK_WORK_LICENCE-m050k000000CbDpAAK\",\n    \"jws\": \"\"\n}";
    private static final String worksafeWithoutPhoto = "{\n    \"attributes\": {\n        \"domain\": \"WORKSAFE\",\n        \"type\": \"AGENCY_HOLDING\",\n        \"subtype\": \"SUBTYPE\",\n        \"agencyIdentifier\": \"WL1234567\",\n        \"firstName\": \"JOHN\",\n        \"lastName\": \"CITIZEN\",\n        \"licenceClass\": \"SA, RA, LF\",\n        \"licenceConditions\": \"SCLR\",\n        \"startDateTime\": \"2018-06-02T00:00:00+10:00\",\n        \"expiry\": \"2035-06-02T00:00:00+10:00\",\n        \"dateOfBirth\": \"1980-01-01\",\n        \"state\": \"Valid\"\n    },\n    \"assets\": [],\n    \"link\": \"/adapter/v1/wallet/holdings/WORKSAFE-AGENCY_HOLDING-SUBTYPE-m050k000000CbDpAAK\",\n    \"jws\": \"\"\n}";
    private static final String wwc = "{\n    \"attributes\": {\n        \"domain\": \"WWC\",\n        \"type\": \"AGENCY_HOLDING\",\n        \"subtype\": \"WWC_VOLUNTEER\",\n        \"agencyIdentifier\": \"1234567A - 01\",\n        \"name\": \"Justin E Smith\",\n        \"expiry\": \"2035-06-01T00:00:00+10:00\"\n    },\n    \"assets\": [\n        {\n            \"type\": \"photo\",\n            \"url\": \"https://c2.staticflickr.com/7/6225/6299162780_0b612ded13_o.jpg\",\n            \"hash\": \"KwU2fkj64_FHPc04FoXMyMUBrrI\"\n        }\n    ],\n    \"link\": \"/adapter/v1/wallet/holdings/WWC-AGENCY_HOLDING-VOLUNTEER-1234567A-01\",\n    \"jws\": \"\"\n}";
    private static final TestHolding<SecureHolding> wwcSecure = new TestHolding<>("{\n    \"attributes\": {\n        \"domain\": \"WWC\",\n        \"type\": \"AGENCY_HOLDING\",\n        \"subtype\": \"WWC_VOLUNTEER\",\n        \"agencyIdentifier\": \"1234567A - 01\",\n        \"name\": \"Justin E Smith\",\n        \"expiry\": \"2035-06-01T00:00:00+10:00\"\n    },\n    \"assets\": [\n        {\n            \"type\": \"photo\",\n            \"url\": \"https://c2.staticflickr.com/7/6225/6299162780_0b612ded13_o.jpg\",\n            \"hash\": \"KwU2fkj64_FHPc04FoXMyMUBrrI\"\n        }\n    ],\n    \"link\": \"/adapter/v1/wallet/holdings/WWC-AGENCY_HOLDING-VOLUNTEER-1234567A-01\",\n    \"jws\": \"\"\n}", SecureHolding.class);
    private static final TestHolding<UnsecuredHolding> wwcUnsecured = new TestHolding<>("{\n    \"attributes\": {\n        \"domain\": \"WWC\",\n        \"type\": \"AGENCY_HOLDING\",\n        \"subtype\": \"WWC_VOLUNTEER\",\n        \"agencyIdentifier\": \"1234567A - 01\",\n        \"name\": \"Justin E Smith\",\n        \"expiry\": \"2035-06-01T00:00:00+10:00\"\n    },\n    \"assets\": [\n        {\n            \"type\": \"photo\",\n            \"url\": \"https://c2.staticflickr.com/7/6225/6299162780_0b612ded13_o.jpg\",\n            \"hash\": \"KwU2fkj64_FHPc04FoXMyMUBrrI\"\n        }\n    ],\n    \"link\": \"/adapter/v1/wallet/holdings/WWC-AGENCY_HOLDING-VOLUNTEER-1234567A-01\",\n    \"jws\": \"\"\n}", UnsecuredHolding.class);
    private final Class<T> clazz;
    private final String json;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.digitalwallet.app.holdings.TestHolding */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TestHolding copy$default(TestHolding testHolding, String str, Class cls, int i, Object obj) {
        if ((i & 1) != 0) {
            str = testHolding.json;
        }
        if ((i & 2) != 0) {
            cls = testHolding.clazz;
        }
        return testHolding.copy(str, cls);
    }

    public final String component1() {
        return this.json;
    }

    public final Class<T> component2() {
        return this.clazz;
    }

    public final TestHolding<T> copy(String str, Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return new TestHolding<>(str, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TestHolding)) {
            return false;
        }
        TestHolding testHolding = (TestHolding) obj;
        return Intrinsics.areEqual(this.json, testHolding.json) && Intrinsics.areEqual(this.clazz, testHolding.clazz);
    }

    public int hashCode() {
        String str = this.json;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Class<T> cls = this.clazz;
        if (cls != null) {
            i = cls.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "TestHolding(json=" + this.json + ", clazz=" + this.clazz + ")";
    }

    public TestHolding(String str, Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        this.json = str;
        this.clazz = cls;
    }

    public final Class<T> getClazz() {
        return this.clazz;
    }

    public final String getJson() {
        return this.json;
    }

    public final Function1<List<? extends T>, List<T>> mockIf(boolean z, Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        return new TestHolding$mockIf$1(this, z, moshi);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u001f\u001a\u00020 J\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\u001f\u001a\u00020 J\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u001f\u001a\u00020 J\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u000e\u0010\u0012\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR\u000e\u0010\u0017\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\tR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\t¨\u0006$"}, d2 = {"Lcom/digitalwallet/app/holdings/TestHolding$Companion;", "", "()V", "ambulanceVictoria", "", "ambulanceVictoriaSecure", "Lcom/digitalwallet/app/holdings/TestHolding;", "Lcom/digitalwallet/app/model/SecureHolding;", "getAmbulanceVictoriaSecure", "()Lcom/digitalwallet/app/holdings/TestHolding;", "ambulanceVictoriaUnsecured", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "getAmbulanceVictoriaUnsecured", "kangarooHarvester", "kangarooHarvesterSecure", "getKangarooHarvesterSecure", "kangarooHarvesterUnsecured", "getKangarooHarvesterUnsecured", "solar", "solarSecure", "getSolarSecure", "solarUnsecured", "getSolarUnsecured", "worksafe", "worksafeWithoutPhoto", "wwc", "wwcSecure", "getWwcSecure", "wwcUnsecured", "getWwcUnsecured", "worksafeSecure", "subType", "Lcom/digitalwallet/app/model/SubType;", "worksafeUnsecured", "worksafeWithoutPhotoSecure", "worksafeWithoutPhotoUnsecured", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: TestHoldings.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TestHolding<SecureHolding> getAmbulanceVictoriaSecure() {
            return TestHolding.ambulanceVictoriaSecure;
        }

        public final TestHolding<UnsecuredHolding> getAmbulanceVictoriaUnsecured() {
            return TestHolding.ambulanceVictoriaUnsecured;
        }

        public final TestHolding<SecureHolding> getSolarSecure() {
            return TestHolding.solarSecure;
        }

        public final TestHolding<UnsecuredHolding> getSolarUnsecured() {
            return TestHolding.solarUnsecured;
        }

        public final TestHolding<SecureHolding> worksafeSecure(SubType subType) {
            Intrinsics.checkNotNullParameter(subType, "subType");
            return new TestHolding<>(StringsKt.replace$default(TestHolding.worksafe, "SUBTYPE", subType.getRemoteName(), false, 4, (Object) null), SecureHolding.class);
        }

        public final TestHolding<UnsecuredHolding> worksafeUnsecured(SubType subType) {
            Intrinsics.checkNotNullParameter(subType, "subType");
            return new TestHolding<>(StringsKt.replace$default(TestHolding.worksafe, "SUBTYPE", subType.getRemoteName(), false, 4, (Object) null), UnsecuredHolding.class);
        }

        public final TestHolding<SecureHolding> worksafeWithoutPhotoSecure(SubType subType) {
            Intrinsics.checkNotNullParameter(subType, "subType");
            return new TestHolding<>(StringsKt.replace$default(TestHolding.worksafeWithoutPhoto, "SUBTYPE", subType.getRemoteName(), false, 4, (Object) null), SecureHolding.class);
        }

        public final TestHolding<UnsecuredHolding> worksafeWithoutPhotoUnsecured(SubType subType) {
            Intrinsics.checkNotNullParameter(subType, "subType");
            return new TestHolding<>(StringsKt.replace$default(TestHolding.worksafeWithoutPhoto, "SUBTYPE", subType.getRemoteName(), false, 4, (Object) null), UnsecuredHolding.class);
        }

        public final TestHolding<SecureHolding> getWwcSecure() {
            return TestHolding.wwcSecure;
        }

        public final TestHolding<UnsecuredHolding> getWwcUnsecured() {
            return TestHolding.wwcUnsecured;
        }

        public final TestHolding<SecureHolding> getKangarooHarvesterSecure() {
            return TestHolding.kangarooHarvesterSecure;
        }

        public final TestHolding<UnsecuredHolding> getKangarooHarvesterUnsecured() {
            return TestHolding.kangarooHarvesterUnsecured;
        }
    }
}
