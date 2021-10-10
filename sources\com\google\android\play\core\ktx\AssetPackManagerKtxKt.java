package com.google.android.play.core.ktx;

import android.app.Activity;
import com.google.android.play.core.assetpacks.AssetLocation;
import com.google.android.play.core.assetpacks.AssetPackLocation;
import com.google.android.play.core.assetpacks.AssetPackManager;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStates;
import com.google.android.play.core.tasks.Task;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001d\u0010+\u001a\u00020\u000b*\u00020,2\u0006\u0010-\u001a\u00020.H@ø\u0001\u0000¢\u0006\u0002\u0010/\u001a#\u00100\u001a\u00020\u0017*\u00020,2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000102H@ø\u0001\u0000¢\u0006\u0002\u00103\u001a#\u00104\u001a\u00020\u0017*\u00020,2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000102H@ø\u0001\u0000¢\u0006\u0002\u00103\u001a\u001e\u00105\u001a\b\u0012\u0004\u0012\u00020\u000706*\u00020,2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000102\u001a\u001d\u00107\u001a\u000208*\u00020,2\u0006\u00109\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010:\"\u0018\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0016\u0010\n\u001a\u00020\u000b*\u00020\u00078Ç\u0002¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0016\u0010\u000e\u001a\u00020\u0001*\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0016\u0010\u0011\u001a\u00020\u0006*\u00020\u00128Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0016*\u00020\u00178Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\"\u0016\u0010\u001a\u001a\u00020\u000b*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0016\u0010\u001d\u001a\u00020\u0001*\u00020\u00128Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0004\"\u0016\u0010 \u001a\u00020\u0006*\u00020\u00128Æ\u0002¢\u0006\u0006\u001a\u0004\b!\u0010\u0014\"\u0016\u0010\"\u001a\u00020\u000b*\u00020\u00078Ç\u0002¢\u0006\u0006\u001a\u0004\b#\u0010\r\"\u0016\u0010$\u001a\u00020\u0006*\u00020\u00178Æ\u0002¢\u0006\u0006\u001a\u0004\b%\u0010&\"\u0016\u0010'\u001a\u00020\u0006*\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b(\u0010\t\"\u0016\u0010)\u001a\u00020\u000b*\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b*\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006;"}, d2 = {"assetsPath", "", "Lcom/google/android/play/core/assetpacks/AssetPackLocation;", "getAssetsPath", "(Lcom/google/android/play/core/assetpacks/AssetPackLocation;)Ljava/lang/String;", "bytesDownloaded", "", "Lcom/google/android/play/core/assetpacks/AssetPackState;", "getBytesDownloaded", "(Lcom/google/android/play/core/assetpacks/AssetPackState;)J", "errorCode", "", "getErrorCode", "(Lcom/google/android/play/core/assetpacks/AssetPackState;)I", "name", "getName", "(Lcom/google/android/play/core/assetpacks/AssetPackState;)Ljava/lang/String;", "offset", "Lcom/google/android/play/core/assetpacks/AssetLocation;", "getOffset", "(Lcom/google/android/play/core/assetpacks/AssetLocation;)J", "packStates", "", "Lcom/google/android/play/core/assetpacks/AssetPackStates;", "getPackStates", "(Lcom/google/android/play/core/assetpacks/AssetPackStates;)Ljava/util/Map;", "packStorageMethod", "getPackStorageMethod", "(Lcom/google/android/play/core/assetpacks/AssetPackLocation;)I", "path", "getPath", "(Lcom/google/android/play/core/assetpacks/AssetLocation;)Ljava/lang/String;", "size", "getSize", "status", "getStatus", "totalBytes", "getTotalBytes", "(Lcom/google/android/play/core/assetpacks/AssetPackStates;)J", "totalBytesToDownload", "getTotalBytesToDownload", "transferProgressPercentage", "getTransferProgressPercentage", "requestCellularDataConfirmation", "Lcom/google/android/play/core/assetpacks/AssetPackManager;", "activity", "Landroid/app/Activity;", "(Lcom/google/android/play/core/assetpacks/AssetPackManager;Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestFetch", "packs", "", "(Lcom/google/android/play/core/assetpacks/AssetPackManager;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestPackStates", "requestProgressFlow", "Lkotlinx/coroutines/flow/Flow;", "requestRemovePack", "", "packName", "(Lcom/google/android/play/core/assetpacks/AssetPackManager;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tmp.wkwm2e3_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: AssetPackManagerKtx.kt */
public final class AssetPackManagerKtxKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final Object requestFetch(AssetPackManager assetPackManager, List<String> list, Continuation<? super AssetPackStates> continuation) {
        AssetPackManagerKtxKt$requestFetch$1 assetPackManagerKtxKt$requestFetch$1;
        int i;
        if (continuation instanceof AssetPackManagerKtxKt$requestFetch$1) {
            assetPackManagerKtxKt$requestFetch$1 = (AssetPackManagerKtxKt$requestFetch$1) continuation;
            if ((assetPackManagerKtxKt$requestFetch$1.label & Integer.MIN_VALUE) != 0) {
                assetPackManagerKtxKt$requestFetch$1.label -= Integer.MIN_VALUE;
                Object obj = assetPackManagerKtxKt$requestFetch$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = assetPackManagerKtxKt$requestFetch$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Task<AssetPackStates> fetch = assetPackManager.fetch(list);
                    Intrinsics.checkExpressionValueIsNotNull(fetch, "fetch(packs)");
                    assetPackManagerKtxKt$requestFetch$1.L$0 = assetPackManager;
                    assetPackManagerKtxKt$requestFetch$1.L$1 = list;
                    assetPackManagerKtxKt$requestFetch$1.label = 1;
                    obj = TaskUtilsKt.runTask$default(fetch, null, assetPackManagerKtxKt$requestFetch$1, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    List list2 = (List) assetPackManagerKtxKt$requestFetch$1.L$1;
                    AssetPackManager assetPackManager2 = (AssetPackManager) assetPackManagerKtxKt$requestFetch$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Intrinsics.checkExpressionValueIsNotNull(obj, "runTask(fetch(packs))");
                return obj;
            }
        }
        assetPackManagerKtxKt$requestFetch$1 = new AssetPackManagerKtxKt$requestFetch$1(continuation);
        Object obj2 = assetPackManagerKtxKt$requestFetch$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = assetPackManagerKtxKt$requestFetch$1.label;
        if (i != 0) {
        }
        Intrinsics.checkExpressionValueIsNotNull(obj2, "runTask(fetch(packs))");
        return obj2;
    }

