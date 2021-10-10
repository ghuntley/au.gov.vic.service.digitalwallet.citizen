package com.google.android.play.core.ktx;

import android.app.Activity;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.tasks.Task;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"launchReview", "", "Lcom/google/android/play/core/review/ReviewManager;", "activity", "Landroid/app/Activity;", "reviewInfo", "Lcom/google/android/play/core/review/ReviewInfo;", "(Lcom/google/android/play/core/review/ReviewManager;Landroid/app/Activity;Lcom/google/android/play/core/review/ReviewInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestReview", "(Lcom/google/android/play/core/review/ReviewManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tmp.wkwm2e3_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: ReviewManagerKtx.kt */
public final class ReviewManagerKtxKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final Object requestReview(ReviewManager reviewManager, Continuation<? super ReviewInfo> continuation) {
        ReviewManagerKtxKt$requestReview$1 reviewManagerKtxKt$requestReview$1;
        int i;
        if (continuation instanceof ReviewManagerKtxKt$requestReview$1) {
            reviewManagerKtxKt$requestReview$1 = (ReviewManagerKtxKt$requestReview$1) continuation;
            if ((reviewManagerKtxKt$requestReview$1.label & Integer.MIN_VALUE) != 0) {
                reviewManagerKtxKt$requestReview$1.label -= Integer.MIN_VALUE;
                Object obj = reviewManagerKtxKt$requestReview$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = reviewManagerKtxKt$requestReview$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Task<ReviewInfo> requestReviewFlow = reviewManager.requestReviewFlow();
                    Intrinsics.checkExpressionValueIsNotNull(requestReviewFlow, "requestReviewFlow()");
                    reviewManagerKtxKt$requestReview$1.L$0 = reviewManager;
                    reviewManagerKtxKt$requestReview$1.label = 1;
                    obj = TaskUtilsKt.runTask$default(requestReviewFlow, null, reviewManagerKtxKt$requestReview$1, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    ReviewManager reviewManager2 = (ReviewManager) reviewManagerKtxKt$requestReview$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Intrinsics.checkExpressionValueIsNotNull(obj, "runTask(requestReviewFlow())");
                return obj;
            }
        }
        reviewManagerKtxKt$requestReview$1 = new ReviewManagerKtxKt$requestReview$1(continuation);
        Object obj2 = reviewManagerKtxKt$requestReview$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = reviewManagerKtxKt$requestReview$1.label;
        if (i != 0) {
        }
        Intrinsics.checkExpressionValueIsNotNull(obj2, "runTask(requestReviewFlow())");
        return obj2;
    }

    public static final Object launchReview(ReviewManager reviewManager, Activity activity, ReviewInfo reviewInfo, Continuation<? super Unit> continuation) {
        Task<Void> launchReviewFlow = reviewManager.launchReviewFlow(activity, reviewInfo);
        Intrinsics.checkExpressionValueIsNotNull(launchReviewFlow, "launchReviewFlow(activity, reviewInfo)");
        Object runTask$default = TaskUtilsKt.runTask$default(launchReviewFlow, null, continuation, 2, null);
        if (runTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return runTask$default;
        }
        return Unit.INSTANCE;
    }
}
