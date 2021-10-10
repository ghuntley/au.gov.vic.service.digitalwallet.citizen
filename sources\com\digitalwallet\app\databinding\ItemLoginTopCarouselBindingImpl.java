package com.digitalwallet.app.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.viewmodel.svservices.SVItemViewModel;

public class ItemLoginTopCarouselBindingImpl extends ItemLoginTopCarouselBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback13;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final ImageView mboundView1;

    public ItemLoginTopCarouselBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, sIncludes, sViewsWithIds));
    }

    private ItemLoginTopCarouselBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        setRootTag(view);
        this.mCallback13 = new OnClickListener(this, 1);
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
        setVm((SVItemViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.ItemLoginTopCarouselBinding
    public void setVm(SVItemViewModel sVItemViewModel) {
        this.mVm = sVItemViewModel;
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
        return onChangeVmImageDrawable((ObservableField) obj, i2);
    }

    private boolean onChangeVmImageDrawable(ObservableField<Drawable> observableField, int i) {
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
        Drawable drawable;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        SVItemViewModel sVItemViewModel = this.mVm;
        int i = ((7 & j) > 0 ? 1 : ((7 & j) == 0 ? 0 : -1));
        String str = null;
        Drawable drawable2 = null;
        if (i != 0) {
            String itemId = ((j & 6) == 0 || sVItemViewModel == null) ? null : sVItemViewModel.getItemId();
            ObservableField<Drawable> imageDrawable = sVItemViewModel != null ? sVItemViewModel.getImageDrawable() : null;
            updateRegistration(0, imageDrawable);
            if (imageDrawable != null) {
                drawable2 = imageDrawable.get();
            }
            drawable = drawable2;
            str = itemId;
        } else {
            drawable = null;
        }
        if ((4 & j) != 0) {
            this.mboundView0.setOnClickListener(this.mCallback13);
        }
        if ((j & 6) != 0 && getBuildSdkInt() >= 4) {
            this.mboundView1.setContentDescription(str);
        }
        if (i != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView1, drawable);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        SVItemViewModel sVItemViewModel = this.mVm;
        if (sVItemViewModel != null) {
            sVItemViewModel.onClicked();
        }
    }
}
