package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class zzc<TResult, TContinuationResult> implements zzr<TResult> {
    private final Executor zza;
    private final Continuation<TResult, TContinuationResult> zzb;
    private final zzu<TContinuationResult> zzc;

    public zzc(Executor executor, Continuation<TResult, TContinuationResult> continuation, zzu<TContinuationResult> zzu) {
        this.zza = executor;
        this.zzb = continuation;
        this.zzc = zzu;
    }

    @Override // com.google.android.gms.tasks.zzr
    public final void zza(Task<TResult> task) {
        this.zza.execute(new zze(this, task));
    }

    @Override // com.google.android.gms.tasks.zzr
    public final void zza() {
        throw new UnsupportedOperationException();
    }
}
