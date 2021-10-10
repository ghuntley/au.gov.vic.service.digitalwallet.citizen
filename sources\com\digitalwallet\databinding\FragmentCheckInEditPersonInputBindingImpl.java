package com.digitalwallet.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.Converters;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.generated.callback.OnClickListener;
import com.digitalwallet.view.util.BindingAdaptersKt;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInEditPersonInputViewModel;

public class FragmentCheckInEditPersonInputBindingImpl extends FragmentCheckInEditPersonInputBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback10;
    private final View.OnClickListener mCallback8;
    private final View.OnClickListener mCallback9;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final ConstraintLayout mboundView1;
    private final LayoutTitleBarBinding mboundView11;
    private final TextView mboundView2;
    private final TextView mboundView3;
    private final LinearLayout mboundView4;
    private final Button mboundView5;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(8);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"layout_title_bar"}, new int[]{6}, new int[]{R.layout.layout_title_bar_RES_2131492940});
        includedLayouts.setIncludes(4, new String[]{"layout_check_in_input"}, new int[]{7}, new int[]{R.layout.layout_check_in_input});
    }

    public FragmentCheckInEditPersonInputBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private FragmentCheckInEditPersonInputBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (LayoutCheckInInputBinding) objArr[7]);
        this.mDirtyFlags = -1;
        setContainedBinding(this.inputLayout);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[1];
        this.mboundView1 = constraintLayout2;
        constraintLayout2.setTag(null);
        LayoutTitleBarBinding layoutTitleBarBinding = (LayoutTitleBarBinding) objArr[6];
        this.mboundView11 = layoutTitleBarBinding;
        setContainedBinding(layoutTitleBarBinding);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.mboundView3 = textView2;
        textView2.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[4];
        this.mboundView4 = linearLayout;
        linearLayout.setTag(null);
        Button button = (Button) objArr[5];
        this.mboundView5 = button;
        button.setTag(null);
        setRootTag(view);
        this.mCallback10 = new OnClickListener(this, 3);
        this.mCallback9 = new OnClickListener(this, 2);
        this.mCallback8 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16;
        }
        this.mboundView11.invalidateAll();
        this.inputLayout.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r4.inputLayout.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.mboundView11.hasPendingBindings() == false) goto L_0x0016;
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
        setVm((CheckInEditPersonInputViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.databinding.FragmentCheckInEditPersonInputBinding
    public void setVm(CheckInEditPersonInputViewModel checkInEditPersonInputViewModel) {
        this.mVm = checkInEditPersonInputViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView11.setLifecycleOwner(lifecycleOwner);
        this.inputLayout.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeVmIsEditingPrimaryPerson((ObservableBoolean) obj, i2);
        }
        if (i == 1) {
            return onChangeVmAllRequiredFieldsInputted((ObservableBoolean) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return onChangeInputLayout((LayoutCheckInInputBinding) obj, i2);
    }

    private boolean onChangeVmIsEditingPrimaryPerson(ObservableBoolean observableBoolean, int i) {
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

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CheckInEditPersonInputViewModel checkInEditPersonInputViewModel = this.mVm;
        boolean z4 = false;
        if ((27 & j) != 0) {
            ObservableBoolean observableBoolean = null;
            if ((j & 25) != 0) {
                ObservableBoolean isEditingPrimaryPerson = checkInEditPersonInputViewModel != null ? checkInEditPersonInputViewModel.isEditingPrimaryPerson() : null;
                updateRegistration(0, isEditingPrimaryPerson);
                if (isEditingPrimaryPerson != null) {
                    z3 = isEditingPrimaryPerson.get();
                } else {
                    z3 = false;
                }
                z2 = !z3;
            } else {
                z2 = false;
            }
            int i2 = ((j & 26) > 0 ? 1 : ((j & 26) == 0 ? 0 : -1));
            if (i2 != 0) {
                if (checkInEditPersonInputViewModel != null) {
                    observableBoolean = checkInEditPersonInputViewModel.getAllRequiredFieldsInputted();
                }
                updateRegistration(1, observableBoolean);
                if (observableBoolean != null) {
                    z4 = observableBoolean.get();
                }
                if (i2 != 0) {
                    j |= z4 ? 64 : 32;
                }
                i = getColorFromResource(this.mboundView5, z4 ? R.color.dw_orange_RES_2131034234 : R.color.dw_orange_disabled_RES_2131034235);
                z4 = z2;
                z = z4;
            } else {
                i = 0;
                z4 = z2;
                z = false;
            }
        } else {
            z = false;
            i = 0;
        }
        if ((24 & j) != 0) {
            this.inputLayout.setVm(checkInEditPersonInputViewModel);
        }
        if ((16 & j) != 0) {
            this.mboundView11.setTitle(getRoot().getResources().getString(R.string.check_in_edit_details));
            this.mboundView2.setOnClickListener(this.mCallback8);
            this.mboundView3.setOnClickListener(this.mCallback9);
            this.mboundView5.setOnClickListener(this.mCallback10);
        }
        if ((25 & j) != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.mboundView3, z4);
        }
        if ((j & 26) != 0) {
            ViewBindingAdapter.setBackground(this.mboundView5, Converters.convertColorToDrawable(i));
            this.mboundView5.setEnabled(z);
        }
        executeBindingsOn(this.mboundView11);
        executeBindingsOn(this.inputLayout);
    }

    @Override // com.digitalwallet.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            CheckInEditPersonInputViewModel checkInEditPersonInputViewModel = this.mVm;
            if (checkInEditPersonInputViewModel != null) {
                z = true;
            }
            if (z) {
                checkInEditPersonInputViewModel.cancel();
            }
        } else if (i == 2) {
            CheckInEditPersonInputViewModel checkInEditPersonInputViewModel2 = this.mVm;
            if (checkInEditPersonInputViewModel2 != null) {
                z = true;
            }
            if (z) {
                checkInEditPersonInputViewModel2.deleteDependant();
            }
        } else if (i == 3) {
            CheckInEditPersonInputViewModel checkInEditPersonInputViewModel3 = this.mVm;
            if (checkInEditPersonInputViewModel3 != null) {
                z = true;
            }
            if (z) {
                checkInEditPersonInputViewModel3.update();
            }
        }
    }
}
