package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.bz;
import com.google.android.play.core.internal.w;
import com.google.android.play.core.internal.z;
import java.util.Arrays;

final class b extends w {
    private final ag a = new ag("AssetPackExtractionService");
    private final Context b;
    private final AssetPackExtractionService c;
    private final bb d;

    b(Context context, AssetPackExtractionService assetPackExtractionService, bb bbVar) {
        this.b = context;
        this.c = assetPackExtractionService;
        this.d = bbVar;
    }

    @Override // com.google.android.play.core.internal.x
    public final void b(Bundle bundle, z zVar) throws RemoteException {
        String[] packagesForUid;
        this.a.a("updateServiceState AIDL call", new Object[0]);
        if (!bz.a(this.b) || (packagesForUid = this.b.getPackageManager().getPackagesForUid(Binder.getCallingUid())) == null || !Arrays.asList(packagesForUid).contains("com.android.vending")) {
            zVar.d(new Bundle());
            this.c.b();
            return;
        }
        zVar.c(this.c.a(bundle), new Bundle());
    }

    @Override // com.google.android.play.core.internal.x
    public final void c(z zVar) throws RemoteException {
        this.d.w();
        zVar.e(new Bundle());
    }
}
