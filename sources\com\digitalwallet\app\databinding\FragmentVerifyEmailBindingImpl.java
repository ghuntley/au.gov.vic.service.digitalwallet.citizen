package com.digitalwallet.app.databinding;

import android.text.SpannableStringBuilder;
import android.util.SparseIntArray;
import android.view.View;
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
import com.digitalwallet.app.viewmodel.login.VerifyEmailViewModel;
import com.mukesh.OtpView;

public class FragmentVerifyEmailBindingImpl extends FragmentVerifyEmailBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final LayoutLoadingBinding mboundView01;
    private final TextView mboundView1;
    private InverseBindingListener otpViewandroidTextAttrChanged;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(6);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_title_bar", "layout_loading"}, new int[]{4, 5}, new int[]{R.layout.layout_title_bar_RES_2114388042, R.layout.layout_loading_RES_2114388041});
    }

    public FragmentVerifyEmailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private FragmentVerifyEmailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (TextView) objArr[3], (OtpView) objArr[2], (LayoutTitleBarBinding) objArr[4]);
        this.otpViewandroidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.app.databinding.FragmentVerifyEmailBindingImpl.AnonymousClass1 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentVerifyEmailBindingImpl.this.otpView);
                VerifyEmailViewModel verifyEmailViewModel = FragmentVerifyEmailBindingImpl.this.mVm;
                boolean z = true;
                if (verifyEmailViewModel != null) {
                    ObservableField<String> otpInput = verifyEmailViewModel.getOtpInput();
                    if (otpInput == null) {
                        z = false;
                    }
                    if (z) {
                        otpInput.set(textString);
                    }
                }
            }
        };
        this.mDirtyFlags = -1;
        this.checkEmailDescription.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        LayoutLoadingBinding layoutLoadingBinding = (LayoutLoadingBinding) objArr[5];
        this.mboundView01 = layoutLoadingBinding;
        setContainedBinding(layoutLoadingBinding);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        this.otpView.setTag(null);
        setContainedBinding(this.titleBar);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
        }
        this.titleBar.invalidateAll();
        this.mboundView01.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r4.mboundView01.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
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
        if (8257543 != i) {
            return false;
        }
        setVm((VerifyEmailViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.FragmentVerifyEmailBinding
    public void setVm(VerifyEmailViewModel verifyEmailViewModel) {
        this.mVm = verifyEmailViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleBar.setLifecycleOwner(lifecycleOwner);
        this.mboundView01.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeTitleBar((LayoutTitleBarBinding) obj, i2);
        }
        if (i == 1) {
            return onChangeVmShowLoading((ObservableField) obj, i2);
        }
        if (i == 2) {
            return onChangeVmOtpInput((ObservableField) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return onChangeVmEmail((ObservableField) obj, i2);
    }

    private boolean onChangeTitleBar(LayoutTitleBarBinding layoutTitleBarBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmShowLoading(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmOtpInput(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmEmail(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0091  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        Boolean bool;
        SpannableStringBuilder spannableStringBuilder;
        String str2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        VerifyEmailViewModel verifyEmailViewModel = this.mVm;
        if ((62 & j) != 0) {
            spannableStringBuilder = ((j & 48) == 0 || verifyEmailViewModel == null) ? null : verifyEmailViewModel.getDetailedDescription();
            if ((j & 50) != 0) {
                ObservableField<Boolean> showLoading = verifyEmailViewModel != null ? verifyEmailViewModel.getShowLoading() : null;
                updateRegistration(1, showLoading);
                if (showLoading != null) {
                    bool = showLoading.get();
                    if ((j & 52) != 0) {
                        ObservableField<String> otpInput = verifyEmailViewModel != null ? verifyEmailViewModel.getOtpInput() : null;
                        updateRegistration(2, otpInput);
                        if (otpInput != null) {
                            str = otpInput.get();
                            if ((j & 56) != 0) {
                                ObservableField<String> email = verifyEmailViewModel != null ? verifyEmailViewModel.getEmail() : null;
                                updateRegistration(3, email);
                                str2 = (email != null ? email.get() : null) + '.';
                            } else {
                                str2 = null;
                            }
                        }
                    }
                    str = null;
                    if ((j & 56) != 0) {
                    }
                }
            }
            bool = null;
            if ((j & 52) != 0) {
            }
            str = null;
            if ((j & 56) != 0) {
            }
        } else {
            str2 = null;
            spannableStringBuilder = null;
            bool = null;
            str = null;
        }
        if ((48 & j) != 0) {
            TextViewBindingAdapter.setText(this.checkEmailDescription, spannableStringBuilder);
        }
        if ((50 & j) != 0) {
            this.mboundView01.setShowLoading(bool);
        }
        if ((56 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView1, str2);
        }
        if ((j & 52) != 0) {
            TextViewBindingAdapter.setText(this.otpView, str);
        }
        if ((j & 32) != 0) {
            TextViewBindingAdapter.setTextWatcher(this.otpView, null, null, null, this.otpViewandroidTextAttrChanged);
            this.titleBar.setTitle(getRoot().getResources().getString(R.string.check_email));
        }
        executeBindingsOn(this.titleBar);
        executeBindingsOn(this.mboundView01);
    }
}
