package com.digitalwallet.app.utilities;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"hideKeyboard", "", "Landroid/app/Activity;", "app_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: ActivityHelper.kt */
public final class ActivityHelperKt {
    public static final void hideKeyboard(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$this$hideKeyboard");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            Object systemService = activity.getSystemService("input_method");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            Intrinsics.checkNotNullExpressionValue(currentFocus, "it");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }
}
