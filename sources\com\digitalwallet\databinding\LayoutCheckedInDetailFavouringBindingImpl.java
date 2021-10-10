package com.digitalwallet.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.generated.callback.OnClickListener;
import com.digitalwallet.view.util.BindingAdaptersKt;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckedInDetailFavouringBaseViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class LayoutCheckedInDetailFavouringBindingImpl extends LayoutCheckedInDetailFavouringBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback5;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final LinearLayout mboundView6;
    private final SwitchMaterial mboundView7;
    private InverseBindingListener mboundView7androidCheckedAttrChanged;
    private final TextView mboundView8;
    private final Button mboundView9;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.network_connection_issue_heading, 10);
        sparseIntArray.put(R.id.network_connection_issue_error_message, 11);
        sparseIntArray.put(R.id.checkIn_detail, 12);
        sparseIntArray.put(R.id.favouring_view, 13);
    }

    public LayoutCheckedInDetailFavouringBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private LayoutCheckedInDetailFavouringBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 8, (ConstraintLayout) objArr[12], (ImageView) objArr[3], (TextView) objArr[2], (TextView) objArr[4], (TextView) objArr[5], (LinearLayout) objArr[13], (ConstraintLayout) objArr[1], (TextView) objArr[11], (TextView) objArr[10]);
        this.mboundView7androidCheckedAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.databinding.LayoutCheckedInDetailFavouringBindingImpl.AnonymousClass1 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                boolean isChecked = LayoutCheckedInDetailFavouringBindingImpl.this.mboundView7.isChecked();
                CheckedInDetailFavouringBaseViewModel checkedInDetailFavouringBaseViewModel = LayoutCheckedInDetailFavouringBindingImpl.this.mVm;
                boolean z = true;
                if (checkedInDetailFavouringBaseViewModel != null) {
                    ObservableBoolean shouldFavour = checkedInDetailFavouringBaseViewModel.getShouldFavour();
                    if (shouldFavour == null) {
                        z = false;
                    }
                    if (z) {
                        shouldFavour.set(isChecked);
                    }
                }
            }
        };
        this.mDirtyFlags = -1;
        this.checkInTick.setTag(null);
        this.checkInToTitle.setTag(null);
        this.checkedIn.setTag(null);
        this.checkedInTime.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[6];
        this.mboundView6 = linearLayout;
        linearLayout.setTag(null);
        SwitchMaterial switchMaterial = (SwitchMaterial) objArr[7];
        this.mboundView7 = switchMaterial;
        switchMaterial.setTag(null);
        TextView textView = (TextView) objArr[8];
        this.mboundView8 = textView;
        textView.setTag(null);
        Button button = (Button) objArr[9];
        this.mboundView9 = button;
        button.setTag(null);
        this.networkConnectionIssue.setTag(null);
        setRootTag(view);
        this.mCallback5 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
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
        if (8 == i) {
            setVm((CheckedInDetailFavouringBaseViewModel) obj);
        } else if (5 != i) {
            return false;
        } else {
            setShowDoneButton((Boolean) obj);
        }
        return true;
    }

    @Override // com.digitalwallet.databinding.LayoutCheckedInDetailFavouringBinding
    public void setVm(CheckedInDetailFavouringBaseViewModel checkedInDetailFavouringBaseViewModel) {
        this.mVm = checkedInDetailFavouringBaseViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // com.digitalwallet.databinding.LayoutCheckedInDetailFavouringBinding
    public void setShowDoneButton(Boolean bool) {
        this.mShowDoneButton = bool;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeVmCanFavour((ObservableBoolean) obj, i2);
            case 1:
                return onChangeVmGuestCount((ObservableInt) obj, i2);
            case 2:
                return onChangeVmShouldFavour((ObservableBoolean) obj, i2);
            case 3:
                return onChangeVmIsActiveCheckIn((ObservableBoolean) obj, i2);
            case 4:
                return onChangeVmLocationName((ObservableField) obj, i2);
            case 5:
                return onChangeVmTime((ObservableField) obj, i2);
            case 6:
                return onChangeVmNoInternetConnectionBanner((ObservableBoolean) obj, i2);
            case 7:
                return onChangeVmDetailedCheckedInText((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeVmCanFavour(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmGuestCount(ObservableInt observableInt, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmShouldFavour(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmIsActiveCheckIn(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeVmLocationName(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeVmTime(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeVmNoInternetConnectionBanner(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeVmDetailedCheckedInText(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e2  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        String str;
        boolean z2;
        String str2;
        boolean z3;
        String str3;
        boolean z4;
        boolean z5;
        Drawable drawable;
        int i;
        boolean z6;
        int i2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CheckedInDetailFavouringBaseViewModel checkedInDetailFavouringBaseViewModel = this.mVm;
        Boolean bool = this.mShowDoneButton;
        if ((1535 & j) != 0) {
            if ((j & 1281) != 0) {
                ObservableBoolean canFavour = checkedInDetailFavouringBaseViewModel != null ? checkedInDetailFavouringBaseViewModel.getCanFavour() : null;
                updateRegistration(0, canFavour);
                if (canFavour != null) {
                    z5 = canFavour.get();
                } else {
                    z5 = false;
                }
                z6 = !z5;
            } else {
                z5 = false;
                z6 = false;
            }
            if ((j & 1284) != 0) {
                ObservableBoolean shouldFavour = checkedInDetailFavouringBaseViewModel != null ? checkedInDetailFavouringBaseViewModel.getShouldFavour() : null;
                updateRegistration(2, shouldFavour);
                if (shouldFavour != null) {
                    z3 = shouldFavour.get();
                    i2 = ((j & 1290) > 0 ? 1 : ((j & 1290) == 0 ? 0 : -1));
                    if (i2 == 0) {
                        ObservableBoolean isActiveCheckIn = checkedInDetailFavouringBaseViewModel != null ? checkedInDetailFavouringBaseViewModel.isActiveCheckIn() : null;
                        updateRegistration(3, isActiveCheckIn);
                        if (isActiveCheckIn != null) {
                            z4 = isActiveCheckIn.get();
                        } else {
                            z4 = false;
                        }
                        if (i2 != 0) {
                            j = z4 ? j | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : j | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                        }
                    } else {
                        z4 = false;
                    }
                    if ((j & 1296) != 0) {
                        ObservableField<String> locationName = checkedInDetailFavouringBaseViewModel != null ? checkedInDetailFavouringBaseViewModel.getLocationName() : null;
                        updateRegistration(4, locationName);
                        if (locationName != null) {
                            str3 = locationName.get();
                            if ((j & 1312) != 0) {
                                ObservableField<String> time = checkedInDetailFavouringBaseViewModel != null ? checkedInDetailFavouringBaseViewModel.getTime() : null;
                                updateRegistration(5, time);
                                if (time != null) {
                                    str2 = time.get();
                                    if ((j & 1344) != 0) {
                                        ObservableBoolean noInternetConnectionBanner = checkedInDetailFavouringBaseViewModel != null ? checkedInDetailFavouringBaseViewModel.getNoInternetConnectionBanner() : null;
                                        updateRegistration(6, noInternetConnectionBanner);
                                        if (noInternetConnectionBanner != null) {
                                            z2 = noInternetConnectionBanner.get();
                                            if ((j & 1408) != 0) {
                                                ObservableField<String> detailedCheckedInText = checkedInDetailFavouringBaseViewModel != null ? checkedInDetailFavouringBaseViewModel.getDetailedCheckedInText() : null;
                                                updateRegistration(7, detailedCheckedInText);
                                                if (detailedCheckedInText != null) {
                                                    str = detailedCheckedInText.get();
                                                    z = z6;
                                                }
                                            }
                                            z = z6;
                                            str = null;
                                        }
                                    }
                                    z2 = false;
                                    if ((j & 1408) != 0) {
                                    }
                                    z = z6;
                                    str = null;
                                }
                            }
                            str2 = null;
                            if ((j & 1344) != 0) {
                            }
                            z2 = false;
                            if ((j & 1408) != 0) {
                            }
                            z = z6;
                            str = null;
                        }
                    }
                    str3 = null;
                    if ((j & 1312) != 0) {
                    }
                    str2 = null;
                    if ((j & 1344) != 0) {
                    }
                    z2 = false;
                    if ((j & 1408) != 0) {
                    }
                    z = z6;
                    str = null;
                }
            }
            z3 = false;
            i2 = ((j & 1290) > 0 ? 1 : ((j & 1290) == 0 ? 0 : -1));
            if (i2 == 0) {
            }
            if ((j & 1296) != 0) {
            }
            str3 = null;
            if ((j & 1312) != 0) {
            }
            str2 = null;
            if ((j & 1344) != 0) {
            }
            z2 = false;
            if ((j & 1408) != 0) {
            }
            z = z6;
            str = null;
        } else {
            z5 = false;
            z4 = false;
            str3 = null;
            z3 = false;
            str2 = null;
            z2 = false;
            str = null;
            z = false;
        }
        boolean safeUnbox = (j & 1536) != 0 ? ViewDataBinding.safeUnbox(bool) : false;
        int i3 = ((j & PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) > 0 ? 1 : ((j & PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == 0 ? 0 : -1));
        if (i3 != 0) {
            ObservableInt guestCount = checkedInDetailFavouringBaseViewModel != null ? checkedInDetailFavouringBaseViewModel.getGuestCount() : null;
            boolean z7 = true;
            updateRegistration(1, guestCount);
            if (guestCount != null) {
                i = guestCount.get();
            } else {
                i = 0;
            }
            if (i != 0) {
                z7 = false;
            }
            if (i3 != 0) {
                j |= z7 ? PlaybackStateCompat.ACTION_PREPARE : PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            drawable = AppCompatResources.getDrawable(this.checkInTick.getContext(), z7 ? R.drawable.ic_checked_in_single : R.drawable.ic_checked_in_multiple);
        } else {
            drawable = null;
        }
        int i4 = ((j & 1290) > 0 ? 1 : ((j & 1290) == 0 ? 0 : -1));
        if (i4 == 0) {
            drawable = null;
        } else if (z4) {
            drawable = AppCompatResources.getDrawable(this.checkInTick.getContext(), R.drawable.ic_icon_check_in_tick);
        }
        if (i4 != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.checkInTick, drawable);
        }
        if ((1296 & j) != 0) {
            TextViewBindingAdapter.setText(this.checkInToTitle, str3);
        }
        if ((1408 & j) != 0) {
            TextViewBindingAdapter.setText(this.checkedIn, str);
        }
        if ((1312 & j) != 0) {
            TextViewBindingAdapter.setText(this.checkedInTime, str2);
        }
        if ((j & 1281) != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.mboundView6, z5);
            BindingAdaptersKt.setVisibleOrGone(this.mboundView8, z);
        }
        if ((j & 1284) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.mboundView7, z3);
        }
        if ((PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID & j) != 0) {
            CompoundButtonBindingAdapter.setListeners(this.mboundView7, null, this.mboundView7androidCheckedAttrChanged);
            this.mboundView9.setOnClickListener(this.mCallback5);
        }
        if ((j & 1536) != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.mboundView9, safeUnbox);
        }
        if ((j & 1344) != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.networkConnectionIssue, z2);
        }
    }

    @Override // com.digitalwallet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        CheckedInDetailFavouringBaseViewModel checkedInDetailFavouringBaseViewModel = this.mVm;
        if (checkedInDetailFavouringBaseViewModel != null) {
            checkedInDetailFavouringBaseViewModel.onDone();
        }
    }
}
