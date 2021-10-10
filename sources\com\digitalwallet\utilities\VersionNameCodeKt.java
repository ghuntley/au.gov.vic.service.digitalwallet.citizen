package com.digitalwallet.utilities;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\b"}, d2 = {"getPackageInfo", "Landroid/content/pm/PackageInfo;", "context", "Landroid/content/Context;", "versionCode", "", "versionName", "", "base_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: VersionNameCode.kt */
public final class VersionNameCodeKt {
    public static final PackageInfo getPackageInfo(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            Timber.e(e);
            return null;
        }
    }

    public static final long versionCode(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 28) {
            PackageInfo packageInfo = getPackageInfo(context);
            Intrinsics.checkNotNull(packageInfo);
            return packageInfo.getLongVersionCode();
        }
        PackageInfo packageInfo2 = getPackageInfo(context);
        Intrinsics.checkNotNull(packageInfo2);
        return (long) packageInfo2.versionCode;
    }

    public static final String versionName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PackageInfo packageInfo = getPackageInfo(context);
        Intrinsics.checkNotNull(packageInfo);
        String str = packageInfo.versionName;
        Intrinsics.checkNotNullExpressionValue(str, "getPackageInfo(context)!!.versionName");
        return str;
    }
}
