package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: CrashlyticsReportPersistence */
final /* synthetic */ class CrashlyticsReportPersistence$$Lambda$6 implements FilenameFilter {
    private static final CrashlyticsReportPersistence$$Lambda$6 instance = new CrashlyticsReportPersistence$$Lambda$6();

    private CrashlyticsReportPersistence$$Lambda$6() {
    }

    public static FilenameFilter lambdaFactory$() {
        return instance;
    }

    public boolean accept(File file, String str) {
        return str.startsWith("event");
    }
}
