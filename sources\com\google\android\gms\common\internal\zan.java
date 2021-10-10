package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
final class zan implements PendingResultUtil.zaa {
    zan() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.zaa
    public final ApiException zaa(Status status) {
        return ApiExceptionUtil.fromStatus(status);
    }
}
