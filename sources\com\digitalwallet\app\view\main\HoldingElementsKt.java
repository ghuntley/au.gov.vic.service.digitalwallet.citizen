package com.digitalwallet.app.view.main;

import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.DynamicHoldingCardTemplate;
import com.digitalwallet.app.model.HoldingKt;
import com.digitalwallet.app.model.HoldingRecordAttributes;
import com.digitalwallet.app.model.HoldingType;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.ServerTypeKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n\u001a\u0018\u0010\u0000\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0004\u001a\u00020\u0003*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"holdingElements", "", "Lcom/digitalwallet/app/model/HoldingType;", "Lcom/digitalwallet/app/view/main/HoldingElements;", "embeddedElements", "getEmbeddedElements", "(Lcom/digitalwallet/app/model/HoldingType;)Lcom/digitalwallet/app/view/main/HoldingElements;", "cardTemplate", "Lcom/digitalwallet/app/model/DynamicHoldingCardTemplate;", "attributes", "Lcom/digitalwallet/app/model/HoldingRecordAttributes;", "holdingType", "app_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: HoldingElements.kt */
public final class HoldingElementsKt {
    private static final Map<HoldingType, HoldingElements> holdingElements = MapsKt.mapOf(TuplesKt.to(HoldingType.FISHING_LICENCE, new HoldingElements(true, true, R.layout.card_fishing_licence_front, Integer.valueOf((int) R.layout.card_fishing_licence_back), R.layout.card_affordances_renew, Integer.valueOf((int) R.string.add_card_fishing), Integer.valueOf((int) com.digitalwallet.app.R.drawable.card_fishing_small), Integer.valueOf((int) R.string.fishing_licence_url), R.string.fishing_licence_title, R.string.fishing_licence_lowercase)), TuplesKt.to(HoldingType.SOLAR_INSTALLER, new HoldingElements(true, true, R.layout.card_solar_installer_front, Integer.valueOf((int) R.layout.card_solar_installer_back), R.layout.card_affordances_eligibility, Integer.valueOf((int) R.string.add_card_solar), Integer.valueOf((int) com.digitalwallet.app.R.drawable.card_solar_small), null, R.string.licence_uc, R.string.licence_lc)), TuplesKt.to(HoldingType.AMBULANCE_VICTORIA, new HoldingElements(true, true, R.layout.card_ambulance_membership_front, Integer.valueOf((int) R.layout.card_ambulance_membership_back), R.layout.card_affordances_renew, Integer.valueOf((int) R.string.add_card_av), Integer.valueOf((int) com.digitalwallet.app.R.drawable.card_av_small), Integer.valueOf((int) R.string.av_renew_url), R.string.av_membership_title, R.string.av_membership_lowercase)), TuplesKt.to(HoldingType.WORKSAFE_LICENCE, new HoldingElements(false, true, R.layout.card_worksafe_licence_front, Integer.valueOf((int) R.layout.card_worksafe_licence_back), R.layout.card_affordances_renew, Integer.valueOf((int) R.string.add_card_worksafe), Integer.valueOf((int) com.digitalwallet.app.R.drawable.card_worksafe_small), null, R.string.worksafe_licence_title, R.string.worksafe_licence_lowercase)), TuplesKt.to(HoldingType.WWC_CHECK, new HoldingElements(false, true, R.layout.card_wwc_check_front, Integer.valueOf((int) R.layout.card_wwc_check_back), R.layout.card_affordances_renew, Integer.valueOf((int) R.string.add_card_wwc), Integer.valueOf((int) com.digitalwallet.app.R.drawable.card_wwc_small), null, R.string.wwc_check_title, R.string.wwc_check_lowercase)), TuplesKt.to(HoldingType.KANGAROO_HARVESTER, new HoldingElements(true, true, R.layout.card_kangaroo_harvester_front, Integer.valueOf((int) R.layout.card_kangaroo_harvester_back), R.layout.card_affordances_kangaroo_harvester, Integer.valueOf((int) R.string.kangaroo_harvester_title), Integer.valueOf((int) com.digitalwallet.app.R.drawable.card_kangaroo_harvester_small), null, R.string.kangaroo_harvester_title, R.string.kangaroo_harvester_title)), TuplesKt.to(HoldingType.AUTHORITY, new HoldingElements(true, false, R.layout.card_authority_fisheries, null, R.layout.card_affordances_authority, null, null, null, R.string.fishing_licence_title, R.string.fishing_licence_lowercase)), TuplesKt.to(HoldingType.ADD_A_CARD, new HoldingElements(false, false, R.layout.card_add_a_card, null, R.layout.card_affordances_add_a_card, null, null, null, R.string.empty_string_RES_2114650224, R.string.empty_string_RES_2114650224)));

    public static final HoldingElements holdingElements(DynamicHoldingCardTemplate dynamicHoldingCardTemplate, HoldingRecordAttributes holdingRecordAttributes) {
        Intrinsics.checkNotNullParameter(holdingRecordAttributes, "attributes");
        return holdingElements(HoldingKt.holdingType(dynamicHoldingCardTemplate, holdingRecordAttributes), dynamicHoldingCardTemplate);
    }

    public static final HoldingElements holdingElements(HoldingType holdingType, DynamicHoldingCardTemplate dynamicHoldingCardTemplate) {
        Intrinsics.checkNotNullParameter(holdingType, "holdingType");
        if (holdingType != HoldingType.TEMPLATE || dynamicHoldingCardTemplate == null) {
            return getEmbeddedElements(holdingType);
        }
        return new HoldingElements(true, true, dynamicHoldingCardTemplate.getTemplateType().getCardFrontLayoutID(), Integer.valueOf((int) R.layout.card_template_back), ServerTypeKt.getAppType() == AppType.CITIZEN ? R.layout.card_affordances_renew : R.layout.card_affordances_authority, Integer.valueOf((int) R.string.dynamic_holding_template_title), Integer.valueOf((int) R.drawable.holding_bg_kangaroo_harvester), null, R.string.dynamic_holding_template_title, R.string.dynamic_holding_template_title);
    }

    private static final HoldingElements getEmbeddedElements(HoldingType holdingType) {
        HoldingElements holdingElements2 = holdingElements.get(holdingType);
        if (holdingElements2 != null) {
            return holdingElements2;
        }
        throw new IllegalStateException(("Unsupported Holding Type: " + holdingType).toString());
    }
}
