package com.digitalwallet.app.di;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.digitalwallet.DigitalWalletApplication;
import com.digitalwallet.app.AppStartUp;
import com.digitalwallet.app.api.AssetApi;
import com.digitalwallet.app.api.AuthApi;
import com.digitalwallet.app.api.ConfigApi;
import com.digitalwallet.app.api.DeviceRegisterApi;
import com.digitalwallet.app.api.HoldingsApi;
import com.digitalwallet.app.api.UserApi;
import com.digitalwallet.app.connection.BLEClient;
import com.digitalwallet.app.connection.BLEClient_Factory;
import com.digitalwallet.app.connection.BLEServer;
import com.digitalwallet.app.connection.BLEServer_Factory;
import com.digitalwallet.app.connection.BLEUtil;
import com.digitalwallet.app.di.ActivityModuleServer_ContributeMainActivity;
import com.digitalwallet.app.di.ActivityModule_ContributeHarvestJobActivity;
import com.digitalwallet.app.di.ActivityModule_ContributeLoginActivity;
import com.digitalwallet.app.di.ActivityModule_ContributeOnboardingActivity;
import com.digitalwallet.app.di.ActivityModule_ContributePinActivity;
import com.digitalwallet.app.di.ActivityModule_ContributeSecondSplashActivity;
import com.digitalwallet.app.di.ActivityModule_ContributeSetupActivity;
import com.digitalwallet.app.di.AppComponentServer;
import com.digitalwallet.app.di.SupportFragmentModule_AutoSyncFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeAccountDetailsFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeAccountSettingsFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeCardAddFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeCardSyncFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeCheckInAddDependantInputFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeCheckInEditPersonInputFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeCheckInFeedbackFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeCheckInFeedbackSuccessFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeCheckInHistoryDetailFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeCheckInOverviewFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeCheckInPrimaryInputFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeCheckInScannerFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeCheckInShortcutFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeCheckInSubmittingFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeCheckInSuccessFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeCheckInSummaryFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeCreateAccountFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeFingerprintDialogFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeHoldingDetailFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeHoldingDisclaimerFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeHoldingListFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeHomeServicesFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeIncomingRequestFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeLobbyFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeMainPagerFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeMoreCardsInfoFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeRegisterSuccessFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeServiceDetailFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeServiceTypeFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeSharingDetailsFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeSharingHistoryFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeTransactionHistoryFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributeVerifyEmailFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ContributesEligibilityScannerFragment;
import com.digitalwallet.app.di.SupportFragmentModule_HarvestJobListFragment;
import com.digitalwallet.app.di.SupportFragmentModule_HarvestJobWizardAddressFragment;
import com.digitalwallet.app.di.SupportFragmentModule_HarvestJobWizardConsentFragment;
import com.digitalwallet.app.di.SupportFragmentModule_HarvestJobWizardZoneFragment;
import com.digitalwallet.app.di.SupportFragmentModule_HarvestScannerFragment;
import com.digitalwallet.app.di.SupportFragmentModule_HarvestTagManualEntryFragment;
import com.digitalwallet.app.di.SupportFragmentModule_HarvestTagSummaryFragment;
import com.digitalwallet.app.di.SupportFragmentModule_NicknameCreateFragment;
import com.digitalwallet.app.di.SupportFragmentModule_NicknameEditFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ServiceCategoryTransactionsFragment;
import com.digitalwallet.app.di.SupportFragmentModule_ServiceGroupCategoriesFragment;
import com.digitalwallet.app.holdings.HoldingParser;
import com.digitalwallet.app.holdings.HoldingParser_Factory;
import com.digitalwallet.app.holdings.HoldingsApiService;
import com.digitalwallet.app.holdings.HoldingsApiService_Factory;
import com.digitalwallet.app.holdings.HoldingsDbService;
import com.digitalwallet.app.holdings.HoldingsDbService_Factory;
import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.holdings.HoldingsService_Factory;
import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import com.digitalwallet.app.model.db.harvester.HarvestModel;
import com.digitalwallet.app.model.db.scan.ScanDao;
import com.digitalwallet.app.model.db.secure.DigitalWalletSecuredStore;
import com.digitalwallet.app.model.db.secure.DigitalWalletSecuredStore_Factory;
import com.digitalwallet.app.model.db.secure.JWTIssuerKeysDao;
import com.digitalwallet.app.model.db.secure.JWTIssuerKeysService;
import com.digitalwallet.app.model.db.secure.JWTIssuerKeysService_Factory;
import com.digitalwallet.app.model.db.shares.ShareRecordStore;
import com.digitalwallet.app.model.db.unsecure.UnsecuredStore;
import com.digitalwallet.app.oidc.AuthenticationService;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.oidc.OIDCRequestHandler;
import com.digitalwallet.app.oidc.config.ConfigurationDocument;
import com.digitalwallet.app.services.AssetService;
import com.digitalwallet.app.services.BluetoothEventsService;
import com.digitalwallet.app.services.HandshakeService;
import com.digitalwallet.app.services.HandshakeService_Factory;
import com.digitalwallet.app.services.HarvestDataService;
import com.digitalwallet.app.services.HarvestDataService_Factory;
import com.digitalwallet.app.services.ScannerDataService;
import com.digitalwallet.app.services.ScannerDataService_Factory;
import com.digitalwallet.app.services.SimpleAssetService;
import com.digitalwallet.app.services.TransactionSharesService;
import com.digitalwallet.app.services.TransactionSharesService_Factory;
import com.digitalwallet.app.services.remotenotification.RemoteSubscriptionService;
import com.digitalwallet.app.services.remotenotification.RemoteSubscriptionService_Factory;
import com.digitalwallet.app.view.SetupActivity;
import com.digitalwallet.app.view.SetupActivity_MembersInjector;
import com.digitalwallet.app.view.base.AppDaggerAppCompatActivity_MembersInjector;
import com.digitalwallet.app.view.base.BaseAppActivity_MembersInjector;
import com.digitalwallet.app.view.harvester.HarvestActivity;
import com.digitalwallet.app.view.harvester.HarvestActivity_MembersInjector;
import com.digitalwallet.app.view.harvester.HarvestJobListFragment;
import com.digitalwallet.app.view.harvester.HarvestJobWizardAddressFragment;
import com.digitalwallet.app.view.harvester.HarvestJobWizardConsentFragment;
import com.digitalwallet.app.view.harvester.HarvestJobWizardZoneFragment;
import com.digitalwallet.app.view.harvester.HarvestScannerFragment;
import com.digitalwallet.app.view.harvester.HarvestTagManualEntryFragment;
import com.digitalwallet.app.view.harvester.HarvestTagSummaryFragment;
import com.digitalwallet.app.view.login.CreateAccountFragment;
import com.digitalwallet.app.view.login.CreateAccountFragment_MembersInjector;
import com.digitalwallet.app.view.login.HomeServicesFragment;
import com.digitalwallet.app.view.login.HomeServicesFragment_MembersInjector;
import com.digitalwallet.app.view.login.LoginActivity;
import com.digitalwallet.app.view.login.LoginActivity_MembersInjector;
import com.digitalwallet.app.view.login.RegisterSuccessFragment;
import com.digitalwallet.app.view.login.RegisterSuccessFragment_MembersInjector;
import com.digitalwallet.app.view.login.VerifyEmailFragment;
import com.digitalwallet.app.view.login.VerifyEmailFragment_MembersInjector;
import com.digitalwallet.app.view.main.AccountDetailsFragment;
import com.digitalwallet.app.view.main.AccountDetailsFragment_MembersInjector;
import com.digitalwallet.app.view.main.AccountSettingsFragment;
import com.digitalwallet.app.view.main.AccountSettingsFragment_MembersInjector;
import com.digitalwallet.app.view.main.AutoSyncFragment;
import com.digitalwallet.app.view.main.AutoSyncFragment_MembersInjector;
import com.digitalwallet.app.view.main.CardAddFragment;
import com.digitalwallet.app.view.main.CardAddFragment_MembersInjector;
import com.digitalwallet.app.view.main.CardSyncFragment;
import com.digitalwallet.app.view.main.CardSyncFragment_MembersInjector;
import com.digitalwallet.app.view.main.EligibilityScannerFragment;
import com.digitalwallet.app.view.main.EligibilityScannerFragment_MembersInjector;
import com.digitalwallet.app.view.main.HoldingDetailFragment;
import com.digitalwallet.app.view.main.HoldingDetailFragment_MembersInjector;
import com.digitalwallet.app.view.main.HoldingDisclaimerFragment;
import com.digitalwallet.app.view.main.HoldingListFragment;
import com.digitalwallet.app.view.main.HoldingListFragment_MembersInjector;
import com.digitalwallet.app.view.main.IncomingRequestFragment;
import com.digitalwallet.app.view.main.IncomingRequestFragment_MembersInjector;
import com.digitalwallet.app.view.main.LobbyFragment;
import com.digitalwallet.app.view.main.LobbyFragment_MembersInjector;
import com.digitalwallet.app.view.main.MainActivity;
import com.digitalwallet.app.view.main.MainActivityServer;
import com.digitalwallet.app.view.main.MainActivityServer_MembersInjector;
import com.digitalwallet.app.view.main.MainActivity_MembersInjector;
import com.digitalwallet.app.view.main.MainPagerFragment;
import com.digitalwallet.app.view.main.MainPagerFragment_MembersInjector;
import com.digitalwallet.app.view.main.NicknameCreateFragment;
import com.digitalwallet.app.view.main.NicknameCreateFragment_MembersInjector;
import com.digitalwallet.app.view.main.NicknameEditFragment;
import com.digitalwallet.app.view.main.NicknameEditFragment_MembersInjector;
import com.digitalwallet.app.view.main.ServiceDetailFragment;
import com.digitalwallet.app.view.main.ServiceDetailFragment_MembersInjector;
import com.digitalwallet.app.view.main.ServiceTypeFragment;
import com.digitalwallet.app.view.main.SharingDetailsFragment;
import com.digitalwallet.app.view.main.SharingHistoryFragment;
import com.digitalwallet.app.view.main.SharingHistoryFragment_MembersInjector;
import com.digitalwallet.app.view.main.TransactionHistoryFragment;
import com.digitalwallet.app.view.main.TransactionHistoryFragment_MembersInjector;
import com.digitalwallet.app.view.main.holdings.MoreCardsInfoFragment;
import com.digitalwallet.app.view.main.holdings.MoreCardsInfoFragment_MembersInjector;
import com.digitalwallet.app.view.onboarding.OnboardingActivity;
import com.digitalwallet.app.view.onboarding.OnboardingActivity_MembersInjector;
import com.digitalwallet.app.view.pin.FingerprintDialogFragment;
import com.digitalwallet.app.view.pin.FingerprintDialogFragment_MembersInjector;
import com.digitalwallet.app.view.pin.PinActivity;
import com.digitalwallet.app.view.pin.PinActivity_MembersInjector;
import com.digitalwallet.app.view.splash.SplashActivity;
import com.digitalwallet.app.view.splash.SplashActivity_MembersInjector;
import com.digitalwallet.app.view.svservices.ServiceCategoryTransactionsFragment;
import com.digitalwallet.app.view.svservices.ServiceCategoryTransactionsFragment_MembersInjector;
import com.digitalwallet.app.view.svservices.ServiceGroupCategoriesFragment;
import com.digitalwallet.app.view.svservices.ServiceGroupCategoriesFragment_MembersInjector;
import com.digitalwallet.app.viewmodel.harvester.HarvestJobWizardViewModel;
import com.digitalwallet.app.viewmodel.harvester.HarvestJobWizardViewModel_Factory;
import com.digitalwallet.app.viewmodel.harvester.HarvestTagViewModel;
import com.digitalwallet.app.viewmodel.harvester.HarvestTagViewModel_Factory;
import com.digitalwallet.app.viewmodel.login.CreateAccountViewModel;
import com.digitalwallet.app.viewmodel.login.CreateAccountViewModel_Factory;
import com.digitalwallet.app.viewmodel.login.HomeServicesViewModel;
import com.digitalwallet.app.viewmodel.login.HomeServicesViewModel_Factory;
import com.digitalwallet.app.viewmodel.login.LoginActivityViewModel;
import com.digitalwallet.app.viewmodel.login.LoginActivityViewModel_Factory;
import com.digitalwallet.app.viewmodel.login.RegisterSuccessViewModel;
import com.digitalwallet.app.viewmodel.login.RegisterSuccessViewModel_Factory;
import com.digitalwallet.app.viewmodel.login.VerifyEmailViewModel;
import com.digitalwallet.app.viewmodel.login.VerifyEmailViewModel_Factory;
import com.digitalwallet.app.viewmodel.main.AccountDetailsFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.AccountDetailsFragmentViewModel_Factory;
import com.digitalwallet.app.viewmodel.main.AccountDetailsFragmentViewModel_MembersInjector;
import com.digitalwallet.app.viewmodel.main.AccountSettingsFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.AccountSettingsFragmentViewModel_Factory;
import com.digitalwallet.app.viewmodel.main.EligibilityScannerFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.EligibilityScannerFragmentViewModel_Factory;
import com.digitalwallet.app.viewmodel.main.HoldingDetailFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.HoldingDetailFragmentViewModel_Factory;
import com.digitalwallet.app.viewmodel.main.HoldingListFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.HoldingListFragmentViewModel_Factory;
import com.digitalwallet.app.viewmodel.main.MainActivityViewModel;
import com.digitalwallet.app.viewmodel.main.MainActivityViewModel_Factory;
import com.digitalwallet.app.viewmodel.main.MainPagerFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.MainPagerFragmentViewModel_Factory;
import com.digitalwallet.app.viewmodel.main.NicknameViewModel;
import com.digitalwallet.app.viewmodel.main.NicknameViewModel_Factory;
import com.digitalwallet.app.viewmodel.main.ServiceDetailFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.ServiceDetailFragmentViewModel_Factory;
import com.digitalwallet.app.viewmodel.main.addsync.AutoSyncViewModel;
import com.digitalwallet.app.viewmodel.main.addsync.AutoSyncViewModel_Factory;
import com.digitalwallet.app.viewmodel.main.addsync.CardAddViewModel;
import com.digitalwallet.app.viewmodel.main.addsync.CardAddViewModel_Factory;
import com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel;
import com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel_Factory;
import com.digitalwallet.app.viewmodel.main.history.SharingHistoryFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.history.SharingHistoryFragmentViewModel_Factory;
import com.digitalwallet.app.viewmodel.main.history.SharingHistoryFragmentViewModel_MembersInjector;
import com.digitalwallet.app.viewmodel.main.history.TransactionHistoryFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.history.TransactionHistoryFragmentViewModel_Factory;
import com.digitalwallet.app.viewmodel.main.history.TransactionHistoryFragmentViewModel_MembersInjector;
import com.digitalwallet.app.viewmodel.main.holdings.MoreCardsInfoViewModel;
import com.digitalwallet.app.viewmodel.main.holdings.MoreCardsInfoViewModel_Factory;
import com.digitalwallet.app.viewmodel.main.sharing.IncomingRequestFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.sharing.IncomingRequestFragmentViewModel_Factory;
import com.digitalwallet.app.viewmodel.main.sharing.IncomingRequestFragmentViewModel_MembersInjector;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyFragmentViewModel_Factory;
import com.digitalwallet.app.viewmodel.pin.FingerprintDialogFragmentViewModel;
import com.digitalwallet.app.viewmodel.pin.FingerprintDialogFragmentViewModel_Factory;
import com.digitalwallet.app.viewmodel.pin.PinActivityViewModel;
import com.digitalwallet.app.viewmodel.pin.PinActivityViewModel_Factory;
import com.digitalwallet.app.viewmodel.splash.SplashViewModel;
import com.digitalwallet.app.viewmodel.splash.SplashViewModel_Factory;
import com.digitalwallet.app.viewmodel.svservices.ServiceCategoryTransactionsViewModel;
import com.digitalwallet.app.viewmodel.svservices.ServiceCategoryTransactionsViewModel_Factory;
import com.digitalwallet.app.viewmodel.svservices.ServiceGroupCategoriesViewModel;
import com.digitalwallet.app.viewmodel.svservices.ServiceGroupCategoriesViewModel_Factory;
import com.digitalwallet.di.BaseComponent;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.services.RemoteConfigService;
import com.digitalwallet.services.ScannerViewService;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.view.base.BaseActivity_MembersInjector;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import com.digitalwallet.view.checkIn.CheckInOverviewFragment;
import com.digitalwallet.view.checkIn.CheckInOverviewFragment_MembersInjector;
import com.digitalwallet.view.checkIn.CheckInScannerFragment;
import com.digitalwallet.view.checkIn.CheckInScannerFragment_MembersInjector;
import com.digitalwallet.view.checkIn.checkInInput.CheckInAddDependantInputFragment;
import com.digitalwallet.view.checkIn.checkInInput.CheckInAddDependantInputFragment_MembersInjector;
import com.digitalwallet.view.checkIn.checkInInput.CheckInEditPersonInputFragment;
import com.digitalwallet.view.checkIn.checkInInput.CheckInEditPersonInputFragment_MembersInjector;
import com.digitalwallet.view.checkIn.checkInInput.CheckInPrimaryInputFragment;
import com.digitalwallet.view.checkIn.checkInInput.CheckInPrimaryInputFragment_MembersInjector;
import com.digitalwallet.view.checkIn.checkInInput.CheckInSubmittingFragment;
import com.digitalwallet.view.checkIn.checkInInput.CheckInSubmittingFragment_MembersInjector;
import com.digitalwallet.view.checkIn.checkInInput.CheckInSummaryFragment;
import com.digitalwallet.view.checkIn.checkInInput.CheckInSummaryFragment_MembersInjector;
import com.digitalwallet.view.checkIn.checkInShortcut.CheckInShortcutFragment;
import com.digitalwallet.view.checkIn.checkInShortcut.CheckInShortcutFragment_MembersInjector;
import com.digitalwallet.view.checkIn.checkedIn.CheckInFeedbackFragment;
import com.digitalwallet.view.checkIn.checkedIn.CheckInFeedbackFragment_MembersInjector;
import com.digitalwallet.view.checkIn.checkedIn.CheckInFeedbackSuccessFragment;
import com.digitalwallet.view.checkIn.checkedIn.CheckInFeedbackSuccessFragment_MembersInjector;
import com.digitalwallet.view.checkIn.checkedIn.CheckInHistoryDetailFragment;
import com.digitalwallet.view.checkIn.checkedIn.CheckInHistoryDetailFragment_MembersInjector;
import com.digitalwallet.view.checkIn.checkedIn.CheckInSuccessFragment;
import com.digitalwallet.view.checkIn.checkedIn.CheckInSuccessFragment_MembersInjector;
import com.digitalwallet.viewmodel.checkIn.CheckInOverviewViewModel;
import com.digitalwallet.viewmodel.checkIn.CheckInOverviewViewModel_Factory;
import com.digitalwallet.viewmodel.checkIn.CheckInScannerViewModel;
import com.digitalwallet.viewmodel.checkIn.CheckInScannerViewModel_Factory;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInAddDependantInputViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInAddDependantInputViewModel_Factory;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInEditPersonInputViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInEditPersonInputViewModel_Factory;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInPrimaryInputViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInPrimaryInputViewModel_Factory;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInSubmittingViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInSubmittingViewModel_Factory;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInSummaryViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInSummaryViewModel_Factory;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.CheckInShortcutViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.CheckInShortcutViewModel_Factory;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInFeedbackSuccessViewModel;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInFeedbackSuccessViewModel_Factory;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInFeedbackViewModel;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInFeedbackViewModel_Factory;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInHistoryDetailViewModel;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInHistoryDetailViewModel_Factory;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInSuccessViewModel;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInSuccessViewModel_Factory;
import com.squareup.moshi.Moshi;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.android.support.DaggerFragment_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

