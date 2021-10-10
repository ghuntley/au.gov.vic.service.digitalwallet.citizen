package net.openid.appauth.browser;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class BrowserSelector {
    static final String ACTION_CUSTOM_TABS_CONNECTION = "android.support.customtabs.action.CustomTabsService";
    static final Intent BROWSER_INTENT = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
    private static final String SCHEME_HTTP = "http";
    private static final String SCHEME_HTTPS = "https";

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0079 A[Catch:{ NameNotFoundException -> 0x002d }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007d A[Catch:{ NameNotFoundException -> 0x002d }] */
    public static List<BrowserDescriptor> getAllBrowsers(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        int i = Build.VERSION.SDK_INT >= 23 ? 131136 : 64;
        Intent intent = BROWSER_INTENT;
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        String str = resolveActivity != null ? resolveActivity.activityInfo.packageName : null;
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, i)) {
            if (isFullBrowser(resolveInfo)) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.packageName, 64);
                    int i2 = 1;
                    if (hasWarmupService(packageManager, resolveInfo.activityInfo.packageName)) {
                        BrowserDescriptor browserDescriptor = new BrowserDescriptor(packageInfo, true);
                        if (resolveInfo.activityInfo.packageName.equals(str)) {
                            arrayList.add(0, browserDescriptor);
                            BrowserDescriptor browserDescriptor2 = new BrowserDescriptor(packageInfo, false);
                            if (!resolveInfo.activityInfo.packageName.equals(str)) {
                                arrayList.add(i2, browserDescriptor2);
                            } else {
                                arrayList.add(browserDescriptor2);
                            }
                        } else {
                            arrayList.add(browserDescriptor);
                        }
                    }
                    i2 = 0;
                    BrowserDescriptor browserDescriptor22 = new BrowserDescriptor(packageInfo, false);
                    if (!resolveInfo.activityInfo.packageName.equals(str)) {
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
        }
        return arrayList;
    }

    public static BrowserDescriptor select(Context context, BrowserMatcher browserMatcher) {
        BrowserDescriptor browserDescriptor = null;
        for (BrowserDescriptor browserDescriptor2 : getAllBrowsers(context)) {
            if (browserMatcher.matches(browserDescriptor2)) {
                if (browserDescriptor2.useCustomTab.booleanValue()) {
                    return browserDescriptor2;
                }
                if (browserDescriptor == null) {
                    browserDescriptor = browserDescriptor2;
                }
            }
        }
        return browserDescriptor;
    }

    private static boolean hasWarmupService(PackageManager packageManager, String str) {
        Intent intent = new Intent();
        intent.setAction("android.support.customtabs.action.CustomTabsService");
        intent.setPackage(str);
        if (packageManager.resolveService(intent, 0) != null) {
            return true;
        }
        return false;
    }

    private static boolean isFullBrowser(ResolveInfo resolveInfo) {
        if (!resolveInfo.filter.hasAction("android.intent.action.VIEW") || !resolveInfo.filter.hasCategory("android.intent.category.BROWSABLE") || resolveInfo.filter.schemesIterator() == null || resolveInfo.filter.authoritiesIterator() != null) {
            return false;
        }
        Iterator<String> schemesIterator = resolveInfo.filter.schemesIterator();
        boolean z = false;
        boolean z2 = false;
        while (schemesIterator.hasNext()) {
            String next = schemesIterator.next();
            z |= SCHEME_HTTP.equals(next);
            z2 |= SCHEME_HTTPS.equals(next);
            if (z && z2) {
                return true;
            }
        }
        return false;
    }
}
