package dagger.android.support;

import dagger.Module;
import dagger.android.AndroidInjectionModule;

@Module(includes = {AndroidInjectionModule.class})
public abstract class AndroidSupportInjectionModule {
    private AndroidSupportInjectionModule() {
    }
}
