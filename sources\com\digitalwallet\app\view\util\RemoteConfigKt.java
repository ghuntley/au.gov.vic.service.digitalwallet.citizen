package com.digitalwallet.app.view.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceManager;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.view.util.AlertFragment;
import com.digitalwallet.model.RemoteConfig;
import com.digitalwallet.model.RemoteConfigNotice;
import com.digitalwallet.model.RemoteConfigUpdate;
import com.digitalwallet.model.RemoteConfigUpdateData;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.utilities.VersionNameCodeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"KEY_LAST_SHOWN_MESSAGE", "", "KEY_LAST_SHOWN_TITLE", "KEY_SHOWN_UPDATE_TIME", "KEY_SHOWN_UPDATE_VERSION", "ONE_WEEK", "", "handleRemoteConfig", "", "Landroidx/appcompat/app/AppCompatActivity;", "remoteConfig", "Lcom/digitalwallet/model/RemoteConfig;", "app_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: RemoteConfig.kt */
public final class RemoteConfigKt {
    public static final String KEY_LAST_SHOWN_MESSAGE = "last_message";
    public static final String KEY_LAST_SHOWN_TITLE = "last_title";
    public static final String KEY_SHOWN_UPDATE_TIME = "update_prompt_time";
    public static final String KEY_SHOWN_UPDATE_VERSION = "update_prompt_version";
    public static final long ONE_WEEK = 604800000;

    public static final void handleRemoteConfig(AppCompatActivity appCompatActivity, RemoteConfig remoteConfig) {
        RemoteConfigUpdateData android2;
        Intrinsics.checkNotNullParameter(appCompatActivity, "$this$handleRemoteConfig");
        Intrinsics.checkNotNullParameter(remoteConfig, "remoteConfig");
        AppCompatActivity appCompatActivity2 = appCompatActivity;
        AnalyticsHelper analyticsHelper = new AnalyticsHelper(appCompatActivity2);
        RemoteConfigUpdate update = remoteConfig.getUpdate();
        if (!(update == null || (android2 = update.getAndroid()) == null)) {
            Context applicationContext = appCompatActivity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            if (((long) android2.getVersion()) > VersionNameCodeKt.versionCode(applicationContext)) {
                if (android2.getForce()) {
                    AlertFragment create$default = AlertFragment.Companion.create$default(AlertFragment.Companion, android2.getTitle(), null, false, android2.getMessage(), null, null, appCompatActivity.getString(R.string.update_RES_2114650514), new RemoteConfigKt$handleRemoteConfig$$inlined$let$lambda$1(appCompatActivity, analyticsHelper), Integer.valueOf((int) R.drawable.ic_app_update), null, false, 566, null);
                    View findViewById = appCompatActivity.findViewById(R.id.fragment_container_RES_2114322527);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<FrameLayout>(R.id.fragment_container)");
                    ((FrameLayout) findViewById).setVisibility(0);
                    FragmentManager supportFragmentManager = appCompatActivity.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    List<Fragment> fragments = supportFragmentManager.getFragments();
                    Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
                    for (T t : fragments) {
                        Intrinsics.checkNotNullExpressionValue(t, "it");
                        t.setUserVisibleHint(false);
                    }
                    FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                    Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
                    beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
                    String simpleName = Reflection.getOrCreateKotlinClass(AlertFragment.class).getSimpleName();
                    beginTransaction.add(R.id.fragment_container_RES_2114322527, create$default, simpleName).addToBackStack(simpleName).commit();
                    return;
                }
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(appCompatActivity2);
                long currentTimeMillis = System.currentTimeMillis();
                if (defaultSharedPreferences.getInt(KEY_SHOWN_UPDATE_VERSION, Integer.MIN_VALUE) != android2.getVersion() || defaultSharedPreferences.getLong(KEY_SHOWN_UPDATE_TIME, Long.MIN_VALUE) < currentTimeMillis - ONE_WEEK) {
                    defaultSharedPreferences.edit().putLong(KEY_SHOWN_UPDATE_TIME, currentTimeMillis).putInt(KEY_SHOWN_UPDATE_VERSION, android2.getVersion()).apply();
                    appCompatActivity.runOnUiThread(new RemoteConfigKt$handleRemoteConfig$$inlined$let$lambda$2(android2, appCompatActivity, analyticsHelper));
                    return;
                }
            }
        }
        RemoteConfigNotice notice = remoteConfig.getNotice();
        if (notice != null) {
            SharedPreferences defaultSharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(appCompatActivity2);
            if ((!Intrinsics.areEqual(defaultSharedPreferences2.getString(KEY_LAST_SHOWN_TITLE, null), notice.getTitle())) || (!Intrinsics.areEqual(defaultSharedPreferences2.getString(KEY_LAST_SHOWN_MESSAGE, null), notice.getMessage()))) {
                appCompatActivity.runOnUiThread(new RemoteConfigKt$handleRemoteConfig$$inlined$let$lambda$3(notice, defaultSharedPreferences2, appCompatActivity));
            }
        }
    }
}
