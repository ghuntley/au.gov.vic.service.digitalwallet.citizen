package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.GmsRpc;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.iid.Metadata;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public class TopicsSubscriber {
    private static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    private final Context context;
    private final FirebaseInstanceId iid;
    private final Metadata metadata;
    private final Map<String, ArrayDeque<TaskCompletionSource<Void>>> pendingOperations = new ArrayMap();
    private final GmsRpc rpc;
    private final TopicsStore store;
    private final ScheduledExecutorService syncExecutor;
    private boolean syncScheduledOrRunning = false;

    static Task<TopicsSubscriber> createInstance(FirebaseApp firebaseApp, FirebaseInstanceId firebaseInstanceId, Metadata metadata2, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi, Context context2, ScheduledExecutorService scheduledExecutorService) {
        return createInstance(firebaseInstanceId, metadata2, new GmsRpc(firebaseApp, metadata2, provider, provider2, firebaseInstallationsApi), context2, scheduledExecutorService);
    }

    static Task<TopicsSubscriber> createInstance(FirebaseInstanceId firebaseInstanceId, Metadata metadata2, GmsRpc gmsRpc, Context context2, ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new TopicsSubscriber$$Lambda$0(context2, scheduledExecutorService, firebaseInstanceId, metadata2, gmsRpc));
    }

    private TopicsSubscriber(FirebaseInstanceId firebaseInstanceId, Metadata metadata2, TopicsStore topicsStore, GmsRpc gmsRpc, Context context2, ScheduledExecutorService scheduledExecutorService) {
        this.iid = firebaseInstanceId;
        this.metadata = metadata2;
        this.store = topicsStore;
        this.rpc = gmsRpc;
        this.context = context2;
        this.syncExecutor = scheduledExecutorService;
    }

    /* access modifiers changed from: package-private */
    public Task<Void> subscribeToTopic(String str) {
        Task<Void> scheduleTopicOperation = scheduleTopicOperation(TopicOperation.subscribe(str));
        startTopicsSyncIfNecessary();
        return scheduleTopicOperation;
    }

    /* access modifiers changed from: package-private */
    public Task<Void> unsubscribeFromTopic(String str) {
        Task<Void> scheduleTopicOperation = scheduleTopicOperation(TopicOperation.unsubscribe(str));
        startTopicsSyncIfNecessary();
        return scheduleTopicOperation;
    }

    /* access modifiers changed from: package-private */
    public Task<Void> scheduleTopicOperation(TopicOperation topicOperation) {
        this.store.addTopicOperation(topicOperation);
        TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        addToPendingOperations(topicOperation, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    private void addToPendingOperations(TopicOperation topicOperation, TaskCompletionSource<Void> taskCompletionSource) {
        ArrayDeque<TaskCompletionSource<Void>> arrayDeque;
        synchronized (this.pendingOperations) {
            String serialize = topicOperation.serialize();
            if (this.pendingOperations.containsKey(serialize)) {
                arrayDeque = this.pendingOperations.get(serialize);
            } else {
                ArrayDeque<TaskCompletionSource<Void>> arrayDeque2 = new ArrayDeque<>();
                this.pendingOperations.put(serialize, arrayDeque2);
                arrayDeque = arrayDeque2;
            }
            arrayDeque.add(taskCompletionSource);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasPendingOperation() {
        return this.store.getNextTopicOperation() != null;
    }

    /* access modifiers changed from: package-private */
    public void startTopicsSyncIfNecessary() {
        if (hasPendingOperation()) {
            startSync();
        }
    }

    private void startSync() {
        if (!isSyncScheduledOrRunning()) {
            syncWithDelaySecondsInternal(0);
        }
    }

    /* access modifiers changed from: package-private */
    public void syncWithDelaySecondsInternal(long j) {
        scheduleSyncTaskWithDelaySeconds(new TopicsSyncTask(this, this.context, this.metadata, Math.min(Math.max(30L, j << 1), MAX_DELAY_SEC)), j);
        setSyncScheduledOrRunning(true);
    }

    /* access modifiers changed from: package-private */
    public void scheduleSyncTaskWithDelaySeconds(Runnable runnable, long j) {
        this.syncExecutor.schedule(runnable, j, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (performTopicOperation(r0) != false) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        return false;
     */
    public boolean syncTopics() throws IOException {
        TopicOperation nextTopicOperation;
        while (true) {
            synchronized (this) {
                nextTopicOperation = this.store.getNextTopicOperation();
                if (nextTopicOperation == null) {
                    if (isDebugLogEnabled()) {
                        Log.d(Constants.TAG, "topic sync succeeded");
                    }
                    return true;
                }
            }
            this.store.removeTopicOperation(nextTopicOperation);
            markCompletePendingOperation(nextTopicOperation);
        }
    }

    private void markCompletePendingOperation(TopicOperation topicOperation) {
        synchronized (this.pendingOperations) {
            String serialize = topicOperation.serialize();
            if (this.pendingOperations.containsKey(serialize)) {
                ArrayDeque<TaskCompletionSource<Void>> arrayDeque = this.pendingOperations.get(serialize);
                TaskCompletionSource<Void> poll = arrayDeque.poll();
                if (poll != null) {
                    poll.setResult(null);
                }
                if (arrayDeque.isEmpty()) {
                    this.pendingOperations.remove(serialize);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean performTopicOperation(TopicOperation topicOperation) throws IOException {
        try {
            String operation = topicOperation.getOperation();
            char c = 65535;
            int hashCode = operation.hashCode();
            if (hashCode != 83) {
                if (hashCode == 85) {
                    if (operation.equals("U")) {
                        c = 1;
                    }
                }
            } else if (operation.equals("S")) {
                c = 0;
            }
            if (c == 0) {
                blockingSubscribeToTopic(topicOperation.getTopic());
                if (isDebugLogEnabled()) {
                    String topic = topicOperation.getTopic();
                    StringBuilder sb = new StringBuilder(String.valueOf(topic).length() + 31);
                    sb.append("Subscribe to topic: ");
                    sb.append(topic);
                    sb.append(" succeeded.");
                    Log.d(Constants.TAG, sb.toString());
                }
            } else if (c == 1) {
                blockingUnsubscribeFromTopic(topicOperation.getTopic());
                if (isDebugLogEnabled()) {
                    String topic2 = topicOperation.getTopic();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(topic2).length() + 35);
                    sb2.append("Unsubscribe from topic: ");
                    sb2.append(topic2);
                    sb2.append(" succeeded.");
                    Log.d(Constants.TAG, sb2.toString());
                }
            } else if (isDebugLogEnabled()) {
                String valueOf = String.valueOf(topicOperation);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 24);
                sb3.append("Unknown topic operation");
                sb3.append(valueOf);
                sb3.append(".");
                Log.d(Constants.TAG, sb3.toString());
            }
            return true;
        } catch (IOException e) {
            if (GmsRpc.ERROR_SERVICE_NOT_AVAILABLE.equals(e.getMessage()) || GmsRpc.ERROR_INTERNAL_SERVER_ERROR.equals(e.getMessage())) {
                String message = e.getMessage();
                StringBuilder sb4 = new StringBuilder(String.valueOf(message).length() + 53);
                sb4.append("Topic operation failed: ");
                sb4.append(message);
                sb4.append(". Will retry Topic operation.");
                Log.e(Constants.TAG, sb4.toString());
                return false;
            } else if (e.getMessage() == null) {
                Log.e(Constants.TAG, "Topic operation failed without exception message. Will retry Topic operation.");
                return false;
            } else {
                throw e;
            }
        }
    }

    private void blockingSubscribeToTopic(String str) throws IOException {
        InstanceIdResult instanceIdResult = (InstanceIdResult) awaitTask(this.iid.getInstanceId());
        awaitTask(this.rpc.subscribeToTopic(instanceIdResult.getId(), instanceIdResult.getToken(), str));
    }

    private void blockingUnsubscribeFromTopic(String str) throws IOException {
        InstanceIdResult instanceIdResult = (InstanceIdResult) awaitTask(this.iid.getInstanceId());
        awaitTask(this.rpc.unsubscribeFromTopic(instanceIdResult.getId(), instanceIdResult.getToken(), str));
    }

    private static <T> T awaitTask(Task<T> task) throws IOException {
        try {
            return (T) Tasks.await(task, 30, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e);
            }
        } catch (InterruptedException | TimeoutException e2) {
            throw new IOException(GmsRpc.ERROR_SERVICE_NOT_AVAILABLE, e2);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean isSyncScheduledOrRunning() {
        return this.syncScheduledOrRunning;
    }

    /* access modifiers changed from: package-private */
    public synchronized void setSyncScheduledOrRunning(boolean z) {
        this.syncScheduledOrRunning = z;
    }

    static boolean isDebugLogEnabled() {
        if (!Log.isLoggable(Constants.TAG, 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable(Constants.TAG, 3);
        }
        return true;
    }

    static final /* synthetic */ TopicsSubscriber lambda$createInstance$0$TopicsSubscriber(Context context2, ScheduledExecutorService scheduledExecutorService, FirebaseInstanceId firebaseInstanceId, Metadata metadata2, GmsRpc gmsRpc) throws Exception {
        return new TopicsSubscriber(firebaseInstanceId, metadata2, TopicsStore.getInstance(context2, scheduledExecutorService), gmsRpc, context2, scheduledExecutorService);
    }
}
