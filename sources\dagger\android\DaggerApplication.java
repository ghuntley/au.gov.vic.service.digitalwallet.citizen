package dagger.android;

import android.app.Application;
import javax.inject.Inject;

public abstract class DaggerApplication extends Application implements HasAndroidInjector {
    @Inject
    volatile DispatchingAndroidInjector<Object> androidInjector;

    /* access modifiers changed from: protected */
    public abstract AndroidInjector<? extends DaggerApplication> applicationInjector();

    public void onCreate() {
        super.onCreate();
        injectIfNecessary();
    }

    private void injectIfNecessary() {
        if (this.androidInjector == null) {
            synchronized (this) {
                if (this.androidInjector == null) {
                    applicationInjector().inject(this);
                    if (this.androidInjector == null) {
                        throw new IllegalStateException("The AndroidInjector returned from applicationInjector() did not inject the DaggerApplication");
                    }
                }
            }
        }
    }

    @Override // dagger.android.HasAndroidInjector
    public AndroidInjector<Object> androidInjector() {
        injectIfNecessary();
        return this.androidInjector;
    }
}
