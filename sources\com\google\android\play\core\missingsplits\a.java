package com.google.android.play.core.missingsplits;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.play.core.internal.ag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* access modifiers changed from: package-private */
public final class a {
    private static final ag a = new ag("MissingSplitsAppComponentsHelper");
    private final Context b;
    private final PackageManager c;

    a(Context context, PackageManager packageManager) {
        this.b = context;
        this.c = packageManager;
    }

    private final void d(List<ComponentInfo> list, int i) {
        for (ComponentInfo componentInfo : list) {
            this.c.setComponentEnabledSetting(new ComponentName(componentInfo.packageName, componentInfo.name), i, 1);
        }
    }

    private final List<ComponentInfo> e() {
        try {
            ArrayList arrayList = new ArrayList();
            PackageInfo packageInfo = this.c.getPackageInfo(this.b.getPackageName(), 526);
            if (packageInfo.providers != null) {
                Collections.addAll(arrayList, packageInfo.providers);
            }
            if (packageInfo.receivers != null) {
                Collections.addAll(arrayList, packageInfo.receivers);
            }
            if (packageInfo.services != null) {
                Collections.addAll(arrayList, packageInfo.services);
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            a.e("Failed to resolve own package : %s", e);
            return Collections.emptyList();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        for (ComponentInfo componentInfo : e()) {
            if (this.c.getComponentEnabledSetting(new ComponentName(componentInfo.packageName, componentInfo.name)) != 2) {
                a.a("Not all non-activity components are disabled", new Object[0]);
                return false;
            }
        }
        a.a("All non-activity components are disabled", new Object[0]);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        a.d("Disabling all non-activity components", new Object[0]);
        d(e(), 2);
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        a.d("Resetting enabled state of all non-activity components", new Object[0]);
        d(e(), 0);
    }
}
