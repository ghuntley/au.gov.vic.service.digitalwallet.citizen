package com.google.android.play.core.assetpacks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.ck;
import com.google.android.play.core.splitinstall.p;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import com.google.android.play.core.tasks.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* access modifiers changed from: package-private */
public final class j implements AssetPackManager {
    private static final ag a = new ag("AssetPackManager");
    private final bb b;
    private final ck<w> c;
    private final aw d;
    private final p e;
    private final cp f;
    private final bz g;
    private final bn h;
    private final ck<Executor> i;
    private final Handler j = new Handler(Looper.getMainLooper());
    private boolean k;

    j(bb bbVar, ck<w> ckVar, aw awVar, p pVar, cp cpVar, bz bzVar, bn bnVar, ck<Executor> ckVar2) {
        this.b = bbVar;
        this.c = ckVar;
        this.d = awVar;
        this.e = pVar;
        this.f = cpVar;
        this.g = bzVar;
        this.h = bnVar;
        this.i = ckVar2;
    }

    private final void h() {
        this.i.a().execute(new e(this));
    }

    private final void i() {
        this.i.a().execute(new f(this));
        this.k = true;
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        boolean j2 = this.d.j();
        this.d.e(z);
        if (z && !j2) {
            h();
        }
    }

    /* access modifiers changed from: package-private */
    public final int b(int i2, String str) {
        if (!this.b.a(str) && i2 == 4) {
            return 8;
        }
        if (!this.b.a(str) || i2 == 4) {
            return i2;
        }
        return 4;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void c() {
        this.b.u();
        this.b.r();
        this.b.v();
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final AssetPackStates cancel(List<String> list) {
        Map<String, Integer> h2 = this.f.h(list);
        HashMap hashMap = new HashMap();
        for (String str : list) {
            Integer num = h2.get(str);
            hashMap.put(str, AssetPackState.b(str, num == null ? 0 : num.intValue(), 0, 0, 0, 0.0d, 1));
        }
        this.c.a().b(list);
        return AssetPackStates.a(0, hashMap);
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final void clearListeners() {
        this.d.h();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void d() {
        Task<List<String>> c2 = this.c.a().c(this.b.c());
        bb bbVar = this.b;
        bbVar.getClass();
        c2.addOnSuccessListener(this.i.a(), g.a(bbVar));
        c2.addOnFailureListener(this.i.a(), h.a);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void f(String str, i iVar) {
        if (this.b.q(str)) {
            iVar.a(null);
            this.c.a().i(str);
            return;
        }
        iVar.b(new IOException(String.format("Failed to remove pack %s.", str)));
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final Task<AssetPackStates> fetch(List<String> list) {
        Map<String, Long> c2 = this.b.c();
        ArrayList arrayList = new ArrayList(list);
        arrayList.removeAll(c2.keySet());
        ArrayList arrayList2 = new ArrayList(list);
        arrayList2.removeAll(arrayList);
        if (!arrayList.isEmpty()) {
            return this.c.a().a(arrayList2, arrayList, c2);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt("error_code", 0);
        for (String str : list) {
            bundle.putInt(com.google.android.play.core.internal.i.e("status", str), 4);
            bundle.putInt(com.google.android.play.core.internal.i.e("error_code", str), 0);
            bundle.putLong(com.google.android.play.core.internal.i.e("total_bytes_to_download", str), 0);
            bundle.putLong(com.google.android.play.core.internal.i.e("bytes_downloaded", str), 0);
        }
        bundle.putStringArrayList("pack_names", new ArrayList<>(list));
        bundle.putLong("total_bytes_to_download", 0);
        bundle.putLong("bytes_downloaded", 0);
        return Tasks.a(AssetPackStates.b(bundle, this.g));
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final AssetLocation getAssetLocation(String str, String str2) {
        AssetPackLocation assetPackLocation;
        if (!this.k) {
            this.i.a().execute(new f(this));
            this.k = true;
        }
        if (this.b.a(str)) {
            try {
                assetPackLocation = this.b.d(str);
            } catch (IOException unused) {
            }
        } else {
            if (this.e.a().contains(str)) {
                assetPackLocation = AssetPackLocation.a();
            }
            assetPackLocation = null;
        }
        if (assetPackLocation == null) {
            return null;
        }
        if (assetPackLocation.packStorageMethod() == 1) {
            return this.b.x(str, str2);
        }
        if (assetPackLocation.packStorageMethod() == 0) {
            return this.b.y(str, str2, assetPackLocation);
        }
        a.a("The asset %s is not present in Asset Pack %s", str2, str);
        return null;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final AssetPackLocation getPackLocation(String str) {
        if (!this.k) {
            i();
        }
        if (this.b.a(str)) {
            try {
                return this.b.d(str);
            } catch (IOException unused) {
                return null;
            }
        } else if (this.e.a().contains(str)) {
            return AssetPackLocation.a();
        } else {
            return null;
        }
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final Map<String, AssetPackLocation> getPackLocations() {
        Map<String, AssetPackLocation> b2 = this.b.b();
        HashMap hashMap = new HashMap();
        for (String str : this.e.a()) {
            hashMap.put(str, AssetPackLocation.a());
        }
        b2.putAll(hashMap);
        return b2;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final Task<AssetPackStates> getPackStates(List<String> list) {
        return this.c.a().d(list, new c(this), this.b.c());
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final synchronized void registerListener(AssetPackStateUpdateListener assetPackStateUpdateListener) {
        boolean j2 = this.d.j();
        this.d.f(assetPackStateUpdateListener);
        if (!j2) {
            h();
        }
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final Task<Void> removePack(String str) {
        i iVar = new i();
        this.i.a().execute(new d(this, str, iVar));
        return iVar.c();
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final Task<Integer> showCellularDataConfirmation(Activity activity) {
        if (activity == null) {
            return Tasks.b(new AssetPackException(-3));
        }
        if (this.h.b() == null) {
            return Tasks.b(new AssetPackException(-12));
        }
        Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", this.h.b());
        i iVar = new i();
        intent.putExtra("result_receiver", new i(this, this.j, iVar));
        activity.startActivity(intent);
        return iVar.c();
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackManager
    public final void unregisterListener(AssetPackStateUpdateListener assetPackStateUpdateListener) {
        this.d.g(assetPackStateUpdateListener);
    }
}