    public static final Flow<AssetPackState> requestProgressFlow(AssetPackManager assetPackManager, List<String> list) {
        Intrinsics.checkParameterIsNotNull(assetPackManager, "$this$requestProgressFlow");
        Intrinsics.checkParameterIsNotNull(list, "packs");
        return FlowKt.buffer(FlowKt.callbackFlow(new AssetPackManagerKtxKt$requestProgressFlow$1(assetPackManager, list, null)), Integer.MAX_VALUE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final Object requestPackStates(AssetPackManager assetPackManager, List<String> list, Continuation<? super AssetPackStates> continuation) {
        AssetPackManagerKtxKt$requestPackStates$1 assetPackManagerKtxKt$requestPackStates$1;
        int i;
        if (continuation instanceof AssetPackManagerKtxKt$requestPackStates$1) {
            assetPackManagerKtxKt$requestPackStates$1 = (AssetPackManagerKtxKt$requestPackStates$1) continuation;
            if ((assetPackManagerKtxKt$requestPackStates$1.label & Integer.MIN_VALUE) != 0) {
                assetPackManagerKtxKt$requestPackStates$1.label -= Integer.MIN_VALUE;
                Object obj = assetPackManagerKtxKt$requestPackStates$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = assetPackManagerKtxKt$requestPackStates$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Task<AssetPackStates> packStates = assetPackManager.getPackStates(list);
                    Intrinsics.checkExpressionValueIsNotNull(packStates, "task");
                    assetPackManagerKtxKt$requestPackStates$1.L$0 = assetPackManager;
                    assetPackManagerKtxKt$requestPackStates$1.L$1 = list;
                    assetPackManagerKtxKt$requestPackStates$1.L$2 = packStates;
                    assetPackManagerKtxKt$requestPackStates$1.label = 1;
                    obj = TaskUtilsKt.runTask$default(packStates, null, assetPackManagerKtxKt$requestPackStates$1, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    Task task = (Task) assetPackManagerKtxKt$requestPackStates$1.L$2;
                    List list2 = (List) assetPackManagerKtxKt$requestPackStates$1.L$1;
                    AssetPackManager assetPackManager2 = (AssetPackManager) assetPackManagerKtxKt$requestPackStates$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Intrinsics.checkExpressionValueIsNotNull(obj, "runTask(task)");
                return obj;
            }
        }
        assetPackManagerKtxKt$requestPackStates$1 = new AssetPackManagerKtxKt$requestPackStates$1(continuation);
        Object obj2 = assetPackManagerKtxKt$requestPackStates$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = assetPackManagerKtxKt$requestPackStates$1.label;
        if (i != 0) {
        }
        Intrinsics.checkExpressionValueIsNotNull(obj2, "runTask(task)");
        return obj2;
    }

    public static final Object requestRemovePack(AssetPackManager assetPackManager, String str, Continuation<? super Unit> continuation) {
        Task<Void> removePack = assetPackManager.removePack(str);
        Intrinsics.checkExpressionValueIsNotNull(removePack, "removePack(packName)");
        Object runTask$default = TaskUtilsKt.runTask$default(removePack, null, continuation, 2, null);
        if (runTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return runTask$default;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final Object requestCellularDataConfirmation(AssetPackManager assetPackManager, Activity activity, Continuation<? super Integer> continuation) {
        AssetPackManagerKtxKt$requestCellularDataConfirmation$1 assetPackManagerKtxKt$requestCellularDataConfirmation$1;
        int i;
        if (continuation instanceof AssetPackManagerKtxKt$requestCellularDataConfirmation$1) {
            assetPackManagerKtxKt$requestCellularDataConfirmation$1 = (AssetPackManagerKtxKt$requestCellularDataConfirmation$1) continuation;
            if ((assetPackManagerKtxKt$requestCellularDataConfirmation$1.label & Integer.MIN_VALUE) != 0) {
                assetPackManagerKtxKt$requestCellularDataConfirmation$1.label -= Integer.MIN_VALUE;
                Object obj = assetPackManagerKtxKt$requestCellularDataConfirmation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = assetPackManagerKtxKt$requestCellularDataConfirmation$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Task<Integer> showCellularDataConfirmation = assetPackManager.showCellularDataConfirmation(activity);
                    Intrinsics.checkExpressionValueIsNotNull(showCellularDataConfirmation, "showCellularDataConfirmation(activity)");
                    assetPackManagerKtxKt$requestCellularDataConfirmation$1.L$0 = assetPackManager;
                    assetPackManagerKtxKt$requestCellularDataConfirmation$1.L$1 = activity;
                    assetPackManagerKtxKt$requestCellularDataConfirmation$1.label = 1;
                    obj = TaskUtilsKt.runTask$default(showCellularDataConfirmation, null, assetPackManagerKtxKt$requestCellularDataConfirmation$1, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    Activity activity2 = (Activity) assetPackManagerKtxKt$requestCellularDataConfirmation$1.L$1;
                    AssetPackManager assetPackManager2 = (AssetPackManager) assetPackManagerKtxKt$requestCellularDataConfirmation$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Intrinsics.checkExpressionValueIsNotNull(obj, "runTask(showCellularDataConfirmation(activity))");
                return obj;
            }
        }
        assetPackManagerKtxKt$requestCellularDataConfirmation$1 = new AssetPackManagerKtxKt$requestCellularDataConfirmation$1(continuation);
        Object obj2 = assetPackManagerKtxKt$requestCellularDataConfirmation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = assetPackManagerKtxKt$requestCellularDataConfirmation$1.label;
        if (i != 0) {
        }
        Intrinsics.checkExpressionValueIsNotNull(obj2, "runTask(showCellularDataConfirmation(activity))");
        return obj2;
    }

    public static final Map<String, AssetPackState> getPackStates(AssetPackStates assetPackStates) {
        Intrinsics.checkParameterIsNotNull(assetPackStates, "$this$packStates");
        Map<String, AssetPackState> packStates = assetPackStates.packStates();
        Intrinsics.checkExpressionValueIsNotNull(packStates, "packStates()");
        return packStates;
    }

    public static final long getTotalBytes(AssetPackStates assetPackStates) {
        Intrinsics.checkParameterIsNotNull(assetPackStates, "$this$totalBytes");
        return assetPackStates.totalBytes();
    }

    public static final int getStatus(AssetPackState assetPackState) {
        Intrinsics.checkParameterIsNotNull(assetPackState, "$this$status");
        return assetPackState.status();
    }

    public static final int getErrorCode(AssetPackState assetPackState) {
        Intrinsics.checkParameterIsNotNull(assetPackState, "$this$errorCode");
        return assetPackState.errorCode();
    }

    public static final long getBytesDownloaded(AssetPackState assetPackState) {
        Intrinsics.checkParameterIsNotNull(assetPackState, "$this$bytesDownloaded");
        return assetPackState.bytesDownloaded();
    }

    public static final long getTotalBytesToDownload(AssetPackState assetPackState) {
        Intrinsics.checkParameterIsNotNull(assetPackState, "$this$totalBytesToDownload");
        return assetPackState.totalBytesToDownload();
    }

    public static final String getName(AssetPackState assetPackState) {
        Intrinsics.checkParameterIsNotNull(assetPackState, "$this$name");
        String name = assetPackState.name();
        Intrinsics.checkExpressionValueIsNotNull(name, "name()");
        return name;
    }

    public static final int getTransferProgressPercentage(AssetPackState assetPackState) {
        Intrinsics.checkParameterIsNotNull(assetPackState, "$this$transferProgressPercentage");
        return assetPackState.transferProgressPercentage();
    }

    public static final String getAssetsPath(AssetPackLocation assetPackLocation) {
        Intrinsics.checkParameterIsNotNull(assetPackLocation, "$this$assetsPath");
        return assetPackLocation.assetsPath();
    }

    public static final int getPackStorageMethod(AssetPackLocation assetPackLocation) {
        Intrinsics.checkParameterIsNotNull(assetPackLocation, "$this$packStorageMethod");
        return assetPackLocation.packStorageMethod();
    }

    public static final String getPath(AssetPackLocation assetPackLocation) {
        Intrinsics.checkParameterIsNotNull(assetPackLocation, "$this$path");
        return assetPackLocation.path();
    }

    public static final String getPath(AssetLocation assetLocation) {
        Intrinsics.checkParameterIsNotNull(assetLocation, "$this$path");
        String path = assetLocation.path();
        Intrinsics.checkExpressionValueIsNotNull(path, "path()");
        return path;
    }

    public static final long getOffset(AssetLocation assetLocation) {
        Intrinsics.checkParameterIsNotNull(assetLocation, "$this$offset");
        return assetLocation.offset();
    }

    public static final long getSize(AssetLocation assetLocation) {
        Intrinsics.checkParameterIsNotNull(assetLocation, "$this$size");
        return assetLocation.size();
    }
}
