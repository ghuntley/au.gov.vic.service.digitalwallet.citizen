package com.digitalwallet.app.model.db.shares;

import android.content.Context;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.Asset;
import com.digitalwallet.app.model.AttributeDetailItem;
import com.digitalwallet.app.model.DynamicHoldingDisplay;
import com.digitalwallet.app.model.DynamicHoldingDisplayDetail;
import com.digitalwallet.app.model.HoldingAddress;
import com.digitalwallet.app.model.HoldingEmail;
import com.digitalwallet.app.model.HoldingKt;
import com.digitalwallet.app.model.HoldingPhone;
import com.digitalwallet.app.model.HoldingRecordAttributes;
import com.digitalwallet.app.model.HoldingType;
import com.digitalwallet.app.model.ShareHolding;
import com.digitalwallet.app.model.SubType;
import com.digitalwallet.app.view.util.ViewUtilsKt;
import com.digitalwallet.utilities.DateFormattingHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tB1\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eBË\u0001\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0012\u0012\u0006\u0010\u001a\u001a\u00020\u0012\u0012\u0006\u0010\u001b\u001a\u00020\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u0012\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0012\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010#\u001a\u00020$\u0012\u0006\u0010%\u001a\u00020\u0012¢\u0006\u0002\u0010&J\u0006\u0010C\u001a\u00020\u0012J\u000e\u0010D\u001a\u00020\u00122\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020HJ\f\u0010I\u001a\b\u0012\u0004\u0012\u00020J0\u0007J\f\u0010K\u001a\b\u0012\u0004\u0012\u00020J0\u0007R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\u001f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u001b\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u001c\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(R\u0011\u0010\u0018\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b1\u0010(R\u0011\u0010\u0019\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b2\u0010(R\u0011\u0010\u0013\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b3\u0010(R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u001a\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b6\u0010(R\u0011\u0010\u0015\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b7\u0010(R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b8\u0010(R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b9\u0010(R\u0013\u0010 \u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b:\u0010(R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b;\u0010(R\u0013\u0010!\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b<\u0010(R\u0011\u0010%\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b=\u0010(R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010\u0016\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b@\u0010(R\u0011\u0010\u0017\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bA\u0010(R\u0011\u0010\u0014\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bB\u0010(¨\u0006L"}, d2 = {"Lcom/digitalwallet/app/model/db/shares/ShareRecord;", "", "receivedHolding", "Lcom/digitalwallet/app/model/HoldingRecordAttributes;", "dynamicDisplay", "Lcom/digitalwallet/app/model/DynamicHoldingDisplay;", ShareHolding.assetDataKey, "", "Lcom/digitalwallet/app/model/Asset;", "(Lcom/digitalwallet/app/model/HoldingRecordAttributes;Lcom/digitalwallet/app/model/DynamicHoldingDisplay;Ljava/util/List;)V", "sender", "senderDynamicDisplay", "senderAssets", "receiver", "(Lcom/digitalwallet/app/model/HoldingRecordAttributes;Lcom/digitalwallet/app/model/DynamicHoldingDisplay;Ljava/util/List;Lcom/digitalwallet/app/model/HoldingRecordAttributes;)V", "id", "", "licenceNumber", "", "holdingTypeString", "subTypeString", "licenceKind", "startDate", "startTime", "expiryDate", "firstName", "lastName", "dateOfBirth", "email", AuthorizationRequest.Scope.PHONE, AuthorizationRequest.Scope.ADDRESS, "attributes", "receiverFirstName", "receiverLastName", "receiverIdentifier", "shareTime", "", "shareDate", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/digitalwallet/app/model/HoldingRecordAttributes;Lcom/digitalwallet/app/model/DynamicHoldingDisplay;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getAssets", "()Ljava/util/List;", "getAttributes", "()Lcom/digitalwallet/app/model/HoldingRecordAttributes;", "getDateOfBirth", "getDynamicDisplay", "()Lcom/digitalwallet/app/model/DynamicHoldingDisplay;", "getEmail", "getExpiryDate", "getFirstName", "getHoldingTypeString", "getId", "()I", "getLastName", "getLicenceKind", "getLicenceNumber", "getPhone", "getReceiverFirstName", "getReceiverIdentifier", "getReceiverLastName", "getShareDate", "getShareTime", "()J", "getStartDate", "getStartTime", "getSubTypeString", "getFullName", "getHoldingName", "context", "Landroid/content/Context;", "overADayOld", "", "receiverDetailsAsList", "Lcom/digitalwallet/app/model/AttributeDetailItem;", "senderDetailsAsList", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ShareRecord.kt */
public final class ShareRecord {
    private final String address;
    private final List<Asset> assets;
    private final HoldingRecordAttributes attributes;
    private final String dateOfBirth;
    private final DynamicHoldingDisplay dynamicDisplay;
    private final String email;
    private final String expiryDate;
    private final String firstName;
    private final String holdingTypeString;
    private final int id;
    private final String lastName;
    private final String licenceKind;
    private final String licenceNumber;
    private final String phone;
    private final String receiverFirstName;
    private final String receiverIdentifier;
    private final String receiverLastName;
    private final String shareDate;
    private final long shareTime;
    private final String startDate;
    private final String startTime;
    private final String subTypeString;

