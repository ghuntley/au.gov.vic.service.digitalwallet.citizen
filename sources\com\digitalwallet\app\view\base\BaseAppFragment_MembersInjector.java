package com.digitalwallet.app.view.base;

import androidx.databinding.ViewDataBinding;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class BaseAppFragment_MembersInjector<T extends ViewDataBinding> implements MembersInjector<BaseAppFragment<T>> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    @Override // dagger.MembersInjector
    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        injectMembers((BaseAppFragment) ((BaseAppFragment) obj));
    }

    public BaseAppFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static <T extends ViewDataBinding> MembersInjector<BaseAppFragment<T>> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        return new BaseAppFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(BaseAppFragment<T> baseAppFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(baseAppFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(baseAppFragment, this.viewModelFactoryProvider.get());
    }
}
