package com.google.android.play.core.internal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
public final class bd implements ba {
    bd() {
    }

    @Override // com.google.android.play.core.internal.ba
    public final Object[] a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
        return (Object[]) br.b(obj, "makePathElements", Object[].class, List.class, arrayList, File.class, file, List.class, arrayList2);
    }
}
