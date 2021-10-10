package com.digitalwallet.app.model.db.harvester;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b;\b\u0007\u0018\u00002\u00020\u0001B·\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0011\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010(\"\u0004\b,\u0010*R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001e\"\u0004\b.\u0010 R\"\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b/\u00100\"\u0004\b1\u00102R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001e\"\u0004\b5\u0010 R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001e\"\u0004\b7\u0010 R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010\u0015\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010>\"\u0004\bB\u0010@R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\bC\u00109\"\u0004\bD\u0010;R\u001a\u0010\u0017\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010>\"\u0004\bF\u0010@R\u001a\u0010\u0018\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010>\"\u0004\bH\u0010@R\u001a\u0010\u0013\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010>\"\u0004\bJ\u0010@R\u001a\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010>\"\u0004\bL\u0010@R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u001e\"\u0004\bN\u0010 R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\bT\u0010P\"\u0004\bU\u0010R¨\u0006V"}, d2 = {"Lcom/digitalwallet/app/model/db/harvester/SavedHarvestBatch;", "", "harvesterId", "", "quotaId", AuthorizationRequest.Scope.ADDRESS, "landholderName", "landholderContactNumber", "consentCaptured", "", "consentDateTime", "Ljava/util/Date;", "dateOfHarvest", "scanLatitude", "", "scanLongitude", "numFemales", "", "numEasternGreyKangaroos", "numWesternGreyKangaroos", "numRedKangaroos", "numPouchYoungDestroyed", "numYoungAtFootDestroyed", "numTaggedCarcassesLeftOnProperty", "numTaggedCarcassesStoredForProcessor", "comments", "id", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Date;Ljava/util/Date;Ljava/lang/Double;Ljava/lang/Double;ILjava/lang/Integer;ILjava/lang/Integer;IIIILjava/lang/String;Ljava/lang/Long;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getComments", "setComments", "getConsentCaptured", "()Z", "setConsentCaptured", "(Z)V", "getConsentDateTime", "()Ljava/util/Date;", "setConsentDateTime", "(Ljava/util/Date;)V", "getDateOfHarvest", "setDateOfHarvest", "getHarvesterId", "setHarvesterId", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLandholderContactNumber", "setLandholderContactNumber", "getLandholderName", "setLandholderName", "getNumEasternGreyKangaroos", "()Ljava/lang/Integer;", "setNumEasternGreyKangaroos", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getNumFemales", "()I", "setNumFemales", "(I)V", "getNumPouchYoungDestroyed", "setNumPouchYoungDestroyed", "getNumRedKangaroos", "setNumRedKangaroos", "getNumTaggedCarcassesLeftOnProperty", "setNumTaggedCarcassesLeftOnProperty", "getNumTaggedCarcassesStoredForProcessor", "setNumTaggedCarcassesStoredForProcessor", "getNumWesternGreyKangaroos", "setNumWesternGreyKangaroos", "getNumYoungAtFootDestroyed", "setNumYoungAtFootDestroyed", "getQuotaId", "setQuotaId", "getScanLatitude", "()Ljava/lang/Double;", "setScanLatitude", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getScanLongitude", "setScanLongitude", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestLocalModel.kt */
public final class SavedHarvestBatch {
    private String address;
    private String comments;
    private boolean consentCaptured;
    private Date consentDateTime;
    private Date dateOfHarvest;
    private String harvesterId;
    private Long id;
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
    private Double scanLatitude;
    private Double scanLongitude;

    public SavedHarvestBatch(String str, String str2, String str3, String str4, String str5, boolean z, Date date, Date date2, Double d, Double d2, int i, Integer num, int i2, Integer num2, int i3, int i4, int i5, int i6, String str6, Long l) {
        Intrinsics.checkNotNullParameter(str, "harvesterId");
        Intrinsics.checkNotNullParameter(str2, "quotaId");
        Intrinsics.checkNotNullParameter(str3, AuthorizationRequest.Scope.ADDRESS);
        Intrinsics.checkNotNullParameter(date, "consentDateTime");
        Intrinsics.checkNotNullParameter(date2, "dateOfHarvest");
        this.harvesterId = str;
        this.quotaId = str2;
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
        this.id = l;
    }

    public final String getHarvesterId() {
        return this.harvesterId;
    }

    public final void setHarvesterId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.harvesterId = str;
    }

    public final String getQuotaId() {
        return this.quotaId;
    }

    public final void setQuotaId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.quotaId = str;
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

    public final Double getScanLatitude() {
        return this.scanLatitude;
    }

    public final void setScanLatitude(Double d) {
        this.scanLatitude = d;
    }

    public final Double getScanLongitude() {
        return this.scanLongitude;
    }

    public final void setScanLongitude(Double d) {
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
        this.comments = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SavedHarvestBatch(String str, String str2, String str3, String str4, String str5, boolean z, Date date, Date date2, Double d, Double d2, int i, Integer num, int i2, Integer num2, int i3, int i4, int i5, int i6, String str6, Long l, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, z, date, date2, d, d2, i, num, i2, num2, i3, i4, i5, i6, str6, (i7 & 524288) != 0 ? null : l);
    }

    public final Long getId() {
        return this.id;
    }

    public final void setId(Long l) {
        this.id = l;
    }
}
