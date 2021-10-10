package net.openid.appauth.browser;

import java.util.Arrays;
import java.util.List;

public class BrowserWhitelist implements BrowserMatcher {
    private List<BrowserMatcher> mBrowserMatchers;

    public BrowserWhitelist(BrowserMatcher... browserMatcherArr) {
        this.mBrowserMatchers = Arrays.asList(browserMatcherArr);
    }

    @Override // net.openid.appauth.browser.BrowserMatcher
    public boolean matches(BrowserDescriptor browserDescriptor) {
        for (BrowserMatcher browserMatcher : this.mBrowserMatchers) {
            if (browserMatcher.matches(browserDescriptor)) {
                return true;
            }
        }
        return false;
    }
}
