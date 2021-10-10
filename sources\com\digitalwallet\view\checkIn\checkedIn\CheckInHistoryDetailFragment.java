package com.digitalwallet.view.checkIn.checkedIn;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.databinding.FragmentCheckInHistoryDetailBinding;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.utilities.EventObserver;
import com.digitalwallet.view.base.BaseFragment;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInHistoryDetailViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkedIn/CheckInHistoryDetailFragment;", "Lcom/digitalwallet/view/base/BaseFragment;", "Lcom/digitalwallet/databinding/FragmentCheckInHistoryDetailBinding;", "()V", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInHistoryDetailViewModel;", "getViewModel", "()Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInHistoryDetailViewModel;", "setViewModel", "(Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInHistoryDetailViewModel;)V", "observerEvents", "", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInHistoryDetailFragment.kt */
public final class CheckInHistoryDetailFragment extends BaseFragment<FragmentCheckInHistoryDetailBinding> {
    private static final String CHECK_IN_CODE_KEY = "CHECK_IN_CODE_KEY";
    private static final String CHECK_IN_ITEM_KEY = "CHECK_IN_ITEM_KEY";
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    private final int layoutId = R.layout.fragment_check_in_history_detail;
    @Inject
    public CheckInHistoryDetailViewModel viewModel;

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
    public CheckInHistoryDetailViewModel getViewModel() {
        CheckInHistoryDetailViewModel checkInHistoryDetailViewModel = this.viewModel;
        if (checkInHistoryDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return checkInHistoryDetailViewModel;
    }

    public void setViewModel(CheckInHistoryDetailViewModel checkInHistoryDetailViewModel) {
        Intrinsics.checkNotNullParameter(checkInHistoryDetailViewModel, "<set-?>");
        this.viewModel = checkInHistoryDetailViewModel;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, androidx.fragment.app.Fragment, com.digitalwallet.view.base.BasicFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ActivityAnalyticsHelper.setScreenName$default(new ActivityAnalyticsHelper(requireActivity), ActivityAnalyticsHelper.Screen.CheckInDetailExpanded, null, null, 6, null);
        ((FragmentCheckInHistoryDetailBinding) getBinding()).setLifecycleOwner(this);
        Bundle arguments = getArguments();
        CheckInUtils.CheckInCode checkInCode = null;
        CheckIn checkIn = arguments != null ? (CheckIn) arguments.getParcelable(CHECK_IN_ITEM_KEY) : null;
        if (!(checkIn instanceof CheckIn)) {
            checkIn = null;
        }
        if (checkIn != null) {
            Bundle arguments2 = getArguments();
            CheckInUtils.CheckInCode checkInCode2 = arguments2 != null ? (CheckInUtils.CheckInCode) arguments2.getParcelable(CHECK_IN_CODE_KEY) : null;
            if (checkInCode2 instanceof CheckInUtils.CheckInCode) {
                checkInCode = checkInCode2;
            }
            getViewModel().setup(checkIn, checkInCode);
        }
        observerEvents();
    }

    private final void observerEvents() {
        getViewModel().getBackEvent().observe(getViewLifecycleOwner(), new EventObserver(new CheckInHistoryDetailFragment$observerEvents$1(this)));
        getViewModel().getShouldFavour().addOnPropertyChangedCallback(new CheckInHistoryDetailFragment$observerEvents$2(this));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkedIn/CheckInHistoryDetailFragment$Companion;", "", "()V", CheckInHistoryDetailFragment.CHECK_IN_CODE_KEY, "", CheckInHistoryDetailFragment.CHECK_IN_ITEM_KEY, "createFragment", "Lcom/digitalwallet/view/checkIn/checkedIn/CheckInHistoryDetailFragment;", "checkInItem", "Lcom/digitalwallet/model/CheckIn;", "checkInCode", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CheckInHistoryDetailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CheckInHistoryDetailFragment createFragment(CheckIn checkIn, CheckInUtils.CheckInCode checkInCode) {
            Intrinsics.checkNotNullParameter(checkIn, "checkInItem");
            CheckInHistoryDetailFragment checkInHistoryDetailFragment = new CheckInHistoryDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(CheckInHistoryDetailFragment.CHECK_IN_ITEM_KEY, checkIn);
            bundle.putParcelable(CheckInHistoryDetailFragment.CHECK_IN_CODE_KEY, checkInCode);
            Unit unit = Unit.INSTANCE;
            checkInHistoryDetailFragment.setArguments(bundle);
            return checkInHistoryDetailFragment;
        }
    }
}
