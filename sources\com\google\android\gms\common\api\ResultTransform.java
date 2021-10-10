package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zabz;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public abstract class ResultTransform<R extends Result, S extends Result> {
    public Status onFailure(Status status) {
        return status;
    }

    public abstract PendingResult<S> onSuccess(R r);

    public final PendingResult<S> createFailedResult(Status status) {
        return new zabz(status);
    }
}
