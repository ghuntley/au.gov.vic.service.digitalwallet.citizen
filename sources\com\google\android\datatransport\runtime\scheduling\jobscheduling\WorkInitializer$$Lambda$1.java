package com.google.android.datatransport.runtime.scheduling.jobscheduling;

/* access modifiers changed from: package-private */
/* compiled from: WorkInitializer */
public final /* synthetic */ class WorkInitializer$$Lambda$1 implements Runnable {
    private final WorkInitializer arg$1;

    private WorkInitializer$$Lambda$1(WorkInitializer workInitializer) {
        this.arg$1 = workInitializer;
    }

    public static Runnable lambdaFactory$(WorkInitializer workInitializer) {
        return new WorkInitializer$$Lambda$1(workInitializer);
    }

    public void run() {
        WorkInitializer workInitializer;
        workInitializer.guard.runCriticalSection(WorkInitializer$$Lambda$2.lambdaFactory$(this.arg$1));
    }
}
