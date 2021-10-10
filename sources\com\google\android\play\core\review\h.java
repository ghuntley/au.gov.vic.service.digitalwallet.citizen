package com.google.android.play.core.review;

import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.internal.ac;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.aq;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.i;

public final class h {
    private static final ag b = new ag("ReviewService");
    final aq<ac> a;
    private final String c;

    public h(Context context) {
        this.c = context.getPackageName();
        this.a = new aq<>(context, b, "com.google.android.finsky.inappreviewservice.InAppReviewService", new Intent("com.google.android.finsky.BIND_IN_APP_REVIEW_SERVICE").setPackage("com.android.vending"), d.a);
    }

    public final Task<ReviewInfo> a() {
        b.d("requestInAppReview (%s)", this.c);
        i iVar = new i();
        this.a.a(new e(this, iVar, iVar));
        return iVar.c();
    }
}
