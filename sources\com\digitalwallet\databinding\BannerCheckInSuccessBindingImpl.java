package com.digitalwallet.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckedInBaseViewModel;

public class BannerCheckInSuccessBindingImpl extends BannerCheckInSuccessBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView1;
    private final TextView mboundView2;
    private final TextView mboundView3;

    public BannerCheckInSuccessBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private BannerCheckInSuccessBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.mboundView2 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[3];
        this.mboundView3 = textView3;
        textView3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
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
        setVm((CheckedInBaseViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.databinding.BannerCheckInSuccessBinding
    public void setVm(CheckedInBaseViewModel checkedInBaseViewModel) {
        this.mVm = checkedInBaseViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeVmLocationName((ObservableField) obj, i2);
        }
        if (i == 1) {
            return onChangeVmTime((ObservableField) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return onChangeVmBriefCheckedInText((ObservableField) obj, i2);
    }

    private boolean onChangeVmLocationName(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmTime(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmBriefCheckedInText(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CheckedInBaseViewModel checkedInBaseViewModel = this.mVm;
        String str3 = null;
        if ((31 & j) != 0) {
            if ((j & 25) != 0) {
                ObservableField<String> locationName = checkedInBaseViewModel != null ? checkedInBaseViewModel.getLocationName() : null;
                updateRegistration(0, locationName);
                if (locationName != null) {
                    str2 = locationName.get();
                    if ((j & 26) != 0) {
                        ObservableField<String> time = checkedInBaseViewModel != null ? checkedInBaseViewModel.getTime() : null;
                        updateRegistration(1, time);
                        if (time != null) {
                            str = time.get();
                            if ((j & 28) != 0) {
                                ObservableField<String> briefCheckedInText = checkedInBaseViewModel != null ? checkedInBaseViewModel.getBriefCheckedInText() : null;
                                updateRegistration(2, briefCheckedInText);
                                if (briefCheckedInText != null) {
                                    str3 = briefCheckedInText.get();
                                }
                            }
                        }
                    }
                    str = null;
                    if ((j & 28) != 0) {
                    }
                }
            }
            str2 = null;
            if ((j & 26) != 0) {
            }
            str = null;
            if ((j & 28) != 0) {
            }
        } else {
            str2 = null;
            str = null;
        }
        if ((28 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, str3);
        }
        if ((25 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView2, str2);
        }
        if ((j & 26) != 0) {
            TextViewBindingAdapter.setText(this.mboundView3, str);
        }
    }
}
