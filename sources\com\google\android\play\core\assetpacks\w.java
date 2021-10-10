package com.google.android.play.core.assetpacks;

import android.os.ParcelFileDescriptor;
import com.google.android.play.core.tasks.Task;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public interface w {
    Task<AssetPackStates> a(List<String> list, List<String> list2, Map<String, Long> map);

    void b(List<String> list);

    Task<List<String>> c(Map<String, Long> map);

    Task<AssetPackStates> d(List<String> list, az azVar, Map<String, Long> map);

    void e(int i, String str, String str2, int i2);

    void f(int i, String str);

    void g(int i);

    Task<ParcelFileDescriptor> h(int i, String str, String str2, int i2);

    void i(String str);

    void j();
}
