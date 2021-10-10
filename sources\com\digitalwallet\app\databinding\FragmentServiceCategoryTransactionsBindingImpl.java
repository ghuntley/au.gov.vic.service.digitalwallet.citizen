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
import com.digitalwallet.app.viewmodel.svservices.ServiceCategoryTransactionsViewModel;

public class FragmentServiceCategoryTransactionsBindingImpl extends FragmentServiceCategoryTransactionsBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback53;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.category_transaction_list, 5);
    }

    public FragmentServiceCategoryTransactionsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private FragmentServiceCategoryTransactionsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ImageView) objArr[1], (TextView) objArr[4], (RecyclerView) objArr[5], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.categoryImage.setTag(null);
        this.categoryName.setTag(null);
        this.groupName.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        setRootTag(view);
        this.mCallback53 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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
        setVm((ServiceCategoryTransactionsViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.FragmentServiceCategoryTransactionsBinding
    public void setVm(ServiceCategoryTransactionsViewModel serviceCategoryTransactionsViewModel) {
        this.mVm = serviceCategoryTransactionsViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeVmCategoryName((ObservableField) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeVmGroupName((ObservableField) obj, i2);
    }

    private boolean onChangeVmCategoryName(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmGroupName(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ServiceCategoryTransactionsViewModel serviceCategoryTransactionsViewModel = this.mVm;
        String str2 = null;
        if ((15 & j) != 0) {
            if ((j & 13) != 0) {
                ObservableField<String> categoryName = serviceCategoryTransactionsViewModel != null ? serviceCategoryTransactionsViewModel.getCategoryName() : null;
                updateRegistration(0, categoryName);
                if (categoryName != null) {
                    str = categoryName.get();
                    if ((j & 14) != 0) {
                        ObservableField<String> groupName = serviceCategoryTransactionsViewModel != null ? serviceCategoryTransactionsViewModel.getGroupName() : null;
                        updateRegistration(1, groupName);
                        if (groupName != null) {
                            str2 = groupName.get();
                        }
                    }
                }
            }
            str = null;
            if ((j & 14) != 0) {
            }
        } else {
            str = null;
        }
        if ((13 & j) != 0) {
            if (getBuildSdkInt() >= 4) {
                this.categoryImage.setContentDescription(str);
            }
            TextViewBindingAdapter.setText(this.categoryName, str);
        }
        if ((j & 14) != 0) {
            TextViewBindingAdapter.setText(this.groupName, str2);
        }
        if ((j & 8) != 0) {
            this.mboundView2.setOnClickListener(this.mCallback53);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        ServiceCategoryTransactionsViewModel serviceCategoryTransactionsViewModel = this.mVm;
        if (serviceCategoryTransactionsViewModel != null) {
            serviceCategoryTransactionsViewModel.onBack();
        }
    }
}
