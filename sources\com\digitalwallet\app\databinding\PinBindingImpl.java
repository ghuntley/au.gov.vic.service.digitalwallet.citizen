package com.digitalwallet.app.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.Editable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.view.util.BindingAdaptersKt;
import com.digitalwallet.app.viewmodel.pin.PinActivityViewModel;
import com.mukesh.OtpView;

public class PinBindingImpl extends PinBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback57;
    private final View.OnClickListener mCallback58;
    private long mDirtyFlags;
    private AfterTextChangedImpl mVmPinChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private final ConstraintLayout mboundView0;
    private final LinearLayout mboundView1;
    private final LayoutTitleBarBinding mboundView11;
    private final LinearLayout mboundView6;
    private final TextView mboundView7;
    private InverseBindingListener pinTextandroidTextAttrChanged;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(10);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"layout_title_bar"}, new int[]{9}, new int[]{R.layout.layout_title_bar_RES_2114388042});
    }

    public PinBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private PinBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 8, (Button) objArr[8], (TextView) objArr[5], (TextView) objArr[2], (TextView) objArr[3], (OtpView) objArr[4]);
        this.pinTextandroidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.app.databinding.PinBindingImpl.AnonymousClass1 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(PinBindingImpl.this.pinText);
                PinActivityViewModel pinActivityViewModel = PinBindingImpl.this.mVm;
                boolean z = true;
                if (pinActivityViewModel != null) {
                    ObservableField<String> pin = pinActivityViewModel.getPin();
                    if (pin == null) {
                        z = false;
                    }
                    if (z) {
                        pin.set(textString);
                    }
                }
            }
        };
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout;
        linearLayout.setTag(null);
        LayoutTitleBarBinding layoutTitleBarBinding = (LayoutTitleBarBinding) objArr[9];
        this.mboundView11 = layoutTitleBarBinding;
        setContainedBinding(layoutTitleBarBinding);
        LinearLayout linearLayout2 = (LinearLayout) objArr[6];
        this.mboundView6 = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView = (TextView) objArr[7];
        this.mboundView7 = textView;
        textView.setTag(null);
        this.nextButton.setTag(null);
        this.pinError.setTag(null);
        this.pinHeader.setTag(null);
        this.pinSubHeader.setTag(null);
        this.pinText.setTag(null);
        setRootTag(view);
        this.mCallback57 = new OnClickListener(this, 1);
        this.mCallback58 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 512;
        }
        this.mboundView11.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
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
        if (8257543 != i) {
            return false;
        }
        setVm((PinActivityViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.PinBinding
    public void setVm(PinActivityViewModel pinActivityViewModel) {
        this.mVm = pinActivityViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView11.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeVmSubHeaderText((ObservableField) obj, i2);
            case 1:
                return onChangeVmButtonAlpha((ObservableField) obj, i2);
            case 2:
                return onChangeVmPin((ObservableField) obj, i2);
            case 3:
                return onChangeVmHeaderText((ObservableField) obj, i2);
            case 4:
                return onChangeVmEnableButton((ObservableField) obj, i2);
            case 5:
                return onChangeVmPinError((ObservableField) obj, i2);
            case 6:
                return onChangeVmScreenTitle((ObservableField) obj, i2);
            case 7:
                return onChangeVmHideButton((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeVmSubHeaderText(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmButtonAlpha(ObservableField<Float> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmPin(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmHeaderText(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeVmEnableButton(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeVmPinError(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeVmScreenTitle(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeVmHideButton(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x015f  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        int i;
        boolean z;
        int i2;
        AfterTextChangedImpl afterTextChangedImpl;
        int i3;
        String str2;
        boolean z2;
        int i4;
        float f;
        boolean z3;
        float f2;
        int i5;
        boolean z4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        PinActivityViewModel pinActivityViewModel = this.mVm;
        if ((1023 & j) != 0) {
            if ((j & 768) != 0) {
                if (pinActivityViewModel != null) {
                    z4 = pinActivityViewModel.getPinSet();
                    AfterTextChangedImpl afterTextChangedImpl2 = this.mVmPinChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
                    if (afterTextChangedImpl2 == null) {
                        afterTextChangedImpl2 = new AfterTextChangedImpl();
                        this.mVmPinChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = afterTextChangedImpl2;
                    }
                    afterTextChangedImpl = afterTextChangedImpl2.setValue(pinActivityViewModel);
                } else {
                    z4 = false;
                    afterTextChangedImpl = null;
                }
                z3 = ViewDataBinding.safeUnbox(Boolean.valueOf(z4));
            } else {
                z3 = false;
                afterTextChangedImpl = null;
            }
            if ((j & 769) != 0) {
                ObservableField<Integer> subHeaderText = pinActivityViewModel != null ? pinActivityViewModel.getSubHeaderText() : null;
                updateRegistration(0, subHeaderText);
                i2 = ViewDataBinding.safeUnbox(subHeaderText != null ? subHeaderText.get() : null);
            } else {
                i2 = 0;
            }
            if ((j & 770) != 0) {
                ObservableField<Float> buttonAlpha = pinActivityViewModel != null ? pinActivityViewModel.getButtonAlpha() : null;
                updateRegistration(1, buttonAlpha);
                f2 = ViewDataBinding.safeUnbox(buttonAlpha != null ? buttonAlpha.get() : null);
            } else {
                f2 = 0.0f;
            }
            if ((j & 772) != 0) {
                ObservableField<String> pin = pinActivityViewModel != null ? pinActivityViewModel.getPin() : null;
                updateRegistration(2, pin);
                if (pin != null) {
                    str2 = pin.get();
                    if ((j & 776) == 0) {
                        ObservableField<Integer> headerText = pinActivityViewModel != null ? pinActivityViewModel.getHeaderText() : null;
                        updateRegistration(3, headerText);
                        i3 = ViewDataBinding.safeUnbox(headerText != null ? headerText.get() : null);
                    } else {
                        i3 = 0;
                    }
                    if ((j & 784) == 0) {
                        ObservableField<Boolean> enableButton = pinActivityViewModel != null ? pinActivityViewModel.getEnableButton() : null;
                        updateRegistration(4, enableButton);
                        z = ViewDataBinding.safeUnbox(enableButton != null ? enableButton.get() : null);
                    } else {
                        z = false;
                    }
                    if ((j & 800) == 0) {
                        ObservableField<Integer> pinError = pinActivityViewModel != null ? pinActivityViewModel.getPinError() : null;
                        updateRegistration(5, pinError);
                        i = ViewDataBinding.safeUnbox(pinError != null ? pinError.get() : null);
                    } else {
                        i = 0;
                    }
                    if ((j & 832) == 0) {
                        ObservableField<Integer> screenTitle = pinActivityViewModel != null ? pinActivityViewModel.getScreenTitle() : null;
                        updateRegistration(6, screenTitle);
                        str = getRoot().getContext().getString(ViewDataBinding.safeUnbox(screenTitle != null ? screenTitle.get() : null));
                    } else {
                        str = null;
                    }
                    i5 = ((j & 896) > 0 ? 1 : ((j & 896) == 0 ? 0 : -1));
                    if (i5 == 0) {
                        ObservableField<Boolean> hideButton = pinActivityViewModel != null ? pinActivityViewModel.getHideButton() : null;
                        updateRegistration(7, hideButton);
                        boolean safeUnbox = ViewDataBinding.safeUnbox(hideButton != null ? hideButton.get() : null);
                        if (i5 != 0) {
                            j |= safeUnbox ? PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH : PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                        }
                        int i6 = safeUnbox ? 4 : 0;
                        f = f2;
                        z2 = z3;
                        i4 = i6;
                    } else {
                        f = f2;
                        z2 = z3;
                        i4 = 0;
                    }
                }
            }
            str2 = null;
            if ((j & 776) == 0) {
            }
            if ((j & 784) == 0) {
            }
            if ((j & 800) == 0) {
            }
            if ((j & 832) == 0) {
            }
            i5 = ((j & 896) > 0 ? 1 : ((j & 896) == 0 ? 0 : -1));
            if (i5 == 0) {
            }
        } else {
            str2 = null;
            afterTextChangedImpl = null;
            str = null;
            f = 0.0f;
            i4 = 0;
            z2 = false;
            i3 = 0;
            i2 = 0;
            z = false;
            i = 0;
        }
        if ((j & 832) != 0) {
            this.mboundView11.setTitle(str);
        }
        if ((j & 768) != 0) {
            BindingAdaptersKt.setVisibleOrGone(this.mboundView6, z2);
            TextViewBindingAdapter.setTextWatcher(this.pinText, null, null, afterTextChangedImpl, this.pinTextandroidTextAttrChanged);
        }
        if ((512 & j) != 0) {
            this.mboundView7.setOnClickListener(this.mCallback57);
            this.nextButton.setOnClickListener(this.mCallback58);
        }
        if ((j & 770) != 0 && getBuildSdkInt() >= 11) {
            this.nextButton.setAlpha(f);
        }
        if ((784 & j) != 0) {
            this.nextButton.setEnabled(z);
        }
        if ((896 & j) != 0) {
            this.nextButton.setVisibility(i4);
        }
        if ((800 & j) != 0) {
            this.pinError.setText(i);
        }
        if ((776 & j) != 0) {
            this.pinHeader.setText(i3);
        }
        if ((j & 769) != 0) {
            this.pinSubHeader.setText(i2);
        }
        if ((j & 772) != 0) {
            TextViewBindingAdapter.setText(this.pinText, str2);
        }
        executeBindingsOn(this.mboundView11);
    }

    public static class AfterTextChangedImpl implements TextViewBindingAdapter.AfterTextChanged {
        private PinActivityViewModel value;

        public AfterTextChangedImpl setValue(PinActivityViewModel pinActivityViewModel) {
            this.value = pinActivityViewModel;
            if (pinActivityViewModel == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged
        public void afterTextChanged(Editable editable) {
            this.value.pinChanged(editable);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        if (i == 1) {
            PinActivityViewModel pinActivityViewModel = this.mVm;
            if (pinActivityViewModel != null) {
                z = true;
            }
            if (z) {
                pinActivityViewModel.loginWithEmail();
            }
        } else if (i == 2) {
            PinActivityViewModel pinActivityViewModel2 = this.mVm;
            if (pinActivityViewModel2 != null) {
                z = true;
            }
            if (z) {
                pinActivityViewModel2.pinNext();
            }
        }
    }
}
