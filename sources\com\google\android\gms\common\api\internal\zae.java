package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public abstract class zae<T> extends zab {
    protected final TaskCompletionSource<T> zab;

    public zae(int i, TaskCompletionSource<T> taskCompletionSource) {
        super(i);
        this.zab = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public void zaa(zaw zaw, boolean z) {
    }

    /* access modifiers changed from: protected */
    public abstract void zad(GoogleApiManager.zaa<?> zaa) throws RemoteException;

    @Override // com.google.android.gms.common.api.internal.zac
    public void zaa(Status status) {
        this.zab.trySetException(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public void zaa(Exception exc) {
        this.zab.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zac(GoogleApiManager.zaa<?> zaa) throws DeadObjectException {
        try {
            zad(zaa);
        } catch (DeadObjectException e) {
            zaa(zac.zab(e));
            throw e;
        } catch (RemoteException e2) {
            zaa(zac.zab(e2));
        } catch (RuntimeException e3) {
            zaa(e3);
        }
    }
}
