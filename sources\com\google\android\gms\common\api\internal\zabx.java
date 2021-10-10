package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
final /* synthetic */ class zabx implements RemoteCall {
    private final RegistrationMethods.Builder zaa;

    zabx(RegistrationMethods.Builder builder) {
        this.zaa = builder;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        this.zaa.zaa((Api.AnyClient) obj, (TaskCompletionSource) obj2);
    }
}
