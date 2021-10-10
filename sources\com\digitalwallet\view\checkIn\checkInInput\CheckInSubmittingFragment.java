package com.digitalwallet.view.checkIn.checkInInput;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.databinding.FragmentCheckInSubmittingBinding;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.utilities.EventObserver;
import com.digitalwallet.view.base.BaseFragment;
import com.digitalwallet.view.checkIn.CheckInUtilsKt;
import com.digitalwallet.view.checkIn.checkedIn.CheckInFeedbackFragment;
import com.digitalwallet.view.checkIn.checkedIn.CheckInSuccessFragment;
import com.digitalwallet.view.util.ViewUtilsKt;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInSubmittingViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.firebase.messaging.Constants;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\u001a\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u000fH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006 "}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInInput/CheckInSubmittingFragment;", "Lcom/digitalwallet/view/base/BaseFragment;", "Lcom/digitalwallet/databinding/FragmentCheckInSubmittingBinding;", "()V", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInSubmittingViewModel;", "getViewModel", "()Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInSubmittingViewModel;", "setViewModel", "(Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInSubmittingViewModel;)V", "navigateToFeedback", "", "checkInItem", "Lcom/digitalwallet/model/CheckIn;", "navigateToSuccess", "checkInCode", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "observeEvents", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "showErrorDialog", "titleId", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "startSubmission", "Companion", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInSubmittingFragment.kt */
public final class CheckInSubmittingFragment extends BaseFragment<FragmentCheckInSubmittingBinding> {
    private static final String CHECK_IN_CODE_KEY = "CHECK_IN_CODE_KEY";
    private static final String CHECK_IN_PAYLOAD_KEY = "CHECK_IN_PAYLOAD_KEY";
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    private final int layoutId = R.layout.fragment_check_in_submitting;
    @Inject
    public CheckInSubmittingViewModel viewModel;

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

    @Override // com.digitalwallet.view.base.BaseFragment, androidx.fragment.app.Fragment, com.digitalwallet.view.base.BasicFragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public CheckInSubmittingViewModel getViewModel() {
        CheckInSubmittingViewModel checkInSubmittingViewModel = this.viewModel;
        if (checkInSubmittingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return checkInSubmittingViewModel;
    }

    public void setViewModel(CheckInSubmittingViewModel checkInSubmittingViewModel) {
        Intrinsics.checkNotNullParameter(checkInSubmittingViewModel, "<set-?>");
        this.viewModel = checkInSubmittingViewModel;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, androidx.fragment.app.Fragment, com.digitalwallet.view.base.BasicFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        getViewModel().isInstantApp().set(CheckInUtilsKt.isInstantApp(this));
        observeEvents();
        startSubmission();
    }

    private final void startSubmission() {
        Bundle arguments = getArguments();
        CheckInUtils.CheckInCode checkInCode = null;
        CheckIn checkIn = arguments != null ? (CheckIn) arguments.getParcelable(CHECK_IN_PAYLOAD_KEY) : null;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            checkInCode = (CheckInUtils.CheckInCode) arguments2.getParcelable(CHECK_IN_CODE_KEY);
        }
        if ((checkIn == null || checkInCode == null) ? false : true) {
            getViewModel().submitCheckInInfo(checkIn, checkInCode);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final void observeEvents() {
        getViewModel().getShowPopUpOfNoInternetConnection().observe(getViewLifecycleOwner(), new EventObserver(new CheckInSubmittingFragment$observeEvents$1(this)));
        getViewModel().getShowPopUpOfNetworkIssue().observe(getViewLifecycleOwner(), new EventObserver(new CheckInSubmittingFragment$observeEvents$2(this)));
        getViewModel().getNavigateToFeedback().observe(getViewLifecycleOwner(), new EventObserver(new CheckInSubmittingFragment$observeEvents$3(this)));
        getViewModel().getNavigateToSuccess().observe(getViewLifecycleOwner(), new EventObserver(new CheckInSubmittingFragment$observeEvents$4(this)));
    }

    /* access modifiers changed from: private */
    public final void showErrorDialog(int i, int i2) {
        new AlertDialog.Builder(requireContext()).setTitle(i).setMessage(i2).setPositiveButton(R.string.ok_RES_2131689719, new CheckInSubmittingFragment$showErrorDialog$1(this)).setCancelable(false).create().show();
    }

    /* access modifiers changed from: private */
    public final void navigateToFeedback(CheckIn checkIn) {
        CheckInFeedbackFragment create = CheckInFeedbackFragment.Companion.create(checkIn);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        int containerId = ViewUtilsKt.getContainerId(this);
        FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        beginTransaction.replace(containerId, create, Reflection.getOrCreateKotlinClass(CheckInFeedbackFragment.class).getSimpleName()).addToBackStack(null).commit();
    }

    /* access modifiers changed from: private */
    public final void navigateToSuccess(CheckIn checkIn, CheckInUtils.CheckInCode checkInCode) {
        CheckInSuccessFragment create = CheckInSuccessFragment.Companion.create(checkIn, checkInCode);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        int containerId = ViewUtilsKt.getContainerId(this);
        FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        beginTransaction.replace(containerId, create, Reflection.getOrCreateKotlinClass(CheckInSuccessFragment.class).getSimpleName()).addToBackStack(null).commit();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInInput/CheckInSubmittingFragment$Companion;", "", "()V", CheckInSubmittingFragment.CHECK_IN_CODE_KEY, "", CheckInSubmittingFragment.CHECK_IN_PAYLOAD_KEY, "createFragment", "Lcom/digitalwallet/view/checkIn/checkInInput/CheckInSubmittingFragment;", "checkInPayload", "Lcom/digitalwallet/model/CheckIn;", "checkInCode", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CheckInSubmittingFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CheckInSubmittingFragment createFragment(CheckIn checkIn, CheckInUtils.CheckInCode checkInCode) {
            Intrinsics.checkNotNullParameter(checkIn, "checkInPayload");
            Intrinsics.checkNotNullParameter(checkInCode, "checkInCode");
            CheckInSubmittingFragment checkInSubmittingFragment = new CheckInSubmittingFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(CheckInSubmittingFragment.CHECK_IN_PAYLOAD_KEY, checkIn);
            bundle.putParcelable(CheckInSubmittingFragment.CHECK_IN_CODE_KEY, checkInCode);
            Unit unit = Unit.INSTANCE;
            checkInSubmittingFragment.setArguments(bundle);
            return checkInSubmittingFragment;
        }
    }
}
