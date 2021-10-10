package com.digitalwallet.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.Converters;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.generated.callback.OnClickListener;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInPrimaryInputViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class FragmentCheckInPrimaryInputBindingImpl extends FragmentCheckInPrimaryInputBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback29;
    private final View.OnClickListener mCallback30;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final LinearLayout mboundView1;
    private final TextView mboundView2;
    private final SwitchMaterial mboundView3;
    private InverseBindingListener mboundView3androidCheckedAttrChanged;
    private final Button mboundView4;
    private final Button mboundView5;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(9);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_check_in_title_bar"}, new int[]{6}, new int[]{R.layout.layout_check_in_title_bar});
        includedLayouts.setIncludes(1, new String[]{"layout_check_in_input", "layout_check_in_privacy"}, new int[]{7, 8}, new int[]{R.layout.layout_check_in_input, R.layout.layout_check_in_privacy});
    }

    public FragmentCheckInPrimaryInputBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private FragmentCheckInPrimaryInputBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (LayoutCheckInPrivacyBinding) objArr[8], (LayoutCheckInInputBinding) objArr[7], (LayoutCheckInTitleBarBinding) objArr[6]);
        this.mboundView3androidCheckedAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.databinding.FragmentCheckInPrimaryInputBindingImpl.AnonymousClass1 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                boolean isChecked = FragmentCheckInPrimaryInputBindingImpl.this.mboundView3.isChecked();
                CheckInPrimaryInputViewModel checkInPrimaryInputViewModel = FragmentCheckInPrimaryInputBindingImpl.this.mVm;
                boolean z = true;
                if (checkInPrimaryInputViewModel != null) {
                    ObservableBoolean shouldSavePrimaryPerson = checkInPrimaryInputViewModel.getShouldSavePrimaryPerson();
                    if (shouldSavePrimaryPerson == null) {
                        z = false;
                    }
                    if (z) {
                        shouldSavePrimaryPerson.set(isChecked);
                    }
                }
            }
        };
        this.mDirtyFlags = -1;
        setContainedBinding(this.checkInPrivacyLayout);
        setContainedBinding(this.inputLayout);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        SwitchMaterial switchMaterial = (SwitchMaterial) objArr[3];
        this.mboundView3 = switchMaterial;
        switchMaterial.setTag(null);
        Button button = (Button) objArr[4];
        this.mboundView4 = button;
        button.setTag(null);
        Button button2 = (Button) objArr[5];
        this.mboundView5 = button2;
        button2.setTag(null);
        setContainedBinding(this.titleBar);
        setRootTag(view);
        this.mCallback29 = new OnClickListener(this, 1);
        this.mCallback30 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 256;
        }
        this.titleBar.invalidateAll();
        this.inputLayout.invalidateAll();
        this.checkInPrivacyLayout.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r4.inputLayout.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r4.checkInPrivacyLayout.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.titleBar.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (8 != i) {
            return false;
        }
        setVm((CheckInPrimaryInputViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.databinding.FragmentCheckInPrimaryInputBinding
    public void setVm(CheckInPrimaryInputViewModel checkInPrimaryInputViewModel) {
        this.mVm = checkInPrimaryInputViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleBar.setLifecycleOwner(lifecycleOwner);
        this.inputLayout.setLifecycleOwner(lifecycleOwner);
        this.checkInPrivacyLayout.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeCheckInPrivacyLayout((LayoutCheckInPrivacyBinding) obj, i2);
            case 1:
                return onChangeVmShouldSavePrimaryPerson((ObservableBoolean) obj, i2);
            case 2:
                return onChangeVmAllRequiredFieldsInputted((ObservableBoolean) obj, i2);
            case 3:
                return onChangeInputLayout((LayoutCheckInInputBinding) obj, i2);
            case 4:
                return onChangeVmShowBack((ObservableBoolean) obj, i2);
            case 5:
                return onChangeTitleBar((LayoutCheckInTitleBarBinding) obj, i2);
            case 6:
                return onChangeVmCheckInCode((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeCheckInPrivacyLayout(LayoutCheckInPrivacyBinding layoutCheckInPrivacyBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmShouldSavePrimaryPerson(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmAllRequiredFieldsInputted(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeInputLayout(LayoutCheckInInputBinding layoutCheckInInputBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeVmShowBack(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeTitleBar(LayoutCheckInTitleBarBinding layoutCheckInTitleBarBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeVmCheckInCode(ObservableField<CheckInUtils.CheckInCode> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ac  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        int i;
        String str;
        boolean z2;
        float f;
        boolean z3;
        int i2;
        float f2;
        int i3;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CheckInPrimaryInputViewModel checkInPrimaryInputViewModel = this.mVm;
        boolean z4 = false;
        if ((470 & j) != 0) {
            if ((j & 386) != 0) {
                ObservableBoolean shouldSavePrimaryPerson = checkInPrimaryInputViewModel != null ? checkInPrimaryInputViewModel.getShouldSavePrimaryPerson() : null;
                updateRegistration(1, shouldSavePrimaryPerson);
                if (shouldSavePrimaryPerson != null) {
                    z3 = shouldSavePrimaryPerson.get();
                    i2 = ((j & 388) > 0 ? 1 : ((j & 388) == 0 ? 0 : -1));
                    if (i2 == 0) {
                        ObservableBoolean allRequiredFieldsInputted = checkInPrimaryInputViewModel != null ? checkInPrimaryInputViewModel.getAllRequiredFieldsInputted() : null;
                        updateRegistration(2, allRequiredFieldsInputted);
                        if (allRequiredFieldsInputted != null) {
                            z = allRequiredFieldsInputted.get();
                        } else {
                            z = false;
                        }
                        if (i2 != 0) {
                            if (z) {
                                j3 = j | PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                                j2 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                            } else {
                                j3 = j | 512;
                                j2 = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                            }
                            j = j3 | j2;
                        }
                        i3 = getColorFromResource(this.mboundView5, z ? R.color.dw_orange_RES_2131034234 : R.color.dw_orange_disabled_RES_2131034235);
                        f2 = z ? 1.0f : 0.4f;
                    } else {
                        i3 = 0;
                        z = false;
                        f2 = 0.0f;
                    }
                    if ((j & 400) != 0) {
                        ObservableBoolean showBack = checkInPrimaryInputViewModel != null ? checkInPrimaryInputViewModel.getShowBack() : null;
                        updateRegistration(4, showBack);
                        if (showBack != null) {
                            z4 = showBack.get();
                        }
                    }
                    if ((j & 448) != 0) {
                        ObservableField<CheckInUtils.CheckInCode> checkInCode = checkInPrimaryInputViewModel != null ? checkInPrimaryInputViewModel.getCheckInCode() : null;
                        updateRegistration(6, checkInCode);
                        CheckInUtils.CheckInCode checkInCode2 = checkInCode != null ? checkInCode.get() : null;
                        if (checkInCode2 != null) {
                            str = checkInCode2.getLocation();
                            i = i3;
                            z2 = z3;
                            f = f2;
                        }
                    }
                    i = i3;
                    str = null;
                    z2 = z3;
                    f = f2;
                }
            }
            z3 = false;
            i2 = ((j & 388) > 0 ? 1 : ((j & 388) == 0 ? 0 : -1));
            if (i2 == 0) {
            }
            if ((j & 400) != 0) {
            }
            if ((j & 448) != 0) {
            }
            i = i3;
            str = null;
            z2 = z3;
            f = f2;
        } else {
            z2 = false;
            i = 0;
            z = false;
            str = null;
            f = 0.0f;
        }
        if ((j & 384) != 0) {
            this.inputLayout.setVm(checkInPrimaryInputViewModel);
        }
        if ((j & 448) != 0) {
            TextViewBindingAdapter.setText(this.mboundView2, str);
        }
        if ((j & 386) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.mboundView3, z2);
        }
        if ((256 & j) != 0) {
            CompoundButtonBindingAdapter.setListeners(this.mboundView3, null, this.mboundView3androidCheckedAttrChanged);
            this.mboundView4.setOnClickListener(this.mCallback29);
            this.mboundView5.setOnClickListener(this.mCallback30);
            this.titleBar.setTitle(getRoot().getResources().getString(R.string.check_in_title));
        }
        if ((388 & j) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.mboundView4.setAlpha(f);
            }
            this.mboundView4.setEnabled(z);
            ViewBindingAdapter.setBackground(this.mboundView5, Converters.convertColorToDrawable(i));
            this.mboundView5.setEnabled(z);
        }
        if ((j & 400) != 0) {
            this.titleBar.setShowBack(Boolean.valueOf(z4));
        }
        executeBindingsOn(this.titleBar);
        executeBindingsOn(this.inputLayout);
        executeBindingsOn(this.checkInPrivacyLayout);
    }

    @Override // com.digitalwallet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            CheckInPrimaryInputViewModel checkInPrimaryInputViewModel = this.mVm;
            if (checkInPrimaryInputViewModel != null) {
                z = true;
            }
            if (z) {
                checkInPrimaryInputViewModel.toAddDependants();
            }
        } else if (i == 2) {
            CheckInPrimaryInputViewModel checkInPrimaryInputViewModel2 = this.mVm;
            if (checkInPrimaryInputViewModel2 != null) {
                z = true;
            }
            if (z) {
                checkInPrimaryInputViewModel2.onCheckIn();
            }
        }
    }
}
