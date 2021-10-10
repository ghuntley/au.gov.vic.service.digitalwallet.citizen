package com.digitalwallet.app.view.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.digitalwallet.app.databinding.ActivityMainBinding;
import com.digitalwallet.app.view.util.ViewUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onBackStackChanged"}, k = 3, mv = {1, 4, 0})
/* compiled from: MainActivity.kt */
public final class MainActivity$onCreate$2 implements FragmentManager.OnBackStackChangedListener {
    final /* synthetic */ MainActivity this$0;

    MainActivity$onCreate$2(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public final void onBackStackChanged() {
        FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
        Fragment fragment = (Fragment) CollectionsKt.lastOrNull((List) fragments);
        if (fragment != null) {
            fragment.setUserVisibleHint(true);
        }
        FragmentManager supportFragmentManager2 = this.this$0.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "supportFragmentManager");
        if (supportFragmentManager2.getBackStackEntryCount() == 0) {
            AHBottomNavigation aHBottomNavigation = ((ActivityMainBinding) this.this$0.getBinding()).bottomNavigation;
            Intrinsics.checkNotNullExpressionValue(aHBottomNavigation, "binding.bottomNavigation");
            ViewUtilsKt.slideIn(aHBottomNavigation);
            this.this$0.getAtFront().accept(new Object());
            return;
        }
        AHBottomNavigation aHBottomNavigation2 = ((ActivityMainBinding) this.this$0.getBinding()).bottomNavigation;
        Intrinsics.checkNotNullExpressionValue(aHBottomNavigation2, "binding.bottomNavigation");
        ViewUtilsKt.slideOut(aHBottomNavigation2);
    }
}
