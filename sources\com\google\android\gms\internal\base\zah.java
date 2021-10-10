package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zah extends Drawable.ConstantState {
    int zaa;
    int zab;

    zah(zah zah) {
        if (zah != null) {
            this.zaa = zah.zaa;
            this.zab = zah.zab;
        }
    }

    public final Drawable newDrawable() {
        return new zae(this);
    }

    public final int getChangingConfigurations() {
        return this.zaa;
    }
}
