package com.digitalwallet.view.checkIn.checkInInput;

import androidx.databinding.ViewDataBinding;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class CheckInInputBaseFragment_MembersInjector<T extends ViewDataBinding> implements MembersInjector<CheckInInputBaseFragment<T>> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    @Override // dagger.MembersInjector
    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        injectMembers((CheckInInputBaseFragment) ((CheckInInputBaseFragment) obj));
    }

    public CheckInInputBaseFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static <T extends ViewDataBinding> MembersInjector<CheckInInputBaseFragment<T>> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        return new CheckInInputBaseFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(CheckInInputBaseFragment<T> checkInInputBaseFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(checkInInputBaseFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(checkInInputBaseFragment, this.viewModelFactoryProvider.get());
    }
}
