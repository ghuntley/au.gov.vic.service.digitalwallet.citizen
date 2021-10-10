package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;

public interface AnalyticsEventReceiver {
    void onEvent(String str, Bundle bundle);
}
