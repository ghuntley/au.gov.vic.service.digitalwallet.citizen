package com.digitalwallet.app.view.svservices;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.login.SVCategory;
import com.digitalwallet.app.model.login.SVService;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/app/model/login/SVCategory;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: ServiceGroupCategoriesFragment.kt */
public final class ServiceGroupCategoriesFragment$observeCategoryListAction$1 extends Lambda implements Function1<SVCategory, Unit> {
    final /* synthetic */ SVService $group;
    final /* synthetic */ ServiceGroupCategoriesFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceGroupCategoriesFragment$observeCategoryListAction$1(ServiceGroupCategoriesFragment serviceGroupCategoriesFragment, SVService sVService) {
        super(1);
        this.this$0 = serviceGroupCategoriesFragment;
        this.$group = sVService;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SVCategory sVCategory) {
        invoke(sVCategory);
        return Unit.INSTANCE;
    }

    public final void invoke(SVCategory sVCategory) {
        Intrinsics.checkNotNullParameter(sVCategory, "it");
        this.this$0.getAnalytics().selectContent("Service group category", sVCategory.getId());
        ServiceCategoryTransactionsFragment serviceCategoryTransactionsFragment = new ServiceCategoryTransactionsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ServiceCategoryTransactionsFragment.SV_SERVICE_GROUP_NAME_KEY, this.$group.getTitle());
        bundle.putParcelable(ServiceCategoryTransactionsFragment.SV_SERVICE_CATEGORY_KEY, sVCategory);
        Unit unit = Unit.INSTANCE;
        serviceCategoryTransactionsFragment.setArguments(bundle);
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        List<Fragment> fragments = parentFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
        for (T t : fragments) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            t.setUserVisibleHint(false);
        }
        FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
        String simpleName = Reflection.getOrCreateKotlinClass(ServiceCategoryTransactionsFragment.class).getSimpleName();
        beginTransaction.add(R.id.fragment_container_RES_2114322527, serviceCategoryTransactionsFragment, simpleName).addToBackStack(simpleName).commit();
    }
}
