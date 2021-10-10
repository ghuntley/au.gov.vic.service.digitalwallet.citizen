package net.openid.appauth.browser;

import java.util.Arrays;
import java.util.List;

public class BrowserBlacklist implements BrowserMatcher {
    private List<BrowserMatcher> mBrowserMatchers;

    public BrowserBlacklist(BrowserMatcher... browserMatcherArr) {
        this.mBrowserMatchers = Arrays.asList(browserMatcherArr);
    }

    @Override // net.openid.appauth.browser.BrowserMatcher
    public boolean matches(BrowserDescriptor browserDescriptor) {
        for (BrowserMatcher browserMatcher : this.mBrowserMatchers) {
            if (browserMatcher.matches(browserDescriptor)) {
                return false;
            }
        }
        return true;
    }
}
