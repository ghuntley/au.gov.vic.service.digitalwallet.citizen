package com.google.android.play.core.assetpacks;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.a;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.ck;
import com.google.android.play.core.listener.b;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* access modifiers changed from: package-private */
public final class aw extends b<AssetPackState> {
    private final cp c;
    private final bw d;
    private final ck<w> e;
    private final bn f;
    private final bz g;
    private final a h;
    private final ck<Executor> i;
    private final ck<Executor> j;
    private final Handler k = new Handler(Looper.getMainLooper());

    aw(Context context, cp cpVar, bw bwVar, ck<w> ckVar, bz bzVar, bn bnVar, a aVar, ck<Executor> ckVar2, ck<Executor> ckVar3) {
        super(new ag("AssetPackServiceListenerRegistry"), new IntentFilter("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE"), context);
        this.c = cpVar;
        this.d = bwVar;
        this.e = ckVar;
        this.g = bzVar;
        this.f = bnVar;
        this.h = aVar;
        this.i = ckVar2;
        this.j = ckVar3;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.listener.b
    public final void a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE");
        if (bundleExtra != null) {
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("pack_names");
            if (stringArrayList == null || stringArrayList.size() != 1) {
                this.a.b("Corrupt bundle received from broadcast.", new Object[0]);
                return;
            }
            Bundle bundleExtra2 = intent.getBundleExtra("com.google.android.play.core.FLAGS");
            if (bundleExtra2 != null) {
                this.h.a(bundleExtra2);
            }
            AssetPackState c2 = AssetPackState.c(bundleExtra, stringArrayList.get(0), this.g, ay.a);
            this.a.a("ListenerRegistryBroadcastReceiver.onReceive: %s", c2);
            PendingIntent pendingIntent = (PendingIntent) bundleExtra.getParcelable("confirmation_intent");
            if (pendingIntent != null) {
                this.f.a(pendingIntent);
            }
            this.j.a().execute(new au(this, bundleExtra, c2));
            this.i.a().execute(new av(this, bundleExtra));
            return;
        }
        this.a.b("Empty bundle received from broadcast.", new Object[0]);
    }

    /* access modifiers changed from: package-private */
    public final void b(AssetPackState assetPackState) {
        this.k.post(new at(this, assetPackState));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void c(Bundle bundle) {
        if (this.c.d(bundle)) {
            this.d.a();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void d(Bundle bundle, AssetPackState assetPackState) {
        if (this.c.e(bundle)) {
            b(assetPackState);
            this.e.a().j();
        }
    }
}
