package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BlockingAnalyticsEventLogger implements AnalyticsEventReceiver, AnalyticsEventLogger {
    static final String APP_EXCEPTION_EVENT_NAME = "_ae";
    private final CrashlyticsOriginAnalyticsEventLogger baseAnalyticsEventLogger;
    private boolean callbackReceived = false;
    private CountDownLatch eventLatch;
    private final Object latchLock = new Object();
    private final TimeUnit timeUnit;
    private final int timeout;

    public BlockingAnalyticsEventLogger(CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger, int i, TimeUnit timeUnit2) {
        this.baseAnalyticsEventLogger = crashlyticsOriginAnalyticsEventLogger;
        this.timeout = i;
        this.timeUnit = timeUnit2;
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger
    public void logEvent(String str, Bundle bundle) {
        synchronized (this.latchLock) {
            Logger.getLogger().d("Logging Crashlytics event to Firebase");
            this.eventLatch = new CountDownLatch(1);
            this.callbackReceived = false;
            this.baseAnalyticsEventLogger.logEvent(str, bundle);
            Logger.getLogger().d("Awaiting app exception callback from FA...");
            try {
                if (this.eventLatch.await((long) this.timeout, this.timeUnit)) {
                    this.callbackReceived = true;
                    Logger.getLogger().d("App exception callback received from FA listener.");
                } else {
                    Logger.getLogger().d("Timeout exceeded while awaiting app exception callback from FA listener.");
                }
            } catch (InterruptedException unused) {
                Logger.getLogger().d("Interrupted while awaiting app exception callback from FA listener.");
            }
            this.eventLatch = null;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver
    public void onEvent(String str, Bundle bundle) {
        CountDownLatch countDownLatch = this.eventLatch;
        if (countDownLatch != null && APP_EXCEPTION_EVENT_NAME.equals(str)) {
            countDownLatch.countDown();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isCallbackReceived() {
        return this.callbackReceived;
    }
}
