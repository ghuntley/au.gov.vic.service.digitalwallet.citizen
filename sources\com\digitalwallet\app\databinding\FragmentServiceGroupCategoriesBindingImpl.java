package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.viewmodel.svservices.ServiceGroupCategoriesViewModel;

public class FragmentServiceGroupCategoriesBindingImpl extends FragmentServiceGroupCategoriesBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback26;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.group_category_list, 4);
    }

    public FragmentServiceGroupCategoriesBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private FragmentServiceGroupCategoriesBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (RecyclerView) objArr[4], (ImageView) objArr[1], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.groupImage.setTag(null);
        this.groupName.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        setRootTag(view);
        this.mCallback26 = new OnClickListener(this, 1);
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
        setVm((ServiceGroupCategoriesViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.FragmentServiceGroupCategoriesBinding
    public void setVm(ServiceGroupCategoriesViewModel serviceGroupCategoriesViewModel) {
        this.mVm = serviceGroupCategoriesViewModel;
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
        return onChangeVmGroupName((ObservableField) obj, i2);
    }

    private boolean onChangeVmGroupName(ObservableField<String> observableField, int i) {
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
        ServiceGroupCategoriesViewModel serviceGroupCategoriesViewModel = this.mVm;
        int i = ((7 & j) > 0 ? 1 : ((7 & j) == 0 ? 0 : -1));
        String str = null;
        if (i != 0) {
            ObservableField<String> groupName = serviceGroupCategoriesViewModel != null ? serviceGroupCategoriesViewModel.getGroupName() : null;
            updateRegistration(0, groupName);
            if (groupName != null) {
                str = groupName.get();
            }
        }
        if (i != 0) {
            if (getBuildSdkInt() >= 4) {
                this.groupImage.setContentDescription(str);
            }
            TextViewBindingAdapter.setText(this.groupName, str);
        }
        if ((j & 4) != 0) {
            this.mboundView2.setOnClickListener(this.mCallback26);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        ServiceGroupCategoriesViewModel serviceGroupCategoriesViewModel = this.mVm;
        if (serviceGroupCategoriesViewModel != null) {
            serviceGroupCategoriesViewModel.onBack();
        }
    }
}
