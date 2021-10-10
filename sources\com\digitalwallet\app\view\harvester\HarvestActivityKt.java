package com.digitalwallet.app.view.harvester;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.utilities.ActivityHelperKt;
import com.digitalwallet.app.view.harvester.HarvestTagView;
import com.digitalwallet.app.view.harvester.HarvestView;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\n\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\u00052\u0006\u0010\t\u001a\u00020\n\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u000b"}, d2 = {"fragmentName", "", "Lcom/digitalwallet/app/view/harvester/HarvestTagView$Screen;", "getFragmentName", "(Lcom/digitalwallet/app/view/harvester/HarvestTagView$Screen;)Ljava/lang/String;", "Lcom/digitalwallet/app/view/harvester/HarvestView$Screen;", "(Lcom/digitalwallet/app/view/harvester/HarvestView$Screen;)Ljava/lang/String;", "go", "", "activity", "Lcom/digitalwallet/app/view/harvester/HarvestActivity;", "app_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: HarvestActivity.kt */
public final class HarvestActivityKt {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[HarvestView.Screen.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[HarvestView.Screen.List.ordinal()] = 1;
            iArr[HarvestView.Screen.Consent.ordinal()] = 2;
            iArr[HarvestView.Screen.Address.ordinal()] = 3;
            iArr[HarvestView.Screen.Zone.ordinal()] = 4;
            int[] iArr2 = new int[HarvestTagView.Screen.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[HarvestTagView.Screen.Scanner.ordinal()] = 1;
            iArr2[HarvestTagView.Screen.HarvestSummary.ordinal()] = 2;
            iArr2[HarvestTagView.Screen.ManualEntry.ordinal()] = 3;
        }
    }

    public static final String getFragmentName(HarvestView.Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "$this$fragmentName");
        return "HarvestJob" + screen.name();
    }

    public static final void go(HarvestView.Screen screen, HarvestActivity harvestActivity) {
        HarvestJobListFragment harvestJobListFragment;
        Intrinsics.checkNotNullParameter(screen, "$this$go");
        Intrinsics.checkNotNullParameter(harvestActivity, "activity");
        int i = WhenMappings.$EnumSwitchMapping$0[screen.ordinal()];
        if (i == 1) {
            harvestJobListFragment = new HarvestJobListFragment();
        } else if (i == 2) {
            harvestActivity.getViewModel().clear();
            harvestJobListFragment = new HarvestJobWizardConsentFragment();
        } else if (i == 3) {
            harvestJobListFragment = new HarvestJobWizardAddressFragment();
        } else if (i == 4) {
            ActivityHelperKt.hideKeyboard(harvestActivity);
            harvestJobListFragment = new HarvestJobWizardZoneFragment();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        ((HarvestJobFragment) harvestJobListFragment).setViewModel(harvestActivity.getViewModel());
        FragmentManager supportFragmentManager = harvestActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        String fragmentName = getFragmentName(screen);
        List<Fragment> fragments = supportFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
        for (T t : fragments) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            t.setUserVisibleHint(false);
        }
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
        if (fragmentName == null) {
            fragmentName = Reflection.getOrCreateKotlinClass(Fragment.class).getSimpleName();
        }
        beginTransaction.add(R.id.fragment_container_RES_2114322527, harvestJobListFragment, fragmentName).addToBackStack(fragmentName).commit();
    }

    public static final String getFragmentName(HarvestTagView.Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "$this$fragmentName");
        return "HarvestTag" + screen.name();
    }

    public static final void go(HarvestTagView.Screen screen, HarvestActivity harvestActivity) {
        HarvestScannerFragment harvestScannerFragment;
        Intrinsics.checkNotNullParameter(screen, "$this$go");
        Intrinsics.checkNotNullParameter(harvestActivity, "activity");
        int i = WhenMappings.$EnumSwitchMapping$1[screen.ordinal()];
        if (i == 1) {
            ActivityHelperKt.hideKeyboard(harvestActivity);
            harvestScannerFragment = new HarvestScannerFragment();
        } else if (i == 2) {
            harvestScannerFragment = new HarvestTagSummaryFragment();
        } else if (i == 3) {
            harvestScannerFragment = new HarvestTagManualEntryFragment();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        ((HarvestTagFragment) harvestScannerFragment).setViewModel(harvestActivity.getTagViewModel());
        FragmentManager supportFragmentManager = harvestActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        String fragmentName = getFragmentName(screen);
        List<Fragment> fragments = supportFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
        for (T t : fragments) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            t.setUserVisibleHint(false);
        }
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
        if (fragmentName == null) {
            fragmentName = Reflection.getOrCreateKotlinClass(Fragment.class).getSimpleName();
        }
        beginTransaction.add(R.id.fragment_container_RES_2114322527, harvestScannerFragment, fragmentName).addToBackStack(fragmentName).commit();
    }
}
