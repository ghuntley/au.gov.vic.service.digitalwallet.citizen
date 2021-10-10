package com.digitalwallet.app.model.db.harvester;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0018JZ\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010¨\u00061"}, d2 = {"Lcom/digitalwallet/app/model/db/harvester/SavedHarvestJob;", "", "agencyIdentifier", "", "consentDateTime", "Ljava/util/Date;", "quotaId", "harvestAddress", "landholderName", "landholderContactNumber", "id", "", "(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getAgencyIdentifier", "()Ljava/lang/String;", "setAgencyIdentifier", "(Ljava/lang/String;)V", "getConsentDateTime", "()Ljava/util/Date;", "setConsentDateTime", "(Ljava/util/Date;)V", "getHarvestAddress", "setHarvestAddress", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLandholderContactNumber", "setLandholderContactNumber", "getLandholderName", "setLandholderName", "getQuotaId", "setQuotaId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/digitalwallet/app/model/db/harvester/SavedHarvestJob;", "equals", "", "other", "hashCode", "", "toString", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestLocalModel.kt */
public final class SavedHarvestJob {
    private String agencyIdentifier;
    private Date consentDateTime;
    private String harvestAddress;
    private Long id;
    private String landholderContactNumber;
    private String landholderName;
    private String quotaId;

    public static /* synthetic */ SavedHarvestJob copy$default(SavedHarvestJob savedHarvestJob, String str, Date date, String str2, String str3, String str4, String str5, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = savedHarvestJob.agencyIdentifier;
        }
        if ((i & 2) != 0) {
            date = savedHarvestJob.consentDateTime;
        }
        if ((i & 4) != 0) {
            str2 = savedHarvestJob.quotaId;
        }
        if ((i & 8) != 0) {
            str3 = savedHarvestJob.harvestAddress;
        }
        if ((i & 16) != 0) {
            str4 = savedHarvestJob.landholderName;
        }
        if ((i & 32) != 0) {
            str5 = savedHarvestJob.landholderContactNumber;
        }
        if ((i & 64) != 0) {
            l = savedHarvestJob.id;
        }
        return savedHarvestJob.copy(str, date, str2, str3, str4, str5, l);
    }

    public final String component1() {
        return this.agencyIdentifier;
    }

    public final Date component2() {
        return this.consentDateTime;
    }

    public final String component3() {
        return this.quotaId;
    }

    public final String component4() {
        return this.harvestAddress;
    }

    public final String component5() {
        return this.landholderName;
    }

    public final String component6() {
        return this.landholderContactNumber;
    }

    public final Long component7() {
        return this.id;
    }

    public final SavedHarvestJob copy(String str, Date date, String str2, String str3, String str4, String str5, Long l) {
        Intrinsics.checkNotNullParameter(str, "agencyIdentifier");
        Intrinsics.checkNotNullParameter(date, "consentDateTime");
        Intrinsics.checkNotNullParameter(str2, "quotaId");
        Intrinsics.checkNotNullParameter(str3, "harvestAddress");
        return new SavedHarvestJob(str, date, str2, str3, str4, str5, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SavedHarvestJob)) {
            return false;
        }
        SavedHarvestJob savedHarvestJob = (SavedHarvestJob) obj;
        return Intrinsics.areEqual(this.agencyIdentifier, savedHarvestJob.agencyIdentifier) && Intrinsics.areEqual(this.consentDateTime, savedHarvestJob.consentDateTime) && Intrinsics.areEqual(this.quotaId, savedHarvestJob.quotaId) && Intrinsics.areEqual(this.harvestAddress, savedHarvestJob.harvestAddress) && Intrinsics.areEqual(this.landholderName, savedHarvestJob.landholderName) && Intrinsics.areEqual(this.landholderContactNumber, savedHarvestJob.landholderContactNumber) && Intrinsics.areEqual(this.id, savedHarvestJob.id);
    }

    public int hashCode() {
        String str = this.agencyIdentifier;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Date date = this.consentDateTime;
        int hashCode2 = (hashCode + (date != null ? date.hashCode() : 0)) * 31;
        String str2 = this.quotaId;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.harvestAddress;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.landholderName;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.landholderContactNumber;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Long l = this.id;
        if (l != null) {
            i = l.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "SavedHarvestJob(agencyIdentifier=" + this.agencyIdentifier + ", consentDateTime=" + this.consentDateTime + ", quotaId=" + this.quotaId + ", harvestAddress=" + this.harvestAddress + ", landholderName=" + this.landholderName + ", landholderContactNumber=" + this.landholderContactNumber + ", id=" + this.id + ")";
    }

    public SavedHarvestJob(String str, Date date, String str2, String str3, String str4, String str5, Long l) {
        Intrinsics.checkNotNullParameter(str, "agencyIdentifier");
        Intrinsics.checkNotNullParameter(date, "consentDateTime");
        Intrinsics.checkNotNullParameter(str2, "quotaId");
        Intrinsics.checkNotNullParameter(str3, "harvestAddress");
        this.agencyIdentifier = str;
        this.consentDateTime = date;
        this.quotaId = str2;
        this.harvestAddress = str3;
        this.landholderName = str4;
        this.landholderContactNumber = str5;
        this.id = l;
    }

    public final String getAgencyIdentifier() {
        return this.agencyIdentifier;
    }

    public final void setAgencyIdentifier(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.agencyIdentifier = str;
    }

    public final Date getConsentDateTime() {
        return this.consentDateTime;
    }

    public final void setConsentDateTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.consentDateTime = date;
    }

    public final String getQuotaId() {
        return this.quotaId;
    }

    public final void setQuotaId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.quotaId = str;
    }

    public final String getHarvestAddress() {
        return this.harvestAddress;
    }

    public final void setHarvestAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.harvestAddress = str;
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SavedHarvestJob(String str, Date date, String str2, String str3, String str4, String str5, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, date, str2, str3, str4, str5, (i & 64) != 0 ? null : l);
    }

    public final Long getId() {
        return this.id;
    }

    public final void setId(Long l) {
        this.id = l;
    }
}
