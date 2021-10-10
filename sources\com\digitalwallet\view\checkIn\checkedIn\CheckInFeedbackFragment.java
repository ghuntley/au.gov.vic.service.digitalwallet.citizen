package com.digitalwallet.view.checkIn.checkedIn;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.databinding.FragmentCheckInFeedbackBinding;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.utilities.EventObserver;
import com.digitalwallet.view.base.BaseFragment;
import com.digitalwallet.view.checkIn.CheckInUtilsKt;
import com.digitalwallet.view.checkIn.checkedIn.CheckInFeedbackSuccessFragment;
import com.digitalwallet.view.main.BackHandler;
import com.digitalwallet.view.util.ViewUtilsKt;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInFeedbackViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u001a\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkedIn/CheckInFeedbackFragment;", "Lcom/digitalwallet/view/base/BaseFragment;", "Lcom/digitalwallet/databinding/FragmentCheckInFeedbackBinding;", "Lcom/digitalwallet/view/main/BackHandler;", "()V", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInFeedbackViewModel;", "getViewModel", "()Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInFeedbackViewModel;", "setViewModel", "(Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInFeedbackViewModel;)V", "handleBack", "", "navigateToSuccess", "", "skip", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInFeedbackFragment.kt */
public final class CheckInFeedbackFragment extends BaseFragment<FragmentCheckInFeedbackBinding> implements BackHandler {
    public static final String CHECK_IN_ITEM_KEY = "CHECK_IN_ITEM";
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    private final int layoutId = R.layout.fragment_check_in_feedback;
    @Inject
    public CheckInFeedbackViewModel viewModel;

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
    public CheckInFeedbackViewModel getViewModel() {
        CheckInFeedbackViewModel checkInFeedbackViewModel = this.viewModel;
        if (checkInFeedbackViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return checkInFeedbackViewModel;
    }

    public void setViewModel(CheckInFeedbackViewModel checkInFeedbackViewModel) {
        Intrinsics.checkNotNullParameter(checkInFeedbackViewModel, "<set-?>");
        this.viewModel = checkInFeedbackViewModel;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CheckIn checkIn;
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ActivityAnalyticsHelper.setScreenName$default(new ActivityAnalyticsHelper(requireActivity), ActivityAnalyticsHelper.Screen.CheckInFeedback, null, null, 6, null);
        Bundle arguments = getArguments();
        if (!(arguments == null || (checkIn = (CheckIn) arguments.getParcelable(CHECK_IN_ITEM_KEY)) == null)) {
            CheckInFeedbackViewModel viewModel2 = getViewModel();
            Intrinsics.checkNotNullExpressionValue(checkIn, "it");
            viewModel2.setup(checkIn);
        }
        getViewModel().getSkip().observe(getViewLifecycleOwner(), new EventObserver(new CheckInFeedbackFragment$onViewCreated$2(this)));
        getViewModel().getShowFeedbackSuccess().observe(getViewLifecycleOwner(), new EventObserver(new CheckInFeedbackFragment$onViewCreated$3(this)));
    }

    /* access modifiers changed from: private */
    public final void navigateToSuccess(boolean z) {
        CheckInFeedbackFragment checkInFeedbackFragment = this;
        if (CheckInUtilsKt.isInstantApp(checkInFeedbackFragment)) {
            CheckInFeedbackSuccessFragment.Companion companion = CheckInFeedbackSuccessFragment.Companion;
            Bundle requireArguments = requireArguments();
            Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
            CheckInFeedbackSuccessFragment create = companion.create(requireArguments, z);
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            int containerId = ViewUtilsKt.getContainerId(this);
            FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
            beginTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.slide_in_up, R.anim.slide_out_down);
            beginTransaction.replace(containerId, create, Reflection.getOrCreateKotlinClass(CheckInFeedbackSuccessFragment.class).getSimpleName()).addToBackStack(null).commit();
            return;
        }
        CheckInUtilsKt.backToMainActivity(checkInFeedbackFragment);
    }

    @Override // com.digitalwallet.view.main.BackHandler
    public boolean handleBack() {
        navigateToSuccess(true);
        return true;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkedIn/CheckInFeedbackFragment$Companion;", "", "()V", "CHECK_IN_ITEM_KEY", "", "create", "Lcom/digitalwallet/view/checkIn/checkedIn/CheckInFeedbackFragment;", "checkInItem", "Lcom/digitalwallet/model/CheckIn;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CheckInFeedbackFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CheckInFeedbackFragment create(CheckIn checkIn) {
            Intrinsics.checkNotNullParameter(checkIn, "checkInItem");
            CheckInFeedbackFragment checkInFeedbackFragment = new CheckInFeedbackFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(CheckInFeedbackFragment.CHECK_IN_ITEM_KEY, checkIn);
            Unit unit = Unit.INSTANCE;
            checkInFeedbackFragment.setArguments(bundle);
            return checkInFeedbackFragment;
        }
    }
}
