package com.digitalwallet.app.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.digitalwallet.app.viewmodel.harvester.HarvestJobWizardViewModel;
import com.digitalwallet.app.viewmodel.harvester.HarvestTagViewModel;
import com.digitalwallet.app.viewmodel.login.CreateAccountViewModel;
import com.digitalwallet.app.viewmodel.login.HomeServicesViewModel;
import com.digitalwallet.app.viewmodel.login.LoginActivityViewModel;
import com.digitalwallet.app.viewmodel.login.RegisterSuccessViewModel;
import com.digitalwallet.app.viewmodel.login.VerifyEmailViewModel;
import com.digitalwallet.app.viewmodel.main.AccountDetailsFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.AccountSettingsFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.EligibilityScannerFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.HoldingDetailFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.HoldingListFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.MainActivityViewModel;
import com.digitalwallet.app.viewmodel.main.MainPagerFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.NicknameViewModel;
import com.digitalwallet.app.viewmodel.main.ServiceDetailFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.addsync.AutoSyncViewModel;
import com.digitalwallet.app.viewmodel.main.addsync.CardAddViewModel;
import com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel;
import com.digitalwallet.app.viewmodel.main.history.SharingHistoryFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.history.TransactionHistoryFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.holdings.MoreCardsInfoViewModel;
import com.digitalwallet.app.viewmodel.main.sharing.IncomingRequestFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyFragmentViewModel;
import com.digitalwallet.app.viewmodel.pin.FingerprintDialogFragmentViewModel;
import com.digitalwallet.app.viewmodel.pin.PinActivityViewModel;
import com.digitalwallet.app.viewmodel.splash.SplashViewModel;
import com.digitalwallet.app.viewmodel.svservices.ServiceCategoryTransactionsViewModel;
import com.digitalwallet.app.viewmodel.svservices.ServiceGroupCategoriesViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.di.ViewModelKey;
import com.digitalwallet.viewmodel.checkIn.CheckInOverviewViewModel;
import com.digitalwallet.viewmodel.checkIn.CheckInScannerViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInAddDependantInputViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInEditPersonInputViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInPrimaryInputViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInSubmittingViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInSummaryViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.CheckInShortcutViewModel;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInFeedbackSuccessViewModel;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInFeedbackViewModel;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInHistoryDetailViewModel;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInSuccessViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000è\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H!¢\u0006\u0002\b\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\tH!¢\u0006\u0002\b\nJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\fH!¢\u0006\u0002\b\rJ\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H!¢\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0014H!¢\u0006\u0002\b\u0015J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0017H!¢\u0006\u0002\b\u0018J\u0015\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001aH!¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001dH!¢\u0006\u0002\b\u001eJ\u0015\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020 H!¢\u0006\u0002\b!J\u0015\u0010\"\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020#H!¢\u0006\u0002\b$J\u0015\u0010%\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020&H!¢\u0006\u0002\b'J\u0015\u0010(\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020)H!¢\u0006\u0002\b*J\u0015\u0010+\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020,H!¢\u0006\u0002\b-J\u0015\u0010.\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020/H!¢\u0006\u0002\b0J\u0015\u00101\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000202H!¢\u0006\u0002\b3J\u0015\u00104\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000205H!¢\u0006\u0002\b6J\u0015\u00107\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000208H!¢\u0006\u0002\b9J\u0015\u0010:\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020;H!¢\u0006\u0002\b<J\u0015\u0010=\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020>H!¢\u0006\u0002\b?J\u0015\u0010@\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020AH!¢\u0006\u0002\bBJ\u0015\u0010C\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020DH!¢\u0006\u0002\bEJ\u0015\u0010F\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020GH!¢\u0006\u0002\bHJ\u0015\u0010I\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020JH!¢\u0006\u0002\bKJ\u0015\u0010L\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020MH!¢\u0006\u0002\bNJ\u0015\u0010O\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020PH!¢\u0006\u0002\bQJ\u0015\u0010R\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020SH!¢\u0006\u0002\bTJ\u0015\u0010U\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020VH!¢\u0006\u0002\bWJ\u0015\u0010X\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020YH!¢\u0006\u0002\bZJ\u0015\u0010[\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\\H!¢\u0006\u0002\b]J\u0015\u0010^\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020_H!¢\u0006\u0002\b`J\u0015\u0010a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020bH!¢\u0006\u0002\bcJ\u0015\u0010d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020eH!¢\u0006\u0002\bfJ\u0015\u0010g\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020hH!¢\u0006\u0002\biJ\u0015\u0010j\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020kH!¢\u0006\u0002\blJ\u0015\u0010m\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020nH!¢\u0006\u0002\boJ\u0015\u0010p\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020qH!¢\u0006\u0002\brJ\u0015\u0010s\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020tH!¢\u0006\u0002\buJ\u0015\u0010v\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020wH!¢\u0006\u0002\bxJ\u0015\u0010y\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020zH!¢\u0006\u0002\b{J\u0015\u0010|\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020}H!¢\u0006\u0002\b~J\u0017\u0010\u001a\u00020\u00042\u0007\u0010\u0005\u001a\u00030\u0001H!¢\u0006\u0003\b\u0001J\u0018\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0005\u001a\u00030\u0001H!¢\u0006\u0003\b\u0001¨\u0006\u0001"}, d2 = {"Lcom/digitalwallet/app/di/ViewModelModule;", "", "()V", "accountDetailsFragmentViewModel", "Landroidx/lifecycle/ViewModel;", "viewModel", "Lcom/digitalwallet/app/viewmodel/main/AccountDetailsFragmentViewModel;", "accountDetailsFragmentViewModel$app_citizenProdRelease", "accountSettingsFragmentViewModel", "Lcom/digitalwallet/app/viewmodel/main/AccountSettingsFragmentViewModel;", "accountSettingsFragmentViewModel$app_citizenProdRelease", "autoSyncViewModel", "Lcom/digitalwallet/app/viewmodel/main/addsync/AutoSyncViewModel;", "autoSyncViewModel$app_citizenProdRelease", "bindViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "Lcom/digitalwallet/di/ViewModelFactory;", "bindViewModelFactory$app_citizenProdRelease", "cardAddFragmentViewModel", "Lcom/digitalwallet/app/viewmodel/main/addsync/CardAddViewModel;", "cardAddFragmentViewModel$app_citizenProdRelease", "cardSyncFragmentViewModel", "Lcom/digitalwallet/app/viewmodel/main/addsync/CardSyncViewModel;", "cardSyncFragmentViewModel$app_citizenProdRelease", "checkInAddDependantInputViewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInAddDependantInputViewModel;", "checkInAddDependantInputViewModel$app_citizenProdRelease", "checkInEditPersonInputViewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInEditPersonInputViewModel;", "checkInEditPersonInputViewModel$app_citizenProdRelease", "checkInFeedbackSuccessViewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInFeedbackSuccessViewModel;", "checkInFeedbackSuccessViewModel$app_citizenProdRelease", "checkInFeedbackViewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInFeedbackViewModel;", "checkInFeedbackViewModel$app_citizenProdRelease", "checkInHistoryDetailViewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInHistoryDetailViewModel;", "checkInHistoryDetailViewModel$app_citizenProdRelease", "checkInOverviewViewModel", "Lcom/digitalwallet/viewmodel/checkIn/CheckInOverviewViewModel;", "checkInOverviewViewModel$app_citizenProdRelease", "checkInPrimaryInputViewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInPrimaryInputViewModel;", "checkInPrimaryInputViewModel$app_citizenProdRelease", "checkInScannerViewModel", "Lcom/digitalwallet/viewmodel/checkIn/CheckInScannerViewModel;", "checkInScannerViewModel$app_citizenProdRelease", "checkInShortcutViewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkInShortcut/CheckInShortcutViewModel;", "checkInShortcutViewModel$app_citizenProdRelease", "checkInSubmittingViewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInSubmittingViewModel;", "checkInSubmittingViewModel$app_citizenProdRelease", "checkInSuccessViewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInSuccessViewModel;", "checkInSuccessViewModel$app_citizenProdRelease", "checkInSummaryViewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInSummaryViewModel;", "checkInSummaryViewModel$app_citizenProdRelease", "createAccountViewModel", "Lcom/digitalwallet/app/viewmodel/login/CreateAccountViewModel;", "createAccountViewModel$app_citizenProdRelease", "eligibilityScannerFragmentViewModel", "Lcom/digitalwallet/app/viewmodel/main/EligibilityScannerFragmentViewModel;", "eligibilityScannerFragmentViewModel$app_citizenProdRelease", "fingerprintDialogViewModel", "Lcom/digitalwallet/app/viewmodel/pin/FingerprintDialogFragmentViewModel;", "fingerprintDialogViewModel$app_citizenProdRelease", "harvestJobViewModel", "Lcom/digitalwallet/app/viewmodel/harvester/HarvestJobWizardViewModel;", "harvestJobViewModel$app_citizenProdRelease", "harvestTagViewModel", "Lcom/digitalwallet/app/viewmodel/harvester/HarvestTagViewModel;", "harvestTagViewModel$app_citizenProdRelease", "holdingDetailFragmentViewModel", "Lcom/digitalwallet/app/viewmodel/main/HoldingDetailFragmentViewModel;", "holdingDetailFragmentViewModel$app_citizenProdRelease", "holdingListFragmentViewModel", "Lcom/digitalwallet/app/viewmodel/main/HoldingListFragmentViewModel;", "holdingListFragmentViewModel$app_citizenProdRelease", "homeServicesViewModel", "Lcom/digitalwallet/app/viewmodel/login/HomeServicesViewModel;", "homeServicesViewModel$app_citizenProdRelease", "incomingRequestFragmentViewModel", "Lcom/digitalwallet/app/viewmodel/main/sharing/IncomingRequestFragmentViewModel;", "incomingRequestFragmentViewModel$app_citizenProdRelease", "lobbyFragmentViewModel", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyFragmentViewModel;", "lobbyFragmentViewModel$app_citizenProdRelease", "loginViewModel", "Lcom/digitalwallet/app/viewmodel/login/LoginActivityViewModel;", "loginViewModel$app_citizenProdRelease", "mainPagerFragmentViewModel", "Lcom/digitalwallet/app/viewmodel/main/MainPagerFragmentViewModel;", "mainPagerFragmentViewModel$app_citizenProdRelease", "mainViewModel", "Lcom/digitalwallet/app/viewmodel/main/MainActivityViewModel;", "mainViewModel$app_citizenProdRelease", "moreCardsInfoViewModel", "Lcom/digitalwallet/app/viewmodel/main/holdings/MoreCardsInfoViewModel;", "moreCardsInfoViewModel$app_citizenProdRelease", "nicknameViewModel", "Lcom/digitalwallet/app/viewmodel/main/NicknameViewModel;", "nicknameViewModel$app_citizenProdRelease", "pinViewModel", "Lcom/digitalwallet/app/viewmodel/pin/PinActivityViewModel;", "pinViewModel$app_citizenProdRelease", "registerSuccessViewModel", "Lcom/digitalwallet/app/viewmodel/login/RegisterSuccessViewModel;", "registerSuccessViewModel$app_citizenProdRelease", "serviceCategoryTransactionsViewModel", "Lcom/digitalwallet/app/viewmodel/svservices/ServiceCategoryTransactionsViewModel;", "serviceCategoryTransactionsViewModel$app_citizenProdRelease", "serviceDetailFragmentViewModel", "Lcom/digitalwallet/app/viewmodel/main/ServiceDetailFragmentViewModel;", "serviceDetailFragmentViewModel$app_citizenProdRelease", "serviceGroupCategoriesViewModel", "Lcom/digitalwallet/app/viewmodel/svservices/ServiceGroupCategoriesViewModel;", "serviceGroupCategoriesViewModel$app_citizenProdRelease", "sharingHistoryFragmentViewModel", "Lcom/digitalwallet/app/viewmodel/main/history/SharingHistoryFragmentViewModel;", "sharingHistoryFragmentViewModel$app_citizenProdRelease", "splashViewModel", "Lcom/digitalwallet/app/viewmodel/splash/SplashViewModel;", "splashViewModel$app_citizenProdRelease", "transactionHistoryFragmentViewModel", "Lcom/digitalwallet/app/viewmodel/main/history/TransactionHistoryFragmentViewModel;", "transactionHistoryFragmentViewModel$app_citizenProdRelease", "verifyEmailViewModel", "Lcom/digitalwallet/app/viewmodel/login/VerifyEmailViewModel;", "verifyEmailViewModel$app_citizenProdRelease", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
@Module
/* compiled from: ViewModelModule.kt */
public abstract class ViewModelModule {
    @ViewModelKey(AccountDetailsFragmentViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel accountDetailsFragmentViewModel$app_citizenProdRelease(AccountDetailsFragmentViewModel accountDetailsFragmentViewModel);

    @ViewModelKey(AccountSettingsFragmentViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel accountSettingsFragmentViewModel$app_citizenProdRelease(AccountSettingsFragmentViewModel accountSettingsFragmentViewModel);

    @ViewModelKey(AutoSyncViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel autoSyncViewModel$app_citizenProdRelease(AutoSyncViewModel autoSyncViewModel);

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory$app_citizenProdRelease(ViewModelFactory viewModelFactory);

    @ViewModelKey(CardAddViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel cardAddFragmentViewModel$app_citizenProdRelease(CardAddViewModel cardAddViewModel);

    @ViewModelKey(CardSyncViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel cardSyncFragmentViewModel$app_citizenProdRelease(CardSyncViewModel cardSyncViewModel);

    @ViewModelKey(CheckInAddDependantInputViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInAddDependantInputViewModel$app_citizenProdRelease(CheckInAddDependantInputViewModel checkInAddDependantInputViewModel);

    @ViewModelKey(CheckInEditPersonInputViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInEditPersonInputViewModel$app_citizenProdRelease(CheckInEditPersonInputViewModel checkInEditPersonInputViewModel);

    @ViewModelKey(CheckInFeedbackSuccessViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInFeedbackSuccessViewModel$app_citizenProdRelease(CheckInFeedbackSuccessViewModel checkInFeedbackSuccessViewModel);

    @ViewModelKey(CheckInFeedbackViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInFeedbackViewModel$app_citizenProdRelease(CheckInFeedbackViewModel checkInFeedbackViewModel);

    @ViewModelKey(CheckInHistoryDetailViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInHistoryDetailViewModel$app_citizenProdRelease(CheckInHistoryDetailViewModel checkInHistoryDetailViewModel);

    @ViewModelKey(CheckInOverviewViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInOverviewViewModel$app_citizenProdRelease(CheckInOverviewViewModel checkInOverviewViewModel);

    @ViewModelKey(CheckInPrimaryInputViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInPrimaryInputViewModel$app_citizenProdRelease(CheckInPrimaryInputViewModel checkInPrimaryInputViewModel);

    @ViewModelKey(CheckInScannerViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInScannerViewModel$app_citizenProdRelease(CheckInScannerViewModel checkInScannerViewModel);

    @ViewModelKey(CheckInShortcutViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInShortcutViewModel$app_citizenProdRelease(CheckInShortcutViewModel checkInShortcutViewModel);

    @ViewModelKey(CheckInSubmittingViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInSubmittingViewModel$app_citizenProdRelease(CheckInSubmittingViewModel checkInSubmittingViewModel);

    @ViewModelKey(CheckInSuccessViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInSuccessViewModel$app_citizenProdRelease(CheckInSuccessViewModel checkInSuccessViewModel);

    @ViewModelKey(CheckInSummaryViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel checkInSummaryViewModel$app_citizenProdRelease(CheckInSummaryViewModel checkInSummaryViewModel);

    @ViewModelKey(CreateAccountViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel createAccountViewModel$app_citizenProdRelease(CreateAccountViewModel createAccountViewModel);

    @ViewModelKey(EligibilityScannerFragmentViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel eligibilityScannerFragmentViewModel$app_citizenProdRelease(EligibilityScannerFragmentViewModel eligibilityScannerFragmentViewModel);

    @ViewModelKey(FingerprintDialogFragmentViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel fingerprintDialogViewModel$app_citizenProdRelease(FingerprintDialogFragmentViewModel fingerprintDialogFragmentViewModel);

    @ViewModelKey(HarvestJobWizardViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel harvestJobViewModel$app_citizenProdRelease(HarvestJobWizardViewModel harvestJobWizardViewModel);

    @ViewModelKey(HarvestTagViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel harvestTagViewModel$app_citizenProdRelease(HarvestTagViewModel harvestTagViewModel);

    @ViewModelKey(HoldingDetailFragmentViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel holdingDetailFragmentViewModel$app_citizenProdRelease(HoldingDetailFragmentViewModel holdingDetailFragmentViewModel);

    @ViewModelKey(HoldingListFragmentViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel holdingListFragmentViewModel$app_citizenProdRelease(HoldingListFragmentViewModel holdingListFragmentViewModel);

    @ViewModelKey(HomeServicesViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel homeServicesViewModel$app_citizenProdRelease(HomeServicesViewModel homeServicesViewModel);

    @ViewModelKey(IncomingRequestFragmentViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel incomingRequestFragmentViewModel$app_citizenProdRelease(IncomingRequestFragmentViewModel incomingRequestFragmentViewModel);

    @ViewModelKey(LobbyFragmentViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel lobbyFragmentViewModel$app_citizenProdRelease(LobbyFragmentViewModel lobbyFragmentViewModel);

    @ViewModelKey(LoginActivityViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel loginViewModel$app_citizenProdRelease(LoginActivityViewModel loginActivityViewModel);

    @ViewModelKey(MainPagerFragmentViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel mainPagerFragmentViewModel$app_citizenProdRelease(MainPagerFragmentViewModel mainPagerFragmentViewModel);

    @ViewModelKey(MainActivityViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel mainViewModel$app_citizenProdRelease(MainActivityViewModel mainActivityViewModel);

    @ViewModelKey(MoreCardsInfoViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel moreCardsInfoViewModel$app_citizenProdRelease(MoreCardsInfoViewModel moreCardsInfoViewModel);

    @ViewModelKey(NicknameViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel nicknameViewModel$app_citizenProdRelease(NicknameViewModel nicknameViewModel);

    @ViewModelKey(PinActivityViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel pinViewModel$app_citizenProdRelease(PinActivityViewModel pinActivityViewModel);

    @ViewModelKey(RegisterSuccessViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel registerSuccessViewModel$app_citizenProdRelease(RegisterSuccessViewModel registerSuccessViewModel);

    @ViewModelKey(ServiceCategoryTransactionsViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel serviceCategoryTransactionsViewModel$app_citizenProdRelease(ServiceCategoryTransactionsViewModel serviceCategoryTransactionsViewModel);

    @ViewModelKey(ServiceDetailFragmentViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel serviceDetailFragmentViewModel$app_citizenProdRelease(ServiceDetailFragmentViewModel serviceDetailFragmentViewModel);

    @ViewModelKey(ServiceGroupCategoriesViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel serviceGroupCategoriesViewModel$app_citizenProdRelease(ServiceGroupCategoriesViewModel serviceGroupCategoriesViewModel);

    @ViewModelKey(SharingHistoryFragmentViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel sharingHistoryFragmentViewModel$app_citizenProdRelease(SharingHistoryFragmentViewModel sharingHistoryFragmentViewModel);

    @ViewModelKey(SplashViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel splashViewModel$app_citizenProdRelease(SplashViewModel splashViewModel);

    @ViewModelKey(TransactionHistoryFragmentViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel transactionHistoryFragmentViewModel$app_citizenProdRelease(TransactionHistoryFragmentViewModel transactionHistoryFragmentViewModel);

    @ViewModelKey(VerifyEmailViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel verifyEmailViewModel$app_citizenProdRelease(VerifyEmailViewModel verifyEmailViewModel);
}
