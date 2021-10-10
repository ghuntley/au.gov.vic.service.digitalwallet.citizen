package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public class TaskCompletionSource<TResult> {
    private final zzu<TResult> zza = new zzu<>();

    public TaskCompletionSource() {
    }

    public TaskCompletionSource(CancellationToken cancellationToken) {
        cancellationToken.onCanceledRequested(new zzs(this));
    }

    public void setResult(TResult tresult) {
        this.zza.zza((Object) tresult);
    }

    public boolean trySetResult(TResult tresult) {
        return this.zza.zzb((Object) tresult);
    }

    public void setException(Exception exc) {
        this.zza.zza(exc);
    }

    public boolean trySetException(Exception exc) {
        return this.zza.zzb(exc);
    }

    public Task<TResult> getTask() {
        return this.zza;
    }
}
