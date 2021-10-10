package com.digitalwallet.app.view.login.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.digitalwallet.app.databinding.ItemLoginTopCarouselBinding;
import com.digitalwallet.app.viewmodel.svservices.SVItemViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/view/login/adapter/TopCarouselPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "carouselVMs", "", "Lcom/digitalwallet/app/viewmodel/svservices/SVItemViewModel;", "(Ljava/util/List;)V", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "instantiateItem", "isViewFromObject", "", "p0", "Landroid/view/View;", "p1", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: TopCarouselPagerAdapter.kt */
public final class TopCarouselPagerAdapter extends PagerAdapter {
    private final List<SVItemViewModel> carouselVMs;

    public TopCarouselPagerAdapter(List<SVItemViewModel> list) {
        Intrinsics.checkNotNullParameter(list, "carouselVMs");
        this.carouselVMs = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.carouselVMs.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        Intrinsics.checkNotNullParameter(view, "p0");
        Intrinsics.checkNotNullParameter(obj, "p1");
        return Intrinsics.areEqual(view, obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        ItemLoginTopCarouselBinding inflate = ItemLoginTopCarouselBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "ItemLoginTopCarouselBind…flater, container, false)");
        inflate.setVm(this.carouselVMs.get(i));
        viewGroup.addView(inflate.getRoot());
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(obj, "object");
        View view = (View) (!(obj instanceof View) ? null : obj);
        if (view != null) {
            viewGroup.removeView(view);
        } else {
            super.destroyItem(viewGroup, i, obj);
        }
    }
}
