package com.digitalwallet.view.checkIn.checkInInput;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.databinding.FragmentCheckInAddDependantInputBinding;
import com.digitalwallet.databinding.LayoutCheckInInputBinding;
import com.digitalwallet.model.PrimaryPersonCheckIn;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.utilities.EventObserver;
import com.digitalwallet.utilities.FragmentHelperKt;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInAddDependantInputViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u001a\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInInput/CheckInAddDependantInputFragment;", "Lcom/digitalwallet/view/checkIn/checkInInput/CheckInInputBaseFragment;", "Lcom/digitalwallet/databinding/FragmentCheckInAddDependantInputBinding;", "()V", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInAddDependantInputViewModel;", "getViewModel", "()Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInAddDependantInputViewModel;", "setViewModel", "(Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInAddDependantInputViewModel;)V", "goBack", "", "observeUniqueEvents", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupViews", "Companion", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInAddDependantInputFragment.kt */
public final class CheckInAddDependantInputFragment extends CheckInInputBaseFragment<FragmentCheckInAddDependantInputBinding> {
    public static final Companion Companion = new Companion(null);
    private static final String FULL_SCREEN_MODE_KEY = "FULL_SCREEN_MODE_KEY";
    private static final String PRIMARY_PERSON_CHECK_IN_KEY = "PRIMARY_PERSON_CHECK_IN_KEY";
    private HashMap _$_findViewCache;
    private final int layoutId = R.layout.fragment_check_in_add_dependant_input;
    @Inject
    public CheckInAddDependantInputViewModel viewModel;

    @Override // com.digitalwallet.view.checkIn.checkInInput.CheckInInputBaseFragment, com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.digitalwallet.view.checkIn.checkInInput.CheckInInputBaseFragment, com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment
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

    @Override // com.digitalwallet.view.checkIn.checkInInput.CheckInInputBaseFragment, com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.digitalwallet.view.checkIn.checkInInput.CheckInInputBaseFragment, com.digitalwallet.view.base.BaseFragment
    public CheckInAddDependantInputViewModel getViewModel() {
        CheckInAddDependantInputViewModel checkInAddDependantInputViewModel = this.viewModel;
        if (checkInAddDependantInputViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return checkInAddDependantInputViewModel;
    }

    public void setViewModel(CheckInAddDependantInputViewModel checkInAddDependantInputViewModel) {
        Intrinsics.checkNotNullParameter(checkInAddDependantInputViewModel, "<set-?>");
        this.viewModel = checkInAddDependantInputViewModel;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), ActivityAnalyticsHelper.Screen.CheckInAddDependant, null, null, 6, null);
        Bundle arguments = getArguments();
        Boolean bool = null;
        PrimaryPersonCheckIn primaryPersonCheckIn = arguments != null ? (PrimaryPersonCheckIn) arguments.getParcelable(PRIMARY_PERSON_CHECK_IN_KEY) : null;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            bool = Boolean.valueOf(arguments2.getBoolean(FULL_SCREEN_MODE_KEY));
        }
        if ((primaryPersonCheckIn == null || bool == null) ? false : true) {
            getViewModel().setup(primaryPersonCheckIn, bool.booleanValue());
            LayoutCheckInInputBinding layoutCheckInInputBinding = ((FragmentCheckInAddDependantInputBinding) getBinding()).inputLayout;
            Intrinsics.checkNotNullExpressionValue(layoutCheckInInputBinding, "binding.inputLayout");
            super.observeCommonEvents(layoutCheckInInputBinding);
            observeUniqueEvents();
            setupViews();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final void setupViews() {
        TextView textView = ((FragmentCheckInAddDependantInputBinding) getBinding()).checkInPrivacyLayout.dataDesc;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.checkInPrivacyLayout.dataDesc");
        CheckInInputBaseFragmentKt.formatDescriptionText(this, textView, null);
        TextView textView2 = ((FragmentCheckInAddDependantInputBinding) getBinding()).checkInPrivacyLayout.checkInPrivacy;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.checkInPrivacyLayout.checkInPrivacy");
        CheckInInputBaseFragmentKt.formatPrivacySecurityText(this, textView2, null);
        ((FragmentCheckInAddDependantInputBinding) getBinding()).fullScreenTitleBar.backButton.setOnClickListener(new CheckInAddDependantInputFragment$setupViews$1(this));
        ((FragmentCheckInAddDependantInputBinding) getBinding()).fullScreenTitleBar.helpButton.setOnClickListener(new CheckInAddDependantInputFragment$setupViews$2(this));
        LayoutCheckInInputBinding layoutCheckInInputBinding = ((FragmentCheckInAddDependantInputBinding) getBinding()).inputLayout;
        Intrinsics.checkNotNullExpressionValue(layoutCheckInInputBinding, "binding.inputLayout");
        super.maybeRequestFieldFocus(layoutCheckInInputBinding);
    }

    private final void observeUniqueEvents() {
        getViewModel().getCancelEvent().observe(getViewLifecycleOwner(), new EventObserver(new CheckInAddDependantInputFragment$observeUniqueEvents$1(this)));
        getViewModel().getNavigateToSummary().observe(getViewLifecycleOwner(), new EventObserver(new CheckInAddDependantInputFragment$observeUniqueEvents$2(this)));
    }

    /* access modifiers changed from: private */
    public final void goBack() {
        FragmentHelperKt.hideKeyboard(this);
        getParentFragmentManager().popBackStack();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInInput/CheckInAddDependantInputFragment$Companion;", "", "()V", CheckInAddDependantInputFragment.FULL_SCREEN_MODE_KEY, "", CheckInAddDependantInputFragment.PRIMARY_PERSON_CHECK_IN_KEY, "createFragment", "Lcom/digitalwallet/view/checkIn/checkInInput/CheckInAddDependantInputFragment;", "primaryPersonCheckIn", "Lcom/digitalwallet/model/PrimaryPersonCheckIn;", "fullScreenMode", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CheckInAddDependantInputFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CheckInAddDependantInputFragment createFragment(PrimaryPersonCheckIn primaryPersonCheckIn, boolean z) {
            Intrinsics.checkNotNullParameter(primaryPersonCheckIn, "primaryPersonCheckIn");
            CheckInAddDependantInputFragment checkInAddDependantInputFragment = new CheckInAddDependantInputFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(CheckInAddDependantInputFragment.PRIMARY_PERSON_CHECK_IN_KEY, primaryPersonCheckIn);
            bundle.putBoolean(CheckInAddDependantInputFragment.FULL_SCREEN_MODE_KEY, z);
            Unit unit = Unit.INSTANCE;
            checkInAddDependantInputFragment.setArguments(bundle);
            return checkInAddDependantInputFragment;
        }
    }
}
