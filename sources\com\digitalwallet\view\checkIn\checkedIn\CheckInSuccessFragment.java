package com.digitalwallet.view.checkIn.checkedIn;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.databinding.FragmentCheckInSuccessBinding;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.utilities.EventObserver;
import com.digitalwallet.view.base.BaseFragment;
import com.digitalwallet.view.checkIn.CheckInUtilsKt;
import com.digitalwallet.view.main.BackHandler;
import com.digitalwallet.view.util.ViewUtilsKt;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInSuccessViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001a\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkedIn/CheckInSuccessFragment;", "Lcom/digitalwallet/view/base/BaseFragment;", "Lcom/digitalwallet/databinding/FragmentCheckInSuccessBinding;", "Lcom/digitalwallet/view/main/BackHandler;", "()V", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInSuccessViewModel;", "getViewModel", "()Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInSuccessViewModel;", "setViewModel", "(Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInSuccessViewModel;)V", "finishUp", "", "handleBack", "", "maybeAlertBeforeFinishing", "finishType", "Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInSuccessViewModel$FinishCheckInFlowType;", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInSuccessFragment.kt */
public final class CheckInSuccessFragment extends BaseFragment<FragmentCheckInSuccessBinding> implements BackHandler {
    private static final String CHECK_IN_CODE_KEY = "CHECK_IN_CODE_KEY";
    private static final String CHECK_IN_ITEM_KEY = "CHECK_IN_ITEM_KEY";
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    private final int layoutId = R.layout.fragment_check_in_success;
    @Inject
    public CheckInSuccessViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CheckInSuccessViewModel.FinishCheckInFlowType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[CheckInSuccessViewModel.FinishCheckInFlowType.WITH_FAVOURITE_ADDED.ordinal()] = 1;
            iArr[CheckInSuccessViewModel.FinishCheckInFlowType.WITH_FAVOURITE_REMOVED.ordinal()] = 2;
            iArr[CheckInSuccessViewModel.FinishCheckInFlowType.NO_FAVOURITE_CHANGE.ordinal()] = 3;
        }
    }

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

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public CheckInSuccessViewModel getViewModel() {
        CheckInSuccessViewModel checkInSuccessViewModel = this.viewModel;
        if (checkInSuccessViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return checkInSuccessViewModel;
    }

    public void setViewModel(CheckInSuccessViewModel checkInSuccessViewModel) {
        Intrinsics.checkNotNullParameter(checkInSuccessViewModel, "<set-?>");
        this.viewModel = checkInSuccessViewModel;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), ActivityAnalyticsHelper.Screen.CheckInSuccess, null, null, 6, null);
        ((FragmentCheckInSuccessBinding) getBinding()).setLifecycleOwner(this);
        Bundle arguments = getArguments();
        CheckInUtils.CheckInCode checkInCode = null;
        CheckIn checkIn = arguments != null ? (CheckIn) arguments.getParcelable(CHECK_IN_ITEM_KEY) : null;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            checkInCode = (CheckInUtils.CheckInCode) arguments2.getParcelable(CHECK_IN_CODE_KEY);
        }
        if ((checkIn == null || checkInCode == null) ? false : true) {
            getViewModel().setup(checkIn, checkInCode);
            getViewModel().isInstantApp().set(Boolean.valueOf(CheckInUtilsKt.isInstantApp(this)));
            getViewModel().getFinishCheckInFlow().observe(getViewLifecycleOwner(), new EventObserver(new CheckInSuccessFragment$onViewCreated$1(this)));
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.digitalwallet.view.main.BackHandler
    public boolean handleBack() {
        return ((Boolean) new CheckInSuccessFragment$handleBack$1(this).invoke()).booleanValue();
    }

    /* access modifiers changed from: private */
    public final void maybeAlertBeforeFinishing(CheckInSuccessViewModel.FinishCheckInFlowType finishCheckInFlowType) {
        int i = WhenMappings.$EnumSwitchMapping$0[finishCheckInFlowType.ordinal()];
        String str = null;
        if (i == 1) {
            AlertDialog.Builder title = new AlertDialog.Builder(getContext()).setTitle(R.string.checked_in_favourite_added_title);
            Context context = getContext();
            if (context != null) {
                str = context.getString(R.string.checked_in_favourite_added_message, getViewModel().getLocationName().get());
            }
            title.setMessage(str).setPositiveButton(R.string.ok_RES_2131689719, new CheckInSuccessFragment$maybeAlertBeforeFinishing$1(this)).setCancelable(false).create().show();
        } else if (i == 2) {
            AlertDialog.Builder title2 = new AlertDialog.Builder(getContext()).setTitle(R.string.checked_in_favourite_removed_title);
            Context context2 = getContext();
            if (context2 != null) {
                str = context2.getString(R.string.checked_in_favourite_removed_message, getViewModel().getLocationName().get());
            }
            title2.setMessage(str).setPositiveButton(R.string.ok_RES_2131689719, new CheckInSuccessFragment$maybeAlertBeforeFinishing$2(this)).setCancelable(false).create().show();
        } else if (i == 3) {
            finishUp();
        }
    }

    /* access modifiers changed from: private */
    public final void finishUp() {
        if (getViewModel().getHasCheckedIn()) {
            CheckInUtilsKt.backToMainActivity(this);
            return;
        }
        CheckInFeedbackFragment create = CheckInFeedbackFragment.Companion.create(getViewModel().getCheckInItem());
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        int containerId = ViewUtilsKt.getContainerId(this);
        FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        beginTransaction.replace(containerId, create, Reflection.getOrCreateKotlinClass(CheckInFeedbackFragment.class).getSimpleName()).addToBackStack(null).commit();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkedIn/CheckInSuccessFragment$Companion;", "", "()V", CheckInSuccessFragment.CHECK_IN_CODE_KEY, "", CheckInSuccessFragment.CHECK_IN_ITEM_KEY, "create", "Lcom/digitalwallet/view/checkIn/checkedIn/CheckInSuccessFragment;", "checkInItem", "Lcom/digitalwallet/model/CheckIn;", "checkInCode", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CheckInSuccessFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CheckInSuccessFragment create(CheckIn checkIn, CheckInUtils.CheckInCode checkInCode) {
            Intrinsics.checkNotNullParameter(checkIn, "checkInItem");
            Intrinsics.checkNotNullParameter(checkInCode, "checkInCode");
            CheckInSuccessFragment checkInSuccessFragment = new CheckInSuccessFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(CheckInSuccessFragment.CHECK_IN_ITEM_KEY, checkIn);
            bundle.putParcelable(CheckInSuccessFragment.CHECK_IN_CODE_KEY, checkInCode);
            Unit unit = Unit.INSTANCE;
            checkInSuccessFragment.setArguments(bundle);
            return checkInSuccessFragment;
        }
    }
}
