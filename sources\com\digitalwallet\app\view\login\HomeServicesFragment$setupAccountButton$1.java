package com.digitalwallet.app.view.login;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.model.RemoteConfig;
import com.digitalwallet.model.RemoteFeatureFlags;
import com.digitalwallet.utilities.AnalyticsHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 0})
/* compiled from: HomeServicesFragment.kt */
public final class HomeServicesFragment$setupAccountButton$1 implements View.OnClickListener {
    final /* synthetic */ HomeServicesFragment this$0;

    HomeServicesFragment$setupAccountButton$1(HomeServicesFragment homeServicesFragment) {
        this.this$0 = homeServicesFragment;
    }

    public final void onClick(View view) {
        RemoteFeatureFlags features;
        LoginActivity loginActivity = null;
        AnalyticsHelper.selectContent$default(this.this$0.getAnalytics(), "Button click - Home screen - Account", null, 2, null);
        if (this.this$0.getViewModel().isCitizen()) {
            RemoteConfig cached = this.this$0.getRemoteConfigService().getCached();
            if (Intrinsics.areEqual((Object) ((cached == null || (features = cached.getFeatures()) == null) ? null : features.getCreateAccountEnabled()), (Object) true)) {
                FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                CreateAccountFragment createAccountFragment = new CreateAccountFragment();
                List<Fragment> fragments = parentFragmentManager.getFragments();
                Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
                for (T t : fragments) {
                    Intrinsics.checkNotNullExpressionValue(t, "it");
                    t.setUserVisibleHint(false);
                }
                FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
                Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
                beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
                String simpleName = Reflection.getOrCreateKotlinClass(CreateAccountFragment.class).getSimpleName();
                beginTransaction.add(R.id.fragment_container_RES_2114322527, createAccountFragment, simpleName).addToBackStack(simpleName).commit();
                return;
            }
        }
        FragmentActivity activity = this.this$0.getActivity();
        if (activity instanceof LoginActivity) {
            loginActivity = activity;
        }
        LoginActivity loginActivity2 = loginActivity;
        if (loginActivity2 != null) {
            loginActivity2.login();
        }
    }
}
