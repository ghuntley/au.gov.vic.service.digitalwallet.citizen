package com.google.firebase.crashlytics.internal.send;

import com.bumptech.glide.load.Key;
import com.google.android.datatransport.Transformer;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.nio.charset.Charset;

/* compiled from: DataTransportCrashlyticsReportSender */
final /* synthetic */ class DataTransportCrashlyticsReportSender$$Lambda$2 implements Transformer {
    private static final DataTransportCrashlyticsReportSender$$Lambda$2 instance = new DataTransportCrashlyticsReportSender$$Lambda$2();

    private DataTransportCrashlyticsReportSender$$Lambda$2() {
    }

    public static Transformer lambdaFactory$() {
        return instance;
    }

    @Override // com.google.android.datatransport.Transformer
    public Object apply(Object obj) {
        return DataTransportCrashlyticsReportSender.TRANSFORM.reportToJson((CrashlyticsReport) obj).getBytes(Charset.forName(Key.STRING_CHARSET_NAME));
    }
}
