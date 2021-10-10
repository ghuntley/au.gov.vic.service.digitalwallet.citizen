package com.digitalwallet.app.view.base;

import androidx.databinding.ViewDataBinding;
import com.digitalwallet.app.AppStartUp;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class BaseAppActivity_MembersInjector<T extends ViewDataBinding> implements MembersInjector<BaseAppActivity<T>> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<AppStartUp> appStartUpProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    @Override // dagger.MembersInjector
    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        injectMembers((BaseAppActivity) ((BaseAppActivity) obj));
    }

    public BaseAppActivity_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AppStartUp> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.appStartUpProvider = provider3;
    }

    public static <T extends ViewDataBinding> MembersInjector<BaseAppActivity<T>> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AppStartUp> provider3) {
        return new BaseAppActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(BaseAppActivity<T> baseAppActivity) {
        BaseActivity_MembersInjector.injectAndroidInjector(baseAppActivity, this.androidInjectorProvider.get());
        BaseActivity_MembersInjector.injectViewModelFactory(baseAppActivity, this.viewModelFactoryProvider.get());
        injectAppStartUp(baseAppActivity, this.appStartUpProvider.get());
    }

    public static <T extends ViewDataBinding> void injectAppStartUp(BaseAppActivity<T> baseAppActivity, AppStartUp appStartUp) {
        baseAppActivity.appStartUp = appStartUp;
    }
}
