package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.io.FilenameFilter;

/* access modifiers changed from: package-private */
/* compiled from: CrashlyticsReportPersistence */
public final /* synthetic */ class CrashlyticsReportPersistence$$Lambda$3 implements FilenameFilter {
    private static final CrashlyticsReportPersistence$$Lambda$3 instance = new CrashlyticsReportPersistence$$Lambda$3();

    private CrashlyticsReportPersistence$$Lambda$3() {
    }

    public static FilenameFilter lambdaFactory$() {
        return instance;
    }

    public boolean accept(File file, String str) {
        return CrashlyticsReportPersistence.isNormalPriorityEventFile(file, str);
    }
}
