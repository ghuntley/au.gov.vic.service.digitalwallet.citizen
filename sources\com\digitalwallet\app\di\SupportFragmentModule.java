package com.digitalwallet.app.di;

import com.digitalwallet.app.view.harvester.HarvestJobListFragment;
import com.digitalwallet.app.view.harvester.HarvestJobWizardAddressFragment;
import com.digitalwallet.app.view.harvester.HarvestJobWizardConsentFragment;
import com.digitalwallet.app.view.harvester.HarvestJobWizardZoneFragment;
import com.digitalwallet.app.view.harvester.HarvestScannerFragment;
import com.digitalwallet.app.view.harvester.HarvestTagManualEntryFragment;
import com.digitalwallet.app.view.harvester.HarvestTagSummaryFragment;
import com.digitalwallet.app.view.login.CreateAccountFragment;
import com.digitalwallet.app.view.login.HomeServicesFragment;
import com.digitalwallet.app.view.login.RegisterSuccessFragment;
import com.digitalwallet.app.view.login.VerifyEmailFragment;
import com.digitalwallet.app.view.main.AccountDetailsFragment;
import com.digitalwallet.app.view.main.AccountSettingsFragment;
import com.digitalwallet.app.view.main.AutoSyncFragment;
import com.digitalwallet.app.view.main.CardAddFragment;
import com.digitalwallet.app.view.main.CardSyncFragment;
import com.digitalwallet.app.view.main.EligibilityScannerFragment;
import com.digitalwallet.app.view.main.HoldingDetailFragment;
import com.digitalwallet.app.view.main.HoldingDisclaimerFragment;
import com.digitalwallet.app.view.main.HoldingListFragment;
import com.digitalwallet.app.view.main.IncomingRequestFragment;
import com.digitalwallet.app.view.main.LobbyFragment;
import com.digitalwallet.app.view.main.MainPagerFragment;
import com.digitalwallet.app.view.main.NicknameCreateFragment;
import com.digitalwallet.app.view.main.NicknameEditFragment;
import com.digitalwallet.app.view.main.ServiceDetailFragment;
import com.digitalwallet.app.view.main.ServiceTypeFragment;
import com.digitalwallet.app.view.main.SharingDetailsFragment;
import com.digitalwallet.app.view.main.SharingHistoryFragment;
import com.digitalwallet.app.view.main.TransactionHistoryFragment;
import com.digitalwallet.app.view.main.holdings.MoreCardsInfoFragment;
import com.digitalwallet.app.view.pin.FingerprintDialogFragment;
import com.digitalwallet.app.view.svservices.ServiceCategoryTransactionsFragment;
import com.digitalwallet.app.view.svservices.ServiceGroupCategoriesFragment;
import com.digitalwallet.view.checkIn.CheckInOverviewFragment;
import com.digitalwallet.view.checkIn.CheckInScannerFragment;
import com.digitalwallet.view.checkIn.checkInInput.CheckInAddDependantInputFragment;
import com.digitalwallet.view.checkIn.checkInInput.CheckInEditPersonInputFragment;
import com.digitalwallet.view.checkIn.checkInInput.CheckInPrimaryInputFragment;
import com.digitalwallet.view.checkIn.checkInInput.CheckInSubmittingFragment;
import com.digitalwallet.view.checkIn.checkInInput.CheckInSummaryFragment;
import com.digitalwallet.view.checkIn.checkInShortcut.CheckInShortcutFragment;
import com.digitalwallet.view.checkIn.checkedIn.CheckInFeedbackFragment;
import com.digitalwallet.view.checkIn.checkedIn.CheckInFeedbackSuccessFragment;
import com.digitalwallet.view.checkIn.checkedIn.CheckInHistoryDetailFragment;
import com.digitalwallet.view.checkIn.checkedIn.CheckInSuccessFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H'J\b\u0010\u0005\u001a\u00020\u0006H'J\b\u0010\u0007\u001a\u00020\bH'J\b\u0010\t\u001a\u00020\nH'J\b\u0010\u000b\u001a\u00020\fH'J\b\u0010\r\u001a\u00020\u000eH'J\b\u0010\u000f\u001a\u00020\u0010H'J\b\u0010\u0011\u001a\u00020\u0012H'J\b\u0010\u0013\u001a\u00020\u0014H'J\b\u0010\u0015\u001a\u00020\u0016H'J\b\u0010\u0017\u001a\u00020\u0018H'J\b\u0010\u0019\u001a\u00020\u001aH'J\b\u0010\u001b\u001a\u00020\u001cH'J\b\u0010\u001d\u001a\u00020\u001eH'J\b\u0010\u001f\u001a\u00020 H'J\b\u0010!\u001a\u00020\"H'J\b\u0010#\u001a\u00020$H'J\b\u0010%\u001a\u00020&H'J\b\u0010'\u001a\u00020(H'J\b\u0010)\u001a\u00020*H'J\b\u0010+\u001a\u00020,H'J\b\u0010-\u001a\u00020.H'J\b\u0010/\u001a\u000200H'J\b\u00101\u001a\u000202H'J\b\u00103\u001a\u000204H'J\b\u00105\u001a\u000206H'J\b\u00107\u001a\u000208H'J\b\u00109\u001a\u00020:H'J\b\u0010;\u001a\u00020<H'J\b\u0010=\u001a\u00020>H'J\b\u0010?\u001a\u00020@H'J\b\u0010A\u001a\u00020BH'J\b\u0010C\u001a\u00020DH'J\b\u0010E\u001a\u00020FH'J\b\u0010G\u001a\u00020HH'J\b\u0010I\u001a\u00020JH'J\b\u0010K\u001a\u00020LH'J\b\u0010M\u001a\u00020NH'J\b\u0010O\u001a\u00020PH'J\b\u0010Q\u001a\u00020RH'J\b\u0010S\u001a\u00020TH'J\b\u0010U\u001a\u00020VH'J\b\u0010W\u001a\u00020XH'J\b\u0010Y\u001a\u00020ZH'J\b\u0010[\u001a\u00020\\H'J\b\u0010]\u001a\u00020^H'¨\u0006_"}, d2 = {"Lcom/digitalwallet/app/di/SupportFragmentModule;", "", "()V", "autoSyncFragment", "Lcom/digitalwallet/app/view/main/AutoSyncFragment;", "contributeAccountDetailsFragment", "Lcom/digitalwallet/app/view/main/AccountDetailsFragment;", "contributeAccountSettingsFragment", "Lcom/digitalwallet/app/view/main/AccountSettingsFragment;", "contributeCardAddFragment", "Lcom/digitalwallet/app/view/main/CardAddFragment;", "contributeCardSyncFragment", "Lcom/digitalwallet/app/view/main/CardSyncFragment;", "contributeCheckInAddDependantInputFragment", "Lcom/digitalwallet/view/checkIn/checkInInput/CheckInAddDependantInputFragment;", "contributeCheckInEditPersonInputFragment", "Lcom/digitalwallet/view/checkIn/checkInInput/CheckInEditPersonInputFragment;", "contributeCheckInFeedbackFragment", "Lcom/digitalwallet/view/checkIn/checkedIn/CheckInFeedbackFragment;", "contributeCheckInFeedbackSuccessFragment", "Lcom/digitalwallet/view/checkIn/checkedIn/CheckInFeedbackSuccessFragment;", "contributeCheckInHistoryDetailFragment", "Lcom/digitalwallet/view/checkIn/checkedIn/CheckInHistoryDetailFragment;", "contributeCheckInOverviewFragment", "Lcom/digitalwallet/view/checkIn/CheckInOverviewFragment;", "contributeCheckInPrimaryInputFragment", "Lcom/digitalwallet/view/checkIn/checkInInput/CheckInPrimaryInputFragment;", "contributeCheckInScannerFragment", "Lcom/digitalwallet/view/checkIn/CheckInScannerFragment;", "contributeCheckInShortcutFragment", "Lcom/digitalwallet/view/checkIn/checkInShortcut/CheckInShortcutFragment;", "contributeCheckInSubmittingFragment", "Lcom/digitalwallet/view/checkIn/checkInInput/CheckInSubmittingFragment;", "contributeCheckInSuccessFragment", "Lcom/digitalwallet/view/checkIn/checkedIn/CheckInSuccessFragment;", "contributeCheckInSummaryFragment", "Lcom/digitalwallet/view/checkIn/checkInInput/CheckInSummaryFragment;", "contributeCreateAccountFragment", "Lcom/digitalwallet/app/view/login/CreateAccountFragment;", "contributeFingerprintDialogFragment", "Lcom/digitalwallet/app/view/pin/FingerprintDialogFragment;", "contributeHoldingDetailFragment", "Lcom/digitalwallet/app/view/main/HoldingDetailFragment;", "contributeHoldingDisclaimerFragment", "Lcom/digitalwallet/app/view/main/HoldingDisclaimerFragment;", "contributeHoldingListFragment", "Lcom/digitalwallet/app/view/main/HoldingListFragment;", "contributeHomeServicesFragment", "Lcom/digitalwallet/app/view/login/HomeServicesFragment;", "contributeIncomingRequestFragment", "Lcom/digitalwallet/app/view/main/IncomingRequestFragment;", "contributeLobbyFragment", "Lcom/digitalwallet/app/view/main/LobbyFragment;", "contributeMainPagerFragment", "Lcom/digitalwallet/app/view/main/MainPagerFragment;", "contributeMoreCardsInfoFragment", "Lcom/digitalwallet/app/view/main/holdings/MoreCardsInfoFragment;", "contributeRegisterSuccessFragment", "Lcom/digitalwallet/app/view/login/RegisterSuccessFragment;", "contributeServiceDetailFragment", "Lcom/digitalwallet/app/view/main/ServiceDetailFragment;", "contributeServiceTypeFragment", "Lcom/digitalwallet/app/view/main/ServiceTypeFragment;", "contributeSharingDetailsFragment", "Lcom/digitalwallet/app/view/main/SharingDetailsFragment;", "contributeSharingHistoryFragment", "Lcom/digitalwallet/app/view/main/SharingHistoryFragment;", "contributeTransactionHistoryFragment", "Lcom/digitalwallet/app/view/main/TransactionHistoryFragment;", "contributeVerifyEmailFragment", "Lcom/digitalwallet/app/view/login/VerifyEmailFragment;", "contributesEligibilityScannerFragment", "Lcom/digitalwallet/app/view/main/EligibilityScannerFragment;", "harvestJobListFragment", "Lcom/digitalwallet/app/view/harvester/HarvestJobListFragment;", "harvestJobWizardAddressFragment", "Lcom/digitalwallet/app/view/harvester/HarvestJobWizardAddressFragment;", "harvestJobWizardConsentFragment", "Lcom/digitalwallet/app/view/harvester/HarvestJobWizardConsentFragment;", "harvestJobWizardZoneFragment", "Lcom/digitalwallet/app/view/harvester/HarvestJobWizardZoneFragment;", "harvestScannerFragment", "Lcom/digitalwallet/app/view/harvester/HarvestScannerFragment;", "harvestTagManualEntryFragment", "Lcom/digitalwallet/app/view/harvester/HarvestTagManualEntryFragment;", "harvestTagSummaryFragment", "Lcom/digitalwallet/app/view/harvester/HarvestTagSummaryFragment;", "nicknameCreateFragment", "Lcom/digitalwallet/app/view/main/NicknameCreateFragment;", "nicknameEditFragment", "Lcom/digitalwallet/app/view/main/NicknameEditFragment;", "serviceCategoryTransactionsFragment", "Lcom/digitalwallet/app/view/svservices/ServiceCategoryTransactionsFragment;", "serviceGroupCategoriesFragment", "Lcom/digitalwallet/app/view/svservices/ServiceGroupCategoriesFragment;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
@Module
/* compiled from: SupportFragmentModule.kt */
public abstract class SupportFragmentModule {
    @ContributesAndroidInjector
    public abstract AutoSyncFragment autoSyncFragment();