    public ShareRecord(HoldingRecordAttributes holdingRecordAttributes, DynamicHoldingDisplay dynamicHoldingDisplay, List<Asset> list) {
        Intrinsics.checkNotNullParameter(holdingRecordAttributes, "receivedHolding");
        this.id = 0;
        this.licenceNumber = holdingRecordAttributes.getIdentifier();
        this.holdingTypeString = HoldingKt.holdingType(dynamicHoldingDisplay != null ? dynamicHoldingDisplay.getCardTemplate() : null, holdingRecordAttributes).name();
        this.subTypeString = holdingRecordAttributes.getSubtype();
        this.licenceKind = holdingRecordAttributes.getLicenceKindToDisplay();
        this.startDate = DateFormattingHelper.INSTANCE.toDateWithMonthAsWord(holdingRecordAttributes.getStartDateTime());
        this.startTime = DateFormattingHelper.INSTANCE.tryParseToShowTime(holdingRecordAttributes.getStartDateTime());
        this.expiryDate = DateFormattingHelper.INSTANCE.toDateWithMonthAsWord(holdingRecordAttributes.getExpiry());
        this.firstName = holdingRecordAttributes.getFirstName();
        this.lastName = holdingRecordAttributes.getLastName();
        this.dateOfBirth = DateFormattingHelper.INSTANCE.toDateWithMonthAsWord(holdingRecordAttributes.getDateOfBirth());
        this.email = ((HoldingEmail) CollectionsKt.first((List) holdingRecordAttributes.getEmailContact())).getEmail();
        this.phone = ((HoldingPhone) CollectionsKt.first((List) holdingRecordAttributes.getPhoneContact())).getNumber();
        HoldingAddress holdingAddress = (HoldingAddress) CollectionsKt.firstOrNull((List) holdingRecordAttributes.getAddresses());
        this.address = holdingAddress != null ? holdingAddress.getWholeAddressAsString() : null;
        this.attributes = holdingRecordAttributes;
        this.dynamicDisplay = dynamicHoldingDisplay;
        this.assets = list;
        String str = null;
        this.receiverFirstName = str;
        this.receiverLastName = str;
        this.receiverIdentifier = str;
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
        this.shareTime = instance.getTimeInMillis();
        this.shareDate = DateFormattingHelper.INSTANCE.getCurrentDateWithMonthAsWord();
    }

