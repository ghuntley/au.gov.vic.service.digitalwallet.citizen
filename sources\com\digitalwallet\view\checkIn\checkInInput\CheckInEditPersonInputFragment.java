package com.digitalwallet.view.checkIn.checkInInput;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.databinding.FragmentCheckInEditPersonInputBinding;
import com.digitalwallet.databinding.LayoutCheckInInputBinding;
import com.digitalwallet.model.DependantCheckIn;
import com.digitalwallet.model.PrimaryPersonCheckIn;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.utilities.EventObserver;
import com.digitalwallet.utilities.FragmentHelperKt;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInEditPersonInputViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u001a\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInInput/CheckInEditPersonInputFragment;", "Lcom/digitalwallet/view/checkIn/checkInInput/CheckInInputBaseFragment;", "Lcom/digitalwallet/databinding/FragmentCheckInEditPersonInputBinding;", "()V", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInEditPersonInputViewModel;", "getViewModel", "()Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInEditPersonInputViewModel;", "setViewModel", "(Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInEditPersonInputViewModel;)V", "goBack", "", "observeUniqueEvents", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInEditPersonInputFragment.kt */
public final class CheckInEditPersonInputFragment extends CheckInInputBaseFragment<FragmentCheckInEditPersonInputBinding> {
    public static final Companion Companion = new Companion(null);
    private static final String DEPENDANT_CHECK_IN_KEY = "DEPENDANT_CHECK_IN_KEY";
    private static final String PRIMARY_PERSON_CHECK_IN_KEY = "PRIMARY_PERSON_CHECK_IN_KEY";
    private HashMap _$_findViewCache;
    private final int layoutId = R.layout.fragment_check_in_edit_person_input;
    @Inject
    public CheckInEditPersonInputViewModel viewModel;

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
    public CheckInEditPersonInputViewModel getViewModel() {
        CheckInEditPersonInputViewModel checkInEditPersonInputViewModel = this.viewModel;
        if (checkInEditPersonInputViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return checkInEditPersonInputViewModel;
    }

    public void setViewModel(CheckInEditPersonInputViewModel checkInEditPersonInputViewModel) {
        Intrinsics.checkNotNullParameter(checkInEditPersonInputViewModel, "<set-?>");
        this.viewModel = checkInEditPersonInputViewModel;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), ActivityAnalyticsHelper.Screen.CheckInEditPerson, null, null, 6, null);
        Bundle arguments = getArguments();
        DependantCheckIn dependantCheckIn = null;
        PrimaryPersonCheckIn primaryPersonCheckIn = arguments != null ? (PrimaryPersonCheckIn) arguments.getParcelable(PRIMARY_PERSON_CHECK_IN_KEY) : null;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            dependantCheckIn = (DependantCheckIn) arguments2.getParcelable(DEPENDANT_CHECK_IN_KEY);
        }
        getViewModel().setup(primaryPersonCheckIn, dependantCheckIn);
        LayoutCheckInInputBinding layoutCheckInInputBinding = ((FragmentCheckInEditPersonInputBinding) getBinding()).inputLayout;
        Intrinsics.checkNotNullExpressionValue(layoutCheckInInputBinding, "binding.inputLayout");
        super.observeCommonEvents(layoutCheckInInputBinding);
        observeUniqueEvents();
        LayoutCheckInInputBinding layoutCheckInInputBinding2 = ((FragmentCheckInEditPersonInputBinding) getBinding()).inputLayout;
        Intrinsics.checkNotNullExpressionValue(layoutCheckInInputBinding2, "binding.inputLayout");
        super.maybeRequestFieldFocus(layoutCheckInInputBinding2);
    }

    private final void observeUniqueEvents() {
        T t;
        T t2;
        getViewModel().getCancelEvent().observe(getViewLifecycleOwner(), new EventObserver(new CheckInEditPersonInputFragment$observeUniqueEvents$1(this)));
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        List<Fragment> fragments = parentFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "parentFragmentManager.fragments");
        Iterator<T> it = fragments.iterator();
        while (true) {
            t = null;
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (t2 instanceof CheckInSummaryFragment) {
                break;
            }
        }
        if (t2 instanceof CheckInSummaryFragment) {
            t = t2;
        }
        T t3 = t;
        getViewModel().getPrimaryPersonEditedEvent().observe(getViewLifecycleOwner(), new EventObserver(new CheckInEditPersonInputFragment$observeUniqueEvents$2(this, t3)));
        getViewModel().getDependantEditedEvent().observe(getViewLifecycleOwner(), new EventObserver(new CheckInEditPersonInputFragment$observeUniqueEvents$3(this, t3)));
        getViewModel().getDependantDeletedEvent().observe(getViewLifecycleOwner(), new EventObserver(new CheckInEditPersonInputFragment$observeUniqueEvents$4(this, t3)));
    }

    /* access modifiers changed from: private */
    public final void goBack() {
        FragmentHelperKt.hideKeyboard(this);
        getParentFragmentManager().popBackStack();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInInput/CheckInEditPersonInputFragment$Companion;", "", "()V", CheckInEditPersonInputFragment.DEPENDANT_CHECK_IN_KEY, "", CheckInEditPersonInputFragment.PRIMARY_PERSON_CHECK_IN_KEY, "createFragment", "Lcom/digitalwallet/view/checkIn/checkInInput/CheckInEditPersonInputFragment;", "dependantCheckIn", "Lcom/digitalwallet/model/DependantCheckIn;", "primaryPersonCheckIn", "Lcom/digitalwallet/model/PrimaryPersonCheckIn;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CheckInEditPersonInputFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CheckInEditPersonInputFragment createFragment(PrimaryPersonCheckIn primaryPersonCheckIn) {
            Intrinsics.checkNotNullParameter(primaryPersonCheckIn, "primaryPersonCheckIn");
            CheckInEditPersonInputFragment checkInEditPersonInputFragment = new CheckInEditPersonInputFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(CheckInEditPersonInputFragment.PRIMARY_PERSON_CHECK_IN_KEY, primaryPersonCheckIn);
            Unit unit = Unit.INSTANCE;
            checkInEditPersonInputFragment.setArguments(bundle);
            return checkInEditPersonInputFragment;
        }

        public final CheckInEditPersonInputFragment createFragment(DependantCheckIn dependantCheckIn) {
            Intrinsics.checkNotNullParameter(dependantCheckIn, "dependantCheckIn");
            CheckInEditPersonInputFragment checkInEditPersonInputFragment = new CheckInEditPersonInputFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(CheckInEditPersonInputFragment.DEPENDANT_CHECK_IN_KEY, dependantCheckIn);
            Unit unit = Unit.INSTANCE;
            checkInEditPersonInputFragment.setArguments(bundle);
            return checkInEditPersonInputFragment;
        }
    }
}
