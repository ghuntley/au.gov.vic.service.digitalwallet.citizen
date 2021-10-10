package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.Metadata;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public class FirebaseMessaging {
    @Deprecated
    public static final String INSTANCE_ID_SCOPE = "FCM";
    static TransportFactory transportFactory;
    private final AutoInit autoInit;
    private final Context context;
    private final Executor fileIoExecutor;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstanceId iid;
    private final Task<TopicsSubscriber> topicsSubscriberTask;

    public static synchronized FirebaseMessaging getInstance() {
        FirebaseMessaging instance;
        synchronized (FirebaseMessaging.class) {
            instance = getInstance(FirebaseApp.getInstance());
        }
        return instance;
    }

    static synchronized FirebaseMessaging getInstance(FirebaseApp firebaseApp2) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) firebaseApp2.get(FirebaseMessaging.class);
            Preconditions.checkNotNull(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public class AutoInit {
        private Boolean autoInitEnabled;
        private EventHandler<DataCollectionDefaultChange> dataCollectionDefaultChangeEventHandler;
        private boolean initialized;
        private final Subscriber subscriber;

        AutoInit(Subscriber subscriber2) {
            this.subscriber = subscriber2;
        }

        /* access modifiers changed from: package-private */
        public synchronized void initialize() {
            if (!this.initialized) {
                Boolean readEnabled = readEnabled();
                this.autoInitEnabled = readEnabled;
                if (readEnabled == null) {
                    FirebaseMessaging$AutoInit$$Lambda$0 firebaseMessaging$AutoInit$$Lambda$0 = new FirebaseMessaging$AutoInit$$Lambda$0(this);
                    this.dataCollectionDefaultChangeEventHandler = firebaseMessaging$AutoInit$$Lambda$0;
                    this.subscriber.subscribe(DataCollectionDefaultChange.class, firebaseMessaging$AutoInit$$Lambda$0);
                }
                this.initialized = true;
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean isEnabled() {
            initialize();
            Boolean bool = this.autoInitEnabled;
            if (bool != null) {
                return bool.booleanValue();
            }
            return FirebaseMessaging.this.firebaseApp.isDataCollectionDefaultEnabled();
        }

        /* access modifiers changed from: package-private */
        public synchronized void setEnabled(boolean z) {
            initialize();
            EventHandler<DataCollectionDefaultChange> eventHandler = this.dataCollectionDefaultChangeEventHandler;
            if (eventHandler != null) {
                this.subscriber.unsubscribe(DataCollectionDefaultChange.class, eventHandler);
                this.dataCollectionDefaultChangeEventHandler = null;
            }
            SharedPreferences.Editor edit = FirebaseMessaging.this.firebaseApp.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
            edit.putBoolean("auto_init", z);
            edit.apply();
            if (z) {
                FirebaseMessaging.this.fileIoExecutor.execute(new FirebaseMessaging$AutoInit$$Lambda$1(this));
            }
            this.autoInitEnabled = Boolean.valueOf(z);
        }

        private Boolean readEnabled() {
            ApplicationInfo applicationInfo;
            Context applicationContext = FirebaseMessaging.this.firebaseApp.getApplicationContext();
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = applicationContext.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public final /* synthetic */ void lambda$setEnabled$2$FirebaseMessaging$AutoInit() {
            FirebaseMessaging.this.iid.getToken();
        }

        /* access modifiers changed from: package-private */
        public final /* synthetic */ void lambda$initialize$1$FirebaseMessaging$AutoInit(Event event) {
            if (isEnabled()) {
                FirebaseMessaging.this.fileIoExecutor.execute(new FirebaseMessaging$AutoInit$$Lambda$2(this));
            }
        }

        /* access modifiers changed from: package-private */
        public final /* synthetic */ void lambda$initialize$0$FirebaseMessaging$AutoInit() {
            FirebaseMessaging.this.iid.getToken();
        }
    }

    FirebaseMessaging(FirebaseApp firebaseApp2, FirebaseInstanceId firebaseInstanceId, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi, TransportFactory transportFactory2, Subscriber subscriber) {
        try {
            Class.forName("com.google.firebase.iid.FirebaseInstanceIdReceiver");
            transportFactory = transportFactory2;
            this.firebaseApp = firebaseApp2;
            this.iid = firebaseInstanceId;
            this.autoInit = new AutoInit(subscriber);
            Context applicationContext = firebaseApp2.getApplicationContext();
            this.context = applicationContext;
            ScheduledExecutorService newInitExecutor = FcmExecutors.newInitExecutor();
            this.fileIoExecutor = newInitExecutor;
            newInitExecutor.execute(new FirebaseMessaging$$Lambda$0(this, firebaseInstanceId));
            Task<TopicsSubscriber> createInstance = TopicsSubscriber.createInstance(firebaseApp2, firebaseInstanceId, new Metadata(applicationContext), provider, provider2, firebaseInstallationsApi, applicationContext, FcmExecutors.newTopicsSyncExecutor());
            this.topicsSubscriberTask = createInstance;
            createInstance.addOnSuccessListener(FcmExecutors.newTopicsSyncTriggerExecutor(), new FirebaseMessaging$$Lambda$1(this));
        } catch (ClassNotFoundException unused) {
            throw new IllegalStateException("FirebaseMessaging and FirebaseInstanceId versions not compatible. Update to latest version of firebase-messaging.");
        }
    }

    public boolean isAutoInitEnabled() {
        return this.autoInit.isEnabled();
    }

    public void setAutoInitEnabled(boolean z) {
        this.autoInit.setEnabled(z);
    }

    public boolean deliveryMetricsExportToBigQueryEnabled() {
        return MessagingAnalytics.deliveryMetricsExportToBigQueryEnabled();
    }

    public void setDeliveryMetricsExportToBigQuery(boolean z) {
        MessagingAnalytics.setDeliveryMetricsExportToBigQuery(z);
    }

    public Task<String> getToken() {
        return this.iid.getInstanceId().continueWith(FirebaseMessaging$$Lambda$2.$instance);
    }

    public Task<Void> deleteToken() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FcmExecutors.newNetworkIOExecutor().execute(new FirebaseMessaging$$Lambda$3(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public Task<Void> subscribeToTopic(String str) {
        return this.topicsSubscriberTask.onSuccessTask(new FirebaseMessaging$$Lambda$4(str));
    }

    public Task<Void> unsubscribeFromTopic(String str) {
        return this.topicsSubscriberTask.onSuccessTask(new FirebaseMessaging$$Lambda$5(str));
    }

    public void send(RemoteMessage remoteMessage) {
        if (!TextUtils.isEmpty(remoteMessage.getTo())) {
            Intent intent = new Intent("com.google.android.gcm.intent.SEND");
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            intent.putExtra("app", PendingIntent.getBroadcast(this.context, 0, intent2, 0));
            intent.setPackage("com.google.android.gms");
            remoteMessage.populateSendMessageIntent(intent);
            this.context.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
            return;
        }
        throw new IllegalArgumentException("Missing 'to'");
    }

    public static TransportFactory getTransportFactory() {
        return transportFactory;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$deleteToken$3$FirebaseMessaging(TaskCompletionSource taskCompletionSource) {
        try {
            this.iid.deleteToken(Metadata.getDefaultSenderId(this.firebaseApp), INSTANCE_ID_SCOPE);
            taskCompletionSource.setResult(null);
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$new$1$FirebaseMessaging(TopicsSubscriber topicsSubscriber) {
        if (isAutoInitEnabled()) {
            topicsSubscriber.startTopicsSyncIfNecessary();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$new$0$FirebaseMessaging(FirebaseInstanceId firebaseInstanceId) {
        if (this.autoInit.isEnabled()) {
            firebaseInstanceId.getToken();
        }
    }
}
