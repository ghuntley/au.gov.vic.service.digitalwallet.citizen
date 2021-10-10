package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.cb;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* access modifiers changed from: package-private */
public final class be extends cb {
    private final File a;
    private final File b;
    private final NavigableMap<Long, File> c = new TreeMap();

    be(File file, File file2) throws IOException {
        this.a = file;
        this.b = file2;
        List<File> a2 = dt.a(file, file2);
        if (!a2.isEmpty()) {
            long j = 0;
            for (File file3 : a2) {
                this.c.put(Long.valueOf(j), file3);
                j += file3.length();
            }
            return;
        }
        throw new bv(String.format("Virtualized slice archive empty for %s, %s", file, file2));
    }

    private final InputStream d(long j, Long l) throws IOException {
        FileInputStream fileInputStream = new FileInputStream((File) this.c.get(l));
        if (fileInputStream.skip(j - l.longValue()) == j - l.longValue()) {
            return fileInputStream;
        }
        throw new bv(String.format("Virtualized slice archive corrupt, could not skip in file with key %s", l));
    }

    @Override // com.google.android.play.core.internal.cb
    public final long a() {
        Map.Entry<Long, File> lastEntry = this.c.lastEntry();
        return lastEntry.getKey().longValue() + lastEntry.getValue().length();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.cb
    public final InputStream b(long j, long j2) throws IOException {
        if (j < 0 || j2 < 0) {
            throw new bv(String.format("Invalid input parameters %s, %s", Long.valueOf(j), Long.valueOf(j2)));
        }
        long j3 = j + j2;
        if (j3 <= a()) {
            Long floorKey = this.c.floorKey(Long.valueOf(j));
            Long floorKey2 = this.c.floorKey(Long.valueOf(j3));
            if (floorKey.equals(floorKey2)) {
                return new bd(d(j, floorKey), j2);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(d(j, floorKey));
            Collection<File> values = this.c.subMap(floorKey, false, floorKey2, false).values();
            if (!values.isEmpty()) {
                arrayList.add(new dc(Collections.enumeration(values)));
            }
            arrayList.add(new bd(new FileInputStream((File) this.c.get(floorKey2)), j2 - (floorKey2.longValue() - j)));
            return new SequenceInputStream(Collections.enumeration(arrayList));
        }
        throw new bv(String.format("Trying to access archive out of bounds. Archive ends at: %s. Tried accessing: %s", Long.valueOf(a()), Long.valueOf(j3)));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
