package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;

public interface AnalyticsEventLogger {
    void logEvent(String str, Bundle bundle);
}
