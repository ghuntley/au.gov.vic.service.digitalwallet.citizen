package com.digitalwallet.view.checkIn;

import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import com.digitalwallet.viewmodel.checkIn.CheckInScannerViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class CheckInScannerFragment_MembersInjector implements MembersInjector<CheckInScannerFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<CheckInRepository> checkInRepositoryProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<CheckInScannerViewModel> viewModelProvider;

    public CheckInScannerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInScannerViewModel> provider3, Provider<CheckInRepository> provider4) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
        this.checkInRepositoryProvider = provider4;
    }

    public static MembersInjector<CheckInScannerFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInScannerViewModel> provider3, Provider<CheckInRepository> provider4) {
        return new CheckInScannerFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(CheckInScannerFragment checkInScannerFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(checkInScannerFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(checkInScannerFragment, this.viewModelFactoryProvider.get());
        injectViewModel(checkInScannerFragment, this.viewModelProvider.get());
        injectCheckInRepository(checkInScannerFragment, this.checkInRepositoryProvider.get());
    }

    public static void injectViewModel(CheckInScannerFragment checkInScannerFragment, CheckInScannerViewModel checkInScannerViewModel) {
        checkInScannerFragment.viewModel = checkInScannerViewModel;
    }

    public static void injectCheckInRepository(CheckInScannerFragment checkInScannerFragment, CheckInRepository checkInRepository) {
        checkInScannerFragment.checkInRepository = checkInRepository;
    }
}
