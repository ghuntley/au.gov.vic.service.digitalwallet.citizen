package com.google.firebase.crashlytics.internal.log;

/* access modifiers changed from: package-private */
public interface FileLogStore {
    void closeLogFile();

    void deleteLogFile();

    byte[] getLogAsBytes();

    String getLogAsString();

    void writeToLog(long j, String str);
}
