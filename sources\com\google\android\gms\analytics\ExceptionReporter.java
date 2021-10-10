package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.internal.gtm.zzch;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Objects;

public class ExceptionReporter implements Thread.UncaughtExceptionHandler {
    private final Thread.UncaughtExceptionHandler zzrk;
    private final Tracker zzrl;
    private final Context zzrm;
    private ExceptionParser zzrn;
    private GoogleAnalytics zzro;

    public ExceptionReporter(Tracker tracker, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        String str;
        Objects.requireNonNull(tracker, "tracker cannot be null");
        Objects.requireNonNull(context, "context cannot be null");
        this.zzrk = uncaughtExceptionHandler;
        this.zzrl = tracker;
        this.zzrn = new StandardExceptionParser(context, new ArrayList());
        this.zzrm = context.getApplicationContext();
        if (uncaughtExceptionHandler == null) {
            str = "null";
        } else {
            str = uncaughtExceptionHandler.getClass().getName();
        }
        String valueOf = String.valueOf(str);
        zzch.zzab(valueOf.length() != 0 ? "ExceptionReporter created, original handler is ".concat(valueOf) : new String("ExceptionReporter created, original handler is "));
    }

    public ExceptionParser getExceptionParser() {
        return this.zzrn;
    }

    public void setExceptionParser(ExceptionParser exceptionParser) {
        this.zzrn = exceptionParser;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String str;
        if (this.zzrn != null) {
            str = this.zzrn.getDescription(thread != null ? thread.getName() : null, th);
        } else {
            str = "UncaughtException";
        }
        String valueOf = String.valueOf(str);
        zzch.zzab(valueOf.length() != 0 ? "Reporting uncaught exception: ".concat(valueOf) : new String("Reporting uncaught exception: "));
        this.zzrl.send(new HitBuilders.ExceptionBuilder().setDescription(str).setFatal(true).build());
        if (this.zzro == null) {
            this.zzro = GoogleAnalytics.getInstance(this.zzrm);
        }
        GoogleAnalytics googleAnalytics = this.zzro;
        googleAnalytics.dispatchLocalHits();
        googleAnalytics.zzab().zzcs().zzcj();
        if (this.zzrk != null) {
            zzch.zzab("Passing exception to the original handler");
            this.zzrk.uncaughtException(thread, th);
        }
    }

    /* access modifiers changed from: package-private */
    public final Thread.UncaughtExceptionHandler zzaf() {
        return this.zzrk;
    }
}