public final class DaggerAppComponentServer implements AppComponentServer {
    private Provider<SupportFragmentModule_ContributeAccountDetailsFragment.AccountDetailsFragmentSubcomponent.Factory> accountDetailsFragmentSubcomponentFactoryProvider;
    private Provider<AccountDetailsFragmentViewModel> accountDetailsFragmentViewModelProvider;
    private Provider<SupportFragmentModule_ContributeAccountSettingsFragment.AccountSettingsFragmentSubcomponent.Factory> accountSettingsFragmentSubcomponentFactoryProvider;
    private Provider<AnalyticsHelper> analyticsProvider;
    private Provider<Application> applicationProvider;
    private Provider<SupportFragmentModule_AutoSyncFragment.AutoSyncFragmentSubcomponent.Factory> autoSyncFragmentSubcomponentFactoryProvider;
    private Provider<AutoSyncViewModel> autoSyncViewModelProvider;
    private Provider<BLEClient> bLEClientProvider;
    private Provider<BLEServer> bLEServerProvider;
    private final BaseComponent baseComponent;
    private Provider<SupportFragmentModule_ContributeCardAddFragment.CardAddFragmentSubcomponent.Factory> cardAddFragmentSubcomponentFactoryProvider;
    private Provider<CardAddViewModel> cardAddViewModelProvider;
    private Provider<SupportFragmentModule_ContributeCardSyncFragment.CardSyncFragmentSubcomponent.Factory> cardSyncFragmentSubcomponentFactoryProvider;
    private Provider<CardSyncViewModel> cardSyncViewModelProvider;
    private Provider<SupportFragmentModule_ContributeCheckInAddDependantInputFragment.CheckInAddDependantInputFragmentSubcomponent.Factory> checkInAddDependantInputFragmentSubcomponentFactoryProvider;
    private Provider<CheckInAddDependantInputViewModel> checkInAddDependantInputViewModelProvider;
    private Provider<SupportFragmentModule_ContributeCheckInEditPersonInputFragment.CheckInEditPersonInputFragmentSubcomponent.Factory> checkInEditPersonInputFragmentSubcomponentFactoryProvider;
    private Provider<CheckInEditPersonInputViewModel> checkInEditPersonInputViewModelProvider;
    private Provider<SupportFragmentModule_ContributeCheckInFeedbackFragment.CheckInFeedbackFragmentSubcomponent.Factory> checkInFeedbackFragmentSubcomponentFactoryProvider;
    private Provider<SupportFragmentModule_ContributeCheckInFeedbackSuccessFragment.CheckInFeedbackSuccessFragmentSubcomponent.Factory> checkInFeedbackSuccessFragmentSubcomponentFactoryProvider;
    private Provider<CheckInFeedbackSuccessViewModel> checkInFeedbackSuccessViewModelProvider;
    private Provider<CheckInFeedbackViewModel> checkInFeedbackViewModelProvider;
    private Provider<SupportFragmentModule_ContributeCheckInHistoryDetailFragment.CheckInHistoryDetailFragmentSubcomponent.Factory> checkInHistoryDetailFragmentSubcomponentFactoryProvider;
    private Provider<CheckInHistoryDetailViewModel> checkInHistoryDetailViewModelProvider;
    private Provider<SupportFragmentModule_ContributeCheckInOverviewFragment.CheckInOverviewFragmentSubcomponent.Factory> checkInOverviewFragmentSubcomponentFactoryProvider;
    private Provider<CheckInOverviewViewModel> checkInOverviewViewModelProvider;
    private Provider<SupportFragmentModule_ContributeCheckInPrimaryInputFragment.CheckInPrimaryInputFragmentSubcomponent.Factory> checkInPrimaryInputFragmentSubcomponentFactoryProvider;
    private Provider<CheckInPrimaryInputViewModel> checkInPrimaryInputViewModelProvider;
    private Provider<CheckInRepository> checkInRepositoryProvider;
    private Provider<SupportFragmentModule_ContributeCheckInScannerFragment.CheckInScannerFragmentSubcomponent.Factory> checkInScannerFragmentSubcomponentFactoryProvider;
    private Provider<CheckInScannerViewModel> checkInScannerViewModelProvider;
    private Provider<SupportFragmentModule_ContributeCheckInShortcutFragment.CheckInShortcutFragmentSubcomponent.Factory> checkInShortcutFragmentSubcomponentFactoryProvider;
    private Provider<CheckInShortcutViewModel> checkInShortcutViewModelProvider;
    private Provider<SupportFragmentModule_ContributeCheckInSubmittingFragment.CheckInSubmittingFragmentSubcomponent.Factory> checkInSubmittingFragmentSubcomponentFactoryProvider;
    private Provider<CheckInSubmittingViewModel> checkInSubmittingViewModelProvider;
    private Provider<SupportFragmentModule_ContributeCheckInSuccessFragment.CheckInSuccessFragmentSubcomponent.Factory> checkInSuccessFragmentSubcomponentFactoryProvider;
    private Provider<CheckInSuccessViewModel> checkInSuccessViewModelProvider;
    private Provider<SupportFragmentModule_ContributeCheckInSummaryFragment.CheckInSummaryFragmentSubcomponent.Factory> checkInSummaryFragmentSubcomponentFactoryProvider;
    private Provider<CheckInSummaryViewModel> checkInSummaryViewModelProvider;
    private Provider<Context> contextProvider;
    private Provider<SupportFragmentModule_ContributeCreateAccountFragment.CreateAccountFragmentSubcomponent.Factory> createAccountFragmentSubcomponentFactoryProvider;
    private Provider<CreateAccountViewModel> createAccountViewModelProvider;
    private Provider<DigitalWalletApplication> digitalWalletApplicationProvider;
    private Provider<DigitalWalletSecuredStore> digitalWalletSecuredStoreProvider;
    private Provider<SupportFragmentModule_ContributesEligibilityScannerFragment.EligibilityScannerFragmentSubcomponent.Factory> eligibilityScannerFragmentSubcomponentFactoryProvider;
    private Provider<EligibilityScannerFragmentViewModel> eligibilityScannerFragmentViewModelProvider;
    private Provider<SupportFragmentModule_ContributeFingerprintDialogFragment.FingerprintDialogFragmentSubcomponent.Factory> fingerprintDialogFragmentSubcomponentFactoryProvider;
    private Provider<FingerprintDialogFragmentViewModel> fingerprintDialogFragmentViewModelProvider;
    private Provider<HandshakeService> handshakeServiceProvider;
    private Provider<ActivityModule_ContributeHarvestJobActivity.HarvestActivitySubcomponent.Factory> harvestActivitySubcomponentFactoryProvider;
    private Provider<HarvestDataService> harvestDataServiceProvider;
    private Provider<SupportFragmentModule_HarvestJobListFragment.HarvestJobListFragmentSubcomponent.Factory> harvestJobListFragmentSubcomponentFactoryProvider;
    private Provider<SupportFragmentModule_HarvestJobWizardAddressFragment.HarvestJobWizardAddressFragmentSubcomponent.Factory> harvestJobWizardAddressFragmentSubcomponentFactoryProvider;
    private Provider<SupportFragmentModule_HarvestJobWizardConsentFragment.HarvestJobWizardConsentFragmentSubcomponent.Factory> harvestJobWizardConsentFragmentSubcomponentFactoryProvider;
    private Provider<HarvestJobWizardViewModel> harvestJobWizardViewModelProvider;
    private Provider<SupportFragmentModule_HarvestJobWizardZoneFragment.HarvestJobWizardZoneFragmentSubcomponent.Factory> harvestJobWizardZoneFragmentSubcomponentFactoryProvider;
    private Provider<SupportFragmentModule_HarvestScannerFragment.HarvestScannerFragmentSubcomponent.Factory> harvestScannerFragmentSubcomponentFactoryProvider;
    private Provider<SupportFragmentModule_HarvestTagManualEntryFragment.HarvestTagManualEntryFragmentSubcomponent.Factory> harvestTagManualEntryFragmentSubcomponentFactoryProvider;
    private Provider<SupportFragmentModule_HarvestTagSummaryFragment.HarvestTagSummaryFragmentSubcomponent.Factory> harvestTagSummaryFragmentSubcomponentFactoryProvider;
    private Provider<HarvestTagViewModel> harvestTagViewModelProvider;
    private Provider<SupportFragmentModule_ContributeHoldingDetailFragment.HoldingDetailFragmentSubcomponent.Factory> holdingDetailFragmentSubcomponentFactoryProvider;
    private Provider<HoldingDetailFragmentViewModel> holdingDetailFragmentViewModelProvider;
    private Provider<SupportFragmentModule_ContributeHoldingDisclaimerFragment.HoldingDisclaimerFragmentSubcomponent.Factory> holdingDisclaimerFragmentSubcomponentFactoryProvider;
    private Provider<SupportFragmentModule_ContributeHoldingListFragment.HoldingListFragmentSubcomponent.Factory> holdingListFragmentSubcomponentFactoryProvider;
    private Provider<HoldingListFragmentViewModel> holdingListFragmentViewModelProvider;
    private Provider<HoldingParser> holdingParserProvider;
    private Provider<HoldingsApiService> holdingsApiServiceProvider;
    private Provider<HoldingsDbService> holdingsDbServiceProvider;
    private Provider<HoldingsService> holdingsServiceProvider;
    private Provider<SupportFragmentModule_ContributeHomeServicesFragment.HomeServicesFragmentSubcomponent.Factory> homeServicesFragmentSubcomponentFactoryProvider;
    private Provider<HomeServicesViewModel> homeServicesViewModelProvider;
    private Provider<Cache> httpCacheProvider;
    private Provider<SupportFragmentModule_ContributeIncomingRequestFragment.IncomingRequestFragmentSubcomponent.Factory> incomingRequestFragmentSubcomponentFactoryProvider;
    private Provider<IncomingRequestFragmentViewModel> incomingRequestFragmentViewModelProvider;
    private Provider<JWTIssuerKeysService> jWTIssuerKeysServiceProvider;
    private Provider<SupportFragmentModule_ContributeLobbyFragment.LobbyFragmentSubcomponent.Factory> lobbyFragmentSubcomponentFactoryProvider;
    private Provider<LobbyFragmentViewModel> lobbyFragmentViewModelProvider;
    private Provider<ActivityModule_ContributeLoginActivity.LoginActivitySubcomponent.Factory> loginActivitySubcomponentFactoryProvider;
    private Provider<LoginActivityViewModel> loginActivityViewModelProvider;
    private Provider<ActivityModuleServer_ContributeMainActivity.MainActivityServerSubcomponent.Factory> mainActivityServerSubcomponentFactoryProvider;
    private Provider<MainActivityViewModel> mainActivityViewModelProvider;
    private Provider<SupportFragmentModule_ContributeMainPagerFragment.MainPagerFragmentSubcomponent.Factory> mainPagerFragmentSubcomponentFactoryProvider;
    private Provider<MainPagerFragmentViewModel> mainPagerFragmentViewModelProvider;
    private Provider<SupportFragmentModule_ContributeMoreCardsInfoFragment.MoreCardsInfoFragmentSubcomponent.Factory> moreCardsInfoFragmentSubcomponentFactoryProvider;
    private Provider<MoreCardsInfoViewModel> moreCardsInfoViewModelProvider;
    private Provider<Moshi> moshiProvider;
    private Provider<SupportFragmentModule_NicknameCreateFragment.NicknameCreateFragmentSubcomponent.Factory> nicknameCreateFragmentSubcomponentFactoryProvider;
    private Provider<SupportFragmentModule_NicknameEditFragment.NicknameEditFragmentSubcomponent.Factory> nicknameEditFragmentSubcomponentFactoryProvider;
    private Provider<NicknameViewModel> nicknameViewModelProvider;
    private Provider<OkHttpClient> okHttpClientProvider;
    private Provider<ActivityModule_ContributeOnboardingActivity.OnboardingActivitySubcomponent.Factory> onboardingActivitySubcomponentFactoryProvider;
    private Provider<ActivityModule_ContributePinActivity.PinActivitySubcomponent.Factory> pinActivitySubcomponentFactoryProvider;
    private Provider<PinActivityViewModel> pinActivityViewModelProvider;
    private Provider<OkHttpClient> provideApiHttpProvider;
    private Provider<AppStartUp> provideAppStartUpProvider;
    private Provider<AssetApi> provideAssetApiProvider;
    private Provider<AssetService> provideAssetServiceProvider;
    private Provider<AuthApi> provideAuthApiProvider;
    private Provider<AuthenticationService> provideAuthenticationEndpointsProvider;
    private Provider<AuthenticationUtility> provideAuthenticationUtilityProvider;
    private Provider<BLEUtil> provideBLEUtilProvider;
    private Provider<BluetoothEventsService> provideBluetoothEventsServiceProvider;
    private Provider<ConfigApi> provideConfigApiProvider;
    private Provider<ConfigurationDocument> provideConfigurationDocumentProvider;
    private Provider<Converter.Factory> provideCustomConverterFactoryProvider;
    private Provider<DeviceRegisterApi> provideDeviceRegisterApiProvider;
    private Provider<DigitalWalletDatabase> provideDigitalWalletDatabaseProvider;
    private Provider<HarvestModel> provideHarvestModelProvider;
    private Provider<HoldingsApi> provideHoldingsApiProvider;
    private Provider<JWTIssuerKeysDao> provideJWTIssuerKeysDaoProvider;
    private Provider<OIDCRequestHandler> provideOIDCRequestHandlerProvider;
    private Provider<ScanDao> provideScanDaoProvider;
    private Provider<ShareRecordStore> provideShareRecordStoreProvider;
    private Provider<SimpleAssetService> provideSimpleAssetServiceProvider;
    private Provider<UnsecuredStore> provideUnSecureHoldingStoreProvider;
    private Provider<UserApi> provideUserApiProvider;
    private Provider<SupportFragmentModule_ContributeRegisterSuccessFragment.RegisterSuccessFragmentSubcomponent.Factory> registerSuccessFragmentSubcomponentFactoryProvider;
    private Provider<RegisterSuccessViewModel> registerSuccessViewModelProvider;
    private Provider<RemoteConfigService> remoteConfigServiceProvider;
    private Provider<RemoteSubscriptionService> remoteSubscriptionServiceProvider;
    private Provider<ScannerDataService> scannerDataServiceProvider;
    private Provider<ScannerViewService> scannerViewServiceProvider;
    private Provider<SupportFragmentModule_ServiceCategoryTransactionsFragment.ServiceCategoryTransactionsFragmentSubcomponent.Factory> serviceCategoryTransactionsFragmentSubcomponentFactoryProvider;
    private Provider<ServiceCategoryTransactionsViewModel> serviceCategoryTransactionsViewModelProvider;
    private Provider<SupportFragmentModule_ContributeServiceDetailFragment.ServiceDetailFragmentSubcomponent.Factory> serviceDetailFragmentSubcomponentFactoryProvider;
    private Provider<SupportFragmentModule_ServiceGroupCategoriesFragment.ServiceGroupCategoriesFragmentSubcomponent.Factory> serviceGroupCategoriesFragmentSubcomponentFactoryProvider;
    private Provider<SupportFragmentModule_ContributeServiceTypeFragment.ServiceTypeFragmentSubcomponent.Factory> serviceTypeFragmentSubcomponentFactoryProvider;
    private Provider<ActivityModule_ContributeSetupActivity.SetupActivitySubcomponent.Factory> setupActivitySubcomponentFactoryProvider;
    private Provider<SupportFragmentModule_ContributeSharingDetailsFragment.SharingDetailsFragmentSubcomponent.Factory> sharingDetailsFragmentSubcomponentFactoryProvider;
    private Provider<SupportFragmentModule_ContributeSharingHistoryFragment.SharingHistoryFragmentSubcomponent.Factory> sharingHistoryFragmentSubcomponentFactoryProvider;
    private Provider<SharingHistoryFragmentViewModel> sharingHistoryFragmentViewModelProvider;
    private Provider<ActivityModule_ContributeSecondSplashActivity.SplashActivitySubcomponent.Factory> splashActivitySubcomponentFactoryProvider;
    private Provider<SplashViewModel> splashViewModelProvider;
    private Provider<SupportFragmentModule_ContributeTransactionHistoryFragment.TransactionHistoryFragmentSubcomponent.Factory> transactionHistoryFragmentSubcomponentFactoryProvider;
    private Provider<TransactionHistoryFragmentViewModel> transactionHistoryFragmentViewModelProvider;
    private Provider<TransactionSharesService> transactionSharesServiceProvider;
    private Provider<SupportFragmentModule_ContributeVerifyEmailFragment.VerifyEmailFragmentSubcomponent.Factory> verifyEmailFragmentSubcomponentFactoryProvider;
    private Provider<VerifyEmailViewModel> verifyEmailViewModelProvider;

    private DaggerAppComponentServer(AppModuleServer appModuleServer, OIDCModule oIDCModule, DatabaseModule databaseModule, ApiModule apiModule, BaseComponent baseComponent2) {
        this.baseComponent = baseComponent2;
        initialize(appModuleServer, oIDCModule, databaseModule, apiModule, baseComponent2);
        initialize2(appModuleServer, oIDCModule, databaseModule, apiModule, baseComponent2);
    }

    public static AppComponentServer.Factory factory() {
        return new Factory();
    }

    private Map<Class<?>, Provider<AndroidInjector.Factory<?>>> getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf() {
        return MapBuilder.newMapBuilder(53).put(FingerprintDialogFragment.class, this.fingerprintDialogFragmentSubcomponentFactoryProvider).put(MainPagerFragment.class, this.mainPagerFragmentSubcomponentFactoryProvider).put(ServiceTypeFragment.class, this.serviceTypeFragmentSubcomponentFactoryProvider).put(ServiceDetailFragment.class, this.serviceDetailFragmentSubcomponentFactoryProvider).put(TransactionHistoryFragment.class, this.transactionHistoryFragmentSubcomponentFactoryProvider).put(AccountSettingsFragment.class, this.accountSettingsFragmentSubcomponentFactoryProvider).put(AccountDetailsFragment.class, this.accountDetailsFragmentSubcomponentFactoryProvider).put(HoldingListFragment.class, this.holdingListFragmentSubcomponentFactoryProvider).put(HoldingDetailFragment.class, this.holdingDetailFragmentSubcomponentFactoryProvider).put(HoldingDisclaimerFragment.class, this.holdingDisclaimerFragmentSubcomponentFactoryProvider).put(LobbyFragment.class, this.lobbyFragmentSubcomponentFactoryProvider).put(CardSyncFragment.class, this.cardSyncFragmentSubcomponentFactoryProvider).put(IncomingRequestFragment.class, this.incomingRequestFragmentSubcomponentFactoryProvider).put(CardAddFragment.class, this.cardAddFragmentSubcomponentFactoryProvider).put(SharingHistoryFragment.class, this.sharingHistoryFragmentSubcomponentFactoryProvider).put(SharingDetailsFragment.class, this.sharingDetailsFragmentSubcomponentFactoryProvider).put(EligibilityScannerFragment.class, this.eligibilityScannerFragmentSubcomponentFactoryProvider).put(NicknameCreateFragment.class, this.nicknameCreateFragmentSubcomponentFactoryProvider).put(NicknameEditFragment.class, this.nicknameEditFragmentSubcomponentFactoryProvider).put(AutoSyncFragment.class, this.autoSyncFragmentSubcomponentFactoryProvider).put(HarvestJobListFragment.class, this.harvestJobListFragmentSubcomponentFactoryProvider).put(HarvestJobWizardConsentFragment.class, this.harvestJobWizardConsentFragmentSubcomponentFactoryProvider).put(HarvestJobWizardAddressFragment.class, this.harvestJobWizardAddressFragmentSubcomponentFactoryProvider).put(HarvestJobWizardZoneFragment.class, this.harvestJobWizardZoneFragmentSubcomponentFactoryProvider).put(HarvestScannerFragment.class, this.harvestScannerFragmentSubcomponentFactoryProvider).put(HarvestTagManualEntryFragment.class, this.harvestTagManualEntryFragmentSubcomponentFactoryProvider).put(HarvestTagSummaryFragment.class, this.harvestTagSummaryFragmentSubcomponentFactoryProvider).put(CheckInOverviewFragment.class, this.checkInOverviewFragmentSubcomponentFactoryProvider).put(CheckInPrimaryInputFragment.class, this.checkInPrimaryInputFragmentSubcomponentFactoryProvider).put(CheckInAddDependantInputFragment.class, this.checkInAddDependantInputFragmentSubcomponentFactoryProvider).put(CheckInSummaryFragment.class, this.checkInSummaryFragmentSubcomponentFactoryProvider).put(CheckInEditPersonInputFragment.class, this.checkInEditPersonInputFragmentSubcomponentFactoryProvider).put(CheckInSubmittingFragment.class, this.checkInSubmittingFragmentSubcomponentFactoryProvider).put(CheckInSuccessFragment.class, this.checkInSuccessFragmentSubcomponentFactoryProvider).put(CheckInScannerFragment.class, this.checkInScannerFragmentSubcomponentFactoryProvider).put(CheckInHistoryDetailFragment.class, this.checkInHistoryDetailFragmentSubcomponentFactoryProvider).put(CheckInFeedbackFragment.class, this.checkInFeedbackFragmentSubcomponentFactoryProvider).put(CheckInFeedbackSuccessFragment.class, this.checkInFeedbackSuccessFragmentSubcomponentFactoryProvider).put(CheckInShortcutFragment.class, this.checkInShortcutFragmentSubcomponentFactoryProvider).put(HomeServicesFragment.class, this.homeServicesFragmentSubcomponentFactoryProvider).put(ServiceGroupCategoriesFragment.class, this.serviceGroupCategoriesFragmentSubcomponentFactoryProvider).put(ServiceCategoryTransactionsFragment.class, this.serviceCategoryTransactionsFragmentSubcomponentFactoryProvider).put(CreateAccountFragment.class, this.createAccountFragmentSubcomponentFactoryProvider).put(VerifyEmailFragment.class, this.verifyEmailFragmentSubcomponentFactoryProvider).put(RegisterSuccessFragment.class, this.registerSuccessFragmentSubcomponentFactoryProvider).put(MoreCardsInfoFragment.class, this.moreCardsInfoFragmentSubcomponentFactoryProvider).put(LoginActivity.class, this.loginActivitySubcomponentFactoryProvider).put(SplashActivity.class, this.splashActivitySubcomponentFactoryProvider).put(PinActivity.class, this.pinActivitySubcomponentFactoryProvider).put(OnboardingActivity.class, this.onboardingActivitySubcomponentFactoryProvider).put(SetupActivity.class, this.setupActivitySubcomponentFactoryProvider).put(HarvestActivity.class, this.harvestActivitySubcomponentFactoryProvider).put(MainActivityServer.class, this.mainActivityServerSubcomponentFactoryProvider).build();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private DispatchingAndroidInjector<Object> getDispatchingAndroidInjectorOfObject() {
        return DispatchingAndroidInjector_Factory.newInstance(getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), Collections.emptyMap());
    }

