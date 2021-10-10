package com.digitalwallet.app.view.util;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"com/digitalwallet/app/view/util/CustomTabProvider$tabsServiceConnection$1", "Landroidx/browser/customtabs/CustomTabsServiceConnection;", "innerClient", "Landroidx/browser/customtabs/CustomTabsClient;", "onCustomTabsServiceConnected", "", "name", "Landroid/content/ComponentName;", "client", "onServiceDisconnected", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CustomTabProvider.kt */
public final class CustomTabProvider$tabsServiceConnection$1 extends CustomTabsServiceConnection {
    private CustomTabsClient innerClient;

    CustomTabProvider$tabsServiceConnection$1() {
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        Intrinsics.checkNotNullParameter(componentName, "name");
        Intrinsics.checkNotNullParameter(customTabsClient, "client");
        this.innerClient = customTabsClient;
        if (customTabsClient != null) {
            customTabsClient.warmup(0);
        }
        CustomTabsClient customTabsClient2 = this.innerClient;
        if (customTabsClient2 != null) {
            CustomTabProvider customTabProvider = CustomTabProvider.INSTANCE;
            CustomTabsSession newSession = customTabsClient2.newSession(CustomTabProvider.tabsCallback);
            if (newSession != null) {
                CustomTabProvider.INSTANCE.setCustomTabsIntent(new CustomTabsIntent.Builder(newSession).build());
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "name");
        this.innerClient = null;
    }
}
