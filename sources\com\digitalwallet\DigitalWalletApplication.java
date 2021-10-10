package com.digitalwallet;

import android.app.Application;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.digitalwallet.di.BaseApiModule;
import com.digitalwallet.di.BaseComponent;
import com.digitalwallet.di.BaseModule;
import com.digitalwallet.di.DaggerBaseComponent;
import com.digitalwallet.utilities.ServerType;
import com.digitalwallet.utilities.ServerTypeKt;
import com.digitalwallet.utilities.VersionNameCodeKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import io.reactivex.plugins.RxJavaPlugins;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0007J\b\u0010\u001d\u001a\u00020\u001cH\u0007J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0002R$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006 "}, d2 = {"Lcom/digitalwallet/DigitalWalletApplication;", "Ldagger/android/HasAndroidInjector;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/app/Application;", "()V", "androidInjector", "Ldagger/android/DispatchingAndroidInjector;", "", "getAndroidInjector", "()Ldagger/android/DispatchingAndroidInjector;", "setAndroidInjector", "(Ldagger/android/DispatchingAndroidInjector;)V", "baseComponent", "Lcom/digitalwallet/di/BaseComponent;", "getBaseComponent", "()Lcom/digitalwallet/di/BaseComponent;", "setBaseComponent", "(Lcom/digitalwallet/di/BaseComponent;)V", "isAppBackgrounded", "", "()Z", "setAppBackgrounded", "(Z)V", "spawnedAnotherActivity", "getSpawnedAnotherActivity", "setSpawnedAnotherActivity", "Ldagger/android/AndroidInjector;", "onAppBackgrounded", "", "onAppForegrounded", "onCreate", "shouldCrashlyticsBeEnabled", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: DigitalWalletApplication.kt */
public final class DigitalWalletApplication extends Application implements HasAndroidInjector, LifecycleObserver {
    @Inject
    public DispatchingAndroidInjector<Object> androidInjector;
    public BaseComponent baseComponent;
    private boolean isAppBackgrounded;
    private boolean spawnedAnotherActivity;

    @Override // dagger.android.HasAndroidInjector
    public AndroidInjector<Object> androidInjector() {
        DispatchingAndroidInjector<Object> dispatchingAndroidInjector = this.androidInjector;
        if (dispatchingAndroidInjector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("androidInjector");
        }
        return dispatchingAndroidInjector;
    }

    public final DispatchingAndroidInjector<Object> getAndroidInjector() {
        DispatchingAndroidInjector<Object> dispatchingAndroidInjector = this.androidInjector;
        if (dispatchingAndroidInjector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("androidInjector");
        }
        return dispatchingAndroidInjector;
    }

    public final void setAndroidInjector(DispatchingAndroidInjector<Object> dispatchingAndroidInjector) {
        Intrinsics.checkNotNullParameter(dispatchingAndroidInjector, "<set-?>");
        this.androidInjector = dispatchingAndroidInjector;
    }

    public final BaseComponent getBaseComponent() {
        BaseComponent baseComponent2 = this.baseComponent;
        if (baseComponent2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseComponent");
        }
        return baseComponent2;
    }

    public final void setBaseComponent(BaseComponent baseComponent2) {
        Intrinsics.checkNotNullParameter(baseComponent2, "<set-?>");
        this.baseComponent = baseComponent2;
    }

    public void onCreate() {
        super.onCreate();
        RxJavaPlugins.setErrorHandler(DigitalWalletApplication$onCreate$1.INSTANCE);
        BaseComponent build = DaggerBaseComponent.builder().baseModule(new BaseModule(this)).baseApiModule(new BaseApiModule()).build();
        build.inject(this);
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(build, "DaggerBaseComponent.buil….also { it.inject(this) }");
        this.baseComponent = build;
        DigitalWalletApplication digitalWalletApplication = this;
        FirebaseAnalytics instance = FirebaseAnalytics.getInstance(digitalWalletApplication);
        instance.setUserProperty("Version", VersionNameCodeKt.versionName(digitalWalletApplication) + '.' + VersionNameCodeKt.versionCode(digitalWalletApplication));
        instance.setUserProperty("BuildType", "prod.citizen");
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(shouldCrashlyticsBeEnabled());
        LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.get();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "ProcessLifecycleOwner.get()");
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    private final boolean shouldCrashlyticsBeEnabled() {
        CollectionsKt.listOf((Object[]) new ServerType[]{ServerType.PROD, ServerType.UAT, ServerType.SIT}).contains(ServerTypeKt.getServerTypeFromString("prod"));
        return true;
    }

    public final boolean isAppBackgrounded() {
        return this.isAppBackgrounded;
    }

    public final void setAppBackgrounded(boolean z) {
        this.isAppBackgrounded = z;
    }

    public final boolean getSpawnedAnotherActivity() {
        return this.spawnedAnotherActivity;
    }

    public final void setSpawnedAnotherActivity(boolean z) {
        this.spawnedAnotherActivity = z;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onAppBackgrounded() {
        this.isAppBackgrounded = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onAppForegrounded() {
        this.isAppBackgrounded = false;
    }
}
