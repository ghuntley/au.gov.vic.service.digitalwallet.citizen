package com.digitalwallet.utilities;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.cms.CMSAttributeTableGenerator;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eJ\u001a\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000eJ\u0016\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/digitalwallet/utilities/AnalyticsHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "analytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "getAnalytics", "()Lcom/google/firebase/analytics/FirebaseAnalytics;", "setAnalytics", "(Lcom/google/firebase/analytics/FirebaseAnalytics;)V", "addCount", "", "name", "", "count", "", "itemID", "diagnosisLog", CMSAttributeTableGenerator.CONTENT_TYPE, "selectContent", "setInstantApp", "value", "", "setUserId", "viewItem", "category", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AnalyticsHelper.kt */
public class AnalyticsHelper {
    private FirebaseAnalytics analytics;

    public AnalyticsHelper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FirebaseAnalytics instance = FirebaseAnalytics.getInstance(context);
        Intrinsics.checkNotNullExpressionValue(instance, "FirebaseAnalytics.getInstance(context)");
        this.analytics = instance;
    }

    /* access modifiers changed from: protected */
    public final FirebaseAnalytics getAnalytics() {
        return this.analytics;
    }

    /* access modifiers changed from: protected */
    public final void setAnalytics(FirebaseAnalytics firebaseAnalytics) {
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "<set-?>");
        this.analytics = firebaseAnalytics;
    }

    public static /* synthetic */ void selectContent$default(AnalyticsHelper analyticsHelper, String str, String str2, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            analyticsHelper.selectContent(str, str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectContent");
    }

    public final void selectContent(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, CMSAttributeTableGenerator.CONTENT_TYPE);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, str);
        if (str2 != null) {
            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, str2);
        }
        this.analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    public final void viewItem(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "category");
        Intrinsics.checkNotNullParameter(str2, "itemID");
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, str);
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, str2);
        this.analytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM, bundle);
    }

    public final void diagnosisLog(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkNotNullParameter(str2, "itemID");
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, str);
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, str2);
        bundle.putString(FirebaseAnalytics.Param.ITEMS, str + " - " + str2);
        this.analytics.logEvent("diagnosis_log", bundle);
    }

    public static /* synthetic */ void addCount$default(AnalyticsHelper analyticsHelper, String str, int i, String str2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                str2 = null;
            }
            analyticsHelper.addCount(str, i, str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addCount");
    }

    public final void addCount(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        long j = (long) i;
        Bundle bundle = new Bundle();
        bundle.putLong("value", j);
        if (str2 != null) {
            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, str2);
        }
        this.analytics.logEvent(str, bundle);
    }

    public final void setInstantApp(boolean z) {
        this.analytics.setUserProperty("AppType", z ? "Instant" : "Standard");
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.analytics.setUserId(str);
    }
}
