package com.digitalwallet.view.base;

import androidx.databinding.ViewDataBinding;
import com.digitalwallet.di.ViewModelFactory;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class BaseFragment_MembersInjector<T extends ViewDataBinding> implements MembersInjector<BaseFragment<T>> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    @Override // dagger.MembersInjector
    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        injectMembers((BaseFragment) ((BaseFragment) obj));
    }

    public BaseFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static <T extends ViewDataBinding> MembersInjector<BaseFragment<T>> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        return new BaseFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(BaseFragment<T> baseFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(baseFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(baseFragment, this.viewModelFactoryProvider.get());
    }

    public static <T extends ViewDataBinding> void injectViewModelFactory(BaseFragment<T> baseFragment, ViewModelFactory viewModelFactory) {
        baseFragment.viewModelFactory = viewModelFactory;
    }
}
