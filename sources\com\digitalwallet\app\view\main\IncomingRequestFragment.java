package com.digitalwallet.app.view.main;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.digitalwallet.app.BR;
import com.digitalwallet.app.connection.BLEServer;
import com.digitalwallet.app.databinding.CardBinding;
import com.digitalwallet.app.databinding.FragmentIncomingRequestBinding;
import com.digitalwallet.app.holdings.HoldingExpiryPublisher;
import com.digitalwallet.app.model.HoldingAssets;
import com.digitalwallet.app.model.HoldingRecordAttributes;
import com.digitalwallet.app.model.HoldingResponseStatus;
import com.digitalwallet.app.model.RequestHolding;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.services.AssetService;
import com.digitalwallet.app.view.base.BaseAppFragment;
import com.digitalwallet.app.viewmodel.main.sharing.IncomingRequestFragmentViewModel;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import com.digitalwallet.utilities.RetrofitHelper;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.firebase.messaging.Constants;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00016B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J&\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010 2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020(H\u0016J\b\u00103\u001a\u00020(H\u0016J\u001a\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u000101H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0017XD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00060\u0015j\u0002`\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u00020\"8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00067"}, d2 = {"Lcom/digitalwallet/app/view/main/IncomingRequestFragment;", "Lcom/digitalwallet/app/view/base/BaseAppFragment;", "Lcom/digitalwallet/app/databinding/FragmentIncomingRequestBinding;", "()V", "assetService", "Lcom/digitalwallet/app/services/AssetService;", "getAssetService", "()Lcom/digitalwallet/app/services/AssetService;", "setAssetService", "(Lcom/digitalwallet/app/services/AssetService;)V", "authorityHolding", "Lcom/digitalwallet/app/model/HoldingRecordAttributes;", "bleServer", "Lcom/digitalwallet/app/connection/BLEServer;", "getBleServer", "()Lcom/digitalwallet/app/connection/BLEServer;", "setBleServer", "(Lcom/digitalwallet/app/connection/BLEServer;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "holdingName", "", "layoutId", "", "getLayoutId", "()I", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "Ljava/util/UUID;", RequestHolding.sharingCodeKey, "Lcom/digitalwallet/app/model/SharingCode;", "sourceId", "viewGroupContainer", "Landroid/view/ViewGroup;", "viewModel", "Lcom/digitalwallet/app/viewmodel/main/sharing/IncomingRequestFragmentViewModel;", "getViewModel", "()Lcom/digitalwallet/app/viewmodel/main/sharing/IncomingRequestFragmentViewModel;", "setViewModel", "(Lcom/digitalwallet/app/viewmodel/main/sharing/IncomingRequestFragmentViewModel;)V", "bindHoldingView", "", HoldingExpiryPublisher.HOLDING_KEY, "Lcom/digitalwallet/app/model/SecureHolding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onViewCreated", Promotion.ACTION_VIEW, "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: IncomingRequestFragment.kt */
public final class IncomingRequestFragment extends BaseAppFragment<FragmentIncomingRequestBinding> {
    public static final Companion Companion = new Companion(null);
    private static final String authorityHoldingKey = "AUTHORITY_HOLDING";
    private static final String messageIdKey = "MESSAGE_ID";
    private static final String sharingCodeKey = "SHARING_CODE";
    private static final String sourceIdKey = "SOURCE_ID";
    private HashMap _$_findViewCache;
    @Inject
    public AssetService assetService;
    private HoldingRecordAttributes authorityHolding;
    @Inject
    public BLEServer bleServer;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private String holdingName = "";
    private final int layoutId = R.layout.fragment_incoming_request;
    private UUID messageId;
    private String sharingCode;
    private UUID sourceId;
    private ViewGroup viewGroupContainer;
    @Inject
    public IncomingRequestFragmentViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HoldingResponseStatus.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[HoldingResponseStatus.ACCEPTED.ordinal()] = 1;
            iArr[HoldingResponseStatus.DENIED.ordinal()] = 2;
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

    public static final /* synthetic */ HoldingRecordAttributes access$getAuthorityHolding$p(IncomingRequestFragment incomingRequestFragment) {
        HoldingRecordAttributes holdingRecordAttributes = incomingRequestFragment.authorityHolding;
        if (holdingRecordAttributes == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorityHolding");
        }
        return holdingRecordAttributes;
    }

    public static final /* synthetic */ String access$getSharingCode$p(IncomingRequestFragment incomingRequestFragment) {
        String str = incomingRequestFragment.sharingCode;
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
    public IncomingRequestFragmentViewModel getViewModel() {
        IncomingRequestFragmentViewModel incomingRequestFragmentViewModel = this.viewModel;
        if (incomingRequestFragmentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return incomingRequestFragmentViewModel;
    }

    public void setViewModel(IncomingRequestFragmentViewModel incomingRequestFragmentViewModel) {
        Intrinsics.checkNotNullParameter(incomingRequestFragmentViewModel, "<set-?>");
        this.viewModel = incomingRequestFragmentViewModel;
    }

    public final BLEServer getBleServer() {
        BLEServer bLEServer = this.bleServer;
        if (bLEServer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bleServer");
        }
        return bLEServer;
    }

    public final void setBleServer(BLEServer bLEServer) {
        Intrinsics.checkNotNullParameter(bLEServer, "<set-?>");
        this.bleServer = bLEServer;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.digitalwallet.app.view.main.IncomingRequestFragment$sam$io_reactivex_functions_Consumer$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.digitalwallet.view.base.BaseFragment, com.digitalwallet.view.base.BasicFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Parcelable parcelable = arguments.getParcelable(authorityHoldingKey);
            Intrinsics.checkNotNull(parcelable);
            this.authorityHolding = (HoldingRecordAttributes) parcelable;
            String string = arguments.getString(sharingCodeKey);
            Objects.requireNonNull(string, "null cannot be cast to non-null type com.digitalwallet.app.model.SharingCode /* = kotlin.String */");
            this.sharingCode = string;
            Serializable serializable = arguments.getSerializable(sourceIdKey);
            Objects.requireNonNull(serializable, "null cannot be cast to non-null type java.util.UUID");
            this.sourceId = (UUID) serializable;
            Serializable serializable2 = arguments.getSerializable(messageIdKey);
            Objects.requireNonNull(serializable2, "null cannot be cast to non-null type java.util.UUID");
            this.messageId = (UUID) serializable2;
        } else {
            Timber.w("Unable to parse HoldingType for fragment instance " + getArguments(), new Object[0]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("holding: ");
        HoldingRecordAttributes holdingRecordAttributes = this.authorityHolding;
        if (holdingRecordAttributes == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorityHolding");
        }
        sb.append(holdingRecordAttributes);
        Log.d("XYZ", sb.toString());
        getAnalytics().viewItem("Alert", "Incoming request");
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable[] disposableArr = new Disposable[3];
        disposableArr[0] = Completable.complete().doOnComplete(new IncomingRequestFragment$onViewCreated$2(this)).delay(2, TimeUnit.SECONDS).subscribe(IncomingRequestFragment$onViewCreated$3.INSTANCE);
        IncomingRequestFragmentViewModel viewModel2 = getViewModel();
        String str = this.sharingCode;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(RequestHolding.sharingCodeKey);
        }
        disposableArr[1] = viewModel2.fetchRequestedHolding(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new IncomingRequestFragment$onViewCreated$4(this), new IncomingRequestFragment$sam$io_reactivex_functions_Consumer$0(new IncomingRequestFragment$onViewCreated$5(RetrofitHelper.Companion)));
        Observable<HoldingResponseStatus> subscribeOn = getViewModel().getUserConsentPublisher().subscribeOn(Schedulers.io());
        IncomingRequestFragment$onViewCreated$6 incomingRequestFragment$onViewCreated$6 = IncomingRequestFragment$onViewCreated$6.INSTANCE;
        if (incomingRequestFragment$onViewCreated$6 != null) {
            incomingRequestFragment$onViewCreated$6 = new IncomingRequestFragment$sam$io_reactivex_functions_Consumer$0(incomingRequestFragment$onViewCreated$6);
        }
        disposableArr[2] = subscribeOn.doOnError((Consumer) incomingRequestFragment$onViewCreated$6).doOnNext(new IncomingRequestFragment$onViewCreated$7(this)).flatMapMaybe(new IncomingRequestFragment$onViewCreated$8(this)).doOnNext(new IncomingRequestFragment$onViewCreated$9(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new IncomingRequestFragment$onViewCreated$10(this), new IncomingRequestFragment$onViewCreated$11(this));
        compositeDisposable.addAll(disposableArr);
    }

    @Override // com.digitalwallet.view.base.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this.viewGroupContainer = viewGroup;
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ActivityAnalyticsHelper.setScreenName$default(getAnalytics(), ActivityAnalyticsHelper.Screen.IncomingRequest, null, null, 6, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.disposables.dispose();
        FragmentActivity activity = getActivity();
        if (!(activity instanceof MainActivity)) {
            activity = null;
        }
        MainActivity mainActivity = (MainActivity) activity;
        if (mainActivity != null) {
            AHBottomNavigation aHBottomNavigation = (AHBottomNavigation) mainActivity._$_findCachedViewById(com.digitalwallet.app.R.id.bottom_navigation);
            Intrinsics.checkNotNullExpressionValue(aHBottomNavigation, "parent.bottom_navigation");
            aHBottomNavigation.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public final void bindHoldingView(SecureHolding secureHolding) {
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(com.digitalwallet.app.R.id.authority_info_container);
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        ViewDataBinding inflate = DataBindingUtil.inflate(getLayoutInflater(), R.layout.card, this.viewGroupContainer, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…ontainer, false\n        )");
        CardBinding cardBinding = (CardBinding) inflate;
        ViewDataBinding inflate2 = DataBindingUtil.inflate(getLayoutInflater(), secureHolding.getHoldingElements().getFront(), cardBinding.cardContainer, true);
        inflate2.setVariable(BR.holding, secureHolding);
        inflate2.setVariable(BR.vm, secureHolding.getAttributes());
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        AssetService assetService2 = this.assetService;
        if (assetService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assetService");
        }
        inflate2.setVariable(BR.assets, new HoldingAssets(context, assetService2, secureHolding.getAssets(), null, null, 24, null));
        inflate2.executePendingBindings();
        ((FrameLayout) _$_findCachedViewById(com.digitalwallet.app.R.id.authority_info_container)).addView(cardBinding.getRoot());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0004j\u0002`\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/digitalwallet/app/view/main/IncomingRequestFragment$Companion;", "", "()V", "authorityHoldingKey", "", "messageIdKey", "sharingCodeKey", "sourceIdKey", "newInstance", "Lcom/digitalwallet/app/view/main/IncomingRequestFragment;", "authorityHolding", "Lcom/digitalwallet/app/model/HoldingRecordAttributes;", RequestHolding.sharingCodeKey, "Lcom/digitalwallet/app/model/SharingCode;", "sourceId", "Ljava/util/UUID;", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: IncomingRequestFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IncomingRequestFragment newInstance(HoldingRecordAttributes holdingRecordAttributes, String str, UUID uuid, UUID uuid2) {
            Intrinsics.checkNotNullParameter(holdingRecordAttributes, "authorityHolding");
            Intrinsics.checkNotNullParameter(str, RequestHolding.sharingCodeKey);
            Intrinsics.checkNotNullParameter(uuid, "sourceId");
            Intrinsics.checkNotNullParameter(uuid2, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
            IncomingRequestFragment incomingRequestFragment = new IncomingRequestFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(IncomingRequestFragment.authorityHoldingKey, holdingRecordAttributes);
            bundle.putString(IncomingRequestFragment.sharingCodeKey, str);
            bundle.putSerializable(IncomingRequestFragment.sourceIdKey, uuid);
            bundle.putSerializable(IncomingRequestFragment.messageIdKey, uuid2);
            Unit unit = Unit.INSTANCE;
            incomingRequestFragment.setArguments(bundle);
            return incomingRequestFragment;
        }
    }
}
