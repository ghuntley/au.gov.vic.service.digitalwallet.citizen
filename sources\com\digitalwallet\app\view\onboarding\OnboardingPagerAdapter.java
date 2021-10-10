package com.digitalwallet.app.view.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.digitalwallet.app.R;
import com.digitalwallet.app.databinding.OnboardingPageBinding;
import com.digitalwallet.app.model.P2PMessage;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0003\r\u000e\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\u0010"}, d2 = {"Lcom/digitalwallet/app/view/onboarding/OnboardingPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "(Landroidx/fragment/app/FragmentManager;)V", "createFragment", "Landroidx/fragment/app/Fragment;", "copy", "Lcom/digitalwallet/app/view/onboarding/OnboardingPagerAdapter$Resources;", "getCount", "", "getItem", "position", "Companion", "Resources", "SimpleFragment", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: OnboardingPagerAdapter.kt */
public final class OnboardingPagerAdapter extends FragmentPagerAdapter {
    public static final Companion Companion = new Companion(null);
    private static final int itemCount;
    private static final List<Resources> items;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnboardingPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager, 1);
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/digitalwallet/app/view/onboarding/OnboardingPagerAdapter$Companion;", "", "()V", "itemCount", "", "getItemCount", "()I", FirebaseAnalytics.Param.ITEMS, "", "Lcom/digitalwallet/app/view/onboarding/OnboardingPagerAdapter$Resources;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: OnboardingPagerAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getItemCount() {
            return OnboardingPagerAdapter.itemCount;
        }
    }

    static {
        List<Resources> listOf = CollectionsKt.listOf((Object[]) new Resources[]{new Resources(R.drawable.onboard_1, au.gov.vic.service.digitalwallet.citizen.R.string.onboarding_1_heading, au.gov.vic.service.digitalwallet.citizen.R.string.onboarding_1_body), new Resources(au.gov.vic.service.digitalwallet.citizen.R.drawable.onboard_2, au.gov.vic.service.digitalwallet.citizen.R.string.onboarding_2_heading, au.gov.vic.service.digitalwallet.citizen.R.string.onboarding_2_body), new Resources(au.gov.vic.service.digitalwallet.citizen.R.drawable.onboard_3, au.gov.vic.service.digitalwallet.citizen.R.string.onboarding_3_heading, au.gov.vic.service.digitalwallet.citizen.R.string.onboarding_3_body)});
        items = listOf;
        itemCount = listOf.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return createFragment(items.get(i));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return itemCount;
    }

    /* access modifiers changed from: private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/view/onboarding/OnboardingPagerAdapter$Resources;", "", "image", "", "heading", P2PMessage.contentsKey, "(III)V", "getBody", "()I", "getHeading", "getImage", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: OnboardingPagerAdapter.kt */
    public static final class Resources {
        private final int body;
        private final int heading;
        private final int image;

        public static /* synthetic */ Resources copy$default(Resources resources, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = resources.image;
            }
            if ((i4 & 2) != 0) {
                i2 = resources.heading;
            }
            if ((i4 & 4) != 0) {
                i3 = resources.body;
            }
            return resources.copy(i, i2, i3);
        }

        public final int component1() {
            return this.image;
        }

        public final int component2() {
            return this.heading;
        }

        public final int component3() {
            return this.body;
        }

        public final Resources copy(int i, int i2, int i3) {
            return new Resources(i, i2, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Resources)) {
                return false;
            }
            Resources resources = (Resources) obj;
            return this.image == resources.image && this.heading == resources.heading && this.body == resources.body;
        }

        public int hashCode() {
            return (((this.image * 31) + this.heading) * 31) + this.body;
        }

        public String toString() {
            return "Resources(image=" + this.image + ", heading=" + this.heading + ", body=" + this.body + ")";
        }

        public Resources(int i, int i2, int i3) {
            this.image = i;
            this.heading = i2;
            this.body = i3;
        }

        public final int getBody() {
            return this.body;
        }

        public final int getHeading() {
            return this.heading;
        }

        public final int getImage() {
            return this.image;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/digitalwallet/app/view/onboarding/OnboardingPagerAdapter$SimpleFragment;", "Landroidx/fragment/app/Fragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: OnboardingPagerAdapter.kt */
    public static final class SimpleFragment extends Fragment {
        private HashMap _$_findViewCache;

        public void _$_clearFindViewByIdCache() {
            HashMap hashMap = this._$_findViewCache;
            if (hashMap != null) {
                hashMap.clear();
            }
        }

        public View _$_findCachedViewById(int i) {
            if (this._$_findViewCache == null) {
                this._$_findViewCache = new HashMap();
            }
            View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
            if (view != null) {
                return view;
            }
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            View findViewById = view2.findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }

        @Override // androidx.fragment.app.Fragment
        public /* synthetic */ void onDestroyView() {
            super.onDestroyView();
            _$_clearFindViewByIdCache();
        }

        @Override // androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
            Bundle arguments = getArguments();
            Intrinsics.checkNotNull(arguments);
            int i = arguments.getInt(P2PMessage.contentsKey);
            Bundle arguments2 = getArguments();
            Intrinsics.checkNotNull(arguments2);
            int i2 = arguments2.getInt("heading");
            Bundle arguments3 = getArguments();
            Intrinsics.checkNotNull(arguments3);
            int i3 = arguments3.getInt("image");
            OnboardingPageBinding inflate = OnboardingPageBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "OnboardingPageBinding.in…flater, container, false)");
            inflate.image.setImageResource(i3);
            TextView textView = inflate.copy1;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.copy1");
            textView.setText(getString(i2));
            TextView textView2 = inflate.copy2;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.copy2");
            textView2.setText(getString(i));
            return inflate.getRoot();
        }
    }

    private final Fragment createFragment(Resources resources) {
        SimpleFragment simpleFragment = new SimpleFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("image", resources.getImage());
        bundle.putInt("heading", resources.getHeading());
        bundle.putInt(P2PMessage.contentsKey, resources.getBody());
        Unit unit = Unit.INSTANCE;
        simpleFragment.setArguments(bundle);
        return simpleFragment;
    }
}
