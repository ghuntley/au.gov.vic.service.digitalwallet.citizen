package com.digitalwallet.app;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.ActivityMainBindingImpl;
import com.digitalwallet.app.databinding.ActivitySetupBindingImpl;
import com.digitalwallet.app.databinding.ActivitySplashBindingImpl;
import com.digitalwallet.app.databinding.AlertBindingImpl;
import com.digitalwallet.app.databinding.CardAddACardBindingImpl;
import com.digitalwallet.app.databinding.CardAffordancesAddACardBindingImpl;
import com.digitalwallet.app.databinding.CardAffordancesAuthorityBindingImpl;
import com.digitalwallet.app.databinding.CardAffordancesEligibilityBindingImpl;
import com.digitalwallet.app.databinding.CardAffordancesKangarooHarvesterBindingImpl;
import com.digitalwallet.app.databinding.CardAffordancesRenewBindingImpl;
import com.digitalwallet.app.databinding.CardAmbulanceMembershipBackBindingImpl;
import com.digitalwallet.app.databinding.CardAmbulanceMembershipFrontBindingImpl;
import com.digitalwallet.app.databinding.CardAuthorityFisheriesBindingImpl;
import com.digitalwallet.app.databinding.CardBindingImpl;
import com.digitalwallet.app.databinding.CardDetailBindingImpl;
import com.digitalwallet.app.databinding.CardFishingLicenceBackBindingImpl;
import com.digitalwallet.app.databinding.CardFishingLicenceFrontBindingImpl;
import com.digitalwallet.app.databinding.CardKangarooHarvesterBackBindingImpl;
import com.digitalwallet.app.databinding.CardKangarooHarvesterFrontBindingImpl;
import com.digitalwallet.app.databinding.CardSolarInstallerBackBindingImpl;
import com.digitalwallet.app.databinding.CardSolarInstallerFrontBindingImpl;
import com.digitalwallet.app.databinding.CardTemplate1FrontBindingImpl;
import com.digitalwallet.app.databinding.CardTemplate2FrontBindingImpl;
import com.digitalwallet.app.databinding.CardTemplate3FrontBindingImpl;
import com.digitalwallet.app.databinding.CardTemplate4FrontBindingImpl;
import com.digitalwallet.app.databinding.CardTemplateBackBindingImpl;
import com.digitalwallet.app.databinding.CardWithAffordancesBindingImpl;
import com.digitalwallet.app.databinding.CardWorksafeLicenceBackBindingImpl;
import com.digitalwallet.app.databinding.CardWorksafeLicenceFrontBindingImpl;
import com.digitalwallet.app.databinding.CardWwcCheckBackBindingImpl;
import com.digitalwallet.app.databinding.CardWwcCheckFrontBindingImpl;
import com.digitalwallet.app.databinding.FragmentAccountDetailsBindingImpl;
import com.digitalwallet.app.databinding.FragmentAccountSettingsBindingImpl;
import com.digitalwallet.app.databinding.FragmentAutoSyncBindingImpl;
import com.digitalwallet.app.databinding.FragmentCardAddBindingImpl;
import com.digitalwallet.app.databinding.FragmentCardSyncBindingImpl;
import com.digitalwallet.app.databinding.FragmentCreateAccountBindingImpl;
import com.digitalwallet.app.databinding.FragmentEligibilityScannerBindingImpl;
import com.digitalwallet.app.databinding.FragmentHoldingDetailBindingImpl;
import com.digitalwallet.app.databinding.FragmentHoldingDetailBindingLandImpl;
import com.digitalwallet.app.databinding.FragmentHoldingDisclaimerBindingImpl;
import com.digitalwallet.app.databinding.FragmentHoldingListBindingImpl;
import com.digitalwallet.app.databinding.FragmentHomeServicesBindingImpl;
import com.digitalwallet.app.databinding.FragmentIncomingRequestBindingImpl;
import com.digitalwallet.app.databinding.FragmentLobbyBindingImpl;
import com.digitalwallet.app.databinding.FragmentMainPagerBindingImpl;
import com.digitalwallet.app.databinding.FragmentMoreCardsInfoBindingImpl;
import com.digitalwallet.app.databinding.FragmentRegisterSuccessBindingImpl;
import com.digitalwallet.app.databinding.FragmentServiceCategoryTransactionsBindingImpl;
import com.digitalwallet.app.databinding.FragmentServiceDetailBindingImpl;
import com.digitalwallet.app.databinding.FragmentServiceGroupCategoriesBindingImpl;
import com.digitalwallet.app.databinding.FragmentServiceTypeBindingImpl;
import com.digitalwallet.app.databinding.FragmentSharingDetailsBindingImpl;
import com.digitalwallet.app.databinding.FragmentSharingHistoryBindingImpl;
import com.digitalwallet.app.databinding.FragmentTransactionHistoryBindingImpl;
import com.digitalwallet.app.databinding.FragmentVerifyEmailBindingImpl;
import com.digitalwallet.app.databinding.HarvesterActivityBindingImpl;
import com.digitalwallet.app.databinding.HarvesterAddressBindingImpl;
import com.digitalwallet.app.databinding.HarvesterConsentBindingImpl;
import com.digitalwallet.app.databinding.HarvesterItemJobBindingImpl;
import com.digitalwallet.app.databinding.HarvesterItemZoneBindingImpl;
import com.digitalwallet.app.databinding.HarvesterJobsBindingImpl;
import com.digitalwallet.app.databinding.HarvesterScannerBindingImpl;
import com.digitalwallet.app.databinding.HarvesterTagManualEntryBindingImpl;
import com.digitalwallet.app.databinding.HarvesterTagSummaryBindingImpl;
import com.digitalwallet.app.databinding.HarvesterZoneBindingImpl;
import com.digitalwallet.app.databinding.ItemAttributeDetailBindingImpl;
import com.digitalwallet.app.databinding.ItemLobbyMemberBindingImpl;
import com.digitalwallet.app.databinding.ItemLoginTopCarouselBindingImpl;
import com.digitalwallet.app.databinding.ItemRecentShareBindingImpl;
import com.digitalwallet.app.databinding.ItemServiceGroupCategoryBindingImpl;
import com.digitalwallet.app.databinding.ItemSettingOptionBindingImpl;
import com.digitalwallet.app.databinding.ItemSvServiceTitleActionBindingImpl;
import com.digitalwallet.app.databinding.ItemTransactionHistoryBindingImpl;
import com.digitalwallet.app.databinding.LayoutLoadingBindingImpl;
import com.digitalwallet.app.databinding.LayoutTitleBarBindingImpl;
import com.digitalwallet.app.databinding.LoginFingerprintDialogBindingImpl;
import com.digitalwallet.app.databinding.LoginHelloBindingImpl;
import com.digitalwallet.app.databinding.NicknameCreateBindingImpl;
import com.digitalwallet.app.databinding.NicknameEditBindingImpl;
import com.digitalwallet.app.databinding.NotificationBannerBindingImpl;
import com.digitalwallet.app.databinding.OnboardingBindingImpl;
import com.digitalwallet.app.databinding.OnboardingPageBindingImpl;
import com.digitalwallet.app.databinding.PinBindingImpl;
import com.digitalwallet.app.databinding.ServiceDetailRowBindingImpl;
import com.digitalwallet.app.databinding.ServiceTypeCardBindingImpl;
import com.digitalwallet.app.holdings.HoldingExpiryPublisher;
import com.digitalwallet.app.model.ShareHolding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bouncycastle.i18n.MessageBundle;

