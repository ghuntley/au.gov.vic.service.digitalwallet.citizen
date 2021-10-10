package com.digitalwallet.app.services.remotenotification;

import dagger.MembersInjector;
import javax.inject.Provider;

public final class MessagingService_MembersInjector implements MembersInjector<MessagingService> {
    private final Provider<RemoteSubscriptionService> remoteSubscriptionServiceProvider;

    public MessagingService_MembersInjector(Provider<RemoteSubscriptionService> provider) {
        this.remoteSubscriptionServiceProvider = provider;
    }

    public static MembersInjector<MessagingService> create(Provider<RemoteSubscriptionService> provider) {
        return new MessagingService_MembersInjector(provider);
    }

    public void injectMembers(MessagingService messagingService) {
        injectRemoteSubscriptionService(messagingService, this.remoteSubscriptionServiceProvider.get());
    }

    public static void injectRemoteSubscriptionService(MessagingService messagingService, RemoteSubscriptionService remoteSubscriptionService) {
        messagingService.remoteSubscriptionService = remoteSubscriptionService;
    }
}
