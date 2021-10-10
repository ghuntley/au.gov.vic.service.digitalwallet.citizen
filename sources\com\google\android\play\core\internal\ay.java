package com.google.android.play.core.internal;

import java.io.File;

/* access modifiers changed from: package-private */
public final class ay implements az {
    ay() {
    }

    @Override // com.google.android.play.core.internal.az
    public final boolean a(Object obj, File file, File file2) {
        return new File((String) br.f(obj.getClass(), String.class, File.class, file, File.class, file2)).exists();
    }
}
