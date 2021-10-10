package com.digitalwallet.view.base;

import androidx.databinding.ViewDataBinding;
import com.digitalwallet.di.ViewModelFactory;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class BaseActivity_MembersInjector<T extends ViewDataBinding> implements MembersInjector<BaseActivity<T>> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    @Override // dagger.MembersInjector
    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        injectMembers((BaseActivity) ((BaseActivity) obj));
    }

    public BaseActivity_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static <T extends ViewDataBinding> MembersInjector<BaseActivity<T>> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        return new BaseActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(BaseActivity<T> baseActivity) {
        injectAndroidInjector(baseActivity, this.androidInjectorProvider.get());
        injectViewModelFactory(baseActivity, this.viewModelFactoryProvider.get());
    }

    public static <T extends ViewDataBinding> void injectAndroidInjector(BaseActivity<T> baseActivity, DispatchingAndroidInjector<Object> dispatchingAndroidInjector) {
        baseActivity.androidInjector = dispatchingAndroidInjector;
    }

    public static <T extends ViewDataBinding> void injectViewModelFactory(BaseActivity<T> baseActivity, ViewModelFactory viewModelFactory) {
        baseActivity.viewModelFactory = viewModelFactory;
    }
}
