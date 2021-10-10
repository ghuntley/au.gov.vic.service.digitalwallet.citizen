package com.digitalwallet.app.view.main;

import android.view.View;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.FragmentCardAddBinding;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.viewmodel.main.addsync.CardAddViewModel;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/digitalwallet/app/view/main/CardAddFragment;", "Lcom/digitalwallet/app/view/base/BaseAppFragment;", "Lcom/digitalwallet/app/databinding/FragmentCardAddBinding;", "doOnFinished", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/app/viewmodel/main/addsync/CardAddViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/main/addsync/CardAddViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/main/addsync/CardAddViewModel;)V", "onResume", "", "onStart", "onStop", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CardAddFragment.kt */
public final class CardAddFragment extends BaseAppFragment<FragmentCardAddBinding> {
    private HashMap _$_findViewCache;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final Function0<Object> doOnFinished;
    private final int layoutId = R.layout.fragment_card_add;
    @Inject
    public CardAddViewModel viewModel;

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

    public CardAddFragment(Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(function0, "doOnFinished");
        this.doOnFinished = function0;
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public CardAddViewModel getViewModel() {
        CardAddViewModel cardAddViewModel = this.viewModel;
        if (cardAddViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return cardAddViewModel;
    }

    public void setViewModel(CardAddViewModel cardAddViewModel) {
        Intrinsics.checkNotNullParameter(cardAddViewModel, "<set-?>");
        this.viewModel = cardAddViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.disposables.addAll(getViewModel().getCardRequestPublisher().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CardAddFragment$onStart$1(this)), getViewModel().getGoBackEventPublisher().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CardAddFragment$onStart$2(this)));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.doOnFinished.invoke();
        this.disposables.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), ActivityAnalyticsHelper.Screen.AddCard, null, null, 6, null);
    }
}
