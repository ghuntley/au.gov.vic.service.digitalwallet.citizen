package com.digitalwallet.app.services.remotenotification;

import com.google.firebase.messaging.FirebaseMessagingService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.ResponseTypeValues;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/digitalwallet/app/services/remotenotification/MessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "remoteSubscriptionService", "Lcom/digitalwallet/app/services/remotenotification/RemoteSubscriptionService;", "getRemoteSubscriptionService", "()Lcom/digitalwallet/app/services/remotenotification/RemoteSubscriptionService;", "setRemoteSubscriptionService", "(Lcom/digitalwallet/app/services/remotenotification/RemoteSubscriptionService;)V", "onNewToken", "", ResponseTypeValues.TOKEN, "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: MessagingService.kt */
public final class MessagingService extends FirebaseMessagingService {
    @Inject
    public RemoteSubscriptionService remoteSubscriptionService;

    public final RemoteSubscriptionService getRemoteSubscriptionService() {
        RemoteSubscriptionService remoteSubscriptionService2 = this.remoteSubscriptionService;
        if (remoteSubscriptionService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("remoteSubscriptionService");
        }
        return remoteSubscriptionService2;
    }

    public final void setRemoteSubscriptionService(RemoteSubscriptionService remoteSubscriptionService2) {
        Intrinsics.checkNotNullParameter(remoteSubscriptionService2, "<set-?>");
        this.remoteSubscriptionService = remoteSubscriptionService2;
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        Intrinsics.checkNotNullParameter(str, ResponseTypeValues.TOKEN);
        super.onNewToken(str);
        Timber.d("Refreshed token: " + str, new Object[0]);
        try {
            RemoteSubscriptionService remoteSubscriptionService2 = this.remoteSubscriptionService;
            if (remoteSubscriptionService2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("remoteSubscriptionService");
            }
            remoteSubscriptionService2.registerRemoteNotification();
        } catch (Exception e) {
            Timber.e(e, "Has remoteSubscriptionService been initialised?", new Object[0]);
        }
    }
}
