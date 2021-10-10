package com.digitalwallet.app.view.main;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.connection.BLEClient;
import com.digitalwallet.app.connection.NamedDevice;
import com.digitalwallet.app.databinding.FragmentLobbyBinding;
import com.digitalwallet.app.holdings.HoldingParser;
import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.model.RequestHolding;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.view.main.adapter.LobbyAdapter;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyFragmentView;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyFragmentViewModel;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyMemberView;
import com.digitalwallet.app.viewmodel.main.sharing.LobbyViewState;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.google.android.gms.analytics.ecommerce.Promotion;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 L2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001LB\u0005¢\u0006\u0002\u0010\u0005J\u0012\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u000209H\u0016J\b\u0010=\u001a\u000209H\u0016J\b\u0010>\u001a\u000209H\u0016J\u001a\u0010?\u001a\u0002092\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J*\u0010D\u001a\u0002092 \u0010(\u001a\u001c\u0012\b\u0012\u00060\u0011j\u0002`$\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0#j\u0002`'H\u0002J\b\u0010E\u001a\u000209H\u0016J\u001c\u0010F\u001a\u0002092\n\u00101\u001a\u00060\u0011j\u0002`$2\u0006\u0010G\u001a\u00020&H\u0016J\b\u0010H\u001a\u000209H\u0016J\b\u0010I\u001a\u000209H\u0016J\b\u0010J\u001a\u000209H\u0002J\b\u0010K\u001a\u000209H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001fXD¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R_\u0010(\u001a\u001c\u0012\b\u0012\u00060\u0011j\u0002`$\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0#j\u0002`'2 \u0010\"\u001a\u001c\u0012\b\u0012\u00060\u0011j\u0002`$\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0#j\u0002`'8B@BX\u0002¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u0002038\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006M"}, d2 = {"Lcom/digitalwallet/app/view/main/LobbyFragment;", "Lcom/digitalwallet/app/view/base/BaseAppFragment;", "Lcom/digitalwallet/app/databinding/FragmentLobbyBinding;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyMemberView;", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyFragmentView;", "()V", "adapter", "Lcom/digitalwallet/app/view/main/adapter/LobbyAdapter;", "bleClient", "Lcom/digitalwallet/app/connection/BLEClient;", "getBleClient", "()Lcom/digitalwallet/app/connection/BLEClient;", "setBleClient", "(Lcom/digitalwallet/app/connection/BLEClient;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "holdingName", "", "holdingParser", "Lcom/digitalwallet/app/holdings/HoldingParser;", "getHoldingParser", "()Lcom/digitalwallet/app/holdings/HoldingParser;", "setHoldingParser", "(Lcom/digitalwallet/app/holdings/HoldingParser;)V", "holdingsService", "Lcom/digitalwallet/app/holdings/HoldingsService;", "getHoldingsService", "()Lcom/digitalwallet/app/holdings/HoldingsService;", "setHoldingsService", "(Lcom/digitalwallet/app/holdings/HoldingsService;)V", "layoutId", "", "getLayoutId", "()I", "<set-?>", "Lkotlin/Pair;", "Lcom/digitalwallet/app/model/SharingCode;", "", "Lcom/digitalwallet/app/connection/NamedDevice;", "Lcom/digitalwallet/app/connection/Lobby;", "lobby", "getLobby", "()Lkotlin/Pair;", "setLobby", "(Lkotlin/Pair;)V", "lobby$delegate", "Lkotlin/properties/ReadWriteProperty;", "scanner", "Lio/reactivex/disposables/Disposable;", RequestHolding.sharingCodeKey, "viewModel", "Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyFragmentViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyFragmentViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/main/sharing/LobbyFragmentViewModel;)V", "finish", "", "secureHolding", "Lcom/digitalwallet/app/model/SecureHolding;", "onDestroy", "onResume", "onStart", "onViewCreated", Promotion.ACTION_VIEW, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "provideVmWithInitialViewState", "requestCancelled", "requestHolding", "member", "retryRequested", "retryScan", "scan", "vibrate", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: LobbyFragment.kt */
public final class LobbyFragment extends BaseAppFragment<FragmentLobbyBinding> implements LobbyMemberView, LobbyFragmentView {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(LobbyFragment.class, "lobby", "getLobby()Lkotlin/Pair;", 0))};
    public static final Companion Companion = new Companion(null);
    private static final String secureHoldingKey = "secureHoldingKey";
    private HashMap _$_findViewCache;
    private LobbyAdapter adapter;
    @Inject
    public BLEClient bleClient;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private String holdingName;
    @Inject
    public HoldingParser holdingParser;
    @Inject
    public HoldingsService holdingsService;
    private final int layoutId = R.layout.fragment_lobby;
    private final ReadWriteProperty lobby$delegate;
    private Disposable scanner;
    private String sharingCode;
    @Inject
    public LobbyFragmentViewModel viewModel;

    /* access modifiers changed from: private */
    public final Pair<String, List<NamedDevice>> getLobby() {
        return (Pair) this.lobby$delegate.getValue(this, $$delegatedProperties[0]);
    }

    /* access modifiers changed from: private */
    public final void setLobby(Pair<String, ? extends List<NamedDevice>> pair) {
        this.lobby$delegate.setValue(this, $$delegatedProperties[0], pair);
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

    public LobbyFragment() {
        Delegates delegates = Delegates.INSTANCE;
        Pair pair = new Pair("", CollectionsKt.emptyList());
        this.lobby$delegate = new LobbyFragment$$special$$inlined$observable$1(pair, pair, this);
    }

    public static final /* synthetic */ LobbyAdapter access$getAdapter$p(LobbyFragment lobbyFragment) {
        LobbyAdapter lobbyAdapter = lobbyFragment.adapter;
        if (lobbyAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return lobbyAdapter;
    }

    public static final /* synthetic */ String access$getSharingCode$p(LobbyFragment lobbyFragment) {
        String str = lobbyFragment.sharingCode;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(RequestHolding.sharingCodeKey);
        }
        return str;
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.digitalwallet.view.base.BaseFragment
    public LobbyFragmentViewModel getViewModel() {
        LobbyFragmentViewModel lobbyFragmentViewModel = this.viewModel;
        if (lobbyFragmentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return lobbyFragmentViewModel;
    }

    public void setViewModel(LobbyFragmentViewModel lobbyFragmentViewModel) {
        Intrinsics.checkNotNullParameter(lobbyFragmentViewModel, "<set-?>");
        this.viewModel = lobbyFragmentViewModel;
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

    public final HoldingsService getHoldingsService() {
        HoldingsService holdingsService2 = this.holdingsService;
        if (holdingsService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("holdingsService");
        }
        return holdingsService2;
    }

    public final void setHoldingsService(HoldingsService holdingsService2) {
        Intrinsics.checkNotNullParameter(holdingsService2, "<set-?>");
        this.holdingsService = holdingsService2;
    }

    public final BLEClient getBleClient() {
        BLEClient bLEClient = this.bleClient;
        if (bLEClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bleClient");
        }
        return bLEClient;
    }

    public final void setBleClient(BLEClient bLEClient) {
        Intrinsics.checkNotNullParameter(bLEClient, "<set-?>");
        this.bleClient = bLEClient;
    }

    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        getViewModel().setView(this);
        Bundle arguments = getArguments();
        SecureHolding secureHolding = null;
        SecureHolding secureHolding2 = arguments != null ? (SecureHolding) arguments.getParcelable(secureHoldingKey) : null;
        if (secureHolding2 instanceof SecureHolding) {
            secureHolding = secureHolding2;
        }
        if (secureHolding != null) {
            this.holdingName = secureHolding.holdingTypeName(getContext());
            if (secureHolding.getAttributes().getSharingCode() != null) {
                this.sharingCode = secureHolding.getAttributes().getSharingCode();
                BLEClient bleClient2 = getViewModel().getBleClient();
                String str = this.sharingCode;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(RequestHolding.sharingCodeKey);
                }
                bleClient2.setSharingCode(str);
                this.adapter = new LobbyAdapter(getLobby(), this);
                String str2 = this.sharingCode;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(RequestHolding.sharingCodeKey);
                }
                setLobby(new Pair<>(str2, CollectionsKt.emptyList()));
                RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(com.digitalwallet.app.R.id.lobby_members);
                Intrinsics.checkNotNullExpressionValue(recyclerView, "lobby_members");
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
                RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(com.digitalwallet.app.R.id.lobby_members);
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "lobby_members");
                LobbyAdapter lobbyAdapter = this.adapter;
                if (lobbyAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                }
                recyclerView2.setAdapter(lobbyAdapter);
                scan();
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("Unable to parse SecureHolding for fragment instance " + getArguments());
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), ActivityAnalyticsHelper.Screen.AuthRequest, null, null, 6, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        BLEClient bLEClient = this.bleClient;
        if (bLEClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bleClient");
        }
        BLEClient.disconnectFromAllPeers$default(bLEClient, null, 1, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Disposable disposable = this.scanner;
        if (disposable != null) {
            disposable.dispose();
        }
        this.disposables.dispose();
        BLEClient bLEClient = this.bleClient;
        if (bLEClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bleClient");
        }
        bLEClient.stopScan();
        BLEClient bLEClient2 = this.bleClient;
        if (bLEClient2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bleClient");
        }
        BLEClient.disconnectFromAllPeers$default(bLEClient2, null, 1, null);
        super.onDestroy();
    }

    private final void scan() {
        AnalyticsHelper.addCount$default(getAnalytics(), "authority_scan", 1, null, 4, null);
        setLobby(new Pair<>("", CollectionsKt.emptyList()));
        provideVmWithInitialViewState(getLobby());
        Disposable disposable = this.scanner;
        if (disposable != null) {
            disposable.dispose();
        }
        BLEClient bLEClient = this.bleClient;
        if (bLEClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bleClient");
        }
        this.scanner = bLEClient.scan().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new LobbyFragment$scan$1(this), new LobbyFragment$scan$2(this));
    }

    private final void provideVmWithInitialViewState(Pair<String, ? extends List<NamedDevice>> pair) {
        LobbyViewState.Searching searching;
        if (!((Collection) pair.getSecond()).isEmpty()) {
            searching = new LobbyViewState.FoundUser();
        } else {
            searching = new LobbyViewState.Searching();
        }
        getViewModel().changeState(searching);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/view/main/LobbyFragment$Companion;", "", "()V", LobbyFragment.secureHoldingKey, "", "newInstance", "Lcom/digitalwallet/app/view/main/LobbyFragment;", "secureHolding", "Lcom/digitalwallet/app/model/SecureHolding;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: LobbyFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LobbyFragment newInstance(SecureHolding secureHolding) {
            Intrinsics.checkNotNullParameter(secureHolding, "secureHolding");
            LobbyFragment lobbyFragment = new LobbyFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(LobbyFragment.secureHoldingKey, secureHolding);
            Unit unit = Unit.INSTANCE;
            lobbyFragment.setArguments(bundle);
            return lobbyFragment;
        }
    }

    @Override // com.digitalwallet.app.viewmodel.main.sharing.LobbyMemberView
    public void requestHolding(String str, NamedDevice namedDevice) {
        Intrinsics.checkNotNullParameter(str, RequestHolding.sharingCodeKey);
        Intrinsics.checkNotNullParameter(namedDevice, "member");
        AnalyticsHelper.addCount$default(getAnalytics(), "authority_nearby_devices", getLobby().getSecond().size(), null, 4, null);
        getViewModel().requestHolding(str, namedDevice);
    }

    @Override // com.digitalwallet.app.viewmodel.main.sharing.LobbyFragmentView
    public void vibrate() {
        if (Build.VERSION.SDK_INT >= 26) {
            FragmentActivity activity = getActivity();
            if (!(activity instanceof MainActivity)) {
                activity = null;
            }
            MainActivity mainActivity = (MainActivity) activity;
            if (mainActivity != null) {
                mainActivity.vibrateForShare();
            }
        }
    }

    @Override // com.digitalwallet.app.viewmodel.main.sharing.LobbyFragmentView
    public void finish(SecureHolding secureHolding) {
        getParentFragmentManager().popBackStack(Reflection.getOrCreateKotlinClass(LobbyFragment.class).getSimpleName(), 1);
        if (secureHolding != null) {
            HoldingDetailFragment newInstance = HoldingDetailFragment.Companion.newInstance(secureHolding);
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
            String simpleName = Reflection.getOrCreateKotlinClass(HoldingDetailFragment.class).getSimpleName();
            beginTransaction.add(R.id.fragment_container_RES_2114322527, newInstance, simpleName).addToBackStack(simpleName).commit();
        }
    }

    @Override // com.digitalwallet.app.viewmodel.main.sharing.LobbyFragmentView
    public void retryRequested() {
        provideVmWithInitialViewState(getLobby());
    }

    @Override // com.digitalwallet.app.viewmodel.main.sharing.LobbyFragmentView
    public void retryScan() {
        ActivityAnalyticsHelper analytics = getAnalytics();
        String str = this.holdingName;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("holdingName");
        }
        analytics.selectContent("Authority - Rescan", str);
        scan();
    }

    @Override // com.digitalwallet.app.viewmodel.main.sharing.LobbyFragmentView
    public void requestCancelled() {
        ActivityAnalyticsHelper analytics = getAnalytics();
        String str = this.holdingName;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("holdingName");
        }
        analytics.selectContent("Authority - Cancel request", str);
        Timber.d("Request cancelled", new Object[0]);
        BLEClient bLEClient = this.bleClient;
        if (bLEClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bleClient");
        }
        BLEClient.disconnectFromAllPeers$default(bLEClient, null, 1, null);
        getParentFragmentManager().popBackStackImmediate();
    }
}
