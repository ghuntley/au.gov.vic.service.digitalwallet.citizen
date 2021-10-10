package com.digitalwallet.app.view.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "position", "", "<anonymous parameter 1>", "onTabSelected", "com/digitalwallet/app/view/main/MainActivity$setupBottomNavigationBar$1$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: MainActivity.kt */
public final class MainActivity$setupBottomNavigationBar$$inlined$apply$lambda$1 implements AHBottomNavigation.OnTabSelectedListener {
    final /* synthetic */ AHBottomNavigation $this_apply;
    final /* synthetic */ MainActivity this$0;

    MainActivity$setupBottomNavigationBar$$inlined$apply$lambda$1(AHBottomNavigation aHBottomNavigation, MainActivity mainActivity) {
        this.$this_apply = aHBottomNavigation;
        this.this$0 = mainActivity;
    }

    @Override // com.aurelhubert.ahbottomnavigation.AHBottomNavigation.OnTabSelectedListener
    public final boolean onTabSelected(int i, boolean z) {
        if (i == this.$this_apply.getCurrentItem()) {
            return true;
        }
        FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.replace(R.id.fragment_container_RES_2114322527, (Fragment) MainActivity.access$getMenuTabs$p(this.this$0).get(i), Reflection.getOrCreateKotlinClass(Fragment.class).getSimpleName()).commit();
        this.this$0.maybeStartCardSharingSetup(i);
        return true;
    }
}
