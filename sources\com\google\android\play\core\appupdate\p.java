package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.aq;
import com.google.android.play.core.internal.bz;
import com.google.android.play.core.internal.o;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import com.google.android.play.core.tasks.i;

/* access modifiers changed from: package-private */
public final class p {
    private static final ag b = new ag("AppUpdateService");
    private static final Intent c = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");
    aq<o> a;
    private final String d;
    private final Context e;
    private final r f;

    public p(Context context, r rVar) {
        this.d = context.getPackageName();
        this.e = context;
        this.f = rVar;
        if (bz.a(context)) {
            this.a = new aq<>(com.google.android.play.core.splitcompat.p.c(context), b, "AppUpdateService", c, j.a);
        }
    }

    static /* synthetic */ Bundle d(p pVar, String str) {
        Integer num;
        Bundle bundle = new Bundle();
        bundle.putAll(j());
        bundle.putString("package.name", str);
        try {
            num = Integer.valueOf(pVar.e.getPackageManager().getPackageInfo(pVar.e.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            b.b("The current version of the app could not be retrieved", new Object[0]);
            num = null;
        }
        if (num != null) {
            bundle.putInt("app.version.code", num.intValue());
        }
        return bundle;
    }

    static /* synthetic */ AppUpdateInfo h(p pVar, Bundle bundle, String str) {
        return AppUpdateInfo.a(str, bundle.getInt("version.code", -1), bundle.getInt("update.availability"), bundle.getInt("install.status", 0), bundle.getInt("client.version.staleness", -1) == -1 ? null : Integer.valueOf(bundle.getInt("client.version.staleness")), bundle.getInt("in.app.update.priority", 0), bundle.getLong("bytes.downloaded"), bundle.getLong("total.bytes.to.download"), bundle.getLong("additional.size.required"), pVar.f.a(), (PendingIntent) bundle.getParcelable("blocking.intent"), (PendingIntent) bundle.getParcelable("nonblocking.intent"), (PendingIntent) bundle.getParcelable("blocking.destructive.intent"), (PendingIntent) bundle.getParcelable("nonblocking.destructive.intent"));
    }

    private static <T> Task<T> i() {
        b.b("onError(%d)", -9);
        return Tasks.b(new InstallException(-9));
    }

    /* access modifiers changed from: private */
    public static Bundle j() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore.version.code", 10803);
        return bundle;
    }

    public final Task<AppUpdateInfo> a(String str) {
        if (this.a == null) {
            return i();
        }
        b.d("requestUpdateInfo(%s)", str);
        i iVar = new i();
        this.a.a(new k(this, iVar, str, iVar));
        return iVar.c();
    }

    public final Task<Void> b(String str) {
        if (this.a == null) {
            return i();
        }
        b.d("completeUpdate(%s)", str);
        i iVar = new i();
        this.a.a(new l(this, iVar, iVar, str));
        return iVar.c();
    }
}
