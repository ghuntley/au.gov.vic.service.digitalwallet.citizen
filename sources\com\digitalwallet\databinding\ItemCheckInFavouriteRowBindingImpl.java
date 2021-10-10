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
import com.digitalwallet.view.util.BindingAdaptersKt;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.FavouriteRowViewModel;

public class ItemCheckInFavouriteRowBindingImpl extends ItemCheckInFavouriteRowBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback14;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final LinearLayout mboundView1;
    private final ImageView mboundView2;
    private final LinearLayout mboundView3;
    private final CheckBox mboundView4;
    private InverseBindingListener mboundView4androidCheckedAttrChanged;
    private final TextView mboundView5;
    private final View mboundView7;

    public ItemCheckInFavouriteRowBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private ItemCheckInFavouriteRowBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (ImageView) objArr[6]);
        this.mboundView4androidCheckedAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.databinding.ItemCheckInFavouriteRowBindingImpl.AnonymousClass1 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                boolean isChecked = ItemCheckInFavouriteRowBindingImpl.this.mboundView4.isChecked();
                FavouriteRowViewModel favouriteRowViewModel = ItemCheckInFavouriteRowBindingImpl.this.mVm;
                boolean z = true;
                if (favouriteRowViewModel != null) {
                    ObservableBoolean checked = favouriteRowViewModel.getChecked();
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
        this.endIcon.setTag(null);
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
        View view2 = (View) objArr[7];
        this.mboundView7 = view2;
        view2.setTag(null);
        setRootTag(view);
        this.mCallback14 = new OnClickListener(this, 1);
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
        setVm((FavouriteRowViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.databinding.ItemCheckInFavouriteRowBinding
    public void setVm(FavouriteRowViewModel favouriteRowViewModel) {
        this.mVm = favouriteRowViewModel;
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
            return onChangeVmChecked((ObservableBoolean) obj, i2);
        }
        if (i == 1) {
            return onChangeVmEditing((ObservableBoolean) obj, i2);
        }
        if (i != 2) {
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

    private boolean onChangeVmEditing(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmShowDivider(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00be  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        long j2;
        boolean z;
        boolean z2;
        Drawable drawable;
        String str;
        boolean z3;
        boolean z4;
        String str2;
        int i;
        boolean z5;
        String str3;
        long j3;
        long j4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        FavouriteRowViewModel favouriteRowViewModel = this.mVm;
        if ((31 & j) != 0) {
            if ((j & 25) != 0) {
                ObservableBoolean checked = favouriteRowViewModel != null ? favouriteRowViewModel.getChecked() : null;
                updateRegistration(0, checked);
                if (checked != null) {
                    z4 = checked.get();
                    i = ((j & 26) > 0 ? 1 : ((j & 26) == 0 ? 0 : -1));
                    if (i == 0) {
                        ObservableBoolean editing = favouriteRowViewModel != null ? favouriteRowViewModel.getEditing() : null;
                        updateRegistration(1, editing);
                        if (editing != null) {
                            z5 = editing.get();
                        } else {
                            z5 = false;
                        }
                        if (i != 0) {
                            if (z5) {
                                j4 = j | 64;
                                j3 = 256;
                            } else {
                                j4 = j | 32;
                                j3 = 128;
                            }
                            j = j4 | j3;
                        }
                        str = this.endIcon.getResources().getString(z5 ? R.string.cd_click_drag : R.string.next_RES_2131689714);
                        drawable = z5 ? AppCompatResources.getDrawable(this.endIcon.getContext(), R.drawable.ic_reorder_handle) : AppCompatResources.getDrawable(this.endIcon.getContext(), R.drawable.ic_icon_check_in_arrow);
                        z2 = !z5;
                    } else {
                        str = null;
                        drawable = null;
                        z5 = false;
                        z2 = false;
                    }
                    if ((j & 24) != 0) {
                        CheckInUtils.CheckInCode favourite = favouriteRowViewModel != null ? favouriteRowViewModel.getFavourite() : null;
                        if (favourite != null) {
                            str3 = favourite.getLocation();
                            if ((j & 28) != 0) {
                                ObservableBoolean showDivider = favouriteRowViewModel != null ? favouriteRowViewModel.getShowDivider() : null;
                                updateRegistration(2, showDivider);
                                if (showDivider != null) {
                                    z3 = showDivider.get();
                                    str2 = str3;
                                    j2 = 26;
                                    z = z5;
                                }
                            }
                            str2 = str3;
                            z3 = false;
                            j2 = 26;
                            z = z5;
                        }
                    }
                    str3 = null;
                    if ((j & 28) != 0) {
                    }
                    str2 = str3;
                    z3 = false;
                    j2 = 26;
                    z = z5;
                }
            }
            z4 = false;
            i = ((j & 26) > 0 ? 1 : ((j & 26) == 0 ? 0 : -1));
            if (i == 0) {
            }
            if ((j & 24) != 0) {
            }
            str3 = null;
            if ((j & 28) != 0) {
            }
            str2 = str3;
            z3 = false;
            j2 = 26;
            z = z5;
        } else {
            j2 = 26;
            str2 = null;
            str = null;
            drawable = null;
            z4 = false;
            z3 = false;
            z2 = false;
            z = false;
        }
        if ((j & j2) != 0) {
            if (getBuildSdkInt() >= 4) {
                this.endIcon.setContentDescription(str);
            }
            ImageViewBindingAdapter.setImageDrawable(this.endIcon, drawable);
            BindingAdaptersKt.setVisibleOrGone(this.mboundView2, z2);
            BindingAdaptersKt.setVisibleOrGone(this.mboundView3, z);
        }
        if ((16 & j) != 0) {
            this.mboundView1.setOnClickListener(this.mCallback14);
            CompoundButtonBindingAdapter.setListeners(this.mboundView4, null, this.mboundView4androidCheckedAttrChanged);
        }
        if ((j & 24) != 0) {
            if (getBuildSdkInt() >= 4) {
                this.mboundView2.setContentDescription(str2);
            }
            TextViewBindingAdapter.setText(this.mboundView5, str2);
        }
        if ((25 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.mboundView4, z4);
        }
        if ((j & 28) != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.mboundView7, z3);
        }
    }

    @Override // com.digitalwallet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        FavouriteRowViewModel favouriteRowViewModel = this.mVm;
        if (favouriteRowViewModel != null) {
            favouriteRowViewModel.doOnClicked();
        }
    }
}
