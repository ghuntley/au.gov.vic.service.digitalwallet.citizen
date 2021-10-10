package com.digitalwallet.app.view.main;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.FragmentCardSyncBinding;
import com.digitalwallet.app.view.SetupActivity;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel;
import com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewState;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u001a\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/digitalwallet/app/view/main/CardSyncFragment;", "Lcom/digitalwallet/app/view/base/BaseAppFragment;", "Lcom/digitalwallet/app/databinding/FragmentCardSyncBinding;", "inSetup", "", "doOnStop", "Lkotlin/Function0;", "", "(ZLkotlin/jvm/functions/Function0;)V", "layoutId", "", "getLayoutId", "()I", "viewModel", "Lcom/digitalwallet/app/viewmodel/main/addsync/CardSyncViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/main/addsync/CardSyncViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/main/addsync/CardSyncViewModel;)V", "finishUp", "onResume", "onStop", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CardSyncFragment.kt */
public final class CardSyncFragment extends BaseAppFragment<FragmentCardSyncBinding> {
    private HashMap _$_findViewCache;
    private final Function0<Unit> doOnStop;
    private final boolean inSetup;
    private final int layoutId;
    @Inject
    public CardSyncViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardSyncViewState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[CardSyncViewState.UPDATE_REQUESTED.ordinal()] = 1;
            iArr[CardSyncViewState.COMPLETE.ordinal()] = 2;
            iArr[CardSyncViewState.ERROR.ordinal()] = 3;
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

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.app.view.base.BaseAppFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardSyncFragment(boolean z, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? AnonymousClass1.INSTANCE : function0);
    }

    public CardSyncFragment(boolean z, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "doOnStop");
        this.inSetup = z;
        this.doOnStop = function0;
        this.layoutId = R.layout.fragment_card_sync;
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public CardSyncViewModel getViewModel() {
        CardSyncViewModel cardSyncViewModel = this.viewModel;
        if (cardSyncViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return cardSyncViewModel;
    }

    public void setViewModel(CardSyncViewModel cardSyncViewModel) {
        Intrinsics.checkNotNullParameter(cardSyncViewModel, "<set-?>");
        this.viewModel = cardSyncViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), ActivityAnalyticsHelper.Screen.SelectHoldings, null, null, 6, null);
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        CardSyncFragment cardSyncFragment = this;
        getViewModel().getViewState().observe(cardSyncFragment, new CardSyncFragment$onViewCreated$1(this));
        getViewModel().getCardSyncList().observe(cardSyncFragment, new CardSyncFragment$onViewCreated$2(this));
        ((FragmentCardSyncBinding) getBinding()).cancelButton.setOnClickListener(new CardSyncFragment$onViewCreated$3(this));
    }

    /* access modifiers changed from: private */
    public final void finishUp() {
        SetupActivity setupActivity = null;
        if (this.inSetup) {
            getViewModel().setAutoSyncAndNickname();
            getAnalytics().viewItem("Alert", "Setup complete");
            FragmentActivity activity = getActivity();
            if (activity instanceof SetupActivity) {
                setupActivity = activity;
            }
            SetupActivity setupActivity2 = setupActivity;
            if (setupActivity2 != null) {
                setupActivity2.startMainActivity();
                return;
            }
            return;
        }
        getParentFragmentManager().popBackStack((String) null, 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.doOnStop.invoke();
    }
}