public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYMAIN = 1;
    private static final int LAYOUT_ACTIVITYSETUP = 2;
    private static final int LAYOUT_ACTIVITYSPLASH = 3;
    private static final int LAYOUT_ALERT = 4;
    private static final int LAYOUT_CARD = 5;
    private static final int LAYOUT_CARDADDACARD = 6;
    private static final int LAYOUT_CARDAFFORDANCESADDACARD = 7;
    private static final int LAYOUT_CARDAFFORDANCESAUTHORITY = 8;
    private static final int LAYOUT_CARDAFFORDANCESELIGIBILITY = 9;
    private static final int LAYOUT_CARDAFFORDANCESKANGAROOHARVESTER = 10;
    private static final int LAYOUT_CARDAFFORDANCESRENEW = 11;
    private static final int LAYOUT_CARDAMBULANCEMEMBERSHIPBACK = 12;
    private static final int LAYOUT_CARDAMBULANCEMEMBERSHIPFRONT = 13;
    private static final int LAYOUT_CARDAUTHORITYFISHERIES = 14;
    private static final int LAYOUT_CARDDETAIL = 15;
    private static final int LAYOUT_CARDFISHINGLICENCEBACK = 16;
    private static final int LAYOUT_CARDFISHINGLICENCEFRONT = 17;
    private static final int LAYOUT_CARDKANGAROOHARVESTERBACK = 18;
    private static final int LAYOUT_CARDKANGAROOHARVESTERFRONT = 19;
    private static final int LAYOUT_CARDSOLARINSTALLERBACK = 20;
    private static final int LAYOUT_CARDSOLARINSTALLERFRONT = 21;
    private static final int LAYOUT_CARDTEMPLATE1FRONT = 22;
    private static final int LAYOUT_CARDTEMPLATE2FRONT = 23;
    private static final int LAYOUT_CARDTEMPLATE3FRONT = 24;
    private static final int LAYOUT_CARDTEMPLATE4FRONT = 25;
    private static final int LAYOUT_CARDTEMPLATEBACK = 26;
    private static final int LAYOUT_CARDWITHAFFORDANCES = 27;
    private static final int LAYOUT_CARDWORKSAFELICENCEBACK = 28;
    private static final int LAYOUT_CARDWORKSAFELICENCEFRONT = 29;
    private static final int LAYOUT_CARDWWCCHECKBACK = 30;
    private static final int LAYOUT_CARDWWCCHECKFRONT = 31;
    private static final int LAYOUT_FRAGMENTACCOUNTDETAILS = 32;
    private static final int LAYOUT_FRAGMENTACCOUNTSETTINGS = 33;
    private static final int LAYOUT_FRAGMENTAUTOSYNC = 34;
    private static final int LAYOUT_FRAGMENTCARDADD = 35;
    private static final int LAYOUT_FRAGMENTCARDSYNC = 36;
    private static final int LAYOUT_FRAGMENTCREATEACCOUNT = 37;
    private static final int LAYOUT_FRAGMENTELIGIBILITYSCANNER = 38;
    private static final int LAYOUT_FRAGMENTHOLDINGDETAIL = 39;
    private static final int LAYOUT_FRAGMENTHOLDINGDISCLAIMER = 40;
    private static final int LAYOUT_FRAGMENTHOLDINGLIST = 41;
    private static final int LAYOUT_FRAGMENTHOMESERVICES = 42;
    private static final int LAYOUT_FRAGMENTINCOMINGREQUEST = 43;
    private static final int LAYOUT_FRAGMENTLOBBY = 44;
    private static final int LAYOUT_FRAGMENTMAINPAGER = 45;
    private static final int LAYOUT_FRAGMENTMORECARDSINFO = 46;
    private static final int LAYOUT_FRAGMENTREGISTERSUCCESS = 47;
    private static final int LAYOUT_FRAGMENTSERVICECATEGORYTRANSACTIONS = 48;
    private static final int LAYOUT_FRAGMENTSERVICEDETAIL = 49;
    private static final int LAYOUT_FRAGMENTSERVICEGROUPCATEGORIES = 50;
    private static final int LAYOUT_FRAGMENTSERVICETYPE = 51;
    private static final int LAYOUT_FRAGMENTSHARINGDETAILS = 52;
    private static final int LAYOUT_FRAGMENTSHARINGHISTORY = 53;
    private static final int LAYOUT_FRAGMENTTRANSACTIONHISTORY = 54;
    private static final int LAYOUT_FRAGMENTVERIFYEMAIL = 55;
    private static final int LAYOUT_HARVESTERACTIVITY = 56;
    private static final int LAYOUT_HARVESTERADDRESS = 57;
    private static final int LAYOUT_HARVESTERCONSENT = 58;
    private static final int LAYOUT_HARVESTERITEMJOB = 59;
    private static final int LAYOUT_HARVESTERITEMZONE = 60;
    private static final int LAYOUT_HARVESTERJOBS = 61;
    private static final int LAYOUT_HARVESTERSCANNER = 62;
    private static final int LAYOUT_HARVESTERTAGMANUALENTRY = 63;
    private static final int LAYOUT_HARVESTERTAGSUMMARY = 64;
    private static final int LAYOUT_HARVESTERZONE = 65;
    private static final int LAYOUT_ITEMATTRIBUTEDETAIL = 66;
    private static final int LAYOUT_ITEMLOBBYMEMBER = 67;
    private static final int LAYOUT_ITEMLOGINTOPCAROUSEL = 68;
    private static final int LAYOUT_ITEMRECENTSHARE = 69;
    private static final int LAYOUT_ITEMSERVICEGROUPCATEGORY = 70;
    private static final int LAYOUT_ITEMSETTINGOPTION = 71;
    private static final int LAYOUT_ITEMSVSERVICETITLEACTION = 72;
    private static final int LAYOUT_ITEMTRANSACTIONHISTORY = 73;
    private static final int LAYOUT_LAYOUTLOADING = 74;
    private static final int LAYOUT_LAYOUTTITLEBAR = 75;
    private static final int LAYOUT_LOGINFINGERPRINTDIALOG = 76;
    private static final int LAYOUT_LOGINHELLO = 77;
    private static final int LAYOUT_NICKNAMECREATE = 78;
    private static final int LAYOUT_NICKNAMEEDIT = 79;
    private static final int LAYOUT_NOTIFICATIONBANNER = 80;
    private static final int LAYOUT_ONBOARDING = 81;
    private static final int LAYOUT_ONBOARDINGPAGE = 82;
    private static final int LAYOUT_PIN = 83;
    private static final int LAYOUT_SERVICEDETAILROW = 84;
    private static final int LAYOUT_SERVICETYPECARD = 85;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(85);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_main, 1);
        sparseIntArray.put(R.layout.activity_setup, 2);
        sparseIntArray.put(R.layout.activity_splash, 3);
        sparseIntArray.put(R.layout.alert, 4);
        sparseIntArray.put(R.layout.card, 5);
        sparseIntArray.put(R.layout.card_add_a_card, 6);
        sparseIntArray.put(R.layout.card_affordances_add_a_card, 7);
        sparseIntArray.put(R.layout.card_affordances_authority, 8);
        sparseIntArray.put(R.layout.card_affordances_eligibility, 9);
        sparseIntArray.put(R.layout.card_affordances_kangaroo_harvester, 10);
        sparseIntArray.put(R.layout.card_affordances_renew, 11);
        sparseIntArray.put(R.layout.card_ambulance_membership_back, 12);
        sparseIntArray.put(R.layout.card_ambulance_membership_front, 13);
        sparseIntArray.put(R.layout.card_authority_fisheries, 14);
        sparseIntArray.put(R.layout.card_detail, 15);
        sparseIntArray.put(R.layout.card_fishing_licence_back, 16);
        sparseIntArray.put(R.layout.card_fishing_licence_front, 17);
        sparseIntArray.put(R.layout.card_kangaroo_harvester_back, 18);
        sparseIntArray.put(R.layout.card_kangaroo_harvester_front, 19);
        sparseIntArray.put(R.layout.card_solar_installer_back, 20);
        sparseIntArray.put(R.layout.card_solar_installer_front, 21);
        sparseIntArray.put(R.layout.card_template_1_front, 22);
        sparseIntArray.put(R.layout.card_template_2_front, 23);
        sparseIntArray.put(R.layout.card_template_3_front, 24);
        sparseIntArray.put(R.layout.card_template_4_front, 25);
        sparseIntArray.put(R.layout.card_template_back, 26);
        sparseIntArray.put(R.layout.card_with_affordances, 27);
        sparseIntArray.put(R.layout.card_worksafe_licence_back, 28);
        sparseIntArray.put(R.layout.card_worksafe_licence_front, 29);
        sparseIntArray.put(R.layout.card_wwc_check_back, 30);
        sparseIntArray.put(R.layout.card_wwc_check_front, 31);
        sparseIntArray.put(R.layout.fragment_account_details, 32);
        sparseIntArray.put(R.layout.fragment_account_settings, 33);
        sparseIntArray.put(R.layout.fragment_auto_sync, 34);
        sparseIntArray.put(R.layout.fragment_card_add, 35);
        sparseIntArray.put(R.layout.fragment_card_sync, 36);
        sparseIntArray.put(R.layout.fragment_create_account, 37);
        sparseIntArray.put(R.layout.fragment_eligibility_scanner, 38);
        sparseIntArray.put(R.layout.fragment_holding_detail, 39);
        sparseIntArray.put(R.layout.fragment_holding_disclaimer, 40);
        sparseIntArray.put(R.layout.fragment_holding_list, 41);
        sparseIntArray.put(R.layout.fragment_home_services, 42);
        sparseIntArray.put(R.layout.fragment_incoming_request, 43);
        sparseIntArray.put(R.layout.fragment_lobby, 44);
        sparseIntArray.put(R.layout.fragment_main_pager, 45);
        sparseIntArray.put(R.layout.fragment_more_cards_info, 46);
        sparseIntArray.put(R.layout.fragment_register_success, 47);
        sparseIntArray.put(R.layout.fragment_service_category_transactions, 48);
        sparseIntArray.put(R.layout.fragment_service_detail, 49);
        sparseIntArray.put(R.layout.fragment_service_group_categories, 50);
        sparseIntArray.put(R.layout.fragment_service_type, 51);
        sparseIntArray.put(R.layout.fragment_sharing_details, 52);
        sparseIntArray.put(R.layout.fragment_sharing_history, 53);
        sparseIntArray.put(R.layout.fragment_transaction_history, 54);
        sparseIntArray.put(R.layout.fragment_verify_email, 55);
        sparseIntArray.put(R.layout.harvester_activity, 56);
        sparseIntArray.put(R.layout.harvester_address, 57);
        sparseIntArray.put(R.layout.harvester_consent, 58);
        sparseIntArray.put(R.layout.harvester_item_job, 59);
        sparseIntArray.put(R.layout.harvester_item_zone, 60);
        sparseIntArray.put(R.layout.harvester_jobs, 61);
        sparseIntArray.put(R.layout.harvester_scanner, 62);
        sparseIntArray.put(R.layout.harvester_tag_manual_entry, 63);
        sparseIntArray.put(R.layout.harvester_tag_summary, 64);
        sparseIntArray.put(R.layout.harvester_zone, 65);
        sparseIntArray.put(R.layout.item_attribute_detail, 66);
        sparseIntArray.put(R.layout.item_lobby_member, 67);
        sparseIntArray.put(R.layout.item_login_top_carousel, 68);
        sparseIntArray.put(R.layout.item_recent_share, 69);
        sparseIntArray.put(R.layout.item_service_group_category, 70);
        sparseIntArray.put(R.layout.item_setting_option, 71);
        sparseIntArray.put(R.layout.item_sv_service_title_action, 72);
        sparseIntArray.put(R.layout.item_transaction_history, 73);
        sparseIntArray.put(R.layout.layout_loading_RES_2114388041, 74);
        sparseIntArray.put(R.layout.layout_title_bar_RES_2114388042, 75);
        sparseIntArray.put(R.layout.login_fingerprint_dialog, 76);
        sparseIntArray.put(R.layout.login_hello, 77);
        sparseIntArray.put(R.layout.nickname_create, 78);
        sparseIntArray.put(R.layout.nickname_edit, 79);
        sparseIntArray.put(R.layout.notification_banner, 80);
        sparseIntArray.put(R.layout.onboarding, 81);
        sparseIntArray.put(R.layout.onboarding_page, 82);
        sparseIntArray.put(R.layout.pin, 83);
        sparseIntArray.put(R.layout.service_detail_row, 84);
        sparseIntArray.put(R.layout.service_type_card, 85);
    }

    private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 1:
                if ("layout/activity_main_0".equals(obj)) {
                    return new ActivityMainBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + obj);
            case 2:
                if ("layout/activity_setup_0".equals(obj)) {
                    return new ActivitySetupBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_setup is invalid. Received: " + obj);
            case 3:
                if ("layout/activity_splash_0".equals(obj)) {
                    return new ActivitySplashBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_splash is invalid. Received: " + obj);
            case 4:
                if ("layout/alert_0".equals(obj)) {
                    return new AlertBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for alert is invalid. Received: " + obj);
            case 5:
                if ("layout/card_0".equals(obj)) {
                    return new CardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card is invalid. Received: " + obj);
            case 6:
                if ("layout/card_add_a_card_0".equals(obj)) {
                    return new CardAddACardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_add_a_card is invalid. Received: " + obj);
            case 7:
                if ("layout/card_affordances_add_a_card_0".equals(obj)) {
                    return new CardAffordancesAddACardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_affordances_add_a_card is invalid. Received: " + obj);
            case 8:
                if ("layout/card_affordances_authority_0".equals(obj)) {
                    return new CardAffordancesAuthorityBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_affordances_authority is invalid. Received: " + obj);
            case 9:
                if ("layout/card_affordances_eligibility_0".equals(obj)) {
                    return new CardAffordancesEligibilityBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_affordances_eligibility is invalid. Received: " + obj);
            case 10:
                if ("layout/card_affordances_kangaroo_harvester_0".equals(obj)) {
                    return new CardAffordancesKangarooHarvesterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_affordances_kangaroo_harvester is invalid. Received: " + obj);
            case 11:
                if ("layout/card_affordances_renew_0".equals(obj)) {
                    return new CardAffordancesRenewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_affordances_renew is invalid. Received: " + obj);
            case 12:
                if ("layout/card_ambulance_membership_back_0".equals(obj)) {
                    return new CardAmbulanceMembershipBackBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_ambulance_membership_back is invalid. Received: " + obj);
            case 13:
                if ("layout/card_ambulance_membership_front_0".equals(obj)) {
                    return new CardAmbulanceMembershipFrontBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_ambulance_membership_front is invalid. Received: " + obj);
            case 14:
                if ("layout/card_authority_fisheries_0".equals(obj)) {
                    return new CardAuthorityFisheriesBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_authority_fisheries is invalid. Received: " + obj);
            case 15:
                if ("layout/card_detail_0".equals(obj)) {
                    return new CardDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_detail is invalid. Received: " + obj);
            case 16:
                if ("layout/card_fishing_licence_back_0".equals(obj)) {
                    return new CardFishingLicenceBackBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_fishing_licence_back is invalid. Received: " + obj);
            case 17:
                if ("layout/card_fishing_licence_front_0".equals(obj)) {
                    return new CardFishingLicenceFrontBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_fishing_licence_front is invalid. Received: " + obj);
            case 18:
                if ("layout/card_kangaroo_harvester_back_0".equals(obj)) {
                    return new CardKangarooHarvesterBackBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_kangaroo_harvester_back is invalid. Received: " + obj);
            case 19:
                if ("layout/card_kangaroo_harvester_front_0".equals(obj)) {
                    return new CardKangarooHarvesterFrontBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_kangaroo_harvester_front is invalid. Received: " + obj);
            case 20:
                if ("layout/card_solar_installer_back_0".equals(obj)) {
                    return new CardSolarInstallerBackBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_solar_installer_back is invalid. Received: " + obj);
            case 21:
                if ("layout/card_solar_installer_front_0".equals(obj)) {
                    return new CardSolarInstallerFrontBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_solar_installer_front is invalid. Received: " + obj);
            case 22:
                if ("layout/card_template_1_front_0".equals(obj)) {
                    return new CardTemplate1FrontBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_template_1_front is invalid. Received: " + obj);
            case 23:
                if ("layout/card_template_2_front_0".equals(obj)) {
                    return new CardTemplate2FrontBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_template_2_front is invalid. Received: " + obj);
            case 24:
                if ("layout/card_template_3_front_0".equals(obj)) {
                    return new CardTemplate3FrontBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_template_3_front is invalid. Received: " + obj);
            case 25:
                if ("layout/card_template_4_front_0".equals(obj)) {
                    return new CardTemplate4FrontBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_template_4_front is invalid. Received: " + obj);
            case 26:
                if ("layout/card_template_back_0".equals(obj)) {
                    return new CardTemplateBackBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_template_back is invalid. Received: " + obj);
            case 27:
                if ("layout/card_with_affordances_0".equals(obj)) {
                    return new CardWithAffordancesBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_with_affordances is invalid. Received: " + obj);
            case 28:
                if ("layout/card_worksafe_licence_back_0".equals(obj)) {
                    return new CardWorksafeLicenceBackBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_worksafe_licence_back is invalid. Received: " + obj);
            case 29:
                if ("layout/card_worksafe_licence_front_0".equals(obj)) {
                    return new CardWorksafeLicenceFrontBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_worksafe_licence_front is invalid. Received: " + obj);
            case 30:
                if ("layout/card_wwc_check_back_0".equals(obj)) {
                    return new CardWwcCheckBackBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_wwc_check_back is invalid. Received: " + obj);
            case 31:
                if ("layout/card_wwc_check_front_0".equals(obj)) {
                    return new CardWwcCheckFrontBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for card_wwc_check_front is invalid. Received: " + obj);
            case 32:
                if ("layout/fragment_account_details_0".equals(obj)) {
                    return new FragmentAccountDetailsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_account_details is invalid. Received: " + obj);
            case 33:
                if ("layout/fragment_account_settings_0".equals(obj)) {
                    return new FragmentAccountSettingsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_account_settings is invalid. Received: " + obj);
            case 34:
                if ("layout/fragment_auto_sync_0".equals(obj)) {
                    return new FragmentAutoSyncBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_auto_sync is invalid. Received: " + obj);
            case 35:
                if ("layout/fragment_card_add_0".equals(obj)) {
                    return new FragmentCardAddBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_card_add is invalid. Received: " + obj);
            case 36:
                if ("layout/fragment_card_sync_0".equals(obj)) {
                    return new FragmentCardSyncBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_card_sync is invalid. Received: " + obj);
            case 37:
                if ("layout/fragment_create_account_0".equals(obj)) {
                    return new FragmentCreateAccountBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_create_account is invalid. Received: " + obj);
            case 38:
                if ("layout/fragment_eligibility_scanner_0".equals(obj)) {
                    return new FragmentEligibilityScannerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_eligibility_scanner is invalid. Received: " + obj);
            case 39:
                if ("layout/fragment_holding_detail_0".equals(obj)) {
                    return new FragmentHoldingDetailBindingImpl(dataBindingComponent, view);
                }
                if ("layout-land/fragment_holding_detail_0".equals(obj)) {
                    return new FragmentHoldingDetailBindingLandImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_holding_detail is invalid. Received: " + obj);
            case 40:
                if ("layout/fragment_holding_disclaimer_0".equals(obj)) {
                    return new FragmentHoldingDisclaimerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_holding_disclaimer is invalid. Received: " + obj);
            case 41:
                if ("layout/fragment_holding_list_0".equals(obj)) {
                    return new FragmentHoldingListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_holding_list is invalid. Received: " + obj);
            case 42:
                if ("layout/fragment_home_services_0".equals(obj)) {
                    return new FragmentHomeServicesBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_home_services is invalid. Received: " + obj);
            case 43:
                if ("layout/fragment_incoming_request_0".equals(obj)) {
                    return new FragmentIncomingRequestBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_incoming_request is invalid. Received: " + obj);
            case 44:
                if ("layout/fragment_lobby_0".equals(obj)) {
                    return new FragmentLobbyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_lobby is invalid. Received: " + obj);
            case 45:
                if ("layout/fragment_main_pager_0".equals(obj)) {
                    return new FragmentMainPagerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_main_pager is invalid. Received: " + obj);
            case 46:
                if ("layout/fragment_more_cards_info_0".equals(obj)) {
                    return new FragmentMoreCardsInfoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_more_cards_info is invalid. Received: " + obj);
            case 47:
                if ("layout/fragment_register_success_0".equals(obj)) {
                    return new FragmentRegisterSuccessBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_register_success is invalid. Received: " + obj);
            case 48:
                if ("layout/fragment_service_category_transactions_0".equals(obj)) {
                    return new FragmentServiceCategoryTransactionsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_service_category_transactions is invalid. Received: " + obj);
            case 49:
                if ("layout/fragment_service_detail_0".equals(obj)) {
                    return new FragmentServiceDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_service_detail is invalid. Received: " + obj);
            case 50:
                if ("layout/fragment_service_group_categories_0".equals(obj)) {
                    return new FragmentServiceGroupCategoriesBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_service_group_categories is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 51:
                if ("layout/fragment_service_type_0".equals(obj)) {
                    return new FragmentServiceTypeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_service_type is invalid. Received: " + obj);
            case 52:
                if ("layout/fragment_sharing_details_0".equals(obj)) {
                    return new FragmentSharingDetailsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_sharing_details is invalid. Received: " + obj);
            case 53:
                if ("layout/fragment_sharing_history_0".equals(obj)) {
                    return new FragmentSharingHistoryBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_sharing_history is invalid. Received: " + obj);
            case 54:
                if ("layout/fragment_transaction_history_0".equals(obj)) {
                    return new FragmentTransactionHistoryBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_transaction_history is invalid. Received: " + obj);
            case 55:
                if ("layout/fragment_verify_email_0".equals(obj)) {
                    return new FragmentVerifyEmailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_verify_email is invalid. Received: " + obj);
            case 56:
                if ("layout/harvester_activity_0".equals(obj)) {
                    return new HarvesterActivityBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for harvester_activity is invalid. Received: " + obj);
            case 57:
                if ("layout/harvester_address_0".equals(obj)) {
                    return new HarvesterAddressBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for harvester_address is invalid. Received: " + obj);
            case 58:
                if ("layout/harvester_consent_0".equals(obj)) {
                    return new HarvesterConsentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for harvester_consent is invalid. Received: " + obj);
            case 59:
                if ("layout/harvester_item_job_0".equals(obj)) {
                    return new HarvesterItemJobBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for harvester_item_job is invalid. Received: " + obj);
            case 60:
                if ("layout/harvester_item_zone_0".equals(obj)) {
                    return new HarvesterItemZoneBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for harvester_item_zone is invalid. Received: " + obj);
            case 61:
                if ("layout/harvester_jobs_0".equals(obj)) {
                    return new HarvesterJobsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for harvester_jobs is invalid. Received: " + obj);
            case 62:
                if ("layout/harvester_scanner_0".equals(obj)) {
                    return new HarvesterScannerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for harvester_scanner is invalid. Received: " + obj);
            case 63:
                if ("layout/harvester_tag_manual_entry_0".equals(obj)) {
                    return new HarvesterTagManualEntryBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for harvester_tag_manual_entry is invalid. Received: " + obj);
            case 64:
                if ("layout/harvester_tag_summary_0".equals(obj)) {
                    return new HarvesterTagSummaryBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for harvester_tag_summary is invalid. Received: " + obj);
            case 65:
                if ("layout/harvester_zone_0".equals(obj)) {
                    return new HarvesterZoneBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for harvester_zone is invalid. Received: " + obj);
            case 66:
                if ("layout/item_attribute_detail_0".equals(obj)) {
                    return new ItemAttributeDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_attribute_detail is invalid. Received: " + obj);
            case 67:
                if ("layout/item_lobby_member_0".equals(obj)) {
                    return new ItemLobbyMemberBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_lobby_member is invalid. Received: " + obj);
            case 68:
                if ("layout/item_login_top_carousel_0".equals(obj)) {
                    return new ItemLoginTopCarouselBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_login_top_carousel is invalid. Received: " + obj);
            case 69:
                if ("layout/item_recent_share_0".equals(obj)) {
                    return new ItemRecentShareBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_recent_share is invalid. Received: " + obj);
            case 70:
                if ("layout/item_service_group_category_0".equals(obj)) {
                    return new ItemServiceGroupCategoryBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_service_group_category is invalid. Received: " + obj);
            case 71:
                if ("layout/item_setting_option_0".equals(obj)) {
                    return new ItemSettingOptionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_setting_option is invalid. Received: " + obj);
            case 72:
                if ("layout/item_sv_service_title_action_0".equals(obj)) {
                    return new ItemSvServiceTitleActionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_sv_service_title_action is invalid. Received: " + obj);
            case 73:
                if ("layout/item_transaction_history_0".equals(obj)) {
                    return new ItemTransactionHistoryBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_transaction_history is invalid. Received: " + obj);
            case 74:
                if ("layout/layout_loading_0".equals(obj)) {
                    return new LayoutLoadingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_loading is invalid. Received: " + obj);
            case 75:
                if ("layout/layout_title_bar_0".equals(obj)) {
                    return new LayoutTitleBarBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_title_bar is invalid. Received: " + obj);
            case 76:
                if ("layout/login_fingerprint_dialog_0".equals(obj)) {
                    return new LoginFingerprintDialogBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for login_fingerprint_dialog is invalid. Received: " + obj);
            case 77:
                if ("layout/login_hello_0".equals(obj)) {
                    return new LoginHelloBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for login_hello is invalid. Received: " + obj);
            case 78:
                if ("layout/nickname_create_0".equals(obj)) {
                    return new NicknameCreateBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for nickname_create is invalid. Received: " + obj);
            case 79:
                if ("layout/nickname_edit_0".equals(obj)) {
                    return new NicknameEditBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for nickname_edit is invalid. Received: " + obj);
            case 80:
                if ("layout/notification_banner_0".equals(obj)) {
                    return new NotificationBannerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for notification_banner is invalid. Received: " + obj);
            case 81:
                if ("layout/onboarding_0".equals(obj)) {
                    return new OnboardingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for onboarding is invalid. Received: " + obj);
            case 82:
                if ("layout/onboarding_page_0".equals(obj)) {
                    return new OnboardingPageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for onboarding_page is invalid. Received: " + obj);
            case 83:
                if ("layout/pin_0".equals(obj)) {
                    return new PinBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for pin is invalid. Received: " + obj);
            case 84:
                if ("layout/service_detail_row_0".equals(obj)) {
                    return new ServiceDetailRowBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for service_detail_row is invalid. Received: " + obj);
            case 85:
                if ("layout/service_type_card_0".equals(obj)) {
                    return new ServiceTypeCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for service_type_card is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            int i3 = (i2 - 1) / 50;
            if (i3 == 0) {
                return internalGetViewDataBinding0(dataBindingComponent, view, i2, tag);
            }
            if (i3 != 1) {
                return null;
            }
            return internalGetViewDataBinding1(dataBindingComponent, view, i2, tag);
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        return new ArrayList(0);
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(9);
            sKeys = sparseArray;
            sparseArray.put(BR.ViewState, "ViewState");
            sparseArray.put(0, "_all");
            sparseArray.put(BR.assets, ShareHolding.assetDataKey);
            sparseArray.put(BR.drawable, "drawable");
            sparseArray.put(BR.holding, HoldingExpiryPublisher.HOLDING_KEY);
            sparseArray.put(BR.showLoading, "showLoading");
            sparseArray.put(BR.title, MessageBundle.TITLE_ENTRY);
            sparseArray.put(BR.viewModel, "viewModel");
            sparseArray.put(BR.vm, "vm");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(86);
            sKeys = hashMap;
            hashMap.put("layout/activity_main_0", Integer.valueOf((int) R.layout.activity_main));
            hashMap.put("layout/activity_setup_0", Integer.valueOf((int) R.layout.activity_setup));
            hashMap.put("layout/activity_splash_0", Integer.valueOf((int) R.layout.activity_splash));
            hashMap.put("layout/alert_0", Integer.valueOf((int) R.layout.alert));
            hashMap.put("layout/card_0", Integer.valueOf((int) R.layout.card));
            hashMap.put("layout/card_add_a_card_0", Integer.valueOf((int) R.layout.card_add_a_card));
            hashMap.put("layout/card_affordances_add_a_card_0", Integer.valueOf((int) R.layout.card_affordances_add_a_card));
            hashMap.put("layout/card_affordances_authority_0", Integer.valueOf((int) R.layout.card_affordances_authority));
            hashMap.put("layout/card_affordances_eligibility_0", Integer.valueOf((int) R.layout.card_affordances_eligibility));
            hashMap.put("layout/card_affordances_kangaroo_harvester_0", Integer.valueOf((int) R.layout.card_affordances_kangaroo_harvester));
            hashMap.put("layout/card_affordances_renew_0", Integer.valueOf((int) R.layout.card_affordances_renew));
            hashMap.put("layout/card_ambulance_membership_back_0", Integer.valueOf((int) R.layout.card_ambulance_membership_back));
            hashMap.put("layout/card_ambulance_membership_front_0", Integer.valueOf((int) R.layout.card_ambulance_membership_front));
            hashMap.put("layout/card_authority_fisheries_0", Integer.valueOf((int) R.layout.card_authority_fisheries));
            hashMap.put("layout/card_detail_0", Integer.valueOf((int) R.layout.card_detail));
            hashMap.put("layout/card_fishing_licence_back_0", Integer.valueOf((int) R.layout.card_fishing_licence_back));
            hashMap.put("layout/card_fishing_licence_front_0", Integer.valueOf((int) R.layout.card_fishing_licence_front));
            hashMap.put("layout/card_kangaroo_harvester_back_0", Integer.valueOf((int) R.layout.card_kangaroo_harvester_back));
            hashMap.put("layout/card_kangaroo_harvester_front_0", Integer.valueOf((int) R.layout.card_kangaroo_harvester_front));
            hashMap.put("layout/card_solar_installer_back_0", Integer.valueOf((int) R.layout.card_solar_installer_back));
            hashMap.put("layout/card_solar_installer_front_0", Integer.valueOf((int) R.layout.card_solar_installer_front));
            hashMap.put("layout/card_template_1_front_0", Integer.valueOf((int) R.layout.card_template_1_front));
            hashMap.put("layout/card_template_2_front_0", Integer.valueOf((int) R.layout.card_template_2_front));
            hashMap.put("layout/card_template_3_front_0", Integer.valueOf((int) R.layout.card_template_3_front));
            hashMap.put("layout/card_template_4_front_0", Integer.valueOf((int) R.layout.card_template_4_front));
            hashMap.put("layout/card_template_back_0", Integer.valueOf((int) R.layout.card_template_back));
            hashMap.put("layout/card_with_affordances_0", Integer.valueOf((int) R.layout.card_with_affordances));
            hashMap.put("layout/card_worksafe_licence_back_0", Integer.valueOf((int) R.layout.card_worksafe_licence_back));
            hashMap.put("layout/card_worksafe_licence_front_0", Integer.valueOf((int) R.layout.card_worksafe_licence_front));
            hashMap.put("layout/card_wwc_check_back_0", Integer.valueOf((int) R.layout.card_wwc_check_back));
            hashMap.put("layout/card_wwc_check_front_0", Integer.valueOf((int) R.layout.card_wwc_check_front));
            hashMap.put("layout/fragment_account_details_0", Integer.valueOf((int) R.layout.fragment_account_details));
            hashMap.put("layout/fragment_account_settings_0", Integer.valueOf((int) R.layout.fragment_account_settings));
            hashMap.put("layout/fragment_auto_sync_0", Integer.valueOf((int) R.layout.fragment_auto_sync));
            hashMap.put("layout/fragment_card_add_0", Integer.valueOf((int) R.layout.fragment_card_add));
            hashMap.put("layout/fragment_card_sync_0", Integer.valueOf((int) R.layout.fragment_card_sync));
            hashMap.put("layout/fragment_create_account_0", Integer.valueOf((int) R.layout.fragment_create_account));
            hashMap.put("layout/fragment_eligibility_scanner_0", Integer.valueOf((int) R.layout.fragment_eligibility_scanner));
            Integer valueOf = Integer.valueOf((int) R.layout.fragment_holding_detail);
            hashMap.put("layout/fragment_holding_detail_0", valueOf);
            hashMap.put("layout-land/fragment_holding_detail_0", valueOf);
            hashMap.put("layout/fragment_holding_disclaimer_0", Integer.valueOf((int) R.layout.fragment_holding_disclaimer));
            hashMap.put("layout/fragment_holding_list_0", Integer.valueOf((int) R.layout.fragment_holding_list));
            hashMap.put("layout/fragment_home_services_0", Integer.valueOf((int) R.layout.fragment_home_services));
            hashMap.put("layout/fragment_incoming_request_0", Integer.valueOf((int) R.layout.fragment_incoming_request));
            hashMap.put("layout/fragment_lobby_0", Integer.valueOf((int) R.layout.fragment_lobby));
            hashMap.put("layout/fragment_main_pager_0", Integer.valueOf((int) R.layout.fragment_main_pager));
            hashMap.put("layout/fragment_more_cards_info_0", Integer.valueOf((int) R.layout.fragment_more_cards_info));
            hashMap.put("layout/fragment_register_success_0", Integer.valueOf((int) R.layout.fragment_register_success));
            hashMap.put("layout/fragment_service_category_transactions_0", Integer.valueOf((int) R.layout.fragment_service_category_transactions));
            hashMap.put("layout/fragment_service_detail_0", Integer.valueOf((int) R.layout.fragment_service_detail));
            hashMap.put("layout/fragment_service_group_categories_0", Integer.valueOf((int) R.layout.fragment_service_group_categories));
            hashMap.put("layout/fragment_service_type_0", Integer.valueOf((int) R.layout.fragment_service_type));
            hashMap.put("layout/fragment_sharing_details_0", Integer.valueOf((int) R.layout.fragment_sharing_details));
            hashMap.put("layout/fragment_sharing_history_0", Integer.valueOf((int) R.layout.fragment_sharing_history));
            hashMap.put("layout/fragment_transaction_history_0", Integer.valueOf((int) R.layout.fragment_transaction_history));
            hashMap.put("layout/fragment_verify_email_0", Integer.valueOf((int) R.layout.fragment_verify_email));
            hashMap.put("layout/harvester_activity_0", Integer.valueOf((int) R.layout.harvester_activity));
            hashMap.put("layout/harvester_address_0", Integer.valueOf((int) R.layout.harvester_address));
            hashMap.put("layout/harvester_consent_0", Integer.valueOf((int) R.layout.harvester_consent));
            hashMap.put("layout/harvester_item_job_0", Integer.valueOf((int) R.layout.harvester_item_job));
            hashMap.put("layout/harvester_item_zone_0", Integer.valueOf((int) R.layout.harvester_item_zone));
            hashMap.put("layout/harvester_jobs_0", Integer.valueOf((int) R.layout.harvester_jobs));
            hashMap.put("layout/harvester_scanner_0", Integer.valueOf((int) R.layout.harvester_scanner));
            hashMap.put("layout/harvester_tag_manual_entry_0", Integer.valueOf((int) R.layout.harvester_tag_manual_entry));
            hashMap.put("layout/harvester_tag_summary_0", Integer.valueOf((int) R.layout.harvester_tag_summary));
            hashMap.put("layout/harvester_zone_0", Integer.valueOf((int) R.layout.harvester_zone));
            hashMap.put("layout/item_attribute_detail_0", Integer.valueOf((int) R.layout.item_attribute_detail));
            hashMap.put("layout/item_lobby_member_0", Integer.valueOf((int) R.layout.item_lobby_member));
            hashMap.put("layout/item_login_top_carousel_0", Integer.valueOf((int) R.layout.item_login_top_carousel));
            hashMap.put("layout/item_recent_share_0", Integer.valueOf((int) R.layout.item_recent_share));
            hashMap.put("layout/item_service_group_category_0", Integer.valueOf((int) R.layout.item_service_group_category));
            hashMap.put("layout/item_setting_option_0", Integer.valueOf((int) R.layout.item_setting_option));
            hashMap.put("layout/item_sv_service_title_action_0", Integer.valueOf((int) R.layout.item_sv_service_title_action));
            hashMap.put("layout/item_transaction_history_0", Integer.valueOf((int) R.layout.item_transaction_history));
            hashMap.put("layout/layout_loading_0", Integer.valueOf((int) R.layout.layout_loading_RES_2114388041));
            hashMap.put("layout/layout_title_bar_0", Integer.valueOf((int) R.layout.layout_title_bar_RES_2114388042));
            hashMap.put("layout/login_fingerprint_dialog_0", Integer.valueOf((int) R.layout.login_fingerprint_dialog));
            hashMap.put("layout/login_hello_0", Integer.valueOf((int) R.layout.login_hello));
            hashMap.put("layout/nickname_create_0", Integer.valueOf((int) R.layout.nickname_create));
            hashMap.put("layout/nickname_edit_0", Integer.valueOf((int) R.layout.nickname_edit));
            hashMap.put("layout/notification_banner_0", Integer.valueOf((int) R.layout.notification_banner));
            hashMap.put("layout/onboarding_0", Integer.valueOf((int) R.layout.onboarding));
            hashMap.put("layout/onboarding_page_0", Integer.valueOf((int) R.layout.onboarding_page));
            hashMap.put("layout/pin_0", Integer.valueOf((int) R.layout.pin));
            hashMap.put("layout/service_detail_row_0", Integer.valueOf((int) R.layout.service_detail_row));
            hashMap.put("layout/service_type_card_0", Integer.valueOf((int) R.layout.service_type_card));
        }
    }
}
