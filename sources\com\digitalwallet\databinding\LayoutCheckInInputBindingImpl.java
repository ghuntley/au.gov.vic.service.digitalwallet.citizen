package com.digitalwallet.databinding;

import android.text.Editable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInInputBaseViewModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LayoutCheckInInputBindingImpl extends LayoutCheckInInputBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private InverseBindingListener firstNameEditTextandroidTextAttrChanged;
    private InverseBindingListener lastNameEditTextandroidTextAttrChanged;
    private long mDirtyFlags;
    private AfterTextChangedImpl mVmValidateInputsAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private final LinearLayout mboundView0;
    private final TextInputLayout mboundView3;
    private InverseBindingListener phoneNumberEditTextandroidTextAttrChanged;

    public LayoutCheckInInputBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private LayoutCheckInInputBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (TextInputEditText) objArr[1], (TextInputEditText) objArr[2], (TextInputEditText) objArr[4]);
        this.firstNameEditTextandroidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.databinding.LayoutCheckInInputBindingImpl.AnonymousClass1 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(LayoutCheckInInputBindingImpl.this.firstNameEditText);
                CheckInInputBaseViewModel checkInInputBaseViewModel = LayoutCheckInInputBindingImpl.this.mVm;
                boolean z = true;
                if (checkInInputBaseViewModel != null) {
                    ObservableField<String> firstName = checkInInputBaseViewModel.getFirstName();
                    if (firstName == null) {
                        z = false;
                    }
                    if (z) {
                        firstName.set(textString);
                    }
                }
            }
        };
        this.lastNameEditTextandroidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.databinding.LayoutCheckInInputBindingImpl.AnonymousClass2 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(LayoutCheckInInputBindingImpl.this.lastNameEditText);
                CheckInInputBaseViewModel checkInInputBaseViewModel = LayoutCheckInInputBindingImpl.this.mVm;
                boolean z = true;
                if (checkInInputBaseViewModel != null) {
                    ObservableField<String> lastName = checkInInputBaseViewModel.getLastName();
                    if (lastName == null) {
                        z = false;
                    }
                    if (z) {
                        lastName.set(textString);
                    }
                }
            }
        };
        this.phoneNumberEditTextandroidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.databinding.LayoutCheckInInputBindingImpl.AnonymousClass3 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(LayoutCheckInInputBindingImpl.this.phoneNumberEditText);
                CheckInInputBaseViewModel checkInInputBaseViewModel = LayoutCheckInInputBindingImpl.this.mVm;
                boolean z = true;
                if (checkInInputBaseViewModel != null) {
                    ObservableField<String> phoneNumber = checkInInputBaseViewModel.getPhoneNumber();
                    if (phoneNumber == null) {
                        z = false;
                    }
                    if (z) {
                        phoneNumber.set(textString);
                    }
                }
            }
        };
        this.mDirtyFlags = -1;
        this.firstNameEditText.setTag(null);
        this.lastNameEditText.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextInputLayout textInputLayout = (TextInputLayout) objArr[3];
        this.mboundView3 = textInputLayout;
        textInputLayout.setTag(null);
        this.phoneNumberEditText.setTag(null);
        setRootTag(view);
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
        setVm((CheckInInputBaseViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.databinding.LayoutCheckInInputBinding
    public void setVm(CheckInInputBaseViewModel checkInInputBaseViewModel) {
        this.mVm = checkInInputBaseViewModel;
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
            return onChangeVmLastName((ObservableField) obj, i2);
        }
        if (i == 1) {
            return onChangeVmRequirePhoneNumber((ObservableBoolean) obj, i2);
        }
        if (i == 2) {
            return onChangeVmFirstName((ObservableField) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return onChangeVmPhoneNumber((ObservableField) obj, i2);
    }

    private boolean onChangeVmLastName(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmRequirePhoneNumber(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmFirstName(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmPhoneNumber(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b8  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        AfterTextChangedImpl afterTextChangedImpl;
        String str4;
        int i;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CheckInInputBaseViewModel checkInInputBaseViewModel = this.mVm;
        if ((63 & j) != 0) {
            if ((j & 48) == 0 || checkInInputBaseViewModel == null) {
                afterTextChangedImpl = null;
            } else {
                AfterTextChangedImpl afterTextChangedImpl2 = this.mVmValidateInputsAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
                if (afterTextChangedImpl2 == null) {
                    afterTextChangedImpl2 = new AfterTextChangedImpl();
                    this.mVmValidateInputsAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = afterTextChangedImpl2;
                }
                afterTextChangedImpl = afterTextChangedImpl2.setValue(checkInInputBaseViewModel);
            }
            if ((j & 49) != 0) {
                ObservableField<String> lastName = checkInInputBaseViewModel != null ? checkInInputBaseViewModel.getLastName() : null;
                updateRegistration(0, lastName);
                if (lastName != null) {
                    str = lastName.get();
                    i = ((j & 50) > 0 ? 1 : ((j & 50) == 0 ? 0 : -1));
                    if (i == 0) {
                        ObservableBoolean requirePhoneNumber = checkInInputBaseViewModel != null ? checkInInputBaseViewModel.getRequirePhoneNumber() : null;
                        updateRegistration(1, requirePhoneNumber);
                        if (requirePhoneNumber != null) {
                            z = requirePhoneNumber.get();
                        } else {
                            z = false;
                        }
                        if (i != 0) {
                            j |= z ? 128 : 64;
                        }
                        str3 = this.mboundView3.getResources().getString(z ? R.string.check_in_phone_no_placeholder_required : R.string.check_in_phone_no_placeholder_optional);
                    } else {
                        str3 = null;
                    }
                    if ((j & 52) != 0) {
                        ObservableField<String> firstName = checkInInputBaseViewModel != null ? checkInInputBaseViewModel.getFirstName() : null;
                        updateRegistration(2, firstName);
                        if (firstName != null) {
                            str2 = firstName.get();
                            if ((j & 56) != 0) {
                                ObservableField<String> phoneNumber = checkInInputBaseViewModel != null ? checkInInputBaseViewModel.getPhoneNumber() : null;
                                updateRegistration(3, phoneNumber);
                                if (phoneNumber != null) {
                                    str4 = phoneNumber.get();
                                }
                            }
                            str4 = null;
                        }
                    }
                    str2 = null;
                    if ((j & 56) != 0) {
                    }
                    str4 = null;
                }
            }
            str = null;
            i = ((j & 50) > 0 ? 1 : ((j & 50) == 0 ? 0 : -1));
            if (i == 0) {
            }
            if ((j & 52) != 0) {
            }
            str2 = null;
            if ((j & 56) != 0) {
            }
            str4 = null;
        } else {
            str4 = null;
            afterTextChangedImpl = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((52 & j) != 0) {
            TextViewBindingAdapter.setText(this.firstNameEditText, str2);
        }
        if ((j & 48) != 0) {
            TextViewBindingAdapter.BeforeTextChanged beforeTextChanged = null;
            TextViewBindingAdapter.OnTextChanged onTextChanged = null;
            TextViewBindingAdapter.setTextWatcher(this.firstNameEditText, beforeTextChanged, onTextChanged, afterTextChangedImpl, this.firstNameEditTextandroidTextAttrChanged);
            TextViewBindingAdapter.setTextWatcher(this.lastNameEditText, beforeTextChanged, onTextChanged, afterTextChangedImpl, this.lastNameEditTextandroidTextAttrChanged);
            TextViewBindingAdapter.setTextWatcher(this.phoneNumberEditText, beforeTextChanged, onTextChanged, afterTextChangedImpl, this.phoneNumberEditTextandroidTextAttrChanged);
        }
        if ((49 & j) != 0) {
            TextViewBindingAdapter.setText(this.lastNameEditText, str);
        }
        if ((50 & j) != 0) {
            this.mboundView3.setPlaceholderText(str3);
        }
        if ((j & 56) != 0) {
            TextViewBindingAdapter.setText(this.phoneNumberEditText, str4);
        }
    }

    public static class AfterTextChangedImpl implements TextViewBindingAdapter.AfterTextChanged {
        private CheckInInputBaseViewModel value;

        public AfterTextChangedImpl setValue(CheckInInputBaseViewModel checkInInputBaseViewModel) {
            this.value = checkInInputBaseViewModel;
            if (checkInInputBaseViewModel == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged
        public void afterTextChanged(Editable editable) {
            this.value.validateInputs(editable);
        }
    }
}
