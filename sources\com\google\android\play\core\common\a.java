package com.google.android.play.core.common;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private final Map<String, Object> a = new HashMap();

    public final synchronized void a(Bundle bundle) {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && this.a.get(str) == null) {
                this.a.put(str, obj);
            }
        }
    }
}
