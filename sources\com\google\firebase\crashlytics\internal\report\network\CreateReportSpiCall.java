package com.google.firebase.crashlytics.internal.report.network;

import com.google.firebase.crashlytics.internal.report.model.CreateReportRequest;

public interface CreateReportSpiCall {
    boolean invoke(CreateReportRequest createReportRequest, boolean z);
}
