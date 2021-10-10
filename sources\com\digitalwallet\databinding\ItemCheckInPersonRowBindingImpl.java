package com.digitalwallet.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.generated.callback.OnClickListener;
import com.digitalwallet.view.util.BindingAdaptersKt;
import com.digitalwallet.viewmodel.checkIn.checkInInput.PersonRowViewModel;

public class ItemCheckInPersonRowBindingImpl extends ItemCheckInPersonRowBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback26;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final CheckBox mboundView1;
    private InverseBindingListener mboundView1androidCheckedAttrChanged;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final TextView mboundView4;

    public ItemCheckInPersonRowBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemCheckInPersonRowBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.mboundView1androidCheckedAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.databinding.ItemCheckInPersonRowBindingImpl.AnonymousClass1 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                boolean isChecked = ItemCheckInPersonRowBindingImpl.this.mboundView1.isChecked();
                PersonRowViewModel personRowViewModel = ItemCheckInPersonRowBindingImpl.this.mVm;
                boolean z = true;
                if (personRowViewModel != null) {
                    ObservableBoolean checked = personRowViewModel.getChecked();
                    if (checked == null) {
                        z = false;
                    }
                    if (z) {
                        checked.set(isChecked);
                    }
                }
            }
        };
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        CheckBox checkBox = (CheckBox) objArr[1];
        this.mboundView1 = checkBox;
        checkBox.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.mboundView3 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[4];
        this.mboundView4 = textView3;
        textView3.setTag(null);
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
        if (8 != i) {
            return false;
        }
        setVm((PersonRowViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.databinding.ItemCheckInPersonRowBinding
    public void setVm(PersonRowViewModel personRowViewModel) {
        this.mVm = personRowViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeVmChecked((ObservableBoolean) obj, i2);
    }

    private boolean onChangeVmChecked(ObservableBoolean observableBoolean, int i) {
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
        String str2;
        boolean z;
        int i;
        int i2;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        PersonRowViewModel personRowViewModel = this.mVm;
        int i3 = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        boolean z2 = false;
        if (i3 != 0) {
            if ((j & 6) == 0 || personRowViewModel == null) {
                z = false;
                str2 = null;
                str = null;
            } else {
                z = personRowViewModel.getShowCheckBox();
                str2 = personRowViewModel.phoneNumberDisplay(getRoot().getContext());
                str = personRowViewModel.getFullName();
            }
            ObservableBoolean checked = personRowViewModel != null ? personRowViewModel.getChecked() : null;
            updateRegistration(0, checked);
            if (checked != null) {
                z2 = checked.get();
            }
            if (i3 != 0) {
                if (z2) {
                    j3 = j | 16;
                    j2 = 64;
                } else {
                    j3 = j | 8;
                    j2 = 32;
                }
                j = j3 | j2;
            }
            TextView textView = this.mboundView3;
            i = z2 ? getColorFromResource(textView, R.color.dw_battleship_grey_RES_2131034233) : getColorFromResource(textView, R.color.bluey_grey_RES_2131034147);
            i2 = z2 ? getColorFromResource(this.mboundView2, R.color.heavy_metal_RES_2131034244) : getColorFromResource(this.mboundView2, R.color.bluey_grey_RES_2131034147);
        } else {
            i2 = 0;
            i = 0;
            z = false;
            str2 = null;
            str = null;
        }
        if ((7 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.mboundView1, z2);
            this.mboundView2.setTextColor(i2);
            this.mboundView3.setTextColor(i);
        }
        if ((j & 6) != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.mboundView1, z);
            TextViewBindingAdapter.setText(this.mboundView2, str);
            TextViewBindingAdapter.setText(this.mboundView3, str2);
        }
        if ((j & 4) != 0) {
            CompoundButtonBindingAdapter.setListeners(this.mboundView1, null, this.mboundView1androidCheckedAttrChanged);
            this.mboundView4.setOnClickListener(this.mCallback26);
        }
    }

    @Override // com.digitalwallet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        PersonRowViewModel personRowViewModel = this.mVm;
        if (personRowViewModel != null) {
            personRowViewModel.doOnEdit();
        }
    }
}
