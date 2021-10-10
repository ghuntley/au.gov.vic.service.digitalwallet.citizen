package com.digitalwallet.app.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.Editable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.Converters;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.generated.callback.OnClickListener;
import com.digitalwallet.app.viewmodel.login.CreateAccountViewModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class FragmentCreateAccountBindingImpl extends FragmentCreateAccountBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private InverseBindingListener emailEditTextandroidTextAttrChanged;
    private final View.OnClickListener mCallback11;
    private long mDirtyFlags;
    private AfterTextChangedImpl2 mVmOnEmailChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private AfterTextChangedImpl3 mVmOnFamilyNameChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private AfterTextChangedImpl mVmOnGivenNamesChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private AfterTextChangedImpl1 mVmOnPasswordChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private final ConstraintLayout mboundView0;
    private final LayoutLoadingBinding mboundView01;
    private final LayoutTitleBarBinding mboundView1;
    private final TextView mboundView10;
    private final TextView mboundView11;
    private final Button mboundView12;
    private final TextInputLayout mboundView2;
    private final TextInputEditText mboundView3;
    private InverseBindingListener mboundView3androidTextAttrChanged;
    private final TextInputLayout mboundView4;
    private final TextInputEditText mboundView5;
    private InverseBindingListener mboundView5androidTextAttrChanged;
    private final TextInputLayout mboundView6;
    private final TextInputEditText mboundView8;
    private InverseBindingListener mboundView8androidTextAttrChanged;
    private final TextView mboundView9;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(17);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_loading"}, new int[]{14}, new int[]{R.layout.layout_loading_RES_2114388041});
        includedLayouts.setIncludes(1, new String[]{"layout_title_bar"}, new int[]{13}, new int[]{R.layout.layout_title_bar_RES_2114388042});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.back_button_RES_2114322446, 15);
        sparseIntArray.put(R.id.login_button, 16);
    }

    public FragmentCreateAccountBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    private FragmentCreateAccountBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 12, (ImageView) objArr[15], (TextInputEditText) objArr[7], (LinearLayout) objArr[16], (ConstraintLayout) objArr[1]);
        this.emailEditTextandroidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.app.databinding.FragmentCreateAccountBindingImpl.AnonymousClass1 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentCreateAccountBindingImpl.this.emailEditText);
                CreateAccountViewModel createAccountViewModel = FragmentCreateAccountBindingImpl.this.mVm;
                boolean z = true;
                if (createAccountViewModel != null) {
                    ObservableField<String> email = createAccountViewModel.getEmail();
                    if (email == null) {
                        z = false;
                    }
                    if (z) {
                        email.set(textString);
                    }
                }
            }
        };
        this.mboundView3androidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.app.databinding.FragmentCreateAccountBindingImpl.AnonymousClass2 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentCreateAccountBindingImpl.this.mboundView3);
                CreateAccountViewModel createAccountViewModel = FragmentCreateAccountBindingImpl.this.mVm;
                boolean z = true;
                if (createAccountViewModel != null) {
                    ObservableField<String> givenNames = createAccountViewModel.getGivenNames();
                    if (givenNames == null) {
                        z = false;
                    }
                    if (z) {
                        givenNames.set(textString);
                    }
                }
            }
        };
        this.mboundView5androidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.app.databinding.FragmentCreateAccountBindingImpl.AnonymousClass3 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentCreateAccountBindingImpl.this.mboundView5);
                CreateAccountViewModel createAccountViewModel = FragmentCreateAccountBindingImpl.this.mVm;
                boolean z = true;
                if (createAccountViewModel != null) {
                    ObservableField<String> familyName = createAccountViewModel.getFamilyName();
                    if (familyName == null) {
                        z = false;
                    }
                    if (z) {
                        familyName.set(textString);
                    }
                }
            }
        };
        this.mboundView8androidTextAttrChanged = new InverseBindingListener() {
            /* class com.digitalwallet.app.databinding.FragmentCreateAccountBindingImpl.AnonymousClass4 */

            @Override // androidx.databinding.InverseBindingListener
            public void onChange() {
                String textString = TextViewBindingAdapter.getTextString(FragmentCreateAccountBindingImpl.this.mboundView8);
                CreateAccountViewModel createAccountViewModel = FragmentCreateAccountBindingImpl.this.mVm;
                boolean z = true;
                if (createAccountViewModel != null) {
                    ObservableField<String> password = createAccountViewModel.getPassword();
                    if (password == null) {
                        z = false;
                    }
                    if (z) {
                        password.set(textString);
                    }
                }
            }
        };
        this.mDirtyFlags = -1;
        this.emailEditText.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        LayoutLoadingBinding layoutLoadingBinding = (LayoutLoadingBinding) objArr[14];
        this.mboundView01 = layoutLoadingBinding;
        setContainedBinding(layoutLoadingBinding);
        LayoutTitleBarBinding layoutTitleBarBinding = (LayoutTitleBarBinding) objArr[13];
        this.mboundView1 = layoutTitleBarBinding;
        setContainedBinding(layoutTitleBarBinding);
        TextView textView = (TextView) objArr[10];
        this.mboundView10 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[11];
        this.mboundView11 = textView2;
        textView2.setTag(null);
        Button button = (Button) objArr[12];
        this.mboundView12 = button;
        button.setTag(null);
        TextInputLayout textInputLayout = (TextInputLayout) objArr[2];
        this.mboundView2 = textInputLayout;
        textInputLayout.setTag(null);
        TextInputEditText textInputEditText = (TextInputEditText) objArr[3];
        this.mboundView3 = textInputEditText;
        textInputEditText.setTag(null);
        TextInputLayout textInputLayout2 = (TextInputLayout) objArr[4];
        this.mboundView4 = textInputLayout2;
        textInputLayout2.setTag(null);
        TextInputEditText textInputEditText2 = (TextInputEditText) objArr[5];
        this.mboundView5 = textInputEditText2;
        textInputEditText2.setTag(null);
        TextInputLayout textInputLayout3 = (TextInputLayout) objArr[6];
        this.mboundView6 = textInputLayout3;
        textInputLayout3.setTag(null);
        TextInputEditText textInputEditText3 = (TextInputEditText) objArr[8];
        this.mboundView8 = textInputEditText3;
        textInputEditText3.setTag(null);
        TextView textView3 = (TextView) objArr[9];
        this.mboundView9 = textView3;
        textView3.setTag(null);
        this.titleBar.setTag(null);
        setRootTag(view);
        this.mCallback11 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        this.mboundView1.invalidateAll();
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
        if (r4.mboundView1.hasPendingBindings() == false) goto L_0x0016;
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
        setVm((CreateAccountViewModel) obj);
        return true;
    }

    @Override // com.digitalwallet.app.databinding.FragmentCreateAccountBinding
    public void setVm(CreateAccountViewModel createAccountViewModel) {
        this.mVm = createAccountViewModel;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView1.setLifecycleOwner(lifecycleOwner);
        this.mboundView01.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeVmFamilyNameError((ObservableField) obj, i2);
            case 1:
                return onChangeVmGivenNames((ObservableField) obj, i2);
            case 2:
                return onChangeVmGivenNamesError((ObservableField) obj, i2);
            case 3:
                return onChangeVmPwLowerLetterHintColor((ObservableField) obj, i2);
            case 4:
                return onChangeVmPwUpperLetterHintColor((ObservableField) obj, i2);
            case 5:
                return onChangeVmFamilyName((ObservableField) obj, i2);
            case 6:
                return onChangeVmPwLengthHintColor((ObservableField) obj, i2);
            case 7:
                return onChangeVmShowLoading((ObservableField) obj, i2);
            case 8:
                return onChangeVmPassword((ObservableField) obj, i2);
            case 9:
                return onChangeVmEmailError((ObservableField) obj, i2);
            case 10:
                return onChangeVmAreAllInputsValid((ObservableField) obj, i2);
            case 11:
                return onChangeVmEmail((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeVmFamilyNameError(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeVmGivenNames(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeVmGivenNamesError(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeVmPwLowerLetterHintColor(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeVmPwUpperLetterHintColor(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeVmFamilyName(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeVmPwLengthHintColor(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeVmShowLoading(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeVmPassword(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeVmEmailError(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeVmAreAllInputsValid(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean onChangeVmEmail(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0157  */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        boolean z;
        boolean z2;
        String str;
        String str2;
        int i2;
        String str3;
        AfterTextChangedImpl afterTextChangedImpl;
        int i3;
        String str4;
        AfterTextChangedImpl3 afterTextChangedImpl3;
        AfterTextChangedImpl2 afterTextChangedImpl2;
        AfterTextChangedImpl1 afterTextChangedImpl1;
        String str5;
        String str6;
        int i4;
        boolean z3;
        boolean z4;
        Boolean bool;
        String str7;
        String str8;
        String str9;
        boolean z5;
        boolean z6;
        String str10;
        AfterTextChangedImpl3 afterTextChangedImpl32;
        AfterTextChangedImpl2 afterTextChangedImpl22;
        AfterTextChangedImpl1 afterTextChangedImpl12;
        String str11;
        boolean z7;
        String str12;
        int i5;
        int i6;
        int i7;
        String str13;
        int i8;
        int i9;
        Boolean bool2;
        Boolean bool3;
        String str14;
        String str15;
        boolean z8;
        long j2;
        String str16;
        int i10;
        int i11;
        String str17;
        int i12;
        boolean z9;
        ObservableField<Boolean> observableField;
        ObservableField<String> observableField2;
        ObservableField<String> observableField3;
        ObservableField<Boolean> observableField4;
        ObservableField<Integer> observableField5;
        ObservableField<String> observableField6;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        CreateAccountViewModel createAccountViewModel = this.mVm;
        if ((16383 & j) != 0) {
            if ((j & 12289) != 0) {
                ObservableField<String> familyNameError = createAccountViewModel != null ? createAccountViewModel.getFamilyNameError() : null;
                updateRegistration(0, familyNameError);
                if (familyNameError != null) {
                    str10 = familyNameError.get();
                } else {
                    str10 = null;
                }
                z6 = str10 != null;
            } else {
                z6 = false;
                str10 = null;
            }
            if ((j & 12288) == 0 || createAccountViewModel == null) {
                afterTextChangedImpl12 = null;
                afterTextChangedImpl22 = null;
                afterTextChangedImpl32 = null;
                afterTextChangedImpl = null;
            } else {
                AfterTextChangedImpl afterTextChangedImpl4 = this.mVmOnGivenNamesChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
                if (afterTextChangedImpl4 == null) {
                    afterTextChangedImpl4 = new AfterTextChangedImpl();
                    this.mVmOnGivenNamesChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = afterTextChangedImpl4;
                }
                afterTextChangedImpl = afterTextChangedImpl4.setValue(createAccountViewModel);
                AfterTextChangedImpl1 afterTextChangedImpl13 = this.mVmOnPasswordChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
                if (afterTextChangedImpl13 == null) {
                    afterTextChangedImpl13 = new AfterTextChangedImpl1();
                    this.mVmOnPasswordChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = afterTextChangedImpl13;
                }
                afterTextChangedImpl12 = afterTextChangedImpl13.setValue(createAccountViewModel);
                AfterTextChangedImpl2 afterTextChangedImpl23 = this.mVmOnEmailChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
                if (afterTextChangedImpl23 == null) {
                    afterTextChangedImpl23 = new AfterTextChangedImpl2();
                    this.mVmOnEmailChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = afterTextChangedImpl23;
                }
                afterTextChangedImpl22 = afterTextChangedImpl23.setValue(createAccountViewModel);
                AfterTextChangedImpl3 afterTextChangedImpl33 = this.mVmOnFamilyNameChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
                if (afterTextChangedImpl33 == null) {
                    afterTextChangedImpl33 = new AfterTextChangedImpl3();
                    this.mVmOnFamilyNameChangedAndroidxDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = afterTextChangedImpl33;
                }
                afterTextChangedImpl32 = afterTextChangedImpl33.setValue(createAccountViewModel);
            }
            if ((j & 12290) != 0) {
                ObservableField<String> givenNames = createAccountViewModel != null ? createAccountViewModel.getGivenNames() : null;
                updateRegistration(1, givenNames);
                if (givenNames != null) {
                    str11 = givenNames.get();
                    if ((j & 12292) == 0) {
                        ObservableField<String> givenNamesError = createAccountViewModel != null ? createAccountViewModel.getGivenNamesError() : null;
                        updateRegistration(2, givenNamesError);
                        if (givenNamesError != null) {
                            str12 = givenNamesError.get();
                        } else {
                            str12 = null;
                        }
                        if (str12 != null) {
                            z7 = true;
                            if ((j & 12296) != 0) {
                                ObservableField<Integer> pwLowerLetterHintColor = createAccountViewModel != null ? createAccountViewModel.getPwLowerLetterHintColor() : null;
                                updateRegistration(3, pwLowerLetterHintColor);
                                i5 = ViewDataBinding.safeUnbox(pwLowerLetterHintColor != null ? pwLowerLetterHintColor.get() : null);
                            } else {
                                i5 = 0;
                            }
                            if ((j & 12304) != 0) {
                                ObservableField<Integer> pwUpperLetterHintColor = createAccountViewModel != null ? createAccountViewModel.getPwUpperLetterHintColor() : null;
                                updateRegistration(4, pwUpperLetterHintColor);
                                i6 = ViewDataBinding.safeUnbox(pwUpperLetterHintColor != null ? pwUpperLetterHintColor.get() : null);
                            } else {
                                i6 = 0;
                            }
                            if ((j & 12320) != 0) {
                                if (createAccountViewModel != null) {
                                    observableField6 = createAccountViewModel.getFamilyName();
                                    i7 = i5;
                                } else {
                                    i7 = i5;
                                    observableField6 = null;
                                }
                                updateRegistration(5, observableField6);
                                if (observableField6 != null) {
                                    str13 = observableField6.get();
                                    if ((j & 12352) == 0) {
                                        if (createAccountViewModel != null) {
                                            observableField5 = createAccountViewModel.getPwLengthHintColor();
                                            str = str13;
                                        } else {
                                            str = str13;
                                            observableField5 = null;
                                        }
                                        updateRegistration(6, observableField5);
                                        i8 = ViewDataBinding.safeUnbox(observableField5 != null ? observableField5.get() : null);
                                    } else {
                                        str = str13;
                                        i8 = 0;
                                    }
                                    if ((j & 12416) == 0) {
                                        if (createAccountViewModel != null) {
                                            observableField4 = createAccountViewModel.getShowLoading();
                                            i9 = i8;
                                        } else {
                                            i9 = i8;
                                            observableField4 = null;
                                        }
                                        updateRegistration(7, observableField4);
                                        if (observableField4 != null) {
                                            bool2 = observableField4.get();
                                            if ((j & 12544) != 0) {
                                                if (createAccountViewModel != null) {
                                                    observableField3 = createAccountViewModel.getPassword();
                                                    bool3 = bool2;
                                                } else {
                                                    bool3 = bool2;
                                                    observableField3 = null;
                                                }
                                                updateRegistration(8, observableField3);
                                                if (observableField3 != null) {
                                                    str14 = observableField3.get();
                                                    if ((j & 12800) == 0) {
                                                        if (createAccountViewModel != null) {
                                                            observableField2 = createAccountViewModel.getEmailError();
                                                            str15 = str14;
                                                        } else {
                                                            str15 = str14;
                                                            observableField2 = null;
                                                        }
                                                        updateRegistration(9, observableField2);
                                                        if (observableField2 != null) {
                                                            str16 = observableField2.get();
                                                        } else {
                                                            str16 = null;
                                                        }
                                                        z8 = str16 != null;
                                                        j2 = 13312;
                                                    } else {
                                                        str15 = str14;
                                                        str16 = null;
                                                        j2 = 13312;
                                                        z8 = false;
                                                    }
                                                    i10 = ((j & j2) > 0 ? 1 : ((j & j2) == 0 ? 0 : -1));
                                                    if (i10 == 0) {
                                                        if (createAccountViewModel != null) {
                                                            str17 = str16;
                                                            i11 = i6;
                                                            observableField = createAccountViewModel.getAreAllInputsValid();
                                                        } else {
                                                            str17 = str16;
                                                            i11 = i6;
                                                            observableField = null;
                                                        }
                                                        updateRegistration(10, observableField);
                                                        z9 = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
                                                        if (i10 != 0) {
                                                            j |= z9 ? PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID : PlaybackStateCompat.ACTION_PREPARE;
                                                        }
                                                        i12 = getColorFromResource(this.mboundView12, z9 ? R.color.dw_orange_RES_2114060292 : R.color.dw_orange_disabled_RES_2114060293);
                                                    } else {
                                                        str17 = str16;
                                                        i11 = i6;
                                                        z9 = false;
                                                        i12 = 0;
                                                    }
                                                    if ((j & 14336) != 0) {
                                                        ObservableField<String> email = createAccountViewModel != null ? createAccountViewModel.getEmail() : null;
                                                        updateRegistration(11, email);
                                                        if (email != null) {
                                                            str7 = email.get();
                                                            z2 = z6;
                                                            z4 = z7;
                                                            z = z8;
                                                            i = i9;
                                                            i3 = i11;
                                                            str6 = str10;
                                                            str4 = str11;
                                                            i2 = i12;
                                                            str3 = str15;
                                                            z3 = z9;
                                                            afterTextChangedImpl3 = afterTextChangedImpl32;
                                                            bool = bool3;
                                                            afterTextChangedImpl2 = afterTextChangedImpl22;
                                                            afterTextChangedImpl1 = afterTextChangedImpl12;
                                                            str5 = str12;
                                                            i4 = i7;
                                                            str2 = str17;
                                                        }
                                                    }
                                                    z2 = z6;
                                                    z4 = z7;
                                                    str7 = null;
                                                    z = z8;
                                                    i = i9;
                                                    i3 = i11;
                                                    str6 = str10;
                                                    str4 = str11;
                                                    i2 = i12;
                                                    str3 = str15;
                                                    z3 = z9;
                                                    afterTextChangedImpl3 = afterTextChangedImpl32;
                                                    bool = bool3;
                                                    afterTextChangedImpl2 = afterTextChangedImpl22;
                                                    afterTextChangedImpl1 = afterTextChangedImpl12;
                                                    str5 = str12;
                                                    i4 = i7;
                                                    str2 = str17;
                                                }
                                            } else {
                                                bool3 = bool2;
                                            }
                                            str14 = null;
                                            if ((j & 12800) == 0) {
                                            }
                                            i10 = ((j & j2) > 0 ? 1 : ((j & j2) == 0 ? 0 : -1));
                                            if (i10 == 0) {
                                            }
                                            if ((j & 14336) != 0) {
                                            }
                                            z2 = z6;
                                            z4 = z7;
                                            str7 = null;
                                            z = z8;
                                            i = i9;
                                            i3 = i11;
                                            str6 = str10;
                                            str4 = str11;
                                            i2 = i12;
                                            str3 = str15;
                                            z3 = z9;
                                            afterTextChangedImpl3 = afterTextChangedImpl32;
                                            bool = bool3;
                                            afterTextChangedImpl2 = afterTextChangedImpl22;
                                            afterTextChangedImpl1 = afterTextChangedImpl12;
                                            str5 = str12;
                                            i4 = i7;
                                            str2 = str17;
                                        }
                                    } else {
                                        i9 = i8;
                                    }
                                    bool2 = null;
                                    if ((j & 12544) != 0) {
                                    }
                                    str14 = null;
                                    if ((j & 12800) == 0) {
                                    }
                                    i10 = ((j & j2) > 0 ? 1 : ((j & j2) == 0 ? 0 : -1));
                                    if (i10 == 0) {
                                    }
                                    if ((j & 14336) != 0) {
                                    }
                                    z2 = z6;
                                    z4 = z7;
                                    str7 = null;
                                    z = z8;
                                    i = i9;
                                    i3 = i11;
                                    str6 = str10;
                                    str4 = str11;
                                    i2 = i12;
                                    str3 = str15;
                                    z3 = z9;
                                    afterTextChangedImpl3 = afterTextChangedImpl32;
                                    bool = bool3;
                                    afterTextChangedImpl2 = afterTextChangedImpl22;
                                    afterTextChangedImpl1 = afterTextChangedImpl12;
                                    str5 = str12;
                                    i4 = i7;
                                    str2 = str17;
                                }
                            } else {
                                i7 = i5;
                            }
                            str13 = null;
                            if ((j & 12352) == 0) {
                            }
                            if ((j & 12416) == 0) {
                            }
                            bool2 = null;
                            if ((j & 12544) != 0) {
                            }
                            str14 = null;
                            if ((j & 12800) == 0) {
                            }
                            i10 = ((j & j2) > 0 ? 1 : ((j & j2) == 0 ? 0 : -1));
                            if (i10 == 0) {
                            }
                            if ((j & 14336) != 0) {
                            }
                            z2 = z6;
                            z4 = z7;
                            str7 = null;
                            z = z8;
                            i = i9;
                            i3 = i11;
                            str6 = str10;
                            str4 = str11;
                            i2 = i12;
                            str3 = str15;
                            z3 = z9;
                            afterTextChangedImpl3 = afterTextChangedImpl32;
                            bool = bool3;
                            afterTextChangedImpl2 = afterTextChangedImpl22;
                            afterTextChangedImpl1 = afterTextChangedImpl12;
                            str5 = str12;
                            i4 = i7;
                            str2 = str17;
                        }
                    } else {
                        str12 = null;
                    }
                    z7 = false;
                    if ((j & 12296) != 0) {
                    }
                    if ((j & 12304) != 0) {
                    }
                    if ((j & 12320) != 0) {
                    }
                    str13 = null;
                    if ((j & 12352) == 0) {
                    }
                    if ((j & 12416) == 0) {
                    }
                    bool2 = null;
                    if ((j & 12544) != 0) {
                    }
                    str14 = null;
                    if ((j & 12800) == 0) {
                    }
                    i10 = ((j & j2) > 0 ? 1 : ((j & j2) == 0 ? 0 : -1));
                    if (i10 == 0) {
                    }
                    if ((j & 14336) != 0) {
                    }
                    z2 = z6;
                    z4 = z7;
                    str7 = null;
                    z = z8;
                    i = i9;
                    i3 = i11;
                    str6 = str10;
                    str4 = str11;
                    i2 = i12;
                    str3 = str15;
                    z3 = z9;
                    afterTextChangedImpl3 = afterTextChangedImpl32;
                    bool = bool3;
                    afterTextChangedImpl2 = afterTextChangedImpl22;
                    afterTextChangedImpl1 = afterTextChangedImpl12;
                    str5 = str12;
                    i4 = i7;
                    str2 = str17;
                }
            }
            str11 = null;
            if ((j & 12292) == 0) {
            }
            z7 = false;
            if ((j & 12296) != 0) {
            }
            if ((j & 12304) != 0) {
            }
            if ((j & 12320) != 0) {
            }
            str13 = null;
            if ((j & 12352) == 0) {
            }
            if ((j & 12416) == 0) {
            }
            bool2 = null;
            if ((j & 12544) != 0) {
            }
            str14 = null;
            if ((j & 12800) == 0) {
            }
            i10 = ((j & j2) > 0 ? 1 : ((j & j2) == 0 ? 0 : -1));
            if (i10 == 0) {
            }
            if ((j & 14336) != 0) {
            }
            z2 = z6;
            z4 = z7;
            str7 = null;
            z = z8;
            i = i9;
            i3 = i11;
            str6 = str10;
            str4 = str11;
            i2 = i12;
            str3 = str15;
            z3 = z9;
            afterTextChangedImpl3 = afterTextChangedImpl32;
            bool = bool3;
            afterTextChangedImpl2 = afterTextChangedImpl22;
            afterTextChangedImpl1 = afterTextChangedImpl12;
            str5 = str12;
            i4 = i7;
            str2 = str17;
        } else {
            str7 = null;
            bool = null;
            str6 = null;
            str5 = null;
            afterTextChangedImpl1 = null;
            afterTextChangedImpl2 = null;
            afterTextChangedImpl3 = null;
            str4 = null;
            afterTextChangedImpl = null;
            str3 = null;
            str2 = null;
            str = null;
            z4 = false;
            z3 = false;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            z2 = false;
            z = false;
            i = 0;
        }
        if ((j & 14336) != 0) {
            str8 = str6;
            TextViewBindingAdapter.setText(this.emailEditText, str7);
        } else {
            str8 = str6;
        }
        if ((j & 12288) != 0) {
            TextViewBindingAdapter.BeforeTextChanged beforeTextChanged = null;
            str9 = str4;
            TextViewBindingAdapter.OnTextChanged onTextChanged = null;
            z5 = z4;
            TextViewBindingAdapter.setTextWatcher(this.emailEditText, beforeTextChanged, onTextChanged, afterTextChangedImpl2, this.emailEditTextandroidTextAttrChanged);
            TextViewBindingAdapter.setTextWatcher(this.mboundView3, beforeTextChanged, onTextChanged, afterTextChangedImpl, this.mboundView3androidTextAttrChanged);
            TextViewBindingAdapter.setTextWatcher(this.mboundView5, beforeTextChanged, onTextChanged, afterTextChangedImpl3, this.mboundView5androidTextAttrChanged);
            TextViewBindingAdapter.setTextWatcher(this.mboundView8, beforeTextChanged, onTextChanged, afterTextChangedImpl1, this.mboundView8androidTextAttrChanged);
        } else {
            z5 = z4;
            str9 = str4;
        }
        if ((j & 12416) != 0) {
            this.mboundView01.setShowLoading(bool);
        }
        if ((PlaybackStateCompat.ACTION_PLAY_FROM_URI & j) != 0) {
            this.mboundView1.setTitle(getRoot().getResources().getString(R.string.create_account));
            this.mboundView12.setOnClickListener(this.mCallback11);
        }
        if ((j & 12304) != 0) {
            this.mboundView10.setTextColor(i3);
        }
        if ((j & 12296) != 0) {
            this.mboundView11.setTextColor(i4);
        }
        if ((13312 & j) != 0) {
            ViewBindingAdapter.setBackground(this.mboundView12, Converters.convertColorToDrawable(i2));
            this.mboundView12.setEnabled(z3);
        }
        if ((j & 12292) != 0) {
            this.mboundView2.setError(str5);
            this.mboundView2.setErrorEnabled(z5);
        }
        if ((j & 12290) != 0) {
            TextViewBindingAdapter.setText(this.mboundView3, str9);
        }
        if ((j & 12289) != 0) {
            this.mboundView4.setError(str8);
            this.mboundView4.setErrorEnabled(z2);
        }
        if ((12320 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView5, str);
        }
        if ((12800 & j) != 0) {
            this.mboundView6.setError(str2);
            this.mboundView6.setErrorEnabled(z);
        }
        if ((12544 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView8, str3);
        }
        if ((j & 12352) != 0) {
            this.mboundView9.setTextColor(i);
        }
        executeBindingsOn(this.mboundView1);
        executeBindingsOn(this.mboundView01);
    }

    public static class AfterTextChangedImpl implements TextViewBindingAdapter.AfterTextChanged {
        private CreateAccountViewModel value;

        public AfterTextChangedImpl setValue(CreateAccountViewModel createAccountViewModel) {
            this.value = createAccountViewModel;
            if (createAccountViewModel == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged
        public void afterTextChanged(Editable editable) {
            this.value.onGivenNamesChanged(editable);
        }
    }

    public static class AfterTextChangedImpl1 implements TextViewBindingAdapter.AfterTextChanged {
        private CreateAccountViewModel value;

        public AfterTextChangedImpl1 setValue(CreateAccountViewModel createAccountViewModel) {
            this.value = createAccountViewModel;
            if (createAccountViewModel == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged
        public void afterTextChanged(Editable editable) {
            this.value.onPasswordChanged(editable);
        }
    }

    public static class AfterTextChangedImpl2 implements TextViewBindingAdapter.AfterTextChanged {
        private CreateAccountViewModel value;

        public AfterTextChangedImpl2 setValue(CreateAccountViewModel createAccountViewModel) {
            this.value = createAccountViewModel;
            if (createAccountViewModel == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged
        public void afterTextChanged(Editable editable) {
            this.value.onEmailChanged(editable);
        }
    }

    public static class AfterTextChangedImpl3 implements TextViewBindingAdapter.AfterTextChanged {
        private CreateAccountViewModel value;

        public AfterTextChangedImpl3 setValue(CreateAccountViewModel createAccountViewModel) {
            this.value = createAccountViewModel;
            if (createAccountViewModel == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged
        public void afterTextChanged(Editable editable) {
            this.value.onFamilyNameChanged(editable);
        }
    }

    @Override // com.digitalwallet.app.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        CreateAccountViewModel createAccountViewModel = this.mVm;
        if (createAccountViewModel != null) {
            createAccountViewModel.createAccount();
        }
    }
}
