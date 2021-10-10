package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

final class u implements Runnable {
    final /* synthetic */ SplitInstallRequest a;
    final /* synthetic */ w b;

    u(w wVar, SplitInstallRequest splitInstallRequest) {
        this.b = wVar;
        this.a = splitInstallRequest;
    }

    public final void run() {
        t tVar = this.b.b;
        List<String> moduleNames = this.a.getModuleNames();
        List list = w.c(this.a.getLanguages());
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt("status", 5);
        bundle.putInt("error_code", 0);
        if (!moduleNames.isEmpty()) {
            bundle.putStringArrayList("module_names", new ArrayList<>(moduleNames));
        }
        if (!list.isEmpty()) {
            bundle.putStringArrayList("languages", new ArrayList<>(list));
        }
        bundle.putLong("total_bytes_to_download", 0);
        bundle.putLong("bytes_downloaded", 0);
        tVar.i(SplitInstallSessionState.d(bundle));
    }
}
