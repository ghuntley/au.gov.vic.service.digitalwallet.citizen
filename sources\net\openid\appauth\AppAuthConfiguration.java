package net.openid.appauth;

import net.openid.appauth.browser.AnyBrowserMatcher;
import net.openid.appauth.browser.BrowserMatcher;
import net.openid.appauth.connectivity.ConnectionBuilder;
import net.openid.appauth.connectivity.DefaultConnectionBuilder;

public class AppAuthConfiguration {
    public static final AppAuthConfiguration DEFAULT = new Builder().build();
    private final BrowserMatcher mBrowserMatcher;
    private final ConnectionBuilder mConnectionBuilder;

    private AppAuthConfiguration(BrowserMatcher browserMatcher, ConnectionBuilder connectionBuilder) {
        this.mBrowserMatcher = browserMatcher;
        this.mConnectionBuilder = connectionBuilder;
    }

    public BrowserMatcher getBrowserMatcher() {
        return this.mBrowserMatcher;
    }

    public ConnectionBuilder getConnectionBuilder() {
        return this.mConnectionBuilder;
    }

    public static class Builder {
        private BrowserMatcher mBrowserMatcher = AnyBrowserMatcher.INSTANCE;
        private ConnectionBuilder mConnectionBuilder = DefaultConnectionBuilder.INSTANCE;

        public Builder setBrowserMatcher(BrowserMatcher browserMatcher) {
            Preconditions.checkNotNull(browserMatcher, "browserMatcher cannot be null");
            this.mBrowserMatcher = browserMatcher;
            return this;
        }

        public Builder setConnectionBuilder(ConnectionBuilder connectionBuilder) {
            Preconditions.checkNotNull(connectionBuilder, "connectionBuilder cannot be null");
            this.mConnectionBuilder = connectionBuilder;
            return this;
        }

        public AppAuthConfiguration build() {
            return new AppAuthConfiguration(this.mBrowserMatcher, this.mConnectionBuilder);
        }
    }
}
