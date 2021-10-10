package com.digitalwallet.app.di;

import com.digitalwallet.di.ActivityScope;
import com.digitalwallet.di.BaseComponent;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/digitalwallet/app/di/AppComponentClient;", "Lcom/digitalwallet/app/di/AppComponent;", "Factory", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
@Component(dependencies = {BaseComponent.class}, modules = {AndroidInjectionModule.class, AppModuleClient.class})
@ActivityScope
/* compiled from: AppComponent.kt */
public interface AppComponentClient extends AppComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/digitalwallet/app/di/AppComponentClient$Factory;", "", "create", "Lcom/digitalwallet/app/di/AppComponentClient;", "baseComponent", "Lcom/digitalwallet/di/BaseComponent;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    @Component.Factory
    /* compiled from: AppComponent.kt */
    public interface Factory {
        AppComponentClient create(BaseComponent baseComponent);
    }
}
