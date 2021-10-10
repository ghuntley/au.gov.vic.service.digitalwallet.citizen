package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.viewpager.widget.ViewPager;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.viewmodel.main.MainPagerFragmentViewModel;
import com.google.android.material.tabs.TabLayout;

public class FragmentMainPagerBindingImpl extends FragmentMainPagerBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.logout_btn, 2);
        sparseIntArray.put(R.id.service_main_container, 3);
        sparseIntArray.put(R.id.tabLayout, 4);
        sparseIntArray.put(R.id.viewPager, 5);
    }

    public FragmentMainPagerBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private FragmentMainPagerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[2], (ConstraintLayout) objArr[3], (TabLayout) objArr[4], (TextView) objArr[1], (ViewPager) objArr[5]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.title.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (8257543 != i) {
            return false;
        }
        setVm((MainPagerFragmentViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.FragmentMainPagerBinding
    public void setVm(MainPagerFragmentViewModel mainPagerFragmentViewModel) {
        this.mVm = mainPagerFragmentViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeVmTitle((ObservableField) obj, i2);
    }

    private boolean onChangeVmTitle(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        MainPagerFragmentViewModel mainPagerFragmentViewModel = this.mVm;
        int i = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        String str = null;
        if (i != 0) {
            ObservableField<String> title = mainPagerFragmentViewModel != null ? mainPagerFragmentViewModel.getTitle() : null;
            updateRegistration(0, title);
            if (title != null) {
                str = title.get();
            }
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.title, str);
        }
    }
}
