package com.digitalwallet.check_in.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.DigitalWalletApplication;
import com.digitalwallet.check_in.di.DaggerCheckInComponent;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.view.checkIn.CheckInOverviewFragment;
import com.digitalwallet.view.checkIn.CheckInUtilsKt;
import com.digitalwallet.view.util.ViewUtilsKt;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import com.google.android.gms.instantapps.InstantApps;
import com.google.android.gms.instantapps.PackageManagerCompat;
import com.squareup.moshi.Moshi;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\u0012\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0012\u0010 \u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/digitalwallet/check_in/view/CheckInActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "getAnalytics", "()Lcom/digitalwallet/utilities/AnalyticsHelper;", "setAnalytics", "(Lcom/digitalwallet/utilities/AnalyticsHelper;)V", "checkInRepository", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "getCheckInRepository", "()Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "setCheckInRepository", "(Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;)V", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "setMoshi", "(Lcom/squareup/moshi/Moshi;)V", "handleIntent", "", "intent", "Landroid/content/Intent;", "navigate", AuthorizationRequest.ResponseMode.FRAGMENT, "Landroidx/fragment/app/Fragment;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "check_in_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInActivity.kt */
public final class CheckInActivity extends AppCompatActivity {
    @Inject
    public AnalyticsHelper analytics;
    @Inject
    public CheckInRepository checkInRepository;
    @Inject
    public Moshi moshi;

    public final Moshi getMoshi() {
        Moshi moshi2 = this.moshi;
        if (moshi2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moshi");
        }
        return moshi2;
    }

    public final void setMoshi(Moshi moshi2) {
        Intrinsics.checkNotNullParameter(moshi2, "<set-?>");
        this.moshi = moshi2;
    }

    public final AnalyticsHelper getAnalytics() {
        AnalyticsHelper analyticsHelper = this.analytics;
        if (analyticsHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analyticsHelper;
    }

    public final void setAnalytics(AnalyticsHelper analyticsHelper) {
        Intrinsics.checkNotNullParameter(analyticsHelper, "<set-?>");
        this.analytics = analyticsHelper;
    }

    public final CheckInRepository getCheckInRepository() {
        CheckInRepository checkInRepository2 = this.checkInRepository;
        if (checkInRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkInRepository");
        }
        return checkInRepository2;
    }

    public final void setCheckInRepository(CheckInRepository checkInRepository2) {
        Intrinsics.checkNotNullParameter(checkInRepository2, "<set-?>");
        this.checkInRepository = checkInRepository2;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        Context applicationContext = getApplicationContext();
        Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.digitalwallet.DigitalWalletApplication");
        DaggerCheckInComponent.factory().create(((DigitalWalletApplication) applicationContext).getBaseComponent()).inject(this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_check_in);
        handleIntent(getIntent());
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        getSupportFragmentManager().popBackStack((String) null, 1);
        handleIntent(intent);
    }

    private final void handleIntent(Intent intent) {
        String dataString;
        if (!(intent == null || (dataString = intent.getDataString()) == null)) {
            CheckInUtils.Companion companion = CheckInUtils.Companion;
            CheckInActivity checkInActivity = this;
            Moshi moshi2 = this.moshi;
            if (moshi2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("moshi");
            }
            Intrinsics.checkNotNullExpressionValue(dataString, "it");
            CheckInUtils.CheckInCode parseUrl = companion.parseUrl(checkInActivity, moshi2, dataString);
            if (parseUrl != null) {
                CheckInRepository checkInRepository2 = this.checkInRepository;
                if (checkInRepository2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("checkInRepository");
                }
                navigate(CheckInUtilsKt.getCheckInInputEntryFragment(checkInRepository2, parseUrl, false));
                return;
            }
        }
        navigate(new CheckInOverviewFragment());
    }

    private final void navigate(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_RES_2097217536, fragment).commit();
        CheckInUtils.Companion.checkGoogleApiAvailability(this);
        PackageManagerCompat packageManagerCompat = InstantApps.getPackageManagerCompat(this);
        Intrinsics.checkNotNullExpressionValue(packageManagerCompat, "InstantApps.getPackageManagerCompat(this)");
        boolean isInstantApp = packageManagerCompat.isInstantApp();
        AnalyticsHelper analyticsHelper = this.analytics;
        if (analyticsHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        analyticsHelper.setInstantApp(isInstantApp);
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        ViewUtilsKt.supportBackHandlerPress(this);
    }
}
