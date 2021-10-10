package com.google.android.play.core.review.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

public class FakeReviewManager implements ReviewManager {
    private final Context a;
    private ReviewInfo b;

    public FakeReviewManager(Context context) {
        this.a = context;
    }

    @Override // com.google.android.play.core.review.ReviewManager
    public Task<Void> launchReviewFlow(Activity activity, ReviewInfo reviewInfo) {
        return reviewInfo != this.b ? Tasks.b(new a()) : Tasks.a(null);
    }

    @Override // com.google.android.play.core.review.ReviewManager
    public Task<ReviewInfo> requestReviewFlow() {
        ReviewInfo b2 = ReviewInfo.b(PendingIntent.getBroadcast(this.a, 0, new Intent(), 0));
        this.b = b2;
        return Tasks.a(b2);
    }
}
