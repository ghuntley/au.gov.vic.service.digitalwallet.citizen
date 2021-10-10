package com.google.android.datatransport.runtime;

import com.google.android.datatransport.TransportScheduleCallback;

/* access modifiers changed from: package-private */
public interface TransportInternal {
    void send(SendRequest sendRequest, TransportScheduleCallback transportScheduleCallback);
}
