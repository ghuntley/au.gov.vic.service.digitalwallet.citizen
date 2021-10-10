package com.google.android.gms.instantapps;

import android.content.Intent;
import com.google.android.gms.tasks.Task;

public interface Launcher {
    public static final String EXTRA_DO_NOT_LAUNCH_INSTANT_APP = "com.google.android.gms.instantapps.DO_NOT_LAUNCH_INSTANT_APP";
    public static final String EXTRA_IS_REFERRER_TRUSTED = "com.google.android.gms.instantapps.IS_REFERRER_TRUSTED";
    public static final String EXTRA_IS_USER_CONFIRMED_LAUNCH = "com.google.android.gms.instantapps.IS_USER_CONFIRMED_LAUNCH";
    public static final String EXTRA_TRUSTED_REFERRER_PKG = "com.google.android.gms.instantapps.TRUSTED_REFERRER_PKG";

    InstantAppIntentData getInstantAppIntentData(String str, Intent intent);

    Task<LaunchData> getInstantAppLaunchData(String str);

    boolean initializeIntentClient();
}
