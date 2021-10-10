package com.google.android.play.core.ktx;

import androidx.core.os.LocaleListCompat;
import androidx.fragment.app.Fragment;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import net.openid.appauth.AuthorizationRequest;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aô\u0001\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d\u001a$\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002\u001a\u001d\u0010,\u001a\u00020\u001e*\u00020-2\u0006\u0010\u0014\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010.\u001a#\u0010/\u001a\u00020\u001e*\u00020-2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH@ø\u0001\u0000¢\u0006\u0002\u00100\u001a#\u00101\u001a\u00020\u001e*\u00020-2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002020\u000eH@ø\u0001\u0000¢\u0006\u0002\u00100\u001a#\u00103\u001a\u00020\u001e*\u00020-2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002020\u000eH@ø\u0001\u0000¢\u0006\u0002\u00100\u001a#\u00104\u001a\u00020\u001e*\u00020-2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH@ø\u0001\u0000¢\u0006\u0002\u00100\u001a5\u00105\u001a\u00020\u0006*\u00020-2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH@ø\u0001\u0000¢\u0006\u0002\u00106\u001a\u0010\u00107\u001a\b\u0012\u0004\u0012\u00020\u000208*\u00020-\u001a\u001d\u00109\u001a\u00020\u0002*\u00020-2\u0006\u0010\u0014\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010.\u001a\u001b\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e*\u00020-H@ø\u0001\u0000¢\u0006\u0002\u0010;\u001a\"\u0010<\u001a\u00020\n*\u00020-2\u0006\u0010=\u001a\u00020\u00022\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0006\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0016\u0010\t\u001a\u00020\n*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\"\u0016\u0010\u0014\u001a\u00020\u0006*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\b\"\u0016\u0010\u0016\u001a\u00020\u0006*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\b\"\u0016\u0010\u0018\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006A"}, d2 = {"bytesDownloaded", "", "Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;", "getBytesDownloaded", "(Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;)J", "errorCode", "", "getErrorCode", "(Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;)I", "hasTerminalStatus", "", "getHasTerminalStatus", "(Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;)Z", "languages", "", "", "getLanguages", "(Lcom/google/android/play/core/splitinstall/SplitInstallSessionState;)Ljava/util/List;", "moduleNames", "getModuleNames", "sessionId", "getSessionId", "status", "getStatus", "totalBytesToDownload", "getTotalBytesToDownload", "SplitInstallStateUpdatedListener", "Lcom/google/android/play/core/splitinstall/SplitInstallStateUpdatedListener;", "onRequiresConfirmation", "Lkotlin/Function1;", "", "onInstalled", "onFailed", "onPending", "onDownloaded", "onDownloading", "onInstalling", "onCanceling", "onCanceled", "onNonTerminalStatus", "onTerminalStatus", "buildSplitInstallRequest", "Lcom/google/android/play/core/splitinstall/SplitInstallRequest;", "modules", "requestCancelInstall", "Lcom/google/android/play/core/splitinstall/SplitInstallManager;", "(Lcom/google/android/play/core/splitinstall/SplitInstallManager;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestDeferredInstall", "(Lcom/google/android/play/core/splitinstall/SplitInstallManager;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestDeferredLanguageInstall", "Ljava/util/Locale;", "requestDeferredLanguageUninstall", "requestDeferredUninstall", "requestInstall", "(Lcom/google/android/play/core/splitinstall/SplitInstallManager;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestProgressFlow", "Lkotlinx/coroutines/flow/Flow;", "requestSessionState", "requestSessionStates", "(Lcom/google/android/play/core/splitinstall/SplitInstallManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startConfirmationDialogForResult", "sessionState", AuthorizationRequest.ResponseMode.FRAGMENT, "Landroidx/fragment/app/Fragment;", "requestCode", "tmp.wkwm2e3_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: SplitInstallManagerKtx.kt */
public final class SplitInstallManagerKtxKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final Object requestInstall(SplitInstallManager splitInstallManager, List<String> list, List<String> list2, Continuation<? super Integer> continuation) {
        SplitInstallManagerKtxKt$requestInstall$1 splitInstallManagerKtxKt$requestInstall$1;
        int i;
        if (continuation instanceof SplitInstallManagerKtxKt$requestInstall$1) {
            splitInstallManagerKtxKt$requestInstall$1 = (SplitInstallManagerKtxKt$requestInstall$1) continuation;
            if ((splitInstallManagerKtxKt$requestInstall$1.label & Integer.MIN_VALUE) != 0) {
                splitInstallManagerKtxKt$requestInstall$1.label -= Integer.MIN_VALUE;
                Object obj = splitInstallManagerKtxKt$requestInstall$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = splitInstallManagerKtxKt$requestInstall$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Task<Integer> startInstall = splitInstallManager.startInstall(buildSplitInstallRequest(list, list2));
                    Intrinsics.checkExpressionValueIsNotNull(startInstall, "startInstall(buildSplitI…uest(modules, languages))");
                    splitInstallManagerKtxKt$requestInstall$1.L$0 = splitInstallManager;
                    splitInstallManagerKtxKt$requestInstall$1.L$1 = list;
                    splitInstallManagerKtxKt$requestInstall$1.L$2 = list2;
                    splitInstallManagerKtxKt$requestInstall$1.label = 1;
                    obj = TaskUtilsKt.runTask$default(startInstall, null, splitInstallManagerKtxKt$requestInstall$1, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    List list3 = (List) splitInstallManagerKtxKt$requestInstall$1.L$2;
                    List list4 = (List) splitInstallManagerKtxKt$requestInstall$1.L$1;
                    SplitInstallManager splitInstallManager2 = (SplitInstallManager) splitInstallManagerKtxKt$requestInstall$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Intrinsics.checkExpressionValueIsNotNull(obj, "runTask(startInstall(bui…est(modules, languages)))");
                return obj;
            }
        }
        splitInstallManagerKtxKt$requestInstall$1 = new SplitInstallManagerKtxKt$requestInstall$1(continuation);
        Object obj2 = splitInstallManagerKtxKt$requestInstall$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = splitInstallManagerKtxKt$requestInstall$1.label;
        if (i != 0) {
        }
        Intrinsics.checkExpressionValueIsNotNull(obj2, "runTask(startInstall(bui…est(modules, languages)))");
        return obj2;
    }

