package com.google.android.play.core.assetpacks;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.ck;
import com.google.android.play.core.internal.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

/* access modifiers changed from: package-private */
public final class cp {
    private static final ag a = new ag("ExtractorSessionStoreView");
    private final bb b;
    private final ck<w> c;
    private final bz d;
    private final ck<Executor> e;
    private final Map<Integer, cm> f = new HashMap();
    private final ReentrantLock g = new ReentrantLock();

    cp(bb bbVar, ck<w> ckVar, bz bzVar, ck<Executor> ckVar2) {
        this.b = bbVar;
        this.c = ckVar;
        this.d = bzVar;
        this.e = ckVar2;
    }

    private final Map<String, cm> q(List<String> list) {
        return (Map) r(new cf(this, list));
    }

    private final <T> T r(co<T> coVar) {
        try {
            a();
            return coVar.a();
        } finally {
            b();
        }
    }

    private final cm s(int i) {
        Map<Integer, cm> map = this.f;
        Integer valueOf = Integer.valueOf(i);
        cm cmVar = map.get(valueOf);
        if (cmVar != null) {
            return cmVar;
        }
        throw new bv(String.format("Could not find session %d while trying to get it", valueOf), i);
    }

    private static String t(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        if (stringArrayList != null && !stringArrayList.isEmpty()) {
            return stringArrayList.get(0);
        }
        throw new bv("Session without pack received.");
    }

    private static <T> List<T> u(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.g.lock();
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.g.unlock();
    }

