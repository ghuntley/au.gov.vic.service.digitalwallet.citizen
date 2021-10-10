package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zah extends zae<Boolean> {
    private final ListenerHolder.ListenerKey<?> zac;

    public zah(ListenerHolder.ListenerKey<?> listenerKey, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.zac = listenerKey;
    }

    @Override // com.google.android.gms.common.api.internal.zac, com.google.android.gms.common.api.internal.zae
    public final /* bridge */ /* synthetic */ void zaa(zaw zaw, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zae
    public final void zad(GoogleApiManager.zaa<?> zaa) throws RemoteException {
        zabs remove = zaa.zac().remove(this.zac);
        if (remove != null) {
            remove.zab.unregisterListener(zaa.zab(), this.zab);
            remove.zaa.clearListener();
            return;
        }
        this.zab.trySetResult(false);
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final Feature[] zaa(GoogleApiManager.zaa<?> zaa) {
        zabs zabs = zaa.zac().get(this.zac);
        if (zabs == null) {
            return null;
        }
        return zabs.zaa.getRequiredFeatures();
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final boolean zab(GoogleApiManager.zaa<?> zaa) {
        zabs zabs = zaa.zac().get(this.zac);
        return zabs != null && zabs.zaa.zaa();
    }

    @Override // com.google.android.gms.common.api.internal.zac, com.google.android.gms.common.api.internal.zae
    public final /* bridge */ /* synthetic */ void zaa(Exception exc) {
        super.zaa(exc);
    }

    @Override // com.google.android.gms.common.api.internal.zac, com.google.android.gms.common.api.internal.zae
    public final /* bridge */ /* synthetic */ void zaa(Status status) {
        super.zaa(status);
    }
}