    @ContributesAndroidInjector
    public abstract AccountDetailsFragment contributeAccountDetailsFragment();

    @ContributesAndroidInjector
    public abstract AccountSettingsFragment contributeAccountSettingsFragment();

    @ContributesAndroidInjector
    public abstract CardAddFragment contributeCardAddFragment();

    @ContributesAndroidInjector
    public abstract CardSyncFragment contributeCardSyncFragment();

    @ContributesAndroidInjector
    public abstract CheckInAddDependantInputFragment contributeCheckInAddDependantInputFragment();

    @ContributesAndroidInjector
    public abstract CheckInEditPersonInputFragment contributeCheckInEditPersonInputFragment();

    @ContributesAndroidInjector
    public abstract CheckInFeedbackFragment contributeCheckInFeedbackFragment();

    @ContributesAndroidInjector
    public abstract CheckInFeedbackSuccessFragment contributeCheckInFeedbackSuccessFragment();

    @ContributesAndroidInjector
    public abstract CheckInHistoryDetailFragment contributeCheckInHistoryDetailFragment();

    @ContributesAndroidInjector
    public abstract CheckInOverviewFragment contributeCheckInOverviewFragment();

    @ContributesAndroidInjector
    public abstract CheckInPrimaryInputFragment contributeCheckInPrimaryInputFragment();

