package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* access modifiers changed from: package-private */
public final class ax {
    private final Context a;

    ax(Context context) {
        this.a = context;
    }

    private final SharedPreferences c() {
        return this.a.getSharedPreferences("playcore_split_install_internal", 0);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        return new java.util.HashSet();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001b */
    public final synchronized Set<String> a() {
        Set<String> stringSet = c().getStringSet("deferred_uninstall_module_list", new HashSet());
        if (stringSet == null) {
            stringSet = new HashSet<>();
        }
        return stringSet;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b(Collection<String> collection) {
        Set<String> a2 = a();
        boolean z = false;
        for (String str : collection) {
            z |= a2.add(str);
        }
        if (z) {
            try {
                c().edit().putStringSet("deferred_uninstall_module_list", a2).apply();
            } catch (Exception unused) {
            }
        }
    }
}
