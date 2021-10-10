package com.digitalwallet.view.checkIn.checkInShortcut;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.databinding.FragmentCheckInShortcutBinding;
import com.digitalwallet.model.CheckIn;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.utilities.EventObserver;
import com.digitalwallet.view.base.BaseFragment;
import com.digitalwallet.view.checkIn.CheckInUtilsKt;
import com.digitalwallet.view.checkIn.checkedIn.CheckInHistoryDetailFragment;
import com.digitalwallet.view.main.BackHandler;
import com.digitalwallet.view.util.ViewUtilsKt;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.CheckInShortcutViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.FavouriteRowViewModel;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.HistoryRowViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001&B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\u001a\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0010H\u0002J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0010H\u0003J\b\u0010\"\u001a\u00020\u0012H\u0002J\b\u0010#\u001a\u00020\u0012H\u0002J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0016H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006'"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInShortcut/CheckInShortcutFragment;", "Lcom/digitalwallet/view/base/BaseFragment;", "Lcom/digitalwallet/databinding/FragmentCheckInShortcutBinding;", "Lcom/digitalwallet/view/main/BackHandler;", "()V", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/viewmodel/checkIn/checkInShortcut/CheckInShortcutViewModel;", "getViewModel", "()Lcom/digitalwallet/viewmodel/checkIn/checkInShortcut/CheckInShortcutViewModel;", "setViewModel", "(Lcom/digitalwallet/viewmodel/checkIn/checkInShortcut/CheckInShortcutViewModel;)V", "handleBack", "", "navigateToCheckInHistoryDetail", "", "checkInItem", "Lcom/digitalwallet/model/CheckIn;", "checkInCode", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "observeEvents", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "populateFavouriteList", "isInitialization", "populateHistoryList", "setupViews", "showAlertBeforeDeletion", "toCheckInToAFavouriteLocation", "favourite", "Companion", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInShortcutFragment.kt */
public final class CheckInShortcutFragment extends BaseFragment<FragmentCheckInShortcutBinding> implements BackHandler {
    public static final Companion Companion = new Companion(null);
    private static final String TO_HISTORY_TAB_KEY = "TO_HISTORY_TAB_KEY";
    private HashMap _$_findViewCache;
    private final int layoutId = R.layout.fragment_check_in_shortcut;
    @Inject
    public CheckInShortcutViewModel viewModel;

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
    public CheckInShortcutViewModel getViewModel() {
        CheckInShortcutViewModel checkInShortcutViewModel = this.viewModel;
        if (checkInShortcutViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return checkInShortcutViewModel;
    }

    public void setViewModel(CheckInShortcutViewModel checkInShortcutViewModel) {
        Intrinsics.checkNotNullParameter(checkInShortcutViewModel, "<set-?>");
        this.viewModel = checkInShortcutViewModel;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/digitalwallet/view/checkIn/checkInShortcut/CheckInShortcutFragment$Companion;", "", "()V", CheckInShortcutFragment.TO_HISTORY_TAB_KEY, "", "createFragment", "Lcom/digitalwallet/view/checkIn/checkInShortcut/CheckInShortcutFragment;", "toHistoryTab", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CheckInShortcutFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CheckInShortcutFragment createFragment(boolean z) {
            CheckInShortcutFragment checkInShortcutFragment = new CheckInShortcutFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(CheckInShortcutFragment.TO_HISTORY_TAB_KEY, z);
            Unit unit = Unit.INSTANCE;
            checkInShortcutFragment.setArguments(bundle);
            return checkInShortcutFragment;
        }
    }

