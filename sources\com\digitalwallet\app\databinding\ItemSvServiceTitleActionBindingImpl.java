package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.viewmodel.svservices.TitleActionVM;

public class ItemSvServiceTitleActionBindingImpl extends ItemSvServiceTitleActionBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback65;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemSvServiceTitleActionBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private ItemSvServiceTitleActionBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2], (TextView) objArr[1]);
        this.mDirtyFlags = -1;
        this.actionIcon.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.svServiceTitle.setTag(null);
        setRootTag(view);
        this.mCallback65 = new OnClickListener(this, 1);
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
        setVm((TitleActionVM) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.ItemSvServiceTitleActionBinding
    public void setVm(TitleActionVM titleActionVM) {
        this.mVm = titleActionVM;
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = null;
        TitleActionVM titleActionVM = this.mVm;
        int i = ((3 & j) > 0 ? 1 : ((3 & j) == 0 ? 0 : -1));
        int i2 = 0;
        if (i != 0) {
            if (titleActionVM != null) {
                str = titleActionVM.getTitle();
                i2 = titleActionVM.getActionIconResId();
            }
            i2 = ViewDataBinding.safeUnbox(Integer.valueOf(i2));
        }
        if (i != 0) {
            this.actionIcon.setImageResource(i2);
            TextViewBindingAdapter.setText(this.svServiceTitle, str);
        }
        if ((j & 2) != 0) {
            this.mboundView0.setOnClickListener(this.mCallback65);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        TitleActionVM titleActionVM = this.mVm;
        if (titleActionVM != null) {
            titleActionVM.onClicked();
        }
    }
}
