package com.digitalwallet.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.viewmodel.login.RegisterSuccessViewModel;

public class FragmentRegisterSuccessBindingImpl extends FragmentRegisterSuccessBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback29;
    private long mDirtyFlags;
    private final LayoutTitleBarBinding mboundView0;
    private final LinearLayout mboundView01;

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(6);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_title_bar"}, new int[]{2}, new int[]{R.layout.layout_title_bar_RES_2114388042});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.thank_you_text, 3);
        sparseIntArray.put(R.id.success_icon, 4);
        sparseIntArray.put(R.id.instructions_text, 5);
    }

    public FragmentRegisterSuccessBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private FragmentRegisterSuccessBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[1], (TextView) objArr[5], (ImageView) objArr[4], (TextView) objArr[3]);
        this.mDirtyFlags = -1;
        this.createPasscodeButton.setTag(null);
        LayoutTitleBarBinding layoutTitleBarBinding = (LayoutTitleBarBinding) objArr[2];
        this.mboundView0 = layoutTitleBarBinding;
        setContainedBinding(layoutTitleBarBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView01 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        this.mCallback29 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
        }
        this.mboundView0.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.mboundView0.hasPendingBindings() == false) goto L_0x0016;
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
        setVm((RegisterSuccessViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.FragmentRegisterSuccessBinding
    public void setVm(RegisterSuccessViewModel registerSuccessViewModel) {
        this.mVm = registerSuccessViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView0.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        RegisterSuccessViewModel registerSuccessViewModel = this.mVm;
        if ((j & 2) != 0) {
            this.createPasscodeButton.setOnClickListener(this.mCallback29);
            this.mboundView0.setTitle(getRoot().getResources().getString(R.string.registration_successful));
        }
        executeBindingsOn(this.mboundView0);
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        RegisterSuccessViewModel registerSuccessViewModel = this.mVm;
        if (registerSuccessViewModel != null) {
            registerSuccessViewModel.createAPasscode();
        }
    }
}
