package com.digitalwallet.view.checkIn.checkInInput;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.databinding.FragmentCheckInPrimaryInputBinding;
import com.digitalwallet.databinding.LayoutCheckInInputBinding;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.utilities.EventObserver;
import com.digitalwallet.utilities.FragmentHelperKt;
import com.digitalwallet.view.checkIn.CheckInUtilsKt;
import com.digitalwallet.view.main.BackHandler;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInPrimaryInputViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.ResponseTypeValues;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001!B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\u001a\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0016H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInInput/CheckInPrimaryInputFragment;", "Lcom/digitalwallet/view/checkIn/checkInInput/CheckInInputBaseFragment;", "Lcom/digitalwallet/databinding/FragmentCheckInPrimaryInputBinding;", "Lcom/digitalwallet/view/main/BackHandler;", "()V", "layoutId", "", "getLayoutId", "()I", "navigatingAway", "", "getNavigatingAway", "()Z", "setNavigatingAway", "(Z)V", "viewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInPrimaryInputViewModel;", "getViewModel", "()Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInPrimaryInputViewModel;", "setViewModel", "(Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInPrimaryInputViewModel;)V", "goBack", "", "handleBack", "observeUniqueEvents", "onResume", "onStop", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupViews", "Companion", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInPrimaryInputFragment.kt */
public final class CheckInPrimaryInputFragment extends CheckInInputBaseFragment<FragmentCheckInPrimaryInputBinding> implements BackHandler {
    private static final String CODE_ITEM_KEY = "CODE_ITEM_KEY";
    public static final Companion Companion = new Companion(null);
    private static final String SHOW_BACK_KEY = "SHOW_BACK_KEY";
    private HashMap _$_findViewCache;
    private final int layoutId = R.layout.fragment_check_in_primary_input;
    private boolean navigatingAway;
    @Inject
    public CheckInPrimaryInputViewModel viewModel;

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
    public CheckInPrimaryInputViewModel getViewModel() {
        CheckInPrimaryInputViewModel checkInPrimaryInputViewModel = this.viewModel;
        if (checkInPrimaryInputViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return checkInPrimaryInputViewModel;
    }

    public void setViewModel(CheckInPrimaryInputViewModel checkInPrimaryInputViewModel) {
        Intrinsics.checkNotNullParameter(checkInPrimaryInputViewModel, "<set-?>");
        this.viewModel = checkInPrimaryInputViewModel;
    }

    public final boolean getNavigatingAway() {
        return this.navigatingAway;
    }

    public final void setNavigatingAway(boolean z) {
        this.navigatingAway = z;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CheckInUtils.CheckInCode checkInCode;
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), ActivityAnalyticsHelper.Screen.CheckInInput, null, null, 6, null);
        ((FragmentCheckInPrimaryInputBinding) getBinding()).setLifecycleOwner(this);
        Bundle arguments = getArguments();
        if (!(arguments == null || (checkInCode = (CheckInUtils.CheckInCode) arguments.getParcelable(CODE_ITEM_KEY)) == null)) {
            CheckInPrimaryInputViewModel viewModel2 = getViewModel();
            Intrinsics.checkNotNullExpressionValue(checkInCode, "it");
            viewModel2.setup(checkInCode);
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            getViewModel().getShowBack().set(arguments2.getBoolean(SHOW_BACK_KEY));
        }
        LayoutCheckInInputBinding layoutCheckInInputBinding = ((FragmentCheckInPrimaryInputBinding) getBinding()).inputLayout;
        Intrinsics.checkNotNullExpressionValue(layoutCheckInInputBinding, "binding.inputLayout");
        super.observeCommonEvents(layoutCheckInInputBinding);
        observeUniqueEvents();
        setupViews();
    }

    private final void setupViews() {
        TextView textView = ((FragmentCheckInPrimaryInputBinding) getBinding()).checkInPrivacyLayout.dataDesc;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.checkInPrivacyLayout.dataDesc");
        CheckInInputBaseFragmentKt.formatDescriptionText(this, textView, new CheckInPrimaryInputFragment$setupViews$1(this));
        TextView textView2 = ((FragmentCheckInPrimaryInputBinding) getBinding()).checkInPrivacyLayout.checkInPrivacy;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.checkInPrivacyLayout.checkInPrivacy");
        CheckInInputBaseFragmentKt.formatPrivacySecurityText(this, textView2, new CheckInPrimaryInputFragment$setupViews$2(this));
        ((FragmentCheckInPrimaryInputBinding) getBinding()).titleBar.backButton.setOnClickListener(new CheckInPrimaryInputFragment$setupViews$3(this));
        ((FragmentCheckInPrimaryInputBinding) getBinding()).titleBar.helpButton.setOnClickListener(new CheckInPrimaryInputFragment$setupViews$4(this));
        LayoutCheckInInputBinding layoutCheckInInputBinding = ((FragmentCheckInPrimaryInputBinding) getBinding()).inputLayout;
        Intrinsics.checkNotNullExpressionValue(layoutCheckInInputBinding, "binding.inputLayout");
        super.maybeRequestFieldFocus(layoutCheckInInputBinding);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.navigatingAway = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (!this.navigatingAway && CheckInUtilsKt.isInstantApp(this)) {
            requireActivity().finish();
        }
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

    private final void observeUniqueEvents() {
        getViewModel().getNavigateToAddDependant().observe(getViewLifecycleOwner(), new EventObserver(new CheckInPrimaryInputFragment$observeUniqueEvents$1(this)));
        getViewModel().getNavigateToSummary().observe(getViewLifecycleOwner(), new EventObserver(new CheckInPrimaryInputFragment$observeUniqueEvents$2(this)));
        getViewModel().getNavigateToSubmitting().observe(getViewLifecycleOwner(), new EventObserver(new CheckInPrimaryInputFragment$observeUniqueEvents$3(this)));
    }

    /* access modifiers changed from: private */
    public final void goBack() {
        FragmentHelperKt.hideKeyboard(this);
        this.navigatingAway = true;
        getParentFragmentManager().popBackStack();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInInput/CheckInPrimaryInputFragment$Companion;", "", "()V", CheckInPrimaryInputFragment.CODE_ITEM_KEY, "", CheckInPrimaryInputFragment.SHOW_BACK_KEY, "createFragment", "Lcom/digitalwallet/view/checkIn/checkInInput/CheckInPrimaryInputFragment;", ResponseTypeValues.CODE, "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "showBack", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CheckInPrimaryInputFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CheckInPrimaryInputFragment createFragment(CheckInUtils.CheckInCode checkInCode, boolean z) {
            Intrinsics.checkNotNullParameter(checkInCode, ResponseTypeValues.CODE);
            CheckInPrimaryInputFragment checkInPrimaryInputFragment = new CheckInPrimaryInputFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(CheckInPrimaryInputFragment.CODE_ITEM_KEY, checkInCode);
            bundle.putBoolean(CheckInPrimaryInputFragment.SHOW_BACK_KEY, z);
            Unit unit = Unit.INSTANCE;
            checkInPrimaryInputFragment.setArguments(bundle);
            return checkInPrimaryInputFragment;
        }
    }
}
