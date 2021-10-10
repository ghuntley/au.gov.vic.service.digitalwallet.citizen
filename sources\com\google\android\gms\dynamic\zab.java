package com.google.android.gms.dynamic;

import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
final class zab implements OnDelegateCreatedListener<T> {
    private final /* synthetic */ DeferredLifecycleHelper zaa;

    zab(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zaa = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.OnDelegateCreatedListener
    public final void onDelegateCreated(T t) {
        DeferredLifecycleHelper.zaa(this.zaa, (LifecycleDelegate) t);
        Iterator it = DeferredLifecycleHelper.zaa(this.zaa).iterator();
        while (it.hasNext()) {
            ((DeferredLifecycleHelper.zaa) it.next()).zaa(DeferredLifecycleHelper.zab(this.zaa));
        }
        DeferredLifecycleHelper.zaa(this.zaa).clear();
        DeferredLifecycleHelper.zaa(this.zaa, (Bundle) null);
    }
}
