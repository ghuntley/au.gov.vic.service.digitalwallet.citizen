package com.digitalwallet.app.viewmodel.main;

import androidx.databinding.ObservableField;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.AttributeDetailItem;
import com.digitalwallet.app.model.DynamicHoldingDisplay;
import com.digitalwallet.app.model.DynamicHoldingDisplayDetail;
import com.digitalwallet.app.model.HoldingAssets;
import com.digitalwallet.app.model.HoldingRecordAttributes;
import com.digitalwallet.app.model.HoldingType;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.utilities.DateFormattingHelper;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\rJ\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J\f\u00100\u001a\b\u0012\u0004\u0012\u00020201J\u0006\u00103\u001a\u00020)J\u0010\u00104\u001a\u00020-2\u0006\u00105\u001a\u00020\rH\u0002J\u0006\u00106\u001a\u00020)R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001f\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001f\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u001f\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u001a\u0010\u001b\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001f\u0010 \u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0010R\u001a\u0010\"\u001a\u00020#X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00067"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/HoldingDetailFragmentViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "(Lcom/digitalwallet/utilities/AnalyticsHelper;)V", "holdingAssets", "Lcom/digitalwallet/app/model/HoldingAssets;", "getHoldingAssets", "()Lcom/digitalwallet/app/model/HoldingAssets;", "setHoldingAssets", "(Lcom/digitalwallet/app/model/HoldingAssets;)V", "keepLandscapeOrientation", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getKeepLandscapeOrientation", "()Landroidx/databinding/ObservableField;", "secureHolding", "Lcom/digitalwallet/app/model/SecureHolding;", "getSecureHolding", "()Lcom/digitalwallet/app/model/SecureHolding;", "setSecureHolding", "(Lcom/digitalwallet/app/model/SecureHolding;)V", "showExpiryView", "getShowExpiryView", "showHoldingDetailAttributeView", "getShowHoldingDetailAttributeView", "showHoldingFrontView", "getShowHoldingFrontView", "()Z", "setShowHoldingFrontView", "(Z)V", "showNotificationBanner", "getShowNotificationBanner", Promotion.ACTION_VIEW, "Lcom/digitalwallet/app/viewmodel/main/HoldingDetailView;", "getView", "()Lcom/digitalwallet/app/viewmodel/main/HoldingDetailView;", "setView", "(Lcom/digitalwallet/app/viewmodel/main/HoldingDetailView;)V", "changeToPortraitOrientation", "", "flipCard", "flipFromLeftToRight", "getAccreditationDetails", "", "credHolding", "Lcom/digitalwallet/app/model/HoldingRecordAttributes;", "getHoldingDetailItems", "", "Lcom/digitalwallet/app/model/AttributeDetailItem;", "startHoldingDisclaimerFragment", "stringForCred", "cred", "viewCard", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HoldingDetailFragmentViewModel.kt */
public final class HoldingDetailFragmentViewModel extends BaseViewModel {
    private AnalyticsHelper analytics;
    private HoldingAssets holdingAssets;
    private final ObservableField<Boolean> keepLandscapeOrientation = new ObservableField<>((Boolean) false);
    private SecureHolding secureHolding;
    private final ObservableField<Boolean> showExpiryView = new ObservableField<>((Boolean) false);
    private final ObservableField<Boolean> showHoldingDetailAttributeView = new ObservableField<>((Boolean) true);
    private boolean showHoldingFrontView = true;
    private final ObservableField<Boolean> showNotificationBanner = new ObservableField<>((Boolean) false);
    public HoldingDetailView view;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HoldingType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[HoldingType.FISHING_LICENCE.ordinal()] = 1;
            iArr[HoldingType.SOLAR_INSTALLER.ordinal()] = 2;
            iArr[HoldingType.AMBULANCE_VICTORIA.ordinal()] = 3;
            iArr[HoldingType.WORKSAFE_LICENCE.ordinal()] = 4;
            iArr[HoldingType.WWC_CHECK.ordinal()] = 5;
            iArr[HoldingType.KANGAROO_HARVESTER.ordinal()] = 6;
            iArr[HoldingType.TEMPLATE.ordinal()] = 7;
        }
    }

    private final String stringForCred(boolean z) {
        return z ? "(Yes)" : "(No)";
    }

    @Inject
    public HoldingDetailFragmentViewModel(AnalyticsHelper analyticsHelper) {
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        this.analytics = analyticsHelper;
    }

    public final HoldingDetailView getView() {
        HoldingDetailView holdingDetailView = this.view;
        if (holdingDetailView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
        }
        return holdingDetailView;
    }

    public final void setView(HoldingDetailView holdingDetailView) {
        Intrinsics.checkNotNullParameter(holdingDetailView, "<set-?>");
        this.view = holdingDetailView;
    }

    public final ObservableField<Boolean> getShowHoldingDetailAttributeView() {
        return this.showHoldingDetailAttributeView;
    }

    public final ObservableField<Boolean> getShowNotificationBanner() {
        return this.showNotificationBanner;
    }

    public final ObservableField<Boolean> getKeepLandscapeOrientation() {
        return this.keepLandscapeOrientation;
    }

    public final ObservableField<Boolean> getShowExpiryView() {
        return this.showExpiryView;
    }

    public final boolean getShowHoldingFrontView() {
        return this.showHoldingFrontView;
    }

    public final void setShowHoldingFrontView(boolean z) {
        this.showHoldingFrontView = z;
    }

    public final SecureHolding getSecureHolding() {
        return this.secureHolding;
    }

    public final void setSecureHolding(SecureHolding secureHolding2) {
        this.secureHolding = secureHolding2;
    }

    public final HoldingAssets getHoldingAssets() {
        return this.holdingAssets;
    }

    public final void setHoldingAssets(HoldingAssets holdingAssets2) {
        this.holdingAssets = holdingAssets2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    public final List<AttributeDetailItem> getHoldingDetailItems() {
        HoldingRecordAttributes attributes;
        ArrayList arrayList;
        DynamicHoldingDisplay dynamicDisplay;
        List<DynamicHoldingDisplayDetail> displayDetails;
        SecureHolding secureHolding2 = this.secureHolding;
        if (!(secureHolding2 == null || (attributes = secureHolding2.getAttributes()) == null)) {
            SecureHolding secureHolding3 = this.secureHolding;
            HoldingType holdingType = secureHolding3 != null ? secureHolding3.getHoldingType() : null;
            if (holdingType != null) {
                switch (WhenMappings.$EnumSwitchMapping$0[holdingType.ordinal()]) {
                    case 1:
                        arrayList = CollectionsKt.listOf((Object[]) new AttributeDetailItem[]{new AttributeDetailItem((int) R.string.detail_licence_type, attributes.getLicenceKindToDisplay()), new AttributeDetailItem((int) R.string.detail_start_date, DateFormattingHelper.INSTANCE.toDateWithMonthAsWord(attributes.getStartDateTime())), new AttributeDetailItem((int) R.string.detail_start_time, attributes.getStartTimeFormatted()), new AttributeDetailItem((int) R.string.detail_expiry_date, DateFormattingHelper.INSTANCE.toDateWithMonthAsWord(attributes.getExpiry())), new AttributeDetailItem((int) R.string.detail_given_name, attributes.getFirstName()), new AttributeDetailItem((int) R.string.detail_family_name, attributes.getLastName()), new AttributeDetailItem((int) R.string.detail_date_of_birth, DateFormattingHelper.INSTANCE.toDateWithMonthAsWord(attributes.getDateOfBirth())), new AttributeDetailItem((int) R.string.detail_email, attributes.getEmailContact().get(0).getEmail()), new AttributeDetailItem((int) R.string.detail_phone, String.valueOf(attributes.getPhoneContact().get(0).getNumber())), new AttributeDetailItem((int) R.string.detail_address, attributes.getAddresses().get(0).getWholeAddressAsString())});
                        break;
                    case 2:
                        arrayList = CollectionsKt.listOf((Object[]) new AttributeDetailItem[]{new AttributeDetailItem((int) R.string.detail_accreditation_number, attributes.getIdentifier()), new AttributeDetailItem((int) R.string.detail_given_name, attributes.getFirstName()), new AttributeDetailItem((int) R.string.detail_family_name, attributes.getLastName()), new AttributeDetailItem((int) R.string.detail_expires, DateFormattingHelper.INSTANCE.toDateWithMonthAsWord(attributes.getExpiry())), new AttributeDetailItem((int) R.string.detail_installer_accreditations, getAccreditationDetails(attributes)), new AttributeDetailItem((int) R.string.detail_status, attributes.getHoldingStateToDisplay())});
                        break;
                    case 3:
                        arrayList = CollectionsKt.listOf((Object[]) new AttributeDetailItem[]{new AttributeDetailItem((int) R.string.detail_membership_type, attributes.getLicenceKindToDisplay()), new AttributeDetailItem((int) R.string.detail_end_date, DateFormattingHelper.INSTANCE.toDateWithMonthAsWord(attributes.getExpiry())), new AttributeDetailItem((int) R.string.detail_given_name, attributes.getFirstName()), new AttributeDetailItem((int) R.string.detail_family_name, attributes.getLastName())});
                        break;
                    case 4:
                        arrayList = CollectionsKt.listOf((Object[]) new AttributeDetailItem[]{new AttributeDetailItem((int) R.string.detail_licence_type, attributes.getSubtypeDisplayName()), new AttributeDetailItem((int) R.string.detail_licence_class, attributes.getLicenceClass()), new AttributeDetailItem((int) R.string.detail_licence_conditions, attributes.getLicenceConditions()), new AttributeDetailItem((int) R.string.detail_valid_from, DateFormattingHelper.INSTANCE.toDate(attributes.getStartDateTime())), new AttributeDetailItem((int) R.string.detail_end_date, DateFormattingHelper.INSTANCE.toDate(attributes.getExpiry())), new AttributeDetailItem((int) R.string.detail_given_name, attributes.getFirstName()), new AttributeDetailItem((int) R.string.detail_family_name, attributes.getLastName())});
                        break;
                    case 5:
                        arrayList = CollectionsKt.listOf((Object[]) new AttributeDetailItem[]{new AttributeDetailItem((int) R.string.detail_licence_type, attributes.getSubtypeDisplayName()), new AttributeDetailItem((int) R.string.detail_card_number, attributes.getIdentifier()), new AttributeDetailItem((int) R.string.detail_expires_on, DateFormattingHelper.INSTANCE.toDate(attributes.getExpiry())), new AttributeDetailItem((int) R.string.detail_issued_to, attributes.getName())});
                        break;
                    case 6:
                        arrayList = CollectionsKt.listOf((Object[]) new AttributeDetailItem[]{new AttributeDetailItem((int) R.string.kangaroo_harvester_detail_number, attributes.getIdentifier()), new AttributeDetailItem((int) R.string.detail_status, attributes.getHoldingStateToDisplay()), new AttributeDetailItem((int) R.string.detail_name, attributes.getName()), new AttributeDetailItem((int) R.string.detail_start_date, DateFormattingHelper.INSTANCE.toDate(attributes.getStartDateTime())), new AttributeDetailItem((int) R.string.detail_expiry_date, DateFormattingHelper.INSTANCE.toDate(attributes.getExpiry())), new AttributeDetailItem((int) R.string.detail_address, attributes.getAddresses().get(0).getStandardFormatAddress())});
                        break;
                    case 7:
                        SecureHolding secureHolding4 = this.secureHolding;
                        if (secureHolding4 != null && (dynamicDisplay = secureHolding4.getDynamicDisplay()) != null && (displayDetails = dynamicDisplay.getDisplayDetails()) != null) {
                            List<DynamicHoldingDisplayDetail> list = displayDetails;
                            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                            for (T t : list) {
                                arrayList2.add(new AttributeDetailItem(t.getLabel(), t.getValue()));
                            }
                            arrayList = arrayList2;
                            break;
                        } else {
                            arrayList = null;
                            break;
                        }
                        break;
                }
                if (arrayList != null) {
                    return arrayList;
                }
            }
            arrayList = CollectionsKt.emptyList();
            if (arrayList != null) {
            }
        }
        return CollectionsKt.emptyList();
    }

    public final void viewCard() {
        AnalyticsHelper.selectContent$default(this.analytics, "Present card - button", null, 2, null);
        HoldingDetailView holdingDetailView = this.view;
        if (holdingDetailView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
        }
        holdingDetailView.changeToLandscapeOrientation();
    }

    public final void startHoldingDisclaimerFragment() {
        AnalyticsHelper.selectContent$default(this.analytics, "View disclaimer", null, 2, null);
        HoldingDetailView holdingDetailView = this.view;
        if (holdingDetailView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
        }
        holdingDetailView.startHoldingDisclaimerFragment();
    }

    public final void changeToPortraitOrientation() {
        AnalyticsHelper.selectContent$default(this.analytics, "Close card presentation", null, 2, null);
        HoldingDetailView holdingDetailView = this.view;
        if (holdingDetailView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
        }
        holdingDetailView.changeToPortraitOrientation();
    }

    public final void flipCard(boolean z) {
        HoldingDetailView holdingDetailView = this.view;
        if (holdingDetailView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
        }
        holdingDetailView.flipCard(z);
    }

    private final String getAccreditationDetails(HoldingRecordAttributes holdingRecordAttributes) {
        return StringsKt.trimIndent("\n                Grid-connected " + stringForCred(holdingRecordAttributes.getGridConnect()) + "\n                Solar hot water " + stringForCred(holdingRecordAttributes.getSolarHotWater()) + "\n                Stand alone " + stringForCred(holdingRecordAttributes.getStandAlone()) + "\n                Batteries " + stringForCred(holdingRecordAttributes.getBattery()) + "\n            ");
    }
}
