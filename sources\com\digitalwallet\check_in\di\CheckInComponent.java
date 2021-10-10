package com.digitalwallet.check_in.di;

import com.digitalwallet.check_in.view.CheckInActivity;
import com.digitalwallet.di.ActivityScope;
import com.digitalwallet.di.BaseComponent;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/digitalwallet/check_in/di/CheckInComponent;", "", "inject", "", "checkInActivity", "Lcom/digitalwallet/check_in/view/CheckInActivity;", "Factory", "check_in_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
@Component(dependencies = {BaseComponent.class}, modules = {AndroidInjectionModule.class})
@ActivityScope
/* compiled from: CheckInComponent.kt */
public interface CheckInComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/digitalwallet/check_in/di/CheckInComponent$Factory;", "", "create", "Lcom/digitalwallet/check_in/di/CheckInComponent;", "baseComponent", "Lcom/digitalwallet/di/BaseComponent;", "check_in_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    @Component.Factory
    /* compiled from: CheckInComponent.kt */
    public interface Factory {
        CheckInComponent create(BaseComponent baseComponent);
    }

    void inject(CheckInActivity checkInActivity);
}
