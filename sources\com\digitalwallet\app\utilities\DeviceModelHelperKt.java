package com.digitalwallet.app.utilities;

import android.os.Build;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\b\u0010\u0003\u001a\u00020\u0002H\u0002\u001a\u0006\u0010\u0004\u001a\u00020\u0005\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"downgradedAnimationDevices", "", "", "getDeviceName", "isDeviceSupportBetterAnimation", "", "app_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: DeviceModelHelper.kt */
public final class DeviceModelHelperKt {
    private static final List<String> downgradedAnimationDevices = CollectionsKt.listOf((Object[]) new String[]{"HUAWEI VTR-L09", "HUAWEI VTR-L29", "HUAWEI VTR-AL00", "HUAWEI VTR-TL00"});

    private static final String getDeviceName() {
        String str = Build.MANUFACTURER + ' ' + Build.MODEL;
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String upperCase = str.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
        return upperCase;
    }

    public static final boolean isDeviceSupportBetterAnimation() {
        return !downgradedAnimationDevices.contains(getDeviceName());
    }
}
