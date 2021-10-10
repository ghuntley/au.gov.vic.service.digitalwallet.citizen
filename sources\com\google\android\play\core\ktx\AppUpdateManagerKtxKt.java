package com.google.android.play.core.ktx;

import android.content.IntentSender;
import androidx.fragment.app.Fragment;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.tasks.Task;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import net.openid.appauth.AuthorizationRequest;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010 \u001a\u00020\u0002*\u00020!H@ø\u0001\u0000¢\u0006\u0002\u0010\"\u001a\u0015\u0010#\u001a\u00020$*\u00020!H@ø\u0001\u0000¢\u0006\u0002\u0010\"\u001a\u0010\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&*\u00020!\u001a,\u0010(\u001a\u00020\f*\u00020!2\u0006\u0010)\u001a\u00020\u00022\b\b\u0001\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\b\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006\"\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0016\u0010\u000b\u001a\u00020\f*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0016\u0010\u000f\u001a\u00020\b*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\b*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0016\u0010\u0012\u001a\u00020\b*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\"\u0016\u0010\u0015\u001a\u00020\f*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0016\u0010\u0017\u001a\u00020\f*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016\"\u0016\u0010\u0018\u001a\u00020\u0019*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\"\u0016\u0010\u001c\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0004\"\u0016\u0010\u001c\u001a\u00020\u0001*\u00020\u00058Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0006\"\u0016\u0010\u001e\u001a\u00020\b*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"bytesDownloaded", "", "Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "getBytesDownloaded", "(Lcom/google/android/play/core/appupdate/AppUpdateInfo;)J", "Lcom/google/android/play/core/install/InstallState;", "(Lcom/google/android/play/core/install/InstallState;)J", "clientVersionStalenessDays", "", "getClientVersionStalenessDays", "(Lcom/google/android/play/core/appupdate/AppUpdateInfo;)Ljava/lang/Integer;", "hasTerminalStatus", "", "getHasTerminalStatus", "(Lcom/google/android/play/core/install/InstallState;)Z", "installErrorCode", "getInstallErrorCode", "(Lcom/google/android/play/core/install/InstallState;)I", "installStatus", "getInstallStatus", "(Lcom/google/android/play/core/appupdate/AppUpdateInfo;)I", "isFlexibleUpdateAllowed", "(Lcom/google/android/play/core/appupdate/AppUpdateInfo;)Z", "isImmediateUpdateAllowed", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "", "getPackageName", "(Lcom/google/android/play/core/install/InstallState;)Ljava/lang/String;", "totalBytesToDownload", "getTotalBytesToDownload", "updatePriority", "getUpdatePriority", "requestAppUpdateInfo", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "(Lcom/google/android/play/core/appupdate/AppUpdateManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestCompleteUpdate", "", "requestUpdateFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "startUpdateFlowForResult", "appUpdateInfo", "appUpdateType", AuthorizationRequest.ResponseMode.FRAGMENT, "Landroidx/fragment/app/Fragment;", "requestCode", "tmp.wkwm2e3_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: AppUpdateManagerKtx.kt */
public final class AppUpdateManagerKtxKt {
    public static final Flow<AppUpdateResult> requestUpdateFlow(AppUpdateManager appUpdateManager) throws InstallException {
        Intrinsics.checkParameterIsNotNull(appUpdateManager, "$this$requestUpdateFlow");
        return FlowKt.conflate(FlowKt.callbackFlow(new AppUpdateManagerKtxKt$requestUpdateFlow$1(appUpdateManager, null)));
    }

    public static final int getInstallStatus(InstallState installState) {
        Intrinsics.checkParameterIsNotNull(installState, "$this$installStatus");
        return installState.installStatus();
    }

    public static final int getInstallErrorCode(InstallState installState) {
        Intrinsics.checkParameterIsNotNull(installState, "$this$installErrorCode");
        return installState.installErrorCode();
    }

    public static final String getPackageName(InstallState installState) {
        Intrinsics.checkParameterIsNotNull(installState, "$this$packageName");
        String packageName = installState.packageName();
        Intrinsics.checkExpressionValueIsNotNull(packageName, "packageName()");
        return packageName;
    }

    public static final long getBytesDownloaded(InstallState installState) {
        Intrinsics.checkParameterIsNotNull(installState, "$this$bytesDownloaded");
        return installState.bytesDownloaded();
    }

    public static final long getTotalBytesToDownload(InstallState installState) {
        Intrinsics.checkParameterIsNotNull(installState, "$this$totalBytesToDownload");
        return installState.totalBytesToDownload();
    }

