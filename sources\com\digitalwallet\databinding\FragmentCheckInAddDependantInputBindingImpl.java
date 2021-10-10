package com.digitalwallet.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.Converters;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.generated.callback.OnClickListener;
import com.digitalwallet.view.util.BindingAdaptersKt;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInAddDependantInputViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class FragmentCheckInAddDependantInputBindingImpl extends FragmentCheckInAddDependantInputBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback11;
    private final View.OnClickListener mCallback12;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final View mboundView1;
    private final LinearLayout mboundView2;
    private final ConstraintLayout mboundView3;
    private final LayoutTitleBarBinding mboundView31;
    private final TextView mboundView4;
    private final LinearLayout mboundView5;
    private final LayoutInfoBoxBinding mboundView51;
    private final SwitchMaterial mboundView6;
    private InverseBindingListener mboundView6androidCheckedAttrChanged;
    private final Button mboundView7;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(13);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(2, new String[]{"layout_check_in_title_bar"}, new int[]{8}, new int[]{R.layout.layout_check_in_title_bar});
        includedLayouts.setIncludes(3, new String[]{"layout_title_bar"}, new int[]{9}, new int[]{R.layout.layout_title_bar_RES_2131492940});
        includedLayouts.setIncludes(5, new String[]{"layout_info_box", "layout_check_in_input", "layout_check_in_privacy"}, new int[]{10, 11, 12}, new int[]{R.layout.layout_info_box, R.layout.layout_check_in_input, R.layout.layout_check_in_privacy});
    }

    public FragmentCheckInAddDependantInputBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private FragmentCheckInAddDependantInputBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (LayoutCheckInPrivacyBinding) objArr[12], (LayoutCheckInTitleBarBinding) objArr[8], (LayoutCheckInInputBinding) objArr[11]);
        this.mboundView6androidCheckedAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.databinding.FragmentCheckInAddDependantInputBindingImpl.AnonymousClass1 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                boolean isChecked = FragmentCheckInAddDependantInputBindingImpl.this.mboundView6.isChecked();
                CheckInAddDependantInputViewModel checkInAddDependantInputViewModel = FragmentCheckInAddDependantInputBindingImpl.this.mVm;
                boolean z = true;
                if (checkInAddDependantInputViewModel != null) {
                    ObservableBoolean shouldSaveDependant = checkInAddDependantInputViewModel.getShouldSaveDependant();
                    if (shouldSaveDependant == null) {
                        z = false;
                    }
                    if (z) {
                        shouldSaveDependant.set(isChecked);
                    }
                }
            }
        };
        this.mDirtyFlags = -1;
        setContainedBinding(this.checkInPrivacyLayout);
        setContainedBinding(this.fullScreenTitleBar);
        setContainedBinding(this.inputLayout);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        View view2 = (View) objArr[1];
        this.mboundView1 = view2;
        view2.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[2];
        this.mboundView2 = linearLayout2;
        linearLayout2.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[3];
        this.mboundView3 = constraintLayout;
        constraintLayout.setTag(null);
        LayoutTitleBarBinding layoutTitleBarBinding = (LayoutTitleBarBinding) objArr[9];
        this.mboundView31 = layoutTitleBarBinding;
        setContainedBinding(layoutTitleBarBinding);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[5];
        this.mboundView5 = linearLayout3;
        linearLayout3.setTag(null);
        LayoutInfoBoxBinding layoutInfoBoxBinding = (LayoutInfoBoxBinding) objArr[10];
        this.mboundView51 = layoutInfoBoxBinding;
        setContainedBinding(layoutInfoBoxBinding);
        SwitchMaterial switchMaterial = (SwitchMaterial) objArr[6];
        this.mboundView6 = switchMaterial;
        switchMaterial.setTag(null);
        Button button = (Button) objArr[7];
        this.mboundView7 = button;
        button.setTag(null);
        setRootTag(view);
        this.mCallback11 = new OnClickListener(this, 1);
        this.mCallback12 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128;
        }
        this.fullScreenTitleBar.invalidateAll();
        this.mboundView31.invalidateAll();
        this.mboundView51.invalidateAll();
        this.inputLayout.invalidateAll();
        this.checkInPrivacyLayout.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r4.mboundView31.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r4.mboundView51.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (r4.inputLayout.hasPendingBindings() == false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        if (r4.checkInPrivacyLayout.hasPendingBindings() == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.fullScreenTitleBar.hasPendingBindings() == false) goto L_0x0016;
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
        setVm((CheckInAddDependantInputViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.databinding.FragmentCheckInAddDependantInputBinding
    public void setVm(CheckInAddDependantInputViewModel checkInAddDependantInputViewModel) {
        this.mVm = checkInAddDependantInputViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.fullScreenTitleBar.setLifecycleOwner(lifecycleOwner);
        this.mboundView31.setLifecycleOwner(lifecycleOwner);
        this.mboundView51.setLifecycleOwner(lifecycleOwner);
        this.inputLayout.setLifecycleOwner(lifecycleOwner);
        this.checkInPrivacyLayout.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeCheckInPrivacyLayout((LayoutCheckInPrivacyBinding) obj, i2);
        }
        if (i == 1) {
            return onChangeVmAllRequiredFieldsInputted((ObservableBoolean) obj, i2);
        }
        if (i == 2) {
            return onChangeInputLayout((LayoutCheckInInputBinding) obj, i2);
        }
        if (i == 3) {
            return onChangeVmShouldSaveDependant((ObservableBoolean) obj, i2);
        }
        if (i == 4) {
            return onChangeVmFullScreenMode((ObservableBoolean) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return onChangeFullScreenTitleBar((LayoutCheckInTitleBarBinding) obj, i2);
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

    private boolean onChangeVmAllRequiredFieldsInputted(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeInputLayout(LayoutCheckInInputBinding layoutCheckInInputBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmShouldSaveDependant(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeVmFullScreenMode(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeFullScreenTitleBar(LayoutCheckInTitleBarBinding layoutCheckInTitleBarBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x015b  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        Drawable drawable;
        boolean z4;
        int i;
        boolean z5;
        int i2;
        boolean z6;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CheckInAddDependantInputViewModel checkInAddDependantInputViewModel = this.mVm;
        if ((218 & j) != 0) {
            int i3 = ((j & 194) > 0 ? 1 : ((j & 194) == 0 ? 0 : -1));
            if (i3 != 0) {
                ObservableBoolean allRequiredFieldsInputted = checkInAddDependantInputViewModel != null ? checkInAddDependantInputViewModel.getAllRequiredFieldsInputted() : null;
                updateRegistration(1, allRequiredFieldsInputted);
                if (allRequiredFieldsInputted != null) {
                    z5 = allRequiredFieldsInputted.get();
                } else {
                    z5 = false;
                }
                if (i3 != 0) {
                    j |= z5 ? 512 : 256;
                }
                i = getColorFromResource(this.mboundView7, z5 ? R.color.dw_orange_RES_2131034234 : R.color.dw_orange_disabled_RES_2131034235);
            } else {
                i = 0;
                z5 = false;
            }
            if ((j & 200) != 0) {
                ObservableBoolean shouldSaveDependant = checkInAddDependantInputViewModel != null ? checkInAddDependantInputViewModel.getShouldSaveDependant() : null;
                updateRegistration(3, shouldSaveDependant);
                if (shouldSaveDependant != null) {
                    z3 = shouldSaveDependant.get();
                    i2 = ((j & 208) > 0 ? 1 : ((j & 208) == 0 ? 0 : -1));
                    if (i2 == 0) {
                        ObservableBoolean fullScreenMode = checkInAddDependantInputViewModel != null ? checkInAddDependantInputViewModel.getFullScreenMode() : null;
                        updateRegistration(4, fullScreenMode);
                        if (fullScreenMode != null) {
                            z6 = fullScreenMode.get();
                        } else {
                            z6 = false;
                        }
                        if (i2 != 0) {
                            j |= z6 ? PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH : PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                        }
                        z4 = !z6;
                        drawable = AppCompatResources.getDrawable(this.mboundView2.getContext(), z6 ? R.drawable.solid_white : R.drawable.top_corners_card);
                        z2 = z5;
                        z = z6;
                        if ((j & 128) != 0) {
                            this.fullScreenTitleBar.setShowBack(true);
                            this.fullScreenTitleBar.setTitle(getRoot().getResources().getString(R.string.check_in_add_another));
                            this.mboundView31.setTitle(getRoot().getResources().getString(R.string.check_in_add_another));
                            this.mboundView4.setOnClickListener(this.mCallback11);
                            this.mboundView51.setInfo(getRoot().getResources().getString(R.string.check_in_what_is_a_dependant));
                            CompoundButtonBindingAdapter.setListeners(this.mboundView6, null, this.mboundView6androidCheckedAttrChanged);
                            this.mboundView7.setOnClickListener(this.mCallback12);
                        }
                        if ((j & 208) != 0) {
                            BindingAdaptersKt.setVisibleOrGone(this.fullScreenTitleBar.getRoot(), z);
                            BindingAdaptersKt.setVisibleOrGone(this.mboundView1, z4);
                            ViewBindingAdapter.setBackground(this.mboundView2, drawable);
                            BindingAdaptersKt.setVisibleOrGone(this.mboundView3, z4);
                        }
                        if ((192 & j) != 0) {
                            this.inputLayout.setVm(checkInAddDependantInputViewModel);
                        }
                        if ((200 & j) != 0) {
                            CompoundButtonBindingAdapter.setChecked(this.mboundView6, z3);
                        }
                        if ((j & 194) != 0) {
                            ViewBindingAdapter.setBackground(this.mboundView7, Converters.convertColorToDrawable(i));
                            this.mboundView7.setEnabled(z2);
                        }
                        executeBindingsOn(this.fullScreenTitleBar);
                        executeBindingsOn(this.mboundView31);
                        executeBindingsOn(this.mboundView51);
                        executeBindingsOn(this.inputLayout);
                        executeBindingsOn(this.checkInPrivacyLayout);
                    }
                    drawable = null;
                    z2 = z5;
                    z4 = false;
                }
            }
            z3 = false;
            i2 = ((j & 208) > 0 ? 1 : ((j & 208) == 0 ? 0 : -1));
            if (i2 == 0) {
            }
        } else {
            drawable = null;
            i = 0;
            z4 = false;
            z3 = false;
            z2 = false;
        }
        z = false;
        if ((j & 128) != 0) {
        }
        if ((j & 208) != 0) {
        }
        if ((192 & j) != 0) {
        }
        if ((200 & j) != 0) {
        }
        if ((j & 194) != 0) {
        }
        executeBindingsOn(this.fullScreenTitleBar);
        executeBindingsOn(this.mboundView31);
        executeBindingsOn(this.mboundView51);
        executeBindingsOn(this.inputLayout);
        executeBindingsOn(this.checkInPrivacyLayout);
    }

    @Override // com.digitalwallet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            CheckInAddDependantInputViewModel checkInAddDependantInputViewModel = this.mVm;
            if (checkInAddDependantInputViewModel != null) {
                z = true;
            }
            if (z) {
                checkInAddDependantInputViewModel.cancel();
            }
        } else if (i == 2) {
            CheckInAddDependantInputViewModel checkInAddDependantInputViewModel2 = this.mVm;
            if (checkInAddDependantInputViewModel2 != null) {
                z = true;
            }
            if (z) {
                checkInAddDependantInputViewModel2.toContinue();
            }
        }
    }
}
