package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.model.transaction.TransactionHistoryItem;

public class ItemTransactionHistoryBindingImpl extends ItemTransactionHistoryBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemTransactionHistoryBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemTransactionHistoryBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (TextView) objArr[2], (TextView) objArr[4], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.date.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.name.setTag(null);
        this.refNum.setTag(null);
        this.status.setTag(null);
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
        setVm((TransactionHistoryItem) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.ItemTransactionHistoryBinding
    public void setVm(TransactionHistoryItem transactionHistoryItem) {
        this.mVm = transactionHistoryItem;
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
        String str2;
        String str3;
        String str4;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        TransactionHistoryItem transactionHistoryItem = this.mVm;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        int i2 = 0;
        String str5 = null;
        if (i != 0) {
            if (transactionHistoryItem != null) {
                z = transactionHistoryItem.getShowReferenceNumber();
                str2 = transactionHistoryItem.getTransactionReferenceNumber();
                str4 = transactionHistoryItem.getCreatedDateFormatted();
                str = transactionHistoryItem.getStatus();
                str3 = transactionHistoryItem.getName();
            } else {
                str3 = null;
                str2 = null;
                str4 = null;
                str = null;
                z = false;
            }
            boolean safeUnbox = ViewDataBinding.safeUnbox(Boolean.valueOf(z));
            if (i != 0) {
                j |= safeUnbox ? 8 : 4;
            }
            if (!safeUnbox) {
                i2 = 8;
            }
            str5 = str4;
        } else {
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((j & 3) != 0) {
            TextViewBindingAdapter.setText(this.date, str5);
            TextViewBindingAdapter.setText(this.name, str3);
            TextViewBindingAdapter.setText(this.refNum, str2);
            this.refNum.setVisibility(i2);
            TextViewBindingAdapter.setText(this.status, str);
        }
    }
}
