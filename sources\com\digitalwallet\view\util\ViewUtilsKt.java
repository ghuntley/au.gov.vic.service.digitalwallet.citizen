package com.digitalwallet.view.util;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.view.main.BackHandler;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import net.openid.appauth.AuthorizationRequest;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aD\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\b¢\u0006\u0002\u0010\u000b\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0003\u001al\u0010\r\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0003\u0010\u000e\u001a\u00020\u00012\b\b\u0003\u0010\u000f\u001a\u00020\u00012\b\b\u0003\u0010\u0010\u001a\u00020\u00012\b\b\u0003\u0010\u0011\u001a\u00020\u0001H\b¢\u0006\u0002\u0010\u0012\u001aD\u0010\u0013\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\b¢\u0006\u0002\u0010\u000b\u001a\n\u0010\u0014\u001a\u00020\u0015*\u00020\u0016\u001a\n\u0010\u0017\u001a\u00020\u0015*\u00020\u0018¨\u0006\u0019"}, d2 = {"addFragmentToContainer", "", "T", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/FragmentManager;", AuthorizationRequest.ResponseMode.FRAGMENT, "containerId", "shouldAnimate", "", "name", "", "(Landroidx/fragment/app/FragmentManager;Landroidx/fragment/app/Fragment;IZLjava/lang/String;)I", "getContainerId", "replaceFragmentContainerWithBackStack", "enter", "exit", "popEnter", "popExit", "(Landroidx/fragment/app/FragmentManager;Landroidx/fragment/app/Fragment;IZLjava/lang/String;IIII)I", "replaceFragmentInContainer", "showKeyboard", "", "Landroid/widget/EditText;", "supportBackHandlerPress", "Landroidx/appcompat/app/AppCompatActivity;", "base_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: ViewUtils.kt */
public final class ViewUtilsKt {
    public static final void supportBackHandlerPress(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "$this$supportBackHandlerPress");
        FragmentManager supportFragmentManager = appCompatActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.getBackStackEntryCount() == 0) {
            appCompatActivity.moveTaskToBack(true);
            return;
        }
        FragmentManager supportFragmentManager2 = appCompatActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager2.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
        Fragment fragment = (Fragment) CollectionsKt.lastOrNull((List) fragments);
        if (!(fragment instanceof BackHandler)) {
            fragment = null;
        }
        BackHandler backHandler = (BackHandler) fragment;
        if (!(backHandler != null ? backHandler.handleBack() : false)) {
            appCompatActivity.getSupportFragmentManager().popBackStackImmediate();
        }
    }

    public static /* synthetic */ int replaceFragmentContainerWithBackStack$default(FragmentManager fragmentManager, Fragment fragment, int i, boolean z, String str, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            z = false;
        }
        if ((i6 & 8) != 0) {
            str = null;
        }
        if ((i6 & 16) != 0) {
            i2 = R.anim.enter_from_right;
        }
        if ((i6 & 32) != 0) {
            i3 = R.anim.exit_to_left;
        }
        if ((i6 & 64) != 0) {
            i4 = R.anim.enter_from_left;
        }
        if ((i6 & 128) != 0) {
            i5 = R.anim.exit_to_right;
        }
        Intrinsics.checkNotNullParameter(fragmentManager, "$this$replaceFragmentContainerWithBackStack");
        Intrinsics.checkNotNullParameter(fragment, AuthorizationRequest.ResponseMode.FRAGMENT);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        if (z) {
            beginTransaction.setCustomAnimations(i2, i3, i4, i5);
        }
        if (str == null) {
            Intrinsics.reifiedOperationMarker(4, "T");
            str = Reflection.getOrCreateKotlinClass(Fragment.class).getSimpleName();
        }
        return beginTransaction.replace(i, fragment, str).addToBackStack(null).commit();
    }

    public static final /* synthetic */ <T extends Fragment> int replaceFragmentContainerWithBackStack(FragmentManager fragmentManager, T t, int i, boolean z, String str, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(fragmentManager, "$this$replaceFragmentContainerWithBackStack");
        Intrinsics.checkNotNullParameter(t, AuthorizationRequest.ResponseMode.FRAGMENT);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        if (z) {
            beginTransaction.setCustomAnimations(i2, i3, i4, i5);
        }
        if (str == null) {
            Intrinsics.reifiedOperationMarker(4, "T");
            str = Reflection.getOrCreateKotlinClass(Fragment.class).getSimpleName();
        }
        return beginTransaction.replace(i, t, str).addToBackStack(null).commit();
    }

    public static final int getContainerId(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "$this$getContainerId");
        View view = fragment.getView();
        Intrinsics.checkNotNull(view);
        Intrinsics.checkNotNullExpressionValue(view, "view!!");
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent);
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        return ((ViewGroup) parent).getId();
    }

    public static /* synthetic */ int addFragmentToContainer$default(FragmentManager fragmentManager, Fragment fragment, int i, boolean z, String str, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(fragmentManager, "$this$addFragmentToContainer");
        Intrinsics.checkNotNullParameter(fragment, AuthorizationRequest.ResponseMode.FRAGMENT);
        List<Fragment> fragments = fragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
        for (T t : fragments) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            t.setUserVisibleHint(false);
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        if (z) {
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
        }
        if (str == null) {
            Intrinsics.reifiedOperationMarker(4, "T");
            str = Reflection.getOrCreateKotlinClass(Fragment.class).getSimpleName();
        }
        return beginTransaction.add(i, fragment, str).addToBackStack(str).commit();
    }

    public static final /* synthetic */ <T extends Fragment> int addFragmentToContainer(FragmentManager fragmentManager, T t, int i, boolean z, String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "$this$addFragmentToContainer");
        Intrinsics.checkNotNullParameter(t, AuthorizationRequest.ResponseMode.FRAGMENT);
        List<Fragment> fragments = fragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
        for (T t2 : fragments) {
            Intrinsics.checkNotNullExpressionValue(t2, "it");
            t2.setUserVisibleHint(false);
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        if (z) {
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
        }
        if (str == null) {
            Intrinsics.reifiedOperationMarker(4, "T");
            str = Reflection.getOrCreateKotlinClass(Fragment.class).getSimpleName();
        }
        return beginTransaction.add(i, t, str).addToBackStack(str).commit();
    }

    public static /* synthetic */ int replaceFragmentInContainer$default(FragmentManager fragmentManager, Fragment fragment, int i, boolean z, String str, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(fragmentManager, "$this$replaceFragmentInContainer");
        Intrinsics.checkNotNullParameter(fragment, AuthorizationRequest.ResponseMode.FRAGMENT);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        if (z) {
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down);
        }
        if (str == null) {
            Intrinsics.reifiedOperationMarker(4, "T");
            str = Reflection.getOrCreateKotlinClass(Fragment.class).getSimpleName();
        }
        return beginTransaction.replace(i, fragment, str).commit();
    }

    public static final /* synthetic */ <T extends Fragment> int replaceFragmentInContainer(FragmentManager fragmentManager, T t, int i, boolean z, String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "$this$replaceFragmentInContainer");
        Intrinsics.checkNotNullParameter(t, AuthorizationRequest.ResponseMode.FRAGMENT);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        if (z) {
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down);
        }
        if (str == null) {
            Intrinsics.reifiedOperationMarker(4, "T");
            str = Reflection.getOrCreateKotlinClass(Fragment.class).getSimpleName();
        }
        return beginTransaction.replace(i, t, str).commit();
    }

    public static final void showKeyboard(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "$this$showKeyboard");
        Object systemService = editText.getContext().getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
    }
}
