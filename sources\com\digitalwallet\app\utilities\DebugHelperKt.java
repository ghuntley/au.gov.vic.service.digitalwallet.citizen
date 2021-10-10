package com.digitalwallet.app.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0007"}, d2 = {"debugOptionActivated", "", "Landroid/content/Context;", "name", "", "toggleDebugOption", "Landroid/content/SharedPreferences;", "app_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: DebugHelper.kt */
public final class DebugHelperKt {
    public static final boolean debugOptionActivated(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "$this$debugOptionActivated");
        Intrinsics.checkNotNullParameter(str, "name");
        SharedPreferences sharedPreferences = context.getSharedPreferences("DEBUG_SETTINGS", 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(str, false);
        }
        return false;
    }

    public static final SharedPreferences toggleDebugOption(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "$this$toggleDebugOption");
        Intrinsics.checkNotNullParameter(str, "name");
        SharedPreferences sharedPreferences = context.getSharedPreferences("DEBUG_SETTINGS", 0);
        if (sharedPreferences == null) {
            return null;
        }
        sharedPreferences.edit().putBoolean(str, !sharedPreferences.getBoolean(str, false)).apply();
        return sharedPreferences;
    }
}
