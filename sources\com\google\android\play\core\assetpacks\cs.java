package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.ag;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* access modifiers changed from: package-private */
public final class cs {
    private static final ag a = new ag("ExtractorTaskFinder");
    private final cp b;
    private final bb c;
    private final bk d;

    cs(cp cpVar, bb bbVar, bk bkVar) {
        this.b = cpVar;
        this.c = bbVar;
        this.d = bkVar;
    }

    private final boolean b(cm cmVar, cn cnVar) {
        bb bbVar = this.c;
        cl clVar = cmVar.c;
        return new dr(bbVar, clVar.a, cmVar.b, clVar.b, cnVar.a).l();
    }

    private static boolean c(cn cnVar) {
        int i = cnVar.f;
        return i == 1 || i == 2;
    }

    /* access modifiers changed from: package-private */
    public final cr a() {
        cr crVar;
        bs bsVar;
        dn dnVar;
        int i;
        try {
            this.b.a();
            ArrayList arrayList = new ArrayList();
            for (cm cmVar : this.b.c().values()) {
                if (db.h(cmVar.c.c)) {
                    arrayList.add(cmVar);
                }
            }
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        crVar = null;
                        break;
                    }
                    cm cmVar2 = (cm) it.next();
                    try {
                        bb bbVar = this.c;
                        cl clVar = cmVar2.c;
                        if (bbVar.k(clVar.a, cmVar2.b, clVar.b) == cmVar2.c.e.size()) {
                            a.a("Found final move task for session %s with pack %s.", Integer.valueOf(cmVar2.a), cmVar2.c.a);
                            int i2 = cmVar2.a;
                            cl clVar2 = cmVar2.c;
                            crVar = new dh(i2, clVar2.a, cmVar2.b, clVar2.b);
                            break;
                        }
                    } catch (IOException e) {
                        throw new bv(String.format("Failed to check number of completed merges for session %s, pack %s", Integer.valueOf(cmVar2.a), cmVar2.c.a), e, cmVar2.a);
                    }
                }
                if (crVar == null) {
                    Iterator it2 = arrayList.iterator();
                    loop2:
                    while (true) {
                        if (!it2.hasNext()) {
                            crVar = null;
                            break;
                        }
                        cm cmVar3 = (cm) it2.next();
                        if (db.h(cmVar3.c.c)) {
                            for (cn cnVar : cmVar3.c.e) {
                                bb bbVar2 = this.c;
                                cl clVar3 = cmVar3.c;
                                if (bbVar2.i(clVar3.a, cmVar3.b, clVar3.b, cnVar.a).exists()) {
                                    a.a("Found merge task for session %s with pack %s and slice %s.", Integer.valueOf(cmVar3.a), cmVar3.c.a, cnVar.a);
                                    int i3 = cmVar3.a;
                                    cl clVar4 = cmVar3.c;
                                    crVar = new de(i3, clVar4.a, cmVar3.b, clVar4.b, cnVar.a);
                                    break loop2;
                                }
                            }
                            continue;
                        }
                    }
                    if (crVar == null) {
                        Iterator it3 = arrayList.iterator();
                        loop4:
                        while (true) {
                            if (!it3.hasNext()) {
                                crVar = null;
                                break;
                            }
                            cm cmVar4 = (cm) it3.next();
                            if (db.h(cmVar4.c.c)) {
                                for (cn cnVar2 : cmVar4.c.e) {
                                    if (b(cmVar4, cnVar2)) {
                                        bb bbVar3 = this.c;
                                        cl clVar5 = cmVar4.c;
                                        if (bbVar3.h(clVar5.a, cmVar4.b, clVar5.b, cnVar2.a).exists()) {
                                            a.a("Found verify task for session %s with pack %s and slice %s.", Integer.valueOf(cmVar4.a), cmVar4.c.a, cnVar2.a);
                                            int i4 = cmVar4.a;
                                            cl clVar6 = cmVar4.c;
                                            String str = clVar6.a;
                                            int i5 = cmVar4.b;
                                            long j = clVar6.b;
                                            String str2 = cnVar2.a;
                                            String str3 = cnVar2.b;
                                            long j2 = cnVar2.c;
                                            crVar = new du(i4, str, i5, j, str2, str3);
                                            break loop4;
                                        }
                                    }
                                }
                                continue;
                            }
                        }
                        if (crVar == null) {
                            Iterator it4 = arrayList.iterator();
                            loop6:
                            while (true) {
                                if (!it4.hasNext()) {
                                    bsVar = null;
                                    break;
                                }
                                cm cmVar5 = (cm) it4.next();
                                if (db.h(cmVar5.c.c)) {
                                    for (cn cnVar3 : cmVar5.c.e) {
                                        if (!c(cnVar3)) {
                                            bb bbVar4 = this.c;
                                            cl clVar7 = cmVar5.c;
                                            try {
                                                i = new dr(bbVar4, clVar7.a, cmVar5.b, clVar7.b, cnVar3.a).k();
                                            } catch (IOException e2) {
                                                a.b("Slice checkpoint corrupt, restarting extraction. %s", e2);
                                                i = 0;
                                            }
                                            if (i != -1 && cnVar3.d.get(i).a) {
                                                a.a("Found extraction task using compression format %s for session %s, pack %s, slice %s, chunk %s.", Integer.valueOf(cnVar3.e), Integer.valueOf(cmVar5.a), cmVar5.c.a, cnVar3.a, Integer.valueOf(i));
                                                InputStream a2 = this.d.a(cmVar5.a, cmVar5.c.a, cnVar3.a, i);
                                                int i6 = cmVar5.a;
                                                cl clVar8 = cmVar5.c;
                                                String str4 = clVar8.a;
                                                int i7 = cmVar5.b;
                                                long j3 = clVar8.b;
                                                String str5 = cnVar3.a;
                                                int i8 = cnVar3.e;
                                                int size = cnVar3.d.size();
                                                cl clVar9 = cmVar5.c;
                                                bsVar = new bs(i6, str4, i7, j3, str5, i8, i, size, clVar9.d, clVar9.c, a2);
                                                break loop6;
                                            }
                                            it4 = it4;
                                        }
                                    }
                                    continue;
                                }
                            }
                            if (bsVar == null) {
                                Iterator it5 = arrayList.iterator();
                                loop8:
                                while (true) {
                                    if (!it5.hasNext()) {
                                        dnVar = null;
                                        break;
                                    }
                                    cm cmVar6 = (cm) it5.next();
                                    if (db.h(cmVar6.c.c)) {
                                        for (cn cnVar4 : cmVar6.c.e) {
                                            if (c(cnVar4) && cnVar4.d.get(0).a && !b(cmVar6, cnVar4)) {
                                                a.a("Found patch slice task using patch format %s for session %s, pack %s, slice %s.", Integer.valueOf(cnVar4.f), Integer.valueOf(cmVar6.a), cmVar6.c.a, cnVar4.a);
                                                InputStream a3 = this.d.a(cmVar6.a, cmVar6.c.a, cnVar4.a, 0);
                                                int i9 = cmVar6.a;
                                                String str6 = cmVar6.c.a;
                                                dnVar = new dn(i9, str6, this.c.s(str6), this.c.t(cmVar6.c.a), cmVar6.b, cmVar6.c.b, cnVar4.f, cnVar4.a, cnVar4.c, a3);
                                                break loop8;
                                            }
                                        }
                                        continue;
                                    }
                                }
                                if (dnVar != null) {
                                    return dnVar;
                                }
                                return null;
                            }
                            this.b.b();
                            return bsVar;
                        }
                    }
                }
                this.b.b();
                return crVar;
            }
            this.b.b();
            return null;
        } finally {
            this.b.b();
        }
    }
}
