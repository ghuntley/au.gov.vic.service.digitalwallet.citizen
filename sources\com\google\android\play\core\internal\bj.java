package com.google.android.play.core.internal;

import java.io.File;
import java.io.IOException;
import java.util.List;

/* access modifiers changed from: package-private */
public final class bj implements bf {
    bj() {
    }

    @Override // com.google.android.play.core.internal.bf
    public final Object[] a(Object obj, List<File> list, List<IOException> list2) {
        return (Object[]) br.a(obj, "makePathElements", Object[].class, List.class, list);
    }
}
