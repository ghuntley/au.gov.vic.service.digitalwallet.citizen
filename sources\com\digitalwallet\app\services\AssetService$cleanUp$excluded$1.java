package com.digitalwallet.app.services;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/io/File;", "kotlin.jvm.PlatformType", "name", "", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: AssetService.kt */
public final class AssetService$cleanUp$excluded$1 implements FilenameFilter {
    final /* synthetic */ List $names;

    AssetService$cleanUp$excluded$1(List list) {
        this.$names = list;
    }

    public final boolean accept(File file, String str) {
        return !this.$names.contains(str);
    }
}
