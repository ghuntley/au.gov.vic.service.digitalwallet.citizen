package com.digitalwallet.di;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.digitalwallet.DigitalWalletApplication;
import com.digitalwallet.DigitalWalletApplication_MembersInjector;
import com.digitalwallet.api.CheckInApi;
import com.digitalwallet.di.BaseSupportFragmentModule_ContributeCheckInAddDependantInputFragment;
import com.digitalwallet.di.BaseSupportFragmentModule_ContributeCheckInEditPersonInputFragment;
import com.digitalwallet.di.BaseSupportFragmentModule_ContributeCheckInFeedbackFragment;
import com.digitalwallet.di.BaseSupportFragmentModule_ContributeCheckInFeedbackSuccessFragment;
import com.digitalwallet.di.BaseSupportFragmentModule_ContributeCheckInHistoryDetailFragment;
import com.digitalwallet.di.BaseSupportFragmentModule_ContributeCheckInOverviewFragment;
import com.digitalwallet.di.BaseSupportFragmentModule_ContributeCheckInPrimaryInputFragment;
import com.digitalwallet.di.BaseSupportFragmentModule_ContributeCheckInScannerFragment;
import com.digitalwallet.di.BaseSupportFragmentModule_ContributeCheckInShortcutFragment;
import com.digitalwallet.di.BaseSupportFragmentModule_ContributeCheckInSubmittingFragment;
import com.digitalwallet.di.BaseSupportFragmentModule_ContributeCheckInSuccessFragment;
import com.digitalwallet.di.BaseSupportFragmentModule_ContributeCheckInSummaryFragment;
import com.digitalwallet.services.RemoteConfigService;
import com.digitalwallet.services.ScannerViewService;
import com.digitalwallet.utilities.AnalyticsHelper;
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
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInSharedPreferences;
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

public final class DaggerBaseComponent implements BaseComponent {
    private Provider<Context> bindContextProvider;
    private Provider<BaseSupportFragmentModule_ContributeCheckInAddDependantInputFragment.CheckInAddDependantInputFragmentSubcomponent.Factory> checkInAddDependantInputFragmentSubcomponentFactoryProvider;
    private Provider<BaseSupportFragmentModule_ContributeCheckInEditPersonInputFragment.CheckInEditPersonInputFragmentSubcomponent.Factory> checkInEditPersonInputFragmentSubcomponentFactoryProvider;
    private Provider<BaseSupportFragmentModule_ContributeCheckInFeedbackFragment.CheckInFeedbackFragmentSubcomponent.Factory> checkInFeedbackFragmentSubcomponentFactoryProvider;
    private Provider<BaseSupportFragmentModule_ContributeCheckInFeedbackSuccessFragment.CheckInFeedbackSuccessFragmentSubcomponent.Factory> checkInFeedbackSuccessFragmentSubcomponentFactoryProvider;
    private Provider<BaseSupportFragmentModule_ContributeCheckInHistoryDetailFragment.CheckInHistoryDetailFragmentSubcomponent.Factory> checkInHistoryDetailFragmentSubcomponentFactoryProvider;
    private Provider<BaseSupportFragmentModule_ContributeCheckInOverviewFragment.CheckInOverviewFragmentSubcomponent.Factory> checkInOverviewFragmentSubcomponentFactoryProvider;
    private Provider<BaseSupportFragmentModule_ContributeCheckInPrimaryInputFragment.CheckInPrimaryInputFragmentSubcomponent.Factory> checkInPrimaryInputFragmentSubcomponentFactoryProvider;
    private Provider<BaseSupportFragmentModule_ContributeCheckInScannerFragment.CheckInScannerFragmentSubcomponent.Factory> checkInScannerFragmentSubcomponentFactoryProvider;
    private Provider<BaseSupportFragmentModule_ContributeCheckInShortcutFragment.CheckInShortcutFragmentSubcomponent.Factory> checkInShortcutFragmentSubcomponentFactoryProvider;
    private Provider<BaseSupportFragmentModule_ContributeCheckInSubmittingFragment.CheckInSubmittingFragmentSubcomponent.Factory> checkInSubmittingFragmentSubcomponentFactoryProvider;
    private Provider<BaseSupportFragmentModule_ContributeCheckInSuccessFragment.CheckInSuccessFragmentSubcomponent.Factory> checkInSuccessFragmentSubcomponentFactoryProvider;
    private Provider<BaseSupportFragmentModule_ContributeCheckInSummaryFragment.CheckInSummaryFragmentSubcomponent.Factory> checkInSummaryFragmentSubcomponentFactoryProvider;
    private Provider<AnalyticsHelper> provideAnalyticsProvider;
    private Provider<Application> provideApplicationProvider;
    private Provider<CheckInApi> provideCheckInApiProvider;
    private Provider<CheckInRepository> provideCheckInRepositoryProvider;
    private Provider<CheckInSharedPreferences> provideCheckInSharedPreferencesProvider;
    private Provider<DigitalWalletApplication> provideDigitalWalletApplicationProvider;
    private Provider<Cache> provideHttpCacheProvider;
    private Provider<Moshi> provideMoshiProvider;
    private Provider<OkHttpClient> provideOkHttpProvider;
    private Provider<RemoteConfigService> provideRemoteConfigServiceProvider;
    private Provider<ScannerViewService> provideScannerViewServiceProvider;

    private DaggerBaseComponent(BaseModule baseModule, BaseApiModule baseApiModule) {
        initialize(baseModule, baseApiModule);
    }

    public static Builder builder() {
        return new Builder();
    }

    private Map<Class<?>, Provider<AndroidInjector.Factory<?>>> getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf() {
        return MapBuilder.newMapBuilder(12).put(CheckInOverviewFragment.class, this.checkInOverviewFragmentSubcomponentFactoryProvider).put(CheckInPrimaryInputFragment.class, this.checkInPrimaryInputFragmentSubcomponentFactoryProvider).put(CheckInAddDependantInputFragment.class, this.checkInAddDependantInputFragmentSubcomponentFactoryProvider).put(CheckInSummaryFragment.class, this.checkInSummaryFragmentSubcomponentFactoryProvider).put(CheckInEditPersonInputFragment.class, this.checkInEditPersonInputFragmentSubcomponentFactoryProvider).put(CheckInSubmittingFragment.class, this.checkInSubmittingFragmentSubcomponentFactoryProvider).put(CheckInSuccessFragment.class, this.checkInSuccessFragmentSubcomponentFactoryProvider).put(CheckInScannerFragment.class, this.checkInScannerFragmentSubcomponentFactoryProvider).put(CheckInHistoryDetailFragment.class, this.checkInHistoryDetailFragmentSubcomponentFactoryProvider).put(CheckInFeedbackFragment.class, this.checkInFeedbackFragmentSubcomponentFactoryProvider).put(CheckInFeedbackSuccessFragment.class, this.checkInFeedbackSuccessFragmentSubcomponentFactoryProvider).put(CheckInShortcutFragment.class, this.checkInShortcutFragmentSubcomponentFactoryProvider).build();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private DispatchingAndroidInjector<Object> getDispatchingAndroidInjectorOfObject() {
        return DispatchingAndroidInjector_Factory.newInstance(getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), Collections.emptyMap());
    }

    private void initialize(BaseModule baseModule, BaseApiModule baseApiModule) {
        this.checkInOverviewFragmentSubcomponentFactoryProvider = new Provider<BaseSupportFragmentModule_ContributeCheckInOverviewFragment.CheckInOverviewFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.di.DaggerBaseComponent.AnonymousClass1 */

            @Override // javax.inject.Provider
            public BaseSupportFragmentModule_ContributeCheckInOverviewFragment.CheckInOverviewFragmentSubcomponent.Factory get() {
                return new CheckInOverviewFragmentSubcomponentFactory();
            }
        };
        this.checkInPrimaryInputFragmentSubcomponentFactoryProvider = new Provider<BaseSupportFragmentModule_ContributeCheckInPrimaryInputFragment.CheckInPrimaryInputFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.di.DaggerBaseComponent.AnonymousClass2 */

