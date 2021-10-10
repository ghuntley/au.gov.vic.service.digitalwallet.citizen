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
import com.digitalwallet.app.viewmodel.harvester.HarvestJobWizardViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class HarvesterAddressBindingImpl extends HarvesterAddressBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private InverseBindingListener addressandroidTextAttrChanged;
    private InverseBindingListener contactNumberandroidTextAttrChanged;
    private final View.OnClickListener mCallback41;
    private final View.OnClickListener mCallback42;
    private long mDirtyFlags;
    private final ImageView mboundView1;
    private final TextInputEditText mboundView2;
    private InverseBindingListener mboundView2androidTextAttrChanged;
    private final Button mboundView5;

    public HarvesterAddressBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private HarvesterAddressBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (TextInputEditText) objArr[4], (TextInputEditText) objArr[3], (GridLayout) objArr[0]);
        this.addressandroidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.app.databinding.HarvesterAddressBindingImpl.AnonymousClass1 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(HarvesterAddressBindingImpl.this.address);
                HarvestJobWizardViewModel harvestJobWizardViewModel = HarvesterAddressBindingImpl.this.mVm;
                boolean z = true;
                if (harvestJobWizardViewModel != null) {
                    ObservableField<String> address = harvestJobWizardViewModel.getAddress();
                    if (address == null) {
                        z = false;
                    }
                    if (z) {
                        address.set(textString);
                    }
                }
            }
        };
        this.contactNumberandroidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.app.databinding.HarvesterAddressBindingImpl.AnonymousClass2 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(HarvesterAddressBindingImpl.this.contactNumber);
                HarvestJobWizardViewModel harvestJobWizardViewModel = HarvesterAddressBindingImpl.this.mVm;
                boolean z = true;
                if (harvestJobWizardViewModel != null) {
                    ObservableField<String> landholderContactNumber = harvestJobWizardViewModel.getLandholderContactNumber();
                    if (landholderContactNumber == null) {
                        z = false;
                    }
                    if (z) {
                        landholderContactNumber.set(textString);
                    }
                }
            }
        };
        this.mboundView2androidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.app.databinding.HarvesterAddressBindingImpl.AnonymousClass3 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(HarvesterAddressBindingImpl.this.mboundView2);
                HarvestJobWizardViewModel harvestJobWizardViewModel = HarvesterAddressBindingImpl.this.mVm;
                boolean z = true;
                if (harvestJobWizardViewModel != null) {
                    ObservableField<String> landholderName = harvestJobWizardViewModel.getLandholderName();
                    if (landholderName == null) {
                        z = false;
                    }
                    if (z) {
                        landholderName.set(textString);
                    }
                }
            }
        };
        this.mDirtyFlags = -1;
        this.address.setTag(null);
        this.contactNumber.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        TextInputEditText textInputEditText = (TextInputEditText) objArr[2];
        this.mboundView2 = textInputEditText;
        textInputEditText.setTag(null);
        Button button = (Button) objArr[5];
        this.mboundView5 = button;
        button.setTag(null);
        this.summaryScreen.setTag(null);
        setRootTag(view);
        this.mCallback41 = new OnClickListener(this, 1);
        this.mCallback42 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
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
        setVm((HarvestJobWizardViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.HarvesterAddressBinding
    public void setVm(HarvestJobWizardViewModel harvestJobWizardViewModel) {
        this.mVm = harvestJobWizardViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeVmLandholderName((ObservableField) obj, i2);
        }
        if (i == 1) {
            return onChangeVmAddress((ObservableField) obj, i2);
        }
        if (i == 2) {
            return onChangeVmLandholderContactNumber((ObservableField) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return onChangeVmLandholderDetailsFilled((ObservableField) obj, i2);
    }

    private boolean onChangeVmLandholderName(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmAddress(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmLandholderContactNumber(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmLandholderDetailsFilled(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        String str;
        String str2;
        String str3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        HarvestJobWizardViewModel harvestJobWizardViewModel = this.mVm;
        if ((63 & j) != 0) {
            if ((j & 49) != 0) {
                ObservableField<String> landholderName = harvestJobWizardViewModel != null ? harvestJobWizardViewModel.getLandholderName() : null;
                updateRegistration(0, landholderName);
                if (landholderName != null) {
                    str3 = landholderName.get();
                    if ((j & 50) != 0) {
                        ObservableField<String> address = harvestJobWizardViewModel != null ? harvestJobWizardViewModel.getAddress() : null;
                        updateRegistration(1, address);
                        if (address != null) {
                            str2 = address.get();
                            if ((j & 52) != 0) {
                                ObservableField<String> landholderContactNumber = harvestJobWizardViewModel != null ? harvestJobWizardViewModel.getLandholderContactNumber() : null;
                                updateRegistration(2, landholderContactNumber);
                                if (landholderContactNumber != null) {
                                    str = landholderContactNumber.get();
                                    if ((j & 56) != 0) {
                                        ObservableField<Boolean> landholderDetailsFilled = harvestJobWizardViewModel != null ? harvestJobWizardViewModel.getLandholderDetailsFilled() : null;
                                        updateRegistration(3, landholderDetailsFilled);
                                        z = ViewDataBinding.safeUnbox(landholderDetailsFilled != null ? landholderDetailsFilled.get() : null);
                                        if ((50 & j) != 0) {
                                            TextViewBindingAdapter.setText(this.address, str2);
                                        }
                                        if ((32 & j) != 0) {
                                            TextViewBindingAdapter.BeforeTextChanged beforeTextChanged = null;
                                            TextViewBindingAdapter.OnTextChanged onTextChanged = null;
                                            TextViewBindingAdapter.AfterTextChanged afterTextChanged = null;
                                            TextViewBindingAdapter.setTextWatcher(this.address, beforeTextChanged, onTextChanged, afterTextChanged, this.addressandroidTextAttrChanged);
                                            TextViewBindingAdapter.setTextWatcher(this.contactNumber, beforeTextChanged, onTextChanged, afterTextChanged, this.contactNumberandroidTextAttrChanged);
                                            this.mboundView1.setOnClickListener(this.mCallback41);
                                            TextViewBindingAdapter.setTextWatcher(this.mboundView2, beforeTextChanged, onTextChanged, afterTextChanged, this.mboundView2androidTextAttrChanged);
                                            this.mboundView5.setOnClickListener(this.mCallback42);
                                        }
                                        if ((j & 52) != 0) {
                                            TextViewBindingAdapter.setText(this.contactNumber, str);
                                        }
                                        if ((49 & j) != 0) {
                                            TextViewBindingAdapter.setText(this.mboundView2, str3);
                                        }
                                        if ((j & 56) == 0) {
                                            this.mboundView5.setEnabled(z);
                                            return;
                                        }
                                        return;
                                    }
                                }
                            }
                            str = null;
                            if ((j & 56) != 0) {
                            }
                        }
                    }
                    str2 = null;
                    if ((j & 52) != 0) {
                    }
                    str = null;
                    if ((j & 56) != 0) {
                    }
                }
            }
            str3 = null;
            if ((j & 50) != 0) {
            }
            str2 = null;
            if ((j & 52) != 0) {
            }
            str = null;
            if ((j & 56) != 0) {
            }
        } else {
            str3 = null;
            str2 = null;
            str = null;
        }
        z = false;
        if ((50 & j) != 0) {
        }
        if ((32 & j) != 0) {
        }
        if ((j & 52) != 0) {
        }
        if ((49 & j) != 0) {
        }
        if ((j & 56) == 0) {
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            HarvestJobWizardViewModel harvestJobWizardViewModel = this.mVm;
            if (harvestJobWizardViewModel != null) {
                z = true;
            }
            if (z) {
                harvestJobWizardViewModel.goBack();
            }
        } else if (i == 2) {
            HarvestJobWizardViewModel harvestJobWizardViewModel2 = this.mVm;
            if (harvestJobWizardViewModel2 != null) {
                z = true;
            }
            if (z) {
                harvestJobWizardViewModel2.doneAddress();
            }
        }
    }
}
