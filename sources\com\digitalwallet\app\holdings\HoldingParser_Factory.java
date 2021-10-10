package com.digitalwallet.app.holdings;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class HoldingParser_Factory implements Factory<HoldingParser> {
    private final Provider<Moshi> moshiProvider;

    public HoldingParser_Factory(Provider<Moshi> provider) {
        this.moshiProvider = provider;
    }

    @Override // javax.inject.Provider
    public HoldingParser get() {
        return new HoldingParser(this.moshiProvider.get());
    }

    public static HoldingParser_Factory create(Provider<Moshi> provider) {
        return new HoldingParser_Factory(provider);
    }

    public static HoldingParser newInstance(Moshi moshi) {
        return new HoldingParser(moshi);
    }
}
