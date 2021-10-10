package com.digitalwallet.app.viewmodel.main.holdings;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class MoreCardsInfoViewModel_Factory implements Factory<MoreCardsInfoViewModel> {
    private final Provider<Context> contextProvider;

    public MoreCardsInfoViewModel_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public MoreCardsInfoViewModel get() {
        return new MoreCardsInfoViewModel(this.contextProvider.get());
    }

    public static MoreCardsInfoViewModel_Factory create(Provider<Context> provider) {
        return new MoreCardsInfoViewModel_Factory(provider);
    }

    public static MoreCardsInfoViewModel newInstance(Context context) {
        return new MoreCardsInfoViewModel(context);
    }
}
