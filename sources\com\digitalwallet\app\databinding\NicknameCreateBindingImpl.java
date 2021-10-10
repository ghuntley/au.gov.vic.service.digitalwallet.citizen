package com.digitalwallet.app.databinding;

import android.text.Editable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.viewmodel.main.NicknameViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class NicknameCreateBindingImpl extends NicknameCreateBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback16;
    private long mDirtyFlags;
    private AfterTextChangedImpl mVmNicknameChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private final NestedScrollView mboundView0;
    private InverseBindingListener nicknameandroidTextAttrChanged;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.imageView, 3);
        sparseIntArray.put(R.id.header, 4);
        sparseIntArray.put(R.id.v_login_privacy, 5);
    }

    public NicknameCreateBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private NicknameCreateBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (LinearLayout) objArr[4], (ImageView) objArr[3], (TextInputEditText) objArr[1], (Button) objArr[2], (TextView) objArr[5]);
        this.nicknameandroidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.app.databinding.NicknameCreateBindingImpl.AnonymousClass1 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(NicknameCreateBindingImpl.this.nickname);
                NicknameViewModel nicknameViewModel = NicknameCreateBindingImpl.this.mVm;
                boolean z = true;
                if (nicknameViewModel != null) {
                    ObservableField<String> nickname = nicknameViewModel.getNickname();
                    if (nickname == null) {
                        z = false;
                    }
                    if (z) {
                        nickname.set(textString);
                    }
                }
            }
        };
        this.mDirtyFlags = -1;
        NestedScrollView nestedScrollView = (NestedScrollView) objArr[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        this.nickname.setTag(null);
        this.save.setTag(null);
        setRootTag(view);
        this.mCallback16 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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
        if (8257543 != i) {
            return false;
        }
        setVm((NicknameViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.NicknameCreateBinding
    public void setVm(NicknameViewModel nicknameViewModel) {
        this.mVm = nicknameViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeVmButtonEnabled((ObservableField) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeVmNickname((ObservableField) obj, i2);
    }

    private boolean onChangeVmButtonEnabled(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmNickname(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        AfterTextChangedImpl afterTextChangedImpl;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        float f = 0.0f;
        NicknameViewModel nicknameViewModel = this.mVm;
        boolean z = false;
        if ((15 & j) != 0) {
            int i = ((j & 13) > 0 ? 1 : ((j & 13) == 0 ? 0 : -1));
            if (i != 0) {
                ObservableField<Boolean> buttonEnabled = nicknameViewModel != null ? nicknameViewModel.getButtonEnabled() : null;
                updateRegistration(0, buttonEnabled);
                Boolean bool = buttonEnabled != null ? buttonEnabled.get() : null;
                z = ViewDataBinding.safeUnbox(bool);
                boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
                if (i != 0) {
                    j |= safeUnbox ? 32 : 16;
                }
                f = safeUnbox ? 1.0f : 0.5f;
            }
            if ((j & 14) != 0) {
                ObservableField<String> nickname = nicknameViewModel != null ? nicknameViewModel.getNickname() : null;
                updateRegistration(1, nickname);
                if (nickname != null) {
                    str = nickname.get();
                    if ((j & 12) != 0 || nicknameViewModel == null) {
                        afterTextChangedImpl = null;
                    } else {
                        AfterTextChangedImpl afterTextChangedImpl2 = this.mVmNicknameChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
                        if (afterTextChangedImpl2 == null) {
                            afterTextChangedImpl2 = new AfterTextChangedImpl();
                            this.mVmNicknameChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = afterTextChangedImpl2;
                        }
                        afterTextChangedImpl = afterTextChangedImpl2.setValue(nicknameViewModel);
                    }
                }
            }
            str = null;
            if ((j & 12) != 0) {
            }
            afterTextChangedImpl = null;
        } else {
            afterTextChangedImpl = null;
            str = null;
        }
        if ((j & 14) != 0) {
            TextViewBindingAdapter.setText(this.nickname, str);
        }
        if ((j & 12) != 0) {
            TextViewBindingAdapter.setTextWatcher(this.nickname, null, null, afterTextChangedImpl, this.nicknameandroidTextAttrChanged);
        }
        if ((13 & j) != 0) {
            this.save.setEnabled(z);
            if (getBuildSdkInt() >= 11) {
                this.save.setAlpha(f);
            }
        }
        if ((j & 8) != 0) {
            this.save.setOnClickListener(this.mCallback16);
        }
    }

    public static class AfterTextChangedImpl implements TextViewBindingAdapter.AfterTextChanged {
        private NicknameViewModel value;

        public AfterTextChangedImpl setValue(NicknameViewModel nicknameViewModel) {
            this.value = nicknameViewModel;
            if (nicknameViewModel == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged
        public void afterTextChanged(Editable editable) {
            this.value.nicknameChanged(editable);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        NicknameViewModel nicknameViewModel = this.mVm;
        if (nicknameViewModel != null) {
            nicknameViewModel.save();
        }
    }
}
