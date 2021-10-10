package com.google.firebase.crashlytics.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.SettingsCacheBehavior;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.crashlytics.internal.settings.model.AppRequestData;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.network.CreateAppSpiCall;
import com.google.firebase.crashlytics.internal.settings.network.UpdateAppSpiCall;
import java.util.concurrent.Executor;

public class Onboarding {
    static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    private final FirebaseApp app;
    private String applicationLabel;
    private final Context context;
    private DataCollectionArbiter dataCollectionArbiter;
    private IdManager idManager;
    private String installerPackageName;
    private PackageInfo packageInfo;
    private PackageManager packageManager;
    private String packageName;
    private final HttpRequestFactory requestFactory = new HttpRequestFactory();
    private String targetAndroidSdkVersion;
    private String versionCode;
    private String versionName;

    public Onboarding(FirebaseApp firebaseApp, Context context2, IdManager idManager2, DataCollectionArbiter dataCollectionArbiter2) {
        this.app = firebaseApp;
        this.context = context2;
        this.idManager = idManager2;
        this.dataCollectionArbiter = dataCollectionArbiter2;
    }

    public Context getContext() {
        return this.context;
    }

    private static String getVersion() {
        return CrashlyticsCore.getVersion();
    }

    public boolean onPreExecute() {
        String str;
        try {
            this.installerPackageName = this.idManager.getInstallerPackageName();
            this.packageManager = this.context.getPackageManager();
            String packageName2 = this.context.getPackageName();
            this.packageName = packageName2;
            PackageInfo packageInfo2 = this.packageManager.getPackageInfo(packageName2, 0);
            this.packageInfo = packageInfo2;
            this.versionCode = Integer.toString(packageInfo2.versionCode);
            if (this.packageInfo.versionName == null) {
                str = IdManager.DEFAULT_VERSION_NAME;
            } else {
                str = this.packageInfo.versionName;
            }
            this.versionName = str;
            this.applicationLabel = this.packageManager.getApplicationLabel(this.context.getApplicationInfo()).toString();
            this.targetAndroidSdkVersion = Integer.toString(this.context.getApplicationInfo().targetSdkVersion);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.getLogger().e("Failed init", e);
            return false;
        }
    }

    public void doOnboarding(final Executor executor, final SettingsController settingsController) {
        final String applicationId = this.app.getOptions().getApplicationId();
        this.dataCollectionArbiter.waitForDataCollectionPermission().onSuccessTask(executor, new SuccessContinuation<Void, AppSettingsData>() {
            /* class com.google.firebase.crashlytics.internal.Onboarding.AnonymousClass2 */

            public Task<AppSettingsData> then(Void r1) throws Exception {
                return settingsController.getAppSettings();
            }
        }).onSuccessTask(executor, new SuccessContinuation<AppSettingsData, Void>() {
            /* class com.google.firebase.crashlytics.internal.Onboarding.AnonymousClass1 */

            public Task<Void> then(AppSettingsData appSettingsData) throws Exception {
                try {
                    Onboarding.this.performAutoConfigure(appSettingsData, applicationId, settingsController, executor, true);
                    return null;
                } catch (Exception e) {
                    Logger.getLogger().e("Error performing auto configuration.", e);
                    throw e;
                }
            }
        });
    }

    public SettingsController retrieveSettingsData(Context context2, FirebaseApp firebaseApp, Executor executor) {
        SettingsController create = SettingsController.create(context2, firebaseApp.getOptions().getApplicationId(), this.idManager, this.requestFactory, this.versionCode, this.versionName, getOverridenSpiEndpoint(), this.dataCollectionArbiter);
        create.loadSettingsData(executor).continueWith(executor, new Continuation<Void, Object>() {
            /* class com.google.firebase.crashlytics.internal.Onboarding.AnonymousClass3 */

            @Override // com.google.android.gms.tasks.Continuation
            public Object then(Task<Void> task) throws Exception {
                if (task.isSuccessful()) {
                    return null;
                }
                Logger.getLogger().e("Error fetching settings.", task.getException());
                return null;
            }
        });
        return create;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void performAutoConfigure(AppSettingsData appSettingsData, String str, SettingsController settingsController, Executor executor, boolean z) {
        if (AppSettingsData.STATUS_NEW.equals(appSettingsData.status)) {
            if (performCreateApp(appSettingsData, str, z)) {
                settingsController.loadSettingsData(SettingsCacheBehavior.SKIP_CACHE_LOOKUP, executor);
            } else {
                Logger.getLogger().e("Failed to create app with Crashlytics service.", null);
            }
        } else if (AppSettingsData.STATUS_CONFIGURED.equals(appSettingsData.status)) {
            settingsController.loadSettingsData(SettingsCacheBehavior.SKIP_CACHE_LOOKUP, executor);
        } else if (appSettingsData.updateRequired) {
            Logger.getLogger().d("Server says an update is required - forcing a full App update.");
            performUpdateApp(appSettingsData, str, z);
        }
    }

    private boolean performCreateApp(AppSettingsData appSettingsData, String str, boolean z) {
        return new CreateAppSpiCall(getOverridenSpiEndpoint(), appSettingsData.url, this.requestFactory, getVersion()).invoke(buildAppRequest(appSettingsData.organizationId, str), z);
    }

    private boolean performUpdateApp(AppSettingsData appSettingsData, String str, boolean z) {
        return new UpdateAppSpiCall(getOverridenSpiEndpoint(), appSettingsData.url, this.requestFactory, getVersion()).invoke(buildAppRequest(appSettingsData.organizationId, str), z);
    }

    private AppRequestData buildAppRequest(String str, String str2) {
        return new AppRequestData(str, str2, getIdManager().getAppIdentifier(), this.versionName, this.versionCode, CommonUtils.createInstanceIdFrom(CommonUtils.getMappingFileId(getContext()), str2, this.versionName, this.versionCode), this.applicationLabel, DeliveryMechanism.determineFrom(this.installerPackageName).getId(), this.targetAndroidSdkVersion, "0");
    }

    /* access modifiers changed from: package-private */
    public String getOverridenSpiEndpoint() {
        return CommonUtils.getStringsFileValue(this.context, CRASHLYTICS_API_ENDPOINT);
    }

    private IdManager getIdManager() {
        return this.idManager;
    }
}
