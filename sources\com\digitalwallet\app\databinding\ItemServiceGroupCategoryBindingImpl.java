package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.viewmodel.svservices.SVCategoryViewModel;

public class ItemServiceGroupCategoryBindingImpl extends ItemServiceGroupCategoryBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback64;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.next_icon, 3);
    }

    public ItemServiceGroupCategoryBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemServiceGroupCategoryBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (TextView) objArr[1], (ImageView) objArr[3]);
        this.mDirtyFlags = -1;
        this.categoryDescription.setTag(null);
        this.categoryTitle.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        this.mCallback64 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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
        setVm((SVCategoryViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.ItemServiceGroupCategoryBinding
    public void setVm(SVCategoryViewModel sVCategoryViewModel) {
        this.mVm = sVCategoryViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        SVCategoryViewModel sVCategoryViewModel = this.mVm;
        int i = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        String str2 = null;
        if (i == 0 || sVCategoryViewModel == null) {
            str = null;
        } else {
            String title = sVCategoryViewModel.getTitle();
            str2 = sVCategoryViewModel.getDescription();
            str = title;
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.categoryDescription, str2);
            TextViewBindingAdapter.setText(this.categoryTitle, str);
        }
        if ((j & 2) != 0) {
            this.mboundView0.setOnClickListener(this.mCallback64);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        SVCategoryViewModel sVCategoryViewModel = this.mVm;
        if (sVCategoryViewModel != null) {
            sVCategoryViewModel.onClicked();
        }
    }
}
