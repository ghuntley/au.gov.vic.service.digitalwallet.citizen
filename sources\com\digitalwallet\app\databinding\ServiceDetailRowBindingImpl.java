package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.viewmodel.main.ServiceDetailItem;

public class ServiceDetailRowBindingImpl extends ServiceDetailRowBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ServiceDetailRowBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ServiceDetailRowBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (ImageView) objArr[3], (TextView) objArr[1]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.serviceDetailDescTextView.setTag(null);
        this.serviceDetailImageView.setTag(null);
        this.serviceDetailNameTextView.setTag(null);
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
        setVm((ServiceDetailItem) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.ServiceDetailRowBinding
    public void setVm(ServiceDetailItem serviceDetailItem) {
        this.mVm = serviceDetailItem;
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
        String str;
        int i2;
        int i3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ServiceDetailItem serviceDetailItem = this.mVm;
        int i4 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        String str2 = null;
        int i5 = 0;
        if (i4 != 0) {
            if (serviceDetailItem != null) {
                i3 = serviceDetailItem.getIcon();
                i5 = serviceDetailItem.getName();
                i2 = serviceDetailItem.getDescription();
            } else {
                i3 = 0;
                i2 = 0;
            }
            str = getRoot().getContext().getString(i5);
            String string = getRoot().getContext().getString(i2);
            i = i3;
            str2 = string;
        } else {
            i = 0;
            str = null;
        }
        if (i4 != 0) {
            TextViewBindingAdapter.setText(this.serviceDetailDescTextView, str2);
            this.serviceDetailImageView.setImageResource(i);
            TextViewBindingAdapter.setText(this.serviceDetailNameTextView, str);
        }
    }
}
