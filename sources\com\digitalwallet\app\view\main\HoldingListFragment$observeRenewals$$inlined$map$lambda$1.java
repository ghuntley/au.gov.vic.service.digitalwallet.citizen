package com.digitalwallet.app.view.main;

import android.app.Application;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.DigitalWalletApplication;
import com.digitalwallet.app.model.DynamicHoldingRenewal;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.view.harvester.HarvestActivity;
import com.digitalwallet.app.view.main.HoldingListFragment;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "kotlin.jvm.PlatformType", "accept", "(Lkotlin/Unit;)V", "com/digitalwallet/app/view/main/HoldingListFragment$observeRenewals$1$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingListFragment.kt */
public final class HoldingListFragment$observeRenewals$$inlined$map$lambda$1<T> implements Consumer<Unit> {
    final /* synthetic */ SecureHolding $holding;
    final /* synthetic */ HoldingListFragment this$0;

    HoldingListFragment$observeRenewals$$inlined$map$lambda$1(SecureHolding secureHolding, HoldingListFragment holdingListFragment) {
        this.$holding = secureHolding;
        this.this$0 = holdingListFragment;
    }

    public final void accept(Unit unit) {
        String url;
        int i = HoldingListFragment.WhenMappings.$EnumSwitchMapping$2[this.$holding.getHoldingType().ordinal()];
        MainActivity mainActivity = null;
        if (i == 1 || i == 2) {
            this.this$0.getAnalytics().selectContent("Renew card - home screen", this.$holding.holdingTypeName(this.this$0.getContext()));
            Integer applyUrl = this.$holding.getHoldingElements().getApplyUrl();
            if (applyUrl != null) {
                int intValue = applyUrl.intValue();
                FragmentActivity activity = this.this$0.getActivity();
                if (activity instanceof MainActivity) {
                    mainActivity = activity;
                }
                MainActivity mainActivity2 = mainActivity;
                if (mainActivity2 != null) {
                    String string = this.this$0.getResources().getString(intValue);
                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(it)");
                    mainActivity2.startChromeCustomTabs(string, true);
                }
            }
        } else if (i == 3) {
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            EligibilityScannerFragment eligibilityScannerFragment = new EligibilityScannerFragment();
            List<Fragment> fragments = parentFragmentManager.getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
            for (T t : fragments) {
                Intrinsics.checkNotNullExpressionValue(t, "it");
                t.setUserVisibleHint(false);
            }
            FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
            String simpleName = Reflection.getOrCreateKotlinClass(EligibilityScannerFragment.class).getSimpleName();
            beginTransaction.add(R.id.fragment_container_RES_2114322527, eligibilityScannerFragment, simpleName).addToBackStack(simpleName).commit();
        } else if (i == 4) {
            HarvestActivity.Companion companion = HarvestActivity.Companion;
            FragmentActivity requireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            Intent create = companion.create(requireActivity, this.$holding.getAttributes());
            FragmentActivity requireActivity2 = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
            Application application = requireActivity2.getApplication();
            Objects.requireNonNull(application, "null cannot be cast to non-null type com.digitalwallet.DigitalWalletApplication");
            ((DigitalWalletApplication) application).setSpawnedAnotherActivity(true);
            this.this$0.startActivity(create);
        } else if (i == 5) {
            DynamicHoldingRenewal renewal = this.$holding.getRenewal();
            if (!(renewal == null || (url = renewal.getUrl()) == null)) {
                this.this$0.getAnalytics().selectContent("Renew card - home screen", this.$holding.holdingTypeName(this.this$0.getContext()));
                FragmentActivity activity2 = this.this$0.getActivity();
                Objects.requireNonNull(activity2, "null cannot be cast to non-null type com.digitalwallet.app.view.main.MainActivity");
                ((MainActivity) activity2).startChrome(url);
            }
        } else {
            throw new IllegalStateException("Unsupported holding type " + this.$holding.getHoldingType());
        }
    }
}