    public ShareRecord(HoldingRecordAttributes holdingRecordAttributes, DynamicHoldingDisplay dynamicHoldingDisplay, List<Asset> list, HoldingRecordAttributes holdingRecordAttributes2) {
        Intrinsics.checkNotNullParameter(holdingRecordAttributes, "sender");
        Intrinsics.checkNotNullParameter(holdingRecordAttributes2, "receiver");
        this.id = 0;
        this.licenceNumber = holdingRecordAttributes.getIdentifier();
        String str = null;
        this.holdingTypeString = HoldingKt.holdingType(dynamicHoldingDisplay != null ? dynamicHoldingDisplay.getCardTemplate() : null, holdingRecordAttributes).name();
        this.subTypeString = holdingRecordAttributes.getSubtype();
        this.licenceKind = holdingRecordAttributes.getLicenceKindToDisplay();
        this.startDate = DateFormattingHelper.INSTANCE.toDateWithMonthAsWord(holdingRecordAttributes.getStartDateTime());
        this.startTime = DateFormattingHelper.INSTANCE.tryParseToShowTime(holdingRecordAttributes.getStartDateTime());
        this.expiryDate = DateFormattingHelper.INSTANCE.toDateWithMonthAsWord(holdingRecordAttributes.getExpiry());
        this.firstName = holdingRecordAttributes.getFirstName();
        this.lastName = holdingRecordAttributes.getLastName();
        this.dateOfBirth = DateFormattingHelper.INSTANCE.toDateWithMonthAsWord(holdingRecordAttributes.getDateOfBirth());
        this.email = ((HoldingEmail) CollectionsKt.first((List) holdingRecordAttributes.getEmailContact())).getEmail();
        this.phone = ((HoldingPhone) CollectionsKt.first((List) holdingRecordAttributes.getPhoneContact())).getNumber();
        HoldingAddress holdingAddress = (HoldingAddress) CollectionsKt.firstOrNull((List) holdingRecordAttributes.getAddresses());
        this.address = holdingAddress != null ? holdingAddress.getWholeAddressAsString() : str;
        this.attributes = holdingRecordAttributes;
        this.dynamicDisplay = dynamicHoldingDisplay;
        this.assets = list;
        this.receiverFirstName = holdingRecordAttributes2.getFirstName();
        this.receiverLastName = holdingRecordAttributes2.getLastName();
        this.receiverIdentifier = holdingRecordAttributes2.getIdentifier();
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
        this.shareTime = instance.getTimeInMillis();
        this.shareDate = DateFormattingHelper.INSTANCE.getCurrentDateWithMonthAsWord();
    }

    public ShareRecord(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, HoldingRecordAttributes holdingRecordAttributes, DynamicHoldingDisplay dynamicHoldingDisplay, List<Asset> list, String str14, String str15, String str16, long j, String str17) {
        Intrinsics.checkNotNullParameter(str, "licenceNumber");
        Intrinsics.checkNotNullParameter(str2, "holdingTypeString");
        Intrinsics.checkNotNullParameter(str3, "subTypeString");
        Intrinsics.checkNotNullParameter(str4, "licenceKind");
        Intrinsics.checkNotNullParameter(str5, "startDate");
        Intrinsics.checkNotNullParameter(str6, "startTime");
        Intrinsics.checkNotNullParameter(str7, "expiryDate");
        Intrinsics.checkNotNullParameter(str8, "firstName");
        Intrinsics.checkNotNullParameter(str9, "lastName");
        Intrinsics.checkNotNullParameter(str10, "dateOfBirth");
        Intrinsics.checkNotNullParameter(str11, "email");
        Intrinsics.checkNotNullParameter(holdingRecordAttributes, "attributes");
        Intrinsics.checkNotNullParameter(str17, "shareDate");
        this.id = i;
        this.licenceNumber = str;
        this.holdingTypeString = str2;
        this.subTypeString = str3;
        this.licenceKind = str4;
        this.startDate = str5;
        this.startTime = str6;
        this.expiryDate = str7;
        this.firstName = str8;
        this.lastName = str9;
        this.dateOfBirth = str10;
        this.email = str11;
        this.phone = str12;
        this.address = str13;
        this.attributes = holdingRecordAttributes;
        this.dynamicDisplay = dynamicHoldingDisplay;
        this.assets = list;
        this.receiverFirstName = str14;
        this.receiverLastName = str15;
        this.receiverIdentifier = str16;
        this.shareTime = j;
        this.shareDate = str17;
    }

