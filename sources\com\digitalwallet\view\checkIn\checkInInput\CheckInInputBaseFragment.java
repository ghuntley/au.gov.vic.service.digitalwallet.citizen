package com.digitalwallet.view.checkIn.checkInInput;

import android.view.View;
import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import com.digitalwallet.databinding.LayoutCheckInInputBinding;
import com.digitalwallet.utilities.EventObserver;
import com.digitalwallet.view.base.BaseFragment;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInInputBaseViewModel;
import com.google.android.material.textfield.TextInputEditText;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001a\u0010\u0010\u001a\u00020\n*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0013H\u0002R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInInput/CheckInInputBaseFragment;", "T", "Landroidx/databinding/ViewDataBinding;", "Lcom/digitalwallet/view/base/BaseFragment;", "()V", "viewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInInputBaseViewModel;", "getViewModel", "()Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInInputBaseViewModel;", "maybeRequestFieldFocus", "", "inputLayout", "Lcom/digitalwallet/databinding/LayoutCheckInInputBinding;", "observeCommonEvents", "observeInputLayoutEvents", "observeShowValidationError", "onDone", "Landroid/widget/EditText;", "callback", "Lkotlin/Function0;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInInputBaseFragment.kt */
public abstract class CheckInInputBaseFragment<T extends ViewDataBinding> extends BaseFragment<T> {
    private HashMap _$_findViewCache;

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment
    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public abstract CheckInInputBaseViewModel getViewModel();

    @Override // com.digitalwallet.view.base.BaseFragment, androidx.fragment.app.Fragment, com.digitalwallet.view.base.BasicFragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void maybeRequestFieldFocus(LayoutCheckInInputBinding layoutCheckInInputBinding) {
        Intrinsics.checkNotNullParameter(layoutCheckInInputBinding, "inputLayout");
        String str = getViewModel().getFirstName().get();
        boolean z = false;
        if (str == null || StringsKt.isBlank(str)) {
            layoutCheckInInputBinding.firstNameEditText.requestFocus();
            return;
        }
        String str2 = getViewModel().getLastName().get();
        if (str2 == null || StringsKt.isBlank(str2)) {
            z = true;
        }
        if (z) {
            layoutCheckInInputBinding.lastNameEditText.requestFocus();
        } else {
            layoutCheckInInputBinding.phoneNumberEditText.requestFocus();
        }
    }

    public final void observeCommonEvents(LayoutCheckInInputBinding layoutCheckInInputBinding) {
        Intrinsics.checkNotNullParameter(layoutCheckInInputBinding, "inputLayout");
        getViewModel().getHideKeyboard().observe(getViewLifecycleOwner(), new EventObserver(new CheckInInputBaseFragment$observeCommonEvents$1(this)));
        observeInputLayoutEvents(layoutCheckInInputBinding);
        observeShowValidationError(layoutCheckInInputBinding);
    }

    private final void observeInputLayoutEvents(LayoutCheckInInputBinding layoutCheckInInputBinding) {
        TextInputEditText textInputEditText = layoutCheckInInputBinding.phoneNumberEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "inputLayout.phoneNumberEditText");
        onDone(textInputEditText, new CheckInInputBaseFragment$observeInputLayoutEvents$1(this));
        getViewModel().getMovePhoneCursorToEnd().observe(getViewLifecycleOwner(), new EventObserver(new CheckInInputBaseFragment$observeInputLayoutEvents$2(layoutCheckInInputBinding)));
    }

    private final void observeShowValidationError(LayoutCheckInInputBinding layoutCheckInInputBinding) {
        getViewModel().getShowValidationError().observe(getViewLifecycleOwner(), new EventObserver(new CheckInInputBaseFragment$observeShowValidationError$1(this, layoutCheckInInputBinding)));
    }

    private final void onDone(EditText editText, Function0<Unit> function0) {
        editText.setOnEditorActionListener(new CheckInInputBaseFragment$onDone$1(function0));
    }
}
