package com.digitalwallet.app.view.util;

import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"com/digitalwallet/app/view/util/CustomTabProvider$tabsCallback$1", "Landroidx/browser/customtabs/CustomTabsCallback;", "lastNavEvent", "", "getLastNavEvent", "()I", "setLastNavEvent", "(I)V", "onNavigationEvent", "", "navigationEvent", "extras", "Landroid/os/Bundle;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CustomTabProvider.kt */
public final class CustomTabProvider$tabsCallback$1 extends CustomTabsCallback {
    private int lastNavEvent;

    CustomTabProvider$tabsCallback$1() {
    }

    public final int getLastNavEvent() {
        return this.lastNavEvent;
    }

    public final void setLastNavEvent(int i) {
        this.lastNavEvent = i;
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public void onNavigationEvent(int i, Bundle bundle) {
        boolean z = true;
        CustomTabProvider.INSTANCE.getBackgroundPublisher().onNext(Boolean.valueOf(this.lastNavEvent == 6 && i == 5));
        MutableLiveData<Boolean> backgroundState = CustomTabProvider.INSTANCE.getBackgroundState();
        if (!(this.lastNavEvent == 6 && i == 5)) {
            z = false;
        }
        backgroundState.setValue(Boolean.valueOf(z));
        this.lastNavEvent = i;
    }
}
