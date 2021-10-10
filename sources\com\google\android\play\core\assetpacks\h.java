package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.OnFailureListener;

/* access modifiers changed from: package-private */
public final /* synthetic */ class h implements OnFailureListener {
    static final OnFailureListener a = new h();

    private h() {
    }

    @Override // com.google.android.play.core.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        j.a.e(String.format("Could not sync active asset packs. %s", exc), new Object[0]);
    }
}
