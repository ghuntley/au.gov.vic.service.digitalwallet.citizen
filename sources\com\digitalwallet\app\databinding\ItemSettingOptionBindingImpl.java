package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.view.util.BindingAdaptersKt;
import com.digitalwallet.app.viewmodel.main.SettingOption;
import com.digitalwallet.app.viewmodel.main.SettingOptionItem;
import com.google.android.material.switchmaterial.SwitchMaterial;
import java.util.List;

public class ItemSettingOptionBindingImpl extends ItemSettingOptionBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback55;
    private final View.OnClickListener mCallback56;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final CheckBox mboundView2;
    private final SwitchMaterial mboundView3;

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemSettingOptionBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemSettingOptionBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        CheckBox checkBox = (CheckBox) objArr[2];
        this.mboundView2 = checkBox;
        checkBox.setTag(null);
        SwitchMaterial switchMaterial = (SwitchMaterial) objArr[3];
        this.mboundView3 = switchMaterial;
        switchMaterial.setTag(null);
        this.name.setTag(null);
        setRootTag(view);
        this.mCallback56 = new OnClickListener(this, 2);
        this.mCallback55 = new OnClickListener(this, 1);
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
        setVm((SettingOptionItem) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.ItemSettingOptionBinding
    public void setVm(SettingOptionItem settingOptionItem) {
        this.mVm = settingOptionItem;
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
        int i;
        boolean z;
        int i2;
        boolean z2;
        SettingOption settingOption;
        boolean z3;
        boolean z4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        SettingOptionItem settingOptionItem = this.mVm;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        boolean z5 = false;
        if (i3 != 0) {
            List<SettingOption> list = null;
            if (settingOptionItem != null) {
                boolean debugOptionActivated = settingOptionItem.getDebugOptionActivated();
                int title = settingOptionItem.getTitle();
                List<SettingOption> switchOptions = settingOptionItem.getSwitchOptions();
                z3 = settingOptionItem.isDebug();
                settingOption = settingOptionItem.getSettingOption();
                z2 = settingOptionItem.getAutoUpdate();
                z4 = debugOptionActivated;
                list = switchOptions;
                i = title;
            } else {
                z2 = false;
                z4 = false;
                i = 0;
                z3 = false;
                settingOption = null;
            }
            if (i3 != 0) {
                j |= z3 ? 8 : 4;
            }
            i2 = z3 ? 0 : 8;
            if (list != null) {
                z5 = list.contains(settingOption);
            }
            z = z5;
            z5 = z4;
        } else {
            z2 = false;
            i2 = 0;
            z = false;
            i = 0;
        }
        if ((2 & j) != 0) {
            this.mboundView0.setOnClickListener(this.mCallback55);
            this.mboundView3.setOnClickListener(this.mCallback56);
        }
        if ((j & 3) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.mboundView2, z5);
            this.mboundView2.setVisibility(i2);
            CompoundButtonBindingAdapter.setChecked(this.mboundView3, z2);
            BindingAdaptersKt.setVisibleOrGone(this.mboundView3, z);
            this.name.setText(i);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            SettingOptionItem settingOptionItem = this.mVm;
            if (settingOptionItem != null) {
                z = true;
            }
            if (z) {
                settingOptionItem.onClick();
            }
        } else if (i == 2) {
            SettingOptionItem settingOptionItem2 = this.mVm;
            if (settingOptionItem2 != null) {
                z = true;
            }
            if (z) {
                settingOptionItem2.onClick();
            }
        }
    }
}
