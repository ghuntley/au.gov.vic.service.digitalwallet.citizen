package com.digitalwallet.app.view.main;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.FragmentSharingHistoryBinding;
import com.digitalwallet.app.model.db.shares.ShareRecord;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.viewmodel.main.history.SharingHistoryFragmentViewModel;
import com.digitalwallet.utilities.AppType;
import com.google.android.gms.analytics.ecommerce.Promotion;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/digitalwallet/app/view/main/SharingHistoryFragment;", "Lcom/digitalwallet/app/view/base/BaseAppFragment;", "Lcom/digitalwallet/app/databinding/FragmentSharingHistoryBinding;", "()V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/app/viewmodel/main/history/SharingHistoryFragmentViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/main/history/SharingHistoryFragmentViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/main/history/SharingHistoryFragmentViewModel;)V", "onDestroyView", "", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SharingHistoryFragment.kt */
public final class SharingHistoryFragment extends BaseAppFragment<FragmentSharingHistoryBinding> {
    private HashMap _$_findViewCache;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final int layoutId = R.layout.fragment_sharing_history;
    @Inject
    public SharingHistoryFragmentViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AppType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AppType.CITIZEN.ordinal()] = 1;
            iArr[AppType.AUTHORITY.ordinal()] = 2;
        }
    }

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

    @Override // com.digitalwallet.view.base.BaseFragment
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public SharingHistoryFragmentViewModel getViewModel() {
        SharingHistoryFragmentViewModel sharingHistoryFragmentViewModel = this.viewModel;
        if (sharingHistoryFragmentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return sharingHistoryFragmentViewModel;
    }

    public void setViewModel(SharingHistoryFragmentViewModel sharingHistoryFragmentViewModel) {
        Intrinsics.checkNotNullParameter(sharingHistoryFragmentViewModel, "<set-?>");
        this.viewModel = sharingHistoryFragmentViewModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.digitalwallet.app.view.main.SharingHistoryFragment$sam$io_reactivex_functions_Consumer$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(com.digitalwallet.app.R.id.shares_recycler_view);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "shares_recycler_view");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable[] disposableArr = new Disposable[2];
        Single<List<ShareRecord>> observeOn = getViewModel().getShares().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        SharingHistoryFragment$onViewCreated$1 sharingHistoryFragment$onViewCreated$1 = SharingHistoryFragment$onViewCreated$1.INSTANCE;
        if (sharingHistoryFragment$onViewCreated$1 != null) {
            sharingHistoryFragment$onViewCreated$1 = new SharingHistoryFragment$sam$io_reactivex_functions_Consumer$0(sharingHistoryFragment$onViewCreated$1);
        }
        disposableArr[0] = observeOn.doOnError((Consumer) sharingHistoryFragment$onViewCreated$1).onErrorReturn(SharingHistoryFragment$onViewCreated$2.INSTANCE).subscribe(new SharingHistoryFragment$onViewCreated$3(this));
        disposableArr[1] = getViewModel().getCloseViewPublisher().subscribeOn(Schedulers.io()).filter(SharingHistoryFragment$onViewCreated$4.INSTANCE).subscribe(new SharingHistoryFragment$onViewCreated$5(this));
        compositeDisposable.addAll(disposableArr);
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.app.view.base.BaseAppFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.disposables.clear();
        _$_clearFindViewByIdCache();
    }
}
