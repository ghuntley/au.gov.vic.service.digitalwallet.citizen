package com.digitalwallet.utilities;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0006\u0010\u0007\u001a\u00020\b\u001a\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b\u001a\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\r"}, d2 = {"getAndroidVersion", "", "getDeviceLocaleName", "getDeviceLocaleTag", "getDeviceManufacturer", "getDeviceModel", "getDeviceTimezoneId", "getDeviceTimezoneOffsetInMin", "", "getScreenHeight", "context", "Landroid/content/Context;", "getScreenWidth", "base_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: DeviceInfo.kt */
public final class DeviceInfoKt {
    public static final String getDeviceLocaleName() {
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        String displayName = locale.getDisplayName();
        Intrinsics.checkNotNullExpressionValue(displayName, "Locale.getDefault().displayName");
        return displayName;
    }

    public static final String getDeviceLocaleTag() {
        String languageTag = Locale.getDefault().toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag, "Locale.getDefault().toLanguageTag()");
        return languageTag;
    }

    public static final String getDeviceManufacturer() {
        String str = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str, "Build.MANUFACTURER");
        return str;
    }

    public static final String getDeviceModel() {
        String str = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str, "Build.MODEL");
        return str;
    }

    public static final String getAndroidVersion() {
        String str = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(str, "Build.VERSION.RELEASE");
        return str;
    }

    public static final String getDeviceTimezoneId() {
        TimeZone timeZone = TimeZone.getDefault();
        Intrinsics.checkNotNullExpressionValue(timeZone, "TimeZone.getDefault()");
        String id = timeZone.getID();
        Intrinsics.checkNotNullExpressionValue(id, "TimeZone.getDefault().id");
        return id;
    }

    public static final int getDeviceTimezoneOffsetInMin() {
        TimeZone timeZone = TimeZone.getDefault();
        Intrinsics.checkNotNullExpressionValue(timeZone, "TimeZone.getDefault()");
        return (timeZone.getRawOffset() / 1000) / 60;
    }

    public static final int getScreenWidth(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return resources.getDisplayMetrics().widthPixels;
    }

    public static final int getScreenHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return resources.getDisplayMetrics().heightPixels;
    }
}
