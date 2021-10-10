package com.digitalwallet.app.view.login;

import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import au.gov.vic.service.digitalwallet.citizen.R;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/digitalwallet/app/view/login/HomeServicesFragment$setupSVServices$3", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HomeServicesFragment.kt */
public final class HomeServicesFragment$setupSVServices$3 implements ViewPager.OnPageChangeListener {
    final /* synthetic */ List $pagingDots;
    final /* synthetic */ HomeServicesFragment this$0;

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    HomeServicesFragment$setupSVServices$3(HomeServicesFragment homeServicesFragment, List list) {
        this.this$0 = homeServicesFragment;
        this.$pagingDots = list;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int size = this.$pagingDots.size();
        int i2 = 0;
        while (i2 < size) {
            ((ImageView) this.$pagingDots.get(i2)).setImageDrawable(this.this$0.getResources().getDrawable(i2 == i ? R.drawable.pill_slate : R.drawable.pill_light, null));
            i2++;
        }
    }
}
