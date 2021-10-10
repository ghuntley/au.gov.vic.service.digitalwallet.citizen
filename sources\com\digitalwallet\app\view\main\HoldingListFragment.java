package com.digitalwallet.app.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.AppStartUp;
import com.digitalwallet.app.databinding.FragmentHoldingListBinding;
import com.digitalwallet.app.holdings.HoldingExpiryPublisher;
import com.digitalwallet.app.holdings.HoldingParser;
import com.digitalwallet.app.model.HoldingType;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.services.AssetService;
import com.digitalwallet.app.utilities.CirclePagerIndicatorDecoration;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.viewmodel.main.HoldingListFragmentViewModel;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.RetrofitHelper;
import com.digitalwallet.utilities.ServerTypeKt;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jwt.SignedJWT;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequencesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001BB\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010&\u001a\u0004\u0018\u00010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130)H\u0002J!\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130)H\u0002¢\u0006\u0002\u0010-J\u0016\u0010.\u001a\u00020,2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001300H\u0002J\b\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u000202H\u0016J\u001a\u00104\u001a\u0002022\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020\u0013H\u0002J\u0010\u0010=\u001a\u0002022\u0006\u0010<\u001a\u00020\u0013H\u0002J\u0010\u0010>\u001a\u0002022\u0006\u0010<\u001a\u00020\u0013H\u0002J\u0010\u0010?\u001a\u0002022\u0006\u0010@\u001a\u00020AH\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bXD¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020!8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006C"}, d2 = {"Lcom/digitalwallet/app/view/main/HoldingListFragment;", "Lcom/digitalwallet/app/view/base/BaseAppFragment;", "Lcom/digitalwallet/app/databinding/FragmentHoldingListBinding;", "()V", "appStartUp", "Lcom/digitalwallet/app/AppStartUp;", "getAppStartUp", "()Lcom/digitalwallet/app/AppStartUp;", "setAppStartUp", "(Lcom/digitalwallet/app/AppStartUp;)V", "assetService", "Lcom/digitalwallet/app/services/AssetService;", "getAssetService", "()Lcom/digitalwallet/app/services/AssetService;", "setAssetService", "(Lcom/digitalwallet/app/services/AssetService;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "expiringHolding", "Lcom/digitalwallet/app/model/SecureHolding;", "holdingParser", "Lcom/digitalwallet/app/holdings/HoldingParser;", "getHoldingParser", "()Lcom/digitalwallet/app/holdings/HoldingParser;", "setHoldingParser", "(Lcom/digitalwallet/app/holdings/HoldingParser;)V", "layoutId", "", "getLayoutId", "()I", "pageIndicator", "Lcom/digitalwallet/app/utilities/CirclePagerIndicatorDecoration;", "viewModel", "Lcom/digitalwallet/app/viewmodel/main/HoldingListFragmentViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/main/HoldingListFragmentViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/main/HoldingListFragmentViewModel;)V", "checkForExpiringHolding", "Landroid/content/Intent;", "holdings", "", "observeRenewals", "", "Lio/reactivex/disposables/Disposable;", "(Ljava/util/List;)[Lio/reactivex/disposables/Disposable;", "observeSelectedHolding", "activeHolding", "Lio/reactivex/subjects/BehaviorSubject;", "onDestroyView", "", "onResume", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "refreshHoldings", "", "startAuthorityFragment", "selectedHolding", "startCardDetailFragment", "startCitizenFragment", "updateViewForMultipleHoldings", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "TrackingLayoutManager", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HoldingListFragment.kt */
public final class HoldingListFragment extends BaseAppFragment<FragmentHoldingListBinding> {
    private HashMap _$_findViewCache;
    @Inject
    public AppStartUp appStartUp;
    @Inject
    public AssetService assetService;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private SecureHolding expiringHolding;
    @Inject
    public HoldingParser holdingParser;
    private final int layoutId = R.layout.fragment_holding_list;
    private final CirclePagerIndicatorDecoration pageIndicator = new CirclePagerIndicatorDecoration();
    @Inject
    public HoldingListFragmentViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[AppType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AppType.CITIZEN.ordinal()] = 1;
            iArr[AppType.AUTHORITY.ordinal()] = 2;
            int[] iArr2 = new int[HoldingType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[HoldingType.ADD_A_CARD.ordinal()] = 1;
            int[] iArr3 = new int[HoldingType.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[HoldingType.AMBULANCE_VICTORIA.ordinal()] = 1;
            iArr3[HoldingType.FISHING_LICENCE.ordinal()] = 2;
            iArr3[HoldingType.SOLAR_INSTALLER.ordinal()] = 3;
            iArr3[HoldingType.KANGAROO_HARVESTER.ordinal()] = 4;
            iArr3[HoldingType.TEMPLATE.ordinal()] = 5;
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
    public HoldingListFragmentViewModel getViewModel() {
        HoldingListFragmentViewModel holdingListFragmentViewModel = this.viewModel;
        if (holdingListFragmentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return holdingListFragmentViewModel;
    }

    public void setViewModel(HoldingListFragmentViewModel holdingListFragmentViewModel) {
        Intrinsics.checkNotNullParameter(holdingListFragmentViewModel, "<set-?>");
        this.viewModel = holdingListFragmentViewModel;
    }

    public final AssetService getAssetService() {
        AssetService assetService2 = this.assetService;
        if (assetService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assetService");
        }
        return assetService2;
    }

    public final void setAssetService(AssetService assetService2) {
        Intrinsics.checkNotNullParameter(assetService2, "<set-?>");
        this.assetService = assetService2;
    }

    public final HoldingParser getHoldingParser() {
        HoldingParser holdingParser2 = this.holdingParser;
        if (holdingParser2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("holdingParser");
        }
        return holdingParser2;
    }

    public final void setHoldingParser(HoldingParser holdingParser2) {
        Intrinsics.checkNotNullParameter(holdingParser2, "<set-?>");
        this.holdingParser = holdingParser2;
    }

    public final AppStartUp getAppStartUp() {
        AppStartUp appStartUp2 = this.appStartUp;
        if (appStartUp2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appStartUp");
        }
        return appStartUp2;
    }

    public final void setAppStartUp(AppStartUp appStartUp2) {
        Intrinsics.checkNotNullParameter(appStartUp2, "<set-?>");
        this.appStartUp = appStartUp2;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(com.digitalwallet.app.R.id.cardListRecyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "cardListRecyclerView");
        recyclerView.setLayoutManager(new TrackingLayoutManager());
        new PagerSnapHelper().attachToRecyclerView((RecyclerView) _$_findCachedViewById(com.digitalwallet.app.R.id.cardListRecyclerView));
        this.disposables.add(getViewModel().getSharesRequest().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).filter(HoldingListFragment$onViewCreated$1.INSTANCE).subscribe(new HoldingListFragment$onViewCreated$2(this)));
        ((FragmentHoldingListBinding) getBinding()).downloadExistingView.setOnClickListener(new HoldingListFragment$onViewCreated$4(this));
        ((FragmentHoldingListBinding) getBinding()).moreInfoView.setOnClickListener(new HoldingListFragment$onViewCreated$5(this));
        ((FragmentHoldingListBinding) getBinding()).addCardBtn.setOnClickListener(new HoldingListFragment$onViewCreated$6(this));
        ((FragmentHoldingListBinding) getBinding()).bluetoothIndicator.setOnClickListener(new HoldingListFragment$onViewCreated$7(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        refreshHoldings();
        ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), ActivityAnalyticsHelper.Screen.CardsHome, null, null, 6, null);
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.app.view.base.BaseAppFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.disposables.clear();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(com.digitalwallet.app.R.id.cardListRecyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "cardListRecyclerView");
        recyclerView.setAdapter(null);
        _$_clearFindViewByIdCache();
    }

    /* access modifiers changed from: private */
    public final boolean refreshHoldings() {
        return this.disposables.add(getViewModel().requestAllSecureHoldings().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new HoldingListFragment$refreshHoldings$1(this)).doFinally(new HoldingListFragment$refreshHoldings$2(this)).distinct(HoldingListFragment$refreshHoldings$3.INSTANCE).doOnNext(new HoldingListFragment$refreshHoldings$4(this)).subscribe(new HoldingListFragment$refreshHoldings$5(this), new HoldingListFragment$sam$io_reactivex_functions_Consumer$0(new HoldingListFragment$refreshHoldings$6(RetrofitHelper.Companion))));
    }

    /* access modifiers changed from: private */
    public final Intent checkForExpiringHolding(List<SecureHolding> list) {
        Bundle extras;
        String string;
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.digitalwallet.app.view.main.MainActivity");
        Intent intent = ((MainActivity) activity).getIntent();
        if (intent == null || (extras = intent.getExtras()) == null || (string = extras.getString(HoldingExpiryPublisher.HOLDING_KEY, null)) == null) {
            return null;
        }
        int indexOf = SequencesKt.indexOf(SequencesKt.map(CollectionsKt.asSequence(list), HoldingListFragment$checkForExpiringHolding$1$expiringHoldingIndex$1.INSTANCE), string);
        if (indexOf >= 0) {
            this.expiringHolding = list.get(indexOf);
        }
        FragmentActivity activity2 = getActivity();
        Objects.requireNonNull(activity2, "null cannot be cast to non-null type com.digitalwallet.app.view.main.MainActivity");
        return ((MainActivity) activity2).getIntent().replaceExtras(new Bundle());
    }

    /* access modifiers changed from: private */
    public final void startCardDetailFragment(SecureHolding secureHolding) {
        int i = WhenMappings.$EnumSwitchMapping$0[ServerTypeKt.getAppType().ordinal()];
        if (i == 1) {
            startCitizenFragment(secureHolding);
        } else if (i == 2) {
            startAuthorityFragment(secureHolding);
        }
    }

    private final void startAuthorityFragment(SecureHolding secureHolding) {
        try {
            AppStartUp appStartUp2 = this.appStartUp;
            if (appStartUp2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appStartUp");
            }
            JWKSet issuerKeys = appStartUp2.getIssuerKeys();
            if (issuerKeys != null) {
                HoldingParser holdingParser2 = this.holdingParser;
                if (holdingParser2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("holdingParser");
                }
                SignedJWT parse = SignedJWT.parse(secureHolding.getJws());
                Intrinsics.checkNotNullExpressionValue(parse, "SignedJWT.parse(selectedHolding.jws)");
                if (holdingParser2.validate(parse, issuerKeys)) {
                    getAnalytics().selectContent("Authority - Start request", secureHolding.holdingTypeName(getContext()));
                    LobbyFragment newInstance = LobbyFragment.Companion.newInstance(secureHolding);
                    FragmentManager parentFragmentManager = getParentFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    List<Fragment> fragments = parentFragmentManager.getFragments();
                    Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
                    for (T t : fragments) {
                        Intrinsics.checkNotNullExpressionValue(t, "it");
                        t.setUserVisibleHint(false);
                    }
                    FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
                    Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
                    beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
                    String simpleName = Reflection.getOrCreateKotlinClass(LobbyFragment.class).getSimpleName();
                    beginTransaction.add(R.id.fragment_container_RES_2114322527, newInstance, simpleName).addToBackStack(simpleName).commit();
                    return;
                }
                throw new Exception("Invalid holding.");
            }
            throw new Exception("No issuerKeys.");
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), 0).show();
        }
    }

    private final void startCitizenFragment(SecureHolding secureHolding) {
        if (WhenMappings.$EnumSwitchMapping$1[secureHolding.getHoldingType().ordinal()] == 1) {
            AnalyticsHelper.selectContent$default(getAnalytics(), "Add card - Empty list", null, 2, null);
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            CardAddFragment cardAddFragment = new CardAddFragment(new HoldingListFragment$startCitizenFragment$1(this));
            List<Fragment> fragments = parentFragmentManager.getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
            for (T t : fragments) {
                Intrinsics.checkNotNullExpressionValue(t, "it");
                t.setUserVisibleHint(false);
            }
            FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
            String simpleName = Reflection.getOrCreateKotlinClass(CardAddFragment.class).getSimpleName();
            beginTransaction.add(R.id.fragment_container_RES_2114322527, cardAddFragment, simpleName).addToBackStack(simpleName).commit();
        } else if (secureHolding.getHoldingElements().getRealCard()) {
            getAnalytics().selectContent("View card details", secureHolding.holdingTypeName(getContext()));
            HoldingDetailFragment newInstance = HoldingDetailFragment.Companion.newInstance(secureHolding);
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            List<Fragment> fragments2 = parentFragmentManager2.getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments2, "fragments");
            for (T t2 : fragments2) {
                Intrinsics.checkNotNullExpressionValue(t2, "it");
                t2.setUserVisibleHint(false);
            }
            FragmentTransaction beginTransaction2 = parentFragmentManager2.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction2, "this.beginTransaction()");
            beginTransaction2.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
            String simpleName2 = Reflection.getOrCreateKotlinClass(HoldingDetailFragment.class).getSimpleName();
            beginTransaction2.add(R.id.fragment_container_RES_2114322527, newInstance, simpleName2).addToBackStack(simpleName2).commit();
        } else {
            throw new IllegalStateException("Holding Type request is not yet supported".toString());
        }
    }

    /* access modifiers changed from: private */
    public final Disposable[] observeRenewals(List<SecureHolding> list) {
        List<SecureHolding> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (T t : list2) {
            arrayList.add(t.getActionEmitter().subscribeOn(Schedulers.io()).subscribe(new HoldingListFragment$observeRenewals$$inlined$map$lambda$1(t, this)));
        }
        Object[] array = arrayList.toArray(new Disposable[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (Disposable[]) array;
    }

    /* access modifiers changed from: private */
    public final Disposable observeSelectedHolding(BehaviorSubject<SecureHolding> behaviorSubject) {
        Disposable subscribe = behaviorSubject.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new HoldingListFragment$sam$io_reactivex_functions_Consumer$0(new HoldingListFragment$observeSelectedHolding$1(this)));
        Intrinsics.checkNotNullExpressionValue(subscribe, "activeHolding.subscribeO…:startCardDetailFragment)");
        return subscribe;
    }

    /* access modifiers changed from: private */
    public final void updateViewForMultipleHoldings(RecyclerView recyclerView) {
        recyclerView.addItemDecoration(this.pageIndicator);
        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new HoldingListFragment$updateViewForMultipleHoldings$1(recyclerView));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/digitalwallet/app/view/main/HoldingListFragment$TrackingLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "(Lcom/digitalwallet/app/view/main/HoldingListFragment;)V", "lastPosition", "", "getLastPosition", "()I", "setLastPosition", "(I)V", "onLayoutCompleted", "", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "startSmoothScroll", "smoothScroller", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: HoldingListFragment.kt */
    private final class TrackingLayoutManager extends LinearLayoutManager {
        private int lastPosition;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public TrackingLayoutManager() {
            super(HoldingListFragment.this.getContext(), 0, false);
        }

        public final int getLastPosition() {
            return this.lastPosition;
        }

        public final void setLastPosition(int i) {
            this.lastPosition = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
        public void onLayoutCompleted(RecyclerView.State state) {
            super.onLayoutCompleted(state);
            this.lastPosition = findFirstCompletelyVisibleItemPosition();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void startSmoothScroll(RecyclerView.SmoothScroller smoothScroller) {
            String str;
            Intrinsics.checkNotNullParameter(smoothScroller, "smoothScroller");
            findFirstCompletelyVisibleItemPosition();
            super.startSmoothScroll(smoothScroller);
            int targetPosition = smoothScroller.getTargetPosition();
            RecyclerView recyclerView = (RecyclerView) HoldingListFragment.this._$_findCachedViewById(com.digitalwallet.app.R.id.cardListRecyclerView);
            Intrinsics.checkNotNullExpressionValue(recyclerView, "cardListRecyclerView");
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            Intrinsics.checkNotNull(adapter);
            Intrinsics.checkNotNullExpressionValue(adapter, "cardListRecyclerView.adapter!!");
            int itemCount = adapter.getItemCount();
            if (targetPosition >= 0 && itemCount > targetPosition) {
                int i = this.lastPosition;
                if (targetPosition > i) {
                    str = "Next";
                } else if (targetPosition < i) {
                    str = "Previous";
                } else {
                    return;
                }
                this.lastPosition = targetPosition;
                HoldingListFragment.this.getAnalytics().selectContent("Swipe card", str);
            }
        }
    }
}
