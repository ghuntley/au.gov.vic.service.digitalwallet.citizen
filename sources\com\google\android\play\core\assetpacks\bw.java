package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.ck;
import java.util.concurrent.atomic.AtomicBoolean;

/* access modifiers changed from: package-private */
public final class bw {
    private static final ag a = new ag("ExtractorLooper");
    private final cp b;
    private final bt c;
    private final dv d;
    private final df e;
    private final dj f;
    private final Cdo g;
    private final ck<w> h;
    private final cs i;
    private final AtomicBoolean j = new AtomicBoolean(false);

    bw(cp cpVar, ck<w> ckVar, bt btVar, dv dvVar, df dfVar, dj djVar, Cdo doVar, cs csVar) {
        this.b = cpVar;
        this.h = ckVar;
        this.c = btVar;
        this.d = dvVar;
        this.e = dfVar;
        this.f = djVar;
        this.g = doVar;
        this.i = csVar;
    }

    private final void b(int i2, Exception exc) {
        try {
            this.b.p(i2);
            this.b.g(i2);
        } catch (bv unused) {
            a.b("Error during error handling: %s", exc.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ag agVar = a;
        agVar.a("Run extractor loop", new Object[0]);
        if (this.j.compareAndSet(false, true)) {
            while (true) {
                cr crVar = null;
                try {
                    crVar = this.i.a();
                } catch (bv e2) {
                    a.b("Error while getting next extraction task: %s", e2.getMessage());
                    if (e2.a >= 0) {
                        this.h.a().g(e2.a);
                        b(e2.a, e2);
                    }
                }
                if (crVar != null) {
                    try {
                        if (crVar instanceof bs) {
                            this.c.a((bs) crVar);
                        } else if (crVar instanceof du) {
                            this.d.a((du) crVar);
                        } else if (crVar instanceof de) {
                            this.e.a((de) crVar);
                        } else if (crVar instanceof dh) {
                            this.f.a((dh) crVar);
                        } else if (crVar instanceof dn) {
                            this.g.a((dn) crVar);
                        } else {
                            a.b("Unknown task type: %s", crVar.getClass().getName());
                        }
                    } catch (Exception e3) {
                        a.b("Error during extraction task: %s", e3.getMessage());
                        this.h.a().g(crVar.j);
                        b(crVar.j, e3);
                    }
                } else {
                    this.j.set(false);
                    return;
                }
            }
        } else {
            agVar.e("runLoop already looping; return", new Object[0]);
        }
    }
}
