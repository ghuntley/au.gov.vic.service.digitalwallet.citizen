package dagger.android;

import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.Multibinds;
import java.util.Map;

@Module
public abstract class AndroidInjectionModule {
    /* access modifiers changed from: package-private */
    @Multibinds
    public abstract Map<Class<?>, AndroidInjector.Factory<?>> classKeyedInjectorFactories();

    /* access modifiers changed from: package-private */
    @Multibinds
    public abstract Map<String, AndroidInjector.Factory<?>> stringKeyedInjectorFactories();

    private AndroidInjectionModule() {
    }
}
