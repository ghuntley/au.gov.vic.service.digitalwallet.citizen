package com.google.android.play.core.review;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.i;

public final class c implements ReviewManager {
    private final h a;
    private final Handler b = new Handler(Looper.getMainLooper());

    c(h hVar) {
        this.a = hVar;
    }

    @Override // com.google.android.play.core.review.ReviewManager
    public final Task<Void> launchReviewFlow(Activity activity, ReviewInfo reviewInfo) {
        Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", reviewInfo.a());
        intent.putExtra("window_flags", activity.getWindow().getDecorView().getWindowSystemUiVisibility());
        i iVar = new i();
        intent.putExtra("result_receiver", new b(this.b, iVar));
        activity.startActivity(intent);
        return iVar.c();
    }

    @Override // com.google.android.play.core.review.ReviewManager
    public final Task<ReviewInfo> requestReviewFlow() {
        return this.a.a();
    }
}
