package com.digitalwallet.app.view.main;

import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class HoldingDisclaimerFragment_MembersInjector implements MembersInjector<HoldingDisclaimerFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public HoldingDisclaimerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider) {
        this.androidInjectorProvider = provider;
    }

    public static MembersInjector<HoldingDisclaimerFragment> create(Provider<DispatchingAndroidInjector<Object>> provider) {
        return new HoldingDisclaimerFragment_MembersInjector(provider);
    }

    public void injectMembers(HoldingDisclaimerFragment holdingDisclaimerFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(holdingDisclaimerFragment, this.androidInjectorProvider.get());
    }
}
