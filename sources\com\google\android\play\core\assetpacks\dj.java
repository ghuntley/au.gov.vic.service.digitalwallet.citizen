package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.ck;
import java.io.File;
import java.util.concurrent.Executor;

/* access modifiers changed from: package-private */
public final class dj {
    private final bb a;
    private final ck<w> b;
    private final cp c;
    private final ck<Executor> d;
    private final bz e;

    dj(bb bbVar, ck<w> ckVar, cp cpVar, ck<Executor> ckVar2, bz bzVar) {
        this.a = bbVar;
        this.b = ckVar;
        this.c = cpVar;
        this.d = ckVar2;
        this.e = bzVar;
    }

    public final void a(dh dhVar) {
        File j = this.a.j(dhVar.k, dhVar.a, dhVar.b);
        File p = this.a.p(dhVar.k, dhVar.a, dhVar.b);
        if (!j.exists() || !p.exists()) {
            throw new bv(String.format("Cannot find pack files to move for pack %s.", dhVar.k), dhVar.j);
        }
        File f = this.a.f(dhVar.k, dhVar.a, dhVar.b);
        f.mkdirs();
        if (j.renameTo(f)) {
            new File(this.a.f(dhVar.k, dhVar.a, dhVar.b), "merge.tmp").delete();
            File g = this.a.g(dhVar.k, dhVar.a, dhVar.b);
            g.mkdirs();
            if (p.renameTo(g)) {
                bb bbVar = this.a;
                bbVar.getClass();
                this.d.a().execute(di.a(bbVar));
                this.c.f(dhVar.k, dhVar.a, dhVar.b);
                this.e.a(dhVar.k);
                this.b.a().f(dhVar.j, dhVar.k);
                return;
            }
            throw new bv("Cannot move metadata files to final location.", dhVar.j);
        }
        throw new bv("Cannot move merged pack files to final location.", dhVar.j);
    }
}
