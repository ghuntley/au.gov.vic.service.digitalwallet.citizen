package dagger.android.support;

import dagger.android.AndroidInjector;

public abstract class DaggerApplication extends dagger.android.DaggerApplication {
    /* access modifiers changed from: protected */
    @Override // dagger.android.DaggerApplication
    public abstract AndroidInjector<? extends DaggerApplication> applicationInjector();
}