            @Override // javax.inject.Provider
            public BaseSupportFragmentModule_ContributeCheckInPrimaryInputFragment.CheckInPrimaryInputFragmentSubcomponent.Factory get() {
                return new CheckInPrimaryInputFragmentSubcomponentFactory();
            }
        };
        this.checkInAddDependantInputFragmentSubcomponentFactoryProvider = new Provider<BaseSupportFragmentModule_ContributeCheckInAddDependantInputFragment.CheckInAddDependantInputFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.di.DaggerBaseComponent.AnonymousClass3 */

            @Override // javax.inject.Provider
            public BaseSupportFragmentModule_ContributeCheckInAddDependantInputFragment.CheckInAddDependantInputFragmentSubcomponent.Factory get() {
                return new CheckInAddDependantInputFragmentSubcomponentFactory();
            }
        };
        this.checkInSummaryFragmentSubcomponentFactoryProvider = new Provider<BaseSupportFragmentModule_ContributeCheckInSummaryFragment.CheckInSummaryFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.di.DaggerBaseComponent.AnonymousClass4 */

            @Override // javax.inject.Provider
            public BaseSupportFragmentModule_ContributeCheckInSummaryFragment.CheckInSummaryFragmentSubcomponent.Factory get() {
                return new CheckInSummaryFragmentSubcomponentFactory();
            }
        };
        this.checkInEditPersonInputFragmentSubcomponentFactoryProvider = new Provider<BaseSupportFragmentModule_ContributeCheckInEditPersonInputFragment.CheckInEditPersonInputFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.di.DaggerBaseComponent.AnonymousClass5 */

            @Override // javax.inject.Provider
            public BaseSupportFragmentModule_ContributeCheckInEditPersonInputFragment.CheckInEditPersonInputFragmentSubcomponent.Factory get() {
                return new CheckInEditPersonInputFragmentSubcomponentFactory();
            }
        };
        this.checkInSubmittingFragmentSubcomponentFactoryProvider = new Provider<BaseSupportFragmentModule_ContributeCheckInSubmittingFragment.CheckInSubmittingFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.di.DaggerBaseComponent.AnonymousClass6 */

            @Override // javax.inject.Provider
            public BaseSupportFragmentModule_ContributeCheckInSubmittingFragment.CheckInSubmittingFragmentSubcomponent.Factory get() {
                return new CheckInSubmittingFragmentSubcomponentFactory();
            }
        };
        this.checkInSuccessFragmentSubcomponentFactoryProvider = new Provider<BaseSupportFragmentModule_ContributeCheckInSuccessFragment.CheckInSuccessFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.di.DaggerBaseComponent.AnonymousClass7 */

            @Override // javax.inject.Provider
            public BaseSupportFragmentModule_ContributeCheckInSuccessFragment.CheckInSuccessFragmentSubcomponent.Factory get() {
                return new CheckInSuccessFragmentSubcomponentFactory();
            }
        };
        this.checkInScannerFragmentSubcomponentFactoryProvider = new Provider<BaseSupportFragmentModule_ContributeCheckInScannerFragment.CheckInScannerFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.di.DaggerBaseComponent.AnonymousClass8 */

            @Override // javax.inject.Provider
            public BaseSupportFragmentModule_ContributeCheckInScannerFragment.CheckInScannerFragmentSubcomponent.Factory get() {
                return new CheckInScannerFragmentSubcomponentFactory();
            }
        };
        this.checkInHistoryDetailFragmentSubcomponentFactoryProvider = new Provider<BaseSupportFragmentModule_ContributeCheckInHistoryDetailFragment.CheckInHistoryDetailFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.di.DaggerBaseComponent.AnonymousClass9 */

            @Override // javax.inject.Provider
            public BaseSupportFragmentModule_ContributeCheckInHistoryDetailFragment.CheckInHistoryDetailFragmentSubcomponent.Factory get() {
                return new CheckInHistoryDetailFragmentSubcomponentFactory();
            }
        };
        this.checkInFeedbackFragmentSubcomponentFactoryProvider = new Provider<BaseSupportFragmentModule_ContributeCheckInFeedbackFragment.CheckInFeedbackFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.di.DaggerBaseComponent.AnonymousClass10 */

            @Override // javax.inject.Provider
            public BaseSupportFragmentModule_ContributeCheckInFeedbackFragment.CheckInFeedbackFragmentSubcomponent.Factory get() {
                return new CheckInFeedbackFragmentSubcomponentFactory();
            }
        };
        this.checkInFeedbackSuccessFragmentSubcomponentFactoryProvider = new Provider<BaseSupportFragmentModule_ContributeCheckInFeedbackSuccessFragment.CheckInFeedbackSuccessFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.di.DaggerBaseComponent.AnonymousClass11 */

            @Override // javax.inject.Provider
            public BaseSupportFragmentModule_ContributeCheckInFeedbackSuccessFragment.CheckInFeedbackSuccessFragmentSubcomponent.Factory get() {
                return new CheckInFeedbackSuccessFragmentSubcomponentFactory();
            }
        };
        this.checkInShortcutFragmentSubcomponentFactoryProvider = new Provider<BaseSupportFragmentModule_ContributeCheckInShortcutFragment.CheckInShortcutFragmentSubcomponent.Factory>() {
            /* class com.digitalwallet.di.DaggerBaseComponent.AnonymousClass12 */

            @Override // javax.inject.Provider
            public BaseSupportFragmentModule_ContributeCheckInShortcutFragment.CheckInShortcutFragmentSubcomponent.Factory get() {
                return new CheckInShortcutFragmentSubcomponentFactory();
            }
        };
        Provider<Application> provider = DoubleCheck.provider(BaseModule_ProvideApplicationFactory.create(baseModule));
        this.provideApplicationProvider = provider;
        this.bindContextProvider = DoubleCheck.provider(BaseModule_BindContextFactory.create(baseModule, provider));
        this.provideDigitalWalletApplicationProvider = DoubleCheck.provider(BaseModule_ProvideDigitalWalletApplicationFactory.create(baseModule));
        this.provideAnalyticsProvider = DoubleCheck.provider(BaseModule_ProvideAnalyticsFactory.create(baseModule, this.bindContextProvider));
        this.provideMoshiProvider = DoubleCheck.provider(BaseApiModule_ProvideMoshiFactory.create(baseApiModule));
        Provider<Cache> provider2 = DoubleCheck.provider(BaseApiModule_ProvideHttpCacheFactory.create(baseApiModule, this.provideApplicationProvider));
        this.provideHttpCacheProvider = provider2;
        Provider<OkHttpClient> provider3 = DoubleCheck.provider(BaseApiModule_ProvideOkHttpFactory.create(baseApiModule, provider2));
        this.provideOkHttpProvider = provider3;
        this.provideCheckInApiProvider = DoubleCheck.provider(BaseApiModule_ProvideCheckInApiFactory.create(baseApiModule, provider3, this.provideMoshiProvider));
        this.provideRemoteConfigServiceProvider = DoubleCheck.provider(BaseApiModule_ProvideRemoteConfigServiceFactory.create(baseApiModule, this.provideOkHttpProvider, this.provideMoshiProvider));
        this.provideScannerViewServiceProvider = DoubleCheck.provider(BaseModule_ProvideScannerViewServiceFactory.create(baseModule, this.bindContextProvider));
        Provider<CheckInSharedPreferences> provider4 = DoubleCheck.provider(BaseModule_ProvideCheckInSharedPreferencesFactory.create(baseModule, this.bindContextProvider, this.provideMoshiProvider));
        this.provideCheckInSharedPreferencesProvider = provider4;
        this.provideCheckInRepositoryProvider = DoubleCheck.provider(BaseModule_ProvideCheckInRepositoryFactory.create(baseModule, this.bindContextProvider, this.provideMoshiProvider, this.provideCheckInApiProvider, provider4, this.provideAnalyticsProvider));
    }

    @Override // com.digitalwallet.di.BaseComponent
    public void inject(DigitalWalletApplication digitalWalletApplication) {
        injectDigitalWalletApplication(digitalWalletApplication);
    }

    @Override // com.digitalwallet.di.BaseComponent
    public Context context() {
        return this.bindContextProvider.get();
    }

    @Override // com.digitalwallet.di.BaseComponent
    public Application application() {
        return this.provideApplicationProvider.get();
    }

    @Override // com.digitalwallet.di.BaseComponent
    public DigitalWalletApplication digitalWalletApplication() {
        return this.provideDigitalWalletApplicationProvider.get();
    }

    @Override // com.digitalwallet.di.BaseComponent
    public AnalyticsHelper analytics() {
        return this.provideAnalyticsProvider.get();
    }

    @Override // com.digitalwallet.di.BaseComponent
    public Moshi moshi() {
        return this.provideMoshiProvider.get();
    }

    @Override // com.digitalwallet.di.BaseComponent
    public Cache httpCache() {
        return this.provideHttpCacheProvider.get();
    }

    @Override // com.digitalwallet.di.BaseComponent
    public CheckInApi checkInApi() {
        return this.provideCheckInApiProvider.get();
    }

    @Override // com.digitalwallet.di.BaseComponent
    public OkHttpClient okHttpClient() {
        return this.provideOkHttpProvider.get();
    }

    @Override // com.digitalwallet.di.BaseComponent
    public RemoteConfigService remoteConfigService() {
        return this.provideRemoteConfigServiceProvider.get();
    }

    @Override // com.digitalwallet.di.BaseComponent
    public ScannerViewService scannerViewService() {
        return this.provideScannerViewServiceProvider.get();
    }

    @Override // com.digitalwallet.di.BaseComponent
    public CheckInRepository checkInRepository() {
        return this.provideCheckInRepositoryProvider.get();
    }

    private DigitalWalletApplication injectDigitalWalletApplication(DigitalWalletApplication digitalWalletApplication) {
        DigitalWalletApplication_MembersInjector.injectAndroidInjector(digitalWalletApplication, getDispatchingAndroidInjectorOfObject());
        return digitalWalletApplication;
    }

    public static final class Builder {
        private BaseApiModule baseApiModule;
        private BaseModule baseModule;

        private Builder() {
        }

        public Builder baseModule(BaseModule baseModule2) {
            this.baseModule = (BaseModule) Preconditions.checkNotNull(baseModule2);
            return this;
        }

        public Builder baseApiModule(BaseApiModule baseApiModule2) {
            this.baseApiModule = (BaseApiModule) Preconditions.checkNotNull(baseApiModule2);
            return this;
        }

        public BaseComponent build() {
            Preconditions.checkBuilderRequirement(this.baseModule, BaseModule.class);
            if (this.baseApiModule == null) {
                this.baseApiModule = new BaseApiModule();
            }
            return new DaggerBaseComponent(this.baseModule, this.baseApiModule);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInOverviewFragmentSubcomponentFactory implements BaseSupportFragmentModule_ContributeCheckInOverviewFragment.CheckInOverviewFragmentSubcomponent.Factory {
        private CheckInOverviewFragmentSubcomponentFactory() {
        }

        public BaseSupportFragmentModule_ContributeCheckInOverviewFragment.CheckInOverviewFragmentSubcomponent create(CheckInOverviewFragment checkInOverviewFragment) {
            Preconditions.checkNotNull(checkInOverviewFragment);
            return new CheckInOverviewFragmentSubcomponentImpl(checkInOverviewFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInOverviewFragmentSubcomponentImpl implements BaseSupportFragmentModule_ContributeCheckInOverviewFragment.CheckInOverviewFragmentSubcomponent {
        private Provider<CheckInAddDependantInputViewModel> checkInAddDependantInputViewModelProvider;
        private Provider<CheckInEditPersonInputViewModel> checkInEditPersonInputViewModelProvider;
        private Provider<CheckInFeedbackSuccessViewModel> checkInFeedbackSuccessViewModelProvider;
        private Provider<CheckInFeedbackViewModel> checkInFeedbackViewModelProvider;
        private Provider<CheckInHistoryDetailViewModel> checkInHistoryDetailViewModelProvider;
        private Provider<CheckInOverviewViewModel> checkInOverviewViewModelProvider;
        private Provider<CheckInPrimaryInputViewModel> checkInPrimaryInputViewModelProvider;
        private Provider<CheckInScannerViewModel> checkInScannerViewModelProvider;
        private Provider<CheckInShortcutViewModel> checkInShortcutViewModelProvider;
        private Provider<CheckInSubmittingViewModel> checkInSubmittingViewModelProvider;
        private Provider<CheckInSuccessViewModel> checkInSuccessViewModelProvider;
        private Provider<CheckInSummaryViewModel> checkInSummaryViewModelProvider;

        private CheckInOverviewFragmentSubcomponentImpl(CheckInOverviewFragment checkInOverviewFragment) {
            initialize(checkInOverviewFragment);
        }

        private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel() {
            return MapBuilder.newMapBuilder(12).put(CheckInOverviewViewModel.class, this.checkInOverviewViewModelProvider).put(CheckInPrimaryInputViewModel.class, this.checkInPrimaryInputViewModelProvider).put(CheckInAddDependantInputViewModel.class, this.checkInAddDependantInputViewModelProvider).put(CheckInSummaryViewModel.class, this.checkInSummaryViewModelProvider).put(CheckInEditPersonInputViewModel.class, this.checkInEditPersonInputViewModelProvider).put(CheckInSubmittingViewModel.class, this.checkInSubmittingViewModelProvider).put(CheckInSuccessViewModel.class, this.checkInSuccessViewModelProvider).put(CheckInScannerViewModel.class, this.checkInScannerViewModelProvider).put(CheckInHistoryDetailViewModel.class, this.checkInHistoryDetailViewModelProvider).put(CheckInFeedbackViewModel.class, this.checkInFeedbackViewModelProvider).put(CheckInFeedbackSuccessViewModel.class, this.checkInFeedbackSuccessViewModelProvider).put(CheckInShortcutViewModel.class, this.checkInShortcutViewModelProvider).build();
        }

        private ViewModelFactory getViewModelFactory() {
            return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
        }

        private CheckInOverviewViewModel getCheckInOverviewViewModel() {
            return new CheckInOverviewViewModel((Context) DaggerBaseComponent.this.bindContextProvider.get(), (CheckInRepository) DaggerBaseComponent.this.provideCheckInRepositoryProvider.get());
        }

        private void initialize(CheckInOverviewFragment checkInOverviewFragment) {
            this.checkInOverviewViewModelProvider = CheckInOverviewViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInPrimaryInputViewModelProvider = CheckInPrimaryInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInAddDependantInputViewModelProvider = CheckInAddDependantInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSummaryViewModelProvider = CheckInSummaryViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInEditPersonInputViewModelProvider = CheckInEditPersonInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSubmittingViewModelProvider = CheckInSubmittingViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSuccessViewModelProvider = CheckInSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInScannerViewModelProvider = CheckInScannerViewModel_Factory.create(DaggerBaseComponent.this.provideScannerViewServiceProvider, DaggerBaseComponent.this.provideMoshiProvider, DaggerBaseComponent.this.provideOkHttpProvider, DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInHistoryDetailViewModelProvider = CheckInHistoryDetailViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInFeedbackViewModelProvider = CheckInFeedbackViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInFeedbackSuccessViewModelProvider = CheckInFeedbackSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInShortcutViewModelProvider = CheckInShortcutViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
        }

        public void inject(CheckInOverviewFragment checkInOverviewFragment) {
            injectCheckInOverviewFragment(checkInOverviewFragment);
        }

        private CheckInOverviewFragment injectCheckInOverviewFragment(CheckInOverviewFragment checkInOverviewFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInOverviewFragment, DaggerBaseComponent.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInOverviewFragment, getViewModelFactory());
            CheckInOverviewFragment_MembersInjector.injectViewModel(checkInOverviewFragment, getCheckInOverviewViewModel());
            return checkInOverviewFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInPrimaryInputFragmentSubcomponentFactory implements BaseSupportFragmentModule_ContributeCheckInPrimaryInputFragment.CheckInPrimaryInputFragmentSubcomponent.Factory {
        private CheckInPrimaryInputFragmentSubcomponentFactory() {
        }

        public BaseSupportFragmentModule_ContributeCheckInPrimaryInputFragment.CheckInPrimaryInputFragmentSubcomponent create(CheckInPrimaryInputFragment checkInPrimaryInputFragment) {
            Preconditions.checkNotNull(checkInPrimaryInputFragment);
            return new CheckInPrimaryInputFragmentSubcomponentImpl(checkInPrimaryInputFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInPrimaryInputFragmentSubcomponentImpl implements BaseSupportFragmentModule_ContributeCheckInPrimaryInputFragment.CheckInPrimaryInputFragmentSubcomponent {
        private Provider<CheckInAddDependantInputViewModel> checkInAddDependantInputViewModelProvider;
        private Provider<CheckInEditPersonInputViewModel> checkInEditPersonInputViewModelProvider;
        private Provider<CheckInFeedbackSuccessViewModel> checkInFeedbackSuccessViewModelProvider;
        private Provider<CheckInFeedbackViewModel> checkInFeedbackViewModelProvider;
        private Provider<CheckInHistoryDetailViewModel> checkInHistoryDetailViewModelProvider;
        private Provider<CheckInOverviewViewModel> checkInOverviewViewModelProvider;
        private Provider<CheckInPrimaryInputViewModel> checkInPrimaryInputViewModelProvider;
        private Provider<CheckInScannerViewModel> checkInScannerViewModelProvider;
        private Provider<CheckInShortcutViewModel> checkInShortcutViewModelProvider;
        private Provider<CheckInSubmittingViewModel> checkInSubmittingViewModelProvider;
        private Provider<CheckInSuccessViewModel> checkInSuccessViewModelProvider;
        private Provider<CheckInSummaryViewModel> checkInSummaryViewModelProvider;

        private CheckInPrimaryInputFragmentSubcomponentImpl(CheckInPrimaryInputFragment checkInPrimaryInputFragment) {
            initialize(checkInPrimaryInputFragment);
        }

        private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel() {
            return MapBuilder.newMapBuilder(12).put(CheckInOverviewViewModel.class, this.checkInOverviewViewModelProvider).put(CheckInPrimaryInputViewModel.class, this.checkInPrimaryInputViewModelProvider).put(CheckInAddDependantInputViewModel.class, this.checkInAddDependantInputViewModelProvider).put(CheckInSummaryViewModel.class, this.checkInSummaryViewModelProvider).put(CheckInEditPersonInputViewModel.class, this.checkInEditPersonInputViewModelProvider).put(CheckInSubmittingViewModel.class, this.checkInSubmittingViewModelProvider).put(CheckInSuccessViewModel.class, this.checkInSuccessViewModelProvider).put(CheckInScannerViewModel.class, this.checkInScannerViewModelProvider).put(CheckInHistoryDetailViewModel.class, this.checkInHistoryDetailViewModelProvider).put(CheckInFeedbackViewModel.class, this.checkInFeedbackViewModelProvider).put(CheckInFeedbackSuccessViewModel.class, this.checkInFeedbackSuccessViewModelProvider).put(CheckInShortcutViewModel.class, this.checkInShortcutViewModelProvider).build();
        }

        private ViewModelFactory getViewModelFactory() {
            return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
        }

        private CheckInPrimaryInputViewModel getCheckInPrimaryInputViewModel() {
            return new CheckInPrimaryInputViewModel((CheckInRepository) DaggerBaseComponent.this.provideCheckInRepositoryProvider.get(), (AnalyticsHelper) DaggerBaseComponent.this.provideAnalyticsProvider.get());
        }

        private void initialize(CheckInPrimaryInputFragment checkInPrimaryInputFragment) {
            this.checkInOverviewViewModelProvider = CheckInOverviewViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInPrimaryInputViewModelProvider = CheckInPrimaryInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInAddDependantInputViewModelProvider = CheckInAddDependantInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSummaryViewModelProvider = CheckInSummaryViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInEditPersonInputViewModelProvider = CheckInEditPersonInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSubmittingViewModelProvider = CheckInSubmittingViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSuccessViewModelProvider = CheckInSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInScannerViewModelProvider = CheckInScannerViewModel_Factory.create(DaggerBaseComponent.this.provideScannerViewServiceProvider, DaggerBaseComponent.this.provideMoshiProvider, DaggerBaseComponent.this.provideOkHttpProvider, DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInHistoryDetailViewModelProvider = CheckInHistoryDetailViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInFeedbackViewModelProvider = CheckInFeedbackViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInFeedbackSuccessViewModelProvider = CheckInFeedbackSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInShortcutViewModelProvider = CheckInShortcutViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
        }

        public void inject(CheckInPrimaryInputFragment checkInPrimaryInputFragment) {
            injectCheckInPrimaryInputFragment(checkInPrimaryInputFragment);
        }

        private CheckInPrimaryInputFragment injectCheckInPrimaryInputFragment(CheckInPrimaryInputFragment checkInPrimaryInputFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInPrimaryInputFragment, DaggerBaseComponent.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInPrimaryInputFragment, getViewModelFactory());
            CheckInPrimaryInputFragment_MembersInjector.injectViewModel(checkInPrimaryInputFragment, getCheckInPrimaryInputViewModel());
            return checkInPrimaryInputFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInAddDependantInputFragmentSubcomponentFactory implements BaseSupportFragmentModule_ContributeCheckInAddDependantInputFragment.CheckInAddDependantInputFragmentSubcomponent.Factory {
        private CheckInAddDependantInputFragmentSubcomponentFactory() {
        }

        public BaseSupportFragmentModule_ContributeCheckInAddDependantInputFragment.CheckInAddDependantInputFragmentSubcomponent create(CheckInAddDependantInputFragment checkInAddDependantInputFragment) {
            Preconditions.checkNotNull(checkInAddDependantInputFragment);
            return new CheckInAddDependantInputFragmentSubcomponentImpl(checkInAddDependantInputFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInAddDependantInputFragmentSubcomponentImpl implements BaseSupportFragmentModule_ContributeCheckInAddDependantInputFragment.CheckInAddDependantInputFragmentSubcomponent {
        private Provider<CheckInAddDependantInputViewModel> checkInAddDependantInputViewModelProvider;
        private Provider<CheckInEditPersonInputViewModel> checkInEditPersonInputViewModelProvider;
        private Provider<CheckInFeedbackSuccessViewModel> checkInFeedbackSuccessViewModelProvider;
        private Provider<CheckInFeedbackViewModel> checkInFeedbackViewModelProvider;
        private Provider<CheckInHistoryDetailViewModel> checkInHistoryDetailViewModelProvider;
        private Provider<CheckInOverviewViewModel> checkInOverviewViewModelProvider;
        private Provider<CheckInPrimaryInputViewModel> checkInPrimaryInputViewModelProvider;
        private Provider<CheckInScannerViewModel> checkInScannerViewModelProvider;
        private Provider<CheckInShortcutViewModel> checkInShortcutViewModelProvider;
        private Provider<CheckInSubmittingViewModel> checkInSubmittingViewModelProvider;
        private Provider<CheckInSuccessViewModel> checkInSuccessViewModelProvider;
        private Provider<CheckInSummaryViewModel> checkInSummaryViewModelProvider;

        private CheckInAddDependantInputFragmentSubcomponentImpl(CheckInAddDependantInputFragment checkInAddDependantInputFragment) {
            initialize(checkInAddDependantInputFragment);
        }

        private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel() {
            return MapBuilder.newMapBuilder(12).put(CheckInOverviewViewModel.class, this.checkInOverviewViewModelProvider).put(CheckInPrimaryInputViewModel.class, this.checkInPrimaryInputViewModelProvider).put(CheckInAddDependantInputViewModel.class, this.checkInAddDependantInputViewModelProvider).put(CheckInSummaryViewModel.class, this.checkInSummaryViewModelProvider).put(CheckInEditPersonInputViewModel.class, this.checkInEditPersonInputViewModelProvider).put(CheckInSubmittingViewModel.class, this.checkInSubmittingViewModelProvider).put(CheckInSuccessViewModel.class, this.checkInSuccessViewModelProvider).put(CheckInScannerViewModel.class, this.checkInScannerViewModelProvider).put(CheckInHistoryDetailViewModel.class, this.checkInHistoryDetailViewModelProvider).put(CheckInFeedbackViewModel.class, this.checkInFeedbackViewModelProvider).put(CheckInFeedbackSuccessViewModel.class, this.checkInFeedbackSuccessViewModelProvider).put(CheckInShortcutViewModel.class, this.checkInShortcutViewModelProvider).build();
        }

        private ViewModelFactory getViewModelFactory() {
            return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
        }

        private CheckInAddDependantInputViewModel getCheckInAddDependantInputViewModel() {
            return new CheckInAddDependantInputViewModel((CheckInRepository) DaggerBaseComponent.this.provideCheckInRepositoryProvider.get());
        }

        private void initialize(CheckInAddDependantInputFragment checkInAddDependantInputFragment) {
            this.checkInOverviewViewModelProvider = CheckInOverviewViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInPrimaryInputViewModelProvider = CheckInPrimaryInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInAddDependantInputViewModelProvider = CheckInAddDependantInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSummaryViewModelProvider = CheckInSummaryViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInEditPersonInputViewModelProvider = CheckInEditPersonInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSubmittingViewModelProvider = CheckInSubmittingViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSuccessViewModelProvider = CheckInSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInScannerViewModelProvider = CheckInScannerViewModel_Factory.create(DaggerBaseComponent.this.provideScannerViewServiceProvider, DaggerBaseComponent.this.provideMoshiProvider, DaggerBaseComponent.this.provideOkHttpProvider, DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInHistoryDetailViewModelProvider = CheckInHistoryDetailViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInFeedbackViewModelProvider = CheckInFeedbackViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInFeedbackSuccessViewModelProvider = CheckInFeedbackSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInShortcutViewModelProvider = CheckInShortcutViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
        }

        public void inject(CheckInAddDependantInputFragment checkInAddDependantInputFragment) {
            injectCheckInAddDependantInputFragment(checkInAddDependantInputFragment);
        }

        private CheckInAddDependantInputFragment injectCheckInAddDependantInputFragment(CheckInAddDependantInputFragment checkInAddDependantInputFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInAddDependantInputFragment, DaggerBaseComponent.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInAddDependantInputFragment, getViewModelFactory());
            CheckInAddDependantInputFragment_MembersInjector.injectViewModel(checkInAddDependantInputFragment, getCheckInAddDependantInputViewModel());
            return checkInAddDependantInputFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInSummaryFragmentSubcomponentFactory implements BaseSupportFragmentModule_ContributeCheckInSummaryFragment.CheckInSummaryFragmentSubcomponent.Factory {
        private CheckInSummaryFragmentSubcomponentFactory() {
        }

        public BaseSupportFragmentModule_ContributeCheckInSummaryFragment.CheckInSummaryFragmentSubcomponent create(CheckInSummaryFragment checkInSummaryFragment) {
            Preconditions.checkNotNull(checkInSummaryFragment);
            return new CheckInSummaryFragmentSubcomponentImpl(checkInSummaryFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInSummaryFragmentSubcomponentImpl implements BaseSupportFragmentModule_ContributeCheckInSummaryFragment.CheckInSummaryFragmentSubcomponent {
        private Provider<CheckInAddDependantInputViewModel> checkInAddDependantInputViewModelProvider;
        private Provider<CheckInEditPersonInputViewModel> checkInEditPersonInputViewModelProvider;
        private Provider<CheckInFeedbackSuccessViewModel> checkInFeedbackSuccessViewModelProvider;
        private Provider<CheckInFeedbackViewModel> checkInFeedbackViewModelProvider;
        private Provider<CheckInHistoryDetailViewModel> checkInHistoryDetailViewModelProvider;
        private Provider<CheckInOverviewViewModel> checkInOverviewViewModelProvider;
        private Provider<CheckInPrimaryInputViewModel> checkInPrimaryInputViewModelProvider;
        private Provider<CheckInScannerViewModel> checkInScannerViewModelProvider;
        private Provider<CheckInShortcutViewModel> checkInShortcutViewModelProvider;
        private Provider<CheckInSubmittingViewModel> checkInSubmittingViewModelProvider;
        private Provider<CheckInSuccessViewModel> checkInSuccessViewModelProvider;
        private Provider<CheckInSummaryViewModel> checkInSummaryViewModelProvider;

        private CheckInSummaryFragmentSubcomponentImpl(CheckInSummaryFragment checkInSummaryFragment) {
            initialize(checkInSummaryFragment);
        }

        private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel() {
            return MapBuilder.newMapBuilder(12).put(CheckInOverviewViewModel.class, this.checkInOverviewViewModelProvider).put(CheckInPrimaryInputViewModel.class, this.checkInPrimaryInputViewModelProvider).put(CheckInAddDependantInputViewModel.class, this.checkInAddDependantInputViewModelProvider).put(CheckInSummaryViewModel.class, this.checkInSummaryViewModelProvider).put(CheckInEditPersonInputViewModel.class, this.checkInEditPersonInputViewModelProvider).put(CheckInSubmittingViewModel.class, this.checkInSubmittingViewModelProvider).put(CheckInSuccessViewModel.class, this.checkInSuccessViewModelProvider).put(CheckInScannerViewModel.class, this.checkInScannerViewModelProvider).put(CheckInHistoryDetailViewModel.class, this.checkInHistoryDetailViewModelProvider).put(CheckInFeedbackViewModel.class, this.checkInFeedbackViewModelProvider).put(CheckInFeedbackSuccessViewModel.class, this.checkInFeedbackSuccessViewModelProvider).put(CheckInShortcutViewModel.class, this.checkInShortcutViewModelProvider).build();
        }

        private ViewModelFactory getViewModelFactory() {
            return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
        }

        private CheckInSummaryViewModel getCheckInSummaryViewModel() {
            return new CheckInSummaryViewModel((Context) DaggerBaseComponent.this.bindContextProvider.get(), (CheckInRepository) DaggerBaseComponent.this.provideCheckInRepositoryProvider.get(), (AnalyticsHelper) DaggerBaseComponent.this.provideAnalyticsProvider.get());
        }

        private void initialize(CheckInSummaryFragment checkInSummaryFragment) {
            this.checkInOverviewViewModelProvider = CheckInOverviewViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInPrimaryInputViewModelProvider = CheckInPrimaryInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInAddDependantInputViewModelProvider = CheckInAddDependantInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSummaryViewModelProvider = CheckInSummaryViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInEditPersonInputViewModelProvider = CheckInEditPersonInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSubmittingViewModelProvider = CheckInSubmittingViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSuccessViewModelProvider = CheckInSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInScannerViewModelProvider = CheckInScannerViewModel_Factory.create(DaggerBaseComponent.this.provideScannerViewServiceProvider, DaggerBaseComponent.this.provideMoshiProvider, DaggerBaseComponent.this.provideOkHttpProvider, DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInHistoryDetailViewModelProvider = CheckInHistoryDetailViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInFeedbackViewModelProvider = CheckInFeedbackViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInFeedbackSuccessViewModelProvider = CheckInFeedbackSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInShortcutViewModelProvider = CheckInShortcutViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
        }

        public void inject(CheckInSummaryFragment checkInSummaryFragment) {
            injectCheckInSummaryFragment(checkInSummaryFragment);
        }

        private CheckInSummaryFragment injectCheckInSummaryFragment(CheckInSummaryFragment checkInSummaryFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInSummaryFragment, DaggerBaseComponent.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInSummaryFragment, getViewModelFactory());
            CheckInSummaryFragment_MembersInjector.injectViewModel(checkInSummaryFragment, getCheckInSummaryViewModel());
            return checkInSummaryFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInEditPersonInputFragmentSubcomponentFactory implements BaseSupportFragmentModule_ContributeCheckInEditPersonInputFragment.CheckInEditPersonInputFragmentSubcomponent.Factory {
        private CheckInEditPersonInputFragmentSubcomponentFactory() {
        }

        public BaseSupportFragmentModule_ContributeCheckInEditPersonInputFragment.CheckInEditPersonInputFragmentSubcomponent create(CheckInEditPersonInputFragment checkInEditPersonInputFragment) {
            Preconditions.checkNotNull(checkInEditPersonInputFragment);
            return new CheckInEditPersonInputFragmentSubcomponentImpl(checkInEditPersonInputFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInEditPersonInputFragmentSubcomponentImpl implements BaseSupportFragmentModule_ContributeCheckInEditPersonInputFragment.CheckInEditPersonInputFragmentSubcomponent {
        private Provider<CheckInAddDependantInputViewModel> checkInAddDependantInputViewModelProvider;
        private Provider<CheckInEditPersonInputViewModel> checkInEditPersonInputViewModelProvider;
        private Provider<CheckInFeedbackSuccessViewModel> checkInFeedbackSuccessViewModelProvider;
        private Provider<CheckInFeedbackViewModel> checkInFeedbackViewModelProvider;
        private Provider<CheckInHistoryDetailViewModel> checkInHistoryDetailViewModelProvider;
        private Provider<CheckInOverviewViewModel> checkInOverviewViewModelProvider;
        private Provider<CheckInPrimaryInputViewModel> checkInPrimaryInputViewModelProvider;
        private Provider<CheckInScannerViewModel> checkInScannerViewModelProvider;
        private Provider<CheckInShortcutViewModel> checkInShortcutViewModelProvider;
        private Provider<CheckInSubmittingViewModel> checkInSubmittingViewModelProvider;
        private Provider<CheckInSuccessViewModel> checkInSuccessViewModelProvider;
        private Provider<CheckInSummaryViewModel> checkInSummaryViewModelProvider;

        private CheckInEditPersonInputFragmentSubcomponentImpl(CheckInEditPersonInputFragment checkInEditPersonInputFragment) {
            initialize(checkInEditPersonInputFragment);
        }

        private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel() {
            return MapBuilder.newMapBuilder(12).put(CheckInOverviewViewModel.class, this.checkInOverviewViewModelProvider).put(CheckInPrimaryInputViewModel.class, this.checkInPrimaryInputViewModelProvider).put(CheckInAddDependantInputViewModel.class, this.checkInAddDependantInputViewModelProvider).put(CheckInSummaryViewModel.class, this.checkInSummaryViewModelProvider).put(CheckInEditPersonInputViewModel.class, this.checkInEditPersonInputViewModelProvider).put(CheckInSubmittingViewModel.class, this.checkInSubmittingViewModelProvider).put(CheckInSuccessViewModel.class, this.checkInSuccessViewModelProvider).put(CheckInScannerViewModel.class, this.checkInScannerViewModelProvider).put(CheckInHistoryDetailViewModel.class, this.checkInHistoryDetailViewModelProvider).put(CheckInFeedbackViewModel.class, this.checkInFeedbackViewModelProvider).put(CheckInFeedbackSuccessViewModel.class, this.checkInFeedbackSuccessViewModelProvider).put(CheckInShortcutViewModel.class, this.checkInShortcutViewModelProvider).build();
        }

        private ViewModelFactory getViewModelFactory() {
            return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
        }

        private CheckInEditPersonInputViewModel getCheckInEditPersonInputViewModel() {
            return new CheckInEditPersonInputViewModel((CheckInRepository) DaggerBaseComponent.this.provideCheckInRepositoryProvider.get());
        }

        private void initialize(CheckInEditPersonInputFragment checkInEditPersonInputFragment) {
            this.checkInOverviewViewModelProvider = CheckInOverviewViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInPrimaryInputViewModelProvider = CheckInPrimaryInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInAddDependantInputViewModelProvider = CheckInAddDependantInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSummaryViewModelProvider = CheckInSummaryViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInEditPersonInputViewModelProvider = CheckInEditPersonInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSubmittingViewModelProvider = CheckInSubmittingViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSuccessViewModelProvider = CheckInSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInScannerViewModelProvider = CheckInScannerViewModel_Factory.create(DaggerBaseComponent.this.provideScannerViewServiceProvider, DaggerBaseComponent.this.provideMoshiProvider, DaggerBaseComponent.this.provideOkHttpProvider, DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInHistoryDetailViewModelProvider = CheckInHistoryDetailViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInFeedbackViewModelProvider = CheckInFeedbackViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInFeedbackSuccessViewModelProvider = CheckInFeedbackSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInShortcutViewModelProvider = CheckInShortcutViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
        }

        public void inject(CheckInEditPersonInputFragment checkInEditPersonInputFragment) {
            injectCheckInEditPersonInputFragment(checkInEditPersonInputFragment);
        }

        private CheckInEditPersonInputFragment injectCheckInEditPersonInputFragment(CheckInEditPersonInputFragment checkInEditPersonInputFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInEditPersonInputFragment, DaggerBaseComponent.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInEditPersonInputFragment, getViewModelFactory());
            CheckInEditPersonInputFragment_MembersInjector.injectViewModel(checkInEditPersonInputFragment, getCheckInEditPersonInputViewModel());
            return checkInEditPersonInputFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInSubmittingFragmentSubcomponentFactory implements BaseSupportFragmentModule_ContributeCheckInSubmittingFragment.CheckInSubmittingFragmentSubcomponent.Factory {
        private CheckInSubmittingFragmentSubcomponentFactory() {
        }

        public BaseSupportFragmentModule_ContributeCheckInSubmittingFragment.CheckInSubmittingFragmentSubcomponent create(CheckInSubmittingFragment checkInSubmittingFragment) {
            Preconditions.checkNotNull(checkInSubmittingFragment);
            return new CheckInSubmittingFragmentSubcomponentImpl(checkInSubmittingFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInSubmittingFragmentSubcomponentImpl implements BaseSupportFragmentModule_ContributeCheckInSubmittingFragment.CheckInSubmittingFragmentSubcomponent {
        private Provider<CheckInAddDependantInputViewModel> checkInAddDependantInputViewModelProvider;
        private Provider<CheckInEditPersonInputViewModel> checkInEditPersonInputViewModelProvider;
        private Provider<CheckInFeedbackSuccessViewModel> checkInFeedbackSuccessViewModelProvider;
        private Provider<CheckInFeedbackViewModel> checkInFeedbackViewModelProvider;
        private Provider<CheckInHistoryDetailViewModel> checkInHistoryDetailViewModelProvider;
        private Provider<CheckInOverviewViewModel> checkInOverviewViewModelProvider;
        private Provider<CheckInPrimaryInputViewModel> checkInPrimaryInputViewModelProvider;
        private Provider<CheckInScannerViewModel> checkInScannerViewModelProvider;
        private Provider<CheckInShortcutViewModel> checkInShortcutViewModelProvider;
        private Provider<CheckInSubmittingViewModel> checkInSubmittingViewModelProvider;
        private Provider<CheckInSuccessViewModel> checkInSuccessViewModelProvider;
        private Provider<CheckInSummaryViewModel> checkInSummaryViewModelProvider;

        private CheckInSubmittingFragmentSubcomponentImpl(CheckInSubmittingFragment checkInSubmittingFragment) {
            initialize(checkInSubmittingFragment);
        }

        private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel() {
            return MapBuilder.newMapBuilder(12).put(CheckInOverviewViewModel.class, this.checkInOverviewViewModelProvider).put(CheckInPrimaryInputViewModel.class, this.checkInPrimaryInputViewModelProvider).put(CheckInAddDependantInputViewModel.class, this.checkInAddDependantInputViewModelProvider).put(CheckInSummaryViewModel.class, this.checkInSummaryViewModelProvider).put(CheckInEditPersonInputViewModel.class, this.checkInEditPersonInputViewModelProvider).put(CheckInSubmittingViewModel.class, this.checkInSubmittingViewModelProvider).put(CheckInSuccessViewModel.class, this.checkInSuccessViewModelProvider).put(CheckInScannerViewModel.class, this.checkInScannerViewModelProvider).put(CheckInHistoryDetailViewModel.class, this.checkInHistoryDetailViewModelProvider).put(CheckInFeedbackViewModel.class, this.checkInFeedbackViewModelProvider).put(CheckInFeedbackSuccessViewModel.class, this.checkInFeedbackSuccessViewModelProvider).put(CheckInShortcutViewModel.class, this.checkInShortcutViewModelProvider).build();
        }

        private ViewModelFactory getViewModelFactory() {
            return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
        }

        private CheckInSubmittingViewModel getCheckInSubmittingViewModel() {
            return new CheckInSubmittingViewModel((CheckInRepository) DaggerBaseComponent.this.provideCheckInRepositoryProvider.get());
        }

        private void initialize(CheckInSubmittingFragment checkInSubmittingFragment) {
            this.checkInOverviewViewModelProvider = CheckInOverviewViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInPrimaryInputViewModelProvider = CheckInPrimaryInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInAddDependantInputViewModelProvider = CheckInAddDependantInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSummaryViewModelProvider = CheckInSummaryViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInEditPersonInputViewModelProvider = CheckInEditPersonInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSubmittingViewModelProvider = CheckInSubmittingViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSuccessViewModelProvider = CheckInSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInScannerViewModelProvider = CheckInScannerViewModel_Factory.create(DaggerBaseComponent.this.provideScannerViewServiceProvider, DaggerBaseComponent.this.provideMoshiProvider, DaggerBaseComponent.this.provideOkHttpProvider, DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInHistoryDetailViewModelProvider = CheckInHistoryDetailViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInFeedbackViewModelProvider = CheckInFeedbackViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInFeedbackSuccessViewModelProvider = CheckInFeedbackSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInShortcutViewModelProvider = CheckInShortcutViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
        }

        public void inject(CheckInSubmittingFragment checkInSubmittingFragment) {
            injectCheckInSubmittingFragment(checkInSubmittingFragment);
        }

        private CheckInSubmittingFragment injectCheckInSubmittingFragment(CheckInSubmittingFragment checkInSubmittingFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInSubmittingFragment, DaggerBaseComponent.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInSubmittingFragment, getViewModelFactory());
            CheckInSubmittingFragment_MembersInjector.injectViewModel(checkInSubmittingFragment, getCheckInSubmittingViewModel());
            return checkInSubmittingFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInSuccessFragmentSubcomponentFactory implements BaseSupportFragmentModule_ContributeCheckInSuccessFragment.CheckInSuccessFragmentSubcomponent.Factory {
        private CheckInSuccessFragmentSubcomponentFactory() {
        }

        public BaseSupportFragmentModule_ContributeCheckInSuccessFragment.CheckInSuccessFragmentSubcomponent create(CheckInSuccessFragment checkInSuccessFragment) {
            Preconditions.checkNotNull(checkInSuccessFragment);
            return new CheckInSuccessFragmentSubcomponentImpl(checkInSuccessFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInSuccessFragmentSubcomponentImpl implements BaseSupportFragmentModule_ContributeCheckInSuccessFragment.CheckInSuccessFragmentSubcomponent {
        private Provider<CheckInAddDependantInputViewModel> checkInAddDependantInputViewModelProvider;
        private Provider<CheckInEditPersonInputViewModel> checkInEditPersonInputViewModelProvider;
        private Provider<CheckInFeedbackSuccessViewModel> checkInFeedbackSuccessViewModelProvider;
        private Provider<CheckInFeedbackViewModel> checkInFeedbackViewModelProvider;
        private Provider<CheckInHistoryDetailViewModel> checkInHistoryDetailViewModelProvider;
        private Provider<CheckInOverviewViewModel> checkInOverviewViewModelProvider;
        private Provider<CheckInPrimaryInputViewModel> checkInPrimaryInputViewModelProvider;
        private Provider<CheckInScannerViewModel> checkInScannerViewModelProvider;
        private Provider<CheckInShortcutViewModel> checkInShortcutViewModelProvider;
        private Provider<CheckInSubmittingViewModel> checkInSubmittingViewModelProvider;
        private Provider<CheckInSuccessViewModel> checkInSuccessViewModelProvider;
        private Provider<CheckInSummaryViewModel> checkInSummaryViewModelProvider;

        private CheckInSuccessFragmentSubcomponentImpl(CheckInSuccessFragment checkInSuccessFragment) {
            initialize(checkInSuccessFragment);
        }

        private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel() {
            return MapBuilder.newMapBuilder(12).put(CheckInOverviewViewModel.class, this.checkInOverviewViewModelProvider).put(CheckInPrimaryInputViewModel.class, this.checkInPrimaryInputViewModelProvider).put(CheckInAddDependantInputViewModel.class, this.checkInAddDependantInputViewModelProvider).put(CheckInSummaryViewModel.class, this.checkInSummaryViewModelProvider).put(CheckInEditPersonInputViewModel.class, this.checkInEditPersonInputViewModelProvider).put(CheckInSubmittingViewModel.class, this.checkInSubmittingViewModelProvider).put(CheckInSuccessViewModel.class, this.checkInSuccessViewModelProvider).put(CheckInScannerViewModel.class, this.checkInScannerViewModelProvider).put(CheckInHistoryDetailViewModel.class, this.checkInHistoryDetailViewModelProvider).put(CheckInFeedbackViewModel.class, this.checkInFeedbackViewModelProvider).put(CheckInFeedbackSuccessViewModel.class, this.checkInFeedbackSuccessViewModelProvider).put(CheckInShortcutViewModel.class, this.checkInShortcutViewModelProvider).build();
        }

        private ViewModelFactory getViewModelFactory() {
            return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
        }

        private CheckInSuccessViewModel getCheckInSuccessViewModel() {
            return new CheckInSuccessViewModel((Context) DaggerBaseComponent.this.bindContextProvider.get(), (CheckInRepository) DaggerBaseComponent.this.provideCheckInRepositoryProvider.get(), (AnalyticsHelper) DaggerBaseComponent.this.provideAnalyticsProvider.get());
        }

        private void initialize(CheckInSuccessFragment checkInSuccessFragment) {
            this.checkInOverviewViewModelProvider = CheckInOverviewViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInPrimaryInputViewModelProvider = CheckInPrimaryInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInAddDependantInputViewModelProvider = CheckInAddDependantInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSummaryViewModelProvider = CheckInSummaryViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInEditPersonInputViewModelProvider = CheckInEditPersonInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSubmittingViewModelProvider = CheckInSubmittingViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSuccessViewModelProvider = CheckInSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInScannerViewModelProvider = CheckInScannerViewModel_Factory.create(DaggerBaseComponent.this.provideScannerViewServiceProvider, DaggerBaseComponent.this.provideMoshiProvider, DaggerBaseComponent.this.provideOkHttpProvider, DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInHistoryDetailViewModelProvider = CheckInHistoryDetailViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInFeedbackViewModelProvider = CheckInFeedbackViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInFeedbackSuccessViewModelProvider = CheckInFeedbackSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInShortcutViewModelProvider = CheckInShortcutViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
        }

        public void inject(CheckInSuccessFragment checkInSuccessFragment) {
            injectCheckInSuccessFragment(checkInSuccessFragment);
        }

        private CheckInSuccessFragment injectCheckInSuccessFragment(CheckInSuccessFragment checkInSuccessFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInSuccessFragment, DaggerBaseComponent.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInSuccessFragment, getViewModelFactory());
            CheckInSuccessFragment_MembersInjector.injectViewModel(checkInSuccessFragment, getCheckInSuccessViewModel());
            return checkInSuccessFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInScannerFragmentSubcomponentFactory implements BaseSupportFragmentModule_ContributeCheckInScannerFragment.CheckInScannerFragmentSubcomponent.Factory {
        private CheckInScannerFragmentSubcomponentFactory() {
        }

        public BaseSupportFragmentModule_ContributeCheckInScannerFragment.CheckInScannerFragmentSubcomponent create(CheckInScannerFragment checkInScannerFragment) {
            Preconditions.checkNotNull(checkInScannerFragment);
            return new CheckInScannerFragmentSubcomponentImpl(checkInScannerFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInScannerFragmentSubcomponentImpl implements BaseSupportFragmentModule_ContributeCheckInScannerFragment.CheckInScannerFragmentSubcomponent {
        private Provider<CheckInAddDependantInputViewModel> checkInAddDependantInputViewModelProvider;
        private Provider<CheckInEditPersonInputViewModel> checkInEditPersonInputViewModelProvider;
        private Provider<CheckInFeedbackSuccessViewModel> checkInFeedbackSuccessViewModelProvider;
        private Provider<CheckInFeedbackViewModel> checkInFeedbackViewModelProvider;
        private Provider<CheckInHistoryDetailViewModel> checkInHistoryDetailViewModelProvider;
        private Provider<CheckInOverviewViewModel> checkInOverviewViewModelProvider;
        private Provider<CheckInPrimaryInputViewModel> checkInPrimaryInputViewModelProvider;
        private Provider<CheckInScannerViewModel> checkInScannerViewModelProvider;
        private Provider<CheckInShortcutViewModel> checkInShortcutViewModelProvider;
        private Provider<CheckInSubmittingViewModel> checkInSubmittingViewModelProvider;
        private Provider<CheckInSuccessViewModel> checkInSuccessViewModelProvider;
        private Provider<CheckInSummaryViewModel> checkInSummaryViewModelProvider;

        private CheckInScannerFragmentSubcomponentImpl(CheckInScannerFragment checkInScannerFragment) {
            initialize(checkInScannerFragment);
        }

        private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel() {
            return MapBuilder.newMapBuilder(12).put(CheckInOverviewViewModel.class, this.checkInOverviewViewModelProvider).put(CheckInPrimaryInputViewModel.class, this.checkInPrimaryInputViewModelProvider).put(CheckInAddDependantInputViewModel.class, this.checkInAddDependantInputViewModelProvider).put(CheckInSummaryViewModel.class, this.checkInSummaryViewModelProvider).put(CheckInEditPersonInputViewModel.class, this.checkInEditPersonInputViewModelProvider).put(CheckInSubmittingViewModel.class, this.checkInSubmittingViewModelProvider).put(CheckInSuccessViewModel.class, this.checkInSuccessViewModelProvider).put(CheckInScannerViewModel.class, this.checkInScannerViewModelProvider).put(CheckInHistoryDetailViewModel.class, this.checkInHistoryDetailViewModelProvider).put(CheckInFeedbackViewModel.class, this.checkInFeedbackViewModelProvider).put(CheckInFeedbackSuccessViewModel.class, this.checkInFeedbackSuccessViewModelProvider).put(CheckInShortcutViewModel.class, this.checkInShortcutViewModelProvider).build();
        }

        private ViewModelFactory getViewModelFactory() {
            return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
        }

        private CheckInScannerViewModel getCheckInScannerViewModel() {
            return new CheckInScannerViewModel((ScannerViewService) DaggerBaseComponent.this.provideScannerViewServiceProvider.get(), (Moshi) DaggerBaseComponent.this.provideMoshiProvider.get(), (OkHttpClient) DaggerBaseComponent.this.provideOkHttpProvider.get(), (Context) DaggerBaseComponent.this.bindContextProvider.get(), (AnalyticsHelper) DaggerBaseComponent.this.provideAnalyticsProvider.get());
        }

        private void initialize(CheckInScannerFragment checkInScannerFragment) {
            this.checkInOverviewViewModelProvider = CheckInOverviewViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInPrimaryInputViewModelProvider = CheckInPrimaryInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInAddDependantInputViewModelProvider = CheckInAddDependantInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSummaryViewModelProvider = CheckInSummaryViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInEditPersonInputViewModelProvider = CheckInEditPersonInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSubmittingViewModelProvider = CheckInSubmittingViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSuccessViewModelProvider = CheckInSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInScannerViewModelProvider = CheckInScannerViewModel_Factory.create(DaggerBaseComponent.this.provideScannerViewServiceProvider, DaggerBaseComponent.this.provideMoshiProvider, DaggerBaseComponent.this.provideOkHttpProvider, DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInHistoryDetailViewModelProvider = CheckInHistoryDetailViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInFeedbackViewModelProvider = CheckInFeedbackViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInFeedbackSuccessViewModelProvider = CheckInFeedbackSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInShortcutViewModelProvider = CheckInShortcutViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
        }

        public void inject(CheckInScannerFragment checkInScannerFragment) {
            injectCheckInScannerFragment(checkInScannerFragment);
        }

        private CheckInScannerFragment injectCheckInScannerFragment(CheckInScannerFragment checkInScannerFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInScannerFragment, DaggerBaseComponent.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInScannerFragment, getViewModelFactory());
            CheckInScannerFragment_MembersInjector.injectViewModel(checkInScannerFragment, getCheckInScannerViewModel());
            CheckInScannerFragment_MembersInjector.injectCheckInRepository(checkInScannerFragment, (CheckInRepository) DaggerBaseComponent.this.provideCheckInRepositoryProvider.get());
            return checkInScannerFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInHistoryDetailFragmentSubcomponentFactory implements BaseSupportFragmentModule_ContributeCheckInHistoryDetailFragment.CheckInHistoryDetailFragmentSubcomponent.Factory {
        private CheckInHistoryDetailFragmentSubcomponentFactory() {
        }

        public BaseSupportFragmentModule_ContributeCheckInHistoryDetailFragment.CheckInHistoryDetailFragmentSubcomponent create(CheckInHistoryDetailFragment checkInHistoryDetailFragment) {
            Preconditions.checkNotNull(checkInHistoryDetailFragment);
            return new CheckInHistoryDetailFragmentSubcomponentImpl(checkInHistoryDetailFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInHistoryDetailFragmentSubcomponentImpl implements BaseSupportFragmentModule_ContributeCheckInHistoryDetailFragment.CheckInHistoryDetailFragmentSubcomponent {
        private Provider<CheckInAddDependantInputViewModel> checkInAddDependantInputViewModelProvider;
        private Provider<CheckInEditPersonInputViewModel> checkInEditPersonInputViewModelProvider;
        private Provider<CheckInFeedbackSuccessViewModel> checkInFeedbackSuccessViewModelProvider;
        private Provider<CheckInFeedbackViewModel> checkInFeedbackViewModelProvider;
        private Provider<CheckInHistoryDetailViewModel> checkInHistoryDetailViewModelProvider;
        private Provider<CheckInOverviewViewModel> checkInOverviewViewModelProvider;
        private Provider<CheckInPrimaryInputViewModel> checkInPrimaryInputViewModelProvider;
        private Provider<CheckInScannerViewModel> checkInScannerViewModelProvider;
        private Provider<CheckInShortcutViewModel> checkInShortcutViewModelProvider;
        private Provider<CheckInSubmittingViewModel> checkInSubmittingViewModelProvider;
        private Provider<CheckInSuccessViewModel> checkInSuccessViewModelProvider;
        private Provider<CheckInSummaryViewModel> checkInSummaryViewModelProvider;

        private CheckInHistoryDetailFragmentSubcomponentImpl(CheckInHistoryDetailFragment checkInHistoryDetailFragment) {
            initialize(checkInHistoryDetailFragment);
        }

        private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel() {
            return MapBuilder.newMapBuilder(12).put(CheckInOverviewViewModel.class, this.checkInOverviewViewModelProvider).put(CheckInPrimaryInputViewModel.class, this.checkInPrimaryInputViewModelProvider).put(CheckInAddDependantInputViewModel.class, this.checkInAddDependantInputViewModelProvider).put(CheckInSummaryViewModel.class, this.checkInSummaryViewModelProvider).put(CheckInEditPersonInputViewModel.class, this.checkInEditPersonInputViewModelProvider).put(CheckInSubmittingViewModel.class, this.checkInSubmittingViewModelProvider).put(CheckInSuccessViewModel.class, this.checkInSuccessViewModelProvider).put(CheckInScannerViewModel.class, this.checkInScannerViewModelProvider).put(CheckInHistoryDetailViewModel.class, this.checkInHistoryDetailViewModelProvider).put(CheckInFeedbackViewModel.class, this.checkInFeedbackViewModelProvider).put(CheckInFeedbackSuccessViewModel.class, this.checkInFeedbackSuccessViewModelProvider).put(CheckInShortcutViewModel.class, this.checkInShortcutViewModelProvider).build();
        }

        private ViewModelFactory getViewModelFactory() {
            return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
        }

        private CheckInHistoryDetailViewModel getCheckInHistoryDetailViewModel() {
            return new CheckInHistoryDetailViewModel((Context) DaggerBaseComponent.this.bindContextProvider.get(), (CheckInRepository) DaggerBaseComponent.this.provideCheckInRepositoryProvider.get());
        }

        private void initialize(CheckInHistoryDetailFragment checkInHistoryDetailFragment) {
            this.checkInOverviewViewModelProvider = CheckInOverviewViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInPrimaryInputViewModelProvider = CheckInPrimaryInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInAddDependantInputViewModelProvider = CheckInAddDependantInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSummaryViewModelProvider = CheckInSummaryViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInEditPersonInputViewModelProvider = CheckInEditPersonInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSubmittingViewModelProvider = CheckInSubmittingViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSuccessViewModelProvider = CheckInSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInScannerViewModelProvider = CheckInScannerViewModel_Factory.create(DaggerBaseComponent.this.provideScannerViewServiceProvider, DaggerBaseComponent.this.provideMoshiProvider, DaggerBaseComponent.this.provideOkHttpProvider, DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInHistoryDetailViewModelProvider = CheckInHistoryDetailViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInFeedbackViewModelProvider = CheckInFeedbackViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInFeedbackSuccessViewModelProvider = CheckInFeedbackSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInShortcutViewModelProvider = CheckInShortcutViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
        }

        public void inject(CheckInHistoryDetailFragment checkInHistoryDetailFragment) {
            injectCheckInHistoryDetailFragment(checkInHistoryDetailFragment);
        }

        private CheckInHistoryDetailFragment injectCheckInHistoryDetailFragment(CheckInHistoryDetailFragment checkInHistoryDetailFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInHistoryDetailFragment, DaggerBaseComponent.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInHistoryDetailFragment, getViewModelFactory());
            CheckInHistoryDetailFragment_MembersInjector.injectViewModel(checkInHistoryDetailFragment, getCheckInHistoryDetailViewModel());
            return checkInHistoryDetailFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInFeedbackFragmentSubcomponentFactory implements BaseSupportFragmentModule_ContributeCheckInFeedbackFragment.CheckInFeedbackFragmentSubcomponent.Factory {
        private CheckInFeedbackFragmentSubcomponentFactory() {
        }

        public BaseSupportFragmentModule_ContributeCheckInFeedbackFragment.CheckInFeedbackFragmentSubcomponent create(CheckInFeedbackFragment checkInFeedbackFragment) {
            Preconditions.checkNotNull(checkInFeedbackFragment);
            return new CheckInFeedbackFragmentSubcomponentImpl(checkInFeedbackFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInFeedbackFragmentSubcomponentImpl implements BaseSupportFragmentModule_ContributeCheckInFeedbackFragment.CheckInFeedbackFragmentSubcomponent {
        private Provider<CheckInAddDependantInputViewModel> checkInAddDependantInputViewModelProvider;
        private Provider<CheckInEditPersonInputViewModel> checkInEditPersonInputViewModelProvider;
        private Provider<CheckInFeedbackSuccessViewModel> checkInFeedbackSuccessViewModelProvider;
        private Provider<CheckInFeedbackViewModel> checkInFeedbackViewModelProvider;
        private Provider<CheckInHistoryDetailViewModel> checkInHistoryDetailViewModelProvider;
        private Provider<CheckInOverviewViewModel> checkInOverviewViewModelProvider;
        private Provider<CheckInPrimaryInputViewModel> checkInPrimaryInputViewModelProvider;
        private Provider<CheckInScannerViewModel> checkInScannerViewModelProvider;
        private Provider<CheckInShortcutViewModel> checkInShortcutViewModelProvider;
        private Provider<CheckInSubmittingViewModel> checkInSubmittingViewModelProvider;
        private Provider<CheckInSuccessViewModel> checkInSuccessViewModelProvider;
        private Provider<CheckInSummaryViewModel> checkInSummaryViewModelProvider;

        private CheckInFeedbackFragmentSubcomponentImpl(CheckInFeedbackFragment checkInFeedbackFragment) {
            initialize(checkInFeedbackFragment);
        }

        private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel() {
            return MapBuilder.newMapBuilder(12).put(CheckInOverviewViewModel.class, this.checkInOverviewViewModelProvider).put(CheckInPrimaryInputViewModel.class, this.checkInPrimaryInputViewModelProvider).put(CheckInAddDependantInputViewModel.class, this.checkInAddDependantInputViewModelProvider).put(CheckInSummaryViewModel.class, this.checkInSummaryViewModelProvider).put(CheckInEditPersonInputViewModel.class, this.checkInEditPersonInputViewModelProvider).put(CheckInSubmittingViewModel.class, this.checkInSubmittingViewModelProvider).put(CheckInSuccessViewModel.class, this.checkInSuccessViewModelProvider).put(CheckInScannerViewModel.class, this.checkInScannerViewModelProvider).put(CheckInHistoryDetailViewModel.class, this.checkInHistoryDetailViewModelProvider).put(CheckInFeedbackViewModel.class, this.checkInFeedbackViewModelProvider).put(CheckInFeedbackSuccessViewModel.class, this.checkInFeedbackSuccessViewModelProvider).put(CheckInShortcutViewModel.class, this.checkInShortcutViewModelProvider).build();
        }

        private ViewModelFactory getViewModelFactory() {
            return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
        }

        private CheckInFeedbackViewModel getCheckInFeedbackViewModel() {
            return new CheckInFeedbackViewModel((Context) DaggerBaseComponent.this.bindContextProvider.get(), (CheckInRepository) DaggerBaseComponent.this.provideCheckInRepositoryProvider.get(), (AnalyticsHelper) DaggerBaseComponent.this.provideAnalyticsProvider.get());
        }

        private void initialize(CheckInFeedbackFragment checkInFeedbackFragment) {
            this.checkInOverviewViewModelProvider = CheckInOverviewViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInPrimaryInputViewModelProvider = CheckInPrimaryInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInAddDependantInputViewModelProvider = CheckInAddDependantInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSummaryViewModelProvider = CheckInSummaryViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInEditPersonInputViewModelProvider = CheckInEditPersonInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSubmittingViewModelProvider = CheckInSubmittingViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSuccessViewModelProvider = CheckInSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInScannerViewModelProvider = CheckInScannerViewModel_Factory.create(DaggerBaseComponent.this.provideScannerViewServiceProvider, DaggerBaseComponent.this.provideMoshiProvider, DaggerBaseComponent.this.provideOkHttpProvider, DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInHistoryDetailViewModelProvider = CheckInHistoryDetailViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInFeedbackViewModelProvider = CheckInFeedbackViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInFeedbackSuccessViewModelProvider = CheckInFeedbackSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInShortcutViewModelProvider = CheckInShortcutViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
        }

        public void inject(CheckInFeedbackFragment checkInFeedbackFragment) {
            injectCheckInFeedbackFragment(checkInFeedbackFragment);
        }

        private CheckInFeedbackFragment injectCheckInFeedbackFragment(CheckInFeedbackFragment checkInFeedbackFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInFeedbackFragment, DaggerBaseComponent.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInFeedbackFragment, getViewModelFactory());
            CheckInFeedbackFragment_MembersInjector.injectViewModel(checkInFeedbackFragment, getCheckInFeedbackViewModel());
            return checkInFeedbackFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInFeedbackSuccessFragmentSubcomponentFactory implements BaseSupportFragmentModule_ContributeCheckInFeedbackSuccessFragment.CheckInFeedbackSuccessFragmentSubcomponent.Factory {
        private CheckInFeedbackSuccessFragmentSubcomponentFactory() {
        }

        public BaseSupportFragmentModule_ContributeCheckInFeedbackSuccessFragment.CheckInFeedbackSuccessFragmentSubcomponent create(CheckInFeedbackSuccessFragment checkInFeedbackSuccessFragment) {
            Preconditions.checkNotNull(checkInFeedbackSuccessFragment);
            return new CheckInFeedbackSuccessFragmentSubcomponentImpl(checkInFeedbackSuccessFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInFeedbackSuccessFragmentSubcomponentImpl implements BaseSupportFragmentModule_ContributeCheckInFeedbackSuccessFragment.CheckInFeedbackSuccessFragmentSubcomponent {
        private Provider<CheckInAddDependantInputViewModel> checkInAddDependantInputViewModelProvider;
        private Provider<CheckInEditPersonInputViewModel> checkInEditPersonInputViewModelProvider;
        private Provider<CheckInFeedbackSuccessViewModel> checkInFeedbackSuccessViewModelProvider;
        private Provider<CheckInFeedbackViewModel> checkInFeedbackViewModelProvider;
        private Provider<CheckInHistoryDetailViewModel> checkInHistoryDetailViewModelProvider;
        private Provider<CheckInOverviewViewModel> checkInOverviewViewModelProvider;
        private Provider<CheckInPrimaryInputViewModel> checkInPrimaryInputViewModelProvider;
        private Provider<CheckInScannerViewModel> checkInScannerViewModelProvider;
        private Provider<CheckInShortcutViewModel> checkInShortcutViewModelProvider;
        private Provider<CheckInSubmittingViewModel> checkInSubmittingViewModelProvider;
        private Provider<CheckInSuccessViewModel> checkInSuccessViewModelProvider;
        private Provider<CheckInSummaryViewModel> checkInSummaryViewModelProvider;

        private CheckInFeedbackSuccessFragmentSubcomponentImpl(CheckInFeedbackSuccessFragment checkInFeedbackSuccessFragment) {
            initialize(checkInFeedbackSuccessFragment);
        }

        private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel() {
            return MapBuilder.newMapBuilder(12).put(CheckInOverviewViewModel.class, this.checkInOverviewViewModelProvider).put(CheckInPrimaryInputViewModel.class, this.checkInPrimaryInputViewModelProvider).put(CheckInAddDependantInputViewModel.class, this.checkInAddDependantInputViewModelProvider).put(CheckInSummaryViewModel.class, this.checkInSummaryViewModelProvider).put(CheckInEditPersonInputViewModel.class, this.checkInEditPersonInputViewModelProvider).put(CheckInSubmittingViewModel.class, this.checkInSubmittingViewModelProvider).put(CheckInSuccessViewModel.class, this.checkInSuccessViewModelProvider).put(CheckInScannerViewModel.class, this.checkInScannerViewModelProvider).put(CheckInHistoryDetailViewModel.class, this.checkInHistoryDetailViewModelProvider).put(CheckInFeedbackViewModel.class, this.checkInFeedbackViewModelProvider).put(CheckInFeedbackSuccessViewModel.class, this.checkInFeedbackSuccessViewModelProvider).put(CheckInShortcutViewModel.class, this.checkInShortcutViewModelProvider).build();
        }

        private ViewModelFactory getViewModelFactory() {
            return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
        }

        private CheckInFeedbackSuccessViewModel getCheckInFeedbackSuccessViewModel() {
            return new CheckInFeedbackSuccessViewModel((Context) DaggerBaseComponent.this.bindContextProvider.get(), (CheckInRepository) DaggerBaseComponent.this.provideCheckInRepositoryProvider.get());
        }

        private void initialize(CheckInFeedbackSuccessFragment checkInFeedbackSuccessFragment) {
            this.checkInOverviewViewModelProvider = CheckInOverviewViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInPrimaryInputViewModelProvider = CheckInPrimaryInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInAddDependantInputViewModelProvider = CheckInAddDependantInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSummaryViewModelProvider = CheckInSummaryViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInEditPersonInputViewModelProvider = CheckInEditPersonInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSubmittingViewModelProvider = CheckInSubmittingViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSuccessViewModelProvider = CheckInSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInScannerViewModelProvider = CheckInScannerViewModel_Factory.create(DaggerBaseComponent.this.provideScannerViewServiceProvider, DaggerBaseComponent.this.provideMoshiProvider, DaggerBaseComponent.this.provideOkHttpProvider, DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInHistoryDetailViewModelProvider = CheckInHistoryDetailViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInFeedbackViewModelProvider = CheckInFeedbackViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInFeedbackSuccessViewModelProvider = CheckInFeedbackSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInShortcutViewModelProvider = CheckInShortcutViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
        }

        public void inject(CheckInFeedbackSuccessFragment checkInFeedbackSuccessFragment) {
            injectCheckInFeedbackSuccessFragment(checkInFeedbackSuccessFragment);
        }

        private CheckInFeedbackSuccessFragment injectCheckInFeedbackSuccessFragment(CheckInFeedbackSuccessFragment checkInFeedbackSuccessFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInFeedbackSuccessFragment, DaggerBaseComponent.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInFeedbackSuccessFragment, getViewModelFactory());
            CheckInFeedbackSuccessFragment_MembersInjector.injectViewModel(checkInFeedbackSuccessFragment, getCheckInFeedbackSuccessViewModel());
            return checkInFeedbackSuccessFragment;
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInShortcutFragmentSubcomponentFactory implements BaseSupportFragmentModule_ContributeCheckInShortcutFragment.CheckInShortcutFragmentSubcomponent.Factory {
        private CheckInShortcutFragmentSubcomponentFactory() {
        }

        public BaseSupportFragmentModule_ContributeCheckInShortcutFragment.CheckInShortcutFragmentSubcomponent create(CheckInShortcutFragment checkInShortcutFragment) {
            Preconditions.checkNotNull(checkInShortcutFragment);
            return new CheckInShortcutFragmentSubcomponentImpl(checkInShortcutFragment);
        }
    }

    /* access modifiers changed from: private */
    public final class CheckInShortcutFragmentSubcomponentImpl implements BaseSupportFragmentModule_ContributeCheckInShortcutFragment.CheckInShortcutFragmentSubcomponent {
        private Provider<CheckInAddDependantInputViewModel> checkInAddDependantInputViewModelProvider;
        private Provider<CheckInEditPersonInputViewModel> checkInEditPersonInputViewModelProvider;
        private Provider<CheckInFeedbackSuccessViewModel> checkInFeedbackSuccessViewModelProvider;
        private Provider<CheckInFeedbackViewModel> checkInFeedbackViewModelProvider;
        private Provider<CheckInHistoryDetailViewModel> checkInHistoryDetailViewModelProvider;
        private Provider<CheckInOverviewViewModel> checkInOverviewViewModelProvider;
        private Provider<CheckInPrimaryInputViewModel> checkInPrimaryInputViewModelProvider;
        private Provider<CheckInScannerViewModel> checkInScannerViewModelProvider;
        private Provider<CheckInShortcutViewModel> checkInShortcutViewModelProvider;
        private Provider<CheckInSubmittingViewModel> checkInSubmittingViewModelProvider;
        private Provider<CheckInSuccessViewModel> checkInSuccessViewModelProvider;
        private Provider<CheckInSummaryViewModel> checkInSummaryViewModelProvider;

        private CheckInShortcutFragmentSubcomponentImpl(CheckInShortcutFragment checkInShortcutFragment) {
            initialize(checkInShortcutFragment);
        }

        private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel() {
            return MapBuilder.newMapBuilder(12).put(CheckInOverviewViewModel.class, this.checkInOverviewViewModelProvider).put(CheckInPrimaryInputViewModel.class, this.checkInPrimaryInputViewModelProvider).put(CheckInAddDependantInputViewModel.class, this.checkInAddDependantInputViewModelProvider).put(CheckInSummaryViewModel.class, this.checkInSummaryViewModelProvider).put(CheckInEditPersonInputViewModel.class, this.checkInEditPersonInputViewModelProvider).put(CheckInSubmittingViewModel.class, this.checkInSubmittingViewModelProvider).put(CheckInSuccessViewModel.class, this.checkInSuccessViewModelProvider).put(CheckInScannerViewModel.class, this.checkInScannerViewModelProvider).put(CheckInHistoryDetailViewModel.class, this.checkInHistoryDetailViewModelProvider).put(CheckInFeedbackViewModel.class, this.checkInFeedbackViewModelProvider).put(CheckInFeedbackSuccessViewModel.class, this.checkInFeedbackSuccessViewModelProvider).put(CheckInShortcutViewModel.class, this.checkInShortcutViewModelProvider).build();
        }

        private ViewModelFactory getViewModelFactory() {
            return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
        }

        private CheckInShortcutViewModel getCheckInShortcutViewModel() {
            return new CheckInShortcutViewModel((Context) DaggerBaseComponent.this.bindContextProvider.get(), (CheckInRepository) DaggerBaseComponent.this.provideCheckInRepositoryProvider.get());
        }

        private void initialize(CheckInShortcutFragment checkInShortcutFragment) {
            this.checkInOverviewViewModelProvider = CheckInOverviewViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInPrimaryInputViewModelProvider = CheckInPrimaryInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInAddDependantInputViewModelProvider = CheckInAddDependantInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSummaryViewModelProvider = CheckInSummaryViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInEditPersonInputViewModelProvider = CheckInEditPersonInputViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSubmittingViewModelProvider = CheckInSubmittingViewModel_Factory.create(DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInSuccessViewModelProvider = CheckInSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInScannerViewModelProvider = CheckInScannerViewModel_Factory.create(DaggerBaseComponent.this.provideScannerViewServiceProvider, DaggerBaseComponent.this.provideMoshiProvider, DaggerBaseComponent.this.provideOkHttpProvider, DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInHistoryDetailViewModelProvider = CheckInHistoryDetailViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInFeedbackViewModelProvider = CheckInFeedbackViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider, DaggerBaseComponent.this.provideAnalyticsProvider);
            this.checkInFeedbackSuccessViewModelProvider = CheckInFeedbackSuccessViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
            this.checkInShortcutViewModelProvider = CheckInShortcutViewModel_Factory.create(DaggerBaseComponent.this.bindContextProvider, DaggerBaseComponent.this.provideCheckInRepositoryProvider);
        }

        public void inject(CheckInShortcutFragment checkInShortcutFragment) {
            injectCheckInShortcutFragment(checkInShortcutFragment);
        }

        private CheckInShortcutFragment injectCheckInShortcutFragment(CheckInShortcutFragment checkInShortcutFragment) {
            DaggerFragment_MembersInjector.injectAndroidInjector(checkInShortcutFragment, DaggerBaseComponent.this.getDispatchingAndroidInjectorOfObject());
            BaseFragment_MembersInjector.injectViewModelFactory(checkInShortcutFragment, getViewModelFactory());
            CheckInShortcutFragment_MembersInjector.injectViewModel(checkInShortcutFragment, getCheckInShortcutViewModel());
            return checkInShortcutFragment;
        }
    }
}