    private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel() {
        return MapBuilder.newMapBuilder(41).put(LoginActivityViewModel.class, this.loginActivityViewModelProvider).put(MainActivityViewModel.class, this.mainActivityViewModelProvider).put(SplashViewModel.class, this.splashViewModelProvider).put(PinActivityViewModel.class, this.pinActivityViewModelProvider).put(FingerprintDialogFragmentViewModel.class, this.fingerprintDialogFragmentViewModelProvider).put(MainPagerFragmentViewModel.class, this.mainPagerFragmentViewModelProvider).put(ServiceDetailFragmentViewModel.class, ServiceDetailFragmentViewModel_Factory.create()).put(TransactionHistoryFragmentViewModel.class, this.transactionHistoryFragmentViewModelProvider).put(AccountSettingsFragmentViewModel.class, AccountSettingsFragmentViewModel_Factory.create()).put(AccountDetailsFragmentViewModel.class, this.accountDetailsFragmentViewModelProvider).put(HoldingListFragmentViewModel.class, this.holdingListFragmentViewModelProvider).put(HoldingDetailFragmentViewModel.class, this.holdingDetailFragmentViewModelProvider).put(LobbyFragmentViewModel.class, this.lobbyFragmentViewModelProvider).put(CardSyncViewModel.class, this.cardSyncViewModelProvider).put(IncomingRequestFragmentViewModel.class, this.incomingRequestFragmentViewModelProvider).put(CardAddViewModel.class, this.cardAddViewModelProvider).put(SharingHistoryFragmentViewModel.class, this.sharingHistoryFragmentViewModelProvider).put(EligibilityScannerFragmentViewModel.class, this.eligibilityScannerFragmentViewModelProvider).put(NicknameViewModel.class, this.nicknameViewModelProvider).put(AutoSyncViewModel.class, this.autoSyncViewModelProvider).put(HarvestJobWizardViewModel.class, this.harvestJobWizardViewModelProvider).put(HarvestTagViewModel.class, this.harvestTagViewModelProvider).put(CheckInOverviewViewModel.class, this.checkInOverviewViewModelProvider).put(CheckInPrimaryInputViewModel.class, this.checkInPrimaryInputViewModelProvider).put(CheckInAddDependantInputViewModel.class, this.checkInAddDependantInputViewModelProvider).put(CheckInSummaryViewModel.class, this.checkInSummaryViewModelProvider).put(CheckInEditPersonInputViewModel.class, this.checkInEditPersonInputViewModelProvider).put(CheckInSubmittingViewModel.class, this.checkInSubmittingViewModelProvider).put(CheckInSuccessViewModel.class, this.checkInSuccessViewModelProvider).put(CheckInFeedbackViewModel.class, this.checkInFeedbackViewModelProvider).put(CheckInFeedbackSuccessViewModel.class, this.checkInFeedbackSuccessViewModelProvider).put(CheckInScannerViewModel.class, this.checkInScannerViewModelProvider).put(CheckInHistoryDetailViewModel.class, this.checkInHistoryDetailViewModelProvider).put(CheckInShortcutViewModel.class, this.checkInShortcutViewModelProvider).put(HomeServicesViewModel.class, this.homeServicesViewModelProvider).put(ServiceGroupCategoriesViewModel.class, ServiceGroupCategoriesViewModel_Factory.create()).put(ServiceCategoryTransactionsViewModel.class, this.serviceCategoryTransactionsViewModelProvider).put(CreateAccountViewModel.class, this.createAccountViewModelProvider).put(VerifyEmailViewModel.class, this.verifyEmailViewModelProvider).put(RegisterSuccessViewModel.class, this.registerSuccessViewModelProvider).put(MoreCardsInfoViewModel.class, this.moreCardsInfoViewModelProvider).build();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ViewModelFactory getViewModelFactory() {
        return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private HarvestJobWizardViewModel getHarvestJobWizardViewModel() {
        return new HarvestJobWizardViewModel(this.provideHarvestModelProvider.get());
    }

    private HarvestDataService getHarvestDataService() {
        return new HarvestDataService(this.provideHoldingsApiProvider.get(), this.provideHarvestModelProvider.get(), (Context) Preconditions.checkNotNull(this.baseComponent.context(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private HarvestTagViewModel getHarvestTagViewModel() {
        return new HarvestTagViewModel(this.provideHarvestModelProvider.get(), (ScannerViewService) Preconditions.checkNotNull(this.baseComponent.scannerViewService(), "Cannot return null from a non-@Nullable component method"), getHarvestDataService());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private LoginActivityViewModel getLoginActivityViewModel() {
        return new LoginActivityViewModel(this.provideAuthenticationEndpointsProvider.get(), (Moshi) Preconditions.checkNotNull(this.baseComponent.moshi(), "Cannot return null from a non-@Nullable component method"), (AnalyticsHelper) Preconditions.checkNotNull(this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method"), (Context) Preconditions.checkNotNull(this.baseComponent.context(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private RemoteSubscriptionService getRemoteSubscriptionService() {
        return new RemoteSubscriptionService((Context) Preconditions.checkNotNull(this.baseComponent.context(), "Cannot return null from a non-@Nullable component method"), this.provideDeviceRegisterApiProvider.get(), this.provideAuthenticationUtilityProvider.get());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private MainActivityViewModel getMainActivityViewModel() {
        return new MainActivityViewModel(this.holdingsServiceProvider.get(), (RemoteConfigService) Preconditions.checkNotNull(this.baseComponent.remoteConfigService(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private PinActivityViewModel getPinActivityViewModel() {
        return new PinActivityViewModel(this.provideAuthenticationUtilityProvider.get(), (AnalyticsHelper) Preconditions.checkNotNull(this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method"), this.holdingsServiceProvider.get(), this.provideDigitalWalletDatabaseProvider.get(), this.handshakeServiceProvider.get());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private SplashViewModel getSplashViewModel() {
        return new SplashViewModel(this.provideAuthenticationUtilityProvider.get(), this.provideAuthenticationEndpointsProvider.get(), this.holdingsServiceProvider.get(), this.provideDigitalWalletDatabaseProvider.get(), (AnalyticsHelper) Preconditions.checkNotNull(this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private FingerprintDialogFragmentViewModel getFingerprintDialogFragmentViewModel() {
        return new FingerprintDialogFragmentViewModel((AnalyticsHelper) Preconditions.checkNotNull(this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private MainPagerFragmentViewModel getMainPagerFragmentViewModel() {
        return new MainPagerFragmentViewModel(this.provideAuthenticationUtilityProvider.get(), this.holdingsServiceProvider.get(), this.provideDigitalWalletDatabaseProvider.get(), this.handshakeServiceProvider.get());
    }

    private TransactionSharesService getTransactionSharesService() {
        return new TransactionSharesService(this.provideHoldingsApiProvider.get(), this.provideShareRecordStoreProvider.get());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private TransactionHistoryFragmentViewModel getTransactionHistoryFragmentViewModel() {
        return injectTransactionHistoryFragmentViewModel(TransactionHistoryFragmentViewModel_Factory.newInstance((AnalyticsHelper) Preconditions.checkNotNull(this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method")));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private AccountDetailsFragmentViewModel getAccountDetailsFragmentViewModel() {
        return injectAccountDetailsFragmentViewModel(AccountDetailsFragmentViewModel_Factory.newInstance((Context) Preconditions.checkNotNull(this.baseComponent.context(), "Cannot return null from a non-@Nullable component method"), getTransactionSharesService(), (AnalyticsHelper) Preconditions.checkNotNull(this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method")));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private HoldingListFragmentViewModel getHoldingListFragmentViewModel() {
        return new HoldingListFragmentViewModel((Context) Preconditions.checkNotNull(this.baseComponent.context(), "Cannot return null from a non-@Nullable component method"), this.holdingsServiceProvider.get(), this.provideBluetoothEventsServiceProvider.get());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private HoldingDetailFragmentViewModel getHoldingDetailFragmentViewModel() {
        return new HoldingDetailFragmentViewModel((AnalyticsHelper) Preconditions.checkNotNull(this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private LobbyFragmentViewModel getLobbyFragmentViewModel() {
        return new LobbyFragmentViewModel((AnalyticsHelper) Preconditions.checkNotNull(this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method"), this.holdingsServiceProvider.get(), this.holdingParserProvider.get(), this.provideAssetServiceProvider.get(), getTransactionSharesService(), this.provideAppStartUpProvider.get(), this.bLEClientProvider.get());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CardSyncViewModel getCardSyncViewModel() {
        return new CardSyncViewModel(this.holdingsServiceProvider.get(), (Moshi) Preconditions.checkNotNull(this.baseComponent.moshi(), "Cannot return null from a non-@Nullable component method"), this.provideAssetServiceProvider.get(), this.provideAuthenticationEndpointsProvider.get());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private IncomingRequestFragmentViewModel getIncomingRequestFragmentViewModel() {
        return injectIncomingRequestFragmentViewModel(IncomingRequestFragmentViewModel_Factory.newInstance((AnalyticsHelper) Preconditions.checkNotNull(this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method")));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CardAddViewModel getCardAddViewModel() {
        return new CardAddViewModel((AnalyticsHelper) Preconditions.checkNotNull(this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private SharingHistoryFragmentViewModel getSharingHistoryFragmentViewModel() {
        return injectSharingHistoryFragmentViewModel(SharingHistoryFragmentViewModel_Factory.newInstance());
    }

    private ScannerDataService getScannerDataService() {
        return new ScannerDataService((Moshi) Preconditions.checkNotNull(this.baseComponent.moshi(), "Cannot return null from a non-@Nullable component method"), this.provideHoldingsApiProvider.get(), this.provideScanDaoProvider.get());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private EligibilityScannerFragmentViewModel getEligibilityScannerFragmentViewModel() {
        return new EligibilityScannerFragmentViewModel((ScannerViewService) Preconditions.checkNotNull(this.baseComponent.scannerViewService(), "Cannot return null from a non-@Nullable component method"), getScannerDataService());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private NicknameViewModel getNicknameViewModel() {
        return new NicknameViewModel(this.provideAuthenticationUtilityProvider.get());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private AutoSyncViewModel getAutoSyncViewModel() {
        return new AutoSyncViewModel(this.provideAuthenticationUtilityProvider.get());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CheckInOverviewViewModel getCheckInOverviewViewModel() {
        return new CheckInOverviewViewModel((Context) Preconditions.checkNotNull(this.baseComponent.context(), "Cannot return null from a non-@Nullable component method"), (CheckInRepository) Preconditions.checkNotNull(this.baseComponent.checkInRepository(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CheckInPrimaryInputViewModel getCheckInPrimaryInputViewModel() {
        return new CheckInPrimaryInputViewModel((CheckInRepository) Preconditions.checkNotNull(this.baseComponent.checkInRepository(), "Cannot return null from a non-@Nullable component method"), (AnalyticsHelper) Preconditions.checkNotNull(this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CheckInAddDependantInputViewModel getCheckInAddDependantInputViewModel() {
        return new CheckInAddDependantInputViewModel((CheckInRepository) Preconditions.checkNotNull(this.baseComponent.checkInRepository(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CheckInSummaryViewModel getCheckInSummaryViewModel() {
        return new CheckInSummaryViewModel((Context) Preconditions.checkNotNull(this.baseComponent.context(), "Cannot return null from a non-@Nullable component method"), (CheckInRepository) Preconditions.checkNotNull(this.baseComponent.checkInRepository(), "Cannot return null from a non-@Nullable component method"), (AnalyticsHelper) Preconditions.checkNotNull(this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CheckInEditPersonInputViewModel getCheckInEditPersonInputViewModel() {
        return new CheckInEditPersonInputViewModel((CheckInRepository) Preconditions.checkNotNull(this.baseComponent.checkInRepository(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CheckInSubmittingViewModel getCheckInSubmittingViewModel() {
        return new CheckInSubmittingViewModel((CheckInRepository) Preconditions.checkNotNull(this.baseComponent.checkInRepository(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CheckInSuccessViewModel getCheckInSuccessViewModel() {
        return new CheckInSuccessViewModel((Context) Preconditions.checkNotNull(this.baseComponent.context(), "Cannot return null from a non-@Nullable component method"), (CheckInRepository) Preconditions.checkNotNull(this.baseComponent.checkInRepository(), "Cannot return null from a non-@Nullable component method"), (AnalyticsHelper) Preconditions.checkNotNull(this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CheckInScannerViewModel getCheckInScannerViewModel() {
        return new CheckInScannerViewModel((ScannerViewService) Preconditions.checkNotNull(this.baseComponent.scannerViewService(), "Cannot return null from a non-@Nullable component method"), (Moshi) Preconditions.checkNotNull(this.baseComponent.moshi(), "Cannot return null from a non-@Nullable component method"), (OkHttpClient) Preconditions.checkNotNull(this.baseComponent.okHttpClient(), "Cannot return null from a non-@Nullable component method"), (Context) Preconditions.checkNotNull(this.baseComponent.context(), "Cannot return null from a non-@Nullable component method"), (AnalyticsHelper) Preconditions.checkNotNull(this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CheckInHistoryDetailViewModel getCheckInHistoryDetailViewModel() {
        return new CheckInHistoryDetailViewModel((Context) Preconditions.checkNotNull(this.baseComponent.context(), "Cannot return null from a non-@Nullable component method"), (CheckInRepository) Preconditions.checkNotNull(this.baseComponent.checkInRepository(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CheckInFeedbackViewModel getCheckInFeedbackViewModel() {
        return new CheckInFeedbackViewModel((Context) Preconditions.checkNotNull(this.baseComponent.context(), "Cannot return null from a non-@Nullable component method"), (CheckInRepository) Preconditions.checkNotNull(this.baseComponent.checkInRepository(), "Cannot return null from a non-@Nullable component method"), (AnalyticsHelper) Preconditions.checkNotNull(this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CheckInFeedbackSuccessViewModel getCheckInFeedbackSuccessViewModel() {
        return new CheckInFeedbackSuccessViewModel((Context) Preconditions.checkNotNull(this.baseComponent.context(), "Cannot return null from a non-@Nullable component method"), (CheckInRepository) Preconditions.checkNotNull(this.baseComponent.checkInRepository(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CheckInShortcutViewModel getCheckInShortcutViewModel() {
        return new CheckInShortcutViewModel((Context) Preconditions.checkNotNull(this.baseComponent.context(), "Cannot return null from a non-@Nullable component method"), (CheckInRepository) Preconditions.checkNotNull(this.baseComponent.checkInRepository(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private HomeServicesViewModel getHomeServicesViewModel() {
        return new HomeServicesViewModel((Moshi) Preconditions.checkNotNull(this.baseComponent.moshi(), "Cannot return null from a non-@Nullable component method"), (Context) Preconditions.checkNotNull(this.baseComponent.context(), "Cannot return null from a non-@Nullable component method"), this.provideSimpleAssetServiceProvider.get(), (CheckInRepository) Preconditions.checkNotNull(this.baseComponent.checkInRepository(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ServiceCategoryTransactionsViewModel getServiceCategoryTransactionsViewModel() {
        return new ServiceCategoryTransactionsViewModel((Context) Preconditions.checkNotNull(this.baseComponent.context(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CreateAccountViewModel getCreateAccountViewModel() {
        return new CreateAccountViewModel((Context) Preconditions.checkNotNull(this.baseComponent.context(), "Cannot return null from a non-@Nullable component method"), this.provideUserApiProvider.get(), getRemoteSubscriptionService(), (Moshi) Preconditions.checkNotNull(this.baseComponent.moshi(), "Cannot return null from a non-@Nullable component method"), (AnalyticsHelper) Preconditions.checkNotNull(this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private VerifyEmailViewModel getVerifyEmailViewModel() {
        return new VerifyEmailViewModel((Context) Preconditions.checkNotNull(this.baseComponent.context(), "Cannot return null from a non-@Nullable component method"), this.provideUserApiProvider.get(), this.provideAuthenticationEndpointsProvider.get(), (Moshi) Preconditions.checkNotNull(this.baseComponent.moshi(), "Cannot return null from a non-@Nullable component method"), (AnalyticsHelper) Preconditions.checkNotNull(this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private RegisterSuccessViewModel getRegisterSuccessViewModel() {
        return new RegisterSuccessViewModel((AnalyticsHelper) Preconditions.checkNotNull(this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private MoreCardsInfoViewModel getMoreCardsInfoViewModel() {
        return new MoreCardsInfoViewModel((Context) Preconditions.checkNotNull(this.baseComponent.context(), "Cannot return null from a non-@Nullable component method"));
    }

    private void initialize(AppModuleServer appModuleServer, OIDCModule oIDCModule, DatabaseModule databaseModule, ApiModule apiModule, BaseComponent baseComponent2) {
        this.fingerprintDialogFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeFingerprintDialogFragment.FingerprintDialogFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass1 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeFingerprintDialogFragment.FingerprintDialogFragmentSubcomponent.Factory get() {
                return new FingerprintDialogFragmentSubcomponentFactory();
            }
        };
        this.mainPagerFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeMainPagerFragment.MainPagerFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass2 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeMainPagerFragment.MainPagerFragmentSubcomponent.Factory get() {
                return new MainPagerFragmentSubcomponentFactory();
            }
        };
        this.serviceTypeFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeServiceTypeFragment.ServiceTypeFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass3 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeServiceTypeFragment.ServiceTypeFragmentSubcomponent.Factory get() {
                return new ServiceTypeFragmentSubcomponentFactory();
            }
        };
        this.serviceDetailFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeServiceDetailFragment.ServiceDetailFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass4 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeServiceDetailFragment.ServiceDetailFragmentSubcomponent.Factory get() {
                return new ServiceDetailFragmentSubcomponentFactory();
            }
        };
        this.transactionHistoryFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeTransactionHistoryFragment.TransactionHistoryFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass5 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeTransactionHistoryFragment.TransactionHistoryFragmentSubcomponent.Factory get() {
                return new TransactionHistoryFragmentSubcomponentFactory();
            }
        };
        this.accountSettingsFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeAccountSettingsFragment.AccountSettingsFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass6 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeAccountSettingsFragment.AccountSettingsFragmentSubcomponent.Factory get() {
                return new AccountSettingsFragmentSubcomponentFactory();
            }
        };
        this.accountDetailsFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeAccountDetailsFragment.AccountDetailsFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass7 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeAccountDetailsFragment.AccountDetailsFragmentSubcomponent.Factory get() {
                return new AccountDetailsFragmentSubcomponentFactory();
            }
        };
        this.holdingListFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeHoldingListFragment.HoldingListFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass8 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeHoldingListFragment.HoldingListFragmentSubcomponent.Factory get() {
                return new HoldingListFragmentSubcomponentFactory();
            }
        };
        this.holdingDetailFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeHoldingDetailFragment.HoldingDetailFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass9 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeHoldingDetailFragment.HoldingDetailFragmentSubcomponent.Factory get() {
                return new HoldingDetailFragmentSubcomponentFactory();
            }
        };
        this.holdingDisclaimerFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeHoldingDisclaimerFragment.HoldingDisclaimerFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass10 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeHoldingDisclaimerFragment.HoldingDisclaimerFragmentSubcomponent.Factory get() {
                return new HoldingDisclaimerFragmentSubcomponentFactory();
            }
        };
        this.lobbyFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeLobbyFragment.LobbyFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass11 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeLobbyFragment.LobbyFragmentSubcomponent.Factory get() {
                return new LobbyFragmentSubcomponentFactory();
            }
        };
        this.cardSyncFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeCardSyncFragment.CardSyncFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass12 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeCardSyncFragment.CardSyncFragmentSubcomponent.Factory get() {
                return new CardSyncFragmentSubcomponentFactory();
            }
        };
        this.incomingRequestFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeIncomingRequestFragment.IncomingRequestFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass13 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeIncomingRequestFragment.IncomingRequestFragmentSubcomponent.Factory get() {
                return new IncomingRequestFragmentSubcomponentFactory();
            }
        };
        this.cardAddFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeCardAddFragment.CardAddFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass14 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeCardAddFragment.CardAddFragmentSubcomponent.Factory get() {
                return new CardAddFragmentSubcomponentFactory();
            }
        };
        this.sharingHistoryFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeSharingHistoryFragment.SharingHistoryFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass15 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeSharingHistoryFragment.SharingHistoryFragmentSubcomponent.Factory get() {
                return new SharingHistoryFragmentSubcomponentFactory();
            }
        };
        this.sharingDetailsFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeSharingDetailsFragment.SharingDetailsFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass16 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeSharingDetailsFragment.SharingDetailsFragmentSubcomponent.Factory get() {
                return new SharingDetailsFragmentSubcomponentFactory();
            }
        };
        this.eligibilityScannerFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributesEligibilityScannerFragment.EligibilityScannerFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass17 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributesEligibilityScannerFragment.EligibilityScannerFragmentSubcomponent.Factory get() {
                return new EligibilityScannerFragmentSubcomponentFactory();
            }
        };
        this.nicknameCreateFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_NicknameCreateFragment.NicknameCreateFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass18 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_NicknameCreateFragment.NicknameCreateFragmentSubcomponent.Factory get() {
                return new NicknameCreateFragmentSubcomponentFactory();
            }
        };
        this.nicknameEditFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_NicknameEditFragment.NicknameEditFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass19 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_NicknameEditFragment.NicknameEditFragmentSubcomponent.Factory get() {
                return new NicknameEditFragmentSubcomponentFactory();
            }
        };
        this.autoSyncFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_AutoSyncFragment.AutoSyncFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass20 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_AutoSyncFragment.AutoSyncFragmentSubcomponent.Factory get() {
                return new AutoSyncFragmentSubcomponentFactory();
            }
        };
        this.harvestJobListFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_HarvestJobListFragment.HarvestJobListFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass21 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_HarvestJobListFragment.HarvestJobListFragmentSubcomponent.Factory get() {
                return new HarvestJobListFragmentSubcomponentFactory();
            }
        };
        this.harvestJobWizardConsentFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_HarvestJobWizardConsentFragment.HarvestJobWizardConsentFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass22 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_HarvestJobWizardConsentFragment.HarvestJobWizardConsentFragmentSubcomponent.Factory get() {
                return new HarvestJobWizardConsentFragmentSubcomponentFactory();
            }
        };
        this.harvestJobWizardAddressFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_HarvestJobWizardAddressFragment.HarvestJobWizardAddressFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass23 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_HarvestJobWizardAddressFragment.HarvestJobWizardAddressFragmentSubcomponent.Factory get() {
                return new HarvestJobWizardAddressFragmentSubcomponentFactory();
            }
        };
        this.harvestJobWizardZoneFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_HarvestJobWizardZoneFragment.HarvestJobWizardZoneFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass24 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_HarvestJobWizardZoneFragment.HarvestJobWizardZoneFragmentSubcomponent.Factory get() {
                return new HarvestJobWizardZoneFragmentSubcomponentFactory();
            }
        };
        this.harvestScannerFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_HarvestScannerFragment.HarvestScannerFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass25 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_HarvestScannerFragment.HarvestScannerFragmentSubcomponent.Factory get() {
                return new HarvestScannerFragmentSubcomponentFactory();
            }
        };
        this.harvestTagManualEntryFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_HarvestTagManualEntryFragment.HarvestTagManualEntryFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass26 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_HarvestTagManualEntryFragment.HarvestTagManualEntryFragmentSubcomponent.Factory get() {
                return new HarvestTagManualEntryFragmentSubcomponentFactory();
            }
        };
        this.harvestTagSummaryFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_HarvestTagSummaryFragment.HarvestTagSummaryFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass27 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_HarvestTagSummaryFragment.HarvestTagSummaryFragmentSubcomponent.Factory get() {
                return new HarvestTagSummaryFragmentSubcomponentFactory();
            }
        };
        this.checkInOverviewFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeCheckInOverviewFragment.CheckInOverviewFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass28 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeCheckInOverviewFragment.CheckInOverviewFragmentSubcomponent.Factory get() {
                return new CheckInOverviewFragmentSubcomponentFactory();
            }
        };
        this.checkInPrimaryInputFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeCheckInPrimaryInputFragment.CheckInPrimaryInputFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass29 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeCheckInPrimaryInputFragment.CheckInPrimaryInputFragmentSubcomponent.Factory get() {
                return new CheckInPrimaryInputFragmentSubcomponentFactory();
            }
        };
        this.checkInAddDependantInputFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeCheckInAddDependantInputFragment.CheckInAddDependantInputFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass30 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeCheckInAddDependantInputFragment.CheckInAddDependantInputFragmentSubcomponent.Factory get() {
                return new CheckInAddDependantInputFragmentSubcomponentFactory();
            }
        };
        this.checkInSummaryFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeCheckInSummaryFragment.CheckInSummaryFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass31 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeCheckInSummaryFragment.CheckInSummaryFragmentSubcomponent.Factory get() {
                return new CheckInSummaryFragmentSubcomponentFactory();
            }
        };
        this.checkInEditPersonInputFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeCheckInEditPersonInputFragment.CheckInEditPersonInputFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass32 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeCheckInEditPersonInputFragment.CheckInEditPersonInputFragmentSubcomponent.Factory get() {
                return new CheckInEditPersonInputFragmentSubcomponentFactory();
            }
        };
        this.checkInSubmittingFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeCheckInSubmittingFragment.CheckInSubmittingFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass33 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeCheckInSubmittingFragment.CheckInSubmittingFragmentSubcomponent.Factory get() {
                return new CheckInSubmittingFragmentSubcomponentFactory();
            }
        };
        this.checkInSuccessFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeCheckInSuccessFragment.CheckInSuccessFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass34 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeCheckInSuccessFragment.CheckInSuccessFragmentSubcomponent.Factory get() {
                return new CheckInSuccessFragmentSubcomponentFactory();
            }
        };
        this.checkInScannerFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeCheckInScannerFragment.CheckInScannerFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass35 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeCheckInScannerFragment.CheckInScannerFragmentSubcomponent.Factory get() {
                return new CheckInScannerFragmentSubcomponentFactory();
            }
        };
        this.checkInHistoryDetailFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeCheckInHistoryDetailFragment.CheckInHistoryDetailFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass36 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeCheckInHistoryDetailFragment.CheckInHistoryDetailFragmentSubcomponent.Factory get() {
                return new CheckInHistoryDetailFragmentSubcomponentFactory();
            }
        };
        this.checkInFeedbackFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeCheckInFeedbackFragment.CheckInFeedbackFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass37 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeCheckInFeedbackFragment.CheckInFeedbackFragmentSubcomponent.Factory get() {
                return new CheckInFeedbackFragmentSubcomponentFactory();
            }
        };
        this.checkInFeedbackSuccessFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeCheckInFeedbackSuccessFragment.CheckInFeedbackSuccessFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass38 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeCheckInFeedbackSuccessFragment.CheckInFeedbackSuccessFragmentSubcomponent.Factory get() {
                return new CheckInFeedbackSuccessFragmentSubcomponentFactory();
            }
        };
        this.checkInShortcutFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeCheckInShortcutFragment.CheckInShortcutFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass39 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeCheckInShortcutFragment.CheckInShortcutFragmentSubcomponent.Factory get() {
                return new CheckInShortcutFragmentSubcomponentFactory();
            }
        };
        this.homeServicesFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeHomeServicesFragment.HomeServicesFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass40 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeHomeServicesFragment.HomeServicesFragmentSubcomponent.Factory get() {
                return new HomeServicesFragmentSubcomponentFactory();
            }
        };
        this.serviceGroupCategoriesFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ServiceGroupCategoriesFragment.ServiceGroupCategoriesFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass41 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ServiceGroupCategoriesFragment.ServiceGroupCategoriesFragmentSubcomponent.Factory get() {
                return new ServiceGroupCategoriesFragmentSubcomponentFactory();
            }
        };
        this.serviceCategoryTransactionsFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ServiceCategoryTransactionsFragment.ServiceCategoryTransactionsFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass42 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ServiceCategoryTransactionsFragment.ServiceCategoryTransactionsFragmentSubcomponent.Factory get() {
                return new ServiceCategoryTransactionsFragmentSubcomponentFactory();
            }
        };
        this.createAccountFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeCreateAccountFragment.CreateAccountFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass43 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeCreateAccountFragment.CreateAccountFragmentSubcomponent.Factory get() {
                return new CreateAccountFragmentSubcomponentFactory();
            }
        };
        this.verifyEmailFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeVerifyEmailFragment.VerifyEmailFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass44 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeVerifyEmailFragment.VerifyEmailFragmentSubcomponent.Factory get() {
                return new VerifyEmailFragmentSubcomponentFactory();
            }
        };
        this.registerSuccessFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeRegisterSuccessFragment.RegisterSuccessFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass45 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeRegisterSuccessFragment.RegisterSuccessFragmentSubcomponent.Factory get() {
                return new RegisterSuccessFragmentSubcomponentFactory();
            }
        };
        this.moreCardsInfoFragmentSubcomponentFactoryProvider = new Provider<SupportFragmentModule_ContributeMoreCardsInfoFragment.MoreCardsInfoFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass46 */

            @Override // javax.inject.Provider
            public SupportFragmentModule_ContributeMoreCardsInfoFragment.MoreCardsInfoFragmentSubcomponent.Factory get() {
                return new MoreCardsInfoFragmentSubcomponentFactory();
            }
        };
        this.loginActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributeLoginActivity.LoginActivitySubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass47 */

            @Override // javax.inject.Provider
            public ActivityModule_ContributeLoginActivity.LoginActivitySubcomponent.Factory get() {
                return new LoginActivitySubcomponentFactory();
            }
        };
        this.splashActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributeSecondSplashActivity.SplashActivitySubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass48 */

            @Override // javax.inject.Provider
            public ActivityModule_ContributeSecondSplashActivity.SplashActivitySubcomponent.Factory get() {
                return new SplashActivitySubcomponentFactory();
            }
        };
        this.pinActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributePinActivity.PinActivitySubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass49 */

            @Override // javax.inject.Provider
            public ActivityModule_ContributePinActivity.PinActivitySubcomponent.Factory get() {
                return new PinActivitySubcomponentFactory();
            }
        };
        this.onboardingActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributeOnboardingActivity.OnboardingActivitySubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass50 */

            @Override // javax.inject.Provider
            public ActivityModule_ContributeOnboardingActivity.OnboardingActivitySubcomponent.Factory get() {
                return new OnboardingActivitySubcomponentFactory();
            }
        };
        this.setupActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributeSetupActivity.SetupActivitySubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass51 */

            @Override // javax.inject.Provider
            public ActivityModule_ContributeSetupActivity.SetupActivitySubcomponent.Factory get() {
                return new SetupActivitySubcomponentFactory();
            }
        };
        this.harvestActivitySubcomponentFactoryProvider = new Provider<ActivityModule_ContributeHarvestJobActivity.HarvestActivitySubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass52 */

            @Override // javax.inject.Provider
            public ActivityModule_ContributeHarvestJobActivity.HarvestActivitySubcomponent.Factory get() {
                return new HarvestActivitySubcomponentFactory();
            }
        };
        this.mainActivityServerSubcomponentFactoryProvider = new Provider<ActivityModuleServer_ContributeMainActivity.MainActivityServerSubcomponent.Factory>() {
            /* class com.digitalwallet.app.di.DaggerAppComponentServer.AnonymousClass53 */

            @Override // javax.inject.Provider
            public ActivityModuleServer_ContributeMainActivity.MainActivityServerSubcomponent.Factory get() {
                return new MainActivityServerSubcomponentFactory();
            }
        };
        this.okHttpClientProvider = new com_digitalwallet_di_BaseComponent_okHttpClient(baseComponent2);
        com_digitalwallet_di_BaseComponent_moshi com_digitalwallet_di_basecomponent_moshi = new com_digitalwallet_di_BaseComponent_moshi(baseComponent2);
        this.moshiProvider = com_digitalwallet_di_basecomponent_moshi;
        Provider<Converter.Factory> provider = DoubleCheck.provider(ApiModule_ProvideCustomConverterFactoryFactory.create(apiModule, com_digitalwallet_di_basecomponent_moshi));
        this.provideCustomConverterFactoryProvider = provider;
        Provider<ConfigApi> provider2 = DoubleCheck.provider(ApiModule_ProvideConfigApiFactory.create(apiModule, this.okHttpClientProvider, provider));
        this.provideConfigApiProvider = provider2;
        this.provideConfigurationDocumentProvider = DoubleCheck.provider(OIDCModule_ProvideConfigurationDocumentFactory.create(oIDCModule, provider2));
        com_digitalwallet_di_BaseComponent_context com_digitalwallet_di_basecomponent_context = new com_digitalwallet_di_BaseComponent_context(baseComponent2);
        this.contextProvider = com_digitalwallet_di_basecomponent_context;
        this.provideAuthenticationUtilityProvider = DoubleCheck.provider(OIDCModule_ProvideAuthenticationUtilityFactory.create(oIDCModule, com_digitalwallet_di_basecomponent_context, this.moshiProvider));
        Provider<AuthApi> provider3 = DoubleCheck.provider(ApiModule_ProvideAuthApiFactory.create(apiModule, this.okHttpClientProvider, this.moshiProvider));
        this.provideAuthApiProvider = provider3;
        this.provideAuthenticationEndpointsProvider = DoubleCheck.provider(OIDCModule_ProvideAuthenticationEndpointsFactory.create(oIDCModule, this.provideConfigurationDocumentProvider, this.provideAuthenticationUtilityProvider, this.moshiProvider, provider3));
        com_digitalwallet_di_BaseComponent_analytics com_digitalwallet_di_basecomponent_analytics = new com_digitalwallet_di_BaseComponent_analytics(baseComponent2);
        this.analyticsProvider = com_digitalwallet_di_basecomponent_analytics;
        this.loginActivityViewModelProvider = LoginActivityViewModel_Factory.create(this.provideAuthenticationEndpointsProvider, this.moshiProvider, com_digitalwallet_di_basecomponent_analytics, this.contextProvider);
        this.httpCacheProvider = new com_digitalwallet_di_BaseComponent_httpCache(baseComponent2);
        Provider<OIDCRequestHandler> provider4 = DoubleCheck.provider(OIDCModule_ProvideOIDCRequestHandlerFactory.create(oIDCModule, this.provideAuthenticationEndpointsProvider, this.provideAuthenticationUtilityProvider, this.provideConfigurationDocumentProvider));
        this.provideOIDCRequestHandlerProvider = provider4;
        Provider<OkHttpClient> provider5 = DoubleCheck.provider(ApiModule_ProvideApiHttpFactory.create(apiModule, this.httpCacheProvider, provider4));
        this.provideApiHttpProvider = provider5;
        this.provideHoldingsApiProvider = DoubleCheck.provider(ApiModule_ProvideHoldingsApiFactory.create(apiModule, provider5, this.moshiProvider));
        this.holdingParserProvider = DoubleCheck.provider(HoldingParser_Factory.create(this.moshiProvider));
        this.digitalWalletApplicationProvider = new com_digitalwallet_di_BaseComponent_digitalWalletApplication(baseComponent2);
        Provider<DigitalWalletDatabase> provider6 = DoubleCheck.provider(DatabaseModule_ProvideDigitalWalletDatabaseFactory.create(databaseModule, this.contextProvider));
        this.provideDigitalWalletDatabaseProvider = provider6;
        Provider<JWTIssuerKeysDao> provider7 = DoubleCheck.provider(DatabaseModule_ProvideJWTIssuerKeysDaoFactory.create(databaseModule, provider6));
        this.provideJWTIssuerKeysDaoProvider = provider7;
        this.jWTIssuerKeysServiceProvider = JWTIssuerKeysService_Factory.create(provider7);
        Provider<ScanDao> provider8 = DoubleCheck.provider(DatabaseModule_ProvideScanDaoFactory.create(databaseModule, this.provideDigitalWalletDatabaseProvider));
        this.provideScanDaoProvider = provider8;
        this.scannerDataServiceProvider = ScannerDataService_Factory.create(this.moshiProvider, this.provideHoldingsApiProvider, provider8);
        Provider<HarvestModel> provider9 = DoubleCheck.provider(DatabaseModule_ProvideHarvestModelFactory.create(databaseModule, this.provideDigitalWalletDatabaseProvider));
        this.provideHarvestModelProvider = provider9;
        this.harvestDataServiceProvider = HarvestDataService_Factory.create(this.provideHoldingsApiProvider, provider9, this.contextProvider);
        com_digitalwallet_di_BaseComponent_checkInRepository com_digitalwallet_di_basecomponent_checkinrepository = new com_digitalwallet_di_BaseComponent_checkInRepository(baseComponent2);
        this.checkInRepositoryProvider = com_digitalwallet_di_basecomponent_checkinrepository;
        Provider<AppStartUp> provider10 = DoubleCheck.provider(AppModule_ProvideAppStartUpFactory.create(appModuleServer, this.digitalWalletApplicationProvider, this.jWTIssuerKeysServiceProvider, this.scannerDataServiceProvider, this.harvestDataServiceProvider, this.provideAuthenticationUtilityProvider, this.analyticsProvider, com_digitalwallet_di_basecomponent_checkinrepository));
        this.provideAppStartUpProvider = provider10;
        this.holdingsApiServiceProvider = DoubleCheck.provider(HoldingsApiService_Factory.create(this.provideConfigurationDocumentProvider, this.provideHoldingsApiProvider, this.holdingParserProvider, provider10));
        this.digitalWalletSecuredStoreProvider = DigitalWalletSecuredStore_Factory.create(this.provideDigitalWalletDatabaseProvider);
        Provider<UnsecuredStore> provider11 = DoubleCheck.provider(DatabaseModule_ProvideUnSecureHoldingStoreFactory.create(databaseModule, this.provideDigitalWalletDatabaseProvider));
        this.provideUnSecureHoldingStoreProvider = provider11;
        this.holdingsDbServiceProvider = HoldingsDbService_Factory.create(this.digitalWalletSecuredStoreProvider, provider11);
        Provider<AssetApi> provider12 = DoubleCheck.provider(ApiModule_ProvideAssetApiFactory.create(apiModule, this.provideApiHttpProvider, this.moshiProvider));
        this.provideAssetApiProvider = provider12;
        Provider<AssetService> provider13 = DoubleCheck.provider(ApiModule_ProvideAssetServiceFactory.create(apiModule, this.contextProvider, provider12));
        this.provideAssetServiceProvider = provider13;
        this.holdingsServiceProvider = DoubleCheck.provider(HoldingsService_Factory.create(this.contextProvider, this.holdingsApiServiceProvider, this.holdingsDbServiceProvider, this.provideAuthenticationUtilityProvider, provider13, this.moshiProvider, this.analyticsProvider));
        com_digitalwallet_di_BaseComponent_remoteConfigService com_digitalwallet_di_basecomponent_remoteconfigservice = new com_digitalwallet_di_BaseComponent_remoteConfigService(baseComponent2);
        this.remoteConfigServiceProvider = com_digitalwallet_di_basecomponent_remoteconfigservice;
        this.mainActivityViewModelProvider = MainActivityViewModel_Factory.create(this.holdingsServiceProvider, com_digitalwallet_di_basecomponent_remoteconfigservice);
        this.splashViewModelProvider = SplashViewModel_Factory.create(this.provideAuthenticationUtilityProvider, this.provideAuthenticationEndpointsProvider, this.holdingsServiceProvider, this.provideDigitalWalletDatabaseProvider, this.analyticsProvider);
        Provider<HandshakeService> provider14 = DoubleCheck.provider(HandshakeService_Factory.create());
        this.handshakeServiceProvider = provider14;
        this.pinActivityViewModelProvider = PinActivityViewModel_Factory.create(this.provideAuthenticationUtilityProvider, this.analyticsProvider, this.holdingsServiceProvider, this.provideDigitalWalletDatabaseProvider, provider14);
        this.fingerprintDialogFragmentViewModelProvider = FingerprintDialogFragmentViewModel_Factory.create(this.analyticsProvider);
        this.mainPagerFragmentViewModelProvider = MainPagerFragmentViewModel_Factory.create(this.provideAuthenticationUtilityProvider, this.holdingsServiceProvider, this.provideDigitalWalletDatabaseProvider, this.handshakeServiceProvider);
        Provider<ShareRecordStore> provider15 = DoubleCheck.provider(DatabaseModule_ProvideShareRecordStoreFactory.create(databaseModule, this.provideDigitalWalletDatabaseProvider));
        this.provideShareRecordStoreProvider = provider15;
        TransactionSharesService_Factory create = TransactionSharesService_Factory.create(this.provideHoldingsApiProvider, provider15);
        this.transactionSharesServiceProvider = create;
        this.transactionHistoryFragmentViewModelProvider = TransactionHistoryFragmentViewModel_Factory.create(this.analyticsProvider, create);
        this.accountDetailsFragmentViewModelProvider = AccountDetailsFragmentViewModel_Factory.create(this.contextProvider, this.transactionSharesServiceProvider, this.analyticsProvider, this.provideAuthenticationUtilityProvider);
        Provider<BluetoothEventsService> provider16 = DoubleCheck.provider(ApiModule_ProvideBluetoothEventsServiceFactory.create(apiModule));
        this.provideBluetoothEventsServiceProvider = provider16;
        this.holdingListFragmentViewModelProvider = HoldingListFragmentViewModel_Factory.create(this.contextProvider, this.holdingsServiceProvider, provider16);
        this.holdingDetailFragmentViewModelProvider = HoldingDetailFragmentViewModel_Factory.create(this.analyticsProvider);
    }

    private void initialize2(AppModuleServer appModuleServer, OIDCModule oIDCModule, DatabaseModule databaseModule, ApiModule apiModule, BaseComponent baseComponent2) {
        com_digitalwallet_di_BaseComponent_application com_digitalwallet_di_basecomponent_application = new com_digitalwallet_di_BaseComponent_application(baseComponent2);
        this.applicationProvider = com_digitalwallet_di_basecomponent_application;
        Provider<BLEUtil> provider = DoubleCheck.provider(ApiModule_ProvideBLEUtilFactory.create(apiModule, com_digitalwallet_di_basecomponent_application, this.provideBluetoothEventsServiceProvider));
        this.provideBLEUtilProvider = provider;
        Provider<BLEClient> provider2 = DoubleCheck.provider(BLEClient_Factory.create(this.applicationProvider, provider, this.analyticsProvider, this.holdingsServiceProvider, this.handshakeServiceProvider));
        this.bLEClientProvider = provider2;
        this.lobbyFragmentViewModelProvider = LobbyFragmentViewModel_Factory.create(this.analyticsProvider, this.holdingsServiceProvider, this.holdingParserProvider, this.provideAssetServiceProvider, this.transactionSharesServiceProvider, this.provideAppStartUpProvider, provider2);
        this.cardSyncViewModelProvider = CardSyncViewModel_Factory.create(this.holdingsServiceProvider, this.moshiProvider, this.provideAssetServiceProvider, this.provideAuthenticationEndpointsProvider);
        this.incomingRequestFragmentViewModelProvider = IncomingRequestFragmentViewModel_Factory.create(this.analyticsProvider, this.holdingsServiceProvider, this.transactionSharesServiceProvider);
        this.cardAddViewModelProvider = CardAddViewModel_Factory.create(this.analyticsProvider);
        this.sharingHistoryFragmentViewModelProvider = SharingHistoryFragmentViewModel_Factory.create(this.transactionSharesServiceProvider);
        com_digitalwallet_di_BaseComponent_scannerViewService com_digitalwallet_di_basecomponent_scannerviewservice = new com_digitalwallet_di_BaseComponent_scannerViewService(baseComponent2);
        this.scannerViewServiceProvider = com_digitalwallet_di_basecomponent_scannerviewservice;
        this.eligibilityScannerFragmentViewModelProvider = EligibilityScannerFragmentViewModel_Factory.create(com_digitalwallet_di_basecomponent_scannerviewservice, this.scannerDataServiceProvider);
        this.nicknameViewModelProvider = NicknameViewModel_Factory.create(this.provideAuthenticationUtilityProvider);
        this.autoSyncViewModelProvider = AutoSyncViewModel_Factory.create(this.provideAuthenticationUtilityProvider);
        this.harvestJobWizardViewModelProvider = HarvestJobWizardViewModel_Factory.create(this.provideHarvestModelProvider);
        this.harvestTagViewModelProvider = HarvestTagViewModel_Factory.create(this.provideHarvestModelProvider, this.scannerViewServiceProvider, this.harvestDataServiceProvider);
        this.checkInOverviewViewModelProvider = CheckInOverviewViewModel_Factory.create(this.contextProvider, this.checkInRepositoryProvider);
        this.checkInPrimaryInputViewModelProvider = CheckInPrimaryInputViewModel_Factory.create(this.checkInRepositoryProvider, this.analyticsProvider);
        this.checkInAddDependantInputViewModelProvider = CheckInAddDependantInputViewModel_Factory.create(this.checkInRepositoryProvider);
        this.checkInSummaryViewModelProvider = CheckInSummaryViewModel_Factory.create(this.contextProvider, this.checkInRepositoryProvider, this.analyticsProvider);
        this.checkInEditPersonInputViewModelProvider = CheckInEditPersonInputViewModel_Factory.create(this.checkInRepositoryProvider);
        this.checkInSubmittingViewModelProvider = CheckInSubmittingViewModel_Factory.create(this.checkInRepositoryProvider);
        this.checkInSuccessViewModelProvider = CheckInSuccessViewModel_Factory.create(this.contextProvider, this.checkInRepositoryProvider, this.analyticsProvider);
        this.checkInFeedbackViewModelProvider = CheckInFeedbackViewModel_Factory.create(this.contextProvider, this.checkInRepositoryProvider, this.analyticsProvider);
        this.checkInFeedbackSuccessViewModelProvider = CheckInFeedbackSuccessViewModel_Factory.create(this.contextProvider, this.checkInRepositoryProvider);
        this.checkInScannerViewModelProvider = CheckInScannerViewModel_Factory.create(this.scannerViewServiceProvider, this.moshiProvider, this.okHttpClientProvider, this.contextProvider, this.analyticsProvider);
        this.checkInHistoryDetailViewModelProvider = CheckInHistoryDetailViewModel_Factory.create(this.contextProvider, this.checkInRepositoryProvider);
        this.checkInShortcutViewModelProvider = CheckInShortcutViewModel_Factory.create(this.contextProvider, this.checkInRepositoryProvider);
        Provider<SimpleAssetService> provider3 = DoubleCheck.provider(ApiModule_ProvideSimpleAssetServiceFactory.create(apiModule, this.contextProvider, this.provideAssetApiProvider, this.moshiProvider));
        this.provideSimpleAssetServiceProvider = provider3;
        this.homeServicesViewModelProvider = HomeServicesViewModel_Factory.create(this.moshiProvider, this.contextProvider, provider3, this.checkInRepositoryProvider);
        this.serviceCategoryTransactionsViewModelProvider = ServiceCategoryTransactionsViewModel_Factory.create(this.contextProvider);
        this.provideUserApiProvider = DoubleCheck.provider(ApiModule_ProvideUserApiFactory.create(apiModule, this.okHttpClientProvider, this.moshiProvider));
        Provider<DeviceRegisterApi> provider4 = DoubleCheck.provider(ApiModule_ProvideDeviceRegisterApiFactory.create(apiModule, this.provideApiHttpProvider, this.moshiProvider));
        this.provideDeviceRegisterApiProvider = provider4;
        RemoteSubscriptionService_Factory create = RemoteSubscriptionService_Factory.create(this.contextProvider, provider4, this.provideAuthenticationUtilityProvider);
        this.remoteSubscriptionServiceProvider = create;
        this.createAccountViewModelProvider = CreateAccountViewModel_Factory.create(this.contextProvider, this.provideUserApiProvider, create, this.moshiProvider, this.analyticsProvider);
        this.verifyEmailViewModelProvider = VerifyEmailViewModel_Factory.create(this.contextProvider, this.provideUserApiProvider, this.provideAuthenticationEndpointsProvider, this.moshiProvider, this.analyticsProvider);
        this.registerSuccessViewModelProvider = RegisterSuccessViewModel_Factory.create(this.analyticsProvider);
        this.moreCardsInfoViewModelProvider = MoreCardsInfoViewModel_Factory.create(this.contextProvider);
        this.bLEServerProvider = DoubleCheck.provider(BLEServer_Factory.create(this.applicationProvider, this.provideBLEUtilProvider, this.provideAuthenticationUtilityProvider, this.handshakeServiceProvider, this.holdingsServiceProvider));
    }

    @Override // com.digitalwallet.app.di.AppComponent
    public void inject(SetupActivity setupActivity) {
        injectSetupActivity(setupActivity);
    }

    @Override // com.digitalwallet.app.di.AppComponent
    public void inject(OnboardingActivity onboardingActivity) {
        injectOnboardingActivity(onboardingActivity);
    }

    @Override // com.digitalwallet.app.di.AppComponent
    public void inject(HarvestActivity harvestActivity) {
        injectHarvestActivity(harvestActivity);
    }

    @Override // com.digitalwallet.app.di.AppComponent
    public void inject(LoginActivity loginActivity) {
        injectLoginActivity(loginActivity);
    }

    @Override // com.digitalwallet.app.di.AppComponent
    public void inject(MainActivity mainActivity) {
        injectMainActivity(mainActivity);
    }

    @Override // com.digitalwallet.app.di.AppComponent
    public void inject(MainActivityServer mainActivityServer) {
        injectMainActivityServer(mainActivityServer);
    }

    @Override // com.digitalwallet.app.di.AppComponent
    public void inject(PinActivity pinActivity) {
        injectPinActivity(pinActivity);
    }

    @Override // com.digitalwallet.app.di.AppComponent
    public void inject(SplashActivity splashActivity) {
        injectSplashActivity(splashActivity);
    }

    private SetupActivity injectSetupActivity(SetupActivity setupActivity) {
        AppDaggerAppCompatActivity_MembersInjector.injectAndroidInjector(setupActivity, getDispatchingAndroidInjectorOfObject());
        AppDaggerAppCompatActivity_MembersInjector.injectViewModelFactory(setupActivity, getViewModelFactory());
        SetupActivity_MembersInjector.injectAuthUtility(setupActivity, this.provideAuthenticationUtilityProvider.get());
        return setupActivity;
    }

    private OnboardingActivity injectOnboardingActivity(OnboardingActivity onboardingActivity) {
        AppDaggerAppCompatActivity_MembersInjector.injectAndroidInjector(onboardingActivity, getDispatchingAndroidInjectorOfObject());
        AppDaggerAppCompatActivity_MembersInjector.injectViewModelFactory(onboardingActivity, getViewModelFactory());
        OnboardingActivity_MembersInjector.injectAuthenticationUtility(onboardingActivity, this.provideAuthenticationUtilityProvider.get());
        OnboardingActivity_MembersInjector.injectRemoteConfigService(onboardingActivity, (RemoteConfigService) Preconditions.checkNotNull(this.baseComponent.remoteConfigService(), "Cannot return null from a non-@Nullable component method"));
        OnboardingActivity_MembersInjector.injectAnalytics(onboardingActivity, (AnalyticsHelper) Preconditions.checkNotNull(this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method"));
        return onboardingActivity;
    }

    private HarvestActivity injectHarvestActivity(HarvestActivity harvestActivity) {
        BaseActivity_MembersInjector.injectAndroidInjector(harvestActivity, getDispatchingAndroidInjectorOfObject());
        BaseActivity_MembersInjector.injectViewModelFactory(harvestActivity, getViewModelFactory());
        BaseAppActivity_MembersInjector.injectAppStartUp(harvestActivity, this.provideAppStartUpProvider.get());
        HarvestActivity_MembersInjector.injectViewModel(harvestActivity, getHarvestJobWizardViewModel());
        HarvestActivity_MembersInjector.injectTagViewModel(harvestActivity, getHarvestTagViewModel());
        return harvestActivity;
    }

    private LoginActivity injectLoginActivity(LoginActivity loginActivity) {
        BaseActivity_MembersInjector.injectAndroidInjector(loginActivity, getDispatchingAndroidInjectorOfObject());
        BaseActivity_MembersInjector.injectViewModelFactory(loginActivity, getViewModelFactory());
        BaseAppActivity_MembersInjector.injectAppStartUp(loginActivity, this.provideAppStartUpProvider.get());
        LoginActivity_MembersInjector.injectViewModel(loginActivity, getLoginActivityViewModel());
        LoginActivity_MembersInjector.injectRemoteConfigService(loginActivity, (RemoteConfigService) Preconditions.checkNotNull(this.baseComponent.remoteConfigService(), "Cannot return null from a non-@Nullable component method"));
        LoginActivity_MembersInjector.injectRemoteSubscriptionService(loginActivity, getRemoteSubscriptionService());
        return loginActivity;
    }

    private MainActivity injectMainActivity(MainActivity mainActivity) {
        BaseActivity_MembersInjector.injectAndroidInjector(mainActivity, getDispatchingAndroidInjectorOfObject());
        BaseActivity_MembersInjector.injectViewModelFactory(mainActivity, getViewModelFactory());
        BaseAppActivity_MembersInjector.injectAppStartUp(mainActivity, this.provideAppStartUpProvider.get());
        MainActivity_MembersInjector.injectViewModel(mainActivity, getMainActivityViewModel());
        MainActivity_MembersInjector.injectHoldingParser(mainActivity, this.holdingParserProvider.get());
        MainActivity_MembersInjector.injectHoldingsService(mainActivity, this.holdingsServiceProvider.get());
        MainActivity_MembersInjector.injectAuthenticationUtility(mainActivity, this.provideAuthenticationUtilityProvider.get());
        MainActivity_MembersInjector.injectBluetoothEvents(mainActivity, this.provideBluetoothEventsServiceProvider.get());
        MainActivity_MembersInjector.injectRemoteSubscriptionService(mainActivity, getRemoteSubscriptionService());
        return mainActivity;
    }

    private MainActivityServer injectMainActivityServer(MainActivityServer mainActivityServer) {
        BaseActivity_MembersInjector.injectAndroidInjector(mainActivityServer, getDispatchingAndroidInjectorOfObject());
        BaseActivity_MembersInjector.injectViewModelFactory(mainActivityServer, getViewModelFactory());
        BaseAppActivity_MembersInjector.injectAppStartUp(mainActivityServer, this.provideAppStartUpProvider.get());
        MainActivity_MembersInjector.injectViewModel(mainActivityServer, getMainActivityViewModel());
        MainActivity_MembersInjector.injectHoldingParser(mainActivityServer, this.holdingParserProvider.get());
        MainActivity_MembersInjector.injectHoldingsService(mainActivityServer, this.holdingsServiceProvider.get());
        MainActivity_MembersInjector.injectAuthenticationUtility(mainActivityServer, this.provideAuthenticationUtilityProvider.get());
        MainActivity_MembersInjector.injectBluetoothEvents(mainActivityServer, this.provideBluetoothEventsServiceProvider.get());
        MainActivity_MembersInjector.injectRemoteSubscriptionService(mainActivityServer, getRemoteSubscriptionService());
        MainActivityServer_MembersInjector.injectBleServer(mainActivityServer, this.bLEServerProvider.get());
        return mainActivityServer;
    }

    private PinActivity injectPinActivity(PinActivity pinActivity) {
        BaseActivity_MembersInjector.injectAndroidInjector(pinActivity, getDispatchingAndroidInjectorOfObject());
        BaseActivity_MembersInjector.injectViewModelFactory(pinActivity, getViewModelFactory());
        BaseAppActivity_MembersInjector.injectAppStartUp(pinActivity, this.provideAppStartUpProvider.get());
        PinActivity_MembersInjector.injectViewModel(pinActivity, getPinActivityViewModel());
        return pinActivity;
    }

    private SplashActivity injectSplashActivity(SplashActivity splashActivity) {
        BaseActivity_MembersInjector.injectAndroidInjector(splashActivity, getDispatchingAndroidInjectorOfObject());
        BaseActivity_MembersInjector.injectViewModelFactory(splashActivity, getViewModelFactory());
        BaseAppActivity_MembersInjector.injectAppStartUp(splashActivity, this.provideAppStartUpProvider.get());
        SplashActivity_MembersInjector.injectViewModel(splashActivity, getSplashViewModel());
        return splashActivity;
    }

    private TransactionHistoryFragmentViewModel injectTransactionHistoryFragmentViewModel(TransactionHistoryFragmentViewModel transactionHistoryFragmentViewModel) {
        TransactionHistoryFragmentViewModel_MembersInjector.injectTransactionSharesService(transactionHistoryFragmentViewModel, getTransactionSharesService());
        return transactionHistoryFragmentViewModel;
    }

    private AccountDetailsFragmentViewModel injectAccountDetailsFragmentViewModel(AccountDetailsFragmentViewModel accountDetailsFragmentViewModel) {
        AccountDetailsFragmentViewModel_MembersInjector.injectAuthUtility(accountDetailsFragmentViewModel, this.provideAuthenticationUtilityProvider.get());
        return accountDetailsFragmentViewModel;
    }

    private IncomingRequestFragmentViewModel injectIncomingRequestFragmentViewModel(IncomingRequestFragmentViewModel incomingRequestFragmentViewModel) {
        IncomingRequestFragmentViewModel_MembersInjector.injectHoldingsService(incomingRequestFragmentViewModel, this.holdingsServiceProvider.get());
        IncomingRequestFragmentViewModel_MembersInjector.injectTransactionHistoryService(incomingRequestFragmentViewModel, getTransactionSharesService());
        return incomingRequestFragmentViewModel;
    }

    private SharingHistoryFragmentViewModel injectSharingHistoryFragmentViewModel(SharingHistoryFragmentViewModel sharingHistoryFragmentViewModel) {
        SharingHistoryFragmentViewModel_MembersInjector.injectSharesService(sharingHistoryFragmentViewModel, getTransactionSharesService());
        return sharingHistoryFragmentViewModel;
    }

    /* access modifiers changed from: private */
    public static final class Factory implements AppComponentServer.Factory {
        private Factory() {
        }

        @Override // com.digitalwallet.app.di.AppComponentServer.Factory
        public AppComponentServer create(BaseComponent baseComponent) {
            Preconditions.checkNotNull(baseComponent);
            return new DaggerAppComponentServer(new AppModuleServer(), new OIDCModule(), new DatabaseModule(), new ApiModule(), baseComponent);
        }
    }

    /* access modifiers changed from: private */
    public static class com_digitalwallet_di_BaseComponent_okHttpClient implements Provider<OkHttpClient> {
        private final BaseComponent baseComponent;

        com_digitalwallet_di_BaseComponent_okHttpClient(BaseComponent baseComponent2) {
            this.baseComponent = baseComponent2;
        }

        @Override // javax.inject.Provider
        public OkHttpClient get() {
            return (OkHttpClient) Preconditions.checkNotNull(this.baseComponent.okHttpClient(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* access modifiers changed from: private */
    public static class com_digitalwallet_di_BaseComponent_moshi implements Provider<Moshi> {
        private final BaseComponent baseComponent;

        com_digitalwallet_di_BaseComponent_moshi(BaseComponent baseComponent2) {
            this.baseComponent = baseComponent2;
        }

        @Override // javax.inject.Provider
        public Moshi get() {
            return (Moshi) Preconditions.checkNotNull(this.baseComponent.moshi(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* access modifiers changed from: private */
    public static class com_digitalwallet_di_BaseComponent_context implements Provider<Context> {
        private final BaseComponent baseComponent;

        com_digitalwallet_di_BaseComponent_context(BaseComponent baseComponent2) {
            this.baseComponent = baseComponent2;
        }

        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNull(this.baseComponent.context(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* access modifiers changed from: private */
    public static class com_digitalwallet_di_BaseComponent_analytics implements Provider<AnalyticsHelper> {
        private final BaseComponent baseComponent;

        com_digitalwallet_di_BaseComponent_analytics(BaseComponent baseComponent2) {
            this.baseComponent = baseComponent2;
        }

        @Override // javax.inject.Provider
        public AnalyticsHelper get() {
            return (AnalyticsHelper) Preconditions.checkNotNull(this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* access modifiers changed from: private */
    public static class com_digitalwallet_di_BaseComponent_httpCache implements Provider<Cache> {
        private final BaseComponent baseComponent;

        com_digitalwallet_di_BaseComponent_httpCache(BaseComponent baseComponent2) {
            this.baseComponent = baseComponent2;
        }

        @Override // javax.inject.Provider
        public Cache get() {
            return (Cache) Preconditions.checkNotNull(this.baseComponent.httpCache(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* access modifiers changed from: private */
    public static class com_digitalwallet_di_BaseComponent_digitalWalletApplication implements Provider<DigitalWalletApplication> {
        private final BaseComponent baseComponent;

        com_digitalwallet_di_BaseComponent_digitalWalletApplication(BaseComponent baseComponent2) {
            this.baseComponent = baseComponent2;
        }

        @Override // javax.inject.Provider
        public DigitalWalletApplication get() {
            return (DigitalWalletApplication) Preconditions.checkNotNull(this.baseComponent.digitalWalletApplication(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* access modifiers changed from: private */
    public static class com_digitalwallet_di_BaseComponent_checkInRepository implements Provider<CheckInRepository> {
        private final BaseComponent baseComponent;

        com_digitalwallet_di_BaseComponent_checkInRepository(BaseComponent baseComponent2) {
            this.baseComponent = baseComponent2;
        }

        @Override // javax.inject.Provider
        public CheckInRepository get() {
            return (CheckInRepository) Preconditions.checkNotNull(this.baseComponent.checkInRepository(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* access modifiers changed from: private */
    public static class com_digitalwallet_di_BaseComponent_remoteConfigService implements Provider<RemoteConfigService> {
        private final BaseComponent baseComponent;

        com_digitalwallet_di_BaseComponent_remoteConfigService(BaseComponent baseComponent2) {
            this.baseComponent = baseComponent2;
        }

        @Override // javax.inject.Provider
        public RemoteConfigService get() {
            return (RemoteConfigService) Preconditions.checkNotNull(this.baseComponent.remoteConfigService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* access modifiers changed from: private */
    public static class com_digitalwallet_di_BaseComponent_application implements Provider<Application> {
        private final BaseComponent baseComponent;

        com_digitalwallet_di_BaseComponent_application(BaseComponent baseComponent2) {
            this.baseComponent = baseComponent2;
        }

        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNull(this.baseComponent.application(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* access modifiers changed from: private */
    public static class com_digitalwallet_di_BaseComponent_scannerViewService implements Provider<ScannerViewService> {
        private final BaseComponent baseComponent;

        com_digitalwallet_di_BaseComponent_scannerViewService(BaseComponent baseComponent2) {
            this.baseComponent = baseComponent2;
        }

        @Override // javax.inject.Provider
        public ScannerViewService get() {
            return (ScannerViewService) Preconditions.checkNotNull(this.baseComponent.scannerViewService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* access modifiers changed from: private */
    public final class FingerprintDialogFragmentSubcomponentFactory implements SupportFragmentModule_ContributeFingerprintDialogFragment.FingerprintDialogFragmentSubcomponent.Factory {
        private FingerprintDialogFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeFingerprintDialogFragment.FingerprintDialogFragmentSubcomponent create(FingerprintDialogFragment fingerprintDialogFragment) {
            Preconditions.checkNotNull(fingerprintDialogFragment);
            return new FingerprintDialogFragmentSubcomponentImpl(fingerprintDialogFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class FingerprintDialogFragmentSubcomponentImpl implements SupportFragmentModule_ContributeFingerprintDialogFragment.FingerprintDialogFragmentSubcomponent {
        private FingerprintDialogFragmentSubcomponentImpl(FingerprintDialogFragment fingerprintDialogFragment) {
        }

        public void inject(FingerprintDialogFragment fingerprintDialogFragment) {
            injectFingerprintDialogFragment(fingerprintDialogFragment);
        }

        private FingerprintDialogFragment injectFingerprintDialogFragment(FingerprintDialogFragment fingerprintDialogFragment) {
            FingerprintDialogFragment_MembersInjector.injectViewModel(fingerprintDialogFragment, DaggerAppComponentServer.this.getFingerprintDialogFragmentViewModel());
            return fingerprintDialogFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class MainPagerFragmentSubcomponentFactory implements SupportFragmentModule_ContributeMainPagerFragment.MainPagerFragmentSubcomponent.Factory {
        private MainPagerFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeMainPagerFragment.MainPagerFragmentSubcomponent create(MainPagerFragment mainPagerFragment) {
            Preconditions.checkNotNull(mainPagerFragment);
            return new MainPagerFragmentSubcomponentImpl(mainPagerFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class MainPagerFragmentSubcomponentImpl implements SupportFragmentModule_ContributeMainPagerFragment.MainPagerFragmentSubcomponent {
        private MainPagerFragmentSubcomponentImpl(MainPagerFragment mainPagerFragment) {
        }

        public void inject(MainPagerFragment mainPagerFragment) {
            injectMainPagerFragment(mainPagerFragment);
        }

        private MainPagerFragment injectMainPagerFragment(MainPagerFragment mainPagerFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(mainPagerFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(mainPagerFragment, DaggerAppComponentServer.this.getViewModelFactory());
            MainPagerFragment_MembersInjector.injectViewModel(mainPagerFragment, DaggerAppComponentServer.this.getMainPagerFragmentViewModel());
            return mainPagerFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class ServiceTypeFragmentSubcomponentFactory implements SupportFragmentModule_ContributeServiceTypeFragment.ServiceTypeFragmentSubcomponent.Factory {
        private ServiceTypeFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeServiceTypeFragment.ServiceTypeFragmentSubcomponent create(ServiceTypeFragment serviceTypeFragment) {
            Preconditions.checkNotNull(serviceTypeFragment);
            return new ServiceTypeFragmentSubcomponentImpl(serviceTypeFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class ServiceTypeFragmentSubcomponentImpl implements SupportFragmentModule_ContributeServiceTypeFragment.ServiceTypeFragmentSubcomponent {
        private ServiceTypeFragmentSubcomponentImpl(ServiceTypeFragment serviceTypeFragment) {
        }

        public void inject(ServiceTypeFragment serviceTypeFragment) {
            injectServiceTypeFragment(serviceTypeFragment);
        }

        private ServiceTypeFragment injectServiceTypeFragment(ServiceTypeFragment serviceTypeFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(serviceTypeFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            return serviceTypeFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class ServiceDetailFragmentSubcomponentFactory implements SupportFragmentModule_ContributeServiceDetailFragment.ServiceDetailFragmentSubcomponent.Factory {
        private ServiceDetailFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeServiceDetailFragment.ServiceDetailFragmentSubcomponent create(ServiceDetailFragment serviceDetailFragment) {
            Preconditions.checkNotNull(serviceDetailFragment);
            return new ServiceDetailFragmentSubcomponentImpl(serviceDetailFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class ServiceDetailFragmentSubcomponentImpl implements SupportFragmentModule_ContributeServiceDetailFragment.ServiceDetailFragmentSubcomponent {
        private ServiceDetailFragmentSubcomponentImpl(ServiceDetailFragment serviceDetailFragment) {
        }

        public void inject(ServiceDetailFragment serviceDetailFragment) {
            injectServiceDetailFragment(serviceDetailFragment);
        }

        private ServiceDetailFragment injectServiceDetailFragment(ServiceDetailFragment serviceDetailFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(serviceDetailFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(serviceDetailFragment, DaggerAppComponentServer.this.getViewModelFactory());
            ServiceDetailFragment_MembersInjector.injectViewModel(serviceDetailFragment, new ServiceDetailFragmentViewModel());
            return serviceDetailFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class TransactionHistoryFragmentSubcomponentFactory implements SupportFragmentModule_ContributeTransactionHistoryFragment.TransactionHistoryFragmentSubcomponent.Factory {
        private TransactionHistoryFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeTransactionHistoryFragment.TransactionHistoryFragmentSubcomponent create(TransactionHistoryFragment transactionHistoryFragment) {
            Preconditions.checkNotNull(transactionHistoryFragment);
            return new TransactionHistoryFragmentSubcomponentImpl(transactionHistoryFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class TransactionHistoryFragmentSubcomponentImpl implements SupportFragmentModule_ContributeTransactionHistoryFragment.TransactionHistoryFragmentSubcomponent {
        private TransactionHistoryFragmentSubcomponentImpl(TransactionHistoryFragment transactionHistoryFragment) {
        }

        public void inject(TransactionHistoryFragment transactionHistoryFragment) {
            injectTransactionHistoryFragment(transactionHistoryFragment);
        }

        private TransactionHistoryFragment injectTransactionHistoryFragment(TransactionHistoryFragment transactionHistoryFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(transactionHistoryFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(transactionHistoryFragment, DaggerAppComponentServer.this.getViewModelFactory());
            TransactionHistoryFragment_MembersInjector.injectViewModel(transactionHistoryFragment, DaggerAppComponentServer.this.getTransactionHistoryFragmentViewModel());
            return transactionHistoryFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class AccountSettingsFragmentSubcomponentFactory implements SupportFragmentModule_ContributeAccountSettingsFragment.AccountSettingsFragmentSubcomponent.Factory {
        private AccountSettingsFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeAccountSettingsFragment.AccountSettingsFragmentSubcomponent create(AccountSettingsFragment accountSettingsFragment) {
            Preconditions.checkNotNull(accountSettingsFragment);
            return new AccountSettingsFragmentSubcomponentImpl(accountSettingsFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class AccountSettingsFragmentSubcomponentImpl implements SupportFragmentModule_ContributeAccountSettingsFragment.AccountSettingsFragmentSubcomponent {
        private AccountSettingsFragmentSubcomponentImpl(AccountSettingsFragment accountSettingsFragment) {
        }

        public void inject(AccountSettingsFragment accountSettingsFragment) {
            injectAccountSettingsFragment(accountSettingsFragment);
        }

        private AccountSettingsFragment injectAccountSettingsFragment(AccountSettingsFragment accountSettingsFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(accountSettingsFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(accountSettingsFragment, DaggerAppComponentServer.this.getViewModelFactory());
            AccountSettingsFragment_MembersInjector.injectViewModel(accountSettingsFragment, new AccountSettingsFragmentViewModel());
            AccountSettingsFragment_MembersInjector.injectAuthenticationUtility(accountSettingsFragment, (AuthenticationUtility) DaggerAppComponentServer.this.provideAuthenticationUtilityProvider.get());
            return accountSettingsFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class AccountDetailsFragmentSubcomponentFactory implements SupportFragmentModule_ContributeAccountDetailsFragment.AccountDetailsFragmentSubcomponent.Factory {
        private AccountDetailsFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeAccountDetailsFragment.AccountDetailsFragmentSubcomponent create(AccountDetailsFragment accountDetailsFragment) {
            Preconditions.checkNotNull(accountDetailsFragment);
            return new AccountDetailsFragmentSubcomponentImpl(accountDetailsFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class AccountDetailsFragmentSubcomponentImpl implements SupportFragmentModule_ContributeAccountDetailsFragment.AccountDetailsFragmentSubcomponent {
        private AccountDetailsFragmentSubcomponentImpl(AccountDetailsFragment accountDetailsFragment) {
        }

        public void inject(AccountDetailsFragment accountDetailsFragment) {
            injectAccountDetailsFragment(accountDetailsFragment);
        }

        private AccountDetailsFragment injectAccountDetailsFragment(AccountDetailsFragment accountDetailsFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(accountDetailsFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(accountDetailsFragment, DaggerAppComponentServer.this.getViewModelFactory());
            AccountDetailsFragment_MembersInjector.injectViewModel(accountDetailsFragment, DaggerAppComponentServer.this.getAccountDetailsFragmentViewModel());
            return accountDetailsFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class HoldingListFragmentSubcomponentFactory implements SupportFragmentModule_ContributeHoldingListFragment.HoldingListFragmentSubcomponent.Factory {
        private HoldingListFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeHoldingListFragment.HoldingListFragmentSubcomponent create(HoldingListFragment holdingListFragment) {
            Preconditions.checkNotNull(holdingListFragment);
            return new HoldingListFragmentSubcomponentImpl(holdingListFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class HoldingListFragmentSubcomponentImpl implements SupportFragmentModule_ContributeHoldingListFragment.HoldingListFragmentSubcomponent {
        private HoldingListFragmentSubcomponentImpl(HoldingListFragment holdingListFragment) {
        }

        public void inject(HoldingListFragment holdingListFragment) {
            injectHoldingListFragment(holdingListFragment);
        }

        private HoldingListFragment injectHoldingListFragment(HoldingListFragment holdingListFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(holdingListFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(holdingListFragment, DaggerAppComponentServer.this.getViewModelFactory());
            HoldingListFragment_MembersInjector.injectViewModel(holdingListFragment, DaggerAppComponentServer.this.getHoldingListFragmentViewModel());
            HoldingListFragment_MembersInjector.injectAssetService(holdingListFragment, (AssetService) DaggerAppComponentServer.this.provideAssetServiceProvider.get());
            HoldingListFragment_MembersInjector.injectHoldingParser(holdingListFragment, (HoldingParser) DaggerAppComponentServer.this.holdingParserProvider.get());
            HoldingListFragment_MembersInjector.injectAppStartUp(holdingListFragment, (AppStartUp) DaggerAppComponentServer.this.provideAppStartUpProvider.get());
            return holdingListFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class HoldingDetailFragmentSubcomponentFactory implements SupportFragmentModule_ContributeHoldingDetailFragment.HoldingDetailFragmentSubcomponent.Factory {
        private HoldingDetailFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeHoldingDetailFragment.HoldingDetailFragmentSubcomponent create(HoldingDetailFragment holdingDetailFragment) {
            Preconditions.checkNotNull(holdingDetailFragment);
            return new HoldingDetailFragmentSubcomponentImpl(holdingDetailFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class HoldingDetailFragmentSubcomponentImpl implements SupportFragmentModule_ContributeHoldingDetailFragment.HoldingDetailFragmentSubcomponent {
        private HoldingDetailFragmentSubcomponentImpl(HoldingDetailFragment holdingDetailFragment) {
        }

        public void inject(HoldingDetailFragment holdingDetailFragment) {
            injectHoldingDetailFragment(holdingDetailFragment);
        }

        private HoldingDetailFragment injectHoldingDetailFragment(HoldingDetailFragment holdingDetailFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(holdingDetailFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(holdingDetailFragment, DaggerAppComponentServer.this.getViewModelFactory());
            HoldingDetailFragment_MembersInjector.injectViewModel(holdingDetailFragment, DaggerAppComponentServer.this.getHoldingDetailFragmentViewModel());
            HoldingDetailFragment_MembersInjector.injectAssetService(holdingDetailFragment, (AssetService) DaggerAppComponentServer.this.provideAssetServiceProvider.get());
            return holdingDetailFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class HoldingDisclaimerFragmentSubcomponentFactory implements SupportFragmentModule_ContributeHoldingDisclaimerFragment.HoldingDisclaimerFragmentSubcomponent.Factory {
        private HoldingDisclaimerFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeHoldingDisclaimerFragment.HoldingDisclaimerFragmentSubcomponent create(HoldingDisclaimerFragment holdingDisclaimerFragment) {
            Preconditions.checkNotNull(holdingDisclaimerFragment);
            return new HoldingDisclaimerFragmentSubcomponentImpl(holdingDisclaimerFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class HoldingDisclaimerFragmentSubcomponentImpl implements SupportFragmentModule_ContributeHoldingDisclaimerFragment.HoldingDisclaimerFragmentSubcomponent {
        private HoldingDisclaimerFragmentSubcomponentImpl(HoldingDisclaimerFragment holdingDisclaimerFragment) {
        }

        public void inject(HoldingDisclaimerFragment holdingDisclaimerFragment) {
            injectHoldingDisclaimerFragment(holdingDisclaimerFragment);
        }

        private HoldingDisclaimerFragment injectHoldingDisclaimerFragment(HoldingDisclaimerFragment holdingDisclaimerFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(holdingDisclaimerFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            return holdingDisclaimerFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class LobbyFragmentSubcomponentFactory implements SupportFragmentModule_ContributeLobbyFragment.LobbyFragmentSubcomponent.Factory {
        private LobbyFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeLobbyFragment.LobbyFragmentSubcomponent create(LobbyFragment lobbyFragment) {
            Preconditions.checkNotNull(lobbyFragment);
            return new LobbyFragmentSubcomponentImpl(lobbyFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class LobbyFragmentSubcomponentImpl implements SupportFragmentModule_ContributeLobbyFragment.LobbyFragmentSubcomponent {
        private LobbyFragmentSubcomponentImpl(LobbyFragment lobbyFragment) {
        }

        public void inject(LobbyFragment lobbyFragment) {
            injectLobbyFragment(lobbyFragment);
        }

        private LobbyFragment injectLobbyFragment(LobbyFragment lobbyFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(lobbyFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(lobbyFragment, DaggerAppComponentServer.this.getViewModelFactory());
            LobbyFragment_MembersInjector.injectViewModel(lobbyFragment, DaggerAppComponentServer.this.getLobbyFragmentViewModel());
            LobbyFragment_MembersInjector.injectHoldingParser(lobbyFragment, (HoldingParser) DaggerAppComponentServer.this.holdingParserProvider.get());
            LobbyFragment_MembersInjector.injectHoldingsService(lobbyFragment, (HoldingsService) DaggerAppComponentServer.this.holdingsServiceProvider.get());
            LobbyFragment_MembersInjector.injectBleClient(lobbyFragment, (BLEClient) DaggerAppComponentServer.this.bLEClientProvider.get());
            return lobbyFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CardSyncFragmentSubcomponentFactory implements SupportFragmentModule_ContributeCardSyncFragment.CardSyncFragmentSubcomponent.Factory {
        private CardSyncFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeCardSyncFragment.CardSyncFragmentSubcomponent create(CardSyncFragment cardSyncFragment) {
            Preconditions.checkNotNull(cardSyncFragment);
            return new CardSyncFragmentSubcomponentImpl(cardSyncFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CardSyncFragmentSubcomponentImpl implements SupportFragmentModule_ContributeCardSyncFragment.CardSyncFragmentSubcomponent {
        private CardSyncFragmentSubcomponentImpl(CardSyncFragment cardSyncFragment) {
        }

        public void inject(CardSyncFragment cardSyncFragment) {
            injectCardSyncFragment(cardSyncFragment);
        }

        private CardSyncFragment injectCardSyncFragment(CardSyncFragment cardSyncFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(cardSyncFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(cardSyncFragment, DaggerAppComponentServer.this.getViewModelFactory());
            CardSyncFragment_MembersInjector.injectViewModel(cardSyncFragment, DaggerAppComponentServer.this.getCardSyncViewModel());
            return cardSyncFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class IncomingRequestFragmentSubcomponentFactory implements SupportFragmentModule_ContributeIncomingRequestFragment.IncomingRequestFragmentSubcomponent.Factory {
        private IncomingRequestFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeIncomingRequestFragment.IncomingRequestFragmentSubcomponent create(IncomingRequestFragment incomingRequestFragment) {
            Preconditions.checkNotNull(incomingRequestFragment);
            return new IncomingRequestFragmentSubcomponentImpl(incomingRequestFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class IncomingRequestFragmentSubcomponentImpl implements SupportFragmentModule_ContributeIncomingRequestFragment.IncomingRequestFragmentSubcomponent {
        private IncomingRequestFragmentSubcomponentImpl(IncomingRequestFragment incomingRequestFragment) {
        }

        public void inject(IncomingRequestFragment incomingRequestFragment) {
            injectIncomingRequestFragment(incomingRequestFragment);
        }

        private IncomingRequestFragment injectIncomingRequestFragment(IncomingRequestFragment incomingRequestFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(incomingRequestFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(incomingRequestFragment, DaggerAppComponentServer.this.getViewModelFactory());
            IncomingRequestFragment_MembersInjector.injectViewModel(incomingRequestFragment, DaggerAppComponentServer.this.getIncomingRequestFragmentViewModel());
            IncomingRequestFragment_MembersInjector.injectBleServer(incomingRequestFragment, (BLEServer) DaggerAppComponentServer.this.bLEServerProvider.get());
            IncomingRequestFragment_MembersInjector.injectAssetService(incomingRequestFragment, (AssetService) DaggerAppComponentServer.this.provideAssetServiceProvider.get());
            return incomingRequestFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CardAddFragmentSubcomponentFactory implements SupportFragmentModule_ContributeCardAddFragment.CardAddFragmentSubcomponent.Factory {
        private CardAddFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeCardAddFragment.CardAddFragmentSubcomponent create(CardAddFragment cardAddFragment) {
            Preconditions.checkNotNull(cardAddFragment);
            return new CardAddFragmentSubcomponentImpl(cardAddFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CardAddFragmentSubcomponentImpl implements SupportFragmentModule_ContributeCardAddFragment.CardAddFragmentSubcomponent {
        private CardAddFragmentSubcomponentImpl(CardAddFragment cardAddFragment) {
        }

        public void inject(CardAddFragment cardAddFragment) {
            injectCardAddFragment(cardAddFragment);
        }

        private CardAddFragment injectCardAddFragment(CardAddFragment cardAddFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(cardAddFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(cardAddFragment, DaggerAppComponentServer.this.getViewModelFactory());
            CardAddFragment_MembersInjector.injectViewModel(cardAddFragment, DaggerAppComponentServer.this.getCardAddViewModel());
            return cardAddFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class SharingHistoryFragmentSubcomponentFactory implements SupportFragmentModule_ContributeSharingHistoryFragment.SharingHistoryFragmentSubcomponent.Factory {
        private SharingHistoryFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeSharingHistoryFragment.SharingHistoryFragmentSubcomponent create(SharingHistoryFragment sharingHistoryFragment) {
            Preconditions.checkNotNull(sharingHistoryFragment);
            return new SharingHistoryFragmentSubcomponentImpl(sharingHistoryFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class SharingHistoryFragmentSubcomponentImpl implements SupportFragmentModule_ContributeSharingHistoryFragment.SharingHistoryFragmentSubcomponent {
        private SharingHistoryFragmentSubcomponentImpl(SharingHistoryFragment sharingHistoryFragment) {
        }

        public void inject(SharingHistoryFragment sharingHistoryFragment) {
            injectSharingHistoryFragment(sharingHistoryFragment);
        }

        private SharingHistoryFragment injectSharingHistoryFragment(SharingHistoryFragment sharingHistoryFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(sharingHistoryFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(sharingHistoryFragment, DaggerAppComponentServer.this.getViewModelFactory());
            SharingHistoryFragment_MembersInjector.injectViewModel(sharingHistoryFragment, DaggerAppComponentServer.this.getSharingHistoryFragmentViewModel());
            return sharingHistoryFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class SharingDetailsFragmentSubcomponentFactory implements SupportFragmentModule_ContributeSharingDetailsFragment.SharingDetailsFragmentSubcomponent.Factory {
        private SharingDetailsFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeSharingDetailsFragment.SharingDetailsFragmentSubcomponent create(SharingDetailsFragment sharingDetailsFragment) {
            Preconditions.checkNotNull(sharingDetailsFragment);
            return new SharingDetailsFragmentSubcomponentImpl(sharingDetailsFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class SharingDetailsFragmentSubcomponentImpl implements SupportFragmentModule_ContributeSharingDetailsFragment.SharingDetailsFragmentSubcomponent {
        private SharingDetailsFragmentSubcomponentImpl(SharingDetailsFragment sharingDetailsFragment) {
        }

        public void inject(SharingDetailsFragment sharingDetailsFragment) {
            injectSharingDetailsFragment(sharingDetailsFragment);
        }

        private SharingDetailsFragment injectSharingDetailsFragment(SharingDetailsFragment sharingDetailsFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(sharingDetailsFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            return sharingDetailsFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class EligibilityScannerFragmentSubcomponentFactory implements SupportFragmentModule_ContributesEligibilityScannerFragment.EligibilityScannerFragmentSubcomponent.Factory {
        private EligibilityScannerFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributesEligibilityScannerFragment.EligibilityScannerFragmentSubcomponent create(EligibilityScannerFragment eligibilityScannerFragment) {
            Preconditions.checkNotNull(eligibilityScannerFragment);
            return new EligibilityScannerFragmentSubcomponentImpl(eligibilityScannerFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class EligibilityScannerFragmentSubcomponentImpl implements SupportFragmentModule_ContributesEligibilityScannerFragment.EligibilityScannerFragmentSubcomponent {
        private EligibilityScannerFragmentSubcomponentImpl(EligibilityScannerFragment eligibilityScannerFragment) {
        }

        public void inject(EligibilityScannerFragment eligibilityScannerFragment) {
            injectEligibilityScannerFragment(eligibilityScannerFragment);
        }

        private EligibilityScannerFragment injectEligibilityScannerFragment(EligibilityScannerFragment eligibilityScannerFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(eligibilityScannerFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(eligibilityScannerFragment, DaggerAppComponentServer.this.getViewModelFactory());
            EligibilityScannerFragment_MembersInjector.injectViewModel(eligibilityScannerFragment, DaggerAppComponentServer.this.getEligibilityScannerFragmentViewModel());
            return eligibilityScannerFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class NicknameCreateFragmentSubcomponentFactory implements SupportFragmentModule_NicknameCreateFragment.NicknameCreateFragmentSubcomponent.Factory {
        private NicknameCreateFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_NicknameCreateFragment.NicknameCreateFragmentSubcomponent create(NicknameCreateFragment nicknameCreateFragment) {
            Preconditions.checkNotNull(nicknameCreateFragment);
            return new NicknameCreateFragmentSubcomponentImpl(nicknameCreateFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class NicknameCreateFragmentSubcomponentImpl implements SupportFragmentModule_NicknameCreateFragment.NicknameCreateFragmentSubcomponent {
        private NicknameCreateFragmentSubcomponentImpl(NicknameCreateFragment nicknameCreateFragment) {
        }

        public void inject(NicknameCreateFragment nicknameCreateFragment) {
            injectNicknameCreateFragment(nicknameCreateFragment);
        }

        private NicknameCreateFragment injectNicknameCreateFragment(NicknameCreateFragment nicknameCreateFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(nicknameCreateFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(nicknameCreateFragment, DaggerAppComponentServer.this.getViewModelFactory());
            NicknameCreateFragment_MembersInjector.injectViewModel(nicknameCreateFragment, DaggerAppComponentServer.this.getNicknameViewModel());
            return nicknameCreateFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class NicknameEditFragmentSubcomponentFactory implements SupportFragmentModule_NicknameEditFragment.NicknameEditFragmentSubcomponent.Factory {
        private NicknameEditFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_NicknameEditFragment.NicknameEditFragmentSubcomponent create(NicknameEditFragment nicknameEditFragment) {
            Preconditions.checkNotNull(nicknameEditFragment);
            return new NicknameEditFragmentSubcomponentImpl(nicknameEditFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class NicknameEditFragmentSubcomponentImpl implements SupportFragmentModule_NicknameEditFragment.NicknameEditFragmentSubcomponent {
        private NicknameEditFragmentSubcomponentImpl(NicknameEditFragment nicknameEditFragment) {
        }

        public void inject(NicknameEditFragment nicknameEditFragment) {
            injectNicknameEditFragment(nicknameEditFragment);
        }

        private NicknameEditFragment injectNicknameEditFragment(NicknameEditFragment nicknameEditFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(nicknameEditFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(nicknameEditFragment, DaggerAppComponentServer.this.getViewModelFactory());
            NicknameEditFragment_MembersInjector.injectViewModel(nicknameEditFragment, DaggerAppComponentServer.this.getNicknameViewModel());
            return nicknameEditFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class AutoSyncFragmentSubcomponentFactory implements SupportFragmentModule_AutoSyncFragment.AutoSyncFragmentSubcomponent.Factory {
        private AutoSyncFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_AutoSyncFragment.AutoSyncFragmentSubcomponent create(AutoSyncFragment autoSyncFragment) {
            Preconditions.checkNotNull(autoSyncFragment);
            return new AutoSyncFragmentSubcomponentImpl(autoSyncFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class AutoSyncFragmentSubcomponentImpl implements SupportFragmentModule_AutoSyncFragment.AutoSyncFragmentSubcomponent {
        private AutoSyncFragmentSubcomponentImpl(AutoSyncFragment autoSyncFragment) {
        }

        public void inject(AutoSyncFragment autoSyncFragment) {
            injectAutoSyncFragment(autoSyncFragment);
        }

        private AutoSyncFragment injectAutoSyncFragment(AutoSyncFragment autoSyncFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(autoSyncFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(autoSyncFragment, DaggerAppComponentServer.this.getViewModelFactory());
            AutoSyncFragment_MembersInjector.injectViewModel(autoSyncFragment, DaggerAppComponentServer.this.getAutoSyncViewModel());
            return autoSyncFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class HarvestJobListFragmentSubcomponentFactory implements SupportFragmentModule_HarvestJobListFragment.HarvestJobListFragmentSubcomponent.Factory {
        private HarvestJobListFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_HarvestJobListFragment.HarvestJobListFragmentSubcomponent create(HarvestJobListFragment harvestJobListFragment) {
            Preconditions.checkNotNull(harvestJobListFragment);
            return new HarvestJobListFragmentSubcomponentImpl(harvestJobListFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class HarvestJobListFragmentSubcomponentImpl implements SupportFragmentModule_HarvestJobListFragment.HarvestJobListFragmentSubcomponent {
        private HarvestJobListFragmentSubcomponentImpl(HarvestJobListFragment harvestJobListFragment) {
        }

        public void inject(HarvestJobListFragment harvestJobListFragment) {
            injectHarvestJobListFragment(harvestJobListFragment);
        }

        private HarvestJobListFragment injectHarvestJobListFragment(HarvestJobListFragment harvestJobListFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(harvestJobListFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(harvestJobListFragment, DaggerAppComponentServer.this.getViewModelFactory());
            return harvestJobListFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class HarvestJobWizardConsentFragmentSubcomponentFactory implements SupportFragmentModule_HarvestJobWizardConsentFragment.HarvestJobWizardConsentFragmentSubcomponent.Factory {
        private HarvestJobWizardConsentFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_HarvestJobWizardConsentFragment.HarvestJobWizardConsentFragmentSubcomponent create(HarvestJobWizardConsentFragment harvestJobWizardConsentFragment) {
            Preconditions.checkNotNull(harvestJobWizardConsentFragment);
            return new HarvestJobWizardConsentFragmentSubcomponentImpl(harvestJobWizardConsentFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class HarvestJobWizardConsentFragmentSubcomponentImpl implements SupportFragmentModule_HarvestJobWizardConsentFragment.HarvestJobWizardConsentFragmentSubcomponent {
        private HarvestJobWizardConsentFragmentSubcomponentImpl(HarvestJobWizardConsentFragment harvestJobWizardConsentFragment) {
        }

        public void inject(HarvestJobWizardConsentFragment harvestJobWizardConsentFragment) {
            injectHarvestJobWizardConsentFragment(harvestJobWizardConsentFragment);
        }

        private HarvestJobWizardConsentFragment injectHarvestJobWizardConsentFragment(HarvestJobWizardConsentFragment harvestJobWizardConsentFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(harvestJobWizardConsentFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(harvestJobWizardConsentFragment, DaggerAppComponentServer.this.getViewModelFactory());
            return harvestJobWizardConsentFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class HarvestJobWizardAddressFragmentSubcomponentFactory implements SupportFragmentModule_HarvestJobWizardAddressFragment.HarvestJobWizardAddressFragmentSubcomponent.Factory {
        private HarvestJobWizardAddressFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_HarvestJobWizardAddressFragment.HarvestJobWizardAddressFragmentSubcomponent create(HarvestJobWizardAddressFragment harvestJobWizardAddressFragment) {
            Preconditions.checkNotNull(harvestJobWizardAddressFragment);
            return new HarvestJobWizardAddressFragmentSubcomponentImpl(harvestJobWizardAddressFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class HarvestJobWizardAddressFragmentSubcomponentImpl implements SupportFragmentModule_HarvestJobWizardAddressFragment.HarvestJobWizardAddressFragmentSubcomponent {
        private HarvestJobWizardAddressFragmentSubcomponentImpl(HarvestJobWizardAddressFragment harvestJobWizardAddressFragment) {
        }

        public void inject(HarvestJobWizardAddressFragment harvestJobWizardAddressFragment) {
            injectHarvestJobWizardAddressFragment(harvestJobWizardAddressFragment);
        }

        private HarvestJobWizardAddressFragment injectHarvestJobWizardAddressFragment(HarvestJobWizardAddressFragment harvestJobWizardAddressFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(harvestJobWizardAddressFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(harvestJobWizardAddressFragment, DaggerAppComponentServer.this.getViewModelFactory());
            return harvestJobWizardAddressFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class HarvestJobWizardZoneFragmentSubcomponentFactory implements SupportFragmentModule_HarvestJobWizardZoneFragment.HarvestJobWizardZoneFragmentSubcomponent.Factory {
        private HarvestJobWizardZoneFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_HarvestJobWizardZoneFragment.HarvestJobWizardZoneFragmentSubcomponent create(HarvestJobWizardZoneFragment harvestJobWizardZoneFragment) {
            Preconditions.checkNotNull(harvestJobWizardZoneFragment);
            return new HarvestJobWizardZoneFragmentSubcomponentImpl(harvestJobWizardZoneFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class HarvestJobWizardZoneFragmentSubcomponentImpl implements SupportFragmentModule_HarvestJobWizardZoneFragment.HarvestJobWizardZoneFragmentSubcomponent {
        private HarvestJobWizardZoneFragmentSubcomponentImpl(HarvestJobWizardZoneFragment harvestJobWizardZoneFragment) {
        }

        public void inject(HarvestJobWizardZoneFragment harvestJobWizardZoneFragment) {
            injectHarvestJobWizardZoneFragment(harvestJobWizardZoneFragment);
        }

        private HarvestJobWizardZoneFragment injectHarvestJobWizardZoneFragment(HarvestJobWizardZoneFragment harvestJobWizardZoneFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(harvestJobWizardZoneFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(harvestJobWizardZoneFragment, DaggerAppComponentServer.this.getViewModelFactory());
            return harvestJobWizardZoneFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class HarvestScannerFragmentSubcomponentFactory implements SupportFragmentModule_HarvestScannerFragment.HarvestScannerFragmentSubcomponent.Factory {
        private HarvestScannerFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_HarvestScannerFragment.HarvestScannerFragmentSubcomponent create(HarvestScannerFragment harvestScannerFragment) {
            Preconditions.checkNotNull(harvestScannerFragment);
            return new HarvestScannerFragmentSubcomponentImpl(harvestScannerFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class HarvestScannerFragmentSubcomponentImpl implements SupportFragmentModule_HarvestScannerFragment.HarvestScannerFragmentSubcomponent {
        private HarvestScannerFragmentSubcomponentImpl(HarvestScannerFragment harvestScannerFragment) {
        }

        public void inject(HarvestScannerFragment harvestScannerFragment) {
            injectHarvestScannerFragment(harvestScannerFragment);
        }

        private HarvestScannerFragment injectHarvestScannerFragment(HarvestScannerFragment harvestScannerFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(harvestScannerFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(harvestScannerFragment, DaggerAppComponentServer.this.getViewModelFactory());
            return harvestScannerFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class HarvestTagManualEntryFragmentSubcomponentFactory implements SupportFragmentModule_HarvestTagManualEntryFragment.HarvestTagManualEntryFragmentSubcomponent.Factory {
        private HarvestTagManualEntryFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_HarvestTagManualEntryFragment.HarvestTagManualEntryFragmentSubcomponent create(HarvestTagManualEntryFragment harvestTagManualEntryFragment) {
            Preconditions.checkNotNull(harvestTagManualEntryFragment);
            return new HarvestTagManualEntryFragmentSubcomponentImpl(harvestTagManualEntryFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class HarvestTagManualEntryFragmentSubcomponentImpl implements SupportFragmentModule_HarvestTagManualEntryFragment.HarvestTagManualEntryFragmentSubcomponent {
        private HarvestTagManualEntryFragmentSubcomponentImpl(HarvestTagManualEntryFragment harvestTagManualEntryFragment) {
        }

        public void inject(HarvestTagManualEntryFragment harvestTagManualEntryFragment) {
            injectHarvestTagManualEntryFragment(harvestTagManualEntryFragment);
        }

        private HarvestTagManualEntryFragment injectHarvestTagManualEntryFragment(HarvestTagManualEntryFragment harvestTagManualEntryFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(harvestTagManualEntryFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(harvestTagManualEntryFragment, DaggerAppComponentServer.this.getViewModelFactory());
            return harvestTagManualEntryFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class HarvestTagSummaryFragmentSubcomponentFactory implements SupportFragmentModule_HarvestTagSummaryFragment.HarvestTagSummaryFragmentSubcomponent.Factory {
        private HarvestTagSummaryFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_HarvestTagSummaryFragment.HarvestTagSummaryFragmentSubcomponent create(HarvestTagSummaryFragment harvestTagSummaryFragment) {
            Preconditions.checkNotNull(harvestTagSummaryFragment);
            return new HarvestTagSummaryFragmentSubcomponentImpl(harvestTagSummaryFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class HarvestTagSummaryFragmentSubcomponentImpl implements SupportFragmentModule_HarvestTagSummaryFragment.HarvestTagSummaryFragmentSubcomponent {
        private HarvestTagSummaryFragmentSubcomponentImpl(HarvestTagSummaryFragment harvestTagSummaryFragment) {
        }

        public void inject(HarvestTagSummaryFragment harvestTagSummaryFragment) {
            injectHarvestTagSummaryFragment(harvestTagSummaryFragment);
        }

        private HarvestTagSummaryFragment injectHarvestTagSummaryFragment(HarvestTagSummaryFragment harvestTagSummaryFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(harvestTagSummaryFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(harvestTagSummaryFragment, DaggerAppComponentServer.this.getViewModelFactory());
            return harvestTagSummaryFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInOverviewFragmentSubcomponentFactory implements SupportFragmentModule_ContributeCheckInOverviewFragment.CheckInOverviewFragmentSubcomponent.Factory {
        private CheckInOverviewFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeCheckInOverviewFragment.CheckInOverviewFragmentSubcomponent create(CheckInOverviewFragment checkInOverviewFragment) {
            Preconditions.checkNotNull(checkInOverviewFragment);
            return new CheckInOverviewFragmentSubcomponentImpl(checkInOverviewFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInOverviewFragmentSubcomponentImpl implements SupportFragmentModule_ContributeCheckInOverviewFragment.CheckInOverviewFragmentSubcomponent {
        private CheckInOverviewFragmentSubcomponentImpl(CheckInOverviewFragment checkInOverviewFragment) {
        }

        public void inject(CheckInOverviewFragment checkInOverviewFragment) {
            injectCheckInOverviewFragment(checkInOverviewFragment);
        }

        private CheckInOverviewFragment injectCheckInOverviewFragment(CheckInOverviewFragment checkInOverviewFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInOverviewFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInOverviewFragment, DaggerAppComponentServer.this.getViewModelFactory());
            CheckInOverviewFragment_MembersInjector.injectViewModel(checkInOverviewFragment, DaggerAppComponentServer.this.getCheckInOverviewViewModel());
            return checkInOverviewFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInPrimaryInputFragmentSubcomponentFactory implements SupportFragmentModule_ContributeCheckInPrimaryInputFragment.CheckInPrimaryInputFragmentSubcomponent.Factory {
        private CheckInPrimaryInputFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeCheckInPrimaryInputFragment.CheckInPrimaryInputFragmentSubcomponent create(CheckInPrimaryInputFragment checkInPrimaryInputFragment) {
            Preconditions.checkNotNull(checkInPrimaryInputFragment);
            return new CheckInPrimaryInputFragmentSubcomponentImpl(checkInPrimaryInputFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInPrimaryInputFragmentSubcomponentImpl implements SupportFragmentModule_ContributeCheckInPrimaryInputFragment.CheckInPrimaryInputFragmentSubcomponent {
        private CheckInPrimaryInputFragmentSubcomponentImpl(CheckInPrimaryInputFragment checkInPrimaryInputFragment) {
        }

        public void inject(CheckInPrimaryInputFragment checkInPrimaryInputFragment) {
            injectCheckInPrimaryInputFragment(checkInPrimaryInputFragment);
        }

        private CheckInPrimaryInputFragment injectCheckInPrimaryInputFragment(CheckInPrimaryInputFragment checkInPrimaryInputFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInPrimaryInputFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInPrimaryInputFragment, DaggerAppComponentServer.this.getViewModelFactory());
            CheckInPrimaryInputFragment_MembersInjector.injectViewModel(checkInPrimaryInputFragment, DaggerAppComponentServer.this.getCheckInPrimaryInputViewModel());
            return checkInPrimaryInputFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInAddDependantInputFragmentSubcomponentFactory implements SupportFragmentModule_ContributeCheckInAddDependantInputFragment.CheckInAddDependantInputFragmentSubcomponent.Factory {
        private CheckInAddDependantInputFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeCheckInAddDependantInputFragment.CheckInAddDependantInputFragmentSubcomponent create(CheckInAddDependantInputFragment checkInAddDependantInputFragment) {
            Preconditions.checkNotNull(checkInAddDependantInputFragment);
            return new CheckInAddDependantInputFragmentSubcomponentImpl(checkInAddDependantInputFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInAddDependantInputFragmentSubcomponentImpl implements SupportFragmentModule_ContributeCheckInAddDependantInputFragment.CheckInAddDependantInputFragmentSubcomponent {
        private CheckInAddDependantInputFragmentSubcomponentImpl(CheckInAddDependantInputFragment checkInAddDependantInputFragment) {
        }

        public void inject(CheckInAddDependantInputFragment checkInAddDependantInputFragment) {
            injectCheckInAddDependantInputFragment(checkInAddDependantInputFragment);
        }

        private CheckInAddDependantInputFragment injectCheckInAddDependantInputFragment(CheckInAddDependantInputFragment checkInAddDependantInputFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInAddDependantInputFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInAddDependantInputFragment, DaggerAppComponentServer.this.getViewModelFactory());
            CheckInAddDependantInputFragment_MembersInjector.injectViewModel(checkInAddDependantInputFragment, DaggerAppComponentServer.this.getCheckInAddDependantInputViewModel());
            return checkInAddDependantInputFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInSummaryFragmentSubcomponentFactory implements SupportFragmentModule_ContributeCheckInSummaryFragment.CheckInSummaryFragmentSubcomponent.Factory {
        private CheckInSummaryFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeCheckInSummaryFragment.CheckInSummaryFragmentSubcomponent create(CheckInSummaryFragment checkInSummaryFragment) {
            Preconditions.checkNotNull(checkInSummaryFragment);
            return new CheckInSummaryFragmentSubcomponentImpl(checkInSummaryFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInSummaryFragmentSubcomponentImpl implements SupportFragmentModule_ContributeCheckInSummaryFragment.CheckInSummaryFragmentSubcomponent {
        private CheckInSummaryFragmentSubcomponentImpl(CheckInSummaryFragment checkInSummaryFragment) {
        }

        public void inject(CheckInSummaryFragment checkInSummaryFragment) {
            injectCheckInSummaryFragment(checkInSummaryFragment);
        }

        private CheckInSummaryFragment injectCheckInSummaryFragment(CheckInSummaryFragment checkInSummaryFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInSummaryFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInSummaryFragment, DaggerAppComponentServer.this.getViewModelFactory());
            CheckInSummaryFragment_MembersInjector.injectViewModel(checkInSummaryFragment, DaggerAppComponentServer.this.getCheckInSummaryViewModel());
            return checkInSummaryFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInEditPersonInputFragmentSubcomponentFactory implements SupportFragmentModule_ContributeCheckInEditPersonInputFragment.CheckInEditPersonInputFragmentSubcomponent.Factory {
        private CheckInEditPersonInputFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeCheckInEditPersonInputFragment.CheckInEditPersonInputFragmentSubcomponent create(CheckInEditPersonInputFragment checkInEditPersonInputFragment) {
            Preconditions.checkNotNull(checkInEditPersonInputFragment);
            return new CheckInEditPersonInputFragmentSubcomponentImpl(checkInEditPersonInputFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInEditPersonInputFragmentSubcomponentImpl implements SupportFragmentModule_ContributeCheckInEditPersonInputFragment.CheckInEditPersonInputFragmentSubcomponent {
        private CheckInEditPersonInputFragmentSubcomponentImpl(CheckInEditPersonInputFragment checkInEditPersonInputFragment) {
        }

        public void inject(CheckInEditPersonInputFragment checkInEditPersonInputFragment) {
            injectCheckInEditPersonInputFragment(checkInEditPersonInputFragment);
        }

        private CheckInEditPersonInputFragment injectCheckInEditPersonInputFragment(CheckInEditPersonInputFragment checkInEditPersonInputFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInEditPersonInputFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInEditPersonInputFragment, DaggerAppComponentServer.this.getViewModelFactory());
            CheckInEditPersonInputFragment_MembersInjector.injectViewModel(checkInEditPersonInputFragment, DaggerAppComponentServer.this.getCheckInEditPersonInputViewModel());
            return checkInEditPersonInputFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInSubmittingFragmentSubcomponentFactory implements SupportFragmentModule_ContributeCheckInSubmittingFragment.CheckInSubmittingFragmentSubcomponent.Factory {
        private CheckInSubmittingFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeCheckInSubmittingFragment.CheckInSubmittingFragmentSubcomponent create(CheckInSubmittingFragment checkInSubmittingFragment) {
            Preconditions.checkNotNull(checkInSubmittingFragment);
            return new CheckInSubmittingFragmentSubcomponentImpl(checkInSubmittingFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInSubmittingFragmentSubcomponentImpl implements SupportFragmentModule_ContributeCheckInSubmittingFragment.CheckInSubmittingFragmentSubcomponent {
        private CheckInSubmittingFragmentSubcomponentImpl(CheckInSubmittingFragment checkInSubmittingFragment) {
        }

        public void inject(CheckInSubmittingFragment checkInSubmittingFragment) {
            injectCheckInSubmittingFragment(checkInSubmittingFragment);
        }

        private CheckInSubmittingFragment injectCheckInSubmittingFragment(CheckInSubmittingFragment checkInSubmittingFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInSubmittingFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInSubmittingFragment, DaggerAppComponentServer.this.getViewModelFactory());
            CheckInSubmittingFragment_MembersInjector.injectViewModel(checkInSubmittingFragment, DaggerAppComponentServer.this.getCheckInSubmittingViewModel());
            return checkInSubmittingFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInSuccessFragmentSubcomponentFactory implements SupportFragmentModule_ContributeCheckInSuccessFragment.CheckInSuccessFragmentSubcomponent.Factory {
        private CheckInSuccessFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeCheckInSuccessFragment.CheckInSuccessFragmentSubcomponent create(CheckInSuccessFragment checkInSuccessFragment) {
            Preconditions.checkNotNull(checkInSuccessFragment);
            return new CheckInSuccessFragmentSubcomponentImpl(checkInSuccessFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInSuccessFragmentSubcomponentImpl implements SupportFragmentModule_ContributeCheckInSuccessFragment.CheckInSuccessFragmentSubcomponent {
        private CheckInSuccessFragmentSubcomponentImpl(CheckInSuccessFragment checkInSuccessFragment) {
        }

        public void inject(CheckInSuccessFragment checkInSuccessFragment) {
            injectCheckInSuccessFragment(checkInSuccessFragment);
        }

        private CheckInSuccessFragment injectCheckInSuccessFragment(CheckInSuccessFragment checkInSuccessFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInSuccessFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInSuccessFragment, DaggerAppComponentServer.this.getViewModelFactory());
            CheckInSuccessFragment_MembersInjector.injectViewModel(checkInSuccessFragment, DaggerAppComponentServer.this.getCheckInSuccessViewModel());
            return checkInSuccessFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInScannerFragmentSubcomponentFactory implements SupportFragmentModule_ContributeCheckInScannerFragment.CheckInScannerFragmentSubcomponent.Factory {
        private CheckInScannerFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeCheckInScannerFragment.CheckInScannerFragmentSubcomponent create(CheckInScannerFragment checkInScannerFragment) {
            Preconditions.checkNotNull(checkInScannerFragment);
            return new CheckInScannerFragmentSubcomponentImpl(checkInScannerFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInScannerFragmentSubcomponentImpl implements SupportFragmentModule_ContributeCheckInScannerFragment.CheckInScannerFragmentSubcomponent {
        private CheckInScannerFragmentSubcomponentImpl(CheckInScannerFragment checkInScannerFragment) {
        }

        public void inject(CheckInScannerFragment checkInScannerFragment) {
            injectCheckInScannerFragment(checkInScannerFragment);
        }

        private CheckInScannerFragment injectCheckInScannerFragment(CheckInScannerFragment checkInScannerFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInScannerFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInScannerFragment, DaggerAppComponentServer.this.getViewModelFactory());
            CheckInScannerFragment_MembersInjector.injectViewModel(checkInScannerFragment, DaggerAppComponentServer.this.getCheckInScannerViewModel());
            CheckInScannerFragment_MembersInjector.injectCheckInRepository(checkInScannerFragment, (CheckInRepository) Preconditions.checkNotNull(DaggerAppComponentServer.this.baseComponent.checkInRepository(), "Cannot return null from a non-@Nullable component method"));
            return checkInScannerFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInHistoryDetailFragmentSubcomponentFactory implements SupportFragmentModule_ContributeCheckInHistoryDetailFragment.CheckInHistoryDetailFragmentSubcomponent.Factory {
        private CheckInHistoryDetailFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeCheckInHistoryDetailFragment.CheckInHistoryDetailFragmentSubcomponent create(CheckInHistoryDetailFragment checkInHistoryDetailFragment) {
            Preconditions.checkNotNull(checkInHistoryDetailFragment);
            return new CheckInHistoryDetailFragmentSubcomponentImpl(checkInHistoryDetailFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInHistoryDetailFragmentSubcomponentImpl implements SupportFragmentModule_ContributeCheckInHistoryDetailFragment.CheckInHistoryDetailFragmentSubcomponent {
        private CheckInHistoryDetailFragmentSubcomponentImpl(CheckInHistoryDetailFragment checkInHistoryDetailFragment) {
        }

        public void inject(CheckInHistoryDetailFragment checkInHistoryDetailFragment) {
            injectCheckInHistoryDetailFragment(checkInHistoryDetailFragment);
        }

        private CheckInHistoryDetailFragment injectCheckInHistoryDetailFragment(CheckInHistoryDetailFragment checkInHistoryDetailFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInHistoryDetailFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInHistoryDetailFragment, DaggerAppComponentServer.this.getViewModelFactory());
            CheckInHistoryDetailFragment_MembersInjector.injectViewModel(checkInHistoryDetailFragment, DaggerAppComponentServer.this.getCheckInHistoryDetailViewModel());
            return checkInHistoryDetailFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInFeedbackFragmentSubcomponentFactory implements SupportFragmentModule_ContributeCheckInFeedbackFragment.CheckInFeedbackFragmentSubcomponent.Factory {
        private CheckInFeedbackFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeCheckInFeedbackFragment.CheckInFeedbackFragmentSubcomponent create(CheckInFeedbackFragment checkInFeedbackFragment) {
            Preconditions.checkNotNull(checkInFeedbackFragment);
            return new CheckInFeedbackFragmentSubcomponentImpl(checkInFeedbackFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInFeedbackFragmentSubcomponentImpl implements SupportFragmentModule_ContributeCheckInFeedbackFragment.CheckInFeedbackFragmentSubcomponent {
        private CheckInFeedbackFragmentSubcomponentImpl(CheckInFeedbackFragment checkInFeedbackFragment) {
        }

        public void inject(CheckInFeedbackFragment checkInFeedbackFragment) {
            injectCheckInFeedbackFragment(checkInFeedbackFragment);
        }

        private CheckInFeedbackFragment injectCheckInFeedbackFragment(CheckInFeedbackFragment checkInFeedbackFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInFeedbackFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInFeedbackFragment, DaggerAppComponentServer.this.getViewModelFactory());
            CheckInFeedbackFragment_MembersInjector.injectViewModel(checkInFeedbackFragment, DaggerAppComponentServer.this.getCheckInFeedbackViewModel());
            return checkInFeedbackFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInFeedbackSuccessFragmentSubcomponentFactory implements SupportFragmentModule_ContributeCheckInFeedbackSuccessFragment.CheckInFeedbackSuccessFragmentSubcomponent.Factory {
        private CheckInFeedbackSuccessFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeCheckInFeedbackSuccessFragment.CheckInFeedbackSuccessFragmentSubcomponent create(CheckInFeedbackSuccessFragment checkInFeedbackSuccessFragment) {
            Preconditions.checkNotNull(checkInFeedbackSuccessFragment);
            return new CheckInFeedbackSuccessFragmentSubcomponentImpl(checkInFeedbackSuccessFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInFeedbackSuccessFragmentSubcomponentImpl implements SupportFragmentModule_ContributeCheckInFeedbackSuccessFragment.CheckInFeedbackSuccessFragmentSubcomponent {
        private CheckInFeedbackSuccessFragmentSubcomponentImpl(CheckInFeedbackSuccessFragment checkInFeedbackSuccessFragment) {
        }

        public void inject(CheckInFeedbackSuccessFragment checkInFeedbackSuccessFragment) {
            injectCheckInFeedbackSuccessFragment(checkInFeedbackSuccessFragment);
        }

        private CheckInFeedbackSuccessFragment injectCheckInFeedbackSuccessFragment(CheckInFeedbackSuccessFragment checkInFeedbackSuccessFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInFeedbackSuccessFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInFeedbackSuccessFragment, DaggerAppComponentServer.this.getViewModelFactory());
            CheckInFeedbackSuccessFragment_MembersInjector.injectViewModel(checkInFeedbackSuccessFragment, DaggerAppComponentServer.this.getCheckInFeedbackSuccessViewModel());
            return checkInFeedbackSuccessFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInShortcutFragmentSubcomponentFactory implements SupportFragmentModule_ContributeCheckInShortcutFragment.CheckInShortcutFragmentSubcomponent.Factory {
        private CheckInShortcutFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeCheckInShortcutFragment.CheckInShortcutFragmentSubcomponent create(CheckInShortcutFragment checkInShortcutFragment) {
            Preconditions.checkNotNull(checkInShortcutFragment);
            return new CheckInShortcutFragmentSubcomponentImpl(checkInShortcutFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInShortcutFragmentSubcomponentImpl implements SupportFragmentModule_ContributeCheckInShortcutFragment.CheckInShortcutFragmentSubcomponent {
        private CheckInShortcutFragmentSubcomponentImpl(CheckInShortcutFragment checkInShortcutFragment) {
        }

        public void inject(CheckInShortcutFragment checkInShortcutFragment) {
            injectCheckInShortcutFragment(checkInShortcutFragment);
        }

        private CheckInShortcutFragment injectCheckInShortcutFragment(CheckInShortcutFragment checkInShortcutFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInShortcutFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInShortcutFragment, DaggerAppComponentServer.this.getViewModelFactory());
            CheckInShortcutFragment_MembersInjector.injectViewModel(checkInShortcutFragment, DaggerAppComponentServer.this.getCheckInShortcutViewModel());
            return checkInShortcutFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class HomeServicesFragmentSubcomponentFactory implements SupportFragmentModule_ContributeHomeServicesFragment.HomeServicesFragmentSubcomponent.Factory {
        private HomeServicesFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeHomeServicesFragment.HomeServicesFragmentSubcomponent create(HomeServicesFragment homeServicesFragment) {
            Preconditions.checkNotNull(homeServicesFragment);
            return new HomeServicesFragmentSubcomponentImpl(homeServicesFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class HomeServicesFragmentSubcomponentImpl implements SupportFragmentModule_ContributeHomeServicesFragment.HomeServicesFragmentSubcomponent {
        private HomeServicesFragmentSubcomponentImpl(HomeServicesFragment homeServicesFragment) {
        }

        public void inject(HomeServicesFragment homeServicesFragment) {
            injectHomeServicesFragment(homeServicesFragment);
        }

        private HomeServicesFragment injectHomeServicesFragment(HomeServicesFragment homeServicesFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(homeServicesFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(homeServicesFragment, DaggerAppComponentServer.this.getViewModelFactory());
            HomeServicesFragment_MembersInjector.injectViewModel(homeServicesFragment, DaggerAppComponentServer.this.getHomeServicesViewModel());
            HomeServicesFragment_MembersInjector.injectRemoteConfigService(homeServicesFragment, (RemoteConfigService) Preconditions.checkNotNull(DaggerAppComponentServer.this.baseComponent.remoteConfigService(), "Cannot return null from a non-@Nullable component method"));
            return homeServicesFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class ServiceGroupCategoriesFragmentSubcomponentFactory implements SupportFragmentModule_ServiceGroupCategoriesFragment.ServiceGroupCategoriesFragmentSubcomponent.Factory {
        private ServiceGroupCategoriesFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ServiceGroupCategoriesFragment.ServiceGroupCategoriesFragmentSubcomponent create(ServiceGroupCategoriesFragment serviceGroupCategoriesFragment) {
            Preconditions.checkNotNull(serviceGroupCategoriesFragment);
            return new ServiceGroupCategoriesFragmentSubcomponentImpl(serviceGroupCategoriesFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class ServiceGroupCategoriesFragmentSubcomponentImpl implements SupportFragmentModule_ServiceGroupCategoriesFragment.ServiceGroupCategoriesFragmentSubcomponent {
        private ServiceGroupCategoriesFragmentSubcomponentImpl(ServiceGroupCategoriesFragment serviceGroupCategoriesFragment) {
        }

        public void inject(ServiceGroupCategoriesFragment serviceGroupCategoriesFragment) {
            injectServiceGroupCategoriesFragment(serviceGroupCategoriesFragment);
        }

        private ServiceGroupCategoriesFragment injectServiceGroupCategoriesFragment(ServiceGroupCategoriesFragment serviceGroupCategoriesFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(serviceGroupCategoriesFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(serviceGroupCategoriesFragment, DaggerAppComponentServer.this.getViewModelFactory());
            ServiceGroupCategoriesFragment_MembersInjector.injectViewModel(serviceGroupCategoriesFragment, new ServiceGroupCategoriesViewModel());
            return serviceGroupCategoriesFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class ServiceCategoryTransactionsFragmentSubcomponentFactory implements SupportFragmentModule_ServiceCategoryTransactionsFragment.ServiceCategoryTransactionsFragmentSubcomponent.Factory {
        private ServiceCategoryTransactionsFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ServiceCategoryTransactionsFragment.ServiceCategoryTransactionsFragmentSubcomponent create(ServiceCategoryTransactionsFragment serviceCategoryTransactionsFragment) {
            Preconditions.checkNotNull(serviceCategoryTransactionsFragment);
            return new ServiceCategoryTransactionsFragmentSubcomponentImpl(serviceCategoryTransactionsFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class ServiceCategoryTransactionsFragmentSubcomponentImpl implements SupportFragmentModule_ServiceCategoryTransactionsFragment.ServiceCategoryTransactionsFragmentSubcomponent {
        private ServiceCategoryTransactionsFragmentSubcomponentImpl(ServiceCategoryTransactionsFragment serviceCategoryTransactionsFragment) {
        }

        public void inject(ServiceCategoryTransactionsFragment serviceCategoryTransactionsFragment) {
            injectServiceCategoryTransactionsFragment(serviceCategoryTransactionsFragment);
        }

        private ServiceCategoryTransactionsFragment injectServiceCategoryTransactionsFragment(ServiceCategoryTransactionsFragment serviceCategoryTransactionsFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(serviceCategoryTransactionsFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(serviceCategoryTransactionsFragment, DaggerAppComponentServer.this.getViewModelFactory());
            ServiceCategoryTransactionsFragment_MembersInjector.injectViewModel(serviceCategoryTransactionsFragment, DaggerAppComponentServer.this.getServiceCategoryTransactionsViewModel());
            return serviceCategoryTransactionsFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CreateAccountFragmentSubcomponentFactory implements SupportFragmentModule_ContributeCreateAccountFragment.CreateAccountFragmentSubcomponent.Factory {
        private CreateAccountFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeCreateAccountFragment.CreateAccountFragmentSubcomponent create(CreateAccountFragment createAccountFragment) {
            Preconditions.checkNotNull(createAccountFragment);
            return new CreateAccountFragmentSubcomponentImpl(createAccountFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CreateAccountFragmentSubcomponentImpl implements SupportFragmentModule_ContributeCreateAccountFragment.CreateAccountFragmentSubcomponent {
        private CreateAccountFragmentSubcomponentImpl(CreateAccountFragment createAccountFragment) {
        }

        public void inject(CreateAccountFragment createAccountFragment) {
            injectCreateAccountFragment(createAccountFragment);
        }

        private CreateAccountFragment injectCreateAccountFragment(CreateAccountFragment createAccountFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(createAccountFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(createAccountFragment, DaggerAppComponentServer.this.getViewModelFactory());
            CreateAccountFragment_MembersInjector.injectViewModel(createAccountFragment, DaggerAppComponentServer.this.getCreateAccountViewModel());
            return createAccountFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class VerifyEmailFragmentSubcomponentFactory implements SupportFragmentModule_ContributeVerifyEmailFragment.VerifyEmailFragmentSubcomponent.Factory {
        private VerifyEmailFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeVerifyEmailFragment.VerifyEmailFragmentSubcomponent create(VerifyEmailFragment verifyEmailFragment) {
            Preconditions.checkNotNull(verifyEmailFragment);
            return new VerifyEmailFragmentSubcomponentImpl(verifyEmailFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class VerifyEmailFragmentSubcomponentImpl implements SupportFragmentModule_ContributeVerifyEmailFragment.VerifyEmailFragmentSubcomponent {
        private VerifyEmailFragmentSubcomponentImpl(VerifyEmailFragment verifyEmailFragment) {
        }

        public void inject(VerifyEmailFragment verifyEmailFragment) {
            injectVerifyEmailFragment(verifyEmailFragment);
        }

        private VerifyEmailFragment injectVerifyEmailFragment(VerifyEmailFragment verifyEmailFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(verifyEmailFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(verifyEmailFragment, DaggerAppComponentServer.this.getViewModelFactory());
            VerifyEmailFragment_MembersInjector.injectViewModel(verifyEmailFragment, DaggerAppComponentServer.this.getVerifyEmailViewModel());
            return verifyEmailFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class RegisterSuccessFragmentSubcomponentFactory implements SupportFragmentModule_ContributeRegisterSuccessFragment.RegisterSuccessFragmentSubcomponent.Factory {
        private RegisterSuccessFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeRegisterSuccessFragment.RegisterSuccessFragmentSubcomponent create(RegisterSuccessFragment registerSuccessFragment) {
            Preconditions.checkNotNull(registerSuccessFragment);
            return new RegisterSuccessFragmentSubcomponentImpl(registerSuccessFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class RegisterSuccessFragmentSubcomponentImpl implements SupportFragmentModule_ContributeRegisterSuccessFragment.RegisterSuccessFragmentSubcomponent {
        private RegisterSuccessFragmentSubcomponentImpl(RegisterSuccessFragment registerSuccessFragment) {
        }

        public void inject(RegisterSuccessFragment registerSuccessFragment) {
            injectRegisterSuccessFragment(registerSuccessFragment);
        }

        private RegisterSuccessFragment injectRegisterSuccessFragment(RegisterSuccessFragment registerSuccessFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(registerSuccessFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(registerSuccessFragment, DaggerAppComponentServer.this.getViewModelFactory());
            RegisterSuccessFragment_MembersInjector.injectViewModel(registerSuccessFragment, DaggerAppComponentServer.this.getRegisterSuccessViewModel());
            return registerSuccessFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class MoreCardsInfoFragmentSubcomponentFactory implements SupportFragmentModule_ContributeMoreCardsInfoFragment.MoreCardsInfoFragmentSubcomponent.Factory {
        private MoreCardsInfoFragmentSubcomponentFactory() {
        }

        public SupportFragmentModule_ContributeMoreCardsInfoFragment.MoreCardsInfoFragmentSubcomponent create(MoreCardsInfoFragment moreCardsInfoFragment) {
            Preconditions.checkNotNull(moreCardsInfoFragment);
            return new MoreCardsInfoFragmentSubcomponentImpl(moreCardsInfoFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class MoreCardsInfoFragmentSubcomponentImpl implements SupportFragmentModule_ContributeMoreCardsInfoFragment.MoreCardsInfoFragmentSubcomponent {
        private MoreCardsInfoFragmentSubcomponentImpl(MoreCardsInfoFragment moreCardsInfoFragment) {
        }

        public void inject(MoreCardsInfoFragment moreCardsInfoFragment) {
            injectMoreCardsInfoFragment(moreCardsInfoFragment);
        }

        private MoreCardsInfoFragment injectMoreCardsInfoFragment(MoreCardsInfoFragment moreCardsInfoFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(moreCardsInfoFragment, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(moreCardsInfoFragment, DaggerAppComponentServer.this.getViewModelFactory());
            MoreCardsInfoFragment_MembersInjector.injectViewModel(moreCardsInfoFragment, DaggerAppComponentServer.this.getMoreCardsInfoViewModel());
            return moreCardsInfoFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class LoginActivitySubcomponentFactory implements ActivityModule_ContributeLoginActivity.LoginActivitySubcomponent.Factory {
        private LoginActivitySubcomponentFactory() {
        }

        public ActivityModule_ContributeLoginActivity.LoginActivitySubcomponent create(LoginActivity loginActivity) {
            Preconditions.checkNotNull(loginActivity);
            return new LoginActivitySubcomponentImpl(loginActivity);
        }
    }

    /* access modifiers changed from: private */
    public final class LoginActivitySubcomponentImpl implements ActivityModule_ContributeLoginActivity.LoginActivitySubcomponent {
        private LoginActivitySubcomponentImpl(LoginActivity loginActivity) {
        }

        public void inject(LoginActivity loginActivity) {
            injectLoginActivity(loginActivity);
        }

        private LoginActivity injectLoginActivity(LoginActivity loginActivity) {
            BaseActivity_MembersInjector.injectAndroidInjector(loginActivity, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseActivity_MembersInjector.injectViewModelFactory(loginActivity, DaggerAppComponentServer.this.getViewModelFactory());
            BaseAppActivity_MembersInjector.injectAppStartUp(loginActivity, (AppStartUp) DaggerAppComponentServer.this.provideAppStartUpProvider.get());
            LoginActivity_MembersInjector.injectViewModel(loginActivity, DaggerAppComponentServer.this.getLoginActivityViewModel());
            LoginActivity_MembersInjector.injectRemoteConfigService(loginActivity, (RemoteConfigService) Preconditions.checkNotNull(DaggerAppComponentServer.this.baseComponent.remoteConfigService(), "Cannot return null from a non-@Nullable component method"));
            LoginActivity_MembersInjector.injectRemoteSubscriptionService(loginActivity, DaggerAppComponentServer.this.getRemoteSubscriptionService());
            return loginActivity;
        }
    }

    /* access modifiers changed from: private */
    public final class SplashActivitySubcomponentFactory implements ActivityModule_ContributeSecondSplashActivity.SplashActivitySubcomponent.Factory {
        private SplashActivitySubcomponentFactory() {
        }

        public ActivityModule_ContributeSecondSplashActivity.SplashActivitySubcomponent create(SplashActivity splashActivity) {
            Preconditions.checkNotNull(splashActivity);
            return new SplashActivitySubcomponentImpl(splashActivity);
        }
    }

    /* access modifiers changed from: private */
    public final class SplashActivitySubcomponentImpl implements ActivityModule_ContributeSecondSplashActivity.SplashActivitySubcomponent {
        private SplashActivitySubcomponentImpl(SplashActivity splashActivity) {
        }

        public void inject(SplashActivity splashActivity) {
            injectSplashActivity(splashActivity);
        }

        private SplashActivity injectSplashActivity(SplashActivity splashActivity) {
            BaseActivity_MembersInjector.injectAndroidInjector(splashActivity, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseActivity_MembersInjector.injectViewModelFactory(splashActivity, DaggerAppComponentServer.this.getViewModelFactory());
            BaseAppActivity_MembersInjector.injectAppStartUp(splashActivity, (AppStartUp) DaggerAppComponentServer.this.provideAppStartUpProvider.get());
            SplashActivity_MembersInjector.injectViewModel(splashActivity, DaggerAppComponentServer.this.getSplashViewModel());
            return splashActivity;
        }
    }

    /* access modifiers changed from: private */
    public final class PinActivitySubcomponentFactory implements ActivityModule_ContributePinActivity.PinActivitySubcomponent.Factory {
        private PinActivitySubcomponentFactory() {
        }

        public ActivityModule_ContributePinActivity.PinActivitySubcomponent create(PinActivity pinActivity) {
            Preconditions.checkNotNull(pinActivity);
            return new PinActivitySubcomponentImpl(pinActivity);
        }
    }

    /* access modifiers changed from: private */
    public final class PinActivitySubcomponentImpl implements ActivityModule_ContributePinActivity.PinActivitySubcomponent {
        private PinActivitySubcomponentImpl(PinActivity pinActivity) {
        }

        public void inject(PinActivity pinActivity) {
            injectPinActivity(pinActivity);
        }

        private PinActivity injectPinActivity(PinActivity pinActivity) {
            BaseActivity_MembersInjector.injectAndroidInjector(pinActivity, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseActivity_MembersInjector.injectViewModelFactory(pinActivity, DaggerAppComponentServer.this.getViewModelFactory());
            BaseAppActivity_MembersInjector.injectAppStartUp(pinActivity, (AppStartUp) DaggerAppComponentServer.this.provideAppStartUpProvider.get());
            PinActivity_MembersInjector.injectViewModel(pinActivity, DaggerAppComponentServer.this.getPinActivityViewModel());
            return pinActivity;
        }
    }

    /* access modifiers changed from: private */
    public final class OnboardingActivitySubcomponentFactory implements ActivityModule_ContributeOnboardingActivity.OnboardingActivitySubcomponent.Factory {
        private OnboardingActivitySubcomponentFactory() {
        }

        public ActivityModule_ContributeOnboardingActivity.OnboardingActivitySubcomponent create(OnboardingActivity onboardingActivity) {
            Preconditions.checkNotNull(onboardingActivity);
            return new OnboardingActivitySubcomponentImpl(onboardingActivity);
        }
    }

    /* access modifiers changed from: private */
    public final class OnboardingActivitySubcomponentImpl implements ActivityModule_ContributeOnboardingActivity.OnboardingActivitySubcomponent {
        private OnboardingActivitySubcomponentImpl(OnboardingActivity onboardingActivity) {
        }

        public void inject(OnboardingActivity onboardingActivity) {
            injectOnboardingActivity(onboardingActivity);
        }

        private OnboardingActivity injectOnboardingActivity(OnboardingActivity onboardingActivity) {
            AppDaggerAppCompatActivity_MembersInjector.injectAndroidInjector(onboardingActivity, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            AppDaggerAppCompatActivity_MembersInjector.injectViewModelFactory(onboardingActivity, DaggerAppComponentServer.this.getViewModelFactory());
            OnboardingActivity_MembersInjector.injectAuthenticationUtility(onboardingActivity, (AuthenticationUtility) DaggerAppComponentServer.this.provideAuthenticationUtilityProvider.get());
            OnboardingActivity_MembersInjector.injectRemoteConfigService(onboardingActivity, (RemoteConfigService) Preconditions.checkNotNull(DaggerAppComponentServer.this.baseComponent.remoteConfigService(), "Cannot return null from a non-@Nullable component method"));
            OnboardingActivity_MembersInjector.injectAnalytics(onboardingActivity, (AnalyticsHelper) Preconditions.checkNotNull(DaggerAppComponentServer.this.baseComponent.analytics(), "Cannot return null from a non-@Nullable component method"));
            return onboardingActivity;
        }
    }

    /* access modifiers changed from: private */
    public final class SetupActivitySubcomponentFactory implements ActivityModule_ContributeSetupActivity.SetupActivitySubcomponent.Factory {
        private SetupActivitySubcomponentFactory() {
        }

        public ActivityModule_ContributeSetupActivity.SetupActivitySubcomponent create(SetupActivity setupActivity) {
            Preconditions.checkNotNull(setupActivity);
            return new SetupActivitySubcomponentImpl(setupActivity);
        }
    }

    /* access modifiers changed from: private */
    public final class SetupActivitySubcomponentImpl implements ActivityModule_ContributeSetupActivity.SetupActivitySubcomponent {
        private SetupActivitySubcomponentImpl(SetupActivity setupActivity) {
        }

        public void inject(SetupActivity setupActivity) {
            injectSetupActivity(setupActivity);
        }

        private SetupActivity injectSetupActivity(SetupActivity setupActivity) {
            AppDaggerAppCompatActivity_MembersInjector.injectAndroidInjector(setupActivity, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            AppDaggerAppCompatActivity_MembersInjector.injectViewModelFactory(setupActivity, DaggerAppComponentServer.this.getViewModelFactory());
            SetupActivity_MembersInjector.injectAuthUtility(setupActivity, (AuthenticationUtility) DaggerAppComponentServer.this.provideAuthenticationUtilityProvider.get());
            return setupActivity;
        }
    }

    /* access modifiers changed from: private */
    public final class HarvestActivitySubcomponentFactory implements ActivityModule_ContributeHarvestJobActivity.HarvestActivitySubcomponent.Factory {
        private HarvestActivitySubcomponentFactory() {
        }

        public ActivityModule_ContributeHarvestJobActivity.HarvestActivitySubcomponent create(HarvestActivity harvestActivity) {
            Preconditions.checkNotNull(harvestActivity);
            return new HarvestActivitySubcomponentImpl(harvestActivity);
        }
    }

    /* access modifiers changed from: private */
    public final class HarvestActivitySubcomponentImpl implements ActivityModule_ContributeHarvestJobActivity.HarvestActivitySubcomponent {
        private HarvestActivitySubcomponentImpl(HarvestActivity harvestActivity) {
        }

        public void inject(HarvestActivity harvestActivity) {
            injectHarvestActivity(harvestActivity);
        }

        private HarvestActivity injectHarvestActivity(HarvestActivity harvestActivity) {
            BaseActivity_MembersInjector.injectAndroidInjector(harvestActivity, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseActivity_MembersInjector.injectViewModelFactory(harvestActivity, DaggerAppComponentServer.this.getViewModelFactory());
            BaseAppActivity_MembersInjector.injectAppStartUp(harvestActivity, (AppStartUp) DaggerAppComponentServer.this.provideAppStartUpProvider.get());
            HarvestActivity_MembersInjector.injectViewModel(harvestActivity, DaggerAppComponentServer.this.getHarvestJobWizardViewModel());
            HarvestActivity_MembersInjector.injectTagViewModel(harvestActivity, DaggerAppComponentServer.this.getHarvestTagViewModel());
            return harvestActivity;
        }
    }

    /* access modifiers changed from: private */
    public final class MainActivityServerSubcomponentFactory implements ActivityModuleServer_ContributeMainActivity.MainActivityServerSubcomponent.Factory {
        private MainActivityServerSubcomponentFactory() {
        }

        public ActivityModuleServer_ContributeMainActivity.MainActivityServerSubcomponent create(MainActivityServer mainActivityServer) {
            Preconditions.checkNotNull(mainActivityServer);
            return new MainActivityServerSubcomponentImpl(mainActivityServer);
        }
    }

    /* access modifiers changed from: private */
    public final class MainActivityServerSubcomponentImpl implements ActivityModuleServer_ContributeMainActivity.MainActivityServerSubcomponent {
        private MainActivityServerSubcomponentImpl(MainActivityServer mainActivityServer) {
        }

        public void inject(MainActivityServer mainActivityServer) {
            injectMainActivityServer(mainActivityServer);
        }

        private MainActivityServer injectMainActivityServer(MainActivityServer mainActivityServer) {
            BaseActivity_MembersInjector.injectAndroidInjector(mainActivityServer, DaggerAppComponentServer.this.getDispatchingAndroidInjectorOfObject());
            BaseActivity_MembersInjector.injectViewModelFactory(mainActivityServer, DaggerAppComponentServer.this.getViewModelFactory());
            BaseAppActivity_MembersInjector.injectAppStartUp(mainActivityServer, (AppStartUp) DaggerAppComponentServer.this.provideAppStartUpProvider.get());
            MainActivity_MembersInjector.injectViewModel(mainActivityServer, DaggerAppComponentServer.this.getMainActivityViewModel());
            MainActivity_MembersInjector.injectHoldingParser(mainActivityServer, (HoldingParser) DaggerAppComponentServer.this.holdingParserProvider.get());
            MainActivity_MembersInjector.injectHoldingsService(mainActivityServer, (HoldingsService) DaggerAppComponentServer.this.holdingsServiceProvider.get());
            MainActivity_MembersInjector.injectAuthenticationUtility(mainActivityServer, (AuthenticationUtility) DaggerAppComponentServer.this.provideAuthenticationUtilityProvider.get());
            MainActivity_MembersInjector.injectBluetoothEvents(mainActivityServer, (BluetoothEventsService) DaggerAppComponentServer.this.provideBluetoothEventsServiceProvider.get());
            MainActivity_MembersInjector.injectRemoteSubscriptionService(mainActivityServer, DaggerAppComponentServer.this.getRemoteSubscriptionService());
            MainActivityServer_MembersInjector.injectBleServer(mainActivityServer, (BLEServer) DaggerAppComponentServer.this.bLEServerProvider.get());
            return mainActivityServer;
        }
    }
}
