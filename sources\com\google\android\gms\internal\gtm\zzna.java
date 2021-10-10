package com.google.android.gms.internal.gtm;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;

/* access modifiers changed from: package-private */
public final class zzna implements zzne {
    private final /* synthetic */ Context val$context;

    zzna(Context context) {
        this.val$context = context;
    }

    @Override // com.google.android.gms.internal.gtm.zzne
    public final InputStream open(String str) throws IOException {
        return this.val$context.getAssets().open(str);
    }
}
