package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.viewmodel.harvester.HarvestTagViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class HarvesterTagManualEntryBindingImpl extends HarvesterTagManualEntryBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private InverseBindingListener barcodeNumberandroidTextAttrChanged;
    private final View.OnClickListener mCallback31;
    private final View.OnClickListener mCallback32;
    private long mDirtyFlags;
    private final GridLayout mboundView0;
    private final ImageView mboundView1;
    private final Button mboundView3;

    public HarvesterTagManualEntryBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private HarvesterTagManualEntryBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextInputEditText) objArr[2]);
        this.barcodeNumberandroidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.app.databinding.HarvesterTagManualEntryBindingImpl.AnonymousClass1 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(HarvesterTagManualEntryBindingImpl.this.barcodeNumber);
                HarvestTagViewModel harvestTagViewModel = HarvesterTagManualEntryBindingImpl.this.mVm;
                boolean z = true;
                if (harvestTagViewModel != null) {
                    ObservableField<String> barcodeNumber = harvestTagViewModel.getBarcodeNumber();
                    if (barcodeNumber == null) {
                        z = false;
                    }
                    if (z) {
                        barcodeNumber.set(textString);
                    }
                }
            }
        };
        this.mDirtyFlags = -1;
        this.barcodeNumber.setTag(null);
        GridLayout gridLayout = (GridLayout) objArr[0];
        this.mboundView0 = gridLayout;
        gridLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        Button button = (Button) objArr[3];
        this.mboundView3 = button;
        button.setTag(null);
        setRootTag(view);
        this.mCallback32 = new OnClickListener(this, 2);
        this.mCallback31 = new OnClickListener(this, 1);
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
        setVm((HarvestTagViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.HarvesterTagManualEntryBinding
    public void setVm(HarvestTagViewModel harvestTagViewModel) {
        this.mVm = harvestTagViewModel;
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
        return onChangeVmBarcodeNumber((ObservableField) obj, i2);
    }

    private boolean onChangeVmBarcodeNumber(ObservableField<String> observableField, int i) {
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
        String str;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        HarvestTagViewModel harvestTagViewModel = this.mVm;
        int i2 = ((7 & j) > 0 ? 1 : ((7 & j) == 0 ? 0 : -1));
        boolean z = false;
        if (i2 != 0) {
            ObservableField<String> barcodeNumber = harvestTagViewModel != null ? harvestTagViewModel.getBarcodeNumber() : null;
            updateRegistration(0, barcodeNumber);
            str = barcodeNumber != null ? barcodeNumber.get() : null;
            if (str != null) {
                i = str.length();
            } else {
                i = 0;
            }
            if (i > 0) {
                z = true;
            }
        } else {
            str = null;
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.barcodeNumber, str);
            this.mboundView3.setEnabled(z);
        }
        if ((j & 4) != 0) {
            TextViewBindingAdapter.setTextWatcher(this.barcodeNumber, null, null, null, this.barcodeNumberandroidTextAttrChanged);
            this.mboundView1.setOnClickListener(this.mCallback31);
            this.mboundView3.setOnClickListener(this.mCallback32);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            HarvestTagViewModel harvestTagViewModel = this.mVm;
            if (harvestTagViewModel != null) {
                z = true;
            }
            if (z) {
                harvestTagViewModel.backToScanner();
            }
        } else if (i == 2) {
            HarvestTagViewModel harvestTagViewModel2 = this.mVm;
            if (harvestTagViewModel2 != null) {
                z = true;
            }
            if (z) {
                harvestTagViewModel2.addBarcode();
            }
        }
    }
}
