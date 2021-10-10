package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.viewmodel.main.ServiceTypeItem;

public class ServiceTypeCardBindingImpl extends ServiceTypeCardBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
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
        sparseIntArray.put(R.id.cardView, 3);
    }

    public ServiceTypeCardBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ServiceTypeCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (CardView) objArr[3], (ImageView) objArr[1], (TextView) objArr[2]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.serviceTypeImageView.setTag(null);
        this.serviceTypeNameTextView.setTag(null);
        setRootTag(view);
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
        setVm((ServiceTypeItem) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.ServiceTypeCardBinding
    public void setVm(ServiceTypeItem serviceTypeItem) {
        this.mVm = serviceTypeItem;
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
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = null;
        ServiceTypeItem serviceTypeItem = this.mVm;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        int i3 = 0;
        if (i2 != 0) {
            if (serviceTypeItem != null) {
                i3 = serviceTypeItem.getImage();
                i = serviceTypeItem.getName();
            } else {
                i = 0;
            }
            i3 = ViewDataBinding.safeUnbox(Integer.valueOf(i3));
            str = getRoot().getContext().getString(i);
        }
        if (i2 != 0) {
            this.serviceTypeImageView.setImageResource(i3);
            TextViewBindingAdapter.setText(this.serviceTypeNameTextView, str);
        }
    }
}
