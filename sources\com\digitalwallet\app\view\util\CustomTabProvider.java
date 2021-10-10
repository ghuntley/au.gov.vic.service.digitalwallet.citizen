package com.digitalwallet.app.view.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.browser.Browsers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/digitalwallet/app/view/util/CustomTabProvider;", "", "()V", "backgroundPublisher", "Lio/reactivex/subjects/PublishSubject;", "", "getBackgroundPublisher", "()Lio/reactivex/subjects/PublishSubject;", "backgroundState", "Landroidx/lifecycle/MutableLiveData;", "getBackgroundState", "()Landroidx/lifecycle/MutableLiveData;", "customTabsIntent", "Landroidx/browser/customtabs/CustomTabsIntent;", "getCustomTabsIntent", "()Landroidx/browser/customtabs/CustomTabsIntent;", "setCustomTabsIntent", "(Landroidx/browser/customtabs/CustomTabsIntent;)V", "tabsCallback", "com/digitalwallet/app/view/util/CustomTabProvider$tabsCallback$1", "Lcom/digitalwallet/app/view/util/CustomTabProvider$tabsCallback$1;", "tabsServiceConnection", "Landroidx/browser/customtabs/CustomTabsServiceConnection;", "getTabsServiceConnection", "()Landroidx/browser/customtabs/CustomTabsServiceConnection;", "getCustomTabsPackageName", "", "context", "Landroid/content/Context;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CustomTabProvider.kt */
public final class CustomTabProvider {
    public static final CustomTabProvider INSTANCE = new CustomTabProvider();
    private static final PublishSubject<Boolean> backgroundPublisher;
    private static final MutableLiveData<Boolean> backgroundState = new MutableLiveData<>();
    private static CustomTabsIntent customTabsIntent;
    private static final CustomTabProvider$tabsCallback$1 tabsCallback = new CustomTabProvider$tabsCallback$1();
    private static final CustomTabsServiceConnection tabsServiceConnection = new CustomTabProvider$tabsServiceConnection$1();

    static {
        PublishSubject<Boolean> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create()");
        backgroundPublisher = create;
    }

    private CustomTabProvider() {
    }

    public final MutableLiveData<Boolean> getBackgroundState() {
        return backgroundState;
    }

    public final PublishSubject<Boolean> getBackgroundPublisher() {
        return backgroundPublisher;
    }

    public final CustomTabsIntent getCustomTabsIntent() {
        return customTabsIntent;
    }

    public final void setCustomTabsIntent(CustomTabsIntent customTabsIntent2) {
        customTabsIntent = customTabsIntent2;
    }

    public final String getCustomTabsPackageName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PackageManager packageManager = context.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "context.packageManager");
        Intent data = new Intent().setAction("android.intent.action.VIEW").addCategory("android.intent.category.BROWSABLE").setData(Uri.fromParts("http", "", null));
        Intrinsics.checkNotNullExpressionValue(data, "Intent()\n               …mParts(\"http\", \"\", null))");
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(data, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            Intent intent = new Intent();
            intent.setAction(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
            intent.setPackage(resolveInfo.activityInfo.packageName);
            if (packageManager.resolveService(intent, 0) != null) {
                arrayList.add(resolveInfo);
            }
        }
        ArrayList<ResolveInfo> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (ResolveInfo resolveInfo2 : arrayList2) {
            arrayList3.add(resolveInfo2.activityInfo.packageName);
        }
        ArrayList arrayList4 = arrayList3;
        if (arrayList4.contains(Browsers.Chrome.PACKAGE_NAME)) {
            return Browsers.Chrome.PACKAGE_NAME;
        }
        return (String) CollectionsKt.firstOrNull((List) arrayList4);
    }

    public final CustomTabsServiceConnection getTabsServiceConnection() {
        return tabsServiceConnection;
    }
}
