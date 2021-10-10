package com.digitalwallet.app.view.main;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.AppStartUp;
import com.digitalwallet.app.connection.BLEServer;
import com.digitalwallet.app.databinding.ActivityMainBinding;
import com.digitalwallet.app.model.P2PMessage;
import com.digitalwallet.app.model.RequestHolding;
import com.digitalwallet.app.model.SecureHolding;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jwt.SignedJWT;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u0012\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0016H\u0014J\b\u0010\u001e\u001a\u00020\u0016H\u0014J\b\u0010\u001f\u001a\u00020\u0016H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/digitalwallet/app/view/main/MainActivityServer;", "Lcom/digitalwallet/app/view/main/MainActivity;", "()V", "advertisement", "Lcom/digitalwallet/app/connection/BLEServer$Advertisement;", "bleServer", "Lcom/digitalwallet/app/connection/BLEServer;", "getBleServer", "()Lcom/digitalwallet/app/connection/BLEServer;", "setBleServer", "(Lcom/digitalwallet/app/connection/BLEServer;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "shareSubscriber", "Lio/reactivex/disposables/Disposable;", "getShareSubscriber", "()Lio/reactivex/disposables/Disposable;", "setShareSubscriber", "(Lio/reactivex/disposables/Disposable;)V", "launchCitizenSharingFragment", "", "requestInfo", "Lcom/digitalwallet/app/model/P2PMessage;", "Lcom/digitalwallet/app/model/RequestHolding;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "stopAdvertising", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: MainActivityServer.kt */
public final class MainActivityServer extends MainActivity {
    private HashMap _$_findViewCache;
    private BLEServer.Advertisement advertisement;
    @Inject
    public BLEServer bleServer;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private Disposable shareSubscriber;

    @Override // com.digitalwallet.app.view.base.BaseAppActivity, com.digitalwallet.app.view.main.MainActivity, com.digitalwallet.view.base.BaseActivity
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.digitalwallet.app.view.base.BaseAppActivity, com.digitalwallet.app.view.main.MainActivity, com.digitalwallet.view.base.BaseActivity
    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
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

    public final CompositeDisposable getDisposables() {
        return this.disposables;
    }

    public final Disposable getShareSubscriber() {
        return this.shareSubscriber;
    }

    public final void setShareSubscriber(Disposable disposable) {
        this.shareSubscriber = disposable;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.digitalwallet.app.view.base.BaseAppActivity, com.digitalwallet.app.view.main.MainActivity, com.digitalwallet.view.base.BaseActivity
    public void onCreate(Bundle bundle) {
        createComponent().inject(this);
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, com.digitalwallet.app.view.main.MainActivity
    public void onResume() {
        super.onResume();
        BLEServer bLEServer = this.bleServer;
        if (bLEServer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bleServer");
        }
        this.disposables.add(bLEServer.getLatestServerReady().timeout(10, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).doOnError(new MainActivityServer$onResume$1(this)).subscribe());
        BLEServer bLEServer2 = this.bleServer;
        if (bLEServer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bleServer");
        }
        this.disposables.add(bLEServer2.getGattServers().doOnNext(new MainActivityServer$onResume$3(this)).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new MainActivityServer$onResume$4(this)));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onPause() {
        super.onPause();
        this.disposables.clear();
        stopAdvertising();
    }

    /* access modifiers changed from: private */
    public final void stopAdvertising() {
        Disposable disposable = this.shareSubscriber;
        if (disposable != null) {
            disposable.dispose();
            this.shareSubscriber = null;
        }
        BLEServer.Advertisement advertisement2 = this.advertisement;
        if (advertisement2 != null) {
            BLEServer bLEServer = this.bleServer;
            if (bLEServer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bleServer");
            }
            bLEServer.stopAdvertising(advertisement2);
            BLEServer bLEServer2 = this.bleServer;
            if (bLEServer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bleServer");
            }
            bLEServer2.closeServer();
            this.advertisement = null;
        }
    }

    /* access modifiers changed from: private */
    public final void launchCitizenSharingFragment(P2PMessage<RequestHolding> p2PMessage) {
        JWKSet issuerKeys;
        MainActivityServer$launchCitizenSharingFragment$onInvalidIdentity$1 mainActivityServer$launchCitizenSharingFragment$onInvalidIdentity$1 = MainActivityServer$launchCitizenSharingFragment$onInvalidIdentity$1.INSTANCE;
        SignedJWT identity = p2PMessage.getBody().getContents().getIdentity();
        if (identity != null) {
            try {
                AppStartUp appStartUp = getAppStartUp();
                if (appStartUp == null || (issuerKeys = appStartUp.getIssuerKeys()) == null) {
                    throw new Exception("No issuerKeys.");
                } else if (getHoldingParser().validate(identity, issuerKeys)) {
                    SecureHolding parseHolding = getHoldingParser().parseHolding(identity);
                    if (parseHolding != null) {
                        getSupportFragmentManager().popBackStackImmediate((String) null, 1);
                        IncomingRequestFragment newInstance = IncomingRequestFragment.Companion.newInstance(parseHolding.getAttributes(), p2PMessage.getBody().getContents().getSharingCode(), p2PMessage.getHeader().getSourceID(), p2PMessage.getHeader().getMessageID());
                        FrameLayout frameLayout = ((ActivityMainBinding) getBinding()).fragmentContainer;
                        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.fragmentContainer");
                        frameLayout.setVisibility(0);
                        FragmentManager supportFragmentManager = getSupportFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                        List<Fragment> fragments = supportFragmentManager.getFragments();
                        Intrinsics.checkNotNullExpressionValue(fragments, "fragments");
                        for (T t : fragments) {
                            Intrinsics.checkNotNullExpressionValue(t, "it");
                            t.setUserVisibleHint(false);
                        }
                        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
                        beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down, R.anim.slide_in_up, R.anim.slide_out_down);
                        String simpleName = Reflection.getOrCreateKotlinClass(IncomingRequestFragment.class).getSimpleName();
                        beginTransaction.add(R.id.fragment_container_RES_2114322527, newInstance, simpleName).addToBackStack(simpleName).commit();
                        return;
                    }
                    mainActivityServer$launchCitizenSharingFragment$onInvalidIdentity$1.invoke();
                } else {
                    throw new Exception("Invalid holding.");
                }
            } catch (Exception unused) {
                mainActivityServer$launchCitizenSharingFragment$onInvalidIdentity$1.invoke();
            }
        } else {
            mainActivityServer$launchCitizenSharingFragment$onInvalidIdentity$1.invoke();
        }
    }
}
