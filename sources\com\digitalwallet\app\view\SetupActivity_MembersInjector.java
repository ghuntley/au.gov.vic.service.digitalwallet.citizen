package com.digitalwallet.app.view;

import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.view.base.AppDaggerAppCompatActivity_MembersInjector;
import com.digitalwallet.di.ViewModelFactory;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class SetupActivity_MembersInjector implements MembersInjector<SetupActivity> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<AuthenticationUtility> authUtilityProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    public SetupActivity_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AuthenticationUtility> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.authUtilityProvider = provider3;
    }

    public static MembersInjector<SetupActivity> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AuthenticationUtility> provider3) {
        return new SetupActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(SetupActivity setupActivity) {
        AppDaggerAppCompatActivity_MembersInjector.injectAndroidInjector(setupActivity, this.androidInjectorProvider.get());
        AppDaggerAppCompatActivity_MembersInjector.injectViewModelFactory(setupActivity, this.viewModelFactoryProvider.get());
        injectAuthUtility(setupActivity, this.authUtilityProvider.get());
    }

    public static void injectAuthUtility(SetupActivity setupActivity, AuthenticationUtility authenticationUtility) {
        setupActivity.authUtility = authenticationUtility;
    }
}