    public final boolean overADayOld() {
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "Calendar.getInstance()");
        return instance.getTimeInMillis() - this.shareTime > DateFormattingHelper.DAY_IN_MS;
    }

    public final String getHoldingName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = this.holdingTypeString;
        HoldingType holdingType = HoldingType.UNKNOWN;
        try {
            holdingType = HoldingType.valueOf(str);
        } catch (Throwable unused) {
        }
        HoldingType holdingType2 = holdingType;
        String str2 = this.subTypeString;
        SubType subType = SubType.UNKNOWN;
        try {
            subType = SubType.valueOf(str2);
        } catch (Throwable unused2) {
        }
        String holdingDetailTitle = HoldingKt.getHoldingDetailTitle(context, holdingType2, subType, this.dynamicDisplay);
        return holdingDetailTitle != null ? holdingDetailTitle : "UNKNOWN";
    }

    public final String getFullName() {
        return this.firstName + ' ' + this.lastName;
    }

    public final List<AttributeDetailItem> senderDetailsAsList() {
        List<DynamicHoldingDisplayDetail> displayDetails;
        DynamicHoldingDisplay dynamicHoldingDisplay = this.dynamicDisplay;
        if (dynamicHoldingDisplay == null || (displayDetails = dynamicHoldingDisplay.getDisplayDetails()) == null) {
            return ViewUtilsKt.toAttributeDetailItem(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(Integer.valueOf((int) R.string.detail_licence_number), this.licenceNumber), TuplesKt.to(Integer.valueOf((int) R.string.detail_licence_type), this.licenceKind), TuplesKt.to(Integer.valueOf((int) R.string.detail_start_date), this.startDate), TuplesKt.to(Integer.valueOf((int) R.string.detail_start_time), this.startTime), TuplesKt.to(Integer.valueOf((int) R.string.detail_expiry_date), this.expiryDate), TuplesKt.to(Integer.valueOf((int) R.string.detail_given_name), this.firstName), TuplesKt.to(Integer.valueOf((int) R.string.detail_family_name), this.lastName), TuplesKt.to(Integer.valueOf((int) R.string.detail_date_of_birth), this.dateOfBirth), TuplesKt.to(Integer.valueOf((int) R.string.detail_email), this.email), TuplesKt.to(Integer.valueOf((int) R.string.detail_phone), this.phone), TuplesKt.to(Integer.valueOf((int) R.string.detail_address), this.address)}));
        }
        List<DynamicHoldingDisplayDetail> list = displayDetails;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            arrayList.add(new AttributeDetailItem(t.getLabel(), t.getValue()));
        }
        return arrayList;
    }

    public final List<AttributeDetailItem> receiverDetailsAsList() {
        return ViewUtilsKt.toAttributeDetailItem(CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(Integer.valueOf((int) R.string.share_officer_first_name), this.receiverFirstName), TuplesKt.to(Integer.valueOf((int) R.string.share_officer_last_name), this.receiverLastName), TuplesKt.to(Integer.valueOf((int) R.string.share_officer_identifier), this.receiverIdentifier)}));
    }

    public final int getId() {
        return this.id;
    }

    public final String getLicenceNumber() {
        return this.licenceNumber;
    }

    public final String getHoldingTypeString() {
        return this.holdingTypeString;
    }

    public final String getSubTypeString() {
        return this.subTypeString;
    }

    public final String getLicenceKind() {
        return this.licenceKind;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getExpiryDate() {
        return this.expiryDate;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getAddress() {
        return this.address;
    }

    public final HoldingRecordAttributes getAttributes() {
        return this.attributes;
    }

    public final DynamicHoldingDisplay getDynamicDisplay() {
        return this.dynamicDisplay;
    }

    public final List<Asset> getAssets() {
        return this.assets;
    }

    public final String getReceiverFirstName() {
        return this.receiverFirstName;
    }

    public final String getReceiverLastName() {
        return this.receiverLastName;
    }

    public final String getReceiverIdentifier() {
        return this.receiverIdentifier;
    }

    public final long getShareTime() {
        return this.shareTime;
    }

    public final String getShareDate() {
        return this.shareDate;
    }
}