    @ContributesAndroidInjector
    public abstract CheckInScannerFragment contributeCheckInScannerFragment();

    @ContributesAndroidInjector
    public abstract CheckInShortcutFragment contributeCheckInShortcutFragment();

    @ContributesAndroidInjector
    public abstract CheckInSubmittingFragment contributeCheckInSubmittingFragment();

    @ContributesAndroidInjector
    public abstract CheckInSuccessFragment contributeCheckInSuccessFragment();

    @ContributesAndroidInjector
    public abstract CheckInSummaryFragment contributeCheckInSummaryFragment();

    @ContributesAndroidInjector
    public abstract CreateAccountFragment contributeCreateAccountFragment();

    @ContributesAndroidInjector
    public abstract FingerprintDialogFragment contributeFingerprintDialogFragment();

    @ContributesAndroidInjector
    public abstract HoldingDetailFragment contributeHoldingDetailFragment();

    @ContributesAndroidInjector
    public abstract HoldingDisclaimerFragment contributeHoldingDisclaimerFragment();

    @ContributesAndroidInjector
    public abstract HoldingListFragment contributeHoldingListFragment();

    @ContributesAndroidInjector
    public abstract HomeServicesFragment contributeHomeServicesFragment();

    @ContributesAndroidInjector
    public abstract IncomingRequestFragment contributeIncomingRequestFragment();

