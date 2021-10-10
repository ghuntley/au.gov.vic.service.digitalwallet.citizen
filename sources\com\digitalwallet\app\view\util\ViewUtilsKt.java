package com.digitalwallet.app.view.util;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.digitalwallet.app.model.AttributeDetailItem;
import com.digitalwallet.app.view.main.adapter.AttributeDetailsAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import net.openid.appauth.AuthorizationRequest;
import org.bouncycastle.i18n.ErrorBundle;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a<\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\b¢\u0006\u0002\u0010\n\u001a\u0018\u0010\u000b\u001a\u00020\f*\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u001a<\u0010\u0011\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\b¢\u0006\u0002\u0010\n\u001a\n\u0010\u0012\u001a\u00020\f*\u00020\u0013\u001a\n\u0010\u0014\u001a\u00020\f*\u00020\u0013\u001a$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00160\u000f¨\u0006\u0017"}, d2 = {"addDWFragment", "", "T", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/FragmentManager;", AuthorizationRequest.ResponseMode.FRAGMENT, "shouldAnimate", "", "name", "", "(Landroidx/fragment/app/FragmentManager;Landroidx/fragment/app/Fragment;ZLjava/lang/String;)I", "initDetails", "", "Landroidx/recyclerview/widget/RecyclerView;", ErrorBundle.DETAIL_ENTRY, "", "Lcom/digitalwallet/app/model/AttributeDetailItem;", "replaceDWFragment", "slideIn", "Lcom/aurelhubert/ahbottomnavigation/AHBottomNavigation;", "slideOut", "toAttributeDetailItem", "Lkotlin/Pair;", "app_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: ViewUtils.kt */
public final class ViewUtilsKt {
    public static final void initDetails(RecyclerView recyclerView, List<AttributeDetailItem> list) {
        Intrinsics.checkNotNullParameter(recyclerView, "$this$initDetails");
        Intrinsics.checkNotNullParameter(list, ErrorBundle.DETAIL_ENTRY);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setAdapter(new AttributeDetailsAdapter(list));
    }

    public static final List<AttributeDetailItem> toAttributeDetailItem(List<Pair<Integer, String>> list) {
        Intrinsics.checkNotNullParameter(list, "$this$toAttributeDetailItem");
        List<Pair<Integer, String>> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (T t : list2) {
            int intValue = ((Number) t.component1()).intValue();
            String str = (String) t.component2();
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                str = AttributeDetailItem.NOT_AVAILABLE;
            }
            arrayList.add(new AttributeDetailItem(intValue, str));
        }
        return arrayList;
    }

    public static final void slideIn(AHBottomNavigation aHBottomNavigation) {
        Intrinsics.checkNotNullParameter(aHBottomNavigation, "$this$slideIn");
        aHBottomNavigation.animate().translationY(0.0f).withStartAction(new ViewUtilsKt$slideIn$1(aHBottomNavigation));
    }

    public static final void slideOut(AHBottomNavigation aHBottomNavigation) {
        Intrinsics.checkNotNullParameter(aHBottomNavigation, "$this$slideOut");
        aHBottomNavigation.animate().translationY((float) aHBottomNavigation.getHeight()).withEndAction(new ViewUtilsKt$slideOut$1(aHBottomNavigation));
    }

    public static /* synthetic */ int addDWFragment$default(FragmentManager fragmentManager, Fragment fragment, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(fragmentManager, "$this$addDWFragment");
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
        return beginTransaction.add(R.id.fragment_container_RES_2114322527, fragment, str).addToBackStack(str).commit();
    }

    public static final /* synthetic */ <T extends Fragment> int addDWFragment(FragmentManager fragmentManager, T t, boolean z, String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "$this$addDWFragment");
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
        return beginTransaction.add(R.id.fragment_container_RES_2114322527, t, str).addToBackStack(str).commit();
    }

    public static /* synthetic */ int replaceDWFragment$default(FragmentManager fragmentManager, Fragment fragment, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(fragmentManager, "$this$replaceDWFragment");
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
        return beginTransaction.replace(R.id.fragment_container_RES_2114322527, fragment, str).commit();
    }

    public static final /* synthetic */ <T extends Fragment> int replaceDWFragment(FragmentManager fragmentManager, T t, boolean z, String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "$this$replaceDWFragment");
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
        return beginTransaction.replace(R.id.fragment_container_RES_2114322527, t, str).commit();
    }
}
