package net.openid.appauth.browser;

import java.util.Collections;
import java.util.Set;
import net.openid.appauth.browser.Browsers;

public class VersionedBrowserMatcher implements BrowserMatcher {
    public static final VersionedBrowserMatcher CHROME_BROWSER = new VersionedBrowserMatcher(Browsers.Chrome.PACKAGE_NAME, Browsers.Chrome.SIGNATURE_SET, false, VersionRange.ANY_VERSION);
    public static final VersionedBrowserMatcher CHROME_CUSTOM_TAB = new VersionedBrowserMatcher(Browsers.Chrome.PACKAGE_NAME, Browsers.Chrome.SIGNATURE_SET, true, VersionRange.atLeast(Browsers.Chrome.MINIMUM_VERSION_FOR_CUSTOM_TAB));
    public static final VersionedBrowserMatcher FIREFOX_BROWSER = new VersionedBrowserMatcher(Browsers.Firefox.PACKAGE_NAME, Browsers.Firefox.SIGNATURE_SET, false, VersionRange.ANY_VERSION);
    public static final VersionedBrowserMatcher FIREFOX_CUSTOM_TAB = new VersionedBrowserMatcher(Browsers.Firefox.PACKAGE_NAME, Browsers.Firefox.SIGNATURE_SET, true, VersionRange.atLeast(Browsers.Firefox.MINIMUM_VERSION_FOR_CUSTOM_TAB));
    public static final VersionedBrowserMatcher SAMSUNG_BROWSER = new VersionedBrowserMatcher(Browsers.SBrowser.PACKAGE_NAME, Browsers.SBrowser.SIGNATURE_SET, false, VersionRange.ANY_VERSION);
    public static final VersionedBrowserMatcher SAMSUNG_CUSTOM_TAB = new VersionedBrowserMatcher(Browsers.SBrowser.PACKAGE_NAME, Browsers.SBrowser.SIGNATURE_SET, true, VersionRange.atLeast(Browsers.SBrowser.MINIMUM_VERSION_FOR_CUSTOM_TAB));
    private String mPackageName;
    private Set<String> mSignatureHashes;
    private boolean mUsingCustomTab;
    private VersionRange mVersionRange;

    public VersionedBrowserMatcher(String str, String str2, boolean z, VersionRange versionRange) {
        this(str, Collections.singleton(str2), z, versionRange);
    }

    public VersionedBrowserMatcher(String str, Set<String> set, boolean z, VersionRange versionRange) {
        this.mPackageName = str;
        this.mSignatureHashes = set;
        this.mUsingCustomTab = z;
        this.mVersionRange = versionRange;
    }

    @Override // net.openid.appauth.browser.BrowserMatcher
    public boolean matches(BrowserDescriptor browserDescriptor) {
        return this.mPackageName.equals(browserDescriptor.packageName) && this.mUsingCustomTab == browserDescriptor.useCustomTab.booleanValue() && this.mVersionRange.matches(browserDescriptor.version) && this.mSignatureHashes.equals(browserDescriptor.signatureHashes);
    }
}
