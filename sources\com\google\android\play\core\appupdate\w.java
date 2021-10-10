package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.splitcompat.p;

public final /* synthetic */ class w {
    private static y a;

    static synchronized y a(Context context) {
        y yVar;
        synchronized (w.class) {
            if (a == null) {
                x xVar = new x(null);
                xVar.b(new g(p.c(context)));
                a = xVar.a();
            }
            yVar = a;
        }
        return yVar;
    }
}
