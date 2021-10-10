package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import javax.inject.Inject;

public class Uploader {
    private static final String LOG_TAG = "Uploader";
    private final BackendRegistry backendRegistry;
    private final Clock clock;
    private final Context context;
    private final EventStore eventStore;
    private final Executor executor;
    private final SynchronizationGuard guard;
    private final WorkScheduler workScheduler;

    @Inject
    public Uploader(Context context2, BackendRegistry backendRegistry2, EventStore eventStore2, WorkScheduler workScheduler2, Executor executor2, SynchronizationGuard synchronizationGuard, Clock clock2) {
        this.context = context2;
        this.backendRegistry = backendRegistry2;
        this.eventStore = eventStore2;
        this.workScheduler = workScheduler2;
        this.executor = executor2;
        this.guard = synchronizationGuard;
        this.clock = clock2;
    }

    /* access modifiers changed from: package-private */
    public boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void upload(TransportContext transportContext, int i, Runnable runnable) {
        this.executor.execute(Uploader$$Lambda$1.lambdaFactory$(this, transportContext, i, runnable));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
        r5.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r2.workScheduler.schedule(r3, r4 + 1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0024 */
    static /* synthetic */ void lambda$upload$1(Uploader uploader, TransportContext transportContext, int i, Runnable runnable) {
        SynchronizationGuard synchronizationGuard = uploader.guard;
        EventStore eventStore2 = uploader.eventStore;
        eventStore2.getClass();
        synchronizationGuard.runCriticalSection(Uploader$$Lambda$4.lambdaFactory$(eventStore2));
        if (!uploader.isNetworkAvailable()) {
            uploader.guard.runCriticalSection(Uploader$$Lambda$5.lambdaFactory$(uploader, transportContext, i));
        } else {
            uploader.logAndUpdateState(transportContext, i);
        }
        runnable.run();
    }

    /* access modifiers changed from: package-private */
    public void logAndUpdateState(TransportContext transportContext, int i) {
        BackendResponse backendResponse;
        TransportBackend transportBackend = this.backendRegistry.get(transportContext.getBackendName());
        Iterable<PersistedEvent> iterable = (Iterable) this.guard.runCriticalSection(Uploader$$Lambda$2.lambdaFactory$(this, transportContext));
        if (iterable.iterator().hasNext()) {
            if (transportBackend == null) {
                Logging.d(LOG_TAG, "Unknown backend for %s, deleting event batch for it...", transportContext);
                backendResponse = BackendResponse.fatalError();
            } else {
                ArrayList arrayList = new ArrayList();
                for (PersistedEvent persistedEvent : iterable) {
                    arrayList.add(persistedEvent.getEvent());
                }
                backendResponse = transportBackend.send(BackendRequest.builder().setEvents(arrayList).setExtras(transportContext.getExtras()).build());
            }
            this.guard.runCriticalSection(Uploader$$Lambda$3.lambdaFactory$(this, backendResponse, iterable, transportContext, i));
        }
    }

    static /* synthetic */ Object lambda$logAndUpdateState$3(Uploader uploader, BackendResponse backendResponse, Iterable iterable, TransportContext transportContext, int i) {
        if (backendResponse.getStatus() == BackendResponse.Status.TRANSIENT_ERROR) {
            uploader.eventStore.recordFailure(iterable);
            uploader.workScheduler.schedule(transportContext, i + 1);
            return null;
        }
        uploader.eventStore.recordSuccess(iterable);
        if (backendResponse.getStatus() == BackendResponse.Status.OK) {
            uploader.eventStore.recordNextCallTime(transportContext, uploader.clock.getTime() + backendResponse.getNextRequestWaitMillis());
        }
        if (!uploader.eventStore.hasPendingEventsFor(transportContext)) {
            return null;
        }
        uploader.workScheduler.schedule(transportContext, 1);
        return null;
    }
}
