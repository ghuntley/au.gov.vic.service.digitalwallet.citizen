package com.digitalwallet.app.view.main;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.FragmentTransactionHistoryBinding;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.view.main.adapter.TransactionInfoAdapter;
import com.digitalwallet.app.view.util.CustomDividerItemDecoration;
import com.digitalwallet.app.viewmodel.main.history.TransactionHistoryFragmentViewModel;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.google.android.gms.analytics.ecommerce.Promotion;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\r8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/digitalwallet/app/view/main/TransactionHistoryFragment;", "Lcom/digitalwallet/app/view/base/BaseAppFragment;", "Lcom/digitalwallet/app/databinding/FragmentTransactionHistoryBinding;", "()V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "layoutId", "", "getLayoutId", "()I", "transactionInfoAdapter", "Lcom/digitalwallet/app/view/main/adapter/TransactionInfoAdapter;", "viewModel", "Lcom/digitalwallet/app/viewmodel/main/history/TransactionHistoryFragmentViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/main/history/TransactionHistoryFragmentViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/main/history/TransactionHistoryFragmentViewModel;)V", "onDestroy", "", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setScreen", "setUserVisibleHint", "isVisibleToUser", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: TransactionHistoryFragment.kt */
public final class TransactionHistoryFragment extends BaseAppFragment<FragmentTransactionHistoryBinding> {
    private HashMap _$_findViewCache;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final int layoutId = R.layout.fragment_transaction_history;
    private TransactionInfoAdapter transactionInfoAdapter = new TransactionInfoAdapter();
    @Inject
    public TransactionHistoryFragmentViewModel viewModel;

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.app.view.base.BaseAppFragment, com.digitalwallet.view.base.BasicFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.app.view.base.BaseAppFragment, com.digitalwallet.view.base.BasicFragment
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

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.app.view.base.BaseAppFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public TransactionHistoryFragmentViewModel getViewModel() {
        TransactionHistoryFragmentViewModel transactionHistoryFragmentViewModel = this.viewModel;
        if (transactionHistoryFragmentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return transactionHistoryFragmentViewModel;
    }

    public void setViewModel(TransactionHistoryFragmentViewModel transactionHistoryFragmentViewModel) {
        Intrinsics.checkNotNullParameter(transactionHistoryFragmentViewModel, "<set-?>");
        this.viewModel = transactionHistoryFragmentViewModel;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        setScreen();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(com.digitalwallet.app.R.id.transactionHistoryRecyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "transactionHistoryRecyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(com.digitalwallet.app.R.id.transactionHistoryRecyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "transactionHistoryRecyclerView");
        recyclerView2.setAdapter(this.transactionInfoAdapter);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ((RecyclerView) _$_findCachedViewById(com.digitalwallet.app.R.id.transactionHistoryRecyclerView)).addItemDecoration(new CustomDividerItemDecoration(requireContext, R.drawable.transaction_history_recyclerview_divider));
        this.disposables.add(getViewModel().getFormattedTransactionHistoryList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new TransactionHistoryFragment$onViewCreated$1(this)));
        getViewModel().requestTransactionHistory();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.disposables.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            setScreen();
            getViewModel().requestTransactionHistory();
        }
    }

    private final void setScreen() {
        if (isVisible() && getUserVisibleHint()) {
            ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), ActivityAnalyticsHelper.Screen.MyServicesHistory, null, null, 6, null);
        }
    }
}
