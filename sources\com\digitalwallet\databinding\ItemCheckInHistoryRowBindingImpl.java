package com.digitalwallet.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.generated.callback.OnClickListener;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.view.util.BindingAdaptersKt;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.HistoryRowViewModel;

public class ItemCheckInHistoryRowBindingImpl extends ItemCheckInHistoryRowBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback13;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final LinearLayout mboundView1;
    private final ImageView mboundView2;
    private final LinearLayout mboundView3;
    private final CheckBox mboundView4;
    private InverseBindingListener mboundView4androidCheckedAttrChanged;
    private final TextView mboundView5;
    private final TextView mboundView6;
    private final ImageView mboundView7;
    private final View mboundView8;

    public ItemCheckInHistoryRowBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private ItemCheckInHistoryRowBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4);
        this.mboundView4androidCheckedAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.databinding.ItemCheckInHistoryRowBindingImpl.AnonymousClass1 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                boolean isChecked = ItemCheckInHistoryRowBindingImpl.this.mboundView4.isChecked();
                HistoryRowViewModel historyRowViewModel = ItemCheckInHistoryRowBindingImpl.this.mVm;
                boolean z = true;
                if (historyRowViewModel != null) {
                    ObservableBoolean checked = historyRowViewModel.getChecked();
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
        LinearLayout linearLayout2 = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout2;
        linearLayout2.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[3];
        this.mboundView3 = linearLayout3;
        linearLayout3.setTag(null);
        CheckBox checkBox = (CheckBox) objArr[4];
        this.mboundView4 = checkBox;
        checkBox.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.mboundView5 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[6];
        this.mboundView6 = textView2;
        textView2.setTag(null);
        ImageView imageView2 = (ImageView) objArr[7];
        this.mboundView7 = imageView2;
        imageView2.setTag(null);
        View view2 = (View) objArr[8];
        this.mboundView8 = view2;
        view2.setTag(null);
        setRootTag(view);
        this.mCallback13 = new OnClickListener(this, 1);
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
        if (8 != i) {
            return false;
        }
        setVm((HistoryRowViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.databinding.ItemCheckInHistoryRowBinding
    public void setVm(HistoryRowViewModel historyRowViewModel) {
        this.mVm = historyRowViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeVmChecked((ObservableBoolean) obj, i2);
        }
        if (i == 1) {
            return onChangeVmIsActiveCheckIn((ObservableBoolean) obj, i2);
        }
        if (i == 2) {
            return onChangeVmEditing((ObservableBoolean) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return onChangeVmShowDivider((ObservableBoolean) obj, i2);
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

    private boolean onChangeVmIsActiveCheckIn(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmEditing(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmShowDivider(ObservableBoolean observableBoolean, int i) {
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
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b1  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        boolean z;
        String str2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Drawable drawable;
        String str3;
        int i;
        String str4;
        String str5;
        int i2;
        CheckIn checkIn;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        HistoryRowViewModel historyRowViewModel = this.mVm;
        if ((63 & j) != 0) {
            if ((j & 49) != 0) {
                ObservableBoolean checked = historyRowViewModel != null ? historyRowViewModel.getChecked() : null;
                updateRegistration(0, checked);
                if (checked != null) {
                    z5 = checked.get();
                    if ((j & 48) == 0) {
                        if (historyRowViewModel != null) {
                            str5 = historyRowViewModel.getBriefInfoDisplay();
                            checkIn = historyRowViewModel.getHistory();
                        } else {
                            str5 = null;
                            checkIn = null;
                        }
                        str4 = checkIn != null ? checkIn.getLocationName() : null;
                    } else {
                        str5 = null;
                        str4 = null;
                    }
                    i2 = ((j & 50) > 0 ? 1 : ((j & 50) == 0 ? 0 : -1));
                    if (i2 == 0) {
                        ObservableBoolean isActiveCheckIn = historyRowViewModel != null ? historyRowViewModel.isActiveCheckIn() : null;
                        updateRegistration(1, isActiveCheckIn);
                        if (isActiveCheckIn != null) {
                            z3 = isActiveCheckIn.get();
                        } else {
                            z3 = false;
                        }
                        if (i2 != 0) {
                            j = z3 ? j | 128 : j | 64;
                        }
                    } else {
                        z3 = false;
                    }
                    if ((j & 52) == 0) {
                        ObservableBoolean editing = historyRowViewModel != null ? historyRowViewModel.getEditing() : null;
                        updateRegistration(2, editing);
                        if (editing != null) {
                            z4 = editing.get();
                        } else {
                            z4 = false;
                        }
                        z = !z4;
                    } else {
                        z4 = false;
                        z = false;
                    }
                    if ((j & 56) != 0) {
                        ObservableBoolean showDivider = historyRowViewModel != null ? historyRowViewModel.getShowDivider() : null;
                        updateRegistration(3, showDivider);
                        if (showDivider != null) {
                            z2 = showDivider.get();
                            str2 = str5;
                            str = str4;
                        }
                    }
                    str2 = str5;
                    str = str4;
                    z2 = false;
                }
            }
            z5 = false;
            if ((j & 48) == 0) {
            }
            i2 = ((j & 50) > 0 ? 1 : ((j & 50) == 0 ? 0 : -1));
            if (i2 == 0) {
            }
            if ((j & 52) == 0) {
            }
            if ((j & 56) != 0) {
            }
            str2 = str5;
            str = str4;
            z2 = false;
        } else {
            str2 = null;
            str = null;
            z5 = false;
            z4 = false;
            z3 = false;
            z2 = false;
            z = false;
        }
        int i3 = ((j & 64) > 0 ? 1 : ((j & 64) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (historyRowViewModel != null) {
                i = historyRowViewModel.getGuestCount();
            } else {
                i = 0;
            }
            boolean z6 = i == 0;
            if (i3 != 0) {
                j |= z6 ? 512 : 256;
            }
            drawable = AppCompatResources.getDrawable(this.mboundView2.getContext(), z6 ? R.drawable.ic_checked_in_single : R.drawable.ic_checked_in_multiple);
        } else {
            drawable = null;
        }
        int i4 = ((j & 50) > 0 ? 1 : ((j & 50) == 0 ? 0 : -1));
        if (i4 == 0) {
            drawable = null;
        } else if (z3) {
            drawable = AppCompatResources.getDrawable(this.mboundView2.getContext(), R.drawable.ic_check_in_tick_small);
        }
        if ((32 & j) != 0) {
            this.mboundView1.setOnClickListener(this.mCallback13);
            CompoundButtonBindingAdapter.setListeners(this.mboundView4, null, this.mboundView4androidCheckedAttrChanged);
        }
        if ((48 & j) != 0) {
            if (getBuildSdkInt() >= 4) {
                str3 = str;
                this.mboundView2.setContentDescription(str3);
            } else {
                str3 = str;
            }
            TextViewBindingAdapter.setText(this.mboundView5, str3);
            TextViewBindingAdapter.setText(this.mboundView6, str2);
        }
        if (i4 != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mboundView2, drawable);
        }
        if ((52 & j) != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.mboundView2, z);
            BindingAdaptersKt.setVisibleOrGone(this.mboundView3, z4);
            BindingAdaptersKt.setVisibleOrGone(this.mboundView7, z);
        }
        if ((49 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.mboundView4, z5);
        }
        if ((j & 56) != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.mboundView8, z2);
        }
    }

    @Override // com.digitalwallet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        HistoryRowViewModel historyRowViewModel = this.mVm;
        if (historyRowViewModel != null) {
            historyRowViewModel.doOnClicked();
        }
    }
}