    public static /* synthetic */ Object requestInstall$default(SplitInstallManager splitInstallManager, List list, List list2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 2) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        return requestInstall(splitInstallManager, list, list2, continuation);
    }

    public static final Flow<SplitInstallSessionState> requestProgressFlow(SplitInstallManager splitInstallManager) {
        Intrinsics.checkParameterIsNotNull(splitInstallManager, "$this$requestProgressFlow");
        return FlowKt.buffer(FlowKt.callbackFlow(new SplitInstallManagerKtxKt$requestProgressFlow$1(splitInstallManager, null)), Integer.MAX_VALUE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final Object requestSessionStates(SplitInstallManager splitInstallManager, Continuation<? super List<? extends SplitInstallSessionState>> continuation) {
        SplitInstallManagerKtxKt$requestSessionStates$1 splitInstallManagerKtxKt$requestSessionStates$1;
        int i;
        if (continuation instanceof SplitInstallManagerKtxKt$requestSessionStates$1) {
            splitInstallManagerKtxKt$requestSessionStates$1 = (SplitInstallManagerKtxKt$requestSessionStates$1) continuation;
            if ((splitInstallManagerKtxKt$requestSessionStates$1.label & Integer.MIN_VALUE) != 0) {
                splitInstallManagerKtxKt$requestSessionStates$1.label -= Integer.MIN_VALUE;
                Object obj = splitInstallManagerKtxKt$requestSessionStates$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = splitInstallManagerKtxKt$requestSessionStates$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Task<List<SplitInstallSessionState>> sessionStates = splitInstallManager.getSessionStates();
                    Intrinsics.checkExpressionValueIsNotNull(sessionStates, "sessionStates");
                    splitInstallManagerKtxKt$requestSessionStates$1.L$0 = splitInstallManager;
                    splitInstallManagerKtxKt$requestSessionStates$1.label = 1;
                    obj = TaskUtilsKt.runTask$default(sessionStates, null, splitInstallManagerKtxKt$requestSessionStates$1, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    SplitInstallManager splitInstallManager2 = (SplitInstallManager) splitInstallManagerKtxKt$requestSessionStates$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Intrinsics.checkExpressionValueIsNotNull(obj, "runTask(sessionStates)");
                return obj;
            }
        }
        splitInstallManagerKtxKt$requestSessionStates$1 = new SplitInstallManagerKtxKt$requestSessionStates$1(continuation);
        Object obj2 = splitInstallManagerKtxKt$requestSessionStates$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = splitInstallManagerKtxKt$requestSessionStates$1.label;
        if (i != 0) {
        }
        Intrinsics.checkExpressionValueIsNotNull(obj2, "runTask(sessionStates)");
        return obj2;
    }

    public static final Object requestDeferredInstall(SplitInstallManager splitInstallManager, List<String> list, Continuation<? super Unit> continuation) {
        Task<Void> deferredInstall = splitInstallManager.deferredInstall(list);
        Intrinsics.checkExpressionValueIsNotNull(deferredInstall, "deferredInstall(moduleNames)");
        Object runTask$default = TaskUtilsKt.runTask$default(deferredInstall, null, continuation, 2, null);
        if (runTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return runTask$default;
        }
        return Unit.INSTANCE;
    }

    public static final Object requestDeferredUninstall(SplitInstallManager splitInstallManager, List<String> list, Continuation<? super Unit> continuation) {
        Task<Void> deferredInstall = splitInstallManager.deferredInstall(list);
        Intrinsics.checkExpressionValueIsNotNull(deferredInstall, "deferredInstall(moduleNames)");
        Object runTask$default = TaskUtilsKt.runTask$default(deferredInstall, null, continuation, 2, null);
        if (runTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return runTask$default;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final Object requestSessionState(SplitInstallManager splitInstallManager, int i, Continuation<? super SplitInstallSessionState> continuation) {
        SplitInstallManagerKtxKt$requestSessionState$1 splitInstallManagerKtxKt$requestSessionState$1;
        int i2;
        if (continuation instanceof SplitInstallManagerKtxKt$requestSessionState$1) {
            splitInstallManagerKtxKt$requestSessionState$1 = (SplitInstallManagerKtxKt$requestSessionState$1) continuation;
            if ((splitInstallManagerKtxKt$requestSessionState$1.label & Integer.MIN_VALUE) != 0) {
                splitInstallManagerKtxKt$requestSessionState$1.label -= Integer.MIN_VALUE;
                Object obj = splitInstallManagerKtxKt$requestSessionState$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = splitInstallManagerKtxKt$requestSessionState$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Task<SplitInstallSessionState> sessionState = splitInstallManager.getSessionState(i);
                    Intrinsics.checkExpressionValueIsNotNull(sessionState, "getSessionState(sessionId)");
                    splitInstallManagerKtxKt$requestSessionState$1.L$0 = splitInstallManager;
                    splitInstallManagerKtxKt$requestSessionState$1.I$0 = i;
                    splitInstallManagerKtxKt$requestSessionState$1.label = 1;
                    obj = TaskUtilsKt.runTask$default(sessionState, null, splitInstallManagerKtxKt$requestSessionState$1, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i2 == 1) {
                    int i3 = splitInstallManagerKtxKt$requestSessionState$1.I$0;
                    SplitInstallManager splitInstallManager2 = (SplitInstallManager) splitInstallManagerKtxKt$requestSessionState$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Intrinsics.checkExpressionValueIsNotNull(obj, "runTask(getSessionState(sessionId))");
                return obj;
            }
        }
        splitInstallManagerKtxKt$requestSessionState$1 = new SplitInstallManagerKtxKt$requestSessionState$1(continuation);
        Object obj2 = splitInstallManagerKtxKt$requestSessionState$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = splitInstallManagerKtxKt$requestSessionState$1.label;
        if (i2 != 0) {
        }
        Intrinsics.checkExpressionValueIsNotNull(obj2, "runTask(getSessionState(sessionId))");
        return obj2;
    }

    public static final Object requestCancelInstall(SplitInstallManager splitInstallManager, int i, Continuation<? super Unit> continuation) {
        Task<Void> cancelInstall = splitInstallManager.cancelInstall(i);
        Intrinsics.checkExpressionValueIsNotNull(cancelInstall, "cancelInstall(sessionId)");
        Object runTask$default = TaskUtilsKt.runTask$default(cancelInstall, null, continuation, 2, null);
        if (runTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return runTask$default;
        }
        return Unit.INSTANCE;
    }

    public static final Object requestDeferredLanguageInstall(SplitInstallManager splitInstallManager, List<Locale> list, Continuation<? super Unit> continuation) {
        Task<Void> deferredLanguageInstall = splitInstallManager.deferredLanguageInstall(list);
        Intrinsics.checkExpressionValueIsNotNull(deferredLanguageInstall, "deferredLanguageInstall(languages)");
        Object runTask$default = TaskUtilsKt.runTask$default(deferredLanguageInstall, null, continuation, 2, null);
        if (runTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return runTask$default;
        }
        return Unit.INSTANCE;
    }

    public static final Object requestDeferredLanguageUninstall(SplitInstallManager splitInstallManager, List<Locale> list, Continuation<? super Unit> continuation) {
        Task<Void> deferredLanguageUninstall = splitInstallManager.deferredLanguageUninstall(list);
        Intrinsics.checkExpressionValueIsNotNull(deferredLanguageUninstall, "deferredLanguageUninstall(languages)");
        Object runTask$default = TaskUtilsKt.runTask$default(deferredLanguageUninstall, null, continuation, 2, null);
        if (runTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return runTask$default;
        }
        return Unit.INSTANCE;
    }

    public static final int getSessionId(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$sessionId");
        return splitInstallSessionState.sessionId();
    }

    public static final int getStatus(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$status");
        return splitInstallSessionState.status();
    }

    public static final int getErrorCode(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$errorCode");
        return splitInstallSessionState.errorCode();
    }

    public static final long getBytesDownloaded(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$bytesDownloaded");
        return splitInstallSessionState.bytesDownloaded();
    }

    public static final long getTotalBytesToDownload(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$totalBytesToDownload");
        return splitInstallSessionState.totalBytesToDownload();
    }

    public static final List<String> getLanguages(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$languages");
        List<String> languages = splitInstallSessionState.languages();
        Intrinsics.checkExpressionValueIsNotNull(languages, "languages()");
        return languages;
    }

    public static final List<String> getModuleNames(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$moduleNames");
        List<String> moduleNames = splitInstallSessionState.moduleNames();
        Intrinsics.checkExpressionValueIsNotNull(moduleNames, "moduleNames()");
        return moduleNames;
    }

    public static final boolean getHasTerminalStatus(SplitInstallSessionState splitInstallSessionState) {
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "$this$hasTerminalStatus");
        return splitInstallSessionState.hasTerminalStatus();
    }

    public static /* synthetic */ SplitInstallStateUpdatedListener SplitInstallStateUpdatedListener$default(Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, Function1 function17, Function1 function18, Function1 function19, Function1 function110, Function1 function111, int i, Object obj) {
        return SplitInstallStateUpdatedListener(function1, function12, (i & 4) != 0 ? SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$1.INSTANCE : function13, (i & 8) != 0 ? SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$2.INSTANCE : function14, (i & 16) != 0 ? SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$3.INSTANCE : function15, (i & 32) != 0 ? SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$4.INSTANCE : function16, (i & 64) != 0 ? SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$5.INSTANCE : function17, (i & 128) != 0 ? SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$6.INSTANCE : function18, (i & 256) != 0 ? SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$7.INSTANCE : function19, (i & 512) != 0 ? SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$8.INSTANCE : function110, (i & 1024) != 0 ? SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$9.INSTANCE : function111);
    }

    public static final SplitInstallStateUpdatedListener SplitInstallStateUpdatedListener(Function1<? super SplitInstallSessionState, Unit> function1, Function1<? super SplitInstallSessionState, Unit> function12, Function1<? super SplitInstallSessionState, Unit> function13, Function1<? super SplitInstallSessionState, Unit> function14, Function1<? super SplitInstallSessionState, Unit> function15, Function1<? super SplitInstallSessionState, Unit> function16, Function1<? super SplitInstallSessionState, Unit> function17, Function1<? super SplitInstallSessionState, Unit> function18, Function1<? super SplitInstallSessionState, Unit> function19, Function1<? super SplitInstallSessionState, Unit> function110, Function1<? super SplitInstallSessionState, Unit> function111) {
        Intrinsics.checkParameterIsNotNull(function1, "onRequiresConfirmation");
        Intrinsics.checkParameterIsNotNull(function12, "onInstalled");
        Intrinsics.checkParameterIsNotNull(function13, "onFailed");
        Intrinsics.checkParameterIsNotNull(function14, "onPending");
        Intrinsics.checkParameterIsNotNull(function15, "onDownloaded");
        Intrinsics.checkParameterIsNotNull(function16, "onDownloading");
        Intrinsics.checkParameterIsNotNull(function17, "onInstalling");
        Intrinsics.checkParameterIsNotNull(function18, "onCanceling");
        Intrinsics.checkParameterIsNotNull(function19, "onCanceled");
        Intrinsics.checkParameterIsNotNull(function110, "onNonTerminalStatus");
        Intrinsics.checkParameterIsNotNull(function111, "onTerminalStatus");
        return new SplitInstallManagerKtxKt$SplitInstallStateUpdatedListener$10(function13, function14, function1, function16, function15, function17, function12, function18, function19, function111, function110);
    }

    public static final boolean startConfirmationDialogForResult(SplitInstallManager splitInstallManager, SplitInstallSessionState splitInstallSessionState, Fragment fragment, int i) {
        Intrinsics.checkParameterIsNotNull(splitInstallManager, "$this$startConfirmationDialogForResult");
        Intrinsics.checkParameterIsNotNull(splitInstallSessionState, "sessionState");
        Intrinsics.checkParameterIsNotNull(fragment, AuthorizationRequest.ResponseMode.FRAGMENT);
        return splitInstallManager.startConfirmationDialogForResult(splitInstallSessionState, new SplitInstallManagerKtxKt$sam$com_google_android_play_core_common_IntentSenderForResultStarter$0(new SplitInstallManagerKtxKt$startConfirmationDialogForResult$1(fragment)), i);
    }

    private static final SplitInstallRequest buildSplitInstallRequest(List<String> list, List<String> list2) {
        SplitInstallRequest.Builder newBuilder = SplitInstallRequest.newBuilder();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            newBuilder.addModule(it.next());
        }
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            newBuilder.addLanguage(LocaleListCompat.forLanguageTags(it2.next()).get(0));
        }
        SplitInstallRequest build = newBuilder.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "SplitInstallRequest.newB…lang).get(0)) }\n}.build()");
        return build;
    }
}
