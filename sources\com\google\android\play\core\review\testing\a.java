package com.google.android.play.core.review.testing;

import com.google.android.play.core.tasks.j;

final class a extends j {
    a() {
        super("Please use requestReviewFlow() to get the ReviewInfo.");
    }

    @Override // com.google.android.play.core.tasks.j
    public final int getErrorCode() {
        return -100;
    }
}