    public static final int getInstallStatus(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "$this$installStatus");
        return appUpdateInfo.installStatus();
    }

    public static final Integer getClientVersionStalenessDays(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "$this$clientVersionStalenessDays");
        return appUpdateInfo.clientVersionStalenessDays();
    }

    public static final int getUpdatePriority(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "$this$updatePriority");
        return appUpdateInfo.updatePriority();
    }

    public static final long getBytesDownloaded(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "$this$bytesDownloaded");
        return appUpdateInfo.bytesDownloaded();
    }

    public static final long getTotalBytesToDownload(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "$this$totalBytesToDownload");
        return appUpdateInfo.totalBytesToDownload();
    }

    public static final boolean isFlexibleUpdateAllowed(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "$this$isFlexibleUpdateAllowed");
        return appUpdateInfo.isUpdateTypeAllowed(0);
    }

    public static final boolean isImmediateUpdateAllowed(AppUpdateInfo appUpdateInfo) {
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "$this$isImmediateUpdateAllowed");
        return appUpdateInfo.isUpdateTypeAllowed(1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final Object requestAppUpdateInfo(AppUpdateManager appUpdateManager, Continuation<? super AppUpdateInfo> continuation) {
        AppUpdateManagerKtxKt$requestAppUpdateInfo$1 appUpdateManagerKtxKt$requestAppUpdateInfo$1;
        int i;
        if (continuation instanceof AppUpdateManagerKtxKt$requestAppUpdateInfo$1) {
            appUpdateManagerKtxKt$requestAppUpdateInfo$1 = (AppUpdateManagerKtxKt$requestAppUpdateInfo$1) continuation;
            if ((appUpdateManagerKtxKt$requestAppUpdateInfo$1.label & Integer.MIN_VALUE) != 0) {
                appUpdateManagerKtxKt$requestAppUpdateInfo$1.label -= Integer.MIN_VALUE;
                Object obj = appUpdateManagerKtxKt$requestAppUpdateInfo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = appUpdateManagerKtxKt$requestAppUpdateInfo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Task<AppUpdateInfo> appUpdateInfo = appUpdateManager.getAppUpdateInfo();
                    Intrinsics.checkExpressionValueIsNotNull(appUpdateInfo, "appUpdateInfo");
                    appUpdateManagerKtxKt$requestAppUpdateInfo$1.L$0 = appUpdateManager;
                    appUpdateManagerKtxKt$requestAppUpdateInfo$1.label = 1;
                    obj = TaskUtilsKt.runTask$default(appUpdateInfo, null, appUpdateManagerKtxKt$requestAppUpdateInfo$1, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    AppUpdateManager appUpdateManager2 = (AppUpdateManager) appUpdateManagerKtxKt$requestAppUpdateInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Intrinsics.checkExpressionValueIsNotNull(obj, "runTask(appUpdateInfo)");
                return obj;
            }
        }
        appUpdateManagerKtxKt$requestAppUpdateInfo$1 = new AppUpdateManagerKtxKt$requestAppUpdateInfo$1(continuation);
        Object obj2 = appUpdateManagerKtxKt$requestAppUpdateInfo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = appUpdateManagerKtxKt$requestAppUpdateInfo$1.label;
        if (i != 0) {
        }
        Intrinsics.checkExpressionValueIsNotNull(obj2, "runTask(appUpdateInfo)");
        return obj2;
    }

    public static final Object requestCompleteUpdate(AppUpdateManager appUpdateManager, Continuation<? super Unit> continuation) {
        Task<Void> completeUpdate = appUpdateManager.completeUpdate();
        Intrinsics.checkExpressionValueIsNotNull(completeUpdate, "completeUpdate()");
        Object runTask$default = TaskUtilsKt.runTask$default(completeUpdate, null, continuation, 2, null);
        if (runTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return runTask$default;
        }
        return Unit.INSTANCE;
    }

    public static final boolean startUpdateFlowForResult(AppUpdateManager appUpdateManager, AppUpdateInfo appUpdateInfo, int i, Fragment fragment, int i2) throws IntentSender.SendIntentException {
        Intrinsics.checkParameterIsNotNull(appUpdateManager, "$this$startUpdateFlowForResult");
        Intrinsics.checkParameterIsNotNull(appUpdateInfo, "appUpdateInfo");
        Intrinsics.checkParameterIsNotNull(fragment, AuthorizationRequest.ResponseMode.FRAGMENT);
        if (!appUpdateInfo.isUpdateTypeAllowed(i)) {
            return false;
        }
        return appUpdateManager.startUpdateFlowForResult(appUpdateInfo, i, new AppUpdateManagerKtxKt$sam$com_google_android_play_core_common_IntentSenderForResultStarter$0(new AppUpdateManagerKtxKt$startUpdateFlowForResult$1(fragment)), i2);
    }

    public static final boolean getHasTerminalStatus(InstallState installState) {
        Intrinsics.checkParameterIsNotNull(installState, "$this$hasTerminalStatus");
        int installStatus = installState.installStatus();
        return installStatus == 0 || installStatus == 11 || installStatus == 5 || installStatus == 6;
    }
}
