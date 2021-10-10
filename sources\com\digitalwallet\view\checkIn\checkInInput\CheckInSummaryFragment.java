package com.digitalwallet.view.checkIn.checkInInput;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.databinding.FragmentCheckInSummaryBinding;
import com.digitalwallet.model.DependantCheckIn;
import com.digitalwallet.model.PrimaryPersonCheckIn;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.utilities.EventObserver;
import com.digitalwallet.utilities.FragmentHelperKt;
import com.digitalwallet.view.base.BaseFragment;
import com.digitalwallet.view.checkIn.CheckInUtilsKt;
import com.digitalwallet.view.main.BackHandler;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInSummaryViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\u001a\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInInput/CheckInSummaryFragment;", "Lcom/digitalwallet/view/base/BaseFragment;", "Lcom/digitalwallet/databinding/FragmentCheckInSummaryBinding;", "Lcom/digitalwallet/view/main/BackHandler;", "()V", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInSummaryViewModel;", "getViewModel", "()Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInSummaryViewModel;", "setViewModel", "(Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInSummaryViewModel;)V", "goBack", "", "handleBack", "", "observeEvents", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupViews", "Companion", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInSummaryFragment.kt */
public final class CheckInSummaryFragment extends BaseFragment<FragmentCheckInSummaryBinding> implements BackHandler {
    public static final Companion Companion = new Companion(null);
    private static final String FIRST_DEPENDANT_CHECK_IN_KEY = "FIRST_DEPENDANT_CHECK_IN_KEY";
    private static final String PRIMARY_PERSON_CHECK_IN_KEY = "PRIMARY_PERSON_CHECK_IN_KEY";
    private static final String SHOW_BACK_KEY = "SHOW_BACK_KEY";
    private HashMap _$_findViewCache;
    private final int layoutId = R.layout.fragment_check_in_summary;
    @Inject
    public CheckInSummaryViewModel viewModel;

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
    public CheckInSummaryViewModel getViewModel() {
        CheckInSummaryViewModel checkInSummaryViewModel = this.viewModel;
        if (checkInSummaryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return checkInSummaryViewModel;
    }

    public void setViewModel(CheckInSummaryViewModel checkInSummaryViewModel) {
        Intrinsics.checkNotNullParameter(checkInSummaryViewModel, "<set-?>");
        this.viewModel = checkInSummaryViewModel;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), ActivityAnalyticsHelper.Screen.CheckInSummary, null, null, 6, null);
        setupViews();
        observeEvents();
        Bundle arguments = getArguments();
        Boolean bool = null;
        PrimaryPersonCheckIn primaryPersonCheckIn = arguments != null ? (PrimaryPersonCheckIn) arguments.getParcelable(PRIMARY_PERSON_CHECK_IN_KEY) : null;
        boolean z = true;
        if (primaryPersonCheckIn != null) {
            Bundle arguments2 = getArguments();
            DependantCheckIn dependantCheckIn = arguments2 != null ? (DependantCheckIn) arguments2.getParcelable(FIRST_DEPENDANT_CHECK_IN_KEY) : null;
            Bundle arguments3 = getArguments();
            if (arguments3 != null) {
                bool = Boolean.valueOf(arguments3.getBoolean(SHOW_BACK_KEY));
            }
            if (bool == null) {
                z = false;
            }
            if (z) {
                getViewModel().setup(primaryPersonCheckIn, dependantCheckIn, bool.booleanValue());
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final void setupViews() {
        TextView textView = ((FragmentCheckInSummaryBinding) getBinding()).checkInPrivacyLayout.dataDesc;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.checkInPrivacyLayout.dataDesc");
        CheckInInputBaseFragmentKt.formatDescriptionText(this, textView, null);
        TextView textView2 = ((FragmentCheckInSummaryBinding) getBinding()).checkInPrivacyLayout.checkInPrivacy;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.checkInPrivacyLayout.checkInPrivacy");
        CheckInInputBaseFragmentKt.formatPrivacySecurityText(this, textView2, null);
        ((FragmentCheckInSummaryBinding) getBinding()).titleBar.backButton.setOnClickListener(new CheckInSummaryFragment$setupViews$1(this));
        ((FragmentCheckInSummaryBinding) getBinding()).titleBar.helpButton.setOnClickListener(new CheckInSummaryFragment$setupViews$2(this));
        getViewModel().getDependantRowVMs().addOnPropertyChangedCallback(new CheckInSummaryFragment$setupViews$3(this));
    }

    private final void observeEvents() {
        getViewModel().getPresentAddDependant().observe(getViewLifecycleOwner(), new EventObserver(new CheckInSummaryFragment$observeEvents$1(this)));
        getViewModel().getPresentEditPrimary().observe(getViewLifecycleOwner(), new EventObserver(new CheckInSummaryFragment$observeEvents$2(this)));
        getViewModel().getPresentEditDependant().observe(getViewLifecycleOwner(), new EventObserver(new CheckInSummaryFragment$observeEvents$3(this)));
        getViewModel().getNavigateToSubmitting().observe(getViewLifecycleOwner(), new EventObserver(new CheckInSummaryFragment$observeEvents$4(this)));
    }

    @Override // com.digitalwallet.view.main.BackHandler
    public boolean handleBack() {
        if (getViewModel().getShowBack().get()) {
            goBack();
            return true;
        } else if (CheckInUtilsKt.isInstantApp(this)) {
            requireActivity().finish();
            return true;
        } else {
            goBack();
            return true;
        }
    }

    /* access modifiers changed from: private */
    public final void goBack() {
        FragmentHelperKt.hideKeyboard(this);
        getParentFragmentManager().popBackStack();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInInput/CheckInSummaryFragment$Companion;", "", "()V", CheckInSummaryFragment.FIRST_DEPENDANT_CHECK_IN_KEY, "", CheckInSummaryFragment.PRIMARY_PERSON_CHECK_IN_KEY, CheckInSummaryFragment.SHOW_BACK_KEY, "createFragment", "Lcom/digitalwallet/view/checkIn/checkInInput/CheckInSummaryFragment;", "primaryPersonCheckIn", "Lcom/digitalwallet/model/PrimaryPersonCheckIn;", "firstDependantCheckIn", "Lcom/digitalwallet/model/DependantCheckIn;", "showBack", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CheckInSummaryFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CheckInSummaryFragment createFragment(PrimaryPersonCheckIn primaryPersonCheckIn, DependantCheckIn dependantCheckIn, boolean z) {
            Intrinsics.checkNotNullParameter(primaryPersonCheckIn, "primaryPersonCheckIn");
            CheckInSummaryFragment checkInSummaryFragment = new CheckInSummaryFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(CheckInSummaryFragment.PRIMARY_PERSON_CHECK_IN_KEY, primaryPersonCheckIn);
            bundle.putParcelable(CheckInSummaryFragment.FIRST_DEPENDANT_CHECK_IN_KEY, dependantCheckIn);
            bundle.putBoolean(CheckInSummaryFragment.SHOW_BACK_KEY, z);
            Unit unit = Unit.INSTANCE;
            checkInSummaryFragment.setArguments(bundle);
            return checkInSummaryFragment;
        }
    }
}