    /* access modifiers changed from: package-private */
    public final Map<Integer, cm> c() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public final boolean d(Bundle bundle) {
        return ((Boolean) r(new cc(this, bundle))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean e(Bundle bundle) {
        return ((Boolean) r(new cd(this, bundle))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final void f(String str, int i, long j) {
        r(new ce(this, str, i, j));
    }

    /* access modifiers changed from: package-private */
    public final void g(int i) {
        r(new ch(this, i));
    }

    /* access modifiers changed from: package-private */
    public final Map<String, Integer> h(List<String> list) {
        return (Map) r(new ci(this, list));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Map i(List list) {
        int i;
        Map<String, cm> q = q(list);
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            cm cmVar = q.get(str);
            if (cmVar == null) {
                i = 8;
            } else {
                if (db.f(cmVar.c.c)) {
                    try {
                        cmVar.c.c = 6;
                        this.e.a().execute(new cj(this, cmVar));
                        this.d.a(str);
                    } catch (bv unused) {
                        a.d("Session %d with pack %s does not exist, no need to cancel.", Integer.valueOf(cmVar.a), str);
                    }
                }
                i = cmVar.c.c;
            }
            hashMap.put(str, Integer.valueOf(i));
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Map j(List list) {
        HashMap hashMap = new HashMap();
        for (cm cmVar : this.f.values()) {
            String str = cmVar.c.a;
            if (list.contains(str)) {
                cm cmVar2 = (cm) hashMap.get(str);
                if ((cmVar2 == null ? -1 : cmVar2.a) < cmVar.a) {
                    hashMap.put(str, cmVar);
                }
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Boolean k(Bundle bundle) {
        boolean z;
        int i = bundle.getInt("session_id");
        if (i == 0) {
            return true;
        }
        Map<Integer, cm> map = this.f;
        Integer valueOf = Integer.valueOf(i);
        if (!map.containsKey(valueOf)) {
            return true;
        }
        cm cmVar = this.f.get(valueOf);
        if (cmVar.c.c == 6) {
            z = false;
        } else {
            z = !db.i(cmVar.c.c, bundle.getInt(i.e("status", t(bundle))));
        }
        return Boolean.valueOf(z);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Boolean l(Bundle bundle) {
        boolean z;
        boolean z2;
        cn cnVar;
        int i = bundle.getInt("session_id");
        boolean z3 = false;
        if (i == 0) {
            return false;
        }
        Map<Integer, cm> map = this.f;
        Integer valueOf = Integer.valueOf(i);
        boolean z4 = true;
        if (map.containsKey(valueOf)) {
            cm s = s(i);
            int i2 = bundle.getInt(i.e("status", s.c.a));
            if (db.i(s.c.c, i2)) {
                a.a("Found stale update for session %s with status %d.", valueOf, Integer.valueOf(s.c.c));
                cl clVar = s.c;
                String str = clVar.a;
                int i3 = clVar.c;
                if (i3 == 4) {
                    this.c.a().f(i, str);
                } else if (i3 == 5) {
                    this.c.a().g(i);
                } else if (i3 == 6) {
                    this.c.a().b(Arrays.asList(str));
                }
            } else {
                s.c.c = i2;
                if (db.g(i2)) {
                    g(i);
                    this.d.a(s.c.a);
                } else {
                    for (cn cnVar2 : s.c.e) {
                        ArrayList parcelableArrayList = bundle.getParcelableArrayList(i.f("chunk_intents", s.c.a, cnVar2.a));
                        if (parcelableArrayList != null) {
                            for (int i4 = 0; i4 < parcelableArrayList.size(); i4++) {
                                if (!(parcelableArrayList.get(i4) == null || ((Intent) parcelableArrayList.get(i4)).getData() == null)) {
                                    cnVar2.d.get(i4).a = true;
                                }
                            }
                        }
                    }
                }
            }
            z = true;
        } else {
            String t = t(bundle);
            long j = bundle.getLong(i.e("pack_version", t));
            int i5 = bundle.getInt(i.e("status", t));
            long j2 = bundle.getLong(i.e("total_bytes_to_download", t));
            ArrayList<String> stringArrayList = bundle.getStringArrayList(i.e("slice_ids", t));
            ArrayList arrayList = new ArrayList();
            for (String str2 : u(stringArrayList)) {
                ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(i.f("chunk_intents", t, str2));
                ArrayList arrayList2 = new ArrayList();
                for (Intent intent : u(parcelableArrayList2)) {
                    if (intent == null) {
                        z4 = z3;
                    }
                    arrayList2.add(new ck(z4));
                    z3 = false;
                    z4 = true;
                }
                String string = bundle.getString(i.f("uncompressed_hash_sha256", t, str2));
                long j3 = bundle.getLong(i.f("uncompressed_size", t, str2));
                int i6 = bundle.getInt(i.f("patch_format", t, str2), 0);
                if (i6 != 0) {
                    cnVar = new cn(str2, string, j3, arrayList2, 0, i6);
                    z2 = false;
                } else {
                    z2 = false;
                    cnVar = new cn(str2, string, j3, arrayList2, bundle.getInt(i.f("compression_format", t, str2), 0), 0);
                }
                arrayList.add(cnVar);
                z3 = z2;
                z4 = true;
            }
            this.f.put(Integer.valueOf(i), new cm(i, bundle.getInt("app_version_code"), new cl(t, j, i5, j2, arrayList)));
            z = true;
        }
        return Boolean.valueOf(z);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void m(String str, int i, long j) {
        cm cmVar = q(Arrays.asList(str)).get(str);
        if (cmVar == null || db.g(cmVar.c.c)) {
            a.b(String.format("Could not find pack %s while trying to complete it", str), new Object[0]);
        }
        this.b.A(str, i, j);
        cmVar.c.c = 4;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void n(int i) {
        s(i).c.c = 5;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void o(int i) {
        cm s = s(i);
        if (db.g(s.c.c)) {
            bb bbVar = this.b;
            cl clVar = s.c;
            bbVar.A(clVar.a, s.b, clVar.b);
            cl clVar2 = s.c;
            int i2 = clVar2.c;
            if (i2 == 5 || i2 == 6) {
                this.b.q(clVar2.a);
                return;
            }
            return;
        }
        throw new bv(String.format("Could not safely delete session %d because it is not in a terminal state.", Integer.valueOf(i)), i);
    }

    /* access modifiers changed from: package-private */
    public final void p(int i) {
        r(new cg(this, i));
    }
}
