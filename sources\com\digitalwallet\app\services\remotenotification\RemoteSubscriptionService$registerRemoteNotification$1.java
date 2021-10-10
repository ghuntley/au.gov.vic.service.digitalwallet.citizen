package com.digitalwallet.app.services.remotenotification;

import com.digitalwallet.app.model.RegisterDevicePayload;
import com.digitalwallet.app.oidc.model.Tokens;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/CompletableSource;", "kotlin.jvm.PlatformType", "deviceToken", "", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: RemoteSubscriptionService.kt */
final class RemoteSubscriptionService$registerRemoteNotification$1<T, R> implements Function<String, CompletableSource> {
    final /* synthetic */ RemoteSubscriptionService this$0;

    RemoteSubscriptionService$registerRemoteNotification$1(RemoteSubscriptionService remoteSubscriptionService) {
        this.this$0 = remoteSubscriptionService;
    }

    public final CompletableSource apply(String str) {
        Completable completable;
        Intrinsics.checkNotNullParameter(str, "deviceToken");
        RegisterDevicePayload registerDevicePayload = this.this$0.getDeviceRegistrationPayload(str);
        Tokens tokens = this.this$0.authenticationUtility.getTokens();
        String id = tokens != null ? tokens.getId() : null;
        if (id == null || (completable = this.this$0.deviceRegisterApi.registerLoggedInDevice(id, registerDevicePayload)) == null) {
            completable = this.this$0.deviceRegisterApi.registerGuestDevice(registerDevicePayload);
        }
        return completable;
    }
}
