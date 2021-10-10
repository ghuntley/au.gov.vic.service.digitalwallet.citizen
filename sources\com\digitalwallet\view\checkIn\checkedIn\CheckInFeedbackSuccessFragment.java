package com.digitalwallet.view.checkIn.checkedIn;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.databinding.FragmentCheckInFeedbackSuccessBinding;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.view.base.BaseFragment;
import com.digitalwallet.view.checkIn.CheckInUtilsKt;
import com.digitalwallet.view.main.BackHandler;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInFeedbackSuccessViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkedIn/CheckInFeedbackSuccessFragment;", "Lcom/digitalwallet/view/base/BaseFragment;", "Lcom/digitalwallet/databinding/FragmentCheckInFeedbackSuccessBinding;", "Lcom/digitalwallet/view/main/BackHandler;", "()V", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInFeedbackSuccessViewModel;", "getViewModel", "()Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInFeedbackSuccessViewModel;", "setViewModel", "(Lcom/digitalwallet/viewmodel/checkIn/checkedIn/CheckInFeedbackSuccessViewModel;)V", "handleBack", "", "onViewCreated", "", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInFeedbackSuccessFragment.kt */
public final class CheckInFeedbackSuccessFragment extends BaseFragment<FragmentCheckInFeedbackSuccessBinding> implements BackHandler {
    private static final String CHECK_IN_ITEM_KEY = "CHECK_IN_ITEM";
    public static final Companion Companion = new Companion(null);
    private static final String SKIP_KEY = "SKIP";
    private HashMap _$_findViewCache;
    private final int layoutId = R.layout.fragment_check_in_feedback_success;
    @Inject
    public CheckInFeedbackSuccessViewModel viewModel;

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
    public CheckInFeedbackSuccessViewModel getViewModel() {
        CheckInFeedbackSuccessViewModel checkInFeedbackSuccessViewModel = this.viewModel;
        if (checkInFeedbackSuccessViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return checkInFeedbackSuccessViewModel;
    }

    public void setViewModel(CheckInFeedbackSuccessViewModel checkInFeedbackSuccessViewModel) {
        Intrinsics.checkNotNullParameter(checkInFeedbackSuccessViewModel, "<set-?>");
        this.viewModel = checkInFeedbackSuccessViewModel;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CheckIn checkIn;
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ActivityAnalyticsHelper.setScreenName$default(new ActivityAnalyticsHelper(requireActivity), ActivityAnalyticsHelper.Screen.CheckInFeedbackThankYou, null, null, 6, null);
        Bundle arguments = getArguments();
        if (!(arguments == null || (checkIn = (CheckIn) arguments.getParcelable("CHECK_IN_ITEM")) == null)) {
            CheckInFeedbackSuccessViewModel viewModel2 = getViewModel();
            Intrinsics.checkNotNullExpressionValue(checkIn, "it");
            viewModel2.setup(checkIn);
        }
        getViewModel().getSkipped().set(Boolean.valueOf(requireArguments().getBoolean(SKIP_KEY)));
    }

    @Override // com.digitalwallet.view.main.BackHandler
    public boolean handleBack() {
        CheckInUtilsKt.backToMainActivity(this);
        return true;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkedIn/CheckInFeedbackSuccessFragment$Companion;", "", "()V", "CHECK_IN_ITEM_KEY", "", "SKIP_KEY", "create", "Lcom/digitalwallet/view/checkIn/checkedIn/CheckInFeedbackSuccessFragment;", "arguments", "Landroid/os/Bundle;", "skip", "", "checkInItem", "Lcom/digitalwallet/model/CheckIn;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CheckInFeedbackSuccessFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CheckInFeedbackSuccessFragment create(Bundle bundle, boolean z) {
            Intrinsics.checkNotNullParameter(bundle, "arguments");
            Parcelable parcelable = bundle.getParcelable("CHECK_IN_ITEM");
            Intrinsics.checkNotNull(parcelable);
            Intrinsics.checkNotNullExpressionValue(parcelable, "arguments.getParcelable<…kIn>(CHECK_IN_ITEM_KEY)!!");
            return create((CheckIn) parcelable, z);
        }

        private final CheckInFeedbackSuccessFragment create(CheckIn checkIn, boolean z) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("CHECK_IN_ITEM", checkIn);
            bundle.putBoolean(CheckInFeedbackSuccessFragment.SKIP_KEY, z);
            CheckInFeedbackSuccessFragment checkInFeedbackSuccessFragment = new CheckInFeedbackSuccessFragment();
            checkInFeedbackSuccessFragment.setArguments(bundle);
            return checkInFeedbackSuccessFragment;
        }
    }
}
