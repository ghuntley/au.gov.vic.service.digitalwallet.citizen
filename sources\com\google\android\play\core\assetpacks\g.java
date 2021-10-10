package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.OnSuccessListener;
import java.util.List;

/* access modifiers changed from: package-private */
public final /* synthetic */ class g implements OnSuccessListener {
    private final bb a;

    private g(bb bbVar) {
        this.a = bbVar;
    }

    static OnSuccessListener a(bb bbVar) {
        return new g(bbVar);
    }

    @Override // com.google.android.play.core.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        this.a.z((List) obj);
    }
}
