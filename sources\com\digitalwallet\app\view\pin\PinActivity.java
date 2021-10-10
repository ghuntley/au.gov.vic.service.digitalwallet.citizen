package com.digitalwallet.app.view.pin;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.FragmentManager;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.DigitalWalletApplication;
import com.digitalwallet.app.databinding.PinBinding;
import com.digitalwallet.app.holdings.HoldingExpiryPublisher;
import com.digitalwallet.app.view.base.BaseAppActivity;
import com.digitalwallet.app.view.login.LoginActivity;
import com.digitalwallet.app.view.main.MainActivity;
import com.digitalwallet.app.viewmodel.pin.AuthViewInterface;
import com.digitalwallet.app.viewmodel.pin.PinActivityViewModel;
import com.digitalwallet.utilities.ActivityAnalyticsHelper;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;

public final class PinActivity extends BaseAppActivity<PinBinding> implements AuthViewInterface {
    private static final String CALLED_FROM_CUSTOM_TABS;
    public static final Companion Companion = new Companion(null);
    public static final String PIN_ENTERED_KEY;
    private HashMap _$_findViewCache;
    private final int layoutId = R.layout.pin;
    public PinActivityViewModel viewModel;

    @Override // com.digitalwallet.app.view.base.BaseAppActivity, com.digitalwallet.view.base.BaseActivity
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.digitalwallet.app.view.base.BaseAppActivity, com.digitalwallet.view.base.BaseActivity
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

    @Override // com.digitalwallet.view.base.BaseActivity
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.digitalwallet.view.base.BaseActivity
    public PinActivityViewModel getViewModel() {
        PinActivityViewModel pinActivityViewModel = this.viewModel;
        if (pinActivityViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return pinActivityViewModel;
    }

    public void setViewModel(PinActivityViewModel pinActivityViewModel) {
        Intrinsics.checkNotNullParameter(pinActivityViewModel, "<set-?>");
        this.viewModel = pinActivityViewModel;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.digitalwallet.app.view.base.BaseAppActivity, com.digitalwallet.view.base.BaseActivity
    public void onCreate(Bundle bundle) {
        createComponent().inject(this);
        super.onCreate(bundle);
        ((PinBinding) getBinding()).pinText.setOnEditorActionListener(new PinActivity$onCreate$1(this));
        ((PinBinding) getBinding()).pinText.addTextChangedListener(new PinActivity$onCreate$2(this));
    }

    private final void updateScreen() {
        getAnalytics().setScreenName(ActivityAnalyticsHelper.Screen.Pin, getViewModel().getScreen().getRawValue(), "PinActivity");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        getViewModel().inject(this);
        if (!getViewModel().isFingerprintAuthAvailable(this) || getViewModel().getScreen() == PinActivityViewModel.PinScreen.Create) {
            showKeyboardForPin();
        } else {
            AuthViewInterface.DefaultImpls.toggleFingerprintDialog$default(this, false, 1, null);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        updateScreen();
    }

    @Override // com.digitalwallet.app.viewmodel.pin.AuthViewInterface
    public void toggleFingerprintDialog(boolean z) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (z) {
            FingerprintDialogFragment.Companion.newInstance().show(getSupportFragmentManager(), FingerprintDialogFragment.Companion.getTAG());
        } else {
            showKeyboardForPin();
        }
    }

    @Override // com.digitalwallet.app.viewmodel.pin.AuthViewInterface
    public void startMainActivity() {
        Bundle extras;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            if (!getIntent().getBooleanExtra(CALLED_FROM_CUSTOM_TABS, false)) {
                Intent intent = getIntent();
                String str = null;
                if (!(intent == null || (extras = intent.getExtras()) == null)) {
                    str = extras.getString(HoldingExpiryPublisher.HOLDING_KEY, null);
                }
                Intent intent2 = new Intent(this, MainActivity.Companion.getIntentClass());
                intent2.setFlags(67108864);
                intent2.putExtra(PIN_ENTERED_KEY, true);
                intent2.putExtra(HoldingExpiryPublisher.HOLDING_KEY, str);
                startActivity(intent2);
            }
            Application application = getApplication();
            Objects.requireNonNull(application, "null cannot be cast to non-null type com.digitalwallet.DigitalWalletApplication");
            ((DigitalWalletApplication) application).setSpawnedAnotherActivity(true);
            hideKeyboard();
            finish();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.digitalwallet.app.viewmodel.pin.AuthViewInterface
    public void startLoginActivity(boolean z) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(67108864);
            intent.putExtra(LoginActivity.PRESENT_LOGIN_SCREEN_KEY, z);
            startActivity(intent);
            hideKeyboard();
            finish();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // androidx.activity.ComponentActivity, com.digitalwallet.view.base.BaseActivity
    public void onBackPressed() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.getBackStackEntryCount() == 0) {
            moveTaskToBack(true);
        } else {
            super.onBackPressed();
        }
    }

    private final void showKeyboardForPin() {
        ((PinBinding) getBinding()).pinText.requestFocus();
        ((InputMethodManager) getSystemService(InputMethodManager.class)).showSoftInput(((PinBinding) getBinding()).pinText, 1);
    }

    private final void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(InputMethodManager.class);
        View currentFocus = getCurrentFocus();
        inputMethodManager.hideSoftInputFromWindow(currentFocus != null ? currentFocus.getWindowToken() : null, 0);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void launch$default(Companion companion, Activity activity, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            companion.launch(activity, z);
        }

        public final void launch(Activity activity, boolean z) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intent intent = new Intent(activity, PinActivity.class);
            intent.setFlags(PKIFailureInfo.duplicateCertReq);
            intent.putExtra(PinActivity.CALLED_FROM_CUSTOM_TABS, z);
            activity.startActivity(intent);
        }
    }
}
