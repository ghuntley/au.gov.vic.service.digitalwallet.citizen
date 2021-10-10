package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.cj;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

final class dt {
    private static final Pattern a = Pattern.compile("[0-9]+-(NAM|LFH)\\.dat");

    static List<File> a(File file, File file2) throws IOException {
        File[] fileArr;
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file2.listFiles(ds.a);
        if (listFiles == null) {
            fileArr = new File[0];
        } else {
            int length = listFiles.length;
            File[] fileArr2 = new File[length];
            for (File file3 : listFiles) {
                int parseInt = Integer.parseInt(file3.getName().split("-")[0]);
                if (parseInt > listFiles.length || fileArr2[parseInt] != null) {
                    throw new bv("Metadata folder ordering corrupt.");
                }
                fileArr2[parseInt] = file3;
            }
            fileArr = fileArr2;
        }
        for (File file4 : fileArr) {
            arrayList.add(file4);
            if (file4.getName().contains("LFH")) {
                FileInputStream fileInputStream = new FileInputStream(file4);
                try {
                    dx a2 = new bm(fileInputStream).a();
                    if (a2.d() != null) {
                        File file5 = new File(file, a2.d());
                        if (file5.exists()) {
                            arrayList.add(file5);
                            fileInputStream.close();
                        } else {
                            throw new bv(String.format("Missing asset file %s during slice reconstruction.", file5.getCanonicalPath()));
                        }
                    } else {
                        throw new bv("Metadata files corrupt. Could not read local file header.");
                    }
                } catch (Throwable th) {
                    cj.a(th, th);
                }
            }
        }
        return arrayList;
        throw th;
    }
}
