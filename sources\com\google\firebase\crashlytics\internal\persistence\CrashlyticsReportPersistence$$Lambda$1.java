package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.io.FilenameFilter;

/* access modifiers changed from: package-private */
/* compiled from: CrashlyticsReportPersistence */
public final /* synthetic */ class CrashlyticsReportPersistence$$Lambda$1 implements FilenameFilter {
    private final String arg$1;

    private CrashlyticsReportPersistence$$Lambda$1(String str) {
        this.arg$1 = str;
    }

    public static FilenameFilter lambdaFactory$(String str) {
        return new CrashlyticsReportPersistence$$Lambda$1(str);
    }

    public boolean accept(File file, String str) {
        return str.startsWith(this.arg$1);
    }
}
