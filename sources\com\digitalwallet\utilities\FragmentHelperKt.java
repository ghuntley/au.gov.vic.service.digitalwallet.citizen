package com.digitalwallet.utilities;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"hideKeyboard", "", "Landroidx/fragment/app/Fragment;", "openURL", "uriString", "", "base_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: FragmentHelper.kt */
public final class FragmentHelperKt {
    public static final void hideKeyboard(Fragment fragment) {
        View currentFocus;
        Intrinsics.checkNotNullParameter(fragment, "$this$hideKeyboard");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null && (currentFocus = activity.getCurrentFocus()) != null) {
            FragmentActivity activity2 = fragment.getActivity();
            Object systemService = activity2 != null ? activity2.getSystemService("input_method") : null;
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            Intrinsics.checkNotNullExpressionValue(currentFocus, "it");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    public static final void openURL(Fragment fragment, String str) {
        Intrinsics.checkNotNullParameter(fragment, "$this$openURL");
        Intrinsics.checkNotNullParameter(str, "uriString");
        Uri build = Uri.parse(str).buildUpon().appendQueryParameter("channel", "mobileApplication").build();
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Intrinsics.checkNotNullExpressionValue(build, "uri");
        ActivityHelperKt.viewURI(requireContext, build);
    }
}