    @Override // com.digitalwallet.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ObservableBoolean isHistoryView = getViewModel().isHistoryView();
        Bundle arguments = getArguments();
        boolean z = true;
        if (arguments == null || !arguments.getBoolean(TO_HISTORY_TAB_KEY)) {
            z = false;
        }
        isHistoryView.set(z);
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), ActivityAnalyticsHelper.Screen.CheckInShortcut, null, null, 6, null);
        setupViews();
        observeEvents();
    }

    private final void setupViews() {
        populateHistoryList(true);
        getViewModel().getHistoryRowVMs().addOnPropertyChangedCallback(new CheckInShortcutFragment$setupViews$1(this));
        populateFavouriteList(true);
        getViewModel().getFavouriteRowVMs().addOnPropertyChangedCallback(new CheckInShortcutFragment$setupViews$2(this));
        getViewModel().isEditMode().addOnPropertyChangedCallback(new CheckInShortcutFragment$setupViews$3(this));
        ((FragmentCheckInShortcutBinding) getBinding()).deleteButton.setOnClickListener(new CheckInShortcutFragment$setupViews$4(this));
    }

    private final void observeEvents() {
        getViewModel().getBackEvent().observe(getViewLifecycleOwner(), new EventObserver(new CheckInShortcutFragment$observeEvents$1(this)));
        getViewModel().getToHistoryDetailEvent().observe(getViewLifecycleOwner(), new EventObserver(new CheckInShortcutFragment$observeEvents$2(this)));
        getViewModel().getToFavouriteCheckInEvent().observe(getViewLifecycleOwner(), new EventObserver(new CheckInShortcutFragment$observeEvents$3(this)));
    }

    @Override // com.digitalwallet.view.main.BackHandler
    public boolean handleBack() {
        if (getViewModel().isEditMode().get()) {
            getViewModel().cancelEditing();
            return true;
        }
        getViewModel().goBack();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getViewModel().refreshData();
        RecyclerView recyclerView = ((FragmentCheckInShortcutBinding) getBinding()).historyList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.historyList");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (!(adapter instanceof HistoryListAdapter)) {
            adapter = null;
        }
        HistoryListAdapter historyListAdapter = (HistoryListAdapter) adapter;
        if (historyListAdapter != null) {
            historyListAdapter.clearSearchFocus();
        }
    }

    /* access modifiers changed from: private */
    public final void showAlertBeforeDeletion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        if (getViewModel().isHistoryView().get()) {
            builder.setTitle(R.string.check_in_delete_history_title).setMessage(R.string.check_in_delete_history_message);
        } else if (getViewModel().getSelectedRowsCount().get() == 1) {
            builder.setTitle(R.string.check_in_remove_a_favourite_title).setMessage(R.string.check_in_remove_a_favourite_message);
        } else {
            builder.setTitle(R.string.check_in_remove_favourites_title).setMessage(R.string.check_in_remove_favourites_message);
        }
        builder.setNegativeButton(R.string.cancel_RES_2131689505, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.remove, new CheckInShortcutFragment$showAlertBeforeDeletion$2(this)).show();
    }

    /* access modifiers changed from: private */
    public final void populateHistoryList(boolean z) {
        ArrayList arrayList;
        List<HistoryRowViewModel> list = getViewModel().getHistoryRowVMs().get();
        if (list == null || (arrayList = CollectionsKt.toMutableList((Collection) list)) == null) {
            arrayList = new ArrayList();
        }
        if (z) {
            RecyclerView recyclerView = ((FragmentCheckInShortcutBinding) getBinding()).historyList;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.historyList");
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            HistoryListAdapter historyListAdapter = new HistoryListAdapter(new CheckInShortcutFragment$populateHistoryList$adapter$1(getViewModel()));
            historyListAdapter.updateHistoryList(arrayList);
            RecyclerView recyclerView2 = ((FragmentCheckInShortcutBinding) getBinding()).historyList;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.historyList");
            recyclerView2.setAdapter(historyListAdapter);
            RecyclerView recyclerView3 = ((FragmentCheckInShortcutBinding) getBinding()).historyList;
            RecyclerView recyclerView4 = ((FragmentCheckInShortcutBinding) getBinding()).historyList;
            Intrinsics.checkNotNullExpressionValue(recyclerView4, "binding.historyList");
            recyclerView3.addItemDecoration(new HeaderItemDecoration(recyclerView4, false, new CheckInShortcutFragment$populateHistoryList$1(historyListAdapter)));
            CheckInShortcutFragment$populateHistoryList$onTouchListener$1 checkInShortcutFragment$populateHistoryList$onTouchListener$1 = new CheckInShortcutFragment$populateHistoryList$onTouchListener$1(historyListAdapter);
            ((FragmentCheckInShortcutBinding) getBinding()).historyList.setOnTouchListener(checkInShortcutFragment$populateHistoryList$onTouchListener$1);
            ((FragmentCheckInShortcutBinding) getBinding()).historyListContainer.setOnTouchListener(checkInShortcutFragment$populateHistoryList$onTouchListener$1);
            return;
        }
        RecyclerView recyclerView5 = ((FragmentCheckInShortcutBinding) getBinding()).historyList;
        Intrinsics.checkNotNullExpressionValue(recyclerView5, "binding.historyList");
        RecyclerView.Adapter adapter = recyclerView5.getAdapter();
        if (!(adapter instanceof HistoryListAdapter)) {
            adapter = null;
        }
        HistoryListAdapter historyListAdapter2 = (HistoryListAdapter) adapter;
        if (historyListAdapter2 != null) {
            historyListAdapter2.updateHistoryList(arrayList);
        }
    }

    /* access modifiers changed from: private */
    public final void populateFavouriteList(boolean z) {
        ArrayList arrayList;
        List<FavouriteRowViewModel> list = getViewModel().getFavouriteRowVMs().get();
        if (list == null || (arrayList = CollectionsKt.toMutableList((Collection) list)) == null) {
            arrayList = new ArrayList();
        }
        if (z) {
            RecyclerView recyclerView = ((FragmentCheckInShortcutBinding) getBinding()).favouriteList;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.favouriteList");
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            RecyclerView recyclerView2 = ((FragmentCheckInShortcutBinding) getBinding()).favouriteList;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.favouriteList");
            recyclerView2.setAdapter(new FavouriteListAdapter(arrayList, getViewModel().getFavouriteItemsTouchHelper()));
            return;
        }
        RecyclerView recyclerView3 = ((FragmentCheckInShortcutBinding) getBinding()).favouriteList;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.favouriteList");
        RecyclerView.Adapter adapter = recyclerView3.getAdapter();
        if (!(adapter instanceof FavouriteListAdapter)) {
            adapter = null;
        }
        FavouriteListAdapter favouriteListAdapter = (FavouriteListAdapter) adapter;
        if (favouriteListAdapter != null) {
            favouriteListAdapter.updateFavouriteList(arrayList);
        }
    }

    /* access modifiers changed from: private */
    public final void navigateToCheckInHistoryDetail(CheckIn checkIn, CheckInUtils.CheckInCode checkInCode) {
        CheckInHistoryDetailFragment createFragment = CheckInHistoryDetailFragment.Companion.createFragment(checkIn, checkInCode);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        int containerId = ViewUtilsKt.getContainerId(this);
        List<Fragment> fragments = parentFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
        for (T t : fragments) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            t.setUserVisibleHint(false);
        }
        FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
        String simpleName = Reflection.getOrCreateKotlinClass(CheckInHistoryDetailFragment.class).getSimpleName();
        beginTransaction.add(containerId, createFragment, simpleName).addToBackStack(simpleName).commit();
    }

    /* access modifiers changed from: private */
    public final void toCheckInToAFavouriteLocation(CheckInUtils.CheckInCode checkInCode) {
        BaseFragment<? extends ViewDataBinding> checkInInputEntryFragment = CheckInUtilsKt.getCheckInInputEntryFragment(getViewModel().getCheckInRepository(), checkInCode, true);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        int containerId = ViewUtilsKt.getContainerId(this);
        FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
        beginTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        beginTransaction.replace(containerId, checkInInputEntryFragment, Reflection.getOrCreateKotlinClass(BaseFragment.class).getSimpleName()).addToBackStack(null).commit();
    }
}
