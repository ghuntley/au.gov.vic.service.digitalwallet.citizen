package com.google.android.play.core.ktx;

import com.google.android.play.core.tasks.Task;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.SendChannel;

public final class TaskUtilsKt {
    public static /* synthetic */ Object runTask$default(Task task, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = TaskUtilsKt$runTask$2.INSTANCE;
        }
        return runTask(task, function0, continuation);
    }

    public static final <E> boolean tryOffer(SendChannel<? super E> sendChannel, E e) {
        Intrinsics.checkParameterIsNotNull(sendChannel, "$this$tryOffer");
        try {
            return sendChannel.offer(e);
        } catch (Exception unused) {
            return false;
        }
    }

    public static final <T> Object runTask(Task<T> task, Function0<Unit> function0, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new TaskUtilsKt$runTask$$inlined$suspendCancellableCoroutine$lambda$1(function0, task));
        if (!task.isComplete()) {
            task.addOnSuccessListener(new TaskUtilsKt$runTask$3$2(cancellableContinuationImpl2));
            Intrinsics.checkExpressionValueIsNotNull(task.addOnFailureListener(new TaskUtilsKt$runTask$3$3(cancellableContinuationImpl2)), "task.addOnFailureListene…ithException(exception) }");
        } else if (task.isSuccessful()) {
            T result = task.getResult();
            Result.Companion companion = Result.Companion;
            cancellableContinuationImpl2.resumeWith(Result.m12constructorimpl(result));
        } else {
            CancellableContinuationImpl cancellableContinuationImpl3 = cancellableContinuationImpl2;
            Exception exception = task.getException();
            if (exception == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(exception, "task.exception!!");
            Result.Companion companion2 = Result.Companion;
            cancellableContinuationImpl3.resumeWith(Result.m12constructorimpl(ResultKt.createFailure(exception)));
        }
        Object result2 = cancellableContinuationImpl.getResult();
        if (result2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result2;
    }
}
