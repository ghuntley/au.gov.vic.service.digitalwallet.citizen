package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.br;
import com.google.android.play.core.internal.cj;
import com.google.android.play.core.internal.ck;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* access modifiers changed from: package-private */
/* renamed from: com.google.android.play.core.assetpacks.do  reason: invalid class name */
public final class Cdo {
    private static final ag a = new ag("PatchSliceTaskHandler");
    private final bb b;
    private final ck<w> c;

    Cdo(bb bbVar, ck<w> ckVar) {
        this.b = bbVar;
        this.c = ckVar;
    }

    public final void a(dn dnVar) {
        File f = this.b.f(dnVar.k, dnVar.a, dnVar.b);
        bb bbVar = this.b;
        String str = dnVar.k;
        int i = dnVar.a;
        long j = dnVar.b;
        File file = new File(bbVar.g(str, i, j), dnVar.f);
        try {
            InputStream inputStream = dnVar.h;
            if (dnVar.e == 2) {
                inputStream = new GZIPInputStream(inputStream, 8192);
            }
            try {
                be beVar = new be(f, file);
                File h = this.b.h(dnVar.k, dnVar.c, dnVar.d, dnVar.f);
                if (!h.exists()) {
                    h.mkdirs();
                }
                dr drVar = new dr(this.b, dnVar.k, dnVar.c, dnVar.d, dnVar.f);
                br.k(beVar, inputStream, new by(h, drVar), dnVar.g);
                drVar.d(0);
                inputStream.close();
                a.d("Patching and extraction finished for slice %s of pack %s.", dnVar.f, dnVar.k);
                this.c.a().e(dnVar.j, dnVar.k, dnVar.f, 0);
                try {
                    dnVar.h.close();
                    return;
                } catch (IOException unused) {
                    a.e("Could not close file for slice %s of pack %s.", dnVar.f, dnVar.k);
                    return;
                }
            } catch (Throwable th) {
                cj.a(th, th);
            }
            throw th;
        } catch (IOException e) {
            a.b("IOException during patching %s.", e.getMessage());
            throw new bv(String.format("Error patching slice %s of pack %s.", dnVar.f, dnVar.k), e, dnVar.j);
        }
    }
}
