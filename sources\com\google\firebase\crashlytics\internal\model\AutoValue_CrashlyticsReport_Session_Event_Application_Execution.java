package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution extends CrashlyticsReport.Session.Event.Application.Execution {
    private final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> binaries;
    private final CrashlyticsReport.Session.Event.Application.Execution.Exception exception;
    private final CrashlyticsReport.Session.Event.Application.Execution.Signal signal;
    private final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> threads;

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> immutableList, CrashlyticsReport.Session.Event.Application.Execution.Exception exception2, CrashlyticsReport.Session.Event.Application.Execution.Signal signal2, ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> immutableList2) {
        this.threads = immutableList;
        this.exception = exception2;
        this.signal = signal2;
        this.binaries = immutableList2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> getThreads() {
        return this.threads;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public CrashlyticsReport.Session.Event.Application.Execution.Exception getException() {
        return this.exception;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public CrashlyticsReport.Session.Event.Application.Execution.Signal getSignal() {
        return this.signal;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> getBinaries() {
        return this.binaries;
    }

    public String toString() {
        return "Execution{threads=" + this.threads + ", exception=" + this.exception + ", signal=" + this.signal + ", binaries=" + this.binaries + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution execution = (CrashlyticsReport.Session.Event.Application.Execution) obj;
        return this.threads.equals(execution.getThreads()) && this.exception.equals(execution.getException()) && this.signal.equals(execution.getSignal()) && this.binaries.equals(execution.getBinaries());
    }

    public int hashCode() {
        return ((((((this.threads.hashCode() ^ 1000003) * 1000003) ^ this.exception.hashCode()) * 1000003) ^ this.signal.hashCode()) * 1000003) ^ this.binaries.hashCode();
    }

    /* access modifiers changed from: package-private */
    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Builder {
        private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> binaries;
        private CrashlyticsReport.Session.Event.Application.Execution.Exception exception;
        private CrashlyticsReport.Session.Event.Application.Execution.Signal signal;
        private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> threads;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder setThreads(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> immutableList) {
            Objects.requireNonNull(immutableList, "Null threads");
            this.threads = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder setException(CrashlyticsReport.Session.Event.Application.Execution.Exception exception2) {
            Objects.requireNonNull(exception2, "Null exception");
            this.exception = exception2;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder setSignal(CrashlyticsReport.Session.Event.Application.Execution.Signal signal2) {
            Objects.requireNonNull(signal2, "Null signal");
            this.signal = signal2;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder setBinaries(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> immutableList) {
            Objects.requireNonNull(immutableList, "Null binaries");
            this.binaries = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution build() {
            String str = "";
            if (this.threads == null) {
                str = str + " threads";
            }
            if (this.exception == null) {
                str = str + " exception";
            }
            if (this.signal == null) {
                str = str + " signal";
            }
            if (this.binaries == null) {
                str = str + " binaries";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution(this.threads, this.exception, this.signal, this.binaries);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
