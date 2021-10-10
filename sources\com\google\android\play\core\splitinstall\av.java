package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.aq;
import com.google.android.play.core.internal.bv;
import com.google.android.play.core.internal.bz;
import com.google.android.play.core.splitcompat.p;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import com.google.android.play.core.tasks.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* access modifiers changed from: package-private */
public final class av {
    private static final ag b = new ag("SplitInstallService");
    private static final Intent c = new Intent("com.google.android.play.core.splitinstall.BIND_SPLIT_INSTALL_SERVICE").setPackage("com.android.vending");
    aq<bv> a;
    private final String d;

    public av(Context context) {
        this.d = context.getPackageName();
        if (bz.a(context)) {
            this.a = new aq<>(p.c(context), b, "SplitInstallService", c, ad.a);
        }
    }

    static /* synthetic */ ArrayList i(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", (String) it.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    static /* synthetic */ ArrayList j(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString("language", (String) it.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    static /* synthetic */ Bundle l() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 10803);
        return bundle;
    }

    private static <T> Task<T> n() {
        b.b("onError(%d)", -14);
        return Tasks.b(new SplitInstallException(-14));
    }

    public final Task<Integer> a(Collection<String> collection, Collection<String> collection2) {
        if (this.a == null) {
            return n();
        }
        b.d("startInstall(%s,%s)", collection, collection2);
        i iVar = new i();
        this.a.a(new ae(this, iVar, collection, collection2, iVar));
        return iVar.c();
    }

    public final Task<Void> b(List<String> list) {
        if (this.a == null) {
            return n();
        }
        b.d("deferredUninstall(%s)", list);
        i iVar = new i();
        this.a.a(new af(this, iVar, list, iVar));
        return iVar.c();
    }

    public final Task<Void> c(List<String> list) {
        if (this.a == null) {
            return n();
        }
        b.d("deferredInstall(%s)", list);
        i iVar = new i();
        this.a.a(new ag(this, iVar, list, iVar));
        return iVar.c();
    }

    public final Task<Void> d(List<String> list) {
        if (this.a == null) {
            return n();
        }
        b.d("deferredLanguageInstall(%s)", list);
        i iVar = new i();
        this.a.a(new ah(this, iVar, list, iVar));
        return iVar.c();
    }

    public final Task<Void> e(List<String> list) {
        if (this.a == null) {
            return n();
        }
        b.d("deferredLanguageUninstall(%s)", list);
        i iVar = new i();
        this.a.a(new ai(this, iVar, list, iVar));
        return iVar.c();
    }

    public final Task<SplitInstallSessionState> f(int i) {
        if (this.a == null) {
            return n();
        }
        b.d("getSessionState(%d)", Integer.valueOf(i));
        i iVar = new i();
        this.a.a(new aj(this, iVar, i, iVar));
        return iVar.c();
    }

    public final Task<List<SplitInstallSessionState>> g() {
        if (this.a == null) {
            return n();
        }
        b.d("getSessionStates", new Object[0]);
        i iVar = new i();
        this.a.a(new ak(this, iVar, iVar));
        return iVar.c();
    }

    public final Task<Void> h(int i) {
        if (this.a == null) {
            return n();
        }
        b.d("cancelInstall(%d)", Integer.valueOf(i));
        i iVar = new i();
        this.a.a(new al(this, iVar, i, iVar));
        return iVar.c();
    }
}
