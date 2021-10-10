package com.google.android.play.core.assetpacks;

import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class bz {
    private final Map<String, Double> a = new HashMap();

    bz() {
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(String str) {
        this.a.put(str, Double.valueOf(0.0d));
    }

    /* access modifiers changed from: package-private */
    public final synchronized double b(String str) {
        Double d = this.a.get(str);
        if (d == null) {
            return 0.0d;
        }
        return d.doubleValue();
    }

    /* access modifiers changed from: package-private */
    public final synchronized double c(String str, cr crVar) {
        double d;
        d = (((double) ((bs) crVar).e) + 1.0d) / ((double) ((bs) crVar).f);
        this.a.put(str, Double.valueOf(d));
        return d;
    }
}
