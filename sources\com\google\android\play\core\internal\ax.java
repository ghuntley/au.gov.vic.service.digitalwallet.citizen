package com.google.android.play.core.internal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
public final class ax implements ba {
    ax() {
    }

    @Override // com.google.android.play.core.internal.ba
    public final Object[] a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
        return (Object[]) br.b(obj, "makeDexElements", Object[].class, ArrayList.class, arrayList, File.class, file, ArrayList.class, arrayList2);
    }
}
