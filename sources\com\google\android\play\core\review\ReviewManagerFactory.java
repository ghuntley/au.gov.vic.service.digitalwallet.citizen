package com.google.android.play.core.review;

import android.content.Context;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.splitcompat.p;

public class ReviewManagerFactory {
    private ReviewManagerFactory() {
    }

    public static ReviewManager create(Context context) {
        PlayCoreDialogWrapperActivity.a(context);
        return new c(new h(p.c(context)));
    }
}
