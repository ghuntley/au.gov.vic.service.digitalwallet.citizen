package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.viewmodel.harvester.HarvestJobViewHolder;

public class HarvesterItemJobBindingImpl extends HarvesterItemJobBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback27;
    private final View.OnClickListener mCallback28;
    private long mDirtyFlags;
    private final GridLayout mboundView0;
    private final TextView mboundView1;
    private final Button mboundView2;
    private final Button mboundView3;

    public HarvesterItemJobBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private HarvesterItemJobBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.mDirtyFlags = -1;
        GridLayout gridLayout = (GridLayout) objArr[0];
        this.mboundView0 = gridLayout;
        gridLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        Button button = (Button) objArr[2];
        this.mboundView2 = button;
        button.setTag(null);
        Button button2 = (Button) objArr[3];
        this.mboundView3 = button2;
        button2.setTag(null);
        setRootTag(view);
        this.mCallback27 = new OnClickListener(this, 1);
        this.mCallback28 = new OnClickListener(this, 2);
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
        setVm((HarvestJobViewHolder) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.HarvesterItemJobBinding
    public void setVm(HarvestJobViewHolder harvestJobViewHolder) {
        this.mVm = harvestJobViewHolder;
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
        return onChangeVmAddress((ObservableField) obj, i2);
    }

    private boolean onChangeVmAddress(ObservableField<String> observableField, int i) {
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
        HarvestJobViewHolder harvestJobViewHolder = this.mVm;
        int i = ((7 & j) > 0 ? 1 : ((7 & j) == 0 ? 0 : -1));
        String str = null;
        if (i != 0) {
            ObservableField<String> address = harvestJobViewHolder != null ? harvestJobViewHolder.getAddress() : null;
            updateRegistration(0, address);
            if (address != null) {
                str = address.get();
            }
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, str);
        }
        if ((j & 4) != 0) {
            this.mboundView2.setOnClickListener(this.mCallback27);
            this.mboundView3.setOnClickListener(this.mCallback28);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            HarvestJobViewHolder harvestJobViewHolder = this.mVm;
            if (harvestJobViewHolder != null) {
                z = true;
            }
            if (z) {
                harvestJobViewHolder.closeJob();
            }
        } else if (i == 2) {
            HarvestJobViewHolder harvestJobViewHolder2 = this.mVm;
            if (harvestJobViewHolder2 != null) {
                z = true;
            }
            if (z) {
                harvestJobViewHolder2.scanTags();
            }
        }
    }
}
