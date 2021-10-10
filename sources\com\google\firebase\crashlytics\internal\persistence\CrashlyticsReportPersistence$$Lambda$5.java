package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.util.Comparator;

/* compiled from: CrashlyticsReportPersistence */
final /* synthetic */ class CrashlyticsReportPersistence$$Lambda$5 implements Comparator {
    private static final CrashlyticsReportPersistence$$Lambda$5 instance = new CrashlyticsReportPersistence$$Lambda$5();

    private CrashlyticsReportPersistence$$Lambda$5() {
    }

    public static Comparator lambdaFactory$() {
        return instance;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return ((File) obj2).getName().compareTo(((File) obj).getName());
    }
}
