package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zay implements OnCompleteListener<TResult> {
    private final /* synthetic */ TaskCompletionSource zaa;
    private final /* synthetic */ zaw zab;

    zay(zaw zaw, TaskCompletionSource taskCompletionSource) {
        this.zab = zaw;
        this.zaa = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<TResult> task) {
        this.zab.zab.remove(this.zaa);
    }
}
