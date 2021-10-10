package com.digitalwallet.utilities;

import android.app.Activity;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public final class ActivityAnalyticsHelper extends AnalyticsHelper {
    private Activity activity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityAnalyticsHelper(Activity activity2) {
        super(activity2);
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.activity = activity2;
    }

    public enum Screen {
        CardsHome(AnonymousClass1.INSTANCE),
        CardsMoreInfo(AnonymousClass2.INSTANCE),
        AddCard(AnonymousClass3.INSTANCE),
        CardDetails(AnonymousClass4.INSTANCE),
        ShowCard(AnonymousClass5.INSTANCE),
        ShowCardDisclaimer(AnonymousClass6.INSTANCE),
        SolarHomesScannerView(AnonymousClass7.INSTANCE),
        KangarooHarvesterScannerView(AnonymousClass8.INSTANCE),
        MyServicesCategory(AnonymousClass9.INSTANCE),
        MyServicesMenu(AnonymousClass10.INSTANCE),
        MyServicesHistory(AnonymousClass11.INSTANCE),
        AccountDetails(AnonymousClass12.INSTANCE),
        SettingsMenuTable(AnonymousClass13.INSTANCE),
        Pin(AnonymousClass14.INSTANCE),
        LoginHello(AnonymousClass15.INSTANCE),
        LoginServiceGroupCategories(AnonymousClass16.INSTANCE),
        LoginServiceCategoryTransactions(AnonymousClass17.INSTANCE),
        CreateAccount(AnonymousClass18.INSTANCE),
        CheckEmail(AnonymousClass19.INSTANCE),
        RegistrationSuccessful(AnonymousClass20.INSTANCE),
        Splash(AnonymousClass21.INSTANCE),
        SelectHoldings(AnonymousClass22.INSTANCE),
        SyncHoldings(AnonymousClass23.INSTANCE),
        SyncOption(AnonymousClass24.INSTANCE),
        IncomingRequest(AnonymousClass25.INSTANCE),
        AuthRequest(AnonymousClass26.INSTANCE),
        SharedHolding(AnonymousClass27.INSTANCE),
        CheckInDetailExpanded(AnonymousClass28.INSTANCE),
        CheckInOverview(AnonymousClass29.INSTANCE),
        CheckInScanner(AnonymousClass30.INSTANCE),
        CheckInInput(AnonymousClass31.INSTANCE),
        CheckInAddDependant(AnonymousClass32.INSTANCE),
        CheckInSummary(AnonymousClass33.INSTANCE),
        CheckInEditPerson(AnonymousClass34.INSTANCE),
        CheckInSuccess(AnonymousClass35.INSTANCE),
        CheckInFeedback(AnonymousClass36.INSTANCE),
        CheckInFeedbackThankYou(AnonymousClass37.INSTANCE),
        CheckInShortcut(AnonymousClass38.INSTANCE);
        
        private final Function1<String, String> getName;

        private Screen(Function1 function1) {
            this.getName = function1;
        }

        public final Function1<String, String> getGetName() {
            return this.getName;
        }
    }

    public static /* synthetic */ void setScreenName$default(ActivityAnalyticsHelper activityAnalyticsHelper, Screen screen, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        activityAnalyticsHelper.setScreenName(screen, str, str2);
    }

    public final void setScreenName(Screen screen, String str, String str2) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        String invoke = screen.getGetName().invoke(str);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, invoke);
        if (str2 == null) {
            str2 = invoke;
        }
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, str2);
        getAnalytics().logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
    }
}
