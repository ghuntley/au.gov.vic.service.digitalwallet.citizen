package com.google.firebase.crashlytics.internal.report;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.BackgroundPriorityRunnable;
import com.google.firebase.crashlytics.internal.common.DataTransportState;
import com.google.firebase.crashlytics.internal.report.model.CreateReportRequest;
import com.google.firebase.crashlytics.internal.report.model.Report;
import com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReportUploader {
    private static final short[] RETRY_INTERVALS = {10, 20, 30, 60, 120, 300};
    private final CreateReportSpiCall createReportCall;
    private final DataTransportState dataTransportState;
    private final String googleAppId;
    private final HandlingExceptionCheck handlingExceptionCheck;
    private final String organizationId;
    private final ReportManager reportManager;
    private Thread uploadThread;

    public interface HandlingExceptionCheck {
        boolean isHandlingException();
    }

    public interface Provider {
        ReportUploader createReportUploader(AppSettingsData appSettingsData);
    }

    public interface ReportFilesProvider {
        File[] getCompleteSessionFiles();

        File[] getNativeReportFiles();
    }

    public ReportUploader(String str, String str2, DataTransportState dataTransportState2, ReportManager reportManager2, CreateReportSpiCall createReportSpiCall, HandlingExceptionCheck handlingExceptionCheck2) {
        if (createReportSpiCall != null) {
            this.createReportCall = createReportSpiCall;
            this.organizationId = str;
            this.googleAppId = str2;
            this.dataTransportState = dataTransportState2;
            this.reportManager = reportManager2;
            this.handlingExceptionCheck = handlingExceptionCheck2;
            return;
        }
        throw new IllegalArgumentException("createReportCall must not be null.");
    }

    public synchronized void uploadReportsAsync(List<Report> list, boolean z, float f) {
        if (this.uploadThread != null) {
            Logger.getLogger().d("Report upload has already been started.");
            return;
        }
        Thread thread = new Thread(new Worker(list, z, f), "Crashlytics Report Uploader");
        this.uploadThread = thread;
        thread.start();
    }

    /* access modifiers changed from: package-private */
    public boolean isUploading() {
        return this.uploadThread != null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    public boolean uploadReport(Report report, boolean z) {
        boolean z2;
        try {
            CreateReportRequest createReportRequest = new CreateReportRequest(this.organizationId, this.googleAppId, report);
            if (this.dataTransportState == DataTransportState.ALL) {
                Logger.getLogger().d("Report configured to be sent via DataTransport.");
            } else if (this.dataTransportState == DataTransportState.JAVA_ONLY && report.getType() == Report.Type.JAVA) {
                Logger.getLogger().d("Report configured to be sent via DataTransport.");
            } else {
                z2 = this.createReportCall.invoke(createReportRequest, z);
                Logger logger = Logger.getLogger();
                StringBuilder sb = new StringBuilder();
                sb.append("Crashlytics Reports Endpoint upload ");
                sb.append(z2 ? "complete: " : "FAILED: ");
                sb.append(report.getIdentifier());
                logger.i(sb.toString());
                if (z2) {
                    return false;
                }
                this.reportManager.deleteReport(report);
                return true;
            }
            z2 = true;
            if (z2) {
            }
        } catch (Exception e) {
            Logger.getLogger().e("Error occurred sending report " + report, e);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public class Worker extends BackgroundPriorityRunnable {
        private final boolean dataCollectionToken;
        private final float delay;
        private final List<Report> reports;

        Worker(List<Report> list, boolean z, float f) {
            this.reports = list;
            this.dataCollectionToken = z;
            this.delay = f;
        }

        @Override // com.google.firebase.crashlytics.internal.common.BackgroundPriorityRunnable
        public void onRun() {
            try {
                attemptUploadWithRetry(this.reports, this.dataCollectionToken);
            } catch (Exception e) {
                Logger.getLogger().e("An unexpected error occurred while attempting to upload crash reports.", e);
            }
            ReportUploader.this.uploadThread = null;
        }

        private void attemptUploadWithRetry(List<Report> list, boolean z) {
            Logger logger = Logger.getLogger();
            logger.d("Starting report processing in " + this.delay + " second(s)...");
            float f = this.delay;
            if (f > 0.0f) {
                try {
                    Thread.sleep((long) (f * 1000.0f));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (!ReportUploader.this.handlingExceptionCheck.isHandlingException()) {
                int i = 0;
                while (list.size() > 0 && !ReportUploader.this.handlingExceptionCheck.isHandlingException()) {
                    Logger logger2 = Logger.getLogger();
                    logger2.d("Attempting to send " + list.size() + " report(s)");
                    ArrayList arrayList = new ArrayList();
                    for (Report report : list) {
                        if (!ReportUploader.this.uploadReport(report, z)) {
                            arrayList.add(report);
                        }
                    }
                    if (arrayList.size() > 0) {
                        int i2 = i + 1;
                        long j = (long) ReportUploader.RETRY_INTERVALS[Math.min(i, ReportUploader.RETRY_INTERVALS.length - 1)];
                        Logger logger3 = Logger.getLogger();
                        logger3.d("Report submission: scheduling delayed retry in " + j + " seconds");
                        try {
                            Thread.sleep(j * 1000);
                            i = i2;
                        } catch (InterruptedException unused2) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    list = arrayList;
                }
            }
        }
    }
}
