package dagger.android;

import dagger.BindsInstance;

public interface AndroidInjector<T> {

    public interface Factory<T> {
        AndroidInjector<T> create(@BindsInstance T t);
    }

    void inject(T t);

    @Deprecated
    public static abstract class Builder<T> implements Factory<T> {
        public abstract AndroidInjector<T> build();

        @BindsInstance
        public abstract void seedInstance(T t);

        @Override // dagger.android.AndroidInjector.Factory
        public final AndroidInjector<T> create(T t) {
            seedInstance(t);
            return build();
        }
    }
}
