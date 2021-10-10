package com.digitalwallet.app.view;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.DigitalWalletApplication;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.view.base.AppDaggerAppCompatActivity;
import com.digitalwallet.app.view.main.CardSyncFragment;
import com.digitalwallet.app.view.main.MainActivity;
import com.digitalwallet.app.view.main.NicknameCreateFragment;
import com.digitalwallet.app.view.pin.PinActivity;
import com.digitalwallet.view.util.ViewUtilsKt;
import java.util.HashMap;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\fH\u0014J\b\u0010\u0014\u001a\u00020\fH\u0014J\u0006\u0010\u0015\u001a\u00020\fR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/digitalwallet/app/view/SetupActivity;", "Lcom/digitalwallet/app/view/base/AppDaggerAppCompatActivity;", "()V", "authUtility", "Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "getAuthUtility", "()Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "setAuthUtility", "(Lcom/digitalwallet/app/oidc/AuthenticationUtility;)V", "pinEnteredForSession", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onStart", "onStop", "startMainActivity", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SetupActivity.kt */
public final class SetupActivity extends AppDaggerAppCompatActivity {
    private HashMap _$_findViewCache;
    @Inject
    public AuthenticationUtility authUtility;
    private boolean pinEnteredForSession;

    @Override // com.digitalwallet.app.view.base.AppDaggerAppCompatActivity
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.digitalwallet.app.view.base.AppDaggerAppCompatActivity
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

    public final AuthenticationUtility getAuthUtility() {
        AuthenticationUtility authenticationUtility = this.authUtility;
        if (authenticationUtility == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authUtility");
        }
        return authenticationUtility;
    }

    public final void setAuthUtility(AuthenticationUtility authenticationUtility) {
        Intrinsics.checkNotNullParameter(authenticationUtility, "<set-?>");
        this.authUtility = authenticationUtility;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.digitalwallet.app.view.base.AppDaggerAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        createComponent().inject(this);
        super.onCreate(bundle);
        DataBindingUtil.setContentView(this, R.layout.activity_setup);
        boolean z = false;
        this.pinEnteredForSession = getIntent().getBooleanExtra(PinActivity.PIN_ENTERED_KEY, false);
        AuthenticationUtility authenticationUtility = this.authUtility;
        if (authenticationUtility == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authUtility");
        }
        if (!authenticationUtility.cardSyncPreferencesSet()) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.beginTransaction()");
            beginTransaction.replace(R.id.fragment_container_RES_2114322527, new CardSyncFragment(true, null, 2, null), Reflection.getOrCreateKotlinClass(CardSyncFragment.class).getSimpleName()).commit();
            return;
        }
        AuthenticationUtility authenticationUtility2 = this.authUtility;
        if (authenticationUtility2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authUtility");
        }
        if (authenticationUtility2.getNickname().length() == 0) {
            z = true;
        }
        if (z) {
            FragmentManager supportFragmentManager2 = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "supportFragmentManager");
            FragmentTransaction beginTransaction2 = supportFragmentManager2.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction2, "this.beginTransaction()");
            beginTransaction2.replace(R.id.fragment_container_RES_2114322527, new NicknameCreateFragment(), Reflection.getOrCreateKotlinClass(NicknameCreateFragment.class).getSimpleName()).commit();
            return;
        }
        startMainActivity();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        Application application = getApplication();
        Objects.requireNonNull(application, "null cannot be cast to non-null type com.digitalwallet.DigitalWalletApplication");
        if (((DigitalWalletApplication) application).getSpawnedAnotherActivity()) {
            this.pinEnteredForSession = true;
            Application application2 = getApplication();
            Objects.requireNonNull(application2, "null cannot be cast to non-null type com.digitalwallet.DigitalWalletApplication");
            ((DigitalWalletApplication) application2).setSpawnedAnotherActivity(false);
        }
        if (!this.pinEnteredForSession) {
            PinActivity.Companion.launch$default(PinActivity.Companion, this, false, 2, null);
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStop() {
        super.onStop();
        this.pinEnteredForSession = false;
        finishActivity(0);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.pinEnteredForSession = intent.getBooleanExtra(PinActivity.PIN_ENTERED_KEY, false);
            setIntent(intent);
        }
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        ViewUtilsKt.supportBackHandlerPress(this);
    }

    public final void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.Companion.getIntentClass());
        intent.setFlags(67108864);
        intent.putExtra(PinActivity.PIN_ENTERED_KEY, this.pinEnteredForSession);
        startActivity(intent);
        finish();
    }
}
