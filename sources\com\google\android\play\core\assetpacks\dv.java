package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.ag;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/* access modifiers changed from: package-private */
public final class dv {
    private static final ag a = new ag("VerifySliceTaskHandler");
    private final bb b;

    dv(bb bbVar) {
        this.b = bbVar;
    }

    private final void b(du duVar, File file) {
        try {
            File o = this.b.o(duVar.k, duVar.a, duVar.b, duVar.c);
            if (o.exists()) {
                try {
                    if (db.a(dt.a(file, o)).equals(duVar.d)) {
                        a.d("Verification of slice %s of pack %s successful.", duVar.c, duVar.k);
                        return;
                    }
                    throw new bv(String.format("Verification failed for slice %s.", duVar.c), duVar.j);
                } catch (NoSuchAlgorithmException e) {
                    throw new bv("SHA256 algorithm not supported.", e, duVar.j);
                } catch (IOException e2) {
                    throw new bv(String.format("Could not digest file during verification for slice %s.", duVar.c), e2, duVar.j);
                }
            } else {
                throw new bv(String.format("Cannot find metadata files for slice %s.", duVar.c), duVar.j);
            }
        } catch (IOException e3) {
            throw new bv(String.format("Could not reconstruct slice archive during verification for slice %s.", duVar.c), e3, duVar.j);
        }
    }

    public final void a(du duVar) {
        File h = this.b.h(duVar.k, duVar.a, duVar.b, duVar.c);
        if (h.exists()) {
            b(duVar, h);
            File i = this.b.i(duVar.k, duVar.a, duVar.b, duVar.c);
            if (!i.exists()) {
                i.mkdirs();
            }
            if (!h.renameTo(i)) {
                throw new bv(String.format("Failed to move slice %s after verification.", duVar.c), duVar.j);
            }
            return;
        }
        throw new bv(String.format("Cannot find unverified files for slice %s.", duVar.c), duVar.j);
    }
}
