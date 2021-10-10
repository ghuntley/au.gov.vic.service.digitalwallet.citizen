package com.digitalwallet.app.view.pin;

import com.digitalwallet.app.viewmodel.pin.FingerprintDialogFragmentViewModel;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class FingerprintDialogFragment_MembersInjector implements MembersInjector<FingerprintDialogFragment> {
    private final Provider<FingerprintDialogFragmentViewModel> viewModelProvider;

    public FingerprintDialogFragment_MembersInjector(Provider<FingerprintDialogFragmentViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<FingerprintDialogFragment> create(Provider<FingerprintDialogFragmentViewModel> provider) {
        return new FingerprintDialogFragment_MembersInjector(provider);
    }

    public void injectMembers(FingerprintDialogFragment fingerprintDialogFragment) {
        injectViewModel(fingerprintDialogFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(FingerprintDialogFragment fingerprintDialogFragment, FingerprintDialogFragmentViewModel fingerprintDialogFragmentViewModel) {
        fingerprintDialogFragment.viewModel = fingerprintDialogFragmentViewModel;
    }
}
