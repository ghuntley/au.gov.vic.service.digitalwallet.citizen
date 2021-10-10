package com.digitalwallet.view.main;

import androidx.databinding.ViewDataBinding;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class ScannerFragment_MembersInjector<T extends ViewDataBinding> implements MembersInjector<ScannerFragment<T>> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    @Override // dagger.MembersInjector
    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        injectMembers((ScannerFragment) ((ScannerFragment) obj));
    }

    public ScannerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static <T extends ViewDataBinding> MembersInjector<ScannerFragment<T>> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        return new ScannerFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(ScannerFragment<T> scannerFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(scannerFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(scannerFragment, this.viewModelFactoryProvider.get());
    }
}
