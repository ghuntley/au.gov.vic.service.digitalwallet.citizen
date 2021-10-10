package com.digitalwallet.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import au.gov.vic.service.digitalwallet.citizen.R;

public class LayoutCheckInTitleBarBindingImpl extends LayoutCheckInTitleBarBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView2;

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.help_button, 3);
    }

    public LayoutCheckInTitleBarBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private LayoutCheckInTitleBarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (ImageView) objArr[3]);
        this.mDirtyFlags = -1;
        this.backButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
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
        if (7 == i) {
            setTitle((String) obj);
        } else if (4 != i) {
            return false;
        } else {
            setShowBack((Boolean) obj);
        }
        return true;
    }

    @Override // com.digitalwallet.databinding.LayoutCheckInTitleBarBinding
    public void setTitle(String str) {
        this.mTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    @Override // com.digitalwallet.databinding.LayoutCheckInTitleBarBinding
    public void setShowBack(Boolean bool) {
        this.mShowBack = bool;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = this.mTitle;
        Boolean bool = this.mShowBack;
        int i = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        int i2 = 0;
        if (i != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i != 0) {
                j |= safeUnbox ? 16 : 8;
            }
            if (!safeUnbox) {
                i2 = 4;
            }
        }
        if ((j & 6) != 0) {
            this.backButton.setVisibility(i2);
        }
        if ((j & 5) != 0) {
            TextViewBindingAdapter.setText(this.mboundView2, str);
        }
    }
}