    @ContributesAndroidInjector
    public abstract LobbyFragment contributeLobbyFragment();

    @ContributesAndroidInjector
    public abstract MainPagerFragment contributeMainPagerFragment();

    @ContributesAndroidInjector
    public abstract MoreCardsInfoFragment contributeMoreCardsInfoFragment();

    @ContributesAndroidInjector
    public abstract RegisterSuccessFragment contributeRegisterSuccessFragment();

    @ContributesAndroidInjector
    public abstract ServiceDetailFragment contributeServiceDetailFragment();

    @ContributesAndroidInjector
    public abstract ServiceTypeFragment contributeServiceTypeFragment();

    @ContributesAndroidInjector
    public abstract SharingDetailsFragment contributeSharingDetailsFragment();

    @ContributesAndroidInjector
    public abstract SharingHistoryFragment contributeSharingHistoryFragment();

    @ContributesAndroidInjector
    public abstract TransactionHistoryFragment contributeTransactionHistoryFragment();

    @ContributesAndroidInjector
    public abstract VerifyEmailFragment contributeVerifyEmailFragment();

    @ContributesAndroidInjector
    public abstract EligibilityScannerFragment contributesEligibilityScannerFragment();

    @ContributesAndroidInjector
    public abstract HarvestJobListFragment harvestJobListFragment();

    @ContributesAndroidInjector
    public abstract HarvestJobWizardAddressFragment harvestJobWizardAddressFragment();

    @ContributesAndroidInjector
    public abstract HarvestJobWizardConsentFragment harvestJobWizardConsentFragment();

    @ContributesAndroidInjector
    public abstract HarvestJobWizardZoneFragment harvestJobWizardZoneFragment();

    @ContributesAndroidInjector
    public abstract HarvestScannerFragment harvestScannerFragment();

    @ContributesAndroidInjector
    public abstract HarvestTagManualEntryFragment harvestTagManualEntryFragment();

    @ContributesAndroidInjector
    public abstract HarvestTagSummaryFragment harvestTagSummaryFragment();

    @ContributesAndroidInjector
    public abstract NicknameCreateFragment nicknameCreateFragment();

    @ContributesAndroidInjector
    public abstract NicknameEditFragment nicknameEditFragment();

    @ContributesAndroidInjector
    public abstract ServiceCategoryTransactionsFragment serviceCategoryTransactionsFragment();

    @ContributesAndroidInjector
    public abstract ServiceGroupCategoriesFragment serviceGroupCategoriesFragment();
}
