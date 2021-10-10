package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.MainActivityServer;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H'¨\u0006\u0005"}, d2 = {"Lcom/digitalwallet/app/di/ActivityModuleServer;", "Lcom/digitalwallet/app/di/ActivityModule;", "()V", "contributeMainActivity", "Lcom/digitalwallet/app/view/main/MainActivityServer;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
@Module
/* compiled from: ActivityModule.kt */
public abstract class ActivityModuleServer extends ActivityModule {
    @ContributesAndroidInjector
    public abstract MainActivityServer contributeMainActivity();
}
