package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Comparator;

/* access modifiers changed from: package-private */
/* compiled from: SessionReportingCoordinator */
public final /* synthetic */ class SessionReportingCoordinator$$Lambda$2 implements Comparator {
    private static final SessionReportingCoordinator$$Lambda$2 instance = new SessionReportingCoordinator$$Lambda$2();

    private SessionReportingCoordinator$$Lambda$2() {
    }

    public static Comparator lambdaFactory$() {
        return instance;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return ((CrashlyticsReport.CustomAttribute) obj).getKey().compareTo(((CrashlyticsReport.CustomAttribute) obj2).getKey());
    }
}
