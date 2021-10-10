package com.digitalwallet.app.model.db.harvester;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bS\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B·\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0002\u0010 J\t\u0010X\u001a\u00020\u0006HÆ\u0003J\t\u0010Y\u001a\u00020\u0011HÆ\u0003J\t\u0010Z\u001a\u00020\u0014HÆ\u0003J\u0010\u0010[\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u00108J\t\u0010\\\u001a\u00020\u0014HÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u00108J\t\u0010^\u001a\u00020\u0014HÆ\u0003J\t\u0010_\u001a\u00020\u0014HÆ\u0003J\t\u0010`\u001a\u00020\u0014HÆ\u0003J\t\u0010a\u001a\u00020\u0014HÆ\u0003J\t\u0010b\u001a\u00020\u0006HÆ\u0003J\t\u0010c\u001a\u00020\u0006HÆ\u0003J\u000f\u0010d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eHÆ\u0003J\t\u0010e\u001a\u00020\u0006HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010h\u001a\u00020\fHÆ\u0003J\t\u0010i\u001a\u00020\u000eHÆ\u0003J\t\u0010j\u001a\u00020\u000eHÆ\u0003J\t\u0010k\u001a\u00020\u0011HÆ\u0003Jä\u0001\u0010l\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u00142\b\b\u0002\u0010\u001c\u001a\u00020\u00062\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eHÆ\u0001¢\u0006\u0002\u0010mJ\u0013\u0010n\u001a\u00020\f2\b\u0010o\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010p\u001a\u00020\u0014HÖ\u0001J\t\u0010q\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\"\"\u0004\b2\u0010$R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\"\"\u0004\b4\u0010$R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\"\"\u0004\b6\u0010$R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010\u0018\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010=\"\u0004\bA\u0010?R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\bB\u00108\"\u0004\bC\u0010:R\u001a\u0010\u001a\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010=\"\u0004\bE\u0010?R\u001a\u0010\u001b\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010=\"\u0004\bG\u0010?R\u001a\u0010\u0016\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010=\"\u0004\bI\u0010?R\u001a\u0010\u0019\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010=\"\u0004\bK\u0010?R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\"\"\u0004\bM\u0010$R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010O\"\u0004\bS\u0010QR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006r"}, d2 = {"Lcom/digitalwallet/app/model/db/harvester/HarvestBatch;", "", "batch", "Lcom/digitalwallet/app/model/db/harvester/SavedHarvestTagBatch;", "(Lcom/digitalwallet/app/model/db/harvester/SavedHarvestTagBatch;)V", "quotaId", "", "harvesterId", AuthorizationRequest.Scope.ADDRESS, "landholderName", "landholderContactNumber", "consentCaptured", "", "consentDateTime", "Ljava/util/Date;", "dateOfHarvest", "scanLatitude", "", "scanLongitude", "numFemales", "", "numEasternGreyKangaroos", "numWesternGreyKangaroos", "numRedKangaroos", "numPouchYoungDestroyed", "numYoungAtFootDestroyed", "numTaggedCarcassesLeftOnProperty", "numTaggedCarcassesStoredForProcessor", "comments", "tags", "", "Lcom/digitalwallet/app/model/db/harvester/HarvestTag;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Date;Ljava/util/Date;DDILjava/lang/Integer;ILjava/lang/Integer;IIIILjava/lang/String;Ljava/util/List;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getComments", "setComments", "getConsentCaptured", "()Z", "setConsentCaptured", "(Z)V", "getConsentDateTime", "()Ljava/util/Date;", "setConsentDateTime", "(Ljava/util/Date;)V", "getDateOfHarvest", "setDateOfHarvest", "getHarvesterId", "setHarvesterId", "getLandholderContactNumber", "setLandholderContactNumber", "getLandholderName", "setLandholderName", "getNumEasternGreyKangaroos", "()Ljava/lang/Integer;", "setNumEasternGreyKangaroos", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getNumFemales", "()I", "setNumFemales", "(I)V", "getNumPouchYoungDestroyed", "setNumPouchYoungDestroyed", "getNumRedKangaroos", "setNumRedKangaroos", "getNumTaggedCarcassesLeftOnProperty", "setNumTaggedCarcassesLeftOnProperty", "getNumTaggedCarcassesStoredForProcessor", "setNumTaggedCarcassesStoredForProcessor", "getNumWesternGreyKangaroos", "setNumWesternGreyKangaroos", "getNumYoungAtFootDestroyed", "setNumYoungAtFootDestroyed", "getQuotaId", "setQuotaId", "getScanLatitude", "()D", "setScanLatitude", "(D)V", "getScanLongitude", "setScanLongitude", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Date;Ljava/util/Date;DDILjava/lang/Integer;ILjava/lang/Integer;IIIILjava/lang/String;Ljava/util/List;)Lcom/digitalwallet/app/model/db/harvester/HarvestBatch;", "equals", "other", "hashCode", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestApiModel.kt */
public final class HarvestBatch {
    private String address;
    private String comments;
    private boolean consentCaptured;
    private Date consentDateTime;
    private Date dateOfHarvest;
    @Json(name = "harvesterID")
    private String harvesterId;
    private String landholderContactNumber;
    private String landholderName;
    private Integer numEasternGreyKangaroos;
    private int numFemales;
    private int numPouchYoungDestroyed;
    private Integer numRedKangaroos;
    private int numTaggedCarcassesLeftOnProperty;
    private int numTaggedCarcassesStoredForProcessor;
    private int numWesternGreyKangaroos;
    private int numYoungAtFootDestroyed;
    private String quotaId;
    private double scanLatitude;
    private double scanLongitude;
    private List<HarvestTag> tags;

    public static /* synthetic */ HarvestBatch copy$default(HarvestBatch harvestBatch, String str, String str2, String str3, String str4, String str5, boolean z, Date date, Date date2, double d, double d2, int i, Integer num, int i2, Integer num2, int i3, int i4, int i5, int i6, String str6, List list, int i7, Object obj) {
        return harvestBatch.copy((i7 & 1) != 0 ? harvestBatch.quotaId : str, (i7 & 2) != 0 ? harvestBatch.harvesterId : str2, (i7 & 4) != 0 ? harvestBatch.address : str3, (i7 & 8) != 0 ? harvestBatch.landholderName : str4, (i7 & 16) != 0 ? harvestBatch.landholderContactNumber : str5, (i7 & 32) != 0 ? harvestBatch.consentCaptured : z, (i7 & 64) != 0 ? harvestBatch.consentDateTime : date, (i7 & 128) != 0 ? harvestBatch.dateOfHarvest : date2, (i7 & 256) != 0 ? harvestBatch.scanLatitude : d, (i7 & 512) != 0 ? harvestBatch.scanLongitude : d2, (i7 & 1024) != 0 ? harvestBatch.numFemales : i, (i7 & 2048) != 0 ? harvestBatch.numEasternGreyKangaroos : num, (i7 & 4096) != 0 ? harvestBatch.numWesternGreyKangaroos : i2, (i7 & 8192) != 0 ? harvestBatch.numRedKangaroos : num2, (i7 & 16384) != 0 ? harvestBatch.numPouchYoungDestroyed : i3, (i7 & 32768) != 0 ? harvestBatch.numYoungAtFootDestroyed : i4, (i7 & 65536) != 0 ? harvestBatch.numTaggedCarcassesLeftOnProperty : i5, (i7 & 131072) != 0 ? harvestBatch.numTaggedCarcassesStoredForProcessor : i6, (i7 & 262144) != 0 ? harvestBatch.comments : str6, (i7 & 524288) != 0 ? harvestBatch.tags : list);
    }

    public final String component1() {
        return this.quotaId;
    }

    public final double component10() {
        return this.scanLongitude;
    }

    public final int component11() {
        return this.numFemales;
    }

    public final Integer component12() {
        return this.numEasternGreyKangaroos;
    }

    public final int component13() {
        return this.numWesternGreyKangaroos;
    }

    public final Integer component14() {
        return this.numRedKangaroos;
    }

    public final int component15() {
        return this.numPouchYoungDestroyed;
    }

    public final int component16() {
        return this.numYoungAtFootDestroyed;
    }

    public final int component17() {
        return this.numTaggedCarcassesLeftOnProperty;
    }

    public final int component18() {
        return this.numTaggedCarcassesStoredForProcessor;
    }

    public final String component19() {
        return this.comments;
    }

    public final String component2() {
        return this.harvesterId;
    }

    public final List<HarvestTag> component20() {
        return this.tags;
    }

    public final String component3() {
        return this.address;
    }

    public final String component4() {
        return this.landholderName;
    }

    public final String component5() {
        return this.landholderContactNumber;
    }

    public final boolean component6() {
        return this.consentCaptured;
    }

    public final Date component7() {
        return this.consentDateTime;
    }

    public final Date component8() {
        return this.dateOfHarvest;
    }

    public final double component9() {
        return this.scanLatitude;
    }

    public final HarvestBatch copy(String str, String str2, String str3, String str4, String str5, boolean z, Date date, Date date2, double d, double d2, int i, Integer num, int i2, Integer num2, int i3, int i4, int i5, int i6, String str6, List<HarvestTag> list) {
        Intrinsics.checkNotNullParameter(str, "quotaId");
        Intrinsics.checkNotNullParameter(str2, "harvesterId");
        Intrinsics.checkNotNullParameter(str3, AuthorizationRequest.Scope.ADDRESS);
        Intrinsics.checkNotNullParameter(date, "consentDateTime");
        Intrinsics.checkNotNullParameter(date2, "dateOfHarvest");
        Intrinsics.checkNotNullParameter(str6, "comments");
        Intrinsics.checkNotNullParameter(list, "tags");
        return new HarvestBatch(str, str2, str3, str4, str5, z, date, date2, d, d2, i, num, i2, num2, i3, i4, i5, i6, str6, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HarvestBatch)) {
            return false;
        }
        HarvestBatch harvestBatch = (HarvestBatch) obj;
        return Intrinsics.areEqual(this.quotaId, harvestBatch.quotaId) && Intrinsics.areEqual(this.harvesterId, harvestBatch.harvesterId) && Intrinsics.areEqual(this.address, harvestBatch.address) && Intrinsics.areEqual(this.landholderName, harvestBatch.landholderName) && Intrinsics.areEqual(this.landholderContactNumber, harvestBatch.landholderContactNumber) && this.consentCaptured == harvestBatch.consentCaptured && Intrinsics.areEqual(this.consentDateTime, harvestBatch.consentDateTime) && Intrinsics.areEqual(this.dateOfHarvest, harvestBatch.dateOfHarvest) && Double.compare(this.scanLatitude, harvestBatch.scanLatitude) == 0 && Double.compare(this.scanLongitude, harvestBatch.scanLongitude) == 0 && this.numFemales == harvestBatch.numFemales && Intrinsics.areEqual(this.numEasternGreyKangaroos, harvestBatch.numEasternGreyKangaroos) && this.numWesternGreyKangaroos == harvestBatch.numWesternGreyKangaroos && Intrinsics.areEqual(this.numRedKangaroos, harvestBatch.numRedKangaroos) && this.numPouchYoungDestroyed == harvestBatch.numPouchYoungDestroyed && this.numYoungAtFootDestroyed == harvestBatch.numYoungAtFootDestroyed && this.numTaggedCarcassesLeftOnProperty == harvestBatch.numTaggedCarcassesLeftOnProperty && this.numTaggedCarcassesStoredForProcessor == harvestBatch.numTaggedCarcassesStoredForProcessor && Intrinsics.areEqual(this.comments, harvestBatch.comments) && Intrinsics.areEqual(this.tags, harvestBatch.tags);
    }

    public int hashCode() {
        String str = this.quotaId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.harvesterId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.address;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.landholderName;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.landholderContactNumber;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        boolean z = this.consentCaptured;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode5 + i2) * 31;
        Date date = this.consentDateTime;
        int hashCode6 = (i5 + (date != null ? date.hashCode() : 0)) * 31;
        Date date2 = this.dateOfHarvest;
        int hashCode7 = (((((((hashCode6 + (date2 != null ? date2.hashCode() : 0)) * 31) + HarvestBatch$$ExternalSynthetic0.m0(this.scanLatitude)) * 31) + HarvestBatch$$ExternalSynthetic0.m0(this.scanLongitude)) * 31) + this.numFemales) * 31;
        Integer num = this.numEasternGreyKangaroos;
        int hashCode8 = (((hashCode7 + (num != null ? num.hashCode() : 0)) * 31) + this.numWesternGreyKangaroos) * 31;
        Integer num2 = this.numRedKangaroos;
        int hashCode9 = (((((((((hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 31) + this.numPouchYoungDestroyed) * 31) + this.numYoungAtFootDestroyed) * 31) + this.numTaggedCarcassesLeftOnProperty) * 31) + this.numTaggedCarcassesStoredForProcessor) * 31;
        String str6 = this.comments;
        int hashCode10 = (hashCode9 + (str6 != null ? str6.hashCode() : 0)) * 31;
        List<HarvestTag> list = this.tags;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode10 + i;
    }

    public String toString() {
        return "HarvestBatch(quotaId=" + this.quotaId + ", harvesterId=" + this.harvesterId + ", address=" + this.address + ", landholderName=" + this.landholderName + ", landholderContactNumber=" + this.landholderContactNumber + ", consentCaptured=" + this.consentCaptured + ", consentDateTime=" + this.consentDateTime + ", dateOfHarvest=" + this.dateOfHarvest + ", scanLatitude=" + this.scanLatitude + ", scanLongitude=" + this.scanLongitude + ", numFemales=" + this.numFemales + ", numEasternGreyKangaroos=" + this.numEasternGreyKangaroos + ", numWesternGreyKangaroos=" + this.numWesternGreyKangaroos + ", numRedKangaroos=" + this.numRedKangaroos + ", numPouchYoungDestroyed=" + this.numPouchYoungDestroyed + ", numYoungAtFootDestroyed=" + this.numYoungAtFootDestroyed + ", numTaggedCarcassesLeftOnProperty=" + this.numTaggedCarcassesLeftOnProperty + ", numTaggedCarcassesStoredForProcessor=" + this.numTaggedCarcassesStoredForProcessor + ", comments=" + this.comments + ", tags=" + this.tags + ")";
    }

    public HarvestBatch(String str, String str2, String str3, String str4, String str5, boolean z, Date date, Date date2, double d, double d2, int i, Integer num, int i2, Integer num2, int i3, int i4, int i5, int i6, String str6, List<HarvestTag> list) {
        Intrinsics.checkNotNullParameter(str, "quotaId");
        Intrinsics.checkNotNullParameter(str2, "harvesterId");
        Intrinsics.checkNotNullParameter(str3, AuthorizationRequest.Scope.ADDRESS);
        Intrinsics.checkNotNullParameter(date, "consentDateTime");
        Intrinsics.checkNotNullParameter(date2, "dateOfHarvest");
        Intrinsics.checkNotNullParameter(str6, "comments");
        Intrinsics.checkNotNullParameter(list, "tags");
        this.quotaId = str;
        this.harvesterId = str2;
        this.address = str3;
        this.landholderName = str4;
        this.landholderContactNumber = str5;
        this.consentCaptured = z;
        this.consentDateTime = date;
        this.dateOfHarvest = date2;
        this.scanLatitude = d;
        this.scanLongitude = d2;
        this.numFemales = i;
        this.numEasternGreyKangaroos = num;
        this.numWesternGreyKangaroos = i2;
        this.numRedKangaroos = num2;
        this.numPouchYoungDestroyed = i3;
        this.numYoungAtFootDestroyed = i4;
        this.numTaggedCarcassesLeftOnProperty = i5;
        this.numTaggedCarcassesStoredForProcessor = i6;
        this.comments = str6;
        this.tags = list;
    }

    public final String getQuotaId() {
        return this.quotaId;
    }

    public final void setQuotaId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.quotaId = str;
    }

    public final String getHarvesterId() {
        return this.harvesterId;
    }

    public final void setHarvesterId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.harvesterId = str;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.address = str;
    }

    public final String getLandholderName() {
        return this.landholderName;
    }

    public final void setLandholderName(String str) {
        this.landholderName = str;
    }

    public final String getLandholderContactNumber() {
        return this.landholderContactNumber;
    }

    public final void setLandholderContactNumber(String str) {
        this.landholderContactNumber = str;
    }

    public final boolean getConsentCaptured() {
        return this.consentCaptured;
    }

    public final void setConsentCaptured(boolean z) {
        this.consentCaptured = z;
    }

    public final Date getConsentDateTime() {
        return this.consentDateTime;
    }

    public final void setConsentDateTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.consentDateTime = date;
    }

    public final Date getDateOfHarvest() {
        return this.dateOfHarvest;
    }

    public final void setDateOfHarvest(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.dateOfHarvest = date;
    }

    public final double getScanLatitude() {
        return this.scanLatitude;
    }

    public final void setScanLatitude(double d) {
        this.scanLatitude = d;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HarvestBatch(String str, String str2, String str3, String str4, String str5, boolean z, Date date, Date date2, double d, double d2, int i, Integer num, int i2, Integer num2, int i3, int i4, int i5, int i6, String str6, List list, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, z, date, date2, (i7 & 256) != 0 ? 0.0d : d, (i7 & 512) != 0 ? 0.0d : d2, i, num, i2, num2, i3, i4, i5, i6, str6, list);
    }

    public final double getScanLongitude() {
        return this.scanLongitude;
    }

    public final void setScanLongitude(double d) {
        this.scanLongitude = d;
    }

    public final int getNumFemales() {
        return this.numFemales;
    }

    public final void setNumFemales(int i) {
        this.numFemales = i;
    }

    public final Integer getNumEasternGreyKangaroos() {
        return this.numEasternGreyKangaroos;
    }

    public final void setNumEasternGreyKangaroos(Integer num) {
        this.numEasternGreyKangaroos = num;
    }

    public final int getNumWesternGreyKangaroos() {
        return this.numWesternGreyKangaroos;
    }

    public final void setNumWesternGreyKangaroos(int i) {
        this.numWesternGreyKangaroos = i;
    }

    public final Integer getNumRedKangaroos() {
        return this.numRedKangaroos;
    }

    public final void setNumRedKangaroos(Integer num) {
        this.numRedKangaroos = num;
    }

    public final int getNumPouchYoungDestroyed() {
        return this.numPouchYoungDestroyed;
    }

    public final void setNumPouchYoungDestroyed(int i) {
        this.numPouchYoungDestroyed = i;
    }

    public final int getNumYoungAtFootDestroyed() {
        return this.numYoungAtFootDestroyed;
    }

    public final void setNumYoungAtFootDestroyed(int i) {
        this.numYoungAtFootDestroyed = i;
    }

    public final int getNumTaggedCarcassesLeftOnProperty() {
        return this.numTaggedCarcassesLeftOnProperty;
    }

    public final void setNumTaggedCarcassesLeftOnProperty(int i) {
        this.numTaggedCarcassesLeftOnProperty = i;
    }

    public final int getNumTaggedCarcassesStoredForProcessor() {
        return this.numTaggedCarcassesStoredForProcessor;
    }

    public final void setNumTaggedCarcassesStoredForProcessor(int i) {
        this.numTaggedCarcassesStoredForProcessor = i;
    }

    public final String getComments() {
        return this.comments;
    }

    public final void setComments(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.comments = str;
    }

    public final List<HarvestTag> getTags() {
        return this.tags;
    }

    public final void setTags(List<HarvestTag> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.tags = list;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public HarvestBatch(SavedHarvestTagBatch savedHarvestTagBatch) {
        this(r2, r3, r4, r5, r6, true, r8, r9, r12, r10, r0, r16, r17, r18, r19, r20, r21, r22, r24, r7);
        Intrinsics.checkNotNullParameter(savedHarvestTagBatch, "batch");
        String quotaId2 = savedHarvestTagBatch.getBatch().getQuotaId();
        String harvesterId2 = savedHarvestTagBatch.getBatch().getHarvesterId();
        String address2 = savedHarvestTagBatch.getBatch().getAddress();
        String landholderName2 = savedHarvestTagBatch.getBatch().getLandholderName();
        String landholderContactNumber2 = savedHarvestTagBatch.getBatch().getLandholderContactNumber();
        Date consentDateTime2 = savedHarvestTagBatch.getBatch().getConsentDateTime();
        Date dateOfHarvest2 = savedHarvestTagBatch.getBatch().getDateOfHarvest();
        Double scanLatitude2 = savedHarvestTagBatch.getBatch().getScanLatitude();
        double d = 0.0d;
        double doubleValue = scanLatitude2 != null ? scanLatitude2.doubleValue() : 0.0d;
        Double scanLongitude2 = savedHarvestTagBatch.getBatch().getScanLongitude();
        d = scanLongitude2 != null ? scanLongitude2.doubleValue() : d;
        int numFemales2 = savedHarvestTagBatch.getBatch().getNumFemales();
        Integer numEasternGreyKangaroos2 = savedHarvestTagBatch.getBatch().getNumEasternGreyKangaroos();
        int numWesternGreyKangaroos2 = savedHarvestTagBatch.getBatch().getNumWesternGreyKangaroos();
        Integer numRedKangaroos2 = savedHarvestTagBatch.getBatch().getNumRedKangaroos();
        int numPouchYoungDestroyed2 = savedHarvestTagBatch.getBatch().getNumPouchYoungDestroyed();
        int numYoungAtFootDestroyed2 = savedHarvestTagBatch.getBatch().getNumYoungAtFootDestroyed();
        int numTaggedCarcassesLeftOnProperty2 = savedHarvestTagBatch.getBatch().getNumTaggedCarcassesLeftOnProperty();
        int numTaggedCarcassesStoredForProcessor2 = savedHarvestTagBatch.getBatch().getNumTaggedCarcassesStoredForProcessor();
        String comments2 = savedHarvestTagBatch.getBatch().getComments();
        Intrinsics.checkNotNull(comments2);
        List<SavedHarvestTag> tags2 = savedHarvestTagBatch.getTags();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(tags2, 10));
        Iterator<T> it = tags2.iterator();
        while (it.hasNext()) {
            arrayList.add(new HarvestTag(it.next().getTagNumber()));
            it = it;
            numFemales2 = numFemales2;
        }
    }
}
